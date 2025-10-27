package gvcr2.entity.boss;

import java.util.List;
import java.util.Random;

import gvclib.entity.EntityBBase;
import gvclib.entity.EntityB_Bullet;
import gvclib.entity.EntityB_BulletAA;
import gvclib.entity.EntityB_BulletFire;
import gvclib.entity.EntityT_Grenade;
import gvclib.entity.living.AI_Damage;
import gvclib.entity.living.AI_EntityMoveS;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_EntityWeapon_new;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.event.GVCSoundEvent;
import gvclib.item.ItemGunBase;
import gvclib.network.GVCLClientMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.ai.AI_Type2_EntityMoveS;
import gvcr2.entity.bullet.EntityGVCR2_Bullet_Beam;
import hmggirlfront.GFSoundEvent;
import hmggirlfront.mod_GirlFront;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.MultiPartEntityPart;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.boss.dragon.phase.PhaseList;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class EntityGVCR2_BOSS_HAUNEB extends EntityGVCR2_BOSSBase //implements IEntityMultiPart
{

	
	//public MultiPartEntityPart dragonPartHead = new MultiPartEntityPart(this, "head", 6.0F, 6.0F);
	
	public EntityGVCR2_BOSS_HAUNEB(World worldIn) {
		super(worldIn);
		this.setSize(10.0F, 7F);
		this.experienceValue = 10;
		
		
		aitypemax2 = 120;
		aitypemaxset2 = 4;
	}

	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIRestrictSun(this));
		this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0D);
	}
	

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		
	}
	
	public void setWeapon() {
		//this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_mg42));
	}
	
	
	/**
     * Drop the equipment for this entity.
     */
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier)
    {
    	
    }
    
    /*@Override
	public World getWorld() {
		// TODO 自動生成されたメソッド・スタブ
    	return this.world;
	}*/
    
    public boolean attackEntityFromPart(MultiPartEntityPart dragonPart, DamageSource source, float damage)
    {
    	return true;
    }
    
    public SoundEvent  DamegeSound = SoundEvents.BLOCK_ANVIL_LAND;
	public boolean attackEntityFrom(DamageSource source, float par2)
    {
    	Entity entity;
    	entity = source.getImmediateSource();
    	
    	if(living_time > 0) {
    		return false;
    	}
    	else if(entity != null){
			if(this.getControllingPassenger() != null && this.getControllingPassenger() == source.getImmediateSource()){
	    		return false;
	        }else if(entity instanceof IMob){
	    		return false;
	        }
	        else if(entity == this){
	    		return false;
	        }
			else
	        {
				/*if(par2 > 20) {
					par2 = 10;
				}else if(par2 > 10) {
					par2 = 1;
				}
				else {
					par2 = 0.5F;
				}*/
				par2 = par2 * AI_Damage.newAntiBullet(this, entity, par2, 0.25F, 0.5F, 0.5F, 0.5F);
	        	if(entity instanceof EntityB_BulletFire)
	    		{
	        		par2 = 0;
	            }
				return super.attackEntityFrom(source, par2);
			}
		}else{
			return super.attackEntityFrom(source, par2);
		}
    }
    
	protected void onDeathUpdate() {
		//super.onDeathUpdate();
		++deathTime;
		
		if(this.deathTime <= 140) {
			if (this.deathTime % 10 == 0 && !this.world.isRemote) {
				int x = new Random().nextInt(8) - 2;
				int y = new Random().nextInt(10) + 1;
				int z = new Random().nextInt(8) - 2;
				GVCExplosionBase.ExplosionKai(this, this, this.posX + x, this.posY + y, this.posZ + z, 0, false,  false);
			}
		}else if(this.deathTime <= 170){
			if (this.deathTime % 5 == 0 && !this.world.isRemote) {
				int x = new Random().nextInt(8) - 2;
				int y = new Random().nextInt(10) + 1;
				int z = new Random().nextInt(8) - 2;
				GVCExplosionBase.ExplosionKai(this, this, this.posX + x, this.posY + y, this.posZ + z, 0, false,  false);
			}
		}
		if(!this.world.isRemote && this.deathTime == 200) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 4, this.posZ + 0, 6, false,  false);
			{
				this.world.setBlockState(new BlockPos(this.posX + 0, this.posY + 0, this.posZ + 0), Blocks.CHEST.getDefaultState(), 2);
				TileEntityChest Chest3;
				Chest3 = (TileEntityChest) this.world.getTileEntity(new BlockPos(this.posX + 0, this.posY + 0, this.posZ + 0));
				Chest3.setInventorySlotContents(13, new ItemStack(mod_GVCR2.gvcr2_item_request_rog, 1, 0));
				
				Chest3.setInventorySlotContents(4, new ItemStack(Blocks.DIAMOND_BLOCK, 1, 0));
				Chest3.setInventorySlotContents(12, new ItemStack(Blocks.EMERALD_BLOCK, 2, 0));
				Chest3.setInventorySlotContents(14, new ItemStack(Blocks.EMERALD_BLOCK, 2, 0));
				Chest3.setInventorySlotContents(22, new ItemStack(Blocks.EMERALD_BLOCK, 2, 0));
			}
			this.setDead();
		}
	}
    
    public void getbeacon() {
    }
    
    
    public void onUpdate()
    {
        super.onUpdate();
        if(FMLCommonHandler.instance().getMinecraftServerInstance() != null) {
			for (EntityPlayerMP playermp : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers()) {
				GVCLPacketHandler.INSTANCE2.sendTo(new GVCLClientMessageKeyPressed(2003, this.getEntityId(), cooltime3), playermp);
			}
		}
    }
    
	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
    int self_ex = 0;
    
    public int cannon_move;
    
    public int living_time = 0;
    
	public void onLivingUpdate() {
		super.onLivingUpdate();
		
		if(this.getMoveT() == 0) {
			this.setMoveT(1);
			this.setMoveX((int)this.posX);
			this.setMoveY((int)this.posY);
			this.setMoveZ((int)this.posZ);
		}
		
		{
			if(this.getAIType3() == 0)++living_time;
			if(living_time == 200 && this.getAIType3() == 0) {
				this.setAIType3(1);
				living_time = 0;
			}
			
			if(this.getAIType3() == 1 && !(this.getHealth() > this.getMaxHealth() / 2)) {
				++living_time;
				if (this.living_time % 10 == 0 && !this.world.isRemote) {
					int x = new Random().nextInt(8) - 2;
					int y = new Random().nextInt(10) + 1;
					int z = new Random().nextInt(8) - 2;
					GVCExplosionBase.ExplosionKai(this, this, this.posX + x, this.posY + y, this.posZ + z, 0, false,  false);
				}
			}
			if(living_time == 200 && this.getAIType3() == 1) {
				this.setAIType3(2);
				living_time = 0;
			}
			
			if(this.getAIType3() == 2 && !(this.getHealth() > this.getMaxHealth() / 4)) {
				++living_time;
				if (this.living_time % 10 == 0 && !this.world.isRemote) {
					int x = new Random().nextInt(8) - 2;
					int y = new Random().nextInt(10) + 1;
					int z = new Random().nextInt(8) - 2;
					GVCExplosionBase.ExplosionKai(this, this, this.posX + x, this.posY + y, this.posZ + z, 0, false,  false);
				}
			}
			if(living_time == 200 && this.getAIType3() == 2) {
				this.setAIType3(3);
				living_time = 0;
			}
		}
		
		
		
		float sp = 0.00F;
		Vec3d looked = this.getLookVec();
		
		{
			//if(this.deathTime < 0) 
			{
				this.motionY *= 0.5F;
			}
			BlockPos bp = this.world.getHeight(new BlockPos(this.posX, this.posY, this.posZ));
			int genY = bp.getY() + 20;
			if (this.getHealth() > 0.0F) {
				if(this.posY <= genY || this.posY <= this.getMoveY() + 30) {
					this.motionY = 0.1F;
				}
			}
		}
		
		++this.rotationYaw;
		
		boolean exflag = false;
		
		if(this.getHealth() > 0.0F) {
			AI_EntityWeapon.getTargetEntity(this, 100, 60, 60);
			this.newmove(this, 1, sp, 0, 2, 100);
		}
		
		
		reload_time1 = 100;
		reload_time2 = 60;
		
		if(!(living_time > 0) && this.getHealth() > 0) {
		
		if(this.getAIType3() == 1 || this.getAIType3() == 3){
    		if(this.cooltime > 2){
    			for(int iii = 0; iii < 4; ++iii){
					String model = "gvclib:textures/entity/model/bullet_aaa.mqo";
		    		String tex = "gvclib:textures/entity/model/bullet_aaa.png";
		    		String modelf = "gvclib:textures/entity/mflash.mqo";
		    		String texf = "gvclib:textures/entity/mflash.png";
		    		SoundEvent sounds = GVCSoundEvent.fire_mg;
		    		//
		    		EntityBBase var3;
		    		var3 = new EntityB_Bullet(this.world, this);
		    		var3.Bdamege = 5;
					var3.gra = 0.029;// 0.025
					//var3.friend = entity;
					var3.friend = this;
					var3.ex = false;
					var3.exfire = false;
					var3.exsmoke = false;
					var3.exflash = false;
					var3.exlevel = -1;
					var3.setModel(model);
					var3.setTex(tex);
					var3.timemax = 40;
					var3.bulletDameID = 0;
					var3.muteki = true;
					var3.fly_sound = false;
					
					float w = 0F;
					float bx = 0F;
					double z = 4.0;
					double bz = 4.0;
					double h = 0.5;
					double by = 0.5;
					if(iii == 3) {
						w = 0F;
						bx = 0F;
						z = -4.0;
						bz = -4.0;
					}
					if(iii == 1) {
						w = 4F;
						bx = 4F;
						z = 0.0;
						bz = 0.0;
					}
					if(iii == 2) {
						w = -4F;
						bx = -4F;
						z = 0.0;
						bz = 0.0;
					}
					
					boolean follow_rote = true;//向いている方向に
					float xoffset = 0;
					float yoffset = 0;
					double px = this.posX;
					double py = this.posY;
					double pz = this.posZ;
					float rote = this.rotationYaw;
					
					double xx11 = 0;
					double zz11 = 0;
					xx11 -= MathHelper.sin(rote * 0.01745329252F) * z;
					zz11 += MathHelper.cos(rote * 0.01745329252F) * z;
					xx11 -= MathHelper.sin(rote * 0.01745329252F + 1.57F) * w;
					zz11 += MathHelper.cos(rote * 0.01745329252F + 1.57F) * w;
					double offx = 0;
					double offz = 0;
					offx -= MathHelper.sin(rote * 0.01745329252F + 1.57F) * xoffset;
					offz += MathHelper.cos(rote * 0.01745329252F + 1.57F) * xoffset;
					double kaku = 0;
					//kaku += lock.y * 2;
					kaku = MathHelper.sqrt((z - bz)* (z - bz) + (w - bx)*(w - bx)) * Math.tan(Math.toRadians(-this.rotationPitch)) * 0.4D;
					var3.setLocationAndAngles(px + xx11, py + h + kaku, pz + zz11, this.rotationYaw,
							0.0F);
					float pitch = 0;
					float yaw = 0;
					if(iii == 1) {
						yaw = 90;
					}
					if(iii == 2) {
						yaw = 270;
					}
					if(iii == 3) {
						yaw = 180;
					}
					pitch = this.world.rand.nextInt(90);
					this.rotationp_1 = pitch;
					var3.setHeadingFromThrower(this, (float)this.rotationPitch + (float)yoffset + pitch, this.rotationYaw + (float)xoffset + yaw, 0.0F,
							2F, 1F);
					if (!this.world.isRemote) {
						this.world.spawnEntity(var3);
					}
				}
    			this.cooltime = 0;
			}
    		
    		if(this.cooltime2 > 60){
    			{
					String model = "gvclib:textures/entity/model/bullet_cannon.mqo";
		    		String tex = "gvclib:textures/entity/model/bullet_cannon.png";
		    		String modelf = "gvclib:textures/entity/mflash.mqo";
		    		String texf = "gvclib:textures/entity/mflash.png";
		    		SoundEvent sounds = GVCSoundEvent.fire_cannon;
		    		
		        			AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
							we.id = 12;
							we.model = model;
							we.tex = tex;
							we.modelf = model;
							we.texf = tex;
							we.ftime = 0;
							we.sound = sounds;
							we.f = 1.57F;
							we.w = 0.0F;
							we.bx = 0.0F;
							we.z = 1.4;
							we.bz = 0.0;
							we.h = 8;
							we.by = 8;
							we.follow_rote = true;//向いている方向に
							we.xoffset = 0;
							we.yoffset = 10;
							we.px = this.posX;
							we.py = this.posY;
							we.pz = this.posZ;
							we.lock = looked;
							we.rote = this.rotationYawHead;
							we.maxy = 20;
							we.miny = 10;
							
							
							we.power = 16 + this.world.getDifficulty().getDifficultyId();
							we.damegetime = false;
							we.speed = 1F;
							we.bure = 2F;
							we.ex = 3;
							we.extrue = false;
							we.kazu = 1;
							we.gra = 0.029;
							we.maxtime = 80;
							we.dameid = 0;
							we.spg_fly_sound = false;
							we.Attacktask(this, this, 80);
				}
    			this.cooltime2 = 0;
			}
    	}/**/
		if(this.getAIType3() == 2 || this.getAIType3() == 3){
			//for(int iii = 0; iii < 20; ++iii) 
			if(this.cooltime3 < 40){
				String model = "gvclib:textures/entity/model/bullet_aaa.mqo";
	    		String tex = "gvclib:textures/entity/model/bullet_aaa.png";
	    		String modelf = "gvclib:textures/entity/mflash.mqo";
	    		String texf = "gvclib:textures/entity/mflash.png";
	    		SoundEvent sounds = GVCSoundEvent.fire_mg;
	    		//
	    		EntityBBase var3;
	    		var3 = new EntityGVCR2_Bullet_Beam(this.world, this);
	    		var3.Bdamege = 5;
				var3.gra = 0.029;// 0.025
				//var3.friend = entity;
				var3.friend = this;
				var3.ex = false;
				var3.exfire = false;
				var3.exsmoke = false;
				var3.exflash = false;
				var3.exlevel = 10;
				var3.setModel(model);
				var3.setTex(tex);
				var3.timemax = 200;
				var3.bulletDameID = 0;
				var3.muteki = true;
				var3.fly_sound = false;
				
				var3.startposX = this.posX;
				var3.startposY = this.posY;
				var3.startposZ = this.posZ;
				
				float w = 0F;
				float bx = 0F;
				double z = 0.0;
				double bz = 0.0;
				double h = -2.5;
				double by = -2.5;
				
				boolean follow_rote = true;//向いている方向に
				float xoffset = 0;
				float yoffset = 0;
				double px = this.posX;
				double py = this.posY;
				double pz = this.posZ;
				float rote = this.rotationYaw;
				
				double xx11 = 0;
				double zz11 = 0;
				xx11 -= MathHelper.sin(rote * 0.01745329252F) * z;
				zz11 += MathHelper.cos(rote * 0.01745329252F) * z;
				xx11 -= MathHelper.sin(rote * 0.01745329252F + 1.57F) * w;
				zz11 += MathHelper.cos(rote * 0.01745329252F + 1.57F) * w;
				double offx = 0;
				double offz = 0;
				offx -= MathHelper.sin(rote * 0.01745329252F + 1.57F) * xoffset;
				offz += MathHelper.cos(rote * 0.01745329252F + 1.57F) * xoffset;
				double kaku = 0;
				//kaku += lock.y * 2;
				kaku = MathHelper.sqrt((z - bz)* (z - bz) + (w - bx)*(w - bx)) * Math.tan(Math.toRadians(-this.rotationPitch)) * 0.4D;
				var3.setLocationAndAngles(px + xx11, py + h + kaku, pz + zz11, this.rotationYaw,
						0.0F);
				float pitch = 0;
				float yaw = 0;
				pitch = this.world.rand.nextInt(90);
				
				this.rotationp_2 = this.cooltime3 * 4 + 10;
				
				var3.setHeadingFromThrower(this, this.rotationp_2, this.rotationYaw + (float)xoffset + yaw, 0.0F,
						2F, 1F);
				
				
				if (!this.world.isRemote) {
					this.world.spawnEntity(var3);
				}
			}
			if(this.cooltime3 > 300) {
				this.cooltime3 = 0;
			}
		}
		}
		
		
		
		
		
	}
	
	
	
	public void newmove(EntityGVCLivingBase entity, int id, float sp, float turnspeed, double max, double range1) {
		entity.sneak = false;
		boolean ta = false;
		double range = range1;
		
		{
			List<Entity> llist = entity.world.getEntitiesWithinAABBExcludingEntity(entity, entity
					.getEntityBoundingBox().expand(entity.motionX, entity.motionY, entity.motionZ).grow(range));
			if (llist != null) {
				for (int lj = 0; lj < llist.size(); lj++) {
					Entity entity1 = (Entity) llist.get(lj);
					if (entity1.canBeCollidedWith()) {
						boolean flag = entity.getEntitySenses().canSee(entity1);
						if (entity.CanAttack(entity1) && entity1 != null) {//target
							if (entity.targetentity == entity1
									&& ((EntityLivingBase) entity1).getHealth() > 0.0F) {
								double d5 = entity1.posX - entity.posX;
								double d7 = entity1.posZ - entity.posZ;
								double d6 = entity1.posY - entity.posY;
								double d1 = entity.posY - (entity1.posY);
								double d3 = (double) MathHelper.sqrt(d5 * d5 + d7 * d7);
								float f11 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
								{
									entity.rotationYawHead = entity.rotation = entity.rote
											= -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
									entity.rotationp = entity.rotationPitch = -f11 + 10;
									MoveS(entity, 0.03);
									entity.noflag = 0;
									ta = true;
								}
									entity.targetentity = (EntityLivingBase) entity1;
								ta = true;
								break;
							} 
						}//target
						
					}
				}
			}
		}
		if(!ta){
			//stay(entity, id);
		}else{
			entity.sneak = true;
		}
	}
	
	public static void MoveS(EntityGVCLivingBase entity, double speed){
		{
			double mox = 0;
			double moy = entity.motionY;
			double moz = 0;
			
			float yaw = entity.rotationYawHead * (2 * (float) Math.PI / 360);
			
			mox -= MathHelper.sin(yaw) * speed * 1;
			moz += MathHelper.cos(yaw) * speed * 1;
			if(!entity.world.isRemote){
				entity.motionX = mox;
				entity.motionZ = moz;
				//entity.motionY = y;
				entity.move(MoverType.PLAYER, entity.motionX, entity.motionY, entity.motionZ);
			}
		}
	}

	
}
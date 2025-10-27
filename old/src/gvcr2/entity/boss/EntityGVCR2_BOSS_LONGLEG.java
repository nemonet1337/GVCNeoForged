package gvcr2.entity.boss;

import java.util.List;
import java.util.Random;

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

public class EntityGVCR2_BOSS_LONGLEG extends EntityGVCR2_BOSSBase //implements IEntityMultiPart
{

	
	//public MultiPartEntityPart dragonPartHead = new MultiPartEntityPart(this, "head", 6.0F, 6.0F);
	
	public EntityGVCR2_BOSS_LONGLEG(World worldIn) {
		super(worldIn);
		this.setSize(6.0F, 10F);
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
    	
		if(entity != null){
			if(this.getControllingPassenger() != null && this.getControllingPassenger() == source.getImmediateSource()){
	    		return false;
	        }else
	        {
	        	if(entity.posY < this.posY + 4.0D) {
	        		par2 = 0;
	        	}
				par2 = par2 * AI_Damage.newAntiBullet(this, entity, par2, 0.1F, 1.0F, 1.5F, 1.5F);
				if(par2 <= 0.0) {
					this.playSound(DamegeSound, 2F, 1F);
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
				Chest3.setInventorySlotContents(13, new ItemStack(mod_GVCR2.gvcr2_gun_m134, 1, 0));
				
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
        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL && this.getcanDespawn() == 0)
        {
            this.setDead();
        }
        
        if(FMLCommonHandler.instance().getMinecraftServerInstance() != null) {
			for (EntityPlayerMP playermp : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers()) {
				GVCLPacketHandler.INSTANCE2.sendTo(new GVCLClientMessageKeyPressed(2002, this.getEntityId(), cooltime2), playermp);
				GVCLPacketHandler.INSTANCE2.sendTo(new GVCLClientMessageKeyPressed(2015, this.getEntityId(), counter2), playermp);
				
				GVCLPacketHandler.INSTANCE2.sendTo(new GVCLClientMessageKeyPressed(2004, this.getEntityId(), cooltime4), playermp);
				GVCLPacketHandler.INSTANCE2.sendTo(new GVCLClientMessageKeyPressed(2017, this.getEntityId(), counter4), playermp);
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
    
	public void onLivingUpdate() {
		super.onLivingUpdate();
		
		if(this.getRemain_L() <= 0){
			++reload1;
			if(reload1 == reload_time1 - 20){
				this.playSound(GVCSoundEvent.reload_mag, 1.0F, 1.0F);
			}
			if(reload1 >= reload_time1){
				this.setRemain_L(this.magazine);
				reload1 = 0;
			}
		}
		if(this.getRemain_R() <= 0){
			++reload2;
			if(reload2 >= reload_time2){
				this.setRemain_R(this.magazine2);
				reload2 = 0;
			}
			this.cooltime2 = 0;
		}
		float sp = 0.00F;
		Vec3d looked = this.getLookVec();
		
		/*this.dragonPartHead.width = 1.0F;
        this.dragonPartHead.height = 1.0F;
        this.dragonPartHead.onUpdate();
        this.dragonPartHead.setLocationAndAngles(this.posX + 0, this.posY + 4, this.posZ - 0, 0.0F, 0.0F);
		*/
		
		boolean exflag = false;
		
		if(this.getHealth() > 0.0F) {
			AI_EntityWeapon.getTargetEntity(this, 100, 60, 20);
			this.newmove(this, 1, sp, 0, 2, 100);
		}
		
		
		reload_time1 = 100;
		reload_time2 = 60;
		
		this.magazine = 30;
		{
    		if(this.cooltime > 20)
			{
    			this.counter1 = true;
    			this.cooltime = 0;
			}
    		if(this.counter1 && this.gun_count1 > 2){
    			for(int iii = 0; iii < 4; ++iii){
					String model = "gvclib:textures/entity/model/bullet.mqo";
		    		String tex = "gvclib:textures/entity/model/bullet.png";
		    		String modelf = "gvclib:textures/entity/mflash.mqo";
		    		String texf = "gvclib:textures/entity/mflash.png";
		    		SoundEvent sounds = GVCSoundEvent.fire_mg;
		    		//SoundEvent sounds = null;
		    		
		        			AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
							we.id = 0;
							we.model = model;
							we.tex = tex;
							we.modelf = model;
							we.texf = tex;
							we.ftime = 0;
							we.sound = sounds;
							we.fly_sound = false;
							we.f = 1.57F;
							if(iii == 1) {
								we.w = -2.25F;
								we.bx = -2.25F;
								we.z = 2.25;
								we.bz = 2.25;
							}else if(iii == 2) {
								we.w = 2.25F;
								we.bx = 2.25F;
								we.z = -2.25;
								we.bz = -2.25;
							}else if(iii == 3) {
								we.w = -2.25F;
								we.bx = -2.25F;
								we.z = -2.25;
								we.bz = -2.25;
							}else {
								we.w = 2.25F;
								we.bx = 2.25F;
								we.z = 2.25;
								we.bz = 2.25;
							}
							we.h = 7.5;
							we.by = 7.5;
							we.follow_rote = true;//向いている方向に
							we.xoffset = 0;
							we.yoffset = 0;
							we.px = this.posX;
							we.py = this.posY;
							we.pz = this.posZ;
							we.lock = looked;
							we.rote = this.rotationYawHead;
							we.maxy = 20;
							we.miny = 10;
							
							if(this.countlimit1 == 0) {
								we.power = 3 + this.world.getDifficulty().getDifficultyId();
							}else {
								we.power = 0;
							}
							we.damegetime = false;
							we.speed = 2F;
							we.bure = 15F;
							we.ex = 0;
							we.extrue = false;
							we.kazu = 1;
							we.gra = 0.029;
							we.maxtime = 80;
							we.dameid = 0;
							we.Attacktask(this, this, 80);
				}
				this.gun_count1 = 0;
				++this.countlimit1;
			}
			if(this.countlimit1 >= 3){
				this.gun_count1 = 0;
				this.counter1 = false;
				this.countlimit1 = 0;
			}
    	}/**/
		
		
		
		
		
		this.magazine2 = 8;
		if(this.getAIType2() == 1) {
			{
	    		if(this.cooltime2 > 60 && this.getRemain_R() > 0)
				{
	    			this.counter2 = true;
	    			this.cooltime2 = 0;
				}
	    		if(this.counter2 && this.gun_count2 > 5 && this.getRemain_R() > 0){
	    			{
						String model = "gvclib:textures/entity/model/bullet_small_missile.mqo";
			    		String tex = "gvclib:textures/entity/model/bullet_small_missile.png";
			    		String modelf = "gvclib:textures/entity/mflash.mqo";
			    		String texf = "gvclib:textures/entity/mflash.png";
			    		SoundEvent sounds = GVCSoundEvent.fire_missile;
			    		
			        			AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
								we.id = 12;
								we.model = model;
								we.tex = tex;
								we.modelf = model;
								we.texf = tex;
								we.ftime = 0;
								we.sound = sounds;
								we.f = 1.57F;
								if(this.getRemain_R() %2 == 0) {
									we.w = 1.7F;
									we.bx = 1.7F;
								}else {
									we.w = -1.7F;
									we.bx = -1.7F;
								}
								we.z = 0.0;
								we.bz = 0.0;
								we.h = 10.0;
								we.by = 10.0;
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
								
								we.power = 3 + this.world.getDifficulty().getDifficultyId();
								we.damegetime = false;
								we.speed = 1F;
								we.bure = 5F;
								we.ex = 2;
								we.extrue = false;
								we.kazu = 1;
								we.gra = 0.029;
								we.maxtime = 80;
								we.dameid = 0;
								we.Attacktask(this, this, 80);
					}
					this.gun_count2 = 0;
					if(this.firetrue){
						this.setRemain_R(this.getRemain_R() - 1);
					}
					++this.countlimit2;
				}
				if(this.countlimit2 >= 4){
					this.gun_count2 = 0;
					this.counter2 = false;
					this.countlimit2 = 0;
				}
	    	}
			this.setAIType3(0);
			if(cannon_move > 0)--cannon_move;
		}
		else if(this.getAIType2() == 2){
			if(this.getattacktask()){
				{
					if(this.targetentity != null) {
						if(this.targetentity.posY < this.posY + 4.0D) {
							this.setAIType3(1);
							
						}else {
							this.setAIType3(2);
						}
					}
					if(cannon_move < 15)++cannon_move;
					
		    		if(this.cooltime2 > 80)
					{
		    			this.counter2 = true;
		    			//this.cooltime4 = 0;
					}
		    		if(this.counter2){
		    			if(this.targetentity != null) {
									/*double YY = 0;
									if(this.getAIType3() == 1) {
										YY = 2.0;
									}else {
										YY = 7.0;
									}
									
									EntityGVCR2_Bullet_Beam entitysnowball = new EntityGVCR2_Bullet_Beam(this.world, this);
						    		entitysnowball.timemax = 20;
						    		entitysnowball.gra = -0.03F;
						    		entitysnowball.startposX = this.posX;
						    		entitysnowball.startposY = this.posY;
						    		entitysnowball.startposZ = this.posZ;
						    		double d0 = this.targetentity.posY + (double)this.targetentity.getEyeHeight() - 1.100000023841858D;
						            double d1 = this.targetentity.posX - this.posX;
						            double d2 = d0 - entitysnowball.posY;
						            double d3 = this.targetentity.posZ - this.posZ;
						            float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
						            entitysnowball.setLocationAndAngles(posX, posY + YY, posZ, this.rotationYaw,
						            		this.rotationPitch);
						            entitysnowball.setThrowableHeading(d1, d2 + (double)f, d3, 1.0F, 1.0F);
						            this.playSound(SoundEvents.ENTITY_SNOWMAN_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
						            if(!this.world.isRemote)this.world.spawnEntity(entitysnowball);****/
		    				{
								String model = "gvclib:textures/entity/model/bullet_aaa.mqo";
					    		String tex = "gvclib:textures/entity/model/bullet_beam.png";
					    		String modelf = "gvclib:textures/entity/mflash.mqo";
					    		String texf = "gvclib:textures/entity/mflash.png";
					    		SoundEvent sounds = GVCSoundEvent.fire_rail;
					    		
					        			AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
										we.id = 1;
										we.model = model;
										we.tex = tex;
										we.modelf = model;
										we.texf = tex;
										we.ftime = 0;
										we.sound = sounds;
										we.f = 1.57F;
										if(this.getAIType3() == 1) {
											we.h = 3.5;
											we.by = 3.5;
										}else {
											we.h = 10.45;
											we.by = 10.45;
										}
										we.w = 0.0F;
										we.bx = 0.0F;
										we.z = 0.0;
										we.bz = 0.0;
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
										
										we.power = 3 + this.world.getDifficulty().getDifficultyId();
										we.damegetime = false;
										we.speed = 4F;
										we.bure = 1F;
										we.ex = -1;
										we.extrue = false;
										we.kazu = 1;
										we.gra = 0.03;
										we.maxtime = 80;
										we.dameid = 0;
										we.Attacktask(this, this, 100);
							}
						}
		    			
						if(this.cooltime2 > 100 && this.counter2)
						{
							this.cooltime2 = 0;
							this.gun_count2 = 0;
							this.counter2 = false;
							this.countlimit2 = 0;
							this.aitypetime2 = this.aitypemax2;
						}
					}
		    	}
	    	}
		}
		else {
			this.cooltime2 = 0;
			//this.cooltime4 = 0;
			this.gun_count2 = 0;
			//this.gun_count4 = 0;
			this.counter2 = false;
			this.setAIType3(0);
			if(cannon_move > 0)--cannon_move;
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
									entity.rotationYawHead = entity.rotation = entity.rote = entity.renderYawOffset 
											= -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
									entity.rotationp = entity.rotationPitch = -f11 + 10;
									
									entity.noflag = 0;
									ta = true;
								}
								if (flag) {
									entity.targetentity = (EntityLivingBase) entity1;
								}
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
	
	public void MoveS(EntityGVCLivingBase entity, double speed, double han, double ex, double ey, double ez, int id, EntityLivingBase en){
		{// 1
			if(!entity.world.isRemote)
			{
				double d5 = ex - entity.posX;
				double d7 = ez - entity.posZ;
				
				double root = Math.sqrt(d5 * d5 + d7 * d7);
				
				float off = 0;
				entity.rotationYaw = entity.renderYawOffset = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
				float yaw = entity.rotationYaw * (2 * (float) Math.PI / 360);
				double mox = 0;
				double moy = entity.motionY;
				double moz = 0;
				if(entity.getAIType2() != 1) {
					
				}


			}
		} // 1
	}
	
	public static void stay(EntityGVCLivingBase entity, int id) {
		double xPosition = 0;
	    double yPosition = 0;
	    double zPosition = 0;
		if (entity.getIdleTime() >= 100)
        {
        }
        else if (entity.getRNG().nextInt(120) != 0)
        {
        }
        else
        {
            Vec3d vec3 = RandomPositionGenerator.findRandomTarget(entity, 10, 7);

            if (vec3 == null)
            {
            }
            else
            {
                xPosition = vec3.x;
                yPosition = vec3.y;
                zPosition = vec3.z;
            }
            entity.rotation = entity.getRNG().nextInt(120) - 60;
        }
		if(id != 0) {
			entity.getNavigator().tryMoveToXYZ(xPosition, yPosition, zPosition, 1D);
		}
	}

	
}
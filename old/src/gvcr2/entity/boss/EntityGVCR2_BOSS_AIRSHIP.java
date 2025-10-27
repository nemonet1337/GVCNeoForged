package gvcr2.entity.boss;

import java.util.List;
import java.util.Random;

import gvclib.entity.EntityBBase;
import gvclib.entity.EntityB_Bullet;
import gvclib.entity.EntityTNTBase;
import gvclib.entity.EntityT_Grenade;
import gvclib.entity.living.AI_Damage;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_EntityWeapon_new;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.ISoldier;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLClientMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.mob.EntityGVCR2_GE_U_DRONE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockLilyPad;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGVCR2_BOSS_AIRSHIP extends EntityGVCR2_BOSSBase {
	
	public EntityGVCR2_BOSS_AIRSHIP(World worldIn) {
		super(worldIn);
		this.setSize(20F, 20F);
		this.experienceValue = 300;
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
	}
	
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		
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
				par2 = par2 * AI_Damage.newAntiBullet(this, entity, par2, 0.1F, 0.1F, 0.5F, 0.5F);
				if(par2 <= 0.0) {
					this.playSound(DamegeSound, 2F, 1F);
				}
				return super.attackEntityFrom(source, par2);
			}
		}else{
			return super.attackEntityFrom(source, par2);
		}
    }
	
	protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier)
    {
    }
	
    
	public void onUpdate()
    {
        super.onUpdate();
        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL && this.getcanDespawn() == 0)
        {
            this.setDead();
        }
    }
    
	protected void onDeathUpdate() {
		//super.onDeathUpdate();
		++deathTime;
		if(this.deathTime <= 140) {
			if (this.deathTime % 10 == 0 && !this.world.isRemote) {
				for(int ka = 0; ka < 3; ++ka) {
					int x = new Random().nextInt(20) - 10;
					int y = new Random().nextInt(20) - 10;
					int z = new Random().nextInt(20) - 10;
					GVCExplosionBase.ExplosionKai(this, this, this.posX + x, this.posY + y, this.posZ + z, 2, false,  false);
				}
			}
		}else if(this.deathTime <= 170){
			if (this.deathTime % 5 == 0 && !this.world.isRemote) {
				for(int ka = 0; ka < 3; ++ka) {
					int x = new Random().nextInt(20) - 10;
					int y = new Random().nextInt(20) - 10;
					int z = new Random().nextInt(20) - 10;
					GVCExplosionBase.ExplosionKai(this, this, this.posX + x, this.posY + y, this.posZ + z, 2, false,  false);
				}
			}
		}
		if(!this.world.isRemote && this.deathTime == 200) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 6, false,  false);
			/*{
				this.world.setBlockState(new BlockPos(this.getMoveX(), this.getMoveY(), this.getMoveZ()), Blocks.CHEST.getDefaultState(), 2);
				TileEntityChest Chest3;
				Chest3 = (TileEntityChest) this.world.getTileEntity(new BlockPos(this.getMoveX(), this.getMoveY(), this.getMoveZ()));
				Chest3.setInventorySlotContents(13, new ItemStack(mod_GVCR2.gvcr2_spawn_sp_st1, 1, 0));
				
				Chest3.setInventorySlotContents(4, new ItemStack(Blocks.DIAMOND_BLOCK, 2, 0));
				Chest3.setInventorySlotContents(12, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
				Chest3.setInventorySlotContents(14, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
				Chest3.setInventorySlotContents(22, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
				
				//Chest3.setInventorySlotContents(0, new ItemStack(mod_GVCR.i_aichip, 1, 0));
			}*/
			this.setDead();
		}
	}
	
	private int pos_reset = 0;
	public void getbeacon() {
		
    }
	
	@SideOnly(Side.CLIENT)
    public int getBrightnessForRender()
    {
        return 15728880;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness()
    {
        return 1.0F;
    }
	
    /*
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        if(player.isSneaking()) {
    		this.rotationYaw = this.rotationYaw + 10;
    		this.rotationYawHead = this.rotationYawHead + 10;
    		this.prevRotationYaw = this.prevRotationYaw + 10;
    		this.renderYawOffset = this.renderYawOffset + 10;
    	}else {
    		this.rotationYaw = this.rotationYaw - 10;
    		this.rotationYawHead = this.rotationYawHead - 10;
    		this.prevRotationYaw = this.prevRotationYaw - 10;
    		this.renderYawOffset = this.renderYawOffset - 10;
    	}
    	return true;
    }/**/
    
	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
    int self_ex = 0;
	public void onLivingUpdate() {
		super.onLivingUpdate();
		//if(this.startuptime < 100)return;
		
		float sp = 0.1F;
		Vec3d looked = this.getLookVec();
		
		boolean exflag = false;
		
		if(this.getMoveT() == 0) {
			this.setMoveT(1);
			this.setMoveX((int)this.posX);
			this.setMoveY((int)this.posY);
			this.setMoveZ((int)this.posZ);
		}
		
		if(this.getHealth() > 0.0F) {
			//AI_EntityWeapon.getTargetEntity(this, 80, 20, 20);
			this.newmove(this, 1, sp, 0, 2, 80);
			if(this.cooltime6 == 300
					|| this.cooltime6 == 320
					|| this.cooltime6 == 340
					|| this.cooltime6 == 360
					|| this.cooltime6 == 380){
				float yaw = this.rotationYaw * (2 * (float) Math.PI / 360);
				double mox = 0;
				double moy = this.motionY;
				double moz = 0;
				
				mox -= MathHelper.sin(yaw) * -17;
				moz += MathHelper.cos(yaw) * -17;
				{
					EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(this.world);
		            entityskeleton.setLocationAndAngles(this.posX + mox, this.posY+2, this.posZ + moz, this.rotationYaw, 0.0F);
		            entityskeleton.targetentity = this.targetentity;
		            entityskeleton.setOwnerId(this.entityUniqueID);
		            entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
					entityskeleton.setWeapon_inv_airborne(false);
		            entityskeleton.setWeapon(true);
		            entityskeleton.setMoveT(1);
		            entityskeleton.setMoveX((int)this.getMoveX());
		            entityskeleton.setMoveY((int)this.getMoveY());
		            entityskeleton.setMoveZ((int)this.getMoveZ());
		            if(!this.world.isRemote) {
		            	this.world.spawnEntity(entityskeleton);
		            }
				}
			}
			if(this.cooltime6 >= 400) {
				this.cooltime6 = 0;
			}
		}
		
		{
			{
				this.motionY *= 0.5F;
			}
			BlockPos bp = this.world.getHeight(new BlockPos(this.posX, this.posY, this.posZ));
			int genY = bp.getY() + 30;
			if (this.getHealth() > 0.0F) {
				if(this.posY <= genY || this.posY <= this.getMoveY() + 30) {
					this.motionY = 0.2F;
				}
			}
		}
    	
		
		hitboxgvc();
		Gunner();
		
	}/**/
	
	public void hitboxgvc() {
		Vec3d lock = Vec3d.fromPitchYaw(this.rotationPitch, this.rotationYaw);//entity.getForward();
		double xfront = this.posX + lock.x * 10;
		double yfront = this.posY + 10;
		double zfront = this.posZ + lock.z * 10;
		
		double xmiddle = this.posX;
		double ymiddle = this.posY + 10;
		double zmiddle = this.posZ;
		
		double xrear = this.posX + lock.x * -10;
		double yrear = this.posY + 10;
		double zrear = this.posZ + lock.z * -10;
		double han = 10;
		{
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - han), (double) (yfront - han),(double) (zfront - han),
					(double) (xfront + han), (double) (yfront + han), (double) (zfront + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	ImpactEntity(llist2);
	        }
		}
		{
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xrear - han), (double) (yrear - han),(double) (zrear - han),
					(double) (xrear + han), (double) (yrear + han), (double) (zrear + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	ImpactEntity(llist2);
	        }
		}
		{
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xmiddle - han), (double) (ymiddle - han),(double) (zmiddle - han),
					(double) (xmiddle + han), (double) (ymiddle + han), (double) (zmiddle + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	ImpactEntity(llist2);
	        }
		}
	}
	
	public void ImpactEntity(List llist2) {
		 for (int lj = 0; lj < llist2.size(); lj++) {
         	Entity entity1 = (Entity)llist2.get(lj);
             {
         		if ((entity1 instanceof IProjectile) && entity1 != null && entity1 != this)
                 {
         			if(entity1 instanceof EntityBBase) {
         				EntityBBase bullet = (EntityBBase) entity1;
         				if(bullet.getThrower() != this) {
         					Vec3d vec3d1 = new Vec3d(entity1.posX, entity1.posY, entity1.posZ);
             	            Vec3d vec3d = new Vec3d(entity1.posX + entity1.motionX, entity1.posY + entity1.motionY, entity1.posZ + entity1.motionZ);
             	            RayTraceResult raytraceresult = this.world.rayTraceBlocks(vec3d1, vec3d, false, true, false);
             	            if (this != null)
             	            {
             	                raytraceresult = new RayTraceResult(this);
             	            }
             	            if (raytraceresult != null)
             	            {
             	            	bullet.ImpactGVC(raytraceresult);
             	            }
             				/*if (!this.world.isRemote) {
             					entity1.setDead();
             				}*/
             				//System.out.println(String.format("000000000"));
         				}
         			}else {
         				
         			}
                 }
             }
         }
	}
	
	public void Gunner() {
		Vec3d lock = Vec3d.fromPitchYaw(this.rotationPitch, this.rotationYaw);//entity.getForward();
		float yaw = this.rotationYaw * (2 * (float) Math.PI / 360);
		double xyaw = 0;
		double zyaw = 0;
		double xfront = this.posX + 0;
		double yfront = this.posY + 0;
		double zfront = this.posZ + 0;
		double han = 50;
		{//右機銃
			xyaw -= MathHelper.sin(yaw + 1.57F) * 50;
			zyaw += MathHelper.cos(yaw + 1.57F) * 1;
			xfront = this.posX + xyaw;
			yfront = this.posY + 0;
			zfront = this.posZ + zyaw;
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - han), (double) (yfront - 20),(double) (zfront - han),
					(double) (xfront + han), (double) (yfront + 20), (double) (zfront + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	GunnerTarget(llist2, -1.57F, -4F, 2.0F, -2.65F, 1);
	        }
		}
		{//左機銃
			xyaw -= MathHelper.sin(yaw + 1.57F) * -50;
			zyaw += MathHelper.cos(yaw + 1.57F) * 1;
			xfront = this.posX + xyaw;
			yfront = this.posY + 0;
			zfront = this.posZ + zyaw;
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - han), (double) (yfront - 20),(double) (zfront - han),
					(double) (xfront + han), (double) (yfront + 20), (double) (zfront + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	GunnerTarget(llist2, -1.57F, 4F, 2.0F, -2.65F, 2);
	        }
		}
		{//上部機銃
			xfront = this.posX + 0;
			yfront = this.posY + 20;
			zfront = this.posZ + 0;
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - han), (double) (yfront - 5),(double) (zfront - han),
					(double) (xfront + han), (double) (yfront + 50), (double) (zfront + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	GunnerTarget(llist2, 0F, 0F, -1F, 0F, 3);
	        }
		}
		{//下部砲塔
			xfront = this.posX + 0;
			yfront = this.posY + 0;
			zfront = this.posZ + 0;
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - han), (double) (yfront - 50),(double) (zfront - han),
					(double) (xfront + han), (double) (yfront + 0), (double) (zfront + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	GunnerTarget(llist2, 0F, 0F, -0.5F, -8F, 4);
	        }
		}
		
		if(this.magazine == 0) {
			++this.reload1;
			if(this.reload1 > 60) {
				this.magazine = 20;
				this.reload1 = 0;
			}
		}
		if(this.magazine2 == 0) {
			++this.reload2;
			if(this.reload2 > 60) {
				this.magazine2 = 20;
				this.reload2 = 0;
			}
		}
		if(this.magazine3 == 0) {
			++this.reload3;
			if(this.reload3 > 60) {
				this.magazine3 = 20;
				this.reload3 = 0;
			}
		}
	}
	
	public void GunnerTarget(List llist2, float ff, float ww, float hh, float zz, int id) {
		int cooltimer;
		int mag;
		if(id == 1) {
			cooltimer = this.cooltime;
			mag = this.magazine;
		}else if(id == 2) {
			cooltimer = this.cooltime2;
			mag = this.magazine2;
		}else if(id == 3) {
			cooltimer = this.cooltime3;
			mag = this.magazine3;
		}else {
			cooltimer = this.cooltime4;
			mag = this.magazine4;
		}
		 for (int lj = 0; lj < llist2.size(); lj++) {
        	Entity entity1 = (Entity)llist2.get(lj);
            {
            	if (entity1.canBeCollidedWith() && entity1 != null && entity1 != null && entity1 instanceof EntityLivingBase) {
					if (((EntityLivingBase) entity1).getHealth() > 0.0F && this.getHealth() > 0.0F && this.CanAttack(entity1)) 
					{
						EntityLivingBase targeted = (EntityLivingBase) entity1;
						double d5 = entity1.posX - this.posX;
						double d7 = entity1.posZ - this.posZ;
						double d6 = entity1.posY - this.posY;
						double d1 = this.posY - (entity1.posY);
						double d3 = (double) MathHelper.sqrt(d5 * d5 + d7 * d7);
						float f11 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
						
						 if(id == 4) {
							 this.rotation_4 = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
								this.rotationp_4 = -f11 + 0;
							 if(cooltimer > 100)
				    			{
				        			AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
									we.id = 2;
									we.model = "gvclib:textures/entity/model/bullet_cannon.mqo";
									we.tex = "gvclib:textures/entity/model/bullet_cannon.png";
									we.modelf = "gvclib:textures/entity/msmoke.mqo";
									we.texf = "gvclib:textures/entity/msmoke.png";
									we.ftime = 16;
									we.sound = GVCSoundEvent.fire_cannon;
									we.f = ff;
									we.w = ww;
									we.h = hh;
									we.z = zz;
									we.bx = ww;
									we.by = hh;
									we.bz = zz;
									we.follow_rote = true;
									we.xoffset = 0;
									we.yoffset = 0;
									we.px = this.posX;
									we.py = this.posY;
									we.pz = this.posZ;
									we.lock = this.getLookVec();
									we.rote = this.rotationYawHead;
									we.maxy = 0;
									we.miny = 0;
									
									we.power = 30;
									we.speed = 1.6F;
									we.bure = 1F;
									we.ex = 3;
									we.extrue = true;
									we.kazu = 1;
									we.gra = 0.029;
									we.maxtime = 80;
									we.dameid = 0;
									we.target = targeted;
									if(magazine4 == 0) {
										we.WeaponAttack();
										++magazine4;
									}
									if(magazine4 == 1 && this.cooltime4 > 120) {
										we.WeaponAttack();
										++magazine4;
									}
									if(magazine4 >= 2) {
										this.cooltime4 = 0;
										magazine4 = 0;
									}
									return;
				    			}
						 }else {
							 if(cooltimer > 3 && mag > 0)
				    			{
				        			AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
									we.id = 0;
									we.model = "gvclib:textures/entity/model/bullet.mqo";
									we.tex = "gvclib:textures/entity/model/bullet.png";
									we.modelf = "gvclib:textures/entity/mflash.mqo";
									we.texf = "gvclib:textures/entity/mflash.png";
									we.ftime = 0;
									we.sound = GVCSoundEvent.fire_rifle3;
									we.f = ff;
									we.w = ww;
									we.h = hh;
									we.z = zz;
									we.bx = ww;
									we.by = hh;
									we.bz = zz;
									we.follow_rote = true;
									we.xoffset = 0;
									we.yoffset = 0;
									if(id == 3) {
										we.px = this.posX;
										we.py = this.posY + 20;
										we.pz = this.posZ;
									}else {
										we.px = this.posX;
										we.py = this.posY;
										we.pz = this.posZ;
									}
									we.lock = this.getLookVec();
									we.rote = this.rotationYawHead;
									we.maxy = 0;
									we.miny = 0;
									
									we.power = 4;
									we.speed = 3F;
									we.bure = 4F;
									we.ex = 0;
									we.extrue = false;
									we.kazu = 1;
									we.gra = 0.029;
									we.maxtime = 80;
									we.dameid = 0;
									we.target = targeted;
									we.WeaponAttack();
									{
										if(id == 1) {
											this.cooltime = 0;
											--this.magazine;
											this.rotation_1 = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
											this.rotationp_1 = -f11 + 0;
										}else if(id == 2) {
											this.cooltime2 = 0;
											--this.magazine2;
											this.rotation_2 = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
											this.rotationp_2 = -f11 + 0;
										}else if(id == 3) {
											this.cooltime3 = 0;
											--this.magazine3;
											this.rotation_3 = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
											this.rotationp_3 = -f11 + 0;
										}
									}
									return;
				    			}
						 }
					}
            	}
            }
        }
	}
	
	
	
	public void newmove(EntityGVCLivingBase entity, int id, float sp, float turnspeed, double max, double range1) {
		entity.sneak = false;
		boolean ta = false;
		double range = range1;
		
		{
			double d5 = entity.getMoveX() - entity.posX;
			double d7 = entity.getMoveZ() - entity.posZ;
			double d6 = entity.getMoveY() - entity.posY;
			double d1 = entity.posY - (entity.getMoveY());
			double d3 = (double) MathHelper.sqrt(d5 * d5 + d7 * d7);
			float f11 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
			{
				entity.rotationYaw = entity.renderYawOffset = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
				
				entity.rotationYawHead = entity.rotation = entity.rote
						= -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
				entity.rotationp = entity.rotationPitch = -f11 + 15;
				
				double ddx = Math.abs(d5);
				double ddz = Math.abs(d7);
				if ((ddx > 30 || ddz > 30)) 
				{
					MoveS(entity, sp, 1, entity.getMoveX(), entity.getMoveY(), entity.getMoveZ(), id);
				}
			}
		}
		
		
	}
	
	public void MoveS(EntityGVCLivingBase entity, double speed, double han, double ex, double ey, double ez, int id){
		{// 1
			if(!entity.world.isRemote)
			{
				double d5 = ex - entity.posX;
				double d7 = ez - entity.posZ;
				
				double root = Math.sqrt(d5 * d5 + d7 * d7);
				
				float off = 0;
				//entity.rotationYaw = entity.renderYawOffset = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
				float yaw = entity.rotationYaw * (2 * (float) Math.PI / 360);
				double mox = 0;
				double moy = entity.motionY;
				double moz = 0;
				//if(entity.aitypetime %15 ==  0 && entity.getAIType2() != 0)
				{
					 //if(entity.getAIType() == 0) 
					{
						mox -= MathHelper.sin(yaw) * speed * 1;
						moz += MathHelper.cos(yaw) * speed * 1;
					}
					
				}
				entity.stepHeight = entity.height * 0.8F;
				{
					{
						entity.motionX = mox;
						entity.motionZ = moz;
						entity.motionY = moy;
						entity.move(MoverType.SELF, entity.motionX, entity.motionY, entity.motionZ);
					}
				}

			}
		} // 1
	}
}
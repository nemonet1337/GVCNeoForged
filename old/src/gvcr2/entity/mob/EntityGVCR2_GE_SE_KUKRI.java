package gvcr2.entity.mob;

import java.util.List;

import gvclib.entity.EntityT_Grenade;
import gvclib.entity.living.AI_Damage;
import gvclib.entity.living.AI_EntityMoveS;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_EntityWeapon_new;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.event.GVCSoundEvent;
import gvclib.item.ItemGunBase;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.ai.AI_Type2_EntityMoveS;
import hmggirlfront.GFSoundEvent;
import hmggirlfront.mod_GirlFront;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityGVCR2_GE_SE_KUKRI extends EntityGVCR2_GEBase {

	public EntityGVCR2_GE_SE_KUKRI(World worldIn) {
		super(worldIn);
		this.setSize(0.5F, 1.8F);
		this.experienceValue = 10;
		
		aitypemax = 30;
		aitypemaxset = 3;
		aitypemax2 = 40;
		aitypemaxset2 = 3;
	}

	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIRestrictSun(this));
		this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0D);
	}
	
	

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
	}
	
	public void setWeapon() {
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_kukriknife));
	}
	
	
	/**
     * Drop the equipment for this entity.
     */
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier)
    {
    	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_gun_kukriknife), 0.0F);
    }
    
    public void getbeacon() {
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
	        	if(this.getAIType3() == 3) {
	        		par2 = 0;
	        	}
				par2 = par2 * AI_Damage.newAntiBullet(this, entity, par2, 0.5F, 0.5F, 0.5F, 1.0F);
				if(par2 <= 0.0) {
					this.playSound(DamegeSound, 2F, 1F);
				}
				return super.attackEntityFrom(source, par2);
			}
		}else{
			return super.attackEntityFrom(source, par2);
		}
    }
    
	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
    int self_ex = 0;
	public void onLivingUpdate() {
		super.onLivingUpdate();
//		this.biped = true;
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
		float sp = 0.08F;
		Vec3d looked = this.getLookVec();
		this.updateArmSwingProgress();
		
		boolean exflag = false;
		
		if(this.getHealth() > 0.0F) {
			AI_EntityWeapon.getTargetEntity(this, 50, 20, 20);
			this.newmove(this, 1, sp, 0, 2, 50);
		}
		/*if(!this.world.isRemote){
			float yaw = this.rotationYaw * (2 * (float) Math.PI / 360);
			double mox = 0;
			double moy = this.motionY;
			double moz = 0;
			mox -= MathHelper.sin(yaw) * sp * 1;
			moz += MathHelper.cos(yaw) * sp * 1;
			this.motionX = mox;
			this.motionZ = moz;
			this.motionY = moy;
			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
		}*/
		
		reload_time1 = 100;
		reload_time2 = 60;
		
		this.magazine = 30;
		this.magazine2 = 1;
		if(this.getAIType3() == 1) {
			{
	    		if(this.cooltime > 30)
				{
	    			this.counter1 = true;
	    			this.cooltime = 0;
				}
	    		if(this.counter1 && this.gun_count1 > 2){
	    			{
						String model = "gvcr2:textures/entity/throwing_knife.mqo";
			    		String tex = "gvcr2:textures/entity/throwing_knife.png";
			    		String modelf = "gvclib:textures/entity/non.mqo";
			    		String texf = "gvclib:textures/entity/non.png";
			    		SoundEvent sounds = SoundEvents.ENTITY_SNOWMAN_SHOOT;
			    		
			        			AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
								we.id = 0;
								we.model = model;
								we.tex = tex;
								we.modelf = model;
								we.texf = tex;
								we.ftime = 0;
								we.sound = sounds;
								we.f = 1.57F;
								we.w = 0.2F;
								we.h = 1.5;
								we.z = 0.75;
								we.bx = 0.2F;
								we.by = 1.5;
								we.bz = 0.0;
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
								
								we.power = 8 + this.world.getDifficulty().getDifficultyId();
								we.damegetime = false;
								we.speed = 1F;
								we.bure = 3F;
								we.ex = 0;
								we.extrue = false;
								we.kazu = 1;
								we.gra = 0.029;
								we.maxtime = 80;
								we.dameid = 0;
								we.Attacktask(this, this, 40);
					}
					this.gun_count1 = 0;
					++this.countlimit1;
				}
				if(this.countlimit1 >= 3){
					this.gun_count1 = 0;
					this.counter1 = false;
					this.countlimit1 = 0;
					this.setAIType3(2);
				}
	    	}
			this.cooltime2 = 0;
			this.aitypetime2 = 0;
		}
		else if(this.getAIType3() == 0){
			if(this.getattacktask()){
	    		/*if(this.cooltime2 == 40 ||this.cooltime2 == 41)
				{
		    			{
							String model = "gvclib:textures/entity/model/grenade_smoke.mqo";
				    		String tex = "gvclib:textures/entity/model/grenade_smoke.png";
				    		
				    		EntityT_Grenade entitysnowball = new EntityT_Grenade(this.world, this);
				    		entitysnowball.exsmoke = true;
				    		entitysnowball.timemax = 20;
				    		entitysnowball.exlevel = 3.0F;
				    		entitysnowball.gra = -0.03F;
				    		entitysnowball.setModel(model);
				    		entitysnowball.setTex(tex);
				            entitysnowball.setHeadingFromThrower(this, this.rotationPitch, this.rotationYaw, 0.0F,0.4F, 1.0F);
				            this.playSound(SoundEvents.ENTITY_SNOWMAN_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
				            if(!this.world.isRemote)this.world.spawnEntity(entitysnowball);
						}
	    		}
	    		else if(this.cooltime2 >= 40 && this.cooltime2 <= 80)
				{
	    			if(!this.world.isRemote){
							float yaw = this.rotationYawHead * (2 * (float) Math.PI / 360);
			    			double mox = 0;
							double moy = this.motionY;
							double moz = 0;
							mox += MathHelper.sin(yaw) * sp * 1;
							moz -= MathHelper.cos(yaw) * sp * 1;
							this.motionX = mox;
							this.motionZ = moz;
							this.motionY = moy;
							this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
					}
				}
	    		else */
				{
					String model = "gvclib:textures/entity/model/grenade_smoke.mqo";
		    		String tex = "gvclib:textures/entity/model/grenade_smoke.png";
		    		
		    		EntityT_Grenade entitysnowball = new EntityT_Grenade(this.world, this);
		    		entitysnowball.exsmoke = true;
		    		entitysnowball.timemax = 20;
		    		entitysnowball.exlevel = 3.0F;
		    		entitysnowball.gra = -0.03F;
		    		entitysnowball.setModel(model);
		    		entitysnowball.setTex(tex);
		            entitysnowball.setHeadingFromThrower(this, this.rotationPitch, this.rotationYaw, 0.0F,0.4F, 1.0F);
		            this.playSound(SoundEvents.ENTITY_SNOWMAN_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		            if(!this.world.isRemote)this.world.spawnEntity(entitysnowball);
				}
	    		{
					this.cooltime2 = 0;
					this.aitypetime2 = 0;
					this.setAIType3(1);
				}
	    	}
			this.cooltime = 0;
		}
		else if(this.getAIType3() == 2){
			if(this.getattacktask()){
	    		if(this.cooltime4 > 40)
				{
	    			if(this.targetentity != null) {
	    				double d5 = this.targetentity.posX - this.posX;
						double d7 = this.targetentity.posZ - this.posZ;
						double ddx = Math.abs(d5);
						double ddz = Math.abs(d7);
						if ((ddx > 2 || ddz > 2)) 
						{
							if(!this.world.isRemote){
								float yaw = this.rotationYawHead * (2 * (float) Math.PI / 360);
				    			double mox = 0;
								double moy = this.motionY;
								double moz = 0;
								mox -= MathHelper.sin(yaw) * sp * 6;
								moz += MathHelper.cos(yaw) * sp * 6;
								this.motionX = mox;
								this.motionZ = moz;
								this.motionY = moy;
								this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
							}
						}
	    			}
				}
	    		if(this.cooltime4 > 80)
	    		{
	    			this.setAIType3(3);
	    		}
	    	}
			this.cooltime = 0;
		}else {
			this.cooltime = 0;
			this.cooltime2 = 0;
			this.cooltime4 = 0;
		}
		 if(this.getAIType2() == 0){
			 this.setAIType3(0);
			 this.aitypetime2 = 0;
			 this.setAIType2(1);
		 }
		 int range = 3;
		 boolean task = AI_EntityWeapon.KnifeAttack(this, 0, range, range, 1, 1);
			if(task){//1
				if(this.cooltime3 > 30){
					this.swingArm(EnumHand.MAIN_HAND);
					Vec3d lock = Vec3d.fromPitchYaw(this.rotationPitch, this.rotationYaw);
					float d = 3;
					List<Entity> llist = this.world.getEntitiesWithinAABBExcludingEntity(this,
							this.getEntityBoundingBox()
									.expand(lock.x * d, lock.y * d, lock.z * d)
									.grow(0.02D));
					if (llist != null) {
						for (int lj = 0; lj < llist.size(); lj++) {
							Entity entity1 = (Entity) llist.get(lj);
							if (entity1.canBeCollidedWith() && entity1 instanceof EntityLivingBase && entity1 != null) {
								if(entity1 != this && entity1 != this.getControllingPassenger()){
									entity1.attackEntityFrom(DamageSource.causeMobDamage(this), 12);
								}
							}
						}
					}
					this.cooltime3 = 0;
				}
			}//1
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
									entity.rotationp = entity.rotationPitch = -f11 + 0;
									double ddx = Math.abs(d5);
									double ddz = Math.abs(d7);
									if ((ddx > 10 || ddz > 10)) 
									{
										this.setAIType(0);
										this.aitypetime = 0;
										MoveS(entity, sp, 2, entity1.posX, entity1.posY, entity1.posZ, 1, (EntityLivingBase)entity1);
									}else if ((ddx < 5 && ddz < 5)) {
										MoveS(entity, sp, 2, entity1.posX, entity1.posY, entity1.posZ, 2, (EntityLivingBase)entity1);
									}else {
										MoveS(entity, sp, 2, entity1.posX, entity1.posY, entity1.posZ, 0, (EntityLivingBase)entity1);
									}
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
			stay(entity, id);
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
				if(this.getAIType3() == 3)  {
					if(id == 1) {
						mox -= MathHelper.sin(yaw) * speed * 1;
						moz += MathHelper.cos(yaw) * speed * 1;
					}else if(id == 2) {
						mox -= MathHelper.sin(yaw) * speed * -1;
						moz += MathHelper.cos(yaw) * speed * -1;
					}else {
						if(entity.getAIType() == 1) {
							mox -= MathHelper.sin(yaw + 1.57F) * speed * 1;
							moz += MathHelper.cos(yaw + 1.57F) * speed * 1;
						}
						else{
							mox -= MathHelper.sin(yaw - 1.57F) * speed * 1;
							moz += MathHelper.cos(yaw - 1.57F) * speed * 1;
						}
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
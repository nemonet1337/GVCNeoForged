package gvcr2.entity.mob;

import java.util.List;

import gvclib.entity.EntityT_Grenade;
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityGVCR2_GE_SE_CERBERUS extends EntityGVCR2_GEBase {

	public EntityGVCR2_GE_SE_CERBERUS(World worldIn) {
		super(worldIn);
		this.setSize(0.5F, 1.8F);
		this.experienceValue = 10;
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
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_mg42));
	}
	
	
	/**
     * Drop the equipment for this entity.
     */
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier)
    {
    	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_gun_mg42), 0.0F);
    }
    
    public void getbeacon() {
    }
    
	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
    int self_ex = 0;
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.biped = true;
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
		float sp = 0.04F;
		Vec3d looked = this.getLookVec();
		
		
		boolean exflag = false;
		
		if(this.getHealth() > 0.0F) {
			AI_EntityWeapon.getTargetEntity(this, 50, 20, 20);
			this.newmove(this, 1, sp, 0, 2, 50);
		}
		
		
		reload_time1 = 100;
		reload_time2 = 60;
		
		this.magazine = 30;
		this.magazine2 = 1;
		if(this.getAIType2() != 1) {
			{
	    		if(this.cooltime > 30 && this.getRemain_L() > 0)
				{
	    			this.counter1 = true;
	    			this.cooltime = 0;
				}
	    		if(this.counter1 && this.gun_count1 > 0 && this.getRemain_L() > 0){
	    			{
						String model = "gvclib:textures/entity/BulletNormal.obj";
			    		String tex = "gvclib:textures/entity/BulletNormal.png";
			    		String modelf = "gvclib:textures/entity/mflash.mqo";
			    		String texf = "gvclib:textures/entity/mflash.png";
			    		SoundEvent sounds = GVCSoundEvent.fire_mg;
			    		
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
								
								we.power = 3 + this.world.getDifficulty().getDifficultyId();
								we.damegetime = false;
								we.speed = 3F;
								we.bure = 5F;
								we.ex = 0;
								we.extrue = false;
								we.kazu = 1;
								we.gra = 0.029;
								we.maxtime = 80;
								we.dameid = 0;
								we.Attacktask(this, this, 40);
					}
					this.gun_count1 = 0;
					if(this.firetrue){
						this.setRemain_L(this.getRemain_L() - 1);
					}
					++this.countlimit1;
				}
				if(this.countlimit1 >= 10){
					this.gun_count1 = 0;
					this.counter1 = false;
					this.countlimit1 = 0;
				}
	    	}
			this.cooltime2 = 0;
		}else {
			if(this.getattacktask()){
	    		if(this.cooltime2 > 60 && this.getRemain_R() > 0)
				{
	    			{
		    			{
							String model = "gvclib:textures/entity/BulletNormal.obj";
				    		String tex = "gvclib:textures/entity/BulletNormal.png";
				    		String modelf = "gvclib:textures/entity/mflash.mqo";
				    		String texf = "gvclib:textures/entity/mflash.png";
				    		SoundEvent sounds = GVCSoundEvent.fire_mg;
				    		
				    		EntityT_Grenade entitysnowball = new EntityT_Grenade(this.world, this);
				    		entitysnowball.exsmoke = true;
				    		entitysnowball.timemax = 20;
				    		entitysnowball.exlevel = 3.0F;
				    		entitysnowball.gra = -0.03F;
				            entitysnowball.setHeadingFromThrower(this, this.rotationPitch, this.rotationYaw, 0.0F,0.4F, 1.0F);
				            this.playSound(SoundEvents.ENTITY_SNOWMAN_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
				            if(!this.world.isRemote)this.world.spawnEntity(entitysnowball);
						}
						this.setRemain_R(this.getRemain_R() - 1);
						this.cooltime2 = 0;
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
									if ((ddx > 20 || ddz > 20)) 
									{
										this.setAIType(0);
										this.aitypetime = 0;
										this.setAIType2(0);
										this.aitypetime2 = 0;
										MoveS(entity, sp, 1, entity1.posX, entity1.posY, entity1.posZ, id, (EntityLivingBase)entity1);
									}else {
										MoveS(entity, sp, 1, entity1.posX, entity1.posY, entity1.posZ, id, (EntityLivingBase)entity1);
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
				if(entity.getAIType2() != 1) {
					if(entity.getAIType() == 1) {
						mox -= MathHelper.sin(yaw + 1.57F) * speed * 1;
						moz += MathHelper.cos(yaw + 1.57F) * speed * 1;
					}
					else if(entity.getAIType() == 2) {
						mox -= MathHelper.sin(yaw - 1.57F) * speed * 1;
						moz += MathHelper.cos(yaw - 1.57F) * speed * 1;
					}
					else if(entity.getAIType() == 3) {
						mox -= MathHelper.sin(yaw) * speed * -1;
						moz += MathHelper.cos(yaw) * speed * -1;
					}
					else if(entity.getAIType() == 0){
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
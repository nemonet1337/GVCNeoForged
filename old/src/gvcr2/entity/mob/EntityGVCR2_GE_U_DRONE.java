package gvcr2.entity.mob;

import java.util.List;

import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.event.GVCSoundEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.IMob;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGVCR2_GE_U_DRONE extends EntityGVCR2_GEBase {

	public EntityGVCR2_GE_U_DRONE(World worldIn) {
		super(worldIn);
		this.setSize(1F, 1F);
		aitypemax = 100;
		aitypemax2 = 40;
		aitypemaxset2 = 10;
	}

	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIRestrictSun(this));
		this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
	}

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		
	}
    
	public boolean attackEntityFrom(DamageSource source, float par2)
    {
    	Entity entity;
    	entity = source.getTrueSource();
    	
		if(entity != null){
			if(entity instanceof IMob){
	    		return false;
	        }else {
	        	return super.attackEntityFrom(source, par2);
	        }
		}else{
			return super.attackEntityFrom(source, par2);
		}
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
		++this.deathTime;
		if(!this.world.isRemote && this.deathTime == 1) {
			//GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 1, false,  false);
			this.motionY = 0.4F;
		}
		this.motionY *= 0.8F;
		if(!this.world.isRemote && this.onGround) {
			//GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 2, false,  false);
			this.setDead();
		}
		if(this.deathTime >= 200) {
			this.setDead();
		}
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
	
	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
    int self_ex = 0;
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.biped = true;
		this.reload_time1 = 60;
		this.magazine = 10;
		if(this.getRemain_L() <= 0){
			++reload1;
			if(reload1 >= reload_time1){
				this.setRemain_L(this.magazine);
				reload1 = 0;
			}
		}
		float sp = 0.1F;
		Vec3d looked = this.getLookVec();
		
		boolean exflag = false;
		if(this.deathTime < 0) {
			this.motionY *= 0.1F;
		}
		
		AI_EntityWeapon.getTargetEntity(this, 30, 20, 20);
		///AI_EntityMoveS.newmove(this, 1, sp, 0, 1, 40, 40);
		this.newmove(this, 1, sp, 0, 20, 30);
		BlockPos bp = this.world.getHeight(new BlockPos(this.posX, this.posY, this.posZ));
		int genY = bp.getY() + 3;
		if (this.posY <= genY && this.getHealth() > 0.0F) {
			this.motionY = 0.2F;
		}
		
		if(AI_EntityWeapon.getRange(this, 30, 20, 20)){
			String model = "gvclib:textures/entity/BulletNormal.obj";
    		String tex = "gvclib:textures/entity/BulletNormal.png";
    		String modelf = "gvclib:textures/entity/mflash.mqo";
    		String texf = "gvclib:textures/entity/mflash.png";
        	{
        		if(this.cooltime > 30 && this.getRemain_L() > 0)
    			{
        			this.counter1 = true;
        			this.cooltime = 0;
    			}
        		if(this.counter1 && this.gun_count1 > 2 && this.getRemain_L() > 0){
        			SoundEvent sounds = GVCSoundEvent.fire_hg;
        			
        			AI_EntityWeapon.Attacktask(this, this, 0, 40, 
        					model, tex, modelf, texf,2, sounds, 
        					0, 0, 0, 0.9,this.posX, this.posY, this.posZ,looked,this.rotationYawHead, 10, 10,
    						3, 1.4F, 2, 0, false, 1, 0.029D, 80, 0);
    				this.gun_count1 = 0;
    				if(this.firetrue){
    					this.setRemain_L(this.getRemain_L() - 1);
    				}
    				++this.countlimit1;
    			}
    			if(this.countlimit1 >= 1){
    				this.gun_count1 = 0;
    				this.counter1 = false;
    				this.countlimit1 = 0;
    			}
        	}
		}
		{
			boolean boss = false;
			double k = this.posX;
			double l = this.posY;
			double i = this.posZ;
			int han = 20;
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double) (k - han), (double) (l - han),
					(double) (i - han), (double) (k + han), (double) (l + han), (double) (i + han)))
							.grow(1);
			List<Entity> llist = this.world.getEntitiesWithinAABBExcludingEntity(this, axisalignedbb);
			if (llist != null) {
				for (int lj = 0; lj < llist.size(); lj++) {
					Entity entity1 = (Entity) llist.get(lj);
					if (entity1.canBeCollidedWith() && entity1 != null) {
						if (entity1 instanceof EntityGVCR2_GE_SE_ASSAULT || entity1 instanceof EntityGVCR2_GE_SV) {
							boss = true;
						}
					}
				}
			}
			if(!boss) {
				if (!this.world.isRemote)
		        {
		            this.setDead();
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
					.getEntityBoundingBox().expand(entity.motionX, entity.motionY, entity.motionZ).grow(10));
			if (llist != null) {
				for (int lj = 0; lj < llist.size(); lj++) {
					Entity entity1 = (Entity) llist.get(lj);
					if (entity1.canBeCollidedWith()) {
						if (entity1 != null && (entity1 instanceof EntityGVCR2_GE_SE_ASSAULT  || entity1 instanceof EntityGVCR2_GE_SV)) {//target
							if (entity.getHealth() > 0.0F) {
								double d5 = entity1.posX - entity.posX;
								double d7 = entity1.posZ - entity.posZ;
								double d6 = entity1.posY - entity.posY;
								double d1 = entity.posY - (entity1.posY);
								double d3 = (double) MathHelper.sqrt(d5 * d5 + d7 * d7);
								float f11 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
								{
									double ddx = Math.abs(d5);
									double ddz = Math.abs(d7);
									if ((ddx > 2 || ddz > 2)) 
									{
										MoveS(entity, sp, 1, entity1.posX, entity1.posY, entity1.posZ, id, (EntityLivingBase)entity1);
									}
								}
							} 
						}//target
						if (entity1 != null && entity1 instanceof EntityGVCR2_GE_U_DRONE) {
							double d5 = entity1.posX - entity.posX;
							double d7 = entity1.posZ - entity.posZ;
							double d6 = entity1.posY - entity.posY;
							double d1 = entity.posY - (entity1.posY);
							double d3 = (double) MathHelper.sqrt(d5 * d5 + d7 * d7);
							double ddx = Math.abs(d5);
							double ddz = Math.abs(d7);
							if ((ddx < 3 && ddz < 3)) {
								MoveS(entity, -sp, 1, entity1.posX, entity1.posY, entity1.posZ, id, (EntityLivingBase)entity1);
							}
							//break;
						}
					}
				}
			}
		}
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
									entity.rotationYawHead = entity.rotation = entity.rote = entity.renderYawOffset = entity.rotationYaw
											= -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
									entity.rotationp = entity.rotationPitch = -f11 + 0;
									entity.noflag = 0;
									ta = true;
								}
								if (flag) {
									entity.targetentity = (EntityLivingBase) entity1;
									entity.setattacktask(true);
								}
								ta = true;
								break;
							} 
						}//target
						
					}
				}
			}
		}
		
	}
	
	public void MoveS(EntityGVCLivingBase entity, double speed, double han, double ex, double ey, double ez, int id, EntityLivingBase en){
		{// 1
			if(!entity.world.isRemote)
			{
				double d5 = ex - entity.posX;
				double d7 = ez - entity.posZ;
				float yawoffset = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
				float yaw = yawoffset * (2 * (float) Math.PI / 360);
				double mox = 0;
				double moy = entity.motionY;
				double moz = 0;
				mox -= MathHelper.sin(yaw) * speed * 1;
				moz += MathHelper.cos(yaw) * speed * 1;
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
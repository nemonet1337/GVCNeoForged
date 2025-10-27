package gvcr2.entity.boss;

import java.util.List;

import gvclib.entity.living.EntityGVCLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityGVCR2_EE_Shark extends EntityGVCLivingBase implements IAnimals {

	public EntityGVCR2_EE_Shark(World worldIn) {
		super(worldIn);
		this.setSize(4F, 15F);
		this.experienceValue = 10;
	}

	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIRestrictSun(this));
		this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));

	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(2000D);
		 this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.2D);
	}
	
	/**
	 * Get this Entity's EnumCreatureAttribute
	 */
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}
	public void onLivingUpdate() {
		super.onLivingUpdate();
		float sp = 0.08F;
		Vec3d looked = this.getLookVec();
		{
		    	List<Entity> llist = this.world.getEntitiesWithinAABBExcludingEntity(this,
						this.getEntityBoundingBox().expand(this.motionX, this.motionY, this.motionZ).grow(10));
				if (llist != null) {
					for (int lj = 0; lj < llist.size(); lj++) {
						Entity entity1 = (Entity) llist.get(lj);
						if (entity1.canBeCollidedWith()) {
							{
								if (entity1 instanceof EntityLivingBase && entity1 != null && ((EntityLivingBase) entity1).getHealth() > 0.0F) 
								{
									entity1.motionY = 2;
									entity1.attackEntityFrom(DamageSource.causeMobDamage(this), 1000);
								}
							}
						}
					}
				}
		}
		if(this.cooltime == 0) {
			this.motionY = 2;
		}
		if(this.cooltime >= 60) {
			if(!this.world.isRemote) {
				this.setDead();
			}
		}
	}
	
	public boolean CanAttack(Entity entity){
    	{
    		return false;
    	}
    }
    
    
    
    /**
    * Checks to make sure the light is not too bright where the mob is spawning
    */
   protected boolean isValidLightLevel()
   {
       BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

       if (this.world.getLightFor(EnumSkyBlock.SKY, blockpos) > this.rand.nextInt(32))
       {
           return false;
       }
       else
       {
           int i = this.world.getLightFromNeighbors(blockpos);

           if (this.world.isThundering())
           {
               int j = this.world.getSkylightSubtracted();
               this.world.setSkylightSubtracted(10);
               i = this.world.getLightFromNeighbors(blockpos);
               this.world.setSkylightSubtracted(j);
           }

           return i <= this.rand.nextInt(8);
       }
   }

   /**
    * Checks if the entity's current position is a valid location to spawn this entity.
    */
   public boolean getCanSpawnHere()
   {
       return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && super.getCanSpawnHere();
   }
    
    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
    	return false;
    }
    
    
    public void onUpdate()
    {
        super.onUpdate();
    }
}
package gvcr2.entity.bullet;

import gvclib.entity.living.AI_EntityMoveS;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.ISoldier;
import gvclib.item.ItemGunBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGVCR2_STARS extends EntityGVCLivingBase implements ISoldier{

	public EntityGVCR2_STARS(World worldIn) {
		super(worldIn);
		this.setSize(2F, 0.5F);
	}

	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIRestrictSun(this));
		this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
	}

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		
	}
	
	 /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
    	return false;
    }
	
	public boolean CanAttack(Entity entity){
    	{
    		return false;
    	}
    }
    
	public void onUpdate()
    {
        super.onUpdate();
    }
	
	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
    int timer = 0;
	public void onLivingUpdate() {
		super.onLivingUpdate();
		++timer;
		if(timer > 20) {
			BlockPos bp = this.world.getHeight(new BlockPos(this.posX, this.posY, this.posZ));
			int genY = bp.getY() + 30;
			if (this.getHealth() > 0.0F) {
				this.motionY = 0.3F;
			}
			if(this.posY >= genY) {
				//if(!this.world.isRemote)
				{
					
					/*Entity entity = this.getRidingEntity();
					if(entity != null) {
						entity.setDead();
						this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_spawn_ge_pow), 0.0F);
					}*/
					if(this.getPassengers().size() > 0) {
						if (this.getPassengers().get(0) != null && !this.world.isRemote)
						{
							this.getPassengers().get(0).setDead();
							this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_spawn_ge_pow), 0.0F);
						}
					}
					/*if(this.getPassengers().size() > 1)
			        {
			        	 if(this.getPassengers().get(1) != null){
			     			if (this.getPassengers().get(1) instanceof EntityGVCR2_GE_S) {
			     				this.setDead();
			     			}
			        	 }
			        }*/
					
					if(!this.world.isRemote)this.setDead();
				}
			}
		}
		if(timer > 300) {
			if(!this.world.isRemote)this.setDead();
		}
	}
}
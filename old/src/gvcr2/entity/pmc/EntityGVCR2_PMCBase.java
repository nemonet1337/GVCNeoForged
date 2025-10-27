package gvcr2.entity.pmc;

import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.ISoldier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityGVCR2_PMCBase extends EntityGVCLivingBase implements ISoldier
{
	
	
    public EntityGVCR2_PMCBase(World worldIn)
    {
        super(worldIn);
    }

    /*public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    	{
    		this.rotationYaw = this.rotationYaw + 5;
    		this.rotationYawHead = this.rotationYawHead + 5;
    		this.prevRotationYaw = this.prevRotationYaw + 5;
    		this.renderYawOffset = this.renderYawOffset + 5;
    	}
    	return true;
    }*/
    
    public boolean CanAttack(Entity entity){
    	if(entity instanceof IMob && ((EntityLivingBase) entity).getHealth() > 0.0F){
    		return true;
    	}else
    	{
    		return false;
    	}
    }
    
    protected void entityInit() {
		super.entityInit();
	}
    
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL)
        {
            this.setDead();
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
    	if(this.getcanDespawn() == 1){
        return false;
    	}else{
    		return true;
    	}
        
    }
    
}
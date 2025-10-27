package gvcr2.entity.so;

import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.ISoldier;
import gvcr2.mod_GVCR2;
import gvcr2.event.level.GVCR2WorldDifficultyLevel;
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
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldProviderSurface;

public class EntityGVCR2_SOBase extends EntityGVCLivingBase implements ISoldier
{
	
	
    public EntityGVCR2_SOBase(World worldIn)
    {
        super(worldIn);
    }

    /*
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    	ItemStack itemstack = player.getHeldItem(hand);
        boolean flag = !itemstack.isEmpty();
        if(flag) {
        	if(player.isSneaking()) {
        		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, itemstack);
        	}
        }
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
    
    public int getLevel() {
  	  /* if(mod_GVCR2.cfg_spawn_original) {
  		   return 10;
  	   }else */
  	   {
  		   return GVCR2WorldDifficultyLevel.getLevel(mod_GVCR2.INSTANCE, this.world);
  	   }
     }
    
    public boolean CanAttack(Entity entity){
    	if(entity instanceof IMob && ((EntityLivingBase) entity).getHealth() > 0.0F){
    		return true;
    	}else/**/
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

   public boolean getCanSpawnUnderGround()
   {
	   boolean flag = false;
	   BlockPos bp = world.getHeight(new BlockPos(this.posX, this.posY, this.posZ));
	   int genY = bp.getY();
	   if(this.posY >= genY) {
		   flag = true;
	   }
	   if(mod_GVCR2.cfg_canspawn_underground) {
		   flag = true;
	   }
	   return flag;
   }
   
   public boolean getCanSpawnDimension()
   {
	   boolean flag = false;
	   if (world.provider instanceof WorldProviderSurface) {
		   flag = true;
	   }
	   else if (world.provider instanceof WorldProviderHell) {
		   flag = mod_GVCR2.cfg_canspawn_hell;
	   }
	   else if (world.provider instanceof WorldProviderEnd) {
		   flag = mod_GVCR2.cfg_canspawn_sky;
	   }else {
		   flag = mod_GVCR2.cfg_canspawn_anotherworld;
	   }
	   return flag;
   }
   
   /**
    * Checks if the entity's current position is a valid location to spawn this entity.
    */
   public boolean getCanSpawnHere()
   {
       return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && this.isValidLightLevel() 
    		   && this.getCanSpawnUnderGround() && getCanSpawnDimension() && super.getCanSpawnHere();
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
package gvcr2.entity.boss;

import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.ISoldier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGVCR2_BOSSBase_Base extends EntityGVCLivingBase
{
	
	private final BossInfoServer bossInfo =
			(BossInfoServer)(new BossInfoServer(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS)).setDarkenSky(false);
	
    public EntityGVCR2_BOSSBase_Base(World worldIn)
    {
        super(worldIn);
    }
    
    /**　各entityごとにGVCLPacketHandlerに飛ばすこと
     * 2001*/
    @SideOnly(Side.CLIENT)
    public int getClient_cooltime(EntityGVCLivingBase entity)
    {
        return entity.cooltime;
    }
    /**　各entityごとにGVCLPacketHandlerに飛ばすこと
     * 2002*/
    @SideOnly(Side.CLIENT)
    public int getClient_cooltime2(EntityGVCLivingBase entity)
    {
        return entity.cooltime2;
    }
    /**　各entityごとにGVCLPacketHandlerに飛ばすこと
     * 2003*/
    @SideOnly(Side.CLIENT)
    public int getClient_cooltime3(EntityGVCLivingBase entity)
    {
        return entity.cooltime3;
    }
    /**　各entityごとにGVCLPacketHandlerに飛ばすこと
     * 2004*/
    @SideOnly(Side.CLIENT)
    public int getClient_cooltime4(EntityGVCLivingBase entity)
    {
        return entity.cooltime4;
    }
    
    
    /**　各entityごとにGVCLPacketHandlerに飛ばすこと
     * 2014*/
    @SideOnly(Side.CLIENT)
    public boolean getClient_counter(EntityGVCLivingBase entity)
    {
        return entity.counter1;
    }
    /**　各entityごとにGVCLPacketHandlerに飛ばすこと
     * 2015*/
    @SideOnly(Side.CLIENT)
    public boolean getClient_counter2(EntityGVCLivingBase entity)
    {
        return entity.counter2;
    }
    /**　各entityごとにGVCLPacketHandlerに飛ばすこと
     * 2016*/
    @SideOnly(Side.CLIENT)
    public boolean getClient_counter3(EntityGVCLivingBase entity)
    {
        return entity.counter3;
    }
    /**　各entityごとにGVCLPacketHandlerに飛ばすこと
     * 2017*/
    @SideOnly(Side.CLIENT)
    public boolean getClient_counter4(EntityGVCLivingBase entity)
    {
        return entity.counter4;
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
    
    protected void entityInit() {
		super.entityInit();
	}

	/**
	 * Get this Entity's EnumCreatureAttribute
	 */
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}
    
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL)
        {
            this.setDead();
        }
        if(this.getHealth() > 0.0F) {
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}
    }
    
    /**
     * Add the given player to the list of players tracking this entity. For instance, a player may track a boss in
     * order to view its associated boss bar.
     */
    public void addTrackingPlayer(EntityPlayerMP player)
    {
        super.addTrackingPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    /**
     * Removes the given player from the list of players tracking this entity. See {@link Entity#addTrackingPlayer} for
     * more information on tracking.
     */
    public void removeTrackingPlayer(EntityPlayerMP player)
    {
        super.removeTrackingPlayer(player);
        this.bossInfo.removePlayer(player);
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
    
}
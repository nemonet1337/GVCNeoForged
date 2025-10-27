package gvcr2.item;

import java.util.List;

import gvclib.mod_GVCLib;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.ISoldier;
import gvclib.item.ItemGunBase;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvcr2.network.GVCR2ClientMessageKeyPressed;
import gvcr2.network.GVCR2MessageKeyPressed;
import gvcr2.network.GVCR2PacketHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;


	public class ItemAED extends Item {
		
		public ItemAED() {
			super();
			this.maxStackSize = 1;
		}
		
		public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
	    {
			super.onUpdate(itemstack, world, entity, i, flag);
			
	    }
		
		public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityLivingBase par3EntityPlayer, int par4){
			
        }
		
		/*public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	    {
			ItemStack itemstack = playerIn.getHeldItem(handIn);
	        {
	            playerIn.setActiveHand(handIn);
	            return new ActionResult(EnumActionResult.SUCCESS, itemstack);
	        }
	    }*/
		/**
	     * Called when the equipped item is right clicked.
	     */
	    /*public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	    {
	        ItemStack itemstack = ItemMap.setupNewMap(worldIn, playerIn.posX, playerIn.posZ, (byte)4, true, false);
	        ItemStack itemstack1 = playerIn.getHeldItem(handIn);
	        itemstack1.shrink(1);

	        if (itemstack1.isEmpty())
	        {
	            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	        }
	        else
	        {
	            if (!playerIn.inventory.addItemStackToInventory(itemstack.copy()))
	            {
	                playerIn.dropItem(itemstack, false);
	            }

	            playerIn.addStat(StatList.getObjectUseStats(this));
	            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack1);
	        }
	    }*/
		
		  /**
	     * How long it takes to use or consume an item
	     */
	    public int getMaxItemUseDuration(ItemStack stack)
	    {
	        return 72000;
	    }

	    /**
	     * returns the action that specifies what animation to play when the items is being used
	     */
	    public EnumAction getItemUseAction(ItemStack stack)
	    {
	        return EnumAction.BOW;
	    }
}

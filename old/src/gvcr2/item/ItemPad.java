package gvcr2.item;

import gvcr2.mod_GVCR2;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemPad extends Item{
	
	public ItemPad()
    {
        this.maxStackSize = 1;
    }
	
	/**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
    	ItemStack itemStackIn = playerIn.getHeldItem(handIn);
    	if(!worldIn.isRemote){
    		playerIn.openGui(mod_GVCR2.INSTANCE, 0, 
    				playerIn.world, (int)playerIn.posX, (int)playerIn.posY, (int)playerIn.posZ);
    	}
    	return new ActionResult(EnumActionResult.PASS, itemStackIn);
    }
	
	
}

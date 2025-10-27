package gvcr2.gui.container;
 
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
 
public class GVCR2Slot extends Slot
{
	
	private int id = 0;
	
    public GVCR2Slot(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_)
    {
        super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
        id = p_i1824_2_;
    }
 
    /**
     * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
     */
    public boolean isItemValid(ItemStack stack)
    {
    	boolean idd = !(getHasStack() && getStack().getItem() == Items.EMERALD);
    	if(id == 0) {
    		idd = (!stack.isEmpty() && (stack.getItem() == Items.EMERALD || stack.getItem() == Items.GUNPOWDER));
   		 }
		if (id == 1) {
			idd = (!stack.isEmpty() && stack.getItem() == Items.IRON_INGOT);
		}
		if (id == 2) {
			idd = (!stack.isEmpty() && stack.getItem() == Items.REDSTONE);
		}
        //return TileEntityFurnace.isItemFuel(stack) || isBucket(stack);
    	return idd;
    }
}
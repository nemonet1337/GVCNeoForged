package gvcr2.block.tile;

import gvcr2.mod_GVCR2;
import gvcr2.block.Block_VehicleCrafter;
import gvcr2.gui.container.BlockContainerInventory_VehicleCrafter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntity_VehicleCrafter extends TileEntityCrafterBase implements ITickable, ISidedInventory
{
    /**
     * Like the old updateEntity(), except more generic.
     */
    
	public int facing = 0;
	public int id = 0;
	
    public int sell_id = 0;
    public boolean cansell = false;
    
    public boolean do_sell = false;
    
    public void update()
    {

    	if(this.world.getBlockState(pos).getBlock() instanceof Block_VehicleCrafter) {
    		Block_VehicleCrafter gubcrafter = (Block_VehicleCrafter) this.world.getBlockState(pos).getBlock();
    		EnumFacing enumfacing = (EnumFacing)this.world.getBlockState(pos).getValue(gubcrafter.FACING);
    		if(enumfacing == EnumFacing.SOUTH) {
    			facing = 1;
    		}else if(enumfacing == EnumFacing.WEST) {
    			facing = 2;
    		}else if(enumfacing == EnumFacing.EAST) {
    			facing = 3;
    		}else {
    			facing = 0;
    		}
    	}
    	
    	if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_vehiclecrafter_1){
    		id = 0;
    		ItemStack eme = (ItemStack)this.furnaceItemStacks.get(0);
            ItemStack iron = (ItemStack)this.furnaceItemStacks.get(1);
            ItemStack red = (ItemStack)this.furnaceItemStacks.get(2);
            ItemStack output = (ItemStack)this.furnaceItemStacks.get(3);
            
            if(mod_GVCR2.vehicle_item_1[sell_id] != null) {
            	if(!eme.isEmpty() && eme.getItem() == Items.EMERALD
            			&& !iron.isEmpty() && iron.getItem() == Items.IRON_INGOT
            			&& !red.isEmpty() && red.getItem() == Items.REDSTONE) {
            		if(eme.getCount() >= mod_GVCR2.vehicle_eme_1[sell_id]
            				&& iron.getCount() >= mod_GVCR2.vehicle_iron_1[sell_id]
            						&&red.getCount() >= mod_GVCR2.vehicle_red_1[sell_id]) {
            			if(do_sell) {
            				if(output.isEmpty()){
            					this.furnaceItemStacks.set(3, new ItemStack(mod_GVCR2.vehicle_item_1[sell_id], 1));
            					eme.shrink(mod_GVCR2.vehicle_eme_1[sell_id]);
                				iron.shrink(mod_GVCR2.vehicle_iron_1[sell_id]);
                				red.shrink(mod_GVCR2.vehicle_red_1[sell_id]);
            				}
            				do_sell = false;
            			}
            		}
            	}
            }
    	}
    	
    	if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_vehiclecrafter_2){
    		id = 1;
    		ItemStack eme = (ItemStack)this.furnaceItemStacks.get(0);
            ItemStack iron = (ItemStack)this.furnaceItemStacks.get(1);
            ItemStack red = (ItemStack)this.furnaceItemStacks.get(2);
            ItemStack output = (ItemStack)this.furnaceItemStacks.get(3);
            
            if(mod_GVCR2.vehicle_item_2[sell_id] != null) {
            	if(!eme.isEmpty() && eme.getItem() == Items.EMERALD
            			&& !iron.isEmpty() && iron.getItem() == Items.IRON_INGOT
            			&& !red.isEmpty() && red.getItem() == Items.REDSTONE) {
            		if(eme.getCount() >= mod_GVCR2.vehicle_eme_2[sell_id]
            				&& iron.getCount() >= mod_GVCR2.vehicle_iron_2[sell_id]
            						&&red.getCount() >= mod_GVCR2.vehicle_red_2[sell_id]) {
            			if(do_sell) {
            				if(output.isEmpty()){
            					this.furnaceItemStacks.set(3, new ItemStack(mod_GVCR2.vehicle_item_2[sell_id], 1));
            					eme.shrink(mod_GVCR2.vehicle_eme_2[sell_id]);
                				iron.shrink(mod_GVCR2.vehicle_iron_2[sell_id]);
                				red.shrink(mod_GVCR2.vehicle_red_2[sell_id]);
            				}
            				do_sell = false;
            			}
            		}
            	}
            }
    	}
    	
    	if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_vehiclecrafter_3){
    		id = 2;
    		ItemStack eme = (ItemStack)this.furnaceItemStacks.get(0);
            ItemStack iron = (ItemStack)this.furnaceItemStacks.get(1);
            ItemStack red = (ItemStack)this.furnaceItemStacks.get(2);
            ItemStack output = (ItemStack)this.furnaceItemStacks.get(3);
            
            if(mod_GVCR2.vehicle_item_3[sell_id] != null) {
            	if(!eme.isEmpty() && eme.getItem() == Items.EMERALD
            			&& !iron.isEmpty() && iron.getItem() == Items.IRON_INGOT
            			&& !red.isEmpty() && red.getItem() == Items.REDSTONE) {
            		if(eme.getCount() >= mod_GVCR2.vehicle_eme_3[sell_id]
            				&& iron.getCount() >= mod_GVCR2.vehicle_iron_3[sell_id]
            						&&red.getCount() >= mod_GVCR2.vehicle_red_3[sell_id]) {
            			if(do_sell) {
            				if(output.isEmpty()){
            					this.furnaceItemStacks.set(3, new ItemStack(mod_GVCR2.vehicle_item_3[sell_id], 1));
            					eme.shrink(mod_GVCR2.vehicle_eme_3[sell_id]);
                				iron.shrink(mod_GVCR2.vehicle_iron_3[sell_id]);
                				red.shrink(mod_GVCR2.vehicle_red_3[sell_id]);
            				}
            				do_sell = false;
            			}
            		}
            	}
            }
    	}
    	
    	//System.out.println(String.format("%1$3d", sell_id));
    	//System.out.println(String.format("%1$3d", mod_GVCR2.vehicle_id_1));
    	/*if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_vehiclecrafter_1){
    		id = 0;
    		ItemStack eme = (ItemStack)this.furnaceItemStacks.get(0);
            ItemStack iron = (ItemStack)this.furnaceItemStacks.get(1);
            ItemStack red = (ItemStack)this.furnaceItemStacks.get(2);
            ItemStack output = (ItemStack)this.furnaceItemStacks.get(3);
            
            if(mod_GVCR2.vehicle_item_1[sell_id] != null) {
            	if(!eme.isEmpty() && eme.getItem() == Items.EMERALD
            			&& !iron.isEmpty() && iron.getItem() == Items.IRON_INGOT
            			&& !red.isEmpty() && red.getItem() == Items.REDSTONE) {
            		if(eme.getCount() >= mod_GVCR2.vehicle_eme_1[sell_id]
            				&& iron.getCount() >= mod_GVCR2.vehicle_iron_1[sell_id]
            						&&red.getCount() >= mod_GVCR2.vehicle_red_1[sell_id]) {
            			if(this.furnaceItemStacks.get(3).isEmpty() && cansell) {
            				eme.shrink(mod_GVCR2.vehicle_eme_1[sell_id]);
            				iron.shrink(mod_GVCR2.vehicle_iron_1[sell_id]);
            				red.shrink(mod_GVCR2.vehicle_red_1[sell_id]);
            				cansell = false;
            			}else {
            				this.furnaceItemStacks.set(3, new ItemStack(mod_GVCR2.vehicle_item_1[sell_id], 1));
            				cansell = true;
            			}
            		}else {
            			this.furnaceItemStacks.set(3, output.EMPTY);
            		}
            	}else {
            		this.furnaceItemStacks.set(3, output.EMPTY);
            		cansell = false;
            	}
            }
    	}
    	
    	if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_vehiclecrafter_2){
    		id = 1;
    		ItemStack eme = (ItemStack)this.furnaceItemStacks.get(0);
            ItemStack iron = (ItemStack)this.furnaceItemStacks.get(1);
            ItemStack red = (ItemStack)this.furnaceItemStacks.get(2);
            ItemStack output = (ItemStack)this.furnaceItemStacks.get(3);
            
            if(mod_GVCR2.vehicle_item_2[sell_id] != null) {
            	if(!eme.isEmpty() && eme.getItem() == Items.EMERALD
            			&& !iron.isEmpty() && iron.getItem() == Items.IRON_INGOT
            			&& !red.isEmpty() && red.getItem() == Items.REDSTONE) {
            		if(eme.getCount() >= mod_GVCR2.vehicle_eme_2[sell_id]
            				&& iron.getCount() >= mod_GVCR2.vehicle_iron_2[sell_id]
            						&&red.getCount() >= mod_GVCR2.vehicle_red_2[sell_id]) {
            			if(this.furnaceItemStacks.get(3).isEmpty() && cansell) {
            				eme.shrink(mod_GVCR2.vehicle_eme_2[sell_id]);
            				iron.shrink(mod_GVCR2.vehicle_iron_2[sell_id]);
            				red.shrink(mod_GVCR2.vehicle_red_2[sell_id]);
            				cansell = false;
            			}else {
            				this.furnaceItemStacks.set(3, new ItemStack(mod_GVCR2.vehicle_item_2[sell_id], 1));
            				cansell = true;
            			}
            		}else {
            			this.furnaceItemStacks.set(3, output.EMPTY);
            		}
            	}else {
            		this.furnaceItemStacks.set(3, output.EMPTY);
            		cansell = false;
            	}
            }
    	}
    	
    	if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_vehiclecrafter_3){
    		id = 2;
    		ItemStack eme = (ItemStack)this.furnaceItemStacks.get(0);
            ItemStack iron = (ItemStack)this.furnaceItemStacks.get(1);
            ItemStack red = (ItemStack)this.furnaceItemStacks.get(2);
            ItemStack output = (ItemStack)this.furnaceItemStacks.get(3);
            
            if(mod_GVCR2.vehicle_item_3[sell_id] != null) {
            	if(!eme.isEmpty() && eme.getItem() == Items.EMERALD
            			&& !iron.isEmpty() && iron.getItem() == Items.IRON_INGOT
            			&& !red.isEmpty() && red.getItem() == Items.REDSTONE) {
            		if(eme.getCount() >= mod_GVCR2.vehicle_eme_3[sell_id]
            				&& iron.getCount() >= mod_GVCR2.vehicle_iron_3[sell_id]
            						&&red.getCount() >= mod_GVCR2.vehicle_red_3[sell_id]) {
            			if(this.furnaceItemStacks.get(3).isEmpty() && cansell) {
            				eme.shrink(mod_GVCR2.vehicle_eme_3[sell_id]);
            				iron.shrink(mod_GVCR2.vehicle_iron_3[sell_id]);
            				red.shrink(mod_GVCR2.vehicle_red_3[sell_id]);
            				cansell = false;
            			}else {
            				this.furnaceItemStacks.set(3, new ItemStack(mod_GVCR2.vehicle_item_3[sell_id], 1));
            				cansell = true;
            			}
            		}else {
            			this.furnaceItemStacks.set(3, output.EMPTY);
            		}
            	}else {
            		this.furnaceItemStacks.set(3, output.EMPTY);
            		cansell = false;
            	}
            }
    	}*/
    	
    }


    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new BlockContainerInventory_VehicleCrafter(playerInventory, this, this);
    }
}
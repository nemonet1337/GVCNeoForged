package gvcr2.block.tile;

import gvcr2.mod_GVCR2;
import gvcr2.block.Block_BulletCrafter;
import gvcr2.gui.container.BlockContainerInventory_BulletCrafter;
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

public class TileEntity_BulletCrafter extends TileEntityCrafterBase implements ITickable, ISidedInventory
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

    	if(this.world.getBlockState(pos).getBlock() instanceof Block_BulletCrafter) {
    		Block_BulletCrafter gubcrafter = (Block_BulletCrafter) this.world.getBlockState(pos).getBlock();
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
    	
    	
    	if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_bulletcrafter_1){
    		id = 0;
    		ItemStack eme = (ItemStack)this.furnaceItemStacks.get(0);
            ItemStack iron = (ItemStack)this.furnaceItemStacks.get(1);
            ItemStack output = (ItemStack)this.furnaceItemStacks.get(3);
            
            
            if(mod_GVCR2.bullet_item_1[sell_id] != null) {
            	if(!eme.isEmpty() && eme.getItem() == Items.GUNPOWDER
            			&& !iron.isEmpty() && iron.getItem() == Items.IRON_INGOT) {
            		if(eme.getCount() >= mod_GVCR2.bullet_eme_1[sell_id]
            				&& iron.getCount() >= mod_GVCR2.bullet_iron_1[sell_id]) {
            			if(do_sell) {
            				if(!output.isEmpty() && output.getItem() == mod_GVCR2.bullet_item_1[sell_id]) {
            					if(output.getCount() <= 64 - mod_GVCR2.bullet_kazu_1[sell_id]) {
            						this.furnaceItemStacks.set(3, new ItemStack(mod_GVCR2.bullet_item_1[sell_id], mod_GVCR2.bullet_kazu_1[sell_id] + output.getCount()));
            						eme.shrink(mod_GVCR2.bullet_eme_1[sell_id]);
                    				iron.shrink(mod_GVCR2.bullet_iron_1[sell_id]);
            					}
            				}else {
            					this.furnaceItemStacks.set(3, new ItemStack(mod_GVCR2.bullet_item_1[sell_id], mod_GVCR2.bullet_kazu_1[sell_id]));
                				eme.shrink(mod_GVCR2.bullet_eme_1[sell_id]);
                				iron.shrink(mod_GVCR2.bullet_iron_1[sell_id]);
            				}
            				do_sell = false;
            			}
            			/*if(this.furnaceItemStacks.get(3).isEmpty() && cansell) {
            				eme.shrink(mod_GVCR2.bullet_eme_1[sell_id]);
            				iron.shrink(mod_GVCR2.bullet_iron_1[sell_id]);
            				cansell = false;
            			}else {
            				
            				cansell = true;
            			}*/
            		}else {
            			//this.furnaceItemStacks.set(3, output.EMPTY);
            		}
            	}else {
            		//this.furnaceItemStacks.set(3, output.EMPTY);
            		//cansell = false;
            	}
            }
    	}
    	
    	//System.out.println(String.format("%1$3d", sell_id));
    	//System.out.println(String.format("%1$3d", mod_GVCR2.Bullet_id_1));
    	/*if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_bulletcrafter_1){
    		id = 0;
    		ItemStack eme = (ItemStack)this.furnaceItemStacks.get(0);
            ItemStack iron = (ItemStack)this.furnaceItemStacks.get(1);
            ItemStack output = (ItemStack)this.furnaceItemStacks.get(3);
            
            if(mod_GVCR2.bullet_item_1[sell_id] != null) {
            	if(!eme.isEmpty() && eme.getItem() == Items.GUNPOWDER
            			&& !iron.isEmpty() && iron.getItem() == Items.IRON_INGOT) {
            		if(eme.getCount() >= mod_GVCR2.bullet_eme_1[sell_id]
            				&& iron.getCount() >= mod_GVCR2.bullet_iron_1[sell_id]) {
            			if(this.furnaceItemStacks.get(3).isEmpty() && cansell) {
            				eme.shrink(mod_GVCR2.bullet_eme_1[sell_id]);
            				iron.shrink(mod_GVCR2.bullet_iron_1[sell_id]);
            				cansell = false;
            			}else {
            				this.furnaceItemStacks.set(3, new ItemStack(mod_GVCR2.bullet_item_1[sell_id], mod_GVCR2.bullet_kazu_1[sell_id]));
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
        return new BlockContainerInventory_BulletCrafter(playerInventory, this, this);
    }
}
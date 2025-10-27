package gvcr2.block.tile;

import gvcr2.mod_GVCR2;
import gvcr2.block.Block_GunRack;
import gvcr2.gui.container.BlockContainerInventory_GunRack;
import gvcr2.network.GVCR2ClientMessageKeyPressed;
import gvcr2.network.GVCR2PacketHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
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
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntity_GunRack extends TileEntityLockable implements ITickable, ISidedInventory
{
    private static final int[] SLOTS_TOP = new int[] {0};
    private static final int[] SLOTS_BOTTOM = new int[] {2, 1};
    private static final int[] SLOTS_SIDES = new int[] {1};
    /** The ItemStacks that hold the items currently being used in the furnace */
    public NonNullList<ItemStack> furnaceItemStacks = NonNullList.<ItemStack>withSize(8, ItemStack.EMPTY);
    /** The number of ticks that the furnace will keep burning */
    private int furnaceBurnTime;
    /** The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for */
    private int currentItemBurnTime;
    private int cookTime;
    private int totalCookTime;
    private String furnaceCustomName;
    
    public static boolean cancraft;
    public static int crafttime;
    public int facing = 0;
    
    public int houkou = 10;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.furnaceItemStacks.size();
    }

    public boolean isEmpty()
    {
        for (ItemStack itemstack : this.furnaceItemStacks)
        {
            if (!itemstack.isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns the stack in the given slot.
     */
    public ItemStack getStackInSlot(int index)
    {
        return this.furnaceItemStacks.get(index);
    }

    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
     */
    public ItemStack decrStackSize(int index, int count)
    {
        return ItemStackHelper.getAndSplit(this.furnaceItemStacks, index, count);
    }

    /**
     * Removes a stack from the given slot and returns it.
     */
    public ItemStack removeStackFromSlot(int index)
    {
        return ItemStackHelper.getAndRemove(this.furnaceItemStacks, index);
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        ItemStack itemstack = this.furnaceItemStacks.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.furnaceItemStacks.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit())
        {
            stack.setCount(this.getInventoryStackLimit());
        }

        if (index == 0 && !flag)
        {
            this.totalCookTime = this.getCookTime(stack);
            this.cookTime = 0;
            this.markDirty();
        }
    }

    /**
     * Get the name of this object. For players this returns their username
     */
    public String getName()
    {
        //return this.hasCustomName() ? this.furnaceCustomName : "container.furnace";
    	return this.hasCustomName() ? this.furnaceCustomName : "Crafting Machine";
    }

    /**
     * Returns true if this thing is named
     */
    public boolean hasCustomName()
    {
        return this.furnaceCustomName != null && !this.furnaceCustomName.isEmpty();
    }

    public void setCustomInventoryName(String p_145951_1_)
    {
        this.furnaceCustomName = p_145951_1_;
    }

    public static void registerFixesFurnace(DataFixer fixer)
    {
        fixer.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntity_GunRack.class, new String[] {"Items"}));
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.furnaceItemStacks = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.furnaceItemStacks);
        this.furnaceBurnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("CookTimeTotal");
       // this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks.get(1));

        this.cancraft = compound.getBoolean("cancraft");
        this.crafttime = compound.getInteger("crafttime");
        
        this.houkou = compound.getInteger("houkou");
        
        if (compound.hasKey("CustomName", 8))
        {
            this.furnaceCustomName = compound.getString("CustomName");
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        //compound.setInteger("BurnTime", (short)this.furnaceBurnTime);
        compound.setInteger("CookTime", (short)this.cookTime);
        compound.setInteger("CookTimeTotal", (short)this.totalCookTime);
        ItemStackHelper.saveAllItems(compound, this.furnaceItemStacks);

        compound.setBoolean("cancraft", this.cancraft);
        compound.setInteger("crafttime", this.crafttime);
        
        compound.setInteger("houkou", this.houkou);
        
        if (this.hasCustomName())
        {
            compound.setString("CustomName", this.furnaceCustomName);
        }

        return compound;
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended.
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Furnace isBurning
     */
    public boolean isBurning()
    {
        return this.furnaceBurnTime > 0;
    }

    @SideOnly(Side.CLIENT)
    public static boolean isBurning(IInventory inventory)
    {
        return inventory.getField(0) > 0;
    }

    /**
     * Like the old updateEntity(), except more generic.
     */
    
    public int id = 0;
    @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared()
    {
    	return 4096.0D;//return 65536.0D;
    }
    
    public int sell_id = 0;
    public boolean cansell = false;
    
    
    public boolean clientgetter = false;
    public void update()
    {
    	/*if(this.world.getBlockState(this.pos).getBlock() != null && this.world.getBlockState(this.pos).getBlock() instanceof Block_Handing2) {
    		Block_Handing2 tileblock = (Block_Handing2) this.world.getBlockState(this.pos).getBlock();
    		EnumFacing facing = (EnumFacing)this.world.getBlockState(this.pos).getValue(tileblock.FACING);
    		if(facing == EnumFacing.SOUTH) {
    			this.houkou = 1;
    		}
    		else if(facing == EnumFacing.EAST) {
    			this.houkou = 2;
    		}
    		else if(facing == EnumFacing.WEST) {
    			this.houkou = 3;
    		}else {
    			this.houkou = 0;
    		}
    	}*/
    	if(this.world.getBlockState(pos).getBlock() instanceof Block_GunRack) {
    		Block_GunRack gubcrafter = (Block_GunRack) this.world.getBlockState(pos).getBlock();
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
    	
    	
    	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_gunrack_rsin) {
        	id = 1;
        }
        else if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_gunrack_rswn) {
        	id = 2;
        }
        else if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_gunrack_hti) {
        	id = 3;
        }
        else if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_gunrack_rti1) {
        	id = 4;
        }
        else if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_gunrack_rti2) {
        	id = 5;
        }
        else {
        	id = 0;
        }
    	
    	if(!this.world.isRemote) {
    		if(!this.furnaceItemStacks.get(0).isEmpty()) {
    			Item item = this.furnaceItemStacks.get(0).getItem();
    			if(FMLCommonHandler.instance().getMinecraftServerInstance() != null) {
    				for (EntityPlayerMP playermp : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers()) {
    					GVCR2PacketHandler.INSTANCE2.sendTo(new GVCR2ClientMessageKeyPressed(3, 
    	    					this.getPos().getX(), this.getPos().getY(), this.getPos().getZ()
    	    					,item.getIdFromItem(item), true), playermp);
    				}
    			}
    		}
    		if(!this.furnaceItemStacks.get(1).isEmpty()) {
    			Item item = this.furnaceItemStacks.get(1).getItem();
    			if(FMLCommonHandler.instance().getMinecraftServerInstance() != null) {
    				for (EntityPlayerMP playermp : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers()) {
    					GVCR2PacketHandler.INSTANCE2.sendTo(new GVCR2ClientMessageKeyPressed(4, 
    	    					this.getPos().getX(), this.getPos().getY(), this.getPos().getZ()
    	    					,item.getIdFromItem(item), true), playermp);
    				}
    			}
    		}
    		if(!this.furnaceItemStacks.get(2).isEmpty()) {
    			Item item = this.furnaceItemStacks.get(2).getItem();
    			if(FMLCommonHandler.instance().getMinecraftServerInstance() != null) {
    				for (EntityPlayerMP playermp : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers()) {
    					GVCR2PacketHandler.INSTANCE2.sendTo(new GVCR2ClientMessageKeyPressed(5, 
    	    					this.getPos().getX(), this.getPos().getY(), this.getPos().getZ()
    	    					,item.getIdFromItem(item), true), playermp);
    				}
    			}
    		}
    		clientgetter = true;
    	}
    }

    
    
    public int getCookTime(ItemStack stack)
    {
        return 200;
    }

    

    /**
     * Don't rename this method to canInteractWith due to conflicts with Container
     */
    public boolean isUsableByPlayer(EntityPlayer player)
    {
        if (this.world.getTileEntity(this.pos) != this)
        {
            return false;
        }
        else
        {
            return player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    public void openInventory(EntityPlayer player)
    {
    }

    public void closeInventory(EntityPlayer player)
    {
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot. For
     * guis use Slot.isItemValid
     */
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        if (index == 2)
        {
            return false;
        }
        else if (index != 1)
        {
            return true;
        }
        else
        {
            ItemStack itemstack = this.furnaceItemStacks.get(1);
            //return isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack) && itemstack.getItem() != Items.BUCKET;
            return false;
        }
    }

    public int[] getSlotsForFace(EnumFacing side)
    {
        if (side == EnumFacing.DOWN)
        {
            return SLOTS_BOTTOM;
        }
        else
        {
            return side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES;
        }
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side.
     */
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
    {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side.
     */
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
    {
        if (direction == EnumFacing.DOWN && index == 1)
        {
            Item item = stack.getItem();

            if (item != Items.WATER_BUCKET && item != Items.BUCKET)
            {
                return false;
            }
        }

        return true;
    }

    public String getGuiID()
    {
        return "minecraft:furnace";
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new BlockContainerInventory_GunRack(playerInventory, this);
    }

    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.furnaceBurnTime;
            case 1:
                return this.currentItemBurnTime;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }
    }

    public void setField(int id, int value)
    {
        switch (id)
        {
            case 0:
                this.furnaceBurnTime = value;
                break;
            case 1:
                this.currentItemBurnTime = value;
                break;
            case 2:
                this.cookTime = value;
                break;
            case 3:
                this.totalCookTime = value;
        }
    }

    public int getFieldCount()
    {
        return 4;
    }

    public void clear()
    {
        this.furnaceItemStacks.clear();
    }
}
package gvcr2.gui;

import gvcr2.block.tile.TileEntity_BulletCrafter;
import gvcr2.block.tile.TileEntity_GunCrafter;
import gvcr2.block.tile.TileEntity_GunRack;
import gvcr2.block.tile.TileEntity_VehicleCrafter;
import gvcr2.gui.container.BlockContainerInventory_BulletCrafter;
import gvcr2.gui.container.BlockContainerInventory_GunCrafter;
import gvcr2.gui.container.BlockContainerInventory_GunRack;
import gvcr2.gui.container.BlockContainerInventory_VehicleCrafter;
import gvcr2.gui.container.GVCR2Container_Pad;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GVCR2GuiHandler implements IGuiHandler {
	/*
	 * ServerでGUIが開かれたときに呼ばれる 通常はContainerを生成する。
	 */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		ItemStack itemstack = player.getHeldItemMainhand();
        if(ID == 0){
            return new GVCR2Container_Pad(player.inventory, itemstack);
        }
        if (ID == 1) {
			TileEntity tileentity = player.world.getTileEntity(pos);
			if (!world.isBlockLoaded(pos)) {
				return null;
			}else
            if (tileentity instanceof TileEntity_GunCrafter)
            {
            	return new BlockContainerInventory_GunCrafter(player.inventory, (TileEntity_GunCrafter)tileentity, (TileEntity_GunCrafter)tileentity);
            }
		}
        if (ID == 2) {
			TileEntity tileentity = player.world.getTileEntity(pos);
			if (!world.isBlockLoaded(pos)) {
				return null;
			}else
            if (tileentity instanceof TileEntity_VehicleCrafter)
            {
            	return new BlockContainerInventory_VehicleCrafter(player.inventory, (TileEntity_VehicleCrafter)tileentity, (TileEntity_VehicleCrafter) tileentity);
            }
		}
        if (ID == 3) {
			TileEntity tileentity = player.world.getTileEntity(pos);
			if (!world.isBlockLoaded(pos)) {
				return null;
			}else
            if (tileentity instanceof TileEntity_BulletCrafter)
            {
            	return new BlockContainerInventory_BulletCrafter(player.inventory, (TileEntity_BulletCrafter)tileentity, (TileEntity_BulletCrafter)tileentity);
            }
		}
        
        if (ID == 4) {
			TileEntity tileentity = player.world.getTileEntity(pos);
			if (!world.isBlockLoaded(pos)) {
				return null;
			}else
            if (tileentity instanceof TileEntity_GunRack)
            {
            	return new BlockContainerInventory_GunRack(player.inventory, (TileEntity_GunRack)tileentity);
            }
		}
		return null;
	}

	/*
	 * ClientでGUIが開かれたときに呼ばれる 通常はGUIを生成する
	 */
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		ItemStack itemstack = player.getHeldItemMainhand();
        if(ID == 0){
            return new GVCR2Gui_Pad(player.inventory, itemstack);
        }
        if (ID == 1) {
			TileEntity tileentity = player.world.getTileEntity(pos);
			if (!world.isBlockLoaded(pos)) {
				return null;
			}else
            if (tileentity instanceof TileEntity_GunCrafter)
            {
            	return new BlockGuiInventory_GunCrafter(player.inventory, (TileEntity_GunCrafter)tileentity, (TileEntity_GunCrafter)tileentity);
            }
		}
        if (ID == 2) {
			TileEntity tileentity = player.world.getTileEntity(pos);
			if (!world.isBlockLoaded(pos)) {
				return null;
			}else
            if (tileentity instanceof TileEntity_VehicleCrafter)
            {
            	return new BlockGuiInventory_VehicleCrafter(player.inventory, (TileEntity_VehicleCrafter)tileentity, (TileEntity_VehicleCrafter)tileentity);
            }
		}
        if (ID == 3) {
			TileEntity tileentity = player.world.getTileEntity(pos);
			if (!world.isBlockLoaded(pos)) {
				return null;
			}else
            if (tileentity instanceof TileEntity_BulletCrafter)
            {
            	return new BlockGuiInventory_BulletCrafter(player.inventory, (TileEntity_BulletCrafter)tileentity, (TileEntity_BulletCrafter)tileentity);
            }
		}
        
        if (ID == 4) {
			TileEntity tileentity = player.world.getTileEntity(pos);
			if (!world.isBlockLoaded(pos)) {
				return null;
			}else
            if (tileentity instanceof TileEntity_GunRack)
            {
            	return new BlockGuiInventory_GunRack(player.inventory, (TileEntity_GunRack)tileentity, (TileEntity_GunRack)tileentity);
            }
		}
		return null;
	}
}
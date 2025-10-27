package gvcr2.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public class GVCR2Container_Pad extends Container {
    //座標でGUIを開くか判定するためのもの。
   /* int xCoord, yCoord, zCoord;
    public GVCR2Container_Pad(int x, int y, int z) {
        this.xCoord = x;
        this.yCoord = y;
        this.zCoord = z;
    }*/

    public GVCR2Container_Pad(InventoryPlayer inventory, ItemStack stack) {
    	
    	
    }

    
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        //もし、ブロックとの位置関係でGUI制御したいなら、こちらを使う
//        return player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64D;
        return true;
    }
}
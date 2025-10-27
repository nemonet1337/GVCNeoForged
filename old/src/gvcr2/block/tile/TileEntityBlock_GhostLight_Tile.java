package gvcr2.block.tile;

import java.util.List;

import gvclib.entity.living.ISoldier;
import gvclib.item.ItemWrench;
import gvcr2.mod_GVCR2;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityBlock_GhostLight_Tile extends TileEntity implements ITickable
{
	public int count = 0;
	
   @Override
	public void update() {
   	Block block = this.world.getBlockState(this.pos).getBlock();
   	
   	int x = this.pos.getX();
    int y= this.pos.getY();
    int z = this.pos.getZ();
   	
    if(getPlayer(x, y, z, 16)) {
    	count = 0;
    }
    
   	++count;
   	
   	if(count > 20) {
   		this.world.setBlockState(this.getPos(), mod_GVCR2.gvcr2_block_ghostlight.getDefaultState(), 2);
   	}
   	
   }
   
   
   public boolean getPlayer(double x, double y, double z, int han) {
   	boolean spawn = false;
   	Entity entity = null;
   	int mobkazu = 0;
   	int mobkazu2 = 0;
   	{
   		AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(x-han), (double)(y-han), (double)(z-han), (double)(x + han), (double)(y + han), (double)(z+ han)))
           		.grow(1);
           List llist2 = this.world.getEntitiesWithinAABBExcludingEntity(entity, axisalignedbb2);
           if(llist2!=null){
               for (int lj = 0; lj < llist2.size(); lj++) {
               	
               	Entity entity1 = (Entity)llist2.get(lj);
               	if (entity1.canBeCollidedWith())
                   {
               		if (entity1 != null && entity1 instanceof EntityPlayer) {
               			EntityPlayer player = (EntityPlayer) entity1;
               			ItemStack itemstack = player.getHeldItemMainhand();
                		if (!itemstack.isEmpty() && itemstack.getItem() instanceof ItemWrench) {
                			spawn = true;
                   			break;
                		}
   					}
                   }
               }
           }
   	}
   	return spawn;
   }
}
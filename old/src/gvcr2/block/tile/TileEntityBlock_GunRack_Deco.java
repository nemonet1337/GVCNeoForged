package gvcr2.block.tile;
 
import gvcr2.mod_GVCR2;
import gvcr2.block.Block_BulletCrafter;
import gvcr2.block.Block_GunRack_Deco;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
 
public class TileEntityBlock_GunRack_Deco extends TileEntity implements ITickable
{
	public int facing = 0;
	
	public int id = 0;
    
	@SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared()
    {
		return 4096.0D;//return 65536.0D;
    }
	
    @Override
	public void update() {
    	Block block = this.world.getBlockState(this.pos).getBlock();
        
        int x = this.pos.getX();
        int y= this.pos.getY();
        int z = this.pos.getZ();
        if(this.world.getBlockState(pos).getBlock() instanceof Block_GunRack_Deco) {
        	Block_GunRack_Deco gubcrafter = (Block_GunRack_Deco) this.world.getBlockState(pos).getBlock();
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
        if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_gunrack_rsin_deco) {
        	this.id = 1;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_gunrack_rswn_deco) {
        	this.id = 2;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_gunrack_hti_deco) {
        	this.id = 3;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_gunrack_rti1_deco) {
        	this.id = 4;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_gunrack_rti2_deco) {
        	this.id = 5;
        }
        else {
        	this.id = 0;
        }
	}
	
}
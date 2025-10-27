package gvcr2.block.tile;
 
import gvcr2.mod_GVCR2;
import gvcr2.block.Block_GVC_DecoFacingBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
 
public class TileEntity_GVC_DecoFacingBlock extends TileEntity implements ITickable
{
	public int facing = 0;
	
	public int id = 0;
    
	@SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared()
    {
		double range = 16384.0D;
		if(this.world.getBlockState(pos).getBlock() instanceof Block_GVC_DecoFacingBlock) {
        	Block_GVC_DecoFacingBlock gubcrafter = (Block_GVC_DecoFacingBlock) this.world.getBlockState(pos).getBlock();
        	EntityPlayer player = mod_GVCR2.proxy.getEntityPlayerInstance();
        	if(!gubcrafter.aabb) {
        		if(player.isSneaking()) {
        			range = 4096.0D;
        		}else {
        			range = 1024.0D;
        		}
        	}
		}
        return range;//return 65536.0D;
    }
	
    @Override
	public void update() {
    	Block block = this.world.getBlockState(this.pos).getBlock();
        
        int x = this.pos.getX();
        int y= this.pos.getY();
        int z = this.pos.getZ();
        if(this.world.getBlockState(pos).getBlock() instanceof Block_GVC_DecoFacingBlock) {
        	Block_GVC_DecoFacingBlock gubcrafter = (Block_GVC_DecoFacingBlock) this.world.getBlockState(pos).getBlock();
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
    		this.id = gubcrafter.id;
    	}
        /*if(this.world.getBlockState(pos).getBlock() == mod_GirlFront.b_block_laptop_df) {
        	this.id = 0;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GirlFront.b_block_monitor1_df) {
        	this.id = 1;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GirlFront.b_block_sincgars_df) {
        	this.id = 2;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GirlFront.b_block_toughbook_df) {
        	this.id = 3;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GirlFront.b_block_9mmpack_df) {
        	this.id = 4;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GirlFront.b_block_12gpack_df) {
        	this.id = 5;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GirlFront.b_block_556pack_df) {
        	this.id = 6;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GirlFront.b_block_collapse_bombe) {
        	this.id = 7;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GirlFront.b_block_epiphyllum1) {
        	this.id = 8;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GirlFront.b_block_epiphyllum2) {
        	this.id = 9;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GirlFront.b_block_jutebag_df) {
        	this.id = 10;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GirlFront.b_block_medbag_df) {
        	this.id = 11;
        }*/
        
        /*else {
        	this.id = 0;
        }*/
	}
	
}
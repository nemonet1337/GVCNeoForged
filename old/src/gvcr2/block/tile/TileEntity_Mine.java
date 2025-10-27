package gvcr2.block.tile;
 
import gvcr2.mod_GVCR2;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
 
public class TileEntity_Mine extends TileEntity implements ITickable
{
	public boolean spawn = false;
	
	public int count = 0;
	
	public int id = 0;
    
	@SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared()
    {
        return 65536.0D;
    }
	
    @Override
	public void update() {
    	Block block = this.world.getBlockState(this.pos).getBlock();
        
        int x = this.pos.getX();
        int y= this.pos.getY();
        int z = this.pos.getZ();
        if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_atmine) {
        	this.id = 1;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_ied) {
        	this.id = 2;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_bomb) {
        	this.id = 3;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_water_mine) {
        	this.id = 4;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_propane) {
        	this.id = 5;
        }
       /* else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_ammobox1) {
        	this.id = 6;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_artibox1) {
        	this.id = 7;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_artibox2) {
        	this.id = 8;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_artibox3) {
        	this.id = 9;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_barrel_drum1) {
        	this.id = 10;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_barrel_drum2) {
        	this.id = 11;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_barrel_drum3) {
        	this.id = 12;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_Jerrycan1) {
        	this.id = 13;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_missile_rack1) {
        	this.id = 14;
        }*/
        
        
        
        else {
        	this.id = 0;
        }
	}
	
}
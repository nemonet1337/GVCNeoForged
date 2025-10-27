package gvcr2.entity.vehicle;

import gvclib.entity.living.EntityMobVehicleBase;
import gvcr2.mod_GVCR2;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockLilyPad;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class VehicleBase {

	
	public static void roadattack_barbed(EntityMobVehicleBase vehicle) {
		if(!vehicle.world.isRemote && vehicle.roodbreak){
    		AxisAlignedBB axisalignedbb = vehicle.getEntityBoundingBox();
    		double xx = vehicle.width;
        		for(double x = 0; x < vehicle.width*2; ++x) {
        			for(double y = -1; y < vehicle.height*1.2; ++y) {
        				for(double z = 0; z < vehicle.width*2; ++z) {
        					BlockPos pos = new BlockPos(vehicle.posX -xx + x, vehicle.posY + y, vehicle.posZ - xx + z);
        					if(vehicle.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_barbed1_gc
        						|| vehicle.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_barbed2_gc
        						//|| vehicle.world.getBlockState(pos).getBlock() instanceof BlockGrass	
        							) 
        					{
        						IBlockState iblockstate = vehicle.world.getBlockState(pos);
        		                Block block = iblockstate.getBlock();
        		                if (iblockstate.getMaterial() != Material.AIR)
        		                {
        		                    block.dropBlockAsItemWithChance(vehicle.world, pos, vehicle.world.getBlockState(pos), 1.0F, 0);
        		                    vehicle.world.setBlockToAir(pos);
        		                }
        					}
        				}
        			}
        		}
    	}
	}
}

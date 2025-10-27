package gvcr2.world;

import java.util.Random;

import gvcr2.mod_GVCR2;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldBlockStructure extends WorldGenerator {

	public boolean flag = false;
	public Block block;
	public int id;

	public WorldBlockStructure(int bl) {
		//this.flag = flag;
		this.id = bl;
	}

	@Override
	public boolean generate(World par1World, Random rand, BlockPos pos) {

		int par1 = pos.getX();
		int par2 = pos.getY();
		int par3 = pos.getZ();

		/*if (par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() == Blocks.GRASS
				|| par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() == Blocks.SAND
				|| par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() == Blocks.WATER
				|| par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() == Blocks.NETHERRACK
				|| par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() == Blocks.END_STONE
				|| par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() == Blocks.TALLGRASS) */
		/*if (par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() != Blocks.AIR
				&& par1World.getBlockState(new BlockPos(par1, par2 + 1, par3)).getBlock() == Blocks.AIR
				&& !(par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() instanceof BlockLeaves))*/
		if (par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() != Blocks.AIR
			&& par1World.getBlockState(new BlockPos(par1, par2 + 1, par3)).getBlock() == Blocks.AIR
			&& !(par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() instanceof BlockLeaves))
		{
			if (id == 0) {
				if (par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() != Blocks.WATER)
				{
					int dd = rand.nextInt(6);
					if (dd == 0) {
						par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
						mod_GVCR2.gvcr2_block_ied.getDefaultState(), 2);
					}
					else if (dd == 1) {
						par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
						mod_GVCR2.gvcr2_block_supplies_1.getDefaultState(), 2);
					}
					else if (dd == 2) {
						par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
						mod_GVCR2.gvcr2_block_supplies_2.getDefaultState(), 2);
					}
					else if (dd == 3) {
						par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
						mod_GVCR2.gvcr2_block_supplies_3.getDefaultState(), 2);
					}
					else if (dd == 4) {
						par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
						mod_GVCR2.gvcr2_block_bomb.getDefaultState(), 2);
					}
					else{
						par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
								mod_GVCR2.gvcr2_block_supplies_scrap.getDefaultState(), 2);
					}
				}
			}
			else if (id== 1) {
				if (par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() == Blocks.WATER
						 && par1World.getBlockState(new BlockPos(par1, par2 - 2, par3)).getBlock() == Blocks.WATER
						 && par1World.getBlockState(new BlockPos(par1, par2 - 3, par3)).getBlock() == Blocks.WATER
						 && par1World.getBlockState(new BlockPos(par1, par2 - 4, par3)).getBlock() == Blocks.WATER)
				{
					int dd = rand.nextInt(6);
					if (dd == 0 && mod_GVCR2.cfg_building_huge_dungeon) {
						par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0 , par3 + 0),
								mod_GVCR2.gvcr2_block_bouy.getDefaultState(), 2);
					}else {
						par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0 , par3 + 0),
								mod_GVCR2.gvcr2_block_water_mine.getDefaultState(), 2);
					}
				}
			}
		}
		return true;

	}
}
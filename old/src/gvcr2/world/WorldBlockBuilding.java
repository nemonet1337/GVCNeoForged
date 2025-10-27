package gvcr2.world;

import java.util.Random;

import gvcr2.mod_GVCR2;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldBlockBuilding extends WorldGenerator {

	public boolean flag = false;
	public Block block;
	public int id;

	public WorldBlockBuilding(int bl) {
		//this.flag = flag;
		this.id = bl;
	}

	@Override
	public boolean generate(World par1World, Random rand, BlockPos pos) {

		int par1 = pos.getX();
		int par2 = pos.getY();
		int par3 = pos.getZ();

		if (id == 100) {
			//for(int y = 0; y < 64; ++y) 
			{
				//if (par1World.getBlockState(new BlockPos(par1, par2 + y, par3)).getBlock() == Blocks.AIR) 
				{
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_supplies_air.getDefaultState(), 2);
					//break;
				}
			}
		}
		
		/*if (par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() == Blocks.GRASS
				|| par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() == Blocks.SAND
				|| par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() == Blocks.WATER
				|| par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() == Blocks.NETHERRACK
				|| par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() == Blocks.END_STONE
				|| par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() == Blocks.TALLGRASS)*/
		/*if (par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() != Blocks.AIR
				&& par1World.getBlockState(new BlockPos(par1, par2 + 1, par3)).getBlock() == Blocks.AIR
				&& !(par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() instanceof BlockLeaves))*/
		
		if(par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() instanceof BlockLeaves) {
			par2 = par2 - getground(par1World, rand, pos);
		}
		
		
		/*if (par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() != Blocks.AIR
				&& (par1World.getBlockState(new BlockPos(par1, par2 + 1, par3)).getBlock() == Blocks.AIR 
				|| par1World.getBlockState(new BlockPos(par1, par2 + 1, par3)).getBlock() == Blocks.TALLGRASS
				|| par1World.getBlockState(new BlockPos(par1, par2 + 1, par3)).getBlock() instanceof BlockLeaves)
				//&& !(par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() instanceof BlockLeaves)
				)*/
		{
			if (id == 0) {
				int dd = rand.nextInt(12);
				if (dd == 1) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
					mod_GVCR2.gvcr2_block_building_hideout.getDefaultState(), 2);
				}
				else if (dd == 2) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_cannonplace.getDefaultState(), 2);
				}
				else if (dd == 3) {
	//				par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
	//						mod_GVCR2.gvcr2_block_building_aaplace.getDefaultState(), 2);
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_mg_place.getDefaultState(), 2);
				}
				else if (dd == 4) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_bunker.getDefaultState(), 2);
				}
				else if (dd == 5) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_munitions_depot.getDefaultState(), 2);
				}
				else if (dd == 6) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_radiobase.getDefaultState(), 2);
				}
				else if (dd == 7) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_weaponbase.getDefaultState(), 2);
				}
				else if (dd == 8) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_smallbase.getDefaultState(), 2);
				}
				else if (dd == 9) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_watchtower.getDefaultState(), 2);
				}
				else if (dd == 10) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_latticetower.getDefaultState(), 2);
				}
				else
				{
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_camp.getDefaultState(), 2);
				}
			}
			else if (id == 1) {
				int dd = rand.nextInt(9);
				if (dd == 1) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_hideout_de.getDefaultState(), 2);
				} else if (dd == 2) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_cannonplace_de.getDefaultState(), 2);
				} else if (dd == 3) {
					// par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
					// mod_GVCR2.gvcr2_block_building_aaplace.getDefaultState(), 2);
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_mg_place_de.getDefaultState(), 2);
				} else if (dd == 4) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_bunker_de.getDefaultState(), 2);
				} else if (dd == 5) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_munitions_depot_de.getDefaultState(), 2);
				} else if (dd == 6) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_radiobase_de.getDefaultState(), 2);
				} else if (dd == 7) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_smallbase_de.getDefaultState(), 2);
				} 
				else 
				{
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_camp.getDefaultState(), 2);//gvcr2_block_building_camp
				}
			}
			else if (id == 2) {
				int dd = rand.nextInt(13);
				if (dd == 1) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_hideout.getDefaultState(), 2);
				} else if (dd == 2) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_cannonplace_sf.getDefaultState(), 2);
				} else if (dd == 3) {
					// par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
					// mod_GVCR2.gvcr2_block_building_aaplace.getDefaultState(), 2);
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_mg_place_sf.getDefaultState(), 2);
				} else if (dd == 4) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_bunker.getDefaultState(), 2);
				} else if (dd == 5) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_munitions_depot.getDefaultState(), 2);
				} else if (dd == 6) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_radiobase_sn.getDefaultState(), 2);
				} else if (dd == 7) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_smallbase_sn.getDefaultState(), 2);
				} else if (dd == 8) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_igloo.getDefaultState(), 2);
				} else if (dd == 9) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_camp_sn.getDefaultState(), 2);
				} else if (dd == 9) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_hideout_sn.getDefaultState(), 2);
				} else if (dd == 10) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_latticetower_sn.getDefaultState(), 2);
				} else if (dd == 11) {
					int dd1 = rand.nextInt(2);
					if (dd1== 0) {
						par1World.setBlockState(new BlockPos(par1 + 0, 63, par3 + 0),
								mod_GVCR2.gvcr2_block_building_submarine_sn.getDefaultState(), 2);
					}
				} 
				else {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_camp.getDefaultState(), 2);
				}
			}
			else if (id == 3) {
				int dd = rand.nextInt(4);
				if (dd == 0 || dd == 1) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_ff.getDefaultState(), 2);
				}else{
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_dd.getDefaultState(), 2);
				}
			}
			else if (id == 4) {
				int dd = rand.nextInt(5);
				if (dd == 1) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_cannon_position.getDefaultState(), 2);
				} else if (dd == 2) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_metro.getDefaultState(), 2);
				} else {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_airfield.getDefaultState(), 2);
				}
			}
			
			else if (id == 5) {
				int dd = rand.nextInt(7);
				if (dd == 1) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_ruins.getDefaultState(), 2);
				} else if (dd == 2) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_abandoned_factory.getDefaultState(), 2);
				} else if (dd == 3) {
					/*par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_trench.getDefaultState(), 2);*/
				} else if (dd == 4) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_reichstag.getDefaultState(), 2);
				} else if (dd == 5) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_triumphal_arch.getDefaultState(), 2);
				} 
				else {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_city.getDefaultState(), 2);
				}
			}
			else if (id == 6) {
				int dd = rand.nextInt(5);
				if (dd == 1) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_battleship.getDefaultState(), 2);
				} else if (dd == 2) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_ship.getDefaultState(), 2);
				} else if (dd == 3) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_cv.getDefaultState(), 2);
				}
			}
			else if (id == 7) {
				int dd = rand.nextInt(5);
				/*if (dd == 1) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_city.getDefaultState(), 2);
				}else */
				if (dd == 2) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_snowcastle.getDefaultState(), 2);
				}
				else {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_trainstation.getDefaultState(), 2);
					//par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
					//		mod_GVCR2.gvcr2_block_building_city.getDefaultState(), 2);
				}
			}
			else if (id == 8) {
				int dd = rand.nextInt(5);
				 {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_desertcity.getDefaultState(), 2);
					//par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
					//		mod_GVCR2.gvcr2_block_building_city.getDefaultState(), 2);
				}
			}
			
			else if (id == 10) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
					mod_GVCR2.gvcr2_block_building_airbase.getDefaultState(), 2);
			}
			else if (id == 11) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_garrison.getDefaultState(), 2);
			}
			else if (id == 12) {
				par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
						mod_GVCR2.gvcr2_block_building_garrison_de.getDefaultState(), 2);
		    }
			else if (id == 13) {
				int dd = rand.nextInt(3);
				if (dd == 0) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_garrison_sn.getDefaultState(), 2);
				}else {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_garrison_ice.getDefaultState(), 2);
				}
		    }
			else if (id == 14) {
				par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
						mod_GVCR2.gvcr2_block_building_garrison_ice.getDefaultState(), 2);
		    }
			else if (id == 15) {
				par1World.setBlockState(new BlockPos(par1 + 0, 80, par3 + 0),
						mod_GVCR2.gvcr2_block_building_latticetower_mt.getDefaultState(), 2);
		    }
			else if (id == 16) {
				int dd = rand.nextInt(10);
				if (dd == 0) {
					par1World.setBlockState(new BlockPos(par1 + 0, par2 + 0, par3 + 0),
							mod_GVCR2.gvcr2_block_building_submarine.getDefaultState(), 2);
				}
			}
			else if (id == 17) {
				int dd = rand.nextInt(2);
				if (dd == 0) {
					if(par2 > 80)par2 = 80;
					par1World.setBlockState(new BlockPos(par1 + 0, par2, par3 + 0),
							mod_GVCR2.gvcr2_block_building_highway.getDefaultState(), 2);
				}else {
					if(par2 > 80)par2 = 80;
					par1World.setBlockState(new BlockPos(par1 + 0, par2, par3 + 0),
							mod_GVCR2.gvcr2_block_building_flaktower.getDefaultState(), 2);
				}
				
		    }
		}
		return true;

	}
	
	public int getground(World par1World, Random rand, BlockPos pos) {
		int par1 = pos.getX();
		int par2 = pos.getY();
		int par3 = pos.getZ();
		
		int y = 0;
		
		if(par1World.getBlockState(new BlockPos(par1, par2 - 1, par3)).getBlock() instanceof BlockLeaves){
			for(int yy = 0; yy < 20; ++yy) {
				if(!(par1World.getBlockState(new BlockPos(par1, par2 - 1 - yy, par3)).getBlock() instanceof BlockLeaves)){
					y = yy;
					break;
				}
			}
		}
		return y;
	}
	
	
}
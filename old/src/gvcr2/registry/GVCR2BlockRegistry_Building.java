package gvcr2.registry;

import gvcr2.mod_GVCR2;
import gvcr2.block.BlockBossSpawn_Tile;
import gvcr2.block.BlockBuildingBaseFlag;
import gvcr2.block.building.BlockBuildingReader;
import gvcr2.block.tile.TileEntityBlockSpawn_ONE;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GVCR2BlockRegistry_Building {
	public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Block> event){
		{
			mod.gvcr2_block_building_camp = new BlockBuildingReader("camp.txt")
					.setUnlocalizedName("gvcr2_block_building_camp")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_camp").setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_camp;
				building.setair = true;
				building.setbed = false;
				building.sizex = 8;
				building.sizey = 8;
				building.sizez = 8;
			}
			event.getRegistry().register(mod.gvcr2_block_building_camp);
		}
		{
			mod.gvcr2_block_building_hideout = new BlockBuildingReader("hideout.txt")
					.setUnlocalizedName("gvcr2_block_building_hideout")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_hideout").setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_hideout;
				building.setair = true;
				building.setbed = true;
				building.sizex = 16;
				building.sizey = 8;
				building.sizez = 16;
			}
			event.getRegistry().register(mod.gvcr2_block_building_hideout);
		}
		{
			mod.gvcr2_block_building_hideout_de = new BlockBuildingReader("hideout_de.txt")
					.setUnlocalizedName("gvcr2_block_building_hideout_de")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_hideout_de").setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_hideout_de;
				building.setair = true;
				building.setbed = true;
				building.sizex = 16;
				building.sizey = 16;
				building.sizez = 16;
			}
			event.getRegistry().register(mod.gvcr2_block_building_hideout_de);
		}
		{
			mod.gvcr2_block_building_mg_place = new BlockBuildingReader("mg_place.txt")
					.setUnlocalizedName("gvcr2_block_building_mg_place")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_mg_place").setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_mg_place;
				building.setair = true;
				building.setbed = true;
				building.sizex = 9;
				building.sizey = 5;
				building.sizez = 9;
			}
			event.getRegistry().register(mod.gvcr2_block_building_mg_place);
		}
		{
			mod.gvcr2_block_building_mg_place_de = new BlockBuildingReader("mg_place_de.txt")
					.setUnlocalizedName("gvcr2_block_building_mg_place_de")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_mg_place_de").setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_mg_place_de;
				building.setair = true;
				building.setbed = true;
				building.sizex = 9;
				building.sizey = 5;
				building.sizez = 9;
			}
			event.getRegistry().register(mod.gvcr2_block_building_mg_place_de);
		}
		{
			mod.gvcr2_block_building_mg_place_sf = new BlockBuildingReader("mg_place_sf.txt")
					.setUnlocalizedName("gvcr2_block_building_mg_place_sf")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_mg_place_sf").setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_mg_place_sf;
				building.setair = true;
				building.setbed = true;
				building.sizex = 9;
				building.sizey = 5;
				building.sizez = 9;
			}
			event.getRegistry().register(mod.gvcr2_block_building_mg_place_sf);
		}
		{
			mod.gvcr2_block_building_aaplace = new BlockBuildingReader("aa_place.txt")
					.setUnlocalizedName("gvcr2_block_building_aaplace")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_aaplace").setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_aaplace;
				building.setair = true;
				building.setbed = true;
				building.sizex = 9;
				building.sizey = 5;
				building.sizez = 9;
			}
			event.getRegistry().register(mod.gvcr2_block_building_aaplace);
		}
		{
			mod.gvcr2_block_building_aaplace_de = new BlockBuildingReader("aa_place_de.txt")
					.setUnlocalizedName("gvcr2_block_building_aaplace_de")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_aaplace_de").setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_aaplace_de;
				building.setair = true;
				building.setbed = true;
				building.sizex = 9;
				building.sizey = 5;
				building.sizez = 9;
			}
			event.getRegistry().register(mod.gvcr2_block_building_aaplace_de);
		}
		{
			mod.gvcr2_block_building_aaplace_sf = new BlockBuildingReader("aa_place_sf.txt")
					.setUnlocalizedName("gvcr2_block_building_aaplace_sf")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_aaplace_sf").setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_aaplace_sf;
				building.setair = true;
				building.setbed = true;
				building.sizex = 9;
				building.sizey = 5;
				building.sizez = 9;
			}
			event.getRegistry().register(mod.gvcr2_block_building_aaplace_sf);
		}
		{
			mod.gvcr2_block_building_mortarplace = new BlockBuildingReader("mortar_place.txt")
					.setUnlocalizedName("gvcr2_block_building_mortarplace")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_mortarplace").setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_mortarplace;
				building.setair = true;
				building.setbed = true;
				building.sizex = 9;
				building.sizey = 5;
				building.sizez = 9;
			}
			event.getRegistry().register(mod.gvcr2_block_building_mortarplace);
		}
		{
			mod.gvcr2_block_building_mortarplace_de = new BlockBuildingReader("mortar_place_de.txt")
					.setUnlocalizedName("gvcr2_block_building_mortarplace_de")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_mortarplace_de")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_mortarplace_de;
				building.setair = true;
				building.setbed = true;
				building.sizex = 9;
				building.sizey = 5;
				building.sizez = 9;
			}
			event.getRegistry().register(mod.gvcr2_block_building_mortarplace_de);
		}
		{
			mod.gvcr2_block_building_mortarplace_sf = new BlockBuildingReader("mortar_place_sf.txt")
					.setUnlocalizedName("gvcr2_block_building_mortarplace_sf")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_mortarplace_sf")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_mortarplace_sf;
				building.setair = true;
				building.setbed = true;
				building.sizex = 9;
				building.sizey = 5;
				building.sizez = 9;
			}
			event.getRegistry().register(mod.gvcr2_block_building_mortarplace_sf);
		}

		{
			mod.gvcr2_block_building_cannonplace = new BlockBuildingReader("cannon_place.txt")
					.setUnlocalizedName("gvcr2_block_building_cannonplace")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_cannonplace").setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_cannonplace;
				building.setair = true;
				building.setbed = true;
				building.sizex = 9;
				building.sizey = 5;
				building.sizez = 9;
			}
			event.getRegistry().register(mod.gvcr2_block_building_cannonplace);
		}
		{
			mod.gvcr2_block_building_cannonplace_de = new BlockBuildingReader("cannon_place_de.txt")
					.setUnlocalizedName("gvcr2_block_building_cannonplace_de")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_cannonplace_de")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_cannonplace_de;
				building.setair = true;
				building.setbed = true;
				building.sizex = 9;
				building.sizey = 5;
				building.sizez = 9;
			}
			event.getRegistry().register(mod.gvcr2_block_building_cannonplace_de);
		}
		{
			mod.gvcr2_block_building_cannonplace_sf = new BlockBuildingReader("cannon_place_sf.txt")
					.setUnlocalizedName("gvcr2_block_building_cannonplace_sf")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_cannonplace_sf")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_cannonplace_sf;
				building.setair = true;
				building.setbed = true;
				building.sizex = 9;
				building.sizey = 5;
				building.sizez = 9;
			}
			event.getRegistry().register(mod.gvcr2_block_building_cannonplace_sf);
		}
		
		{
			mod.gvcr2_block_building_bunker = new BlockBuildingReader("bunker.txt")
					.setUnlocalizedName("gvcr2_block_building_bunker")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_bunker")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_bunker;
				building.setair = true;
				building.setbed = true;
				building.sizex = 10;
				building.sizey = 12;
				building.sizez = 10;
				building.offsety = -8;
			}
			event.getRegistry().register(mod.gvcr2_block_building_bunker);
		}
		{
			mod.gvcr2_block_building_bunker_de = new BlockBuildingReader("bunker_de.txt")
					.setUnlocalizedName("gvcr2_block_building_bunker_de")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_bunker_de")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_bunker_de;
				building.setair = true;
				building.setbed = true;
				building.sizex = 10;
				building.sizey = 12;
				building.sizez = 10;
				building.offsety = -8;
			}
			event.getRegistry().register(mod.gvcr2_block_building_bunker_de);
		}
		{
			mod.gvcr2_block_building_munitions_depot = new BlockBuildingReader("munitions_depot.txt")
					.setUnlocalizedName("gvcr2_block_building_munitions_depot")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_munitions_depot")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_munitions_depot;
				building.setair = true;
				building.setbed = true;
				building.sizex = 10;
				building.sizey = 12;
				building.sizez = 10;
				building.offsety = -8;
			}
			event.getRegistry().register(mod.gvcr2_block_building_munitions_depot);
		}
		{
			mod.gvcr2_block_building_munitions_depot_de = new BlockBuildingReader("munitions_depot_de.txt")
					.setUnlocalizedName("gvcr2_block_building_munitions_depot_de")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_munitions_depot_de")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_munitions_depot_de;
				building.setair = true;
				building.setbed = true;
				building.sizex = 10;
				building.sizey = 12;
				building.sizez = 10;
				building.offsety = -8;
			}
			event.getRegistry().register(mod.gvcr2_block_building_munitions_depot_de);
		}
		
		{
			mod.gvcr2_block_building_radiobase = new BlockBuildingReader("radiobase.txt")
					.setUnlocalizedName("gvcr2_block_building_radiobase")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_radiobase")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_radiobase;
				building.setair = true;
				building.setbed = true;
				building.sizex = 23;
				building.sizey = 12;
				building.sizez = 19;
				building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_radiobase);
		}
		{
			mod.gvcr2_block_building_radiobase_de = new BlockBuildingReader("radiobase_de.txt")
					.setUnlocalizedName("gvcr2_block_building_radiobase_de")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_radiobase_de")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_radiobase_de;
				building.setair = true;
				building.setbed = true;
				building.sizex = 23;
				building.sizey = 12;
				building.sizez = 19;
				building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_radiobase_de);
		}
		{
			mod.gvcr2_block_building_radiobase_sn = new BlockBuildingReader("radiobase_sn.txt")
					.setUnlocalizedName("gvcr2_block_building_radiobase_sn")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_radiobase_sn")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_radiobase_sn;
				building.setair = true;
				building.setbed = true;
				building.sizex = 23;
				building.sizey = 12;
				building.sizez = 19;
				building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_radiobase_sn);
		}
		
		{
			mod.gvcr2_block_building_weaponbase = new BlockBuildingReader("weaponbase.txt")
					.setUnlocalizedName("gvcr2_block_building_weaponbase")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_weaponbase")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_weaponbase;
				building.setair = true;
				building.setbed = true;
				building.sizex = 27;
				building.sizey = 12;
				building.sizez = 17;
				building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_weaponbase);
		}
		
		{
			mod.gvcr2_block_building_smallbase = new BlockBuildingReader("smallbase.txt")
					.setUnlocalizedName("gvcr2_block_building_smallbase")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_smallbase")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_smallbase;
				building.setair = true;
				building.setbed = true;
				building.sizex = 37;
				building.sizey = 12;
				building.sizez = 25;
				building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_smallbase);
		}
		{
			mod.gvcr2_block_building_smallbase_de = new BlockBuildingReader("smallbase_de.txt")
					.setUnlocalizedName("gvcr2_block_building_smallbase_de")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_smallbase_de")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_smallbase_de;
				building.setair = true;
				building.setbed = true;
				building.sizex = 37;
				building.sizey = 12;
				building.sizez = 25;
				building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_smallbase_de);
		}
		{
			mod.gvcr2_block_building_smallbase_sn = new BlockBuildingReader("smallbase_sn.txt")
					.setUnlocalizedName("gvcr2_block_building_smallbase_sn")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_smallbase_sn")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_smallbase_sn;
				building.setair = true;
				building.setbed = true;
				building.sizex = 37;
				building.sizey = 12;
				building.sizez = 25;
				building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_smallbase_sn);
		}
		
		{
			mod.gvcr2_block_building_watchtower = new BlockBuildingReader("watchtower.txt")
					.setUnlocalizedName("gvcr2_block_building_watchtower")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_watchtower")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_watchtower;
				building.setair = true;
				building.setbed = true;
				building.sizex = 16;
				building.sizey = 32;
				building.sizez = 16;
				building.offsety = 0;
			}
			event.getRegistry().register(mod.gvcr2_block_building_watchtower);
		}
		{
			mod.gvcr2_block_building_igloo = new BlockBuildingReader("igloo.txt")
					.setUnlocalizedName("gvcr2_block_building_igloo")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_igloo")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_igloo;
				building.setair = true;
				building.setbed = true;
				building.sizex = 16;
				building.sizey = 8;
				building.sizez = 16;
				building.offsety = -2;
			}
			event.getRegistry().register(mod.gvcr2_block_building_igloo);
		}
		{
			mod.gvcr2_block_building_latticetower = new BlockBuildingReader("latticetower.txt")
					.setUnlocalizedName("gvcr2_block_building_latticetower")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_latticetower")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_latticetower;
				building.setair = true;
				building.setbed = true;
				building.sizex = 16;
				building.sizey = 48;
				building.sizez = 16;
				building.offsety = 0;
			}
			event.getRegistry().register(mod.gvcr2_block_building_latticetower);
		}
		{
			mod.gvcr2_block_building_latticetower_mt = new BlockBuildingReader("latticetower_mt.txt")
					.setUnlocalizedName("gvcr2_block_building_latticetower_mt")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_latticetower_mt")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_latticetower_mt;
				building.setair = true;
				building.setbed = true;
				building.sizex = 16;
				building.sizey = 48;
				building.sizez = 16;
				building.offsety = 0;
			}
			event.getRegistry().register(mod.gvcr2_block_building_latticetower_mt);
		}
		{
			mod.gvcr2_block_building_latticetower_sn = new BlockBuildingReader("latticetower_sn.txt")
					.setUnlocalizedName("gvcr2_block_building_latticetower_sn")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_latticetower_sn")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_latticetower_sn;
				building.setair = true;
				building.setbed = true;
				building.sizex = 16;
				building.sizey = 48;
				building.sizez = 16;
				building.offsety = 0;
			}
			event.getRegistry().register(mod.gvcr2_block_building_latticetower_sn);
		}
		{
			mod.gvcr2_block_building_camp_sn = new BlockBuildingReader("camp_sn.txt")
					.setUnlocalizedName("gvcr2_block_building_camp_sn")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_camp_sn")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_camp_sn;
				building.setair = true;
				building.setbed = true;
				building.sizex = 16;
				building.sizey = 8;
				building.sizez = 16;
				building.offsety = 0;
			}
			event.getRegistry().register(mod.gvcr2_block_building_camp_sn);
		}
		{
			mod.gvcr2_block_building_hideout_sn = new BlockBuildingReader("hideout_sn.txt")
					.setUnlocalizedName("gvcr2_block_building_hideout_sn")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_hideout_sn")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_hideout_sn;
				building.setair = true;
				building.setbed = true;
				building.sizex = 16;
				building.sizey = 16;
				building.sizez = 16;
				building.offsety = 0;
			}
			event.getRegistry().register(mod.gvcr2_block_building_hideout_sn);
		}
		{
			mod.gvcr2_block_building_submarine = new BlockBuildingReader("submarine.txt")
					.setUnlocalizedName("gvcr2_block_building_submarine")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_submarine")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_submarine;
				//building.setair = true;
				//building.setbed = true;
				building.sizex = 96;
				building.sizey = 16;
				building.sizez = 32;
				building.offsety = -8;
			}
			event.getRegistry().register(mod.gvcr2_block_building_submarine);
		}
		{
			mod.gvcr2_block_building_submarine_sn = new BlockBuildingReader("submarine_sn.txt")
					.setUnlocalizedName("gvcr2_block_building_submarine_sn")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_submarine_sn")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_submarine_sn;
				building.setair = true;
				building.setbed = true;
				building.sizex = 96;
				building.sizey = 32;
				building.sizez = 32;
				building.offsety = -10;
			}
			event.getRegistry().register(mod.gvcr2_block_building_submarine_sn);
		}
		
		
		
		{

			mod.gvcr2_block_flag_ge_playerbase = new BlockBuildingBaseFlag().setHardness(3F)
					.setUnlocalizedName("gvcr2_block_flag_ge_playerbase")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_playerbase")
					.setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_flag_ge_playerbase);
			
			mod.gvcr2_block_flag_so_playerbase = new BlockBuildingBaseFlag().setHardness(3F)
					.setUnlocalizedName("gvcr2_block_flag_so_playerbase")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_playerbase")
					.setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_flag_so_playerbase);
		}
		
		
		///大型ダンジョン
		{
			mod.gvcr2_block_building_city = new BlockBuildingReader("city.txt")
					.setUnlocalizedName("gvcr2_block_building_city")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_city")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_city;
				building.Building_Read("city.txt");
				building.setair = true;
				building.setbed = true;
				building.sizex = 128;
				building.sizey = 32;
				building.sizez = 128;
				building.offsety = -2;
			}
			event.getRegistry().register(mod.gvcr2_block_building_city);
			{
				mod.gvcr2_block_flag_ge_city = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_city")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_city")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_city);
				
				mod.gvcr2_block_flag_so_city = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_city")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_city")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_city);
			}
		}
		{
			mod.gvcr2_block_building_ship = new BlockBuildingReader("ship.txt")
					.setUnlocalizedName("gvcr2_block_building_ship")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_ship")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_ship;
				building.setair = false;
				building.setbed = false;
				building.sizex = 128;
				building.sizey = 32;
				building.sizez = 64;
				building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_ship);
			{
				mod.gvcr2_block_flag_ge_ship = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_ship")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_ship")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_ship);
				
				mod.gvcr2_block_flag_so_ship = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_ship")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_ship")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_ship);
			}
		}
		
		{
			mod.gvcr2_block_building_ruins = new BlockBuildingReader("ruins.txt")
					.setUnlocalizedName("gvcr2_block_building_ruins")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_ruins")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_ruins;
				building.setair = true;
				building.setbed = true;
				building.sizex = 128;
				building.sizey = 32;
				building.sizez = 128;
				//building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_ruins);
			{
				mod.gvcr2_block_flag_ge_ruins = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_ruins")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_ruins")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_ruins);
				
				mod.gvcr2_block_flag_so_ruins = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_ruins")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_ruins")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_ruins);
			}
		}
		{
			mod.gvcr2_block_building_abandoned_factory = new BlockBuildingReader("abandoned_factory.txt")
					.setUnlocalizedName("gvcr2_block_building_abandoned_factory")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_abandoned_factory")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_abandoned_factory;
				building.setair = true;
				building.setbed = true;
				building.sizex = 128;
				building.sizey = 32;
				building.sizez = 128;
				//building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_abandoned_factory);
			{
				mod.gvcr2_block_flag_ge_abandoned_factory = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_abandoned_factory")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_abandoned_factory")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_abandoned_factory);
				
				mod.gvcr2_block_flag_so_abandoned_factory = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_abandoned_factory")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_abandoned_factory")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_abandoned_factory);
			}
		}
		{
			mod.gvcr2_block_building_airfield = new BlockBuildingReader("airfield.txt")
					.setUnlocalizedName("gvcr2_block_building_airfield")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_airfield")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_airfield;
				building.setair = true;
				building.setbed = true;
				building.sizex = 64;
				building.sizey = 32;
				building.sizez = 48;
				//building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_airfield);
			{
				mod.gvcr2_block_flag_ge_airfield = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_airfield")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_airfield")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_airfield);
				
				mod.gvcr2_block_flag_so_airfield = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_airfield")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_airfield")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_airfield);
			}
		}
		{
			mod.gvcr2_block_building_airbase = new BlockBuildingReader("airbase.txt")
					.setUnlocalizedName("gvcr2_block_building_airbase")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_airbase")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_airbase;
				building.setair = true;
				building.setbed = true;
				building.sizex = 128;
				building.sizey = 64;//32
				building.sizez = 128;//64
				//building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_airbase);
			{
				mod.gvcr2_block_flag_ge_airbase = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_airbase")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_airbase")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_airbase);
				
				mod.gvcr2_block_flag_so_airbase = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_airbase")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_airbase")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_airbase);
			}
			{
				mod.gvcr2_block_flag_boss_airbase = new BlockBossSpawn_Tile()
						.setUnlocalizedName("gvcr2_block_flag_boss_airbase")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_boss_airbase")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_boss_airbase);
				
				
			}
		}
		{
			mod.gvcr2_block_building_garrison = new BlockBuildingReader("garrison.txt")
					.setUnlocalizedName("gvcr2_block_building_garrison")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_garrison")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_garrison;
				building.setair = true;
				building.setbed = true;
				building.sizex = 64;
				building.sizey = 32;
				building.sizez = 64;
				//building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_garrison);
			
			mod.gvcr2_block_building_garrison_de = new BlockBuildingReader("garrison_de.txt")
					.setUnlocalizedName("gvcr2_block_building_garrison_de")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_garrison_de")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_garrison_de;
				building.setair = true;
				building.setbed = true;
				building.sizex = 64;
				building.sizey = 32;
				building.sizez = 64;
				//building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_garrison_de);
			
			mod.gvcr2_block_building_garrison_sn = new BlockBuildingReader("garrison_sn.txt")
					.setUnlocalizedName("gvcr2_block_building_garrison_sn")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_garrison_sn")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_garrison_sn;
				building.setair = true;
				building.setbed = true;
				building.sizex = 114;
				building.sizey = 32;
				building.sizez = 101;
				building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_garrison_sn);
			
			mod.gvcr2_block_building_garrison_ice = new BlockBuildingReader("garrison_ice.txt")
					.setUnlocalizedName("gvcr2_block_building_garrison_ice")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_garrison_ice")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_garrison_ice;
				building.setair = true;
				building.setbed = true;
				building.sizex = 64;
				building.sizey = 32;
				building.sizez = 64;
				building.offsety = 0;
			}
			event.getRegistry().register(mod.gvcr2_block_building_garrison_ice);
			
			mod.gvcr2_block_building_garrison_fortress = new BlockBuildingReader("garrison_fortress.txt")
					.setUnlocalizedName("gvcr2_block_building_garrison_fortress")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_garrison_fortress")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_garrison_fortress;
				building.setair = true;
				building.setbed = true;
				building.sizex = 64;
				building.sizey = 32;
				building.sizez = 64;
				//building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_garrison_fortress);
			
			{
				mod.gvcr2_block_flag_ge_garrison = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_garrison")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_garrison")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_garrison);
				
				mod.gvcr2_block_flag_so_garrison = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_garrison")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_garrison")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_garrison);
			}
		}
		
		{
			mod.gvcr2_block_building_metro = new BlockBuildingReader("metro.txt")
					.setUnlocalizedName("gvcr2_block_building_metro")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_metro")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_metro;
				building.setair = true;
				building.setbed = false;
				building.sizex = 96;
				building.sizey = 39;
				building.sizez = 48;
				building.offsety = -32;
			}
			event.getRegistry().register(mod.gvcr2_block_building_metro);
			{
				mod.gvcr2_block_flag_ge_metro = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_metro")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_metro")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_metro);
				
				mod.gvcr2_block_flag_so_metro = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_metro")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_metro")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_metro);
			}
		}
		
		{
			mod.gvcr2_block_building_cannon_position = new BlockBuildingReader("cannon_position.txt")
					.setUnlocalizedName("gvcr2_block_building_cannon_position")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_cannon_position")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_cannon_position;
				building.setair = true;
				building.setbed = true;
				building.sizex = 64;
				building.sizey = 32;
				building.sizez = 64;
				building.offsety = 0;
			}
			event.getRegistry().register(mod.gvcr2_block_building_cannon_position);
			{
				mod.gvcr2_block_flag_ge_cannon_position = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_cannon_position")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_cannon_position")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_cannon_position);
				
				mod.gvcr2_block_flag_so_cannon_position = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_cannon_position")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_cannon_position")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_cannon_position);
			}
		}
		
		{
			mod.gvcr2_block_building_trench = new BlockBuildingReader("trench.txt")
					.setUnlocalizedName("gvcr2_block_building_trench")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_trench")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_trench;
				building.setair = true;
				building.setbed = true;
				building.sizex = 128;
				building.sizey = 32;
				building.sizez = 128;
				building.offsety = -0;
			}
			event.getRegistry().register(mod.gvcr2_block_building_trench);
			{
				mod.gvcr2_block_flag_ge_trench = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_trench")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_trench")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_trench);
				
				mod.gvcr2_block_flag_so_trench = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_trench")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_trench")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_trench);
			}
		}
		
		{
			mod.gvcr2_block_building_battleship = new BlockBuildingReader("battleship.txt")
					.setUnlocalizedName("gvcr2_block_building_battleship")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_battleship")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_battleship;
				building.setair = false;
				building.setbed = false;
				building.sizex = 128;
				building.sizey = 39;
				building.sizez = 48;
				building.offsety = -2;
			}
			event.getRegistry().register(mod.gvcr2_block_building_battleship);
			{
				mod.gvcr2_block_flag_ge_battleship = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_battleship")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_battleship")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_battleship);
				
				mod.gvcr2_block_flag_so_battleship = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_battleship")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_battleship")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_battleship);
			}
		}
		
		{
			mod.gvcr2_block_building_snowcastle = new BlockBuildingReader("snowcastle.txt")
					.setUnlocalizedName("gvcr2_block_building_snowcastle")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_snowcastle")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_snowcastle;
				building.setair = true;
				building.setbed = true;
				building.sizex = 128;
				building.sizey = 32;
				building.sizez = 128;
				//building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_snowcastle);
			{
				mod.gvcr2_block_flag_ge_snowcastle = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_snowcastle")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_snowcastle")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_snowcastle);
				
				mod.gvcr2_block_flag_so_snowcastle = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_snowcastle")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_snowcastle")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_snowcastle);
			}
		}
		
		{
			mod.gvcr2_block_building_trainstation = new BlockBuildingReader("trainstation.txt")
					.setUnlocalizedName("gvcr2_block_building_trainstation")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_trainstation")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_trainstation;
				building.setair = true;
				building.setbed = true;
				building.sizex = 128;
				building.sizey = 32;
				building.sizez = 128;
				//building.offsety = -4;
			}
			event.getRegistry().register(mod.gvcr2_block_building_trainstation);
			{
				mod.gvcr2_block_flag_ge_trainstation = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_trainstation")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_trainstation")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_trainstation);
				
				mod.gvcr2_block_flag_so_trainstation = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_trainstation")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_trainstation")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_trainstation);
			}
		}
		
		{
			mod.gvcr2_block_building_reichstag = new BlockBuildingReader("reichstag.txt")
					.setUnlocalizedName("gvcr2_block_building_reichstag")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_reichstag")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_reichstag;
				building.setair = true;
				building.setbed = true;
				building.sizex = 100;
				building.sizey = 48;
				building.sizez = 100;
				building.offsety = -17;
			}
			event.getRegistry().register(mod.gvcr2_block_building_reichstag);
			{
				mod.gvcr2_block_flag_ge_reichstag = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_reichstag")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_reichstag")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_reichstag);
				
				mod.gvcr2_block_flag_so_reichstag = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_reichstag")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_reichstag")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_reichstag);
			}
		}
		
		{
			mod.gvcr2_block_building_desertcity = new BlockBuildingReader("desertcity.txt")
					.setUnlocalizedName("gvcr2_block_building_desertcity")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_desertcity")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_desertcity;
				building.setair = true;
				building.setbed = true;
				building.sizex = 128;
				building.sizey = 48;
				building.sizez = 128;
				building.offsety = 0;
			}
			event.getRegistry().register(mod.gvcr2_block_building_desertcity);
			{
				mod.gvcr2_block_flag_ge_desertcity = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_desertcity")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_desertcity")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_desertcity);
				
				mod.gvcr2_block_flag_so_desertcity = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_desertcity")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_desertcity")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_desertcity);
			}
		}
		
		{
			mod.gvcr2_block_building_triumphal_arch = new BlockBuildingReader("triumphal_arch.txt")
					.setUnlocalizedName("gvcr2_block_building_triumphal_arch")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_triumphal_arch")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_triumphal_arch;
				building.setair = true;
				building.setbed = true;
				building.sizex = 105;
				building.sizey = 48;
				building.sizez = 105;
				building.offsety = 0;
			}
			event.getRegistry().register(mod.gvcr2_block_building_triumphal_arch);
			{
				mod.gvcr2_block_flag_ge_triumphal_arch = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_triumphal_arch")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_triumphal_arch")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_triumphal_arch);
				
				mod.gvcr2_block_flag_so_triumphal_arch = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_triumphal_arch")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_triumphal_arch")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_triumphal_arch);
			}
		}
		
		{
			mod.gvcr2_block_building_cv = new BlockBuildingReader("cv.txt")
					.setUnlocalizedName("gvcr2_block_building_cv")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_cv")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_cv;
				building.setair = false;
				building.setbed = false;
				building.sizex = 128;
				building.sizey = 48;
				building.sizez = 128;
				building.offsety = -3;
			}
			event.getRegistry().register(mod.gvcr2_block_building_cv);
			{
				mod.gvcr2_block_flag_ge_cv = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_cv")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_cv")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_cv);
				
				mod.gvcr2_block_flag_so_cv = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_cv")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_cv")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_cv);
			}
			{
				//GameRegistry.registerTileEntity(TileEntityBlockSpawn_ONE.class, "TileEntityBlockSpawn_ONE");
				
				mod.gvcr2_block_flag_boss_cv = new BlockBossSpawn_Tile()
						.setUnlocalizedName("gvcr2_block_flag_boss_cv")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_boss_cv")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_boss_cv);
				
				
			}
		}
		
		{
			mod.gvcr2_block_building_dd = new BlockBuildingReader("dd.txt")
					.setUnlocalizedName("gvcr2_block_building_dd")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_dd")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_dd;
				building.setair = false;
				building.setbed = false;
				building.sizex = 128;
				building.sizey = 48;
				building.sizez = 128;
				building.offsety = -2;
			}
			event.getRegistry().register(mod.gvcr2_block_building_dd);
			{
				mod.gvcr2_block_flag_ge_dd = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_dd")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_dd")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_dd);
				
				mod.gvcr2_block_flag_so_dd = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_dd")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_dd")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_dd);
			}
		}
		
		{
			mod.gvcr2_block_building_ff = new BlockBuildingReader("ff.txt")
					.setUnlocalizedName("gvcr2_block_building_ff")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_ff")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_ff;
				building.setair = false;
				building.setbed = false;
				building.sizex = 128;
				building.sizey = 48;
				building.sizez = 128;
				building.offsety = -2;
			}
			event.getRegistry().register(mod.gvcr2_block_building_ff);
			{
				mod.gvcr2_block_flag_ge_ff = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_ff")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_ff")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_ff);
				
				mod.gvcr2_block_flag_so_ff = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_ff")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_ff")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_ff);
			}
		}
		{
			mod.gvcr2_block_building_flaktower = new BlockBuildingReader("flaktower.txt")
					.setUnlocalizedName("gvcr2_block_building_flaktower")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_flaktower")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_flaktower;
				building.setair = true;
				building.setbed = false;
				building.sizex = 64;
				building.sizey = 128;
				building.sizez = 64;
				building.offsety = -11;
			}
			event.getRegistry().register(mod.gvcr2_block_building_flaktower);
			{
				mod.gvcr2_block_flag_ge_flaktower = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_flaktower")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_flaktower")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_flaktower);
				
				mod.gvcr2_block_flag_so_flaktower = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_flaktower")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_flaktower")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_flaktower);
			}
		}
		{
			mod.gvcr2_block_building_slum = new BlockBuildingReader("slum.txt")
					.setUnlocalizedName("gvcr2_block_building_slum")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_slum")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_slum;
				building.setair = true;
				building.setbed = false;
				building.sizex = 128;
				building.sizey = 64;
				building.sizez = 128;
				building.offsety = -3;
			}
			event.getRegistry().register(mod.gvcr2_block_building_slum);
			{
				mod.gvcr2_block_flag_ge_slum = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_slum")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_slum")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_slum);
				
				mod.gvcr2_block_flag_so_slum = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_slum")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_slum")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_slum);
			}
		}
		{
			mod.gvcr2_block_building_highway = new BlockBuildingReader("highway.txt")
					.setUnlocalizedName("gvcr2_block_building_highway")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_building_highway")
					.setCreativeTab(mod.tabgg_building);
			{
				BlockBuildingReader building = (BlockBuildingReader) mod.gvcr2_block_building_highway;
				building.setair = true;
				building.setbed = false;
				building.sizex = 128;
				building.sizey = 64;
				building.sizez = 64;
				building.offsety = -2;
			}
			event.getRegistry().register(mod.gvcr2_block_building_highway);
			{
				mod.gvcr2_block_flag_ge_highway = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_ge_highway")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_ge_highway")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_ge_highway);
				
				mod.gvcr2_block_flag_so_highway = new BlockBuildingBaseFlag()
						.setUnlocalizedName("gvcr2_block_flag_so_highway")
						.setRegistryName(mod.MOD_ID, "gvcr2_block_flag_so_highway")
						.setCreativeTab(mod.tabgg_building);
				event.getRegistry().register(mod.gvcr2_block_flag_so_highway);
			}
		}
		
		///////////
	}//end
}

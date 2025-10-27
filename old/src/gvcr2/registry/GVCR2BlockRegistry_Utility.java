package gvcr2.registry;

import gvcr2.mod_GVCR2;
import gvcr2.block.BlockBossSpawn_Tile;
import gvcr2.block.BlockSpawn_Spawner;
import gvcr2.block.Block_BulletCrafter;
import gvcr2.block.Block_GVC_DecoFacingBlock;
import gvcr2.block.Block_GhostLight;
import gvcr2.block.Block_GhostLight_Tile;
import gvcr2.block.Block_GunCrafter;
import gvcr2.block.Block_GunRack;
import gvcr2.block.Block_GunRack_Deco;
import gvcr2.block.Block_Mine;
import gvcr2.block.Block_Scaffold;
import gvcr2.block.Block_Supplies;
import gvcr2.block.Block_VehicleCrafter;
import gvcr2.block.tile.TileEntityBlockSpawn_ONE;
import gvcr2.block.tile.TileEntityBlock_GhostLight_Tile;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GVCR2BlockRegistry_Utility {
	public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Block> event){
		{
			mod.gvcr2_block_mine	= new Block_Mine().setUnlocalizedName("gvcr2_block_mine")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_mine").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_mine);
			
			mod.gvcr2_block_atmine	= new Block_Mine().setUnlocalizedName("gvcr2_block_atmine")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_atmine").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_atmine);
			
			mod.gvcr2_block_ied	= new Block_Mine().setUnlocalizedName("gvcr2_block_ied")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_ied").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_ied);
			
			mod.gvcr2_block_bomb	= new Block_Mine().setUnlocalizedName("gvcr2_block_bomb")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_bomb").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_bomb);
			
			mod.gvcr2_block_water_mine	= new Block_Mine().setUnlocalizedName("gvcr2_block_water_mine")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_water_mine").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_water_mine);
			
			mod.gvcr2_block_propane	= new Block_Mine().setUnlocalizedName("gvcr2_block_propane")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_propane").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_propane);
			
			mod.gvcr2_block_bouy	= new BlockSpawn_Spawner().setUnlocalizedName("gvcr2_block_bouy")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_bouy").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_bouy);
		}
		{
			mod.gvcr2_block_supplies_air= new Block_Supplies(0).setUnlocalizedName("gvcr2_block_supplies_air")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_supplies_air").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_supplies_air);
			
			mod.gvcr2_block_supplies_1	= new Block_Supplies(1).setUnlocalizedName("gvcr2_block_supplies_1")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_supplies_1").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_supplies_1);
			mod.gvcr2_block_supplies_2= new Block_Supplies(2).setUnlocalizedName("gvcr2_block_supplies_2")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_supplies_2").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_supplies_2);
			mod.gvcr2_block_supplies_3	= new Block_Supplies(3).setUnlocalizedName("gvcr2_block_supplies_3")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_supplies_3").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_supplies_3);
			mod.gvcr2_block_supplies_4	= new Block_Supplies(4).setUnlocalizedName("gvcr2_block_supplies_4")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_supplies_4").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_supplies_4);
			mod.gvcr2_block_supplies_scrap	= new Block_Supplies(5).setUnlocalizedName("gvcr2_block_supplies_scrap")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_supplies_scrap").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_supplies_scrap);
		}
		
		
		
		
		
		
		
		
		
		
		{
			mod.gvcr2_block_bulletcrafter_1= new Block_BulletCrafter().setUnlocalizedName("gvcr2_block_bulletcrafter_1")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_bulletcrafter_1").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_bulletcrafter_1);
		}
		
		{
			mod.gvcr2_block_guncrafter_1= new Block_GunCrafter(0).setUnlocalizedName("gvcr2_block_guncrafter_1")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_guncrafter_1").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_guncrafter_1);
			mod.gvcr2_block_guncrafter_2= new Block_GunCrafter(1).setUnlocalizedName("gvcr2_block_guncrafter_2")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_guncrafter_2").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_guncrafter_2);
			mod.gvcr2_block_guncrafter_3= new Block_GunCrafter(2).setUnlocalizedName("gvcr2_block_guncrafter_3")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_guncrafter_3").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_guncrafter_3);
		}
		
		{
			mod.gvcr2_block_vehiclecrafter_1= new Block_VehicleCrafter(0).setUnlocalizedName("gvcr2_block_vehiclecrafter_1")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_vehiclecrafter_1").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_vehiclecrafter_1);
			mod.gvcr2_block_vehiclecrafter_2= new Block_VehicleCrafter(1).setUnlocalizedName("gvcr2_block_vehiclecrafter_2")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_vehiclecrafter_2").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_vehiclecrafter_2);
			mod.gvcr2_block_vehiclecrafter_3= new Block_VehicleCrafter(2).setUnlocalizedName("gvcr2_block_vehiclecrafter_3")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_vehiclecrafter_3").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_vehiclecrafter_3);
		}
		{
			mod.gvcr2_block_gunrack_hsin= new Block_GunRack().setUnlocalizedName("gvcr2_block_gunrack_hsin")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_gunrack_hsin").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_gunrack_hsin);
			
			mod.gvcr2_block_gunrack_rsin= new Block_GunRack().setUnlocalizedName("gvcr2_block_gunrack_rsin")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_gunrack_rsin").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_gunrack_rsin);
			
			mod.gvcr2_block_gunrack_rswn= new Block_GunRack().setUnlocalizedName("gvcr2_block_gunrack_rswn")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_gunrack_rswn").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_gunrack_rswn);
			
			
			mod.gvcr2_block_gunrack_hti= new Block_GunRack().setUnlocalizedName("gvcr2_block_gunrack_hti")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_gunrack_hti").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_gunrack_hti);
			
			mod.gvcr2_block_gunrack_rti1= new Block_GunRack().setUnlocalizedName("gvcr2_block_gunrack_rti1")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_gunrack_rti1").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_gunrack_rti1);
			
			mod.gvcr2_block_gunrack_rti2= new Block_GunRack().setUnlocalizedName("gvcr2_block_gunrack_rti2")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_gunrack_rti2").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_gunrack_rti2);
		}
		
		{
			mod.gvcr2_block_gunrack_hsin_deco= new Block_GunRack_Deco(0).setUnlocalizedName("gvcr2_block_gunrack_hsin_deco")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_gunrack_hsin_deco").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_gunrack_hsin_deco);
			mod.gvcr2_block_gunrack_rsin_deco= new Block_GunRack_Deco(1).setUnlocalizedName("gvcr2_block_gunrack_rsin_deco")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_gunrack_rsin_deco").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_gunrack_rsin_deco);
			mod.gvcr2_block_gunrack_rswn_deco= new Block_GunRack_Deco(2).setUnlocalizedName("gvcr2_block_gunrack_rswn_deco")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_gunrack_rswn_deco").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_gunrack_rswn_deco);
			mod.gvcr2_block_gunrack_hti_deco= new Block_GunRack_Deco(3).setUnlocalizedName("gvcr2_block_gunrack_hti_deco")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_gunrack_hti_deco").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_gunrack_hti_deco);
			mod.gvcr2_block_gunrack_rti1_deco= new Block_GunRack_Deco(4).setUnlocalizedName("gvcr2_block_gunrack_rti1_deco")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_gunrack_rti1_deco").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_gunrack_rti1_deco);
			mod.gvcr2_block_gunrack_rti2_deco= new Block_GunRack_Deco(5).setUnlocalizedName("gvcr2_block_gunrack_rti2_deco")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_gunrack_rti2_deco").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_gunrack_rti2_deco);
		}
		
		
		{
			mod.gvcr2_block_ammobox1	= new Block_GVC_DecoFacingBlock(37, true).setUnlocalizedName("gvcr2_block_ammobox1")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_ammobox1").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_ammobox1);
			mod.gvcr2_block_artibox1	= new Block_GVC_DecoFacingBlock(38, true).setUnlocalizedName("gvcr2_block_artibox1")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_artibox1").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_artibox1);
			mod.gvcr2_block_artibox2	= new Block_GVC_DecoFacingBlock(39, true).setUnlocalizedName("gvcr2_block_artibox2")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_artibox2").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_artibox2);
			mod.gvcr2_block_artibox3	= new Block_GVC_DecoFacingBlock(40, true).setUnlocalizedName("gvcr2_block_artibox3")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_artibox3").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_artibox3);
			mod.gvcr2_block_barrel_drum1	= new Block_GVC_DecoFacingBlock(41, true).setUnlocalizedName("gvcr2_block_barrel_drum1")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_barrel_drum1").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_barrel_drum1);
			mod.gvcr2_block_barrel_drum2	= new Block_GVC_DecoFacingBlock(42, true).setUnlocalizedName("gvcr2_block_barrel_drum2")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_barrel_drum2").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_barrel_drum2);
			mod.gvcr2_block_barrel_drum3	= new Block_GVC_DecoFacingBlock(43, true).setUnlocalizedName("gvcr2_block_barrel_drum3")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_barrel_drum3").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_barrel_drum3);
			
			mod.gvcr2_block_cadaver_g	= new Block_Supplies(1).setUnlocalizedName("gvcr2_block_cadaver_g")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_cadaver_g").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_cadaver_g);
			
			mod.gvcr2_block_hesco	= new Block(Material.SAND, MapColor.SAND).setHardness(3.0F).setResistance(100.0F).setUnlocalizedName("gvcr2_block_hesco")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_hesco").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_hesco);
			mod.gvcr2_block_jerrycan1	= new Block_GVC_DecoFacingBlock(44, true).setUnlocalizedName("gvcr2_block_jerrycan1")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_jerrycan1").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_jerrycan1);
			
			mod.gvcr2_block_missile_rack1	= new Block_GVC_DecoFacingBlock(45, true).setUnlocalizedName("gvcr2_block_missile_rack1")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_missile_rack1").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_missile_rack1);
		}
		
		
		
		
		
		{
			mod.gvcr2_block_9mmpack_gc	= new Block_GVC_DecoFacingBlock(0, false).setUnlocalizedName("gvcr2_block_9mmpack_gc")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_9mmpack_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_9mmpack_gc);
			
			mod.gvcr2_block_45pack_gc	= new Block_GVC_DecoFacingBlock(1, false).setUnlocalizedName("gvcr2_block_45pack_gc")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_45pack_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_45pack_gc);
			
			mod.gvcr2_block_223pack_gc	= new Block_GVC_DecoFacingBlock(2, false).setUnlocalizedName("gvcr2_block_223pack_gc")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_223pack_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_223pack_gc);
			
			mod.gvcr2_block_308pack_gc	= new Block_GVC_DecoFacingBlock(3, false).setUnlocalizedName("gvcr2_block_308pack_gc")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_308pack_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_308pack_gc);
			
			mod.gvcr2_block_50bmgpack_gc	= new Block_GVC_DecoFacingBlock(4, false).setUnlocalizedName("gvcr2_block_50bmgpack_gc")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_50bmgpack_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_50bmgpack_gc);
			
			mod.gvcr2_block_12gpack_gc	= new Block_GVC_DecoFacingBlock(5, false).setUnlocalizedName("gvcr2_block_12gpack_gc")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_12gpack_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_12gpack_gc);
			
			mod.gvcr2_block_40mmgr_ammo_gc	= new Block_GVC_DecoFacingBlock(6, false).setUnlocalizedName("gvcr2_block_40mmgr_ammo_gc")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_40mmgr_ammo_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_40mmgr_ammo_gc);
			
			mod.gvcr2_block_grenade_box_gc	= new Block_GVC_DecoFacingBlock(7, false).setUnlocalizedName("gvcr2_block_grenade_box_gc")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_grenade_box_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_grenade_box_gc);
			
			mod.gvcr2_block_rpg_ammobox1	= new Block_GVC_DecoFacingBlock(8, true).setUnlocalizedName("gvcr2_block_rpg_ammobox1")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_rpg_ammobox1").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_rpg_ammobox1);
			
			mod.gvcr2_block_rpg_ammobox2	= new Block_GVC_DecoFacingBlock(9, true).setUnlocalizedName("gvcr2_block_rpg_ammobox2")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_rpg_ammobox2").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_rpg_ammobox2);
			
			mod.gvcr2_block_ammo_mass	= new Block_GVC_DecoFacingBlock(10, true).setUnlocalizedName("gvcr2_block_ammo_mass")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_ammo_mass").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_ammo_mass);
			
			mod.gvcr2_block_m18_claymore	= new Block_GVC_DecoFacingBlock(11, true).setUnlocalizedName("gvcr2_block_m18_claymore")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_m18_claymore").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_m18_claymore);
			
			mod.gvcr2_block_m72_box	= new Block_GVC_DecoFacingBlock(12, false).setUnlocalizedName("gvcr2_block_m72_box")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_m72_box").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_m72_box);
			
			mod.gvcr2_block_rpg_box	= new Block_GVC_DecoFacingBlock(13, false).setUnlocalizedName("gvcr2_block_rpg_box")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_rpg_box").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_rpg_box);
			
			mod.gvcr2_block_medbag_gc	= new Block_GVC_DecoFacingBlock(14, false).setUnlocalizedName("gvcr2_block_medbag_gc")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_medbag_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_medbag_gc);
			
			mod.gvcr2_block_laptop	= new Block_GVC_DecoFacingBlock(15, false).setUnlocalizedName("gvcr2_block_laptop")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_laptop").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_laptop);
			
			mod.gvcr2_block_toughbook	= new Block_GVC_DecoFacingBlock(16, false).setUnlocalizedName("gvcr2_block_toughbook")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_toughbook").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_toughbook);
			
			mod.gvcr2_block_monitor1	= new Block_GVC_DecoFacingBlock(17, false).setUnlocalizedName("gvcr2_block_monitor1")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_monitor1").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_monitor1);
			
			mod.gvcr2_block_man_target	= new Block_GVC_DecoFacingBlock(18, true).setUnlocalizedName("gvcr2_block_man_target")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_man_target").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_man_target);
			
			mod.gvcr2_block_old_radio	= new Block_GVC_DecoFacingBlock(19, true).setUnlocalizedName("gvcr2_block_old_radio")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_old_radio").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_old_radio);
			
			mod.gvcr2_block_radio_big	= new Block_GVC_DecoFacingBlock(20, true).setUnlocalizedName("gvcr2_block_radio_big")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_radio_big").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_radio_big);
			
			mod.gvcr2_block_sincgars	= new Block_GVC_DecoFacingBlock(21, true).setUnlocalizedName("gvcr2_block_sincgars")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_sincgars").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_sincgars);
			
			mod.gvcr2_block_burn_barrel	= new Block_GVC_DecoFacingBlock(22, true).setUnlocalizedName("gvcr2_block_burn_barrel")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_burn_barrel").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_burn_barrel);
			
			mod.gvcr2_block_at_obstacles	= new Block_GVC_DecoFacingBlock(23, true).setUnlocalizedName("gvcr2_block_at_obstacles")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_at_obstacles").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_at_obstacles);
			
			mod.gvcr2_block_barbed1_gc	= new Block_GVC_DecoFacingBlock(24, false).setUnlocalizedName("gvcr2_block_barbed1_gc").setHardness(2.0F).setResistance(100.0F)
					.setRegistryName(mod.MOD_ID, "gvcr2_block_barbed1_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_barbed1_gc);
			
			mod.gvcr2_block_barbed2_gc	= new Block_GVC_DecoFacingBlock(25, false).setUnlocalizedName("gvcr2_block_barbed2_gc").setHardness(2.0F).setResistance(100.0F)
					.setRegistryName(mod.MOD_ID, "gvcr2_block_barbed2_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_barbed2_gc);
			
			mod.gvcr2_block_fire_exti_gc	= new Block_GVC_DecoFacingBlock(26, false).setUnlocalizedName("gvcr2_block_fire_exti_gc")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_fire_exti_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_fire_exti_gc);
			
			mod.gvcr2_block_mil_cont1_gc	= new Block_GVC_DecoFacingBlock(27, true).setUnlocalizedName("gvcr2_block_mil_cont1_gc")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_mil_cont1_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_mil_cont1_gc);
			
			mod.gvcr2_block_mil_cont2_gc	= new Block_GVC_DecoFacingBlock(28, true).setUnlocalizedName("gvcr2_block_mil_cont2_gc")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_mil_cont2_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_mil_cont2_gc);
			
			mod.gvcr2_block_odunit_gc	= new Block_GVC_DecoFacingBlock(29, true).setUnlocalizedName("gvcr2_block_odunit_gc")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_odunit_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_odunit_gc);
			
			mod.gvcr2_block_sandbag_a1_gc	= new Block_GVC_DecoFacingBlock(30, true).setUnlocalizedName("gvcr2_block_sandbag_a1_gc").setHardness(3.0F).setResistance(100.0F)
					.setRegistryName(mod.MOD_ID, "gvcr2_block_sandbag_a1_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_sandbag_a1_gc);
			
			mod.gvcr2_block_sandbag_a2_gc	= new Block_GVC_DecoFacingBlock(31, true).setUnlocalizedName("gvcr2_block_sandbag_a2_gc").setHardness(3.0F).setResistance(100.0F)
					.setRegistryName(mod.MOD_ID, "gvcr2_block_sandbag_a2_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_sandbag_a2_gc);
			
			//240224変更
			mod.gvcr2_block_sandbag_b1_gc	= new Block(Material.SAND, MapColor.SAND).setUnlocalizedName("gvcr2_block_sandbag_b1_gc").setHardness(3.0F).setResistance(100.0F)
					.setRegistryName(mod.MOD_ID, "gvcr2_block_sandbag_b1_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_sandbag_b1_gc);
			
			mod.gvcr2_block_sandbag_b2_gc	= new Block_GVC_DecoFacingBlock(33, true).setUnlocalizedName("gvcr2_block_sandbag_b2_gc").setHardness(3.0F).setResistance(100.0F)
					.setRegistryName(mod.MOD_ID, "gvcr2_block_sandbag_b2_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_sandbag_b2_gc);
			
			mod.gvcr2_block_t_wall1_gc	= new Block_GVC_DecoFacingBlock(34, true).setUnlocalizedName("gvcr2_block_t_wall1_gc")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_t_wall1_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_t_wall1_gc);
			
			mod.gvcr2_block_t_wall2_gc	= new Block_GVC_DecoFacingBlock(35, true).setUnlocalizedName("gvcr2_block_t_wall2_gc")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_t_wall2_gc").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_t_wall2_gc);
			
			mod.gvcr2_block_wolcott	= new Block_GVC_DecoFacingBlock(36, true).setUnlocalizedName("gvcr2_block_wolcott")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_wolcott").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_wolcott);
			
			mod.gvcr2_block_fslight	= new Block_GVC_DecoFacingBlock(46, false).setUnlocalizedName("gvcr2_block_fslight")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_fslight").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_fslight);
			
			
			mod.gvcr2_block_lantern_g	= new Block_GVC_DecoFacingBlock(47, false).setUnlocalizedName("gvcr2_block_lantern_g")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_lantern_g").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_lantern_g);
			
			//mod.gvcr2_block_light_block_g	= new Block_GVC_DecoFacingBlock(48, false).setUnlocalizedName("gvcr2_block_light_block_g")
			//		.setRegistryName(mod.MOD_ID, "gvcr2_block_light_block_g").setCreativeTab(mod.tabgg_block);
			//event.getRegistry().register(mod.gvcr2_block_light_block_g);
			
			mod.gvcr2_block_light_block_g	= new Block(Material.ROCK).setHardness(3.0F).setResistance(3.0F).setLightOpacity(1).setLightLevel(1.0F).setUnlocalizedName("gvcr2_block_light_block_g")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_light_block_g").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_light_block_g);
			
			mod.gvcr2_block_wall_light_gg	= new Block_GVC_DecoFacingBlock(49, false).setUnlocalizedName("gvcr2_block_wall_light_gg")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_wall_light_gg").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_wall_light_gg);
			
			mod.gvcr2_block_wall_light_rg	= new Block_GVC_DecoFacingBlock(50, false).setUnlocalizedName("gvcr2_block_wall_light_rg")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_wall_light_rg").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_wall_light_rg);
			
			mod.gvcr2_block_wall_light_wg	= new Block_GVC_DecoFacingBlock(51, false).setUnlocalizedName("gvcr2_block_wall_light_wg")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_wall_light_wg").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_wall_light_wg);
			
			mod.gvcr2_block_rack_g1	= new Block_GVC_DecoFacingBlock(52, false).setUnlocalizedName("gvcr2_block_rack_g1")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_rack_g1").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_rack_g1);
			
			mod.gvcr2_block_rack_g2	= new Block_GVC_DecoFacingBlock(53, false).setUnlocalizedName("gvcr2_block_rack_g2")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_rack_g2").setCreativeTab(mod.tabgg_block);
			event.getRegistry().register(mod.gvcr2_block_rack_g2);
			
		}
		mod.gvcr2_block_ghostlight	= new Block_GhostLight().setUnlocalizedName("gvcr2_block_ghostlight")
				.setRegistryName(mod.MOD_ID, "gvcr2_block_ghostlight").setCreativeTab(mod.tabgg_block);
		event.getRegistry().register(mod.gvcr2_block_ghostlight);
		
		GameRegistry.registerTileEntity(TileEntityBlock_GhostLight_Tile.class, "TileEntityBlock_GhostLight_Tile");
		mod.gvcr2_block_ghostlight_tile	= new Block_GhostLight_Tile().setUnlocalizedName("gvcr2_block_ghostlight_tile")
				.setRegistryName(mod.MOD_ID, "gvcr2_block_ghostlight_tile").setCreativeTab(mod.tabgg_block);
		event.getRegistry().register(mod.gvcr2_block_ghostlight_tile);
		
		mod.gvcr2_block_scaffold	= new Block_Scaffold().setUnlocalizedName("gvcr2_block_scaffold")
				.setRegistryName(mod.MOD_ID, "gvcr2_block_scaffold").setCreativeTab(mod.tabgg_block);
		event.getRegistry().register(mod.gvcr2_block_scaffold);
		
		
	}
}

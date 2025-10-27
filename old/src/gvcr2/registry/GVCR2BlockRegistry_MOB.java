package gvcr2.registry;

import gvcr2.mod_GVCR2;
import gvcr2.block.BlockBossSpawn_Tile;
import gvcr2.block.BlockBuilding_Chest;
import gvcr2.block.BlockSpawn_INV_Change;
import gvcr2.block.BlockSpawn_ONE;
import gvcr2.block.BlockSpawn_Spawner;
import gvcr2.block.tile.TileEntityBlockSpawn_INV_Change;
import gvcr2.block.tile.TileEntityBlockSpawn_ONE;
import gvcr2.block.tile.TileEntityBuilding_Chest;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GVCR2BlockRegistry_MOB {
	public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Block> event){
		
		
		
		GameRegistry.registerTileEntity(TileEntityBlockSpawn_ONE.class, "TileEntityBlockSpawn_ONE");
		{
			mod.gvcr2_block_ge_s	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_ge_s")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_ge_s").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_ge_s);
			
			
			mod.gvcr2_block_ge_sv	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_ge_sv")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_ge_sv").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_ge_sv);
			mod.gvcr2_block_ge_sv_fire	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_ge_sv_fire")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_ge_sv_fire").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_ge_sv_fire);
			mod.gvcr2_block_ge_sv_trench	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_ge_sv_trench")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_ge_sv_trench").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_ge_sv_trench);
			mod.gvcr2_block_ge_sv_antitank	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_ge_sv_antitank")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_ge_sv_antitank").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_ge_sv_antitank);
			mod.gvcr2_block_ge_sv_sniper	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_ge_sv_sniper")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_ge_sv_sniper").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_ge_sv_sniper);
			mod.gvcr2_block_ge_sv_drone	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_ge_sv_drone")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_ge_sv_drone").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_ge_sv_drone);
			
			
			mod.gvcr2_block_ge_se_assault	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_ge_se_assault")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_ge_se_assault").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_ge_se_assault);
			mod.gvcr2_block_ge_se_cerberus	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_ge_se_cerberus")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_ge_se_cerberus").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_ge_se_cerberus);
			mod.gvcr2_block_ge_se_hacs	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_ge_se_hacs")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_ge_se_hacs").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_ge_se_hacs);
			mod.gvcr2_block_ge_se_kukri	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_ge_se_kukri")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_ge_se_kukri").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_ge_se_kukri);
			
			mod.gvcr2_block_ge_s_mr_cpt	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_ge_s_mr_cpt")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_ge_s_mr_cpt").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_ge_s_mr_cpt);
		}
		
		{
			mod.gvcr2_block_boss_longleg	= new BlockBossSpawn_Tile().setUnlocalizedName("gvcr2_block_boss_longleg")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_boss_longleg").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_boss_longleg);
			
			mod.gvcr2_block_boss_st1	= new BlockBossSpawn_Tile().setUnlocalizedName("gvcr2_block_boss_st1")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_boss_st1").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_boss_st1);
			
			mod.gvcr2_block_boss_mer08	= new BlockBossSpawn_Tile().setUnlocalizedName("gvcr2_block_boss_mer08")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_boss_mer08").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_boss_mer08);
			
			mod.gvcr2_block_boss_mer08_sn	= new BlockBossSpawn_Tile().setUnlocalizedName("gvcr2_block_boss_mer08_sn")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_boss_mer08_sn").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_boss_mer08_sn);
			
			mod.gvcr2_block_boss_mer08_b	= new BlockBossSpawn_Tile().setUnlocalizedName("gvcr2_block_boss_mer08_b")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_boss_mer08_b").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_boss_mer08_b);
			
			mod.gvcr2_block_boss_mer03k	= new BlockBossSpawn_Tile().setUnlocalizedName("gvcr2_block_boss_mer03k")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_boss_mer03k").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_boss_mer03k);
			
			mod.gvcr2_block_boss_hauneb	= new BlockBossSpawn_Tile().setUnlocalizedName("gvcr2_block_boss_hauneb")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_boss_hauneb").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_boss_hauneb);
			
			mod.gvcr2_block_boss_irving	= new BlockBossSpawn_Tile().setUnlocalizedName("gvcr2_block_boss_irving")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_boss_irving").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_boss_irving);
			
			mod.gvcr2_block_boss_char2c	= new BlockBossSpawn_Tile().setUnlocalizedName("gvcr2_block_boss_char2c")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_boss_char2c").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_boss_char2c);
			
			mod.gvcr2_block_boss_av8b	= new BlockBossSpawn_Tile().setUnlocalizedName("gvcr2_block_boss_av8b")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_boss_av8b").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_boss_av8b);
			
			mod.gvcr2_block_boss_ratte	= new BlockBossSpawn_Tile().setUnlocalizedName("gvcr2_block_boss_ratte")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_boss_ratte").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_boss_ratte);
			
		}
		
		{
			mod.gvcr2_block_so_s	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_so_s")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_so_s").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_so_s);
			
			mod.gvcr2_block_so_s_mr_cpt	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_so_s_mr_cpt")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_so_s_mr_cpt").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_so_s_mr_cpt);
			
			mod.gvcr2_block_so_s_af_cpt	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_so_s_af_cpt")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_so_s_af_cpt").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_so_s_af_cpt);
		}
		{
			mod.gvcr2_block_npc_arms_trader	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_npc_arms_trader")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_npc_arms_trader").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_npc_arms_trader);
		}
		
		{
			mod.gvcr2_block_set_mg_m60	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_set_mg_m60")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_set_mg_m60").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_set_mg_m60);
			mod.gvcr2_block_set_mg_m2	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_set_mg_m2")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_set_mg_m2").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_set_mg_m2);
			mod.gvcr2_block_set_mg_pkm	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_set_mg_pkm")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_set_mg_pkm").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_set_mg_pkm);
			mod.gvcr2_block_set_mg_dp28	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_set_mg_dp28")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_set_mg_dp28").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_set_mg_dp28);
		}
		{
			mod.gvcr2_block_set_aa_20mmaa	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_set_aa_20mmaa")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_set_aa_20mmaa").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_set_aa_20mmaa);
			mod.gvcr2_block_set_aa_vads	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_set_aa_vads")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_set_aa_vads").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_set_aa_vads);
			mod.gvcr2_block_set_aa_zu23	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_set_aa_zu23")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_set_aa_zu23").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_set_aa_zu23);
		}
		{
			mod.gvcr2_block_set_mg_pak40	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_set_mg_pak40")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_set_mg_pak40").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_set_mg_pak40);
			mod.gvcr2_block_set_mg_flak18	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_set_mg_flak18")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_set_mg_flak18").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_set_mg_flak18);
			mod.gvcr2_block_set_mg_tow2	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_set_mg_tow2")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_set_mg_tow2").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_set_mg_tow2);
			
			mod.gvcr2_block_set_mg_m224	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_set_mg_m224")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_set_mg_m224").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_set_mg_m224);
			mod.gvcr2_block_set_mg_fh18	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_set_mg_fh18")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_set_mg_fh18").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_set_mg_fh18);
			
			mod.gvcr2_block_set_mg_ak130	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_set_mg_ak130")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_set_mg_ak130").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_set_mg_ak130);
			mod.gvcr2_block_set_mk15_phalanx	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_set_mk15_phalanx")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_set_mk15_phalanx").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_set_mk15_phalanx);
			mod.gvcr2_block_set_mk45_mod4	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_set_mk45_mod4")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_set_mk45_mod4").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_set_mk45_mod4);
		}
		
		{
			mod.gvcr2_block_apc_m113	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_apc_m113")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_apc_m113").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_apc_m113);
			mod.gvcr2_block_tank_m60a1	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_tank_m60a1")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_tank_m60a1").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_tank_m60a1);
			mod.gvcr2_block_heli_ah1s	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_heli_ah1s")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_heli_ah1s").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_heli_ah1s);
			mod.gvcr2_block_apc_9k35	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_apc_9k35")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_apc_9k35").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_apc_9k35);
			mod.gvcr2_block_apc_m1097	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_apc_m1097")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_apc_m1097").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_apc_m1097);
			mod.gvcr2_block_air_a4	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_air_a4")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_air_a4").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_air_a4);
			mod.gvcr2_block_air_yak23kai	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_air_yak23kai")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_air_yak23kai").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_air_yak23kai);
			
			
			mod.gvcr2_block_tank_t34	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_tank_t34")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_tank_t34").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_tank_t34);
			mod.gvcr2_block_tank_kv2	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_tank_kv2")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_tank_kv2").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_tank_kv2);
			mod.gvcr2_block_heli_g_heli	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_heli_g_heli")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_heli_g_heli").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_heli_g_heli);
			mod.gvcr2_block_ship_cruiser	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_ship_cruiser")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_ship_cruiser").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_ship_cruiser);
			
			mod.gvcr2_block_ship_pr1204	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_ship_pr1204")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_ship_pr1204").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_ship_pr1204);
			
			mod.gvcr2_block_tank_t72	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_tank_t72")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_tank_t72").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_tank_t72);
			mod.gvcr2_block_tank_2k22	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_tank_2k22")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_tank_2k22").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_tank_2k22);
			mod.gvcr2_block_heli_mi24d	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_heli_mi24d")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_heli_mi24d").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_heli_mi24d);
		}
		
		
		{
			GameRegistry.registerTileEntity(TileEntityBuilding_Chest.class, "TileEntityBuilding_Chest");
			mod.gvcr2_block_chest_food	= new BlockBuilding_Chest().setUnlocalizedName("gvcr2_block_chest_food")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_chest_food").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_chest_food);
			mod.gvcr2_block_chest_weapon	= new BlockBuilding_Chest().setUnlocalizedName("gvcr2_block_chest_weapon")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_chest_weapon").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_chest_weapon);
			mod.gvcr2_block_chest_weapon2	= new BlockBuilding_Chest().setUnlocalizedName("gvcr2_block_chest_weapon2")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_chest_weapon2").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_chest_weapon2);
			mod.gvcr2_block_chest_weapon3	= new BlockBuilding_Chest().setUnlocalizedName("gvcr2_block_chest_weapon3")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_chest_weapon3").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_chest_weapon3);
			mod.gvcr2_block_chest_weapon4	= new BlockBuilding_Chest().setUnlocalizedName("gvcr2_block_chest_weapon4")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_chest_weapon4").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_chest_weapon4);
			
			mod.gvcr2_block_setair	= new BlockBuilding_Chest().setUnlocalizedName("gvcr2_block_setair")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_setair").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_block_setair);
		}
		
		
		
		//GameRegistry.registerTileEntity(TileEntityBlockSpawn_ONE.class, "TileEntityBlockSpawn_ONE");
		{
			mod.gvcr2_blockspawner_ge_s	= new BlockSpawn_Spawner().setUnlocalizedName("gvcr2_blockspawner_ge_s")
					.setRegistryName(mod.MOD_ID, "gvcr2_blockspawner_ge_s").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_blockspawner_ge_s);
			
			mod.gvcr2_blockspawner_so_s	= new BlockSpawn_Spawner().setUnlocalizedName("gvcr2_blockspawner_so_s")
					.setRegistryName(mod.MOD_ID, "gvcr2_blockspawner_so_s").setCreativeTab(mod.tabgg_building);
			event.getRegistry().register(mod.gvcr2_blockspawner_so_s);
		}
		
		mod.gvcr2_block_cv_jamming	= new BlockSpawn_ONE().setUnlocalizedName("gvcr2_block_cv_jamming")
				.setRegistryName(mod.MOD_ID, "gvcr2_block_cv_jamming").setCreativeTab(mod.tabgg_block);
		event.getRegistry().register(mod.gvcr2_block_cv_jamming);
		
		
		GameRegistry.registerTileEntity(TileEntityBlockSpawn_INV_Change.class, "TileEntityBlockSpawn_INV_Change");
		mod.gvcr2_block_invate_zu23_mk15	= new BlockSpawn_INV_Change().setUnlocalizedName("gvcr2_block_invate_zu23_mk15")
				.setRegistryName(mod.MOD_ID, "gvcr2_block_invate_zu23_mk15").setCreativeTab(mod.tabgg_block);
		event.getRegistry().register(mod.gvcr2_block_invate_zu23_mk15);
		
		
	}
}

package gvcr2.registry;

import gvcr2.mod_GVCR2;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;

public class GVCR2ItemRegistry_Block {
	public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Item> event){
		
		
		registryItemBlock(mod, event, mod.gvcr2_block_mine, "gvcr2_block_mine");
		registryItemBlock(mod, event, mod.gvcr2_block_atmine, "gvcr2_block_atmine");
		registryItemBlock(mod, event, mod.gvcr2_block_ied, "gvcr2_block_ied");
		registryItemBlock(mod, event, mod.gvcr2_block_bomb, "gvcr2_block_bomb");
		registryItemBlock(mod, event, mod.gvcr2_block_water_mine, "gvcr2_block_water_mine");
		registryItemBlock(mod, event, mod.gvcr2_block_propane, "gvcr2_block_propane");
		registryItemBlock(mod, event, mod.gvcr2_block_bouy, "gvcr2_block_bouy");
		
		registryItemBlock(mod, event, mod.gvcr2_block_supplies_air, "gvcr2_block_supplies_air");
		registryItemBlock(mod, event, mod.gvcr2_block_supplies_1, "gvcr2_block_supplies_1");
		registryItemBlock(mod, event, mod.gvcr2_block_supplies_2, "gvcr2_block_supplies_2");
		registryItemBlock(mod, event, mod.gvcr2_block_supplies_3, "gvcr2_block_supplies_3");
		registryItemBlock(mod, event, mod.gvcr2_block_supplies_4, "gvcr2_block_supplies_4");
		registryItemBlock(mod, event, mod.gvcr2_block_supplies_scrap, "gvcr2_block_supplies_scrap");
		
		
		registryItemBlock(mod, event, mod.gvcr2_block_ammobox1, "gvcr2_block_ammobox1");
		registryItemBlock(mod, event, mod.gvcr2_block_artibox1, "gvcr2_block_artibox1");
		registryItemBlock(mod, event, mod.gvcr2_block_artibox2, "gvcr2_block_artibox2");
		registryItemBlock(mod, event, mod.gvcr2_block_artibox3, "gvcr2_block_artibox3");
		registryItemBlock(mod, event, mod.gvcr2_block_barrel_drum1, "gvcr2_block_barrel_drum1");
		registryItemBlock(mod, event, mod.gvcr2_block_barrel_drum2, "gvcr2_block_barrel_drum2");
		registryItemBlock(mod, event, mod.gvcr2_block_barrel_drum3, "gvcr2_block_barrel_drum3");
		registryItemBlock(mod, event, mod.gvcr2_block_cadaver_g, "gvcr2_block_cadaver_g");
		registryItemBlock(mod, event, mod.gvcr2_block_hesco, "gvcr2_block_hesco");
		registryItemBlock(mod, event, mod.gvcr2_block_jerrycan1, "gvcr2_block_jerrycan1");
		registryItemBlock(mod, event, mod.gvcr2_block_missile_rack1, "gvcr2_block_missile_rack1");
		
		
		registryItemBlock(mod, event, mod.gvcr2_block_9mmpack_gc, "gvcr2_block_9mmpack_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_45pack_gc, "gvcr2_block_45pack_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_223pack_gc, "gvcr2_block_223pack_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_308pack_gc, "gvcr2_block_308pack_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_50bmgpack_gc, "gvcr2_block_50bmgpack_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_12gpack_gc, "gvcr2_block_12gpack_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_40mmgr_ammo_gc, "gvcr2_block_40mmgr_ammo_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_grenade_box_gc, "gvcr2_block_grenade_box_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_rpg_ammobox1, "gvcr2_block_rpg_ammobox1");
		registryItemBlock(mod, event, mod.gvcr2_block_rpg_ammobox2, "gvcr2_block_rpg_ammobox2");
		registryItemBlock(mod, event, mod.gvcr2_block_ammo_mass, "gvcr2_block_ammo_mass");
		registryItemBlock(mod, event, mod.gvcr2_block_m18_claymore, "gvcr2_block_m18_claymore");
		registryItemBlock(mod, event, mod.gvcr2_block_m72_box, "gvcr2_block_m72_box");
		registryItemBlock(mod, event, mod.gvcr2_block_rpg_box, "gvcr2_block_rpg_box");
		registryItemBlock(mod, event, mod.gvcr2_block_medbag_gc, "gvcr2_block_medbag_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_laptop, "gvcr2_block_laptop");
		registryItemBlock(mod, event, mod.gvcr2_block_toughbook, "gvcr2_block_toughbook");
		registryItemBlock(mod, event, mod.gvcr2_block_monitor1, "gvcr2_block_monitor1");
		registryItemBlock(mod, event, mod.gvcr2_block_man_target, "gvcr2_block_man_target");
		registryItemBlock(mod, event, mod.gvcr2_block_old_radio, "gvcr2_block_old_radio");
		registryItemBlock(mod, event, mod.gvcr2_block_radio_big, "gvcr2_block_radio_big");
		registryItemBlock(mod, event, mod.gvcr2_block_sincgars, "gvcr2_block_sincgars");
		registryItemBlock(mod, event, mod.gvcr2_block_burn_barrel, "gvcr2_block_burn_barrel");
		registryItemBlock(mod, event, mod.gvcr2_block_at_obstacles, "gvcr2_block_at_obstacles");
		registryItemBlock(mod, event, mod.gvcr2_block_barbed1_gc, "gvcr2_block_barbed1_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_barbed2_gc, "gvcr2_block_barbed2_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_fire_exti_gc, "gvcr2_block_fire_exti_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_mil_cont1_gc, "gvcr2_block_mil_cont1_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_mil_cont2_gc, "gvcr2_block_mil_cont2_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_odunit_gc, "gvcr2_block_odunit_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_sandbag_a1_gc, "gvcr2_block_sandbag_a1_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_sandbag_a2_gc, "gvcr2_block_sandbag_a2_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_sandbag_b1_gc, "gvcr2_block_sandbag_b1_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_sandbag_b2_gc, "gvcr2_block_sandbag_b2_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_t_wall1_gc, "gvcr2_block_t_wall1_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_t_wall2_gc, "gvcr2_block_t_wall2_gc");
		registryItemBlock(mod, event, mod.gvcr2_block_wolcott, "gvcr2_block_wolcott");
		registryItemBlock(mod, event, mod.gvcr2_block_fslight, "gvcr2_block_fslight");
		registryItemBlock(mod, event, mod.gvcr2_block_ghostlight, "gvcr2_block_ghostlight");
		registryItemBlock(mod, event, mod.gvcr2_block_ghostlight_tile, "gvcr2_block_ghostlight_tile");
		registryItemBlock(mod, event, mod.gvcr2_block_scaffold, "gvcr2_block_scaffold");
		registryItemBlock(mod, event, mod.gvcr2_block_lantern_g, "gvcr2_block_lantern_g");
		registryItemBlock(mod, event, mod.gvcr2_block_light_block_g, "gvcr2_block_light_block_g");
		registryItemBlock(mod, event, mod.gvcr2_block_wall_light_gg, "gvcr2_block_wall_light_gg");
		registryItemBlock(mod, event, mod.gvcr2_block_wall_light_rg, "gvcr2_block_wall_light_rg");
		registryItemBlock(mod, event, mod.gvcr2_block_wall_light_wg, "gvcr2_block_wall_light_wg");
		registryItemBlock(mod, event, mod.gvcr2_block_rack_g1, "gvcr2_block_rack_g1");
		registryItemBlock(mod, event, mod.gvcr2_block_rack_g2, "gvcr2_block_rack_g2");
		
		
		
		registryItemBlock(mod, event, mod.gvcr2_block_bulletcrafter_1, "gvcr2_block_bulletcrafter_1");
		
		registryItemBlock(mod, event, mod.gvcr2_block_guncrafter_1, "gvcr2_block_guncrafter_1");
		registryItemBlock(mod, event, mod.gvcr2_block_guncrafter_2, "gvcr2_block_guncrafter_2");
		registryItemBlock(mod, event, mod.gvcr2_block_guncrafter_3, "gvcr2_block_guncrafter_3");
		
		registryItemBlock(mod, event, mod.gvcr2_block_vehiclecrafter_1, "gvcr2_block_vehiclecrafter_1");
		registryItemBlock(mod, event, mod.gvcr2_block_vehiclecrafter_2, "gvcr2_block_vehiclecrafter_2");
		registryItemBlock(mod, event, mod.gvcr2_block_vehiclecrafter_3, "gvcr2_block_vehiclecrafter_3");
		
		registryItemBlock(mod, event, mod.gvcr2_block_gunrack_hsin, "gvcr2_block_gunrack_hsin");
		registryItemBlock(mod, event, mod.gvcr2_block_gunrack_rsin, "gvcr2_block_gunrack_rsin");
		registryItemBlock(mod, event, mod.gvcr2_block_gunrack_rswn, "gvcr2_block_gunrack_rswn");
		registryItemBlock(mod, event, mod.gvcr2_block_gunrack_hti, "gvcr2_block_gunrack_hti");
		registryItemBlock(mod, event, mod.gvcr2_block_gunrack_rti1, "gvcr2_block_gunrack_rti1");
		registryItemBlock(mod, event, mod.gvcr2_block_gunrack_rti2, "gvcr2_block_gunrack_rti2");
		
		registryItemBlock(mod, event, mod.gvcr2_block_gunrack_hsin_deco, "gvcr2_block_gunrack_hsin_deco");
		registryItemBlock(mod, event, mod.gvcr2_block_gunrack_rsin_deco, "gvcr2_block_gunrack_rsin_deco");
		registryItemBlock(mod, event, mod.gvcr2_block_gunrack_rswn_deco, "gvcr2_block_gunrack_rswn_deco");
		registryItemBlock(mod, event, mod.gvcr2_block_gunrack_hti_deco, "gvcr2_block_gunrack_hti_deco");
		registryItemBlock(mod, event, mod.gvcr2_block_gunrack_rti1_deco, "gvcr2_block_gunrack_rti1_deco");
		registryItemBlock(mod, event, mod.gvcr2_block_gunrack_rti2_deco, "gvcr2_block_gunrack_rti2_deco");
		
		
		registryItemBlock(mod, event, mod.gvcr2_block_cv_jamming, "gvcr2_block_cv_jamming");
		
		
		registryItemBlock(mod, event, mod.gvcr2_block_ge_s, "gvcr2_block_ge_s");
		
		registryItemBlock(mod, event, mod.gvcr2_block_ge_sv, "gvcr2_block_ge_sv");
		registryItemBlock(mod, event, mod.gvcr2_block_ge_sv_fire, "gvcr2_block_ge_sv_fire");
		registryItemBlock(mod, event, mod.gvcr2_block_ge_sv_trench, "gvcr2_block_ge_sv_trench");
		registryItemBlock(mod, event, mod.gvcr2_block_ge_sv_antitank, "gvcr2_block_ge_sv_antitank");
		registryItemBlock(mod, event, mod.gvcr2_block_ge_sv_sniper, "gvcr2_block_ge_sv_sniper");
		registryItemBlock(mod, event, mod.gvcr2_block_ge_sv_drone, "gvcr2_block_ge_sv_drone");
		
		registryItemBlock(mod, event, mod.gvcr2_block_ge_se_assault, "gvcr2_block_ge_se_assault");
		registryItemBlock(mod, event, mod.gvcr2_block_ge_se_cerberus, "gvcr2_block_ge_se_cerberus");
		registryItemBlock(mod, event, mod.gvcr2_block_ge_se_hacs, "gvcr2_block_ge_se_hacs");
		registryItemBlock(mod, event, mod.gvcr2_block_ge_se_kukri, "gvcr2_block_ge_se_kukri");
		
		registryItemBlock(mod, event, mod.gvcr2_block_ge_s_mr_cpt, "gvcr2_block_ge_s_mr_cpt");
		
		
		
		registryItemBlock(mod, event, mod.gvcr2_block_boss_longleg, "gvcr2_block_boss_longleg");
		registryItemBlock(mod, event, mod.gvcr2_block_boss_st1, "gvcr2_block_boss_st1");
		registryItemBlock(mod, event, mod.gvcr2_block_boss_mer08, "gvcr2_block_boss_mer08");
		registryItemBlock(mod, event, mod.gvcr2_block_boss_mer08_sn, "gvcr2_block_boss_mer08_sn");
		registryItemBlock(mod, event, mod.gvcr2_block_boss_mer08_b, "gvcr2_block_boss_mer08_b");
		registryItemBlock(mod, event, mod.gvcr2_block_boss_mer03k, "gvcr2_block_boss_mer03k");
		registryItemBlock(mod, event, mod.gvcr2_block_boss_hauneb, "gvcr2_block_boss_hauneb");
		registryItemBlock(mod, event, mod.gvcr2_block_boss_irving, "gvcr2_block_boss_irving");
		registryItemBlock(mod, event, mod.gvcr2_block_boss_char2c, "gvcr2_block_boss_char2c");
		registryItemBlock(mod, event, mod.gvcr2_block_boss_av8b, "gvcr2_block_boss_av8b");
		registryItemBlock(mod, event, mod.gvcr2_block_boss_ratte, "gvcr2_block_boss_ratte");
		
		
		
		registryItemBlock(mod, event, mod.gvcr2_block_so_s, "gvcr2_block_so_s");
		registryItemBlock(mod, event, mod.gvcr2_block_so_s_mr_cpt, "gvcr2_block_so_s_mr_cpt");
		registryItemBlock(mod, event, mod.gvcr2_block_so_s_af_cpt, "gvcr2_block_so_s_af_cpt");
		registryItemBlock(mod, event, mod.gvcr2_block_npc_arms_trader, "gvcr2_block_npc_arms_trader");
		
		
		registryItemBlock(mod, event, mod.gvcr2_block_set_mg_m60, "gvcr2_block_set_mg_m60");
		registryItemBlock(mod, event, mod.gvcr2_block_set_mg_m2, "gvcr2_block_set_mg_m2");
		registryItemBlock(mod, event, mod.gvcr2_block_set_mg_pkm, "gvcr2_block_set_mg_pkm");
		registryItemBlock(mod, event, mod.gvcr2_block_set_mg_dp28, "gvcr2_block_set_mg_dp28");
		
		registryItemBlock(mod, event, mod.gvcr2_block_set_aa_20mmaa, "gvcr2_block_set_aa_20mmaa");
		registryItemBlock(mod, event, mod.gvcr2_block_set_aa_vads, "gvcr2_block_set_aa_vads");
		registryItemBlock(mod, event, mod.gvcr2_block_set_aa_zu23, "gvcr2_block_set_aa_zu23");
		
		registryItemBlock(mod, event, mod.gvcr2_block_set_mg_pak40, "gvcr2_block_set_mg_pak40");
		registryItemBlock(mod, event, mod.gvcr2_block_set_mg_flak18, "gvcr2_block_set_mg_flak18");
		registryItemBlock(mod, event, mod.gvcr2_block_set_mg_tow2, "gvcr2_block_set_mg_tow2");
		
		registryItemBlock(mod, event, mod.gvcr2_block_set_mg_m224, "gvcr2_block_set_mg_m224");
		registryItemBlock(mod, event, mod.gvcr2_block_set_mg_fh18, "gvcr2_block_set_mg_fh18");
		
		registryItemBlock(mod, event, mod.gvcr2_block_set_mg_ak130, "gvcr2_block_set_mg_ak130");
		registryItemBlock(mod, event, mod.gvcr2_block_set_mk15_phalanx, "gvcr2_block_set_mk15_phalanx");
		registryItemBlock(mod, event, mod.gvcr2_block_set_mk45_mod4, "gvcr2_block_set_mk45_mod4");
		
		
		
		registryItemBlock(mod, event, mod.gvcr2_block_apc_m113, "gvcr2_block_apc_m113");
		registryItemBlock(mod, event, mod.gvcr2_block_tank_m60a1, "gvcr2_block_tank_m60a1");
		registryItemBlock(mod, event, mod.gvcr2_block_heli_ah1s, "gvcr2_block_heli_ah1s");
		registryItemBlock(mod, event, mod.gvcr2_block_apc_9k35, "gvcr2_block_apc_9k35");
		registryItemBlock(mod, event, mod.gvcr2_block_apc_m1097, "gvcr2_block_apc_m1097");
		registryItemBlock(mod, event, mod.gvcr2_block_air_a4, "gvcr2_block_air_a4");
		registryItemBlock(mod, event, mod.gvcr2_block_air_yak23kai, "gvcr2_block_air_yak23kai");
		
		registryItemBlock(mod, event, mod.gvcr2_block_tank_t34, "gvcr2_block_tank_t34");
		registryItemBlock(mod, event, mod.gvcr2_block_tank_kv2, "gvcr2_block_tank_kv2");
		registryItemBlock(mod, event, mod.gvcr2_block_heli_g_heli, "gvcr2_block_heli_g_heli");
		registryItemBlock(mod, event, mod.gvcr2_block_ship_cruiser, "gvcr2_block_ship_cruiser");
		registryItemBlock(mod, event, mod.gvcr2_block_ship_pr1204, "gvcr2_block_ship_pr1204");
		
		registryItemBlock(mod, event, mod.gvcr2_block_tank_t72, "gvcr2_block_tank_t72");
		registryItemBlock(mod, event, mod.gvcr2_block_tank_2k22, "gvcr2_block_tank_2k22");
		registryItemBlock(mod, event, mod.gvcr2_block_heli_mi24d, "gvcr2_block_heli_mi24d");
		
		
		
		registryItemBlock(mod, event, mod.gvcr2_blockspawner_ge_s, "gvcr2_blockspawner_ge_s");
		registryItemBlock(mod, event, mod.gvcr2_blockspawner_so_s, "gvcr2_blockspawner_so_s");
		
		
		registryItemBlock(mod, event, mod.gvcr2_block_chest_food, "gvcr2_block_chest_food");
		registryItemBlock(mod, event, mod.gvcr2_block_chest_weapon, "gvcr2_block_chest_weapon");
		registryItemBlock(mod, event, mod.gvcr2_block_chest_weapon2, "gvcr2_block_chest_weapon2");
		registryItemBlock(mod, event, mod.gvcr2_block_chest_weapon3, "gvcr2_block_chest_weapon3");
		registryItemBlock(mod, event, mod.gvcr2_block_chest_weapon4, "gvcr2_block_chest_weapon4");
		registryItemBlock(mod, event, mod.gvcr2_block_setair, "gvcr2_block_setair");
		
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_camp, "gvcr2_block_building_camp");
		registryItemBlock(mod, event, mod.gvcr2_block_building_hideout, "gvcr2_block_building_hideout");
		registryItemBlock(mod, event, mod.gvcr2_block_building_hideout_de, "gvcr2_block_building_hideout_de");
		registryItemBlock(mod, event, mod.gvcr2_block_building_mg_place, "gvcr2_block_building_mg_place");
		registryItemBlock(mod, event, mod.gvcr2_block_building_mg_place_de, "gvcr2_block_building_mg_place_de");
		registryItemBlock(mod, event, mod.gvcr2_block_building_mg_place_sf, "gvcr2_block_building_mg_place_sf");
		registryItemBlock(mod, event, mod.gvcr2_block_building_aaplace, "gvcr2_block_building_aaplace");
		registryItemBlock(mod, event, mod.gvcr2_block_building_aaplace_de, "gvcr2_block_building_aaplace_de");
		registryItemBlock(mod, event, mod.gvcr2_block_building_aaplace_sf, "gvcr2_block_building_aaplace_sf");
		registryItemBlock(mod, event, mod.gvcr2_block_building_mortarplace, "gvcr2_block_building_mortarplace");
		registryItemBlock(mod, event, mod.gvcr2_block_building_mortarplace_de, "gvcr2_block_building_mortarplace_de");
		registryItemBlock(mod, event, mod.gvcr2_block_building_mortarplace_sf, "gvcr2_block_building_mortarplace_sf");
		registryItemBlock(mod, event, mod.gvcr2_block_building_cannonplace, "gvcr2_block_building_cannonplace");
		registryItemBlock(mod, event, mod.gvcr2_block_building_cannonplace_de, "gvcr2_block_building_cannonplace_de");
		registryItemBlock(mod, event, mod.gvcr2_block_building_cannonplace_sf, "gvcr2_block_building_cannonplace_sf");
		registryItemBlock(mod, event, mod.gvcr2_block_building_bunker, "gvcr2_block_building_bunker");
		registryItemBlock(mod, event, mod.gvcr2_block_building_bunker_de, "gvcr2_block_building_bunker_de");
		registryItemBlock(mod, event, mod.gvcr2_block_building_munitions_depot, "gvcr2_block_building_munitions_depot");
		registryItemBlock(mod, event, mod.gvcr2_block_building_munitions_depot_de, "gvcr2_block_building_munitions_depot_de");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_radiobase, "gvcr2_block_building_radiobase");
		registryItemBlock(mod, event, mod.gvcr2_block_building_radiobase_de, "gvcr2_block_building_radiobase_de");
		registryItemBlock(mod, event, mod.gvcr2_block_building_radiobase_sn, "gvcr2_block_building_radiobase_sn");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_weaponbase, "gvcr2_block_building_weaponbase");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_smallbase, "gvcr2_block_building_smallbase");
		registryItemBlock(mod, event, mod.gvcr2_block_building_smallbase_de, "gvcr2_block_building_smallbase_de");
		registryItemBlock(mod, event, mod.gvcr2_block_building_smallbase_sn, "gvcr2_block_building_smallbase_sn");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_watchtower, "gvcr2_block_building_watchtower");
		registryItemBlock(mod, event, mod.gvcr2_block_building_igloo, "gvcr2_block_building_igloo");
		registryItemBlock(mod, event, mod.gvcr2_block_building_latticetower, "gvcr2_block_building_latticetower");
		registryItemBlock(mod, event, mod.gvcr2_block_building_latticetower_mt, "gvcr2_block_building_latticetower_mt");
		registryItemBlock(mod, event, mod.gvcr2_block_building_latticetower_sn, "gvcr2_block_building_latticetower_sn");
		registryItemBlock(mod, event, mod.gvcr2_block_building_camp_sn, "gvcr2_block_building_camp_sn");
		registryItemBlock(mod, event, mod.gvcr2_block_building_hideout_sn, "gvcr2_block_building_hideout_sn");
		registryItemBlock(mod, event, mod.gvcr2_block_building_submarine, "gvcr2_block_building_submarine");
		registryItemBlock(mod, event, mod.gvcr2_block_building_submarine_sn, "gvcr2_block_building_submarine_sn");
		
		
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_playerbase, "gvcr2_block_flag_ge_playerbase");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_playerbase, "gvcr2_block_flag_so_playerbase");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_city, "gvcr2_block_building_city");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_city, "gvcr2_block_flag_ge_city");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_city, "gvcr2_block_flag_so_city");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_ship, "gvcr2_block_building_ship");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_ship, "gvcr2_block_flag_ge_ship");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_ship, "gvcr2_block_flag_so_ship");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_ruins, "gvcr2_block_building_ruins");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_ruins, "gvcr2_block_flag_ge_ruins");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_ruins, "gvcr2_block_flag_so_ruins");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_abandoned_factory, "gvcr2_block_building_abandoned_factory");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_abandoned_factory, "gvcr2_block_flag_ge_abandoned_factory");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_abandoned_factory, "gvcr2_block_flag_so_abandoned_factory");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_airfield, "gvcr2_block_building_airfield");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_airfield, "gvcr2_block_flag_ge_airfield");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_airfield, "gvcr2_block_flag_so_airfield");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_airbase, "gvcr2_block_building_airbase");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_airbase, "gvcr2_block_flag_ge_airbase");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_airbase, "gvcr2_block_flag_so_airbase");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_boss_airbase, "gvcr2_block_flag_boss_airbase");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_garrison, "gvcr2_block_building_garrison");
		registryItemBlock(mod, event, mod.gvcr2_block_building_garrison_de, "gvcr2_block_building_garrison_de");
		registryItemBlock(mod, event, mod.gvcr2_block_building_garrison_sn, "gvcr2_block_building_garrison_sn");
		registryItemBlock(mod, event, mod.gvcr2_block_building_garrison_ice, "gvcr2_block_building_garrison_ice");
		registryItemBlock(mod, event, mod.gvcr2_block_building_garrison_fortress, "gvcr2_block_building_garrison_fortress");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_garrison, "gvcr2_block_flag_ge_garrison");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_garrison, "gvcr2_block_flag_so_garrison");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_metro, "gvcr2_block_building_metro");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_metro, "gvcr2_block_flag_ge_metro");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_metro, "gvcr2_block_flag_so_metro");
		
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_cannon_position, "gvcr2_block_building_cannon_position");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_cannon_position, "gvcr2_block_flag_ge_cannon_position");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_cannon_position, "gvcr2_block_flag_so_cannon_position");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_trench, "gvcr2_block_building_trench");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_trench, "gvcr2_block_flag_ge_trench");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_trench, "gvcr2_block_flag_so_trench");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_battleship, "gvcr2_block_building_battleship");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_battleship, "gvcr2_block_flag_ge_battleship");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_battleship, "gvcr2_block_flag_so_battleship");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_snowcastle, "gvcr2_block_building_snowcastle");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_snowcastle, "gvcr2_block_flag_ge_snowcastle");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_snowcastle, "gvcr2_block_flag_so_snowcastle");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_trainstation, "gvcr2_block_building_trainstation");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_trainstation, "gvcr2_block_flag_ge_trainstation");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_trainstation, "gvcr2_block_flag_so_trainstation");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_reichstag, "gvcr2_block_building_reichstag");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_reichstag, "gvcr2_block_flag_ge_reichstag");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_reichstag, "gvcr2_block_flag_so_reichstag");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_desertcity, "gvcr2_block_building_desertcity");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_desertcity, "gvcr2_block_flag_ge_desertcity");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_desertcity, "gvcr2_block_flag_so_desertcity");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_triumphal_arch, "gvcr2_block_building_triumphal_arch");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_triumphal_arch, "gvcr2_block_flag_ge_triumphal_arch");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_triumphal_arch, "gvcr2_block_flag_so_triumphal_arch");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_cv, "gvcr2_block_building_cv");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_cv, "gvcr2_block_flag_ge_cv");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_cv, "gvcr2_block_flag_so_cv");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_boss_cv, "gvcr2_block_flag_boss_cv");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_dd, "gvcr2_block_building_dd");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_dd, "gvcr2_block_flag_ge_dd");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_dd, "gvcr2_block_flag_so_dd");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_ff, "gvcr2_block_building_ff");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_ff, "gvcr2_block_flag_ge_ff");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_ff, "gvcr2_block_flag_so_ff");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_flaktower, "gvcr2_block_building_flaktower");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_flaktower, "gvcr2_block_flag_ge_flaktower");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_flaktower, "gvcr2_block_flag_so_flaktower");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_slum, "gvcr2_block_building_slum");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_slum, "gvcr2_block_flag_ge_slum");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_slum, "gvcr2_block_flag_so_slum");
		
		registryItemBlock(mod, event, mod.gvcr2_block_building_highway, "gvcr2_block_building_highway");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_ge_highway, "gvcr2_block_flag_ge_highway");
		registryItemBlock(mod, event, mod.gvcr2_block_flag_so_highway, "gvcr2_block_flag_so_highway");
	}
	
	public static void registryItemBlock(mod_GVCR2 mod, RegistryEvent.Register<Item> event, Block block,
			String bn) {
		event.getRegistry().register(new ItemBlock(block).setRegistryName(mod.MOD_ID, bn));

	}
}

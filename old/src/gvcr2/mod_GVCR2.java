package gvcr2;

import java.io.File;

import gvcr2.event.client.GVCR2ClientEvent_INV;
import gvcr2.event.world.GVCR2EventWorld;
import gvcr2.gui.GVCR2GuiHandler;
import gvcr2.network.GVCR2PacketHandler;
import gvcr2.registry.GVCR2BlockRegistry;
import gvcr2.registry.GVCR2BlockRegistry_Building;
import gvcr2.registry.GVCR2BlockRegistry_MOB;
import gvcr2.registry.GVCR2BlockRegistry_Utility;
import gvcr2.registry.GVCR2EntityRegistrys;
import gvcr2.registry.GVCR2EventRegistry;
import gvcr2.registry.GVCR2ItemRegistry_Block;
import gvcr2.registry.GVCR2ItemRegistry_Drone;
import gvcr2.registry.GVCR2ItemRegistry_GUN;
import gvcr2.registry.GVCR2ItemRegistry_GUN_AR;
import gvcr2.registry.GVCR2ItemRegistry_GUN_ARMOR;
import gvcr2.registry.GVCR2ItemRegistry_GUN_ATTACHMENT;
import gvcr2.registry.GVCR2ItemRegistry_GUN_GRENADE;
import gvcr2.registry.GVCR2ItemRegistry_GUN_MG;
import gvcr2.registry.GVCR2ItemRegistry_GUN_RF;
import gvcr2.registry.GVCR2ItemRegistry_GUN_RL;
import gvcr2.registry.GVCR2ItemRegistry_GUN_SG;
import gvcr2.registry.GVCR2ItemRegistry_GUN_SMG;
import gvcr2.registry.GVCR2ItemRegistry_GUN_SW;
import gvcr2.registry.GVCR2ItemRegistry_Item;
import gvcr2.registry.GVCR2ItemRegistry_MOB;
import gvcr2.registry.GVCR2ModelRegistry;
import gvcr2.registry.GVCR2RecipeRegistrys;
import gvcr2.tab.GVCR2CreativeTab;
import gvcr2.tab.GVCR2CreativeTab_Block;
import gvcr2.tab.GVCR2CreativeTab_Building;
import gvcr2.tab.GVCR2CreativeTab_Item;
import gvcr2.tab.GVCR2CreativeTab_Mob;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@Mod(
		modid	= mod_GVCR2.MOD_ID,
		name	= mod_GVCR2.MOD_ID,
		version	= "1.12.2",
		acceptedMinecraftVersions="[1.12.2]",
		useMetadata=true
		)
@EventBusSubscriber
public class mod_GVCR2 
{
	@SidedProxy(clientSide = "gvcr2.ClientProxyGVCR2", serverSide = "gvcr2.CommonSideProxyGVCR2")
	public static CommonSideProxyGVCR2 proxy;
	public static final String MOD_ID = "gvcr2";
	@Mod.Instance(MOD_ID)
	 
    public static mod_GVCR2 INSTANCE;
	
	public static boolean isDebugMessage = true;
	
	public static boolean cfg_exprotion_player;
	public static boolean cfg_exprotion_mob;
	public static boolean cfg_exprotion_grenade = false;;
	public static boolean cfg_damage_relief_vehicle = true;
	public static boolean cfg_damage_relief_mob = true;
	
	public static boolean cfg_movebreak = true;
	
	public static boolean cfg_canspawn;
	public static boolean cfg_canspawn_underground;
	public static boolean cfg_canspawn_anotherworld;
	public static boolean cfg_canspawn_hell;
	public static boolean cfg_canspawn_sky;
	
	public static boolean cfg_canspawn_mob_ge;
	public static boolean cfg_canspawn_mob_ge_rpg;
	
	
	public static boolean cfg_canspawn_mob_car;
	public static boolean cfg_canspawn_mob_tank;
	public static boolean cfg_canspawn_mob_heli;
	public static boolean cfg_canspawn_mob_so;
	
	public static int cfg_spawn_limit_g = 100;
	public static int cfg_spawn_limit_g_min = 100;
	public static int cfg_spawn_limit_g_max = 200;
	public static int cfg_spawn_limit_car = 20;
	public static int cfg_spawn_limit_car_min = 5;
	public static int cfg_spawn_limit_car_max = 10;
	public static int cfg_spawn_limit_tank = 10;
	public static int cfg_spawn_limit_tank_min = 1;
	public static int cfg_spawn_limit_tank_max = 2;
	public static int cfg_spawn_limit_heli = 10;
	public static int cfg_spawn_limit_heli_min = 1;
	public static int cfg_spawn_limit_heli_max = 2;
	
	public static int cfg_spawn_limit_s = 20;
	public static int cfg_spawn_limit_s_min = 50;
	public static int cfg_spawn_limit_s_max = 80;
	
	public static int cfg_support_fighter_time = 1200;
	
	
	public static int cfg_invasion_cycle;
	public static int cfg_invasion_spawnmax;
	
	public static int cfg_beacon_breaklimit;
	public static int cfg_beacon_ymin;
	public static boolean cfg_beacon_clear;
	
	public static boolean cfg_building;
	public static boolean cfg_building_dungeon;
	public static boolean cfg_building_huge_dungeon;
	public static boolean cfg_building_boss_dungeon;
	public static boolean cfg_building_ally_dungeon;
	public static boolean cfg_building_supplies;
	public static boolean cfg_building_supplies_air;
	public static boolean cfg_building_mine;
	public static int cfg_building_rand_dungeon;//80
	public static int cfg_building_rand_huge_dungeon;//500
	public static int cfg_building_rand_boss_dungeon;//800
	public static int cfg_building_rand_ally_dungeon;//600
	public static int cfg_building_rand_mine;//20
	
	public static boolean cfg_building_offsettype;
	public static int cfg_building_offset_rand_dungeon;//20
	public static int cfg_building_offset_rand_huge_dungeon;//40
	public static int cfg_building_offset_rand_boss_dungeon;//896
	
	
	
	public static boolean cfg_building_dungeon_spawner;
	
	
	public static boolean cfg_mob_missile;
	
	
	public static int cfg_spawner_limit;
	
	public static boolean cfg_worldlevel_debag;
	
	public static boolean cfg_vehicle_angle;
	
	public static boolean cfg_return_block;
	
	public static int cfg_targeting_time;
	
	
	
	////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public static Item gvcr2_item_pra;
	public static Item gvcr2_item_scrap;
	
	public static Item gvcr2_item_pad;
	
	public static Item gvcr2_item_squad_cn;
	
	public static Item gvcr2_item_wrench;
	public static Item gvcr2_item_weapon_change;
	public static Item gvcr2_item_binoculars;
	
	public static Item gvcr2_item_bandage;
	public static Item gvcr2_item_cm;
	
	public static Item gvcr2_item_aed;
	
	public static Item gvcr2_item_stars;
	
	
	public static Item gvcr2_bullet_9mmhg;
	public static Item gvcr2_bullet_45calhg;
	public static Item gvcr2_bullet_22calar;
	public static Item gvcr2_bullet_30calrf;
	public static Item gvcr2_bullet_50calrf;
	public static Item gvcr2_bullet_40mmgl;
	public static Item gvcr2_bullet_12gasg;
	public static Item gvcr2_bullet_76mmrl;
	public static Item gvcr2_bullet_84mmrl;
	public static Item gvcr2_bullet_76mmml;
	
	public static Item gvcr2_grenade_frag;
	public static Item gvcr2_grenade_flame;
	public static Item gvcr2_grenade_smoke;
	public static Item gvcr2_grenade_impact;
	public static Item gvcr2_grenade_atgrenade;
	
	
	public static Item gvcr2_am_dotsight;
	public static Item gvcr2_am_compm4;
	public static Item gvcr2_am_coyote;
	public static Item gvcr2_am_horo;
	public static Item gvcr2_am_kobra;
	public static Item gvcr2_am_micro;
	
	public static Item gvcr2_am_acog;
	public static Item gvcr2_am_m145;
	public static Item gvcr2_am_scope;
	
	public static Item gvcr2_am_lasersight;
	public static Item gvcr2_am_flashlight;
	
	public static Item gvcr2_am_suppressor;
	
	public static Item gvcr2_am_grip;
	public static Item gvcr2_am_anglegrip;
	public static Item gvcr2_am_bipod;
	public static Item gvcr2_am_gripod;
	
	public static Item gvcr2_am_bullet_ap;
	public static Item gvcr2_am_bullet_hp;
	public static Item gvcr2_am_bullet_at;
	public static Item gvcr2_am_bullet_srag;
	public static Item gvcr2_am_bullet_frag;
	public static Item gvcr2_am_bullet_db;
	
	
	
	//gun
	
	//ar
	public static Item gvcr2_gun_ak47;
	public static Item gvcr2_gun_ak74;
	public static Item gvcr2_gun_aks74u;
	public static Item gvcr2_gun_ak102;
	public static Item gvcr2_gun_m16a1;
	public static Item gvcr2_gun_m16a2;
	public static Item gvcr2_gun_m16a4;
	public static Item gvcr2_gun_m4;
	public static Item gvcr2_gun_m4a1;
	public static Item gvcr2_gun_g3a3;
	public static Item gvcr2_gun_g36;
	public static Item gvcr2_gun_g36c;
	public static Item gvcr2_gun_f2000;
	public static Item gvcr2_gun_l85a1;
	public static Item gvcr2_gun_type95;
	public static Item gvcr2_gun_ak12;
	public static Item gvcr2_gun_hk416;
	public static Item gvcr2_gun_scar_h;
	public static Item gvcr2_gun_stg44;
	public static Item gvcr2_gun_patriot;
	
	
	//hg
	public static Item gvcr2_gun_m1911;
	public static Item gvcr2_gun_pm;
	public static Item gvcr2_gun_m9;
	public static Item gvcr2_gun_m93r;
	public static Item gvcr2_gun_g17;
	public static Item gvcr2_gun_g18c;
	public static Item gvcr2_gun_g17_flux;
	
	//smg
	public static Item gvcr2_gun_vz61;
	public static Item gvcr2_gun_m10;
	public static Item gvcr2_gun_mp5;
	public static Item gvcr2_gun_mp40;
	public static Item gvcr2_gun_mp7;
	public static Item gvcr2_gun_uzi;
	public static Item gvcr2_gun_tmp;
	public static Item gvcr2_gun_ppsh41;
	
	//rf
	public static Item gvcr2_gun_sks;
	public static Item gvcr2_gun_svd;
	public static Item gvcr2_gun_m1891;
	public static Item gvcr2_gun_m14;
	public static Item gvcr2_gun_m110;
	public static Item gvcr2_gun_r700;
	public static Item gvcr2_gun_l96;
	public static Item gvcr2_gun_m82a3;
	public static Item gvcr2_gun_ptrd;
	public static Item gvcr2_gun_railgun;
	
	
	//mg
	public static Item gvcr2_gun_rpk47;
	public static Item gvcr2_gun_pkm;
	public static Item gvcr2_gun_pkp;
	public static Item gvcr2_gun_m60;
	public static Item gvcr2_gun_m63;
	public static Item gvcr2_gun_m240;
	public static Item gvcr2_gun_m249;
	public static Item gvcr2_gun_mg42;
	public static Item gvcr2_gun_mg36;
	public static Item gvcr2_gun_fm;
	public static Item gvcr2_gun_dp28;
	public static Item gvcr2_gun_lewisgun;
	public static Item gvcr2_gun_m134;
	
	
	//sg
	public static Item gvcr2_gun_m870;
	public static Item gvcr2_gun_m590;
	public static Item gvcr2_gun_m1014;
	public static Item gvcr2_gun_saiga12;
	
	
	//gl
	public static Item gvcr2_gun_m79;
	public static Item gvcr2_gun_m320;
	public static Item gvcr2_gun_xm25;
	public static Item gvcr2_gun_mgl140;
	
	//rl
	public static Item gvcr2_gun_rpg7;
	public static Item gvcr2_gun_panzerfaust;
	public static Item gvcr2_gun_m72;
	public static Item gvcr2_gun_m202;
	public static Item gvcr2_gun_smaw;
	public static Item gvcr2_gun_sraw;
	public static Item gvcr2_gun_fgm148;
	public static Item gvcr2_gun_fim92;
	
	public static Item gvcr2_gun_compoundbow;
	public static Item gvcr2_am_exarrow;
	public static Item gvcr2_am_psarrow;
	
	
	public static Item gvcr2_gun_la16u;
	public static Item gvcr2_item_request_105mm;
	public static Item gvcr2_item_request_40mm;
	public static Item gvcr2_item_request_20mm;
	public static Item gvcr2_item_request_pave;
	public static Item gvcr2_item_request_missile1;
	public static Item gvcr2_item_request_missile2;
	public static Item gvcr2_item_request_missile3;
	public static Item gvcr2_item_request_rog;
	
	public static Item gvcr2_item_request_fire1;
	public static Item gvcr2_item_request_fire2;
	public static Item gvcr2_item_request_fire3;
	public static Item gvcr2_item_request_airstrike1;
	public static Item gvcr2_item_request_airstrike2;
	public static Item gvcr2_item_request_airstrike3;
	public static Item gvcr2_item_request_strafing1;
	public static Item gvcr2_item_request_strafing2;
	public static Item gvcr2_item_request_flare;
	public static Item gvcr2_item_request_light;
	public static Item gvcr2_item_request_airborne1;
	public static Item gvcr2_item_request_airborne2;
	public static Item gvcr2_item_request_airborne3;
	
	public static Item gvcr2_item_request_support_fighter1;
	public static Item gvcr2_item_request_support_fighter2;
	public static Item gvcr2_item_request_support_fighter3;
	public static Item gvcr2_item_request_support_heli1;
	public static Item gvcr2_item_request_support_heli2;
	
	
	
	
	
	//armor
	public static Item gvcr2_armor_gasmask;
	public static Item gvcr2_armor_firemask;
	public static Item gvcr2_armor_trenchmask;
	public static Item gvcr2_armor_trench_body;
	public static Item gvcr2_armor_trench_leggings;
	public static Item gvcr2_armor_trench_boots;
	public static Item gvcr2_armor_tachanka;
	public static Item gvcr2_armor_parachute;
	
	public static Item gvcr2_armor_prahelmet;
	public static Item gvcr2_armor_prachest;
	public static Item gvcr2_armor_praleggings;
	public static Item gvcr2_armor_praboots;
	
	public static Item gvcr2_armor_camouflage_head;
	public static Item gvcr2_armor_camouflage_body;
	public static Item gvcr2_armor_camouflage_leggings;
	public static Item gvcr2_armor_camouflage_boots;
	
	public static Item gvcr2_armor_sehelmet;
	public static Item gvcr2_armor_sechest;
	
	public static Item gvcr2_armor_chest_rig;
	
	

	//sw
	public static Item gvcr2_gun_kukriknife;
	public static Item gvcr2_gun_club;
	
	
	//sd
	public static Item gvcr2_gun_riotshield;
	public static Item gvcr2_gun_heavyshield;
	
	public static Item gvcr2_drone_mav;
	public static Item gvcr2_drone_eod;
	public static Item gvcr2_drone_rawr;
	
	
	
	//mine
	public static Block gvcr2_block_mine;
	public static Block gvcr2_block_atmine;
	public static Block gvcr2_block_ied;
	public static Block gvcr2_block_bomb;
	public static Block gvcr2_block_water_mine;
	public static Block gvcr2_block_propane;
	public static Block gvcr2_block_bouy;
	
	//supplies
	public static Block gvcr2_block_supplies_air;
	
	public static Block gvcr2_block_supplies_1;
	public static Block gvcr2_block_supplies_2;
	public static Block gvcr2_block_supplies_3;
	public static Block gvcr2_block_supplies_4;
	
	public static Block gvcr2_block_supplies_scrap;
	
	//decoration
	public static Block gvcr2_block_ammobox1;
	public static Block gvcr2_block_artibox1;
	public static Block gvcr2_block_artibox2;
	public static Block gvcr2_block_artibox3;
	public static Block gvcr2_block_barrel_drum1;
	public static Block gvcr2_block_barrel_drum2;
	public static Block gvcr2_block_barrel_drum3;
	public static Block gvcr2_block_cadaver_g;
	public static Block gvcr2_block_hesco;
	public static Block gvcr2_block_jerrycan1;
	public static Block gvcr2_block_missile_rack1;
	
	
	public static Block gvcr2_block_9mmpack_gc;
	public static Block gvcr2_block_45pack_gc;
	public static Block gvcr2_block_223pack_gc;
	public static Block gvcr2_block_308pack_gc;
	public static Block gvcr2_block_50bmgpack_gc;
	public static Block gvcr2_block_12gpack_gc;
	public static Block gvcr2_block_40mmgr_ammo_gc;
	public static Block gvcr2_block_grenade_box_gc;
	public static Block gvcr2_block_rpg_ammobox1;
	public static Block gvcr2_block_rpg_ammobox2;
	public static Block gvcr2_block_ammo_mass;
	public static Block gvcr2_block_m18_claymore;
	public static Block gvcr2_block_m72_box;
	public static Block gvcr2_block_rpg_box;
	public static Block gvcr2_block_medbag_gc;
	public static Block gvcr2_block_laptop;
	public static Block gvcr2_block_toughbook;
	public static Block gvcr2_block_monitor1;
	public static Block gvcr2_block_man_target;
	public static Block gvcr2_block_old_radio;
	public static Block gvcr2_block_radio_big;
	public static Block gvcr2_block_sincgars;
	
	
	public static Block gvcr2_block_burn_barrel;
	public static Block gvcr2_block_at_obstacles;
	public static Block gvcr2_block_barbed1_gc;
	public static Block gvcr2_block_barbed2_gc;
	public static Block gvcr2_block_fire_exti_gc;
	public static Block gvcr2_block_mil_cont1_gc;
	public static Block gvcr2_block_mil_cont2_gc;
	public static Block gvcr2_block_odunit_gc;
	public static Block gvcr2_block_sandbag_a1_gc;
	public static Block gvcr2_block_sandbag_a2_gc;
	public static Block gvcr2_block_sandbag_b1_gc;
	public static Block gvcr2_block_sandbag_b2_gc;
	public static Block gvcr2_block_t_wall1_gc;
	public static Block gvcr2_block_t_wall2_gc;
	public static Block gvcr2_block_wolcott;
	public static Block gvcr2_block_fslight;
	public static Block gvcr2_block_ghostlight;
	public static Block gvcr2_block_ghostlight_tile;
	public static Block gvcr2_block_scaffold;
	public static Block gvcr2_block_lantern_g;
	public static Block gvcr2_block_light_block_g;
	public static Block gvcr2_block_wall_light_gg;
	public static Block gvcr2_block_wall_light_rg;
	public static Block gvcr2_block_wall_light_wg;
	public static Block gvcr2_block_rack_g1;
	public static Block gvcr2_block_rack_g2;
	
	
	
	//craft_machine
	public static Block gvcr2_block_guncrafter_1;
	public static Block gvcr2_block_guncrafter_2;
	public static Block gvcr2_block_guncrafter_3;
	
	public static int gun_id_1 = 0;
	public static int[] gun_eme_1 = new int[1024];
	public static int[] gun_iron_1 = new int[1024];
	public static int[] gun_red_1 = new int[1024];
	public static Item[] gun_item_1 = new Item[1024];
	
	public static int gun_id_2 = 0;
	public static int[] gun_eme_2 = new int[1024];
	public static int[] gun_iron_2 = new int[1024];
	public static int[] gun_red_2 = new int[1024];
	public static Item[] gun_item_2 = new Item[1024];
	
	public static int gun_id_3 = 0;
	public static int[] gun_eme_3 = new int[1024];
	public static int[] gun_iron_3 = new int[1024];
	public static int[] gun_red_3 = new int[1024];
	public static Item[] gun_item_3 = new Item[1024];
	
	
	
	public static Block gvcr2_block_vehiclecrafter_1;
	public static Block gvcr2_block_vehiclecrafter_2;
	public static Block gvcr2_block_vehiclecrafter_3;
	
	public static int vehicle_id_1 = 0;
	public static int[] vehicle_eme_1 = new int[1024];
	public static int[] vehicle_iron_1 = new int[1024];
	public static int[] vehicle_red_1 = new int[1024];
	public static Item[] vehicle_item_1 = new Item[1024];
	
	public static int vehicle_id_2 = 0;
	public static int[] vehicle_eme_2 = new int[1024];
	public static int[] vehicle_iron_2 = new int[1024];
	public static int[] vehicle_red_2 = new int[1024];
	public static Item[] vehicle_item_2 = new Item[1024];
	
	public static int vehicle_id_3 = 0;
	public static int[] vehicle_eme_3 = new int[1024];
	public static int[] vehicle_iron_3 = new int[1024];
	public static int[] vehicle_red_3 = new int[1024];
	public static Item[] vehicle_item_3 = new Item[1024];
	
	public static Block gvcr2_block_bulletcrafter_1;
	public static int bullet_id_1 = 0;
	public static int[] bullet_eme_1 = new int[1024];
	public static int[] bullet_iron_1 = new int[1024];
	public static int[] bullet_kazu_1 = new int[1024];
	public static Item[] bullet_item_1 = new Item[1024];
	
	
	public static Block gvcr2_block_gunrack_hsin;
	public static Block gvcr2_block_gunrack_rsin;
	public static Block gvcr2_block_gunrack_rswn;
	
	public static Block gvcr2_block_gunrack_hti;
	public static Block gvcr2_block_gunrack_rti1;
	public static Block gvcr2_block_gunrack_rti2;
	
	public static Block gvcr2_block_gunrack_hsin_deco;
	public static Block gvcr2_block_gunrack_rsin_deco;
	public static Block gvcr2_block_gunrack_rswn_deco;
	public static Block gvcr2_block_gunrack_hti_deco;
	public static Block gvcr2_block_gunrack_rti1_deco;
	public static Block gvcr2_block_gunrack_rti2_deco;
	
	
	
	//spawn_ge
	public static Item gvcr2_spawn_ge_s;
	
	public static Item gvcr2_spawn_ge_sv;
	public static Item gvcr2_spawn_ge_sv_fire;
	public static Item gvcr2_spawn_ge_sv_trench;
	public static Item gvcr2_spawn_ge_sv_antitank;
	public static Item gvcr2_spawn_ge_sv_sniper;
	public static Item gvcr2_spawn_ge_sv_drone;
	public static Block gvcr2_block_ge_sv;
	public static Block gvcr2_block_ge_sv_fire;
	public static Block gvcr2_block_ge_sv_trench;
	public static Block gvcr2_block_ge_sv_antitank;
	public static Block gvcr2_block_ge_sv_sniper;
	public static Block gvcr2_block_ge_sv_drone;
	
	public static Item gvcr2_spawn_ge_pow;
	
	
	public static Item gvcr2_spawn_ge_se_assault;
	public static Block gvcr2_block_ge_se_assault;
	public static Item gvcr2_spawn_ge_se_cerberus;
	public static Block gvcr2_block_ge_se_cerberus;
	//public static Item gvcr2_spawn_ge_se_juggernaut;
	public static Item gvcr2_spawn_ge_se_hacs;
	public static Block gvcr2_block_ge_se_hacs;
	public static Item gvcr2_spawn_ge_se_kukri;
	public static Block gvcr2_block_ge_se_kukri;
	
	public static Item gvcr2_spawn_ge_s_mr_cpt;
	public static Block gvcr2_block_ge_s_mr_cpt;
	
	public static Item gvcr2_spawn_unks_c_s;
	
	public static Item gvcr2_spawn_pmc_s;
	public static Item gvcr2_spawn_so_s;
	
	public static Item gvcr2_spawn_so_s_mr_cpt;
	public static Block gvcr2_block_so_s_mr_cpt;
	
	public static Item gvcr2_spawn_so_s_af_cpt;
	public static Block gvcr2_block_so_s_af_cpt;
	
	
	public static Item gvcr2_spawn_npc_arms_trader;
	public static Block gvcr2_block_npc_arms_trader;
	
	public static Item gvcr2_spawn_sp_rex;
	
	public static Item gvcr2_spawn_boss_longleg;
	public static Block gvcr2_block_boss_longleg;
	
	public static Item gvcr2_spawn_boss_st1;
	public static Block gvcr2_block_boss_st1;
	public static Item gvcr2_spawn_sp_st1;
	
	public static Item gvcr2_spawn_boss_mer08;
	public static Block gvcr2_block_boss_mer08;
	
	public static Item gvcr2_spawn_boss_mer08_sn;
	public static Block gvcr2_block_boss_mer08_sn;
	
	public static Item gvcr2_spawn_boss_mer08_b;
	public static Block gvcr2_block_boss_mer08_b;
	public static Item gvcr2_spawn_boss_mer03k;
	public static Block gvcr2_block_boss_mer03k;
	
	public static Item gvcr2_spawn_boss_hauneb;
	public static Block gvcr2_block_boss_hauneb;
	
	public static Item gvcr2_spawn_boss_irving;
	public static Block gvcr2_block_boss_irving;
	
	public static Item gvcr2_spawn_boss_char2c;
	public static Block gvcr2_block_boss_char2c;
	
	public static Item gvcr2_spawn_boss_av8b;
	public static Block gvcr2_block_boss_av8b;
	
	public static Item gvcr2_spawn_boss_ratte;
	public static Block gvcr2_block_boss_ratte;
	
	public static Item gvcr2_spawn_boss_tb3;
	//public static Block gvcr2_block_boss_tb3;
	
	public static Item gvcr2_spawn_boss_airship;
	
	
	//spawn_car
	public static Item gvcr2_spawn_car_technical;
	public static Item gvcr2_spawn_car_technical_mortar;
	public static Item gvcr2_spawn_car_technical_aa;
	public static Item gvcr2_spawn_car_technical_rocket;
	public static Item gvcr2_spawn_car_technical_tnt;
	public static Item gvcr2_spawn_car_bike;
	public static Item gvcr2_spawn_car_buggy;
	public static Item gvcr2_spawn_car_hmmwv;
	public static Item gvcr2_spawn_car_armor_bulldozer;
	
	public static Item gvcr2_spawn_apc_m113;
	public static Item gvcr2_spawn_apc_m113_aa;
	public static Item gvcr2_spawn_apc_m113_ifv;
	public static Item gvcr2_spawn_apc_m113_spg;
	public static Item gvcr2_spawn_apc_m1126;
	public static Item gvcr2_spawn_apc_m1129;
	public static Item gvcr2_spawn_apc_m1128;
	public static Item gvcr2_spawn_apc_lav25;
	public static Item gvcr2_spawn_apc_lav25ad;
	public static Item gvcr2_spawn_apc_btr60;
	public static Item gvcr2_spawn_apc_m1097;
	public static Item gvcr2_spawn_apc_9k35;
	public static Item gvcr2_spawn_apc_m270;
	public static Item gvcr2_spawn_apc_bmp3;
	
	
	//spawn_heli
	public static Item gvcr2_spawn_heli_ah1s;
	public static Item gvcr2_spawn_heli_ah6;
	public static Item gvcr2_spawn_heli_uh1;
	public static Item gvcr2_spawn_heli_ch47;
	public static Item gvcr2_spawn_heli_g_heli;
	public static Item gvcr2_spawn_heli_mi24d;
	
	public static Item gvcr2_spawn_heli_uh1y;
	public static Item gvcr2_spawn_heli_uh60;
	public static Item gvcr2_spawn_heli_ah1z;
	public static Item gvcr2_spawn_heli_ka50;
	public static Item gvcr2_spawn_heli_z10;
	public static Item gvcr2_spawn_heli_ka60;
	public static Item gvcr2_spawn_heli_r22;
	
	
	//spawn_tank
	public static Item gvcr2_spawn_tank_m60a1;
	public static Item gvcr2_spawn_tank_m1;
	public static Item gvcr2_spawn_tank_m41;
	public static Item gvcr2_spawn_tank_m551;
	public static Item gvcr2_spawn_tank_t34;
	public static Item gvcr2_spawn_tank_t55;
	public static Item gvcr2_spawn_tank_t72;
	public static Item gvcr2_spawn_tank_t90;
	public static Item gvcr2_spawn_tank_pt76;
	public static Item gvcr2_spawn_tank_kv2;
	public static Item gvcr2_spawn_tank_fv101;
	public static Item gvcr2_spawn_tank_zsu_23_4;
	public static Item gvcr2_spawn_tank_2k22;
	public static Item gvcr2_spawn_tank_m1a2;
	public static Item gvcr2_spawn_tank_m41dk1;
	public static Item gvcr2_spawn_tank_ratte;
	
	
	//spawn_aircraft
	public static Item gvcr2_spawn_air_f16;
	public static Item gvcr2_spawn_air_f18;
	public static Item gvcr2_spawn_air_a10;
	public static Item gvcr2_spawn_air_mig17;
	public static Item gvcr2_spawn_air_li28;
	public static Item gvcr2_spawn_air_f117;
	public static Item gvcr2_spawn_air_ac130;
	public static Item gvcr2_spawn_air_a6;
	public static Item gvcr2_spawn_air_yak23;
	public static Item gvcr2_spawn_air_a4;
	public static Item gvcr2_spawn_air_yak23kai;
	public static Item gvcr2_spawn_air_an2;
	public static Item gvcr2_spawn_air_su25;
	public static Item gvcr2_spawn_air_su27;
	public static Item gvcr2_spawn_air_av8b;
	
	//spawn_ship
	public static Item gvcr2_spawn_ship_rhib;
	public static Item gvcr2_spawn_ship_rcb;
	public static Item gvcr2_spawn_ship_cruiser;
	public static Item gvcr2_spawn_ship_pr1204;
	public static Item gvcr2_spawn_ship_hamina;
	public static Item gvcr2_spawn_ship_airship;
	
	
	//spawn_set
	public static Item gvcr2_spawn_set_mg_m60;
	public static Item gvcr2_spawn_set_mg_m2;
	public static Item gvcr2_spawn_set_mg_pkm;
	public static Item gvcr2_spawn_set_mg_dp28;
	
	public static Item gvcr2_spawn_set_aa_20mmaa;
	public static Item gvcr2_spawn_set_aa_vads;
	public static Item gvcr2_spawn_set_aa_zu23;
	
	public static Item gvcr2_spawn_set_mg_pak40;
	public static Item gvcr2_spawn_set_mg_flak18;
	public static Item gvcr2_spawn_set_mg_fh18;
	public static Item gvcr2_spawn_set_mg_tow2;
	
	public static Item gvcr2_spawn_set_mg_m224;
	
	public static Item gvcr2_spawn_set_mg_ak130;
	public static Item gvcr2_spawn_set_mg_mk15_phalanx;
	public static Item gvcr2_spawn_set_mg_mk45_mod4;
	
	
	
	//spawn_block
	public static Block gvcr2_block_ge_s;
	
	public static Block gvcr2_block_so_s;
	
	
	
	public static Block gvcr2_block_set_mg_m60;
	public static Block gvcr2_block_set_mg_m2;
	public static Block gvcr2_block_set_mg_pkm;
	public static Block gvcr2_block_set_mg_dp28;
	
	public static Block gvcr2_block_set_aa_20mmaa;
	public static Block gvcr2_block_set_aa_vads;
	public static Block gvcr2_block_set_aa_zu23;
	
	public static Block gvcr2_block_set_mg_pak40;
	public static Block gvcr2_block_set_mg_flak18;
	public static Block gvcr2_block_set_mg_fh18;
	public static Block gvcr2_block_set_mg_tow2;
	
	public static Block gvcr2_block_set_mg_m224;
	
	public static Block gvcr2_block_set_mg_ak130;
	public static Block gvcr2_block_set_mk15_phalanx;
	public static Block gvcr2_block_set_mk45_mod4;
	
	
	public static Block gvcr2_block_apc_m113;
	public static Block gvcr2_block_tank_m60a1;
	public static Block gvcr2_block_heli_ah1s;
	public static Block gvcr2_block_apc_9k35;
	public static Block gvcr2_block_apc_m1097;
	public static Block gvcr2_block_air_a4;
	public static Block gvcr2_block_air_yak23kai;
	
	
	public static Block gvcr2_block_tank_t34;
	public static Block gvcr2_block_tank_kv2;
	public static Block gvcr2_block_heli_g_heli;
	public static Block gvcr2_block_ship_cruiser;
	public static Block gvcr2_block_ship_pr1204;
	
	public static Block gvcr2_block_tank_t72;
	public static Block gvcr2_block_tank_2k22;
	public static Block gvcr2_block_heli_mi24d;
	
	public static Block gvcr2_block_invate_zu23_mk15;
	
	
	
	//spawner
	public static Block gvcr2_blockspawner_ge_s;
	
	public static Block gvcr2_blockspawner_so_s;
	
	
	//building_chest
	public static Block gvcr2_block_chest_food;
	public static Block gvcr2_block_chest_weapon;
	public static Block gvcr2_block_chest_weapon2;
	public static Block gvcr2_block_chest_weapon3;
	public static Block gvcr2_block_chest_weapon4;
	public static Block gvcr2_block_setair;
	
	
	//building
	public static Block gvcr2_block_building_camp;
	public static Block gvcr2_block_building_aaplace;
	public static Block gvcr2_block_building_aaplace_de;
	public static Block gvcr2_block_building_aaplace_sf;
	public static Block gvcr2_block_building_mortarplace;
	public static Block gvcr2_block_building_mortarplace_de;
	public static Block gvcr2_block_building_mortarplace_sf;
	public static Block gvcr2_block_building_cannonplace;
	public static Block gvcr2_block_building_cannonplace_de;
	public static Block gvcr2_block_building_cannonplace_sf;
	
	public static Block gvcr2_block_building_mg_place;
	public static Block gvcr2_block_building_mg_place_de;
	public static Block gvcr2_block_building_mg_place_sf;
	
	public static Block gvcr2_block_building_hideout;
	public static Block gvcr2_block_building_hideout_de;
	
	public static Block gvcr2_block_building_bunker;
	public static Block gvcr2_block_building_bunker_de;
	
	public static Block gvcr2_block_building_munitions_depot;
	public static Block gvcr2_block_building_munitions_depot_de;
	
	public static Block gvcr2_block_building_radiobase;
	public static Block gvcr2_block_building_radiobase_de;
	public static Block gvcr2_block_building_radiobase_sn;
	
	public static Block gvcr2_block_building_weaponbase;
	
	public static Block gvcr2_block_building_smallbase;
	public static Block gvcr2_block_building_smallbase_de;
	public static Block gvcr2_block_building_smallbase_sn;
	
	public static Block gvcr2_block_building_watchtower;
	public static Block gvcr2_block_building_igloo;
	public static Block gvcr2_block_building_latticetower;
	public static Block gvcr2_block_building_latticetower_mt;
	public static Block gvcr2_block_building_latticetower_sn;
	public static Block gvcr2_block_building_camp_sn;
	public static Block gvcr2_block_building_hideout_sn;
	
	public static Block gvcr2_block_building_submarine;
	public static Block gvcr2_block_building_submarine_sn;
	
	
	public static Block gvcr2_block_flag_ge_playerbase;
	public static Block gvcr2_block_flag_so_playerbase;
	
	public static Block gvcr2_block_building_city;
	public static Block gvcr2_block_flag_ge_city;
	public static Block gvcr2_block_flag_so_city;
	
	public static Block gvcr2_block_building_ruins;
	public static Block gvcr2_block_flag_ge_ruins;
	public static Block gvcr2_block_flag_so_ruins;
	
	public static Block gvcr2_block_building_ship;
	public static Block gvcr2_block_flag_ge_ship;
	public static Block gvcr2_block_flag_so_ship;
	
	public static Block gvcr2_block_building_abandoned_factory;
	public static Block gvcr2_block_flag_ge_abandoned_factory;
	public static Block gvcr2_block_flag_so_abandoned_factory;
	
	public static Block gvcr2_block_building_airfield;
	public static Block gvcr2_block_flag_ge_airfield;
	public static Block gvcr2_block_flag_so_airfield;
	
	public static Block gvcr2_block_building_airbase;
	public static Block gvcr2_block_flag_ge_airbase;
	public static Block gvcr2_block_flag_so_airbase;
	public static Block gvcr2_block_flag_boss_airbase;
	public static Item gvcr2_block_debag_boss_airbase;
	
	public static Block gvcr2_block_building_garrison;//鬧仙ｱｯ蝨ｰ
	public static Block gvcr2_block_building_garrison_de;//鬧仙ｱｯ蝨ｰ
	public static Block gvcr2_block_building_garrison_sn;//鬧仙ｱｯ蝨ｰ
	public static Block gvcr2_block_building_garrison_ice;//鬧仙ｱｯ蝨ｰ
	public static Block gvcr2_block_building_garrison_fortress;//鬧仙ｱｯ蝨ｰ
	public static Block gvcr2_block_flag_ge_garrison;
	public static Block gvcr2_block_flag_so_garrison;
	
	public static Block gvcr2_block_building_metro;
	public static Block gvcr2_block_flag_ge_metro;
	public static Block gvcr2_block_flag_so_metro;
	
	public static Block gvcr2_block_building_cannon_position;
	public static Block gvcr2_block_flag_ge_cannon_position;
	public static Block gvcr2_block_flag_so_cannon_position;
	
	public static Block gvcr2_block_building_trench;
	public static Block gvcr2_block_flag_ge_trench;
	public static Block gvcr2_block_flag_so_trench;
	
	public static Block gvcr2_block_building_battleship;
	public static Block gvcr2_block_flag_ge_battleship;
	public static Block gvcr2_block_flag_so_battleship;
	
	public static Block gvcr2_block_building_snowcastle;
	public static Block gvcr2_block_flag_ge_snowcastle;
	public static Block gvcr2_block_flag_so_snowcastle;
	
	public static Block gvcr2_block_building_trainstation;
	public static Block gvcr2_block_flag_ge_trainstation;
	public static Block gvcr2_block_flag_so_trainstation;
	
	public static Block gvcr2_block_building_reichstag;
	public static Block gvcr2_block_flag_ge_reichstag;
	public static Block gvcr2_block_flag_so_reichstag;
	
	public static Block gvcr2_block_building_desertcity;
	public static Block gvcr2_block_flag_ge_desertcity;
	public static Block gvcr2_block_flag_so_desertcity;
	
	public static Block gvcr2_block_building_triumphal_arch;
	public static Block gvcr2_block_flag_ge_triumphal_arch;
	public static Block gvcr2_block_flag_so_triumphal_arch;
	
	public static Block gvcr2_block_building_cv;
	public static Block gvcr2_block_flag_ge_cv;
	public static Block gvcr2_block_flag_so_cv;
	public static Block gvcr2_block_flag_boss_cv;
	public static Item gvcr2_block_debag_boss_cv;
	public static Block gvcr2_block_cv_jamming;
	
	
	public static Block gvcr2_block_building_dd;
	public static Block gvcr2_block_flag_ge_dd;
	public static Block gvcr2_block_flag_so_dd;
	
	public static Block gvcr2_block_building_ff;
	public static Block gvcr2_block_flag_ge_ff;
	public static Block gvcr2_block_flag_so_ff;
	
	public static Block gvcr2_block_building_flaktower;
	public static Block gvcr2_block_flag_ge_flaktower;
	public static Block gvcr2_block_flag_so_flaktower;
	
	public static Block gvcr2_block_building_slum;
	public static Block gvcr2_block_flag_ge_slum;
	public static Block gvcr2_block_flag_so_slum;
	
	public static Block gvcr2_block_building_highway;
	public static Block gvcr2_block_flag_ge_highway;
	public static Block gvcr2_block_flag_so_highway;
	
	
	
	public static Item gvcr2_item_inv_infantry_1;
	public static Item gvcr2_item_inv_infantry_2;
	public static Item gvcr2_item_inv_infantry_3;
	public static Item gvcr2_item_inv_infantry_4;
	
	public static Item gvcr2_item_inv_normal_1;
	public static Item gvcr2_item_inv_normal_2;
	public static Item gvcr2_item_inv_normal_3;
	public static Item gvcr2_item_inv_normal_4;
	
	public static Item gvcr2_item_inv_tank_1;
	public static Item gvcr2_item_inv_tank_2;
	public static Item gvcr2_item_inv_tank_3;
	public static Item gvcr2_item_inv_tank_4;
	
	public static Item gvcr2_item_inv_dogfight_1;
	public static Item gvcr2_item_inv_dogfight_2;
	public static Item gvcr2_item_inv_dogfight_3;
	public static Item gvcr2_item_inv_dogfight_4;
	
	public static Item gvcr2_item_inv_airborne_1;
	public static Item gvcr2_item_inv_airborne_2;
	public static Item gvcr2_item_inv_airborne_3;
	public static Item gvcr2_item_inv_airborne_4;
	
	
	protected static File configFile;
	
	public static final CreativeTabs tab_gun = new GVCR2CreativeTab("GVCTab_Gun");
	public static final CreativeTabs tab_item = new GVCR2CreativeTab_Item("GVCTab_Item");
	public static final CreativeTabs tabgg_mob = new GVCR2CreativeTab_Mob("GVCTab_Mob");
	public static final CreativeTabs tabgg_block = new GVCR2CreativeTab_Block("GVCTab_Block");
	public static final CreativeTabs tabgg_building = new GVCR2CreativeTab_Building("GVCTab_Building");
	
	
	/**world蜊倅ｽ阪〒邂｡逅�*/
	public static int difficult_level = -1;
	
	
	public static float test_1_x = 0;
	public static float test_1_y = 0;
	public static float test_1_z = 0;
	
	public static float test_2_x = 0;
	public static float test_2_y = 0;
	public static float test_2_z = 0;
	
	
	
	
	@Mod.EventHandler
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent pEvent) {
		configFile = pEvent.getSuggestedConfigurationFile();
		Configuration lconf = new Configuration(pEvent.getSuggestedConfigurationFile());
		lconf.load();
		cfg_worldlevel_debag	= lconf.get("debag", "cfg_worldlevel_debag", false).getBoolean(false);
		
		
		cfg_damage_relief_vehicle	= lconf.get("entity", "cfg_damage_relief_vehicle", true).getBoolean(true);
		cfg_damage_relief_mob	= lconf.get("entity", "cfg_damage_relief_mob", true).getBoolean(true);
		cfg_exprotion_player	= lconf.get("entity", "cfg_exprotion_player", true).getBoolean(true);
		cfg_exprotion_mob	= lconf.get("entity", "cfg_exprotion_mob", true).getBoolean(true);
		cfg_exprotion_grenade	= lconf.get("entity", "cfg_exprotion_grenade", false).getBoolean(false);
		cfg_movebreak	= lconf.get("entity", "cfg_movebreak", true).getBoolean(true);
		cfg_vehicle_angle	= lconf.get("entity", "cfg_vehicle_angle", true).getBoolean(true);
		cfg_return_block	= lconf.get("entity", "cfg_return_block", true).getBoolean(true);
		cfg_targeting_time	= lconf.get("entity", "cfg_targeting_time", 30).getInt(30);
		
		cfg_support_fighter_time	= lconf.get("request", "cfg_support_fighter_time", 1200).getInt(1200);
		
		cfg_canspawn	= lconf.get("spawn", "cfg_canspawn", true).getBoolean(true);
		cfg_canspawn_underground	= lconf.get("spawn", "cfg_canspawn_underground", false).getBoolean(false);
		cfg_canspawn_anotherworld	= lconf.get("spawn", "cfg_canspawn_anotherworld", false).getBoolean(false);
		cfg_canspawn_hell	= lconf.get("spawn", "cfg_canspawn_hell", true).getBoolean(true);
		cfg_canspawn_sky	= lconf.get("spawn", "cfg_canspawn_sky", false).getBoolean(false);
		
		cfg_canspawn_mob_ge	= lconf.get("spawn", "cfg_canspawn_mob_ge", true).getBoolean(true);
		cfg_canspawn_mob_ge_rpg	= lconf.get("spawn", "cfg_canspawn_mob_ge_rpg", true).getBoolean(true);
		cfg_canspawn_mob_car	= lconf.get("spawn", "cfg_canspawn_mob_car", true).getBoolean(true);
		cfg_canspawn_mob_tank	= lconf.get("spawn", "cfg_canspawn_mob_tank", true).getBoolean(true);
		cfg_canspawn_mob_heli	= lconf.get("spawn", "cfg_canspawn_mob_heli", true).getBoolean(true);
		cfg_canspawn_mob_so	= lconf.get("spawn", "cfg_canspawn_mob_so", true).getBoolean(true);
		
		cfg_spawn_limit_g	= lconf.get("mob_spawn_limit", "cfg_spawn_limit_g", 100).getInt(100);
		cfg_spawn_limit_g_min	= lconf.get("mob_spawn_limit", "cfg_spawn_limit_g_min", 100).getInt(100);
		cfg_spawn_limit_g_max	= lconf.get("mob_spawn_limit", "cfg_spawn_limit_g_max", 200).getInt(200);
		
		cfg_spawn_limit_car	= lconf.get("mob_spawn_limit", "cfg_spawn_limit_car", 20).getInt(20);
		cfg_spawn_limit_car_min	= lconf.get("mob_spawn_limit", "cfg_spawn_limit_car_min", 5).getInt(5);
		cfg_spawn_limit_car_max	= lconf.get("mob_spawn_limit", "cfg_spawn_limit_car_max", 10).getInt(10);
		
		cfg_spawn_limit_tank	= lconf.get("mob_spawn_limit", "cfg_spawn_limit_tank", 10).getInt(10);
		cfg_spawn_limit_tank_min	= lconf.get("mob_spawn_limit", "cfg_spawn_limit_tank_min", 2).getInt(2);
		cfg_spawn_limit_tank_max	= lconf.get("mob_spawn_limit", "cfg_spawn_limit_tank_max", 4).getInt(4);
		
		cfg_spawn_limit_heli	= lconf.get("mob_spawn_limit", "cfg_spawn_limit_heli", 10).getInt(10);
		cfg_spawn_limit_heli_min	= lconf.get("mob_spawn_limit", "cfg_spawn_limit_heli_min", 2).getInt(2);
		cfg_spawn_limit_heli_max	= lconf.get("mob_spawn_limit", "cfg_spawn_limit_heli_max", 4).getInt(4);
		
		cfg_spawn_limit_s	= lconf.get("mob_spawn_limit", "cfg_spawn_limit_s", 20).getInt(20);
		cfg_spawn_limit_s_min	= lconf.get("mob_spawn_limit", "cfg_spawn_limit_s_min", 50).getInt(50);
		cfg_spawn_limit_s_max	= lconf.get("mob_spawn_limit", "cfg_spawn_limit_s_max", 80).getInt(80);
		
		
		cfg_building_dungeon	= lconf.get("structure", "cfg_building_dungeon", true).getBoolean(true);
		cfg_building_dungeon_spawner	= lconf.get("structure", "cfg_building_dungeon_spawner", true).getBoolean(true);
		cfg_building_huge_dungeon	= lconf.get("structure", "cfg_building_huge_dungeon", true).getBoolean(true);
		cfg_building_boss_dungeon	= lconf.get("structure", "cfg_building_boss_dungeon", true).getBoolean(true);
		cfg_building_ally_dungeon	= lconf.get("structure", "cfg_building_ally_dungeon", true).getBoolean(true);
		cfg_building_mine	= lconf.get("structure", "cfg_building_mine", true).getBoolean(true);
		
		cfg_building_rand_dungeon	= lconf.get("structure", "cfg_building_rand_dungeon", 80).getInt(80);
		cfg_building_rand_huge_dungeon	= lconf.get("structure", "cfg_building_rand_huge_dungeon", 500).getInt(500);
		cfg_building_rand_boss_dungeon	= lconf.get("structure", "cfg_building_rand_boss_dungeon", 800).getInt(800);
		cfg_building_rand_ally_dungeon	= lconf.get("structure", "cfg_building_rand_ally_dungeon", 600).getInt(600);
		cfg_building_rand_mine	= lconf.get("structure", "cfg_building_rand_mine", 20).getInt(20);
		
		cfg_building_offsettype	= lconf.get("structure", "cfg_building_offsettype", true).getBoolean(true);
		cfg_building_offset_rand_dungeon	= lconf.get("structure", "cfg_building_offset_rand_dungeon", 20).getInt(20);
		cfg_building_offset_rand_huge_dungeon	= lconf.get("structure", "cfg_building_offset_rand_huge_dungeon", 40).getInt(40);
		cfg_building_offset_rand_boss_dungeon	= lconf.get("structure", "cfg_building_offset_rand_boss_dungeon", 7).getInt(7);
		
		cfg_building_supplies	= lconf.get("structure", "cfg_building_supplies", true).getBoolean(true);
		cfg_building_supplies_air	= lconf.get("structure", "cfg_building_supplies_air", true).getBoolean(true);
		
		lconf.save();
		
		
		 GVCR2PacketHandler.init();
	}
	
	
	
	@SubscribeEvent
    protected static void registerItems(RegistryEvent.Register<Item> event){
		GVCR2ItemRegistry_Item.registry(INSTANCE, event);
		GVCR2ItemRegistry_GUN_GRENADE.registry(INSTANCE, event);
		GVCR2ItemRegistry_GUN.registry(INSTANCE, event);
		GVCR2ItemRegistry_GUN_AR.registry(INSTANCE, event);
		GVCR2ItemRegistry_GUN_SMG.registry(INSTANCE, event);
		GVCR2ItemRegistry_GUN_RF.registry(INSTANCE, event);
		GVCR2ItemRegistry_GUN_MG.registry(INSTANCE, event);
		GVCR2ItemRegistry_GUN_SG.registry(INSTANCE, event);
		GVCR2ItemRegistry_GUN_RL.registry(INSTANCE, event);
		GVCR2ItemRegistry_GUN_SW.registry(INSTANCE, event);
		GVCR2ItemRegistry_GUN_ARMOR.registry(INSTANCE, event);
		GVCR2ItemRegistry_GUN_ATTACHMENT.registry(INSTANCE, event);
		GVCR2ItemRegistry_Drone.registry(INSTANCE, event);
		GVCR2ItemRegistry_MOB.registry(INSTANCE, event);
		GVCR2ItemRegistry_Block.registry(INSTANCE, event);
	}
	
	@SubscribeEvent
    protected static void registerBlocks(RegistryEvent.Register<Block> event){
		GVCR2BlockRegistry.registry(INSTANCE, event);
		GVCR2BlockRegistry_Utility.registry(INSTANCE, event);
		GVCR2BlockRegistry_MOB.registry(INSTANCE, event);
		GVCR2BlockRegistry_Building.registry(INSTANCE, event);
	}
	
	@SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event) {
		GVCR2ModelRegistry.registry(INSTANCE, event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent pEvent) {
		int D = Short.MAX_VALUE;
		
		GVCR2RecipeRegistrys.recipe();
		
		GVCR2EntityRegistrys.registrys();
		
		
		//Event髢｢菫ゅ�ｯ縺薙▲縺｡�ｼ�
		GVCR2EventRegistry.registrys(pEvent);
		
		
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this.INSTANCE, new GVCR2GuiHandler());
		
		FMLCommonHandler.instance().bus().register(this);
		proxy.reisterRenderers();
		proxy.getClient();
		proxy.getCilentWorld();
		proxy.registerTileEntity();
		proxy.InitRendering();
		proxy.ProxyFile();
		proxy.getEntityPlayerInstance();
	}
	
}

	
	

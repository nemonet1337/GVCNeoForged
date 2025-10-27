package gvcr2.registry;

import gvcr2.mod_GVCR2;
import gvcr2.item.ItemGVC;
import gvcr2.item.ItemGVCR2_SPAWN;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class GVCR2ItemRegistry_MOB {
	public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Item> event){
		{
			mod.gvcr2_spawn_ge_s	= new ItemGVCR2_SPAWN(0).setUnlocalizedName("gvcr2_spawn_ge_s")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ge_s").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ge_s);
		}
		
		{
			mod.gvcr2_spawn_ge_sv	= new ItemGVCR2_SPAWN(1).setUnlocalizedName("gvcr2_spawn_ge_sv")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ge_sv").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ge_sv);
		}
		{
			mod.gvcr2_spawn_ge_sv_fire	= new ItemGVCR2_SPAWN(110).setUnlocalizedName("gvcr2_spawn_ge_sv_fire")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ge_sv_fire").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ge_sv_fire);
		}
		{
			mod.gvcr2_spawn_ge_sv_trench	= new ItemGVCR2_SPAWN(111).setUnlocalizedName("gvcr2_spawn_ge_sv_trench")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ge_sv_trench").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ge_sv_trench);
		}
		{
			mod.gvcr2_spawn_ge_sv_antitank	= new ItemGVCR2_SPAWN(112).setUnlocalizedName("gvcr2_spawn_ge_sv_antitank")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ge_sv_antitank").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ge_sv_antitank);
		}
		{
			mod.gvcr2_spawn_ge_sv_sniper	= new ItemGVCR2_SPAWN(113).setUnlocalizedName("gvcr2_spawn_ge_sv_sniper")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ge_sv_sniper").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ge_sv_sniper);
		}
		{
			mod.gvcr2_spawn_ge_sv_drone	= new ItemGVCR2_SPAWN(114).setUnlocalizedName("gvcr2_spawn_ge_sv_drone")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ge_sv_drone").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ge_sv_drone);
		}
		
		{
			mod.gvcr2_spawn_ge_pow	= new ItemGVCR2_SPAWN(115).setUnlocalizedName("gvcr2_spawn_ge_pow")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ge_pow").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ge_pow);
		}
		
		{
			mod.gvcr2_spawn_ge_se_assault	= new ItemGVCR2_SPAWN(2).setUnlocalizedName("gvcr2_spawn_ge_se_assault")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ge_se_assault").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ge_se_assault);
		}
		{
			mod.gvcr2_spawn_ge_se_cerberus	= new ItemGVCR2_SPAWN(3).setUnlocalizedName("gvcr2_spawn_ge_se_cerberus")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ge_se_cerberus").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ge_se_cerberus);
		}
		{
			mod.gvcr2_spawn_ge_se_hacs	= new ItemGVCR2_SPAWN(4).setUnlocalizedName("gvcr2_spawn_ge_se_hacs")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ge_se_hacs").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ge_se_hacs);
		}
		{
			mod.gvcr2_spawn_ge_se_kukri	= new ItemGVCR2_SPAWN(5).setUnlocalizedName("gvcr2_spawn_ge_se_kukri")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ge_se_kukri").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ge_se_kukri);
		}
		{
			mod.gvcr2_spawn_ge_s_mr_cpt	= new ItemGVCR2_SPAWN(6).setUnlocalizedName("gvcr2_spawn_ge_s_mr_cpt")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ge_s_mr_cpt").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ge_s_mr_cpt);
		}
		
		
		{
			mod.gvcr2_spawn_pmc_s	= new ItemGVCR2_SPAWN(15).setUnlocalizedName("gvcr2_spawn_pmc_s")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_pmc_s").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_pmc_s);
		}
		{
			mod.gvcr2_spawn_so_s	= new ItemGVCR2_SPAWN(16).setUnlocalizedName("gvcr2_spawn_so_s")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_so_s").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_so_s);
		}
		{
			mod.gvcr2_spawn_so_s_mr_cpt	= new ItemGVCR2_SPAWN(14).setUnlocalizedName("gvcr2_spawn_so_s_mr_cpt")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_so_s_mr_cpt").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_so_s_mr_cpt);
		}
		{
			mod.gvcr2_spawn_so_s_af_cpt	= new ItemGVCR2_SPAWN(1401).setUnlocalizedName("gvcr2_spawn_so_s_af_cpt")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_so_s_af_cpt").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_so_s_af_cpt);
		}
		{
			mod.gvcr2_spawn_sp_rex	= new ItemGVCR2_SPAWN(17).setUnlocalizedName("gvcr2_spawn_sp_rex")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_sp_rex").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_sp_rex);
		}
		{
			mod.gvcr2_spawn_npc_arms_trader	= new ItemGVCR2_SPAWN(18).setUnlocalizedName("gvcr2_spawn_npc_arms_trader")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_npc_arms_trader").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_npc_arms_trader);
		}
		{
			mod.gvcr2_spawn_sp_st1	= new ItemGVCR2_SPAWN(19).setUnlocalizedName("gvcr2_spawn_sp_st1")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_sp_st1").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_sp_st1);
		}
		
		
		{
			mod.gvcr2_spawn_boss_longleg	= new ItemGVCR2_SPAWN(160).setUnlocalizedName("gvcr2_spawn_boss_longleg")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_boss_longleg").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_boss_longleg);
		    
		    mod.gvcr2_spawn_boss_st1	= new ItemGVCR2_SPAWN(161).setUnlocalizedName("gvcr2_spawn_boss_st1")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_boss_st1").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_boss_st1);
		    
		    mod.gvcr2_spawn_boss_mer08	= new ItemGVCR2_SPAWN(162).setUnlocalizedName("gvcr2_spawn_boss_mer08")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_boss_mer08").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_boss_mer08);
		    
		    mod.gvcr2_spawn_boss_mer08_sn	= new ItemGVCR2_SPAWN(163).setUnlocalizedName("gvcr2_spawn_boss_mer08_sn")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_boss_mer08_sn").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_boss_mer08_sn);
		    
		    mod.gvcr2_spawn_boss_mer08_b	= new ItemGVCR2_SPAWN(169).setUnlocalizedName("gvcr2_spawn_boss_mer08_b")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_boss_mer08_b").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_boss_mer08_b);
		    mod.gvcr2_spawn_boss_mer03k	= new ItemGVCR2_SPAWN(225).setUnlocalizedName("gvcr2_spawn_boss_mer03k")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_boss_mer03k").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_boss_mer03k);
		    
		    mod.gvcr2_spawn_boss_hauneb	= new ItemGVCR2_SPAWN(164).setUnlocalizedName("gvcr2_spawn_boss_hauneb")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_boss_hauneb").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_boss_hauneb);
		    
		    mod.gvcr2_spawn_boss_irving	= new ItemGVCR2_SPAWN(165).setUnlocalizedName("gvcr2_spawn_boss_irving")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_boss_irving").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_boss_irving);
		    
		    mod.gvcr2_block_debag_boss_cv	= new ItemGVCR2_SPAWN(166).setUnlocalizedName("gvcr2_block_debag_boss_cv")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_debag_boss_cv").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_block_debag_boss_cv);
		    
		    mod.gvcr2_block_debag_boss_airbase	= new ItemGVCR2_SPAWN(171).setUnlocalizedName("gvcr2_block_debag_boss_airbase")
					.setRegistryName(mod.MOD_ID, "gvcr2_block_debag_boss_airbase").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_block_debag_boss_airbase);
		    
		    mod.gvcr2_spawn_boss_char2c	= new ItemGVCR2_SPAWN(168).setUnlocalizedName("gvcr2_spawn_boss_char2c")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_boss_char2c").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_boss_char2c);
		    
		    mod.gvcr2_spawn_boss_av8b	= new ItemGVCR2_SPAWN(172).setUnlocalizedName("gvcr2_spawn_boss_av8b")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_boss_av8b").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_boss_av8b);
		    
		    mod.gvcr2_spawn_boss_ratte	= new ItemGVCR2_SPAWN(173).setUnlocalizedName("gvcr2_spawn_boss_ratte")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_boss_ratte").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_boss_ratte);
		    
		    mod.gvcr2_spawn_boss_tb3	= new ItemGVCR2_SPAWN(174).setUnlocalizedName("gvcr2_spawn_boss_tb3")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_boss_tb3").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_boss_tb3);
		    
		    mod.gvcr2_spawn_boss_airship	= new ItemGVCR2_SPAWN(175).setUnlocalizedName("gvcr2_spawn_boss_airship")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_boss_airship").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_boss_airship);
		}
		
		{
			mod.gvcr2_spawn_unks_c_s	= new ItemGVCR2_SPAWN(220).setUnlocalizedName("gvcr2_spawn_unks_c_s")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_unks_c_s").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_unks_c_s);
		}
		
		
		
		
		
		{
			mod.gvcr2_spawn_car_technical	= new ItemGVCR2_SPAWN(20).setUnlocalizedName("gvcr2_spawn_car_technical")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_car_technical").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_car_technical);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 6;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_car_technical;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_car_technical;
				spawn.text1 = "gvcr2.string.spawn.vehicle_tec.name";
				spawn.text2 = "3-SEATs";
				spawn.text3 = "gvcr2.string.spawn.vehicle_tec_3.name";
		    }
		}
		{
			mod.gvcr2_spawn_car_technical_mortar	= new ItemGVCR2_SPAWN(2001).setUnlocalizedName("gvcr2_spawn_car_technical_mortar")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_car_technical_mortar").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_car_technical_mortar);
		    {
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_car_technical_mortar;
				spawn.text1 = "gvcr2.string.spawn.vehicle_tec.name";
				spawn.text2 = "3-SEATs";
				spawn.text3 = "gvcr2.string.spawn.vehicle_tec_3.name";
		    }
		}
		{
			mod.gvcr2_spawn_car_technical_aa	= new ItemGVCR2_SPAWN(2002).setUnlocalizedName("gvcr2_spawn_car_technical_aa")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_car_technical_aa").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_car_technical_aa);
		    {
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_car_technical_aa;
				spawn.text1 = "gvcr2.string.spawn.vehicle_tec.name";
				spawn.text2 = "3-SEATs";
				spawn.text3 = "gvcr2.string.spawn.vehicle_tec_3.name";
		    }
		}
		{
			mod.gvcr2_spawn_car_technical_rocket	= new ItemGVCR2_SPAWN(2003).setUnlocalizedName("gvcr2_spawn_car_technical_rocket")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_car_technical_rocket").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_car_technical_rocket);
		    {
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_car_technical_rocket;
				spawn.text1 = "gvcr2.string.spawn.vehicle_tec.name";
				spawn.text2 = "3-SEATs";
				spawn.text3 = "gvcr2.string.spawn.vehicle_tec_3.name";
		    }
		}
		{
			mod.gvcr2_spawn_car_technical_tnt	= new ItemGVCR2_SPAWN(2004).setUnlocalizedName("gvcr2_spawn_car_technical_tnt")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_car_technical_tnt").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_car_technical_tnt);
		    {
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_car_technical_tnt;
				spawn.text1 = "gvcr2.string.spawn.vehicle_tec.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "gvcr2.string.spawn.vehicle_tec_3.name";
		    }
		}
		{
			mod.gvcr2_spawn_car_bike	= new ItemGVCR2_SPAWN(21).setUnlocalizedName("gvcr2_spawn_car_bike")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_car_bike").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_car_bike);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 3;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_car_bike;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_car_bike;
				spawn.text1 = "gvcr2.string.spawn.vehicle_tec.name";
				spawn.text2 = "1-SEATs";
		    }
		}
		{
			mod.gvcr2_spawn_car_buggy	= new ItemGVCR2_SPAWN(22).setUnlocalizedName("gvcr2_spawn_car_buggy")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_car_buggy").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_car_buggy);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 3;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_car_buggy;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_car_buggy;
				spawn.text1 = "gvcr2.string.spawn.vehicle_tec.name";
				spawn.text2 = "2-SEATs";
		    }
		}
		{
			mod.gvcr2_spawn_car_hmmwv	= new ItemGVCR2_SPAWN(23).setUnlocalizedName("gvcr2_spawn_car_hmmwv")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_car_hmmwv").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_car_hmmwv);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 6;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 6;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 3;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_car_hmmwv;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_car_hmmwv;
				spawn.text1 = "gvcr2.string.spawn.vehicle_tec.name";
				spawn.text2 = "5-SEATs";
		    }
		}
		{
			mod.gvcr2_spawn_car_armor_bulldozer	= new ItemGVCR2_SPAWN(24).setUnlocalizedName("gvcr2_spawn_car_armor_bulldozer")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_car_armor_bulldozer").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_car_armor_bulldozer);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 3;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 6;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 3;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_car_armor_bulldozer;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_car_armor_bulldozer;
				spawn.text1 = "gvcr2.string.spawn.vehicle_tec.name";
				spawn.text2 = "1-SEATs";
		    }
		}
		
		{
			mod.gvcr2_spawn_apc_m113	= new ItemGVCR2_SPAWN(30).setUnlocalizedName("gvcr2_spawn_apc_m113")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_apc_m113").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_apc_m113);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 3;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 6;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 3;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_apc_m113;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_apc_m113;
				spawn.text1 = "gvcr2.string.spawn.vehicle_apc.name";
				spawn.text2 = "5-SEATs";
				spawn.text3 = "Weapon1::HMG";
		    }
		}
		{
			mod.gvcr2_spawn_apc_btr60	= new ItemGVCR2_SPAWN(39).setUnlocalizedName("gvcr2_spawn_apc_btr60")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_apc_btr60").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_apc_btr60);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 3;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 6;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 6;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_apc_btr60;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_apc_btr60;
				spawn.text1 = "gvcr2.string.spawn.vehicle_apc.name";
				spawn.text2 = "5-SEATs";
				spawn.text3 = "Weapon1::HMG";
		    }
		}
		{
			mod.gvcr2_spawn_apc_bmp3	= new ItemGVCR2_SPAWN(394).setUnlocalizedName("gvcr2_spawn_apc_bmp3")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_apc_bmp3").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_apc_bmp3);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_apc_bmp3;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_apc_bmp3;
				spawn.text1 = "gvcr2.string.spawn.vehicle_ifv.name";
				spawn.text2 = "5-SEATs";
				spawn.text3 = "Weapon1::100mmCannon";
				spawn.text4 = "Weapon2::30mmMG";
		    }
		}
		{
			mod.gvcr2_spawn_apc_m113_aa	= new ItemGVCR2_SPAWN(31).setUnlocalizedName("gvcr2_spawn_apc_m113_aa")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_apc_m113_aa").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_apc_m113_aa);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 3;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_apc_m113_aa;
				++mod.vehicle_id_2;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_apc_m113_aa;
				spawn.text1 = "gvcr2.string.spawn.vehicle_spaag.name";
				spawn.text2 = "5-SEATs";
				spawn.text3 = "Weapon1::20mmAAG";
		    }
		}
		{
			mod.gvcr2_spawn_apc_m113_ifv	= new ItemGVCR2_SPAWN(32).setUnlocalizedName("gvcr2_spawn_apc_m113_ifv")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_apc_m113_ifv").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_apc_m113_ifv);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 3;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_apc_m113_ifv;
				++mod.vehicle_id_2;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_apc_m113_ifv;
				spawn.text1 = "gvcr2.string.spawn.vehicle_ifv.name";
				spawn.text2 = "5-SEATs";
				spawn.text3 = "Weapon1::25mmMC";
		    }
		}
		{
			mod.gvcr2_spawn_apc_m113_spg	= new ItemGVCR2_SPAWN(33).setUnlocalizedName("gvcr2_spawn_apc_m113_spg")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_apc_m113_spg").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_apc_m113_spg);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 3;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_apc_m113_spg;
				++mod.vehicle_id_2;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_apc_m113_spg;
				spawn.text1 = "gvcr2.string.spawn.vehicle_spg.name";
				spawn.text2 = "5-SEATs";
				spawn.text3 = "Weapon1::60mmMortar";
		    }
		}
		{
			mod.gvcr2_spawn_apc_m1126	= new ItemGVCR2_SPAWN(34).setUnlocalizedName("gvcr2_spawn_apc_m1126")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_apc_m1126").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_apc_m1126);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 12;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 12;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 12;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_apc_m1126;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_apc_m1126;
				spawn.text1 = "gvcr2.string.spawn.vehicle_apc.name";
				spawn.text2 = "6-SEATs";
				spawn.text3 = "Weapon1::HMG";
		    }
		}
		{
			mod.gvcr2_spawn_apc_m1128	= new ItemGVCR2_SPAWN(35).setUnlocalizedName("gvcr2_spawn_apc_m1128")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_apc_m1128").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_apc_m1128);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 12;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 12;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 12;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_apc_m1128;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_apc_m1128;
				spawn.text1 = "gvcr2.string.spawn.vehicle_td.name";
				spawn.text2 = "6-SEATs";
				spawn.text3 = "Weapon1::105mmCannon";
		    }
		}
		{
			mod.gvcr2_spawn_apc_m1129	= new ItemGVCR2_SPAWN(36).setUnlocalizedName("gvcr2_spawn_apc_m1129")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_apc_m1129").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_apc_m1129);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 12;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 12;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 12;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_apc_m1129;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_apc_m1129;
				spawn.text1 = "gvcr2.string.spawn.vehicle_spg.name";
				spawn.text2 = "6-SEATs";
				spawn.text3 = "Weapon1::120mmMortar";
		    }
		}
		{
			mod.gvcr2_spawn_apc_lav25	= new ItemGVCR2_SPAWN(37).setUnlocalizedName("gvcr2_spawn_apc_lav25")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_apc_lav25").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_apc_lav25);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_apc_lav25;
				++mod.vehicle_id_2;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_apc_lav25;
				spawn.text1 = "gvcr2.string.spawn.vehicle_ifv.name";
				spawn.text2 = "5-SEATs";
				spawn.text3 = "Weapon1::25mmMC";
				spawn.text4 = "Weapon2::76mmRocket";
		    }
		}
		{
			mod.gvcr2_spawn_apc_lav25ad	= new ItemGVCR2_SPAWN(38).setUnlocalizedName("gvcr2_spawn_apc_lav25ad")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_apc_lav25ad").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_apc_lav25ad);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 12;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 12;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 12;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_apc_lav25ad;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_apc_lav25ad;
				spawn.text1 = "gvcr2.string.spawn.vehicle_spaag.name";
				spawn.text2 = "5-SEATs";
				spawn.text3 = "Weapon1::20mmAAG";
				spawn.text4 = "Weapon2::SAMissile(IR)";
		    }
		}
		{
			mod.gvcr2_spawn_apc_m1097	= new ItemGVCR2_SPAWN(391).setUnlocalizedName("gvcr2_spawn_apc_m1097")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_apc_m1097").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_apc_m1097);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 12;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 12;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 12;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_apc_m1097;
				++mod.vehicle_id_2;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_apc_m1097;
				spawn.text1 = "gvcr2.string.spawn.vehicle_spaag.name";
				spawn.text2 = "5-SEATs";
				spawn.text3 = "Weapon1::20mmAAG";
				spawn.text4 = "Weapon2::SAMissile(IR)";
		    }
		}
		{
			mod.gvcr2_spawn_apc_9k35	= new ItemGVCR2_SPAWN(392).setUnlocalizedName("gvcr2_spawn_apc_9k35")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_apc_9k35").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_apc_9k35);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 12;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 12;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 12;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_apc_9k35;
				++mod.vehicle_id_2;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_apc_9k35;
				spawn.text1 = "gvcr2.string.spawn.vehicle_spaag.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::SAMissile(AR)";
		    }
		}
		{
			mod.gvcr2_spawn_apc_m270	= new ItemGVCR2_SPAWN(393).setUnlocalizedName("gvcr2_spawn_apc_m270")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_apc_m270").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_apc_m270);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 24;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 24;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 24;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_apc_m270;
				++mod.vehicle_id_2;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_apc_m270;
				spawn.text1 = "gvcr2.string.spawn.vehicle_sprg.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::227mmRocket";
		    }
		}
		
		
		
		
		
		
		{
			mod.gvcr2_spawn_heli_ah1s	= new ItemGVCR2_SPAWN(40).setUnlocalizedName("gvcr2_spawn_heli_ah1s")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_heli_ah1s").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_heli_ah1s);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 24;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_heli_ah1s;
				++mod.vehicle_id_2;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_heli_ah1s;
				spawn.text1 = "gvcr2.string.spawn.vehicle_ah.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::20mmMC";
				spawn.text4 = "Weapon2::76mmRocket";
		    }
		}
		{
			mod.gvcr2_spawn_heli_r22	= new ItemGVCR2_SPAWN(142).setUnlocalizedName("gvcr2_spawn_heli_r22")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_heli_r22").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_heli_r22);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 1;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 1;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 8;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_heli_r22;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_heli_r22;
				spawn.text1 = "gvcr2.string.spawn.vehicle_rh.name";
				spawn.text2 = "4-SEATs";
				spawn.text3 = "Weapon1::7.62mmMG";
				spawn.text4 = "Weapon2::RocketLauncher";
		    }
		}
		{
			mod.gvcr2_spawn_heli_ah6	= new ItemGVCR2_SPAWN(41).setUnlocalizedName("gvcr2_spawn_heli_ah6")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_heli_ah6").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_heli_ah6);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 3;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 3;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 16;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_heli_ah6;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_heli_ah6;
				spawn.text1 = "gvcr2.string.spawn.vehicle_rh.name";
				spawn.text2 = "4-SEATs";
				spawn.text3 = "Weapon1::7.62mmMG";
		    }
		}
		{
			mod.gvcr2_spawn_heli_uh1	= new ItemGVCR2_SPAWN(42).setUnlocalizedName("gvcr2_spawn_heli_uh1")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_heli_uh1").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_heli_uh1);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 6;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 9;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 16;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_heli_uh1;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_heli_uh1;
				spawn.text1 = "gvcr2.string.spawn.vehicle_uh.name";
				spawn.text2 = "6-SEATs";
		    }
		}
		{
			mod.gvcr2_spawn_heli_g_heli	= new ItemGVCR2_SPAWN(43).setUnlocalizedName("gvcr2_spawn_heli_g_heli")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_heli_g_heli").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_heli_g_heli);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 3;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 9;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 16;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_heli_g_heli;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_heli_g_heli;
				spawn.text1 = "gvcr2.string.spawn.vehicle_uh.name";
				spawn.text2 = "4-SEATs";
		    }
		}
		{
			mod.gvcr2_spawn_heli_mi24d	= new ItemGVCR2_SPAWN(44).setUnlocalizedName("gvcr2_spawn_heli_mi24d")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_heli_mi24d").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_heli_mi24d);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 24;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_heli_mi24d;
				++mod.vehicle_id_2;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_heli_mi24d;
				spawn.text1 = "gvcr2.string.spawn.vehicle_ah.name";
				spawn.text2 = "3-SEATs";
				spawn.text3 = "Weapon1::1.27mmMG";
				spawn.text4 = "Weapon2::76mmRocket";
		    }
		}
		{
			mod.gvcr2_spawn_heli_ch47	= new ItemGVCR2_SPAWN(45).setUnlocalizedName("gvcr2_spawn_heli_ch47")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_heli_ch47").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_heli_ch47);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 24;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 24;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_heli_ch47;
				++mod.vehicle_id_2;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_heli_ch47;
				spawn.text1 = "gvcr2.string.spawn.vehicle_uh.name";
				spawn.text2 = "16-SEATs";
		    }
		}
		{
			mod.gvcr2_spawn_heli_uh1y	= new ItemGVCR2_SPAWN(46).setUnlocalizedName("gvcr2_spawn_heli_uh1y")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_heli_uh1y").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_heli_uh1y);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 9;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 24;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 24;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_heli_uh1y;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_heli_uh1y;
				spawn.text1 = "gvcr2.string.spawn.vehicle_uh.name";
				spawn.text2 = "6-SEATs";
		    }
		}
		{
			mod.gvcr2_spawn_heli_uh60	= new ItemGVCR2_SPAWN(47).setUnlocalizedName("gvcr2_spawn_heli_uh60")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_heli_uh60").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_heli_uh60);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 9;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 24;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 24;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_heli_uh60;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_heli_uh60;
				spawn.text1 = "gvcr2.string.spawn.vehicle_uh.name";
				spawn.text2 = "6-SEATs";
		    }
		}
		
		{
			mod.gvcr2_spawn_heli_ah1z	= new ItemGVCR2_SPAWN(48).setUnlocalizedName("gvcr2_spawn_heli_ah1z")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_heli_ah1z").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_heli_ah1z);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 18;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 18;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 48;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_heli_ah1z;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_heli_ah1z;
				spawn.text1 = "gvcr2.string.spawn.vehicle_ah.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::20mmMC";
				spawn.text4 = "Weapon2::76mmRocket";
				spawn.text5 = "Weapon3::AAMissile(IR)";
		    }
		}
		{
			mod.gvcr2_spawn_heli_ka50	= new ItemGVCR2_SPAWN(49).setUnlocalizedName("gvcr2_spawn_heli_ka50")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_heli_ka50").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_heli_ka50);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 18;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 18;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 48;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_heli_ka50;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_heli_ka50;
				spawn.text1 = "gvcr2.string.spawn.vehicle_ah.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::30mmMC";
				spawn.text4 = "Weapon2::76mmRocket";
				spawn.text5 = "Weapon3::AAMissile(IR)";
		    }
		}
		{
			mod.gvcr2_spawn_heli_z10	= new ItemGVCR2_SPAWN(140).setUnlocalizedName("gvcr2_spawn_heli_z10")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_heli_z10").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_heli_z10);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 18;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 18;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 48;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_heli_z10;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_heli_z10;
				spawn.text1 = "gvcr2.string.spawn.vehicle_ah.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::23mmMC";
				spawn.text4 = "Weapon2::76mmRocket";
				spawn.text5 = "Weapon3::AAMissile(IR)";
		    }
		}
		{
			mod.gvcr2_spawn_heli_ka60	= new ItemGVCR2_SPAWN(141).setUnlocalizedName("gvcr2_spawn_heli_ka60")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_heli_ka60").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_heli_ka60);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 9;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 24;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 24;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_heli_ka60;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_heli_ka60;
				spawn.text1 = "gvcr2.string.spawn.vehicle_uh.name";
				spawn.text2 = "6-SEATs";
		    }
		}
		
		
		
		
		
		{
			mod.gvcr2_spawn_tank_m60a1	= new ItemGVCR2_SPAWN(50).setUnlocalizedName("gvcr2_spawn_tank_m60a1")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_tank_m60a1").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_tank_m60a1);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 18;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 12;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_tank_m60a1;
				++mod.vehicle_id_2;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_tank_m60a1;
				spawn.text1 = "gvcr2.string.spawn.vehicle_mbt.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::105mmCannon";
				spawn.text4 = "Weapon2::MMG";
		    }
		}
		{
			mod.gvcr2_spawn_tank_m1	= new ItemGVCR2_SPAWN(51).setUnlocalizedName("gvcr2_spawn_tank_m1")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_tank_m1").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_tank_m1);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 32;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 32;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_tank_m1;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_tank_m1;
				spawn.text1 = "gvcr2.string.spawn.vehicle_mbt.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::120mmCannon";
				spawn.text4 = "Weapon2::HMG";
		    }
		}
		{
			mod.gvcr2_spawn_tank_m41	= new ItemGVCR2_SPAWN(52).setUnlocalizedName("gvcr2_spawn_tank_m41")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_tank_m41").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_tank_m41);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 3;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 9;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 6;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_tank_m41;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_tank_m41;
				spawn.text1 = "gvcr2.string.spawn.vehicle_lt.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::76mmCannon";
				spawn.text4 = "Weapon2::MMG";
		    }
		}
		{
			mod.gvcr2_spawn_tank_m551	= new ItemGVCR2_SPAWN(53).setUnlocalizedName("gvcr2_spawn_tank_m551")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_tank_m551").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_tank_m551);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 16;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_tank_m551;
				++mod.vehicle_id_2;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_tank_m551;
				spawn.text1 = "gvcr2.string.spawn.vehicle_lt.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::152mmGunLuncher";
				spawn.text4 = "Weapon2::MMG";
		    }
		}
		{
			mod.gvcr2_spawn_tank_t34	= new ItemGVCR2_SPAWN(54).setUnlocalizedName("gvcr2_spawn_tank_t34")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_tank_t34").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_tank_t34);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 9;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 4;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_tank_t34;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_tank_t34;
				spawn.text1 = "gvcr2.string.spawn.vehicle_mt.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::85mmCannon";
				spawn.text4 = "Weapon2::MMG";
		    }
		}
		{
			mod.gvcr2_spawn_tank_t55	= new ItemGVCR2_SPAWN(55).setUnlocalizedName("gvcr2_spawn_tank_t55")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_tank_t55").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_tank_t55);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 16;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_tank_t55;
				++mod.vehicle_id_2;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_tank_t55;
				spawn.text1 = "gvcr2.string.spawn.vehicle_mbt.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::100mmCannon";
				spawn.text4 = "Weapon2::MMG";
		    }
		}
		{
			mod.gvcr2_spawn_tank_t72	= new ItemGVCR2_SPAWN(56).setUnlocalizedName("gvcr2_spawn_tank_t72")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_tank_t72").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_tank_t72);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 32;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 24;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_tank_t72;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_tank_t72;
				spawn.text1 = "gvcr2.string.spawn.vehicle_mbt.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::125mmCannon";
				spawn.text4 = "Weapon2::HMG";
		    }
		}
		{
			mod.gvcr2_spawn_tank_t90	= new ItemGVCR2_SPAWN(64).setUnlocalizedName("gvcr2_spawn_tank_t90")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_tank_t90").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_tank_t90);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 64;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 32;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_tank_t90;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_tank_t90;
				spawn.text1 = "gvcr2.string.spawn.vehicle_mbt.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::125mmCannon";
				spawn.text4 = "Weapon2::HMG";
		    }
		}
		{
			mod.gvcr2_spawn_tank_pt76	= new ItemGVCR2_SPAWN(57).setUnlocalizedName("gvcr2_spawn_tank_pt76")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_tank_pt76").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_tank_pt76);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 6;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 6;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_tank_pt76;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_tank_pt76;
				spawn.text1 = "gvcr2.string.spawn.vehicle_lt.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::76mmCannon";
				spawn.text4 = "Weapon2::MMG";
		    }
		}
		{
			mod.gvcr2_spawn_tank_kv2	= new ItemGVCR2_SPAWN(58).setUnlocalizedName("gvcr2_spawn_tank_kv2")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_tank_kv2").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_tank_kv2);
		    {
		    	ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_tank_kv2;
				spawn.text1 = "gvcr2.string.spawn.vehicle_ht.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::152mmCannon";
		    }
		}
		
		{
			mod.gvcr2_spawn_tank_fv101	= new ItemGVCR2_SPAWN(59).setUnlocalizedName("gvcr2_spawn_tank_fv101")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_tank_fv101").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_tank_fv101);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 6;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 6;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_tank_fv101;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_tank_fv101;
				spawn.text1 = "gvcr2.string.spawn.vehicle_lt.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::76mmCannon";
				spawn.text4 = "Weapon2::MMG";
		    }
		}
		{
			mod.gvcr2_spawn_tank_zsu_23_4	= new ItemGVCR2_SPAWN(60).setUnlocalizedName("gvcr2_spawn_tank_zsu_23_4")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_tank_zsu_23_4").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_tank_zsu_23_4);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 16;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 16;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_tank_zsu_23_4;
				++mod.vehicle_id_2;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_tank_zsu_23_4;
				spawn.text1 = "gvcr2.string.spawn.vehicle_aat.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::23mmAAC";
		    }
		}
		{
			mod.gvcr2_spawn_tank_2k22	= new ItemGVCR2_SPAWN(61).setUnlocalizedName("gvcr2_spawn_tank_2k22")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_tank_2k22").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_tank_2k22);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 24;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 32;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_tank_2k22;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_tank_2k22;
				spawn.text1 = "gvcr2.string.spawn.vehicle_aat.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::30mmAAC";
				spawn.text4 = "Weapon2::SAMissile(IR)";
		    }
		}
		
		{
			mod.gvcr2_spawn_tank_m1a2	= new ItemGVCR2_SPAWN(62).setUnlocalizedName("gvcr2_spawn_tank_m1a2")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_tank_m1a2").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_tank_m1a2);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 64;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 32;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_tank_m1a2;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_tank_m1a2;
				spawn.text1 = "gvcr2.string.spawn.vehicle_mbt.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::120mmCannon";
				spawn.text4 = "Weapon2::MMG&HMG";
		    }
		}
		{
			mod.gvcr2_spawn_tank_m41dk1	= new ItemGVCR2_SPAWN(63).setUnlocalizedName("gvcr2_spawn_tank_m41dk1")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_tank_m41dk1").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_tank_m41dk1);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_tank_m41dk1;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_tank_m41dk1;
				spawn.text1 = "gvcr2.string.spawn.vehicle_lt.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::76mmCannon";
				spawn.text4 = "Weapon2::MMG";
		    }
		}
		{
			mod.gvcr2_spawn_tank_ratte	= new ItemGVCR2_SPAWN(65).setUnlocalizedName("gvcr2_spawn_tank_ratte")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_tank_ratte").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_tank_ratte);
		    {
		    	ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_tank_ratte;
				spawn.text1 = "gvcr2.string.spawn.vehicle_sht.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::280mmCannon";
				spawn.text4 = "Weapon2::AUTO_AAGun";
				spawn.text5 = "Weapon3::AUTO_AACannon";
				spawn.text6 = "Weapon4::AUTO_FrontMG";
		    }
		}
		
		
		
		{
			mod.gvcr2_spawn_air_yak23	= new ItemGVCR2_SPAWN(108).setUnlocalizedName("gvcr2_spawn_air_yak23")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_air_yak23").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_air_yak23);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 24;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 9;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 24;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_air_yak23;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_air_yak23;
				spawn.text1 = "gvcr2.string.spawn.vehicle_fighter.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::23mmMC";
				//spawn.text6 = "gvcr2.string.spawn.vehicle_weapon.name";
		    }
		}
		{
			mod.gvcr2_spawn_air_yak23kai	= new ItemGVCR2_SPAWN(1100).setUnlocalizedName("gvcr2_spawn_air_yak23kai")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_air_yak23kai").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_air_yak23kai);
		    {
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_air_yak23kai;
				spawn.text1 = "gvcr2.string.spawn.vehicle_fighter.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::23mmMC";
				spawn.text4 = "Weapon2::AAMissile(IR)";
				//spawn.text6 = "gvcr2.string.spawn.vehicle_weapon.name";
		    }
		}
		{
			mod.gvcr2_spawn_air_a4	= new ItemGVCR2_SPAWN(109).setUnlocalizedName("gvcr2_spawn_air_a4")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_air_a4").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_air_a4);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 24;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 9;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 24;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_air_a4;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_air_a4;
				spawn.text1 = "gvcr2.string.spawn.vehicle_fighter.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::20mmMC";
				spawn.text4 = "Weapon2::AAMissile(IR)";
				//spawn.text6 = "gvcr2.string.spawn.vehicle_weapon.name";
		    }
		}
		{
			mod.gvcr2_spawn_air_an2	= new ItemGVCR2_SPAWN(1101).setUnlocalizedName("gvcr2_spawn_air_an2")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_air_an2").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_air_an2);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 24;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 9;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 24;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_air_an2;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_air_an2;
				spawn.text1 = "gvcr2.string.spawn.bomber.name";
				spawn.text2 = "12-SEATs";
				spawn.text3 = "Weapon1::250kgBomb";
				//spawn.text6 = "gvcr2.string.spawn.vehicle_weapon.name";
		    }
		}
		
		{
			mod.gvcr2_spawn_air_f16	= new ItemGVCR2_SPAWN(100).setUnlocalizedName("gvcr2_spawn_air_f16")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_air_f16").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_air_f16);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 32;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 16;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 32;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_air_f16;
				++mod.vehicle_id_2;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_air_f16;
				spawn.text1 = "gvcr2.string.spawn.vehicle_fighter.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::20mmMC";
				spawn.text4 = "Weapon2::AAMissile(IR)";
				spawn.text5 = "Weapon3::AAMissile(AR)";
				//spawn.text6 = "gvcr2.string.spawn.vehicle_weapon.name";
		    }
		}
		{
			mod.gvcr2_spawn_air_f18	= new ItemGVCR2_SPAWN(101).setUnlocalizedName("gvcr2_spawn_air_f18")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_air_f18").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_air_f18);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 48;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 32;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 48;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_air_f18;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_air_f18;
				spawn.text1 = "gvcr2.string.spawn.vehicle_fighter.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::20mmMC";
				spawn.text4 = "Weapon2::AAMissile(IR)";
				spawn.text5 = "Weapon3::AAMissile(AR)";
				spawn.text6 = "gvcr2.string.spawn.vehicle_weapon.name";
		    }
		}
		{
			mod.gvcr2_spawn_air_a10	= new ItemGVCR2_SPAWN(102).setUnlocalizedName("gvcr2_spawn_air_a10")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_air_a10").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_air_a10);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 48;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 32;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 48;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_air_a10;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_air_a10;
				spawn.text1 = "gvcr2.string.spawn.vehicle_attacker.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::30mmMC";
				spawn.text4 = "Weapon2::AGMissile";
				spawn.text5 = "Weapon3::500lbBomb";
				spawn.text6 = "gvcr2.string.spawn.vehicle_weapon.name";
		    }
		}
		{
			mod.gvcr2_spawn_air_av8b	= new ItemGVCR2_SPAWN(1104).setUnlocalizedName("gvcr2_spawn_air_av8b")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_air_av8b").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_air_av8b);
		    {
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_air_av8b;
				spawn.text1 = "gvcr2.string.spawn.vehicle_attacker.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::20mmMC";
				spawn.text4 = "Weapon2::AAMissile(IR)";
				spawn.text5 = "Weapon3::76mmRocket";
				spawn.text6 = "gvcr2.string.spawn.vehicle_weapon.name";
		    }
		}
		{
			mod.gvcr2_spawn_air_su27	= new ItemGVCR2_SPAWN(1102).setUnlocalizedName("gvcr2_spawn_air_su27")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_air_su27").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_air_su27);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 48;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 32;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 48;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_air_su27;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_air_su27;
				spawn.text1 = "gvcr2.string.spawn.vehicle_fighter.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::20mmMC";
				spawn.text4 = "Weapon2::AAMissile(IR)";
				spawn.text5 = "Weapon3::AAMissile(AR)";
				//spawn.text6 = "gvcr2.string.spawn.vehicle_weapon.name";
		    }
		}
		{
			mod.gvcr2_spawn_air_su25	= new ItemGVCR2_SPAWN(1103).setUnlocalizedName("gvcr2_spawn_air_su25")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_air_su25").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_air_su25);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 48;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 32;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 48;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_air_su25;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_air_su25;
				spawn.text1 = "gvcr2.string.spawn.vehicle_attacker.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::30mmMC";
				spawn.text4 = "Weapon2::AGMissile";
				spawn.text5 = "Weapon3::500lbBomb";
				spawn.text6 = "gvcr2.string.spawn.vehicle_weapon.name";
		    }
		}
		{
			mod.gvcr2_spawn_air_mig17	= new ItemGVCR2_SPAWN(103).setUnlocalizedName("gvcr2_spawn_air_mig17")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_air_mig17").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_air_mig17);
		    {
		    	/*mod.vehicle_eme_2[mod.vehicle_id_2] = 24;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 24;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_air_mig17;
				++mod.vehicle_id_2;*/
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_air_mig17;
				spawn.text1 = "gvcr2.string.spawn.vehicle_fighter.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::23mmMC";
				//spawn.text6 = "gvcr2.string.spawn.vehicle_weapon.name";
		    }
		}
		{
			mod.gvcr2_spawn_air_li28	= new ItemGVCR2_SPAWN(104).setUnlocalizedName("gvcr2_spawn_air_li28")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_air_li28").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_air_li28);
		    {
		    	/*mod.vehicle_eme_2[mod.vehicle_id_2] = 24;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 16;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 32;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_air_li28;
				++mod.vehicle_id_2;*/
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_air_li28;
				spawn.text1 = "gvcr2.string.spawn.vehicle_bomber.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::250kgBomb";
				//spawn.text6 = "gvcr2.string.spawn.vehicle_weapon.name";
		    }
		}
		{
			mod.gvcr2_spawn_air_a6	= new ItemGVCR2_SPAWN(107).setUnlocalizedName("gvcr2_spawn_air_a6")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_air_a6").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_air_a6);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 24;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 24;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 24;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_air_a6;
				++mod.vehicle_id_2;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_air_a6;
				spawn.text1 = "gvcr2.string.spawn.vehicle_bomber.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::500lbBomb";
				//spawn.text6 = "gvcr2.string.spawn.vehicle_weapon.name";
		    }
		}
		{
			mod.gvcr2_spawn_air_f117	= new ItemGVCR2_SPAWN(105).setUnlocalizedName("gvcr2_spawn_air_f117")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_air_f117").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_air_f117);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 48;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 32;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 48;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_air_f117;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_air_f117;
				spawn.text1 = "gvcr2.string.spawn.vehicle_bomber.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::2000lbBomb";
				//spawn.text6 = "gvcr2.string.spawn.vehicle_weapon.name";
		    }
		}
		
		{
			mod.gvcr2_spawn_air_ac130	= new ItemGVCR2_SPAWN(106).setUnlocalizedName("gvcr2_spawn_air_ac130")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_air_ac130").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_air_ac130);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 48;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 32;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 48;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_air_ac130;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_air_ac130;
				spawn.text1 = "gvcr2.string.spawn.vehicle_gunship.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::105mmCannon";
				spawn.text4 = "Weapon2::40mmCannon";
				spawn.text5 = "Weapon3::20mmMC";
				//spawn.text6 = "gvcr2.string.spawn.vehicle_weapon.name";
		    }
		}
		
		
		
		{
			mod.gvcr2_spawn_ship_rhib	= new ItemGVCR2_SPAWN(120).setUnlocalizedName("gvcr2_spawn_ship_rhib")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ship_rhib").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ship_rhib);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 4;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_ship_rhib;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_ship_rhib;
				spawn.text1 = "gvcr2.string.spawn.vehicle_boat.name";
				spawn.text2 = "6-SEATs";
		    }
		}
		{
			mod.gvcr2_spawn_ship_rcb	= new ItemGVCR2_SPAWN(121).setUnlocalizedName("gvcr2_spawn_ship_rcb")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ship_rcb").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ship_rcb);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 32;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_ship_rcb;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_ship_rcb;
				spawn.text1 = "gvcr2.string.spawn.vehicle_ship.name";
				spawn.text2 = "4-SEATs";
				spawn.text3 = "Weapon1::30mmMC";
				spawn.text4 = "Weapon2::TOW2";
		    }
		}
		{
			mod.gvcr2_spawn_ship_cruiser	= new ItemGVCR2_SPAWN(122).setUnlocalizedName("gvcr2_spawn_ship_cruiser")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ship_cruiser").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ship_cruiser);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 16;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_ship_cruiser;
				++mod.vehicle_id_2;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_ship_cruiser;
				spawn.text1 = "gvcr2.string.spawn.vehicle_ship.name";
				spawn.text2 = "4-SEATs";
				spawn.text3 = "Weapon1::20mmMC";
		    }
		}
		{
			mod.gvcr2_spawn_ship_pr1204	= new ItemGVCR2_SPAWN(123).setUnlocalizedName("gvcr2_spawn_ship_pr1204")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ship_pr1204").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ship_pr1204);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 9;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 16;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_ship_pr1204;
				++mod.vehicle_id_2;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_ship_pr1204;
				spawn.text1 = "gvcr2.string.spawn.vehicle_ship.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::20mmMC";
		    }
		}
		{
			mod.gvcr2_spawn_ship_hamina	= new ItemGVCR2_SPAWN(124).setUnlocalizedName("gvcr2_spawn_ship_hamina")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ship_hamina").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ship_hamina);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 64;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 64;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 64;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_ship_hamina;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_ship_hamina;
				spawn.text1 = "gvcr2.string.spawn.vehicle_ship.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::gvcr2_spawn_ship_hamina.name";
		    }
		}
		{
			mod.gvcr2_spawn_ship_airship	= new ItemGVCR2_SPAWN(125).setUnlocalizedName("gvcr2_spawn_ship_airship")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_ship_airship").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_ship_airship);
		    {
		    	//ItemGVC spawn = (ItemGVC) mod.gvcr2_spawn_ship_airship;
				//spawn.text1 = "gvcr2.string.spawn.non.name";
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_ship_airship;
				spawn.text1 = "gvcr2.string.spawn.vehicle_airship.name";
				spawn.text2 = "1-SEATs";
				spawn.text3 = "Weapon1::152mmCannon";
				spawn.text4 = "Weapon2::AUTO_AAGun";
		    }
		}
		
		
		
		{
			mod.gvcr2_spawn_set_mg_m60	= new ItemGVCR2_SPAWN(70).setUnlocalizedName("gvcr2_spawn_set_mg_m60")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_set_mg_m60").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_set_mg_m60);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_set_mg_m60;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_set_mg_m60;
				spawn.text1 = "gvcr2.string.spawn.vehicle_hmg.name";
		    }
		}
		{
			mod.gvcr2_spawn_set_mg_m2	= new ItemGVCR2_SPAWN(71).setUnlocalizedName("gvcr2_spawn_set_mg_m2")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_set_mg_m2").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_set_mg_m2);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_set_mg_m2;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_set_mg_m2;
				spawn.text1 = "gvcr2.string.spawn.vehicle_hmg.name";
		    }
		}
		{
			mod.gvcr2_spawn_set_mg_pkm	= new ItemGVCR2_SPAWN(72).setUnlocalizedName("gvcr2_spawn_set_mg_pkm")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_set_mg_pkm").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_set_mg_pkm);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_set_mg_pkm;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_set_mg_pkm;
				spawn.text1 = "gvcr2.string.spawn.vehicle_hmg.name";
		    }
		}
		{
			mod.gvcr2_spawn_set_mg_dp28	= new ItemGVCR2_SPAWN(73).setUnlocalizedName("gvcr2_spawn_set_mg_dp28")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_set_mg_dp28").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_set_mg_dp28);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_set_mg_dp28;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_set_mg_dp28;
				spawn.text1 = "gvcr2.string.spawn.vehicle_hmg.name";
		    }
		}
		
		
		{
			mod.gvcr2_spawn_set_aa_20mmaa	= new ItemGVCR2_SPAWN(80).setUnlocalizedName("gvcr2_spawn_set_aa_20mmaa")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_set_aa_20mmaa").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_set_aa_20mmaa);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_set_aa_20mmaa;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_set_aa_20mmaa;
				spawn.text1 = "gvcr2.string.spawn.vehicle_aag.name";
		    }
		}
		{
			mod.gvcr2_spawn_set_aa_zu23	= new ItemGVCR2_SPAWN(81).setUnlocalizedName("gvcr2_spawn_set_aa_zu23")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_set_aa_zu23").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_set_aa_zu23);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 4;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 4;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 4;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_set_aa_zu23;
				++mod.vehicle_id_2;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_set_aa_zu23;
				spawn.text1 = "gvcr2.string.spawn.vehicle_aag.name";
		    }
		}
		{
			mod.gvcr2_spawn_set_aa_vads	= new ItemGVCR2_SPAWN(82).setUnlocalizedName("gvcr2_spawn_set_aa_vads")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_set_aa_vads").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_set_aa_vads);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_set_aa_vads;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_set_aa_vads;
				spawn.text1 = "gvcr2.string.spawn.vehicle_aag.name";
		    }
		}
		
		{
			mod.gvcr2_spawn_set_mg_pak40	= new ItemGVCR2_SPAWN(90).setUnlocalizedName("gvcr2_spawn_set_mg_pak40")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_set_mg_pak40").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_set_mg_pak40);
		    {
		    	mod.vehicle_eme_2[mod.vehicle_id_2] = 4;
		    	mod.vehicle_iron_2[mod.vehicle_id_2] = 4;
		    	mod.vehicle_red_2[mod.vehicle_id_2] = 4;
		    	mod.vehicle_item_2[mod.vehicle_id_2] = mod.gvcr2_spawn_set_mg_pak40;
				++mod.vehicle_id_2;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_set_mg_pak40;
				spawn.text1 = "gvcr2.string.spawn.vehicle_cannon.name";
		    }
		}
		{
			mod.gvcr2_spawn_set_mg_flak18	= new ItemGVCR2_SPAWN(91).setUnlocalizedName("gvcr2_spawn_set_mg_flak18")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_set_mg_flak18").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_set_mg_flak18);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 8;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 8;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 8;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_set_mg_flak18;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_set_mg_flak18;
				spawn.text1 = "gvcr2.string.spawn.vehicle_cannon.name";
		    }
		}
		{
			mod.gvcr2_spawn_set_mg_tow2	= new ItemGVCR2_SPAWN(92).setUnlocalizedName("gvcr2_spawn_set_mg_tow2")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_set_mg_tow2").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_set_mg_tow2);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_set_mg_tow2;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_set_mg_tow2;
				spawn.text1 = "gvcr2.string.spawn.vehicle_tow.name";
		    }
		}
		
		{
			mod.gvcr2_spawn_set_mg_m224	= new ItemGVCR2_SPAWN(95).setUnlocalizedName("gvcr2_spawn_set_mg_m224")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_set_mg_m224").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_set_mg_m224);
		    {
		    	mod.vehicle_eme_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_iron_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_red_1[mod.vehicle_id_1] = 2;
		    	mod.vehicle_item_1[mod.vehicle_id_1] = mod.gvcr2_spawn_set_mg_m224;
				++mod.vehicle_id_1;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_set_mg_m224;
				spawn.text1 = "gvcr2.string.spawn.vehicle_mortar.name";
		    }
		}
		{
			mod.gvcr2_spawn_set_mg_fh18	= new ItemGVCR2_SPAWN(96).setUnlocalizedName("gvcr2_spawn_set_mg_fh18")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_set_mg_fh18").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_set_mg_fh18);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 8;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 8;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_set_mg_fh18;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_set_mg_fh18;
				spawn.text1 = "gvcr2.string.spawn.vehicle_hcannon.name";
		    }
		}
		
		{
			mod.gvcr2_spawn_set_mg_ak130	= new ItemGVCR2_SPAWN(97).setUnlocalizedName("gvcr2_spawn_set_mg_ak130")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_set_mg_ak130").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_set_mg_ak130);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 8;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 8;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_set_mg_ak130;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_set_mg_ak130;
				spawn.text1 = "gvcr2.string.spawn.vehicle_hcannon.name";
		    }
		}
		{
			mod.gvcr2_spawn_set_mg_mk15_phalanx	= new ItemGVCR2_SPAWN(83).setUnlocalizedName("gvcr2_spawn_set_mg_mk15_phalanx")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_set_mg_mk15_phalanx").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_set_mg_mk15_phalanx);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 8;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 8;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_set_mg_mk15_phalanx;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_set_mg_mk15_phalanx;
				spawn.text1 = "gvcr2.string.spawn.vehicle_aag.name";
		    }
		}
		{
			mod.gvcr2_spawn_set_mg_mk45_mod4	= new ItemGVCR2_SPAWN(98).setUnlocalizedName("gvcr2_spawn_set_mg_mk45_mod4")
					.setRegistryName(mod.MOD_ID, "gvcr2_spawn_set_mg_mk45_mod4").setCreativeTab(mod.tabgg_mob);
		    event.getRegistry().register(mod.gvcr2_spawn_set_mg_mk45_mod4);
		    {
		    	mod.vehicle_eme_3[mod.vehicle_id_3] = 8;
		    	mod.vehicle_iron_3[mod.vehicle_id_3] = 16;
		    	mod.vehicle_red_3[mod.vehicle_id_3] = 8;
		    	mod.vehicle_item_3[mod.vehicle_id_3] = mod.gvcr2_spawn_set_mg_mk45_mod4;
				++mod.vehicle_id_3;
				ItemGVCR2_SPAWN spawn = (ItemGVCR2_SPAWN) mod.gvcr2_spawn_set_mg_mk45_mod4;
				spawn.text1 = "gvcr2.string.spawn.vehicle_hcannon.name";
		    }
		}
	}
}

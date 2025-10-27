package gvcr2.registry;

import gvclib.Createjson;
import gvcr2.mod_GVCR2;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;

public class GVCR2ModelRegistry {
	public static void registry(mod_GVCR2 mod, ModelRegistryEvent event){
		
		{
			Createjson.addjson_domain(mod.gvcr2_item_pra, "gvcr2", "gvcr2_item_pra", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_scrap, "gvcr2", "gvcr2_item_scrap", "item", mod.isDebugMessage);
		}
		
		{
			Createjson.addjsongun_domain(mod.gvcr2_item_wrench, "gvcr2", "gvcr2_item_wrench", "item", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_item_weapon_change, "gvcr2", "gvcr2_item_weapon_change", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_pad, "gvcr2", "gvcr2_item_pad", "item", mod.isDebugMessage);
			
			Createjson.addjson_domain(mod.gvcr2_item_squad_cn, "gvcr2", "gvcr2_item_squad_cn", "item", mod.isDebugMessage);
			
			Createjson.addjsongun_domain(mod.gvcr2_item_binoculars, "gvcr2", "gvcr2_item_binoculars", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_bandage, "gvcr2", "gvcr2_item_bandage", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_cm, "gvcr2", "gvcr2_item_cm", "item", mod.isDebugMessage);
			
			Createjson.addjson_domain(mod.gvcr2_item_aed, "gvcr2", "gvcr2_item_aed", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_stars, "gvcr2", "gvcr2_item_stars", "item", mod.isDebugMessage);
		}
		{
			Createjson.addjson_domain(mod.gvcr2_bullet_9mmhg, "gvcr2", "gvcr2_bullet_9mmhg", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_bullet_45calhg, "gvcr2", "gvcr2_bullet_45calhg", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_bullet_22calar, "gvcr2", "gvcr2_bullet_22calar", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_bullet_30calrf, "gvcr2", "gvcr2_bullet_30calrf", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_bullet_50calrf, "gvcr2", "gvcr2_bullet_50calrf", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_bullet_40mmgl, "gvcr2", "gvcr2_bullet_40mmgl", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_bullet_12gasg, "gvcr2", "gvcr2_bullet_12gasg", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_bullet_76mmrl, "gvcr2", "gvcr2_bullet_76mmrl", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_bullet_84mmrl, "gvcr2", "gvcr2_bullet_84mmrl", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_bullet_76mmml, "gvcr2", "gvcr2_bullet_76mmml", "item", mod.isDebugMessage);
		}
		{
			Createjson.addjsongun_domain(mod.gvcr2_grenade_frag, "gvcr2", "gvcr2_grenade_frag", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_grenade_flame, "gvcr2", "gvcr2_grenade_flame", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_grenade_smoke, "gvcr2", "gvcr2_grenade_smoke", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_grenade_impact, "gvcr2", "gvcr2_grenade_impact", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_grenade_atgrenade, "gvcr2", "gvcr2_grenade_atgrenade", "gun", mod.isDebugMessage);
		}
		
		{
			Createjson.addjson_domain(mod.gvcr2_am_dotsight, "gvcr2", "gvcr2_am_dotsight", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_am_compm4, "gvcr2", "gvcr2_am_compm4", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_am_coyote, "gvcr2", "gvcr2_am_coyote", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_am_horo, "gvcr2", "gvcr2_am_horo", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_am_kobra, "gvcr2", "gvcr2_am_kobra", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_am_micro, "gvcr2", "gvcr2_am_micro", "item", mod.isDebugMessage);
			
			Createjson.addjson_domain(mod.gvcr2_am_acog, "gvcr2", "gvcr2_am_acog", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_am_m145, "gvcr2", "gvcr2_am_m145", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_am_scope, "gvcr2", "gvcr2_am_scope", "item", mod.isDebugMessage);
			
			Createjson.addjson_domain(mod.gvcr2_am_lasersight, "gvcr2", "gvcr2_am_lasersight", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_am_flashlight, "gvcr2", "gvcr2_am_flashlight", "item", mod.isDebugMessage);
			
			Createjson.addjson_domain(mod.gvcr2_am_suppressor, "gvcr2", "gvcr2_am_suppressor", "item", mod.isDebugMessage);
			
			Createjson.addjson_domain(mod.gvcr2_am_grip, "gvcr2", "gvcr2_am_grip", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_am_anglegrip, "gvcr2", "gvcr2_am_anglegrip", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_am_bipod, "gvcr2", "gvcr2_am_bipod", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_am_gripod, "gvcr2", "gvcr2_am_gripod", "item", mod.isDebugMessage);
			
			Createjson.addjson_domain(mod.gvcr2_am_bullet_ap, "gvcr2", "gvcr2_am_bullet_ap", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_am_bullet_hp, "gvcr2", "gvcr2_am_bullet_hp", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_am_bullet_at, "gvcr2", "gvcr2_am_bullet_at", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_am_bullet_srag, "gvcr2", "gvcr2_am_bullet_srag", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_am_bullet_frag, "gvcr2", "gvcr2_am_bullet_frag", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_am_bullet_db, "gvcr2", "gvcr2_am_bullet_db", "item", mod.isDebugMessage);
		}
		
		//gun
		{
			Createjson.addjsongun_domain(mod.gvcr2_gun_m1911, "gvcr2", "gvcr2_gun_m1911", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_pm, "gvcr2", "gvcr2_gun_pm", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_sks, "gvcr2", "gvcr2_gun_sks", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_vz61, "gvcr2", "gvcr2_gun_vz61", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m10, "gvcr2", "gvcr2_gun_m10", "gun", mod.isDebugMessage);
		}
		{
			Createjson.addjsongun_domain(mod.gvcr2_gun_m9, "gvcr2", "gvcr2_gun_m9", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m93r, "gvcr2", "gvcr2_gun_m93r", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_g17, "gvcr2", "gvcr2_gun_g17", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_g18c, "gvcr2", "gvcr2_gun_g18c", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_g17_flux, "gvcr2", "gvcr2_gun_g17_flux", "gun", mod.isDebugMessage);
		}
		{
			Createjson.addjsongun_domain(mod.gvcr2_gun_ak47, "gvcr2", "gvcr2_gun_ak47", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_ak74, "gvcr2", "gvcr2_gun_ak74", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_aks74u, "gvcr2", "gvcr2_gun_aks74u", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_ak102, "gvcr2", "gvcr2_gun_ak102", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_stg44, "gvcr2", "gvcr2_gun_stg44", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m16a1, "gvcr2", "gvcr2_gun_m16a1", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m16a2, "gvcr2", "gvcr2_gun_m16a2", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m16a4, "gvcr2", "gvcr2_gun_m16a4", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m4, "gvcr2", "gvcr2_gun_m4", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m4a1, "gvcr2", "gvcr2_gun_m4a1", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_g3a3, "gvcr2", "gvcr2_gun_g3a3", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_g36, "gvcr2", "gvcr2_gun_g36", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_g36c, "gvcr2", "gvcr2_gun_g36c", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_f2000, "gvcr2", "gvcr2_gun_f2000", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_l85a1, "gvcr2", "gvcr2_gun_l85a1", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_type95, "gvcr2", "gvcr2_gun_type95", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_ak12, "gvcr2", "gvcr2_gun_ak12", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_scar_h, "gvcr2", "gvcr2_gun_scar_h", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_hk416, "gvcr2", "gvcr2_gun_hk416", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_patriot, "gvcr2", "gvcr2_gun_patriot", "gun", mod.isDebugMessage);
		}
		{
			Createjson.addjsongun_domain(mod.gvcr2_gun_mp5, "gvcr2", "gvcr2_gun_mp5", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_mp40, "gvcr2", "gvcr2_gun_mp40", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_ppsh41, "gvcr2", "gvcr2_gun_ppsh41", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_mp7, "gvcr2", "gvcr2_gun_mp7", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_uzi, "gvcr2", "gvcr2_gun_uzi", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_tmp, "gvcr2", "gvcr2_gun_tmp", "gun", mod.isDebugMessage);
		}
		{
			Createjson.addjsongun_domain(mod.gvcr2_gun_svd, "gvcr2", "gvcr2_gun_svd", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m1891, "gvcr2", "gvcr2_gun_m1891", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m14, "gvcr2", "gvcr2_gun_m14", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m110, "gvcr2", "gvcr2_gun_m110", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_r700, "gvcr2", "gvcr2_gun_r700", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_l96, "gvcr2", "gvcr2_gun_l96", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_ptrd, "gvcr2", "gvcr2_gun_ptrd", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m82a3, "gvcr2", "gvcr2_gun_m82a3", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_railgun, "gvcr2", "gvcr2_gun_railgun", "gun", mod.isDebugMessage);
		}
		{
			Createjson.addjsongun_domain(mod.gvcr2_gun_rpk47, "gvcr2", "gvcr2_gun_rpk47", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_dp28, "gvcr2", "gvcr2_gun_dp28", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_pkm, "gvcr2", "gvcr2_gun_pkm", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_pkp, "gvcr2", "gvcr2_gun_pkp", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m60, "gvcr2", "gvcr2_gun_m60", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m63, "gvcr2", "gvcr2_gun_m63", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m240, "gvcr2", "gvcr2_gun_m240", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m249, "gvcr2", "gvcr2_gun_m249", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_mg42, "gvcr2", "gvcr2_gun_mg42", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_mg36, "gvcr2", "gvcr2_gun_mg36", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_fm, "gvcr2", "gvcr2_gun_fm", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m134, "gvcr2", "gvcr2_gun_m134", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_lewisgun, "gvcr2", "gvcr2_gun_lewisgun", "gun", mod.isDebugMessage);
		}
		{
			Createjson.addjsongun_domain(mod.gvcr2_gun_m870, "gvcr2", "gvcr2_gun_m870", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m590, "gvcr2", "gvcr2_gun_m590", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m1014, "gvcr2", "gvcr2_gun_m1014", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_saiga12, "gvcr2", "gvcr2_gun_saiga12", "gun", mod.isDebugMessage);
		}
		{
			Createjson.addjsongun_domain(mod.gvcr2_gun_m79, "gvcr2", "gvcr2_gun_m79", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m320, "gvcr2", "gvcr2_gun_m320", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_xm25, "gvcr2", "gvcr2_gun_xm25", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_mgl140, "gvcr2", "gvcr2_gun_mgl140", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_rpg7, "gvcr2", "gvcr2_gun_rpg7", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_panzerfaust, "gvcr2", "gvcr2_gun_panzerfaust", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m72, "gvcr2", "gvcr2_gun_m72", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_m202, "gvcr2", "gvcr2_gun_m202", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_smaw, "gvcr2", "gvcr2_gun_smaw", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_sraw, "gvcr2", "gvcr2_gun_sraw", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_fgm148, "gvcr2", "gvcr2_gun_fgm148", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_fim92, "gvcr2", "gvcr2_gun_fim92", "gun", mod.isDebugMessage);
		}
		{
			Createjson.addjsongun_domain(mod.gvcr2_gun_kukriknife, "gvcr2", "gvcr2_gun_kukriknife", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_club, "gvcr2", "gvcr2_gun_club", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_compoundbow, "gvcr2", "gvcr2_gun_compoundbow", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_am_exarrow, "gvcr2", "gvcr2_am_exarrow", "item", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_am_psarrow, "gvcr2", "gvcr2_am_psarrow", "item", mod.isDebugMessage);
			
			Createjson.addjsongun_domain(mod.gvcr2_gun_riotshield, "gvcr2", "gvcr2_gun_riotshield", "gun", mod.isDebugMessage);
			Createjson.addjsongun_domain(mod.gvcr2_gun_heavyshield, "gvcr2", "gvcr2_gun_heavyshield", "gun", mod.isDebugMessage);
		}
		{
			Createjson.addjsongun_domain(mod.gvcr2_gun_la16u, "gvcr2", "gvcr2_gun_la16u", "gun", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_airstrike1, "gvcr2", "gvcr2_item_request_airstrike1", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_airstrike2, "gvcr2", "gvcr2_item_request_airstrike2", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_airstrike3, "gvcr2", "gvcr2_item_request_airstrike3", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_flare, "gvcr2", "gvcr2_item_request_flare", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_light, "gvcr2", "gvcr2_item_request_light", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_fire1, "gvcr2", "gvcr2_item_request_fire1", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_fire2, "gvcr2", "gvcr2_item_request_fire2", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_fire3, "gvcr2", "gvcr2_item_request_fire3", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_airborne1, "gvcr2", "gvcr2_item_request_airborne1", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_airborne2, "gvcr2", "gvcr2_item_request_airborne2", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_airborne3, "gvcr2", "gvcr2_item_request_airborne3", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_missile1, "gvcr2", "gvcr2_item_request_missile1", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_missile2, "gvcr2", "gvcr2_item_request_missile2", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_missile3, "gvcr2", "gvcr2_item_request_missile3", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_strafing1, "gvcr2", "gvcr2_item_request_strafing1", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_strafing2, "gvcr2", "gvcr2_item_request_strafing2", "item", mod.isDebugMessage);
			
			Createjson.addjson_domain(mod.gvcr2_item_request_105mm, "gvcr2", "gvcr2_item_request_105mm", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_40mm, "gvcr2", "gvcr2_item_request_40mm", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_20mm, "gvcr2", "gvcr2_item_request_20mm", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_pave, "gvcr2", "gvcr2_item_request_pave", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_rog, "gvcr2", "gvcr2_item_request_rog", "item", mod.isDebugMessage);
			
			Createjson.addjson_domain(mod.gvcr2_item_request_support_fighter1, "gvcr2", "gvcr2_item_request_support_fighter1", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_support_fighter2, "gvcr2", "gvcr2_item_request_support_fighter2", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_support_fighter3, "gvcr2", "gvcr2_item_request_support_fighter3", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_support_heli1, "gvcr2", "gvcr2_item_request_support_heli1", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_request_support_heli2, "gvcr2", "gvcr2_item_request_support_heli2", "item", mod.isDebugMessage);
		}
		{
			Createjson.addjson_domain(mod.gvcr2_armor_gasmask, "gvcr2", "gvcr2_armor_gasmask", "armor", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_armor_firemask, "gvcr2", "gvcr2_armor_firemask", "armor", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_armor_trenchmask, "gvcr2", "gvcr2_armor_trenchmask", "armor", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_armor_trench_body, "gvcr2", "gvcr2_armor_trench_body", "armor", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_armor_trench_leggings, "gvcr2", "gvcr2_armor_trench_leggings", "armor", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_armor_trench_boots, "gvcr2", "gvcr2_armor_trench_boots", "armor", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_armor_tachanka, "gvcr2", "gvcr2_armor_tachanka", "armor", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_armor_parachute, "gvcr2", "gvcr2_armor_parachute", "armor", mod.isDebugMessage);
			
			Createjson.addjson_domain(mod.gvcr2_armor_prahelmet, "gvcr2", "gvcr2_armor_prahelmet", "armor", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_armor_prachest, "gvcr2", "gvcr2_armor_prachest", "armor", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_armor_praleggings, "gvcr2", "gvcr2_armor_praleggings", "armor", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_armor_praboots, "gvcr2", "gvcr2_armor_praboots", "armor", mod.isDebugMessage);
			
			Createjson.addjson_domain(mod.gvcr2_armor_camouflage_head, "gvcr2", "gvcr2_armor_camouflage_head", "armor", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_armor_camouflage_body, "gvcr2", "gvcr2_armor_camouflage_body", "armor", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_armor_camouflage_leggings, "gvcr2", "gvcr2_armor_camouflage_leggings", "armor", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_armor_camouflage_boots, "gvcr2", "gvcr2_armor_camouflage_boots", "armor", mod.isDebugMessage);
			
			Createjson.addjson_domain(mod.gvcr2_armor_sehelmet, "gvcr2", "gvcr2_armor_sehelmet", "armor", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_armor_sechest, "gvcr2", "gvcr2_armor_sechest", "armor", mod.isDebugMessage);
		}
		
		{
			Createjson.addjson_domain(mod.gvcr2_drone_mav, "gvcr2", "gvcr2_drone_mav", "drone", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_drone_eod, "gvcr2", "gvcr2_drone_eod", "drone", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_drone_rawr, "gvcr2", "gvcr2_drone_rawr", "drone", mod.isDebugMessage);
		}
		
		
		{
			Createjson.addjsonblock_tile(mod.gvcr2_block_mine, "gvcr2", "gvcr2_block_mine", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_atmine, "gvcr2", "gvcr2_block_atmine", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_ied, "gvcr2", "gvcr2_block_ied", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_bomb, "gvcr2", "gvcr2_block_bomb", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_water_mine, "gvcr2", "gvcr2_block_water_mine", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_propane, "gvcr2", "gvcr2_block_propane", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_bouy, "gvcr2", "gvcr2_block_bouy", true);
			
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_ammobox1, "gvcr2", "gvcr2_block_ammobox1", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_artibox1, "gvcr2", "gvcr2_block_artibox1", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_artibox2, "gvcr2", "gvcr2_block_artibox2", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_artibox3, "gvcr2", "gvcr2_block_artibox3", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_barrel_drum1, "gvcr2", "gvcr2_block_barrel_drum1", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_barrel_drum2, "gvcr2", "gvcr2_block_barrel_drum2", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_barrel_drum3, "gvcr2", "gvcr2_block_barrel_drum3", "blockitem", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_cadaver_g, "gvcr2", "gvcr2_block_cadaver_g", true);
			//Createjson.addjsonblock_tile(mod.gvcr2_block_hesco, "gvcr2", "gvcr2_block_hesco", true);
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod.gvcr2_block_hesco), 
					0, new ModelResourceLocation("gvcr2:" + "gvcr2_block_hesco", "inventory"));
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_jerrycan1, "gvcr2", "gvcr2_block_jerrycan1", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_missile_rack1, "gvcr2", "gvcr2_block_missile_rack1", "blockitem", true);
		}
		{
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_9mmpack_gc, mod.MOD_ID, "gvcr2_block_9mmpack_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_45pack_gc, mod.MOD_ID, "gvcr2_block_45pack_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_223pack_gc, mod.MOD_ID, "gvcr2_block_223pack_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_308pack_gc, mod.MOD_ID, "gvcr2_block_308pack_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_50bmgpack_gc, mod.MOD_ID, "gvcr2_block_50bmgpack_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_12gpack_gc, mod.MOD_ID, "gvcr2_block_12gpack_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_40mmgr_ammo_gc, mod.MOD_ID, "gvcr2_block_40mmgr_ammo_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_grenade_box_gc, mod.MOD_ID, "gvcr2_block_grenade_box_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_rpg_ammobox1, mod.MOD_ID, "gvcr2_block_rpg_ammobox1", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_rpg_ammobox2, mod.MOD_ID, "gvcr2_block_rpg_ammobox2", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_ammo_mass, mod.MOD_ID, "gvcr2_block_ammo_mass", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_m18_claymore, mod.MOD_ID, "gvcr2_block_m18_claymore", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_m72_box, mod.MOD_ID, "gvcr2_block_m72_box", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_rpg_box, mod.MOD_ID, "gvcr2_block_rpg_box", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_medbag_gc, mod.MOD_ID, "gvcr2_block_medbag_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_laptop, mod.MOD_ID, "gvcr2_block_laptop", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_toughbook, mod.MOD_ID, "gvcr2_block_toughbook", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_monitor1, mod.MOD_ID, "gvcr2_block_monitor1", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_man_target, mod.MOD_ID, "gvcr2_block_man_target", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_old_radio, mod.MOD_ID, "gvcr2_block_old_radio", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_radio_big, mod.MOD_ID, "gvcr2_block_radio_big", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_sincgars, mod.MOD_ID, "gvcr2_block_sincgars", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_burn_barrel, mod.MOD_ID, "gvcr2_block_burn_barrel", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_at_obstacles, mod.MOD_ID, "gvcr2_block_at_obstacles", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_barbed1_gc, mod.MOD_ID, "gvcr2_block_barbed1_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_barbed2_gc, mod.MOD_ID, "gvcr2_block_barbed2_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_fire_exti_gc, mod.MOD_ID, "gvcr2_block_fire_exti_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_mil_cont1_gc, mod.MOD_ID, "gvcr2_block_mil_cont1_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_mil_cont2_gc, mod.MOD_ID, "gvcr2_block_mil_cont2_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_odunit_gc, mod.MOD_ID, "gvcr2_block_odunit_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_sandbag_a1_gc, mod.MOD_ID, "gvcr2_block_sandbag_a1_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_sandbag_a2_gc, mod.MOD_ID, "gvcr2_block_sandbag_a2_gc", "blockitem", true);
			//Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_sandbag_b1_gc, mod.MOD_ID, "gvcr2_block_sandbag_b1_gc", "blockitem", true);
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod.gvcr2_block_sandbag_b1_gc), 
					0, new ModelResourceLocation("gvcr2:" + "gvcr2_block_sandbag_b1_gc", "inventory"));
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_sandbag_b2_gc, mod.MOD_ID, "gvcr2_block_sandbag_b2_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_t_wall1_gc, mod.MOD_ID, "gvcr2_block_t_wall1_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_t_wall2_gc, mod.MOD_ID, "gvcr2_block_t_wall2_gc", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_wolcott, mod.MOD_ID, "gvcr2_block_wolcott", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_fslight, mod.MOD_ID, "gvcr2_block_fslight", "blockitem", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_ghostlight, mod.MOD_ID, "gvcr2_block_ghostlight", true);
			Createjson.addjsonblock(mod.gvcr2_block_ghostlight_tile, mod.MOD_ID, "gvcr2_block_ghostlight_tile", true);
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod.gvcr2_block_scaffold), 
					0, new ModelResourceLocation("gvcr2:" + "gvcr2_block_scaffold", "inventory"));
			
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_lantern_g, mod.MOD_ID, "gvcr2_block_lantern_g", "blockitem", true);
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod.gvcr2_block_light_block_g), 
					0, new ModelResourceLocation("gvcr2:" + "gvcr2_block_light_block_g", "inventory"));
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_wall_light_gg, mod.MOD_ID, "gvcr2_block_wall_light_gg", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_wall_light_rg, mod.MOD_ID, "gvcr2_block_wall_light_rg", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_wall_light_wg, mod.MOD_ID, "gvcr2_block_wall_light_wg", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_rack_g1, mod.MOD_ID, "gvcr2_block_rack_g1", "blockitem", true);
			Createjson.addjsonblock_tile_facing_domain(mod.gvcr2_block_rack_g2, mod.MOD_ID, "gvcr2_block_rack_g2", "blockitem", true);
		}
		{
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_bulletcrafter_1, "gvcr2", "gvcr2_block_bulletcrafter_1", true);
			
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_guncrafter_1, "gvcr2", "gvcr2_block_guncrafter_1", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_guncrafter_2, "gvcr2", "gvcr2_block_guncrafter_2", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_guncrafter_3, "gvcr2", "gvcr2_block_guncrafter_3", true);
			//ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod.gvcr2_block_guncrafter_1), 0, new ModelResourceLocation("gvcr2" + ":" + "gvcr2_block_guncrafter_1", "inventory"));
			
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_vehiclecrafter_1, "gvcr2", "gvcr2_block_vehiclecrafter_1", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_vehiclecrafter_2, "gvcr2", "gvcr2_block_vehiclecrafter_2", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_vehiclecrafter_3, "gvcr2", "gvcr2_block_vehiclecrafter_3", true);
			
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_gunrack_hsin, "gvcr2", "gvcr2_block_gunrack_hsin", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_gunrack_rsin, "gvcr2", "gvcr2_block_gunrack_rsin", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_gunrack_rswn, "gvcr2", "gvcr2_block_gunrack_rswn", true);
			
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_gunrack_hti, "gvcr2", "gvcr2_block_gunrack_hti", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_gunrack_rti1, "gvcr2", "gvcr2_block_gunrack_rti1", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_gunrack_rti2, "gvcr2", "gvcr2_block_gunrack_rti2", true);
			
			
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_gunrack_hsin_deco, "gvcr2", "gvcr2_block_gunrack_hsin_deco", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_gunrack_rsin_deco, "gvcr2", "gvcr2_block_gunrack_rsin_deco", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_gunrack_rswn_deco, "gvcr2", "gvcr2_block_gunrack_rswn_deco", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_gunrack_hti_deco, "gvcr2", "gvcr2_block_gunrack_hti_deco", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_gunrack_rti1_deco, "gvcr2", "gvcr2_block_gunrack_rti1_deco", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_gunrack_rti2_deco, "gvcr2", "gvcr2_block_gunrack_rti2_deco", true);
		}
		{
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_supplies_air, "gvcr2", "gvcr2_block_supplies_air", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_supplies_1, "gvcr2", "gvcr2_block_supplies_1", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_supplies_2, "gvcr2", "gvcr2_block_supplies_2", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_supplies_3, "gvcr2", "gvcr2_block_supplies_3", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_supplies_4, "gvcr2", "gvcr2_block_supplies_4", true);
			Createjson.addjsonblock_tile_facing(mod.gvcr2_block_supplies_scrap, "gvcr2", "gvcr2_block_supplies_scrap", true);
		}
		
		
		
		
		{
			Createjson.addjson_domain(mod.gvcr2_spawn_ge_s, "gvcr2", "gvcr2_spawn_ge_s", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_ge_sv, "gvcr2", "gvcr2_spawn_ge_sv", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_ge_sv_fire, "gvcr2", "gvcr2_spawn_ge_sv_fire", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_ge_sv_trench, "gvcr2", "gvcr2_spawn_ge_sv_trench", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_ge_sv_antitank, "gvcr2", "gvcr2_spawn_ge_sv_antitank", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_ge_sv_sniper, "gvcr2", "gvcr2_spawn_ge_sv_sniper", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_ge_sv_drone, "gvcr2", "gvcr2_spawn_ge_sv_drone", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_ge_se_assault, "gvcr2", "gvcr2_spawn_ge_se_assault", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_ge_se_cerberus, "gvcr2", "gvcr2_spawn_ge_se_cerberus", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_ge_se_hacs, "gvcr2", "gvcr2_spawn_ge_se_hacs", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_ge_se_kukri, "gvcr2", "gvcr2_spawn_ge_se_kukri", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_ge_s_mr_cpt, "gvcr2", "gvcr2_spawn_ge_s_mr_cpt", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_ge_pow, "gvcr2", "gvcr2_spawn_ge_pow", "spawn", true);
			
			Createjson.addjson_domain(mod.gvcr2_spawn_pmc_s, "gvcr2", "gvcr2_spawn_pmc_s", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_so_s, "gvcr2", "gvcr2_spawn_so_s", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_so_s_mr_cpt, "gvcr2", "gvcr2_spawn_so_s_mr_cpt", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_so_s_af_cpt, "gvcr2", "gvcr2_spawn_so_s_af_cpt", "spawn", true);
			
			Createjson.addjson_domain(mod.gvcr2_spawn_sp_rex, "gvcr2", "gvcr2_spawn_sp_rex", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_sp_st1, "gvcr2", "gvcr2_spawn_sp_st1", "spawn", true);
			
			Createjson.addjson_domain(mod.gvcr2_spawn_npc_arms_trader, "gvcr2", "gvcr2_spawn_npc_arms_trader", "spawn", true);
			Createjson.addjsonblock(mod.gvcr2_block_npc_arms_trader, "gvcr2", "gvcr2_block_npc_arms_trader", true);
			
			Createjson.addjson_domain(mod.gvcr2_spawn_boss_longleg, "gvcr2", "gvcr2_spawn_boss_longleg", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_boss_st1, "gvcr2", "gvcr2_spawn_boss_st1", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_boss_mer08, "gvcr2", "gvcr2_spawn_boss_mer08", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_boss_mer08_sn, "gvcr2", "gvcr2_spawn_boss_mer08_sn", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_boss_mer08_b, "gvcr2", "gvcr2_spawn_boss_mer08_b", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_boss_mer03k, "gvcr2", "gvcr2_spawn_boss_mer03k", "spawn", true);
			
			Createjson.addjson_domain(mod.gvcr2_spawn_boss_hauneb, "gvcr2", "gvcr2_spawn_boss_hauneb", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_boss_irving, "gvcr2", "gvcr2_spawn_boss_irving", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_boss_char2c, "gvcr2", "gvcr2_spawn_boss_char2c", "spawn", true);
			
			Createjson.addjson_domain(mod.gvcr2_spawn_boss_av8b, "gvcr2", "gvcr2_spawn_boss_av8b", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_boss_ratte, "gvcr2", "gvcr2_spawn_boss_ratte", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_boss_airship, "gvcr2", "gvcr2_spawn_boss_airship", "spawn", true);
			
			Createjson.addjson_domain(mod.gvcr2_spawn_unks_c_s, "gvcr2", "gvcr2_spawn_unks_c_s", "spawn", true);
		}
		{
			Createjson.addjson_domain(mod.gvcr2_spawn_set_mg_m60, "gvcr2", "gvcr2_spawn_set_mg_m60", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_set_mg_m2, "gvcr2", "gvcr2_spawn_set_mg_m2", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_set_mg_pkm, "gvcr2", "gvcr2_spawn_set_mg_pkm", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_set_mg_dp28, "gvcr2", "gvcr2_spawn_set_mg_dp28", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_set_aa_20mmaa, "gvcr2", "gvcr2_spawn_set_aa_20mmaa", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_set_aa_vads, "gvcr2", "gvcr2_spawn_set_aa_vads", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_set_aa_zu23, "gvcr2", "gvcr2_spawn_set_aa_zu23", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_set_mg_pak40, "gvcr2", "gvcr2_spawn_set_mg_pak40", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_set_mg_flak18, "gvcr2", "gvcr2_spawn_set_mg_flak18", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_set_mg_tow2, "gvcr2", "gvcr2_spawn_set_mg_tow2", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_set_mg_m224, "gvcr2", "gvcr2_spawn_set_mg_m224", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_set_mg_fh18, "gvcr2", "gvcr2_spawn_set_mg_fh18", "spawn", true);
			
			Createjson.addjson_domain(mod.gvcr2_spawn_set_mg_ak130, "gvcr2", "gvcr2_spawn_set_mg_ak130", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_set_mg_mk15_phalanx, "gvcr2", "gvcr2_spawn_set_mg_mk15_phalanx", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_set_mg_mk45_mod4, "gvcr2", "gvcr2_spawn_set_mg_mk45_mod4", "spawn", true);
			
			
			Createjson.addjson_domain(mod.gvcr2_spawn_car_technical, "gvcr2", "gvcr2_spawn_car_technical", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_car_technical_mortar, "gvcr2", "gvcr2_spawn_car_technical_mortar", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_car_technical_aa, "gvcr2", "gvcr2_spawn_car_technical_aa", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_car_technical_rocket, "gvcr2", "gvcr2_spawn_car_technical_rocket", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_car_technical_tnt, "gvcr2", "gvcr2_spawn_car_technical_tnt", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_car_bike, "gvcr2", "gvcr2_spawn_car_bike", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_car_buggy, "gvcr2", "gvcr2_spawn_car_buggy", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_car_hmmwv, "gvcr2", "gvcr2_spawn_car_hmmwv", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_car_armor_bulldozer, "gvcr2", "gvcr2_spawn_car_armor_bulldozer", "spawn", true);
			
			Createjson.addjson_domain(mod.gvcr2_spawn_apc_m113, "gvcr2", "gvcr2_spawn_apc_m113", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_apc_m113_aa, "gvcr2", "gvcr2_spawn_apc_m113_aa", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_apc_m113_ifv, "gvcr2", "gvcr2_spawn_apc_m113_ifv", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_apc_m113_spg, "gvcr2", "gvcr2_spawn_apc_m113_spg", "spawn", true);
			
			Createjson.addjson_domain(mod.gvcr2_spawn_apc_m1126, "gvcr2", "gvcr2_spawn_apc_m1126", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_apc_m1129, "gvcr2", "gvcr2_spawn_apc_m1129", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_apc_m1128, "gvcr2", "gvcr2_spawn_apc_m1128", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_apc_lav25, "gvcr2", "gvcr2_spawn_apc_lav25", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_apc_lav25ad, "gvcr2", "gvcr2_spawn_apc_lav25ad", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_apc_btr60, "gvcr2", "gvcr2_spawn_apc_btr60", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_apc_m1097, "gvcr2", "gvcr2_spawn_apc_m1097", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_apc_9k35, "gvcr2", "gvcr2_spawn_apc_9k35", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_apc_m270, "gvcr2", "gvcr2_spawn_apc_m270", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_apc_bmp3, "gvcr2", "gvcr2_spawn_apc_bmp3", "spawn", true);
			
			
			Createjson.addjson_domain(mod.gvcr2_spawn_heli_ah1s, "gvcr2", "gvcr2_spawn_heli_ah1s", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_heli_ah6, "gvcr2", "gvcr2_spawn_heli_ah6", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_heli_uh1, "gvcr2", "gvcr2_spawn_heli_uh1", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_heli_ch47, "gvcr2", "gvcr2_spawn_heli_ch47", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_heli_g_heli, "gvcr2", "gvcr2_spawn_heli_g_heli", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_heli_mi24d, "gvcr2", "gvcr2_spawn_heli_mi24d", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_heli_uh1y, "gvcr2", "gvcr2_spawn_heli_uh1y", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_heli_uh60, "gvcr2", "gvcr2_spawn_heli_uh60", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_heli_ah1z, "gvcr2", "gvcr2_spawn_heli_ah1z", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_heli_ka50, "gvcr2", "gvcr2_spawn_heli_ka50", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_heli_z10, "gvcr2", "gvcr2_spawn_heli_z10", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_heli_ka60, "gvcr2", "gvcr2_spawn_heli_ka60", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_heli_r22, "gvcr2", "gvcr2_spawn_heli_r22", "spawn", true);
			
			Createjson.addjson_domain(mod.gvcr2_spawn_tank_m60a1, "gvcr2", "gvcr2_spawn_tank_m60a1", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_tank_m1, "gvcr2", "gvcr2_spawn_tank_m1", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_tank_m41, "gvcr2", "gvcr2_spawn_tank_m41", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_tank_m551, "gvcr2", "gvcr2_spawn_tank_m551", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_tank_t34, "gvcr2", "gvcr2_spawn_tank_t34", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_tank_t55, "gvcr2", "gvcr2_spawn_tank_t55", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_tank_t72, "gvcr2", "gvcr2_spawn_tank_t72", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_tank_t90, "gvcr2", "gvcr2_spawn_tank_t90", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_tank_pt76, "gvcr2", "gvcr2_spawn_tank_pt76", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_tank_kv2, "gvcr2", "gvcr2_spawn_tank_kv2", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_tank_fv101, "gvcr2", "gvcr2_spawn_tank_fv101", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_tank_zsu_23_4, "gvcr2", "gvcr2_spawn_tank_zsu_23_4", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_tank_2k22, "gvcr2", "gvcr2_spawn_tank_2k22", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_tank_m1a2, "gvcr2", "gvcr2_spawn_tank_m1a2", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_tank_m41dk1, "gvcr2", "gvcr2_spawn_tank_m41dk1", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_tank_ratte, "gvcr2", "gvcr2_spawn_tank_ratte", "spawn", true);
		}
		{
			Createjson.addjson_domain(mod.gvcr2_spawn_air_f16, "gvcr2", "gvcr2_spawn_air_f16", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_air_f18, "gvcr2", "gvcr2_spawn_air_f18", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_air_a10, "gvcr2", "gvcr2_spawn_air_a10", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_air_mig17, "gvcr2", "gvcr2_spawn_air_mig17", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_air_li28, "gvcr2", "gvcr2_spawn_air_li28", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_air_f117, "gvcr2", "gvcr2_spawn_air_f117", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_air_ac130, "gvcr2", "gvcr2_spawn_air_ac130", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_air_yak23, "gvcr2", "gvcr2_spawn_air_yak23", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_air_a4, "gvcr2", "gvcr2_spawn_air_a4", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_air_a6, "gvcr2", "gvcr2_spawn_air_a6", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_air_yak23kai, "gvcr2", "gvcr2_spawn_air_yak23kai", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_air_an2, "gvcr2", "gvcr2_spawn_air_an2", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_air_su25, "gvcr2", "gvcr2_spawn_air_su25", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_air_su27, "gvcr2", "gvcr2_spawn_air_su27", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_air_av8b, "gvcr2", "gvcr2_spawn_air_av8b", "spawn", true);
		}
		
		{
			Createjson.addjson_domain(mod.gvcr2_spawn_ship_rhib, "gvcr2", "gvcr2_spawn_ship_rhib", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_ship_rcb, "gvcr2", "gvcr2_spawn_ship_rcb", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_ship_cruiser, "gvcr2", "gvcr2_spawn_ship_cruiser", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_ship_pr1204, "gvcr2", "gvcr2_spawn_ship_pr1204", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_ship_hamina, "gvcr2", "gvcr2_spawn_ship_hamina", "spawn", true);
			Createjson.addjson_domain(mod.gvcr2_spawn_ship_airship, "gvcr2", "gvcr2_spawn_ship_airship", "spawn", true);
		}
		
		{
			Createjson.addjsonblock(mod.gvcr2_block_ge_s, "gvcr2", "gvcr2_block_ge_s", true);
			Createjson.addjsonblock(mod.gvcr2_block_ge_s_mr_cpt, "gvcr2", "gvcr2_block_ge_s_mr_cpt", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_ge_sv, "gvcr2", "gvcr2_block_ge_sv", true);
			Createjson.addjsonblock(mod.gvcr2_block_ge_sv_fire, "gvcr2", "gvcr2_block_ge_sv_fire", true);
			Createjson.addjsonblock(mod.gvcr2_block_ge_sv_trench, "gvcr2", "gvcr2_block_ge_sv_trench", true);
			Createjson.addjsonblock(mod.gvcr2_block_ge_sv_antitank, "gvcr2", "gvcr2_block_ge_sv_antitank", true);
			Createjson.addjsonblock(mod.gvcr2_block_ge_sv_sniper, "gvcr2", "gvcr2_block_ge_sv_sniper", true);
			Createjson.addjsonblock(mod.gvcr2_block_ge_sv_drone, "gvcr2", "gvcr2_block_ge_sv_drone", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_ge_se_assault, "gvcr2", "gvcr2_block_ge_se_assault", true);
			Createjson.addjsonblock(mod.gvcr2_block_ge_se_cerberus, "gvcr2", "gvcr2_block_ge_se_cerberus", true);
			Createjson.addjsonblock(mod.gvcr2_block_ge_se_hacs, "gvcr2", "gvcr2_block_ge_se_hacs", true);
			Createjson.addjsonblock(mod.gvcr2_block_ge_se_kukri, "gvcr2", "gvcr2_block_ge_se_kukri", true);
			Createjson.addjsonblock(mod.gvcr2_block_ge_s_mr_cpt, "gvcr2", "gvcr2_block_ge_s_mr_cpt", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_so_s, "gvcr2", "gvcr2_block_so_s", true);
			Createjson.addjsonblock(mod.gvcr2_block_so_s_mr_cpt, "gvcr2", "gvcr2_block_so_s_mr_cpt", true);
			Createjson.addjsonblock(mod.gvcr2_block_so_s_af_cpt, "gvcr2", "gvcr2_block_so_s_af_cpt", true);
		}
		{
			Createjson.addjsonblock(mod.gvcr2_block_set_mg_m60, "gvcr2", "gvcr2_block_set_mg_m60", true);
			Createjson.addjsonblock(mod.gvcr2_block_set_mg_m2, "gvcr2", "gvcr2_block_set_mg_m2", true);
			Createjson.addjsonblock(mod.gvcr2_block_set_mg_pkm, "gvcr2", "gvcr2_block_set_mg_pkm", true);
			Createjson.addjsonblock(mod.gvcr2_block_set_mg_dp28, "gvcr2", "gvcr2_block_set_mg_dp28", true);
			Createjson.addjsonblock(mod.gvcr2_block_set_aa_20mmaa, "gvcr2", "gvcr2_block_set_aa_20mmaa", true);
			Createjson.addjsonblock(mod.gvcr2_block_set_aa_vads, "gvcr2", "gvcr2_block_set_aa_vads", true);
			Createjson.addjsonblock(mod.gvcr2_block_set_aa_zu23, "gvcr2", "gvcr2_block_set_aa_zu23", true);
			Createjson.addjsonblock(mod.gvcr2_block_set_mg_pak40, "gvcr2", "gvcr2_block_set_mg_pak40", true);
			Createjson.addjsonblock(mod.gvcr2_block_set_mg_flak18, "gvcr2", "gvcr2_block_set_mg_flak18", true);
			Createjson.addjsonblock(mod.gvcr2_block_set_mg_tow2, "gvcr2", "gvcr2_block_set_mg_tow2", true);
			Createjson.addjsonblock(mod.gvcr2_block_set_mg_m224, "gvcr2", "gvcr2_block_set_mg_m224", true);
			Createjson.addjsonblock(mod.gvcr2_block_set_mg_fh18, "gvcr2", "gvcr2_block_set_mg_fh18", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_set_mg_ak130, "gvcr2", "gvcr2_block_set_mg_ak130", true);
			Createjson.addjsonblock(mod.gvcr2_block_set_mk15_phalanx, "gvcr2", "gvcr2_block_set_mk15_phalanx", true);
			Createjson.addjsonblock(mod.gvcr2_block_set_mk45_mod4, "gvcr2", "gvcr2_block_set_mk45_mod4", true);
			

		}
		{
			Createjson.addjsonblock(mod.gvcr2_block_apc_m113, "gvcr2", "gvcr2_block_apc_m113", true);
			Createjson.addjsonblock(mod.gvcr2_block_tank_m60a1, "gvcr2", "gvcr2_block_tank_m60a1", true);
			Createjson.addjsonblock(mod.gvcr2_block_heli_ah1s, "gvcr2", "gvcr2_block_heli_ah1s", true);
			Createjson.addjsonblock(mod.gvcr2_block_tank_t34, "gvcr2", "gvcr2_block_tank_t34", true);
			Createjson.addjsonblock(mod.gvcr2_block_tank_kv2, "gvcr2", "gvcr2_block_tank_kv2", true);
			Createjson.addjsonblock(mod.gvcr2_block_heli_g_heli, "gvcr2", "gvcr2_block_heli_g_heli", true);
			Createjson.addjsonblock(mod.gvcr2_block_ship_cruiser, "gvcr2", "gvcr2_block_ship_cruiser", true);
			Createjson.addjsonblock(mod.gvcr2_block_ship_pr1204, "gvcr2", "gvcr2_block_ship_pr1204", true);
			Createjson.addjsonblock(mod.gvcr2_block_apc_9k35, "gvcr2", "gvcr2_block_apc_9k35", true);
			Createjson.addjsonblock(mod.gvcr2_block_apc_m1097, "gvcr2", "gvcr2_block_apc_m1097", true);
			Createjson.addjsonblock(mod.gvcr2_block_air_a4, "gvcr2", "gvcr2_block_air_a4", true);
			Createjson.addjsonblock(mod.gvcr2_block_air_yak23kai, "gvcr2", "gvcr2_block_air_yak23kai", true);
			Createjson.addjsonblock(mod.gvcr2_block_tank_t72, "gvcr2", "gvcr2_block_tank_t72", true);
			Createjson.addjsonblock(mod.gvcr2_block_tank_2k22, "gvcr2", "gvcr2_block_tank_2k22", true);
			Createjson.addjsonblock(mod.gvcr2_block_heli_mi24d, "gvcr2", "gvcr2_block_heli_mi24d", true);
		}
		{
			Createjson.addjsonblock_tile(mod.gvcr2_blockspawner_ge_s, "gvcr2", "gvcr2_blockspawner_ge_s", true);
			Createjson.addjsonblock_tile(mod.gvcr2_blockspawner_so_s, "gvcr2", "gvcr2_blockspawner_so_s", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_boss_longleg, "gvcr2", "gvcr2_block_boss_longleg", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_boss_st1, "gvcr2", "gvcr2_block_boss_st1", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_boss_mer08, "gvcr2", "gvcr2_block_boss_mer08", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_boss_mer08_sn, "gvcr2", "gvcr2_block_boss_mer08_sn", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_boss_irving, "gvcr2", "gvcr2_block_boss_irving", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_boss_char2c, "gvcr2", "gvcr2_block_boss_char2c", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_boss_mer08_b, "gvcr2", "gvcr2_block_boss_mer08_b", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_boss_mer03k, "gvcr2", "gvcr2_block_boss_mer03k", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_boss_airbase, "gvcr2", "gvcr2_block_flag_boss_airbase", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_boss_av8b, "gvcr2", "gvcr2_block_boss_av8b", true);
		}
		{
			Createjson.addjsonblock(mod.gvcr2_block_chest_food, "gvcr2", "gvcr2_block_chest_food", true);
			Createjson.addjsonblock(mod.gvcr2_block_chest_weapon, "gvcr2", "gvcr2_block_chest_weapon", true);
			Createjson.addjsonblock(mod.gvcr2_block_chest_weapon2, "gvcr2", "gvcr2_block_chest_weapon2", true);
			Createjson.addjsonblock(mod.gvcr2_block_chest_weapon3, "gvcr2", "gvcr2_block_chest_weapon3", true);
			Createjson.addjsonblock(mod.gvcr2_block_chest_weapon4, "gvcr2", "gvcr2_block_chest_weapon4", true);
		}
		{
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_playerbase, "gvcr2", "gvcr2_block_flag_ge_playerbase", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_playerbase, "gvcr2", "gvcr2_block_flag_so_playerbase", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_city, "gvcr2", "gvcr2_block_building_city", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_city, "gvcr2", "gvcr2_block_flag_ge_city", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_city, "gvcr2", "gvcr2_block_flag_so_city", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_ship, "gvcr2", "gvcr2_block_building_ship", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_ship, "gvcr2", "gvcr2_block_flag_ge_ship", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_ship, "gvcr2", "gvcr2_block_flag_so_ship", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_ruins, "gvcr2", "gvcr2_block_building_ruins", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_ruins, "gvcr2", "gvcr2_block_flag_ge_ruins", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_ruins, "gvcr2", "gvcr2_block_flag_so_ruins", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_abandoned_factory, "gvcr2", "gvcr2_block_building_abandoned_factory", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_abandoned_factory, "gvcr2", "gvcr2_block_flag_ge_abandoned_factory", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_abandoned_factory, "gvcr2", "gvcr2_block_flag_so_abandoned_factory", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_airfield, "gvcr2", "gvcr2_block_building_airfield", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_airfield, "gvcr2", "gvcr2_block_flag_ge_airfield", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_airfield, "gvcr2", "gvcr2_block_flag_so_airfield", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_airbase, "gvcr2", "gvcr2_block_building_airbase", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_airbase, "gvcr2", "gvcr2_block_flag_ge_airbase", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_airbase, "gvcr2", "gvcr2_block_flag_so_airbase", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_garrison, "gvcr2", "gvcr2_block_building_garrison", true);
			Createjson.addjsonblock(mod.gvcr2_block_building_garrison_de, "gvcr2", "gvcr2_block_building_garrison_de", true);
			Createjson.addjsonblock(mod.gvcr2_block_building_garrison_sn, "gvcr2", "gvcr2_block_building_garrison_sn", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_garrison, "gvcr2", "gvcr2_block_flag_ge_garrison", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_garrison, "gvcr2", "gvcr2_block_flag_so_garrison", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_metro, "gvcr2", "gvcr2_block_building_metro", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_metro, "gvcr2", "gvcr2_block_flag_ge_metro", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_metro, "gvcr2", "gvcr2_block_flag_so_metro", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_cannon_position, "gvcr2", "gvcr2_block_building_cannon_position", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_cannon_position, "gvcr2", "gvcr2_block_flag_ge_cannon_position", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_cannon_position, "gvcr2", "gvcr2_block_flag_so_cannon_position", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_trench, "gvcr2", "gvcr2_block_building_trench", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_trench, "gvcr2", "gvcr2_block_flag_ge_trench", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_trench, "gvcr2", "gvcr2_block_flag_so_trench", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_battleship, "gvcr2", "gvcr2_block_building_battleship", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_battleship, "gvcr2", "gvcr2_block_flag_ge_battleship", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_battleship, "gvcr2", "gvcr2_block_flag_so_battleship", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_snowcastle, "gvcr2", "gvcr2_block_building_snowcastle", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_snowcastle, "gvcr2", "gvcr2_block_flag_ge_snowcastle", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_snowcastle, "gvcr2", "gvcr2_block_flag_so_snowcastle", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_trainstation, "gvcr2", "gvcr2_block_building_trainstation", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_trainstation, "gvcr2", "gvcr2_block_flag_ge_trainstation", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_trainstation, "gvcr2", "gvcr2_block_flag_so_trainstation", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_reichstag, "gvcr2", "gvcr2_block_building_reichstag", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_reichstag, "gvcr2", "gvcr2_block_flag_ge_reichstag", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_reichstag, "gvcr2", "gvcr2_block_flag_so_reichstag", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_desertcity, "gvcr2", "gvcr2_block_building_desertcity", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_desertcity, "gvcr2", "gvcr2_block_flag_ge_desertcity", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_desertcity, "gvcr2", "gvcr2_block_flag_so_desertcity", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_triumphal_arch, "gvcr2", "gvcr2_block_building_triumphal_arch", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_triumphal_arch, "gvcr2", "gvcr2_block_flag_ge_triumphal_arch", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_triumphal_arch, "gvcr2", "gvcr2_block_flag_so_triumphal_arch", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_cv, "gvcr2", "gvcr2_block_building_cv", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_cv, "gvcr2", "gvcr2_block_flag_ge_cv", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_cv, "gvcr2", "gvcr2_block_flag_so_cv", true);
			Createjson.addjsonblock(mod.gvcr2_block_cv_jamming, "gvcr2", "gvcr2_block_cv_jamming", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_dd, "gvcr2", "gvcr2_block_building_dd", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_dd, "gvcr2", "gvcr2_block_flag_ge_dd", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_dd, "gvcr2", "gvcr2_block_flag_so_dd", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_boss_cv, "gvcr2", "gvcr2_block_flag_boss_cv", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_ff, "gvcr2", "gvcr2_block_building_ff", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_ff, "gvcr2", "gvcr2_block_flag_ge_ff", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_ff, "gvcr2", "gvcr2_block_flag_so_ff", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_flaktower, "gvcr2", "gvcr2_block_building_flaktower", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_flaktower, "gvcr2", "gvcr2_block_flag_ge_flaktower", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_flaktower, "gvcr2", "gvcr2_block_flag_so_flaktower", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_slum, "gvcr2", "gvcr2_block_building_slum", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_slum, "gvcr2", "gvcr2_block_flag_ge_slum", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_slum, "gvcr2", "gvcr2_block_flag_so_slum", true);
			
			Createjson.addjsonblock(mod.gvcr2_block_building_highway, "gvcr2", "gvcr2_block_building_highway", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_ge_highway, "gvcr2", "gvcr2_block_flag_ge_highway", true);
			Createjson.addjsonblock_tile(mod.gvcr2_block_flag_so_highway, "gvcr2", "gvcr2_block_flag_so_highway", true);
		}
		{
			Createjson.addjson_domain(mod.gvcr2_item_inv_infantry_1, "gvcr2", "gvcr2_item_inv_infantry_1", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_infantry_2, "gvcr2", "gvcr2_item_inv_infantry_2", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_infantry_3, "gvcr2", "gvcr2_item_inv_infantry_3", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_infantry_4, "gvcr2", "gvcr2_item_inv_infantry_4", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_normal_1, "gvcr2", "gvcr2_item_inv_normal_1", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_normal_2, "gvcr2", "gvcr2_item_inv_normal_2", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_normal_3, "gvcr2", "gvcr2_item_inv_normal_3", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_normal_4, "gvcr2", "gvcr2_item_inv_normal_4", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_tank_1, "gvcr2", "gvcr2_item_inv_tank_1", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_tank_2, "gvcr2", "gvcr2_item_inv_tank_2", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_tank_3, "gvcr2", "gvcr2_item_inv_tank_3", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_tank_4, "gvcr2", "gvcr2_item_inv_tank_4", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_dogfight_1, "gvcr2", "gvcr2_item_inv_dogfight_1", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_dogfight_2, "gvcr2", "gvcr2_item_inv_dogfight_2", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_dogfight_3, "gvcr2", "gvcr2_item_inv_dogfight_3", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_dogfight_4, "gvcr2", "gvcr2_item_inv_dogfight_4", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_airborne_1, "gvcr2", "gvcr2_item_inv_airborne_1", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_airborne_2, "gvcr2", "gvcr2_item_inv_airborne_2", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_airborne_3, "gvcr2", "gvcr2_item_inv_airborne_3", "item", mod.isDebugMessage);
			Createjson.addjson_domain(mod.gvcr2_item_inv_airborne_4, "gvcr2", "gvcr2_item_inv_airborne_4", "item", mod.isDebugMessage);
		}
	}
}

package gvcr2.registry;

import gvclib.item.ItemAttachment;
import gvclib.item.ItemGunBase;
import gvclib.item.ItemGun_AR;
import gvclib.item.ItemGun_SR;
import gvclib.item.ItemGun_SWORD;
import gvclib.item.ItemGun_Shield;
import gvcr2.mod_GVCR2;
import gvcr2.item.ItemGun_BeaconGun;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import objmodel.AdvancedModelLoader;

public class GVCR2ItemRegistry_GUN_SW {
	public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Item> event){
		{
			mod.gvcr2_gun_kukriknife	= new ItemGun_SWORD().setUnlocalizedName("gvcr2_gun_kukriknife")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_kukriknife").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_kukriknife;
				GVCR2LoadGunStatus.load(gun, mod, event, "sw/gvcr2_gun_kukriknife.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_kukriknife);
		}
		{
			mod.gvcr2_gun_club	= new ItemGun_SWORD().setUnlocalizedName("gvcr2_gun_club")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_club").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_club;
				GVCR2LoadGunStatus.load(gun, mod, event, "sw/gvcr2_gun_club.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_club);
		}
		{
			mod.gvcr2_gun_compoundbow	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_compoundbow")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_compoundbow").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_compoundbow;
				GVCR2LoadGunStatus.load(gun, mod, event, "sw/gvcr2_gun_compoundbow.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_compoundbow);
		}
		{
			mod.gvcr2_am_exarrow	= new ItemAttachment().setUnlocalizedName("gvcr2_am_exarrow").setMaxStackSize(64)
					.setCreativeTab(mod.tab_gun)
	        		.setRegistryName(mod.MOD_ID, "gvcr2_am_exarrow");
			{
				ItemAttachment am = (ItemAttachment) mod.gvcr2_am_exarrow;
				if (mod.proxy.getClient()) {
		    		
		    	}
				am.id = 50;
				am.power = 1.0F;
				am.pellet = 1;
				am.exlevel = 2.0F;
				am.bure = 1.0F;
				am.bure_ads = 1.0F;
				am.bullet_name = "EXARROW";
			}
			event.getRegistry().register(mod.gvcr2_am_exarrow);
		}
		{
			mod.gvcr2_am_psarrow	= new ItemAttachment().setUnlocalizedName("gvcr2_am_psarrow").setMaxStackSize(64)
					.setCreativeTab(mod.tab_gun)
	        		.setRegistryName(mod.MOD_ID, "gvcr2_am_psarrow");
			{
				ItemAttachment am = (ItemAttachment) mod.gvcr2_am_psarrow;
				if (mod.proxy.getClient()) {
		    		
		    	}
				am.id = 50;
				am.power = 1.0F;
				am.pellet = 1;
				am.p_id = 19;
				am.p_level = 0;
				am.p_time = 100;
				am.bullet_name = "PSARROW";
			}
			event.getRegistry().register(mod.gvcr2_am_psarrow);
		}
		
		
		
		
		
		{
			mod.gvcr2_gun_riotshield	= new ItemGun_Shield().setUnlocalizedName("gvcr2_gun_riotshield")
		    		.setMaxDamage(1).setRegistryName(mod.MOD_ID, "gvcr2_gun_riotshield").setCreativeTab(mod.tab_gun);
		    {
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_riotshield;
				if (mod.proxy.getClient()) {
				gun.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/gun/model/sd/riotshield.mqo"));
				gun.arm_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/arm.obj"));
				}
				gun.obj_tex = "gvcr2:textures/gun/model/sd/riotshield.png";
				gun.obj_true = true;
				gun.Shield_defence = 0.75F;
				gun.motion = 0.9F;
				
				gun.magazine = null;
				gun.Sprintrotationx = 0; 
				gun.Sprintrotationy = 0; 
				gun.model_y = -2F;
				gun.model_y_ads = -1.7F;
				gun.model_x = 4F;
				gun.model_x_ads = 2F;
				gun.arm_l_posz = - 20F;
				gun.rotationz = -30F;
				gun.model_y_adsr = -2.4F;
				gun.model_y_adss = -2.4F;
				
				mod_GVCR2.gun_eme_2[mod_GVCR2.gun_id_2] = 4;
				mod_GVCR2.gun_iron_2[mod_GVCR2.gun_id_2] = 4;
				mod_GVCR2.gun_red_2[mod_GVCR2.gun_id_2] = 4;
				mod_GVCR2.gun_item_2[mod_GVCR2.gun_id_2] = gun;
				++mod_GVCR2.gun_id_2;
			}
		    event.getRegistry().register(mod.gvcr2_gun_riotshield);
		}
		{
			mod.gvcr2_gun_heavyshield	= new ItemGun_Shield().setUnlocalizedName("gvcr2_gun_heavyshield")
		    		.setMaxDamage(1).setRegistryName(mod.MOD_ID, "gvcr2_gun_heavyshield").setCreativeTab(mod.tab_gun);
		    {
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_heavyshield;
				if (mod.proxy.getClient()) {
				gun.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/gun/model/sd/heavyshield.mqo"));
				gun.arm_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/arm.obj"));
				}
				gun.obj_tex = "gvcr2:textures/gun/model/sd/heavyshield.png";
				gun.obj_true = true;
				gun.Shield_defence = 0.1F;
				gun.motion = 0.4F;
				
				gun.magazine = null;
				gun.Sprintrotationx = 0; 
				gun.Sprintrotationy = 0; 
				gun.model_y = -2F;
				gun.model_y_ads = -1.7F;
				gun.model_x = 4F;
				gun.model_x_ads = 2F;
				gun.arm_l_posz = - 20F;
				gun.rotationz = -30F;
				gun.model_y_adsr = -2.4F;
				gun.model_y_adss = -2.4F;
				
				mod_GVCR2.gun_eme_2[mod_GVCR2.gun_id_2] = 4;
				mod_GVCR2.gun_iron_2[mod_GVCR2.gun_id_2] = 8;
				mod_GVCR2.gun_red_2[mod_GVCR2.gun_id_2] = 4;
				mod_GVCR2.gun_item_2[mod_GVCR2.gun_id_2] = gun;
			}
		    event.getRegistry().register(mod.gvcr2_gun_heavyshield);
		}
		
		{
			mod.gvcr2_gun_la16u	= new ItemGun_BeaconGun().setUnlocalizedName("gvcr2_gun_la16u")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_la16u").setCreativeTab(mod.tab_gun);
			{
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_la16u;
					if (FMLCommonHandler.instance().getSide().isClient()) {
						gun.obj_model = AdvancedModelLoader
								.loadModel(new ResourceLocation("gvcr2:textures/gun/model/hg/la16u.mqo"));
						gun.arm_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/arm.obj"));
						gun.arm_model2 = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/arm2.obj"));
						gun.flash_model = AdvancedModelLoader
								.loadModel(new ResourceLocation("gvclib:textures/model/flash.obj"));
					}
					gun.obj_tex = "gvcr2:textures/gun/model/hg/la16u.png";
					gun.gun_type = 3;
					gun.bullet_time_max = 800;
					gun.ex = mod.cfg_exprotion_player;
					gun.exlevel = 2.0F;
					gun.setMaxDamage(1);
					gun.reload_type = 2;
					gun.powor = 30;
					gun.reloadtime = 50;
					gun.scopezoom = gun.scopezoombase = 3F;
					//gun.magazine = new ItemStack(Blocks.EMERALD_BLOCK, 1).getItem();
					gun.magazine = Items.AIR;
					gun.sound = gun.soundbase = "gvclib.sound_call";
					gun.soundsp = 1.0F;

					gun.obj_true = true;
					gun.shotgun_pellet = 1;
					gun.render_sight = false;
					gun.render_light = false;
					gun.render_muss = false;
					gun.render_grip = false;

					gun.model_y = -1.0F;
					gun.model_y_ads = -1.225F;
					gun.model_z_ads = -2.0F;

					gun.arm_r_posy =   0F;
					gun.arm_l_posx = - 0F;
					gun.arm_l_posy = - 0.6F;
					gun.arm_l_posz = - 2.5F;
					
					gun.Sprintrotationx = -60; 
					gun.Sprintrotationy = 0; 
					
					mod_GVCR2.gun_eme_2[mod_GVCR2.gun_id_2] = 16;
					mod_GVCR2.gun_iron_2[mod_GVCR2.gun_id_2] = 8;
					mod_GVCR2.gun_red_2[mod_GVCR2.gun_id_2] = 8;
					mod_GVCR2.gun_item_2[mod_GVCR2.gun_id_2] = gun;
					++mod_GVCR2.gun_id_2;
				}
			}
		    event.getRegistry().register(mod.gvcr2_gun_la16u);
		}
		{
			
		    
		    
		    mod.gvcr2_item_request_105mm	= new ItemAttachment().setUnlocalizedName("gvcr2_item_request_105mm")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_105mm").setCreativeTab(mod.tab_gun);
			{
				ItemAttachment am = (ItemAttachment) mod.gvcr2_item_request_105mm;
				am.id = 55;
				am.information1 = "gvcr2.string.item.request_1.name";
				am.information2 = "gvcr2.string.item.request_2.name";
				am.information3 = "gvcr2.string.item.request_3.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_105mm);
		    mod.gvcr2_item_request_40mm	= new ItemAttachment().setUnlocalizedName("gvcr2_item_request_40mm")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_40mm").setCreativeTab(mod.tab_gun);
			{
				ItemAttachment am = (ItemAttachment) mod.gvcr2_item_request_40mm;
				am.id = 55;
				am.information1 = "gvcr2.string.item.request_1.name";
				am.information2 = "gvcr2.string.item.request_2.name";
				am.information3 = "gvcr2.string.item.request_3.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_40mm);
		    mod.gvcr2_item_request_20mm	= new ItemAttachment().setUnlocalizedName("gvcr2_item_request_20mm")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_20mm").setCreativeTab(mod.tab_gun);
			{
				ItemAttachment am = (ItemAttachment) mod.gvcr2_item_request_20mm;
				am.id = 55;
				am.information1 = "gvcr2.string.item.request_1.name";
				am.information2 = "gvcr2.string.item.request_2.name";
				am.information3 = "gvcr2.string.item.request_3.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_20mm);
		    
		    mod.gvcr2_item_request_pave	= new ItemAttachment().setUnlocalizedName("gvcr2_item_request_pave")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_pave").setCreativeTab(mod.tab_gun);
			{
				ItemAttachment am = (ItemAttachment) mod.gvcr2_item_request_pave;
				am.id = 55;
				am.information1 = "gvcr2.string.item.request_1.name";
				am.information2 = "gvcr2.string.item.request_2.name";
				am.information3 = "gvcr2.string.item.request_3.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_pave);
		    
		    mod.gvcr2_item_request_missile1	= new ItemAttachment().setUnlocalizedName("gvcr2_item_request_missile1")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_missile1").setCreativeTab(mod.tab_gun);
			{
				ItemAttachment am = (ItemAttachment) mod.gvcr2_item_request_missile1;
				am.id = 55;
				am.information1 = "gvcr2.string.item.request_1.name";
				am.information2 = "gvcr2.string.item.request_2.name";
				am.information3 = "gvcr2.string.item.request_3.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_missile1);
		    mod.gvcr2_item_request_missile2	= new ItemAttachment().setUnlocalizedName("gvcr2_item_request_missile2")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_missile2").setCreativeTab(mod.tab_gun);
			{
				ItemAttachment am = (ItemAttachment) mod.gvcr2_item_request_missile2;
				am.id = 55;
				am.information1 = "gvcr2.string.item.request_1.name";
				am.information2 = "gvcr2.string.item.request_2.name";
				am.information3 = "gvcr2.string.item.request_3.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_missile2);
		    mod.gvcr2_item_request_missile3	= new ItemAttachment().setUnlocalizedName("gvcr2_item_request_missile3")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_missile3").setCreativeTab(mod.tab_gun);
			{
				ItemAttachment am = (ItemAttachment) mod.gvcr2_item_request_missile3;
				am.id = 55;
				am.information1 = "gvcr2.string.item.request_1.name";
				am.information2 = "gvcr2.string.item.request_2.name";
				am.information3 = "gvcr2.string.item.request_3.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_missile3);
		    
		    mod.gvcr2_item_request_rog	= new ItemAttachment().setUnlocalizedName("gvcr2_item_request_rog")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_rog").setCreativeTab(mod.tab_gun);
			{
				ItemAttachment am = (ItemAttachment) mod.gvcr2_item_request_rog;
				am.id = 55;
				am.information1 = "gvcr2.string.item.request_1.name";
				am.information2 = "gvcr2.string.item.request_2.name";
				am.information3 = "gvcr2.string.item.request_3.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_rog);
		}
	}
}

package gvcr2.registry;

import gvclib.item.ItemAttachment;
import gvclib.item.ItemGunBase;
import gvclib.item.ItemGun_Grenade;
import gvcr2.mod_GVCR2;
import gvcr2.item.ItemRequest_Remocon;
import gvcr2.item.ItemRequest_Smoke;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import objmodel.AdvancedModelLoader;

public class GVCR2ItemRegistry_GUN_GRENADE {
	public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Item> event){
		{
			mod.gvcr2_grenade_frag	= new ItemGun_Grenade().setUnlocalizedName("gvcr2_grenade_frag").setMaxStackSize(3)
		    		.setRegistryName(mod.MOD_ID, "gvcr2_grenade_frag").setCreativeTab(mod.tab_item);
			ItemGunBase gun = (ItemGunBase)mod. gvcr2_grenade_frag;
	    	if (FMLCommonHandler.instance().getSide().isClient()) {
				gun.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/gun/model/grenade/grenade.mqo"));
				gun.obj_tex = "gvcr2:textures/gun/model/grenade/grenade.png";
				gun.arm_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/arm.obj"));
				gun.arm_model2 = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/arm2.obj"));
				gun.flash_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/flash.obj"));
				
			}
			
			gun.gun_type = 9;
			gun.bullet_model = "gvclib:textures/entity/model/grenade.mqo";
			gun.bullet_tex = "gvclib:textures/entity/model/grenade.png";
			gun.bullet_time_max = 60;
			gun.ex = mod_GVCR2.cfg_exprotion_grenade;//false
			gun.exfire = false;
			gun.exlevel = 3.5F;
			gun.bullet_c = true;
			gun.muzzle_flash = false;
			
			gun.setMaxDamage(1);
			gun.reload_type = 2;
			gun.powor = 30;
			gun.speed = 1.5F;
			gun.bure = 1.0F;
			gun.gra = 0.0F;
			gun.recoil = 0D;
			gun.reloadtime = 50;
			gun.cycle = gun.cocktime = 6;
			gun.scopezoom = gun.scopezoombase = 1.2F;
			gun.magazine = mod.gvcr2_grenade_frag;
			gun.fires = SoundEvents.ENTITY_SNOWBALL_THROW;
			gun.sound = gun.soundbase  = "gvclib.fire_rifle";
			gun.soundsp = 1.0F;
			
			gun.obj_true = true;
			gun.shotgun_pellet = 1;
			
			gun.Sprintrotationx = -60; 
			gun.Sprintrotationy = 0; 
			
			gun.model_y = -2.0F;
			gun.model_y_ads = -2.0F;
			gun.model_x = 1.5F;
			gun.model_x_ads = 1.5F;
			gun.model_z = -3.5F;
			gun.model_z_ads = -3.5F;
			
			gun.arm_l_posx = - 0F;
			gun.arm_l_posy = - 0.0F;
			gun.arm_l_posz = - 20F;
			
			gun.Sprintrotationx = -60; 
			gun.Sprintrotationy = 0;
			
			gun.mobmax = 30;
		    gun.mobrange = 30;
		    gun.mobbullettype = 9;
		    gun.mobammo = 60;
		    gun.mobcycle = 2;
		    gun.mobbarst = 1;
		    {
				gun.newreload = true;
				gun.mat_rk_0 = 1;
				gun.mat_r_0 = new String[]{"mat1", "0", "60", 
						"0", "0", "0", 
			    		"0", "0", "0", 
			    		"0", "0", "0", 
			    		"0", "0", "0", 
			    		"0", "0", "0", "0","0"
			    		};
				
			}
		
		    event.getRegistry().register(mod.gvcr2_grenade_frag);
		}
		
		{
			mod.gvcr2_grenade_flame	= new ItemGun_Grenade().setUnlocalizedName("gvcr2_grenade_flame").setMaxStackSize(3)
		    		.setRegistryName(mod.MOD_ID, "gvcr2_grenade_flame").setCreativeTab(mod.tab_item);
			ItemGunBase gun = (ItemGunBase)mod. gvcr2_grenade_flame;
	    	if (FMLCommonHandler.instance().getSide().isClient()) {
				gun.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/gun/model/grenade/grenade_smoke.mqo"));
				gun.obj_tex = "gvcr2:textures/gun/model/grenade/grenade_smoke.png";
				gun.arm_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/arm.obj"));
				gun.arm_model2 = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/arm2.obj"));
				gun.flash_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/flash.obj"));
				
			}
			
			gun.gun_type = 9;
			gun.bullet_model = "gvclib:textures/entity/model/grenade.mqo";
			gun.bullet_tex = "gvclib:textures/entity/model/grenade.png";
			gun.bullet_time_max = 60;
			gun.ex = false;
			gun.exfire = true;
			//gun.exgas = true;
			gun.exlevel = 2.0F;
			gun.bullet_c = true;
			gun.muzzle_flash = false;
			
			gun.setMaxDamage(1);
			gun.reload_type = 2;
			gun.powor = 00;
			gun.speed = 1.5F;
			gun.bure = 1.0F;
			gun.gra = 0.0F;
			gun.recoil = 0D;
			gun.reloadtime = 50;
			gun.cycle = gun.cocktime = 6;
			gun.scopezoom = gun.scopezoombase = 1.2F;
			gun.magazine = mod.gvcr2_grenade_flame;
			gun.fires = SoundEvents.ENTITY_SNOWBALL_THROW;
			gun.sound = gun.soundbase  = "gvclib.fire_rifle";
			gun.soundsp = 1.0F;
			
			gun.obj_true = true;
			gun.shotgun_pellet = 1;
			
			gun.Sprintrotationx = -60; 
			gun.Sprintrotationy = 0; 
			
			gun.model_y = -2.0F;
			gun.model_y_ads = -2.0F;
			gun.model_x = 1.5F;
			gun.model_x_ads = 1.5F;
			gun.model_z = -3.5F;
			gun.model_z_ads = -3.5F;
			
			gun.arm_l_posx = - 0F;
			gun.arm_l_posy = - 0.0F;
			gun.arm_l_posz = - 20F;
			
			gun.Sprintrotationx = -60; 
			gun.Sprintrotationy = 0;
			
			gun.mobmax = 30;
		    gun.mobrange = 30;
		    gun.mobbullettype = 9;
		    gun.mobammo = 60;
		    gun.mobcycle = 2;
		    gun.mobbarst = 1;
		    {
				gun.newreload = true;
				gun.mat_rk_0 = 1;
				gun.mat_r_0 = new String[]{"mat1", "0", "60", 
						"0", "0", "0", 
			    		"0", "0", "0", 
			    		"0", "0", "0", 
			    		"0", "0", "0", 
			    		"0", "0", "0", "0","0"
			    		};
				
			}
		
		    event.getRegistry().register(mod.gvcr2_grenade_flame);
		}
		
		{
			mod.gvcr2_grenade_smoke	= new ItemGun_Grenade().setUnlocalizedName("gvcr2_grenade_smoke").setMaxStackSize(3)
		    		.setRegistryName(mod.MOD_ID, "gvcr2_grenade_smoke").setCreativeTab(mod.tab_item);
			ItemGunBase gun = (ItemGunBase)mod. gvcr2_grenade_smoke;
	    	if (FMLCommonHandler.instance().getSide().isClient()) {
				gun.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/gun/model/grenade/grenade_smoke.mqo"));
				gun.obj_tex = "gvcr2:textures/gun/model/grenade/grenade_smoke.png";
				gun.arm_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/arm.obj"));
				gun.arm_model2 = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/arm2.obj"));
				gun.flash_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/flash.obj"));
				
			}
			
			gun.gun_type = 9;
			gun.bullet_model = "gvclib:textures/entity/model/grenade_smoke.mqo";
			gun.bullet_tex = "gvclib:textures/entity/model/grenade_smoke.png";
			gun.bullet_time_max = 40;
			gun.ex = false;
			gun.exfire = false;
			gun.exsmoke = true;
			gun.exlevel = 2.0F;
			gun.muzzle_flash = false;
			
			gun.setMaxDamage(1);
			gun.reload_type = 2;
			gun.powor = 0;
			gun.speed = 1.5F;
			gun.bure = 1.0F;
			gun.gra = 0.0F;
			gun.recoil = 0D;
			gun.reloadtime = 50;
			gun.cycle = gun.cocktime = 6;
			gun.scopezoom = gun.scopezoombase = 1.2F;
			gun.magazine = mod.gvcr2_grenade_smoke;
			gun.fires = SoundEvents.ENTITY_SNOWBALL_THROW;
			gun.sound = gun.soundbase  = "gvclib.fire_rifle";
			gun.soundsp = 1.0F;
			
			gun.obj_true = true;
			gun.shotgun_pellet = 1;
			
			gun.Sprintrotationx = -60; 
			gun.Sprintrotationy = 0; 
			
			gun.model_y = -2.0F;
			gun.model_y_ads = -2.0F;
			gun.model_x = 1.5F;
			gun.model_x_ads = 1.5F;
			gun.model_z = -3.5F;
			gun.model_z_ads = -3.5F;
			
			gun.arm_l_posx = - 0F;
			gun.arm_l_posy = - 0.0F;
			gun.arm_l_posz = - 20F;
			
			gun.Sprintrotationx = -60; 
			gun.Sprintrotationy = 0;
			
			gun.mobmax = 30;
		    gun.mobrange = 30;
		    gun.mobbullettype = 9;
		    gun.mobammo = 60;
		    gun.mobcycle = 2;
		    gun.mobbarst = 1;
		    {
				gun.newreload = true;
				gun.mat_rk_0 = 1;
				gun.mat_r_0 = new String[]{"mat1", "0", "60", 
						"0", "0", "0", 
			    		"0", "0", "0", 
			    		"0", "0", "0", 
			    		"0", "0", "0", 
			    		"0", "0", "0", "0","0"
			    		};
				
			}
		
		    event.getRegistry().register(mod.gvcr2_grenade_smoke);
		}
		
		{
			mod.gvcr2_grenade_impact	= new ItemGun_Grenade().setUnlocalizedName("gvcr2_grenade_impact").setMaxStackSize(3)
		    		.setRegistryName(mod.MOD_ID, "gvcr2_grenade_impact").setCreativeTab(mod.tab_item);
			ItemGunBase gun = (ItemGunBase)mod. gvcr2_grenade_impact;
	    	if (FMLCommonHandler.instance().getSide().isClient()) {
				gun.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/gun/model/grenade/grenade.mqo"));
				gun.obj_tex = "gvcr2:textures/gun/model/grenade/grenade.png";
				gun.arm_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/arm.obj"));
				gun.arm_model2 = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/arm2.obj"));
				gun.flash_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/flash.obj"));
				
			}
			
			gun.gun_type = 2;
			gun.bullet_model = "gvclib:textures/entity/model/grenade.mqo";
			gun.bullet_tex = "gvclib:textures/entity/model/grenade.png";
			gun.bullet_time_max = 100;
			gun.ex = mod_GVCR2.cfg_exprotion_grenade;//false
			gun.exfire = false;
			gun.exlevel = 2.0F;
			gun.bullet_c = true;
			gun.muzzle_flash = false;
			
			gun.setMaxDamage(1);
			gun.reload_type = 2;
			gun.powor = 15;
			gun.speed = 1.5F;
			gun.bure = 1.0F;
			gun.gra = 0.0F;
			gun.recoil = 0D;
			gun.reloadtime = 50;
			gun.cycle = gun.cocktime = 6;
			gun.scopezoom = gun.scopezoombase = 1.2F;
			gun.magazine = mod.gvcr2_grenade_impact;
			gun.fires = SoundEvents.ENTITY_SNOWBALL_THROW;
			gun.sound = gun.soundbase  = "gvclib.fire_rifle";
			gun.soundsp = 1.0F;
			
			gun.obj_true = true;
			gun.shotgun_pellet = 1;
			
			gun.Sprintrotationx = -60; 
			gun.Sprintrotationy = 0; 
			
			gun.model_y = -2.0F;
			gun.model_y_ads = -2.0F;
			gun.model_x = 1.5F;
			gun.model_x_ads = 1.5F;
			gun.model_z = -3.5F;
			gun.model_z_ads = -3.5F;
			
			gun.arm_l_posx = - 0F;
			gun.arm_l_posy = - 0.0F;
			gun.arm_l_posz = - 20F;
			
			gun.Sprintrotationx = -60; 
			gun.Sprintrotationy = 0;
			
			gun.mobmax = 30;
		    gun.mobrange = 30;
		    gun.mobbullettype = 9;
		    gun.mobammo = 60;
		    gun.mobcycle = 2;
		    gun.mobbarst = 1;
		    {
				gun.newreload = true;
				gun.mat_rk_0 = 1;
				gun.mat_r_0 = new String[]{"mat1", "0", "60", 
						"0", "0", "0", 
			    		"0", "0", "0", 
			    		"0", "0", "0", 
			    		"0", "0", "0", 
			    		"0", "0", "0", "0","0"
			    		};
				
			}
		
		    event.getRegistry().register(mod.gvcr2_grenade_impact);
		}
		
		{
			mod.gvcr2_grenade_atgrenade	= new ItemGun_Grenade().setUnlocalizedName("gvcr2_grenade_atgrenade").setMaxStackSize(3)
		    		.setRegistryName(mod.MOD_ID, "gvcr2_grenade_atgrenade").setCreativeTab(mod.tab_item);
			ItemGunBase gun = (ItemGunBase)mod. gvcr2_grenade_atgrenade;
	    	if (FMLCommonHandler.instance().getSide().isClient()) {
				gun.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/gun/model/grenade/atgrenade.mqo"));
				gun.obj_tex = "gvcr2:textures/gun/model/grenade/atgrenade.png";
				gun.arm_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/arm.obj"));
				gun.arm_model2 = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/arm2.obj"));
				gun.flash_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/flash.obj"));
				
			}
			
			gun.gun_type = 3;
			gun.bullet_model = "gvclib:textures/entity/model/grenade_at.mqo";
			gun.bullet_tex = "gvclib:textures/entity/model/grenade_at.png";
			gun.bullet_time_max = 100;
			gun.ex = mod_GVCR2.cfg_exprotion_player;
			gun.exfire = false;
			gun.exlevel = 4.0F;
			gun.bullet_c = true;
			gun.muzzle_flash = false;
			
			gun.setMaxDamage(1);
			gun.reload_type = 2;
			gun.powor = 40;
			gun.speed = 1.0F;
			gun.bure = 1.0F;
			gun.gra = 0.0F;
			gun.recoil = 0D;
			gun.reloadtime = 50;
			gun.cycle = gun.cocktime = 6;
			gun.scopezoom = gun.scopezoombase = 1.2F;
			gun.magazine = mod.gvcr2_grenade_atgrenade;
			gun.fires = SoundEvents.ENTITY_SNOWBALL_THROW;
			gun.sound = gun.soundbase  = "gvclib.fire_rifle";
			gun.soundsp = 1.0F;
			
			gun.obj_true = true;
			gun.shotgun_pellet = 1;
			
			gun.Sprintrotationx = -60; 
			gun.Sprintrotationy = 0; 
			
			gun.model_y = -2.0F;
			gun.model_y_ads = -2.0F;
			gun.model_x = 1.5F;
			gun.model_x_ads = 1.5F;
			gun.model_z = -3.5F;
			gun.model_z_ads = -3.5F;
			
			gun.arm_l_posx = - 0F;
			gun.arm_l_posy = - 0.0F;
			gun.arm_l_posz = - 20F;
			
			gun.Sprintrotationx = -60; 
			gun.Sprintrotationy = 0;
			
			gun.mobmax = 30;
		    gun.mobrange = 30;
		    gun.mobbullettype = 9;
		    gun.mobammo = 60;
		    gun.mobcycle = 2;
		    gun.mobbarst = 1;
		    {
				gun.newreload = true;
				gun.mat_rk_0 = 1;
				gun.mat_r_0 = new String[]{"mat1", "0", "60", 
						"0", "0", "0", 
			    		"0", "0", "0", 
			    		"0", "0", "0", 
			    		"0", "0", "0", 
			    		"0", "0", "0", "0","0"
			    		};
				
			}
		
		    event.getRegistry().register(mod.gvcr2_grenade_atgrenade);
		}
		
		{
			mod.gvcr2_item_request_fire1	= new ItemRequest_Smoke(9).setUnlocalizedName("gvcr2_item_request_fire1")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_fire1").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Smoke am = (ItemRequest_Smoke) mod.gvcr2_item_request_fire1;
				am.information1 = "gvcr2.string.item.request_4.name";
				am.information2 = "gvcr2.string.item.request_5.name";
				am.information3 = "gvcr2.string.item.request_6.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_fire1);
		    mod.gvcr2_item_request_fire2	= new ItemRequest_Smoke(10).setUnlocalizedName("gvcr2_item_request_fire2")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_fire2").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Smoke am = (ItemRequest_Smoke) mod.gvcr2_item_request_fire2;
				am.information1 = "gvcr2.string.item.request_4.name";
				am.information2 = "gvcr2.string.item.request_5.name";
				am.information3 = "gvcr2.string.item.request_6.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_fire2);
		    mod.gvcr2_item_request_fire3	= new ItemRequest_Smoke(11).setUnlocalizedName("gvcr2_item_request_fire3")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_fire3").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Smoke am = (ItemRequest_Smoke) mod.gvcr2_item_request_fire3;
				am.information1 = "gvcr2.string.item.request_4.name";
				am.information2 = "gvcr2.string.item.request_5.name";
				am.information3 = "gvcr2.string.item.request_6.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_fire3);
			
			mod.gvcr2_item_request_airstrike1	= new ItemRequest_Smoke(1).setUnlocalizedName("gvcr2_item_request_airstrike1")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_airstrike1").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Smoke am = (ItemRequest_Smoke) mod.gvcr2_item_request_airstrike1;
				am.information1 = "gvcr2.string.item.request_4.name";
				am.information2 = "gvcr2.string.item.request_5.name";
				am.information3 = "gvcr2.string.item.request_6.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_airstrike1);
		    mod.gvcr2_item_request_airstrike2	= new ItemRequest_Smoke(2).setUnlocalizedName("gvcr2_item_request_airstrike2")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_airstrike2").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Smoke am = (ItemRequest_Smoke) mod.gvcr2_item_request_airstrike2;
				am.information1 = "gvcr2.string.item.request_4.name";
				am.information2 = "gvcr2.string.item.request_5.name";
				am.information3 = "gvcr2.string.item.request_6.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_airstrike2);
		    mod.gvcr2_item_request_airstrike3	= new ItemRequest_Smoke(3).setUnlocalizedName("gvcr2_item_request_airstrike3")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_airstrike3").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Smoke am = (ItemRequest_Smoke) mod.gvcr2_item_request_airstrike3;
				am.information1 = "gvcr2.string.item.request_4.name";
				am.information2 = "gvcr2.string.item.request_5.name";
				am.information3 = "gvcr2.string.item.request_6.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_airstrike3);
		    
		    mod.gvcr2_item_request_strafing1	= new ItemRequest_Smoke(12).setUnlocalizedName("gvcr2_item_request_strafing1")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_strafing1").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Smoke am = (ItemRequest_Smoke) mod.gvcr2_item_request_strafing1;
				am.information1 = "gvcr2.string.item.request_4.name";
				am.information2 = "gvcr2.string.item.request_5.name";
				am.information3 = "gvcr2.string.item.request_6.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_strafing1);
		    
		    mod.gvcr2_item_request_strafing2	= new ItemRequest_Smoke(13).setUnlocalizedName("gvcr2_item_request_strafing2")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_strafing2").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Smoke am = (ItemRequest_Smoke) mod.gvcr2_item_request_strafing2;
				am.information1 = "gvcr2.string.item.request_4.name";
				am.information2 = "gvcr2.string.item.request_5.name";
				am.information3 = "gvcr2.string.item.request_6.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_strafing2);
		    
		    
		    
		    mod.gvcr2_item_request_flare	= new ItemRequest_Smoke(4).setUnlocalizedName("gvcr2_item_request_flare")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_flare").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Smoke am = (ItemRequest_Smoke) mod.gvcr2_item_request_flare;
				am.information1 = "gvcr2.string.item.request_4.name";
				am.information2 = "gvcr2.string.item.request_5.name";
				am.information3 = "gvcr2.string.item.request_6.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_flare);
		    mod.gvcr2_item_request_light	= new ItemRequest_Smoke(5).setUnlocalizedName("gvcr2_item_request_light")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_light").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Smoke am = (ItemRequest_Smoke) mod.gvcr2_item_request_light;
				am.information1 = "gvcr2.string.item.request_4.name";
				am.information2 = "gvcr2.string.item.request_5.name";
				am.information3 = "gvcr2.string.item.request_6.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_light);
		    
		    mod.gvcr2_item_request_airborne1	= new ItemRequest_Smoke(6).setUnlocalizedName("gvcr2_item_request_airborne1")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_airborne1").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Smoke am = (ItemRequest_Smoke) mod.gvcr2_item_request_airborne1;
				am.information1 = "gvcr2.string.item.request_4.name";
				am.information2 = "gvcr2.string.item.request_5.name";
				am.information3 = "gvcr2.string.item.request_6.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_airborne1);
		    mod.gvcr2_item_request_airborne2	= new ItemRequest_Smoke(7).setUnlocalizedName("gvcr2_item_request_airborne2")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_airborne2").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Smoke am = (ItemRequest_Smoke) mod.gvcr2_item_request_airborne2;
				am.information1 = "gvcr2.string.item.request_4.name";
				am.information2 = "gvcr2.string.item.request_5.name";
				am.information3 = "gvcr2.string.item.request_6.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_airborne2);
		    
		    mod.gvcr2_item_request_airborne3	= new ItemRequest_Smoke(8).setUnlocalizedName("gvcr2_item_request_airborne3")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_airborne3").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Smoke am = (ItemRequest_Smoke) mod.gvcr2_item_request_airborne3;
				am.information1 = "gvcr2.string.item.request_4.name";
				am.information2 = "gvcr2.string.item.request_5.name";
				am.information3 = "gvcr2.string.item.request_6.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_airborne3);
		    
		    
		    
		    
		    
		    mod.gvcr2_item_request_support_fighter1	= new ItemRequest_Remocon(1).setUnlocalizedName("gvcr2_item_request_support_fighter1")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_support_fighter1").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Remocon am = (ItemRequest_Remocon) mod.gvcr2_item_request_support_fighter1;
				am.information1 = "gvcr2.string.item.request_7.name";
				am.information2 = "gvcr2.string.item.request_8.name";
				am.information3 = "gvcr2.string.item.request_9.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_support_fighter1);
		    
		    mod.gvcr2_item_request_support_fighter2	= new ItemRequest_Remocon(2).setUnlocalizedName("gvcr2_item_request_support_fighter2")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_support_fighter2").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Remocon am = (ItemRequest_Remocon) mod.gvcr2_item_request_support_fighter2;
				am.information1 = "gvcr2.string.item.request_7.name";
				am.information2 = "gvcr2.string.item.request_8.name";
				am.information3 = "gvcr2.string.item.request_9.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_support_fighter2);
		    
		    mod.gvcr2_item_request_support_fighter3	= new ItemRequest_Remocon(3).setUnlocalizedName("gvcr2_item_request_support_fighter3")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_support_fighter3").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Remocon am = (ItemRequest_Remocon) mod.gvcr2_item_request_support_fighter3;
				am.information1 = "gvcr2.string.item.request_7.name";
				am.information2 = "gvcr2.string.item.request_8.name";
				am.information3 = "gvcr2.string.item.request_9.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_support_fighter3);
		    
		    mod.gvcr2_item_request_support_heli1	= new ItemRequest_Remocon(4).setUnlocalizedName("gvcr2_item_request_support_heli1")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_support_heli1").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Remocon am = (ItemRequest_Remocon) mod.gvcr2_item_request_support_heli1;
				am.information1 = "gvcr2.string.item.request_7.name";
				am.information2 = "gvcr2.string.item.request_8.name";
				am.information3 = "gvcr2.string.item.request_9.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_support_heli1);
		    
		    mod.gvcr2_item_request_support_heli2	= new ItemRequest_Remocon(5).setUnlocalizedName("gvcr2_item_request_support_heli2")
					.setRegistryName(mod.MOD_ID, "gvcr2_item_request_support_heli2").setCreativeTab(mod.tab_gun);
			{
				ItemRequest_Remocon am = (ItemRequest_Remocon) mod.gvcr2_item_request_support_heli2;
				am.information1 = "gvcr2.string.item.request_7.name";
				am.information2 = "gvcr2.string.item.request_8.name";
				am.information3 = "gvcr2.string.item.request_9.name";
			}
		    event.getRegistry().register(mod.gvcr2_item_request_support_heli2);
		    
		}
		
		
		
		
	}
}

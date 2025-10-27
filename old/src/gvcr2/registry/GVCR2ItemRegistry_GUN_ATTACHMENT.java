package gvcr2.registry;

import gvclib.LoadAttachmentStausBase;
import gvclib.item.ItemAttachment;
import gvcr2.mod_GVCR2;
import gvcr2.item.ItemGVC;
import gvcr2.item.ItemInv_Scenario;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import objmodel.AdvancedModelLoader;

public class GVCR2ItemRegistry_GUN_ATTACHMENT {
	public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Item> event){
		{
			mod.gvcr2_am_dotsight	= new ItemAttachment().setUnlocalizedName("gvcr2_am_dotsight").setMaxStackSize(64)
					.setRegistryName(mod.MOD_ID, "gvcr2_am_dotsight").setCreativeTab(mod.tab_item);
		    {
		    	ItemAttachment am = (ItemAttachment) mod.gvcr2_am_dotsight;
		    	am.objtrue = true;
		    	am.id = 101;
		    	if (mod.proxy.getClient()) {
		    		
		    		am.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/attachment/am_dotsight.mqo"));
		    	}
		    	am.obj_model_string = "am_dotsight.mqo";
		    	am.obj_tex = "gvcr2:textures/attachment/am_dotsight.png";
		    	am.zoom = 1.2F;
				am.x = 0F;
				am.y = 0.35F;
				am.z = 0F;
				LoadAttachmentStausBase.load(am, event);
			}
		    event.getRegistry().register(mod.gvcr2_am_dotsight);
		}
		{
			mod.gvcr2_am_compm4	= new ItemAttachment().setUnlocalizedName("gvcr2_am_compm4").setMaxStackSize(64)
					.setRegistryName(mod.MOD_ID, "gvcr2_am_compm4").setCreativeTab(mod.tab_item);
		    {
		    	ItemAttachment am = (ItemAttachment) mod.gvcr2_am_compm4;
		    	am.objtrue = true;
		    	am.id = 101;
		    	if (mod.proxy.getClient()) {
		    		
		    		am.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/attachment/am_compm4.mqo"));
		    	}
		    	am.obj_model_string = "am_compm4.mqo";
		    	am.obj_tex = "gvcr2:textures/attachment/am_compm4.png";
		    	am.zoom = 1.2F;
				am.x = 0F;
				am.y = 0.35F;
				am.z = 0F;
				LoadAttachmentStausBase.load(am, event);
			}
		    event.getRegistry().register(mod.gvcr2_am_compm4);
		}
		{
			mod.gvcr2_am_coyote	= new ItemAttachment().setUnlocalizedName("gvcr2_am_coyote").setMaxStackSize(64)
					.setRegistryName(mod.MOD_ID, "gvcr2_am_coyote").setCreativeTab(mod.tab_item);
		    {
		    	ItemAttachment am = (ItemAttachment) mod.gvcr2_am_coyote;
		    	am.objtrue = true;
		    	am.id = 101;
		    	if (mod.proxy.getClient()) {
		    		
		    		am.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/attachment/am_coyote.mqo"));
		    	}
		    	am.obj_model_string = "am_coyote.mqo";
		    	am.obj_tex = "gvcr2:textures/attachment/am_coyote.png";
		    	am.zoom = 1.2F;
				am.x = 0F;
				am.y = 0.325F;
				am.z = 0F;
				LoadAttachmentStausBase.load(am, event);
			}
		    event.getRegistry().register(mod.gvcr2_am_coyote);
		}
		{
			mod.gvcr2_am_horo	= new ItemAttachment().setUnlocalizedName("gvcr2_am_horo").setMaxStackSize(64)
					.setRegistryName(mod.MOD_ID, "gvcr2_am_horo").setCreativeTab(mod.tab_item);
		    {
		    	ItemAttachment am = (ItemAttachment) mod.gvcr2_am_horo;
		    	am.objtrue = true;
		    	am.id = 101;
		    	if (mod.proxy.getClient()) {
		    		
		    		am.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/attachment/am_horo.mqo"));
		    	}
		    	am.obj_model_string = "am_horo.mqo";
		    	am.obj_tex = "gvcr2:textures/attachment/am_horo.png";
		    	am.zoom = 1.2F;
				am.x = 0F;
				am.y = 0.325F;
				am.z = 0F;
				LoadAttachmentStausBase.load(am, event);
			}
		    event.getRegistry().register(mod.gvcr2_am_horo);
		}
		{
			mod.gvcr2_am_kobra	= new ItemAttachment().setUnlocalizedName("gvcr2_am_kobra").setMaxStackSize(64)
					.setRegistryName(mod.MOD_ID, "gvcr2_am_kobra").setCreativeTab(mod.tab_item);
		    {
		    	ItemAttachment am = (ItemAttachment) mod.gvcr2_am_kobra;
		    	am.objtrue = true;
		    	am.id = 101;
		    	if (mod.proxy.getClient()) {
		    		
		    		am.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/attachment/am_kobra.mqo"));
		    	}
		    	am.obj_model_string = "am_kobra.mqo";
		    	am.obj_tex = "gvcr2:textures/attachment/am_kobra.png";
		    	am.zoom = 1.2F;
				am.x = 0F;
				am.y = 0.35F;
				am.z = 0F;
				LoadAttachmentStausBase.load(am, event);
			}
		    event.getRegistry().register(mod.gvcr2_am_kobra);
		}
		{
			mod.gvcr2_am_micro	= new ItemAttachment().setUnlocalizedName("gvcr2_am_micro").setMaxStackSize(64)
					.setRegistryName(mod.MOD_ID, "gvcr2_am_micro").setCreativeTab(mod.tab_item);
		    {
		    	ItemAttachment am = (ItemAttachment) mod.gvcr2_am_micro;
		    	am.objtrue = true;
		    	am.id = 101;
		    	if (mod.proxy.getClient()) {
		    		
		    		am.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/attachment/am_micro.mqo"));
		    	}
		    	am.obj_model_string = "am_micro.mqo";
		    	am.obj_tex = "gvcr2:textures/attachment/am_micro.png";
		    	am.zoom = 1.2F;
				am.x = 0F;
				am.y = 0.15F;
				am.z = 0F;
				LoadAttachmentStausBase.load(am, event);
			}
		    event.getRegistry().register(mod.gvcr2_am_micro);
		}
		
		{
			mod.gvcr2_am_acog	= new ItemAttachment().setUnlocalizedName("gvcr2_am_acog").setMaxStackSize(64)
					.setRegistryName(mod.MOD_ID, "gvcr2_am_acog").setCreativeTab(mod.tab_item);
		    {
		    	ItemAttachment am = (ItemAttachment) mod.gvcr2_am_acog;
		    	am.objtrue = true;
		    	am.id = 101;
		    	if (mod.proxy.getClient()) {
		    		
		    		am.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/attachment/am_acog.mqo"));
		    	}
		    	am.obj_model_string = "am_acog.mqo";
		    	am.obj_tex = "gvcr2:textures/attachment/am_acog.png";
		    	am.zoom = 3.4F;
		    	am.eye_relief = - 1.75F;
				am.x = 0F;
				am.y = 0.35F;
				am.z = 0F;
				LoadAttachmentStausBase.load(am, event);
			}
		    event.getRegistry().register(mod.gvcr2_am_acog);
		}
		{
			mod.gvcr2_am_m145	= new ItemAttachment().setUnlocalizedName("gvcr2_am_m145").setMaxStackSize(64)
					.setRegistryName(mod.MOD_ID, "gvcr2_am_m145").setCreativeTab(mod.tab_item);
		    {
		    	ItemAttachment am = (ItemAttachment) mod.gvcr2_am_m145;
		    	am.objtrue = true;
		    	am.id = 101;
		    	if (mod.proxy.getClient()) {
		    		
		    		am.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/attachment/am_m145.mqo"));
		    	}
		    	am.obj_model_string = "am_m145.mqo";
		    	am.obj_tex = "gvcr2:textures/attachment/am_m145.png";
		    	am.zoom = 3.4F;
		    	am.eye_relief = - 1.75F;
				am.x = 0F;
				am.y = 0.35F;
				am.z = 0F;
				LoadAttachmentStausBase.load(am, event);
			}
		    event.getRegistry().register(mod.gvcr2_am_m145);
		}
		{
			mod.gvcr2_am_scope	= new ItemAttachment().setUnlocalizedName("gvcr2_am_scope").setMaxStackSize(64)
					.setRegistryName(mod.MOD_ID, "gvcr2_am_scope").setCreativeTab(mod.tab_item);
		    {
		    	ItemAttachment am = (ItemAttachment) mod.gvcr2_am_scope;
		    	am.objtrue = true;
		    	am.id = 101;
		    	if (mod.proxy.getClient()) {
		    		
		    		am.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/attachment/am_scope.mqo"));
		    	}
		    	am.obj_model_string = "am_scope.mqo";
		    	am.obj_tex = "gvcr2:textures/attachment/am_scope.png";
		    	am.ads_tex = "gvcr2:textures/misc/scope.png";
		    	am.zoomrender = false;
		    	am.zoomrendertex = true;
		    	am.zoom = 6F;
				am.x = 0F;
				am.y = 0.325F;
				am.z = 0F;
				LoadAttachmentStausBase.load(am, event);
			}
		    event.getRegistry().register(mod.gvcr2_am_scope);
		}
		
		
		
		
		{
			mod.gvcr2_am_lasersight	= new ItemAttachment().setUnlocalizedName("gvcr2_am_lasersight").setMaxStackSize(64)
					.setRegistryName(mod.MOD_ID, "gvcr2_am_lasersight").setCreativeTab(mod.tab_item);
		    {
		    	ItemAttachment am = (ItemAttachment) mod.gvcr2_am_lasersight;
		    	am.objtrue = true;
		    	am.id = 102;
		    	if (mod.proxy.getClient()) {
		    		am.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/attachment/am_lasersight.mqo"));
		    	}
		    	am.obj_model_string = "am_lasersight.mqo";
		    	am.obj_tex = "gvcr2:textures/attachment/am_lasersight.png";
		    	am.colorlevel[0] = 0.4F;
		    	am.colorlevel[1] = 0.2F;
		    	am.light_kazu = 2;
		    	LoadAttachmentStausBase.load(am, event);
			}
		    event.getRegistry().register(mod.gvcr2_am_lasersight);
		}
		{
			mod.gvcr2_am_flashlight	= new ItemAttachment().setUnlocalizedName("gvcr2_am_flashlight").setMaxStackSize(64)
					.setRegistryName(mod.MOD_ID, "gvcr2_am_flashlight").setCreativeTab(mod.tab_item);
		    {
		    	ItemAttachment am = (ItemAttachment) mod.gvcr2_am_flashlight;
		    	am.objtrue = true;
		    	am.id = 102;
		    	if (mod.proxy.getClient()) {
		    		am.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/attachment/am_flashlight.mqo"));
		    	}
		    	am.obj_model_string = "am_flashlight.mqo";
		    	am.obj_tex = "gvcr2:textures/attachment/am_flashlight.png";
		    	am.colorlevel[0] = 0.2F;
		    	am.light_kazu = 1;
		    	LoadAttachmentStausBase.load(am, event);
			}
		    event.getRegistry().register(mod.gvcr2_am_flashlight);
		}
		
		{
			mod.gvcr2_am_suppressor	= new ItemAttachment().setUnlocalizedName("gvcr2_am_suppressor").setMaxStackSize(64)
					.setRegistryName(mod.MOD_ID, "gvcr2_am_suppressor").setCreativeTab(mod.tab_item);
		    {
		    	ItemAttachment am = (ItemAttachment) mod.gvcr2_am_suppressor;
		    	am.objtrue = true;
		    	am.id = 8;
		    	if (mod.proxy.getClient()) {
		    		am.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/attachment/am_suppressor.mqo"));
		    	}
		    	am.obj_model_string = "am_suppressor.mqo";
		    	am.obj_tex = "gvcr2:textures/attachment/am_suppressor.png";
		    	LoadAttachmentStausBase.load(am, event);
			}
		    event.getRegistry().register(mod.gvcr2_am_suppressor);
		}
		
		{
			mod.gvcr2_am_grip	= new ItemAttachment().setUnlocalizedName("gvcr2_am_grip").setMaxStackSize(64)
					.setRegistryName(mod.MOD_ID, "gvcr2_am_grip").setCreativeTab(mod.tab_item);
		    {
		    	ItemAttachment am = (ItemAttachment) mod.gvcr2_am_grip;
		    	am.objtrue = true;
		    	am.id = 9;
		    	if (mod.proxy.getClient()) {
		    		
		    		am.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/attachment/am_grip.mqo"));
		    	}
		    	am.obj_model_string = "am_grip.mqo";
		    	am.obj_tex = "gvcr2:textures/attachment/am_grip.png";
		    	am.recoil = 1.0;
				am.recoil_ads = 0.75;
				am.bure = 1.0F;
				am.bure_ads = 0.75F;
				
				am.grip_gripping_point = true;
				am.grip_gripping_point_x = 0;
				am.grip_gripping_point_y = -0.80F;
				am.grip_gripping_point_z = 0;
				LoadAttachmentStausBase.load(am, event);
			}
		    event.getRegistry().register(mod.gvcr2_am_grip);
		}
		{
			mod.gvcr2_am_anglegrip	= new ItemAttachment().setUnlocalizedName("gvcr2_am_anglegrip").setMaxStackSize(64)
					.setRegistryName(mod.MOD_ID, "gvcr2_am_anglegrip").setCreativeTab(mod.tab_item);
		    {
		    	ItemAttachment am = (ItemAttachment) mod.gvcr2_am_anglegrip;
		    	am.objtrue = true;
		    	am.id = 9;
		    	if (mod.proxy.getClient()) {
		    		
		    		am.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/attachment/am_anglegrip.mqo"));
		    	}
		    	am.obj_model_string = "am_anglegrip.mqo";
		    	am.obj_tex = "gvcr2:textures/attachment/am_anglegrip.png";
		    	am.recoil = 0.75;
				am.recoil_ads = 1;
				am.bure = 0.75F;
				am.bure_ads = 1F;
				
				am.grip_gripping_point = true;
				am.grip_gripping_point_x = 0;
				am.grip_gripping_point_y = -0.7F;
				am.grip_gripping_point_z = -0.3F;
				LoadAttachmentStausBase.load(am, event);
			}
		    event.getRegistry().register(mod.gvcr2_am_anglegrip);
		}
		{
			mod.gvcr2_am_bipod	= new ItemAttachment().setUnlocalizedName("gvcr2_am_bipod").setMaxStackSize(64)
					.setRegistryName(mod.MOD_ID, "gvcr2_am_bipod").setCreativeTab(mod.tab_item);
		    {
		    	ItemAttachment am = (ItemAttachment) mod.gvcr2_am_bipod;
		    	am.objtrue = true;
		    	am.id = 9;
		    	if (mod.proxy.getClient()) {
		    		
		    		am.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/attachment/am_bipod.mqo"));
		    	}
		    	am.obj_model_string = "am_bipod.mqo";
		    	am.obj_tex = "gvcr2:textures/attachment/am_bipod.png";
		    	am.recoil = 1.25;
				am.recoil_ads = 0.1;
				am.bure = 1.25F;
				am.bure_ads = 1.0F;
				am.grip_gripping_point = false;
				LoadAttachmentStausBase.load(am, event);
			}
		    event.getRegistry().register(mod.gvcr2_am_bipod);
		}
		{
			mod.gvcr2_am_gripod	= new ItemAttachment().setUnlocalizedName("gvcr2_am_gripod").setMaxStackSize(64)
					.setRegistryName(mod.MOD_ID, "gvcr2_am_gripod").setCreativeTab(mod.tab_item);
		    {
		    	ItemAttachment am = (ItemAttachment) mod.gvcr2_am_gripod;
		    	am.objtrue = true;
		    	am.id = 9;
		    	if (mod.proxy.getClient()) {
		    		
		    		am.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/attachment/am_gripod.mqo"));
		    	}
		    	am.obj_model_string = "am_gripod.mqo";
		    	am.obj_tex = "gvcr2:textures/attachment/am_gripod.png";
		    	am.recoil = 1.1;
				am.recoil_ads = 0.3;
				am.bure = 1.1F;
				am.bure_ads = 0.75F;
				
				am.grip_gripping_point = true;
				am.grip_gripping_point_x = 0;
				am.grip_gripping_point_y = -0.825F;
				am.grip_gripping_point_z = 0;
				LoadAttachmentStausBase.load(am, event);
			}
		    event.getRegistry().register(mod.gvcr2_am_gripod);
		}
		
		{
			mod.gvcr2_am_bullet_ap	= new ItemAttachment().setUnlocalizedName("gvcr2_am_bullet_ap").setMaxStackSize(64)
					.setCreativeTab(mod.tab_item)
	        		.setRegistryName(mod.MOD_ID, "gvcr2_am_bullet_ap");
			{
				ItemAttachment am = (ItemAttachment) mod.gvcr2_am_bullet_ap;
				if (mod.proxy.getClient()) {
		    		
		    	}
				am.id = 50;
				am.power = 0.75F;
				am.pellet = 1;
				am.exlevel = 0;
				am.bulletid = 1;
				am.bullet_name = "AP";
			}
			event.getRegistry().register(mod.gvcr2_am_bullet_ap);
		}
		
		{
			mod.gvcr2_am_bullet_hp	= new ItemAttachment().setUnlocalizedName("gvcr2_am_bullet_hp").setMaxStackSize(64)
					.setCreativeTab(mod.tab_item)
	        		.setRegistryName(mod.MOD_ID, "gvcr2_am_bullet_hp");
			{
				ItemAttachment am = (ItemAttachment) mod.gvcr2_am_bullet_hp;
				if (mod.proxy.getClient()) {
		    		
		    	}
				am.id = 50;
				am.power = 1.5F;
				am.pellet = 1;
				am.exlevel = 0;
				am.bulletid = 0;
				am.bure = 1.5F;
				am.bure_ads = 1.5F;
				am.bullet_name = "HP";
			}
			event.getRegistry().register(mod.gvcr2_am_bullet_hp);
		}
		
		{
			mod.gvcr2_am_bullet_at	= new ItemAttachment().setUnlocalizedName("gvcr2_am_bullet_at").setMaxStackSize(64)
					.setCreativeTab(mod.tab_item)
	        		.setRegistryName(mod.MOD_ID, "gvcr2_am_bullet_at");
			{
				ItemAttachment am = (ItemAttachment) mod.gvcr2_am_bullet_at;
				if (mod.proxy.getClient()) {
		    		
		    	}
				am.id = 50;
				am.power = 0.01F;
				am.pellet = 1;
				am.exlevel = 0;
				am.bulletid = 0;
				am.p_id = 2;
				am.p_level = 10;
				am.p_time = 200;
				am.bure = 1.0F;
				am.bure_ads = 1.0F;
				am.bullet_name = "AT";
			}
			event.getRegistry().register(mod.gvcr2_am_bullet_at);
		}
		
		{
			mod.gvcr2_am_bullet_srag	= new ItemAttachment().setUnlocalizedName("gvcr2_am_bullet_srag").setMaxStackSize(64)
					.setCreativeTab(mod.tab_item)
	        		.setRegistryName(mod.MOD_ID, "gvcr2_am_bullet_srag");
			{
				ItemAttachment am = (ItemAttachment) mod.gvcr2_am_bullet_srag;
				if (mod.proxy.getClient()) {
		    		
		    	}
				am.id = 50;
				am.power = 14.00F;
				am.pellet = 1;
				am.exlevel = 0;
				am.bure = 0.25F;
				am.bure_ads = 0.25F;
				am.bullet_name = "Srag";
			}
			event.getRegistry().register(mod.gvcr2_am_bullet_srag);
		}
		
		{
			mod.gvcr2_am_bullet_frag	= new ItemAttachment().setUnlocalizedName("gvcr2_am_bullet_frag").setMaxStackSize(64)
					.setCreativeTab(mod.tab_item)
	        		.setRegistryName(mod.MOD_ID, "gvcr2_am_bullet_frag");
			{
				ItemAttachment am = (ItemAttachment) mod.gvcr2_am_bullet_frag;
				if (mod.proxy.getClient()) {
		    		
		    	}
				am.id = 50;
				am.power = 1.8F;
				am.pellet = 1;
				am.exlevel = 1.9F;
				am.bure = 0.25F;
				am.bure_ads = 0.25F;
				am.bullet_name = "Frag";
			}
			event.getRegistry().register(mod.gvcr2_am_bullet_frag);
		}
		
		{
			mod.gvcr2_am_bullet_db	= new ItemAttachment().setUnlocalizedName("gvcr2_am_bullet_db").setMaxStackSize(64)
					.setCreativeTab(mod.tab_item)
	        		.setRegistryName(mod.MOD_ID, "gvcr2_am_bullet_db");
			{
				ItemAttachment am = (ItemAttachment) mod.gvcr2_am_bullet_db;
				if (mod.proxy.getClient()) {
		    		
		    	}
				am.id = 50;
				am.power = 0.75F;
				am.bulletid = 6;
				am.pellet_priority = true;
				am.pellet = 16;
				am.exlevel = 0;
				am.bure = 1.0F;
				am.bure_ads = 1.0F;
				am.bullet_name = "D_Breath";
			}
			event.getRegistry().register(mod.gvcr2_am_bullet_db);
		}
		
		
		
		
		{
			mod.gvcr2_item_inv_infantry_1	= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_infantry_1").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_infantry_1").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_infantry_1);
		    
		    mod.gun_eme_1[mod.gun_id_1] = 8;
	    	mod.gun_iron_1[mod.gun_id_1] = 8;
	    	mod.gun_red_1[mod.gun_id_1] = 8;
	    	mod.gun_item_1[mod.gun_id_1] = mod.gvcr2_item_inv_infantry_1;
			++mod.gun_id_1;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_infantry_1;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		{
			mod.gvcr2_item_inv_infantry_2	= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_infantry_2").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_infantry_2").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_infantry_2);
		    mod.gun_eme_2[mod.gun_id_2] = 8;
	    	mod.gun_iron_2[mod.gun_id_2] = 8;
	    	mod.gun_red_2[mod.gun_id_2] = 8;
	    	mod.gun_item_2[mod.gun_id_2] = mod.gvcr2_item_inv_infantry_2;
			++mod.gun_id_2;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_infantry_2;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		{
			mod.gvcr2_item_inv_infantry_3= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_infantry_3").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_infantry_3").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_infantry_3);
		    mod.gun_eme_3[mod.gun_id_3] = 8;
	    	mod.gun_iron_3[mod.gun_id_3] = 8;
	    	mod.gun_red_3[mod.gun_id_3] = 8;
	    	mod.gun_item_3[mod.gun_id_3] = mod.gvcr2_item_inv_infantry_3;
			++mod.gun_id_3;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_infantry_3;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		{
			mod.gvcr2_item_inv_infantry_4= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_infantry_4").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_infantry_4").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_infantry_4);
		    mod.gun_eme_3[mod.gun_id_3] = 16;
	    	mod.gun_iron_3[mod.gun_id_3] = 16;
	    	mod.gun_red_3[mod.gun_id_3] = 16;
	    	mod.gun_item_3[mod.gun_id_3] = mod.gvcr2_item_inv_infantry_4;
			++mod.gun_id_3;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_infantry_4;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		
		
		
		
		{
			mod.gvcr2_item_inv_normal_1	= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_normal_1").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_normal_1").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_normal_1);
		    
		    mod.gun_eme_1[mod.gun_id_1] = 8;
	    	mod.gun_iron_1[mod.gun_id_1] = 8;
	    	mod.gun_red_1[mod.gun_id_1] = 8;
	    	mod.gun_item_1[mod.gun_id_1] = mod.gvcr2_item_inv_normal_1;
			++mod.gun_id_1;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_normal_1;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		{
			mod.gvcr2_item_inv_normal_2	= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_normal_2").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_normal_2").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_normal_2);
		    mod.gun_eme_2[mod.gun_id_2] = 8;
	    	mod.gun_iron_2[mod.gun_id_2] = 8;
	    	mod.gun_red_2[mod.gun_id_2] = 8;
	    	mod.gun_item_2[mod.gun_id_2] = mod.gvcr2_item_inv_normal_2;
			++mod.gun_id_2;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_normal_2;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		{
			mod.gvcr2_item_inv_normal_3= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_normal_3").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_normal_3").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_normal_3);
		    mod.gun_eme_3[mod.gun_id_3] = 8;
	    	mod.gun_iron_3[mod.gun_id_3] = 8;
	    	mod.gun_red_3[mod.gun_id_3] = 8;
	    	mod.gun_item_3[mod.gun_id_3] = mod.gvcr2_item_inv_normal_3;
			++mod.gun_id_3;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_normal_3;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		{
			mod.gvcr2_item_inv_normal_4= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_normal_4").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_normal_4").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_normal_4);
		    mod.gun_eme_3[mod.gun_id_3] = 16;
	    	mod.gun_iron_3[mod.gun_id_3] = 16;
	    	mod.gun_red_3[mod.gun_id_3] = 16;
	    	mod.gun_item_3[mod.gun_id_3] = mod.gvcr2_item_inv_normal_4;
			++mod.gun_id_3;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_normal_4;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		
		{
			mod.gvcr2_item_inv_tank_1	= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_tank_1").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_tank_1").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_tank_1);
		    mod.gun_eme_1[mod.gun_id_1] = 8;
	    	mod.gun_iron_1[mod.gun_id_1] = 8;
	    	mod.gun_red_1[mod.gun_id_1] = 8;
	    	mod.gun_item_1[mod.gun_id_1] = mod.gvcr2_item_inv_tank_1;
			++mod.gun_id_1;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_tank_1;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		{
			mod.gvcr2_item_inv_tank_2	= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_tank_2").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_tank_2").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_tank_2);
		    mod.gun_eme_2[mod.gun_id_2] = 8;
	    	mod.gun_iron_2[mod.gun_id_2] = 8;
	    	mod.gun_red_2[mod.gun_id_2] = 8;
	    	mod.gun_item_2[mod.gun_id_2] = mod.gvcr2_item_inv_tank_2;
			++mod.gun_id_2;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_tank_2;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		{
			mod.gvcr2_item_inv_tank_3= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_tank_3").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_tank_3").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_tank_3);
		    mod.gun_eme_3[mod.gun_id_3] = 8;
	    	mod.gun_iron_3[mod.gun_id_3] = 8;
	    	mod.gun_red_3[mod.gun_id_3] = 8;
	    	mod.gun_item_3[mod.gun_id_3] = mod.gvcr2_item_inv_tank_3;
			++mod.gun_id_3;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_tank_3;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		{
			mod.gvcr2_item_inv_tank_4= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_tank_4").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_tank_4");
		    event.getRegistry().register(mod.gvcr2_item_inv_tank_4);
		    mod.gun_eme_3[mod.gun_id_3] = 16;
	    	mod.gun_iron_3[mod.gun_id_3] = 16;
	    	mod.gun_red_3[mod.gun_id_3] = 16;
	    	mod.gun_item_3[mod.gun_id_3] = mod.gvcr2_item_inv_tank_4;
			++mod.gun_id_3;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_tank_4;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		
		
		{
			mod.gvcr2_item_inv_dogfight_1	= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_dogfight_1").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_dogfight_1").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_dogfight_1);
		    mod.gun_eme_1[mod.gun_id_1] = 8;
	    	mod.gun_iron_1[mod.gun_id_1] = 8;
	    	mod.gun_red_1[mod.gun_id_1] = 8;
	    	mod.gun_item_1[mod.gun_id_1] = mod.gvcr2_item_inv_dogfight_1;
			++mod.gun_id_1;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_dogfight_1;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		{
			mod.gvcr2_item_inv_dogfight_2	= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_dogfight_2").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_dogfight_2").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_dogfight_2);
		    mod.gun_eme_2[mod.gun_id_2] = 8;
	    	mod.gun_iron_2[mod.gun_id_2] = 8;
	    	mod.gun_red_2[mod.gun_id_2] = 8;
	    	mod.gun_item_2[mod.gun_id_2] = mod.gvcr2_item_inv_dogfight_2;
			++mod.gun_id_2;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_dogfight_2;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		{
			mod.gvcr2_item_inv_dogfight_3= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_dogfight_3").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_dogfight_3").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_dogfight_3);
		    mod.gun_eme_3[mod.gun_id_3] = 8;
	    	mod.gun_iron_3[mod.gun_id_3] = 8;
	    	mod.gun_red_3[mod.gun_id_3] = 8;
	    	mod.gun_item_3[mod.gun_id_3] = mod.gvcr2_item_inv_dogfight_3;
			++mod.gun_id_3;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_dogfight_3;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		{
			mod.gvcr2_item_inv_dogfight_4= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_dogfight_4").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_dogfight_4");
		    event.getRegistry().register(mod.gvcr2_item_inv_dogfight_4);
		    mod.gun_eme_3[mod.gun_id_3] = 16;
	    	mod.gun_iron_3[mod.gun_id_3] = 16;
	    	mod.gun_red_3[mod.gun_id_3] = 16;
	    	mod.gun_item_3[mod.gun_id_3] = mod.gvcr2_item_inv_dogfight_4;
			++mod.gun_id_3;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_dogfight_4;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		
		{
			mod.gvcr2_item_inv_airborne_1	= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_airborne_1").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_airborne_1").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_airborne_1);
		    mod.gun_eme_1[mod.gun_id_1] = 8;
	    	mod.gun_iron_1[mod.gun_id_1] = 8;
	    	mod.gun_red_1[mod.gun_id_1] = 8;
	    	mod.gun_item_1[mod.gun_id_1] = mod.gvcr2_item_inv_airborne_1;
			++mod.gun_id_1;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_airborne_1;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		{
			mod.gvcr2_item_inv_airborne_2	= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_airborne_2").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_airborne_2").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_airborne_2);
		    mod.gun_eme_2[mod.gun_id_2] = 8;
	    	mod.gun_iron_2[mod.gun_id_2] = 8;
	    	mod.gun_red_2[mod.gun_id_2] = 8;
	    	mod.gun_item_2[mod.gun_id_2] = mod.gvcr2_item_inv_airborne_2;
			++mod.gun_id_2;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_airborne_2;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		{
			mod.gvcr2_item_inv_airborne_3= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_airborne_3").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_airborne_3").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_airborne_3);
		    mod.gun_eme_3[mod.gun_id_3] = 8;
	    	mod.gun_iron_3[mod.gun_id_3] = 8;
	    	mod.gun_red_3[mod.gun_id_3] = 8;
	    	mod.gun_item_3[mod.gun_id_3] = mod.gvcr2_item_inv_airborne_3;
			++mod.gun_id_3;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_airborne_3;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
		{
			mod.gvcr2_item_inv_airborne_4= new ItemInv_Scenario().setUnlocalizedName("gvcr2_item_inv_airborne_4").setMaxStackSize(1)
					.setRegistryName(mod.MOD_ID, "gvcr2_item_inv_airborne_4").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_item_inv_airborne_4);
		    mod.gun_eme_3[mod.gun_id_3] = 16;
	    	mod.gun_iron_3[mod.gun_id_3] = 16;
	    	mod.gun_red_3[mod.gun_id_3] = 16;
	    	mod.gun_item_3[mod.gun_id_3] = mod.gvcr2_item_inv_airborne_4;
			++mod.gun_id_3;
			{
				ItemInv_Scenario spawn = (ItemInv_Scenario) mod.gvcr2_item_inv_airborne_4;
				spawn.text1 = "gvcr2.string.inv.text1.name";
				spawn.text2 = "gvcr2.string.inv.text2.name";
				spawn.text3 = "gvcr2.string.inv.text3.name";
		    }
		}
	}
}

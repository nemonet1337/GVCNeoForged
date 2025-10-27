package gvcr2.registry;

import gvclib.item.ItemArmor_Base;
import gvclib.item.ItemArmor_NewObj;
import gvclib.item.ItemArmor_camouflage;
import gvclib.item.ItemGunBase;
import gvclib.item.ItemGun_AR;
import gvcr2.mod_GVCR2;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import objmodel.AdvancedModelLoader;

public class GVCR2ItemRegistry_GUN_ARMOR {
	public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Item> event){
		//
		{
			ArmorMaterial armormate = EnumHelper.addArmorMaterial("gvcr2_armor_gasmask", "gvcr2:textures/armor/gasmask.png", 
					 2000, new int[] {1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
			mod.gvcr2_armor_gasmask	= new ItemArmor_NewObj(armormate, EntityEquipmentSlot.HEAD).setUnlocalizedName("gvcr2_armor_gasmask")
					.setRegistryName(mod.MOD_ID, "gvcr2_armor_gasmask").setCreativeTab(mod.tab_item);
			{
		    	ItemArmor_NewObj armor = (ItemArmor_NewObj)mod. gvcr2_armor_gasmask;
		    	if (mod.proxy.getClient()) {
			    	armor.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/armor/gasmask.mqo"));
			    	
			    }
		    	armor.obj_tex = "gvcr2:textures/armor/gasmask.png";
		    	armor.gazo = true;
		    	armor.tps = false;
		    	armor.gazotex = "gvcr2:textures/misc/armor_gas.png";
		    }
		    event.getRegistry().register(mod.gvcr2_armor_gasmask);
		}
		{
			ArmorMaterial armormate = EnumHelper.addArmorMaterial("gvcr2_armor_firemask", "gvcr2:textures/armor/firemask.png", 
					 2000, new int[] {1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
			mod.gvcr2_armor_firemask	= new ItemArmor_NewObj(armormate, EntityEquipmentSlot.HEAD).setUnlocalizedName("gvcr2_armor_firemask")
					.setRegistryName(mod.MOD_ID, "gvcr2_armor_firemask").setCreativeTab(mod.tab_item);
			{
		    	ItemArmor_NewObj armor = (ItemArmor_NewObj)mod. gvcr2_armor_firemask;
		    	if (mod.proxy.getClient()) {
			    	armor.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/armor/firemask.mqo"));
			    	
			    }
		    	armor.obj_tex = "gvcr2:textures/armor/firemask.png";
		    	armor.gazo = true;
		    	armor.tps = false;
		    	armor.gazotex = "gvcr2:textures/misc/armor_gas.png";
		    }
		    event.getRegistry().register(mod.gvcr2_armor_firemask);
		}
		{
			ArmorMaterial armormate = EnumHelper.addArmorMaterial("gvcr2_armor_trenchmask", "gvcr2:textures/armor/trenchmask.png", 
					 2000, new int[] {2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
			mod.gvcr2_armor_trenchmask	= new ItemArmor_NewObj(armormate, EntityEquipmentSlot.HEAD).setUnlocalizedName("gvcr2_armor_trenchmask")
					.setRegistryName(mod.MOD_ID, "gvcr2_armor_trenchmask").setCreativeTab(mod.tab_item);
			{
		    	ItemArmor_NewObj armor = (ItemArmor_NewObj)mod. gvcr2_armor_trenchmask;
		    	if (mod.proxy.getClient()) {
			    	armor.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/armor/trenchmask.mqo"));
			    	
			    }
		    	armor.obj_tex = "gvcr2:textures/armor/trenchmask.png";
		    }
		    event.getRegistry().register(mod.gvcr2_armor_trenchmask);
		    
		    mod.gvcr2_armor_trench_body	= new ItemArmor_Base(armormate, EntityEquipmentSlot.CHEST,
		    		"gvcr2:textures/armor/trench_layer_1.png","gvcr2:textures/armor/trench_layer_2.png")
		    		.setUnlocalizedName("gvcr2_armor_trench_body").setRegistryName(mod.MOD_ID, "gvcr2_armor_trench_body").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_armor_trench_body);
		    mod.gvcr2_armor_trench_leggings	= new ItemArmor_Base(armormate, EntityEquipmentSlot.LEGS,
		    		"gvcr2:textures/armor/trench_layer_1.png","gvcr2:textures/armor/trench_layer_2.png")
		    		.setUnlocalizedName("gvcr2_armor_trench_leggings").setRegistryName(mod.MOD_ID, "gvcr2_armor_trench_leggings").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_armor_trench_leggings);
		    mod.gvcr2_armor_trench_boots	= new ItemArmor_Base(armormate, EntityEquipmentSlot.FEET,
		    		"gvcr2:textures/armor/trench_layer_1.png","gvcr2:textures/armor/trench_layer_2.png")
		    		.setUnlocalizedName("gvcr2_armor_trench_boots").setRegistryName(mod.MOD_ID, "gvcr2_armor_trench_boots").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_armor_trench_boots);
		}
		{
			ArmorMaterial armormate = EnumHelper.addArmorMaterial("gvcr2_armor_tachanka", "gvcr2:textures/armor/tachanka.png", 
					 2000, new int[] {3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
			mod.gvcr2_armor_tachanka	= new ItemArmor_NewObj(armormate, EntityEquipmentSlot.HEAD).setUnlocalizedName("gvcr2_armor_tachanka")
					.setRegistryName(mod.MOD_ID, "gvcr2_armor_tachanka").setCreativeTab(mod.tab_item);
			{
		    	ItemArmor_NewObj armor = (ItemArmor_NewObj)mod. gvcr2_armor_tachanka;
		    	if (mod.proxy.getClient()) {
			    	armor.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/armor/tachanka.mqo"));
			    	
			    }
		    	armor.obj_tex = "gvcr2:textures/armor/tachanka.png";
		    	armor.gazo = true;
		    	armor.tps = false;
		    	armor.gazotex = "gvcr2:textures/misc/armor_mg.png";
		    }
		    event.getRegistry().register(mod.gvcr2_armor_tachanka);
		}
		
		{
			ArmorMaterial armormate = EnumHelper.addArmorMaterial("gvcr2_armor_parachute", "gvcr2:textures/armor/parachute.png", 
					 2000, new int[] {1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
			mod.gvcr2_armor_parachute	= new ItemArmor_NewObj(armormate, EntityEquipmentSlot.CHEST).setUnlocalizedName("gvcr2_armor_parachute")
					.setRegistryName(mod.MOD_ID, "gvcr2_armor_parachute").setCreativeTab(mod.tab_item);
			{
		    	ItemArmor_NewObj armor = (ItemArmor_NewObj)mod. gvcr2_armor_parachute;
		    	if (mod.proxy.getClient()) {
			    	armor.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/armor/parachute.mqo"));
			    	
			    }
		    	armor.obj_tex = "gvcr2:textures/armor/parachute.png";
		    	armor.para = true;
		    	armor.fall = true;
		    }
		    event.getRegistry().register(mod.gvcr2_armor_parachute);
		}
		{
			ArmorMaterial armormate = EnumHelper.addArmorMaterial("gvcr2_armor_pra", "gvcr2:textures/armor/praarmor_layer_1.png", 
					430, new int[] {4, 8, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
		    mod.gvcr2_armor_prahelmet	= new ItemArmor_Base(armormate, EntityEquipmentSlot.HEAD,
		    		"gvcr2:textures/armor/praarmor_layer_1.png","gvcr2:textures/armor/praarmor_layer_2.png")
		    		.setUnlocalizedName("gvcr2_armor_prahelmet").setRegistryName(mod.MOD_ID, "gvcr2_armor_prahelmet").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_armor_prahelmet);
		    mod.gvcr2_armor_prachest	= new ItemArmor_Base(armormate, EntityEquipmentSlot.CHEST,
		    		"gvcr2:textures/armor/praarmor_layer_1.png","gvcr2:textures/armor/praarmor_layer_2.png")
		    		.setUnlocalizedName("gvcr2_armor_prachest").setRegistryName(mod.MOD_ID, "gvcr2_armor_prachest").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_armor_prachest);
		    mod.gvcr2_armor_praleggings	= new ItemArmor_Base(armormate, EntityEquipmentSlot.LEGS,
		    		"gvcr2:textures/armor/praarmor_layer_1.png","gvcr2:textures/armor/praarmor_layer_2.png")
		    		.setUnlocalizedName("gvcr2_armor_praleggings").setRegistryName(mod.MOD_ID, "gvcr2_armor_praleggings").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_armor_praleggings);
		    mod.gvcr2_armor_praboots	= new ItemArmor_Base(armormate, EntityEquipmentSlot.FEET,
		    		"gvcr2:textures/armor/praarmor_layer_1.png","gvcr2:textures/armor/praarmor_layer_2.png")
		    		.setUnlocalizedName("gvcr2_armor_praboots").setRegistryName(mod.MOD_ID, "gvcr2_armor_praboots").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_armor_praboots);
		}
		
		{
			ArmorMaterial armormate = EnumHelper.addArmorMaterial("gvcr2_armor_camouflage", "gvcr2:textures/armor/camouflage_layer_1.png", 
					2000, new int[] {1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
		    mod.gvcr2_armor_camouflage_head	= new ItemArmor_camouflage(armormate, EntityEquipmentSlot.HEAD,
		    		"gvcr2:textures/armor/camouflage_layer_1","gvcr2:textures/armor/camouflage_layer_2")
		    		.setUnlocalizedName("gvcr2_armor_camouflage_head").setRegistryName(mod.MOD_ID, "gvcr2_armor_camouflage_head").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_armor_camouflage_head);
		    mod.gvcr2_armor_camouflage_body	= new ItemArmor_camouflage(armormate, EntityEquipmentSlot.CHEST,
		    		"gvcr2:textures/armor/camouflage_layer_1","gvcr2:textures/armor/camouflage_layer_2")
		    		.setUnlocalizedName("gvcr2_armor_camouflage_body").setRegistryName(mod.MOD_ID, "gvcr2_armor_camouflage_body").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_armor_camouflage_body);
		    mod.gvcr2_armor_camouflage_leggings	= new ItemArmor_camouflage(armormate, EntityEquipmentSlot.LEGS,
		    		"gvcr2:textures/armor/camouflage_layer_1","gvcr2:textures/armor/camouflage_layer_2")
		    		.setUnlocalizedName("gvcr2_armor_camouflage_leggings").setRegistryName(mod.MOD_ID, "gvcr2_armor_camouflage_leggings").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_armor_camouflage_leggings);
		    mod.gvcr2_armor_camouflage_boots	= new ItemArmor_camouflage(armormate, EntityEquipmentSlot.FEET,
		    		"gvcr2:textures/armor/camouflage_layer_1","gvcr2:textures/armor/camouflage_layer_2")
		    		.setUnlocalizedName("gvcr2_armor_camouflage_boots").setRegistryName(mod.MOD_ID, "gvcr2_armor_camouflage_boots").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_armor_camouflage_boots);
		}
		
		{
			ArmorMaterial armormate = EnumHelper.addArmorMaterial("gvcr2_armor_se", "gvcr2:textures/armor/searmor_layer_1.png", 
					430, new int[] {4, 8, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
		    mod.gvcr2_armor_sehelmet	= new ItemArmor_Base(armormate, EntityEquipmentSlot.HEAD,
		    		"gvcr2:textures/armor/searmor_layer_1.png","gvcr2:textures/armor/searmor_layer_2.png")
		    		.setUnlocalizedName("gvcr2_armor_sehelmet").setRegistryName(mod.MOD_ID, "gvcr2_armor_sehelmet").setCreativeTab(mod.tab_item);
		    event.getRegistry().register(mod.gvcr2_armor_sehelmet);
		    mod.gvcr2_armor_sechest	= new ItemArmor_NewObj(armormate, EntityEquipmentSlot.CHEST).setUnlocalizedName("gvcr2_armor_sechest")
					.setRegistryName(mod.MOD_ID, "gvcr2_armor_sechest").setCreativeTab(mod.tab_item);
		    {
		    	ItemArmor_NewObj armor = (ItemArmor_NewObj)mod. gvcr2_armor_sechest;
		    	if (mod.proxy.getClient()) {
			    	armor.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/armor/sechest.mqo"));
			    	
			    }
		    	armor.obj_tex = "gvcr2:textures/armor/sechest.png";
		    }
		    event.getRegistry().register(mod.gvcr2_armor_sechest); 
		}
		
		
		{
			ArmorMaterial armormate = EnumHelper.addArmorMaterial("gvcr2_armor_chest_rig", "gvcr2:textures/armor/chest_rig.png", 
					 2000, new int[] {4, 8, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
			mod.gvcr2_armor_chest_rig	= new ItemArmor_NewObj(armormate, EntityEquipmentSlot.CHEST).setUnlocalizedName("gvcr2_armor_chest_rig")
					.setRegistryName(mod.MOD_ID, "gvcr2_armor_chest_rig").setCreativeTab(mod.tab_item);
			{
		    	ItemArmor_NewObj armor = (ItemArmor_NewObj)mod. gvcr2_armor_chest_rig;
		    	if (mod.proxy.getClient()) {
			    	armor.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/armor/chest_rig.mqo"));
			    	
			    }
		    	armor.obj_tex = "gvcr2:textures/armor/chest_rig.png";
		    }
		    event.getRegistry().register(mod.gvcr2_armor_chest_rig);
		}
	}
}

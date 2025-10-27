package gvcr2.registry;

import gvclib.item.ItemGunBase;
import gvclib.item.ItemGun_AR;
import gvclib.item.ItemGun_Grenade;
import gvclib.item.ItemMagazine;
import gvclib.item.ItemWrench;
import gvclib.item.Item_GVC;
import gvcr2.mod_GVCR2;
import gvcr2.item.ItemAED;
import gvcr2.item.ItemBandage;
import gvcr2.item.ItemBinoculars;
import gvcr2.item.ItemGVCR2_SPAWN;
import gvcr2.item.ItemInv_Scenario;
import gvcr2.item.ItemPad;
import gvcr2.item.ItemSquadCN;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import objmodel.AdvancedModelLoader;

public class GVCR2ItemRegistry_Item {
		public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Item> event){
			
			{
				mod.gvcr2_item_pad	= new ItemPad().setUnlocalizedName("gvcr2_item_pad")
						.setRegistryName(mod.MOD_ID, "gvcr2_item_pad").setCreativeTab(mod.tab_item);
			    event.getRegistry().register(mod.gvcr2_item_pad);
			}
			
			{
				mod.gvcr2_item_squad_cn	= new ItemSquadCN().setUnlocalizedName("gvcr2_item_squad_cn")
						.setRegistryName(mod.MOD_ID, "gvcr2_item_squad_cn").setCreativeTab(mod.tab_item);
			    event.getRegistry().register(mod.gvcr2_item_squad_cn);
			}
			
			
			{
				mod.gvcr2_item_wrench	= new ItemWrench().setUnlocalizedName("gvcr2_item_wrench")
						.setRegistryName(mod.MOD_ID, "gvcr2_item_wrench").setCreativeTab(mod.tab_item);
			    event.getRegistry().register(mod.gvcr2_item_wrench);
			}
			{
				mod.gvcr2_item_weapon_change	= new Item_GVC().setUnlocalizedName("gvcr2_item_weapon_change").setMaxStackSize(1)
						.setRegistryName(mod.MOD_ID, "gvcr2_item_weapon_change").setCreativeTab(mod.tab_item);
				{
					Item_GVC spawn = (Item_GVC) mod.gvcr2_item_weapon_change;
					spawn.text1 = "gvcr2.string.item.weaponchange_1.name";
					spawn.text2 = "gvcr2.string.item.weaponchange_2.name";
				}
			    event.getRegistry().register(mod.gvcr2_item_weapon_change);
			}
			
			{
				mod.gvcr2_item_binoculars	= new ItemBinoculars().setUnlocalizedName("gvcr2_item_binoculars")
						.setRegistryName(mod.MOD_ID, "gvcr2_item_binoculars").setCreativeTab(mod.tab_item);
			    event.getRegistry().register(mod.gvcr2_item_binoculars);
			}
			{
				mod.gvcr2_item_bandage	= new ItemBandage(0, 4, false, 16, EnumAction.BOW).setUnlocalizedName("gvcr2_item_bandage")
						.setRegistryName(mod.MOD_ID, "gvcr2_item_bandage").setCreativeTab(mod.tab_item);
			    event.getRegistry().register(mod.gvcr2_item_bandage);
			}
			{
				mod.gvcr2_item_cm	= new ItemBandage(4, 4, false, 32, EnumAction.EAT).setUnlocalizedName("gvcr2_item_cm")
						.setRegistryName(mod.MOD_ID, "gvcr2_item_cm").setCreativeTab(mod.tab_item);
			    event.getRegistry().register(mod.gvcr2_item_cm);
			}
			
			{
				mod.gvcr2_item_aed	= new ItemAED().setUnlocalizedName("gvcr2_item_aed")
						.setRegistryName(mod.MOD_ID, "gvcr2_item_aed").setCreativeTab(mod.tab_item);
			    event.getRegistry().register(mod.gvcr2_item_aed);
			}
			
			{
				mod.gvcr2_item_stars	= new Item().setUnlocalizedName("gvcr2_item_stars").setMaxStackSize(1)
						.setRegistryName(mod.MOD_ID, "gvcr2_item_stars").setCreativeTab(mod.tab_item);
			    event.getRegistry().register(mod.gvcr2_item_stars);
			}
			
			{
				mod.gvcr2_item_pra	= new Item().setUnlocalizedName("gvcr2_item_pra").setMaxStackSize(64)
						.setRegistryName(mod.MOD_ID, "gvcr2_item_pra").setCreativeTab(mod.tab_item);
			    event.getRegistry().register(mod.gvcr2_item_pra);
			}
			{
				mod.gvcr2_item_scrap	= new Item().setUnlocalizedName("gvcr2_item_scrap").setMaxStackSize(64)
						.setRegistryName(mod.MOD_ID, "gvcr2_item_scrap").setCreativeTab(mod.tab_item);
			    event.getRegistry().register(mod.gvcr2_item_scrap);
			}
			
			
			
			{
				mod.gvcr2_bullet_9mmhg	= new ItemMagazine().setUnlocalizedName("gvcr2_bullet_9mmhg").setMaxStackSize(64)
			    		.setRegistryName(mod.MOD_ID, "gvcr2_bullet_9mmhg").setCreativeTab(mod.tab_item);
				{
					ItemMagazine magazine = (ItemMagazine) mod.gvcr2_bullet_9mmhg;
					magazine.magazine_tab = "9mmHG";
				}
			    event.getRegistry().register(mod.gvcr2_bullet_9mmhg);
			    {
			    	mod.bullet_eme_1[mod.bullet_id_1] = 1;
			    	mod.bullet_iron_1[mod.bullet_id_1] = 1;
			    	mod.bullet_kazu_1[mod.bullet_id_1] = 32;
			    	mod.bullet_item_1[mod.bullet_id_1] = mod.gvcr2_bullet_9mmhg;
					++mod.bullet_id_1;
			    }
			}
			{
				mod.gvcr2_bullet_45calhg	= new ItemMagazine().setUnlocalizedName("gvcr2_bullet_45calhg").setMaxStackSize(64)
			    		.setRegistryName(mod.MOD_ID, "gvcr2_bullet_45calhg").setCreativeTab(mod.tab_item);
				{
					ItemMagazine magazine = (ItemMagazine) mod.gvcr2_bullet_45calhg;
					magazine.magazine_tab = ".45calHG";
				}
			    event.getRegistry().register(mod.gvcr2_bullet_45calhg);
			    {
			    	mod.bullet_eme_1[mod.bullet_id_1] = 1;
			    	mod.bullet_iron_1[mod.bullet_id_1] = 1;
			    	mod.bullet_kazu_1[mod.bullet_id_1] = 32;
			    	mod.bullet_item_1[mod.bullet_id_1] = mod.gvcr2_bullet_45calhg;
					++mod.bullet_id_1;
			    }
			}
			{
				mod.gvcr2_bullet_22calar	= new ItemMagazine().setUnlocalizedName("gvcr2_bullet_22calar").setMaxStackSize(64)
			    		.setRegistryName(mod.MOD_ID, "gvcr2_bullet_22calar").setCreativeTab(mod.tab_item);
				{
					ItemMagazine magazine = (ItemMagazine) mod.gvcr2_bullet_22calar;
					magazine.magazine_tab = "5.56mmAR";
				}
			    event.getRegistry().register(mod.gvcr2_bullet_22calar);
			    {
			    	mod.bullet_eme_1[mod.bullet_id_1] = 2;
			    	mod.bullet_iron_1[mod.bullet_id_1] = 2;
			    	mod.bullet_kazu_1[mod.bullet_id_1] = 32;
			    	mod.bullet_item_1[mod.bullet_id_1] = mod.gvcr2_bullet_22calar;
					++mod.bullet_id_1;
			    }
			}
			{
				mod.gvcr2_bullet_30calrf	= new ItemMagazine().setUnlocalizedName("gvcr2_bullet_30calrf").setMaxStackSize(64)
			    		.setRegistryName(mod.MOD_ID, "gvcr2_bullet_30calrf").setCreativeTab(mod.tab_item);
				{
					ItemMagazine magazine = (ItemMagazine) mod.gvcr2_bullet_30calrf;
					magazine.magazine_tab = "7.62mmRF";
				}
			    event.getRegistry().register(mod.gvcr2_bullet_30calrf);
			    {
			    	mod.bullet_eme_1[mod.bullet_id_1] = 2;
			    	mod.bullet_iron_1[mod.bullet_id_1] = 2;
			    	mod.bullet_kazu_1[mod.bullet_id_1] = 16;
			    	mod.bullet_item_1[mod.bullet_id_1] = mod.gvcr2_bullet_30calrf;
					++mod.bullet_id_1;
			    }
			}
			{
				mod.gvcr2_bullet_50calrf	= new ItemMagazine().setUnlocalizedName("gvcr2_bullet_50calrf").setMaxStackSize(64)
			    		.setRegistryName(mod.MOD_ID, "gvcr2_bullet_50calrf").setCreativeTab(mod.tab_item);
				{
					ItemMagazine magazine = (ItemMagazine) mod.gvcr2_bullet_50calrf;
					magazine.magazine_tab = "12.7mmRF";
				}
			    event.getRegistry().register(mod.gvcr2_bullet_50calrf);
			    {
			    	mod.bullet_eme_1[mod.bullet_id_1] = 4;
			    	mod.bullet_iron_1[mod.bullet_id_1] = 2;
			    	mod.bullet_kazu_1[mod.bullet_id_1] = 16;
			    	mod.bullet_item_1[mod.bullet_id_1] = mod.gvcr2_bullet_50calrf;
					++mod.bullet_id_1;
			    }
			}
			{
				mod.gvcr2_bullet_40mmgl	= new ItemMagazine().setUnlocalizedName("gvcr2_bullet_40mmgl").setMaxStackSize(64)
			    		.setRegistryName(mod.MOD_ID, "gvcr2_bullet_40mmgl").setCreativeTab(mod.tab_item);
				{
					ItemMagazine magazine = (ItemMagazine) mod.gvcr2_bullet_40mmgl;
					magazine.magazine_tab = "40mmGL";
				}
			    event.getRegistry().register(mod.gvcr2_bullet_40mmgl);
			    {
			    	mod.bullet_eme_1[mod.bullet_id_1] = 8;
			    	mod.bullet_iron_1[mod.bullet_id_1] = 2;
			    	mod.bullet_kazu_1[mod.bullet_id_1] = 16;
			    	mod.bullet_item_1[mod.bullet_id_1] = mod.gvcr2_bullet_40mmgl;
					++mod.bullet_id_1;
			    }
			}
			{
				mod.gvcr2_bullet_12gasg	= new ItemMagazine().setUnlocalizedName("gvcr2_bullet_12gasg").setMaxStackSize(64)
			    		.setRegistryName(mod.MOD_ID, "gvcr2_bullet_12gasg").setCreativeTab(mod.tab_item);
				{
					ItemMagazine magazine = (ItemMagazine) mod.gvcr2_bullet_12gasg;
					magazine.magazine_tab = "12GA";
				}
			    event.getRegistry().register(mod.gvcr2_bullet_12gasg);
			    {
			    	mod.bullet_eme_1[mod.bullet_id_1] = 2;
			    	mod.bullet_iron_1[mod.bullet_id_1] = 2;
			    	mod.bullet_kazu_1[mod.bullet_id_1] = 32;
			    	mod.bullet_item_1[mod.bullet_id_1] = mod.gvcr2_bullet_12gasg;
					++mod.bullet_id_1;
			    }
			}
			{
				mod.gvcr2_bullet_76mmrl	= new ItemMagazine().setUnlocalizedName("gvcr2_bullet_76mmrl").setMaxStackSize(64)
			    		.setRegistryName(mod.MOD_ID, "gvcr2_bullet_76mmrl").setCreativeTab(mod.tab_item);
				{
					ItemMagazine magazine = (ItemMagazine) mod.gvcr2_bullet_76mmrl;
					magazine.magazine_tab = "76mmRocket";
				}
			    event.getRegistry().register(mod.gvcr2_bullet_76mmrl);
			    {
			    	mod.bullet_eme_1[mod.bullet_id_1] = 4;
			    	mod.bullet_iron_1[mod.bullet_id_1] = 2;
			    	mod.bullet_kazu_1[mod.bullet_id_1] = 16;
			    	mod.bullet_item_1[mod.bullet_id_1] = mod.gvcr2_bullet_76mmrl;
					++mod.bullet_id_1;
			    }
			}
			{
				mod.gvcr2_bullet_84mmrl	= new ItemMagazine().setUnlocalizedName("gvcr2_bullet_84mmrl").setMaxStackSize(64)
			    		.setRegistryName(mod.MOD_ID, "gvcr2_bullet_84mmrl").setCreativeTab(mod.tab_item);
				{
					ItemMagazine magazine = (ItemMagazine) mod.gvcr2_bullet_84mmrl;
					magazine.magazine_tab = "84mmRocket";
				}
			    event.getRegistry().register(mod.gvcr2_bullet_84mmrl);
			    {
			    	mod.bullet_eme_1[mod.bullet_id_1] = 4;
			    	mod.bullet_iron_1[mod.bullet_id_1] = 4;
			    	mod.bullet_kazu_1[mod.bullet_id_1] = 16;
			    	mod.bullet_item_1[mod.bullet_id_1] = mod.gvcr2_bullet_84mmrl;
					++mod.bullet_id_1;
			    }
			}
			{
				mod.gvcr2_bullet_76mmml	= new ItemMagazine().setUnlocalizedName("gvcr2_bullet_76mmml").setMaxStackSize(64)
			    		.setRegistryName(mod.MOD_ID, "gvcr2_bullet_76mmml").setCreativeTab(mod.tab_item);
				{
					ItemMagazine magazine = (ItemMagazine) mod.gvcr2_bullet_76mmml;
					magazine.magazine_tab = "76mmMissile";
				}
			    event.getRegistry().register(mod.gvcr2_bullet_76mmml);
			    {
			    	mod.bullet_eme_1[mod.bullet_id_1] = 8;
			    	mod.bullet_iron_1[mod.bullet_id_1] = 8;
			    	mod.bullet_kazu_1[mod.bullet_id_1] = 8;
			    	mod.bullet_item_1[mod.bullet_id_1] = mod.gvcr2_bullet_76mmml;
					++mod.bullet_id_1;
			    }
			}
			
			
			
			
		}
}

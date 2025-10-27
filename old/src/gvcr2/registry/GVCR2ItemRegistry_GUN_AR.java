package gvcr2.registry;

import gvclib.item.ItemGunBase;
import gvclib.item.ItemGun_AR;
import gvclib.item.ItemGun_SR;
import gvcr2.mod_GVCR2;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class GVCR2ItemRegistry_GUN_AR {
		public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Item> event){
			{
				mod.gvcr2_gun_ak47	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_ak47")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_ak47").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_ak47;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_ak47.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_ak47);
			}
			{
				mod.gvcr2_gun_ak74	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_ak74")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_ak74").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_ak74;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_ak74.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_ak74);
			}
			{
				mod.gvcr2_gun_aks74u = new ItemGun_AR().setUnlocalizedName("gvcr2_gun_aks74u")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_aks74u").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_aks74u;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_aks74u.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_aks74u);
			}
			{
				mod.gvcr2_gun_ak102	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_ak102")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_ak102").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_ak102;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_ak102.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_ak102);
			}
			{
				mod.gvcr2_gun_stg44	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_stg44")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_stg44").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_stg44;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_stg44.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_stg44);
			}
			{
				mod.gvcr2_gun_m16a1	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_m16a1")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_m16a1").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m16a1;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_m16a1.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_m16a1);
			}
			{
				mod.gvcr2_gun_m16a2	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_m16a2")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_m16a2").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m16a2;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_m16a2.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_m16a2);
			}
			{
				mod.gvcr2_gun_m16a4	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_m16a4")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_m16a4").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m16a4;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_m16a4.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_m16a4);
			}
			{
				mod.gvcr2_gun_m4	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_m4")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_m4").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m4;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_m4.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_m4);
			}
			{
				mod.gvcr2_gun_m4a1	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_m4a1")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_m4a1").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m4a1;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_m4a1.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_m4a1);
			}
			{
				mod.gvcr2_gun_g3a3	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_g3a3")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_g3a3").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_g3a3;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_g3a3.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_g3a3);
			}
			{
				mod.gvcr2_gun_g36	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_g36")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_g36").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_g36;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_g36.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_g36);
			}
			{
				mod.gvcr2_gun_g36c	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_g36c")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_g36c").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_g36c;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_g36c.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_g36c);
			}
			{
				mod.gvcr2_gun_f2000	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_f2000")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_f2000").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_f2000;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_f2000.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_f2000);
			}
			{
				mod.gvcr2_gun_l85a1	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_l85a1")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_l85a1").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_l85a1;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_l85a1.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_l85a1);
			}
			{
				mod.gvcr2_gun_type95	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_type95")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_type95").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_type95;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_type95.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_type95);
			}
			{
				mod.gvcr2_gun_ak12	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_ak12")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_ak12").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_ak12;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_ak12.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_ak12);
			}
			{
				mod.gvcr2_gun_scar_h	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_scar_h")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_scar_h").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_scar_h;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_scar_h.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_scar_h);
			}
			{
				mod.gvcr2_gun_hk416	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_hk416")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_hk416").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_hk416;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_hk416.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_hk416);
			}
			{
				mod.gvcr2_gun_patriot	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_patriot")
						.setRegistryName(mod.MOD_ID, "gvcr2_gun_patriot").setCreativeTab(mod.tab_gun);
				{
					ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_patriot;
					GVCR2LoadGunStatus.load(gun, mod, event, "ar/gvcr2_gun_patriot.txt");
				}
			    event.getRegistry().register(mod.gvcr2_gun_patriot);
			}
		}
}

package gvcr2.registry;

import gvclib.item.ItemGunBase;
import gvclib.item.ItemGun_AR;
import gvcr2.mod_GVCR2;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class GVCR2ItemRegistry_GUN_MG {
	public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Item> event){
		{
			mod.gvcr2_gun_rpk47	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_rpk47")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_rpk47").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_rpk47;
				GVCR2LoadGunStatus.load(gun, mod, event, "mg/gvcr2_gun_rpk47.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_rpk47);
		}
		{
			mod.gvcr2_gun_dp28	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_dp28")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_dp28").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_dp28;
				GVCR2LoadGunStatus.load(gun, mod, event, "mg/gvcr2_gun_dp28.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_dp28);
		}
		{
			mod.gvcr2_gun_pkm	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_pkm")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_pkm").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_pkm;
				GVCR2LoadGunStatus.load(gun, mod, event, "mg/gvcr2_gun_pkm.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_pkm);
		}
		{
			mod.gvcr2_gun_pkp	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_pkp")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_pkp").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_pkp;
				GVCR2LoadGunStatus.load(gun, mod, event, "mg/gvcr2_gun_pkp.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_pkp);
		}
		{
			mod.gvcr2_gun_m60	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_m60")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m60").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m60;
				GVCR2LoadGunStatus.load(gun, mod, event, "mg/gvcr2_gun_m60.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m60);
		}
		{
			mod.gvcr2_gun_m63	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_m63")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m63").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m63;
				GVCR2LoadGunStatus.load(gun, mod, event, "mg/gvcr2_gun_m63.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m63);
		}
		{
			mod.gvcr2_gun_m240	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_m240")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m240").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m240;
				GVCR2LoadGunStatus.load(gun, mod, event, "mg/gvcr2_gun_m240.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m240);
		}
		{
			mod.gvcr2_gun_m249	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_m249")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m249").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m249;
				GVCR2LoadGunStatus.load(gun, mod, event, "mg/gvcr2_gun_m249.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m249);
		}
		{
			mod.gvcr2_gun_mg42	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_mg42")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_mg42").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_mg42;
				GVCR2LoadGunStatus.load(gun, mod, event, "mg/gvcr2_gun_mg42.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_mg42);
		}
		{
			mod.gvcr2_gun_mg36	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_mg36")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_mg36").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_mg36;
				GVCR2LoadGunStatus.load(gun, mod, event, "mg/gvcr2_gun_mg36.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_mg36);
		}
		{
			mod.gvcr2_gun_fm	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_fm")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_fm").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_fm;
				GVCR2LoadGunStatus.load(gun, mod, event, "mg/gvcr2_gun_fm.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_fm);
		}
		{
			mod.gvcr2_gun_m134	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_m134")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m134").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m134;
				GVCR2LoadGunStatus.load(gun, mod, event, "mg/gvcr2_gun_m134.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m134);
		}
		{
			mod.gvcr2_gun_lewisgun	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_lewisgun")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_lewisgun").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_lewisgun;
				GVCR2LoadGunStatus.load(gun, mod, event, "mg/gvcr2_gun_lewisgun.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_lewisgun);
		}
	}
}

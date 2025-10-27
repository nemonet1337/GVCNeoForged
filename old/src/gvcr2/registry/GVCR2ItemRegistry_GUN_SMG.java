package gvcr2.registry;

import gvclib.item.ItemGunBase;
import gvclib.item.ItemGun_AR;
import gvcr2.mod_GVCR2;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class GVCR2ItemRegistry_GUN_SMG {
	public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Item> event){
		{
			mod.gvcr2_gun_vz61	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_vz61")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_vz61").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_vz61;
				GVCR2LoadGunStatus.load(gun, mod, event, "smg/gvcr2_gun_vz61.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_vz61);
		}
		{
			mod.gvcr2_gun_m10	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_m10")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m10").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m10;
				GVCR2LoadGunStatus.load(gun, mod, event, "smg/gvcr2_gun_m10.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m10);
		}
		{
			mod.gvcr2_gun_mp5	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_mp5")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_mp5").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_mp5;
				GVCR2LoadGunStatus.load(gun, mod, event, "smg/gvcr2_gun_mp5.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_mp5);
		}
		{
			mod.gvcr2_gun_mp40	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_mp40")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_mp40").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_mp40;
				GVCR2LoadGunStatus.load(gun, mod, event, "smg/gvcr2_gun_mp40.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_mp40);
		}
		{
			mod.gvcr2_gun_ppsh41	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_ppsh41")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_ppsh41").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_ppsh41;
				GVCR2LoadGunStatus.load(gun, mod, event, "smg/gvcr2_gun_ppsh41.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_ppsh41);
		}
		{
			mod.gvcr2_gun_mp7	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_mp7")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_mp7").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_mp7;
				GVCR2LoadGunStatus.load(gun, mod, event, "smg/gvcr2_gun_mp7.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_mp7);
		}
		{
			mod.gvcr2_gun_uzi	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_uzi")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_uzi").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_uzi;
				GVCR2LoadGunStatus.load(gun, mod, event, "smg/gvcr2_gun_uzi.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_uzi);
		}
		{
			mod.gvcr2_gun_tmp	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_tmp")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_tmp").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_tmp;
				GVCR2LoadGunStatus.load(gun, mod, event, "smg/gvcr2_gun_tmp.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_tmp);
		}
	}
}

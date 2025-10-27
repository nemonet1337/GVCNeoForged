package gvcr2.registry;

import gvclib.item.ItemGunBase;
import gvclib.item.ItemGun_AR;
import gvclib.item.ItemGun_SR;
import gvcr2.mod_GVCR2;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class GVCR2ItemRegistry_GUN {
	public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Item> event){
		{
			mod.gvcr2_gun_m1911	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_m1911")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m1911").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m1911;
				GVCR2LoadGunStatus.load(gun, mod, event, "hg/gvcr2_gun_m1911.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m1911);
		}
		{
			mod.gvcr2_gun_pm	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_pm")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_pm").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_pm;
				GVCR2LoadGunStatus.load(gun, mod, event, "hg/gvcr2_gun_pm.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_pm);
		}
		{
			mod.gvcr2_gun_m9	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_m9")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m9").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m9;
				GVCR2LoadGunStatus.load(gun, mod, event, "hg/gvcr2_gun_m9.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m9);
		}
		{
			mod.gvcr2_gun_m93r	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_m93r")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m93r").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m93r;
				GVCR2LoadGunStatus.load(gun, mod, event, "hg/gvcr2_gun_m93r.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m93r);
		}
		{
			mod.gvcr2_gun_g17	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_g17")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_g17").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_g17;
				GVCR2LoadGunStatus.load(gun, mod, event, "hg/gvcr2_gun_g17.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_g17);
		}
		{
			mod.gvcr2_gun_g18c	= new ItemGun_AR().setUnlocalizedName("gvcr2_gun_g18c")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_g18c").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_g18c;
				GVCR2LoadGunStatus.load(gun, mod, event, "hg/gvcr2_gun_g18c.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_g18c);
		}
		{
			mod.gvcr2_gun_g17_flux	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_g17_flux")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_g17_flux").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_g17_flux;
				GVCR2LoadGunStatus.load(gun, mod, event, "hg/gvcr2_gun_g17_flux.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_g17_flux);
		}
		
	}
}

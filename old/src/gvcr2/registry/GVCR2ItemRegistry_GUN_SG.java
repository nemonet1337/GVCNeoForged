package gvcr2.registry;

import gvclib.item.ItemGunBase;
import gvclib.item.ItemGun_AR;
import gvclib.item.ItemGun_SR;
import gvcr2.mod_GVCR2;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class GVCR2ItemRegistry_GUN_SG {
	public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Item> event){
		{
			mod.gvcr2_gun_m870	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_m870")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m870").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m870;
				GVCR2LoadGunStatus.load(gun, mod, event, "sg/gvcr2_gun_m870.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m870);
		}
		{
			mod.gvcr2_gun_m590	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_m590")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m590").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m590;
				GVCR2LoadGunStatus.load(gun, mod, event, "sg/gvcr2_gun_m590.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m590);
		}
		{
			mod.gvcr2_gun_m1014	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_m1014")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m1014").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m1014;
				GVCR2LoadGunStatus.load(gun, mod, event, "sg/gvcr2_gun_m1014.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m1014);
		}
		{
			mod.gvcr2_gun_saiga12	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_saiga12")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_saiga12").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_saiga12;
				GVCR2LoadGunStatus.load(gun, mod, event, "sg/gvcr2_gun_saiga12.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_saiga12);
		}
	}
}

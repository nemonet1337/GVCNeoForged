package gvcr2.registry;

import gvclib.item.ItemGunBase;
import gvclib.item.ItemGun_SR;
import gvcr2.mod_GVCR2;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class GVCR2ItemRegistry_GUN_RF {
	public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Item> event){
		{
			mod.gvcr2_gun_sks	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_sks")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_sks").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_sks;
				GVCR2LoadGunStatus.load(gun, mod, event, "rf/gvcr2_gun_sks.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_sks);
		}
		{
			mod.gvcr2_gun_svd	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_svd")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_svd").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_svd;
				GVCR2LoadGunStatus.load(gun, mod, event, "rf/gvcr2_gun_svd.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_svd);
		}
		{
			mod.gvcr2_gun_m1891	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_m1891")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m1891").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m1891;
				GVCR2LoadGunStatus.load(gun, mod, event, "rf/gvcr2_gun_m1891.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m1891);
		}
		{
			mod.gvcr2_gun_m14	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_m14")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m14").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m14;
				GVCR2LoadGunStatus.load(gun, mod, event, "rf/gvcr2_gun_m14.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m14);
		}
		{
			mod.gvcr2_gun_m110	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_m110")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m110").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m110;
				GVCR2LoadGunStatus.load(gun, mod, event, "rf/gvcr2_gun_m110.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m110);
		}
		{
			mod.gvcr2_gun_r700	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_r700")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_r700").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_r700;
				GVCR2LoadGunStatus.load(gun, mod, event, "rf/gvcr2_gun_r700.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_r700);
		}
		{
			mod.gvcr2_gun_l96	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_l96")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_l96").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_l96;
				GVCR2LoadGunStatus.load(gun, mod, event, "rf/gvcr2_gun_l96.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_l96);
		}
		{
			mod.gvcr2_gun_ptrd	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_ptrd")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_ptrd").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_ptrd;
				GVCR2LoadGunStatus.load(gun, mod, event, "rf/gvcr2_gun_ptrd.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_ptrd);
		}
		{
			mod.gvcr2_gun_m82a3	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_m82a3")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m82a3").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m82a3;
				GVCR2LoadGunStatus.load(gun, mod, event, "rf/gvcr2_gun_m82a3.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m82a3);
		}
		
		{
			mod.gvcr2_gun_railgun	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_railgun")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_railgun").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_railgun;
				GVCR2LoadGunStatus.load(gun, mod, event, "rf/gvcr2_gun_railgun.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_railgun);
		}
		
	}
}

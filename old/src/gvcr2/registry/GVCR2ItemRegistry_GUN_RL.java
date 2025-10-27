package gvcr2.registry;

import gvclib.item.ItemGunBase;
import gvclib.item.ItemGun_SR;
import gvcr2.mod_GVCR2;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class GVCR2ItemRegistry_GUN_RL {
	public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Item> event){
		
		{
			mod.gvcr2_gun_m79	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_m79")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m79").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m79;
				GVCR2LoadGunStatus.load(gun, mod, event, "rl/gvcr2_gun_m79.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m79);
		}
		{
			mod.gvcr2_gun_m320	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_m320")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m320").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m320;
				GVCR2LoadGunStatus.load(gun, mod, event, "rl/gvcr2_gun_m320.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m320);
		}
		{
			mod.gvcr2_gun_xm25	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_xm25")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_xm25").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_xm25;
				GVCR2LoadGunStatus.load(gun, mod, event, "rl/gvcr2_gun_xm25.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_xm25);
		}
		{
			mod.gvcr2_gun_mgl140	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_mgl140")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_mgl140").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_mgl140;
				GVCR2LoadGunStatus.load(gun, mod, event, "rl/gvcr2_gun_mgl140.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_mgl140);
		}
		
		
		{
			mod.gvcr2_gun_rpg7	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_rpg7")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_rpg7").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_rpg7;
				GVCR2LoadGunStatus.load(gun, mod, event, "rl/gvcr2_gun_rpg7.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_rpg7);
		}
		{
			mod.gvcr2_gun_panzerfaust	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_panzerfaust")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_panzerfaust").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_panzerfaust;
				GVCR2LoadGunStatus.load(gun, mod, event, "rl/gvcr2_gun_panzerfaust.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_panzerfaust);
		}
		{
			mod.gvcr2_gun_m72	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_m72")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m72").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m72;
				GVCR2LoadGunStatus.load(gun, mod, event, "rl/gvcr2_gun_m72.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m72);
		}
		{
			mod.gvcr2_gun_m202	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_m202")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_m202").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_m202;
				GVCR2LoadGunStatus.load(gun, mod, event, "rl/gvcr2_gun_m202.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_m202);
		}
		{
			mod.gvcr2_gun_smaw	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_smaw")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_smaw").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_smaw;
				GVCR2LoadGunStatus.load(gun, mod, event, "rl/gvcr2_gun_smaw.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_smaw);
		}
		{
			mod.gvcr2_gun_sraw	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_sraw")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_sraw").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_sraw;
				GVCR2LoadGunStatus.load(gun, mod, event, "rl/gvcr2_gun_sraw.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_sraw);
		}
		{
			mod.gvcr2_gun_fgm148	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_fgm148")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_fgm148").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_fgm148;
				GVCR2LoadGunStatus.load(gun, mod, event, "rl/gvcr2_gun_fgm148.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_fgm148);
		}
		{
			mod.gvcr2_gun_fim92	= new ItemGun_SR().setUnlocalizedName("gvcr2_gun_fim92")
					.setRegistryName(mod.MOD_ID, "gvcr2_gun_fim92").setCreativeTab(mod.tab_gun);
			{
				ItemGunBase gun = (ItemGunBase) mod.gvcr2_gun_fim92;
				GVCR2LoadGunStatus.load(gun, mod, event, "rl/gvcr2_gun_fim92.txt");
			}
		    event.getRegistry().register(mod.gvcr2_gun_fim92);
		}
	}
}

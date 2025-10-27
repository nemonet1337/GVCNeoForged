package gvcr2.registry;

import gvclib.item.ItemGunBase;
import gvclib.item.ItemGun_AR;
import gvcr2.mod_GVCR2;
import gvcr2.item.ItemDrone;
import gvcr2.item.ItemGVCR2_SPAWN;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class GVCR2ItemRegistry_Drone {
	public static void registry(mod_GVCR2 mod, RegistryEvent.Register<Item> event){
		{
			mod.gvcr2_drone_mav	= new ItemDrone(0).setUnlocalizedName("gvcr2_drone_mav")
					.setRegistryName(mod.MOD_ID, "gvcr2_drone_mav").setCreativeTab(mod.tab_gun);
		    event.getRegistry().register(mod.gvcr2_drone_mav);
		    {
		    	mod_GVCR2.gun_eme_2[mod_GVCR2.gun_id_2] = 4;
				mod_GVCR2.gun_iron_2[mod_GVCR2.gun_id_2] = 1;
				mod_GVCR2.gun_red_2[mod_GVCR2.gun_id_2] = 1;
				mod_GVCR2.gun_item_2[mod_GVCR2.gun_id_2] = mod.gvcr2_drone_mav;
				++mod_GVCR2.gun_id_2;
		    }
		}
		{
			mod.gvcr2_drone_eod	= new ItemDrone(1).setUnlocalizedName("gvcr2_drone_eod")
					.setRegistryName(mod.MOD_ID, "gvcr2_drone_eod").setCreativeTab(mod.tab_gun);
		    event.getRegistry().register(mod.gvcr2_drone_eod);
		    {
		    	mod_GVCR2.gun_eme_2[mod_GVCR2.gun_id_2] = 4;
				mod_GVCR2.gun_iron_2[mod_GVCR2.gun_id_2] = 1;
				mod_GVCR2.gun_red_2[mod_GVCR2.gun_id_2] = 1;
				mod_GVCR2.gun_item_2[mod_GVCR2.gun_id_2] = mod.gvcr2_drone_eod;
				++mod_GVCR2.gun_id_2;
		    }
		}
		{
			mod.gvcr2_drone_rawr	= new ItemDrone(2).setUnlocalizedName("gvcr2_drone_rawr")
					.setRegistryName(mod.MOD_ID, "gvcr2_drone_rawr").setCreativeTab(mod.tab_gun);
		    event.getRegistry().register(mod.gvcr2_drone_rawr);
		    mod_GVCR2.gun_eme_3[mod_GVCR2.gun_id_3] = 8;
			mod_GVCR2.gun_iron_3[mod_GVCR2.gun_id_3] = 2;
			mod_GVCR2.gun_red_3[mod_GVCR2.gun_id_3] = 2;
			mod_GVCR2.gun_item_3[mod_GVCR2.gun_id_3] = mod.gvcr2_drone_rawr;
			++mod_GVCR2.gun_id_3;
		}
	}
}

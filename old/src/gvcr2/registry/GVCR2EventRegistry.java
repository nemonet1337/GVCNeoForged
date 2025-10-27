package gvcr2.registry;

import gvcr2.mod_GVCR2;
import gvcr2.event.client.GVCR2ClientEvent_Binoculars;
import gvcr2.event.client.GVCR2ClientEvent_Gui;
import gvcr2.event.client.GVCR2ClientEvent_INV;
import gvcr2.event.client.GVCR2ClientEvent_PMC_Squad;
import gvcr2.event.entity.GVCR2EventArmor;
import gvcr2.event.entity.GVCR2EventEasterEgg;
import gvcr2.event.item.GVCR2EventItem;
import gvcr2.event.level.GVCR2EventLevel_Server;
import gvcr2.event.world.GVCR2EventWorld;
import gvcr2.world.WorldGenerator_GVCR2_Bullding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GVCR2EventRegistry {
	public static void registrys(FMLInitializationEvent pEvent) {
		mod_GVCR2 mod = mod_GVCR2.INSTANCE;

		MinecraftForge.EVENT_BUS.register(new GVCR2EventWorld());
		
		
		MinecraftForge.EVENT_BUS.register(new GVCR2EventLevel_Server());
		
		MinecraftForge.EVENT_BUS.register(new GVCR2EventArmor());
		
		MinecraftForge.EVENT_BUS.register(new GVCR2EventItem());
		
		MinecraftForge.EVENT_BUS.register(new GVCR2EventEasterEgg());
		
		
		 if (pEvent.getSide().isClient()) {
			 MinecraftForge.EVENT_BUS.register(new GVCR2ClientEvent_INV());
			 
			 MinecraftForge.EVENT_BUS.register(new GVCR2ClientEvent_Gui());
			 
			 MinecraftForge.EVENT_BUS.register(new GVCR2ClientEvent_Binoculars());
			 
			 MinecraftForge.EVENT_BUS.register(new GVCR2ClientEvent_PMC_Squad());
		 }

		 
		 
		 
		 
		// if(mod.cfg_building)
		{
			GameRegistry.registerWorldGenerator(new WorldGenerator_GVCR2_Bullding(), 10);
		}
		if (pEvent.getSide().isClient()) {
			// MinecraftForge.EVENT_BUS.register(new GVCEventSquad_Render());
		}
	}
}

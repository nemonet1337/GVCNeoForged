package gvcr2.event.client;

import java.util.List;

import gvclib.mod_GVCLib;
import gvcr2.mod_GVCR2;
import gvcr2.gui.GVCR2Gui_Pad;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GVCR2ClientEvent_Gui {
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onEvent(GuiScreenEvent.ActionPerformedEvent.Pre event) {
		/*GuiButton button = event.getButton();
		List<GuiButton> buttonList = event.getButtonList();
		GuiScreen gui = event.getGui();
		if(gui != null && gui instanceof GVCR2Gui_Pad) {
			System.out.println("2");
			GVCR2Gui_Pad padgui = (GVCR2Gui_Pad) gui;
			int page = padgui.page;
			if(page == 1) {
				if(button == buttonList.get(0)
						|| button == buttonList.get(2)
						|| button == buttonList.get(3)
						|| button == buttonList.get(4)
						|| button == buttonList.get(5)
						|| button == buttonList.get(6)
						|| button == buttonList.get(7)
						|| button == buttonList.get(8)) {
					event.isCanceled();
					event.isCancelable();
					System.out.println("debug");
				}
			}
		}*/
	}
	
	/*@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onUPEvent(LivingUpdateEvent event) {
		EntityLivingBase target = event.getEntityLiving();
		if (target instanceof EntityPlayer) {
			Minecraft minecraft = Minecraft.getMinecraft();
			EntityPlayer entityplayer = (EntityPlayer) target;
			if (mod_GVCLib.proxy.left()) {
				mod_GVCR2.test_1_x = mod_GVCR2.test_1_x + 2;
				String dd = String.format("%1$.2f", mod_GVCR2.test_1_x);
				System.out.println("x : " + String.format(dd));
			}
			if (mod_GVCLib.proxy.right()) {
				mod_GVCR2.test_1_x = mod_GVCR2.test_1_x - 2;
				String dd = String.format("%1$.2f", mod_GVCR2.test_1_x);
				System.out.println("x : " + String.format(dd));
			}
			if (mod_GVCLib.proxy.up()) {
				mod_GVCR2.test_1_y = mod_GVCR2.test_1_y + 2;
				String dd = String.format("%1$.2f", mod_GVCR2.test_1_y);
				System.out.println("y : " + String.format(dd));
			}
			if (mod_GVCLib.proxy.down()) {
				mod_GVCR2.test_1_y = mod_GVCR2.test_1_y - 2;
				String dd = String.format("%1$.2f", mod_GVCR2.test_1_y);
				System.out.println("y : " + String.format(dd));
			}
			if (mod_GVCLib.proxy.LBRACKET()) {
				mod_GVCR2.test_1_z = mod_GVCR2.test_1_z + 2;
				String dd = String.format("%1$.2f", mod_GVCR2.test_1_z);
				System.out.println("z : " + String.format(dd));
			}
			if (mod_GVCLib.proxy.RBRACKET()) {
				mod_GVCR2.test_1_z = mod_GVCR2.test_1_z - 2;
				String dd = String.format("%1$.2f", mod_GVCR2.test_1_z);
				System.out.println("z : " + String.format(dd));
			}
			
			
			if (mod_GVCLib.proxy.numpad_4()) {
				mod_GVCR2.test_2_x = mod_GVCR2.test_2_x + 2;
				String dd = String.format("%1$.2f", mod_GVCR2.test_2_x);
				System.out.println("x2 : " + String.format(dd));
			}
			if (mod_GVCLib.proxy.numpad_6()) {
				mod_GVCR2.test_2_x = mod_GVCR2.test_2_x - 2;
				String dd = String.format("%1$.2f", mod_GVCR2.test_2_x);
				System.out.println("x2 : " + String.format(dd));
			}
			if (mod_GVCLib.proxy.numpad_8()) {
				mod_GVCR2.test_2_y = mod_GVCR2.test_2_y + 2;
				String dd = String.format("%1$.2f", mod_GVCR2.test_2_y);
				System.out.println("y2 : " + String.format(dd));
			}
			if (mod_GVCLib.proxy.numpad_2()) {
				mod_GVCR2.test_2_y = mod_GVCR2.test_2_y - 2;
				String dd = String.format("%1$.2f", mod_GVCR2.test_2_y);
				System.out.println("y2 : " + String.format(dd));
			}
			if (mod_GVCLib.proxy.numpad_1()) {
				mod_GVCR2.test_2_z = mod_GVCR2.test_2_z + 2;
				String dd = String.format("%1$.2f", mod_GVCR2.test_2_z);
				System.out.println("z2 : " + String.format(dd));
			}
			if (mod_GVCLib.proxy.numpad_3()) {
				mod_GVCR2.test_2_z = mod_GVCR2.test_2_z - 2;
				String dd = String.format("%1$.2f", mod_GVCR2.test_2_z);
				System.out.println("z2 : " + String.format(dd));
			}
		}
	}*/
}

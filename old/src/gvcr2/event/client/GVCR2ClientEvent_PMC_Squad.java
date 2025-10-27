package gvcr2.event.client;

import java.awt.Color;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.entity.living.EntityVehicleBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.pmc.EntityGVCR2_PMC_S;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_MG_DP28;
import gvcr2.item.ItemSquadCN;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;



public class GVCR2ClientEvent_PMC_Squad {
	
	private static final ResourceLocation class_0 = new ResourceLocation("gvcr2:textures/marker/marker0.png");
	private static final ResourceLocation class_1 = new ResourceLocation("gvcr2:textures/marker/marker1.png");
	private static final ResourceLocation class_2 = new ResourceLocation("gvcr2:textures/marker/marker2.png");
	private static final ResourceLocation class_3 = new ResourceLocation("gvcr2:textures/marker/marker3.png");
    private static final IModelCustom doll_class = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/marker/marker.obj"));
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void rendergunthird(RenderLivingEvent.Post event) {
		EntityLivingBase entity = (EntityLivingBase) event.getEntity();
		Minecraft minecraft = Minecraft.getMinecraft();
		EntityPlayer entityplayer = minecraft.player;
		if(entity instanceof  EntityGVCR2_PMC_S && entity.getHealth() > 0.0F){
			EntityGVCR2_PMC_S gvcentity = (EntityGVCR2_PMC_S) entity;
			GL11.glPushMatrix();
			//GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
			GL11.glTranslatef((float) event.getX(), (float) event.getY(), (float) event.getZ());
			RenderManager manager = minecraft.getRenderManager();
	//		GlStateManager.rotate(-manager.playerViewY, 0.0F, 1.0F, 0.0F);
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			if(gvcentity.getArmID_L() == 1){
				GL11.glTranslatef(0, entity.height + 0.5F, 0);
				GlStateManager.disableLighting();
				if (gvcentity.getMoveT() == 1) {
					Minecraft.getMinecraft().renderEngine.bindTexture(class_1);
				}else if (gvcentity.getMoveT() == 2) {
					Minecraft.getMinecraft().renderEngine.bindTexture(class_2);
				}else if (gvcentity.getMoveT() == 3) {
					Minecraft.getMinecraft().renderEngine.bindTexture(class_3);
				}else {
					Minecraft.getMinecraft().renderEngine.bindTexture(class_0);
				}
				doll_class.renderPart("mat1");
				GlStateManager.enableLighting();
			}
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
			//GL11.glPopAttrib();
			GL11.glPopMatrix();
		}
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onEvent(RenderGameOverlayEvent.Text event) {
		
		Minecraft mc = FMLClientHandler.instance().getClient();
		World world = FMLClientHandler.instance().getWorldClient();
		ScaledResolution scaledresolution = new ScaledResolution(mc);
		int i = scaledresolution.getScaledWidth();
		int j = scaledresolution.getScaledHeight();
		EntityPlayer player = mc.player;
		ItemStack itemstack = ((EntityPlayer) (player)).getHeldItemMainhand();
		ItemStack itemstackl = ((EntityPlayer) (player)).getHeldItemOffhand();
		FontRenderer fontrenderer = mc.fontRenderer;
		mc.entityRenderer.setupOverlayRendering();
		// OpenGlHelper.
		
		if(!itemstack.isEmpty() && itemstack.getItem() instanceof ItemSquadCN){
			this.renderhud(player, mc, fontrenderer);
		}
		if(!itemstackl.isEmpty() && itemstackl.getItem() instanceof ItemSquadCN){
			this.renderhud(player, mc, fontrenderer);
		}
		
	}
	
	public void renderhud(EntityPlayer player, Minecraft mc, FontRenderer fontrenderer) {
		// GL11.glEnable(GL11.GL_BLEND);
				if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
					{
						GL11.glPushMatrix();
						GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
						GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
								GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
								GlStateManager.DestFactor.ZERO);
						mc.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
						int x = 8;
						GL11.glScalef(1, 1, 1);
						GuiIngame g  = mc.ingameGUI;
						mc.renderEngine.bindTexture(new ResourceLocation("gvcr2:textures/items/rogo.png"));
						GL11.glScalef(0.0625f, 0.0625f, 1);
						g.drawTexturedModalRect((5)*16,
								(0)*16, 0,0, 256, 256);
						
						GL11.glPopMatrix();
					}
					
					
					int count = 0;
					int vehicle_count = 1;
					int x = 30;
					{
						GL11.glPushMatrix();
						RenderItem renderitem = mc.getRenderItem();
						renderitem.renderItemIntoGUI(new ItemStack(mod_GVCR2.gvcr2_spawn_pmc_s), x, 0);
						GL11.glPopMatrix();
					}
					{
						List<Entity> llist = player.world.getEntitiesWithinAABBExcludingEntity(player,
								player.getEntityBoundingBox().expand(player.motionX, player.motionY, player.motionZ).grow(100.0D));
						if (llist != null) {
							for (int lj = 0; lj < llist.size(); lj++) {
								Entity entity1 = (Entity) llist.get(lj);
								if (entity1.canBeCollidedWith() && entity1 instanceof EntityGVCR2_PMC_S && entity1 != null) {
									EntityGVCR2_PMC_S doll = (EntityGVCR2_PMC_S) entity1;
									if(doll.isOwner(player) && doll.getArmID_L() == 1) {
										++count;
										if (doll.getRidingEntity() instanceof EntityVehicleBase && doll.getRidingEntity() != null) {// 1
											EntityVehicleBase vehicle = (EntityVehicleBase) doll.getRidingEntity();
											{
												GL11.glPushMatrix();
												RenderItem renderitem = mc.getRenderItem();
												if(vehicle.spawn_item != null)renderitem.renderItemIntoGUI(new ItemStack(vehicle.spawn_item), x * vehicle_count + x, 0);
												GL11.glPopMatrix();
											}
											++vehicle_count;
										}
										/*GL11.glPushMatrix();
										GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
										GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
												GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
												GlStateManager.DestFactor.ZERO);
										mc.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
										
										String mode = "follow";
										int color_mode = Color.GREEN.getRGB();
										if(doll.getMoveT() == 1) {
											mode = "free";
											color_mode = Color.RED.getRGB();
										}
										if(doll.getMoveT() == 2) {
											mode = "attack";
											color_mode = Color.YELLOW.getRGB();
										}
										if(doll.getMoveT() == 3) {
											mode = "wait";
											color_mode = Color.BLUE.getRGB();
										}
										if(doll.getMoveT() == 5) {
											mode = "point attack";
											color_mode = Color.ORANGE.getRGB();
										}
										fontrenderer.drawString(mode, x, 30, color_mode);
										GL11.glPopMatrix();*/
									}
								}
							}
						}
					}
					{
						GL11.glPushMatrix();
						GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
						fontrenderer.drawString("x" + count, x + 10, 20, Color.WHITE.getRGB());
						GL11.glPopMatrix();
					}
					
					
					
				}
	}
	
	
}//end

package gvcr2.event.client;

import org.lwjgl.opengl.GL11;

import gvclib.item.ItemGunBase;
import gvcr2.mod_GVCR2;
import gvcr2.item.ItemBinoculars;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GVCR2ClientEvent_Binoculars {
	
	
	@SideOnly(Side.CLIENT)
    @SubscribeEvent
	  public void renderfov(FOVUpdateEvent event)
	  {
		Minecraft minecraft = FMLClientHandler.instance().getClient();
		EntityPlayer entityplayer = minecraft.player;
		ItemStack itemstack = ((EntityPlayer) (entityplayer)).getHeldItemMainhand();
		if (!itemstack.isEmpty() && itemstack.getItem() instanceof ItemBinoculars) {//item
			ItemBinoculars gun = (ItemBinoculars) itemstack.getItem();
			if (entityplayer.isHandActive()) {
				event.setNewfov(event.getFov() / 4);
			}
		}//item
	  }
	
	/*
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onEvent2(RenderGameOverlayEvent.Text event) {
		Minecraft minecraft = FMLClientHandler.instance().getClient();
		World world = FMLClientHandler.instance().getWorldClient();
		ScaledResolution scaledresolution = new ScaledResolution(minecraft);
		int i = scaledresolution.getScaledWidth();
		int j = scaledresolution.getScaledHeight();
		EntityPlayer entityplayer = minecraft.player;
		if(entityplayer != null) {
			ItemStack itemstack = ((EntityPlayer) (entityplayer)).getHeldItemMainhand();
			//ItemStack HEAD = ((EntityPlayer) (entityplayer)).getItemStackFromSlot(EntityEquipmentSlot.HEAD);
			FontRenderer fontrenderer = minecraft.fontRenderer;
			//minecraft.entityRenderer.setupOverlayRendering();
			if (!itemstack.isEmpty() && itemstack.getItem() instanceof ItemBinoculars) {//item
				ItemBinoculars gun = (ItemBinoculars) itemstack.getItem();
				if (entityplayer.isHandActive()) 
				{
					//GL11.glColor4f(0.1F, 0.1F, 0.1F, 1.0F);
					//event.getRenderer().setRenderOutlines(true);
					 //GlStateManager.enableOutlineMode(this.getTeamColor(event.getEntity()));
					GL11.glPushMatrix();
					GlStateManager.enableBlend();
					GL11.glEnable(GL11.GL_BLEND);
					
					GlStateManager.disableDepth();
					GlStateManager.depthMask(false);
					GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
							GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
							GlStateManager.DestFactor.ZERO);
					GlStateManager.color(0.5F, 0.5F, 0.5F, 0.8F);
					GlStateManager.disableAlpha();
					minecraft.getTextureManager().bindTexture(new ResourceLocation("gvcr2:textures/misc/over.png"));
					Tessellator tessellator = Tessellator.getInstance();
					BufferBuilder bufferbuilder = tessellator.getBuffer();
			        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
			        bufferbuilder.pos(0.0D, (double)scaledresolution.getScaledHeight(), -90.0D).tex(0.0D, 1.0D).endVertex();
			        bufferbuilder.pos((double)scaledresolution.getScaledWidth(), (double)scaledresolution.getScaledHeight(), -90.0D).tex(1.0D, 1.0D).endVertex();
			        bufferbuilder.pos((double)scaledresolution.getScaledWidth(), 0.0D, -90.0D).tex(1.0D, 0.0D).endVertex();
			        bufferbuilder.pos(0.0D, 0.0D, -90.0D).tex(0.0D, 0.0D).endVertex();
					tessellator.draw();
					GlStateManager.depthMask(true);
					GlStateManager.enableDepth();
					GlStateManager.enableAlpha();
					GlStateManager.color(0.5F, 0.5F, 0.5F, 0.8F);
					
					GlStateManager.disableBlend();
					GL11.glPopMatrix();
				}
			}//item
		}
	}/**/
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onEvent(RenderGameOverlayEvent.Text event) {
		Minecraft minecraft = FMLClientHandler.instance().getClient();
		World world = FMLClientHandler.instance().getWorldClient();
		ScaledResolution scaledresolution = new ScaledResolution(minecraft);
		int i = scaledresolution.getScaledWidth();
		int j = scaledresolution.getScaledHeight();
		EntityPlayer entityplayer = minecraft.player;
		ItemStack itemstack = ((EntityPlayer) (entityplayer)).getHeldItemMainhand();
		ItemStack HEAD = ((EntityPlayer) (entityplayer)).getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		FontRenderer fontrenderer = minecraft.fontRenderer;
		minecraft.entityRenderer.setupOverlayRendering();
		if (!itemstack.isEmpty() && itemstack.getItem() instanceof ItemBinoculars) {//item
			ItemBinoculars gun = (ItemBinoculars) itemstack.getItem();
			if (entityplayer.isHandActive()) {
			GL11.glPushMatrix();
			GlStateManager.enableBlend();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			minecraft.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
					GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
					GlStateManager.DestFactor.ZERO);
				this.renderPumpkinBlur(minecraft, scaledresolution, "gvcr2:textures/misc/binoculars.png");
			GlStateManager.disableBlend();
			GL11.glPopMatrix();
			}
		}//item
	}
	
	
	
	/*
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onEvent3(TextureStitchEvent.Pre event) {
		Minecraft minecraft = FMLClientHandler.instance().getClient();
		World world = FMLClientHandler.instance().getWorldClient();
		ScaledResolution scaledresolution = new ScaledResolution(minecraft);
		int i = scaledresolution.getScaledWidth();
		int j = scaledresolution.getScaledHeight();
		EntityPlayer entityplayer = minecraft.player;
		if(entityplayer != null) 
		{
			ItemStack itemstack = ((EntityPlayer) (entityplayer)).getHeldItemMainhand();
			//ItemStack HEAD = ((EntityPlayer) (entityplayer)).getItemStackFromSlot(EntityEquipmentSlot.HEAD);
			FontRenderer fontrenderer = minecraft.fontRenderer;
			//minecraft.entityRenderer.setupOverlayRendering();
			if (!itemstack.isEmpty() && itemstack.getItem() instanceof ItemBinoculars) {//item
				ItemBinoculars gun = (ItemBinoculars) itemstack.getItem();
				//if (entityplayer.isHandActive()) 
				{
					//event.getRenderer().
					//GL11.glClearColor(0, 0, 0, 1);
					GL11.glColor4f(0.1F, 0.1F, 0.1F, 1.0F);
				}
			}//item
		}
	}/**/
	
	
	 protected int getTeamColor(Entity entityIn)
	    {
	        int i = 16777215;
	        ScorePlayerTeam scoreplayerteam = (ScorePlayerTeam)entityIn.getTeam();

	        if (scoreplayerteam != null)
	        {
	            String s = FontRenderer.getFormatFromString(scoreplayerteam.getPrefix());

	            if (s.length() >= 2)
	            {
	                i = FMLClientHandler.instance().getClient().fontRenderer.getColorCode(s.charAt(1));
	            }
	        }

	        return i;
	    }
	
	
	@SideOnly(Side.CLIENT)
	protected void renderPumpkinBlur(Minecraft minecraft, ScaledResolution scaledRes, String adss) {
		GlStateManager.disableDepth();
		GlStateManager.depthMask(false);
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
				GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
				GlStateManager.DestFactor.ZERO);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.disableAlpha();
		minecraft.getTextureManager().bindTexture(new ResourceLocation(adss));
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.pos(0.0D, (double)scaledRes.getScaledHeight(), -90.0D).tex(0.0D, 1.0D).endVertex();
        bufferbuilder.pos((double)scaledRes.getScaledWidth(), (double)scaledRes.getScaledHeight(), -90.0D).tex(1.0D, 1.0D).endVertex();
        bufferbuilder.pos((double)scaledRes.getScaledWidth(), 0.0D, -90.0D).tex(1.0D, 0.0D).endVertex();
        bufferbuilder.pos(0.0D, 0.0D, -90.0D).tex(0.0D, 0.0D).endVertex();
		tessellator.draw();
		GlStateManager.depthMask(true);
		GlStateManager.enableDepth();
		GlStateManager.enableAlpha();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	}
}

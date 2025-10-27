package gvcr2.event.client;

import org.lwjgl.opengl.GL11;

import gvcr2.block.tile.TileEntityBlockBaseFlag_Base;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GVCR2ClientEvent_INV {

	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onEvent(RenderGameOverlayEvent.Text event) {
		/*if(!mod_GirlFront.cfg_hud) {
			return;
		}*/
		
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
		
		renderInv(player, mc, fontrenderer);
		
	}
	
	public void renderInv(EntityPlayer player, Minecraft mc, FontRenderer fontrenderer) {
		GL11.glPushMatrix();{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		ScaledResolution scaledresolution = new ScaledResolution(mc);
        int ix = scaledresolution.getScaledWidth();
        int jy = scaledresolution.getScaledHeight();
		for(int x = 0; x < 40; ++x) {
			for(int y = 0; y < 40; ++y) {
				for(int z = 0; z < 40; ++z) {
					BlockPos pos = new BlockPos(player.posX - 20 + x, player.posY - 20 + y, player.posZ - 20 + z);
					//if(player.world.getBlockState(pos).getBlock() instanceof Block_BaseBase) 
					if(player.world.getTileEntity(pos) instanceof TileEntityBlockBaseFlag_Base) 
					{
						TileEntityBlockBaseFlag_Base tile =  (TileEntityBlockBaseFlag_Base)player.world.getTileEntity(pos);
						

						double xx = player.posX - pos.getX();
						double yy = player.posY - pos.getY();
						double zz = player.posZ - pos.getZ();
						
						
						double xy = Math.sqrt(xx * xx + yy * yy);
						double xyz = Math.sqrt(xy * xy + zz * zz);
						
						if(xyz <= tile.flag_range*1.1){
							double count = tile.getClientInvCount(tile);
							double invmaxcount = tile.getClientInvMaxCount(tile);

							
							//invasion
							{
								GL11.glPushMatrix();
								{
									GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
											GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
											GlStateManager.SourceFactor.ONE,
											GlStateManager.DestFactor.ZERO);
									GuiIngame g = mc.ingameGUI;
									mc.renderEngine
											.bindTexture(
													new ResourceLocation("gvcr2:textures/misc/"+ tile.inv_tex));
									GL11.glScalef(0.125f, 0.125f, 1);
									g.drawTexturedModalRect((ix / 2 - 16) * 8, (jy / 2 - 100) * 8, 0, 0, 256, 256);
								}
								GL11.glPopMatrix();
								GL11.glPushMatrix();
								{
									GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
											GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
											GlStateManager.SourceFactor.ONE,
											GlStateManager.DestFactor.ZERO);
									GuiIngame g = mc.ingameGUI;
									mc.renderEngine
											.bindTexture(new ResourceLocation(
													"gvcr2:textures/misc/"+ tile.inv_tex_em));
									GL11.glScalef(0.125f, 0.125f, 1);
									double co = (count / invmaxcount) * 256;
									//GL11.glScalef(1 * 0.5f, 1, 1);
									int co2 = (int) co;
									if(tile.enemyblock) {
										g.drawTexturedModalRect((ix / 2 - 16) * 8, (jy / 2 - 100) * 8, 0, 0, 256 - co2,
												256);
									}else {
										g.drawTexturedModalRect((ix / 2 - 16) * 8, (jy / 2 - 100) * 8, 0, 0, co2,
												256);
									}
								}
								GL11.glPopMatrix();
								GL11.glPushMatrix();
								{
									GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
											GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
											GlStateManager.SourceFactor.ONE,
											GlStateManager.DestFactor.ZERO);
									TextComponentTranslation text = new TextComponentTranslation(tile.inv_name, new Object[0]);
									fontrenderer.drawString(text.getFormattedText(), (ix / 2) - 26, (jy / 2 - 60), 0xFFFFFF);
								}
								GL11.glPopMatrix();
						}
					
							//player vs mob
							{
								double player_count = tile.getClientPlayerCount(tile);
								double mob_count = tile.getClientMobCount(tile);
								
									GL11.glPushMatrix();
									{
										GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
												GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
												GlStateManager.SourceFactor.ONE,
												GlStateManager.DestFactor.ZERO);
										GuiIngame g = mc.ingameGUI;
										mc.renderEngine
												.bindTexture(
														new ResourceLocation("gvcr2:textures/misc/invhp.png"));
										GL11.glScalef(0.125f, 0.125f, 1);
										g.drawTexturedModalRect((ix / 2 - 16) * 8, (jy / 2 - 84) * 8, 0, 0, 256, 256);
									}
									GL11.glPopMatrix();
									GL11.glPushMatrix();
									{
										GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
												GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
												GlStateManager.SourceFactor.ONE,
												GlStateManager.DestFactor.ZERO);
										GuiIngame g = mc.ingameGUI;
										mc.renderEngine
												.bindTexture(new ResourceLocation(
														"gvcr2:textures/misc/invhp_em.png"));
										GL11.glScalef(0.125f, 0.125f, 1);
										double max = player_count + mob_count;
										double range = 256 / max;
										double player_range = player_count * range;
										double mob_range = mob_count * range;
										//double co = (count / invmaxcount) * 256;
										//int co2 = (int) co;
										{
											g.drawTexturedModalRect((ix / 2 - 16) * 8, (jy / 2 - 84) * 8, 0, 0, (int)mob_range,
													256);
										}
									}
									GL11.glPopMatrix();
									GL11.glPushMatrix();
									{
										GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
												GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
												GlStateManager.SourceFactor.ONE,
												GlStateManager.DestFactor.ZERO);
										TextComponentTranslation text = new TextComponentTranslation(tile.inv_name, new Object[0]);
										fontrenderer.drawString(text.getFormattedText(), (ix / 2) - 26, (jy / 2 - 60), 0xFFFFFF);
									}
									GL11.glPopMatrix();
							}
						}
						break;
					}
				}
			}
		}
		
		
		}GL11.glPopMatrix();
	}
	
	
}

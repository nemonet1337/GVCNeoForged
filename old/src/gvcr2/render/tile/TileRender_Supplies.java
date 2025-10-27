package gvcr2.render.tile;


import java.awt.Color;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvcr2.mod_GVCR2;
import gvcr2.block.tile.TileEntity_Supplies;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockStone;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class TileRender_Supplies extends TileEntitySpecialRenderer<TileEntity_Supplies>
{
    private static final ResourceLocation tex1 = new ResourceLocation("gvcr2:textures/blocks/tile/backpack.png");
    private static final IModelCustom model1 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/backpack.mqo"));
    
    private static final ResourceLocation tex2 = new ResourceLocation("gvcr2:textures/blocks/tile/cadaver.png");
    private static final IModelCustom model2 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/cadaver.mqo"));
    
    private static final ResourceLocation tex3 = new ResourceLocation("gvcr2:textures/blocks/tile/t34breaked.png");
    private static final IModelCustom model3 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/t34breaked.mqo"));
    
    private static final ResourceLocation tex4 = new ResourceLocation("gvcr2:textures/blocks/tile/box.png");
    private static final IModelCustom model4 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/box.mqo"));
    
    private static final ResourceLocation tex5 = new ResourceLocation("gvcr2:textures/blocks/tile/scrap.png");
    private static final IModelCustom model5 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/scrap.mqo"));
    private static final ResourceLocation dirt = new ResourceLocation("textures/blocks/dirt.png");
    private static final ResourceLocation sand = new ResourceLocation("textures/blocks/sand.png");
    private static final ResourceLocation stone = new ResourceLocation("textures/blocks/stone.png");
    private static final ResourceLocation glass = new ResourceLocation("textures/blocks/glass_white.png");
    
    private static final ResourceLocation tex0 = new ResourceLocation("gvcr2:textures/blocks/tile/air_supplies.png");
    private static final IModelCustom model0 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/air_supplies.mqo"));
    
    private static final ResourceLocation tex6 = new ResourceLocation("gvcr2:textures/blocks/tile/cadaver_g.png");
    private static final IModelCustom model6 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/cadaver_g.mqo"));
    
    private ResourceLocation texture;

    public TileRender_Supplies()
    {
    }

    public void render(TileEntity_Supplies te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
    	Minecraft minecraft = Minecraft.getMinecraft();
    	
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslatef((float)x + 0.5F, (float)y + 0F, (float)z + 0.5F);
        GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
        
        if(te.facing == 1) {
        	GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
        }
        else  if(te.facing == 2) {
        	GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        }
        else  if(te.facing == 3) {
        	GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
        }
        else {
        	//GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
        }
        
        if(te.id == 1) {
        	this.bindTexture(tex1);
        	model1.renderPart("mat1");
        }
        else if(te.id == 2) {
        	this.bindTexture(tex2);
        	model2.renderPart("mat1");
        }
        else if(te.id == 3) {
        	this.bindTexture(tex3);
        	model3.renderPart("mat1");
        }
        else if(te.id == 4) {
        	this.bindTexture(tex4);
        	model4.renderPart("mat1");
        }
        else if(te.id == 5) {
        	this.bindTexture(tex5);
        	model5.renderPart("mat1");
        	World world = mod_GVCR2.proxy.getCilentWorld();
        	if(world.getBlockState(new BlockPos(te.getPos().getX(), te.getPos().getY() - 1,te.getPos().getZ())).getBlock() instanceof BlockSand) {
        		this.bindTexture(sand);
        	}
        	else if(world.getBlockState(new BlockPos(te.getPos().getX(), te.getPos().getY() - 1,te.getPos().getZ())).getBlock() instanceof BlockStone) {
        		this.bindTexture(stone);
        	}
        	/*else if(world.getBlockState(new BlockPos(te.getPos().getX(), te.getPos().getY() - 1,te.getPos().getZ())).getBlock() instanceof BlockLeaves) {
        		this.bindTexture(glass);
        	}*/
        	else {
        		this.bindTexture(dirt);
        	}
        	model5.renderPart("block");
        }
        else if(te.id == 6) {
        	this.bindTexture(tex6);
        	model6.renderPart("mat1");
        }
		else {
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			{
				if(!te.can_view) {
					GlStateManager.depthFunc(519);
					GlStateManager.disableFog();
					RenderHelper.disableStandardItemLighting();
					
					GlStateManager.enableColorMaterial();
					// GlStateManager.enableOutlineMode(this.getTeamColor(entity));//16777215
					GlStateManager.enableOutlineMode(Color.YELLOW.getRGB());// 16777215
					//RenderHelper.disableStandardItemLighting();
				}
				this.bindTexture(tex0);
				model0.renderPart("mat1");
				if(!te.can_view) {
					GlStateManager.disableOutlineMode();
					GlStateManager.disableColorMaterial();
					
					RenderHelper.enableStandardItemLighting();
					GlStateManager.depthMask(false);
					GlStateManager.enableLighting();
					GlStateManager.depthMask(true);
					GlStateManager.enableFog();
					GlStateManager.enableBlend();
					GlStateManager.enableColorMaterial();
					GlStateManager.depthFunc(515);
					GlStateManager.enableDepth();
					GlStateManager.enableAlpha();
				}
			}
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		}
        
        
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        
    }
}
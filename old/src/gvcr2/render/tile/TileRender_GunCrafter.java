package gvcr2.render.tile;


import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvcr2.block.tile.TileEntity_GunCrafter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class TileRender_GunCrafter extends TileEntitySpecialRenderer<TileEntity_GunCrafter>
{
    private static final ResourceLocation tex1 = new ResourceLocation("gvcr2:textures/blocks/tile/guncrafter_1.png");
    private static final IModelCustom model1 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/guncrafter_1.mqo"));
    
    private static final ResourceLocation tex2 = new ResourceLocation("gvcr2:textures/blocks/tile/guncrafter_2.png");
    private static final IModelCustom model2 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/guncrafter_2.mqo"));
    
    private static final ResourceLocation tex3 = new ResourceLocation("gvcr2:textures/blocks/tile/guncrafter_3.png");
    private static final IModelCustom model3 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/guncrafter_3.mqo"));

    public TileRender_GunCrafter()
    {
    }

    public void render(TileEntity_GunCrafter te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
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
        	this.bindTexture(tex2);
        	model2.renderPart("mat1");
        }else if(te.id == 2) {
        	this.bindTexture(tex3);
        	model3.renderPart("mat1");
        }else {
        	this.bindTexture(tex1);
        	model1.renderPart("mat1");
        }
        
        
        
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        
    }
}
package gvcr2.render.tile;


import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvcr2.block.tile.TileEntity_BulletCrafter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class TileRender_BulletCrafter extends TileEntitySpecialRenderer<TileEntity_BulletCrafter>
{
    private static final ResourceLocation tex1 = new ResourceLocation("gvcr2:textures/blocks/tile/bulletcrafter.png");
    private static final IModelCustom model1 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/bulletcrafter.mqo"));

    public TileRender_BulletCrafter()
    {
    }

    public void render(TileEntity_BulletCrafter te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
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
        
        this.bindTexture(tex1);
        model1.renderPart("mat1");
        
        
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        
    }
}
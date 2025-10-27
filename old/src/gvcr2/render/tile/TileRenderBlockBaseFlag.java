package gvcr2.render.tile;


import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvcr2.block.tile.TileEntityBlockBaseFlag;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class TileRenderBlockBaseFlag extends TileEntitySpecialRenderer<TileEntityBlockBaseFlag>
{
	private static final ResourceLocation flag_ge = new ResourceLocation("gvcr2:textures/blocks/tile/baseflag.png");
	private static final ResourceLocation flag_so = new ResourceLocation("gvcr2:textures/blocks/tile/baseflag_so.png");
    private static final IModelCustom flag = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/baseflag.mqo"));
    private ResourceLocation texture;
    private boolean field_147509_j;
    private static final String __OBFID = "CL_00000965";

    public TileRenderBlockBaseFlag()
    {
    }

    public void render(TileEntityBlockBaseFlag te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
    	Minecraft minecraft = Minecraft.getMinecraft();
    	
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslatef((float)x + 0.5F, (float)y + 0F, (float)z + 0.5F);
        //GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
        if(te.enemy) {
        	this.bindTexture(flag_ge);
        }else {
        	this.bindTexture(flag_so);
        }
        flag.renderPart("mat1");
        flag.renderPart("mat3");
        
        double count = te.getClientInvCount(te);
		double invmaxcount = te.getClientInvMaxCount(te);
		double co = (count / invmaxcount) * 2.5;
		if(te.enemy) {
			GL11.glTranslatef(0.0F, (float)(-co), 0.0F);
			flag.renderPart("flag");
        }else {
        	GL11.glTranslatef(0.0F, (float)(-co), 0.0F);
        	flag.renderPart("flag");
        }
        
        
        GL11.glColor4f(1F, 1F, 1F, 1F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        
    }
}
package gvcr2.render.tile;


import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvcr2.block.tile.TileEntityBlockSpawn_Spawner;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class TileRenderBlockSpawn_Spawner extends TileEntitySpecialRenderer<TileEntityBlockSpawn_Spawner>
{
    private static final ResourceLocation box = new ResourceLocation("gvcr2:textures/blocks/tile/beacon.png");
    private static final ResourceLocation box_so = new ResourceLocation("gvcr2:textures/blocks/tile/beacon_so.png");
    private static final IModelCustom box_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/beacon.mqo"));
    
    private static final ResourceLocation bouy = new ResourceLocation("gvcr2:textures/blocks/tile/buoy.png");
    private static final IModelCustom bouy_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/buoy.mqo"));
    
    private static final ResourceLocation jamming = new ResourceLocation("gvcr2:textures/blocks/tile/jamming.png");
    private static final IModelCustom jamming_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/jamming.mqo"));

    public TileRenderBlockSpawn_Spawner()
    {
    }

    public void render(TileEntityBlockSpawn_Spawner te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
    	Minecraft minecraft = Minecraft.getMinecraft();
    	
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslatef((float)x + 0.5F, (float)y + 0F, (float)z + 0.5F);
        //GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
        if(te.id == 3) {
        	GL11.glTranslatef(0.0F, -0.5F, 0.0F);
             this.bindTexture(bouy);
             bouy_model.renderPart("mat1");
        }else if(te.id == 2) {
            this.bindTexture(jamming);
            jamming_model.renderPart("mat1");
       }
        else {
        	 if(te.id == 1) {
             	this.bindTexture(box_so);
             }else {
             	this.bindTexture(box);
             }
             box_model.renderPart("mat1");
        }
        GL11.glColor4f(1F, 1F, 1F, 1F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        
    }
}
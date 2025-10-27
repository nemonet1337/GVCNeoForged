package gvcr2.render.tile;


import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvcr2.block.tile.TileEntity_Mine;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class TileRender_Mine extends TileEntitySpecialRenderer<TileEntity_Mine>
{
    private static final ResourceLocation at = new ResourceLocation("gvcr2:textures/blocks/tile/atmine.png");
    private static final IModelCustom atm = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/atmine.mqo"));
    
    private static final ResourceLocation ah = new ResourceLocation("gvcr2:textures/blocks/tile/ahmine.png");
    private static final IModelCustom ahm = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/ahmine.mqo"));
    
    private static final ResourceLocation ied = new ResourceLocation("gvcr2:textures/blocks/tile/ied.png");
    private static final IModelCustom iedm = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/ied.mqo"));
    
    private static final ResourceLocation bomb = new ResourceLocation("gvcr2:textures/blocks/tile/bomb.png");
    private static final IModelCustom bombm = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/bomb.mqo"));
    
    private static final ResourceLocation watermine = new ResourceLocation("gvcr2:textures/blocks/tile/water_mine.png");
    private static final IModelCustom waterminem = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/water_mine.mqo"));
    
    private static final ResourceLocation propane = new ResourceLocation("gvcr2:textures/blocks/tile/propane.png");
    private static final IModelCustom propanem = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/propane.mqo"));
    
    
    
    private static final ResourceLocation ammobox1 = new ResourceLocation("gvcr2:textures/blocks/tile/ammobox1.png");
    private static final IModelCustom ammobox1m = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/ammobox1.mqo"));
    private static final ResourceLocation artibox1 = new ResourceLocation("gvcr2:textures/blocks/tile/artibox1.png");
    private static final IModelCustom artibox1m = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/artibox1.mqo"));
    private static final ResourceLocation artibox2 = new ResourceLocation("gvcr2:textures/blocks/tile/artibox2.png");
    private static final IModelCustom artibox2m = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/artibox2.mqo"));
    private static final ResourceLocation artibox3 = new ResourceLocation("gvcr2:textures/blocks/tile/artibox3.png");
    private static final IModelCustom artibox3m = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/artibox3.mqo"));
    private static final ResourceLocation barrel_drum1 = new ResourceLocation("gvcr2:textures/blocks/tile/barrel_drum1.png");
    private static final ResourceLocation barrel_drum2 = new ResourceLocation("gvcr2:textures/blocks/tile/barrel_drum2.png");
    private static final ResourceLocation barrel_drum3 = new ResourceLocation("gvcr2:textures/blocks/tile/barrel_drum3.png");
    private static final IModelCustom barrel_drum = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/barrel_drum.mqo"));
    private static final ResourceLocation Jerrycan1 = new ResourceLocation("gvcr2:textures/blocks/tile/Jerrycan1.png");
    private static final IModelCustom Jerrycan1m = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/Jerrycan1.mqo"));
    private static final ResourceLocation missile_rack1 = new ResourceLocation("gvcr2:textures/blocks/tile/missile_rack1.png");
    private static final IModelCustom missile_rack1m = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/missile_rack1.mqo"));
    
    private ResourceLocation texture;
    private boolean field_147509_j;
    private static final String __OBFID = "CL_00000965";

    public TileRender_Mine()
    {
    }

    public void render(TileEntity_Mine te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
    	Minecraft minecraft = Minecraft.getMinecraft();
    	
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslatef((float)x + 0.5F, (float)y + 0F, (float)z + 0.5F);
        GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
        if(te.id == 1) {
        	this.bindTexture(at);
        	atm.renderPart("mat1");
        }
        else if(te.id == 2) {
        	this.bindTexture(ied);
        	iedm.renderPart("mat1");
        }
        else if(te.id == 3) {
        	this.bindTexture(bomb);
        	bombm.renderPart("mat1");
        }
        else if(te.id == 4) {
        	GL11.glTranslatef(0.0F, -0.5F, 0.0F);
        	this.bindTexture(watermine);
        	waterminem.renderPart("mat1");
        }
        else if(te.id == 5) {
        	this.bindTexture(propane);
        	propanem.renderPart("mat1");
        }
        else if(te.id == 6) {
        	this.bindTexture(ammobox1);
        	ammobox1m.renderPart("mat1");
        }
        else if(te.id == 7) {
        	this.bindTexture(artibox1);
        	artibox1m.renderPart("mat1");
        }
        else if(te.id == 8) {
        	this.bindTexture(artibox2);
        	artibox2m.renderPart("mat1");
        }
        else if(te.id == 9) {
        	this.bindTexture(artibox3);
        	artibox3m.renderPart("mat1");
        }
        else if(te.id == 10) {
        	this.bindTexture(barrel_drum1);
        	barrel_drum.renderPart("mat1");
        }
        else if(te.id == 11) {
        	this.bindTexture(barrel_drum2);
        	barrel_drum.renderPart("mat1");
        }
        else if(te.id == 12) {
        	this.bindTexture(barrel_drum3);
        	barrel_drum.renderPart("mat1");
        }
        else if(te.id == 13) {
        	this.bindTexture(Jerrycan1);
        	Jerrycan1m.renderPart("mat1");
        }
        else if(te.id == 13) {
        	this.bindTexture(missile_rack1);
        	missile_rack1m.renderPart("mat1");
        }
        
        else {
        	this.bindTexture(ah);
        	ahm.renderPart("mat1");
        }
        
        
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        
    }
}
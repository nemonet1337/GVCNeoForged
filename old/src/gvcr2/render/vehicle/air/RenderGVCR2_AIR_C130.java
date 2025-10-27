package gvcr2.render.vehicle.air;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.render.RenderCanMobRidding;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_C130;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class RenderGVCR2_AIR_C130 extends Render<EntityGVCR2_AIR_C130>
{
    private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/aircraft/c130.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/aircraft/c130.mqo"));
    /** instance of ModelBoat for rendering */

    public RenderGVCR2_AIR_C130(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.shadowSize = 4.5F;
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    float iii;
    public void doRender(EntityGVCR2_AIR_C130 entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.bindEntityTexture(entity);
		
		
        GL11.glPushMatrix();//glstart
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		
		if(entity.deathTicks > 0 && !entity.onGround){
			GL11.glRotatef(entity.deathTicks*2, 0.0F, 0.0F, 1.0F);
		}
		
		if(entity.deathTicks > 0){
			GL11.glColor4f(0.1F, 0.1F, 0.1F, 1F);
		}else{
			GL11.glColor4f(1F, 1F, 1F, 1F);
		}
		
		GL11.glRotatef(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
		tankk.renderPart("mat1");
		tankk.renderPart("eg_1");
		tankk.renderPart("eg_2");
		tankk.renderPart("eg_3");
		tankk.renderPart("eg_4");
		{
			GL11.glPushMatrix();//glstart
			GL11.glTranslatef(0.0F, 0.4F, -3.5F);
			GL11.glRotatef(-30, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-0.0F, -0.4F, 3.5F);
			tankk.renderPart("door1");
			GL11.glPopMatrix();//glend
		}
		{
			GL11.glPushMatrix();//glstart
			GL11.glTranslatef(0.0F, 2.5F, -9F);
			GL11.glRotatef(-30, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-0.0F, -2.5F, 9F);
			tankk.renderPart("door2");
			GL11.glPopMatrix();//glend
		}
		{
			for(int t1 = 0; t1 < entity.pera; ++t1){
    			GL11.glPushMatrix();//glstart
    			String tu1 = String.valueOf(t1 + 1);
				GL11.glTranslatef(entity.pera_x[t1], entity.pera_y[t1], entity.pera_z[t1]);//0,1,2.5
				GL11.glRotatef((float) entity.thpera, entity.perarote_x[t1], entity.perarote_y[t1], entity.perarote_z[t1]);
				GL11.glTranslatef(-entity.pera_x[t1], -entity.pera_y[t1], -entity.pera_z[t1]);
				tankk.renderPart("pera_" + tu1);
				GL11.glPopMatrix();//glend
			}
		}
			
			
		
		//RenderCanMobRidding.can(entity);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glPopMatrix();//glend
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGVCR2_AIR_C130 entity)
    {
    	{
			return boatTextures;
		}
    }
    
    protected void renderLivingAt(EntityGVCR2_AIR_C130 entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_AIR_C130 livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
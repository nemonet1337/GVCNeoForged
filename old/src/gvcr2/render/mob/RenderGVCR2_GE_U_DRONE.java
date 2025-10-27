package gvcr2.render.mob;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvcr2.entity.mob.EntityGVCR2_GE_U_DRONE;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class RenderGVCR2_GE_U_DRONE extends Render<EntityGVCR2_GE_U_DRONE>
{
    private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/robo/drone.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/robo/drone.mqo"));
    /** instance of ModelBoat for rendering */

    public RenderGVCR2_GE_U_DRONE(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.shadowSize = 0.5F;
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    float iii;
    public void doRender(EntityGVCR2_GE_U_DRONE entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.bindEntityTexture(entity);
		
		
        GL11.glPushMatrix();//glstart
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		if(entity.deathTime > 0){
			GL11.glColor4f(0.1F, 0.1F, 0.1F, 1F);
		}else{
			GL11.glColor4f(1F, 1F, 1F, 1F);
		}
		GL11.glRotatef(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
			tankk.renderPart("mat1");
			tankk.renderPart("mat2");
			if(iii < 360F){
				iii = iii + 30F;
			}else{
	 			iii = 0F;
	 		}
			float xx = 0.5F;
			float yy = 0.45F;
			float zz = 0.325F;
			{
				GL11.glPushMatrix();//glstart
				GL11.glTranslatef(xx, yy, zz);
	 			GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - iii, 0.0F, 1.0F, 0.0F);
	 			GL11.glTranslatef(-xx, -yy, -zz);
				tankk.renderPart("pera_1");
				GL11.glPopMatrix();//glend
			}
			{
				GL11.glPushMatrix();//glstart
				GL11.glTranslatef(-xx, yy, zz);
	 			GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - iii, 0.0F, 1.0F, 0.0F);
	 			GL11.glTranslatef(xx, -yy, -zz);
				tankk.renderPart("pera_2");
				GL11.glPopMatrix();//glend
			}
			{
				GL11.glPushMatrix();//glstart
				GL11.glTranslatef(xx, yy,- zz);
	 			GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - iii, 0.0F, 1.0F, 0.0F);
	 			GL11.glTranslatef(-xx, -yy, zz);
				tankk.renderPart("pera_3");
				GL11.glPopMatrix();//glend
			}
			{
				GL11.glPushMatrix();//glstart
				GL11.glTranslatef(-xx, yy, -zz);
	 			GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - iii, 0.0F, 1.0F, 0.0F);
	 			GL11.glTranslatef(xx, -yy, zz);
				tankk.renderPart("pera_4");
				GL11.glPopMatrix();//glend
			}
			
		GL11.glRotatef(-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glPopMatrix();//glend
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGVCR2_GE_U_DRONE entity)
    {
        return boatTextures;
    }
    
    protected void renderLivingAt(EntityGVCR2_GE_U_DRONE entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_GE_U_DRONE livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
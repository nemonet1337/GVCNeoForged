package gvcr2.render.boss;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvcr2.entity.boss.EntityGVCR2_EE_Shark;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class RenderGVCR2_EE_Shark extends Render<EntityGVCR2_EE_Shark>
{
    private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/mob/shark.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/mob/shark.mqo"));
    /** instance of ModelBoat for rendering */

    public RenderGVCR2_EE_Shark(RenderManager renderManagerIn)
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
    
    float arm_x = 0F;
    float arm_y = 0.87F;
    float arm_z = 0F;
    
    float hand_x = -0.4F;
    float hand_y = 1.3F;
    float hand_z = 0F;
    
    public void doRender(EntityGVCR2_EE_Shark entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.bindEntityTexture(entity);
		
		
		GL11.glPushMatrix();//glstart
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glRotatef(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
			//tankk.renderPart("mat1");
		if(entity.cooltime < 10) {
			//GL11.glRotatef(30, 1.0F, 0.0F, 0.0F);
		}else {
			GL11.glRotatef(entity.cooltime * 2, -1.0F, 0.0F, 0.0F);
		}
		tankk.renderPart("mat1");
		{
			GL11.glPushMatrix();//glstart
			GL11.glTranslatef(0, 2.25F, 0);
			if(entity.cooltime < 15) {
				GL11.glRotatef(-30, 1.0F, 0.0F, 0.0F);
			}else {
				GL11.glRotatef(0, 1.0F, 0.0F, 0.0F);
			}
			GL11.glTranslatef(0, -2.25F, 0);
			tankk.renderPart("mat2");
			GL11.glPopMatrix();//glend
		}
		{
			GL11.glPushMatrix();//glstart
			GL11.glTranslatef(0, 2.25F, 0);
			if(entity.cooltime < 15) {
				GL11.glRotatef(30, 1.0F, 0.0F, 0.0F);
			}else {
				GL11.glRotatef(0, 1.0F, 0.0F, 0.0F);
			}
			GL11.glTranslatef(0, -2.25F, 0);
			tankk.renderPart("mat3");
			GL11.glPopMatrix();//glend
		}
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();//glend
		
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGVCR2_EE_Shark entity)
    {
        return boatTextures;
    }
    
    protected void renderLivingAt(EntityGVCR2_EE_Shark entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_EE_Shark livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
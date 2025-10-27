package gvcr2.render.mob;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.render.ModelBase_Non;
import gvclib.render.RenderCanMobRidding;
import gvcr2.entity.mob.EntityGVCR2_GE_Jamming;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class Render_GE_Jamming extends RenderLiving<EntityGVCR2_GE_Jamming>
{
	private static final ResourceLocation jamming = new ResourceLocation("gvcr2:textures/blocks/tile/jamming.png");
    private static final IModelCustom jamming_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/jamming.mqo"));
    /** instance of ModelBoat for rendering */

    public Render_GE_Jamming(RenderManager renderManagerIn)
    {
    	super(renderManagerIn, new ModelBase_Non(),0.5F);
        this.shadowSize = 0.5F;
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    float iii;
    public void doRender(EntityGVCR2_GE_Jamming entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	this.bindEntityTexture(entity);
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);

		if(entity.deathTicks > 0){
			GL11.glColor4f(0.1F, 0.1F, 0.1F, 1F);
		}
		GL11.glRotatef(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
		//get_world_rotation(entity);
		jamming_model.renderPart("mat1");
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGVCR2_GE_Jamming entity)
    {
    	{
			return jamming;
		}
    }
    
    protected void renderLivingAt(EntityGVCR2_GE_Jamming entityLivingBaseIn, double x, double y, double z)
    {
    	GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_GE_Jamming livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
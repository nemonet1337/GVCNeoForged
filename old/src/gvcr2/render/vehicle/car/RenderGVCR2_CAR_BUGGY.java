package gvcr2.render.vehicle.car;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.render.ModelBase_Non;
import gvclib.render.RenderAngleSystem;
import gvclib.render.RenderCanMobRidding;
import gvcr2.mod_GVCR2;
import gvcr2.entity.vehicle.car.EntityGVCR2_CAR_BUGGY;
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
public class RenderGVCR2_CAR_BUGGY extends RenderLiving<EntityGVCR2_CAR_BUGGY>
{
    private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/car/buggy.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/car/buggy.mqo"));
    /** instance of ModelBoat for rendering */

    public RenderGVCR2_CAR_BUGGY(RenderManager renderManagerIn)
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
    public void doRender(EntityGVCR2_CAR_BUGGY entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.bindEntityTexture(entity);
		
		
		GL11.glPushMatrix();//glstart
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		if(entity.deathTicks > 0){
			GL11.glColor4f(0.1F, 0.1F, 0.1F, 1F);
		}else{
			GL11.glColor4f(1F, 1F, 1F, 1F);
		}
		if(mod_GVCR2.cfg_vehicle_angle) {
			boolean flag1 = false;
			RenderAngleSystem angle_system = new RenderAngleSystem();
			flag1 = angle_system.angle_rote(entity);
			
			GL11.glRotatef(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
			
			angle_system.render_riddir(entity, boatTextures, flag1, entityYaw, partialTicks);
		}else {
			GL11.glRotatef(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
		}
			//tankk.renderPart("mat1");
		tankk.renderAll();
		//tankk.renderPart("obj1");
		RenderCanMobRidding.can(entity);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();//glend
		
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGVCR2_CAR_BUGGY entity)
    {
        return boatTextures;
    }
    
    protected void renderLivingAt(EntityGVCR2_CAR_BUGGY entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_CAR_BUGGY livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
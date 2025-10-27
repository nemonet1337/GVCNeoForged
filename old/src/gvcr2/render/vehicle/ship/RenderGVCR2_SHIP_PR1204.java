package gvcr2.render.vehicle.ship;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.render.ModelBase_Non;
import gvclib.render.RenderCanMobRidding;
import gvclib.render.RenderLaserSight;
import gvcr2.entity.vehicle.ship.EntityGVCR2_SHIP_PR1204;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class RenderGVCR2_SHIP_PR1204 extends RenderLiving<EntityGVCR2_SHIP_PR1204>
{
    private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/ship/pr1204.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/ship/pr1204.mqo"));
    /** instance of ModelBoat for rendering */

    public RenderGVCR2_SHIP_PR1204(RenderManager renderManagerIn)
    {
    	super(renderManagerIn, new ModelBase_Non(),0.5F);
        this.shadowSize = 2.5F;
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    float iii;
    public void doRender(EntityGVCR2_SHIP_PR1204 entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	this.bindEntityTexture(entity);
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);

		if(entity.deathTicks > 0){
			GL11.glColor4f(0.1F, 0.1F, 0.1F, 1F);
		}
		//GL11.glTranslatef(0.0F, 0.5F, 0.0F);
		GL11.glRotatef(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
		tankk.renderPart("mat1");
		tankk.renderPart("mat2");
		
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(0F, 2.25F, 4.0F);
			GL11.glRotatef(180.0F - entity.rotation -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0F, -2.25F, -4.0F);
			tankk.renderPart("mat4_1");
			GL11.glTranslatef(0F, 2.25F, 4.8F);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-0F, -2.25F, -4.8F);
			tankk.renderPart("mat5_1");
			if(!entity.counter1){
				if(entity.cooltime >= 0 && entity.cooltime < 4){
					GL11.glTranslatef(0.0F, 0.0F, -entity.cooltime * 0.4F);
				}
				if(entity.cooltime >= 4 && entity.cooltime < 15){
					GL11.glTranslatef(0.0F, 0.0F, -1.2F);
					GL11.glTranslatef(0.0F, 0.0F, entity.cooltime * 0.1F);
				}
			}
			tankk.renderPart("mat6_1");
			if(entity.getControllingPassenger() != null && entity.getControllingPassenger() == Minecraft.getMinecraft().player){
				if(entity.getRemain_L() > 0)RenderLaserSight.can(entity, 0.0F, 2.25F, 4.0F, 1.0F, boatTextures);
			}
		}
		
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(0F, 2.4F, -7.2F);
			GL11.glRotatef(180.0F - entity.rotation -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0F, -2.4F, 7.2F);
			tankk.renderPart("mat4_2");
			GL11.glTranslatef(0F, 2.4F, -7.2F);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-0F, -2.4F, 7.2F);
			tankk.renderPart("mat5_2");
			if(!entity.counter2){
				if(entity.cooltime2 >= 0 && entity.cooltime2 < 2){
					GL11.glTranslatef(0.0F, 0.0F, -entity.cooltime2 * 0.4F);
				}
			}
			tankk.renderPart("mat6_2");
			if(entity.getControllingPassenger() != null && entity.getControllingPassenger() == Minecraft.getMinecraft().player){
				if(entity.getRemain_R() > 0)RenderLaserSight.can(entity, 0.0F, 2.4F, -7.2F, 1.0F, boatTextures);
			}
		}
		GL11.glPopMatrix();
		
		
		
		RenderCanMobRidding.can(entity);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGVCR2_SHIP_PR1204 entity)
    {
			return boatTextures;
    }
    
    protected void renderLivingAt(EntityGVCR2_SHIP_PR1204 entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_SHIP_PR1204 livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
package gvcr2.render.vehicle.ship;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.render.ModelBase_Non;
import gvclib.render.RenderCanMobRidding;
import gvcr2.entity.vehicle.ship.EntityGVCR2_SHIP_RCB;
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
public class RenderGVCR2_SHIP_RCB extends RenderLiving<EntityGVCR2_SHIP_RCB>
{
    private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/ship/rcb90.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/ship/rcb90.mqo"));
    /** instance of ModelBoat for rendering */

    public RenderGVCR2_SHIP_RCB(RenderManager renderManagerIn)
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
    public void doRender(EntityGVCR2_SHIP_RCB entity, double x, double y, double z, float entityYaw, float partialTicks)
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
		if(entity.getArmID_L() == 0){
			GL11.glTranslatef(0F, 0.0F, 0.0F);
			GL11.glRotatef(180.0F - entity.rotation -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0F, 0.0F, 0.0F);
			tankk.renderPart("mat4_1");
			GL11.glTranslatef(0F, 2.8F, 0.0F);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-0F, -2.8F, 0.0F);
			tankk.renderPart("mat5_1");
		}
		if(entity.getArmID_L() == 1){
			tankk.renderPart("mat2_2");
			GL11.glTranslatef(0F, 2.9F, 0F);
			GL11.glRotatef(180.0F - entity.rotation -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0F, -2.9F, -0F);
			tankk.renderPart("mat4_2");
			GL11.glTranslatef(0F, 2.9F, 0.5F);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0F, -2.9F, -0.5F);
			tankk.renderPart("mat5_2");
			GL11.glTranslatef(0F, 2.9F, 0.5F);
			GL11.glRotatef(entity.getRemain_L() * 30, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(0F, -2.9F, -0.5F);
			tankk.renderPart("mat6_2");
		}
		if(entity.getArmID_L() == 2){
			GL11.glTranslatef(0F, 0.0F, 0.0F);
			GL11.glRotatef(180.0F - entity.rotation -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0F, 0.0F, 0.0F);
			tankk.renderPart("mat4_3");
			GL11.glTranslatef(0F, 2.8F, 0.0F);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-0F, -2.8F, 0.0F);
			tankk.renderPart("mat5_3");
		}
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		if(entity.getArmID_R() == 0){
			GL11.glTranslatef(0F, 0.0F, -3.2F);
			GL11.glRotatef(180.0F - entity.rotation -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0F, 0.0F, 3.2F);
			tankk.renderPart("mat7_1");
			GL11.glTranslatef(0F, 2.0F, -3.2F);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-0F, -2.0F, 3.2F);
			tankk.renderPart("mat8_1");
		}
		if(entity.getArmID_R() == 1){
			GL11.glTranslatef(0F, 0.0F, -3.2F);
			GL11.glRotatef(180.0F - entity.rotation -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0F, 0.0F, 3.2F);
			tankk.renderPart("mat7_2");
			GL11.glTranslatef(0F, 2.0F, -3.2F);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-0F, -2.0F, 3.2F);
			tankk.renderPart("mat8_2");
		}
		if(entity.getArmID_R() == 2){
			GL11.glTranslatef(0F, 0.0F, -3.2F);
			GL11.glRotatef(180.0F - entity.rotation -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0F, 0.0F, 3.2F);
			tankk.renderPart("mat7_3");
			GL11.glTranslatef(0F, 2.0F, -3.2F);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-0F, -2.0F, 3.2F);
			tankk.renderPart("mat8_3");
		}
		GL11.glPopMatrix();
		
		{
			GL11.glPushMatrix();
			tankk.renderPart("mat4_1_l");
			GL11.glTranslatef(1.4F, 1.9F, -3.0F);
			 if(entity.getPassengers().size() > 2 && entity.getPassengers().get(2) != null){
				 GL11.glRotatef(180.0F - entity.rotation_3-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(entity.rotationp_3, 1.0F, 0.0F, 0.0F);
			 }else {
				    GL11.glRotatef((180.0F - entity.rotationYaw + 90)-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(30, 1.0F, 0.0F, 0.0F);
			 }
			GL11.glTranslatef(-1.4F, -1.9F, 3.0F);
			tankk.renderPart("mat5_1_l");
			GL11.glPopMatrix();
		}
		{
			GL11.glPushMatrix();
			tankk.renderPart("mat4_1_r");
			GL11.glTranslatef(-1.4F, 1.9F, -3.0F);
			if(entity.getPassengers().size() > 3 && entity.getPassengers().get(3) != null){
				 GL11.glRotatef(180.0F - entity.rotation_4-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(entity.rotationp_4, 1.0F, 0.0F, 0.0F);
			 }else {
				 //GL11.glRotatef(180.0F - entity.rotation_2-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
				 GL11.glRotatef((180.0F - entity.rotationYaw - 90)-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(30, 1.0F, 0.0F, 0.0F);
			 }
			GL11.glTranslatef(1.4F, -1.9F, 3.0F);
			tankk.renderPart("mat5_1_r");
			GL11.glPopMatrix();
		}
		
		RenderCanMobRidding.can(entity);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGVCR2_SHIP_RCB entity)
    {
			return boatTextures;
    }
    
    protected void renderLivingAt(EntityGVCR2_SHIP_RCB entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_SHIP_RCB livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
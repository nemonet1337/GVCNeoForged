package gvcr2.render.vehicle.air;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.mod_GVCLib;
import gvclib.render.ModelBase_Non;
import gvclib.render.RenderAngleSystem;
import gvclib.render.RenderBomber_Target;
import gvclib.render.RenderCanMobRidding;
import gvclib.render.RenderCanopy;
import gvclib.render.RenderExhaust;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_A10;
import net.minecraft.client.Minecraft;
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
public class RenderGVCR2_AIR_A10 extends RenderLiving<EntityGVCR2_AIR_A10>
{
    private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/aircraft/a10.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/aircraft/a10.mqo"));
    /** instance of ModelBoat for rendering */

    public RenderGVCR2_AIR_A10(RenderManager renderManagerIn)
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
    public void doRender(EntityGVCR2_AIR_A10 entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.bindEntityTexture(entity);
		
		
        GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);

		if(entity.getControllingPassenger() != null && entity.getControllingPassenger() == Minecraft.getMinecraft().player){
			RenderBomber_Target.can(entity, 7.5F);
			Minecraft.getMinecraft().renderEngine.bindTexture(boatTextures);
		}
		
		//　_傾きシステム
				boolean flag1 = false;
				RenderAngleSystem angle_system = new RenderAngleSystem();
				flag1 = angle_system.angle_rote(entity);
				
				if(entity.deathTicks > 0){
					GL11.glColor4f(0.1F, 0.1F, 0.1F, 1F);
				}
				
				GL11.glRotatef(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
				
				//　_傾きシステム
				angle_system.render_riddir(entity, boatTextures, flag1, entityYaw, partialTicks);
		if(!entity.onGround){
			GL11.glTranslatef(0, (float)(entity.riddingy[0] + 1.25F), 0.0F);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(entity.throte, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(0, -(float)(entity.riddingy[0] + 1.25F), -0.0F);
		}
		
		if(entity.deathTicks > 0 && !entity.onGround){
		GL11.glTranslatef(0, 1.6F, 0);
		GL11.glRotatef(entity.deathTicks*6, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(0, -1.6F, 0);
		}
		boolean flag = false;
		if(entity.getControllingPassenger() != null && entity.getControllingPassenger() == Minecraft.getMinecraft().player){
			boolean right = mod_GVCLib.proxy.rightclick();// 1
			if(Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && right){
				flag = true;
			}
		}
		
		if(!flag) {
			tankk.renderPart("mat1");
			tankk.renderPart("mat2");
			tankk.renderPart("seat");
			tankk.renderPart("mat4_1");
			tankk.renderPart("mat5_1");
			
			{
				RenderExhaust.can(entity, 1.4F, 2.5F, -6.9F, 1.0F, false, boatTextures);
				RenderExhaust.can(entity, -1.4F, 2.5F, -6.9F, 1.0F, false, boatTextures);
			}
			
			if(entity.getFTMode() == 30
					|| entity.getFTMode() == 31
					|| entity.getFTMode() == 32
					|| entity.getFTMode() == 33
					|| entity.getFTMode() == 34) {
				tankk.renderPart("bomb");
			}
			else{
				if(entity.getArmID_R() == 1) {
					tankk.renderPart("weapon_rocket");
					tankk.renderPart("weapon_b");
				}
				else {
					tankk.renderPart("weapon_agm");
					tankk.renderPart("weapon_b");
				}
			}
			
			if(entity.onGround){
				tankk.renderPart("gear");
			}else{
				tankk.renderPart("gear_up");
			}
			{
				RenderCanopy.can(entity, tankk);
			}
		}
			RenderCanMobRidding.can(entity);
		GL11.glRotatef(-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

     private void renderAngle(EntityGVCR2_AIR_A10 p_76986_1_, int i){
		{
			GL11.glRotatef(-(p_76986_1_.angletime), 1.0F, 0.0F, 0.0F);
		}
	}
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGVCR2_AIR_A10 entity)
    {
    	{
			return boatTextures;
		}
    }
    
    protected void renderLivingAt(EntityGVCR2_AIR_A10 entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_AIR_A10 livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
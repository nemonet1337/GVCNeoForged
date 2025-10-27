package gvcr2.render.vehicle.heli;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.render.ModelBase_Non;
import gvclib.render.RenderCanMobRidding;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_UH60;
import hmggirlfront.entity.vehicle.EntityVe_Heli;
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
public class RenderGVCR2_HELI_UH60 extends RenderLiving<EntityGVCR2_HELI_UH60>
{
    private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/heli/uh60.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/heli/uh60.mqo"));
    /** instance of ModelBoat for rendering */

    public RenderGVCR2_HELI_UH60(RenderManager renderManagerIn)
    {
    	super(renderManagerIn, new ModelBase_Non(),0.5F);
        this.shadowSize = 2.0F;
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    float iii;
    public void doRender(EntityGVCR2_HELI_UH60 entity, double x, double y, double z, float entityYaw, float partialTicks)
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
		//GL11.glTranslatef(0, 1.6F, 0);
		//this.renderAngle(entity, 1);
		//if(!entity.onGround)
		if(!entity.onGround){
		//GL11.glTranslatef(0, 1.5F, 1.8F);
		GL11.glTranslatef(0, (float)(entity.riddingy[0] + 1.25F), 0F);
		GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(entity.throte, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(0, -(float)(entity.riddingy[0] + 1.25F), 0F);
		//GL11.glTranslatef(0, -1.5F, -1.8F);
		}
		//GL11.glTranslatef(0, -1.6F, 0);
		
		if(entity.deathTicks > 0){
		GL11.glTranslatef(0, 1.6F, 0);
		GL11.glRotatef(entity.deathTicks*6, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0, -1.6F, 0);
		}
			tankk.renderPart("mat1");
			tankk.renderPart("seat_1");
			tankk.renderPart("seat_2");
			tankk.renderPart("door");
			tankk.renderPart("tank");
			if(entity.getArmID_L() == 1){
				tankk.renderPart("mat6_1");
			}
			if(entity.getArmID_L() == 2){
				tankk.renderPart("mat6_2");
			}
			{
				GL11.glPushMatrix();
				tankk.renderPart("mat4_1_l");
				GL11.glTranslatef(1.6F, 1.475F, -0.35F);
				 if(entity.getPassengers().size() > 2 && entity.getPassengers().get(2) != null){
					 GL11.glRotatef(180.0F - entity.rotation_3-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
						GL11.glRotatef(entity.rotationp_3, 1.0F, 0.0F, 0.0F);
				 }else {
					    GL11.glRotatef((180.0F - entity.rotationYaw + 90)-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
						GL11.glRotatef(30, 1.0F, 0.0F, 0.0F);
				 }
				 GL11.glTranslatef(-1.6F, -1.475F, 0.35F);
				tankk.renderPart("mat5_1_l");
				GL11.glPopMatrix();
			}
			{
				GL11.glPushMatrix();
				tankk.renderPart("mat4_1_r");
				GL11.glTranslatef(-1.6F, 1.475F, -0.35F);
				if(entity.getPassengers().size() > 3 && entity.getPassengers().get(3) != null){
					 GL11.glRotatef(180.0F - entity.rotation_4-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
						GL11.glRotatef(entity.rotationp_4, 1.0F, 0.0F, 0.0F);
				 }else {
					 //GL11.glRotatef(180.0F - entity.rotation_2-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
					 GL11.glRotatef((180.0F - entity.rotationYaw - 90)-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
						GL11.glRotatef(30, 1.0F, 0.0F, 0.0F);
				 }
				GL11.glTranslatef(1.6F, -1.475F, 0.35F);
				tankk.renderPart("mat5_1_r");
				GL11.glPopMatrix();
			}
			
			{
				GL11.glPushMatrix();
				GL11.glTranslatef(0, 4F, 0F);
				GL11.glRotatef((float) entity.thpera, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0, -4F, -0F);
				tankk.renderPart("pera_1");
				GL11.glPopMatrix();
			}
			{
				GL11.glPushMatrix();
				GL11.glTranslatef(0, 4.24F, -8.16F);
				GL11.glRotatef((float) entity.thpera, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(0, -4.24F, 8.16F);
				tankk.renderPart("pera_2");
				GL11.glPopMatrix();
			}
			RenderCanMobRidding.can(entity);
		GL11.glRotatef(-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

     private void renderAngle(EntityGVCR2_HELI_UH60 p_76986_1_, int i){
		{
			GL11.glRotatef(-(p_76986_1_.angletime), 1.0F, 0.0F, 0.0F);
		}
	}
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGVCR2_HELI_UH60 entity)
    {
    	{
			return boatTextures;
		}
    }
    
    protected void renderLivingAt(EntityGVCR2_HELI_UH60 entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_HELI_UH60 livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
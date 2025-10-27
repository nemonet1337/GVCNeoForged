package gvcr2.render.vehicle.ship;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.mod_GVCLib;
import gvclib.render.ModelBase_Non;
import gvclib.render.RenderBomber_Target;
import gvclib.render.RenderCanMobRidding;
import gvclib.render.RenderLaserSight;
import gvclib.render.RenderSPG_Target;
import gvcr2.entity.vehicle.ship.EntityGVCR2_SHIP_HAMINA;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
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
public class RenderGVCR2_SHIP_HAMINA extends RenderLiving<EntityGVCR2_SHIP_HAMINA>
{
    private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/ship/hamina.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/ship/hamina.mqo"));
    /** instance of ModelBoat for rendering */

    public RenderGVCR2_SHIP_HAMINA(RenderManager renderManagerIn)
    {
    	super(renderManagerIn, new ModelBase_Non(),0.5F);
        this.shadowSize = 2.5F;
    }

    
    public boolean isMultipass()
    {
        return true;
    }
    
    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    float iii;
    public void doRender(EntityGVCR2_SHIP_HAMINA entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	this.bindEntityTexture(entity);
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);

		if(entity.deathTicks > 0){
			GL11.glColor4f(0.1F, 0.1F, 0.1F, 1F);
		}
		
		if(entity.spg_mode && entity.getArmID_S() == 2)
		{
			RenderSPG_Target.can(entity, entity.spg_yaw, (float)(entity.spg_y - entity.posY), entity.spg_picth);
			if (entity.getControllingPassenger() == null) {
				Minecraft.getMinecraft().renderEngine.bindTexture(boatTextures);
		   	}else
		   	{
		   		Minecraft.getMinecraft().renderEngine.bindTexture(boatTextures);
		   	}
		}
		
		//GL11.glTranslatef(0.0F, 0.5F, 0.0F);
		GL11.glRotatef(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
		tankk.renderPart("mat1");
		//tankk.renderPart("mat2");
		
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(0F, 8.0F, -1.9F);
			GL11.glRotatef((float)mod_GVCLib.proxy.getCilentWorld().getWorldTime()  * 10F, 0.0F, 10.0F, 0.0F);
			GL11.glTranslatef(-0F, -8.0F, 1.9F);
			tankk.renderPart("rader_1");
		}
		GL11.glPopMatrix();
		
		
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(0F, 3.0F, 5.5F);
			GL11.glRotatef(180.0F - entity.rotation -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0F, -3.0F, -5.5F);
			tankk.renderPart("mat4_1");
			GL11.glTranslatef(0F, 2.9F, 5.5F);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-0F, -2.9F, -5.5F);
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
				if(entity.getRemain_L() > 0)RenderLaserSight.can(entity, 0.0F, 2.9F, 5.5F, 1.0F, boatTextures);
			}
		}
		
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(0F, 5.7F, 0.0F);
			GL11.glRotatef(180.0F - entity.rotation -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0F, -5.7F, 0.0F);
			tankk.renderPart("mat4_2");
			GL11.glTranslatef(0F, 6.35F, 0.0F);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-0F, -6.35F, 0.0F);
			tankk.renderPart("mat5_2");
		}
		GL11.glPopMatrix();
		
		{
			GL11.glPushMatrix();
			/*
			 //if(entity.getPassengers().size() > 2 && entity.getPassengers().get(2) != null)
			 {
				 GL11.glRotatef(180.0F - entity.rotation_3-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
					
			 }
			 /*else {
				    GL11.glRotatef((180.0F - entity.rotationYaw)-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(30, 1.0F, 0.0F, 0.0F);
			 }*/
			GL11.glTranslatef(0.0F, 3.6F, 3.1F);
			 GL11.glRotatef(180.0F - entity.rotation_3-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			 GL11.glTranslatef(0.0F, -3.6F, -3.1F);
			tankk.renderPart("mat7_1");
			
			GL11.glTranslatef(0.0F, 4.25F, 3.1F);
			GL11.glRotatef(entity.rotationp_3, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0.0F, -4.25F, -3.1F);
			tankk.renderPart("mat8_1");
			GL11.glPopMatrix();
		}
		
		{
			tankk.renderPart("mat3");
			GL11.glPushMatrix();
			GL11.glTranslatef(0.0F, 2.8F, -8.4F);
			 GL11.glRotatef(180.0F - entity.rotation_3-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			 GL11.glTranslatef(0.0F, -2.8F, 8.4F);
			tankk.renderPart("mat7_2");
			
			GL11.glTranslatef(0.0F, 3.45F, -8.4F);
			GL11.glRotatef(entity.rotationp_3, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0.0F, -3.45F, 8.4F);
			tankk.renderPart("mat8_2");
			GL11.glPopMatrix();
		}
		
		{
			GL11.glPushMatrix();
			if(entity.getControllingPassenger() != null && entity.getControllingPassenger() == Minecraft.getMinecraft().player){
				ResourceLocation resourcelocation = ((AbstractClientPlayer)Minecraft.getMinecraft().player).getLocationSkin();
				if (resourcelocation == null)
		        {
		            resourcelocation = new ResourceLocation("textures/entity/steve.png");
		        }
				Minecraft.getMinecraft().renderEngine.bindTexture(resourcelocation);
				tankk.renderPart("steve");
			}
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
    protected ResourceLocation getEntityTexture(EntityGVCR2_SHIP_HAMINA entity)
    {
			return boatTextures;
    }
    
    protected void renderLivingAt(EntityGVCR2_SHIP_HAMINA entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_SHIP_HAMINA livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
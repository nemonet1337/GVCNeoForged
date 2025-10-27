package gvcr2.render.vehicle.ship;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.mod_GVCLib;
import gvclib.render.ModelBase_Non;
import gvclib.render.RenderBomber_Target;
import gvclib.render.RenderCanMobRidding;
import gvclib.render.RenderLaserSight;
import gvclib.render.RenderSPG_Target;
import gvcr2.entity.vehicle.ship.EntityGVCR2_SHIP_AIRSHIP;
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
public class RenderGVCR2_SHIP_AIRSHIP extends RenderLiving<EntityGVCR2_SHIP_AIRSHIP>
{
    private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/aircraft/airship.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/aircraft/airship.mqo"));
    /** instance of ModelBoat for rendering */

    public RenderGVCR2_SHIP_AIRSHIP(RenderManager renderManagerIn)
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
    public void doRender(EntityGVCR2_SHIP_AIRSHIP entity, double x, double y, double z, float entityYaw, float partialTicks)
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
		
		boolean flag = false;
		if(entity.getControllingPassenger() != null && entity.getControllingPassenger() == Minecraft.getMinecraft().player){
			boolean right = mod_GVCLib.proxy.rightclick();// 1
			if(Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && right){
				flag = true;
			}
		}
		if(!flag) {
		
		//get_world_rotation(entity);
		tankk.renderPart("mat1");
		tankk.renderPart("mat2");
		
		
		{//左機銃
			tankk.renderPart("gunmount_2");
			GL11.glPushMatrix();
			GL11.glTranslatef(4F, 2F, -2.65F);
			GL11.glRotatef(180F - entity.rotation_2 -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(entity.rotationp_2, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-4F, -2F, 2.65F);
			tankk.renderPart("mat5_2");
			
			GL11.glPopMatrix();
		}
		{//右機銃
			tankk.renderPart("gunmount_3");
			GL11.glPushMatrix();
			GL11.glTranslatef(-4F, 2F, -2.65F);
			GL11.glRotatef(180F - entity.rotation_4 -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(entity.rotationp_4, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(4F, -2F, 2.65F);
			tankk.renderPart("mat5_3");
			
			GL11.glPopMatrix();
		}
		{//上部機銃
			tankk.renderPart("gunmount_1");
			GL11.glPushMatrix();
			GL11.glTranslatef(0F, 18.65F, 0F);
			GL11.glRotatef(180F - entity.rotation_3 -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0F, -18.65F, 0F);
			tankk.renderPart("mat4_1");
			GL11.glTranslatef(0F, 19.25F, 0.9F);
			GL11.glRotatef(entity.rotationp_3, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0F, -19.25F, -0.9F);
			tankk.renderPart("mat5_1");
			
			GL11.glPopMatrix();
		}
		{//下部砲塔
			GL11.glPushMatrix();
			GL11.glTranslatef(0F, -0.5F, -8F);
			GL11.glRotatef(180F - entity.rotation -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0F, 0.5F, 8F);
			tankk.renderPart("cannonmount");
			GL11.glTranslatef(0F, -0.5F, -7F);
			GL11.glRotatef(entity.rotationp, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0F, 0.5F, 7F);
			tankk.renderPart("cannon");
			
			GL11.glPopMatrix();
		}
		
		
		
		
		/*{
			GL11.glPushMatrix();
			Minecraft minecraft = Minecraft.getMinecraft();
			minecraft.getTextureManager().bindTexture(g_tex);
			tankk.renderPart("steve1");
			tankk.renderPart("steve_sitting");
			{//上部機銃
				GL11.glPushMatrix();
				GL11.glTranslatef(0F, 18.65F, 0F);
				GL11.glRotatef(180F - entity.rotation_3 -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0F, -18.65F, 0F);
				tankk.renderPart("steve_sitting1");
				GL11.glPopMatrix();
			}
			
			
			
			
			
			this.bindTexture(boatTextures);
			GL11.glPopMatrix();
		}*/
		}
		
		//RenderCanMobRidding.can(entity);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGVCR2_SHIP_AIRSHIP entity)
    {
			return boatTextures;
    }
    
    protected void renderLivingAt(EntityGVCR2_SHIP_AIRSHIP entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_SHIP_AIRSHIP livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
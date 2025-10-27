package gvcr2.render.vehicle.apc;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.render.ModelBase_Non;
import gvclib.render.RenderAngleSystem;
import gvclib.render.RenderCanMobRidding;
import gvclib.render.RenderSPG_Target;
import gvcr2.mod_GVCR2;
import gvcr2.entity.vehicle.apc.EntityGVCR2_APC_M1126;
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
public class RenderGVCR2_APC_M1126 extends RenderLiving<EntityGVCR2_APC_M1126>
{
    private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/apc/m1126.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/apc/m1126.mqo"));
    /** instance of ModelBoat for rendering */

    public RenderGVCR2_APC_M1126(RenderManager renderManagerIn)
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
    public void doRender(EntityGVCR2_APC_M1126 entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	this.bindEntityTexture(entity);
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);

		if(entity.deathTicks > 0){
			GL11.glColor4f(0.1F, 0.1F, 0.1F, 1F);
		}
		if(entity.spg_mode && entity.getArmID_L() == 3)
		{
			RenderSPG_Target.can(entity, entity.spg_yaw, (float)(entity.spg_y - entity.posY), entity.spg_picth);
			if (entity.getControllingPassenger() == null) {
				Minecraft.getMinecraft().renderEngine.bindTexture(boatTextures);
		   	}else
		   	{
		   		Minecraft.getMinecraft().renderEngine.bindTexture(boatTextures);
		   	}
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
		if(entity.getArmID_L() == 1){
			tankk.renderPart("mat2");
			tankk.renderPart("seat");
			tankk.renderPart("door");
		}
		else if(entity.getArmID_L() == 3){
			tankk.renderPart("mat1");
			tankk.renderPart("seat");
			tankk.renderPart("cupola2");
			tankk.renderPart("hatch1");
			tankk.renderPart("door");
		}
		else {
			tankk.renderPart("mat1");
			tankk.renderPart("seat");
			tankk.renderPart("cupola1");
			tankk.renderPart("hatch");
			tankk.renderPart("door");
		}
		//tankk.renderPart("taiya");
		//tankk.renderPart("hach");
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(0F, 0.5F, 1.8F);
			if (entity.canBeSteered() && entity.getControllingPassenger() != null)
			{
				if(entity.getControllingPassenger() instanceof EntityPlayer)
				{
					EntityPlayer entitylivingbase = (EntityPlayer) entity.getControllingPassenger();
					if (entitylivingbase.moveStrafing < 0.0F) {
						GL11.glRotatef((180.0F - entity.rotationYaw - 15) - (180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
					}
					if (entitylivingbase.moveStrafing > 0.0F) {
						GL11.glRotatef((180.0F - entity.rotationYaw + 15) - (180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
					}
					
				}
			}
			GL11.glTranslatef(0F, -0.5F, -1.8F);
			GL11.glTranslatef(0F, 0.5F, 1.8F);
			GL11.glRotatef((float) entity.thpera, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0F, -0.5F, -1.8F);
			tankk.renderPart("wheel_l_1");
			tankk.renderPart("wheel_r_1");
			GL11.glPopMatrix();
		}
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(0F, 0.5F, 0.7F);
			GL11.glRotatef((float) entity.thpera, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0F, -0.5F, -0.7F);
			tankk.renderPart("wheel_l_2");
			tankk.renderPart("wheel_r_2");
			GL11.glPopMatrix();
		}
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(0F, 0.5F, -0.7F);
			GL11.glRotatef((float) entity.thpera, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0F, -0.5F, 0.7F);
			tankk.renderPart("wheel_l_3");
			tankk.renderPart("wheel_r_3");
			GL11.glPopMatrix();
		}
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(0F, 0.5F, -1.8F);
			GL11.glRotatef((float) entity.thpera, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0F, -0.5F, 1.8F);
			tankk.renderPart("wheel_l_4");
			tankk.renderPart("wheel_r_4");
			GL11.glPopMatrix();
		}
		
		//GL11.glRotatef(-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
		
		if(entity.getArmID_L() == 1){
			GL11.glTranslatef(0F, 2.0F, -1.0F);
			GL11.glRotatef(180.0F - entity.rotation-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0F, -2.0F, 1.0F);
			tankk.renderPart("mat4_3");
			GL11.glTranslatef(0F, 2.75F, -0.875F);
			GL11.glRotatef(entity.rotationp, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0F, -2.75F, 0.875F);
			tankk.renderPart("mat5_3");
		}
		else if(entity.getArmID_L() == 3){
			GL11.glTranslatef(0F, 0.95F, -1.9F);
			GL11.glRotatef(180.0F - entity.rotation-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0F, -0.95F, 1.9F);
			tankk.renderPart("mat4_2");
			GL11.glTranslatef(0F, 1.75F, -2.3F);
			GL11.glRotatef(-60, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0F, -1.75F, 2.3F);
			tankk.renderPart("mat5_2");
		}
		else {
			GL11.glTranslatef(0F, 2.5F, -0.55F);
			if(entity.getPassengers().size() > 1 && entity.getPassengers().get(1) != null){
				GL11.glRotatef(180.0F - entity.rotation_1-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			}else {
				GL11.glRotatef((180.0F - entity.rotationYaw + 0)-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			}
			GL11.glTranslatef(0F, -2.5F, 0.55F);
			tankk.renderPart("mat4_1");
			GL11.glTranslatef(0F, 2.9F, 0.325F);
			if(entity.getPassengers().size() > 1 && entity.getPassengers().get(1) != null){
				GL11.glRotatef(entity.rotationp_1, 1.0F, 0.0F, 0.0F);
			}else {
				GL11.glRotatef(10, 1.0F, 0.0F, 0.0F);
			}
			GL11.glTranslatef(0F, -2.9F, -0.325F);
			tankk.renderPart("mat5_1");
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
    protected ResourceLocation getEntityTexture(EntityGVCR2_APC_M1126 entity)
    {
			return boatTextures;
    }
    
    protected void renderLivingAt(EntityGVCR2_APC_M1126 entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_APC_M1126 livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
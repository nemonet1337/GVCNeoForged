package gvcr2.render.vehicle.car;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.render.ModelBase_Non;
import gvclib.render.RenderAngleSystem;
import gvclib.render.RenderCanMobRidding;
import gvcr2.mod_GVCR2;
import gvcr2.entity.vehicle.car.EntityGVCR2_CAR_Technical;
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
public class RenderGVCR2_CAR_Technical extends RenderLiving<EntityGVCR2_CAR_Technical>
{
    private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/car/technical.png");
    private static final ResourceLocation tnt_side = new ResourceLocation("textures/blocks/tnt_side.png");
    private static final ResourceLocation tnt_top = new ResourceLocation("textures/blocks/tnt_top.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/car/technical.mqo"));
    /** instance of ModelBoat for rendering */

    public RenderGVCR2_CAR_Technical(RenderManager renderManagerIn)
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
    public void doRender(EntityGVCR2_CAR_Technical entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	this.bindEntityTexture(entity);
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);

		if(entity.deathTicks > 0){
			GL11.glColor4f(0.1F, 0.1F, 0.1F, 1F);
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
		tankk.renderPart("mat1");
		if(entity.getArmID_L() != 2)tankk.renderPart("mat2");
		
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(0F, 0.55F, 1.55F);
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
			GL11.glTranslatef(0F, -0.55F, -1.55F);
			GL11.glTranslatef(0F, 0.55F, 1.55F);
			GL11.glRotatef((float) entity.thpera, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0F, -0.55F, -1.55F);
			tankk.renderPart("wheel_l1");
			tankk.renderPart("wheel_r1");
			GL11.glPopMatrix();
		}
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(0F, 0.55F, -1.45F);
			GL11.glRotatef((float) entity.thpera, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0F, -0.55F, 1.45F);
			tankk.renderPart("wheel_l2");
			tankk.renderPart("wheel_r2");
			GL11.glPopMatrix();
		}
		
		
		//GL11.glRotatef(-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
		GL11.glPushMatrix();
		/*if(entity.getArmID_L() == 1){
			GL11.glTranslatef(0F, 2.0F, -0.6F);
			GL11.glRotatef(180.0F - entity.rotation_3-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0F, -2.0F, 0.6F);
			tankk.renderPart("mat4_2");
			GL11.glTranslatef(0F, 3.0F, 0.35F);
			GL11.glRotatef(entity.rotationp_3, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0F, -3.0F, -0.35F);
			tankk.renderPart("mat5_2");
		}else */
		{
			
			if(entity.getArmID_L() == 1){
				GL11.glTranslatef(0F, 2.85F, -1.5F);
				rote_yaw(entity, entityYaw);
				GL11.glTranslatef(0F, -2.85F, 1.5F);
				tankk.renderPart("mat4_2");
				
			}else if(entity.getArmID_L() == 2){
				GL11.glTranslatef(0F, 2.85F, -1.5F);
				rote_yaw(entity, entityYaw);
				GL11.glTranslatef(0F, -2.85F, 1.5F);
				tankk.renderPart("mat4_3");
				
				GL11.glTranslatef(0F, 2.9F, -1.55F);
				rote_pitch(entity, -40);
				GL11.glTranslatef(0F, -2.9F, 1.55F);
				tankk.renderPart("mat5_3");
				tankk.renderPart("mat6_3");
			}else if(entity.getArmID_L() == 3){
				
				GL11.glTranslatef(0F, 2.85F, -1.5F);
				//rote_yaw(entity, entityYaw);
				GL11.glTranslatef(0F, -2.85F, 1.5F);
				tankk.renderPart("mat4_4");
				
				GL11.glTranslatef(0F, 2.85F, -1.5F);
				GL11.glRotatef(-50, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(0F, -2.85F, 1.5F);
				tankk.renderPart("mat5_4");
			}else if(entity.getArmID_L() == 4){
				tankk.renderPart("mat4_5");
				Minecraft.getMinecraft().renderEngine.bindTexture(tnt_side);
				tankk.renderPart("tnt_side");
				Minecraft.getMinecraft().renderEngine.bindTexture(tnt_top);
				tankk.renderPart("tnt_top");
			}
			else {
				GL11.glTranslatef(0F, 2.85F, -1.5F);
				rote_yaw(entity, entityYaw);
				GL11.glTranslatef(0F, -2.85F, 1.5F);
				tankk.renderPart("mat4_1");
				
				GL11.glTranslatef(0F, 2.85F, -1.0F);
				rote_pitch(entity, 10);
				GL11.glTranslatef(0F, -2.85F, 1.0F);
				tankk.renderPart("mat5_1");
			}
			
		}
		GL11.glPopMatrix();
		
		RenderCanMobRidding.can(entity);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    public void rote_yaw(EntityGVCR2_CAR_Technical entity, float entityYaw) {
    	if(entity.getPassengers().size() > 1 && entity.getPassengers().get(1) != null){
			GL11.glRotatef(180.0F - entity.rotation_3-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
		}else {
			GL11.glRotatef((180.0F - entity.rotationYaw + 0)-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
		}
    }
    public void rote_pitch(EntityGVCR2_CAR_Technical entity, float offset) {
    	if(entity.getPassengers().size() > 1 && entity.getPassengers().get(1) != null){
			GL11.glRotatef(entity.rotationp_3, 1.0F, 0.0F, 0.0F);
		}else {
			GL11.glRotatef(offset, 1.0F, 0.0F, 0.0F);
		}
    }
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGVCR2_CAR_Technical entity)
    {
			return boatTextures;
    }
    
    protected void renderLivingAt(EntityGVCR2_CAR_Technical entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_CAR_Technical livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
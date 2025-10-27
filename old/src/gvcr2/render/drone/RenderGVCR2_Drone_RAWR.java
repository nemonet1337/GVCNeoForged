package gvcr2.render.drone;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.render.ModelBase_Non;
import gvcr2.entity.drone.EntityDrone_RAWR;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class RenderGVCR2_Drone_RAWR extends RenderLiving<EntityDrone_RAWR> //extends RenderLiving<EntityDrone_RAWR>
{
    private static final ResourceLocation drone = new ResourceLocation("gvcr2:textures/mob/model/drone/rawr.png");
    private static final IModelCustom drone_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/drone/rawr.mqo"));
    
   
    
    
    public RenderGVCR2_Drone_RAWR(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelBase_Non(),0.5F);
  //  	super(renderManagerIn);
        this.shadowSize = 1F;
    }

    @Override
	protected ResourceLocation getEntityTexture(EntityDrone_RAWR entity) {
		// TODO 自動生成されたメソッド・スタブ
		return drone;
	}
    
    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    float iii;
    public void doRender(EntityDrone_RAWR entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	{
			//doRenderShadowAndFire(entity, x, y, z, entityYaw, partialTicks);
		}
    	float limbSwing = this.F6(entity, partialTicks);
		float limbSwingAmount = this.F5(entity, partialTicks);
    	this.bindEntityTexture(entity);
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		
		
		
		if(entity.deathTicks > 0){
			GL11.glColor4f(0.6F, 0.6F, 0.6F, 1F);
		}else {
			if(entity.hurtTime > 0) {
				GL11.glColor4f(0.7F, 0.2F, 0.2F, 1F);
			}else {
				GL11.glColor4f(1F, 1F, 1F, 1F);
			}
		}
		
		GL11.glRotatef(180.0F - entity.renderYawOffset, 0.0F, 1.0F, 0.0F);
		//drone
		{
			GL11.glPushMatrix();//glstart
			Minecraft.getMinecraft().renderEngine.bindTexture(drone);
			drone_model.renderPart("body");
			drone_model.renderPart("leg");
			drone_model.renderPart("arm");
			GL11.glPopMatrix();//glend
		}
		{
			GL11.glTranslatef(0F, 0.0F, 0.0F);
			GL11.glRotatef(180.0F - entity.rotation -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0F, 0.0F, 0.0F);
			drone_model.renderPart("mat4_1");
			GL11.glTranslatef(0F, 0.75F, -0.1F);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-0F, -0.75F, 0.1F);
			drone_model.renderPart("mat5_1");
			drone_model.renderPart("mat5_2");
		}
		
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		
		//doRenderShadowAndFire(entity, x, y, z, entityYaw, partialTicks);
		//renderEntityOnFire(entity, x, y, z, partialTicks);
		
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
		
    }
   
    
    public float F6(EntityLivingBase entity, float partialTicks){
 		float f6 = 0;
 		if (!entity.isRiding())
        {
            f6 = entity.limbSwing - entity.limbSwingAmount * (1.0F - partialTicks);
            if (entity.isChild())
            {
                f6 *= 3.0F;
            }
        }
 		return f6;
 	}
 	public float F5(EntityLivingBase entity, float partialTicks){
 		float f5 = 0;
 		if (!entity.isRiding())
        {
            f5 = entity.prevLimbSwingAmount + (entity.limbSwingAmount - entity.prevLimbSwingAmount) * partialTicks;
            if (f5 > 1.0F)
            {
                f5 = 1.0F;
            }
        }
 		return f5;
 	}
 	
 	/**
     * Returns a rotation angle that is inbetween two other rotation angles. par1 and par2 are the angles between which
     * to interpolate, par3 is probably a float between 0.0 and 1.0 that tells us where "between" the two angles we are.
     * Example: par1 = 30, par2 = 50, par3 = 0.5, then return = 40
     */
    protected float interpolateRotation(float prevYawOffset, float yawOffset, float partialTicks)
    {
        float f;

        for (f = yawOffset - prevYawOffset; f < -180.0F; f += 360.0F)
        {
            ;
        }

        while (f >= 180.0F)
        {
            f -= 360.0F;
        }

        return prevYawOffset + partialTicks * f;
    }
    
    protected void renderLivingAt(EntityDrone_RAWR entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityDrone_RAWR livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }


	
    
}
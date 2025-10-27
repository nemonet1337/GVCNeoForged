package gvcr2.render.vehicle.air;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.mod_GVCLib;
import gvclib.render.ModelBase_Non;
import gvclib.render.RenderBomber_Target;
import gvclib.render.RenderCanMobRidding;
import gvclib.render.RenderSPG_Target;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_F117;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class RenderGVCR2_AIR_F117 extends RenderLiving<EntityGVCR2_AIR_F117>
{
    private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/aircraft/f117.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/aircraft/f117.mqo"));
    /** instance of ModelBoat for rendering */

    public RenderGVCR2_AIR_F117(RenderManager renderManagerIn)
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
    public void doRender(EntityGVCR2_AIR_F117 entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.bindEntityTexture(entity);
		
		
        GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);

		if(entity.deathTicks > 0){
			GL11.glColor4f(0.1F, 0.1F, 0.1F, 1F);
		}
		//if()
		if(entity.getControllingPassenger() != null && entity.getControllingPassenger() == Minecraft.getMinecraft().player){
			/*BlockPos basep = FMLClientHandler.instance().getClient().world.getHeight(new BlockPos(entity.posX, entity.posY, entity.posZ));
			float bsp = (float)Math.tan((entity.motionX * entity.motionX) + (entity.motionZ * entity.motionZ)) * 10;
			//double ve = Math.sqrt((bsp * Math.cos(0)) * (bsp * Math.cos(0)) + 2 * basep.getY() * 0.03F);
			float xspeed = (float) (bsp * Math.sqrt((2  * (entity.posY - basep.getY()) * 0.65F  ) / 0.03F));
			
			float xx = xspeed;
			float zz = 0;
			float xxx = 0;
			float yyy = 0;
			float zzz = 0;
			float yaw = entity.rotationYawHead * (2 * (float) Math.PI / 360);
			xxx -= MathHelper.sin(yaw) * xx;
			zzz += MathHelper.cos(yaw) * xx;
			xxx -= MathHelper.sin(yaw - 1.57F) * zz;
			zzz += MathHelper.cos(yaw - 1.57F) * zz;
			BlockPos bp = FMLClientHandler.instance().getClient().world.getHeight(new BlockPos(xxx + entity.posX, entity.posY, zzz + entity.posZ));
			yyy = bp.getY();
			RenderSPG_Target.can(entity, (float)(xxx), (float)(yyy - entity.posY), (float)(zzz));*/
			RenderBomber_Target.can(entity, 10);
			if (entity.getControllingPassenger() == null) {
				Minecraft.getMinecraft().renderEngine.bindTexture(boatTextures);
		   	}else
		   	{
		   		Minecraft.getMinecraft().renderEngine.bindTexture(boatTextures);
		   	}
		}
		
		GL11.glRotatef(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
		
		
		
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
			
			if(entity.getFTMode() == 30
					|| entity.getFTMode() == 31
					|| entity.getFTMode() == 32
					|| entity.getFTMode() == 33
					|| entity.getFTMode() == 34) {
				tankk.renderPart("bomb");
			}else {
				tankk.renderPart("rocket");
			}
			if(entity.onGround){
				tankk.renderPart("gear");
			}
			RenderCanMobRidding.can(entity);
		}
		GL11.glRotatef(-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

     private void renderAngle(EntityGVCR2_AIR_F117 p_76986_1_, int i){
		{
			GL11.glRotatef(-(p_76986_1_.angletime), 1.0F, 0.0F, 0.0F);
		}
	}
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGVCR2_AIR_F117 entity)
    {
    	{
			return boatTextures;
		}
    }
    
    protected void renderLivingAt(EntityGVCR2_AIR_F117 entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_AIR_F117 livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
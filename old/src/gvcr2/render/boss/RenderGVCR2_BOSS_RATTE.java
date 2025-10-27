package gvcr2.render.boss;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.render.ModelBase_Non;
import gvclib.render.RenderCanMobRidding;
import gvcr2.entity.boss.EntityGVCR2_BOSS_RATTE;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_M60A1;
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
public class RenderGVCR2_BOSS_RATTE extends RenderLiving<EntityGVCR2_BOSS_RATTE>
{
    private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/tank/ratte.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/tank/ratte.mqo"));
    /** instance of ModelBoat for rendering */

    public RenderGVCR2_BOSS_RATTE(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelBase_Non(),0.5F);
        this.shadowSize = 2.5F;
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (RenderLiving<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    float iii;
    public void doRender(EntityGVCR2_BOSS_RATTE entity, double x, double y, double z, float entityYaw, float partialTicks)
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
		//get_world_rotation(entity);
		tankk.renderPart("mat1");
		tankk.renderPart("mat2");
		//GL11.glRotatef(-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
		
		
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(0F, 10.5F, 3F);
			GL11.glRotatef(180.0F - entity.rotation -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0F, -10.5F, -3F);
			tankk.renderPart("mat4_1");
			GL11.glTranslatef(0F, 10F, 8F);
			GL11.glRotatef(entity.rotationp, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0F, -10F, -8F);
			tankk.renderPart("mat5_1");
			GL11.glPopMatrix();
		}
		
		{//Flak88
			GL11.glPushMatrix();
			GL11.glTranslatef(0F, 8.5F, -8F);
			GL11.glRotatef(180.0F - entity.rotation_4 -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(entity.rotationp_4, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-0F, -8.5F, 8F);
			tankk.renderPart("mat5_2");
			GL11.glPopMatrix();
		}
		{//左機銃
			GL11.glPushMatrix();
			GL11.glTranslatef(5F, 7.8F, -12F);
			GL11.glRotatef(180.0F - entity.rotation_2 -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-5F, -7.8F, 12F);
			tankk.renderPart("mat4_3");
			GL11.glTranslatef(5F, 7.8F, -12F);
			GL11.glRotatef(entity.rotationp_2, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-5F, -7.8F, 12F);
			tankk.renderPart("mat5_3");
			GL11.glPopMatrix();
		}
		{//右機銃
			GL11.glPushMatrix();
			GL11.glTranslatef(-5F, 7.8F, -12F);
			GL11.glRotatef(180.0F - entity.rotation_1 -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(5F, -7.8F, 12F);
			tankk.renderPart("mat4_4");
			GL11.glTranslatef(-5F, 7.8F, -12F);
			GL11.glRotatef(entity.rotationp_1, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(5F, -7.8F, 12F);
			tankk.renderPart("mat5_4");
			GL11.glPopMatrix();
		}
		
		{//左前機銃
			GL11.glPushMatrix();
			tankk.renderPart("gunmount_2");
			GL11.glTranslatef(5F, 3.8F, 15F);
			GL11.glRotatef(180.0F - entity.rotation_5 -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(entity.rotationp_5, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-5F, -3.8F, -15F);
			tankk.renderPart("gun2");
			GL11.glPopMatrix();
		}
		{//右前機銃
			GL11.glPushMatrix();
			tankk.renderPart("gunmount_3");
			GL11.glTranslatef(-5F, 3.8F, 15F);
			GL11.glRotatef(180.0F - entity.rotation_6 -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(entity.rotationp_6, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(5F, -3.8F, -15F);
			tankk.renderPart("gun3");
			GL11.glPopMatrix();
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
    protected ResourceLocation getEntityTexture(EntityGVCR2_BOSS_RATTE entity)
    {
    	{
			return boatTextures;
		}
    }
    
    protected void renderLivingAt(EntityGVCR2_BOSS_RATTE entityLivingBaseIn, double x, double y, double z)
    {
    	GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_BOSS_RATTE livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
package gvcr2.render.boss;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.render.ModelBase_Non;
import gvclib.render.RenderCanMobRidding;
import gvclib.render.RenderSPG_Target;
import gvcr2.entity.boss.EntityGVCR2_BOSS_LONGLEG;
import gvcr2.entity.vehicle.apc.EntityGVCR2_APC_M113;
import hmggirlfront.entity.vehicle.EntityVe_HMMWV;
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
public class RenderGVCR2_BOSS_LONGLEG extends RenderLiving<EntityGVCR2_BOSS_LONGLEG>
{
    private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/robo/longleg.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/robo/longleg.mqo"));
    /** instance of ModelBoat for rendering */

    public RenderGVCR2_BOSS_LONGLEG(RenderManager renderManagerIn)
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
    public void doRender(EntityGVCR2_BOSS_LONGLEG entity, double x, double y, double z, float entityYaw, float partialTicks)
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
		tankk.renderPart("body");
		tankk.renderPart("leg_l1");
		tankk.renderPart("leg_l2");
		tankk.renderPart("leg_r1");
		tankk.renderPart("leg_r2");
		
		//tankk.renderPart("head");
		
		//GL11.glRotatef(-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
		
		{
			GL11.glPushMatrix();
			GL11.glRotatef(180.0F - entity.rotationYawHead -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			tankk.renderPart("head0");
			tankk.renderPart("head1");
			if(entity.getAIType2() == 1) {
				tankk.renderPart("head3");
			}else {
				tankk.renderPart("head2");
			}
			//GL11.glPopMatrix();
			
			//GL11.glPushMatrix();
			if(entity.getAIType3() == 1) {
				//GL11.glTranslatef(0.0F, -1.5F, 0.0F);
				GL11.glTranslatef(0.0F, -entity.cannon_move * 0.1F, 0.0F);
				tankk.renderPart("head");
				tankk.renderPart("head_cannon_1");
				
            	//if(entity.cooltime4 < 40)tankk.renderPart("head_cannon_1c");
				//GL11.glTranslatef(0.0F, 1.5F, 0.0F);
            	if(entity.cooltime2 > 40 && entity.cooltime2 < 80) {
            		GL11.glTranslatef(0.0F, 5.25F, 2.0F);
            		float size = partialTicks * 0.4F + 1;
                	GlStateManager.scale(size, size, size);
                	GL11.glTranslatef(0.0F, -5.25F, -2.0F);
                	tankk.renderPart("head_cannon_1c");
            	}
            	if(entity.cooltime2 > 80 && entity.cooltime2 < 100) {
            		GL11.glTranslatef(0.0F, 5.25F, 2.0F);
                	GL11.glRotatef(entity.cooltime2, 0.0F, 0.0F, 1.0F);
                	GL11.glRotatef(entity.rotationPitch - 10, 1.0F, 0.0F, 0.0F);
                	GL11.glTranslatef(0.0F, -5.25F, -2.0F);
                	tankk.renderPart("head_cannon_1b");
            	}
			}else if(entity.getAIType3() == 2) {
				GL11.glTranslatef(0.0F, 0.0F, 0.0F);
				tankk.renderPart("head");
				tankk.renderPart("head_cannon_2");
            	//if(entity.cooltime4 < 40)tankk.renderPart("head_cannon_2c");
				//GL11.glTranslatef(0.0F, 0.0F, 0.0F);
            	if(entity.cooltime2 > 40 && entity.cooltime2 < 80) {
            		GL11.glTranslatef(0.0F, 10.45F, 2.0F);
            		float size = partialTicks * 0.4F + 1;
                	GlStateManager.scale(size, size, size);
                	GL11.glTranslatef(0.0F, -10.45F, -2.0F);
                	tankk.renderPart("head_cannon_2c");
            	}
            	if(entity.cooltime2 > 80 && entity.cooltime2 < 100){
            		GL11.glTranslatef(0.0F, 10.45F, 2.0F);
                	GL11.glRotatef(entity.cooltime2, 0.0F, 0.0F, 1.0F);
                	GL11.glRotatef(entity.rotationPitch - 10, 1.0F, 0.0F, 0.0F);
                	GL11.glTranslatef(0.0F, -10.45F, -2.0F);
                	tankk.renderPart("head_cannon_2b");
            	}
			}else {
				tankk.renderPart("head");
				if(entity.cannon_move > 0)GL11.glTranslatef(0.0F, -2.25F + entity.cannon_move * 0.1F, 0.0F);
			}
			
			GL11.glPopMatrix();
		}
		
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(2.25F, 7.6F, 2.25F);
			GL11.glRotatef(180.0F - entity.rotationYawHead -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-2.25F, -7.6F, -2.25F);
			tankk.renderPart("gun_l1");
			GL11.glTranslatef(2.25F, 7.6F, 2.6F);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-2.25F, -7.6F, -2.6F);
			tankk.renderPart("gun_arm_l1");
			GL11.glPopMatrix();
		}
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(-2.25F, 7.6F, 2.25F);
			GL11.glRotatef(180.0F - entity.rotationYawHead -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(2.25F, -7.6F, -2.25F);
			tankk.renderPart("gun_r1");
			GL11.glTranslatef(-2.25F, 7.6F, 2.6F);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(2.25F, -7.6F, -2.6F);
			tankk.renderPart("gun_arm_r1");
			GL11.glPopMatrix();
		}
		
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(2.25F, 7.6F, -2.25F);
			GL11.glRotatef(180.0F - entity.rotationYawHead -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-2.25F, -7.6F, 2.25F);
			tankk.renderPart("gun_l2");
			GL11.glTranslatef(2.25F, 7.6F, -2.6F);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-2.25F, -7.6F, 2.6F);
			tankk.renderPart("gun_arm_l2");
			GL11.glPopMatrix();
		}
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(-2.25F, 7.6F, -2.25F);
			GL11.glRotatef(180.0F - entity.rotationYawHead -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(2.25F, -7.6F, 2.25F);
			tankk.renderPart("gun_r2");
			GL11.glTranslatef(-2.25F, 7.6F, -2.6F);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(2.25F, -7.6F, 2.6F);
			tankk.renderPart("gun_arm_r2");
			GL11.glPopMatrix();
		}
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGVCR2_BOSS_LONGLEG entity)
    {
			return boatTextures;
    }
    
    protected void renderLivingAt(EntityGVCR2_BOSS_LONGLEG entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_BOSS_LONGLEG livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
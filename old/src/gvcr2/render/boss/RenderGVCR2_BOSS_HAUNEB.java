package gvcr2.render.boss;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.render.ModelBase_Non;
import gvclib.render.RenderCanMobRidding;
import gvclib.render.RenderSPG_Target;
import gvcr2.entity.boss.EntityGVCR2_BOSS_HAUNEB;
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
public class RenderGVCR2_BOSS_HAUNEB extends RenderLiving<EntityGVCR2_BOSS_HAUNEB>
{
    private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/robo/hauneb.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/robo/hauneb.mqo"));
    /** instance of ModelBoat for rendering */

    public RenderGVCR2_BOSS_HAUNEB(RenderManager renderManagerIn)
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
    public void doRender(EntityGVCR2_BOSS_HAUNEB entity, double x, double y, double z, float entityYaw, float partialTicks)
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
		
		{
			tankk.renderPart("mat1");
        	
			
			{
				GL11.glPushMatrix();
				GL11.glTranslatef(0.0F, 8.0F, 0.0F);
				GL11.glRotatef(180.0F - entity.rotationYawHead - (180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(-0.0F, -8.0F, -0.0F);
				tankk.renderPart("mat7");
				GL11.glTranslatef(0.0F, 6.9F, 1.5F);
				GL11.glRotatef(-60, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(-0.0F, -6.9F, -1.5F);
				tankk.renderPart("mat8");
				GL11.glPopMatrix();
			}
			
			if(entity.getAIType3() == 1 || entity.getAIType3() == 3){
				{
					GL11.glPushMatrix();
					GL11.glTranslatef(0.0F, 0.5F, 4.0F);
					GL11.glRotatef(180.0F - (0) -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
					GL11.glTranslatef(-0.0F, -0.5F, -4.0F);
					tankk.renderPart("mat4_1");
					GL11.glTranslatef(0.0F, 0.35F, 5.0F);
					GL11.glRotatef(entity.rotationp_1, 1.0F, 0.0F, 0.0F);
					GL11.glTranslatef(-0.0F, -0.35F, -5.0F);
					tankk.renderPart("mat5_1");
					GL11.glPopMatrix();
				}
				{
					GL11.glPushMatrix();
					GL11.glTranslatef(4.0F, 0.5F, 0.0F);
					GL11.glRotatef(180.0F - (-90) -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
					GL11.glTranslatef(-4.0F, -0.5F, -0.0F);
					tankk.renderPart("mat4_2");
					GL11.glTranslatef(4.0F, 0.35F, 1.0F);
					GL11.glRotatef(entity.rotationp_1, 1.0F, 0.0F, 0.0F);
					GL11.glTranslatef(-4.0F, -0.35F, -1.0F);
					tankk.renderPart("mat5_2");
					GL11.glPopMatrix();
				}
				{
					GL11.glPushMatrix();
					GL11.glTranslatef(-4.0F, 0.5F, 0.0F);
					GL11.glRotatef(180.0F - (90) -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
					GL11.glTranslatef(4.0F, -0.5F, -0.0F);
					tankk.renderPart("mat4_3");
					GL11.glTranslatef(-4.0F, 0.35F, 1.0F);
					GL11.glRotatef(entity.rotationp_1, 1.0F, 0.0F, 0.0F);
					GL11.glTranslatef(4.0F, -0.35F, -1.0F);
					tankk.renderPart("mat5_3");
					GL11.glPopMatrix();
				}
				{
					GL11.glPushMatrix();
					GL11.glTranslatef(0.0F, 0.5F, -4.0F);
					GL11.glRotatef(180.0F - (180) -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
					GL11.glTranslatef(-0.0F, -0.5F, 4.0F);
					tankk.renderPart("mat4_4");
					GL11.glTranslatef(0.0F, 0.35F, -3.0F);
					GL11.glRotatef(entity.rotationp_1, 1.0F, 0.0F, 0.0F);
					GL11.glTranslatef(-0.0F, -0.35F, 3.0F);
					tankk.renderPart("mat5_4");
					GL11.glPopMatrix();
				}
			}
			
			if(entity.getAIType3() == 2 || entity.getAIType3() == 3){
				tankk.renderPart("mat10");
				GL11.glPushMatrix();
				GL11.glTranslatef(0.0F, 0.0F, 0.0F);
				//GL11.glRotatef(entity.rotationp_2, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(0.0F, 0.0F, 0.0F);
				tankk.renderPart("mat10_1");
				GL11.glPopMatrix();
				
				{
					GL11.glPushMatrix();
					GL11.glTranslatef(0.0F, -3.0F, 00F);
					float timee = entity.getClient_cooltime3(entity) * 0.01F;
					GL11.glScalef(1.0F / timee, 1.0F / timee, 1.0F / timee);
					GL11.glTranslatef(0.0F, 3.0F, 0.0F);
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glColor4f(1F, 1F, 1F, 0.8F);
					GL11.glDisable(GL11.GL_DEPTH_TEST);
					if(entity.getClient_cooltime3(entity) > 40 && entity.getClient_cooltime3(entity) < 290 && entity.getHealth() > 0)tankk.renderPart("beam");
					GL11.glEnable(GL11.GL_DEPTH_TEST);
					GL11.glColor4f(1F, 1F, 1F, 1F);
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glPopMatrix();
				}
			}else {
				tankk.renderPart("mat9");
			}
			
        	
			
		}
		
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGVCR2_BOSS_HAUNEB entity)
    {
			return boatTextures;
    }
    
    protected void renderLivingAt(EntityGVCR2_BOSS_HAUNEB entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_BOSS_HAUNEB livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
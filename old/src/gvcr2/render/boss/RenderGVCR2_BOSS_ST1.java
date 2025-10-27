package gvcr2.render.boss;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvcr2.entity.boss.EntityGVCR2_BOSS_ST1;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class RenderGVCR2_BOSS_ST1 extends Render<EntityGVCR2_BOSS_ST1>
{
    private static final ResourceLocation tex = new ResourceLocation("gvcr2:textures/mob/model/robo/st1.png");
    private static final ResourceLocation tex2 = new ResourceLocation("gvcr2:textures/mob/model/robo/st1break.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/robo/st1.mqo"));
    /** instance of ModelBoat for rendering */

    public float kneex = 1.7F;
	public float kneey = 3.0F;
	public float kneez = 0.1F;
	
	public float legx = 1.55F;
	public float legy = 1.1F;
	public float legz = 0.0F;
	
	public float bodyx = 0.0F;
	public float bodyy = 3.6F;
	public float bodyz = 0.0F;
	
	public float headx = 0.0F;
	public float heady = 4.45F;
	public float headz = 0.975F;
	
	public float zarmx = 0.0F;
	public float zarmy = 4.45F;
	public float zarmz = 0.0F;
    
    public RenderGVCR2_BOSS_ST1(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.shadowSize = 0.5F;
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    public void doRender(EntityGVCR2_BOSS_ST1 entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	Minecraft minecraft = Minecraft.getMinecraft();
    	
    	float limbSwing = this.F6(entity, partialTicks);
		float limbSwingAmount = this.F5(entity, partialTicks);
		
		this.bindEntityTexture(entity);
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);

		if(entity.deathTime > 0){
			GL11.glColor4f(0.1F, 0.1F, 0.1F, 1F);
		}
		GL11.glRotatef(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
		{
			GL11.glPushMatrix();//glstart
			this.renderlegs(entity, limbSwing, limbSwingAmount, limbSwingAmount);
			GL11.glPopMatrix();//glend
		}
		
		GL11.glRotatef(-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
		
		{
			GL11.glRotatef(180.0F - entity.rotationYawHead, 0.0F, 1.0F, 0.0F);
			{
				GL11.glPushMatrix();//glstart
				GL11.glTranslatef(bodyx, bodyy, bodyz);
		    	float Ax = MathHelper.cos(-1 * 0.6662F + (float)Math.PI) * limbSwingAmount;
		    //	GL11.glRotatef(Ax * (180F / (float)Math.PI) * 0.2F, - 1.0F, 0.0F, 0.0F);
		    	GL11.glTranslatef(- bodyx, - bodyy, - bodyz);
				this.renderbody(entity, limbSwing, limbSwingAmount, limbSwingAmount);
				GL11.glPopMatrix();//glend
			}
			
		}
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
    }

    private void renderlegs(EntityGVCR2_BOSS_ST1 entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	tankk.renderPart("waist");
    	tankk.renderPart("body");
    	GL11.glPushMatrix();//glstart
		this.renderleg_left(entity, limbSwing, limbSwingAmount, limbSwingAmount);
		GL11.glPopMatrix();//glend
		
		GL11.glPushMatrix();//glstart
		this.renderleg_right(entity, limbSwing, limbSwingAmount, limbSwingAmount);
		GL11.glPopMatrix();//glend
	}
    
    private void renderleg_left(EntityGVCR2_BOSS_ST1 entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	float Ax = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
    	GL11.glPushMatrix();//glstart
    	GL11.glTranslatef(kneex, kneey, kneez);
    	GL11.glRotatef(Ax * (180F / (float)Math.PI) * 2F, 1.0F, 0.0F, 0.0F);
    	GL11.glTranslatef( - kneex,  - kneey, -  kneez);
    	tankk.renderPart("leftleg1");
    	tankk.renderPart("leftleg2");
    	GL11.glTranslatef(legx, legy, legz);
    	GL11.glRotatef(Ax * (180F / (float)Math.PI) * 2F, -1.0F, 0.0F, 0.0F);
    	GL11.glTranslatef(- legx, - legy, - legz);
		tankk.renderPart("leftleg3");
    	GL11.glPopMatrix();//glend
    }
    private void renderleg_right(EntityGVCR2_BOSS_ST1 entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	float Ax = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
    	GL11.glPushMatrix();//glstart
    	GL11.glTranslatef(- kneex, kneey, kneez);
    	GL11.glRotatef(Ax * (180F / (float)Math.PI) * 2F, -1.0F, 0.0F, 0.0F);
    	GL11.glTranslatef( kneex,  - kneey, -  kneez);
    	tankk.renderPart("rightleg1");
    	tankk.renderPart("rightleg2");
    	GL11.glTranslatef(- legx, legy, legz);
    	GL11.glRotatef(Ax * (180F / (float)Math.PI) * 2F, 1.0F, 0.0F, 0.0F);
    	GL11.glTranslatef( legx, - legy, - legz);
		tankk.renderPart("rightleg3");
    	GL11.glPopMatrix();//glend
    }
    
    private void renderbody(EntityGVCR2_BOSS_ST1 entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	
    	if(entity.startuptime > 100)tankk.renderPart("obj30");
    	tankk.renderPart("head");
		GL11.glPushMatrix();//glstart
		GL11.glTranslatef(headx, heady, headz);
		if(entity.rotationPitch > 45){
			GL11.glRotatef(45, 1.0F, 0.0F, 0.0F);
		}else if(entity.rotationPitch < -45){
			GL11.glRotatef(-45, 1.0F, 0.0F, 0.0F);
		}else{
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
		}
		GL11.glRotatef(5F, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(- headx, - heady, - headz);
		tankk.renderPart("head1");
		GL11.glPopMatrix();//glend
		
		GL11.glTranslatef(zarmx, zarmy, zarmz);
		GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(- zarmx, - zarmy, - zarmz);
		{
			GL11.glPushMatrix();//glstart
			this.renderarm_left(entity, limbSwing, limbSwingAmount, limbSwingAmount);
			GL11.glPopMatrix();//glend
			
			GL11.glPushMatrix();//glstart
			this.renderarm_right(entity, limbSwing, limbSwingAmount, limbSwingAmount);
			GL11.glPopMatrix();//glend
		}
    }
    
    private void renderarm_left(EntityGVCR2_BOSS_ST1 entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	tankk.renderPart("leftarm");
    	tankk.renderPart("leftarm1");
    }
    private void renderarm_right(EntityGVCR2_BOSS_ST1 entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	tankk.renderPart("rightarm");
    	tankk.renderPart("rightarm1");
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
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGVCR2_BOSS_ST1 entity)
    {
    	if(entity.startuptime < 100) {
    		return tex2;
    	}else {
    		return tex;
    	}
    }
    
    protected void renderLivingAt(EntityGVCR2_BOSS_ST1 entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_BOSS_ST1 livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
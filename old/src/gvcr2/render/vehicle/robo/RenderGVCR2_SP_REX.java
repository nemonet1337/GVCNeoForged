package gvcr2.render.vehicle.robo;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.entity.living.EntityVehicleBase;
import gvclib.item.ItemGunBase;
import gvclib.render.RenderLaserSight;
import gvcr2.entity.vehicle.robo.EntityGVCR2_SP_REX;
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
public class RenderGVCR2_SP_REX extends Render<EntityGVCR2_SP_REX>
{
    private static final ResourceLocation tex = new ResourceLocation("gvcr2:textures/mob/model/robo/rex.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/robo/rex.mqo"));
    /** instance of ModelBoat for rendering */

    public float kneex = 2.0F;
	public float kneey = 4.3F;
	public float kneez = -0.8F;
	
	public float legx = 2.0F;
	public float legy = 2.2F;
	public float legz = 1.1F;
	
	public float bodyx = 0.0F;
	public float bodyy = 4.0F;
	public float bodyz = 0.0F;
	
	public float headx = 0.0F;
	public float heady = 5.6F;
	public float headz = 1.2F;
	
	public float zarmx = 0.0F;
	public float zarmy = 6.8F;
	public float zarmz = -2.5F;
    
    public RenderGVCR2_SP_REX(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.shadowSize = 4.0F;
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    public void doRender(EntityGVCR2_SP_REX entity, double x, double y, double z, float entityYaw, float partialTicks)
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
		
		/*if(entity.debag_test_client){
			{
				GL11.glPushMatrix();//glstrt2
				newrenderreload(entity, entity.head_time, entity.head_xpoint, entity.head_xpoint, entity.head_xpoint
						, entity.head_xrote, entity.head_xrote, entity.head_xrote);
				tankk.renderPart("head");
		    	tankk.renderPart("head1");
		    	tankk.renderPart("seat");
				GL11.glPopMatrix();//glend2
			}
			{
				GL11.glPushMatrix();//glstrt2
				newrenderreload(entity, entity.body_time, entity.body_xpoint, entity.body_xpoint, entity.body_xpoint
						, entity.body_xrote, entity.body_xrote, entity.body_xrote);
				tankk.renderPart("body");
				GL11.glPopMatrix();//glend2
			}
			{
				GL11.glPushMatrix();//glstrt2
				newrenderreload(entity, entity.waist_time, entity.waist_xpoint, entity.waist_xpoint, entity.waist_xpoint
						, entity.waist_xrote, entity.waist_xrote, entity.waist_xrote);
				tankk.renderPart("waist");
				GL11.glPopMatrix();//glend2
			}
			{
				GL11.glPushMatrix();//glstrt2
				newrenderreload(entity, entity.knee_l_time, entity.knee_l_xpoint, entity.knee_l_xpoint, entity.knee_l_xpoint
						, entity.knee_l_xrote, entity.knee_l_xrote, entity.knee_l_xrote);
				tankk.renderPart("knee_l");
				tankk.renderPart("leg_l");
				newrenderreload(entity, entity.leg_l_time, entity.leg_l_xpoint, entity.leg_l_xpoint, entity.leg_l_xpoint
						, entity.leg_l_xrote, entity.leg_l_xrote, entity.leg_l_xrote);
				tankk.renderPart("feet_l");
				GL11.glPopMatrix();//glend2
			}
			{
				GL11.glPushMatrix();//glstrt2
				newrenderreload(entity, entity.knee_r_time, entity.knee_r_xpoint, entity.knee_r_xpoint, entity.knee_r_xpoint
						, entity.knee_r_xrote, entity.knee_r_xrote, entity.knee_r_xrote);
				tankk.renderPart("knee_r");
				tankk.renderPart("leg_r");
				newrenderreload(entity, entity.leg_r_time, entity.leg_r_xpoint, entity.leg_r_xpoint, entity.leg_r_xpoint
						, entity.leg_r_xrote, entity.leg_r_xrote, entity.leg_r_xrote);
				tankk.renderPart("feet_r");
				GL11.glPopMatrix();//glend2
			}
			
		}else*/
		{
			float Ax1 = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
			if(entity.move_mode != 5) {
				GL11.glTranslatef( 0, Ax1 * (180F / (float)Math.PI) * 0.001F, 0);
	    	}
			{
				GL11.glPushMatrix();//glstart
				this.renderlegs(entity, limbSwing, limbSwingAmount, limbSwingAmount);
				GL11.glPopMatrix();//glend
			}
			GL11.glTranslatef(bodyx, bodyy, bodyz);
			if(entity.move_mode == 3 || entity.move_mode == 5) {
				GL11.glRotatef(5, 0.0F, 0.0F, 1.0F);
			}
			if(entity.move_mode == 4) {
				GL11.glRotatef(5, 0.0F, 0.0F, -1.0F);
			}
			if(entity.move_mode == 5) {
				GL11.glRotatef(20, 1.0F, 1.0F, 0.0F);
			}
			GL11.glTranslatef(-bodyx, -bodyy, -bodyz);
			tankk.renderPart("waist");
	    	tankk.renderPart("body");
	    	tankk.renderPart("mat4_1");
	    	tankk.renderPart("mat5_1");
	    	
	    	
	    	
			GL11.glRotatef(-(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
			
			{
				GL11.glRotatef(180.0F - entity.rotationYawHead, 0.0F, 1.0F, 0.0F);
				{
					GL11.glPushMatrix();//glstart
					GL11.glTranslatef(bodyx, bodyy, bodyz);
			    	float Ax = MathHelper.cos(-1 * 0.6662F + (float)Math.PI) * limbSwingAmount;
			    //	GL11.glRotatef(Ax * (180F / (float)Math.PI) * 0.2F, - 1.0F, 0.0F, 0.0F);
			    	GL11.glTranslatef(- bodyx, - bodyy, - bodyz);
			    	
			    	if(entity.getControllingPassenger() != null && entity.getControllingPassenger() == Minecraft.getMinecraft().player){
						GL11.glPushMatrix();// glstart
						GL11.glTranslatef(0.0F, 3.6F, 1.0F);
						GL11.glRotatef(180.0F - entity.rotation -(180.0F - entityYaw), 0.0F, 1.0F, 0.0F);
						GL11.glRotatef(entity.rotationp, 1.0F, 0.0F, 0.0F);
						GL11.glTranslatef(-0.0F, -3.6F, -1.0F);
						if (entity.getRemain_R() > 0)
							RenderLaserSight.can(entity, 0.0F, 3.6F, 1.0F, 1.0F, tex);
						GL11.glPopMatrix();// glend
			    	}
			    	
					this.renderbody(entity, limbSwing, limbSwingAmount, limbSwingAmount);
					GL11.glPopMatrix();//glend
				}
				
			}
		}
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
    }

    private void renderlegs(EntityGVCR2_SP_REX entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	float volume = 0.5F;
    	GL11.glPushMatrix();//glstart
		this.renderleg_left(entity, limbSwing * volume, limbSwingAmount, limbSwingAmount);
		GL11.glPopMatrix();//glend
		
		GL11.glPushMatrix();//glstart
		this.renderleg_right(entity, limbSwing * volume, limbSwingAmount, limbSwingAmount);
		GL11.glPopMatrix();//glend
	}
    
    private void renderleg_left(EntityGVCR2_SP_REX entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	float Ax = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
    	GL11.glPushMatrix();//glstart
    	float motion =  Ax * (180F / (float)Math.PI) ;
    	GL11.glTranslatef(kneex, kneey, kneez);
    	GL11.glRotatef(10, 0.0F, 0.0F, 1.0F);
    	if(entity.move_mode == 3) {
    		//if(motion > 0)GL11.glRotatef(motion * 1F, 0.0F, 0.0F, 1.0F);
    		GL11.glRotatef(motion * 1F, 1.0F, 0.0F, 0.0F);
    		GL11.glRotatef(10, 0.0F, 0.0F, 1.0F);
    	}else if(entity.move_mode == 4) {
    		//if(motion < 0)GL11.glRotatef(motion * 1F, 0.0F, 0.0F, -1.0F);
    		GL11.glRotatef(motion * 1F, 1.0F, 0.0F, 0.0F);//反対
    		GL11.glRotatef(-10, 0.0F, 0.0F, 1.0F);
    	}else 
    	if(entity.move_mode == 5) {
    		GL11.glRotatef(30, 1.0F, 0.0F, 0.0F);//反対
    		GL11.glRotatef(10, 0.0F, 0.0F, 1.0F);
    	}
    	else {
    		GL11.glRotatef(motion * 1F, 1.0F, 0.0F, 0.0F);
    	}
    	if(entity.ridding)GL11.glRotatef(30F, 1.0F, 0.0F, 0.0F);
    	GL11.glTranslatef( - kneex,  - kneey, -  kneez);
    	tankk.renderPart("knee_l");
    	tankk.renderPart("leg_l");
    	GL11.glTranslatef(legx, legy, legz);
    	//GL11.glRotatef(motion * 1F, -1.0F, 0.0F, 0.0F);
    	if(entity.move_mode == 3) {
    		//if(motion > 0)GL11.glRotatef(motion * 1F, 0.0F, 0.0F, -1.0F);
    		GL11.glRotatef(motion * 1F, -1.0F, 0.0F, 0.0F);
    		GL11.glRotatef(10, 0.0F, 0.0F, 1.0F);
    	}else if(entity.move_mode == 4) {
    		//if(motion < 0)GL11.glRotatef(motion * 1F, 0.0F, 0.0F, 1.0F);
    		GL11.glRotatef(motion * 1F, -1.0F, 0.0F, 0.0F);//反対
    		GL11.glRotatef(-10, 0.0F, 0.0F, 1.0F);
    	}else 
    		if(entity.move_mode == 5) {
    		GL11.glRotatef(30, -1.0F, 0.0F, 0.0F);//反対
    		GL11.glRotatef(10, 0.0F, 0.0F, 1.0F);
    	}else {
    		GL11.glRotatef(motion * 1F, -1.0F, 0.0F, 0.0F);
    	}
    	if(entity.ridding)GL11.glRotatef(-30F, 1.0F, 0.0F, 0.0F);
    	GL11.glTranslatef(- legx, - legy, - legz);
		tankk.renderPart("feet_l");
		tankk.renderPart("sf_l");
    	GL11.glPopMatrix();//glend
    }
    private void renderleg_right(EntityGVCR2_SP_REX entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	float Ax = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
    	GL11.glPushMatrix();//glstart
    	float motion =  Ax * (180F / (float)Math.PI) ;
    	GL11.glTranslatef(- kneex, kneey, kneez);
    	GL11.glRotatef(-10, 0.0F, 0.0F, 1.0F);
    	//GL11.glRotatef(motion * 1F, -1.0F, 0.0F, 0.0F);
    	if(entity.move_mode == 3) {
    		//if(motion < 0)GL11.glRotatef(motion * 1F, 0.0F, 0.0F, -1.0F);
    		GL11.glRotatef(motion * 1F, -1.0F, 0.0F, 0.0F);//反対
    		GL11.glRotatef(10, 0.0F, 0.0F, 1.0F);
    	}else if(entity.move_mode == 4) {
    		//if(motion > 0)GL11.glRotatef(motion * 1F, 0.0F, 0.0F, 1.0F);
    		GL11.glRotatef(motion * 1F, -1.0F, 0.0F, 0.0F);
    		GL11.glRotatef(-10, 0.0F, 0.0F, 1.0F);
    	}else 
    		if(entity.move_mode == 5) {
    		GL11.glRotatef(30, -1.0F, 0.0F, 0.0F);//反対
    		GL11.glRotatef(10, 0.0F, 0.0F, 1.0F);
    	}else {
    		GL11.glRotatef(motion * 1F, -1.0F, 0.0F, 0.0F);
    	}
    	if(entity.ridding)GL11.glRotatef(30F, 1.0F, 0.0F, 0.0F);
    	GL11.glTranslatef( kneex,  - kneey, -  kneez);
    	tankk.renderPart("knee_r");
    	tankk.renderPart("leg_r");
    	GL11.glTranslatef(- legx, legy, legz);
    	//GL11.glRotatef(motion * 1F, 1.0F, 0.0F, 0.0F);
    	if(entity.move_mode == 3) {
    		//if(motion < 0)GL11.glRotatef(motion * 1F, 0.0F, 0.0F, 1.0F);
    		GL11.glRotatef(motion * 1F, 1.0F, 0.0F, 0.0F);//反対
    		GL11.glRotatef(10, 0.0F, 0.0F, 1.0F);
    	}else if(entity.move_mode == 4) {
    		//if(motion > 0)GL11.glRotatef(motion * 1F, 0.0F, 0.0F, -1.0F);
    		GL11.glRotatef(motion * 1F, 1.0F, 0.0F, 0.0F);
    		GL11.glRotatef(-10, 0.0F, 0.0F, 1.0F);
    	}else 
    		if(entity.move_mode == 5) {
    		GL11.glRotatef(30, 1.0F, 0.0F, 0.0F);//反対
    		GL11.glRotatef(-0, 0.0F, 0.0F, 1.0F);
    	}else {
    		GL11.glRotatef(motion * 1F, 1.0F, 0.0F, 0.0F);
    	}
    	if(entity.ridding)GL11.glRotatef(-30F, 1.0F, 0.0F, 0.0F);
    	GL11.glTranslatef( legx, - legy, - legz);
		tankk.renderPart("feet_r");
		tankk.renderPart("sf_r");
    	GL11.glPopMatrix();//glend
    }
    
    private void renderbody(EntityGVCR2_SP_REX entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	GL11.glPushMatrix();//glstart
    	if(!entity.ridding) {
    		GL11.glTranslatef(headx, heady, headz);
    		GL11.glRotatef(20F, 1.0F, 0.0F, 0.0F);
    		GL11.glTranslatef(- headx, - heady, - headz);
    	}
    	tankk.renderPart("head");
    	if(!entity.ridding) {
    		GL11.glTranslatef(headx, heady, headz);
    		GL11.glRotatef(40F, 1.0F, 0.0F, 0.0F);
    		GL11.glTranslatef(- headx, - heady, - headz);
    	}
    	tankk.renderPart("head1");
    	tankk.renderPart("seat");
    	GL11.glPopMatrix();//glend
    	
    	
    	
    	
    	GL11.glPushMatrix();//glstart
		this.renderarm_left(entity, limbSwing, limbSwingAmount, limbSwingAmount);
		GL11.glPopMatrix();//glend
    	
		GL11.glPushMatrix();//glstart
		GL11.glTranslatef(headx, heady, headz);
		/*if(entity.rotationPitch > 45){
			GL11.glRotatef(45, 1.0F, 0.0F, 0.0F);
		}else if(entity.rotationPitch < -45){
			GL11.glRotatef(-45, 1.0F, 0.0F, 0.0F);
		}else{
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
		}*/
		//GL11.glRotatef(5F, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(- headx, - heady, - headz);
		GL11.glPopMatrix();//glend
		
		GL11.glTranslatef(zarmx, zarmy, zarmz);
		GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(- zarmx, - zarmy, - zarmz);
		{
			
			
			GL11.glPushMatrix();//glstart
			this.renderarm_right(entity, limbSwing, limbSwingAmount, limbSwingAmount);
			GL11.glPopMatrix();//glend
		}
    }
    
    private void renderarm_left(EntityGVCR2_SP_REX entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	tankk.renderPart("arm_l");
    }
    private void renderarm_right(EntityGVCR2_SP_REX entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	tankk.renderPart("arm_r");
    	if(entity.getControllingPassenger() != null && entity.getControllingPassenger() == Minecraft.getMinecraft().player){
			if(entity.getRemain_L() > 0)RenderLaserSight.can(entity, -3.4F, 7.6F, zarmz, 1.0F, tex);
		}
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
    protected ResourceLocation getEntityTexture(EntityGVCR2_SP_REX entity)
    {
    	{
    		return tex;
    	}
    }
    
    protected void renderLivingAt(EntityGVCR2_SP_REX entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_SP_REX livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
    
    
    private static void newrenderreload(EntityVehicleBase vehicle, int[] remattime
			, float remat_xpoint, float remat_ypoint, float remat_zpoint
			, float[] remat_xrote, float[] remat_yrote, float[] remat_zrote){
		//if(mat != null)
		{
			for(int i = 1; i < 200; ++i) {
				if(vehicle.motion_time >= remattime[i - 1] && vehicle.motion_time < remattime[i]){
					int time = remattime[i] - remattime[i - 1];
					int nowtime = vehicle.motion_time - remattime[i - 1];
					
					float xpoint = remat_xpoint;
					//xpoint = xpoint / time;
					float ypoint = remat_ypoint;
					//ypoint = ypoint / time;
					float zpoint = remat_zpoint;
					//zpoint = zpoint / time;
					
					float xrote = remat_xrote[i] - remat_xrote[i - 1];
					xrote = xrote / time;
					float yrote = remat_yrote[i] - remat_yrote[i - 1];
					yrote = yrote / time;
					float zrote = remat_zrote[i] - remat_zrote[i - 1];
					zrote = zrote / time;
					
					/*GL11.glTranslatef((remat_xpoint[i - 1] + xpoint * nowtime)
							,(remat_ypoint[i - 1] + ypoint * nowtime)
							,(remat_zpoint[i - 1] + zpoint * nowtime));*/
					GL11.glTranslatef(remat_xpoint, remat_ypoint, remat_zpoint);
					GL11.glRotatef(remat_xrote[i - 1] + xrote * nowtime, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(remat_yrote[i - 1] + yrote * nowtime, 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(remat_zrote[i - 1] + zrote * nowtime, 0.0F, 0.0F, 1.0F);
					/*GL11.glTranslatef((remat_xmove[i - 1] + xmove * nowtime)
							,(remat_ymove[i - 1] + ymove * nowtime)
							,(remat_zmove[i - 1] + zmove * nowtime));*/
					GL11.glTranslatef(-remat_xpoint, -remat_ypoint, -remat_zpoint);
					/*GL11.glTranslatef(-(remat_xpoint[i - 1] + xpoint * nowtime)
							,-(remat_ypoint[i - 1] + ypoint * nowtime)
							,-(remat_zpoint[i - 1] + zpoint * nowtime));*/
				}
			}
			
		}
	}
}
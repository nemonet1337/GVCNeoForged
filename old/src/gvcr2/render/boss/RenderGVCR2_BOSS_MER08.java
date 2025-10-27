package gvcr2.render.boss;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.render.ModelBase_Non;
import gvcr2.entity.boss.EntityGVCR2_BOSS_MER08;
import gvcr2.entity.boss.EntityGVCR2_BOSS_MER08_SN;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class RenderGVCR2_BOSS_MER08 extends RenderLiving<EntityGVCR2_BOSS_MER08>
{
	private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/robo/mer08.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/robo/mer08.mqo"));
    
    private static final ResourceLocation merg01 = new ResourceLocation("gvcr2:textures/mob/model/robo/merg08.png");
    private static final IModelCustom merg01m = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/robo/merg08.mqo"));
    private static final ResourceLocation merg01b = new ResourceLocation("gvcr2:textures/mob/model/robo/merg08b.png");
    private static final IModelCustom merg01bm = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/robo/merg08b.mqo"));
    
    private static final ResourceLocation merg01sw = new ResourceLocation("gvcr2:textures/mob/model/robo/merg08sw.png");
    private static final IModelCustom merg01swm = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/robo/merg08sw.mqo"));
    /** instance of ModelBoat for rendering */
	
	public float kneex = 0.25F;
	public float kneey = 1.2F;
	public float kneez = 0.0F;
	
	public float legx = 0.25F;
	public float legy = 1.2F;
	public float legz = 0.0F;
	
	public float bodyx = 0.0F;
	public float bodyy = 1.35F;
	public float bodyz = 0.0F;
	
	public float headx = 0.0F;
	public float heady = 2.0F;
	public float headz = 0.0F;
	
	public float zarmx = 0.0F;
	public float zarmy = 1.8F;
	public float zarmz = 0.0F;
	
	public float elbowx = 0.65F;
	public float elbowy = 1.8F;
	public float elbowz = 0.0F;
	
	public float armx = 0.65F;
	public float army = 1.4F;
	public float armz = 0.0F;
	
	public float handx = 0.65F;
	public float handy = 1.0F;
	public float handz = 0.0F;
	
	public float wex = 0.65F;
	public float wey = 0.85F;
	public float wez = 0F;

    public RenderGVCR2_BOSS_MER08(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelBase_Non(),0.5F);
        this.shadowSize = 0.5F;
        //this.shadowSize = 0.5F;
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    public void doRender(EntityGVCR2_BOSS_MER08 entity, double x, double y, double z, float entityYaw, float partialTicks)
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
		/*if(entity.deathTime > 0){
		}else {
			if(entity.hurtTime > 0 && !(entity.getHealth() > entity.getMaxHealth()/2) && entity.getAIType2() != 0) {
				GL11.glPushMatrix();//glstart
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				GL11.glColor4f(1F, 1F, 1F, 0.4F);
				tankk.renderPart("sd");
				GL11.glColor4f(1F, 1F, 1F, 1F);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glPopMatrix();//glend
			}
			else if(!(entity.getHealth() > entity.getMaxHealth()/2) && entity.getAIType2() != 0) {
				GL11.glPushMatrix();//glstart
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				GL11.glColor4f(1F, 1F, 1F, 0.2F);
				tankk.renderPart("sd");
				GL11.glColor4f(1F, 1F, 1F, 1F);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glPopMatrix();//glend
			}
			else {
				GL11.glColor4f(1F, 1F, 1F, 1F);
			}
		}*/
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
    }

    private void renderlegs(EntityGVCR2_BOSS_MER08 entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	tankk.renderPart("waist");
    	GL11.glPushMatrix();//glstart
		this.renderleg_left(entity, limbSwing, limbSwingAmount, limbSwingAmount);
		GL11.glPopMatrix();//glend
		
		GL11.glPushMatrix();//glstart
		this.renderleg_right(entity, limbSwing, limbSwingAmount, limbSwingAmount);
		GL11.glPopMatrix();//glend
	}
    
    private void renderleg_left(EntityGVCR2_BOSS_MER08 entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	float Ax = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
    	GL11.glPushMatrix();//glstart
    	GL11.glTranslatef(kneex, kneey, kneez);
    	GL11.glRotatef(10, 0.0F, 0.0F, 1.0F);
    	GL11.glRotatef(-20, 1.0F, 0.0F, 0.0F);
    	GL11.glRotatef(Ax * (180F / (float)Math.PI) * 1F, 1.0F, 0.0F, 0.0F);
    	GL11.glTranslatef( - kneex,  - kneey, -  kneez);
    	tankk.renderPart("knee_l");
    	render_light(entity, "knee_ll");
    	GL11.glPopMatrix();//glend
    	
    	GL11.glPushMatrix();//glstart
    	GL11.glTranslatef(0.675F, 0.3F, 0F);
    	GL11.glRotatef(20, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(-0.675F,- 0.3F, 0F);
	//	GL11.glTranslatef(0.1F, 0F, 0F);
		
		GL11.glTranslatef(legx, legy, legz);
		GL11.glRotatef(8, 0.0F, 0.0F, 1.0F);
    	GL11.glRotatef(Ax * (180F / (float)Math.PI) * 1F, 1.0F, 0.0F, 0.0F);
    	GL11.glTranslatef(- legx, - legy, - legz);
		tankk.renderPart("leg_l");
		render_light(entity, "leg_ll");
		GL11.glPopMatrix();//glend
		
		GL11.glPushMatrix();//glstart
		GL11.glTranslatef(0.15F, 0F, 0F);
		GL11.glTranslatef(legx, legy, legz);
    	GL11.glRotatef(Ax * (180F / (float)Math.PI) * 1F, 1.0F, 0.0F, 0.0F);
    	GL11.glTranslatef(- legx, - legy, - legz);
		tankk.renderPart("foot_l");
		GL11.glPopMatrix();//glend
    }
    private void renderleg_right(EntityGVCR2_BOSS_MER08 entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	float Ax = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
    	GL11.glPushMatrix();//glstart
    	GL11.glTranslatef(- kneex, kneey, kneez);
    	GL11.glRotatef(-10, 0.0F, 0.0F, 1.0F);
    	GL11.glRotatef(-20, 1.0F, 0.0F, 0.0F);
    	GL11.glRotatef(Ax * (180F / (float)Math.PI) * 1F, -1.0F, 0.0F, 0.0F);
    	GL11.glTranslatef( kneex,  - kneey, -  kneez);
    	tankk.renderPart("knee_r");
    	render_light(entity, "knee_rl");
    	GL11.glPopMatrix();//glend
    	
    	GL11.glPushMatrix();//glstart
    	GL11.glTranslatef(-0.675F, 0.3F, 0F);
    	GL11.glRotatef(20, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(0.675F,- 0.3F, 0F);
	//	GL11.glTranslatef(-0.1F, 0F, 0F);
		
		GL11.glTranslatef(- legx, legy, legz);
		GL11.glRotatef(-8, 0.0F, 0.0F, 1.0F);
    	GL11.glRotatef(Ax * (180F / (float)Math.PI) * 1F, -1.0F, 0.0F, 0.0F);
    	GL11.glTranslatef( legx, - legy, - legz);
		tankk.renderPart("leg_r");
		render_light(entity, "leg_rl");
		GL11.glPopMatrix();//glend
		
		GL11.glPushMatrix();//glstart
		GL11.glTranslatef(-0.15F, 0F, 0F);
		GL11.glTranslatef(- legx, legy, legz);
    	GL11.glRotatef(Ax * (180F / (float)Math.PI) * 1F, -1.0F, 0.0F, 0.0F);
    	GL11.glTranslatef( legx, - legy, - legz);
		tankk.renderPart("foot_r");
		GL11.glPopMatrix();//glend
    }
    
    private void renderbody(EntityGVCR2_BOSS_MER08 entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	if(entity.cooltime4 < 20 && entity.startuptime > 100){
    		if(entity.cooltime4 < 7){
				GL11.glTranslatef(bodyx, bodyy, bodyz);
				GL11.glRotatef(entity.cooltime4 * 10, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(-bodyx, -bodyy, -bodyz);
			}
			if(entity.cooltime4 >= 7 && entity.cooltime4 < 13){
				int co = entity.cooltime4 - 7;
				GL11.glTranslatef(bodyx, bodyy, bodyz);
				GL11.glRotatef(co * 20 - 70, 0.0F, -1.0F, 0.0F);
				GL11.glTranslatef(-bodyx, -bodyy, -bodyz);
			}
			if(entity.cooltime4 >= 13){
				int co = entity.cooltime4 - 13;
				GL11.glTranslatef(bodyx, bodyy, bodyz);
				GL11.glRotatef(co * 10 - 50 , 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(-bodyx, -bodyy, -bodyz);
			}
    	}
    	GL11.glTranslatef(bodyx, bodyy, bodyz);
    	GL11.glRotatef(20F, 1.0F, 0.0F, 0.0F);
    	if((entity.getAIType2() == 1 || entity.getAIType2() == 2) && entity.getHealth() > entity.getMaxHealth()/2) {
    		GL11.glRotatef(-20 , 0.0F, 1.0F, 0.0F);
    	}else {
    		GL11.glRotatef(20 , 0.0F, 1.0F, 0.0F);
    	}
    	if(!(entity.getHealth() > entity.getMaxHealth()/2) && entity.getAIType() == 0 && entity.aitypetime < 30) {
    		GL11.glRotatef(30 , 1.0F, 0.0F, 0.0F);
    	}
		GL11.glTranslatef(-bodyx, -bodyy, -bodyz);
    	tankk.renderPart("body");
    	render_light(entity, "body_l");
		
		
		GL11.glPushMatrix();//glstart
		GL11.glTranslatef(headx, heady, headz);
		if(entity.rotationp > 45){
			GL11.glRotatef(45, 1.0F, 0.0F, 0.0F);
		}else if(entity.rotationp < -45){
			GL11.glRotatef(-45, 1.0F, 0.0F, 0.0F);
		}else{
			GL11.glRotatef(entity.rotationp, 1.0F, 0.0F, 0.0F);
		}
		GL11.glRotatef(-10F, 1.0F, 0.0F, 0.0F);
		if((entity.getAIType2() == 1 || entity.getAIType2() == 2) && entity.getHealth() > entity.getMaxHealth()/2) {
    		GL11.glRotatef(20 , 0.0F, 1.0F, 0.0F);
    	}else {
    		GL11.glRotatef(-20 , 0.0F, 1.0F, 0.0F);
    	}
		GL11.glTranslatef(- headx, - heady, - headz);
		tankk.renderPart("head");
		render_light(entity, "head_l");
		GL11.glPopMatrix();//glend
		
		GL11.glTranslatef(zarmx, zarmy, zarmz);
		GL11.glRotatef(entity.rotationp, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(- zarmx, - zarmy, - zarmz);
		{
			GL11.glPushMatrix();//glstart
			this.renderarm_left(entity, limbSwing, limbSwingAmount, limbSwingAmount);
			GL11.glPopMatrix();//glend
			
			GL11.glPushMatrix();//glstart
			this.renderarm_right(entity, limbSwing, limbSwingAmount, limbSwingAmount);
			GL11.glPopMatrix();//glend
			
			GL11.glPushMatrix();//glstart
			this.renderarm_rightgun(entity, limbSwing, limbSwingAmount, limbSwingAmount);
			GL11.glPopMatrix();//glend
			
			GL11.glPushMatrix();//glstart
			this.renderarm_leftgun(entity, limbSwing, limbSwingAmount, limbSwingAmount);
			GL11.glPopMatrix();//glend
			
			GL11.glPushMatrix();//glstart
			this.renderarm_subgun(entity, limbSwing, limbSwingAmount, limbSwingAmount);
			GL11.glPopMatrix();//glend
		}
    }
    
    private void renderarm_left(EntityGVCR2_BOSS_MER08 entity, float limbSwing, float limbSwingAmount, float partialTicks){
		{
			ResourceLocation tex = merg01sw;
			IModelCustom model = merg01swm;
			float elrote = -30F;
	    	float armrote = -60F;
	    	float handrote = 0;
			if((entity.getHealth() > entity.getMaxHealth()/2)){
				elrote = -45F;
	        	armrote = -90F;
	        	handrote = 45;
	        	tex = merg01b;
	        	model = merg01bm;
			}
			if(entity.getHealth() > entity.getMaxHealth()/2) {
				/*GL11.glTranslatef(elbowx, elbowy, elbowz);
			    //	GL11.glRotatef(-5F, 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(-150F, 1.0F, 0.0F, 0.0F);
					GL11.glTranslatef(- elbowx, - elbowy, - elbowz);
			    	tankk.renderPart("elbow_l");
			    	GL11.glTranslatef(armx, army, armz);
					GL11.glRotatef(-120F, 1.0F, 0.0F, 0.0F);
					GL11.glTranslatef(- armx, - army, - armz);
					tankk.renderPart("arm_l");
					GL11.glTranslatef(handx, handy, handz);
					GL11.glRotatef(0F, 1.0F, 0.0F, 0.0F);
					GL11.glTranslatef(-handx, -handy, -handz);
					{
						GL11.glPushMatrix();//glstart
						GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
						GL11.glTranslatef(wex, wez, - wey);
						Minecraft minecraft = Minecraft.getMinecraft();
						minecraft.getTextureManager().bindTexture(tex);
						model.renderPart("gun");
						GL11.glPopMatrix();//glend
					}*/
				Minecraft minecraft = Minecraft.getMinecraft();
				minecraft.getTextureManager().bindTexture(boatTextures);
				GL11.glTranslatef(elbowx, elbowy, elbowz);
				if((entity.getAIType2() == 1 || entity.getAIType2() == 2) && entity.getHealth() > entity.getMaxHealth()/2) {
		    		GL11.glRotatef(20 , 0.0F, 1.0F, 0.0F);
		    	}else {
		    		GL11.glRotatef(20 , 0.0F, 1.0F, 0.0F);
		    		GL11.glRotatef(20F, 1.0F, 0.0F, 0.0F);
		    	}
		    	GL11.glRotatef(-20F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(elrote, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(-elbowx, - elbowy, - elbowz);
		    	tankk.renderPart("elbow_l");
		    	render_light(entity, "elbow_ll");
		    	GL11.glTranslatef(armx, army, armz);
		    	if(entity.gun_count1 < 2){
	    			GL11.glRotatef(-entity.gun_count1, 1.0F, 0.0F, 0.0F);
	    		}
				GL11.glRotatef(armrote, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(-armx, - army, - armz);
				tankk.renderPart("arm_l");
				render_light(entity, "arm_ll");
				GL11.glTranslatef(handx, handy, handz);
				GL11.glRotatef(handrote, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(-handx, -handy, -handz);
				if(entity.getHealth() > entity.getMaxHealth()/2) {
					GL11.glPushMatrix();//glstart
					GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
					GL11.glTranslatef(wex, wez, - wey);
					
					minecraft.getTextureManager().bindTexture(tex);
					model.renderPart("gun");
					GL11.glPopMatrix();//glend
				}
			}else {
				if(entity.cooltime4 < 20  && entity.startuptime > 100){
					if(entity.cooltime4 < 7){
						GL11.glTranslatef(elbowx, elbowy, elbowz);
						GL11.glRotatef(entity.cooltime4 * 10, -1.0F, 1.0F, 0.0F);
						GL11.glTranslatef(- elbowx, - elbowy, - elbowz);
					}
					if(entity.cooltime4 >= 7 && entity.cooltime4 < 13){
						int co = entity.cooltime4 - 7;
						GL11.glTranslatef(elbowx, elbowy, elbowz);
						GL11.glRotatef(co * 40 - 70, 1.0F, -1.0F, 0.0F);
						GL11.glTranslatef(- elbowx, - elbowy, - elbowz);
					}
					if(entity.cooltime4 >= 13){
						int co = entity.cooltime4 - 13;
						GL11.glTranslatef(elbowx, elbowy, elbowz);
						GL11.glRotatef(co * 10 - 180 , -1.0F, 1.0F, 0.0F);
						GL11.glTranslatef(- elbowx, - elbowy, - elbowz);
					}
					GL11.glTranslatef(elbowx, elbowy, elbowz);
				    //	GL11.glRotatef(-5F, 0.0F, 1.0F, 0.0F);
						GL11.glRotatef(-150F, 1.0F, 0.0F, 0.0F);
						GL11.glTranslatef(- elbowx, - elbowy, - elbowz);
				    	tankk.renderPart("elbow_l");
				    	render_light(entity, "elbow_ll");
				    	GL11.glTranslatef(armx, army, armz);
						GL11.glRotatef(-40F, 1.0F, 0.0F, 0.0F);
						GL11.glTranslatef(- armx, - army, - armz);
						tankk.renderPart("arm_l");
						render_light(entity, "arm_ll");
						GL11.glTranslatef(handx, handy, handz);
						GL11.glRotatef(0F, 1.0F, 0.0F, 0.0F);
						GL11.glTranslatef(-handx, -handy, -handz);
						{
							GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
							GL11.glTranslatef(wex, wez, - wey);
							Minecraft minecraft = Minecraft.getMinecraft();
							minecraft.getTextureManager().bindTexture(tex);
							model.renderPart("gun");
						}
				}else {
					GL11.glTranslatef(elbowx, elbowy, elbowz);
				    //	GL11.glRotatef(-5F, 0.0F, 1.0F, 0.0F);
						GL11.glRotatef(-150F, 1.0F, 0.0F, 0.0F);
						GL11.glTranslatef(- elbowx, - elbowy, - elbowz);
				    	tankk.renderPart("elbow_l");
				    	render_light(entity, "elbow_ll");
				    	GL11.glTranslatef(armx, army, armz);
						GL11.glRotatef(-120F, 1.0F, 0.0F, 0.0F);
						GL11.glTranslatef(- armx, - army, - armz);
						tankk.renderPart("arm_l");
						render_light(entity, "arm_ll");
						GL11.glTranslatef(handx, handy, handz);
						GL11.glRotatef(0F, 1.0F, 0.0F, 0.0F);
						GL11.glTranslatef(-handx, -handy, -handz);
						{
							GL11.glPushMatrix();//glstart
							GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
							GL11.glTranslatef(wex, wez, - wey);
							Minecraft minecraft = Minecraft.getMinecraft();
							minecraft.getTextureManager().bindTexture(tex);
							model.renderPart("gun");
							GL11.glPopMatrix();//glend
						}
				}
					
			}
			
			
		}
    }
    private void renderarm_right(EntityGVCR2_BOSS_MER08 entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	ResourceLocation tex = merg01;
		IModelCustom model = merg01m;
    	float elrote = -30F;
    	float armrote = -60F;
    	float handrote = 0;
    	
    	if(entity.getArmID_S() == 1){
    		elrote = -45F;
        	armrote = -90F;
        	handrote = 45;
        	tex = merg01b;
        	model = merg01bm;
    	}
    	
    	Minecraft minecraft = Minecraft.getMinecraft();
    	if(!(entity.getHealth() > entity.getMaxHealth()/2)){
    		/*minecraft.getTextureManager().bindTexture(boatTextures2);
    		if(entity.getAIType2() == 5  && entity.startuptime > 100) {
    			if(entity.cooltime3 < 20){
    				if(entity.cooltime3 < 7){
    					GL11.glTranslatef(-elbowx, elbowy, elbowz);
    					GL11.glRotatef(entity.cooltime3 * 10, 1.0F, 0.0F, 0.0F);
    					GL11.glTranslatef(elbowx, - elbowy, - elbowz);
    				}
    				if(entity.cooltime3 >= 7 && entity.cooltime3 < 13){
    					int co = entity.cooltime3 - 7;
    					GL11.glTranslatef(-elbowx, elbowy, elbowz);
    					GL11.glRotatef(co * 40 - 70, -1.0F, 0.0F, 0.0F);
    					GL11.glTranslatef(elbowx, - elbowy, - elbowz);
    				}
    				if(entity.cooltime3 >= 13){
    					int co = entity.cooltime3 - 13;
    					GL11.glTranslatef(-elbowx, elbowy, elbowz);
    					GL11.glRotatef(co * 10 - 180 , 1.0F, 0.0F, 0.0F);
    					GL11.glTranslatef(elbowx, - elbowy, - elbowz);
    				}
    			}
    		}else {
    			if(entity.cooltime < 20  && entity.startuptime > 100){
    				if(entity.cooltime < 7){
    					GL11.glTranslatef(-elbowx, elbowy, elbowz);
    					GL11.glRotatef(entity.cooltime * 10, 1.0F, 0.0F, 0.0F);
    					GL11.glTranslatef(elbowx, - elbowy, - elbowz);
    				}
    				if(entity.cooltime >= 7 && entity.cooltime < 13){
    					int co = entity.cooltime - 7;
    					GL11.glTranslatef(-elbowx, elbowy, elbowz);
    					GL11.glRotatef(co * 40 - 70, -1.0F, 0.0F, 0.0F);
    					GL11.glTranslatef(elbowx, - elbowy, - elbowz);
    				}
    				if(entity.cooltime >= 13){
    					int co = entity.cooltime - 13;
    					GL11.glTranslatef(-elbowx, elbowy, elbowz);
    					GL11.glRotatef(co * 10 - 180 , 1.0F, 0.0F, 0.0F);
    					GL11.glTranslatef(elbowx, - elbowy, - elbowz);
    				}
    			}
    		}
			
			
			{
				GL11.glTranslatef(- elbowx, elbowy, elbowz);
				GL11.glRotatef(-20F, 0.0F, 1.0F, 0.0F);
		    	GL11.glRotatef(-20F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(elrote, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(elbowx, - elbowy, - elbowz);
		    	tankk.renderPart("elbow_r");
		    	GL11.glTranslatef(- armx, army, armz);
				GL11.glRotatef(armrote, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(armx, - army, - armz);
				tankk.renderPart("arm_r");
				GL11.glTranslatef(-handx, handy, handz);
				GL11.glRotatef(handrote, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(handx, -handy, -handz);
			}*/
    	}
    	else{
			minecraft.getTextureManager().bindTexture(boatTextures);
			GL11.glTranslatef(- elbowx, elbowy, elbowz);
			if((entity.getAIType2() == 1 || entity.getAIType2() == 2) && entity.getHealth() > entity.getMaxHealth()/2) {
	    		GL11.glRotatef(-20 , 0.0F, 1.0F, 0.0F);
	    		GL11.glRotatef(-20F, 1.0F, 0.0F, 0.0F);
	    	}else {
	    		GL11.glRotatef(-20 , 0.0F, 1.0F, 0.0F);
	    	}
	    	GL11.glRotatef(-20F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(elrote, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(elbowx, - elbowy, - elbowz);
	    	tankk.renderPart("elbow_r");
	    	render_light(entity, "elbow_rl");
	    	GL11.glTranslatef(- armx, army, armz);
	    	if(entity.gun_count1 < 2){
    			GL11.glRotatef(-entity.gun_count1, 1.0F, 0.0F, 0.0F);
    		}
			GL11.glRotatef(armrote, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(armx, - army, - armz);
			tankk.renderPart("arm_r");
			render_light(entity, "arm_rl");
			GL11.glTranslatef(-handx, handy, handz);
			GL11.glRotatef(handrote, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(handx, -handy, -handz);
			if(entity.getHealth() > entity.getMaxHealth()/2) {
				GL11.glPushMatrix();//glstart
				GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(-wex, wez, - wey);
				
				minecraft.getTextureManager().bindTexture(tex);
				model.renderPart("gun");
				GL11.glPopMatrix();//glend
			}
		}
    	
    }
    
    private void renderarm_rightgun(EntityGVCR2_BOSS_MER08 entity, float limbSwing, float limbSwingAmount, float partialTicks){
   
    }
    
    private void renderarm_leftgun(EntityGVCR2_BOSS_MER08 entity, float limbSwing, float limbSwingAmount, float partialTicks){
        
        }
    private void renderarm_subgun(EntityGVCR2_BOSS_MER08 entity, float limbSwing, float limbSwingAmount, float partialTicks){
    		
        }
    
    private void render_light(EntityGVCR2_BOSS_MER08 entity, String name){
    	GL11.glPushMatrix();//glstart
    	GL11.glDisable(GL11.GL_LIGHT1);
		GL11.glDisable(GL11.GL_LIGHTING);
    	int i = 15728880;
        int j = i % 65536;
        int k = i / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
        tankk.renderPart(name);
        GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_LIGHT1);
    	GL11.glPopMatrix();//glend
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
    
 	public void BoostRender(float bx, float by, float bz, String re, EntityGVCR2_BOSS_MER08 entity, float partialTicks){
 		boolean boost = false;
    	if(entity.posX != entity.prevPosX || entity.posZ != entity.prevPosZ){
    		boost = true;
    	}
    	if(boost){
			GL11.glPushMatrix();//glstart
			GL11.glTranslatef(bx, by, bz);
			GlStateManager.disableLighting();
        	float size = partialTicks * 0.4F + 1;
        	GlStateManager.scale(size, size, size);
        	GlStateManager.enableLighting();
        	GL11.glTranslatef(-bx, -by, -bz);
        	tankk.renderPart(re);
			GL11.glPopMatrix();//glend
    	}
 	}
 	
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGVCR2_BOSS_MER08 entity)
    {
    	return boatTextures;
    }
    
    protected void renderLivingAt(EntityGVCR2_BOSS_MER08 entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_BOSS_MER08 livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}

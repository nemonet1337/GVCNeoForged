package gvcr2.render.boss;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvcr2.entity.boss.EntityGVCR2_BOSS_IRVING;
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
public class RenderGVCR2_BOSS_IRVING extends Render<EntityGVCR2_BOSS_IRVING>
{
    private static final ResourceLocation tex = new ResourceLocation("gvcr2:textures/mob/model/robo/irving.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/robo/irving.mqo"));
    /** instance of ModelBoat for rendering */

    public float kneex = 0.5F;
	public float kneey = 2.7F;
	public float kneez = -0.1F;
	
	public float legx = 0.5F;
	public float legy = 1.9F;
	public float legz = -0.7F;
	
	public float bodyx = 0.0F;
	public float bodyy = 3.2F;
	public float bodyz = 0.3F;
	
	public float headx = 0.0F;
	public float heady = 3.2F;
	public float headz = 0.3F;
	
	public float r_armx = -0.7F;
	public float r_army = 4.3F;
	public float r_armz = -0.6F;
	
	public float l_armx = 1.0F;
	public float l_army = 3.725F;
	public float l_armz = -0.6F;
	
	public int[] body_time = new int[200];
    public float[] body_xrote = new float[200];
    public float[] body_yrote = new float[200];
    public float[] body_zrote = new float[200];
    
    public int[] waist_time = new int[200];
    public float[] waist_xrote = new float[200];
    public float[] waist_yrote = new float[200];
    public float[] waist_zrote = new float[200];
    
    public int[] leg_l_time = new int[200];
    public float[] leg_l_xrote = new float[200];
    public float[] leg_l_yrote = new float[200];
    public float[] leg_l_zrote = new float[200];
    
    public int[] leg_r_time = new int[200];
    public float[] leg_r_xrote = new float[200];
    public float[] leg_r_yrote = new float[200];
    public float[] leg_r_zrote = new float[200];
    
    public RenderGVCR2_BOSS_IRVING(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.shadowSize = 0.5F;
        
        waist_time[0] = 0;
        waist_xrote[0] = 0;
        waist_zrote[0] = 0;
        
        waist_time[1] = 20;
        waist_xrote[1] = 30;
        waist_zrote[1] = -20;
        
        waist_time[2] = 25;
        waist_xrote[2] = 30;
        waist_zrote[2] = -20;
        
        waist_time[3] = 30;
        waist_xrote[3] = -10;
        waist_zrote[3] = -20;
        
        waist_time[4] = 41;
        waist_xrote[4] = 0;
        waist_zrote[4] = 0;
        
        
        
        leg_l_time[0] = 0;
        leg_l_xrote[0] = 0;
        leg_l_zrote[0] = 0;
        
        leg_l_time[1] = 20;
        leg_l_xrote[1] = -30;
        leg_l_zrote[1] = 20;
        
        leg_l_time[2] = 25;
        leg_l_xrote[2] = -30;
        leg_l_zrote[2] = 20;
        
        leg_l_time[3] = 30;
        leg_l_xrote[3] = 10;
        leg_l_zrote[3] = 20;
        
        leg_l_time[4] = 41;
        leg_l_xrote[4] = 0;
        leg_l_zrote[4] = 0;
        
        
        leg_r_time[0] = 0;
        leg_r_xrote[0] = 0;
        leg_r_zrote[0] = 0;
        
        leg_r_time[1] = 20;
        leg_r_xrote[1] = 90;
        leg_r_zrote[1] = 0;
        
        leg_r_time[2] = 25;
        leg_r_xrote[2] = 90;
        leg_r_zrote[2] = 0;
        
        leg_r_time[3] = 30;
        leg_r_xrote[3] = -120;
        leg_r_zrote[3] = 0;
        
        waist_time[4] = 41;
        leg_r_xrote[4] = 0;
        leg_r_zrote[4] = 0;
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    public void doRender(EntityGVCR2_BOSS_IRVING entity, double x, double y, double z, float entityYaw, float partialTicks)
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
			//GL11.glPushMatrix();//glstart
			this.renderlegs(entity, limbSwing, limbSwingAmount, limbSwingAmount);
			//GL11.glPopMatrix();//glend
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

    private void renderlegs(EntityGVCR2_BOSS_IRVING entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	
    	
    	
    	{
    		GL11.glTranslatef(legx, legy, legz);
        	if(entity.getAIType() == 4 || entity.getAIType() == 5 || entity.getAIType() == 6){
        		if(entity.getClient_aitypetime(entity) <= 10) {
        			GL11.glRotatef(entity.getClient_aitypetime(entity) * 3, 1.0F, 0.0F, 0.0F);
        		}
        	}else if(entity.getAIType() == 2){
        		if(entity.getClient_aitypetime(entity) <= 10) {
        			GL11.glRotatef(entity.getClient_aitypetime(entity) * 3, 1.0F, 0.0F, 0.0F);
        		}
        		else{
        			GL11.glRotatef(30, 1.0F, 0.0F, 0.0F);
        		}
        	}
        	if(entity.getClient_counter4(entity)){
    			motion(entity, waist_time, waist_xrote, waist_yrote, waist_zrote);
    		}
        	GL11.glTranslatef(- legx, - legy, - legz);
        	tankk.renderPart("knee");
    	}
    	
    	
    	
    	GL11.glPushMatrix();//glstart
		this.renderleg_left(entity, limbSwing, limbSwingAmount, limbSwingAmount);
		GL11.glPopMatrix();//glend
		
		GL11.glPushMatrix();//glstart
		this.renderleg_right(entity, limbSwing, limbSwingAmount, limbSwingAmount);
		GL11.glPopMatrix();//glend
		
		{
			GL11.glTranslatef(kneex, kneey, kneez);
        	if(entity.getAIType() == 4 || entity.getAIType() == 5 || entity.getAIType() == 6){
        		if(entity.getClient_aitypetime(entity) <= 10) {
        			GL11.glRotatef(-entity.getClient_aitypetime(entity) * 3, 1.0F, 0.0F, 0.0F);
        		}
        	}else if(entity.getAIType() == 2){
        		if(entity.getClient_aitypetime(entity) <= 10) {
        			GL11.glRotatef(-entity.getClient_aitypetime(entity) * 3, 1.0F, 0.0F, 0.0F);
        		}
        		else{
        			GL11.glRotatef(-30, 1.0F, 0.0F, 0.0F);
        		}
        	}
        	GL11.glTranslatef( - kneex,  - kneey, -  kneez);
        	tankk.renderPart("knee");
    	}
		tankk.renderPart("waist");
	}
    
    private void renderleg_left(EntityGVCR2_BOSS_IRVING entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	float Ax = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
    	GL11.glPushMatrix();//glstart
    	GL11.glTranslatef(kneex, kneey, kneez);
    	/*if(entity.counter4){
    		GL11.glRotatef(20, 1.0F, 0.0F, 0.0F);
    	}else {
    		GL11.glRotatef(Ax * (180F / (float)Math.PI) * 1F, 1.0F, 0.0F, 0.0F);
    	}*/
    	GL11.glTranslatef( - kneex,  - kneey, -  kneez);
    	//tankk.renderPart("leg_l");
    	GL11.glTranslatef(legx, legy, legz);
    	
    	if(entity.getAIType() == 4 || entity.getAIType() == 5 || entity.getAIType() == 6){
    		if(entity.getClient_aitypetime(entity) <= 10) {
    			GL11.glRotatef(-entity.getClient_aitypetime(entity) * 3, 1.0F, 0.0F, 0.0F);
    		}
    	}else if(entity.getAIType() == 2){
    		if(entity.getClient_aitypetime(entity) <= 10) {
    			GL11.glRotatef(-entity.getClient_aitypetime(entity) * 3, 1.0F, 0.0F, 0.0F);
    		}
    		else{
    			GL11.glRotatef(-30, 1.0F, 0.0F, 0.0F);
    		}
    	}
    	if(entity.getClient_counter4(entity)){
			motion(entity, leg_l_time, leg_l_xrote, leg_l_yrote, leg_l_zrote);
		}
    	/*if(entity.getClient_counter4(entity)){
    		GL11.glRotatef(40, 0.0F, 0.0F, 1.0F);
    		GL11.glRotatef(60, 1.0F, 0.0F, 0.0F);
    		GL11.glRotatef(40, 0.0F, 1.0F, 0.0F);
    	}*/
    	else
    	{
    		GL11.glRotatef(Ax * (180F / (float)Math.PI) * 1F, -1.0F, 0.0F, 0.0F);
    	}
    	GL11.glTranslatef(- legx, - legy, - legz);
		tankk.renderPart("leg_l");
    	GL11.glPopMatrix();//glend
    }
    private void renderleg_right(EntityGVCR2_BOSS_IRVING entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	float Ax = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
    	GL11.glPushMatrix();//glstart
    	GL11.glTranslatef(- kneex, kneey, kneez);
    	/*if(entity.counter4){
    		GL11.glRotatef(40, -1.0F, 0.0F, 0.0F);
    	}else {
    		GL11.glRotatef(Ax * (180F / (float)Math.PI) * 1F, -1.0F, 0.0F, 0.0F);
    	}*/
    	GL11.glTranslatef( kneex,  - kneey, -  kneez);
    	//tankk.renderPart("leg_r");
    	GL11.glTranslatef(- legx, legy, legz);
    	
    	if(entity.getAIType() == 4 || entity.getAIType() == 5 || entity.getAIType() == 6){
    		if(entity.getClient_aitypetime(entity) <= 10) {
    			GL11.glRotatef(-entity.getClient_aitypetime(entity) * 3, 1.0F, 0.0F, 0.0F);
    		} 
    	}else if(entity.getAIType() == 2){
    		if(entity.getClient_aitypetime(entity) <= 10) {
    			GL11.glRotatef(-entity.getClient_aitypetime(entity) * 3, 1.0F, 0.0F, 0.0F);
    		}
    		else{
    			GL11.glRotatef(-30, 1.0F, 0.0F, 0.0F);
    		}
    	}
    	
    	if(entity.getClient_counter4(entity)){
			motion(entity, leg_r_time, leg_r_xrote, leg_r_yrote, leg_r_zrote);
		}
    	/*if(entity.getClient_counter4(entity)){
    		GL11.glRotatef(100, 1.0F, 0.0F, 0.0F);
    	}*/
    	else {
    		GL11.glRotatef(Ax * (180F / (float)Math.PI) * 1F, 1.0F, 0.0F, 0.0F);
    	}
    	GL11.glTranslatef( legx, - legy, - legz);
		tankk.renderPart("leg_r");
    	GL11.glPopMatrix();//glend
    }
    
    private void renderbody(EntityGVCR2_BOSS_IRVING entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	
		
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
		tankk.renderPart("body");
		tankk.renderPart("head");
		
		
		{
			GL11.glPushMatrix();//glstart
			GL11.glTranslatef(l_armx, l_army, l_armz);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-l_armx, -l_army, -l_armz);
			this.renderarm_left(entity, limbSwing, limbSwingAmount, limbSwingAmount);
			GL11.glPopMatrix();//glend
			
			GL11.glPushMatrix();//glstart
			GL11.glTranslatef(r_armx, r_army, r_armz);
			GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-r_armx, -r_army, -r_armz);
			this.renderarm_right(entity, limbSwing, limbSwingAmount, limbSwingAmount);
			GL11.glPopMatrix();//glend
		}
		GL11.glPopMatrix();//glend
		
    }
    
    private void renderarm_left(EntityGVCR2_BOSS_IRVING entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	tankk.renderPart("arm_l");
    }
    private void renderarm_right(EntityGVCR2_BOSS_IRVING entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	tankk.renderPart("arm_r");
    	tankk.renderPart("arm_r1");
    }
    
    private static void motion(EntityGVCR2_BOSS_IRVING entity, int[] remattime
			, float[] remat_xrote, float[] remat_yrote, float[] remat_zrote){
		//if(mat != null)
		{
			for(int i = 1; i < 200; ++i) {
				if(entity.getClient_cooltime4(entity) >= remattime[i - 1] && entity.getClient_cooltime4(entity) < remattime[i]){
					int time = remattime[i] - remattime[i - 1];
					int nowtime = entity.getClient_cooltime4(entity) - remattime[i - 1];
					
					float xrote = remat_xrote[i] - remat_xrote[i - 1];
					xrote = xrote / time;
					float yrote = remat_yrote[i] - remat_yrote[i - 1];
					yrote = yrote / time;
					float zrote = remat_zrote[i] - remat_zrote[i - 1];
					zrote = zrote / time;
					
					GL11.glRotatef(remat_xrote[i - 1] + xrote * nowtime, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(remat_yrote[i - 1] + yrote * nowtime, 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(remat_zrote[i - 1] + zrote * nowtime, 0.0F, 0.0F, 1.0F);
				}
			}
			
		}
	}
    
    private static float motion_x(EntityGVCR2_BOSS_IRVING entity, int[] remattime
			, float[] remat_xrote){
		float x = 0;
		{
			for(int i = 1; i < 200; ++i) {
				if(entity.getClient_cooltime4(entity) >= remattime[i - 1] && entity.getClient_cooltime4(entity) < remattime[i]){
					int time = remattime[i] - remattime[i - 1];
					int nowtime = entity.getClient_cooltime4(entity) - remattime[i - 1];
					
					float xrote = remat_xrote[i] - remat_xrote[i - 1];
					xrote = xrote / time;
					x = remat_xrote[i - 1] + xrote * nowtime;
				}
			}
			
		}
		return x;
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
    protected ResourceLocation getEntityTexture(EntityGVCR2_BOSS_IRVING entity)
    {
    	{
    		return tex;
    	}
    }
    
    protected void renderLivingAt(EntityGVCR2_BOSS_IRVING entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_BOSS_IRVING livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
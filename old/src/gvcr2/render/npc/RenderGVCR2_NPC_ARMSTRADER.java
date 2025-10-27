package gvcr2.render.npc;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.event.gun.Layermat;
import gvclib.item.ItemGunBase;
import gvclib.render.ModelBase_Non;
import gvcr2.entity.npc.EntityGVCR2_NPC_ARMSTRADER;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class RenderGVCR2_NPC_ARMSTRADER extends RenderLiving<EntityGVCR2_NPC_ARMSTRADER> //extends RenderLiving<EntityDoll>
{
	private static final ResourceLocation boatTextures = new ResourceLocation("gvcr2:textures/mob/model/biped/arms_trader.png");
    private static final IModelCustom tankk = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/biped/arms_trader.mqo"));
    
    public RenderGVCR2_NPC_ARMSTRADER(RenderManager renderManagerIn)
    {
        //super(renderManagerIn, new ModelDoll(dollmodel, dolltex),0.5F * 1);
    	super(renderManagerIn, new ModelBase_Non(),0.5F);
        this.shadowSize = 0.5F;
    }

    public void rendermodel(EntityGVCR2_NPC_ARMSTRADER entity, String model) {
    	tankk.renderPart(model);
    }
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGVCR2_NPC_ARMSTRADER entity)
    {
    	ResourceLocation dolltex = boatTextures;
		return dolltex;
    }
    
    
    
    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    float iii;
    public void doRender(EntityGVCR2_NPC_ARMSTRADER entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	float limbSwing = this.F6(entity, partialTicks);
		float limbSwingAmount = this.F5(entity, partialTicks);
    	this.bindEntityTexture(entity);
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);

		if(entity.deathTime > 0){
			GL11.glColor4f(0.6F, 0.6F, 0.6F, 1F);
		}else {
			if(entity.hurtTime > 0) {
				GL11.glColor4f(0.7F, 0.2F, 0.2F, 1F);
			}else {
				GL11.glColor4f(1F, 1F, 1F, 1F);
			}
		}
		if(entity.getattacktask() && !(entity.deathTime > 0)) {
			GL11.glRotatef(180.0F - entity.rotationYawHead, 0.0F, 1.0F, 0.0F);
		}else {
			GL11.glRotatef(180.0F - entity.renderYawOffset, 0.0F, 1.0F, 0.0F);
		}
		{
			GL11.glPushMatrix();//glstart
			this.renderlegs(entity, limbSwing, limbSwingAmount, partialTicks);
			GL11.glPopMatrix();//glend
		}
		if(entity.isRiding()) {
			GL11.glTranslatef(0F, -0.5F, 0.0F);
		}
		{
			GL11.glPushMatrix();//glstart
			this.renderbody(entity, limbSwing, limbSwingAmount, partialTicks);
			GL11.glPopMatrix();//glend
		}
		this.bindEntityTexture(entity);
		if(entity.deathTime > 0){
			GL11.glTranslatef(0F, -0.1F, 0.25F);
			GL11.glTranslatef(0F, 1.5F, 0.0F);
			GL11.glRotatef(10, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0F, -1.5F, 0.0F);
		}
		if(entity.getattacktask() && !(entity.deathTime > 0)) {
			GL11.glRotatef(-(180.0F - entity.rotationYawHead), 0.0F, 1.0F, 0.0F);
		}else {
			GL11.glRotatef(-(180.0F - entity.renderYawOffset), 0.0F, 1.0F, 0.0F);
		}
		GL11.glTranslatef(0F, 1.5F, 0.0F);
		GL11.glRotatef(180.0F - entity.rotationYawHead, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(entity.rotationPitch, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(0F, -1.5F, 0.0F);
		this.rendermodel(entity, "head");
		this.rendermodel(entity, "head1");
		EntityPlayer player = Minecraft.getMinecraft().player;
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    private void renderlegs(EntityGVCR2_NPC_ARMSTRADER entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	GL11.glPushMatrix();//glstart
    	{
			float Ax = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
			GL11.glTranslatef(0.15F, 0.625F, 0.0F);//GL11.glTranslatef(0.15F, 0.75F, 0.0F);
			if(entity.getMoveT() == 3 || entity.isRiding()) {
				GL11.glTranslatef(0F, -0.5F, 0.0F);
				GL11.glRotatef(-90, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20, 0.0F, 0.0F, 1.0F);
			}else {
				GL11.glRotatef(Ax * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
			}
			GL11.glTranslatef(-0.15F, -0.625F, 0.0F);
			this.rendermodel(entity, "leg_l");
		}
		GL11.glPopMatrix();//glend
		
		GL11.glPushMatrix();//glstart
		{
			float Ax =MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
			GL11.glTranslatef(-0.15F, 0.625F, 0.0F);
			if(entity.getMoveT() == 3 || entity.isRiding()) {
				GL11.glTranslatef(0F, -0.5F, 0.0F);
				GL11.glRotatef(-90, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(-20, 0.0F, 0.0F, 1.0F);
			}else {
				GL11.glRotatef(Ax * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
			}
			GL11.glTranslatef(0.15F, -0.625F, 0.0F);
			this.rendermodel(entity, "leg_r");
		}
		GL11.glPopMatrix();//glend
	}
    
    private void renderbody(EntityGVCR2_NPC_ARMSTRADER entity, float limbSwing, float limbSwingAmount, float partialTicks){
    	if(entity.deathTime > 0){
    		GL11.glTranslatef(0F, 0.75F, 0.0F);
    		GL11.glRotatef(20, 1.0F, 0.0F, 0.0F);
    		GL11.glTranslatef(0F, -0.75F, 0.0F);
    	}
    	GL11.glPushMatrix();//glstart
    	this.rendermodel(entity, "body");
		this.rendermodel(entity, "body1");
		this.rendermodel(entity, "mantle");
		GL11.glPopMatrix();//glend
    	
		ItemStack main = entity.getHeldItemMainhand();
		ItemStack off = entity.getHeldItemOffhand();
		 float arm_l_rotex = 0;
	     float arm_l_rotez = 0;
	     float arm_l_rotey = 0;
	     float arm_r_rotex = 0;
	     float arm_r_rotez = 0;
	     float arm_r_rotey = 0;
    	GL11.glPushMatrix();//glstart
    	{
			float Ax = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
			GL11.glTranslatef(0.35F, 1.375F, 0.0F);
			//arm_l_rotex = (MathHelper.sin(partialTicks * 0.067F) * 0.05F) * (180F / (float)Math.PI);
			arm_l_rotex = Ax * (180F / (float)Math.PI);
			//arm_l_rotez = (MathHelper.cos(partialTicks * 0.09F) * 0.05F + 0.05F) * (180F / (float)Math.PI);
			//GL11.glRotatef(Ax * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
			//GL11.glRotatef(-(MathHelper.cos(partialTicks * 0.09F) * 0.05F + 0.05F) * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
			//GL11.glRotatef(-(MathHelper.sin(partialTicks * 0.067F) * 0.05F) * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(arm_l_rotex, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(arm_l_rotey, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(arm_l_rotez, 0.0F, 0.0F, 1.0F);
			
			//GL11.glRotatef(MathHelper.sin(partialTicks / 100) * 30F, 1.0F, 0.0F, 0.0F);
			//GL11.glRotatef(MathHelper.cos(partialTicks / 100) * 30F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(-0.35F, -1.375F, 0.0F);
			this.rendermodel(entity, "arm_l");
			if (!off.isEmpty() && off.getItem() instanceof ItemGunBase){
				ItemGunBase gun = (ItemGunBase) off.getItem();
				String tex = gun.obj_tex;
				IModelCustom model = gun.obj_model;
				GL11.glPushMatrix();//glstart
				GL11.glScalef(0.1875F, 0.1875F, 0.1875F);
				GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(0.375F * 5.33F, 0 , -0.85F * 5.33F + 0.2F);//x,z,y
				
				Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(tex));
				gun.obj_model.renderPart("mat1");
				gun.obj_model.renderPart("mat2");
				gun.obj_model.renderPart("mat3");
				Layermat.rendersight( entity,  off,  gun);
				Layermat.renderattachment( entity,  off,  gun);
				gun.obj_model.renderPart("mat25");
				gun.obj_model.renderPart("mat31");
				gun.obj_model.renderPart("mat32");/**/
				GL11.glPopMatrix();//glend
				this.bindEntityTexture(entity);
			}
		}
		GL11.glPopMatrix();//glend
		
		GL11.glPushMatrix();//glstart
		{
			float Ax = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
			GL11.glTranslatef(-0.35F, 1.375F, 0.0F);
			arm_r_rotex = Ax * (180F / (float)Math.PI);
			
			//arm_r_rotez = (MathHelper.cos(partialTicks * 0.09F) * 0.05F + 0.05F) * (180F / (float)Math.PI);
			//GL11.glRotatef(Ax * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
			//GL11.glRotatef((MathHelper.cos(partialTicks * 0.09F) * 0.05F + 0.05F) * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
			//GL11.glRotatef((MathHelper.sin(partialTicks * 0.067F) * 0.05F) * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(arm_r_rotex, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(arm_r_rotey, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(arm_r_rotez, 0.0F, 0.0F, 1.0F);
			
			//GL11.glRotatef(MathHelper.sin(partialTicks / 100) * 50F, 1.0F, 0.0F, 0.0F);
			//GL11.glRotatef(MathHelper.cos(partialTicks / 100) * 50F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(0.35F, -1.375F, 0.0F);
			this.rendermodel(entity, "arm_r");
			
			
		}
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
    
    protected void renderLivingAt(EntityGVCR2_NPC_ARMSTRADER entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }
    protected float handleRotationFloat(EntityGVCR2_NPC_ARMSTRADER livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
}
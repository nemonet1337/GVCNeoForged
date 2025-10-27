package gvcr2.render.tile;


import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvcr2.mod_GVCR2;
import gvcr2.block.tile.TileEntityBlockBossSpawn_Tile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class TileRenderBlockBossSpawn_Tile extends TileEntitySpecialRenderer<TileEntityBlockBossSpawn_Tile>
{
	private static final ResourceLocation longlegt = new ResourceLocation("gvcr2:textures/mob/model/robo/longleg.png");
    private static final IModelCustom longleg = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/robo/longleg.mqo"));
    
    private static final ResourceLocation st1t = new ResourceLocation("gvcr2:textures/mob/model/robo/st1break.png");
    private static final IModelCustom st1 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/robo/st1.mqo"));

    private static final ResourceLocation mer08t = new ResourceLocation("gvcr2:textures/mob/model/robo/mer08.png");
    private static final IModelCustom mer08 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/robo/mer08.mqo"));
    
    private static final ResourceLocation mer08t_sn = new ResourceLocation("gvcr2:textures/mob/model/robo/mer08_sn.png");
    private static final IModelCustom mer08_sn = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/robo/mer08_sn.mqo"));
    
    private static final ResourceLocation haunebt = new ResourceLocation("gvcr2:textures/mob/model/robo/hauneb.png");
    private static final IModelCustom hauneb = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/robo/hauneb.mqo"));
    
    private static final ResourceLocation mer03kt = new ResourceLocation("gvcr2:textures/mob/model/robo/mer03k.png");
    private static final IModelCustom mer03k = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/mob/model/robo/mer03k.mqo"));
    
    private static final String __OBFID = "CL_00000965";

    public TileRenderBlockBossSpawn_Tile()
    {
    }

    public float kneex = 0.25F;
	public float kneey = 1.2F;
	public float kneez = 0.0F;
	
	public float legx = 0.25F;
	public float legy = 0.65F;
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
    
    public void render(TileEntityBlockBossSpawn_Tile te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
    	Minecraft minecraft = Minecraft.getMinecraft();
    	
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslatef((float)x + 0.5F, (float)y + 0F, (float)z + 0.5F);
        //GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
        if(te.id == 1) {
        	this.bindTexture(longlegt);
        	longleg.renderPart("body");
        	longleg.renderPart("leg_l1");
        	longleg.renderPart("leg_l2");
        	longleg.renderPart("leg_r1");
        	longleg.renderPart("leg_r2");
        	/*longleg.renderPart("head");
        	longleg.renderPart("head0");
        	longleg.renderPart("head1");
        	longleg.renderPart("head2");
        	longleg.renderPart("gun_l1");
        	longleg.renderPart("gun_arm_l1");
        	longleg.renderPart("gun_l2");
        	longleg.renderPart("gun_arm_l2");
        	longleg.renderPart("gun_r1");
        	longleg.renderPart("gun_arm_r1");
        	longleg.renderPart("gun_r2");
        	longleg.renderPart("gun_arm_r2");*/
        }
        if(te.id == 2){
        	GL11.glPushMatrix();//glstart
        	this.bindTexture(st1t);
        	st1.renderPart("waist");
        	st1.renderPart("leftleg1");
        	st1.renderPart("leftleg2");
        	st1.renderPart("leftleg3");
        	st1.renderPart("rightleg1");
        	st1.renderPart("rightleg2");
        	st1.renderPart("rightleg3");
        	st1.renderPart("body");
        	st1.renderPart("head");
        	st1.renderPart("head1");
        	st1.renderPart("leftarm");
        	st1.renderPart("leftarm1");
        	st1.renderPart("rightarm");
        	st1.renderPart("rightarm1");
        	GL11.glPopMatrix();//glend
        }
        if(te.id == 3){
        	GL11.glPushMatrix();//glstart
        	GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
        	GL11.glTranslatef(0, -1.2F,0);
        	this.bindTexture(mer08t);
        	mer08.renderPart("waist");
        	{
        		GL11.glPushMatrix();//glstart
            	GL11.glTranslatef( kneex, kneey, kneez);
            	GL11.glRotatef(-120, 1.0F, 0.0F, 0.0F);
            	GL11.glTranslatef( -kneex,  - kneey, -  kneez);
            	mer08.renderPart("knee_r");
            	mer08.renderPart("knee_l");
            //	GL11.glPopMatrix();//glend
        		
            //	GL11.glPushMatrix();//glstart
        		GL11.glTranslatef( legx, legy, legz);
        		GL11.glRotatef(50, 1.0F, 0.0F, 0.0F);
            	GL11.glTranslatef( -legx, - legy, - legz);
            	mer08.renderPart("leg_r");
            	mer08.renderPart("foot_r");
            	mer08.renderPart("leg_l");
            	mer08.renderPart("foot_l");
        		GL11.glPopMatrix();//glend
        		
        	}
        	{
        		GL11.glPushMatrix();//glstart
        		GL11.glTranslatef(bodyx, bodyy, bodyz);
        		GL11.glRotatef(-20, 1.0F, 0.0F, 0.0F);
        		GL11.glTranslatef(-bodyx, -bodyy, -bodyz);
        		mer08.renderPart("body");
        		{
        			GL11.glPushMatrix();//glstart
        			GL11.glTranslatef(headx, heady, headz);
        			GL11.glRotatef(40, 1.0F, 0.0F, 0.0F);
            		GL11.glTranslatef(- headx, - heady, - headz);
            		mer08.renderPart("head");
            		mer08.renderPart("head1");
                	GL11.glPopMatrix();//glend
        		}
        		GL11.glTranslatef(- elbowx, elbowy, elbowz);
        		GL11.glRotatef(20, 1.0F, 0.0F, 0.0F);
    			GL11.glTranslatef(elbowx, - elbowy, - elbowz);
    			mer08.renderPart("elbow_l");
    			mer08.renderPart("elbow_r");
        		
        		GL11.glTranslatef(armx, army, armz);
        		GL11.glRotatef(-60, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(- armx, - army, - armz);
				mer08.renderPart("arm_l");
				mer08.renderPart("arm_r");
        		
        		GL11.glPopMatrix();//glend
        	}
        	GL11.glPopMatrix();//glend
        }
        if(te.id == 4){
        	GL11.glPushMatrix();//glstart
        	GL11.glTranslatef(0, -1.2F,0);
        	this.bindTexture(mer08t_sn);
        	mer08_sn.renderPart("waist");
        	{
        		GL11.glPushMatrix();//glstart
            	GL11.glTranslatef( kneex, kneey, kneez);
            	GL11.glRotatef(-120, 1.0F, 0.0F, 0.0F);
            	GL11.glTranslatef( -kneex,  - kneey, -  kneez);
            	mer08_sn.renderPart("knee_r");
            	mer08_sn.renderPart("knee_l");
            //	GL11.glPopMatrix();//glend
        		
            //	GL11.glPushMatrix();//glstart
        		GL11.glTranslatef( legx, legy, legz);
        		GL11.glRotatef(50, 1.0F, 0.0F, 0.0F);
            	GL11.glTranslatef( -legx, - legy, - legz);
            	mer08_sn.renderPart("leg_r");
            	mer08_sn.renderPart("foot_r");
            	mer08_sn.renderPart("leg_l");
            	mer08_sn.renderPart("foot_l");
        		GL11.glPopMatrix();//glend
        		
        	}
        	{
        		GL11.glPushMatrix();//glstart
        		GL11.glTranslatef(bodyx, bodyy, bodyz);
        		GL11.glRotatef(-20, 1.0F, 0.0F, 0.0F);
        		GL11.glTranslatef(-bodyx, -bodyy, -bodyz);
        		mer08_sn.renderPart("body");
        		{
        			GL11.glPushMatrix();//glstart
        			GL11.glTranslatef(headx, heady, headz);
        			GL11.glRotatef(40, 1.0F, 0.0F, 0.0F);
            		GL11.glTranslatef(- headx, - heady, - headz);
            		mer08_sn.renderPart("head");
                	mer08_sn.renderPart("head1");
                	GL11.glPopMatrix();//glend
        		}
        		GL11.glTranslatef(- elbowx, elbowy, elbowz);
        		GL11.glRotatef(20, 1.0F, 0.0F, 0.0F);
    			GL11.glTranslatef(elbowx, - elbowy, - elbowz);
    			mer08_sn.renderPart("elbow_l");
        		mer08_sn.renderPart("elbow_r");
        		
        		GL11.glTranslatef(armx, army, armz);
        		GL11.glRotatef(-60, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(- armx, - army, - armz);
            	mer08_sn.renderPart("arm_l");
            	mer08_sn.renderPart("arm_r");
        		
        		GL11.glPopMatrix();//glend
        	}
        	
        	
        	GL11.glPopMatrix();//glend
        }
        
        if(te.id == 5){
        	GL11.glPushMatrix();//glstart
        	GL11.glTranslatef(0, -1.2F,0);
        	this.bindTexture(haunebt);
        	hauneb.renderPart("mat1");
        	
        	hauneb.renderPart("mat4_1");
        	hauneb.renderPart("mat5_1");
        	hauneb.renderPart("mat4_2");
        	hauneb.renderPart("mat5_2");
        	hauneb.renderPart("mat4_3");
        	hauneb.renderPart("mat5_3");
        	hauneb.renderPart("mat4_4");
        	hauneb.renderPart("mat5_4");
        	
        	hauneb.renderPart("mat7");
        	hauneb.renderPart("mat8");
        	
        	GL11.glPopMatrix();//glend
        }
        
        
        if(te.id == 9){
        	GL11.glPushMatrix();//glstart
        	GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
        	this.bindTexture(mer03kt);
        	mer03k.renderPart("waist");
        	mer03k.renderPart("knee_r");
        	mer03k.renderPart("knee_l");
        	mer03k.renderPart("leg_r");
        	mer03k.renderPart("foot_r");
        	mer03k.renderPart("leg_l");
        	mer03k.renderPart("foot_l");
        	mer03k.renderPart("body");
        	mer03k.renderPart("head");
        	mer03k.renderPart("head1");
        	mer03k.renderPart("elbow_l");
        	mer03k.renderPart("elbow_r");
        	mer03k.renderPart("arm_l");
        	mer03k.renderPart("arm_r");
        	
        	GL11.glPopMatrix();//glend
        }
        
        GL11.glColor4f(1F, 1F, 1F, 1F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        
    }
}
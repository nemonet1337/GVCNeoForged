
package gvcr2.render.mob; 

 
import gvclib.event.gun.LayerGunBase;
import gvclib.render.LayerSoldierArmorBase;
import gvclib.render.ModelSoldier;
import gvclib.render.ModelSoldier64;
//import gvclib.entity.living.EntityGVCLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeBeach;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraft.world.biome.BiomeRiver; 

 

public class Render_GE_S extends RenderBiped<EntityLiving>//これを入れると防具がバグる
{ 
	
	private  ResourceLocation tex = new ResourceLocation("gvcr2:textures/mob/guerrilla.png"); 
	private  ResourceLocation tex_mr = new ResourceLocation("gvcr2:textures/mob/guerrilla_mr.png"); 

	private final float scale;
 
 	public Render_GE_S(RenderManager p_i46193_1_, float size) 
	{ 
 		 
 		super(p_i46193_1_, new ModelSoldier64(0.0F, true),0.5F * size); //0.5F
 		
 		//this.addLayer(new LayerHeldItem(this));
 		//this.addLayer(new LayerSoldierArmor(this));
 		this.addLayer(new LayerSoldierArmorBase(this));
 		//this.addLayer(new LayerSoldierArmor(this));
 		//skeletonTextures = new ResourceLocation(string);
 		this.scale = size;
 		this.addLayer(new LayerGunBase(this));
	} 
 	 public void doRender(EntityLiving entity, double x, double y, double z, float entityYaw, float partialTicks)
     {
     	{
 			super.doRender(entity, x, y, z, entityYaw, partialTicks);
 		}
     }
 	 /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntityLiving entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.scale(this.scale, this.scale, this.scale);
    }
 	
 	@Override 
 	protected ResourceLocation getEntityTexture(EntityLiving par1EntityLiving) 
 	{ 
 		ResourceLocation te = this.tex;
 		Biome biome = par1EntityLiving.world.getBiome(new BlockPos(par1EntityLiving.posX,par1EntityLiving.posY, par1EntityLiving.posZ));
 		if(biome instanceof BiomeOcean || biome instanceof BiomeRiver  || biome instanceof BiomeBeach){
 			 te = this.tex_mr;
 		}
 		
 		return te; 
 	} 
 } 

 
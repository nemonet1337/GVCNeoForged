package gvcr2.render.tile;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.mod_GVCLib;
import gvclib.item.ItemGunBase;
import gvcr2.block.tile.TileEntityBlock_GunRack_Deco;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class TileRenderBlock_GunRack_Deco extends TileEntitySpecialRenderer<TileEntityBlock_GunRack_Deco> {
	private static final ResourceLocation box = new ResourceLocation(
			"gvcr2:textures/blocks/tile/block_gunrack_hsi_deco.png");
	private static final IModelCustom box_model = AdvancedModelLoader
			.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/block_gunrack_hsi_deco.mqo"));
	
	private static final ResourceLocation box2 = new ResourceLocation(
			"gvcr2:textures/blocks/tile/block_gunrack_rsi_deco.png");
	private static final IModelCustom box_model2 = AdvancedModelLoader
			.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/block_gunrack_rsi_deco.mqo"));
	
	private static final ResourceLocation box3 = new ResourceLocation(
			"gvcr2:textures/blocks/tile/block_gunrack_rsw_deco.png");
	private static final IModelCustom box_model3 = AdvancedModelLoader
			.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/block_gunrack_rsw_deco.mqo"));
	
	private static final ResourceLocation box4 = new ResourceLocation(
			"gvcr2:textures/blocks/tile/block_gunrack_hti_deco.png");
	private static final IModelCustom box_model4 = AdvancedModelLoader
			.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/block_gunrack_hti_deco.mqo"));
	
	private static final ResourceLocation box5 = new ResourceLocation(
			"gvcr2:textures/blocks/tile/block_gunrack_rti1_deco.png");
	private static final IModelCustom box_model5 = AdvancedModelLoader
			.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/block_gunrack_rti1_deco.mqo"));
	
	private static final ResourceLocation box6 = new ResourceLocation(
			"gvcr2:textures/blocks/tile/block_gunrack_rti2_deco.png");
	private static final IModelCustom box_model6 = AdvancedModelLoader
			.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/block_gunrack_rti2_deco.mqo"));

	public TileRenderBlock_GunRack_Deco() {
	}

	public void render(TileEntityBlock_GunRack_Deco tile, double x, double y, double z, float partialTicks, int destroyStage,
			float alpha) {
		Minecraft minecraft = Minecraft.getMinecraft();

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0F, (float) z + 0.5F);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		GL11.glColor4f(1F, 1F, 1F, 1.0F);

		/*
		 * if (tile.houkou == 1) { GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F); } else if
		 * (tile.houkou == 2) { GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F); } else if
		 * (tile.houkou == 3) { GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F); } else {
		 * 
		 * }
		 */
		if (tile.facing == 1) {
			GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		} else if (tile.facing == 2) {
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		} else if (tile.facing == 3) {
			GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
		} else {
			// GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
		}

		if (tile.id == 1) {
			this.bindTexture(box2);
			box_model2.renderPart("mat1");
			
		} 
		else if (tile.id == 2) {
			this.bindTexture(box3);
			box_model3.renderPart("mat1");
			
		} 
		
		else if (tile.id == 3) {
			this.bindTexture(box4);
			box_model4.renderPart("mat1");
			
		} 
		
		else if (tile.id == 4) {
			this.bindTexture(box5);
			box_model5.renderPart("mat1");
			
		} 
		
		else if (tile.id == 5) {
			this.bindTexture(box6);
			box_model6.renderPart("mat1");
			
		} 
		
		
		else {
			this.bindTexture(box);
			box_model.renderPart("mat1");
			
		}
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();

	}

	public void RenderGun(ItemGunBase gun) {
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(gun.obj_tex));
		gun.obj_model.renderPart("mat1");
		gun.obj_model.renderPart("mat2");
		// gun.obj_model.renderPart("mat3");
		// Layermat.rendersight( entity, stack, gun);
		// Layermat.renderattachment( entity, stack, gun);
		gun.obj_model.renderPart("mat25");
		gun.obj_model.renderPart("mat31");
		gun.obj_model.renderPart("mat32");/**/
	}

}
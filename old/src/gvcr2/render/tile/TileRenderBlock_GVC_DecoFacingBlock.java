package gvcr2.render.tile;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvcr2.block.tile.TileEntity_GVC_DecoFacingBlock;
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
public class TileRenderBlock_GVC_DecoFacingBlock extends TileEntitySpecialRenderer<TileEntity_GVC_DecoFacingBlock> {
	private static final ResourceLocation t_9mmpack_gc = new ResourceLocation("gvcr2:textures/blocks/tile/9mmpack_gc.png");
	private static final IModelCustom m_9mmpack_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/9mmpack_gc.mqo"));
	
	private static final ResourceLocation t_45pack_gc = new ResourceLocation("gvcr2:textures/blocks/tile/45pack_gc.png");
	private static final IModelCustom m_45pack_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/45pack_gc.mqo"));
	
	private static final ResourceLocation t_223pack_gc = new ResourceLocation("gvcr2:textures/blocks/tile/223pack_gc.png");
	private static final IModelCustom m_223pack_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/223pack_gc.mqo"));
	
	private static final ResourceLocation t_308pack_gc = new ResourceLocation("gvcr2:textures/blocks/tile/308pack_gc.png");
	private static final IModelCustom m_308pack_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/308pack_gc.mqo"));
	
	private static final ResourceLocation t_50bmgpack_gc = new ResourceLocation("gvcr2:textures/blocks/tile/50bmgpack_gc.png");
	private static final IModelCustom m_50bmgpack_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/50bmgpack_gc.mqo"));
	
	private static final ResourceLocation t_12gpack_gc = new ResourceLocation("gvcr2:textures/blocks/tile/12gpack_gc.png");
	private static final IModelCustom m_12gpack_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/12gpack_gc.mqo"));
	
	private static final ResourceLocation t_40mmgr_ammo_gc = new ResourceLocation("gvcr2:textures/blocks/tile/40mmgr_ammo_gc.png");
	private static final IModelCustom m_40mmgr_ammo_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/40mmgr_ammo_gc.mqo"));
	
	private static final ResourceLocation t_grenade_box_gc = new ResourceLocation("gvcr2:textures/blocks/tile/grenade_box.png");
	private static final IModelCustom m_grenade_box_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/grenade_box.mqo"));
	
	private static final ResourceLocation t_rpg_ammobox1 = new ResourceLocation("gvcr2:textures/blocks/tile/rpg_ammobox1.png");
	private static final IModelCustom m_rpg_ammobox1 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/rpg_ammobox1.mqo"));
	
	private static final ResourceLocation t_rpg_ammobox2 = new ResourceLocation("gvcr2:textures/blocks/tile/rpg_ammobox2.png");
	private static final IModelCustom m_rpg_ammobox2 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/rpg_ammobox2.mqo"));
	
	private static final ResourceLocation t_ammo_mass = new ResourceLocation("gvcr2:textures/blocks/tile/ammo_mass.png");
	private static final IModelCustom m_ammo_mass = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/ammo_mass.mqo"));
	
	private static final ResourceLocation t_m18_claymore = new ResourceLocation("gvcr2:textures/blocks/tile/m18_claymore.png");
	private static final IModelCustom m_m18_claymore = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/m18_claymore.mqo"));
	
	private static final ResourceLocation t_m72_box = new ResourceLocation("gvcr2:textures/blocks/tile/m72_box.png");
	private static final IModelCustom m_m72_box = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/m72_box.mqo"));
	
	private static final ResourceLocation t_rpg_box = new ResourceLocation("gvcr2:textures/blocks/tile/rpg_box.png");
	private static final IModelCustom m_rpg_box = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/rpg_box.mqo"));
	
	private static final ResourceLocation t_medbag_gc = new ResourceLocation("gvcr2:textures/blocks/tile/medbag_gc.png");
	private static final IModelCustom m_medbag_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/medbag_gc.mqo"));
	
	private static final ResourceLocation t_laptop = new ResourceLocation("gvcr2:textures/blocks/tile/laptop.png");
	private static final IModelCustom m_laptop = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/laptop.mqo"));
	
	private static final ResourceLocation t_toughbook = new ResourceLocation("gvcr2:textures/blocks/tile/toughbook.png");
	private static final IModelCustom m_toughbook = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/toughbook.mqo"));
	
	private static final ResourceLocation t_monitor1 = new ResourceLocation("gvcr2:textures/blocks/tile/monitor1.png");
	private static final IModelCustom m_monitor1 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/monitor1.mqo"));
	
	private static final ResourceLocation t_man_target = new ResourceLocation("gvcr2:textures/blocks/tile/man_target.png");
	private static final IModelCustom m_man_target = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/man_target.mqo"));
	
	private static final ResourceLocation t_old_radio = new ResourceLocation("gvcr2:textures/blocks/tile/old_radio.png");
	private static final IModelCustom m_old_radio = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/old_radio.mqo"));
	
	private static final ResourceLocation t_radio_big = new ResourceLocation("gvcr2:textures/blocks/tile/radio_big.png");
	private static final IModelCustom m_radio_big = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/radio_big.mqo"));
	
	private static final ResourceLocation t_sincgars = new ResourceLocation("gvcr2:textures/blocks/tile/sincgars.png");
	private static final IModelCustom m_sincgars = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/sincgars.mqo"));
	
	private static final ResourceLocation t_burn_barrel = new ResourceLocation("gvcr2:textures/blocks/tile/burn_barrel.png");
	private static final IModelCustom m_burn_barrel = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/burn_barrel.mqo"));
	private static final ResourceLocation box1 = new ResourceLocation("gvclib:textures/blocks/b_fire1.png");
    private static final ResourceLocation box2 = new ResourceLocation("gvclib:textures/blocks/b_fire2.png");
    private static final ResourceLocation box3 = new ResourceLocation("gvclib:textures/blocks/b_fire3.png");
    private static final ResourceLocation box4 = new ResourceLocation("gvclib:textures/blocks/b_fire4.png");
    private static final IModelCustom box_model = AdvancedModelLoader.loadModel(
    		new ResourceLocation("gvclib:textures/blocks/b_fire.mqo"));
	
	private static final ResourceLocation t_at_obstacles = new ResourceLocation("gvcr2:textures/blocks/tile/at_obstacles.png");
	private static final IModelCustom m_at_obstaclesc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/at_obstacles.mqo"));
	
	private static final ResourceLocation t_barbed1_gc = new ResourceLocation("gvcr2:textures/blocks/tile/barbed1_gc.png");
	private static final IModelCustom m_barbed1_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/barbed1_gc.mqo"));
	
	private static final ResourceLocation t_barbed2_gc = new ResourceLocation("gvcr2:textures/blocks/tile/barbed2_gc.png");
	private static final IModelCustom m_barbed2_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/barbed2_gc.mqo"));
	
	private static final ResourceLocation t_fire_exti_gc = new ResourceLocation("gvcr2:textures/blocks/tile/fire_exti_gc.png");
	private static final IModelCustom m_fire_exti_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/fire_exti_gc.mqo"));
	
	private static final ResourceLocation t_mil_cont1_gc = new ResourceLocation("gvcr2:textures/blocks/tile/mil_cont1_gc.png");
	private static final IModelCustom m_mil_cont1_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/mil_cont1_gc.mqo"));
	
	private static final ResourceLocation t_mil_cont2_gc = new ResourceLocation("gvcr2:textures/blocks/tile/mil_cont2_gc.png");
	private static final IModelCustom m_mil_cont2_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/mil_cont2_gc.mqo"));
	
	private static final ResourceLocation t_odunit_gc = new ResourceLocation("gvcr2:textures/blocks/tile/odunit_gc.png");
	private static final IModelCustom m_odunit_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/odunit_gc.mqo"));
	
	private static final ResourceLocation t_sandbag_a1_gc = new ResourceLocation("gvcr2:textures/blocks/tile/sandbag_a1_gc.png");
	private static final IModelCustom m_sandbag_a1_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/sandbag_a1_gc.mqo"));
	
	private static final ResourceLocation t_sandbag_a2_gc = new ResourceLocation("gvcr2:textures/blocks/tile/sandbag_a2_gc.png");
	private static final IModelCustom m_sandbag_a2_gc= AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/sandbag_a2_gc.mqo"));
	
	private static final ResourceLocation t_sandbag_b1_gc = new ResourceLocation("gvcr2:textures/blocks/tile/sandbag_b1_gc.png");
	private static final IModelCustom m_sandbag_b1_gc= AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/sandbag_b1_gc.mqo"));
	
	private static final ResourceLocation t_sandbag_b2_gc = new ResourceLocation("gvcr2:textures/blocks/tile/sandbag_b2_gc.png");
	private static final IModelCustom m_sandbag_b2_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/sandbag_b2_gc.mqo"));
	
	private static final ResourceLocation t_t_wall1_gc = new ResourceLocation("gvcr2:textures/blocks/tile/t_wall1_gc.png");
	private static final IModelCustom m_t_wall1_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/t_wall_gc.mqo"));
	
	private static final ResourceLocation t_t_wall2_gc = new ResourceLocation("gvcr2:textures/blocks/tile/t_wall2_gc.png");
	private static final IModelCustom m_t_wall2_gc = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/t_wall_gc.mqo"));
	
	private static final ResourceLocation t_wolcott = new ResourceLocation("gvcr2:textures/blocks/tile/wolcott.png");
	private static final IModelCustom m_wolcott = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/wolcott.mqo"));
	
	private static final ResourceLocation t_fslight = new ResourceLocation("gvcr2:textures/blocks/tile/fslight.png");
	private static final IModelCustom m_fslight = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/fslight.mqo"));
	
	private static final ResourceLocation t_lantern_g = new ResourceLocation("gvcr2:textures/blocks/tile/lantern_g.png");
	private static final IModelCustom m_lantern_g = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/lantern_g.mqo"));
	
	//private static final ResourceLocation t_light_block_g = new ResourceLocation("gvcr2:textures/blocks/tile/light_block_g.png");
	//private static final IModelCustom m_light_block_g = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/light_block_g.mqo"));
	
	private static final ResourceLocation t_wall_light_gg = new ResourceLocation("gvcr2:textures/blocks/tile/wall_light_gg.png");
	private static final ResourceLocation t_wall_light_rg = new ResourceLocation("gvcr2:textures/blocks/tile/wall_light_rg.png");
	private static final ResourceLocation t_wall_light_wg = new ResourceLocation("gvcr2:textures/blocks/tile/wall_light_wg.png");
	private static final IModelCustom m_wall_light_g = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/wall_light_g.mqo"));
	
	private static final ResourceLocation t_rack_g1 = new ResourceLocation("gvcr2:textures/blocks/tile/rack_g1.png");
	private static final IModelCustom m_rack_g1 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/rack_g1.mqo"));
	
	private static final ResourceLocation t_rack_g2 = new ResourceLocation("gvcr2:textures/blocks/tile/rack_g2.png");
	private static final IModelCustom m_rack_g2 = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/rack_g2.mqo"));
	
	
	
	private static final ResourceLocation ammobox1 = new ResourceLocation("gvcr2:textures/blocks/tile/ammobox1.png");
    private static final IModelCustom ammobox1m = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/ammobox1.mqo"));
    private static final ResourceLocation artibox1 = new ResourceLocation("gvcr2:textures/blocks/tile/artibox1.png");
    private static final IModelCustom artibox1m = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/artibox1.mqo"));
    private static final ResourceLocation artibox2 = new ResourceLocation("gvcr2:textures/blocks/tile/artibox2.png");
    private static final IModelCustom artibox2m = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/artibox2.mqo"));
    private static final ResourceLocation artibox3 = new ResourceLocation("gvcr2:textures/blocks/tile/artibox3.png");
    private static final IModelCustom artibox3m = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/artibox3.mqo"));
    private static final ResourceLocation barrel_drum1 = new ResourceLocation("gvcr2:textures/blocks/tile/barrel_drum1.png");
    private static final ResourceLocation barrel_drum2 = new ResourceLocation("gvcr2:textures/blocks/tile/barrel_drum2.png");
    private static final ResourceLocation barrel_drum3 = new ResourceLocation("gvcr2:textures/blocks/tile/barrel_drum3.png");
    private static final IModelCustom barrel_drum = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/barrel_drum.mqo"));
    private static final ResourceLocation Jerrycan1 = new ResourceLocation("gvcr2:textures/blocks/tile/jerrycan1.png");
    private static final IModelCustom Jerrycan1m = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/jerrycan1.mqo"));
    private static final ResourceLocation missile_rack1 = new ResourceLocation("gvcr2:textures/blocks/tile/missile_rack1.png");
    private static final IModelCustom missile_rack1m = AdvancedModelLoader.loadModel(new ResourceLocation("gvcr2:textures/blocks/tile/missile_rack1.mqo"));
	
	
	public TileRenderBlock_GVC_DecoFacingBlock() {
	}

	public void render(TileEntity_GVC_DecoFacingBlock tile, double x, double y, double z, float partialTicks, int destroyStage,
			float alpha) {
		Minecraft minecraft = Minecraft.getMinecraft();

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0F, (float) z + 0.5F);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		GL11.glColor4f(1F, 1F, 1F, 1.0F);
		if (tile.facing == 1) {
			GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		} else if (tile.facing == 2) {
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		} else if (tile.facing == 3) {
			GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
		} else {
			// GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
		}

		if (tile.id == 0) {
			this.bindTexture(t_9mmpack_gc);
			m_9mmpack_gc.renderPart("mat1");
		}
		else if (tile.id == 1) {
			this.bindTexture(t_45pack_gc);
			m_45pack_gc.renderPart("mat1");
		}
		else if (tile.id == 2) {
			this.bindTexture(t_223pack_gc);
			m_223pack_gc.renderPart("mat1");
		}
		else if (tile.id == 3) {
			this.bindTexture(t_308pack_gc);
			m_308pack_gc.renderPart("mat1");
		}
		else if (tile.id == 4) {
			this.bindTexture(t_50bmgpack_gc);
			m_50bmgpack_gc.renderPart("mat1");
		}
		else if (tile.id == 5) {
			this.bindTexture(t_12gpack_gc);
			m_12gpack_gc.renderPart("mat1");
		}
		else if (tile.id == 6) {
			this.bindTexture(t_40mmgr_ammo_gc);
			m_40mmgr_ammo_gc.renderPart("mat1");
		}
		else if (tile.id == 7) {
			this.bindTexture(t_grenade_box_gc);
			m_grenade_box_gc.renderPart("mat1");
		}
		else if (tile.id == 8) {
			this.bindTexture(t_rpg_ammobox1);
			m_rpg_ammobox1.renderPart("mat1");
		}
		else if (tile.id == 9) {
			this.bindTexture(t_rpg_ammobox2);
			m_rpg_ammobox2.renderPart("mat1");
		}
		else if (tile.id == 10) {
			this.bindTexture(t_ammo_mass);
			m_ammo_mass.renderPart("mat1");
		}
		else if (tile.id == 11) {
			this.bindTexture(t_m18_claymore);
			m_m18_claymore.renderPart("mat1");
		}
		else if (tile.id == 12) {
			this.bindTexture(t_m72_box);
			m_m72_box.renderPart("mat1");
		}
		else if (tile.id == 13) {
			this.bindTexture(t_rpg_box);
			m_rpg_box.renderPart("mat1");
		}
		else if (tile.id == 14) {
			this.bindTexture(t_medbag_gc);
			m_medbag_gc.renderPart("mat1");
		}
		else if (tile.id == 15) {
			this.bindTexture(t_laptop);
			m_laptop.renderPart("mat1");
		}
		else if (tile.id == 16) {
			this.bindTexture(t_toughbook);
			m_toughbook.renderPart("mat1");
		}
		else if (tile.id == 17) {
			this.bindTexture(t_monitor1);
			m_monitor1.renderPart("mat1");
		}
		else if (tile.id == 18) {
			this.bindTexture(t_man_target);
			m_man_target.renderPart("mat1");
		}
		else if (tile.id == 19) {
			this.bindTexture(t_old_radio);
			m_old_radio.renderPart("mat1");
		}
		else if (tile.id == 20) {
			this.bindTexture(t_radio_big);
			m_radio_big.renderPart("mat1");
		}
		else if (tile.id == 21) {
			this.bindTexture(t_sincgars);
			m_sincgars.renderPart("mat1");
		}
		else if (tile.id == 22) {
			this.bindTexture(t_burn_barrel);
			m_burn_barrel.renderPart("mat1");
			{
				GL11.glPushMatrix();
				GL11.glTranslatef(0, 0.8F, 0);
				GlStateManager.scale(0.5F, 1F, 0.5F);
				if (tile.getWorld().getWorldTime() %4 == 4) {
					this.bindTexture(box2);
				} else if (tile.getWorld().getWorldTime() %4 == 3) {
					this.bindTexture(box3);
				} else if (tile.getWorld().getWorldTime() %4 == 2) {
					this.bindTexture(box4);
				} else {
					this.bindTexture(box1);
				}
		        
		        box_model.renderPart("mat1");
		        GL11.glPopMatrix();
			}
		}
		else if (tile.id == 23) {
			this.bindTexture(t_at_obstacles);
			m_at_obstaclesc.renderPart("mat1");
		}
		else if (tile.id == 24) {
			this.bindTexture(t_barbed1_gc);
			m_barbed1_gc.renderPart("mat1");
		}
		else if (tile.id == 25) {
			this.bindTexture(t_barbed2_gc);
			m_barbed2_gc.renderPart("mat1");
		}
		else if (tile.id == 26) {
			this.bindTexture(t_fire_exti_gc);
			m_fire_exti_gc.renderPart("mat1");
		}
		else if (tile.id == 27) {
			this.bindTexture(t_mil_cont1_gc);
			m_mil_cont1_gc.renderPart("mat1");
		}
		else if (tile.id == 28) {
			this.bindTexture(t_mil_cont2_gc);
			m_mil_cont2_gc.renderPart("mat1");
		}
		else if (tile.id == 29) {
			this.bindTexture(t_odunit_gc);
			m_odunit_gc.renderPart("mat1");
		}
		else if (tile.id == 30) {
			this.bindTexture(t_sandbag_a1_gc);
			m_sandbag_a1_gc.renderPart("mat1");
		}
		else if (tile.id == 31) {
			this.bindTexture(t_sandbag_a2_gc);
			m_sandbag_a2_gc.renderPart("mat1");
		}
		else if (tile.id == 32) {
			this.bindTexture(t_sandbag_b1_gc);
			m_sandbag_b1_gc.renderPart("mat1");
		}
		else if (tile.id == 33) {
			this.bindTexture(t_sandbag_b2_gc);
			m_sandbag_b2_gc.renderPart("mat1");
		}
		else if (tile.id == 34) {
			this.bindTexture(t_t_wall1_gc);
			m_t_wall1_gc.renderPart("mat1");
		}
		else if (tile.id == 35) {
			this.bindTexture(t_t_wall2_gc);
			m_t_wall2_gc.renderPart("mat1");
		}
		else if (tile.id == 36) {
			this.bindTexture(t_wolcott);
			m_wolcott.renderPart("mat1");
		}
		else if(tile.id == 37) {
        	this.bindTexture(ammobox1);
        	ammobox1m.renderPart("mat1");
        }
        else if(tile.id == 38) {
        	this.bindTexture(artibox1);
        	artibox1m.renderPart("mat1");
        }
        else if(tile.id == 39) {
        	this.bindTexture(artibox2);
        	artibox2m.renderPart("mat1");
        }
        else if(tile.id == 40) {
        	this.bindTexture(artibox3);
        	artibox3m.renderPart("mat1");
        }
        else if(tile.id == 41) {
        	this.bindTexture(barrel_drum1);
        	barrel_drum.renderPart("mat1");
        }
        else if(tile.id == 42) {
        	this.bindTexture(barrel_drum2);
        	barrel_drum.renderPart("mat1");
        }
        else if(tile.id == 43) {
        	this.bindTexture(barrel_drum3);
        	barrel_drum.renderPart("mat1");
        }
        else if(tile.id == 44) {
        	this.bindTexture(Jerrycan1);
        	Jerrycan1m.renderPart("mat1");
        }
        else if(tile.id == 45) {
        	this.bindTexture(missile_rack1);
        	missile_rack1m.renderPart("mat1");
        }
        else if(tile.id == 46) {
        	this.bindTexture(t_fslight);
        	{
        		GL11.glDisable(GL11.GL_LIGHT1);
    			GL11.glDisable(GL11.GL_LIGHTING);
    			m_fslight.renderPart("mat2");
    			GL11.glEnable(GL11.GL_LIGHTING);
    			GL11.glEnable(GL11.GL_LIGHT1);
        	}
        	m_fslight.renderPart("mat1");
        }else if(tile.id == 47) {
        	this.bindTexture(t_lantern_g);
        	{
        		GL11.glDisable(GL11.GL_LIGHT1);
    			GL11.glDisable(GL11.GL_LIGHTING);
    			m_lantern_g.renderPart("mat2");
    			GL11.glEnable(GL11.GL_LIGHTING);
    			GL11.glEnable(GL11.GL_LIGHT1);
        	}
        	m_lantern_g.renderPart("mat1");
        }
        else if(tile.id == 49 || tile.id == 50 || tile.id == 51) {
        	if(tile.id == 49) {
        		this.bindTexture(t_wall_light_gg);
        	}else if(tile.id == 50) {
        		this.bindTexture(t_wall_light_rg);
        	}else {
        		this.bindTexture(t_wall_light_wg);
        	}
        	{
        		GL11.glDisable(GL11.GL_LIGHT1);
    			GL11.glDisable(GL11.GL_LIGHTING);
    			m_wall_light_g.renderPart("mat2");
    			GL11.glEnable(GL11.GL_LIGHTING);
    			GL11.glEnable(GL11.GL_LIGHT1);
        	}
        	m_wall_light_g.renderPart("mat1");
        }
        else if(tile.id == 52) {
        	this.bindTexture(t_rack_g1);
        	m_rack_g1.renderPart("mat1");
        }
        else if(tile.id == 53) {
        	this.bindTexture(t_rack_g2);
        	m_rack_g2.renderPart("mat1");
        }
		
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();

	}



}

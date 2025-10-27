package gvcr2;


import java.io.File;

import gvclib.render.Render_S_Biped;
import gvcr2.block.tile.TileEntityBlockBaseFlag;
import gvcr2.block.tile.TileEntityBlockBossSpawn_Tile;
import gvcr2.block.tile.TileEntityBlockSpawn_Spawner;
import gvcr2.block.tile.TileEntityBlock_GunRack_Deco;
import gvcr2.block.tile.TileEntity_BulletCrafter;
import gvcr2.block.tile.TileEntity_GVC_DecoFacingBlock;
import gvcr2.block.tile.TileEntity_GunCrafter;
import gvcr2.block.tile.TileEntity_GunRack;
import gvcr2.block.tile.TileEntity_Mine;
import gvcr2.block.tile.TileEntity_Supplies;
import gvcr2.block.tile.TileEntity_VehicleCrafter;
import gvcr2.entity.boss.EntityGVCR2_BOSS_AIRBASE;
import gvcr2.entity.boss.EntityGVCR2_BOSS_AIRSHIP;
import gvcr2.entity.boss.EntityGVCR2_BOSS_AV8B;
import gvcr2.entity.boss.EntityGVCR2_BOSS_CHAR2C;
import gvcr2.entity.boss.EntityGVCR2_BOSS_CV;
import gvcr2.entity.boss.EntityGVCR2_BOSS_HAUNEB;
import gvcr2.entity.boss.EntityGVCR2_BOSS_IRVING;
import gvcr2.entity.boss.EntityGVCR2_BOSS_LONGLEG;
import gvcr2.entity.boss.EntityGVCR2_BOSS_MER08;
import gvcr2.entity.boss.EntityGVCR2_BOSS_MER08_B;
import gvcr2.entity.boss.EntityGVCR2_BOSS_MER08_HFB;
import gvcr2.entity.boss.EntityGVCR2_BOSS_MER08_SN;
import gvcr2.entity.boss.EntityGVCR2_BOSS_RATTE;
import gvcr2.entity.boss.EntityGVCR2_BOSS_ST1;
import gvcr2.entity.boss.EntityGVCR2_BOSS_TB3;
import gvcr2.entity.boss.EntityGVCR2_EE_Shark;
import gvcr2.entity.bullet.EntityGVCR2_Bullet_Beam;
import gvcr2.entity.bullet.EntityGVCR2_Bullet_ROG;
import gvcr2.entity.bullet.EntityGVCR2_Request_Smoke;
import gvcr2.entity.bullet.EntityGVCR2_STARS;
import gvcr2.entity.drone.EntityDrone_EOD;
import gvcr2.entity.drone.EntityDrone_MAV;
import gvcr2.entity.drone.EntityDrone_RAWR;
import gvcr2.entity.inv.EntityGVCR2_INV_SCENARIO;
import gvcr2.entity.mob.EntityGVCR2_BOSS_MER03K;
import gvcr2.entity.mob.EntityGVCR2_GE_Jamming;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.mob.EntityGVCR2_GE_SE_ASSAULT;
import gvcr2.entity.mob.EntityGVCR2_GE_SE_CERBERUS;
import gvcr2.entity.mob.EntityGVCR2_GE_SE_HACS;
import gvcr2.entity.mob.EntityGVCR2_GE_SE_KUKRI;
import gvcr2.entity.mob.EntityGVCR2_GE_SV;
import gvcr2.entity.mob.EntityGVCR2_GE_S_MR_CPT;
import gvcr2.entity.mob.EntityGVCR2_GE_U_DRONE;
import gvcr2.entity.mob.EntityGVCR2_UNKS_C_S;
import gvcr2.entity.npc.EntityGVCR2_NPC_ARMSTRADER;
import gvcr2.entity.pmc.EntityGVCR2_PMC_S;
import gvcr2.entity.so.EntityGVCR2_GE_POW;
import gvcr2.entity.so.EntityGVCR2_SO_S;
import gvcr2.entity.so.EntityGVCR2_SO_S_AF_CPT;
import gvcr2.entity.so.EntityGVCR2_SO_S_MR_CPT;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_A10;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_A4;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_A6;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_AC130;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_AN2;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_AV8B;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_C130;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_F117;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_F16;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_F18;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_LI28;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_MIG17;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_SU25;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_SU27;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_YAK23;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_YAK23KAI;
import gvcr2.entity.vehicle.apc.EntityGVCR2_APC_9K35;
import gvcr2.entity.vehicle.apc.EntityGVCR2_APC_BMP3;
import gvcr2.entity.vehicle.apc.EntityGVCR2_APC_BTR60;
import gvcr2.entity.vehicle.apc.EntityGVCR2_APC_LAV25;
import gvcr2.entity.vehicle.apc.EntityGVCR2_APC_M1097;
import gvcr2.entity.vehicle.apc.EntityGVCR2_APC_M1126;
import gvcr2.entity.vehicle.apc.EntityGVCR2_APC_M113;
import gvcr2.entity.vehicle.apc.EntityGVCR2_APC_M270;
import gvcr2.entity.vehicle.car.EntityGVCR2_CAR_BIKE;
import gvcr2.entity.vehicle.car.EntityGVCR2_CAR_BUGGY;
import gvcr2.entity.vehicle.car.EntityGVCR2_CAR_BULLDOZER;
import gvcr2.entity.vehicle.car.EntityGVCR2_CAR_HMMWV;
import gvcr2.entity.vehicle.car.EntityGVCR2_CAR_Technical;
import gvcr2.entity.vehicle.ge.EntityGVCR2_GE_Technical;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_AH1S;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_AH1Z;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_AH6;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_CH47;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_GHELI;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_KA50;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_KA60;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_MI24D;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_R22;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_UH1;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_UH1Y;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_UH60;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_Z10;
import gvcr2.entity.vehicle.robo.EntityGVCR2_SP_REX;
import gvcr2.entity.vehicle.robo.EntityGVCR2_SP_ST1;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_AA_20mmAA;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_AA_Mk15;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_AA_VADS;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_AA_Zu23;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_CANNON_AK130;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_CANNON_Flak18;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_CANNON_Mk45;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_CANNON_Pak40;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_CANNON_TOW2;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_MG_DP28;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_MG_M2;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_MG_M60;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_MG_PKM;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_MORTAR_FH18;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_MORTAR_M224;
import gvcr2.entity.vehicle.ship.EntityGVCR2_SHIP_AIRSHIP;
import gvcr2.entity.vehicle.ship.EntityGVCR2_SHIP_CRUISER;
import gvcr2.entity.vehicle.ship.EntityGVCR2_SHIP_HAMINA;
import gvcr2.entity.vehicle.ship.EntityGVCR2_SHIP_PR1204;
import gvcr2.entity.vehicle.ship.EntityGVCR2_SHIP_RCB;
import gvcr2.entity.vehicle.ship.EntityGVCR2_SHIP_RHIB;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_2K22;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_FV101;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_KV2;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_M1;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_M1A2;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_M41;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_M41DK1;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_M551;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_M60A1;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_PT76;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_RATTE;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T34;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T55;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T72;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T90;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_ZSU_23_4;
import gvcr2.render.boss.RenderGVCR2_BOSS_AIRBASE;
import gvcr2.render.boss.RenderGVCR2_BOSS_AIRSHIP;
import gvcr2.render.boss.RenderGVCR2_BOSS_AV8B;
import gvcr2.render.boss.RenderGVCR2_BOSS_CHAR2C;
import gvcr2.render.boss.RenderGVCR2_BOSS_CV;
import gvcr2.render.boss.RenderGVCR2_BOSS_HAUNEB;
import gvcr2.render.boss.RenderGVCR2_BOSS_IRVING;
import gvcr2.render.boss.RenderGVCR2_BOSS_LONGLEG;
import gvcr2.render.boss.RenderGVCR2_BOSS_MER08;
import gvcr2.render.boss.RenderGVCR2_BOSS_MER08_B;
import gvcr2.render.boss.RenderGVCR2_BOSS_MER08_HFB;
import gvcr2.render.boss.RenderGVCR2_BOSS_MER08_SN;
import gvcr2.render.boss.RenderGVCR2_BOSS_RATTE;
import gvcr2.render.boss.RenderGVCR2_BOSS_ST1;
import gvcr2.render.boss.RenderGVCR2_BOSS_TB3;
import gvcr2.render.boss.RenderGVCR2_EE_Shark;
import gvcr2.render.bullet.RenderGVCR2_Bullet_Beam;
import gvcr2.render.bullet.RenderGVCR2_Bullet_ROG;
import gvcr2.render.bullet.RenderGVCR2_Request_Smoke;
import gvcr2.render.bullet.RenderGVCR2_STARS;
import gvcr2.render.drone.RenderGVCR2_Drone_EOD;
import gvcr2.render.drone.RenderGVCR2_Drone_MAV;
import gvcr2.render.drone.RenderGVCR2_Drone_RAWR;
import gvcr2.render.inv.RenderGVCR2_INV_SCENARIO;
import gvcr2.render.mob.RenderGVCR2_BOSS_MER03K;
import gvcr2.render.mob.RenderGVCR2_GE_SE_CERBERUS;
import gvcr2.render.mob.RenderGVCR2_GE_SE_HACS;
import gvcr2.render.mob.RenderGVCR2_GE_SE_KUKRI;
import gvcr2.render.mob.RenderGVCR2_GE_U_DRONE;
import gvcr2.render.mob.Render_GE_Jamming;
import gvcr2.render.mob.Render_GE_S;
import gvcr2.render.mob.Render_GE_S_MR_CPT;
import gvcr2.render.npc.RenderGVCR2_NPC_ARMSTRADER;
import gvcr2.render.npc.Render_SO_S;
import gvcr2.render.tile.TileRenderBlockBaseFlag;
import gvcr2.render.tile.TileRenderBlockBossSpawn_Tile;
import gvcr2.render.tile.TileRenderBlockSpawn_Spawner;
import gvcr2.render.tile.TileRenderBlock_GVC_DecoFacingBlock;
import gvcr2.render.tile.TileRenderBlock_GunRack;
import gvcr2.render.tile.TileRenderBlock_GunRack_Deco;
import gvcr2.render.tile.TileRender_BulletCrafter;
import gvcr2.render.tile.TileRender_GunCrafter;
import gvcr2.render.tile.TileRender_Mine;
import gvcr2.render.tile.TileRender_Supplies;
import gvcr2.render.tile.TileRender_VehicleCrafter;
import gvcr2.render.vehicle.air.RenderGVCR2_AIR_A10;
import gvcr2.render.vehicle.air.RenderGVCR2_AIR_A4;
import gvcr2.render.vehicle.air.RenderGVCR2_AIR_A6;
import gvcr2.render.vehicle.air.RenderGVCR2_AIR_AC130;
import gvcr2.render.vehicle.air.RenderGVCR2_AIR_AN2;
import gvcr2.render.vehicle.air.RenderGVCR2_AIR_AV8B;
import gvcr2.render.vehicle.air.RenderGVCR2_AIR_C130;
import gvcr2.render.vehicle.air.RenderGVCR2_AIR_F117;
import gvcr2.render.vehicle.air.RenderGVCR2_AIR_F16;
import gvcr2.render.vehicle.air.RenderGVCR2_AIR_F18;
import gvcr2.render.vehicle.air.RenderGVCR2_AIR_LI28;
import gvcr2.render.vehicle.air.RenderGVCR2_AIR_MIG17;
import gvcr2.render.vehicle.air.RenderGVCR2_AIR_SU25;
import gvcr2.render.vehicle.air.RenderGVCR2_AIR_SU27;
import gvcr2.render.vehicle.air.RenderGVCR2_AIR_YAK23;
import gvcr2.render.vehicle.air.RenderGVCR2_AIR_YAK23KAI;
import gvcr2.render.vehicle.apc.RenderGVCR2_APC_9K35;
import gvcr2.render.vehicle.apc.RenderGVCR2_APC_BMP3;
import gvcr2.render.vehicle.apc.RenderGVCR2_APC_BTR60;
import gvcr2.render.vehicle.apc.RenderGVCR2_APC_LAV25;
import gvcr2.render.vehicle.apc.RenderGVCR2_APC_M1097;
import gvcr2.render.vehicle.apc.RenderGVCR2_APC_M1126;
import gvcr2.render.vehicle.apc.RenderGVCR2_APC_M113;
import gvcr2.render.vehicle.apc.RenderGVCR2_APC_M270;
import gvcr2.render.vehicle.car.RenderGVCR2_CAR_BIKE;
import gvcr2.render.vehicle.car.RenderGVCR2_CAR_BUGGY;
import gvcr2.render.vehicle.car.RenderGVCR2_CAR_BULLDOZER;
import gvcr2.render.vehicle.car.RenderGVCR2_CAR_HMMWV;
import gvcr2.render.vehicle.car.RenderGVCR2_CAR_Technical;
import gvcr2.render.vehicle.ge.RenderGVCR2_GE_Technical;
import gvcr2.render.vehicle.heli.RenderGVCR2_HELI_AH1S;
import gvcr2.render.vehicle.heli.RenderGVCR2_HELI_AH1Z;
import gvcr2.render.vehicle.heli.RenderGVCR2_HELI_AH6;
import gvcr2.render.vehicle.heli.RenderGVCR2_HELI_CH47;
import gvcr2.render.vehicle.heli.RenderGVCR2_HELI_GHELI;
import gvcr2.render.vehicle.heli.RenderGVCR2_HELI_KA50;
import gvcr2.render.vehicle.heli.RenderGVCR2_HELI_KA60;
import gvcr2.render.vehicle.heli.RenderGVCR2_HELI_MI24D;
import gvcr2.render.vehicle.heli.RenderGVCR2_HELI_R22;
import gvcr2.render.vehicle.heli.RenderGVCR2_HELI_UH1;
import gvcr2.render.vehicle.heli.RenderGVCR2_HELI_UH1Y;
import gvcr2.render.vehicle.heli.RenderGVCR2_HELI_UH60;
import gvcr2.render.vehicle.heli.RenderGVCR2_HELI_Z10;
import gvcr2.render.vehicle.robo.RenderGVCR2_SP_REX;
import gvcr2.render.vehicle.robo.RenderGVCR2_SP_ST1;
import gvcr2.render.vehicle.set.RenderGVCR2_SET_AA_20mmAA;
import gvcr2.render.vehicle.set.RenderGVCR2_SET_AA_Mk15;
import gvcr2.render.vehicle.set.RenderGVCR2_SET_AA_VADS;
import gvcr2.render.vehicle.set.RenderGVCR2_SET_AA_Zu23;
import gvcr2.render.vehicle.set.RenderGVCR2_SET_CANNON_AK130;
import gvcr2.render.vehicle.set.RenderGVCR2_SET_CANNON_Flak18;
import gvcr2.render.vehicle.set.RenderGVCR2_SET_CANNON_Mk45;
import gvcr2.render.vehicle.set.RenderGVCR2_SET_CANNON_Pak40;
import gvcr2.render.vehicle.set.RenderGVCR2_SET_CANNON_TOW2;
import gvcr2.render.vehicle.set.RenderGVCR2_SET_MG_DP28;
import gvcr2.render.vehicle.set.RenderGVCR2_SET_MG_M2;
import gvcr2.render.vehicle.set.RenderGVCR2_SET_MG_M60;
import gvcr2.render.vehicle.set.RenderGVCR2_SET_MG_PKM;
import gvcr2.render.vehicle.set.RenderGVCR2_SET_MORTAR_FH18;
import gvcr2.render.vehicle.set.RenderGVCR2_SET_MORTAR_M224;
import gvcr2.render.vehicle.ship.RenderGVCR2_SHIP_AIRSHIP;
import gvcr2.render.vehicle.ship.RenderGVCR2_SHIP_CRUISER;
import gvcr2.render.vehicle.ship.RenderGVCR2_SHIP_HAMINA;
import gvcr2.render.vehicle.ship.RenderGVCR2_SHIP_PR1204;
import gvcr2.render.vehicle.ship.RenderGVCR2_SHIP_RCB;
import gvcr2.render.vehicle.ship.RenderGVCR2_SHIP_RHIB;
import gvcr2.render.vehicle.tank.RenderGVCR2_SET_TANK_2K22;
import gvcr2.render.vehicle.tank.RenderGVCR2_SET_TANK_FV101;
import gvcr2.render.vehicle.tank.RenderGVCR2_SET_TANK_KV2;
import gvcr2.render.vehicle.tank.RenderGVCR2_SET_TANK_M1;
import gvcr2.render.vehicle.tank.RenderGVCR2_SET_TANK_M1A2;
import gvcr2.render.vehicle.tank.RenderGVCR2_SET_TANK_M41;
import gvcr2.render.vehicle.tank.RenderGVCR2_SET_TANK_M41DK1;
import gvcr2.render.vehicle.tank.RenderGVCR2_SET_TANK_M551;
import gvcr2.render.vehicle.tank.RenderGVCR2_SET_TANK_M60A1;
import gvcr2.render.vehicle.tank.RenderGVCR2_SET_TANK_PT76;
import gvcr2.render.vehicle.tank.RenderGVCR2_SET_TANK_RATTE;
import gvcr2.render.vehicle.tank.RenderGVCR2_SET_TANK_SU_23_4;
import gvcr2.render.vehicle.tank.RenderGVCR2_SET_TANK_T34;
import gvcr2.render.vehicle.tank.RenderGVCR2_SET_TANK_T55;
import gvcr2.render.vehicle.tank.RenderGVCR2_SET_TANK_T72;
import gvcr2.render.vehicle.tank.RenderGVCR2_SET_TANK_T90;
import hmggirlfront.block.tile.TileEntity_Base_Materials;
import hmggirlfront.render.tile.TileRender_Base_Base;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
public class ClientProxyGVCR2 extends CommonSideProxyGVCR2 {
    
	@Override
    public boolean getClient() {
        return true;
    }
	
    @Override
	public World getCilentWorld(){
		return FMLClientHandler.instance().getClient().world;
		}
    
    @Override
    public EntityPlayer getEntityPlayerInstance() {
        return Minecraft.getMinecraft().player;
    }
    
    @Override
    public void registerClientInfo() {
        //ClientRegistry.registerKeyBinding(Speedreload);
    }
    @Override
	public File ProxyFile(){
		return Minecraft.getMinecraft().mcDataDir;
	}
    @Override
	public void reisterRenderers(){
    	Minecraft mc = FMLClientHandler.instance().getClient();
    	//RenderManager rendermanager = new RenderManager(mc.renderEngine, mc.getRenderItem());
    	RenderManager rendermanager = mc.getRenderManager();
    	RenderItem renderitem = mc.getRenderItem();
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_Bullet_Beam.class, new RenderGVCR2_Bullet_Beam(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_Request_Smoke.class, new RenderGVCR2_Request_Smoke(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_Bullet_ROG.class, new RenderGVCR2_Bullet_ROG(rendermanager));
    	
    	
    	
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_GE_S.class, new Render_GE_S(rendermanager, 1.0F));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_GE_SV.class, new Render_S_Biped(rendermanager, "gvcr2:textures/mob/guerrilla_v.png", 1.0F));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_GE_SE_ASSAULT.class, new Render_S_Biped(rendermanager, "gvcr2:textures/mob/elite.png", 1.0F));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_GE_SE_CERBERUS.class, new RenderGVCR2_GE_SE_CERBERUS(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_GE_SE_HACS.class, new RenderGVCR2_GE_SE_HACS(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_GE_SE_KUKRI.class, new RenderGVCR2_GE_SE_KUKRI(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_GE_S_MR_CPT.class, new Render_GE_S_MR_CPT(rendermanager));
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_GE_U_DRONE.class, new RenderGVCR2_GE_U_DRONE(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_GE_POW.class, new Render_S_Biped(rendermanager, "gvcr2:textures/mob/guerrilla_pow.png", 1.0F));
    	
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_PMC_S.class, new Render_S_Biped(rendermanager, "gvcr2:textures/mob/pmc.png", 1.0F));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SO_S.class, new Render_SO_S(rendermanager, 1.0F));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SO_S_MR_CPT.class, new Render_S_Biped(rendermanager, "gvcr2:textures/mob/soldier_mr_cpt.png", 1.0F));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SO_S_AF_CPT.class, new Render_S_Biped(rendermanager, "gvcr2:textures/mob/soldier_af_cpt.png", 1.0F));
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SP_REX.class, new RenderGVCR2_SP_REX(rendermanager));
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_NPC_ARMSTRADER.class, new RenderGVCR2_NPC_ARMSTRADER(rendermanager));
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SP_ST1.class, new RenderGVCR2_SP_ST1(rendermanager));
    	
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_BOSS_LONGLEG.class, new RenderGVCR2_BOSS_LONGLEG(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_BOSS_ST1.class, new RenderGVCR2_BOSS_ST1(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_BOSS_MER08.class, new RenderGVCR2_BOSS_MER08(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_BOSS_MER08_SN.class, new RenderGVCR2_BOSS_MER08_SN(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_BOSS_MER08_B.class, new RenderGVCR2_BOSS_MER08_B(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_BOSS_MER08_HFB.class, new RenderGVCR2_BOSS_MER08_HFB(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_BOSS_MER03K.class, new RenderGVCR2_BOSS_MER03K(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_BOSS_HAUNEB.class, new RenderGVCR2_BOSS_HAUNEB(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_BOSS_IRVING.class, new RenderGVCR2_BOSS_IRVING(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_BOSS_CV.class, new RenderGVCR2_BOSS_CV(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_GE_Jamming.class, new Render_GE_Jamming(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_BOSS_CHAR2C.class, new RenderGVCR2_BOSS_CHAR2C(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_BOSS_AIRBASE.class, new RenderGVCR2_BOSS_AIRBASE(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_BOSS_AV8B.class, new RenderGVCR2_BOSS_AV8B(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_BOSS_RATTE.class, new RenderGVCR2_BOSS_RATTE(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_BOSS_TB3.class, new RenderGVCR2_BOSS_TB3(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_BOSS_AIRSHIP.class, new RenderGVCR2_BOSS_AIRSHIP(rendermanager));
    	
    	
    	
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_UNKS_C_S.class, new Render_S_Biped(rendermanager, "gvcr2:textures/mob/unks_c.png", 1.0F));
    	
    	
    	
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_CAR_Technical.class, 
    			new RenderGVCR2_CAR_Technical(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_CAR_BIKE.class, 
    			new RenderGVCR2_CAR_BIKE(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_CAR_BUGGY.class, 
    			new RenderGVCR2_CAR_BUGGY(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_CAR_HMMWV.class, 
    			new RenderGVCR2_CAR_HMMWV(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_CAR_BULLDOZER.class, 
    			new RenderGVCR2_CAR_BULLDOZER(rendermanager));
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_APC_M113.class, 
    			new RenderGVCR2_APC_M113(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_APC_M1126.class, 
    			new RenderGVCR2_APC_M1126(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_APC_LAV25.class, 
    			new RenderGVCR2_APC_LAV25(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_APC_BTR60.class, 
    			new RenderGVCR2_APC_BTR60(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_APC_M1097.class, 
    			new RenderGVCR2_APC_M1097(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_APC_9K35.class, 
    			new RenderGVCR2_APC_9K35(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_APC_M270.class, 
    			new RenderGVCR2_APC_M270(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_APC_BMP3.class, 
    			new RenderGVCR2_APC_BMP3(rendermanager));
    	
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_HELI_AH1S.class, 
    			new RenderGVCR2_HELI_AH1S(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_HELI_AH6.class, 
    			new RenderGVCR2_HELI_AH6(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_HELI_UH1.class, 
    			new RenderGVCR2_HELI_UH1(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_HELI_GHELI.class, 
    			new RenderGVCR2_HELI_GHELI(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_HELI_MI24D.class, 
    			new RenderGVCR2_HELI_MI24D(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_HELI_CH47.class, 
    			new RenderGVCR2_HELI_CH47(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_HELI_UH1Y.class, 
    			new RenderGVCR2_HELI_UH1Y(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_HELI_UH60.class, 
    			new RenderGVCR2_HELI_UH60(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_HELI_AH1Z.class, 
    			new RenderGVCR2_HELI_AH1Z(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_HELI_KA50.class, 
    			new RenderGVCR2_HELI_KA50(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_HELI_Z10.class, 
    			new RenderGVCR2_HELI_Z10(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_HELI_KA60.class, 
    			new RenderGVCR2_HELI_KA60(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_HELI_R22.class, 
    			new RenderGVCR2_HELI_R22(rendermanager));
    	
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_TANK_M60A1.class, 
    			new RenderGVCR2_SET_TANK_M60A1(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_TANK_M1.class, 
    			new RenderGVCR2_SET_TANK_M1(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_TANK_M41.class, 
    			new RenderGVCR2_SET_TANK_M41(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_TANK_M551.class, 
    			new RenderGVCR2_SET_TANK_M551(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_TANK_T34.class, 
    			new RenderGVCR2_SET_TANK_T34(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_TANK_T55.class, 
    			new RenderGVCR2_SET_TANK_T55(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_TANK_T72.class, 
    			new RenderGVCR2_SET_TANK_T72(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_TANK_T90.class, 
    			new RenderGVCR2_SET_TANK_T90(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_TANK_PT76.class, 
    			new RenderGVCR2_SET_TANK_PT76(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_TANK_KV2.class, 
    			new RenderGVCR2_SET_TANK_KV2(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_TANK_FV101.class, 
    			new RenderGVCR2_SET_TANK_FV101(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_TANK_ZSU_23_4.class, 
    			new RenderGVCR2_SET_TANK_SU_23_4(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_TANK_2K22.class, 
    			new RenderGVCR2_SET_TANK_2K22(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_TANK_M1A2.class, 
    			new RenderGVCR2_SET_TANK_M1A2(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_TANK_M41DK1.class, 
    			new RenderGVCR2_SET_TANK_M41DK1(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_TANK_RATTE.class, 
    			new RenderGVCR2_SET_TANK_RATTE(rendermanager));
    	
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_AIR_C130.class, 
    			new RenderGVCR2_AIR_C130(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_AIR_F16.class, 
    			new RenderGVCR2_AIR_F16(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_AIR_F18.class, 
    			new RenderGVCR2_AIR_F18(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_AIR_A10.class, 
    			new RenderGVCR2_AIR_A10(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_AIR_MIG17.class, 
    			new RenderGVCR2_AIR_MIG17(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_AIR_LI28.class, 
    			new RenderGVCR2_AIR_LI28(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_AIR_F117.class, 
    			new RenderGVCR2_AIR_F117(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_AIR_AC130.class, 
    			new RenderGVCR2_AIR_AC130(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_AIR_A6.class, 
    			new RenderGVCR2_AIR_A6(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_AIR_YAK23.class, 
    			new RenderGVCR2_AIR_YAK23(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_AIR_A4.class, 
    			new RenderGVCR2_AIR_A4(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_AIR_YAK23KAI.class, new RenderGVCR2_AIR_YAK23KAI(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_AIR_AN2.class, new RenderGVCR2_AIR_AN2(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_AIR_SU27.class, new RenderGVCR2_AIR_SU27(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_AIR_SU25.class, new RenderGVCR2_AIR_SU25(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_AIR_AV8B.class, new RenderGVCR2_AIR_AV8B(rendermanager));
    	
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SHIP_RHIB.class, 
    			new RenderGVCR2_SHIP_RHIB(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SHIP_RCB.class, 
    			new RenderGVCR2_SHIP_RCB(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SHIP_CRUISER.class, 
    			new RenderGVCR2_SHIP_CRUISER(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SHIP_PR1204.class, 
    			new RenderGVCR2_SHIP_PR1204(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SHIP_HAMINA.class, 
    			new RenderGVCR2_SHIP_HAMINA(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SHIP_AIRSHIP.class, 
    			new RenderGVCR2_SHIP_AIRSHIP(rendermanager));
    	
    	
    	
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SET_MG_M60.class, 
    			new RenderGVCR2_SET_MG_M60(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SET_MG_M2.class, 
    			new RenderGVCR2_SET_MG_M2(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SET_MG_PKM.class, 
    			new RenderGVCR2_SET_MG_PKM(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SET_MG_DP28.class, 
    			new RenderGVCR2_SET_MG_DP28(rendermanager));
    	
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SET_AA_20mmAA.class, 
    			new RenderGVCR2_SET_AA_20mmAA(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SET_AA_Zu23.class, 
    			new RenderGVCR2_SET_AA_Zu23(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SET_AA_VADS.class, 
    			new RenderGVCR2_SET_AA_VADS(rendermanager));
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SET_CANNON_Pak40.class, 
    			new RenderGVCR2_SET_CANNON_Pak40(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SET_CANNON_Flak18.class, 
    			new RenderGVCR2_SET_CANNON_Flak18(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SET_CANNON_TOW2.class, 
    			new RenderGVCR2_SET_CANNON_TOW2(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SET_MORTAR_M224.class, 
    			new RenderGVCR2_SET_MORTAR_M224(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SET_MORTAR_FH18.class, 
    			new RenderGVCR2_SET_MORTAR_FH18(rendermanager));
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SET_AA_Mk15.class, 
    			new RenderGVCR2_SET_AA_Mk15(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SET_CANNON_AK130.class, 
    			new RenderGVCR2_SET_CANNON_AK130(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_SET_CANNON_Mk45.class, 
    			new RenderGVCR2_SET_CANNON_Mk45(rendermanager));
    	
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityDrone_MAV.class, 
    			new RenderGVCR2_Drone_MAV(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityDrone_EOD.class, 
    			new RenderGVCR2_Drone_EOD(rendermanager));
    	RenderingRegistry.registerEntityRenderingHandler(EntityDrone_RAWR.class, 
    			new RenderGVCR2_Drone_RAWR(rendermanager));
    	
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_INV_SCENARIO.class, new RenderGVCR2_INV_SCENARIO(rendermanager));
    	
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_EE_Shark.class, new RenderGVCR2_EE_Shark(rendermanager));
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGVCR2_STARS.class, new RenderGVCR2_STARS(rendermanager));
    }
    
    @Override
    public void registerTileEntity() {
    	//ClientRegistry.registerTileEntity(TileEntityGoods.class, "b_goods", new TileRenderGoods());
    	ClientRegistry.registerTileEntity(TileEntity_Mine.class, "TileEntity_Mine", new TileRender_Mine());
    	ClientRegistry.registerTileEntity(TileEntity_Supplies.class, "TileEntity_Supplies", new TileRender_Supplies());
    	
    	ClientRegistry.registerTileEntity(TileEntity_BulletCrafter.class, "TileEntity_BulletCrafter", new TileRender_BulletCrafter());
    	ClientRegistry.registerTileEntity(TileEntity_GunCrafter.class, "TileEntity_GunCrafter", new TileRender_GunCrafter());
    	ClientRegistry.registerTileEntity(TileEntity_VehicleCrafter.class, "TileEntity_VehicleCrafter", new TileRender_VehicleCrafter());
    	
    	ClientRegistry.registerTileEntity(TileEntityBlockSpawn_Spawner.class, "TileEntityBlockSpawn_Spawner", new TileRenderBlockSpawn_Spawner());
    	ClientRegistry.registerTileEntity(TileEntityBlockBossSpawn_Tile.class, "TileEntityBlockBossSpawn_Tile", new TileRenderBlockBossSpawn_Tile());
    	
    	ClientRegistry.registerTileEntity(TileEntityBlockBaseFlag.class, "TileEntityBlockBaseFlag", new TileRenderBlockBaseFlag());
    	
    	ClientRegistry.registerTileEntity(TileEntity_GunRack.class, "TileEntity_GunRack", new TileRenderBlock_GunRack());
    	ClientRegistry.registerTileEntity(TileEntityBlock_GunRack_Deco.class, "TileEntityBlock_GunRack_Deco", new TileRenderBlock_GunRack_Deco());
    	
    	ClientRegistry.registerTileEntity(TileEntity_GVC_DecoFacingBlock.class, "TileEntity_GVC_DecoFacingBlock", new TileRenderBlock_GVC_DecoFacingBlock());
    }
    
    @Override
    public void InitRendering()
    {
    	//ClientRegistry.bindTileEntitySpecialRenderer(GVCTileEntityItemG36.class, new GVCRenderItemG36());
    }
    
}
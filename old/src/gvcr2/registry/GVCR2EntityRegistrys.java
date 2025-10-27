package gvcr2.registry;

import gvcr2.mod_GVCR2;
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
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class GVCR2EntityRegistrys {
	public static void registrys() {
		mod_GVCR2 mod = mod_GVCR2.INSTANCE;
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_GE_S"), 
				EntityGVCR2_GE_S.class, "EntityGVCR2_GE_S", 0, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_GE_SV"), 
				EntityGVCR2_GE_SV.class, "EntityGVCR2_GE_SV", 1, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_GE_SE_ASSAULT"), 
				EntityGVCR2_GE_SE_ASSAULT.class, "EntityGVCR2_GE_SE_ASSAULT", 2, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_GE_SE_CERBERUS"), 
				EntityGVCR2_GE_SE_CERBERUS.class, "EntityGVCR2_GE_SE_CERBERUS", 3, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_GE_SE_HACS"), 
				EntityGVCR2_GE_SE_HACS.class, "EntityGVCR2_GE_SE_HACS", 4, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_GE_SE_KUKRI"), 
				EntityGVCR2_GE_SE_KUKRI.class, "EntityGVCR2_GE_SE_KUKRI", 5, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_GE_S_MR_CPT"), 
				EntityGVCR2_GE_S_MR_CPT.class, "EntityGVCR2_GE_S_MR_CPT", 6, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_GE_U_DRONE"), 
				EntityGVCR2_GE_U_DRONE.class, "EntityGVCR2_GE_U_DRONE", 10, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_GE_POW"), 
				EntityGVCR2_GE_POW.class, "EntityGVCR2_GE_POW", 115, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SO_S_MR_CPT"), 
				EntityGVCR2_SO_S_MR_CPT.class, "EntityGVCR2_SO_S_MR_CPT", 14, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SO_S_AF_CPT"), 
				EntityGVCR2_SO_S_AF_CPT.class, "EntityGVCR2_SO_S_AF_CPT", 1401, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_PMC_S"), 
				EntityGVCR2_PMC_S.class, "EntityGVCR2_PMC_S", 15, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SO_S"), 
				EntityGVCR2_SO_S.class, "EntityGVCR2_SO_S", 16, mod, 128, 5, true);
		
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SP_REX"), 
				EntityGVCR2_SP_REX.class, "EntityGVCR2_SP_REX", 17, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_NPC_ARMSTRADER"), 
				EntityGVCR2_NPC_ARMSTRADER.class, "EntityGVCR2_NPC_ARMSTRADER", 18, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SP_ST1"), 
				EntityGVCR2_SP_ST1.class, "EntityGVCR2_SP_ST1", 19, mod, 128, 5, true);
		
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_BOSS_LONGLEG"), 
				EntityGVCR2_BOSS_LONGLEG.class, "EntityGVCR2_BOSS_LONGLEG", 160, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_BOSS_ST1"), 
				EntityGVCR2_BOSS_ST1.class, "EntityGVCR2_BOSS_ST1", 161, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_BOSS_MER08"), 
				EntityGVCR2_BOSS_MER08.class, "EntityGVCR2_BOSS_MER08", 162, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_BOSS_MER08_SN"), 
				EntityGVCR2_BOSS_MER08_SN.class, "EntityGVCR2_BOSS_MER08_SN", 163, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_BOSS_HAUNEB"), 
				EntityGVCR2_BOSS_HAUNEB.class, "EntityGVCR2_BOSS_HAUNEB", 164, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_BOSS_IRVING"), 
				EntityGVCR2_BOSS_IRVING.class, "EntityGVCR2_BOSS_IRVING", 165, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_BOSS_CV"), 
				EntityGVCR2_BOSS_CV.class, "EntityGVCR2_BOSS_CV", 166, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_GE_Jamming"), 
				EntityGVCR2_GE_Jamming.class, "EntityGVCR2_GE_Jamming", 167, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_BOSS_CHAR2C"), 
				EntityGVCR2_BOSS_CHAR2C.class, "EntityGVCR2_BOSS_CHAR2C", 168, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_BOSS_MER08_B"), 
				EntityGVCR2_BOSS_MER08_B.class, "EntityGVCR2_BOSS_MER08_B", 169, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_BOSS_MER08_HFB"), 
				EntityGVCR2_BOSS_MER08_HFB.class, "EntityGVCR2_BOSS_MER08_HFB", 170, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_BOSS_MER03K"), 
				EntityGVCR2_BOSS_MER03K.class, "EntityGVCR2_BOSS_MER03K", 225, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_BOSS_AIRBASE"), 
				EntityGVCR2_BOSS_AIRBASE.class, "EntityGVCR2_BOSS_AIRBASE", 171, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_BOSS_AV8B"), 
				EntityGVCR2_BOSS_AV8B.class, "EntityGVCR2_BOSS_AV8B", 172, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_BOSS_RATTE"), 
				EntityGVCR2_BOSS_RATTE.class, "EntityGVCR2_BOSS_RATTE", 173, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_BOSS_TB3"), 
				EntityGVCR2_BOSS_TB3.class, "EntityGVCR2_BOSS_TB3", 174, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_BOSS_AIRSHIP"), 
				EntityGVCR2_BOSS_AIRSHIP.class, "EntityGVCR2_BOSS_AIRSHIP", 175, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_UNKS_C_S"), 
				EntityGVCR2_UNKS_C_S.class, "EntityGVCR2_UNKS_C_S", 220, mod, 128, 5, true);
		
		
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_CAR_Technical"), 
				EntityGVCR2_CAR_Technical.class, "EntityGVCR2_CAR_Technical", 20, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_CAR_BIKE"), 
				EntityGVCR2_CAR_BIKE.class, "EntityGVCR2_CAR_BIKE", 21, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_CAR_BUGGY"), 
				EntityGVCR2_CAR_BUGGY.class, "EntityGVCR2_CAR_BUGGY", 22, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_CAR_HMMWV"), 
				EntityGVCR2_CAR_HMMWV.class, "EntityGVCR2_CAR_HMMWV", 23, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_CAR_BULLDOZER"), 
				EntityGVCR2_CAR_BULLDOZER.class, "EntityGVCR2_CAR_BULLDOZER", 24, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_APC_M113"), 
				EntityGVCR2_APC_M113.class, "EntityGVCR2_APC_M113", 30, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_APC_M1126"), 
				EntityGVCR2_APC_M1126.class, "EntityGVCR2_APC_M1126", 34, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_APC_LAV25"), 
				EntityGVCR2_APC_LAV25.class, "EntityGVCR2_APC_LAV25", 37, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_APC_BTR60"), 
				EntityGVCR2_APC_BTR60.class, "EntityGVCR2_APC_BTR60", 39, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_APC_M1097"), 
				EntityGVCR2_APC_M1097.class, "EntityGVCR2_APC_M1097", 391, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_APC_9K35"), 
				EntityGVCR2_APC_9K35.class, "EntityGVCR2_APC_9K35", 392, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_APC_M270"), 
				EntityGVCR2_APC_M270.class, "EntityGVCR2_APC_M270", 393, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_APC_BMP3"), 
				EntityGVCR2_APC_BMP3.class, "EntityGVCR2_APC_BMP3", 394, mod, 128, 5, true);
		
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_HELI_AH1S"), 
				EntityGVCR2_HELI_AH1S.class, "EntityGVCR2_HELI_AH1S", 40, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_HELI_AH6"), 
				EntityGVCR2_HELI_AH6.class, "EntityGVCR2_HELI_AH6", 41, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_HELI_UH1"), 
				EntityGVCR2_HELI_UH1.class, "EntityGVCR2_HELI_UH1", 42, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_HELI_GHELI"), 
				EntityGVCR2_HELI_GHELI.class, "EntityGVCR2_HELI_GHELI", 43, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_HELI_MI24D"), 
				EntityGVCR2_HELI_MI24D.class, "EntityGVCR2_HELI_MI24D", 44, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_HELI_CH47"), 
				EntityGVCR2_HELI_CH47.class, "EntityGVCR2_HELI_CH47", 45, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_HELI_UH1Y"), 
				EntityGVCR2_HELI_UH1Y.class, "EntityGVCR2_HELI_UH1Y", 46, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_HELI_UH60"), 
				EntityGVCR2_HELI_UH60.class, "EntityGVCR2_HELI_UH60", 47, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_HELI_AH1Z"), 
				EntityGVCR2_HELI_AH1Z.class, "EntityGVCR2_HELI_AH1Z", 48, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_HELI_KA50"), 
				EntityGVCR2_HELI_KA50.class, "EntityGVCR2_HELI_KA50", 49, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_HELI_Z10"), 
				EntityGVCR2_HELI_Z10.class, "EntityGVCR2_HELI_Z10", 140, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_HELI_KA60"), 
				EntityGVCR2_HELI_KA60.class, "EntityGVCR2_HELI_KA60", 141, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_HELI_R22"), 
				EntityGVCR2_HELI_R22.class, "EntityGVCR2_HELI_R22", 142, mod, 128, 5, true);
		
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_TANK_M60A1"), 
				EntityGVCR2_TANK_M60A1.class, "EntityGVCR2_TANK_M60A1", 50, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_TANK_M1"), 
				EntityGVCR2_TANK_M1.class, "EntityGVCR2_TANK_M1", 51, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_TANK_M41"), 
				EntityGVCR2_TANK_M41.class, "EntityGVCR2_TANK_M41", 52, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_TANK_M551"), 
				EntityGVCR2_TANK_M551.class, "EntityGVCR2_TANK_M551", 53, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_TANK_T34"), 
				EntityGVCR2_TANK_T34.class, "EntityGVCR2_TANK_T34", 54, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_TANK_T55"), 
				EntityGVCR2_TANK_T55.class, "EntityGVCR2_TANK_T55", 55, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_TANK_T72"), 
				EntityGVCR2_TANK_T72.class, "EntityGVCR2_TANK_T72", 56, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_TANK_PT76"), 
				EntityGVCR2_TANK_PT76.class, "EntityGVCR2_TANK_PT76", 57, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_TANK_KV2"), 
				EntityGVCR2_TANK_KV2.class, "EntityGVCR2_TANK_KV2", 58, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_TANK_FV101"), 
				EntityGVCR2_TANK_FV101.class, "EntityGVCR2_TANK_FV101", 59, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_TANK_ZSU_23_4"), 
				EntityGVCR2_TANK_ZSU_23_4.class, "EntityGVCR2_TANK_ZSU_23_4", 60, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_TANK_2K22"), 
				EntityGVCR2_TANK_2K22.class, "EntityGVCR2_TANK_2K22", 61, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_TANK_M1A2"), 
				EntityGVCR2_TANK_M1A2.class, "EntityGVCR2_TANK_M1A2", 62, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_TANK_M41DK1"), 
				EntityGVCR2_TANK_M41DK1.class, "EntityGVCR2_TANK_M41DK1", 63, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_TANK_T90"), 
				EntityGVCR2_TANK_T90.class, "EntityGVCR2_TANK_T90", 64, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_TANK_RATTE"), 
				EntityGVCR2_TANK_RATTE.class, "EntityGVCR2_TANK_RATTE", 65, mod, 128, 5, true);
		
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_AIR_C130"), 
				EntityGVCR2_AIR_C130.class, "EntityGVCR2_AIR_C130", 99, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_AIR_F16"), 
				EntityGVCR2_AIR_F16.class, "EntityGVCR2_AIR_F16", 100, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_AIR_F18"), 
				EntityGVCR2_AIR_F18.class, "EntityGVCR2_AIR_F18", 101, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_AIR_A10"), 
				EntityGVCR2_AIR_A10.class, "EntityGVCR2_AIR_A10", 102, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_AIR_MIG17"), 
				EntityGVCR2_AIR_MIG17.class, "EntityGVCR2_AIR_MIG17", 103, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_AIR_LI28"), 
				EntityGVCR2_AIR_LI28.class, "EntityGVCR2_AIR_LI28", 104, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_AIR_F117"), 
				EntityGVCR2_AIR_F117.class, "EntityGVCR2_AIR_F117", 105, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_AIR_AC130"), 
				EntityGVCR2_AIR_AC130.class, "EntityGVCR2_AIR_AC130", 106, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_AIR_A6"), 
				EntityGVCR2_AIR_A6.class, "EntityGVCR2_AIR_A6", 107, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_AIR_YAK23"), 
				EntityGVCR2_AIR_YAK23.class, "EntityGVCR2_AIR_YAK23", 108, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_AIR_A4"), 
				EntityGVCR2_AIR_A4.class, "EntityGVCR2_AIR_A4", 109, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_AIR_YAK23KAI"), 
				EntityGVCR2_AIR_YAK23KAI.class, "EntityGVCR2_AIR_YAK23KAI", 1100, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_AIR_AN2"), 
				EntityGVCR2_AIR_AN2.class, "EntityGVCR2_AIR_AN2", 1101, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_AIR_SU27"), 
				EntityGVCR2_AIR_SU27.class, "EntityGVCR2_AIR_SU27", 1102, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_AIR_SU25"), 
				EntityGVCR2_AIR_SU25.class, "EntityGVCR2_AIR_SU25", 1103, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_AIR_AV8B"), 
				EntityGVCR2_AIR_AV8B.class, "EntityGVCR2_AIR_AV8B", 1104, mod, 128, 5, true);
		
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SHIP_RHIB"), 
				EntityGVCR2_SHIP_RHIB.class, "EntityGVCR2_SHIP_RHIB", 120, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SHIP_RCB"), 
				EntityGVCR2_SHIP_RCB.class, "EntityGVCR2_SHIP_RCB", 121, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SHIP_CRUISER"), 
				EntityGVCR2_SHIP_CRUISER.class, "EntityGVCR2_SHIP_CRUISER", 122, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SHIP_PR1204"), 
				EntityGVCR2_SHIP_PR1204.class, "EntityGVCR2_SHIP_PR1204", 123, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SHIP_HAMINA"), 
				EntityGVCR2_SHIP_HAMINA.class, "EntityGVCR2_SHIP_HAMINA", 124, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SHIP_AIRSHIP"), 
				EntityGVCR2_SHIP_AIRSHIP.class, "EntityGVCR2_SHIP_AIRSHIP", 125, mod, 128, 5, true);
		
		
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SET_MG_M60"), 
				EntityGVCR2_SET_MG_M60.class, "EntityGVCR2_SET_MG_M60", 70, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SET_MG_M2"), 
				EntityGVCR2_SET_MG_M2.class, "EntityGVCR2_SET_MG_M2", 71, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SET_MG_PKM"), 
				EntityGVCR2_SET_MG_PKM.class, "EntityGVCR2_SET_MG_PKM", 72, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SET_MG_DP28"), 
				EntityGVCR2_SET_MG_DP28.class, "EntityGVCR2_SET_MG_DP28", 73, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SET_AA_20mmAA"), 
				EntityGVCR2_SET_AA_20mmAA.class, "EntityGVCR2_SET_AA_20mmAA", 80, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SET_AA_Zu23"), 
				EntityGVCR2_SET_AA_Zu23.class, "EntityGVCR2_SET_AA_Zu23", 81, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SET_AA_VADS"), 
				EntityGVCR2_SET_AA_VADS.class, "EntityGVCR2_SET_AA_VADS", 82, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SET_AA_Mk15"), 
				EntityGVCR2_SET_AA_Mk15.class, "EntityGVCR2_SET_AA_Mk15", 83, mod, 128, 5, true);
		
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SET_CANNON_Pak40"), 
				EntityGVCR2_SET_CANNON_Pak40.class, "EntityGVCR2_SET_CANNON_Pak40", 90, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SET_CANNON_Flak18"), 
				EntityGVCR2_SET_CANNON_Flak18.class, "EntityGVCR2_SET_CANNON_Flak18", 91, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SET_CANNON_TOW2"), 
				EntityGVCR2_SET_CANNON_TOW2.class, "EntityGVCR2_SET_CANNON_TOW2", 92, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SET_MORTAR_M224"), 
				EntityGVCR2_SET_MORTAR_M224.class, "EntityGVCR2_SET_MORTAR_M224", 95, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SET_MORTAR_FH18"), 
				EntityGVCR2_SET_MORTAR_FH18.class, "EntityGVCR2_SET_MORTAR_FH18", 96, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SET_CANNON_AK130"), 
				EntityGVCR2_SET_CANNON_AK130.class, "EntityGVCR2_SET_CANNON_AK130", 97, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_SET_CANNON_Mk45"), 
				EntityGVCR2_SET_CANNON_Mk45.class, "EntityGVCR2_SET_CANNON_Mk45", 98, mod, 128, 5, true);
		
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityDrone_MAV"), 
				EntityDrone_MAV.class, "EntityDrone_MAV", 1400, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityDrone_EOD"), 
				EntityDrone_EOD.class, "EntityDrone_EOD", 1410, mod, 128, 5, true);
		EntityRegistry.registerModEntity(new ResourceLocation("EntityDrone_RAWR"), 
				EntityDrone_RAWR.class, "EntityDrone_RAWR", 1420, mod, 128, 5, true);
		
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_INV_SCENARIO"), 
				EntityGVCR2_INV_SCENARIO.class, "EntityGVCR2_INV_SCENARIO", 500, mod, 128, 5, true);
		
		
		
		//bullet
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_Bullet_Beam"), 
				EntityGVCR2_Bullet_Beam.class, "EntityGVCR2_Bullet_Beam", 300, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_EE_Shark"), 
				EntityGVCR2_EE_Shark.class, "EntityGVCR2_EE_Shark", 301, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_Request_Smoke"), 
				EntityGVCR2_Request_Smoke.class, "EntityGVCR2_Request_Smoke", 302, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_Bullet_ROG"), 
				EntityGVCR2_Bullet_ROG.class, "EntityGVCR2_Bullet_ROG", 303, mod, 128, 5, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("EntityGVCR2_STARS"), 
				EntityGVCR2_STARS.class, "EntityGVCR2_STARS", 304, mod, 128, 5, true);
		
		Biome[] biomeList = null;
		biomeList = new Biome[Short.MAX_VALUE];
		for (int i=0; i<255; i++) 
		{
			if( i == 8) {
				if(mod.cfg_canspawn_hell)biomeList[i] = Biome.REGISTRY.getObjectById(i);
			}else if(i == 9) {
				if(mod.cfg_canspawn_sky)biomeList[i] = Biome.REGISTRY.getObjectById(i);
			}else {
				biomeList[i] = Biome.REGISTRY.getObjectById(i);
			}
		}
			
		for(Biome biome : biomeList)
		{
			if(biome!=null)
			{
				if(mod_GVCR2.cfg_canspawn){
					spawnEntity(mod, biome);
				}
			}
		}
		
	}
	
	public static void spawnEntity(mod_GVCR2 mod, Biome biome) {
		if(mod.cfg_canspawn_mob_ge){
			EntityRegistry.addSpawn(EntityGVCR2_GE_S.class, mod.cfg_spawn_limit_g, mod.cfg_spawn_limit_g_min*3, mod.cfg_spawn_limit_g_max*3, EnumCreatureType.MONSTER, biome);
			EntityRegistry.addSpawn(EntityGVCR2_GE_SV.class, mod.cfg_spawn_limit_g, mod.cfg_spawn_limit_g_min, mod.cfg_spawn_limit_g_max, EnumCreatureType.MONSTER, biome);
		}
		{
			if(mod.cfg_canspawn_mob_car){
				EntityRegistry.addSpawn(EntityGVCR2_CAR_Technical.class, mod.cfg_spawn_limit_car, mod.cfg_spawn_limit_car_min*4, mod.cfg_spawn_limit_car_max*4, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(EntityGVCR2_APC_M113.class, mod.cfg_spawn_limit_car, mod.cfg_spawn_limit_car_min, mod.cfg_spawn_limit_car_max, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(EntityGVCR2_APC_BTR60.class, mod.cfg_spawn_limit_car, mod.cfg_spawn_limit_car_min, mod.cfg_spawn_limit_car_max, EnumCreatureType.MONSTER, biome);
			}
			if(mod.cfg_canspawn_mob_tank){
				EntityRegistry.addSpawn(EntityGVCR2_TANK_PT76.class, mod.cfg_spawn_limit_tank, mod.cfg_spawn_limit_tank_min*3, mod.cfg_spawn_limit_tank_max*3, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(EntityGVCR2_TANK_T34.class, mod.cfg_spawn_limit_tank, mod.cfg_spawn_limit_tank_min*2, mod.cfg_spawn_limit_tank_max*2, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(EntityGVCR2_TANK_T55.class, mod.cfg_spawn_limit_tank, mod.cfg_spawn_limit_tank_min, mod.cfg_spawn_limit_tank_max, EnumCreatureType.MONSTER, biome);
			}
			if(mod.cfg_canspawn_mob_heli){
				EntityRegistry.addSpawn(EntityGVCR2_HELI_GHELI.class, mod.cfg_spawn_limit_heli, mod.cfg_spawn_limit_heli_min*2, mod.cfg_spawn_limit_heli_max*2, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(EntityGVCR2_HELI_R22.class, mod.cfg_spawn_limit_heli, mod.cfg_spawn_limit_heli_min*2, mod.cfg_spawn_limit_heli_max*2, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(EntityGVCR2_HELI_MI24D.class, mod.cfg_spawn_limit_heli, mod.cfg_spawn_limit_heli_min, mod.cfg_spawn_limit_heli_max, EnumCreatureType.MONSTER, biome);
			}
		}
		
		if(mod.cfg_canspawn_mob_so){
			EntityRegistry.addSpawn(EntityGVCR2_SO_S.class, mod.cfg_spawn_limit_s, mod.cfg_spawn_limit_s_min, mod.cfg_spawn_limit_s_max, EnumCreatureType.MONSTER, biome);
		}
	}
	
}




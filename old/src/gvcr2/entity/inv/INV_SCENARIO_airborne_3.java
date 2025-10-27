package gvcr2.entity.inv;

import java.util.List;

import gvclib.mod_GVCLib;
import gvcr2.mod_GVCR2;
import gvcr2.block.BlockBuildingBaseFlag;
import gvcr2.block.tile.TileEntityBlockBaseFlag;
import gvcr2.entity.mob.EntityGVCR2_GEBase;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.mob.EntityGVCR2_UNKS_C_S;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_AN2;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_SU27;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_YAK23;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_YAK23KAI;
import gvcr2.entity.vehicle.car.EntityGVCR2_CAR_BULLDOZER;
import gvcr2.entity.vehicle.car.EntityGVCR2_CAR_Technical;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_GHELI;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_KA60;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_R22;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T34;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class INV_SCENARIO_airborne_3 {
	
	public void scenario(EntityGVCR2_INV_SCENARIO inv_entity, int flagtimer, boolean flag_xp, boolean flag_xm, boolean flag_zp, boolean flag_zm) {
		INV_SCENARIO scenario_base = new INV_SCENARIO();
		
		
		
		
		int spawn_start_time = 2;
		int range_x = 80 + inv_entity.getArmID_L();
		int range_z = 80 + inv_entity.getArmID_L();
		World world = inv_entity.world;
		int angle = scenario_base.angle_set(inv_entity, flag_xp, flag_xm, flag_zp, flag_zm);
		 range_x = scenario_base.angle_range(inv_entity, angle, true);
		 range_z = scenario_base.angle_range(inv_entity, angle, false);
		
		boolean spawn_flag = scenario_base.spawn_flags(flag_xp, flag_xm, flag_zp, flag_zm);
		if(inv_entity.getHealth() < spawn_start_time && !spawn_flag){
			scenario_base.sendmessage(world, inv_entity.posX, inv_entity.posY, inv_entity.posZ, 80, "Spawning conditions not met!", true);
			inv_entity.setHealth(200);
		}
		//WAVE1
		if(inv_entity.getHealth() < spawn_start_time && inv_entity.getArmID_A() == 0 && spawn_flag){
			inv_entity.setArmID_A(1);
			scenario_base.sendmessage(world, inv_entity.posX, inv_entity.posY, inv_entity.posZ, 80, "WAVE1 COMMING!", true);
			//flagtimer = 0;
			inv_entity.setHealth(inv_entity.getMaxHealth());
			
			for(int c = 0; c < 3;++c){//for
				int xx = 0;
				int zz = 0;
				if(c == 1) {
					xx = -10;
					zz = 10;
				}
				if(c == 2) {
					xx = -10;
					zz = -10;
				}
				if(c == 0) {
					if (!world.isRemote) {
						EntityGVCR2_AIR_YAK23KAI car = new EntityGVCR2_AIR_YAK23KAI(world);
						car.setcanDespawn(1);
						car.throttle = car.thmax;
						car.thpower = car.thmax;
						car.setMoveT(1);
						car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 10));
						car.setMoveY((int)inv_entity.posY);
						car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 10));
						double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 10);
						double y_pos = inv_entity.posY + 20;
						double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 10);
						double d5 = inv_entity.posX - x_pos;
						double d7 = inv_entity.posZ - z_pos;
						float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
						car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
						world.spawnEntity(car);
						
						if(car != null) {
							for(int mm = 0; mm < car.riddng_maximum; ++mm) {
								EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
								entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
								entityskeleton.setWeapon_inv_airborne(false);
								entityskeleton.setcanDespawn(1);
								entityskeleton.setMoveT(1);
								entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 10));
								entityskeleton.setMoveY((int)inv_entity.posY);
								entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 10));
								entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
								world.spawnEntity(entityskeleton);
								entityskeleton.startRiding(car);
							}
						}
					}
				}
				else{
					if (!world.isRemote) {
						EntityGVCR2_AIR_YAK23 car = new EntityGVCR2_AIR_YAK23(world);
						car.setcanDespawn(1);
						car.throttle = car.thmax;
						car.thpower = car.thmax;
						car.setMoveT(1);
						car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 10));
						car.setMoveY((int)inv_entity.posY);
						car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 10));
						double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 10);
						double y_pos = inv_entity.posY + 20;
						double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 10);
						double d5 = inv_entity.posX - x_pos;
						double d7 = inv_entity.posZ - z_pos;
						float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
						car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
						world.spawnEntity(car);
						
						if(car != null) {
							for(int mm = 0; mm < car.riddng_maximum; ++mm) {
								EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
								entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
								entityskeleton.setWeapon_inv_airborne(false);
								entityskeleton.setcanDespawn(1);
								entityskeleton.setMoveT(1);
								entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 10));
								entityskeleton.setMoveY((int)inv_entity.posY);
								entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 10));
								entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
								world.spawnEntity(entityskeleton);
								entityskeleton.startRiding(car);
							}
						}
					}
				}
				if(c == 0) {
					if (!world.isRemote) {
						EntityGVCR2_AIR_AN2 car = new EntityGVCR2_AIR_AN2(world);
						car.setcanDespawn(1);
						car.throttle = car.thmax;
						car.thpower = car.thmax;
						//car.setFTMode(30);
						//car.setArmID_S(30 + world.rand.nextInt(10));
						car.setMoveT(1);
						car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
						car.setMoveY((int)inv_entity.posY);
						car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
						double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 15);
						double y_pos = inv_entity.posY + 20;
						double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 15);
						double d5 = inv_entity.posX - x_pos;
						double d7 = inv_entity.posZ - z_pos;
						float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
						car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
						world.spawnEntity(car);
						
						if(car != null) {
							for(int mm = 0; mm < 2; ++mm) {
								EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
								entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
								entityskeleton.setWeapon_inv_airborne(false);
								entityskeleton.setcanDespawn(1);
								entityskeleton.setMoveT(1);
								entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
								entityskeleton.setMoveY((int)inv_entity.posY);
								entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
								entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
								world.spawnEntity(entityskeleton);
								entityskeleton.startRiding(car);
							}
						}
					}
				}
				else{
					if (!world.isRemote) {
						EntityGVCR2_AIR_AN2 car = new EntityGVCR2_AIR_AN2(world);
						car.setcanDespawn(1);
						car.throttle = car.thmax;
						car.thpower = car.thmax;
						car.setFTMode(30);
						car.setArmID_S(30 + world.rand.nextInt(10));
						car.setMoveT(1);
						car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
						car.setMoveY((int)inv_entity.posY);
						car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
						double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 15);
						double y_pos = inv_entity.posY + 20;
						double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 15);
						double d5 = inv_entity.posX - x_pos;
						double d7 = inv_entity.posZ - z_pos;
						float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
						car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
						world.spawnEntity(car);
						
						if(car != null) {
							for(int mm = 0; mm < car.riddng_maximum; ++mm) {
								EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
								entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
								entityskeleton.setWeapon_inv_airborne(false);
								entityskeleton.setcanDespawn(1);
								entityskeleton.setMoveT(1);
								entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
								entityskeleton.setMoveY((int)inv_entity.posY);
								entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
								entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
								world.spawnEntity(entityskeleton);
								entityskeleton.startRiding(car);
							}
						}
					}
				}
			}//for
		}//WAVE1
		
		
		//WAVE2
		if(inv_entity.getHealth() < spawn_start_time && inv_entity.getArmID_A() == 1 && spawn_flag){
			inv_entity.setArmID_A(2);
			scenario_base.sendmessage(world, inv_entity.posX, inv_entity.posY, inv_entity.posZ, 80, "WAVE2 COMMING!", true);
			//flagtimer = 0;
			inv_entity.setHealth(inv_entity.getMaxHealth());
			
			for(int c = 0; c < 3;++c){//for
				int xx = 0;
				int zz = 0;
				if(c == 1) {
					xx = -10;
					zz = 10;
				}
				if(c == 2) {
					xx = -10;
					zz = -10;
				}
				if(c == 0) {
					if (!world.isRemote) {
						EntityGVCR2_AIR_YAK23KAI car = new EntityGVCR2_AIR_YAK23KAI(world);
						car.setcanDespawn(1);
						car.throttle = car.thmax;
						car.thpower = car.thmax;
						car.setMoveT(1);
						car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 10));
						car.setMoveY((int)inv_entity.posY);
						car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 10));
						double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 10);
						double y_pos = inv_entity.posY + 20;
						double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 10);
						double d5 = inv_entity.posX - x_pos;
						double d7 = inv_entity.posZ - z_pos;
						float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
						car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
						world.spawnEntity(car);
						
						if(car != null) {
							for(int mm = 0; mm < car.riddng_maximum; ++mm) {
								EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
								entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
								entityskeleton.setWeapon_inv_airborne(false);
								entityskeleton.setcanDespawn(1);
								entityskeleton.setMoveT(1);
								entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 10));
								entityskeleton.setMoveY((int)inv_entity.posY);
								entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 10));
								entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
								world.spawnEntity(entityskeleton);
								entityskeleton.startRiding(car);
							}
						}
					}
				}
				else{
					if (!world.isRemote) {
						EntityGVCR2_AIR_YAK23 car = new EntityGVCR2_AIR_YAK23(world);
						car.setcanDespawn(1);
						car.throttle = car.thmax;
						car.thpower = car.thmax;
						car.setMoveT(1);
						car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 10));
						car.setMoveY((int)inv_entity.posY);
						car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 10));
						double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 10);
						double y_pos = inv_entity.posY + 20;
						double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 10);
						double d5 = inv_entity.posX - x_pos;
						double d7 = inv_entity.posZ - z_pos;
						float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
						car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
						world.spawnEntity(car);
						
						if(car != null) {
							for(int mm = 0; mm < car.riddng_maximum; ++mm) {
								EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
								entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
								entityskeleton.setWeapon_inv_airborne(false);
								entityskeleton.setcanDespawn(1);
								entityskeleton.setMoveT(1);
								entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 10));
								entityskeleton.setMoveY((int)inv_entity.posY);
								entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 10));
								entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
								world.spawnEntity(entityskeleton);
								entityskeleton.startRiding(car);
							}
						}
					}
				}
				if(c == 0) {
					if (!world.isRemote) {
						EntityGVCR2_AIR_AN2 car = new EntityGVCR2_AIR_AN2(world);
						car.setcanDespawn(1);
						car.throttle = car.thmax;
						car.thpower = car.thmax;
						//car.setFTMode(30);
						//car.setArmID_S(30 + world.rand.nextInt(10));
						car.setMoveT(1);
						car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
						car.setMoveY((int)inv_entity.posY);
						car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
						double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 15);
						double y_pos = inv_entity.posY + 20;
						double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 15);
						double d5 = inv_entity.posX - x_pos;
						double d7 = inv_entity.posZ - z_pos;
						float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
						car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
						world.spawnEntity(car);
						
						if(car != null) {
							for(int mm = 0; mm < 2; ++mm) {
								EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
								entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
								entityskeleton.setWeapon_inv_airborne(false);
								entityskeleton.setcanDespawn(1);
								entityskeleton.setMoveT(1);
								entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
								entityskeleton.setMoveY((int)inv_entity.posY);
								entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
								entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
								world.spawnEntity(entityskeleton);
								entityskeleton.startRiding(car);
							}
						}
					}
				}
				else{
					if (!world.isRemote) {
						EntityGVCR2_AIR_AN2 car = new EntityGVCR2_AIR_AN2(world);
						car.setcanDespawn(1);
						car.throttle = car.thmax;
						car.thpower = car.thmax;
						car.setFTMode(30);
						car.setArmID_S(30 + world.rand.nextInt(10));
						car.setMoveT(1);
						car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
						car.setMoveY((int)inv_entity.posY);
						car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
						double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 15);
						double y_pos = inv_entity.posY + 20;
						double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 15);
						double d5 = inv_entity.posX - x_pos;
						double d7 = inv_entity.posZ - z_pos;
						float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
						car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
						world.spawnEntity(car);
						
						if(car != null) {
							for(int mm = 0; mm < car.riddng_maximum; ++mm) {
								EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
								entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
								entityskeleton.setWeapon_inv_airborne(false);
								entityskeleton.setcanDespawn(1);
								entityskeleton.setMoveT(1);
								entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
								entityskeleton.setMoveY((int)inv_entity.posY);
								entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
								entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
								world.spawnEntity(entityskeleton);
								entityskeleton.startRiding(car);
							}
						}
					}
				}
			}//for
		}//WAVE2
		
		//WAVE3
		if(inv_entity.getHealth() < spawn_start_time && inv_entity.getArmID_A() == 2 && spawn_flag){
					inv_entity.setArmID_A(3);
					scenario_base.sendmessage(world, inv_entity.posX, inv_entity.posY, inv_entity.posZ, 80, "WAVE3 COMMING!", true);
					//flagtimer = 0;
					inv_entity.setHealth(inv_entity.getMaxHealth());
					
					for(int c = 0; c < 3;++c){//for
						int xx = 0;
						int zz = 0;
						if(c == 1) {
							xx = -10;
							zz = 10;
						}
						if(c == 2) {
							xx = -10;
							zz = -10;
						}
						{
							if (!world.isRemote) {
								EntityGVCR2_AIR_YAK23KAI car = new EntityGVCR2_AIR_YAK23KAI(world);
								car.setcanDespawn(1);
								car.throttle = car.thmax;
								car.thpower = car.thmax;
								car.setMoveT(1);
								car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 10));
								car.setMoveY((int)inv_entity.posY);
								car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 10));
								double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 10);
								double y_pos = inv_entity.posY + 20;
								double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 10);
								double d5 = inv_entity.posX - x_pos;
								double d7 = inv_entity.posZ - z_pos;
								float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
								car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
								world.spawnEntity(car);
								
								if(car != null) {
									for(int mm = 0; mm < car.riddng_maximum; ++mm) {
										EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
										entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
										entityskeleton.setWeapon_inv_airborne(false);
										entityskeleton.setcanDespawn(1);
										entityskeleton.setMoveT(1);
										entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 10));
										entityskeleton.setMoveY((int)inv_entity.posY);
										entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 10));
										entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
										world.spawnEntity(entityskeleton);
										entityskeleton.startRiding(car);
									}
								}
							}
						}
						if(c == 0) {
							if (!world.isRemote) {
								EntityGVCR2_AIR_AN2 car = new EntityGVCR2_AIR_AN2(world);
								car.setcanDespawn(1);
								car.throttle = car.thmax;
								car.thpower = car.thmax;
								//car.setFTMode(30);
								//car.setArmID_S(30 + world.rand.nextInt(10));
								car.setMoveT(1);
								car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
								car.setMoveY((int)inv_entity.posY);
								car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
								double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 15);
								double y_pos = inv_entity.posY + 20;
								double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 15);
								double d5 = inv_entity.posX - x_pos;
								double d7 = inv_entity.posZ - z_pos;
								float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
								car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
								world.spawnEntity(car);
								
								if(car != null) {
									for(int mm = 0; mm < 2; ++mm) {
										EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
										entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
										entityskeleton.setWeapon_inv_airborne(false);
										entityskeleton.setcanDespawn(1);
										entityskeleton.setMoveT(1);
										entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
										entityskeleton.setMoveY((int)inv_entity.posY);
										entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
										entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
										world.spawnEntity(entityskeleton);
										entityskeleton.startRiding(car);
									}
								}
							}
						}
						else{
							if (!world.isRemote) {
								EntityGVCR2_AIR_AN2 car = new EntityGVCR2_AIR_AN2(world);
								car.setcanDespawn(1);
								car.throttle = car.thmax;
								car.thpower = car.thmax;
								car.setFTMode(30);
								car.setArmID_S(30 + world.rand.nextInt(10));
								car.setMoveT(1);
								car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
								car.setMoveY((int)inv_entity.posY);
								car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
								double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 15);
								double y_pos = inv_entity.posY + 20;
								double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 15);
								double d5 = inv_entity.posX - x_pos;
								double d7 = inv_entity.posZ - z_pos;
								float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
								car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
								world.spawnEntity(car);
								
								if(car != null) {
									for(int mm = 0; mm < car.riddng_maximum; ++mm) {
										EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
										entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
										entityskeleton.setWeapon_inv_airborne(false);
										entityskeleton.setcanDespawn(1);
										entityskeleton.setMoveT(1);
										entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
										entityskeleton.setMoveY((int)inv_entity.posY);
										entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
										entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
										world.spawnEntity(entityskeleton);
										entityskeleton.startRiding(car);
									}
								}
							}
						}
					}//for
				}//WAVE3
		
		//WAVE4
				if(inv_entity.getHealth() < spawn_start_time && inv_entity.getArmID_A() == 3 && spawn_flag){
							inv_entity.setArmID_A(4);
							scenario_base.sendmessage(world, inv_entity.posX, inv_entity.posY, inv_entity.posZ, 80, "WAVE4 COMMING!", true);
							//flagtimer = 0;
							inv_entity.setHealth(inv_entity.getMaxHealth());
							
							for(int c = 0; c < 3;++c){//for
								int xx = 0;
								int zz = 0;
								if(c == 1) {
									xx = -10;
									zz = 10;
								}
								if(c == 2) {
									xx = -10;
									zz = -10;
								}
								{
									if (!world.isRemote) {
										EntityGVCR2_AIR_YAK23KAI car = new EntityGVCR2_AIR_YAK23KAI(world);
										car.setcanDespawn(1);
										car.throttle = car.thmax;
										car.thpower = car.thmax;
										car.setMoveT(1);
										car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 10));
										car.setMoveY((int)inv_entity.posY);
										car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 10));
										double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 10);
										double y_pos = inv_entity.posY + 20;
										double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 10);
										double d5 = inv_entity.posX - x_pos;
										double d7 = inv_entity.posZ - z_pos;
										float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
										car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
										world.spawnEntity(car);
										
										if(car != null) {
											for(int mm = 0; mm < car.riddng_maximum; ++mm) {
												EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
												entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
												entityskeleton.setWeapon_inv_airborne(false);
												entityskeleton.setcanDespawn(1);
												entityskeleton.setMoveT(1);
												entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 10));
												entityskeleton.setMoveY((int)inv_entity.posY);
												entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 10));
												entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
												world.spawnEntity(entityskeleton);
												entityskeleton.startRiding(car);
											}
										}
									}
								}
								if(c == 0) {
									if (!world.isRemote) {
										EntityGVCR2_AIR_AN2 car = new EntityGVCR2_AIR_AN2(world);
										car.setcanDespawn(1);
										car.throttle = car.thmax;
										car.thpower = car.thmax;
										//car.setFTMode(30);
										//car.setArmID_S(30 + world.rand.nextInt(10));
										car.setMoveT(1);
										car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
										car.setMoveY((int)inv_entity.posY);
										car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
										double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 15);
										double y_pos = inv_entity.posY + 20;
										double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 15);
										double d5 = inv_entity.posX - x_pos;
										double d7 = inv_entity.posZ - z_pos;
										float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
										car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
										world.spawnEntity(car);
										
										if(car != null) {
											for(int mm = 0; mm < 2; ++mm) {
												EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
												entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
												entityskeleton.setWeapon_inv_airborne(false);
												entityskeleton.setcanDespawn(1);
												entityskeleton.setMoveT(1);
												entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
												entityskeleton.setMoveY((int)inv_entity.posY);
												entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
												entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
												world.spawnEntity(entityskeleton);
												entityskeleton.startRiding(car);
											}
										}
									}
								}
								else{
									if (!world.isRemote) {
										EntityGVCR2_AIR_AN2 car = new EntityGVCR2_AIR_AN2(world);
										car.setcanDespawn(1);
										car.throttle = car.thmax;
										car.thpower = car.thmax;
										car.setFTMode(30);
										car.setArmID_S(30 + world.rand.nextInt(10));
										car.setMoveT(1);
										car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
										car.setMoveY((int)inv_entity.posY);
										car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
										double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 15);
										double y_pos = inv_entity.posY + 20;
										double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 15);
										double d5 = inv_entity.posX - x_pos;
										double d7 = inv_entity.posZ - z_pos;
										float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
										car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
										world.spawnEntity(car);
										
										if(car != null) {
											for(int mm = 0; mm < car.riddng_maximum; ++mm) {
												EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
												entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
												entityskeleton.setWeapon_inv_airborne(false);
												entityskeleton.setcanDespawn(1);
												entityskeleton.setMoveT(1);
												entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
												entityskeleton.setMoveY((int)inv_entity.posY);
												entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
												entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
												world.spawnEntity(entityskeleton);
												entityskeleton.startRiding(car);
											}
										}
									}
								}
							}//for
						}//WAVE4
				
				//WAVE5
				if(inv_entity.getHealth() < spawn_start_time && inv_entity.getArmID_A() == 4 && spawn_flag){
							inv_entity.setArmID_A(5);
							scenario_base.sendmessage(world, inv_entity.posX, inv_entity.posY, inv_entity.posZ, 80, "WAVE5 COMMING!", true);
							//flagtimer = 0;
							inv_entity.setHealth(inv_entity.getMaxHealth());
							
							for(int c = 0; c < 3;++c){//for
								int xx = 0;
								int zz = 0;
								if(c == 1) {
									xx = -10;
									zz = 10;
								}
								if(c == 2) {
									xx = -10;
									zz = -10;
								}
								if(c == 0) {
									if (!world.isRemote) {
										EntityGVCR2_AIR_SU27 car = new EntityGVCR2_AIR_SU27(world);
										car.setcanDespawn(1);
										car.throttle = car.thmax;
										car.thpower = car.thmax;
										car.setMoveT(1);
										car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 10));
										car.setMoveY((int)inv_entity.posY);
										car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 10));
										double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 10);
										double y_pos = inv_entity.posY + 20;
										double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 10);
										double d5 = inv_entity.posX - x_pos;
										double d7 = inv_entity.posZ - z_pos;
										float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
										car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
										world.spawnEntity(car);
										
										if(car != null) {
											for(int mm = 0; mm < car.riddng_maximum; ++mm) {
												EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
												entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
												entityskeleton.setWeapon_inv_airborne(false);
												entityskeleton.setcanDespawn(1);
												entityskeleton.setMoveT(1);
												entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 10));
												entityskeleton.setMoveY((int)inv_entity.posY);
												entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 10));
												entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
												world.spawnEntity(entityskeleton);
												entityskeleton.startRiding(car);
											}
										}
									}
								}else {
									if (!world.isRemote) {
										EntityGVCR2_AIR_YAK23KAI car = new EntityGVCR2_AIR_YAK23KAI(world);
										car.setcanDespawn(1);
										car.throttle = car.thmax;
										car.thpower = car.thmax;
										car.setMoveT(1);
										car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 10));
										car.setMoveY((int)inv_entity.posY);
										car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 10));
										double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 10);
										double y_pos = inv_entity.posY + 20;
										double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 10);
										double d5 = inv_entity.posX - x_pos;
										double d7 = inv_entity.posZ - z_pos;
										float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
										car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
										world.spawnEntity(car);
										
										if(car != null) {
											for(int mm = 0; mm < car.riddng_maximum; ++mm) {
												EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
												entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
												entityskeleton.setWeapon_inv_airborne(false);
												entityskeleton.setcanDespawn(1);
												entityskeleton.setMoveT(1);
												entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 10));
												entityskeleton.setMoveY((int)inv_entity.posY);
												entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 10));
												entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
												world.spawnEntity(entityskeleton);
												entityskeleton.startRiding(car);
											}
										}
									}
								}
								if(c == 0) {
									if (!world.isRemote) {
										EntityGVCR2_AIR_AN2 car = new EntityGVCR2_AIR_AN2(world);
										car.setcanDespawn(1);
										car.throttle = car.thmax;
										car.thpower = car.thmax;
										//car.setFTMode(30);
										//car.setArmID_S(30 + world.rand.nextInt(10));
										car.setMoveT(1);
										car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
										car.setMoveY((int)inv_entity.posY);
										car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
										double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 15);
										double y_pos = inv_entity.posY + 20;
										double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 15);
										double d5 = inv_entity.posX - x_pos;
										double d7 = inv_entity.posZ - z_pos;
										float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
										car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
										world.spawnEntity(car);
										
										if(car != null) {
											for(int mm = 0; mm < 2; ++mm) {
												EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
												entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
												entityskeleton.setWeapon_inv_airborne(false);
												entityskeleton.setcanDespawn(1);
												entityskeleton.setMoveT(1);
												entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
												entityskeleton.setMoveY((int)inv_entity.posY);
												entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
												entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
												world.spawnEntity(entityskeleton);
												entityskeleton.startRiding(car);
											}
										}
									}
								}
								else{
									if (!world.isRemote) {
										EntityGVCR2_AIR_AN2 car = new EntityGVCR2_AIR_AN2(world);
										car.setcanDespawn(1);
										car.throttle = car.thmax;
										car.thpower = car.thmax;
										car.setFTMode(30);
										car.setArmID_S(30 + world.rand.nextInt(10));
										car.setMoveT(1);
										car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
										car.setMoveY((int)inv_entity.posY);
										car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
										double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 15);
										double y_pos = inv_entity.posY + 20;
										double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 15);
										double d5 = inv_entity.posX - x_pos;
										double d7 = inv_entity.posZ - z_pos;
										float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
										car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
										world.spawnEntity(car);
										
										if(car != null) {
											for(int mm = 0; mm < car.riddng_maximum; ++mm) {
												EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
												entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
												entityskeleton.setWeapon_inv_airborne(false);
												entityskeleton.setcanDespawn(1);
												entityskeleton.setMoveT(1);
												entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
												entityskeleton.setMoveY((int)inv_entity.posY);
												entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
												entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
												world.spawnEntity(entityskeleton);
												entityskeleton.startRiding(car);
											}
										}
									}
								}
							}//for
						}//WAVE5
		
		//WAVE_CLEAR
				if(inv_entity.getHealth() < spawn_start_time && inv_entity.getArmID_A() == 5 && spawn_flag){
					scenario_base.sendmessage(world, inv_entity.posX, inv_entity.posY, inv_entity.posZ, 80, "Misson Clear!", true);
					if(!world.isRemote) {
						{
							world.setBlockState(new BlockPos(inv_entity.getMoveX(), inv_entity.getMoveY(), inv_entity.getMoveZ()), Blocks.CHEST.getDefaultState(), 2);
							TileEntityChest Chest3;
							Chest3 = (TileEntityChest) world.getTileEntity(new BlockPos(inv_entity.getMoveX(), inv_entity.getMoveY(), inv_entity.getMoveZ()));
							Chest3.setInventorySlotContents(13, new ItemStack(mod_GVCR2.gvcr2_item_inv_airborne_3, 1, 0));
							
							Chest3.setInventorySlotContents(4, new ItemStack(Blocks.DIAMOND_BLOCK, 8, 0));
							Chest3.setInventorySlotContents(12, new ItemStack(Blocks.EMERALD_BLOCK, 16, 0));
							Chest3.setInventorySlotContents(14, new ItemStack(Blocks.EMERALD_BLOCK, 16, 0));
							Chest3.setInventorySlotContents(22, new ItemStack(Blocks.EMERALD_BLOCK, 16, 0));
						}
						inv_entity.setDead();
					}
				}
	}
	
}
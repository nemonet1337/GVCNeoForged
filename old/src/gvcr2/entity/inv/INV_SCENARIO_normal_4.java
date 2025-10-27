package gvcr2.entity.inv;

import java.util.List;

import gvclib.mod_GVCLib;
import gvclib.entity.living.EntityMobVehicleBase;
import gvcr2.mod_GVCR2;
import gvcr2.block.BlockBuildingBaseFlag;
import gvcr2.block.tile.TileEntityBlockBaseFlag;
import gvcr2.entity.boss.EntityGVCR2_BOSS_AIRSHIP;
import gvcr2.entity.boss.EntityGVCR2_BOSS_RATTE;
import gvcr2.entity.mob.EntityGVCR2_GEBase;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.mob.EntityGVCR2_UNKS_C_S;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_AN2;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_YAK23;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_YAK23KAI;
import gvcr2.entity.vehicle.apc.EntityGVCR2_APC_BMP3;
import gvcr2.entity.vehicle.apc.EntityGVCR2_APC_BTR60;
import gvcr2.entity.vehicle.car.EntityGVCR2_CAR_BULLDOZER;
import gvcr2.entity.vehicle.car.EntityGVCR2_CAR_Technical;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_KA50;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_KA60;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_MI24D;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_R22;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_2K22;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_PT76;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T34;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T55;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T72;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T90;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_ZSU_23_4;
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

public class INV_SCENARIO_normal_4 {
	
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
		wave1(inv_entity, scenario_base, spawn_start_time, spawn_flag, range_x, range_z);
		/*if(inv_entity.getHealth() < spawn_start_time && inv_entity.getArmID_A() == 0 && spawn_flag){
			inv_entity.setArmID_A(1);
			scenario_base.sendmessage(world, inv_entity.posX, inv_entity.posY, inv_entity.posZ, 80, "WAVE1 COMMING!", true);
			//flagtimer = 0;
			inv_entity.setHealth(inv_entity.getMaxHealth());
			if (!world.isRemote) {
				EntityGVCR2_BOSS_AIRSHIP entityskeleton = new EntityGVCR2_BOSS_AIRSHIP(world);
				entityskeleton.setcanDespawn(1);
				entityskeleton.setAIType(1);
				entityskeleton.setMoveT(1);
				entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
				entityskeleton.setMoveY((int)inv_entity.posY);
				entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
				double x_pos = inv_entity.posX + range_x + 0 +scenario_base.random_int(world, 24);
				double y_pos = inv_entity.posY + 2;
				double z_pos = inv_entity.posZ + range_z  + 0 +scenario_base.random_int(world, 24);
				entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
				world.spawnEntity(entityskeleton);
			}
		}*/
		
		//WAVE2
		wave2(inv_entity, scenario_base, spawn_start_time, spawn_flag, range_x, range_z);
		
		//WAVE3
		wave3(inv_entity, scenario_base, spawn_start_time, spawn_flag, range_x, range_z);
		
		//WAVE4
		wave4(inv_entity, scenario_base, spawn_start_time, spawn_flag, range_x, range_z);
				
		//WAVE5
		wave5(inv_entity, scenario_base, spawn_start_time, spawn_flag, range_x, range_z);
		
		//WAVE6
		wave6(inv_entity, scenario_base, spawn_start_time, spawn_flag, range_x, range_z);
		
		//WAVE_CLEAR
				if(inv_entity.getHealth() < spawn_start_time && inv_entity.getArmID_A() == 6 && spawn_flag){
					scenario_base.sendmessage(world, inv_entity.posX, inv_entity.posY, inv_entity.posZ, 80, "Misson Clear!", true);
					if(!world.isRemote) {
						{
							world.setBlockState(new BlockPos(inv_entity.getMoveX(), inv_entity.getMoveY(), inv_entity.getMoveZ()), Blocks.CHEST.getDefaultState(), 2);
							TileEntityChest Chest3;
							Chest3 = (TileEntityChest) world.getTileEntity(new BlockPos(inv_entity.getMoveX(), inv_entity.getMoveY(), inv_entity.getMoveZ()));
							Chest3.setInventorySlotContents(13, new ItemStack(mod_GVCR2.gvcr2_spawn_tank_ratte, 1, 0));
							Chest3.setInventorySlotContents(1, new ItemStack(mod_GVCR2.gvcr2_item_inv_normal_4, 1, 0));
							
							Chest3.setInventorySlotContents(4, new ItemStack(Blocks.DIAMOND_BLOCK, 8, 0));
							Chest3.setInventorySlotContents(12, new ItemStack(Blocks.EMERALD_BLOCK, 16, 0));
							Chest3.setInventorySlotContents(14, new ItemStack(Blocks.EMERALD_BLOCK, 16, 0));
							Chest3.setInventorySlotContents(22, new ItemStack(Blocks.EMERALD_BLOCK, 16, 0));
						}
						inv_entity.setDead();
					}
				}
	}
	
	public void wave1(EntityGVCR2_INV_SCENARIO inv_entity, INV_SCENARIO scenario_base, int spawn_start_time, boolean spawn_flag, int range_x, int range_z) {
		World world = inv_entity.world;
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
							xx = -20;
							zz = 20;
						}
						if(c == 2) {
							xx = -20;
							zz = -20;
						}
						{
							for(int mm = 0; mm < 24; ++mm) {
								spawn_g(inv_entity, scenario_base, world, mm, range_x, range_z, xx, zz);
							}
						}
						{
							spawn_btr(inv_entity, scenario_base, world, 1, range_x, range_z, xx, zz);
						}
						if(c != 0){
							spawn_tank(inv_entity, scenario_base, world, 1, range_x, range_z, xx, zz);
						}
						if(c == 1){
							spawn_car(inv_entity, scenario_base, world, 3, range_x, range_z, xx, zz);
							spawn_heli(inv_entity, scenario_base, world, 1, range_x, range_z, xx, zz);
						}
						if(c == 2){
							spawn_tank(inv_entity, scenario_base, world, 3, range_x, range_z, xx, zz);
							spawn_heli(inv_entity, scenario_base, world, 1, range_x, range_z, xx, zz);
						}
					}//for
				}//WAVE1
	}
	
	public void wave2(EntityGVCR2_INV_SCENARIO inv_entity, INV_SCENARIO scenario_base, int spawn_start_time, boolean spawn_flag, int range_x, int range_z) {
		World world = inv_entity.world;
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
							xx = -20;
							zz = 20;
						}
						if(c == 2) {
							xx = -20;
							zz = -20;
						}
						{
							for(int mm = 0; mm < 24; ++mm) {
								spawn_g(inv_entity, scenario_base, world, mm, range_x, range_z, xx, zz);
							}
						}
						{
							spawn_btr(inv_entity, scenario_base, world, 1, range_x, range_z, xx, zz);
						}
						if(c != 0){
							spawn_tank(inv_entity, scenario_base, world, 1, range_x, range_z, xx, zz);
						}
						if(c == 1){
							spawn_car(inv_entity, scenario_base, world, 3, range_x, range_z, xx, zz);
							spawn_heli(inv_entity, scenario_base, world, 1, range_x, range_z, xx, zz);
						}
						if(c == 2){
							spawn_tank(inv_entity, scenario_base, world, 3, range_x, range_z, xx, zz);
							spawn_heli(inv_entity, scenario_base, world, 1, range_x, range_z, xx, zz);
						}
					}//for
				}//WAVE2
	}
	
	public void wave3(EntityGVCR2_INV_SCENARIO inv_entity, INV_SCENARIO scenario_base, int spawn_start_time, boolean spawn_flag, int range_x, int range_z) {
		World world = inv_entity.world;
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
									xx = -20;
									zz = 20;
								}
								if(c == 2) {
									xx = -20;
									zz = -20;
								}
								{
									for(int mm = 0; mm < 36; ++mm) {
										spawn_g(inv_entity, scenario_base, world, mm, range_x, range_z, xx, zz);
									}
								}
								{
									spawn_btr(inv_entity, scenario_base, world, 1, range_x, range_z, xx, zz);
								}
								if(c != 0){
									spawn_tank(inv_entity, scenario_base, world, 2, range_x, range_z, xx, zz);
								}
								if(c == 1){
									spawn_car(inv_entity, scenario_base, world, 3, range_x, range_z, xx, zz);
									spawn_heli(inv_entity, scenario_base, world, 1, range_x, range_z, xx, zz);
								}
								if(c == 2){
									spawn_tank(inv_entity, scenario_base, world, 3, range_x, range_z, xx, zz);
									spawn_heli(inv_entity, scenario_base, world, 1, range_x, range_z, xx, zz);
								}
							}//for
						}//WAVE3
	}
	public void wave4(EntityGVCR2_INV_SCENARIO inv_entity, INV_SCENARIO scenario_base, int spawn_start_time, boolean spawn_flag, int range_x, int range_z) {
		World world = inv_entity.world;
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
							xx = -20;
							zz = 20;
						}
						if(c == 2) {
							xx = -20;
							zz = -20;
						}
						{
							for(int mm = 0; mm < 36; ++mm) {
								spawn_g(inv_entity, scenario_base, world, mm, range_x, range_z, xx, zz);
							}
						}
						{
							spawn_btr(inv_entity, scenario_base, world, 1, range_x, range_z, xx, zz);
						}
						if(c != 0){
							spawn_tank(inv_entity, scenario_base, world, 2, range_x, range_z, xx, zz);
						}
						if(c == 1){
							spawn_car(inv_entity, scenario_base, world, 3, range_x, range_z, xx, zz);
							spawn_heli(inv_entity, scenario_base, world, 2, range_x, range_z, xx, zz);
						}
						if(c == 2){
							spawn_tank(inv_entity, scenario_base, world, 3, range_x, range_z, xx, zz);
							spawn_heli(inv_entity, scenario_base, world, 2, range_x, range_z, xx, zz);
						}
					}//for
				}//WAVE4
	}
	
	public void wave5(EntityGVCR2_INV_SCENARIO inv_entity, INV_SCENARIO scenario_base, int spawn_start_time, boolean spawn_flag, int range_x, int range_z) {
		World world = inv_entity.world;
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
							xx = -20;
							zz = 20;
						}
						if(c == 2) {
							xx = -20;
							zz = -20;
						}
						{
							for(int mm = 0; mm < 36; ++mm) {
								spawn_g(inv_entity, scenario_base, world, mm, range_x, range_z, xx, zz);
							}
						}
						{
							spawn_btr(inv_entity, scenario_base, world, 1, range_x, range_z, xx, zz);
						}
							spawn_tank(inv_entity, scenario_base, world, 5, range_x, range_z, xx, zz);
						if(c == 1){
							spawn_car(inv_entity, scenario_base, world, 4, range_x, range_z, xx, zz);
							spawn_heli(inv_entity, scenario_base, world, 2, range_x, range_z, xx, zz);
						}
						if(c == 2){
							spawn_tank(inv_entity, scenario_base, world, 4, range_x, range_z, xx, zz);
							spawn_heli(inv_entity, scenario_base, world, 2, range_x, range_z, xx, zz);
						}
					}//for
				}//WAVE5
	}
	
	public void wave6(EntityGVCR2_INV_SCENARIO inv_entity, INV_SCENARIO scenario_base, int spawn_start_time, boolean spawn_flag, int range_x, int range_z) {
		World world = inv_entity.world;
		//WAVE5
		if(inv_entity.getHealth() < spawn_start_time && inv_entity.getArmID_A() == 5 && spawn_flag){
					inv_entity.setArmID_A(6);
					scenario_base.sendmessage(world, inv_entity.posX, inv_entity.posY, inv_entity.posZ, 80, "BOSS COMMING!", true);
					//flagtimer = 0;
					inv_entity.setHealth(inv_entity.getMaxHealth());
					
					for(int c = 0; c < 3;++c){//for
						int xx = 0;
						int zz = 0;
						if(c == 1) {
							xx = -20;
							zz = 20;
						}
						if(c == 2) {
							xx = -20;
							zz = -20;
						}
						{
							for(int mm = 0; mm < 36; ++mm) {
								spawn_g(inv_entity, scenario_base, world, mm, range_x, range_z, xx, zz);
							}
						}
						spawn_tank(inv_entity, scenario_base, world, 5, range_x, range_z, xx, zz);
					}//for
					if (!world.isRemote) {
						EntityGVCR2_BOSS_RATTE entityskeleton = new EntityGVCR2_BOSS_RATTE(world);
						entityskeleton.setcanDespawn(1);
						entityskeleton.setAIType(1);
						entityskeleton.setMoveT(1);
						entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
						entityskeleton.setMoveY((int)inv_entity.posY);
						entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
						double x_pos = inv_entity.posX + range_x + 0 +scenario_base.random_int(world, 24);
						double y_pos = inv_entity.posY + 2;
						double z_pos = inv_entity.posZ + range_z  + 0 +scenario_base.random_int(world, 24);
						entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
						world.spawnEntity(entityskeleton);
					}
				}//WAVE5
	}
	
	public void spawn_g(EntityGVCR2_INV_SCENARIO inv_entity, INV_SCENARIO scenario_base, World world, int mm, int range_x, int range_z, int xx, int zz) {
		if (!world.isRemote) {
			EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
			if(mm == 0) {
				entityskeleton.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_PICKAXE));
			}else {
				entityskeleton.setWeapon_inv(false);
			}
			entityskeleton.setcanDespawn(1);
			entityskeleton.setMoveT(1);
			entityskeleton.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
			entityskeleton.setMoveY((int)inv_entity.posY);
			entityskeleton.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
			double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 24);
			double y_pos = inv_entity.posY + 2;
			double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 24);
			entityskeleton.setLocationAndAngles(x_pos, y_pos, z_pos, -90F, 0F);
			world.spawnEntity(entityskeleton);
		}
	}
	
	public void spawn_car(EntityGVCR2_INV_SCENARIO inv_entity, INV_SCENARIO scenario_base, World world, int id, int range_x, int range_z, int xx, int zz) {
		if (!world.isRemote) {
			EntityGVCR2_CAR_Technical car = new EntityGVCR2_CAR_Technical(world);
			car.setArmID_L(id);
			car.setcanDespawn(1);
			car.setMoveT(1);
			car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
			car.setMoveY((int)inv_entity.posY);
			car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
			double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 15);
			double y_pos = inv_entity.posY + 2;
			double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 15);
			double d5 = inv_entity.posX - x_pos;
			double d7 = inv_entity.posZ - z_pos;
			float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
			car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
			world.spawnEntity(car);
			
			if(car != null) {
				for(int mm = 0; mm < car.riddng_maximum; ++mm) {
					EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
					entityskeleton.setWeapon_inv(false);
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
	
	public void spawn_btr(EntityGVCR2_INV_SCENARIO inv_entity, INV_SCENARIO scenario_base, World world, int id, int range_x, int range_z, int xx, int zz) {
		if (!world.isRemote) {
			//EntityGVCR2_APC_BTR60 car = new EntityGVCR2_APC_BTR60(world);
			EntityMobVehicleBase car;
			if(id == 1) {
				car = new EntityGVCR2_APC_BMP3(world);
			}else {
				car = new EntityGVCR2_APC_BTR60(world);
			}
			car.setArmID_L(0);
			car.setcanDespawn(1);
			car.setMoveT(1);
			car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
			car.setMoveY((int)inv_entity.posY);
			car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
			double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 15);
			double y_pos = inv_entity.posY + 2;
			double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 15);
			double d5 = inv_entity.posX - x_pos;
			double d7 = inv_entity.posZ - z_pos;
			float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
			car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
			world.spawnEntity(car);
			
			if(car != null) {
				for(int mm = 0; mm < car.riddng_maximum; ++mm) {
					EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
					entityskeleton.setWeapon_inv(false);
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
	
	public void spawn_tank(EntityGVCR2_INV_SCENARIO inv_entity, INV_SCENARIO scenario_base, World world, int id, int range_x, int range_z, int xx, int zz) {
		if (!world.isRemote) {
			EntityMobVehicleBase car;
			if(id == 1) {
				car = new EntityGVCR2_TANK_T55(world);
			}else if(id == 2) {
				car = new EntityGVCR2_TANK_T72(world);
			}else if(id == 3) {
				car = new EntityGVCR2_TANK_ZSU_23_4(world);
			}else if(id == 4) {
				car = new EntityGVCR2_TANK_2K22(world);
			}else if(id == 5) {
				car = new EntityGVCR2_TANK_T90(world);
			}else {
				car = new EntityGVCR2_TANK_T34(world);
			}
			car.setArmID_L(0);
			car.setcanDespawn(1);
			car.setMoveT(1);
			car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
			car.setMoveY((int)inv_entity.posY);
			car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
			double x_pos = inv_entity.posX + range_x + xx +scenario_base.random_int(world, 15);
			double y_pos = inv_entity.posY + 2;
			double z_pos = inv_entity.posZ + range_z  + zz +scenario_base.random_int(world, 15);
			double d5 = inv_entity.posX - x_pos;
			double d7 = inv_entity.posZ - z_pos;
			float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
			car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
			world.spawnEntity(car);
			
			if(car != null) {
				for(int mm = 0; mm < car.riddng_maximum; ++mm) {
					EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
					entityskeleton.setWeapon_inv(false);
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
	
	public void spawn_heli(EntityGVCR2_INV_SCENARIO inv_entity, INV_SCENARIO scenario_base, World world, int id, int range_x, int range_z, int xx, int zz) {
		if (!world.isRemote) {
			EntityMobVehicleBase car;
			if(id == 1) {
				car = new EntityGVCR2_HELI_MI24D(world);
			}else if(id == 2) {
				car = new EntityGVCR2_HELI_KA50(world);
			}else {
				car = new EntityGVCR2_HELI_R22(world);
			}
			car.setArmID_L(0);
			car.setcanDespawn(1);
			car.setMoveT(1);
			car.setMoveX((int)inv_entity.posX + scenario_base.random_int(world, 15));
			car.setMoveY((int)inv_entity.posY);
			car.setMoveZ((int)inv_entity.posZ + scenario_base.random_int(world, 15));
			double x_pos = inv_entity.posX + range_x + 0 +scenario_base.random_int(world, 15);
			double y_pos = inv_entity.posY + 2;
			double z_pos = inv_entity.posZ + range_z  + 0 +scenario_base.random_int(world, 15);
			double d5 = inv_entity.posX - x_pos;
			double d7 = inv_entity.posZ - z_pos;
			float rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
			car.setLocationAndAngles(x_pos, y_pos, z_pos, rote, 0F);
			world.spawnEntity(car);
			
			if(car != null) {
				for(int mm = 0; mm < car.riddng_maximum; ++mm) {
					EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
					entityskeleton.setWeapon_inv(false);
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
	
}
package gvcr2.entity.inv;

import gvclib.entity.living.EntityMobVehicleBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.boss.EntityGVCR2_BOSS_RATTE;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.mob.EntityGVCR2_GE_SV;
import gvcr2.entity.vehicle.apc.EntityGVCR2_APC_BMP3;
import gvcr2.entity.vehicle.apc.EntityGVCR2_APC_BTR60;
import gvcr2.entity.vehicle.car.EntityGVCR2_CAR_Technical;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_KA50;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_MI24D;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_R22;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_2K22;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T34;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T55;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T72;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T90;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_ZSU_23_4;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class INV_SCENARIO_infantry_1 {

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
		
		//WAVE2
		wave2(inv_entity, scenario_base, spawn_start_time, spawn_flag, range_x, range_z);
		
		//WAVE3
		wave3(inv_entity, scenario_base, spawn_start_time, spawn_flag, range_x, range_z);
		
		//WAVE4
		wave4(inv_entity, scenario_base, spawn_start_time, spawn_flag, range_x, range_z);
				
		//WAVE5
		wave5(inv_entity, scenario_base, spawn_start_time, spawn_flag, range_x, range_z);
		
		
		//WAVE_CLEAR
				if(inv_entity.getHealth() < spawn_start_time && inv_entity.getArmID_A() == 5 && spawn_flag){
					scenario_base.sendmessage(world, inv_entity.posX, inv_entity.posY, inv_entity.posZ, 80, "Misson Clear!", true);
					if(!world.isRemote) {
						{
							world.setBlockState(new BlockPos(inv_entity.getMoveX(), inv_entity.getMoveY(), inv_entity.getMoveZ()), Blocks.CHEST.getDefaultState(), 2);
							TileEntityChest Chest3;
							Chest3 = (TileEntityChest) world.getTileEntity(new BlockPos(inv_entity.getMoveX(), inv_entity.getMoveY(), inv_entity.getMoveZ()));
							Chest3.setInventorySlotContents(13, new ItemStack(mod_GVCR2.gvcr2_item_inv_infantry_1, 1, 0));
							
							Chest3.setInventorySlotContents(4, new ItemStack(Blocks.DIAMOND_BLOCK, 2, 0));
							Chest3.setInventorySlotContents(12, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
							Chest3.setInventorySlotContents(14, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
							Chest3.setInventorySlotContents(22, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
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
							for(int mm = 0; mm < 12; ++mm) {
								spawn_g(inv_entity, scenario_base, world, mm, range_x, range_z, xx, zz);
							}
						}
						{
							for(int mm = 0; mm < 4; ++mm) {
								spawn_gv(inv_entity, scenario_base, world, mm, range_x, range_z, xx, zz);
							}
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
							for(int mm = 0; mm < 12; ++mm) {
								spawn_g(inv_entity, scenario_base, world, mm, range_x, range_z, xx, zz);
							}
						}
						{
							for(int mm = 0; mm < 4; ++mm) {
								spawn_gv(inv_entity, scenario_base, world, mm, range_x, range_z, xx, zz);
							}
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
									for(int mm = 0; mm < 18; ++mm) {
										spawn_g(inv_entity, scenario_base, world, mm, range_x, range_z, xx, zz);
									}
								}
								{
									for(int mm = 0; mm < 6; ++mm) {
										spawn_gv(inv_entity, scenario_base, world, mm, range_x, range_z, xx, zz);
									}
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
							for(int mm = 0; mm < 18; ++mm) {
								spawn_g(inv_entity, scenario_base, world, mm, range_x, range_z, xx, zz);
							}
						}
						{
							for(int mm = 0; mm < 6; ++mm) {
								spawn_gv(inv_entity, scenario_base, world, mm, range_x, range_z, xx, zz);
							}
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
							for(int mm = 0; mm < 24; ++mm) {
								spawn_g(inv_entity, scenario_base, world, mm, range_x, range_z, xx, zz);
							}
						}
						{
							for(int mm = 0; mm < 8; ++mm) {
								spawn_gv(inv_entity, scenario_base, world, mm, range_x, range_z, xx, zz);
							}
						}
					}//for
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
	
	public void spawn_gv(EntityGVCR2_INV_SCENARIO inv_entity, INV_SCENARIO scenario_base, World world, int mm, int range_x, int range_z, int xx, int zz) {
		if (!world.isRemote) {
			EntityGVCR2_GE_SV entityskeleton = new EntityGVCR2_GE_SV(world);
			entityskeleton.setWeaponID_Spawn(world.rand.nextInt(6), true);
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
	
	
}
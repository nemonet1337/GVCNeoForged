package gvcr2.block.tile;

import java.util.List;

import javax.annotation.Nullable;

import gvcr2.mod_GVCR2;
import gvcr2.entity.mob.EntityGVCR2_GE_Jamming;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.mob.EntityGVCR2_GE_SE_ASSAULT;
import gvcr2.entity.mob.EntityGVCR2_GE_SE_CERBERUS;
import gvcr2.entity.mob.EntityGVCR2_GE_SE_HACS;
import gvcr2.entity.mob.EntityGVCR2_GE_SE_KUKRI;
import gvcr2.entity.mob.EntityGVCR2_GE_SV;
import gvcr2.entity.mob.EntityGVCR2_GE_S_MR_CPT;
import gvcr2.entity.npc.EntityGVCR2_NPC_ARMSTRADER;
import gvcr2.entity.so.EntityGVCR2_SO_S;
import gvcr2.entity.so.EntityGVCR2_SO_S_AF_CPT;
import gvcr2.entity.so.EntityGVCR2_SO_S_MR_CPT;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_A4;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_YAK23KAI;
import gvcr2.entity.vehicle.apc.EntityGVCR2_APC_9K35;
import gvcr2.entity.vehicle.apc.EntityGVCR2_APC_M1097;
import gvcr2.entity.vehicle.apc.EntityGVCR2_APC_M113;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_AH1S;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_GHELI;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_MI24D;
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
import gvcr2.entity.vehicle.ship.EntityGVCR2_SHIP_CRUISER;
import gvcr2.entity.vehicle.ship.EntityGVCR2_SHIP_PR1204;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_2K22;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_KV2;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_M60A1;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T34;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T72;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityBlockSpawn_ONE extends TileEntity implements ITickable
{
	public boolean spawn = false;
    
	@SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared()
    {
        return 65536.0D;
    }
	
    @Override
	public void update() {
    	Block block = this.world.getBlockState(this.pos).getBlock();
        
        int x = this.pos.getX();
        int y= this.pos.getY();
        int z = this.pos.getZ();
        
        boolean vehicle_lock = false;
        
        boolean on_so = false;
        boolean on_ge = false;
        
        if(!mod_GVCR2.cfg_building_dungeon_spawner) {
        	if(!this.world.isRemote){
            	this.world.setBlockToAir(pos);
            }
        }
        
        
        if(this.world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == mod_GVCR2.gvcr2_block_so_s) {
        	on_so = true;
        }
        if(this.world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == mod_GVCR2.gvcr2_block_ge_s) {
        	on_ge = true;
        }
        
        
        if(this.world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Blocks.GLOWSTONE) {
        	this.canspawn(x, y, z, 20);
        	
        }
        else  if(this.world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Blocks.GOLD_BLOCK) {
        	vehicle_lock = true;
        	this.canspawn(x, y, z, 80);
        }
        else  if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_so_s_mr_cpt) {
        	this.canspawn_long(x, y, z, 100);
        }
        else  if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_so_s_af_cpt) {
        	this.canspawn_long(x, y, z, 100);
        }
        else {
        	this.canspawn(x, y, z, 80);
        }
        
        double xxx = this.pos.getX() + 0.5D;
        double yyy = this.pos.getY();
    	double zzz = this.pos.getZ() + 0.5D;
        
        if(spawn && !this.world.isRemote){
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_ge_s) {
        		EntityGVCR2_GE_S mob = new EntityGVCR2_GE_S(this.world);
        		mob.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
				mob.setcanDespawn(1);
				mob.setWeapon(true);
				
				this.setArmy(mob);
				this.world.spawnEntity(mob);
				mob.reload1 = 200;
				mob.setRemain_L(200);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_ge_sv) {
        		EntityGVCR2_GE_SV mob = new EntityGVCR2_GE_SV(this.world);
        		mob.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
				mob.setcanDespawn(1);
				mob.setWeaponID(0);
				this.setArmy(mob);
				this.world.spawnEntity(mob);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_ge_sv_fire) {
        		EntityGVCR2_GE_SV mob = new EntityGVCR2_GE_SV(this.world);
        		mob.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
				mob.setcanDespawn(1);
				mob.setWeaponID(1);
				this.setArmy(mob);
				this.world.spawnEntity(mob);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_ge_sv_trench) {
        		EntityGVCR2_GE_SV mob = new EntityGVCR2_GE_SV(this.world);
        		mob.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
				mob.setcanDespawn(1);
				mob.setWeaponID(3);
				this.setArmy(mob);
				this.world.spawnEntity(mob);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_ge_sv_antitank) {
        		EntityGVCR2_GE_SV mob = new EntityGVCR2_GE_SV(this.world);
        		mob.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
				mob.setcanDespawn(1);
				mob.setWeaponID_Spawn(2, true);
				this.setArmy(mob);
				this.world.spawnEntity(mob);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_ge_sv_sniper) {
        		EntityGVCR2_GE_SV mob = new EntityGVCR2_GE_SV(this.world);
        		mob.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
				mob.setcanDespawn(1);
				mob.setWeaponID(4);
				this.setArmy(mob);
				this.world.spawnEntity(mob);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_ge_sv_drone) {
        		EntityGVCR2_GE_SV mob = new EntityGVCR2_GE_SV(this.world);
        		mob.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
				mob.setcanDespawn(1);
				mob.setWeaponID_Spawn(5, true);
				this.setArmy(mob);
				this.world.spawnEntity(mob);
        	}
        	
        	
        	
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_ge_se_assault) {
        		EntityGVCR2_GE_SE_ASSAULT mob = new EntityGVCR2_GE_SE_ASSAULT(this.world);
        		mob.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
				mob.setcanDespawn(1);
				mob.setWeapon();
				this.setArmy(mob);
				this.world.spawnEntity(mob);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_ge_se_cerberus) {
        		EntityGVCR2_GE_SE_CERBERUS mob = new EntityGVCR2_GE_SE_CERBERUS(this.world);
        		mob.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
				mob.setcanDespawn(1);
				mob.setWeapon();
				this.setArmy(mob);
				this.world.spawnEntity(mob);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_ge_se_hacs) {
        		EntityGVCR2_GE_SE_HACS mob = new EntityGVCR2_GE_SE_HACS(this.world);
        		mob.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
				mob.setcanDespawn(1);
				mob.setWeapon();
				this.setArmy(mob);
				this.world.spawnEntity(mob);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_ge_se_kukri) {
        		EntityGVCR2_GE_SE_KUKRI mob = new EntityGVCR2_GE_SE_KUKRI(this.world);
        		mob.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
				mob.setcanDespawn(1);
				mob.setWeapon();
				this.setArmy(mob);
				this.world.spawnEntity(mob);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_ge_s_mr_cpt) {
        		EntityGVCR2_GE_S_MR_CPT mob = new EntityGVCR2_GE_S_MR_CPT(this.world);
        		mob.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
				mob.setcanDespawn(1);
				//mob.setWeapon();
				this.setArmy(mob);
				this.world.spawnEntity(mob);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_cv_jamming) {
        		EntityGVCR2_GE_Jamming mob = new EntityGVCR2_GE_Jamming(this.world);
        		mob.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
				mob.setcanDespawn(1);
				this.world.spawnEntity(mob);
        	}
        	
        	
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_so_s) {
        		EntityGVCR2_SO_S mob = new EntityGVCR2_SO_S(this.world);
        		mob.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
				mob.setcanDespawn(1);
				mob.setWeapon();
				mob.reload1 = 200;
				this.setArmy(mob);
				this.world.spawnEntity(mob);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_so_s_mr_cpt) {
        		EntityGVCR2_SO_S_MR_CPT mob = new EntityGVCR2_SO_S_MR_CPT(this.world);
        		mob.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
				mob.setcanDespawn(1);
				mob.setWeapon();
				this.setArmy(mob);
				this.world.spawnEntity(mob);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_so_s_af_cpt) {
        		EntityGVCR2_SO_S_AF_CPT mob = new EntityGVCR2_SO_S_AF_CPT(this.world);
        		mob.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
				mob.setcanDespawn(1);
				mob.setWeapon();
				this.setArmy(mob);
				this.world.spawnEntity(mob);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_npc_arms_trader) {
        		EntityGVCR2_NPC_ARMSTRADER mob = new EntityGVCR2_NPC_ARMSTRADER(this.world);
        		mob.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
				mob.setcanDespawn(1);
				this.world.spawnEntity(mob);
        	}
        	
        	
        	 float xx = this.pos.getX();
         	float yy = this.pos.getY();
         	float zz = this.pos.getZ();
        	
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_set_mg_m60) {
        		EntityGVCR2_SET_MG_M60 mob = new EntityGVCR2_SET_MG_M60(this.world);
				mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				/*mob.setPositionX((float)xx);
				mob.setPositionY((float)yy);
				mob.setPositionZ((float)zz);*/
				mob.setMoveX((int)xx);
				mob.setMoveY((int)yy);
				mob.setMoveZ((int)zz);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_ge) {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_set_mg_m2) {
        		EntityGVCR2_SET_MG_M2 mob = new EntityGVCR2_SET_MG_M2(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				mob.setMoveX((int)xx);
				mob.setMoveY((int)yy);
				mob.setMoveZ((int)zz);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_ge) {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_set_mg_pkm) {
        		EntityGVCR2_SET_MG_PKM mob = new EntityGVCR2_SET_MG_PKM(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				mob.setMoveX((int)xx);
				mob.setMoveY((int)yy);
				mob.setMoveZ((int)zz);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_so) {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_set_mg_dp28) {
        		EntityGVCR2_SET_MG_DP28 mob = new EntityGVCR2_SET_MG_DP28(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				mob.setMoveX((int)xx);
				mob.setMoveY((int)yy);
				mob.setMoveZ((int)zz);
				this.world.spawnEntity(mob);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_set_aa_20mmaa) {
        		EntityGVCR2_SET_AA_20mmAA mob = new EntityGVCR2_SET_AA_20mmAA(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				mob.setMoveX((int)xx);
				mob.setMoveY((int)yy);
				mob.setMoveZ((int)zz);
				this.world.spawnEntity(mob);
				/*{
					EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
	        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
					mob2.setcanDespawn(1);
					this.world.spawnEntity(mob2);
					mob2.startRiding(mob);
				}*/
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_set_aa_vads) {
        		EntityGVCR2_SET_AA_VADS mob = new EntityGVCR2_SET_AA_VADS(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				mob.setMoveX((int)xx);
				mob.setMoveY((int)yy);
				mob.setMoveZ((int)zz);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_ge) {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_set_aa_zu23) {
        		EntityGVCR2_SET_AA_Zu23 mob = new EntityGVCR2_SET_AA_Zu23(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				mob.setMoveX((int)xx);
				mob.setMoveY((int)yy);
				mob.setMoveZ((int)zz);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
	        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
					mob2.setcanDespawn(1);
					this.world.spawnEntity(mob2);
					mob2.startRiding(mob);
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_set_mg_pak40) {
        		EntityGVCR2_SET_CANNON_Pak40 mob = new EntityGVCR2_SET_CANNON_Pak40(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				mob.setMoveX((int)xx);
				mob.setMoveY((int)yy);
				mob.setMoveZ((int)zz);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_so) {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_set_mg_flak18) {
        		EntityGVCR2_SET_CANNON_Flak18 mob = new EntityGVCR2_SET_CANNON_Flak18(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				mob.setMoveX((int)xx);
				mob.setMoveY((int)yy);
				mob.setMoveZ((int)zz);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
	        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
					mob2.setcanDespawn(1);
					this.world.spawnEntity(mob2);
					mob2.startRiding(mob);
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_set_mg_tow2) {
        		EntityGVCR2_SET_CANNON_TOW2 mob = new EntityGVCR2_SET_CANNON_TOW2(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				mob.setMoveX((int)xx);
				mob.setMoveY((int)yy);
				mob.setMoveZ((int)zz);
				this.world.spawnEntity(mob);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_set_mg_m224) {
        		EntityGVCR2_SET_MORTAR_M224 mob = new EntityGVCR2_SET_MORTAR_M224(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				mob.setMoveX((int)xx);
				mob.setMoveY((int)yy);
				mob.setMoveZ((int)zz);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_so) {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_set_mg_fh18) {
        		EntityGVCR2_SET_MORTAR_FH18 mob = new EntityGVCR2_SET_MORTAR_FH18(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				mob.setMoveX((int)xx);
				mob.setMoveY((int)yy);
				mob.setMoveZ((int)zz);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_so) {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_set_mg_ak130) {
        		EntityGVCR2_SET_CANNON_AK130 mob = new EntityGVCR2_SET_CANNON_AK130(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				mob.setMoveX((int)xx);
				mob.setMoveY((int)yy);
				mob.setMoveZ((int)zz);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_so) {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_set_mk15_phalanx) {
        		EntityGVCR2_SET_AA_Mk15 mob = new EntityGVCR2_SET_AA_Mk15(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				mob.setMoveX((int)xx);
				mob.setMoveY((int)yy);
				mob.setMoveZ((int)zz);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_ge) {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_set_mk45_mod4) {
        		EntityGVCR2_SET_CANNON_Mk45 mob = new EntityGVCR2_SET_CANNON_Mk45(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				mob.setMoveX((int)xx);
				mob.setMoveY((int)yy);
				mob.setMoveZ((int)zz);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_ge) {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_tank_t34) {
        		EntityGVCR2_TANK_T34 mob = new EntityGVCR2_TANK_T34(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_so) {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_tank_t72) {
        		EntityGVCR2_TANK_T72 mob = new EntityGVCR2_TANK_T72(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_so) {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_tank_kv2) {
        		EntityGVCR2_TANK_KV2 mob = new EntityGVCR2_TANK_KV2(this.world);
				mob.setLocationAndAngles(this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D,
						0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_so) {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_heli_g_heli) {
        		EntityGVCR2_HELI_GHELI mob = new EntityGVCR2_HELI_GHELI(this.world);
				mob.setLocationAndAngles(this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D,
						0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				this.world.spawnEntity(mob);
				for(int ka = 0; ka < 4; ++ka){
					if(on_so) {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_heli_mi24d) {
        		EntityGVCR2_HELI_MI24D mob = new EntityGVCR2_HELI_MI24D(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 180, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock) {
					mob.setVehicleLock(true);
				}else {
					/*mob.setMoveT(1);
					mob.setMoveX((int)xx);
					mob.setMoveY((int)yy);
					mob.setMoveZ((int)zz);*/
				}
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_so) {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 180, 0.0F);
						mob2.setcanDespawn(1);
						mob2.setMoveT(1);
						mob2.setMoveX((int)xx);
						mob2.setMoveY((int)yy);
						mob2.setMoveZ((int)zz);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
							EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
							mob2.setLocationAndAngles(xxx, yyy, zzz, 180, 0.0F);
							mob2.setcanDespawn(1);
							mob2.setMoveT(1);
							mob2.setMoveX((int) xx);
							mob2.setMoveY((int) yy);
							mob2.setMoveZ((int) zz);
							this.world.spawnEntity(mob2);
							mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_tank_2k22) {
        		EntityGVCR2_TANK_2K22 mob = new EntityGVCR2_TANK_2K22(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_so) {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_ship_cruiser) {
        		EntityGVCR2_SHIP_CRUISER mob = new EntityGVCR2_SHIP_CRUISER(this.world);
				mob.setLocationAndAngles(this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D,
						0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				this.world.spawnEntity(mob);
				for(int ka = 0; ka < 4; ++ka){
					if(on_so) {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_ship_pr1204) {
        		EntityGVCR2_SHIP_PR1204 mob = new EntityGVCR2_SHIP_PR1204(this.world);
				mob.setLocationAndAngles(this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D,
						0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				this.world.spawnEntity(mob);
				{
					if(on_so) {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_apc_9k35) {
        		EntityGVCR2_APC_9K35 mob = new EntityGVCR2_APC_9K35(this.world);
				mob.setLocationAndAngles(this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D,
						0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				this.world.spawnEntity(mob);
				{
					if(on_so) {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_apc_m1097) {
        		EntityGVCR2_APC_M1097 mob = new EntityGVCR2_APC_M1097(this.world);
				mob.setLocationAndAngles(this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D,
						0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_ge) {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_apc_m113) {
        		EntityGVCR2_APC_M113 mob = new EntityGVCR2_APC_M113(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
	        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
					mob2.setcanDespawn(1);
					this.world.spawnEntity(mob2);
					mob2.startRiding(mob);
				}
				if(!vehicle_lock){
					EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
	        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
					mob2.setcanDespawn(1);
					this.world.spawnEntity(mob2);
					mob2.startRiding(mob);
				}
				if(!vehicle_lock){
					EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
	        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
					mob2.setcanDespawn(1);
					this.world.spawnEntity(mob2);
					mob2.startRiding(mob);
				}
				if(!vehicle_lock){
					EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
	        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
					mob2.setcanDespawn(1);
					this.world.spawnEntity(mob2);
					mob2.startRiding(mob);
				}
				if(!vehicle_lock){
					EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
	        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
					mob2.setcanDespawn(1);
					this.world.spawnEntity(mob2);
					mob2.startRiding(mob);
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_tank_m60a1) {
        		EntityGVCR2_TANK_M60A1 mob = new EntityGVCR2_TANK_M60A1(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock)mob.setVehicleLock(true);
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_ge) {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
						mob2.setcanDespawn(1);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_heli_ah1s) {
        		EntityGVCR2_HELI_AH1S mob = new EntityGVCR2_HELI_AH1S(this.world);
        		mob.setLocationAndAngles(xx, yy, zz, 180, 0.0F);
				mob.setcanDespawn(1);
				if(vehicle_lock) {
					mob.setVehicleLock(true);
				}else {
					/*mob.setMoveT(1);
					mob.setMoveX((int)xx);
					mob.setMoveY((int)yy);
					mob.setMoveZ((int)zz);*/
				}
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_ge) {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 180, 0.0F);
						mob2.setcanDespawn(1);
						mob2.setMoveT(1);
						mob2.setMoveX((int)xx);
						mob2.setMoveY((int)yy);
						mob2.setMoveZ((int)zz);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 180, 0.0F);
						mob2.setcanDespawn(1);
						mob2.setMoveT(1);
						mob2.setMoveX((int)xx);
						mob2.setMoveY((int)yy);
						mob2.setMoveZ((int)zz);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_air_a4) {
        		EntityGVCR2_AIR_A4 mob = new EntityGVCR2_AIR_A4(this.world);
				mob.setcanDespawn(1);
				if(vehicle_lock) {
					mob.setVehicleLock(true);
					mob.setLocationAndAngles(xx, yy + 0, zz, 180, 0.0F);
				}else {
					mob.setLocationAndAngles(xx, yy + 0, zz, 90, 0.0F);
					mob.thpower = mob.thmax;
					mob.throttle = mob.thmax;
					/*mob.setMoveT(1);
					mob.setMoveX((int)xx);
					mob.setMoveY((int)yy);
					mob.setMoveZ((int)zz);*/
				}
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_ge) {
						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy + 0, zzz, 180, 0.0F);
						mob2.setcanDespawn(1);
						mob2.setMoveT(1);
						mob2.setMoveX((int)xx);
						mob2.setMoveY((int)yy);
						mob2.setMoveZ((int)zz);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy + 0, zzz, 180, 0.0F);
						mob2.setcanDespawn(1);
						mob2.setMoveT(1);
						mob2.setMoveX((int)xx);
						mob2.setMoveY((int)yy);
						mob2.setMoveZ((int)zz);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}
				}
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_air_yak23kai) {
        		EntityGVCR2_AIR_YAK23KAI mob = new EntityGVCR2_AIR_YAK23KAI(this.world);
				mob.setcanDespawn(1);
				if(vehicle_lock) {
					mob.setVehicleLock(true);
					mob.setLocationAndAngles(xx, yy + 0, zz, 180, 0.0F);
				}else {
					mob.setLocationAndAngles(xx, yy + 0, zz, 90, 0.0F);
					mob.thpower = mob.thmax;
					mob.throttle = mob.thmax;
					/*mob.setMoveT(1);
					mob.setMoveX((int)xx);
					mob.setMoveY((int)yy);
					mob.setMoveZ((int)zz);*/
				}
				this.world.spawnEntity(mob);
				if(!vehicle_lock){
					if(on_so) {
						EntityGVCR2_SO_S mob2 = new EntityGVCR2_SO_S(this.world);
		        		mob2.setLocationAndAngles(xxx, yyy, zzz, 180, 0.0F);
						mob2.setcanDespawn(1);
						mob2.setMoveT(1);
						mob2.setMoveX((int)xx);
						mob2.setMoveY((int)yy);
						mob2.setMoveZ((int)zz);
						this.world.spawnEntity(mob2);
						mob2.startRiding(mob);
					}else {
							EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
							mob2.setLocationAndAngles(xxx, yyy, zzz, 180, 0.0F);
							mob2.setcanDespawn(1);
							mob2.setMoveT(1);
							mob2.setMoveX((int) xx);
							mob2.setMoveY((int) yy);
							mob2.setMoveZ((int) zz);
							this.world.spawnEntity(mob2);
							mob2.startRiding(mob);
					}
				}
        	}
        	/*if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR.b_spawner_one_g_boat) {
        		EntityG_Boat entityskeleton = new EntityG_Boat(this.world);
				entityskeleton.setLocationAndAngles(this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D,
						0, 0.0F);
				entityskeleton.setcanDespawn(1);
				this.world.spawnEntity(entityskeleton);
				EntityG_S entityskeleton1 = new EntityG_S(this.world);
				entityskeleton1.setLocationAndAngles(this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D,
						0, 0.0F);
				
				entityskeleton1.setcanDespawn(1);
				this.world.spawnEntity(entityskeleton1);
				entityskeleton1.startRiding(entityskeleton);
        	}*/
        	if(!this.world.isRemote){
            	//this.world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 2);
            	this.world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 2);
            	this.world.setBlockToAir(pos);
            }
        }
        
        
        
    }
        
    
    private void setArmy(EntityLivingBase ent) {
    	int x = this.pos.getX();
        int y= this.pos.getY();
        int z = this.pos.getZ();
        if(this.world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Blocks.CHEST) {
        	TileEntityChest chest = (TileEntityChest)this.world.getTileEntity(new BlockPos(x, y + 1, z));
        	if(!chest.isEmpty()) {
        		ItemStack main = chest.getStackInSlot(0);
        		ItemStack off = chest.getStackInSlot(1);
        		ItemStack head = chest.getStackInSlot(2);
        		ItemStack pret = chest.getStackInSlot(3);
        		ItemStack leggins = chest.getStackInSlot(4);
        		ItemStack boots = chest.getStackInSlot(5);
        		if(!main.isEmpty())ent.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, main);
        		if(!off.isEmpty())ent.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, off);
        		if(!head.isEmpty())ent.setItemStackToSlot(EntityEquipmentSlot.HEAD, head);
        		if(!pret.isEmpty())ent.setItemStackToSlot(EntityEquipmentSlot.CHEST, pret);
        		if(!leggins.isEmpty())ent.setItemStackToSlot(EntityEquipmentSlot.LEGS, leggins);
        		if(!boots.isEmpty())ent.setItemStackToSlot(EntityEquipmentSlot.FEET, boots);
        		for(int ii = 0; ii < 27; ++ii) {
        			chest.setInventorySlotContents(ii, new ItemStack((Item)null));
        		}
        	}
        	
        }
    }
    
        
        public void canspawn(double x, double y, double z, int han) {
        	Entity entity = null;
        	AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(x-han), (double)(y-han), (double)(z-han), 
        			(double)(x + han), (double)(y + han), (double)(z+ han)))
            		.grow(1);
            List llist2 = this.world.getEntitiesWithinAABBExcludingEntity(entity, axisalignedbb2);
            if(llist2!=null){
                for (int lj = 0; lj < llist2.size(); lj++) {
                	
                	Entity entity1 = (Entity)llist2.get(lj);
                	if (entity1.canBeCollidedWith())
                    {
                		if (entity1 instanceof EntityPlayer && entity1 != null)
                        {
                			EntityPlayer ss = (EntityPlayer) entity1;
                			ItemStack itemstack = ss.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
                    		if(!itemstack.isEmpty() && itemstack.getItem() == Items.GOLDEN_HELMET){
                    		}else {
                    			/*if(this.world.rayTraceBlocks(new Vec3d(this.pos.getX()+0.2, this.pos.getY()+0.2, this.pos.getZ()+0.2), 
                    					new Vec3d(entity1.posX, entity1.posY + (double)entity1.getEyeHeight(), entity1.posZ), false, true, false) == null) */
                    			double d5 = entity1.posX - this.pos.getX();
								double d7 = entity1.posZ - this.pos.getZ();
								double ddx = Math.abs(d5);
								double ddz = Math.abs(d7);
								if ((ddx < 5 && ddz < 5)) {
									spawn = true;
									break;
								}
                    			if(rayTraceBlocks(new Vec3d(this.pos.getX() + 0.1, this.pos.getY() + 0.85, this.pos.getZ() + 0.1), 
                    					new Vec3d(entity1.posX, entity1.posY + (double)entity1.getEyeHeight(), entity1.posZ), false, true, false) == null) 
                    			{
                    				spawn = true;
                    			}
                    			if(rayTraceBlocks(new Vec3d(this.pos.getX() + 0.1, this.pos.getY() + 1.85, this.pos.getZ() + 0.1), 
                    					new Vec3d(entity1.posX, entity1.posY + (double)entity1.getEyeHeight(), entity1.posZ), false, true, false) == null) 
                    			{
                    				spawn = true;
                    			}
                    		}
                        }
                    }
                }
            }
        }
        
        public void canspawn_long(double x, double y, double z, int han) {
        	Entity entity = null;
        	AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(x-han), (double)(y-han), (double)(z-han), 
        			(double)(x + han), (double)(y + han), (double)(z+ han)))
            		.grow(1);
            List llist2 = this.world.getEntitiesWithinAABBExcludingEntity(entity, axisalignedbb2);
            if(llist2!=null){
                for (int lj = 0; lj < llist2.size(); lj++) {
                	
                	Entity entity1 = (Entity)llist2.get(lj);
                	if (entity1.canBeCollidedWith())
                    {
                		if (entity1 instanceof EntityPlayer && entity1 != null)
                        {
                			EntityPlayer ss = (EntityPlayer) entity1;
                			ItemStack itemstack = ss.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
                    		if(!itemstack.isEmpty() && itemstack.getItem() == Items.GOLDEN_HELMET){
                    		}else {
                    			spawn = true;
								break;
                    		}
                        }
                    }
                }
            }
        }
        
        
        /**
         * Performs a raycast against all blocks in the world. Args : Vec1, Vec2, stopOnLiquid,
         * ignoreBlockWithoutBoundingBox, returnLastUncollidableBlock
         */
        @Nullable
        public RayTraceResult rayTraceBlocks(Vec3d vec31, Vec3d vec32, boolean stopOnLiquid, boolean ignoreBlockWithoutBoundingBox, boolean returnLastUncollidableBlock)
        {
            if (!Double.isNaN(vec31.x) && !Double.isNaN(vec31.y) && !Double.isNaN(vec31.z))
            {
                if (!Double.isNaN(vec32.x) && !Double.isNaN(vec32.y) && !Double.isNaN(vec32.z))
                {
                    int i = MathHelper.floor(vec32.x);
                    int j = MathHelper.floor(vec32.y);
                    int k = MathHelper.floor(vec32.z);
                    int l = MathHelper.floor(vec31.x);
                    int i1 = MathHelper.floor(vec31.y);
                    int j1 = MathHelper.floor(vec31.z);
                    BlockPos blockpos = new BlockPos(l, i1, j1);
                    IBlockState iblockstate = this.world.getBlockState(blockpos);
                    Block block = iblockstate.getBlock();

                    //if ((!ignoreBlockWithoutBoundingBox || iblockstate.getCollisionBoundingBox(this.world, blockpos) != Block.NULL_AABB) && block.canCollideCheck(iblockstate, stopOnLiquid))
                     if ((!ignoreBlockWithoutBoundingBox && block.canCollideCheck(iblockstate, stopOnLiquid)))
                    {
                        RayTraceResult raytraceresult = iblockstate.collisionRayTrace(this.world, blockpos, vec31, vec32);

                        if (raytraceresult != null)
                        {
                            return raytraceresult;
                        }
                    }

                    RayTraceResult raytraceresult2 = null;
                    int k1 = 200;

                    while (k1-- >= 0)
                    {
                        if (Double.isNaN(vec31.x) || Double.isNaN(vec31.y) || Double.isNaN(vec31.z))
                        {
                            return null;
                        }

                        if (l == i && i1 == j && j1 == k)
                        {
                            return returnLastUncollidableBlock ? raytraceresult2 : null;
                        }

                        boolean flag2 = true;
                        boolean flag = true;
                        boolean flag1 = true;
                        double d0 = 999.0D;
                        double d1 = 999.0D;
                        double d2 = 999.0D;

                        if (i > l)
                        {
                            d0 = (double)l + 1.0D;
                        }
                        else if (i < l)
                        {
                            d0 = (double)l + 0.0D;
                        }
                        else
                        {
                            flag2 = false;
                        }

                        if (j > i1)
                        {
                            d1 = (double)i1 + 1.0D;
                        }
                        else if (j < i1)
                        {
                            d1 = (double)i1 + 0.0D;
                        }
                        else
                        {
                            flag = false;
                        }

                        if (k > j1)
                        {
                            d2 = (double)j1 + 1.0D;
                        }
                        else if (k < j1)
                        {
                            d2 = (double)j1 + 0.0D;
                        }
                        else
                        {
                            flag1 = false;
                        }

                        double d3 = 999.0D;
                        double d4 = 999.0D;
                        double d5 = 999.0D;
                        double d6 = vec32.x - vec31.x;
                        double d7 = vec32.y - vec31.y;
                        double d8 = vec32.z - vec31.z;

                        if (flag2)
                        {
                            d3 = (d0 - vec31.x) / d6;
                        }

                        if (flag)
                        {
                            d4 = (d1 - vec31.y) / d7;
                        }

                        if (flag1)
                        {
                            d5 = (d2 - vec31.z) / d8;
                        }

                        if (d3 == -0.0D)
                        {
                            d3 = -1.0E-4D;
                        }

                        if (d4 == -0.0D)
                        {
                            d4 = -1.0E-4D;
                        }

                        if (d5 == -0.0D)
                        {
                            d5 = -1.0E-4D;
                        }

                        EnumFacing enumfacing;

                        if (d3 < d4 && d3 < d5)
                        {
                            enumfacing = i > l ? EnumFacing.WEST : EnumFacing.EAST;
                            vec31 = new Vec3d(d0, vec31.y + d7 * d3, vec31.z + d8 * d3);
                        }
                        else if (d4 < d5)
                        {
                            enumfacing = j > i1 ? EnumFacing.DOWN : EnumFacing.UP;
                            vec31 = new Vec3d(vec31.x + d6 * d4, d1, vec31.z + d8 * d4);
                        }
                        else
                        {
                            enumfacing = k > j1 ? EnumFacing.NORTH : EnumFacing.SOUTH;
                            vec31 = new Vec3d(vec31.x + d6 * d5, vec31.y + d7 * d5, d2);
                        }

                        l = MathHelper.floor(vec31.x) - (enumfacing == EnumFacing.EAST ? 1 : 0);
                        i1 = MathHelper.floor(vec31.y) - (enumfacing == EnumFacing.UP ? 1 : 0);
                        j1 = MathHelper.floor(vec31.z) - (enumfacing == EnumFacing.SOUTH ? 1 : 0);
                        blockpos = new BlockPos(l, i1, j1);
                        IBlockState iblockstate1 = this.world.getBlockState(blockpos);
                        Block block1 = iblockstate1.getBlock();

                        if (!ignoreBlockWithoutBoundingBox || iblockstate1.getMaterial() == Material.PORTAL || iblockstate1.getCollisionBoundingBox(this.world, blockpos) != Block.NULL_AABB)
                      //  if (!ignoreBlockWithoutBoundingBox || iblockstate1.getMaterial() == Material.PORTAL)
                        {
                            if (block1.canCollideCheck(iblockstate1, stopOnLiquid))
                            {
                                RayTraceResult raytraceresult1 = iblockstate1.collisionRayTrace(this.world, blockpos, vec31, vec32);

                                if (raytraceresult1 != null)
                                {
                                    return raytraceresult1;
                                }
                            }
                            else
                            {
                                raytraceresult2 = new RayTraceResult(RayTraceResult.Type.MISS, vec31, enumfacing, blockpos);
                            }
                        }
                    }

                    return returnLastUncollidableBlock ? raytraceresult2 : null;
                }
                else
                {
                    return null;
                }
            }
            else
            {
                return null;
            }
        }
}

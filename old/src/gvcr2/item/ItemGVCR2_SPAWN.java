package gvcr2.item;

import java.util.List;

import javax.annotation.Nullable;

import gvcr2.mod_GVCR2;
import gvcr2.entity.boss.EntityGVCR2_BOSS_AIRSHIP;
import gvcr2.entity.boss.EntityGVCR2_BOSS_AV8B;
import gvcr2.entity.boss.EntityGVCR2_BOSS_CHAR2C;
import gvcr2.entity.boss.EntityGVCR2_BOSS_CV;
import gvcr2.entity.boss.EntityGVCR2_BOSS_HAUNEB;
import gvcr2.entity.boss.EntityGVCR2_BOSS_IRVING;
import gvcr2.entity.boss.EntityGVCR2_BOSS_LONGLEG;
import gvcr2.entity.boss.EntityGVCR2_BOSS_MER08;
import gvcr2.entity.boss.EntityGVCR2_BOSS_MER08_B;
import gvcr2.entity.boss.EntityGVCR2_BOSS_MER08_SN;
import gvcr2.entity.boss.EntityGVCR2_BOSS_RATTE;
import gvcr2.entity.boss.EntityGVCR2_BOSS_ST1;
import gvcr2.entity.boss.EntityGVCR2_BOSS_TB3;
import gvcr2.entity.mob.EntityGVCR2_BOSS_MER03K;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.mob.EntityGVCR2_GE_SE_ASSAULT;
import gvcr2.entity.mob.EntityGVCR2_GE_SE_CERBERUS;
import gvcr2.entity.mob.EntityGVCR2_GE_SE_HACS;
import gvcr2.entity.mob.EntityGVCR2_GE_SE_KUKRI;
import gvcr2.entity.mob.EntityGVCR2_GE_SV;
import gvcr2.entity.mob.EntityGVCR2_GE_S_MR_CPT;
import gvcr2.entity.mob.EntityGVCR2_UNKS_C_S;
import gvcr2.entity.npc.EntityGVCR2_NPC_ARMSTRADER;
import gvcr2.entity.pmc.EntityGVCR2_PMC_S;
import gvcr2.entity.so.EntityGVCR2_GE_POW;
import gvcr2.entity.so.EntityGVCR2_SO_S;
import gvcr2.entity.so.EntityGVCR2_SO_S_MR_CPT;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_A10;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_A4;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_A6;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_AC130;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_AN2;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_AV8B;
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
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemGVCR2_SPAWN extends Item
{
	public int ii;
	
	//public String nameid = null;
	
	public String text1 = null;
	public String text2 = null;
	public String text3 = null;
	public String text4 = null;
	public String text5 = null;
	public String text6 = null;
	
	public int id = 0;
	
    public ItemGVCR2_SPAWN(int i)
    {
        this.maxStackSize = 64;
        this.id = i;
    }

	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (text1 != null) {
			TextComponentTranslation information = new TextComponentTranslation(text1, new Object[0]);
			tooltip.add(TextFormatting.WHITE + information.getFormattedText());// 0
		}
		if (text2 != null) {
			TextComponentTranslation information = new TextComponentTranslation(text2, new Object[0]);
			tooltip.add(TextFormatting.WHITE + information.getFormattedText());// 0
		}
		if (text3 != null) {
			TextComponentTranslation information = new TextComponentTranslation(text3, new Object[0]);
			tooltip.add(TextFormatting.WHITE + information.getFormattedText());// 0
		}
		if (text4 != null) {
			TextComponentTranslation information = new TextComponentTranslation(text4, new Object[0]);
			tooltip.add(TextFormatting.WHITE + information.getFormattedText());// 0
		}
		if (text5 != null) {
			TextComponentTranslation information = new TextComponentTranslation(text5, new Object[0]);
			tooltip.add(TextFormatting.WHITE + information.getFormattedText());// 0
		}
		if (text6 != null) {
			TextComponentTranslation information = new TextComponentTranslation(text6, new Object[0]);
			tooltip.add(TextFormatting.WHITE + information.getFormattedText());// 0
		}
		
	}
    
    public void spawnCreature(World worldIn, EntityPlayer playerIn, double par4, double par5, double par6)
    {

		if (this.id == 0) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_GE_S ent = new EntityGVCR2_GE_S(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon(false);
			worldIn.spawnEntity(ent);
			/*{
				++par5;
				int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
				EntityZombie ent = new EntityZombie(worldIn);
				ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
				ent.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_sks));
				worldIn.spawnEntity(ent);
			}*/
		} 
		else if (this.id == 1) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_GE_SV ent = new EntityGVCR2_GE_SV(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeaponID(0);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 110) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_GE_SV ent = new EntityGVCR2_GE_SV(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeaponID(1);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 111) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_GE_SV ent = new EntityGVCR2_GE_SV(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeaponID(3);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 112) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_GE_SV ent = new EntityGVCR2_GE_SV(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeaponID_Spawn(2, true);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 113) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_GE_SV ent = new EntityGVCR2_GE_SV(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeaponID(4);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 114) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_GE_SV ent = new EntityGVCR2_GE_SV(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeaponID_Spawn(5, true);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 115) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_GE_POW ent = new EntityGVCR2_GE_POW(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 2) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_GE_SE_ASSAULT ent = new EntityGVCR2_GE_SE_ASSAULT(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon();
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 3) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_GE_SE_CERBERUS ent = new EntityGVCR2_GE_SE_CERBERUS(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon();
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 4) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_GE_SE_HACS ent = new EntityGVCR2_GE_SE_HACS(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon();
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 5) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_GE_SE_KUKRI ent = new EntityGVCR2_GE_SE_KUKRI(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon();
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 6) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_GE_S_MR_CPT ent = new EntityGVCR2_GE_S_MR_CPT(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		
		else if (this.id == 15) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_PMC_S ent = new EntityGVCR2_PMC_S(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon();
			ent.setTamedBy(playerIn);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 16) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SO_S ent = new EntityGVCR2_SO_S(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon();
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 14) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SO_S_MR_CPT ent = new EntityGVCR2_SO_S_MR_CPT(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon();
			worldIn.spawnEntity(ent);
		} 
		
		else if (this.id == 17) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SP_REX ent = new EntityGVCR2_SP_REX(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 18) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_NPC_ARMSTRADER ent = new EntityGVCR2_NPC_ARMSTRADER(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 19) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SP_ST1 ent = new EntityGVCR2_SP_ST1(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		
		else if (this.id == 160) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_BOSS_LONGLEG ent = new EntityGVCR2_BOSS_LONGLEG(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon();
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 161) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_BOSS_ST1 ent = new EntityGVCR2_BOSS_ST1(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 162) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_BOSS_MER08 ent = new EntityGVCR2_BOSS_MER08(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 163) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_BOSS_MER08_SN ent = new EntityGVCR2_BOSS_MER08_SN(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 164) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_BOSS_HAUNEB ent = new EntityGVCR2_BOSS_HAUNEB(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 165) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_BOSS_IRVING ent = new EntityGVCR2_BOSS_IRVING(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 166) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_BOSS_CV ent = new EntityGVCR2_BOSS_CV(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 168) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_BOSS_CHAR2C ent = new EntityGVCR2_BOSS_CHAR2C(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 169) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_BOSS_MER08_B ent = new EntityGVCR2_BOSS_MER08_B(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 225) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_BOSS_MER03K ent = new EntityGVCR2_BOSS_MER03K(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		
		else if (this.id == 172) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_BOSS_AV8B ent = new EntityGVCR2_BOSS_AV8B(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 173) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_BOSS_RATTE ent = new EntityGVCR2_BOSS_RATTE(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 174) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_BOSS_TB3 ent = new EntityGVCR2_BOSS_TB3(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		else if (this.id == 175) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_BOSS_AIRSHIP ent = new EntityGVCR2_BOSS_AIRSHIP(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		
		else if (this.id == 220) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_UNKS_C_S ent = new EntityGVCR2_UNKS_C_S(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon(false);
			worldIn.spawnEntity(ent);
		} 
		
		
		
		else if (this.id == 20) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_CAR_Technical ent = new EntityGVCR2_CAR_Technical(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon(0);
			ent.setArmID_L(0);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 2001) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_CAR_Technical ent = new EntityGVCR2_CAR_Technical(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon(1);
			ent.setArmID_L(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 2002) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_CAR_Technical ent = new EntityGVCR2_CAR_Technical(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon(2);
			ent.setArmID_L(2);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 2003) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_CAR_Technical ent = new EntityGVCR2_CAR_Technical(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon(3);
			ent.setArmID_L(3);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 2004) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_CAR_Technical ent = new EntityGVCR2_CAR_Technical(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon(4);
			ent.setArmID_L(4);
			ent.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30D);
			ent.setHealth(30F);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 21) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_CAR_BIKE ent = new EntityGVCR2_CAR_BIKE(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 22) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_CAR_BUGGY ent = new EntityGVCR2_CAR_BUGGY(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 23) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_CAR_HMMWV ent = new EntityGVCR2_CAR_HMMWV(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 24) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_CAR_BULLDOZER ent = new EntityGVCR2_CAR_BULLDOZER(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		
		else if (this.id == 30) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_APC_M113 ent = new EntityGVCR2_APC_M113(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon(0);
			ent.setArmID_L(0);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 31) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_APC_M113 ent = new EntityGVCR2_APC_M113(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon(1);
			ent.setArmID_L(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 32) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_APC_M113 ent = new EntityGVCR2_APC_M113(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon(2);
			ent.setArmID_L(2);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 33) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_APC_M113 ent = new EntityGVCR2_APC_M113(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon(3);
			ent.setArmID_L(3);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 34) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_APC_M1126 ent = new EntityGVCR2_APC_M1126(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon(0);
			ent.setArmID_L(0);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 35) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_APC_M1126 ent = new EntityGVCR2_APC_M1126(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon(1);
			ent.setArmID_L(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 36) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_APC_M1126 ent = new EntityGVCR2_APC_M1126(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon(3);
			ent.setArmID_L(3);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 37) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_APC_LAV25 ent = new EntityGVCR2_APC_LAV25(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon(0);
			ent.setArmID_L(0);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 38) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_APC_LAV25 ent = new EntityGVCR2_APC_LAV25(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			ent.setWeapon(1);
			ent.setArmID_L(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 39) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_APC_BTR60 ent = new EntityGVCR2_APC_BTR60(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 391) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_APC_M1097 ent = new EntityGVCR2_APC_M1097(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 392) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_APC_9K35 ent = new EntityGVCR2_APC_9K35(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 393) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_APC_M270 ent = new EntityGVCR2_APC_M270(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 394) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_APC_BMP3 ent = new EntityGVCR2_APC_BMP3(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		
		
		
		
		else if (this.id == 50) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_TANK_M60A1 ent = new EntityGVCR2_TANK_M60A1(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 51) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_TANK_M1 ent = new EntityGVCR2_TANK_M1(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 52) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_TANK_M41 ent = new EntityGVCR2_TANK_M41(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 53) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_TANK_M551 ent = new EntityGVCR2_TANK_M551(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 54) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_TANK_T34 ent = new EntityGVCR2_TANK_T34(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 55) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_TANK_T55 ent = new EntityGVCR2_TANK_T55(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 56) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_TANK_T72 ent = new EntityGVCR2_TANK_T72(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 57) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_TANK_PT76 ent = new EntityGVCR2_TANK_PT76(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 58) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_TANK_KV2 ent = new EntityGVCR2_TANK_KV2(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 59) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_TANK_FV101 ent = new EntityGVCR2_TANK_FV101(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 60) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_TANK_ZSU_23_4 ent = new EntityGVCR2_TANK_ZSU_23_4(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 61) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_TANK_2K22 ent = new EntityGVCR2_TANK_2K22(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 62) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_TANK_M1A2 ent = new EntityGVCR2_TANK_M1A2(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 63) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_TANK_M41DK1 ent = new EntityGVCR2_TANK_M41DK1(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 64) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_TANK_T90 ent = new EntityGVCR2_TANK_T90(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 65) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_TANK_RATTE ent = new EntityGVCR2_TANK_RATTE(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		
		else if (this.id == 40) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_HELI_AH1S ent = new EntityGVCR2_HELI_AH1S(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 41) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_HELI_AH6 ent = new EntityGVCR2_HELI_AH6(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 42) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_HELI_UH1 ent = new EntityGVCR2_HELI_UH1(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 43) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_HELI_GHELI ent = new EntityGVCR2_HELI_GHELI(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 44) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_HELI_MI24D ent = new EntityGVCR2_HELI_MI24D(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 45) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_HELI_CH47 ent = new EntityGVCR2_HELI_CH47(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 46) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_HELI_UH1Y ent = new EntityGVCR2_HELI_UH1Y(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 47) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_HELI_UH60 ent = new EntityGVCR2_HELI_UH60(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 48) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_HELI_AH1Z ent = new EntityGVCR2_HELI_AH1Z(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 49) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_HELI_KA50 ent = new EntityGVCR2_HELI_KA50(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 140) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_HELI_Z10 ent = new EntityGVCR2_HELI_Z10(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 141) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_HELI_KA60 ent = new EntityGVCR2_HELI_KA60(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 142) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_HELI_R22 ent = new EntityGVCR2_HELI_R22(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		
		
		
		
		
		
		else if (this.id == 100) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_AIR_F16 ent = new EntityGVCR2_AIR_F16(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 101) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_AIR_F18 ent = new EntityGVCR2_AIR_F18(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 102) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_AIR_A10 ent = new EntityGVCR2_AIR_A10(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 103) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_AIR_MIG17 ent = new EntityGVCR2_AIR_MIG17(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 104) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_AIR_LI28 ent = new EntityGVCR2_AIR_LI28(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 105) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_AIR_F117 ent = new EntityGVCR2_AIR_F117(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 106) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_AIR_AC130 ent = new EntityGVCR2_AIR_AC130(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 107) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_AIR_A6 ent = new EntityGVCR2_AIR_A6(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 108) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_AIR_YAK23 ent = new EntityGVCR2_AIR_YAK23(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 109) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_AIR_A4 ent = new EntityGVCR2_AIR_A4(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 1100) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_AIR_YAK23KAI ent = new EntityGVCR2_AIR_YAK23KAI(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 1101) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_AIR_AN2 ent = new EntityGVCR2_AIR_AN2(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 1102) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_AIR_SU27 ent = new EntityGVCR2_AIR_SU27(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 1103) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_AIR_SU25 ent = new EntityGVCR2_AIR_SU25(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 1104) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_AIR_AV8B ent = new EntityGVCR2_AIR_AV8B(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		
		
		else if (this.id == 120) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SHIP_RHIB ent = new EntityGVCR2_SHIP_RHIB(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 121) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SHIP_RCB ent = new EntityGVCR2_SHIP_RCB(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 122) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SHIP_CRUISER ent = new EntityGVCR2_SHIP_CRUISER(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 123) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SHIP_PR1204 ent = new EntityGVCR2_SHIP_PR1204(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 124) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SHIP_HAMINA ent = new EntityGVCR2_SHIP_HAMINA(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 125) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SHIP_AIRSHIP ent = new EntityGVCR2_SHIP_AIRSHIP(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		
		
		
		
		else if (this.id == 70) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SET_MG_M60 ent = new EntityGVCR2_SET_MG_M60(worldIn);
			ent.setLocationAndAngles(par4 + 0, par5, par6 + 0, var12, 0.0F);//0000000000機銃類は座標0にする//0000000000機銃類は座標0にする
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 71) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SET_MG_M2 ent = new EntityGVCR2_SET_MG_M2(worldIn);
			ent.setLocationAndAngles(par4 + 0, par5, par6 + 0, var12, 0.0F);//0000000000機銃類は座標0にする
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 72) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SET_MG_PKM ent = new EntityGVCR2_SET_MG_PKM(worldIn);
			ent.setLocationAndAngles(par4 + 0, par5, par6 + 0, var12, 0.0F);//0000000000機銃類は座標0にする
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 73) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SET_MG_DP28 ent = new EntityGVCR2_SET_MG_DP28(worldIn);
			ent.setLocationAndAngles(par4 + 0, par5, par6 + 0, var12, 0.0F);//0000000000機銃類は座標0にする
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 80) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SET_AA_20mmAA ent = new EntityGVCR2_SET_AA_20mmAA(worldIn);
			ent.setLocationAndAngles(par4 + 0, par5, par6 + 0, var12, 0.0F);//0000000000機銃類は座標0にする
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 81) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SET_AA_Zu23 ent = new EntityGVCR2_SET_AA_Zu23(worldIn);
			ent.setLocationAndAngles(par4 + 0, par5, par6 + 0, var12, 0.0F);//0000000000機銃類は座標0にする
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 82) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SET_AA_VADS ent = new EntityGVCR2_SET_AA_VADS(worldIn);
			ent.setLocationAndAngles(par4 + 0, par5, par6 + 0, var12, 0.0F);//0000000000機銃類は座標0にする
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 90) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SET_CANNON_Pak40 ent = new EntityGVCR2_SET_CANNON_Pak40(worldIn);
			ent.setLocationAndAngles(par4 + 0, par5, par6 + 0, var12, 0.0F);//0000000000機銃類は座標0にする
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 91) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SET_CANNON_Flak18 ent = new EntityGVCR2_SET_CANNON_Flak18(worldIn);
			ent.setLocationAndAngles(par4 + 0, par5, par6 + 0, var12, 0.0F);//0000000000機銃類は座標0にする
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 92) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SET_CANNON_TOW2 ent = new EntityGVCR2_SET_CANNON_TOW2(worldIn);
			ent.setLocationAndAngles(par4 + 0, par5, par6 + 0, var12, 0.0F);//0000000000機銃類は座標0にする
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 95) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SET_MORTAR_M224 ent = new EntityGVCR2_SET_MORTAR_M224(worldIn);
			ent.setLocationAndAngles(par4 + 0, par5, par6 + 0, var12, 0.0F);//0000000000機銃類は座標0にする
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 96) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SET_MORTAR_FH18 ent = new EntityGVCR2_SET_MORTAR_FH18(worldIn);
			ent.setLocationAndAngles(par4 + 0, par5, par6 + 0, var12, 0.0F);//0000000000機銃類は座標0にする
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 97) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SET_CANNON_AK130 ent = new EntityGVCR2_SET_CANNON_AK130(worldIn);
			ent.setLocationAndAngles(par4 + 0, par5, par6 + 0, var12, 0.0F);//0000000000機銃類は座標0にする
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 83) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SET_AA_Mk15 ent = new EntityGVCR2_SET_AA_Mk15(worldIn);
			ent.setLocationAndAngles(par4 + 0, par5, par6 + 0, var12, 0.0F);//0000000000機銃類は座標0にする
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		else if (this.id == 98) {
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityGVCR2_SET_CANNON_Mk45 ent = new EntityGVCR2_SET_CANNON_Mk45(worldIn);
			ent.setLocationAndAngles(par4 + 0, par5, par6 + 0, var12, 0.0F);//0000000000機銃類は座標0にする
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		}
		
	}
    
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		ItemStack itemStackIn = player.getHeldItem(hand);
		int par4 = pos.getX();
		int par5 = pos.getY();
		int par6 = pos.getZ();
		
		if (worldIn.isRemote)
        {
			return EnumActionResult.PASS;
        }
        else
		{
        	if (!player.capabilities.isCreativeMode)
            {
        		itemStackIn.shrink(1);
            }
        	spawnCreature(worldIn, player, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
        	return EnumActionResult.PASS;
        }
    }
	
	/**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
    	ItemStack itemStackIn = playerIn.getHeldItem(handIn);
        if (worldIn.isRemote)
        {
            return new ActionResult(EnumActionResult.PASS, itemStackIn);
        }
        else
        {
            RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, true);

            if (raytraceresult != null && raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK)
            {
                BlockPos blockpos = raytraceresult.getBlockPos();

                if (!(worldIn.getBlockState(blockpos).getBlock() instanceof BlockLiquid))
                {
                    return new ActionResult(EnumActionResult.PASS, itemStackIn);
                }
                else if (worldIn.isBlockModifiable(playerIn, blockpos) && playerIn.canPlayerEdit(blockpos, raytraceresult.sideHit, itemStackIn))
                {
                    spawnCreature(worldIn, playerIn, (double)blockpos.getX(), (double)blockpos.getY(), (double)blockpos.getZ());
                    {

                    	if (!playerIn.capabilities.isCreativeMode)
                        {
                    		itemStackIn.shrink(1);
                        }

                        playerIn.addStat(StatList.getObjectUseStats(this));
                        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
                    }
                }
                else
                {
                    return new ActionResult(EnumActionResult.FAIL, itemStackIn);
                }
            }
            else
            {
                return new ActionResult(EnumActionResult.PASS, itemStackIn);
            }
        }
    }
}
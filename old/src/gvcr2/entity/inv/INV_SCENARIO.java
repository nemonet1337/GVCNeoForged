package gvcr2.entity.inv;

import java.util.List;

import gvclib.mod_GVCLib;
import gvcr2.block.BlockBuildingBaseFlag;
import gvcr2.block.tile.TileEntityBlockBaseFlag;
import gvcr2.entity.mob.EntityGVCR2_GEBase;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.mob.EntityGVCR2_UNKS_C_S;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_AN2;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_YAK23;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_YAK23KAI;
import gvcr2.entity.vehicle.car.EntityGVCR2_CAR_BULLDOZER;
import gvcr2.entity.vehicle.car.EntityGVCR2_CAR_Technical;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_KA60;
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

public class INV_SCENARIO {

	
	
	public void scenario(EntityGVCR2_INV_SCENARIO inv_entity) {
		//String timeee = String.format("%1$3d", inv_entity.timer);
		//System.out.println(timeee);
//		int flagtimer = inv_entity.timer;
		
		//　ダメージ処理
		float hp_count = inv_entity.getMaxHealth() / inv_entity.getArmID_R();
		float hp_min = inv_entity.getHealth() - hp_count;
		if(hp_min > 0) {
			inv_entity.setHealth(inv_entity.getHealth() - hp_count);
		}
		
		//　ダメージ処理
		//if(inv_entity.getArmID_A() != 0){}
		//　ダメージ処理
		
		
		//　占領されたら終了
		BlockPos flagbase = new BlockPos(inv_entity.getMoveX(), inv_entity.getMoveY()-1,inv_entity.getMoveZ());
		if (inv_entity.world.getBlockState(flagbase).getBlock() instanceof BlockBuildingBaseFlag) {
			
            if(inv_entity.world.getTileEntity(flagbase) != null && inv_entity.world.getTileEntity(flagbase) instanceof TileEntityBlockBaseFlag)
            {
            	TileEntity tileentity = inv_entity.world.getTileEntity(flagbase);
            	TileEntityBlockBaseFlag flagBlock = (TileEntityBlockBaseFlag) tileentity;
            	if(flagBlock.enemy){
            		sendmessage(inv_entity.world, inv_entity.posX, inv_entity.posY, inv_entity.posZ, 80, "Mission Failed...", true);
            		if (!inv_entity.world.isRemote) {
            			inv_entity.setDead();
            		}
            	}else {
            		if(flagBlock.lastinvcount < flagBlock.invcount) {
            			if(inv_entity.world.getWorldTime() %40 == 0) {
            				sendmessage(inv_entity.world, inv_entity.posX, inv_entity.posY, inv_entity.posZ, 80, "Flag is occupied!", true);
            			}
            		}
            	}
            }
		}else {
			//00000000旗が消えたorズレた
			sendmessage(inv_entity.world, inv_entity.posX, inv_entity.posY, inv_entity.posZ, 80, "Flag not found...", true);
    		if (!inv_entity.world.isRemote) {
    			inv_entity.setDead();
    		}
		}
		//　占領されたら終了
		
		
		
		//if(inv_entity.getArmID_A() == 0){}
		
		boolean flag_xp = true;
		boolean flag_xm = true;
		boolean flag_zp = true;
		boolean flag_zm = true;
		BlockPos pos00 = new BlockPos(inv_entity.getMoveX() + 1, inv_entity.getMoveY()-1,inv_entity.getMoveZ() + 0);
		BlockPos pos10 = new BlockPos(inv_entity.getMoveX() - 1, inv_entity.getMoveY()-1,inv_entity.getMoveZ() + 0);
		BlockPos pos01 = new BlockPos(inv_entity.getMoveX() + 0, inv_entity.getMoveY()-1,inv_entity.getMoveZ() + 1);
		BlockPos pos11 = new BlockPos(inv_entity.getMoveX() + 0, inv_entity.getMoveY()-1,inv_entity.getMoveZ() - 1);
		if(inv_entity.world.getBlockState(pos00).getBlock() == Blocks.OBSIDIAN)flag_xp = false;
		if(inv_entity.world.getBlockState(pos10).getBlock() == Blocks.OBSIDIAN)flag_xm = false;
		if(inv_entity.world.getBlockState(pos01).getBlock() == Blocks.OBSIDIAN)flag_zp = false;
		if(inv_entity.world.getBlockState(pos11).getBlock() == Blocks.OBSIDIAN)flag_zm = false;
		
		if(inv_entity.getArmID_S() == 40)new INV_SCENARIO_infantry_1().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		if(inv_entity.getArmID_S() == 41)new INV_SCENARIO_infantry_2().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		if(inv_entity.getArmID_S() == 42)new INV_SCENARIO_infantry_3().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		if(inv_entity.getArmID_S() == 43)new INV_SCENARIO_infantry_4().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		
		if(inv_entity.getArmID_S() == 0)new INV_SCENARIO_normal_1().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		if(inv_entity.getArmID_S() == 1)new INV_SCENARIO_normal_2().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		if(inv_entity.getArmID_S() == 2)new INV_SCENARIO_normal_3().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		if(inv_entity.getArmID_S() == 3)new INV_SCENARIO_normal_4().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		
		if(inv_entity.getArmID_S() == 10)new INV_SCENARIO_tank_1().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		if(inv_entity.getArmID_S() == 11)new INV_SCENARIO_tank_2().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		if(inv_entity.getArmID_S() == 12)new INV_SCENARIO_tank_3().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		
		if(inv_entity.getArmID_S() == 20)new INV_SCENARIO_dogfight_1().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		if(inv_entity.getArmID_S() == 21)new INV_SCENARIO_dogfight_2().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		if(inv_entity.getArmID_S() == 22)new INV_SCENARIO_dogfight_3().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		
		if(inv_entity.getArmID_S() == 30)new INV_SCENARIO_airborne_1().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		if(inv_entity.getArmID_S() == 31)new INV_SCENARIO_airborne_2().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		if(inv_entity.getArmID_S() == 32)new INV_SCENARIO_airborne_3().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		if(inv_entity.getArmID_S() == 33)new INV_SCENARIO_airborne_4().scenario(inv_entity, 0, flag_xp, flag_xm, flag_zp, flag_zm);
		
		
		//return flagtimer;
	}
	
	public int angle_set(EntityGVCR2_INV_SCENARIO inv_entity, boolean flag_xp, boolean flag_xm, boolean flag_zp, boolean flag_zm) {
		int flag = 0;
		World world = inv_entity.world;
		int ran = 0;
		for(int ra = 0; ra < 20; ++ra) {
				int rand = world.rand.nextInt(4);
				if(rand == 0){
					if(flag_xp) {
						ran = 1;
						break;
					}
				}else if(rand == 1){
					if(flag_xm) {
						ran = 2;
						break;
					}
				}else if(rand == 2){
					if(flag_zp) {
						ran = 3;
						break;
					}
				}else if(rand == 3){
					if(flag_zm) {
						ran = 4;
						break;
					}
				}
		}
		flag = ran;
		return flag;
	}
	
	public int angle_range(EntityGVCR2_INV_SCENARIO inv_entity, int id, boolean x) {
		int flag = 0;
		int range_x = 80 + inv_entity.getArmID_L();
		int range_z = 80 + inv_entity.getArmID_L();
		World world = inv_entity.world;
		{
			if(id == 1) {
				range_x = 80 + inv_entity.getArmID_L();
				range_z = 0;
			}
			if(id == 2) {
				range_x = -80 - inv_entity.getArmID_L();
				range_z = 0;
			}
			if(id == 3) {
				range_x = 0;
				range_z = 80 + inv_entity.getArmID_L();
			}
			if(id == 4) {
				range_x = 0;
				range_z = -80 - inv_entity.getArmID_L();
			}
		}
		if(x) {
			flag = range_x;
		}else {
			flag = range_z;
		}
		return flag;
	}
	
	
	
	public boolean spawn_flags(boolean flag_xp, boolean flag_xm, boolean flag_zp, boolean flag_zm) {
		if(!flag_xp && !flag_xm && !flag_zp && !flag_zm) {
			return false;
		}else {
			return true;
		}
	}
	
	public int random_int(World world, int han) {
		return world.rand.nextInt(han) -(han / 2);
	}
	
public void sendmessage(World world, double x, double y, double z, int han, String message, boolean mission) {
	//if(mod_GVCLib.proxy.getEntityPlayerMP() != null)
	//mod_GVCLib.proxy.getEntityPlayerMP().sendMessage(new TextComponentTranslation(message, new Object[0]));
		
		if(world.isRemote)return;
		
		if(FMLCommonHandler.instance().getMinecraftServerInstance() != null) {
			for (EntityPlayerMP playermp : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers()) {
				playermp.sendMessage(new TextComponentTranslation(message, new Object[0]));
			}
		}
		
    }
	
}

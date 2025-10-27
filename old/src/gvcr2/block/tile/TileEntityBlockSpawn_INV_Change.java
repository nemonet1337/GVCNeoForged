package gvcr2.block.tile;

import java.util.List;

import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.boss.EntityGVCR2_BOSS_HAUNEB;
import gvcr2.entity.boss.EntityGVCR2_BOSS_IRVING;
import gvcr2.entity.boss.EntityGVCR2_BOSS_LONGLEG;
import gvcr2.entity.boss.EntityGVCR2_BOSS_MER08;
import gvcr2.entity.boss.EntityGVCR2_BOSS_MER08_SN;
import gvcr2.entity.boss.EntityGVCR2_BOSS_ST1;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.mob.EntityGVCR2_GE_SE_HACS;
import gvcr2.entity.mob.EntityGVCR2_GE_SE_KUKRI;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_AA_20mmAA;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_AA_VADS;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_AA_Zu23;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_CANNON_Flak18;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_CANNON_Pak40;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_MG_M2;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_MG_M60;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_MG_PKM;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_MORTAR_M224;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_KV2;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T34;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class TileEntityBlockSpawn_INV_Change extends TileEntity implements ITickable
{
	public boolean spawn = false;
    
	public int id = 0;
	
	
    @Override
	public void update() {
    	Block block = this.world.getBlockState(this.pos).getBlock();
        
        int x = this.pos.getX();
        int y= this.pos.getY();
        int z = this.pos.getZ();
        
        if(!mod_GVCR2.cfg_building_dungeon_spawner) {
        	if(!this.world.isRemote){
            	this.world.setBlockToAir(pos);
            }
        }
        
        
        
        if(canspawn_near(this.pos.getX(), this.pos.getY(), this.pos.getZ(), 100)&& !this.world.isRemote){
        	//if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_boss_longleg) 
        	{
        		EntityGVCR2_BOSS_LONGLEG mob = new EntityGVCR2_BOSS_LONGLEG(this.world);
				mob.setLocationAndAngles(this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D,
						0, 0.0F);
				mob.setcanDespawn(1);
				this.world.spawnEntity(mob);
				
        	}
        }
        
        
        
    }
        
    
   
    public boolean canspawn_near(double x, double y, double z, int han) {
    	Entity entity = null;
    	boolean flag = true;
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
                			flag = false;
                		}
                    }
                }
            }
        }
        return flag;
    }
    
        
    
    
    
    
        public void canspawn(double x, double y, double z, int han, int id) {
        	Entity entity = null;
        	boolean can1 = false;
        	boolean can2 = false;
        	boolean can3 = false;
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
                    			can1 = true;
                    		}
                        }
                    }
                }
            }
            if(can1) {
            	boolean cann = true;
                if(llist2!=null){
                    for (int lj = 0; lj < llist2.size(); lj++) {
                    	
                    	Entity entity1 = (Entity)llist2.get(lj);
                    	if (entity1.canBeCollidedWith())
                        {
                    		if (entity1 != null)
                            {
                    			if (id == 1 && entity1 instanceof EntityGVCR2_GE_SE_KUKRI)
                                {
                    				cann = false;
                    				break;
                                }
                    			if (id == 2 && entity1 instanceof EntityGVCR2_TANK_KV2)
                                {
                    				cann = false;
                    				break;
                                }
                    			if (id == 3 && entity1 instanceof EntityGVCR2_GE_SE_HACS)
                                {
                    				cann = false;
                    				break;
                                }
                            }
                        }
                    }
                }
                if(cann) {
                	can2 = true;
                }
            }
            if(can2) {
            	boolean cann = false;
            	if(id == 1 && this.world.getBlockState(new BlockPos(x + 46, y + 16, z +0)).getBlock() == mod_GVCR2.gvcr2_block_flag_so_ship) {
					cann = true;
				}
				if(id == 2 && this.world.getBlockState(new BlockPos(x + 36, y + 10, z + 0)).getBlock() == mod_GVCR2.gvcr2_block_flag_so_city) {
					cann = true;
				}
				if(id == 3 && this.world.getBlockState(new BlockPos(x + 2, y - 16, z + 0)).getBlock() == mod_GVCR2.gvcr2_block_flag_so_abandoned_factory) {
					cann = true;
            	}
				if(id == 4 && this.world.getBlockState(new BlockPos(x + 0, y + 0, z + 17)).getBlock() == mod_GVCR2.gvcr2_block_flag_so_ruins) {
					cann = true;
            	}
            	if(cann) {
            		spawn = true;
            	}
            }
            /*
            if(can2) {
            	boolean cann = true;
            	for(int xx = 0; xx < han * 2; ++xx) {
            		for(int yy = 0; yy < han * 2; ++yy) {
            			for(int zz = 0; zz < han * 2; ++zz) {
            				if(id == 1 && this.world.getBlockState(new BlockPos(x + xx - han, y + yy - han, z + zz - han)).getBlock() == mod_GVCR2.gvcr2_block_ge_se_kukri) {
            					cann = false;
                				break;
            				}
            				if(id == 2 && this.world.getBlockState(new BlockPos(x + xx - han, y + yy - han, z + zz - han)).getBlock() == mod_GVCR2.gvcr2_block_tank_kv2) {
            					cann = false;
                				break;
            				}
            				if(id == 3 && this.world.getBlockState(new BlockPos(x + xx - han, y + yy - han, z + zz - han)).getBlock() == mod_GVCR2.gvcr2_block_ge_se_hacs) {
            					cann = false;
                				break;
            				}
                    	}
                	}
            	}
            	if(cann) {
                	can3 = true;
                }
            }
            if(can3) {
            	boolean cann = true;
            	for(int xx = 0; xx < han * 2; ++xx) {
            		for(int yy = 0; yy < han * 2; ++yy) {
            			for(int zz = 0; zz < han * 2; ++zz) {
            				if(id == 1 && this.world.getBlockState(new BlockPos(x + xx - han, y + yy - han, z + zz - han)).getBlock() == mod_GVCR2.gvcr2_block_flag_so_ship) {
            					cann = false;
                				break;
            				}
            				if(id == 2 && this.world.getBlockState(new BlockPos(x + xx - han, y + yy - han, z + zz - han)).getBlock() == mod_GVCR2.gvcr2_block_flag_so_city) {
            					cann = false;
                				break;
            				}
            				if(id == 3 && this.world.getBlockState(new BlockPos(x + xx - han, y + yy - han, z + zz - han)).getBlock() == mod_GVCR2.gvcr2_block_flag_so_abandoned_factory) {
            					cann = false;
                				break;
            				}
                    	}
                	}
            	}
            	if(cann) {
            		spawn = true;
            	}
            }*/
        }
}

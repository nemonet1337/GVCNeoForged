package gvcr2.block.tile;

import java.util.List;

import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.boss.EntityGVCR2_BOSS_AV8B;
import gvcr2.entity.boss.EntityGVCR2_BOSS_CHAR2C;
import gvcr2.entity.boss.EntityGVCR2_BOSS_CV;
import gvcr2.entity.boss.EntityGVCR2_BOSS_HAUNEB;
import gvcr2.entity.boss.EntityGVCR2_BOSS_IRVING;
import gvcr2.entity.boss.EntityGVCR2_BOSS_LONGLEG;
import gvcr2.entity.boss.EntityGVCR2_BOSS_MER08;
import gvcr2.entity.boss.EntityGVCR2_BOSS_MER08_B;
import gvcr2.entity.boss.EntityGVCR2_BOSS_MER08_SN;
import gvcr2.entity.boss.EntityGVCR2_BOSS_ST1;
import gvcr2.entity.mob.EntityGVCR2_BOSS_MER03K;
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

public class TileEntityBlockBossSpawn_Tile extends TileEntity implements ITickable
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
        
        if(this.world.getBlockState(new BlockPos(x, y, z)).getBlock() == mod_GVCR2.gvcr2_block_boss_longleg) {
        	id =1;
        	//this.canspawn(x, y, z, 80, 1);
        }
        if(this.world.getBlockState(new BlockPos(x, y, z)).getBlock() == mod_GVCR2.gvcr2_block_boss_st1) {
        	id =2;
        	//this.canspawn(x, y, z, 80, 2);
        }
        if(this.world.getBlockState(new BlockPos(x, y, z)).getBlock() == mod_GVCR2.gvcr2_block_boss_mer08) {
        	id =3;
        	this.canspawn_near(x, y, z, 3);
        }
        if(this.world.getBlockState(new BlockPos(x, y, z)).getBlock() == mod_GVCR2.gvcr2_block_boss_mer08_sn) {
        	id =4;
        	this.canspawn_near(x, y, z, 2);
        }
        if(this.world.getBlockState(new BlockPos(x, y, z)).getBlock() == mod_GVCR2.gvcr2_block_boss_hauneb) {
        	id =5;
        	//this.canspawn_near(x, y, z, 2);
        }
        if(this.world.getBlockState(new BlockPos(x, y, z)).getBlock() == mod_GVCR2.gvcr2_block_boss_irving) {
        	id =6;
        	//this.canspawn_near(x, y, z, 2);
        }
        if(this.world.getBlockState(new BlockPos(x, y, z)).getBlock() == mod_GVCR2.gvcr2_block_flag_boss_cv) {
        	id =7;
        	//this.canspawn_near(x, y, z, 2);
        }
        if(this.world.getBlockState(new BlockPos(x, y, z)).getBlock() == mod_GVCR2.gvcr2_block_boss_mer08_b) {
        	id =8;
        	//this.canspawn_near(x, y, z, 2);
        }
        if(this.world.getBlockState(new BlockPos(x, y, z)).getBlock() == mod_GVCR2.gvcr2_block_boss_mer03k) {
        	id =9;
        	this.canspawn_near(x, y, z, 3);
        }
        if(this.world.getBlockState(new BlockPos(x, y, z)).getBlock() == mod_GVCR2.gvcr2_block_boss_av8b) {
        	id =10;
        	//this.canspawn_near(x, y, z, 2);
        }
        
        
        if(spawn && !this.world.isRemote){
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_boss_longleg) {
        		EntityGVCR2_BOSS_LONGLEG mob = new EntityGVCR2_BOSS_LONGLEG(this.world);
				mob.setLocationAndAngles(this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D,
						0, 0.0F);
				mob.setcanDespawn(1);
				this.world.spawnEntity(mob);
				/*for(int xx = 0; xx < 14; ++xx) {
            		for(int yy = 0; yy < 20; ++yy) {
            			for(int zz = 0; zz < 14; ++zz) {
            				this.world.setBlockToAir(new BlockPos(x + xx - 7, y + yy, z + zz - 7));
            			}
            		}
				}*/
				for(int r = 0; r < 15; ++r) {
	        		for(int s = 0; s < 360; ++s) {
		        		for(int c = 0; c < 360; ++c) {
		        			//double r = 20;
		        			
		        			double rad = (2 * (float) Math.PI / 360);
		        			
			        		int xx = (int) (r * Math.sin(s * rad) * Math.cos(c * rad));
			        		int yy = (int) (r * Math.sin(s * rad) * Math.sin(c * rad));
			        		int zz = (int) (r * Math.cos(s * rad));
		        			if(world.getBlockState(new BlockPos(x + xx, y + yy, z + zz)).getBlock() != Blocks.AIR && yy > 0) {
		        				world.setBlockState(new BlockPos(x + xx, y + yy, z + zz), Blocks.AIR.getDefaultState(), 2);
		        			}
			        	}
		        	}
	        	}
				GVCExplosionBase.ExplosionKai(mob, mob, x, y, z, 5, false,  true);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_boss_st1) {
        		EntityGVCR2_BOSS_ST1 mob = new EntityGVCR2_BOSS_ST1(this.world);
				mob.setLocationAndAngles(this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D,
						0, 0.0F);
				mob.setcanDespawn(1);
				this.world.spawnEntity(mob);
				/*for(int xx = 0; xx < 4; ++xx) {
            		for(int yy = 0; yy < 10; ++yy) {
            			for(int zz = 0; zz < 4; ++zz) {
            				this.world.setBlockToAir(new BlockPos(x + xx - 2, y + yy, z + zz - 2));
            			}
            		}
				}*/
				for(int yy = 0; yy < 10; ++yy) {
					if(world.getBlockState(new BlockPos(x , y + yy, z)).getBlock() == Blocks.WATER) {
						world.setBlockState(new BlockPos(x , y + yy, z), Blocks.AIR.getDefaultState(), 2);
					}
				}
				
				for(int r = 0; r < 5; ++r) {
	        		for(int s = 0; s < 360; ++s) {
		        		for(int c = 0; c < 360; ++c) {
		        			//double r = 20;
		        			
		        			double rad = (2 * (float) Math.PI / 360);
		        			
			        		int xx = (int) (r * Math.sin(s * rad) * Math.cos(c * rad));
			        		int yy = (int) (r * Math.sin(s * rad) * Math.sin(c * rad));
			        		int zz = (int) (r * Math.cos(s * rad));
		        			if(world.getBlockState(new BlockPos(x + xx, y + yy + 3, z + zz)).getBlock() != Blocks.AIR) {
		        				world.setBlockState(new BlockPos(x + xx, y + yy + 3, z + zz), Blocks.AIR.getDefaultState(), 2);
		        			}
			        	}
		        	}
	        	}
				//GVCExplosionBase.ExplosionKai(mob, mob, x, y, z, 5, false,  true);
				GVCExplosionBase.ExplosionKai(mob, mob, x, y + 5, z, 5, false,  true);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_boss_mer08) {
        		EntityGVCR2_BOSS_MER08 mob = new EntityGVCR2_BOSS_MER08(this.world);
				mob.setLocationAndAngles(this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D,
						0, 0.0F);
				mob.setcanDespawn(1);
				this.world.spawnEntity(mob);
        	}
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_boss_mer08_sn) {
        		EntityGVCR2_BOSS_MER08_SN mob = new EntityGVCR2_BOSS_MER08_SN(this.world);
				mob.setLocationAndAngles(this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D,
						0, 0.0F);
				mob.setcanDespawn(1);
				this.world.spawnEntity(mob);
        	}
        	
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_boss_hauneb) {
        		EntityGVCR2_BOSS_HAUNEB mob = new EntityGVCR2_BOSS_HAUNEB(this.world);
				mob.setLocationAndAngles(this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D,
						0, 0.0F);
				mob.setcanDespawn(1);
				this.world.spawnEntity(mob);
				/*for(int xx = 0; xx < 14; ++xx) {
            		for(int yy = 0; yy < 20; ++yy) {
            			for(int zz = 0; zz < 14; ++zz) {
            				this.world.setBlockToAir(new BlockPos(x + xx - 7, y + yy, z + zz - 7));
            			}
            		}
				}*/
				for(int r = 0; r < 15; ++r) {
	        		for(int s = 0; s < 360; ++s) {
		        		for(int c = 0; c < 360; ++c) {
		        			//double r = 20;
		        			
		        			double rad = (2 * (float) Math.PI / 360);
		        			
			        		int xx = (int) (r * Math.sin(s * rad) * Math.cos(c * rad));
			        		int yy = (int) (r * Math.sin(s * rad) * Math.sin(c * rad));
			        		int zz = (int) (r * Math.cos(s * rad));
		        			if(world.getBlockState(new BlockPos(x + xx, y + yy + 5, z + zz)).getBlock() != Blocks.AIR && yy > 0) {
		        				world.setBlockState(new BlockPos(x + xx, y + yy + 5, z + zz), Blocks.AIR.getDefaultState(), 2);
		        			}
			        	}
		        	}
	        	}
				GVCExplosionBase.ExplosionKai(mob, mob, x, y, z, 5, false,  true);
        	}
        	
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_boss_irving) {
        		for(int r = 0; r < 5; ++r) {
        			EntityGVCR2_BOSS_IRVING mob = new EntityGVCR2_BOSS_IRVING(this.world);
        			int xp = 20;
        			int zp = 20;
        			if(r == 1) {
        				xp = 35;
        				zp = 40;
        			}
        			if(r == 2) {
        				xp = -35;
        				zp = -40;
        			}
        			if(r == 3) {
        				xp = 50;
        				zp = -40;
        			}
        			if(r == 4) {
        				xp = -35;
        				zp = 40;
        			}
    				mob.setLocationAndAngles(this.pos.getX() - 0.5D + xp, this.pos.getY(), this.pos.getZ() - 0.5D + zp,
    						0, 0.0F);
    				mob.setcanDespawn(1);
    				this.world.spawnEntity(mob);
        		}
        		
        	}
        	
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_boss_cv) {
        		EntityGVCR2_BOSS_CV mob = new EntityGVCR2_BOSS_CV(this.world);
				mob.setLocationAndAngles(this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D,
						0, 0.0F);
				mob.setcanDespawn(1);
				this.world.spawnEntity(mob);
        	}
        	
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_boss_char2c) {
        		//for(int r = 0; r < 5; ++r)
        		{
        			EntityGVCR2_BOSS_CHAR2C mob = new EntityGVCR2_BOSS_CHAR2C(this.world);
        			int xp = 00;
        			int zp = -50;
        			mob.setMoveT(1);
        			mob.setMoveX((int)this.pos.getX() );
        			mob.setMoveY((int)this.pos.getY() );
        			mob.setMoveZ((int)this.pos.getZ() );
    				mob.setLocationAndAngles(this.pos.getX() - 0.5D + xp, this.pos.getY(), this.pos.getZ() - 0.5D + zp,
    						0, 0.0F);
    				mob.setcanDespawn(1);
    				this.world.spawnEntity(mob);
        		}
        		
        	}
        	
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_boss_mer08_b) {
        		EntityGVCR2_BOSS_MER08_B mob = new EntityGVCR2_BOSS_MER08_B(this.world);
				mob.setLocationAndAngles(this.pos.getX() + 0.5D, this.pos.getY(), this.pos.getZ() + 0.5D,
						0, 0.0F);
				mob.setcanDespawn(1);
				this.world.spawnEntity(mob);
				
				for(int r = 0; r < 8; ++r) {
	        		for(int s = 0; s < 360; ++s) {
		        		for(int c = 0; c < 360; ++c) {
		        			//double r = 20;
		        			
		        			double rad = (2 * (float) Math.PI / 360);
		        			
			        		int xx = (int) (r * Math.sin(s * rad) * Math.cos(c * rad));
			        		int yy = (int) (r * Math.sin(s * rad) * Math.sin(c * rad));
			        		int zz = (int) (r * Math.cos(s * rad));
		        			if(world.getBlockState(new BlockPos(x + xx, y + yy + 3, z + zz)).getBlock() != Blocks.AIR && yy > 0) {
		        				world.setBlockState(new BlockPos(x + xx, y + yy + 3, z + zz), Blocks.AIR.getDefaultState(), 2);
		        			}
			        	}
		        	}
	        	}
				GVCExplosionBase.ExplosionKai(mob, mob, x, y, z, 3, false,  true);
        	}
        	
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_boss_mer03k) {
        		EntityGVCR2_BOSS_MER03K mob = new EntityGVCR2_BOSS_MER03K(this.world);
				mob.setLocationAndAngles(this.pos.getX() + 0.5D, this.pos.getY(), this.pos.getZ() + 0.5D,
						0, 0.0F);
				mob.setcanDespawn(1);
				mob.setRemain_L(30);
				this.world.spawnEntity(mob);
        	}
        	
        	
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_boss_av8b) {
        		EntityGVCR2_BOSS_AV8B mob = new EntityGVCR2_BOSS_AV8B(this.world);
				mob.setLocationAndAngles(this.pos.getX() - 0.5D, this.pos.getY() + 20, this.pos.getZ() - 80D,0, 0.0F);
				mob.setcanDespawn(1);
				mob.setMoveT(6);
				mob.setMoveX((int)x);
				mob.setMoveY((int)y);
				mob.setMoveZ((int)z);
				this.world.spawnEntity(mob);
        	}
        	
        	
        	if(!this.world.isRemote){
            	//this.world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 2);
            	this.world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 2);
            	this.world.setBlockToAir(pos);
            }
        }
        
        
        
    }
        
    
   
    public void canspawn_near(double x, double y, double z, int han) {
    	Entity entity = null;
    	boolean flag = false;
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
                			flag = true;
                		}
                    }
                }
            }
        }
        
        if(flag) {
        	for(int xx = 0; xx < 64; ++xx) {
            	for(int yy = 0; yy < 40; ++yy) {
            		for(int zz = 0; zz < 64; ++zz) {
            			{
            				if(world.getTileEntity(new BlockPos(x + xx - 32, y + yy - 20, z + zz - 32)) instanceof TileEntityBlockBossSpawn_Tile) {
            					spawn = true;
            				}
            			}
            		}
    			}
        	}
        }
    }
        
    
    
    /**今現在は使ってないっぽい？*/
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

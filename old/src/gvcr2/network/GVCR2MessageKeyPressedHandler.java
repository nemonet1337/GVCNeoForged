package gvcr2.network;
import java.util.List;

import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.ISoldier;
import gvcr2.mod_GVCR2;
import gvcr2.block.tile.TileEntity_BulletCrafter;
import gvcr2.block.tile.TileEntity_GunCrafter;
import gvcr2.block.tile.TileEntity_VehicleCrafter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 
public class GVCR2MessageKeyPressedHandler implements IMessageHandler<GVCR2MessageKeyPressed, IMessage> {
 
    @Override
    public IMessage onMessage(GVCR2MessageKeyPressed message, MessageContext ctx) {
        EntityPlayer entityPlayer = ctx.getServerHandler().player;
        //System.out.println("0");
        if (message.key == 1) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_GunCrafter) {
        		TileEntity_GunCrafter tile  = (TileEntity_GunCrafter) entityPlayer.world.getTileEntity(pos);
        		//System.out.println("1");
        		 if(tile.sell_id < (mod_GVCR2.gun_id_1 - 1)) {
        			 ++tile.sell_id;
        		 }else {
        			 tile.sell_id = 0;
        		 }
        	}
		}
        if (message.key == 11) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_GunCrafter) {
        		TileEntity_GunCrafter tile  = (TileEntity_GunCrafter) entityPlayer.world.getTileEntity(pos);
        		//System.out.println("1");
        		 if(tile.sell_id < (mod_GVCR2.gun_id_2 - 1)) {
        			 ++tile.sell_id;
        		 }else {
        			 tile.sell_id = 0;
        		 }
        	}
		}
        if (message.key == 12) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_GunCrafter) {
        		TileEntity_GunCrafter tile  = (TileEntity_GunCrafter) entityPlayer.world.getTileEntity(pos);
        		//System.out.println("1");
        		 if(tile.sell_id < (mod_GVCR2.gun_id_3 - 1)) {
        			 ++tile.sell_id;
        		 }else {
        			 tile.sell_id = 0;
        		 }
        	}
		}
        
        
        
        if (message.key == 2) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_GunCrafter) {
        		TileEntity_GunCrafter tile  = (TileEntity_GunCrafter) entityPlayer.world.getTileEntity(pos);
				if (tile.sell_id > 0) {
					--tile.sell_id;
				} else {
					tile.sell_id = (mod_GVCR2.gun_id_1 - 1);
				}
        	}
		}
        if (message.key == 21) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_GunCrafter) {
        		TileEntity_GunCrafter tile  = (TileEntity_GunCrafter) entityPlayer.world.getTileEntity(pos);
				if (tile.sell_id > 0) {
					--tile.sell_id;
				} else {
					tile.sell_id = (mod_GVCR2.gun_id_2 - 1);
				}
        	}
		}
        if (message.key == 22) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_GunCrafter) {
        		TileEntity_GunCrafter tile  = (TileEntity_GunCrafter) entityPlayer.world.getTileEntity(pos);
				if (tile.sell_id > 0) {
					--tile.sell_id;
				} else {
					tile.sell_id = (mod_GVCR2.gun_id_3 - 1);
				}
        	}
		}
        
        if (message.key == 3) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_GunCrafter) {
        		TileEntity_GunCrafter tile  = (TileEntity_GunCrafter) entityPlayer.world.getTileEntity(pos);
        		 ItemStack eme = (ItemStack)tile.furnaceItemStacks.get(0);
                 ItemStack iron = (ItemStack)tile.furnaceItemStacks.get(1);
                 ItemStack red = (ItemStack)tile.furnaceItemStacks.get(2);
                 ItemStack output = (ItemStack)tile.furnaceItemStacks.get(3);
                 if(mod_GVCR2.gun_item_1[tile.sell_id] != null) {
                   	if(!eme.isEmpty() && eme.getItem() == Items.EMERALD
                   			&& !iron.isEmpty() && iron.getItem() == Items.IRON_INGOT
                   			&& !red.isEmpty() && red.getItem() == Items.REDSTONE) {
                   		if(eme.getCount() >= mod_GVCR2.gun_eme_1[tile.sell_id]
                   				&& iron.getCount() >= mod_GVCR2.gun_iron_1[tile.sell_id]
                   						&&red.getCount() >= mod_GVCR2.gun_red_1[tile.sell_id]) {
                   			tile.do_sell = true;
                   		}
                   	}
                   }
        	}
		}
        if (message.key == 31) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_GunCrafter) {
        		TileEntity_GunCrafter tile  = (TileEntity_GunCrafter) entityPlayer.world.getTileEntity(pos);
        		 ItemStack eme = (ItemStack)tile.furnaceItemStacks.get(0);
                 ItemStack iron = (ItemStack)tile.furnaceItemStacks.get(1);
                 ItemStack red = (ItemStack)tile.furnaceItemStacks.get(2);
                 ItemStack output = (ItemStack)tile.furnaceItemStacks.get(3);
                 if(mod_GVCR2.gun_item_2[tile.sell_id] != null) {
                    	if(!eme.isEmpty() && eme.getItem() == Items.EMERALD
                    			&& !iron.isEmpty() && iron.getItem() == Items.IRON_INGOT
                    			&& !red.isEmpty() && red.getItem() == Items.REDSTONE) {
                    		if(eme.getCount() >= mod_GVCR2.gun_eme_2[tile.sell_id]
                    				&& iron.getCount() >= mod_GVCR2.gun_iron_2[tile.sell_id]
                    						&&red.getCount() >= mod_GVCR2.gun_red_2[tile.sell_id]) {
                    			tile.do_sell = true;
                    		}
                    	}
                    }
        	}
		}
        if (message.key == 32) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_GunCrafter) {
        		TileEntity_GunCrafter tile  = (TileEntity_GunCrafter) entityPlayer.world.getTileEntity(pos);
        		 ItemStack eme = (ItemStack)tile.furnaceItemStacks.get(0);
                 ItemStack iron = (ItemStack)tile.furnaceItemStacks.get(1);
                 ItemStack red = (ItemStack)tile.furnaceItemStacks.get(2);
                 ItemStack output = (ItemStack)tile.furnaceItemStacks.get(3);
                 if(mod_GVCR2.gun_item_3[tile.sell_id] != null) {
                    	if(!eme.isEmpty() && eme.getItem() == Items.EMERALD
                    			&& !iron.isEmpty() && iron.getItem() == Items.IRON_INGOT
                    			&& !red.isEmpty() && red.getItem() == Items.REDSTONE) {
                    		if(eme.getCount() >= mod_GVCR2.gun_eme_3[tile.sell_id]
                    				&& iron.getCount() >= mod_GVCR2.gun_iron_3[tile.sell_id]
                    						&&red.getCount() >= mod_GVCR2.gun_red_3[tile.sell_id]) {
                    			tile.do_sell = true;
                    		}
                    	}
                    }
        	}
		}
        
        
        
        if (message.key == 10) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_VehicleCrafter) {
        		TileEntity_VehicleCrafter tile  = (TileEntity_VehicleCrafter) entityPlayer.world.getTileEntity(pos);
        		//System.out.println("1");
        		 if(tile.sell_id < (mod_GVCR2.vehicle_id_1 - 1)) {
        			 ++tile.sell_id;
        		 }else {
        			 tile.sell_id = 0;
        		 }
        	}
		}
        if (message.key == 110) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_VehicleCrafter) {
        		TileEntity_VehicleCrafter tile  = (TileEntity_VehicleCrafter) entityPlayer.world.getTileEntity(pos);
        		//System.out.println("1");
        		 if(tile.sell_id < (mod_GVCR2.vehicle_id_2 - 1)) {
        			 ++tile.sell_id;
        		 }else {
        			 tile.sell_id = 0;
        		 }
        	}
		}
        if (message.key == 120) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_VehicleCrafter) {
        		TileEntity_VehicleCrafter tile  = (TileEntity_VehicleCrafter) entityPlayer.world.getTileEntity(pos);
        		//System.out.println("1");
        		 if(tile.sell_id < (mod_GVCR2.vehicle_id_3 - 1)) {
        			 ++tile.sell_id;
        		 }else {
        			 tile.sell_id = 0;
        		 }
        	}
		}
        
        
        
        if (message.key == 20) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_VehicleCrafter) {
        		TileEntity_VehicleCrafter tile  = (TileEntity_VehicleCrafter) entityPlayer.world.getTileEntity(pos);
				if (tile.sell_id > 0) {
					--tile.sell_id;
				} else {
					tile.sell_id = (mod_GVCR2.vehicle_id_1 - 1);
				}
        	}
		}
        if (message.key == 210) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_VehicleCrafter) {
        		TileEntity_VehicleCrafter tile  = (TileEntity_VehicleCrafter) entityPlayer.world.getTileEntity(pos);
				if (tile.sell_id > 0) {
					--tile.sell_id;
				} else {
					tile.sell_id = (mod_GVCR2.vehicle_id_2 - 1);
				}
        	}
		}
        if (message.key == 220) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_VehicleCrafter) {
        		TileEntity_VehicleCrafter tile  = (TileEntity_VehicleCrafter) entityPlayer.world.getTileEntity(pos);
				if (tile.sell_id > 0) {
					--tile.sell_id;
				} else {
					tile.sell_id = (mod_GVCR2.vehicle_id_3 - 1);
				}
        	}
		}
        
        if (message.key == 30) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_VehicleCrafter) {
        		TileEntity_VehicleCrafter tile  = (TileEntity_VehicleCrafter) entityPlayer.world.getTileEntity(pos);
        		ItemStack eme = (ItemStack)tile.furnaceItemStacks.get(0);
                ItemStack iron = (ItemStack)tile.furnaceItemStacks.get(1);
                ItemStack red = (ItemStack)tile.furnaceItemStacks.get(2);
                ItemStack output = (ItemStack)tile.furnaceItemStacks.get(3);
                if(mod_GVCR2.vehicle_item_1[tile.sell_id] != null) {
                  	if(!eme.isEmpty() && eme.getItem() == Items.EMERALD
                  			&& !iron.isEmpty() && iron.getItem() == Items.IRON_INGOT
                  			&& !red.isEmpty() && red.getItem() == Items.REDSTONE) {
                  		if(eme.getCount() >= mod_GVCR2.vehicle_eme_1[tile.sell_id]
                  				&& iron.getCount() >= mod_GVCR2.vehicle_iron_1[tile.sell_id]
                  						&&red.getCount() >= mod_GVCR2.vehicle_red_1[tile.sell_id]) {
                  			tile.do_sell = true;
                  		}
                  	}
                  }
        	}
		}
        if (message.key == 310) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_VehicleCrafter) {
        		TileEntity_VehicleCrafter tile  = (TileEntity_VehicleCrafter) entityPlayer.world.getTileEntity(pos);
        		ItemStack eme = (ItemStack)tile.furnaceItemStacks.get(0);
                ItemStack iron = (ItemStack)tile.furnaceItemStacks.get(1);
                ItemStack red = (ItemStack)tile.furnaceItemStacks.get(2);
                ItemStack output = (ItemStack)tile.furnaceItemStacks.get(3);
                if(mod_GVCR2.vehicle_item_2[tile.sell_id] != null) {
                   	if(!eme.isEmpty() && eme.getItem() == Items.EMERALD
                   			&& !iron.isEmpty() && iron.getItem() == Items.IRON_INGOT
                   			&& !red.isEmpty() && red.getItem() == Items.REDSTONE) {
                   		if(eme.getCount() >= mod_GVCR2.vehicle_eme_2[tile.sell_id]
                   				&& iron.getCount() >= mod_GVCR2.vehicle_iron_2[tile.sell_id]
                   						&&red.getCount() >= mod_GVCR2.vehicle_red_2[tile.sell_id]) {
                   			tile.do_sell = true;
                   		}
                   	}
                   }
        	}
		}
        if (message.key == 320) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_VehicleCrafter) {
        		TileEntity_VehicleCrafter tile  = (TileEntity_VehicleCrafter) entityPlayer.world.getTileEntity(pos);
        		ItemStack eme = (ItemStack)tile.furnaceItemStacks.get(0);
                ItemStack iron = (ItemStack)tile.furnaceItemStacks.get(1);
                ItemStack red = (ItemStack)tile.furnaceItemStacks.get(2);
                ItemStack output = (ItemStack)tile.furnaceItemStacks.get(3);
                if(mod_GVCR2.vehicle_item_3[tile.sell_id] != null) {
                   	if(!eme.isEmpty() && eme.getItem() == Items.EMERALD
                   			&& !iron.isEmpty() && iron.getItem() == Items.IRON_INGOT
                   			&& !red.isEmpty() && red.getItem() == Items.REDSTONE) {
                   		if(eme.getCount() >= mod_GVCR2.vehicle_eme_3[tile.sell_id]
                   				&& iron.getCount() >= mod_GVCR2.vehicle_iron_3[tile.sell_id]
                   						&&red.getCount() >= mod_GVCR2.vehicle_red_3[tile.sell_id]) {
                   			tile.do_sell = true;
                   		}
                   	}
                   }
        	}
		}
        
        if (message.key == 100) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_BulletCrafter) {
        		TileEntity_BulletCrafter tile  = (TileEntity_BulletCrafter) entityPlayer.world.getTileEntity(pos);
        		//System.out.println("1");
        		 if(tile.sell_id < (mod_GVCR2.bullet_id_1 - 1)) {
        			 ++tile.sell_id;
        		 }else {
        			 tile.sell_id = 0;
        		 }
        	}
		}
        if (message.key == 200) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_BulletCrafter) {
        		TileEntity_BulletCrafter tile  = (TileEntity_BulletCrafter) entityPlayer.world.getTileEntity(pos);
				if (tile.sell_id > 0) {
					--tile.sell_id;
				} else {
					tile.sell_id = (mod_GVCR2.bullet_id_1 - 1);
				}
        	}
		}
        
        if (message.key == 300) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_BulletCrafter) {
        		TileEntity_BulletCrafter tile  = (TileEntity_BulletCrafter) entityPlayer.world.getTileEntity(pos);
        		 ItemStack eme = (ItemStack)tile.furnaceItemStacks.get(0);
                 ItemStack iron = (ItemStack)tile.furnaceItemStacks.get(1);
                 ItemStack output = (ItemStack)tile.furnaceItemStacks.get(3);
                 if(mod_GVCR2.bullet_item_1[tile.sell_id] != null) {
                 	if(!eme.isEmpty() && eme.getItem() == Items.GUNPOWDER
                 			&& !iron.isEmpty() && iron.getItem() == Items.IRON_INGOT) {
                 		if(eme.getCount() >= mod_GVCR2.bullet_eme_1[tile.sell_id]
                 				&& iron.getCount() >= mod_GVCR2.bullet_iron_1[tile.sell_id]) {
                 			tile.do_sell = true;
                 		}
                 	}
                 }
        	}
		}
        
        
        
        if(message.key == 111) {
        	{
    			Vec3d lock = Vec3d.fromPitchYaw(entityPlayer.rotationPitch, entityPlayer.rotationYaw);
				int ix = 0;
				int iy = 0;
				int iz = 0;
				for(int x = 0; x < 120; ++x) {
					if (entityPlayer.world
							.getBlockState(new BlockPos(entityPlayer.posX + lock.x * x,
									entityPlayer.posY + 1.5 + lock.y * x,
									entityPlayer.posZ + lock.z * x))
							.getBlock() != Blocks.AIR) {
						ix = (int) (entityPlayer.posX + lock.x * x);
						iy = (int) (entityPlayer.posY + 1.5 + lock.y * x);
						iz = (int) (entityPlayer.posZ + lock.z * x);
						entityPlayer.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, 
								entityPlayer.posX +lock.x * x,  entityPlayer.posY + 1.5 +lock.y * x, entityPlayer.posZ +lock.z * x, 0, 0, 0);
						break;
					}
				}
				if(ix != 0 && iz != 0 && iy != 0) {
					EntityLivingBase target = null;
					{
						int han = 1;
		            	AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(ix-han), (double)(iy-han), (double)(iz-han), 
		            			(double)(ix + han), (double)(iy + han), (double)(iz+ han)))
		                		.grow(3);
		                List llist2 = entityPlayer.world.getEntitiesWithinAABBExcludingEntity(entityPlayer, axisalignedbb2);
		                if(llist2!=null){
		                    for (int lj = 0; lj < llist2.size(); lj++) {
		                    	
		                    	Entity entity1 = (Entity)llist2.get(lj);
		                    	if (entity1.canBeCollidedWith())
		                        {
		                    		if (entity1 instanceof IMob && entity1 != null)
		                            {
		                    			EntityLivingBase mob = (EntityLivingBase) entity1;
		                    			mob.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 400, 200));
		                    			target = mob;
		                            }
		                        }
		                    }
		                }
					}
	                if(target != null){
	                	int han = 160;
	                	double x = entityPlayer.posX;
	                	double y = entityPlayer.posY;
	                	double z = entityPlayer.posZ;
	                	AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(x-han), (double)(y-han), (double)(z-han), 
		            			(double)(x + han), (double)(y + han), (double)(z+ han)))
		                		.grow(1);
		                List llist2 = entityPlayer.world.getEntitiesWithinAABBExcludingEntity(entityPlayer, axisalignedbb2);
		                if(llist2!=null){
		                    for (int lj = 0; lj < llist2.size(); lj++) {
		                    	
		                    	Entity entity1 = (Entity)llist2.get(lj);
		                    	if (entity1.canBeCollidedWith())
		                        {
		                    		if (entity1 instanceof ISoldier && entity1 != null)
		                            {
		                    			EntityGVCLivingBase mob = (EntityGVCLivingBase) entity1;
		                    			mob.targetentity = target;
		                    			mob.setMobMode(1);
		                    			mob.sneak = true;
		                    			mob.setattacktask(true);
		                    			{
		                    				mob.world.spawnParticle(EnumParticleTypes.NOTE, 
		                    						mob.posX,  mob.posY + mob.height + 1, mob.posZ, 0, 0, 0);
		                    			}
		                            }
		                        }
		                    }
		                }
	                }
	                
				}
        		
    		}
        }
        
        return null;
    }
}
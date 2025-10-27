package gvcr2.network;
import java.util.List;

import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.ISoldier;
import gvcr2.mod_GVCR2;
import gvcr2.block.tile.TileEntityBlockBaseFlag_Base;
import gvcr2.block.tile.TileEntity_GunRack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 
public class GVCR2ClientMessageKeyPressedHandler implements IMessageHandler<GVCR2ClientMessageKeyPressed, IMessage> {
 
    @Override
    public IMessage onMessage(GVCR2ClientMessageKeyPressed message, MessageContext ctx) {
        EntityPlayer player = mod_GVCR2.proxy.getEntityPlayerInstance();
       
        if (message.key == 1) {
        	mod_GVCR2.difficult_level = message.fre;
        }
        if (message.key == 2) {
        	//mod_GVCR2.difficult_doll_kazu = message.fre;
        }
        
        if (message.key == 3) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && player.world.getTileEntity(pos) instanceof TileEntity_GunRack) {
        		TileEntity_GunRack tile  = (TileEntity_GunRack) player.world.getTileEntity(pos);
				Item item = new Item().getItemById(message.item_id);
				if(item != null) {
					tile.furnaceItemStacks.set(0, new ItemStack(item));
				}
        	}
		}
        if (message.key == 4) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && player.world.getTileEntity(pos) instanceof TileEntity_GunRack) {
        		TileEntity_GunRack tile  = (TileEntity_GunRack) player.world.getTileEntity(pos);
				Item item = new Item().getItemById(message.item_id);
				if(item != null) {
					tile.furnaceItemStacks.set(1, new ItemStack(item));
				}
        	}
		}
        if (message.key == 5) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && player.world.getTileEntity(pos) instanceof TileEntity_GunRack) {
        		TileEntity_GunRack tile  = (TileEntity_GunRack) player.world.getTileEntity(pos);
				Item item = new Item().getItemById(message.item_id);
				if(item != null) {
					tile.furnaceItemStacks.set(2, new ItemStack(item));
				}
        	}
		}
        if (message.key == 6) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && player.world.getTileEntity(pos) instanceof TileEntity_GunRack) {
        		TileEntity_GunRack tile  = (TileEntity_GunRack) player.world.getTileEntity(pos);
        		tile.houkou = message.item_id;
        	}
		}
        
        
        if(message.key == 100){
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && player.world.getTileEntity(pos) instanceof TileEntityBlockBaseFlag_Base) {
        		TileEntityBlockBaseFlag_Base tile  = (TileEntityBlockBaseFlag_Base) player.world.getTileEntity(pos);
				tile.invcount = message.enid;
        	}
    	}
        if(message.key == 101){
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && player.world.getTileEntity(pos) instanceof TileEntityBlockBaseFlag_Base) {
        		TileEntityBlockBaseFlag_Base tile  = (TileEntityBlockBaseFlag_Base) player.world.getTileEntity(pos);
				tile.invmaxcount = message.enid;
        	}
    	}
        if(message.key == 102){
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && player.world.getTileEntity(pos) instanceof TileEntityBlockBaseFlag_Base) {
        		TileEntityBlockBaseFlag_Base tile  = (TileEntityBlockBaseFlag_Base) player.world.getTileEntity(pos);
				tile.player_count = message.enid;
        	}
    	}
        if(message.key == 103){
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && player.world.getTileEntity(pos) instanceof TileEntityBlockBaseFlag_Base) {
        		TileEntityBlockBaseFlag_Base tile  = (TileEntityBlockBaseFlag_Base) player.world.getTileEntity(pos);
				tile.mob_count = message.enid;
        	}
    	}
        
        
        if(message.key == 111) {
        	{
    			Vec3d lock = Vec3d.fromPitchYaw(player.rotationPitch, player.rotationYaw);
				int ix = 0;
				int iy = 0;
				int iz = 0;
				for(int x = 0; x < 120; ++x) {
					if (player.world
							.getBlockState(new BlockPos(player.posX + lock.x * x,
									player.posY + 1.5 + lock.y * x,
									player.posZ + lock.z * x))
							.getBlock() != Blocks.AIR) {
						ix = (int) (player.posX + lock.x * x);
						iy = (int) (player.posY + 1.5 + lock.y * x);
						iz = (int) (player.posZ + lock.z * x);
						player.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, 
								player.posX +lock.x * x,  player.posY + 1.5 +lock.y * x, player.posZ +lock.z * x, 0, 0, 0);
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
		                List llist2 = player.world.getEntitiesWithinAABBExcludingEntity(player, axisalignedbb2);
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
	                	double x = player.posX;
	                	double y = player.posY;
	                	double z = player.posZ;
	                	AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(x-han), (double)(y-han), (double)(z-han), 
		            			(double)(x + han), (double)(y + han), (double)(z+ han)))
		                		.grow(1);
		                List llist2 = player.world.getEntitiesWithinAABBExcludingEntity(player, axisalignedbb2);
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
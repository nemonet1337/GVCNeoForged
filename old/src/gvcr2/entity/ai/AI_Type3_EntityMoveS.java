package gvcr2.entity.ai;

import java.util.List;

import gvclib.mod_GVCLib;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicle_Inv_Base;
import gvclib.entity.living.EntityVehicleBase;
import gvclib.world.GVCExplosionBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.chunk.Chunk;

public abstract class AI_Type3_EntityMoveS
{
	public static void newmove(EntityGVCLivingBase entity, int id, float sp, float turnspeed, double max, double range1, double range2) {
		int fps = mod_GVCLib.proxy.getFPS();
		if(fps < 15)return;
		Chunk chunk = entity.world.getChunkFromBlockCoords(new BlockPos(entity.posX, entity.posY, entity.posZ));
		if (chunk.isEmpty())return;
		entity.sneak = false;
		boolean ta = false;
		double range = range1;
		if(entity.getMobMode() == 1){
			range = range2;
		}
		//entity.motionY *= 0.98;
		if (entity.isPotionActive(MobEffects.SLOWNESS))
        {
			sp = sp * 0.5F;
        }
		if (entity.isPotionActive(MobEffects.BLINDNESS))
        {
			sp = sp * 0.1F;
        }
		
		boolean gettarget = false;
		{
			List<Entity> llist = entity.world.getEntitiesWithinAABBExcludingEntity(entity,
					entity.getEntityBoundingBox().expand(entity.motionX, entity.motionY, entity.motionZ)
							.grow(max));
			if (llist != null) {
				for (int lj = 0; lj < llist.size(); lj++) {
					Entity entity1 = (Entity) llist.get(lj);
					if (entity1.canBeCollidedWith() && entity1 != null && entity.getHealth() > 0.0F) {
						boolean flag = entity.getEntitySenses().canSee(entity1);
						if (entity.CanAttack(entity1) && entity1 != null) {
							if (entity.targetentity == entity1) {
								gettarget = true;
								break;
							} else if (entity.targetentity == null) {
								if (entity.CanAttack(entity1) && flag) {
									entity.targetentity = (EntityLivingBase) entity1;
									gettarget = true;
									break;
								}
							}
						}
					}
				}
			}
		}
		
		
		
		if(entity.getMoveT() == 1 && !gettarget){
			{
				MoveS(entity, sp * 0.8, 1, entity.getMoveX(), entity.getMoveY(), entity.getMoveZ(), id);
				{
					double d5 = entity.getMoveX() - entity.posX;
					double d7 = entity.getMoveZ() - entity.posZ;
					double d6 = entity.getMoveY() - entity.posY;
					double d1 = entity.posY - (entity.getMoveY());
					double d3 = (double) MathHelper.sqrt(d5 * d5 + d7 * d7);
					float f11 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
					entity.rotationYawHead = entity.rotation = entity.rote = entity.renderYawOffset 
							= -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
					entity.rotationp = entity.rotationPitch = -f11 + 0;
				}
			}
			for(int xxx = 0; xxx < 6; ++xxx) {
				for(int yyy = 0; yyy < 6; ++yyy) {
					for(int zzz = 0; zzz < 6; ++zzz) {
						if(entity.posX - 3 + xxx == entity.getMoveX() && entity.posY - 3 +yyy == entity.getMoveY() && entity.posZ - 3 +zzz == entity.getMoveZ()) {
							entity.setMoveT(2);
						}
					}
				}
			}
		}
		else if(entity.getRidingEntity() instanceof EntityGVCLivingBase && entity.getRidingEntity() != null) {
			if (entity.targetentity != null
					&& ((EntityLivingBase) entity.targetentity).getHealth() > 0.0F) {
				
			}
		}
		else
		{
			
			boolean tageflag = true;
			if(entity.getRidingEntity() != null && entity.getRidingEntity() instanceof EntityGVCLivingBase) {
				EntityGVCLivingBase vehicle = (EntityGVCLivingBase) entity.getRidingEntity();
				int i = vehicle.getPassengers().indexOf(entity);
				if(vehicle.vehicle_ridding_nofire[i]) {
					tageflag = false;
				}
			}
			if(tageflag) {
			List<Entity> llist = entity.world.getEntitiesWithinAABBExcludingEntity(entity, entity
					.getEntityBoundingBox().expand(entity.motionX, entity.motionY, entity.motionZ).grow(range));
			if (llist != null) {
				for (int lj = 0; lj < llist.size(); lj++) {
					Entity entity1 = (Entity) llist.get(lj);
					if (entity1.canBeCollidedWith()) {
						boolean flag = entity.getEntitySenses().canSee(entity1);
						if (id == 3) {
							if (entity1 != null && entity1 instanceof EntityLivingBase && !entity1.isRiding())
							{
								EntityLivingBase living = (EntityLivingBase) entity1;
								double d5 = entity1.posX - entity.posX;
								double d7 = entity1.posZ - entity.posZ;
								double d6 = entity1.posY - entity.posY;
								double d1 = entity.posY - (entity1.posY);
								double d3 = (double) MathHelper.sqrt(d5 * d5 + d7 * d7);
								float f11 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
								entity.rotationYawHead = entity.rotation = entity.rote = entity.renderYawOffset 
										= -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
								entity.rotationp = entity.rotationPitch = -f11 + 0;
								double ddx = Math.abs(d5);
								double ddz = Math.abs(d7);
								double ddy = Math.abs(d6);
								if (flag && living.getHealth() < living.getMaxHealth() / 2) {
									if ((ddx < 1 && ddz < 1) && entity.cooltime > 40 && living.getHealth() > 0.0F) {
										living.setHealth(living.getHealth() + 4);
										living.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
										entity.cooltime = 0;
										entity.swingArm(EnumHand.MAIN_HAND);
									}
									if ((ddx < range2 && ddz < range2)  && entity.cooltime > 40) {
										MoveS(entity, sp, 1, living.posX, living.posY, living.posZ, 0);
										return;
									}
								}
							}
						}
						else if (entity1 != null && entity1 instanceof EntityVehicleBase && flag && !entity.isRiding()) {
							EntityVehicleBase ve = (EntityVehicleBase) entity1;
							//if (ve.getControllingPassenger() == null)
							double d5 = entity1.posX - entity.posX;
							double d7 = entity1.posZ - entity.posZ;
							double d6 = entity1.posY - entity.posY;
							double ddx = Math.abs(d5);
							double ddz = Math.abs(d7);
							double ddy = Math.abs(d6);
							if ((ddx < 10 && ddz < 10 && ddy < 3)) {
								if(ve.getPassengers().size() < ve.riddng_maximum && ve.getHealth() > 0.0F && !ve.getVehicleLock())
								{
									MoveS(entity, sp, 1, entity1.posX, entity1.posY, entity1.posZ, id);
								}
							}
						}else
						if (entity.CanAttack(entity1) && entity1 != null) {//target
							
							if (entity.targetentity == entity1
									&& ((EntityLivingBase) entity1).getHealth() > 0.0F) {
								double d5 = entity1.posX - entity.posX;
								double d7 = entity1.posZ - entity.posZ;
								double d6 = entity1.posY - entity.posY;
								double d1 = entity.posY - (entity1.posY);
								double d3 = (double) MathHelper.sqrt(d5 * d5 + d7 * d7);
								float f11 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
								entity.rotationYawHead = entity.rotation = entity.rote = entity.renderYawOffset 
										= -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
								entity.rotationp = entity.rotationPitch = -f11 + 0;
								double ddx = Math.abs(d5);
								double ddz = Math.abs(d7);
								double ddy = Math.abs(d6);
								if (flag) {
									entity.noflag = 0;
									++entity.discover_count;
									entity.targetentity_lastposX = entity1.posX;
									entity.targetentity_lastposY = entity1.posY;
									entity.targetentity_lastposZ = entity1.posZ;
									if ((ddx <= range2 && ddz <= range2)) {//attack_range以下なら射撃可能
										entity.setFTMode(1);
									}else {
										entity.setFTMode(0);
									}
									if(ddy > 10) {
									}else {
										if ((ddx > max || ddz > max)) {//maxの距離まで接近
											MoveS(entity, sp, 1, entity1.posX, entity1.posY, entity1.posZ, id);
										}else {//maxの距離まで接近
											MoveS2(entity, sp, entity1.posX, entity1.posY, entity1.posZ, entity.targetentity);
										}
									}
								} else {
									++entity.noflag;
									entity.discover_count = 0;
									entity.setFTMode(0);
									if(entity.noflag > 20 && !(ddy > 10)) 
									{
										//MoveS(entity, sp, 1, entity1.posX, entity1.posY, entity1.posZ, id);
										entity.getNavigator().tryMoveToXYZ(entity1.posX, entity1.posY, entity1.posZ, sp * 10);
										entity.noflag = 0;
									}
								}

								if (flag) {
									entity.targetentity = (EntityLivingBase) entity1;
								}
								break;
							} 
						}//target
						
					}
				}
			}
			}
		}
		if(!entity.getattacktask()){
			stay(entity, id);
			//entity.setattacktask(false);
			//entity.setSneak(false);
		}else{
			
		}
		
	}
	
	
	
	public static void MoveS(EntityGVCLivingBase entity, double speed, double han, double ex, double ey, double ez, int id){
		{// 1
			if(!entity.world.isRemote)
			{
				//this.motionY = 0.2D;
				double ix = 0;
				double iz = 0;
				double iy = entity.motionY;
				float f12 = entity.rotationYaw * (2 * (float) Math.PI / 360);
				float f22 = entity.rotationPitch * (2 * (float) Math.PI / 360);

				double x = entity.posX;
				double y = entity.posY;
				double z = entity.posZ;
				
				double d5 = ex - entity.posX;
				double d7 = ez - entity.posZ;
				
				double root = Math.sqrt(d5 * d5 + d7 * d7);
				
				float off = 0;
				entity.rotationYaw = entity.renderYawOffset = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
				float yaw = entity.rotationYaw * (2 * (float) Math.PI / 360);
				double mox = 0;
				double moy = entity.motionY;
				double moz = 0;
				mox -= MathHelper.sin(yaw) * speed * 1;
				moz += MathHelper.cos(yaw) * speed * 1;
				if (entity.onGround) {
					
				}
				entity.stepHeight = entity.height * 0.8F;
				boolean flag = getObstacle(entity);
				
				//if(entity.world.rand.nextInt(4) == 0) 
				if(flag){
					//entity.getNavigator().tryMoveToXYZ(ex, ey, ez, speed * 10);
					{
						entity.motionX = mox;
						entity.motionZ = moz;
						//entity.motionY = y;
						entity.move(MoverType.PLAYER, entity.motionX, entity.motionY, entity.motionZ);
					}
				}
			}
		} // 1
	}
	
	
	public static void MoveS2(EntityGVCLivingBase entity, double speed, double ex, double ey, double ez, EntityLivingBase target){
		if(target != null){// 1
			
			boolean cansee = entity.getEntitySenses().canSee(target);
			
			if(!entity.world.isRemote)
			{
				//this.motionY = 0.2D;
				double ix = 0;
				double iz = 0;
				double iy = entity.motionY;
				float f12 = entity.rotationYaw * (2 * (float) Math.PI / 360);
				float f22 = entity.rotationPitch * (2 * (float) Math.PI / 360);

				double x = entity.posX;
				double y = entity.posY;
				double z = entity.posZ;
				
				double d5 = ex - entity.posX;
				double d7 = ez - entity.posZ;
				
				double root = Math.sqrt(d5 * d5 + d7 * d7);
				
				float off = 0;
				entity.rotationYaw = entity.renderYawOffset = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
				float yaw = entity.rotationYaw * (2 * (float) Math.PI / 360);
				float yawoffset = 0F;
				double mox = 0;
				double moy = entity.motionY;
				double moz = 0;
				
				if (entity.onGround) {
					
				}
				entity.stepHeight = entity.height * 0.8F;
				boolean flag = getObstacle(entity);
				
				if(entity.getAIType() == 0 || entity.getAIType() == 1) {
					entity.setSneak(true);
					flag = false;
				}else if(entity.getAIType() == 2) {
					  if(cansee) {
					    	yawoffset = -1.57F;
					    	speed = speed *0.5F;
						}
						entity.setSneak(false);
				}else if(entity.getAIType() == 3) {
					  if(cansee) {
					    	yawoffset = 1.57F;
					    	speed = speed *0.5F;
						}
						entity.setSneak(false);
				}
				else {
					if(cansee) {
						speed = speed *-0.70F;
						entity.setSneak(false);
					}
				}
				
				mox -= MathHelper.sin(yaw + yawoffset) * speed * 1;
				moz += MathHelper.cos(yaw + yawoffset) * speed * 1;
				
				if(flag){
					{
						entity.motionX = mox;
						entity.motionZ = moz;
						//entity.motionY = y;
						entity.move(MoverType.PLAYER, entity.motionX, entity.motionY, entity.motionZ);
					}
				}
			}
		} // 1
	}
	
	public static boolean getObstacle(EntityGVCLivingBase entity) {
		boolean flag = true;
		Vec3d lock = Vec3d.fromPitchYaw(entity.rotationPitch, entity.rotationYaw);//entity.getForward();
		BlockPos pos0 = new BlockPos(entity.posX + lock.x * 1, entity.posY - 0,entity.posZ + lock.z * 1);
		BlockPos pos1 = new BlockPos(entity.posX + lock.x * 1, entity.posY - 1,entity.posZ + lock.z * 1);
		BlockPos pos2 = new BlockPos(entity.posX + lock.x * 1, entity.posY - 2,entity.posZ + lock.z * 1);
		
		BlockPos pos3 = new BlockPos(entity.posX + lock.x * 1, entity.posY + 1,entity.posZ + lock.z * 1);
		BlockPos pos4 = new BlockPos(entity.posX + lock.x * 1, entity.posY + 2,entity.posZ + lock.z * 1);
		if (entity.world.getBlockState(pos0).getBlock() == Blocks.LAVA
				|| entity.world.getBlockState(pos0).getBlock() == Blocks.FLOWING_LAVA) {
			 flag = false;
		}
		if (entity.world.getBlockState(pos1).getBlock() == Blocks.LAVA
				|| entity.world.getBlockState(pos1).getBlock() == Blocks.FLOWING_LAVA) {
			 flag = false;
		}
		if (entity.world.getBlockState(pos2).getBlock() == Blocks.LAVA
				|| entity.world.getBlockState(pos2).getBlock() == Blocks.FLOWING_LAVA) {
			 flag = false;
		}
		
		if (entity.world.getBlockState(pos0).getBlock() == Blocks.AIR
				&& entity.world.getBlockState(pos1).getBlock() == Blocks.AIR
				&& entity.world.getBlockState(pos2).getBlock() == Blocks.AIR) {
			 flag = false;
		}
		
		if (entity.world.getBlockState(pos0).getBlock() == Blocks.IRON_BARS
				|| entity.world.getBlockState(pos3).getBlock() == Blocks.IRON_BARS) {
			 flag = false;
		}
		if(entity.getMoveT() == 2) {
			flag = false;
		}
		return flag;
	}
	
	
	
	
	public static void stay(EntityGVCLivingBase entity, int id) {
		entity.setMobMode(0);
		double xPosition = 0;
	    double yPosition = 0;
	    double zPosition = 0;
		if (entity.getIdleTime() >= 100)
        {
        }
        else if (entity.getRNG().nextInt(120) != 0)
        {
        }
        else
        {
            Vec3d vec3 = RandomPositionGenerator.findRandomTarget(entity, 10, 7);

            if (vec3 == null)
            {
            }
            else
            {
                xPosition = vec3.x;
                yPosition = vec3.y;
                zPosition = vec3.z;
            }
            entity.rotation = entity.rotationYawHead = entity.getRNG().nextInt(120) - 60;
        }
		{
			if(entity.rote > 180F){
				entity.rote = -179F;
			}
			if(entity.rote < -180F){
				entity.rote = 179F;
			}
			float f3 = (float) (entity.rotationYawHead - entity.rote);
			 if(entity.rotationYawHead != entity.rote){
         		if(f3 > 1){
 					if(f3 > 180F){
 						entity.rotationYaw = entity.rotationYaw + 1;
 					}else{
 						entity.rotationYaw = entity.rotationYaw - 1;
 					}
 				}
 				else if(f3 < -1){
 					if(f3 < -180F){
 						entity.rotationYaw = entity.rotationYaw - 1;
 					}else{
 						entity.rotationYaw = entity.rotationYaw + 1;
 					}
 				}
	            }
		}
		if(id != 0 && entity.getMoveT() != 3) {
			entity.getNavigator().tryMoveToXYZ(xPosition, yPosition, zPosition, 1D);
		}
		if(entity.isRiding()) {
			/*if(entity.getAIType() == 3) 
			{
				if(entity.ontick <= 5) {
					entity.rotationPitch = entity.rotationPitch - 4;
				}else if(entity.ontick >= 5 && entity.ontick <= 15) {
					entity.rotationPitch = entity.rotationPitch + 4;
				}else {
					entity.rotationPitch = entity.rotationPitch - 4;
				}
			}*/
		}
	}
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static void MoveT(EntityGVCLivingBase entity, double speed, double han, double ex, double ey, double ez, int id){
		{// 1
			if(!entity.world.isRemote)
			{
				double ix = 0;
				double iz = 0;
				double iy = entity.motionY;
				float f12 = entity.rotationYaw * (2 * (float) Math.PI / 360);
				float f22 = entity.rotationPitch * (2 * (float) Math.PI / 360);

				double x = entity.posX;
				double y = entity.posY;
				double z = entity.posZ;
				
				double d5 = ex - entity.posX;
				double d7 = ez - entity.posZ;
				
				double root = Math.sqrt(d5 * d5 + d7 * d7);
				
				float off = 0;
				entity.rotationYaw = entity.renderYawOffset = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
				float yaw = entity.rotationYaw * (2 * (float) Math.PI / 360);
				entity.stepHeight = entity.height * 0.8F;
				Vec3d lock = Vec3d.fromPitchYaw(entity.rotationPitch, entity.rotationYaw);//entity.getForward();
				//if(id == 0) 
				{
					double mox = 0;
					double moy = entity.motionY;
					double moz = 0;
					float yawoffset = 0F;
					for(int xx = 0; xx < 2; ++xx){
						for(int zz = 0; zz < 2; ++zz){
							//for(int yy = 0; yy < 3; ++yy)
							{
								BlockPos pos1 = new BlockPos(entity.posX + lock.x * xx, entity.posY - 1,entity.posZ + lock.z * zz);
								BlockPos pos2 = new BlockPos(entity.posX + lock.x * xx, entity.posY - 2,entity.posZ + lock.z * zz);
								if (entity.world.getBlockState(pos1).getBlock() == Blocks.AIR
										&&entity.world.getBlockState(pos2).getBlock() == Blocks.AIR) {
									double xyaw = 0;
									double zyaw = 0;
									xyaw -= MathHelper.sin(yaw + 1.57F) * xx;
									zyaw += MathHelper.cos(yaw + 1.57F) * zz;
									BlockPos pos3 = new BlockPos(entity.posX + xyaw, entity.posY - 1,entity.posZ + zyaw);
									BlockPos pos4 = new BlockPos(entity.posX + xyaw, entity.posY - 2,entity.posZ + zyaw);
									if (entity.world.getBlockState(pos3).getBlock() == Blocks.AIR
											&&entity.world.getBlockState(pos4).getBlock() == Blocks.AIR) {
										yawoffset = -1.57F;
									}else {
										yawoffset = 1.57F;
									}
								}
							}
						}
					}
					mox -= MathHelper.sin(yaw) * speed * 1;
					moz += MathHelper.cos(yaw) * speed * 1;
					if(entity.getAIType() != 1) 
					{
						/*if(entity.cooltime4 > 20){
							entity.getNavigator().tryMoveToXYZ(ex, ey, ez, speed * 10);
							entity.cooltime4 = 0;
						}*/
						{
							BlockPos pos0 = new BlockPos(entity.posX, entity.posY + 0,entity.posZ);
							BlockPos pos1 = new BlockPos(entity.posX, entity.posY + 1,entity.posZ);
							if (entity.world.getBlockState(pos0).getBlock() instanceof BlockLadder 
									|| entity.world.getBlockState(pos1).getBlock() instanceof BlockLadder) {
								entity.motionY = 0.2;
							}
							entity.motionX = mox;
							entity.motionZ = moz;
							//entity.motionY = y;
							entity.move(MoverType.PLAYER, entity.motionX, entity.motionY, entity.motionZ);
						}
					}
				}
			}
		} // 1
	}
	
	public static boolean getBlock(Block block) {
		boolean flag = false;
		if(block == Blocks.WATER
				|| block == Blocks.FLOWING_WATER
				|| block == Blocks.LAVA
				|| block == Blocks.FLOWING_LAVA
				|| block == Blocks.AIR) {
			flag = true;
		}
		return flag;
		
	}
	public static boolean getBlockfalse(Block block) {
		boolean flag = false;
		if(block != Blocks.WATER
				&& block != Blocks.FLOWING_WATER
				&& block != Blocks.LAVA
				&& block != Blocks.FLOWING_LAVA
				&& block != Blocks.AIR) {
			flag = true;
		}
		return flag;
		
	}
	
}


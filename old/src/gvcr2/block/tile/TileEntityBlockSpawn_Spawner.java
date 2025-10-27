package gvcr2.block.tile;

import java.util.List;

import javax.annotation.Nullable;

import gvclib.entity.EntityBBase;
import gvclib.entity.EntityTNTBase;
import gvclib.entity.living.ISoldier;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.so.EntityGVCR2_SO_S;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_AA_20mmAA;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_AA_VADS;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_AA_Zu23;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_CANNON_Flak18;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_CANNON_Pak40;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_MG_M2;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_MG_M60;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_MORTAR_M224;
import gvcr2.entity.vehicle.ship.EntityGVCR2_SHIP_CRUISER;
import gvcr2.entity.vehicle.ship.EntityGVCR2_SHIP_PR1204;
import gvcr2.entity.vehicle.ship.EntityGVCR2_SHIP_RHIB;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityBlockSpawn_Spawner extends TileEntity implements ITickable
{
	public boolean spawn = false;
	
	public int id = 0;
	
    private int count = 0;
	
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
        
        if(!mod_GVCR2.cfg_building_dungeon_spawner) {
        	if(!this.world.isRemote){
            	this.world.setBlockToAir(pos);
            }
        }
        
       /* if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_blockspawner_ge_s) {
			double han = 0.3;
			AxisAlignedBB aabb = (new AxisAlignedBB((double) (x - han), (double) (y - han),
					(double) (z - han),
					(double) (x + han), (double) (y + han), (double) (z + han)))
							.grow(han);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	            for (int lj = 0; lj < llist2.size(); lj++) {
	            	Entity entity1 = (Entity)llist2.get(lj);
	                {
	            		if ((entity1 instanceof IProjectile) && entity1 != null && !(entity1 instanceof EntityTNTBase))
	                    {
	            			if(entity1 instanceof EntityBBase) {
	            				EntityBBase bullet = (EntityBBase) entity1;
	            				{
	            					{
            							this.world.playSound((EntityPlayer)null, x, y, z, SoundEvents.ENTITY_GENERIC_EXPLODE, 
            									SoundCategory.BLOCKS, 4.0F, (1.0F + (this.world.rand.nextFloat() - this.world.rand.nextFloat()) * 0.2F) * 0.7F);
            							this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, x, y, z, 1.0D, 0.0D, 0.0D);
            						}
	            					if (!entity1.world.isRemote) 
									{
			            				//GVCExplosionBase.ExplosionKai(entity1, this,x, y, z, 1.0F, false,  false);
	            						this.world.setBlockToAir(pos);
										entity1.setDead();
									}
	            				}
	            			}
	                    }
	                }
	            }
	        }
    	}*/
        
        
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_bouy) {
        	id = 3;
        	this.canspawn2(x, y, z, 80);
        	 float xx = this.pos.getX();
          	float yy = this.pos.getY();
          	float zz = this.pos.getZ();
          	double xxx = this.pos.getX() + 0.5D;
            double yyy = this.pos.getY();
        	double zzz = this.pos.getZ() + 0.5D;
          	boolean vehicle_lock = false;
          	 if(spawn && !this.world.isRemote){
          		if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_bouy) {
          			int ran = this.world.rand.nextInt(7);
          			if(ran == 0 && mod_GVCR2.difficult_level >= 4) {
          				EntityGVCR2_SHIP_PR1204 mob = new EntityGVCR2_SHIP_PR1204(this.world);
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
          			}else if(ran == 1 || ran == 2 || ran == 3) {
          				EntityGVCR2_SHIP_CRUISER mob = new EntityGVCR2_SHIP_CRUISER(this.world);
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
          			else {
          				EntityGVCR2_SHIP_RHIB mob = new EntityGVCR2_SHIP_RHIB(this.world);
        				mob.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
        				mob.setcanDespawn(1);
        				if(vehicle_lock)mob.setVehicleLock(true);
        				mob.setMoveX((int)xx);
        				mob.setMoveY((int)yy);
        				mob.setMoveZ((int)zz);
        				this.world.spawnEntity(mob);
        				if(!vehicle_lock){
        					for(int r = 0; r < 4; ++r) {
        						EntityGVCR2_GE_S mob2 = new EntityGVCR2_GE_S(this.world);
            	        		mob2.setLocationAndAngles(xxx, yyy, zzz, 0, 0.0F);
            					mob2.setcanDespawn(1);
            					//if(r != 0)mob2.setWeapon(false);
            					this.world.spawnEntity(mob2);
            					mob2.startRiding(mob);
        					}
        				}
          			}
            	}
          		if(!this.world.isRemote){
                	//this.world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 2);
                	this.world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 2);
                	this.world.setBlockToAir(pos);
                }
          	 }
        }else {
        	 if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_blockspawner_ge_s) {
             	id = 0;
             }
        	 else if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_blockspawner_so_s) {
             	id = 1;
             }
             
             if(count >= 300){
             	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_blockspawner_ge_s) {
             		
             		if(this.canspawn(x, y, z, 30, 20) && !this.world.isRemote){
             			int i = this.world.rand.nextInt(3) + 1;
         		        for(int ii = 0; ii < i; ++ii){
         		        	int ix = this.world.rand.nextInt(10);
         					int iz = this.world.rand.nextInt(10);
         					BlockPos spawnpos = new BlockPos(x - 5 + ix, y + 1, z - 5 + iz);
         					BlockPos spawnpos2 = new BlockPos(x - 5 + ix, y + 2, z - 5 + iz);
         					if(this.world.getBlockState(spawnpos).getBlock() == Blocks.AIR
         							&& this.world.getBlockState(spawnpos2).getBlock() == Blocks.AIR) {
         						EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(this.world);
             		        	entityskeleton.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
             		        	entityskeleton.setWeapon(true);
             			        this.world.spawnEntity(entityskeleton);
         					}
         		        }
                 	}
             	}else if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_blockspawner_so_s) {
             		
             		if(this.canspawnAlly(x, y, z, 30, 20) && !this.world.isRemote){
             			int i = this.world.rand.nextInt(3) + 1;
         		        for(int ii = 0; ii < i; ++ii){
         		        	int ix = this.world.rand.nextInt(10);
         					int iz = this.world.rand.nextInt(10);
         					BlockPos spawnpos = new BlockPos(x - 5 + ix, y + 1, z - 5 + iz);
         					BlockPos spawnpos2 = new BlockPos(x - 5 + ix, y + 2, z - 5 + iz);
         					if(this.world.getBlockState(spawnpos).getBlock() == Blocks.AIR
         							&& this.world.getBlockState(spawnpos2).getBlock() == Blocks.AIR) {
         						EntityGVCR2_SO_S entityskeleton = new EntityGVCR2_SO_S(this.world);
             		        	entityskeleton.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
             		        	entityskeleton.setWeapon();
             			        this.world.spawnEntity(entityskeleton);
         					}
         		        }
                 	}
             	}
             	
             	count = 0;
             }
             if(count < 301)++count;
        }
        
        
       
        
        
    }
        
        
        public boolean canspawn(double x, double y, double z, int han, int han2) {
        	boolean flag = false;
        	boolean canspawn = false;
        	int mob = 0;
        	
        	{
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
                        			canspawn = true;
                        		}
                            }
                        }
                    }
                }
        	}
        	if(canspawn){
        		Entity entity = null;
            	AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(x-han2), (double)(y-han2), (double)(z-han2), 
            			(double)(x + han2), (double)(y + han2), (double)(z+ han2)))
                		.grow(1);
                List llist2 = this.world.getEntitiesWithinAABBExcludingEntity(entity, axisalignedbb2);
                if(llist2!=null){
                    for (int lj = 0; lj < llist2.size(); lj++) {
                    	
                    	Entity entity1 = (Entity)llist2.get(lj);
                    	if (entity1.canBeCollidedWith())
                        {
                    		if (entity1 instanceof IMob && entity1 != null)
                            {
                    			/*if (entity1 instanceof EntityGVCR2_GE_S)
                                {
                    				EntityGVCR2_GE_S ge = (EntityGVCR2_GE_S) entity1;
                    				if(ge.getcanDespawn() != 1) {
                    					++mob;
                    				}
                    				
                                }else {
                                	++mob;
                                }*/
                    			++mob;
                            }
                        }
                    }
                }
                if(mob < 5) {
                	flag = true;
                }
        	}
        	return flag;
        }
        
        public boolean canspawnAlly(double x, double y, double z, int han, int han2) {
        	boolean flag = false;
        	boolean canspawn = false;
        	int mob = 0;
        	
        	{
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
                        			canspawn = true;
                        		}
                            }
                        }
                    }
                }
        	}
        	if(canspawn){
        		Entity entity = null;
            	AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(x-han2), (double)(y-han2), (double)(z-han2), 
            			(double)(x + han2), (double)(y + han2), (double)(z+ han2)))
                		.grow(1);
                List llist2 = this.world.getEntitiesWithinAABBExcludingEntity(entity, axisalignedbb2);
                if(llist2!=null){
                    for (int lj = 0; lj < llist2.size(); lj++) {
                    	
                    	Entity entity1 = (Entity)llist2.get(lj);
                    	if (entity1.canBeCollidedWith())
                        {
                    		if (entity1 instanceof ISoldier && entity1 != null)
                            {
                    			++mob;
                            }
                        }
                    }
                }
                if(mob < 4) {
                	flag = true;
                }
        	}
        	return flag;
        }
        
        
        public void canspawn2(double x, double y, double z, int han) {
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
								if ((ddx < 20 && ddz < 20)) {
									spawn = true;
									break;
								}
                    			if(rayTraceBlocks(new Vec3d(this.pos.getX() + 0.1, this.pos.getY() + 0.85, this.pos.getZ() + 0.1), 
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

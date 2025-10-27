package gvcr2.block.tile;
 
import java.util.List;

import javax.annotation.Nullable;

import gvcr2.mod_GVCR2;
import gvcr2.block.Block_Supplies;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
 
public class TileEntity_Supplies extends TileEntity implements ITickable
{
	public boolean spawn = false;
	
	public int count = 0;
	
	public int id = 0;
	
	public int facing = 0;
	
	public boolean can_view = false;
    
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
        
        if(this.world.getBlockState(pos).getBlock() instanceof Block_Supplies) {
        	Block_Supplies gubcrafter = (Block_Supplies) this.world.getBlockState(pos).getBlock();
    		EnumFacing enumfacing = (EnumFacing)this.world.getBlockState(pos).getValue(gubcrafter.FACING);
    		if(enumfacing == EnumFacing.SOUTH) {
    			facing = 1;
    		}else if(enumfacing == EnumFacing.WEST) {
    			facing = 2;
    		}else if(enumfacing == EnumFacing.EAST) {
    			facing = 3;
    		}else {
    			facing = 0;
    		}
    	}
        
        if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_supplies_1) {
        	this.id = 1;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_supplies_2) {
        	this.id = 2;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_supplies_3) {
        	this.id = 3;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_supplies_4) {
        	this.id = 4;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_supplies_scrap) {
        	this.id = 5;
        }
        else if(this.world.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_cadaver_g) {
        	this.id = 6;
        }
        else {
        	can_view = this.canspawn(x, y, z, 20);
        	this.id = 0;
        }
	}
	
    public boolean canspawn(double x, double y, double z, int han) {
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
            			{
                			if(rayTraceBlocks(new Vec3d(this.pos.getX() + 0.1, this.pos.getY() + 0.85, this.pos.getZ() + 0.1), 
                					new Vec3d(entity1.posX, entity1.posY + (double)entity1.getEyeHeight(), entity1.posZ), false, true, false) == null) 
                			{
                				flag = true;
                			}
                		}
                    }
                }
            }
        }
        return flag;
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
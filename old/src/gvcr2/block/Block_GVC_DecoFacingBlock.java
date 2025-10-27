package gvcr2.block;

import java.util.Random;

import javax.annotation.Nullable;

import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.block.tile.TileEntity_GVC_DecoFacingBlock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Block_GVC_DecoFacingBlock extends BlockContainer
{
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    protected static final AxisAlignedBB normal = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB half = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	protected static final AxisAlignedBB at_obstacles = new AxisAlignedBB(-0.5D, 0.0D, -0.5D, 1.5D, 1.5D, 1.5D);
    //private final boolean isBurning;
    //private static boolean keepInventory;

    public int id = 0;
    public boolean aabb = true;
    
    //public static  mod_GVCR2 mod = mod_GVCR2.INSTANCE;
    
    public Block_GVC_DecoFacingBlock(int i, boolean true_aabb)
    {
    	 super(Material.IRON);
         this.setHardness(5F);
         this.setResistance(10.0F);
         this.setSoundType(SoundType.METAL);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        
        id = i;
        aabb = true_aabb;
       // this.isBurning = isBurning;
        if(i == 22 || i == 46 || i == 47 || i == 49 || i == 50 || i == 51) {
        	 setLightOpacity(1);
             setLightLevel(1.0F);
        }
    }

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		
		
		if (id == 0) {
			for (int y = 0; y < 8; ++y) {
				spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_bullet_9mmhg));
			}
		}
		else if (id == 1) {
			for (int y = 0; y < 8; ++y) {
				spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_bullet_45calhg	));
			}
		}
		else if (id == 2) {
			for (int y = 0; y < 8; ++y) {
				spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_bullet_22calar));
			}
		}
		else if (id == 3) {
			for (int y = 0; y < 8; ++y) {
				spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_bullet_30calrf));
			}
		}
		else if (id == 4) {
			for (int y = 0; y < 8; ++y) {
				spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_bullet_50calrf));
			}
		}
		else if (id == 5) {
			for (int y = 0; y < 8; ++y) {
				spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_bullet_12gasg));
			}
		}
		else if (id == 6) {
			for (int y = 0; y < 8; ++y) {
				spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_bullet_40mmgl));
			}
		}
		else if (id == 7) {
			for (int y = 0; y < 8; ++y) {
				spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_grenade_frag));
			}
		}
		else if (id == 8) {
			for (int y = 0; y < 8; ++y) {
				spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_bullet_76mmrl));
			}
		}
		else if (id == 9) {
			for (int y = 0; y < 8; ++y) {
				spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_bullet_84mmrl));
			}
		}
		else {
			super.breakBlock(worldIn, pos, state);
		}
	}
    
    /*@Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }*/
    
    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    	if (id == 0) {
    		return mod_GVCR2.gvcr2_bullet_9mmhg;
    	}
    	else if (id == 1) {
    		return mod_GVCR2.gvcr2_bullet_45calhg;
    	}
    	else if (id == 2) {
    		return mod_GVCR2.gvcr2_bullet_22calar;
    	}
    	else if (id == 3) {
    		return mod_GVCR2.gvcr2_bullet_30calrf;
    	}
    	else if (id == 4) {
    		return mod_GVCR2.gvcr2_bullet_50calrf;
    	}
    	else if (id == 6) {
    		return mod_GVCR2.gvcr2_bullet_40mmgl;
    	}
    	else if (id == 5) {
    		return mod_GVCR2.gvcr2_bullet_12gasg;
    	}
    	else if (id == 8) {
    		return mod_GVCR2.gvcr2_bullet_76mmrl;
    	}
    	else if (id == 9) {
    		return mod_GVCR2.gvcr2_bullet_84mmrl;
    	}
    	else if (id == 7) {
    		return mod_GVCR2.gvcr2_grenade_frag;
    	}
    	else {
    		return super.getItemDropped(state, rand, fortune);
    	}
        //return Item.getItemFromBlock(mod_GVCR2.gvcr2_block_gunrack_hsin);
    }

    
    /**
     * Called after the block is set in the Chunk data, but before the Tile Entity is set
     */
   /*public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
	   TileEntity tileentity = worldIn.getTileEntity(pos);

    }*/
    
   //240224右クリック判定が吸われるので廃止
    /**
     * Called when the block is right clicked by a player.
     */
   /* public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
        	 TileEntity tileentity = worldIn.getTileEntity(pos);

             
            return true;
        }
        else
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

           

            return true;
        }
    }*/

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntity_GVC_DecoFacingBlock();
    }

    /**
     * Called by ItemBlocks after a block is set in the world, to allow post-place logic
     */
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);

        if (stack.hasDisplayName())
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

           /* if (tileentity instanceof TileEntity_GunRack)
            {
                ((TileEntity_GunRack)tileentity).setCustomInventoryName(stack.getDisplayName());
            }*/
        }
    }

    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.north());
            IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
            IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
            IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

            if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock())
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock())
            {
                enumfacing = EnumFacing.NORTH;
            }
            else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock())
            {
                enumfacing = EnumFacing.EAST;
            }
            else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock())
            {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
    }
    
    /**
     * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
     * IBlockstate
     */
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }
    
    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }
    

    /**
     * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
     * IBlockstate
     */
   /* public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }*/
    
    public boolean hasComparatorInputOverride(IBlockState state)
    {
        return true;
    }

    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return Container.calcRedstone(worldIn.getTileEntity(pos));
    }

    /*public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(mod_GVCR2.gvcr2_block_gunrack_hsin);
    }*/

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    /**
     * Called when this Block is destroyed by an Explosion
     */
    public void onBlockExploded(World worldIn, BlockPos pos, Explosion explosion)
    {
    	double x = pos.getX();
    	double y = pos.getY();
    	double z = pos.getZ();
    	 if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_m18_claymore) {
 			//if (!worldIn.isRemote) 
 			 {
 					GVCExplosionBase.ExplosionKai(null, null, x, y + 0.5, z, 3.5F, false,  true);
 					worldIn.setBlockToAir(pos);
 				}
 		 }else
    	 if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_missile_rack1) {
 			//if (!worldIn.isRemote) 
 		    	{
 					GVCExplosionBase.ExplosionKai(null, null, x, y + 0.5, z, 5F, false,  mod_GVCR2.cfg_exprotion_grenade);
 					worldIn.setBlockToAir(pos);
 				}
 		 }else
 		if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_artibox1
 				|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_artibox2
 				|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_artibox3) {
 			//if (!worldIn.isRemote) 
 		    	{
 					GVCExplosionBase.ExplosionKai(null, null, x, y + 0.5, z, 3.5F, false,  mod_GVCR2.cfg_exprotion_grenade);
 					worldIn.setBlockToAir(pos);
 				}
 		 }else
 		if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_grenade_box_gc
 				|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_rpg_ammobox1
 				|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_rpg_ammobox2
 				|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_m18_claymore) {
 			//if (!worldIn.isRemote) 
 		    	{
 					GVCExplosionBase.ExplosionKai(null, null, x, y + 0.5, z, 3.5F, false,  false);
 					worldIn.setBlockToAir(pos);
 				}
 		 }else
 		if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_barrel_drum1
 				|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_barrel_drum2
 				|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_jerrycan1
 				|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_m18_claymore) {
 			//if (!worldIn.isRemote) 
 		    	{
 					GVCExplosionBase.ExplosionKai(null, null, x, y + 0.5, z, 3.5F, true,  false);
 					worldIn.setBlockToAir(pos);
 				}
 		 }else
 		if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_missile_rack1) {
 			//if (!worldIn.isRemote) 
 		    	{
 					GVCExplosionBase.ExplosionKai(null, null, x, y + 0.5, z, 5F, false,  mod_GVCR2.cfg_exprotion_grenade);
 					worldIn.setBlockToAir(pos);
 				}
 		 }else {
 			 super.onBlockExploded(worldIn, pos, explosion);
 		 }
    }
    
    /**
     * Called When an Entity Collided with the Block
     */
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
    	if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_barbed1_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_barbed2_gc
    			) {
    		if(entityIn instanceof EntityLivingBase)entityIn.attackEntityFrom(DamageSource.CACTUS, 1.0F);
    		entityIn.setInWeb();
    	}
    	double x = pos.getX();
    	double y = pos.getY();
    	double z = pos.getZ();
    	if(entityIn instanceof EntityLivingBase){
    		EntityLivingBase en = (EntityLivingBase) entityIn;
    		 if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_m18_claymore) {
    			//if (!worldIn.isRemote) 
    			 {
    					GVCExplosionBase.ExplosionKai(entityIn, entityIn, x, y + 0.5, z, 3.5F, false,  true);
    					worldIn.setBlockToAir(pos);
    				}
    		 }
    	}
    	if(entityIn instanceof IProjectile){
    		if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_missile_rack1) {
    			//if (!worldIn.isRemote) 
    		    	{
    					GVCExplosionBase.ExplosionKai(entityIn, entityIn, x, y + 0.5, z, 5F, false,  mod_GVCR2.cfg_exprotion_grenade);
    					worldIn.setBlockToAir(pos);
    				}
    		 }
    		if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_artibox1
    				|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_artibox2
    				|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_artibox3) {
    			//if (!worldIn.isRemote) 
    		    	{
    					GVCExplosionBase.ExplosionKai(entityIn, entityIn, x, y + 0.5, z, 3.5F, false,  mod_GVCR2.cfg_exprotion_grenade);
    					worldIn.setBlockToAir(pos);
    				}
    		 }
    		if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_grenade_box_gc
    				|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_rpg_ammobox1
    				|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_rpg_ammobox2
    				|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_m18_claymore) {
    			//if (!worldIn.isRemote) 
    		    	{
    					GVCExplosionBase.ExplosionKai(entityIn, entityIn, x, y + 0.5, z, 3.5F, false,  false);
    					worldIn.setBlockToAir(pos);
    				}
    		 }
    		if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_barrel_drum1
    				|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_barrel_drum2
    				|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_jerrycan1
    				|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_m18_claymore) {
    			//if (!worldIn.isRemote) 
    		    	{
    					GVCExplosionBase.ExplosionKai(entityIn, entityIn, x, y + 0.5, z, 3.5F, true,  false);
    					worldIn.setBlockToAir(pos);
    				}
    		 }
    		if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_missile_rack1) {
    			//if (!worldIn.isRemote) 
    		    	{
    					GVCExplosionBase.ExplosionKai(entityIn, entityIn, x, y + 0.5, z, 5F, false,  mod_GVCR2.cfg_exprotion_grenade);
    					worldIn.setBlockToAir(pos);
    				}
    		 }
    	}
    }
    
    
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        //return NULL_AABB;
    	if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_at_obstacles) {
    		return at_obstacles;
    	}
    	else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_9mmpack_gc	
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_45pack_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_223pack_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_308pack_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_50bmgpack_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_12gpack_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_40mmgr_ammo_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_grenade_box_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_rpg_ammobox1
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_rpg_ammobox2
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_sandbag_a2_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_sandbag_b2_gc	
    			) {
    		return half;
    	}
    	else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_barbed1_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_barbed2_gc
    			) {
    		return NULL_AABB;
    	}
    	else if(!aabb) {
    		return NULL_AABB;
    	}
		 else {
			 return normal;
		 }
    }
    /**
     * Return an AABB (in world coords!) that should be highlighted when the player is targeting this Block
     */
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
    {
    	if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_at_obstacles) {
    		return at_obstacles.offset(pos);
    	}
    	else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_9mmpack_gc	
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_45pack_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_223pack_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_308pack_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_50bmgpack_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_12gpack_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_40mmgr_ammo_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_grenade_box_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_rpg_ammobox1
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_rpg_ammobox2
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_sandbag_a2_gc
    			|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_sandbag_b2_gc	
    			) {
    		return half;
    	}
		 else {
			 return normal.offset(pos);
		 }
    }
    
    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    /**
     * The type of render function called. 3 for standard block models, 2 for TESR's, 1 for liquids, -1 is no render
     */
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
    
}
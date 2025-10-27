package gvcr2.block;

import java.util.Random;

import javax.annotation.Nullable;

import gvcr2.mod_GVCR2;
import gvcr2.block.tile.TileEntityBlock_GunRack_Deco;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Block_GunRack_Deco extends BlockContainer
{
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    //private final boolean isBurning;
    //private static boolean keepInventory;

    private int id = 0;
    
    public Block_GunRack_Deco(int i)
    {
    	 super(Material.IRON);
         this.setHardness(5F);
         this.setResistance(10.0F);
         this.setSoundType(SoundType.METAL);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        
        id = i;
       // this.isBurning = isBurning;
    }

    
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
    
    /**
     * Get the Item that this Block should drop when harvested.
     */
    /*public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(mod_GVCR2.gvcr2_block_gunrack_hsin);
    }*/

    
    /**
     * Called after the block is set in the Chunk data, but before the Tile Entity is set
     */
   public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
	   TileEntity tileentity = worldIn.getTileEntity(pos);

    }
    
    /**
     * Called when the block is right clicked by a player.
     */
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
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
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityBlock_GunRack_Deco();
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
     * Called serverside after this block is replaced with another in Chunk, but before the Tile Entity is updated
     */
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
    	 if(id == 0) {
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_m9));
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_m9));
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_m9));
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_block_gunrack_hsin));
    	 }
    	 else if(id == 1) {
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_m16a2));
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_m16a2));
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_m16a2));
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_block_gunrack_rsin));
    	 }
    	 else if(id == 2) {
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_ak47));
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_ak47));
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_ak47));
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_block_gunrack_rswn));
    	 }
    	 else if(id == 3) {
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_g17));
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_g17));
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_block_gunrack_hti));
    	 }
    	 else if(id == 4) {
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_m14));
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_block_gunrack_rti1));
    	 }
    	 else if(id == 5) {
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_m14));
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_m14));
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_block_gunrack_rti2));
    	 }
    	 else {
    		 super.breakBlock(worldIn, pos, state);
    	 }
        //
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 0;
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
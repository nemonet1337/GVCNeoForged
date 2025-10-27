package gvcr2.block;

import java.util.Random;

import javax.annotation.Nullable;

import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.block.tile.TileEntity_Mine;
import gvcr2.block.tile.TileEntity_Supplies;
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Block_Supplies extends BlockContainer
{
	
	protected static final AxisAlignedBB CACTUS_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	
	protected static final AxisAlignedBB air_box = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB Box = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB Backpack = new AxisAlignedBB(0.2D, 0.0D, 0.2D, 0.8D, 0.3D, 0.8D);
	protected static final AxisAlignedBB cadaver = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.4D, 1.0D);
	protected static final AxisAlignedBB T34Breaked = new AxisAlignedBB(-1.0D, 0.0D, -1.0D, 2.0D, 2.2D, 2.0D);
	protected static final AxisAlignedBB scrap = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	private int id = 0;
	
    public Block_Supplies(int i)
    {
    	super(Material.IRON);
    	setHardness(0.5F);
        setSoundType(SoundType.CLOTH);
        setResistance(1.0F);
    //    setLightOpacity(1);
    //    setLightLevel(0.8F);
        id = i;
        
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }
    
    
    @Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntity_Supplies();
	}
    
    public void onBlockExploded(World world, BlockPos pos, Explosion explosion)
    {
        world.setBlockToAir(pos);
        //onBlockDestroyedByExplosion(world, pos, explosion);
    }
    
    /**
     * Spawns this Block's drops into the World as EntityItems.
     */
    /**　爆発等によるドロップチャンス？*/
    @Override
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {}
    
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
    	int ii = worldIn.rand.nextInt(8);
    	int il = worldIn.rand.nextInt(4);
    	int ik = worldIn.rand.nextInt(10);
    	 if(id == 1) {
    		 if(ii == 0) {
    			 for(int y = 0; y< 30; ++y){
    	      			spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_bullet_9mmhg));
    	      		}
    		 }
    		 else if(ii == 1) {
    			 for(int y = 0; y< 8; ++y){
 	      			spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_bullet_76mmrl));
 	      		}
    		 }
    		 else if(ii == 2) {
    			 for(int y = 0; y< 20; ++y){
 	      			spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_bullet_30calrf));
 	      		}
    		 }
    		 else{
    			 for(int y = 0; y< 30; ++y){
    	      			spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_bullet_22calar));
    	      		}
    		 }
    	 }else if(id == 2) {
    		 if(ii == 0) {
    			 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_m4a1));
    		 }
    		 else if(ii == 1) {
    			 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_m14));
    		 }
    		 else if(ii == 2) {
    			 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_m72));
    		 }
    		 else{
    			 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_m16a1));
    		 }
    	 }else if(id == 3) {
    		 for(int y = 0; y< il+4; ++y){
    			 int ran = worldIn.rand.nextInt(3);
    			 if(ran == 0) {
    				 spawnAsEntity(worldIn, pos, new ItemStack(Items.IRON_INGOT));
    			 }else {
    				 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_item_scrap));
    			 }
     		}
    	 }
    	 else if(id == 4) {
    		 
    	 }
    	 else if(id == 5) {
    		 
    		 if(ik == 0) {
    			 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_mp40));
    		 }
    		 else if(ik == 1) {
    			 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_m1891));
    		 }
    		 else if(ik == 2) {
    			 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_panzerfaust));
    		 }
    		 else{
    			 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_item_scrap));
    		 }
    	 }
    	 else {
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_m4));
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_gun_m9));
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_item_pad));
    		 spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_item_binoculars));
    		 for(int y = 0; y< 64; ++y){
      			spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_bullet_9mmhg));
      		}
    		 for(int y = 0; y< 120; ++y){
      			spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_bullet_22calar));
      		}
    		 for(int y = 0; y< 16; ++y){
      			spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_item_bandage));
      		}
    		 for(int y = 0; y< 8; ++y){
      			spawnAsEntity(worldIn, pos, new ItemStack(Items.BREAD));
      		}
    		 for(int y = 0; y< 3; ++y){
       			spawnAsEntity(worldIn, pos, new ItemStack(mod_GVCR2.gvcr2_grenade_frag));
       		}
    	 }
    	
        super.breakBlock(worldIn, pos, state);
    }
    
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
    	 if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_supplies_1) {
    		return  Backpack;
    	}else  if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_supplies_2) {
    		return  cadaver;
    	}else  if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_supplies_3) {
    		setHardness(5.0F);
        	setSoundType(SoundType.STONE);
        	setResistance(10.0F);
    		return  T34Breaked;
    	}else  if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_supplies_4) {
    		return  Box;
    	}else  if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_supplies_scrap) {
    		return  scrap;
    	}else{
    		return  air_box;
    	}
    }
    /**
     * Return an AABB (in world coords!) that should be highlighted when the player is targeting this Block
     */
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
    {
    	if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_supplies_1) {
    		return  Backpack.offset(pos);
    	}else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_supplies_2) {
    		return  cadaver.offset(pos);
    	}else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_supplies_3) {
    		return  T34Breaked.offset(pos);
    	}else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_supplies_4) {
    		return  Box.offset(pos);
    	}else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_supplies_scrap) {
    		return  scrap.offset(pos);
    	}else{
    		return  air_box.offset(pos);
    	}
        //return CACTUS_AABB.offset(pos);
    }
    
    
    
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, @Nullable ItemStack stack)
    {
        /*if (false && !worldIn.isRemote && stack != null && stack.getItem() == Items.SHEARS) // Forge: Noop Taken care of by IShearable
        {
            player.addStat(StatList.getBlockStats(this));
            spawnAsEntity(worldIn, pos, new ItemStack(Blocks.TALLGRASS, 1, ((BlockTallGrass.EnumType)state.getValue(TYPE)).getMeta()));
        }
        else*/
        {
            //super.harvestBlock(worldIn, player, pos, state, te, stack);
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
}
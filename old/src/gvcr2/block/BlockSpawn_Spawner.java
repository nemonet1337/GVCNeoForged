package gvcr2.block;

import javax.annotation.Nullable;

import gvclib.entity.EntityBBase;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.block.tile.TileEntityBlockSpawn_ONE;
import gvcr2.block.tile.TileEntityBlockSpawn_Spawner;
import gvcr2.event.level.GVCR2WorldDifficultyLevel;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSpawn_Spawner extends BlockContainer
{

    public BlockSpawn_Spawner()
    {
        super(Material.WOOD);
        //this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(DAMAGE, Integer.valueOf(0)));
        setHardness(1.5F);
        setResistance(5.0F);
        setLightOpacity(1);
        setLightLevel(1.0F);
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
    	 if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_bouy) {
    		 
    	 }else {
    		 if(mod_GVCR2.difficult_level < 3)GVCR2WorldDifficultyLevel.setLevel(mod_GVCR2.INSTANCE, worldIn, 3, "levelUp3");
    	 }
        super.breakBlock(worldIn, pos, state);
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
     * Called When an Entity Collided with the Block
     */
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
    	double x = pos.getX();
    	double y = pos.getY();
    	double z = pos.getZ();
    	//if (!worldIn.isRemote) 
    	if(entityIn instanceof EntityBBase){
    		EntityBBase bullet = (EntityBBase) entityIn;
    		if( bullet.getThrower() instanceof IMob) {
    			
    		}else {
    			if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_blockspawner_ge_s){
        			//if (!worldIn.isRemote) 
        		    	{
        					GVCExplosionBase.ExplosionKai(entityIn, entityIn, x, y + 0.5, z, 0.0F, false,  false);
        					worldIn.setBlockToAir(pos);
        				}
        		 }
    		}
    	}
    }
    
    @Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityBlockSpawn_Spawner();
	}

    
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
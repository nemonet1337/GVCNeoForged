package gvcr2.block;

import gvcr2.block.tile.TileEntityBlockBossSpawn_Tile;
import gvcr2.block.tile.TileEntityBlockSpawn_ONE;
import gvcr2.block.tile.TileEntityBlockSpawn_Spawner;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBossSpawn_Tile extends BlockContainer
{

    public BlockBossSpawn_Tile()
    {
        super(Material.WOOD);
        //this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(DAMAGE, Integer.valueOf(0)));
        setHardness(150000F);
        setResistance(1000000000.0F);
        setLightOpacity(1);
        setLightLevel(1.0F);
        setBlockUnbreakable();
    }
    
    @Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityBlockBossSpawn_Tile();
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
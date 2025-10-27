package gvcr2.block;

import gvcr2.block.tile.TileEntityBlockSpawn_ONE;
import gvcr2.block.tile.TileEntityBuilding_Chest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class BlockBuilding_Chest extends BlockContainer
{

    public BlockBuilding_Chest()
    {
        super(Material.WOOD);
        //this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(DAMAGE, Integer.valueOf(0)));
        setHardness(1.5F);
        setResistance(10.0F);
        setLightOpacity(1);
        setLightLevel(1.0F);
    }
    
    @Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityBuilding_Chest();
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
    
    /**
     * The type of render function called. 3 for standard block models, 2 for TESR's, 1 for liquids, -1 is no render
     */
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
    
    

	

}
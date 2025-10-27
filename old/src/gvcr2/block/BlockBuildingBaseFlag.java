package gvcr2.block;

import gvclib.item.ItemGunBase;
import gvcr2.mod_GVCR2;
import gvcr2.block.tile.TileEntityBlockBaseFlag;
import gvcr2.block.tile.TileEntityBlockBossSpawn_Tile;
import gvcr2.block.tile.TileEntityBlockSpawn_ONE;
import gvcr2.block.tile.TileEntityBlockSpawn_Spawner;
import gvcr2.block.tile.TileEntity_BulletCrafter;
import gvcr2.entity.inv.EntityGVCR2_INV_SCENARIO;
import gvcr2.entity.mob.EntityGVCR2_GE_SV;
import gvcr2.item.ItemInv_Scenario;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBuildingBaseFlag extends BlockContainer
{

    public BlockBuildingBaseFlag()
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
		return new TileEntityBlockBaseFlag();
	}

    
    /**
     * Called when the block is right clicked by a player.
     */
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
        	if(playerIn != null) {
        		ItemStack itemstack = playerIn.getHeldItemMainhand();
        		if (!itemstack.isEmpty() && itemstack.getItem() instanceof ItemInv_Scenario) {
        			
        			 TileEntity tileentity = worldIn.getTileEntity(pos);
        	            if (tileentity instanceof TileEntityBlockBaseFlag)
        	            {
        	            	TileEntityBlockBaseFlag flagBlock = (TileEntityBlockBaseFlag) tileentity;
        	            	Item item =  itemstack.getItem();
        	            	
        	            	if(!flagBlock.enemy){
                				EntityGVCR2_INV_SCENARIO mob = new EntityGVCR2_INV_SCENARIO(worldIn);
                        		mob.setLocationAndAngles(pos.getX(), pos.getY() + 1, pos.getZ(), 0, 0.0F);
                				mob.setcanDespawn(1);
                				mob.setArmID_S(scenario(item));
                				if(scenario(item) == 30 || scenario(item) == 31 || scenario(item) == 32 || scenario(item) == 33) {
                					mob.setArmID_L(30);
                				}else if(scenario(item) == 3) {
                					mob.setArmID_L(30);
                				}else {
                					mob.setArmID_L(20);
                				}
                				
                				if(scenario(item) == 3 || scenario(item) == 33) {
                					mob.setArmID_R(3600);
                				}else {
                					mob.setArmID_R(2400);
                				}
                				
                				
                				//mob.setMoveT(1);
                				//mob.setMoveX((int)(pos.getX()));
                				//mob.setMoveY((int)pos.getY() + 1);
                				//mob.setMoveZ((int)(pos.getZ()));
                				worldIn.spawnEntity(mob);
                				
                				 if (!playerIn.capabilities.isCreativeMode)
                 	            {
                 				 itemstack.shrink(1);

                 	                if (itemstack.isEmpty())
                 	                {
                 	                	playerIn.inventory.deleteStack(itemstack);
                 	                }
                 	            }
                 			playerIn.getCooldownTracker().setCooldown(itemstack.getItem(), 100);
                			}
        	            }
        		}
        		/*else if (!itemstack.isEmpty() && itemstack.getItem() == mod_GVCR2.gvcr2_item_squad_cn) {
        			
        		}*/
        	}
            return true;
        }
    }
    
    public int scenario(Item item) {
    	int flag = 0;
    			
    	if(item == mod_GVCR2.gvcr2_item_inv_infantry_1) {
    		flag = 40;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_infantry_2) {
    		flag = 41;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_infantry_3) {
    		flag = 42;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_infantry_4) {
    		flag = 43;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_normal_1) {
    		flag = 0;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_normal_2) {
    		flag = 1;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_normal_3) {
    		flag = 2;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_normal_4) {
    		flag = 3;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_tank_1) {
    		flag = 10;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_tank_2) {
    		flag = 11;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_tank_3) {
    		flag = 12;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_tank_4) {
    		flag = 13;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_dogfight_1) {
    		flag = 20;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_dogfight_2) {
    		flag = 21;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_dogfight_3) {
    		flag = 22;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_dogfight_4) {
    		flag = 23;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_airborne_1) {
    		flag = 30;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_airborne_2) {
    		flag = 31;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_airborne_3) {
    		flag = 32;
    	}
    	if(item == mod_GVCR2.gvcr2_item_inv_airborne_4) {
    		flag = 33;
    	}
    	return flag;
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
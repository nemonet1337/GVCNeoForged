package gvcr2.block.tile;

import java.util.List;

import gvcr2.mod_GVCR2;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;

public class TileEntityBuilding_Chest extends TileEntity implements ITickable
{
	public boolean spawn = false;
    
    @Override
	public void update() {
    	Block block = this.world.getBlockState(this.pos).getBlock();
        
        int x = this.pos.getX();
        int y= this.pos.getY();
        int z = this.pos.getZ();
        
        this.canspawn(x, y, z, 80);
        if(!spawn)return;
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_chest_food) {
    		this.world.setBlockState(this.pos, Blocks.CHEST.getDefaultState(), 2);
    		TileEntityChest Chest3;
    		if(this.world.getTileEntity(this.pos) != null && this.world.getTileEntity(this.pos) instanceof TileEntityChest) {
			Chest3 = (TileEntityChest) this.world.getTileEntity(this.pos);
			int max = this.world.rand.nextInt(17) + 10;
			for (int i = 1; i < max; ++i) {
				int isuu = this.world.rand.nextInt(4);
				int suro2 = this.world.rand.nextInt(27);
				int ra = this.world.rand.nextInt(10);
				if(ra== 0) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(Items.WHEAT, isuu+6, 0));
				}
				else if(ra == 1) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(Items.CARROT, isuu+6, 0));
				}
				else if(ra == 2) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(Items.POTATO, isuu+6, 0));
				}
				else if(ra == 3) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_scrap, isuu, 0));
				}
				else if(ra == 4) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(Items.FISH, isuu+6, 0));
				}
				else if(ra == 5) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_cm, 6, 0));
				}
				else if(ra == 6) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(Items.GUNPOWDER, isuu+20, 0));
				}
				else if(ra == 7) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(Items.REDSTONE, isuu+20, 0));
				}
				else if(ra == 8) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(Items.EMERALD, isuu+4, 0));
				}
				else {
					Chest3.setInventorySlotContents(suro2, new ItemStack(Items.BREAD, isuu+10, 0));
				}
			}
    		}
    	}
        else if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_chest_weapon) {
    		this.world.setBlockState(this.pos, Blocks.CHEST.getDefaultState(), 2);
    		TileEntityChest Chest3;
    		if(this.world.getTileEntity(this.pos) != null && this.world.getTileEntity(this.pos) instanceof TileEntityChest) {
			Chest3 = (TileEntityChest) this.world.getTileEntity(this.pos);
			int max = this.world.rand.nextInt(17) + 6;
			for (int i = 1; i < max; ++i) {
				int isuu = this.world.rand.nextInt(16);
				int suro2 = this.world.rand.nextInt(27);
				int ra = this.world.rand.nextInt(40);
				int ran = this.world.rand.nextInt(5);
				/*if(ra== 0 || ra == 1 || ra == 2 || ra >= 17) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_bullet_9mmhg, isuu+10, 0));
				}
				else if(ra == 3) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_pm, 1, 0));
				}
				else if(ra == 4) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_ak47, 1, 0));
				}
				else if(ra == 5) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_uzi, 1, 0));
				}
				else if(ra == 6) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_sks, 1, 0));
				}
				else if(ra == 7) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_rpg7, 1, 0));
				}
				else {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_bullet_22calar, isuu+10, 0));
				}*/
				switch (ra) {
		        case 1:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_bullet_22calar, isuu+20, 0));
		            break;
		        case 2:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_bullet_22calar, isuu+20, 0));
		            break;
		        case 3:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_bullet_76mmrl, isuu+4, 0));
		            break;
		        case 4:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_bullet_84mmrl, isuu+4, 0));
		            break;
		        case 5:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_pm, 1, 0));
		            break;
		        case 6:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_sks, 1, 0));
		            break;
		        case 7:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_uzi, 1, 0));
		            break;
		        case 8:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_ak47, 1, 0));
		            break;
		        case 9:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_rpg7, 1, 0));
		            break;
		        case 10:
		        	if(ran == 0)Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_am_coyote, 1, 0));
		            break;
		        case 11:
		        	if(ran == 0)Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_am_kobra, 1, 0));
		            break;
		        case 12:
		        	if(ran == 0)Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_am_acog, 1, 0));
		            break;
		        case 13:
		        	if(ran == 0)Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_am_flashlight, 1, 0));
		            break;
		        case 14:
		        	if(ran == 0)Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_am_grip, 1, 0));
		            break;
		        case 15:
		        	if(ran == 0)Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_am_bipod, 1, 0));
		            break;
		        case 16:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_grenade_frag, 1, 0));
		        	  break;
		        case 17:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_airstrike1, 1, 0));
		        	  break;
		        case 18:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_fire1, 1, 0));
		        	  break;
		        case 19:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_airborne1, 1, 0));
		            break;
		        case 20:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_missile1, 1, 0));
		            break;
		        case 21:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_flare, 1, 0));
		            break;
		        case 22:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_light, 1, 0));
		            break;
		        case 23:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_spawn_car_bike, 1, 0));
		            break;
		        case 24:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_spawn_car_buggy, 1, 0));
		            break;
		        case 25:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_105mm, 1, 0));
		            break;
		        case 26:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_40mm, 1, 0));
		            break;
		        case 27:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_20mm, 1, 0));
		            break;
		        case 28:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_pave, 1, 0));
		            break;
		        case 29:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_strafing1, 1, 0));
		            break;
		        case 30:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_am_bullet_ap, 1, 0));
		            break;
		        case 31:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_am_bullet_hp, 1, 0));
		            break;
		        case 32:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_am_bullet_at, 1, 0));
		            break;
		        case 33:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_am_bullet_srag, 1, 0));
		            break;
		        case 34:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_am_bullet_frag, 1, 0));
		            break;
		        case 35:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_am_bullet_db, 1, 0));
		            break;
		        default:
		        	Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_bullet_9mmhg, isuu+10, 0));
		        }
			}
    		}
    	}
        else if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_chest_weapon2) {
    		this.world.setBlockState(this.pos, Blocks.CHEST.getDefaultState(), 2);
    		TileEntityChest Chest3;
    		if(this.world.getTileEntity(this.pos) != null && this.world.getTileEntity(this.pos) instanceof TileEntityChest) {
			Chest3 = (TileEntityChest) this.world.getTileEntity(this.pos);
			int max = this.world.rand.nextInt(17) + 5;
			for (int i = 1; i < max; ++i) {
				int isuu = this.world.rand.nextInt(16);
				int suro2 = this.world.rand.nextInt(27);
				int ra = this.world.rand.nextInt(20);
				if(ra== 0 || ra == 1 || ra == 2 || ra >= 17) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_bullet_9mmhg, isuu+10, 0));
				}
				else if(ra == 3) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_stg44, 1, 0));
				}
				else if(ra == 4) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_mp40, 1, 0));
				}
				else if(ra == 5) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_m1891, 1, 0));
				}
				else if(ra == 6) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_ppsh41, 1, 0));
				}
				else {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_bullet_30calrf, isuu+20, 0));
				}
			}
    		}
    	}
        else if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_chest_weapon3) {
    		this.world.setBlockState(this.pos, Blocks.CHEST.getDefaultState(), 2);
    		TileEntityChest Chest3;
    		if(this.world.getTileEntity(this.pos) != null && this.world.getTileEntity(this.pos) instanceof TileEntityChest) {
			Chest3 = (TileEntityChest) this.world.getTileEntity(this.pos);
			int max = this.world.rand.nextInt(17) + 6;
			for (int i = 1; i < max; ++i) {
				int isuu = this.world.rand.nextInt(16);
				int suro2 = this.world.rand.nextInt(27);
				int ra = this.world.rand.nextInt(20);
				if(ra== 0 || ra == 1 || ra == 2 || ra >= 17) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_bullet_9mmhg, isuu+40, 0));
				}
				else if(ra == 3) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_m16a1, 1, 0));
				}
				else if(ra == 4) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_mp5, 1, 0));
				}
				else if(ra == 5) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_r700, 1, 0));
				}
				else if(ra == 6) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_m79, 1, 0));
				}
				else if(ra == 7) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_mp7, 1, 0));
				}
				else if(ra == 8) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_fim92, 1, 0));
				}
				else if(ra == 9) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_support_fighter1, 1, 0));
				}
				else if(ra == 10) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_support_heli1, 1, 0));
				}
				else if(ra == 11) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_105mm, 1, 0));
				}
				else if(ra == 12) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_40mm, 1, 0));
				}
				else if(ra == 13) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_20mm, 1, 0));
				}
				else if(ra == 14) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_pave, 1, 0));
				}
				else if(ra == 15) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_strafing1, 1, 0));
				}
				else {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_bullet_22calar, isuu+40, 0));
				}
			}
    		}
    	}
        else if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_chest_weapon4) {
    		this.world.setBlockState(this.pos, Blocks.CHEST.getDefaultState(), 2);
    		TileEntityChest Chest3;
    		if(this.world.getTileEntity(this.pos) != null && this.world.getTileEntity(this.pos) instanceof TileEntityChest) {
			Chest3 = (TileEntityChest) this.world.getTileEntity(this.pos);
			int max = this.world.rand.nextInt(8) + 6;
			for (int i = 1; i < max; ++i) {
				int isuu = this.world.rand.nextInt(8);
				int suro2 = this.world.rand.nextInt(27);
				int ra = this.world.rand.nextInt(22);
				if(ra== 0) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_m16a4, 1, 0));
				}
				else if(ra == 1) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_f2000, 1, 0));
				}
				else if(ra == 2) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_hk416, 1, 0));
				}
				else if(ra == 3) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_scar_h, 1, 0));
				}
				else if(ra == 4) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_m320, 1, 0));
				}
				else if(ra == 5) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_l96, 1, 0));
				}
				else if(ra == 6) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_ptrd, 1, 0));
				}
				else if(ra == 7) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_m249, 1, 0));
				}
				else if(ra == 8) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_mg36, 1, 0));
				}
				else if(ra == 9) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_saiga12, 1, 0));
				}
				else if(ra == 10) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_fgm148, 1, 0));
				}
				else if(ra == 12) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_fim92, 1, 0));
				}
				else if(ra == 13) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_mp7, 1, 0));
				}
				else if(ra == 14) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_support_fighter1, 1, 0));
				}
				else if(ra == 15) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_support_heli1, 1, 0));
				}
				else if(ra == 16) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_105mm, 1, 0));
				}
				else if(ra == 17) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_40mm, 1, 0));
				}
				else if(ra == 18) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_20mm, 1, 0));
				}
				else if(ra == 19) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_pave, 1, 0));
				}
				else if(ra == 20) {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_item_request_strafing1, 1, 0));
				}
				else {
					Chest3.setInventorySlotContents(suro2, new ItemStack(mod_GVCR2.gvcr2_gun_hk416, 1, 0));
				}
			}
    		}
    	}
        else if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_setair) {
        	this.world.setBlockState(this.pos, Blocks.AIR.getDefaultState(), 2);
        }
        
    }

    
    public void canspawn(double x, double y, double z, int han) {
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
                			spawn = true;
                		}
                    }
                }
            }
        }
    }
    
}

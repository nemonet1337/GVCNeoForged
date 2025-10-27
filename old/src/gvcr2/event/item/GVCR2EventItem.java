package gvcr2.event.item;

import gvclib.item.ItemWrench;
import gvcr2.mod_GVCR2;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GVCR2EventItem {
	
	@SubscribeEvent
	public void onUpdateEvent(LivingUpdateEvent event) {
		World worldIn = event.getEntityLiving().world;
		EntityLivingBase target = event.getEntityLiving();
		if(target != null && target instanceof EntityPlayer) {
			ItemStack itemstack = target.getHeldItemMainhand();
    		if (!itemstack.isEmpty() && itemstack.getItem() instanceof ItemWrench) {
    			for(int xx = 0; xx < 18; ++xx) {
    				for(int yy = 0; yy < 18; ++yy) {
    					for(int zz = 0; zz < 18; ++zz) {
    						BlockPos pos = new BlockPos(target.posX -8 + xx, target.posY - 8 + yy,target.posZ - 8 + zz);
    						if (worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_ghostlight
    								|| worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_ghostlight_tile) {
    							worldIn.setBlockState(pos, mod_GVCR2.gvcr2_block_ghostlight_tile.getDefaultState(), 2);
    						}
    					}
    				}
    			}
    		}
		}
	}
}

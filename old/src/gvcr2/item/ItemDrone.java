package gvcr2.item;

import gvcr2.entity.drone.EntityDrone_EOD;
import gvcr2.entity.drone.EntityDrone_MAV;
import gvcr2.entity.drone.EntityDrone_RAWR;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import objmodel.IModelCustom;

public class ItemDrone extends Item
{
	public int ii;
	
	//public String nameid = null;
	
	public int id = 0;
	public String model;
	public String tex;
	
    public ItemDrone(int i)
    {
        this.maxStackSize = 1;
        this.id = i;
    }

    public void spawnCreature(World worldIn, EntityPlayer playerIn, double par4, double par5, double par6)
    {

		if(id == 0){
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityDrone_MAV ent = new EntityDrone_MAV(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		if(id == 1){
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityDrone_EOD ent = new EntityDrone_EOD(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		if(id == 2){
			++par5;
			int var12 = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EntityDrone_RAWR ent = new EntityDrone_RAWR(worldIn);
			ent.setLocationAndAngles(par4 + 0.5, par5, par6 + 0.5, var12, 0.0F);
			ent.setcanDespawn(1);
			worldIn.spawnEntity(ent);
		} 
		
	}
    
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		ItemStack itemStackIn = player.getHeldItem(hand);
		int par4 = pos.getX();
		int par5 = pos.getY();
		int par6 = pos.getZ();
		
		if (worldIn.isRemote)
        {
			return EnumActionResult.PASS;
        }
        else
		{
        	if (!player.capabilities.isCreativeMode)
            {
        		itemStackIn.shrink(1);
            }
        	spawnCreature(worldIn, player, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
        	return EnumActionResult.PASS;
        }
    }
	
	/**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
    	ItemStack itemStackIn = playerIn.getHeldItem(handIn);
        if (worldIn.isRemote)
        {
            return new ActionResult(EnumActionResult.PASS, itemStackIn);
        }
        else
        {
            RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, true);

            if (raytraceresult != null && raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK)
            {
                BlockPos blockpos = raytraceresult.getBlockPos();

                if (!(worldIn.getBlockState(blockpos).getBlock() instanceof BlockLiquid))
                {
                    return new ActionResult(EnumActionResult.PASS, itemStackIn);
                }
                else if (worldIn.isBlockModifiable(playerIn, blockpos) && playerIn.canPlayerEdit(blockpos, raytraceresult.sideHit, itemStackIn))
                {
                    spawnCreature(worldIn, playerIn, (double)blockpos.getX(), (double)blockpos.getY(), (double)blockpos.getZ());
                    {

                    	if (!playerIn.capabilities.isCreativeMode)
                        {
                    		itemStackIn.shrink(1);
                        }

                        playerIn.addStat(StatList.getObjectUseStats(this));
                        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
                    }
                }
                else
                {
                    return new ActionResult(EnumActionResult.FAIL, itemStackIn);
                }
            }
            else
            {
                return new ActionResult(EnumActionResult.PASS, itemStackIn);
            }
        }
    }
}
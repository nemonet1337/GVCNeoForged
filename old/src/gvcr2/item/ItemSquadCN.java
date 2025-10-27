package gvcr2.item;

import java.util.List;

import javax.annotation.Nullable;

import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.ISoldier;
import gvcr2.entity.pmc.EntityGVCR2_PMC_S;
import hmggirlfront.entity.EntityDoll;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemSquadCN extends Item
{
	
    public ItemSquadCN()
    {
        this.maxStackSize = 1;
    }

    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	  {
    	tooltip.add(TextFormatting.WHITE + "L-click+Sneaking" + " : " + "Change Squad");//0
    	tooltip.add(TextFormatting.WHITE + "R-click+Sneaking" + " : " + "Gathered Squad");//3
    	tooltip.add(TextFormatting.WHITE + "→←-click" + " : " + "Doll Select");//1
    	tooltip.add(TextFormatting.WHITE + "↑-click" + " : " + "Instruction Doll");//2
	  }
    
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		
		if(!itemstack.hasTagCompound()) {
			/*NBTTagCompound ltags = new NBTTagCompound();
			itemstack.setTagCompound(ltags);
			ltags.setInteger("squadid", 1);*/
		}
		
		if(entity != null && entity instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer) entity;
			
		}
		
		
		super.onUpdate(itemstack, world, entity, i, flag);
	}
    
    public boolean onEntitySwing(EntityLivingBase entity, ItemStack itemstack) {
    	World worldIn = entity.world;
    	if(entity instanceof EntityPlayer)
    	{
    		EntityPlayer playerIn = (EntityPlayer) entity;
    		if(!itemstack.isEmpty()) {
    			if(!playerIn.isSneaking()) 
    			{
    				List<Entity> llist = worldIn.getEntitiesWithinAABBExcludingEntity(playerIn,
	        				playerIn.getEntityBoundingBox()
	        						.expand(playerIn.motionX, playerIn.motionY, playerIn.motionZ)
	        						.grow(50.0D));
	        		if(playerIn != null){
	        			if (llist != null) {
	        				for (int lj = 0; lj < llist.size(); lj++) {
	        					Entity entity1 = (Entity) llist.get(lj);
	        					if (entity1.canBeCollidedWith()) {
	        						if (entity1 != null)
	        						{
	        							if (entity1 instanceof EntityLivingBase && entity1 instanceof EntityGVCR2_PMC_S)
	        	                        {
	        								EntityGVCR2_PMC_S doll = (EntityGVCR2_PMC_S) entity1;
	        								if (doll.isOwner(playerIn)) 
	        								{
    			                    			if(doll.getMoveT() == 1) {
    			                    				doll.setMoveT(0);
    			                    				if(worldIn.isRemote)
    			                    				playerIn.sendMessage(new TextComponentTranslation("gvcr2.order.follow.name", new Object[0]));
    			                    			}
    			                    			else if(doll.getMoveT() == 0) {
    			                    				doll.setMoveT(3);
    			                    				if(worldIn.isRemote)
    			                    				playerIn.sendMessage(new TextComponentTranslation("gvcr2.order.stay.name", new Object[0]));
    			                    			}
    			                    			else if(doll.getMoveT() == 3) {
    			                    				doll.setMoveT(1);
    			                    				if(worldIn.isRemote)
    			                    				playerIn.sendMessage(new TextComponentTranslation("gvcr2.order.free.name", new Object[0]));
    			                    			}
	            							}
	        	                        }
	        						}
	        					}
	        				}
	        			}
	        		}
    			}
    			else
    			{
    				{
    	    			Vec3d lock = Vec3d.fromPitchYaw(playerIn.rotationPitch, playerIn.rotationYaw);
    					int ix = 0;
    					int iy = 0;
    					int iz = 0;
    					for(int x = 0; x < 120; ++x) {
    						boolean geten = false;
    						{
    							ix = (int) (playerIn.posX + lock.x * x);
    							iy = (int) (playerIn.posY + 1.5 + lock.y * x);
    							iz = (int) (playerIn.posZ + lock.z * x);
    							if(ix != 0 && iz != 0 && iy != 0) {
    	    						EntityLivingBase target = null;
    	    						{
    	    							int han = 1;
    	    			            	AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(ix-han), (double)(iy-han), (double)(iz-han), 
    	    			            			(double)(ix + han), (double)(iy + han), (double)(iz+ han)))
    	    			                		.grow(1);
    	    			                List llist2 = playerIn.world.getEntitiesWithinAABBExcludingEntity(playerIn, axisalignedbb2);
    	    			                if(llist2!=null){
    	    			                    for (int lj = 0; lj < llist2.size(); lj++) {
    	    			                    	
    	    			                    	Entity entity1 = (Entity)llist2.get(lj);
    	    			                    	if (entity1.canBeCollidedWith())
    	    			                        {
    	    			                    		if (entity1 instanceof EntityGVCR2_PMC_S && entity1 != null)
    	    			                            {
    	    			                    			EntityGVCR2_PMC_S doll = (EntityGVCR2_PMC_S) entity1;
    	    			                    			doll.dismountRidingEntity();
    	    			                    			geten = true;
    	    			                    			break;
    	    			                            }
    	    			                        }
    	    			                    }
    	    			                }
    	    						}
    	    					}
    						}
    						if(geten)break;
    					}
    	    		}
    			}
    		}
    	}
    	return false;
    }
    
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
    	ItemStack itemstack = playerIn.getHeldItem(handIn);
    	if(!itemstack.isEmpty()) {
    		{
    			if(!playerIn.isSneaking()) {
    				{
    	    			Vec3d lock = Vec3d.fromPitchYaw(playerIn.rotationPitch, playerIn.rotationYaw);
    					int ix = 0;
    					int iy = 0;
    					int iz = 0;
    					for(int x = 0; x < 120; ++x) {
    						boolean geten = false;
    						/*if (playerIn.world
    								.getBlockState(new BlockPos(playerIn.posX + lock.x * x,
    										playerIn.posY + 1.5 + lock.y * x,
    										playerIn.posZ + lock.z * x))
    								.getBlock() != Blocks.AIR) */
    						{
    							ix = (int) (playerIn.posX + lock.x * x);
    							iy = (int) (playerIn.posY + 1.5 + lock.y * x);
    							iz = (int) (playerIn.posZ + lock.z * x);
    							/*playerIn.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, 
    									playerIn.posX +lock.x * x,  playerIn.posY + 1.5 +lock.y * x, playerIn.posZ +lock.z * x, 0, 0, 0);*/
    							if(ix != 0 && iz != 0 && iy != 0) {
    	    						EntityLivingBase target = null;
    	    						{
    	    							int han = 1;
    	    			            	AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(ix-han), (double)(iy-han), (double)(iz-han), 
    	    			            			(double)(ix + han), (double)(iy + han), (double)(iz+ han)))
    	    			                		.grow(1);
    	    			                List llist2 = playerIn.world.getEntitiesWithinAABBExcludingEntity(playerIn, axisalignedbb2);
    	    			                if(llist2!=null){
    	    			                    for (int lj = 0; lj < llist2.size(); lj++) {
    	    			                    	
    	    			                    	Entity entity1 = (Entity)llist2.get(lj);
    	    			                    	if (entity1.canBeCollidedWith())
    	    			                        {
    	    			                    		if (entity1 instanceof EntityGVCR2_PMC_S && entity1 != null)
    	    			                            {
    	    			                    			/*EntityLivingBase mob = (EntityLivingBase) entity1;
    	    			                    			mob.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 200, 200));
    	    			                    			target = mob;*/
    	    			                    			EntityGVCR2_PMC_S doll = (EntityGVCR2_PMC_S) entity1;
    	    			                    			if(doll.getMoveT() == 1) {
    	    			                    				doll.setMoveT(0);
    	    			                    				if(worldIn.isRemote)
    	    			                    				playerIn.sendMessage(new TextComponentTranslation("gvcr2.order.follow.name", new Object[0]));
    	    			                    			}
    	    			                    			else if(doll.getMoveT() == 0) {
    	    			                    				doll.setMoveT(3);
    	    			                    				if(worldIn.isRemote)
    	    			                    				playerIn.sendMessage(new TextComponentTranslation("gvcr2.order.stay.name", new Object[0]));
    	    			                    			}
    	    			                    			else if(doll.getMoveT() == 3) {
    	    			                    				doll.setMoveT(1);
    	    			                    				if(worldIn.isRemote)
    	    			                    				playerIn.sendMessage(new TextComponentTranslation("gvcr2.order.free.name", new Object[0]));
    	    			                    			}
    	    			                    			geten = true;
    	    			                    			break;
    	    			                            }
    	    			                        }
    	    			                    }
    	    			                }
    	    						}
    	    					}
    						}
    						if(geten)break;
    					}
    					
    	        		
    	    		}
    			}
    			else {
    	    			List<Entity> llist = worldIn.getEntitiesWithinAABBExcludingEntity(playerIn,
    	        				playerIn.getEntityBoundingBox()
    	        						.expand(playerIn.motionX, playerIn.motionY, playerIn.motionZ)
    	        						.grow(50.0D));
    	        		if(playerIn != null){
    	        			if (llist != null) {
    	        				for (int lj = 0; lj < llist.size(); lj++) {
    	        					Entity entity1 = (Entity) llist.get(lj);
    	        					if (entity1.canBeCollidedWith()) {
    	        						if (entity1 != null)
    	        						{
    	        							if (entity1 instanceof EntityLivingBase && entity1 instanceof EntityGVCR2_PMC_S)
    	        	                        {
    	        								EntityGVCR2_PMC_S doll = (EntityGVCR2_PMC_S) entity1;
    	        								if (doll.isOwner(playerIn) && doll.getMoveT() != 3) 
    	        								{
    	        									doll.setPositionAndUpdate(playerIn.posX, playerIn.posY, playerIn.posZ);
    	            							}
    	        	                        }
    	        						}
    	        					}
    	        				}
    	        			}
    	        		}
    	        		if(worldIn.isRemote)
    	        			playerIn.sendMessage(new TextComponentTranslation("gvcr2.order.comeon.name", new Object[0]));
    			}
    		}
    		
    	}
        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult(EnumActionResult.SUCCESS, itemstack);
    }
}
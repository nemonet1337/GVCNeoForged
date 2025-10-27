package gvcr2.item;

import java.util.List;

import javax.annotation.Nullable;

import gvclib.entity.living.EntityVehicleBase;
import gvcr2.entity.bullet.EntityGVCR2_Request_Smoke;
import gvcr2.entity.so.EntityGVCR2_SO_S;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_A10;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_A4;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_A6;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_C130;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_F16;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_F18;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_AH1S;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_AH6;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemRequest_Remocon extends Item
{
	
	public int id;
	
    public ItemRequest_Remocon(int i)
    {
        this.maxStackSize = 1;
        this.id = i;
    }

    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        boolean flag = playerIn.capabilities.isCreativeMode;
        ItemStack eme = this.findAmmo(playerIn);
        if (!eme.isEmpty() || flag)
        {
        	//worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!worldIn.isRemote)
            {
            	 if(this.id == 1 || this.id == 2 || this.id == 3) {
            		 for(int ii = 0; ii < 2; ++ii) {
							double xx11 = 0;
							double zz11 = 0;
							float side = 0;
							if(ii == 0)side = -1.57F;
							if(ii == 1)side = 1.57F;
							xx11 -= MathHelper.sin((playerIn.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
							zz11 += MathHelper.cos((playerIn.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
							xx11 -= MathHelper.sin((playerIn.rotationYaw + 90) * 0.01745329252F + side) * 12;
							zz11 += MathHelper.cos((playerIn.rotationYaw + 90) * 0.01745329252F + side) * 12;
							double xx = playerIn.posX - xx11;
							double yy = playerIn.posY;
							double zz = playerIn.posZ - zz11;
							 if(this.id == 1) {
								 this.callfighter(worldIn, playerIn, xx, yy, zz, 100, 30);
							 }
							 if(this.id == 2) {
								 this.callfighter(worldIn, playerIn, xx, yy, zz, 100, 30);
							 }
							 if(this.id == 3) {
								 this.callfighter(worldIn, playerIn, xx, yy, zz, 100, 30);
							 }
						}
            		 playerIn.sendMessage(new TextComponentTranslation("Request the Air Support Fighter!", new Object[0]));
            	 }
            	 if(this.id == 4 || this.id == 5) {
            		 //this.callfighter(worldIn, playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, 100, 32);
            		 for(int ii = 0; ii < 2; ++ii) {
							double xx11 = 0;
							double zz11 = 0;
							float side = 0;
							if(ii == 0)side = -1.57F;
							if(ii == 1)side = 1.57F;
							xx11 -= MathHelper.sin((playerIn.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
							zz11 += MathHelper.cos((playerIn.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
							xx11 -= MathHelper.sin((playerIn.rotationYaw + 90) * 0.01745329252F + side) * 12;
							zz11 += MathHelper.cos((playerIn.rotationYaw + 90) * 0.01745329252F + side) * 12;
							double xx = playerIn.posX - xx11;
							double yy = playerIn.posY;
							double zz = playerIn.posZ - zz11;
							 if(this.id == 4) {
								 this.callfighter(worldIn, playerIn, xx, yy, zz, 100, 33);
							 }
							 if(this.id == 5) {
								 this.callfighter(worldIn, playerIn, xx, yy, zz, 100, 34);
							 }
						}
            		 playerIn.sendMessage(new TextComponentTranslation("Request the Air Support Helicopter!", new Object[0]));
            	 }
            }
            if (!playerIn.capabilities.isCreativeMode)
            {
            	eme.shrink(1);

                if (eme.isEmpty())
                {
                	playerIn.inventory.deleteStack(eme);
                }
            }
            playerIn.getCooldownTracker().setCooldown(this, 100);
            playerIn.addStat(StatList.getObjectUseStats(this));
        }

        
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
    
    public void callfighter(World par2World, EntityPlayer par3EntityPlayer, double ix, double iy, double iz, double range, int id) {
    	if(par3EntityPlayer != null){
			double xx11 = 0;
			double zz11 = 0;
			xx11 -= MathHelper.sin(par3EntityPlayer.rotationYaw * 0.01745329252F - 1.57F) * range;
			zz11 += MathHelper.cos(par3EntityPlayer.rotationYaw * 0.01745329252F - 1.57F) * range;
			double xx = ix - xx11;
			double yy = iy + 40;
			double zz = iz - zz11;
			EntityVehicleBase var8;
			if(id == 33) {
				var8 = new EntityGVCR2_HELI_AH6(par2World);
				yy = iy + 20;
			}
			else if(id == 34) {
				var8 = new EntityGVCR2_HELI_AH1S(par2World);
				yy = iy + 20;
			}
			else if(id == 36) {
				var8 = new EntityGVCR2_HELI_AH1S(par2World);
				yy = iy + 20;
			}
			else {
				 if(this.id == 2) {
					 var8 = new EntityGVCR2_AIR_F16(par2World);
				 }else  if(this.id == 3) {
					 var8 = new EntityGVCR2_AIR_F18(par2World);
				 }else {
					 var8 = new EntityGVCR2_AIR_A4(par2World);
				 }
			}
			var8.fri = par3EntityPlayer;
			var8.rotationYaw = var8.rotationYawHead = var8.renderYawOffset = -((float) Math.atan2(ix - xx, iz - zz)) * 180.0F
					/ (float) Math.PI;
			var8.setLocationAndAngles(xx, yy, zz, var8.rotationYawHead, var8.rotationPitch);
			var8.setFTMode(id);
			var8.setcanDespawn(1);

			if (!par2World.isRemote) {
				par2World.spawnEntity(var8);
			}
			if (!par2World.isRemote){
				EntityGVCR2_SO_S entityskeleton = new EntityGVCR2_SO_S(par2World);
		        entityskeleton.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
		        entityskeleton.setcanDespawn(1);
		        entityskeleton.setTamedBy(par3EntityPlayer);
		        par2World.spawnEntity(entityskeleton);
		        entityskeleton.startRiding(var8);
			}
		}
	}
    
    
    
    
    
    
    private ItemStack findAmmo(EntityPlayer player)
    {
        if (this.isArrow(player.getHeldItem(EnumHand.OFF_HAND)))
        {
            return player.getHeldItem(EnumHand.OFF_HAND);
        }
        else if (this.isArrow(player.getHeldItem(EnumHand.MAIN_HAND)))
        {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
            {
                ItemStack itemstack = player.inventory.getStackInSlot(i);

                if (this.isArrow(itemstack))
                {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }
    
    protected boolean isArrow(ItemStack stack)
    {
        return stack.getItem() == Items.EMERALD;
    }
    
    public String information1 = null;
	public String information2 = null;
	public String information3 = null;
	
	public TextFormatting information1_color = TextFormatting.WHITE;
	public TextFormatting information2_color = TextFormatting.WHITE;
	public TextFormatting information3_color = TextFormatting.WHITE;
    
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	  {
  	//tooltip.add(TextFormatting.BLUE + "Enter the GUI with X key while holding the gun ");
  	String am = "";
  	if(information1 != null) {
			TextComponentTranslation information = new TextComponentTranslation(information1, new Object[0]);
			tooltip.add(information1_color + information.getFormattedText());
		}
		if(information2 != null) {
			TextComponentTranslation information = new TextComponentTranslation(information2, new Object[0]);
			tooltip.add(information2_color + information.getFormattedText());
		}
		if(information3 != null) {
			TextComponentTranslation information = new TextComponentTranslation(information3, new Object[0]);
			tooltip.add(information3_color + information.getFormattedText());
		}
	  }
}
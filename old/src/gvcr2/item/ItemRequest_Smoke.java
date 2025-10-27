package gvcr2.item;

import java.util.List;

import javax.annotation.Nullable;

import gvcr2.entity.bullet.EntityGVCR2_Request_Smoke;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
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
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemRequest_Smoke extends Item
{
	
	public int id;
	
    public ItemRequest_Smoke(int i)
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
        	worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!worldIn.isRemote)
            {
            	EntityGVCR2_Request_Smoke entitysnowball = new EntityGVCR2_Request_Smoke(worldIn, playerIn);
                entitysnowball.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
                {
                	entitysnowball.timemax = 200;
                	entitysnowball.req_id = this.id;
                	entitysnowball.gra = 0.0D;
                	entitysnowball.setModel("gvclib:textures/entity/new/bullet_grenade_smoke.mqo");
                	entitysnowball.setTex("gvclib:textures/entity/new/bullet_grenade_smoke.png");
                }
                worldIn.spawnEntity(entitysnowball);
                if(this.id == 1 || this.id == 2 || this.id == 3) {
                	playerIn.sendMessage(new TextComponentTranslation("Request the Air strike!", new Object[0]));
                }
                if(this.id == 4) {
                	playerIn.sendMessage(new TextComponentTranslation("Request the Air FlareSupport!", new Object[0]));
                }
                if(this.id == 5) {
                	playerIn.sendMessage(new TextComponentTranslation("Request the Air LightSupport!", new Object[0]));
                }
                if(this.id == 6 || this.id == 7 || this.id == 8) {
                	playerIn.sendMessage(new TextComponentTranslation("Request the Air Airborne!", new Object[0]));
                }
                if(this.id == 9 || this.id == 10 || this.id == 11) {
                	playerIn.sendMessage(new TextComponentTranslation("Request the FireSupport!", new Object[0]));
                }
                if(this.id == 12 || this.id == 13) {
                	playerIn.sendMessage(new TextComponentTranslation("Request the Strafing!", new Object[0]));
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
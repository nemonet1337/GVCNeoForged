package gvcr2.item;

import java.util.List;

import javax.annotation.Nullable;

import gvclib.mod_GVCLib;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.ISoldier;
import gvclib.item.ItemGunBase;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvcr2.network.GVCR2ClientMessageKeyPressed;
import gvcr2.network.GVCR2MessageKeyPressed;
import gvcr2.network.GVCR2PacketHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMap;
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



	public class ItemInv_Scenario extends Item {
		
		public String text1 = null;
		public String text2 = null;
		public String text3 = null;
		
		public ItemInv_Scenario() {
			super();
		}
		
		public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
	    {
			super.onUpdate(itemstack, world, entity, i, flag);
			
	    }
		
		public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
		  {
	    	if(text1 != null) {
	    		TextComponentTranslation information = new TextComponentTranslation(text1, new Object[0]);
	    		tooltip.add(TextFormatting.WHITE + information.getFormattedText());//0
	    	}
	    	if(text2 != null) {
	    		TextComponentTranslation information = new TextComponentTranslation(text2, new Object[0]);
	    		tooltip.add(TextFormatting.WHITE + information.getFormattedText());//0
	    	}
	    	if(text3 != null) {
	    		TextComponentTranslation information = new TextComponentTranslation(text3, new Object[0]);
	    		tooltip.add(TextFormatting.WHITE + information.getFormattedText());//0
	    	}
	    	
		  }
		
}
package gvcr2.event.entity;

import gvclib.entity.EntityBBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.so.EntityGVCR2_SOBase;
import gvcr2.item.ItemBinoculars;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GVCR2EventArmor {
	
	@SubscribeEvent
	public void onHurtEvent(LivingHurtEvent event) {
		EntityLivingBase target = event.getEntityLiving();
		DamageSource source = event.getSource();
		float damage = event.getAmount();
		if (target != null && target instanceof EntityPlayer) 
		{
			if(source.getTrueSource() != null&&source.getTrueSource() instanceof EntityGVCR2_SOBase)
	        {
				//event.setAmount(0);
				//event.isCanceled();
				event.setCanceled(true);
	        }
		}
	}
	
	
	@SubscribeEvent
	public void onUpdateEvent(LivingUpdateEvent event) {
		World worldIn = event.getEntityLiving().world;
		EntityLivingBase target = event.getEntityLiving();
		ItemStack HEAD = target.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		ItemStack CHEST = target.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
		ItemStack LEGS = target.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
		ItemStack FEET = target.getItemStackFromSlot(EntityEquipmentSlot.FEET);
		if(target != null) {
			if ((!HEAD.isEmpty())&& HEAD.getItem() == mod_GVCR2.gvcr2_armor_gasmask) {
				if (!worldIn.isRemote)
		        {
					/*//target.curePotionEffects(stack);
					if(target.isPotionActive(Potion.getPotionById(17))
							|| target.isPotionActive(Potion.getPotionById(19))
							|| target.isPotionActive(Potion.getPotionById(20))){
					target.removePotionEffect(Potion.getPotionById(17));
					target.removePotionEffect(Potion.getPotionById(19));
					target.removePotionEffect(Potion.getPotionById(20));
					}*/
					if (target.isPotionActive(MobEffects.POISON))target.removeActivePotionEffect(MobEffects.POISON);
					if (target.isPotionActive(MobEffects.WITHER))target.removeActivePotionEffect(MobEffects.WITHER);
		        }
			}
			if ((!HEAD.isEmpty())&& HEAD.getItem() == mod_GVCR2.gvcr2_armor_firemask) {
				if (!worldIn.isRemote)
		        {
					target.setFire(0);
		        }
			}
		}
	}
	
	/*
	@SubscribeEvent
	public void onUpdateEvent2(LivingUpdateEvent event) {
		World worldIn = event.getEntityLiving().world;
		EntityLivingBase target = event.getEntityLiving();
		if(target != null && target instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer) target;
			if(entityplayer != null) {
				ItemStack itemstack = ((EntityPlayer) (entityplayer)).getHeldItemMainhand();
				if (!itemstack.isEmpty() && itemstack.getItem() instanceof ItemBinoculars) {//item
					ItemBinoculars gun = (ItemBinoculars) itemstack.getItem();
					if (entityplayer.isHandActive()) 
					{
						if (!entityplayer.isPotionActive(MobEffects.NIGHT_VISION))
							entityplayer.addPotionEffect(
									new PotionEffect(MobEffects.NIGHT_VISION, 401, 1, false, false));
					}else {
						if (entityplayer.isPotionActive(MobEffects.NIGHT_VISION) && entityplayer.getActivePotionEffect(MobEffects.NIGHT_VISION).getDuration() < 400) {
							entityplayer.removeActivePotionEffect(MobEffects.NIGHT_VISION);
						}
					}
				}
			}
		}
	}*/
}

package gvcr2.event.entity;

import gvclib.entity.EntityT_Grenade;
import gvclib.entity.living.EntityVehicleBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.boss.EntityGVCR2_EE_Shark;
import gvcr2.entity.vehicle.set.EntityGVCR2_SET_MG_DP28;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GVCR2EventEasterEgg {
	@SubscribeEvent
	public void onUpdateEvent(LivingUpdateEvent event) {
		EntityLivingBase target = event.getEntityLiving();
		if (target != null && !(target instanceof EntityPlayer)) {
			World worldIn = event.getEntityLiving().world;
			ItemStack HEAD = target.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
			if (target.getRidingEntity() instanceof EntityGVCR2_SET_MG_DP28 && target.getRidingEntity() != null) {// 1
				EntityGVCR2_SET_MG_DP28 vehicle = (EntityGVCR2_SET_MG_DP28) target.getRidingEntity();
				if ((!HEAD.isEmpty())&& HEAD.getItem() == mod_GVCR2.gvcr2_armor_tachanka) {
					if(worldIn.getWorldTime() %4 == 0){
						target.rotationYawHead = target.rotationYaw = vehicle.rotationYawHead = vehicle.rotationYaw = worldIn.rand.nextInt(180) - 90;
						target.rotationPitch = vehicle.rotationPitch =  worldIn.rand.nextInt(90) - 45;
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onUpdateEntityEvent(EntityEvent event) {
		Entity entity = event.getEntity();
		if(entity != null && entity instanceof EntityT_Grenade) {
			World worldIn = event.getEntity().world;
			if(worldIn.getBiome(entity.getPosition()) instanceof BiomeOcean) {
				if(entity.isWet() && worldIn.rand.nextInt(20)==0) {
					if(!worldIn.isRemote) {
						EntityGVCR2_EE_Shark entityskeleton = new EntityGVCR2_EE_Shark(worldIn);
				        entityskeleton.setLocationAndAngles(entity.posX+0.5, entity.posY, entity.posZ+0.5, 0, 0.0F);
				        entityskeleton.setMobMode(1);
				        worldIn.spawnEntity(entityskeleton);
				        entity.setDead();
					}
				}
			}
		}
	}
}

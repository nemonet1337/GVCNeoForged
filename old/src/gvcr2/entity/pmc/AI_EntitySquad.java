package gvcr2.entity.pmc;

import java.util.List;

import gvclib.entity.EntityB_Cratridge;
import gvclib.entity.living.AI_EntityMoveS;
import gvclib.entity.living.AI_EntityMoveS_Squad;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_EntityWeapon_new;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.item.ItemGunBase;
import gvclib.item.ItemGun_Shield;
import gvclib.item.gunbase.IGun_Sword;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.ai.AI_Type2_EntityMoveS;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;

public class AI_EntitySquad {
	public static void load(EntityGVCLivingBase gvcentity) {
		
		float sp = 0.08F;
		if(!(gvcentity.getHealth() > 0)) {
			sp = 0.02F;
		}
		Vec3d looked = gvcentity.getLookVec();
		
		boolean en = false;
		{
			
			List llist = gvcentity.world.getEntitiesWithinAABBExcludingEntity(gvcentity, gvcentity.getEntityBoundingBox()
	        		.expand(gvcentity.motionX, gvcentity.motionY, gvcentity.motionZ).grow(60.0D));
			if (llist != null) {
				for (int lj = 0; lj < llist.size(); lj++) {
					Entity entity1 = (Entity) llist.get(lj);
					if (entity1.canBeCollidedWith() && entity1 != null) {
						if (entity1 instanceof EntityLivingBase && entity1 instanceof EntityPlayer)
                        {
							if (gvcentity.isOwner((EntityLivingBase) entity1)) 
							{
								en = true;
								break;
							}
                        }
					}
				}
			}
		}
		
		//boolean exflag = mod_GirlFront.cfg_exprotion;
		boolean exflag = false;
		boolean tageflag = true;
		if(gvcentity.getRidingEntity() != null && gvcentity.getRidingEntity() instanceof EntityGVCLivingBase) {
			EntityGVCLivingBase vehicle = (EntityGVCLivingBase) gvcentity.getRidingEntity();
			int i = vehicle.getPassengers().indexOf(gvcentity);
			if(vehicle.vehicle_ridding_nofire[i]) {
				tageflag = false;
			}
		}
		
		if(tageflag)AI_EntityWeapon.getTargetEntity(gvcentity, 40, 20, 40);
		int max = 15;
		int range = 30;
		int range2 = 30;
		int moveid = 0;
		ItemStack itemstack = gvcentity.getHeldItemMainhand();
		if(!itemstack.isEmpty()){
			if (itemstack.getItem() instanceof ItemBow) 
	    	{
				if (itemstack.getItem() instanceof ItemGunBase) 
		    	{
					if (itemstack.getItem() instanceof IGun_Sword) 
			    	{
						max = 2;
						AI_EntityWeapon.Biped_Sword(gvcentity, itemstack);
			    	}else{
						ItemGunBase gun = (ItemGunBase) itemstack.getItem();
						max = gun.mobmax;
			    		range = (int) (gun.mobrange *0.75D);
			    		range2 = gun.mobrange;
			    		AI_EntityWeapon.Biped_Gun(gvcentity, itemstack,exflag);
			    	}
		    	}else {
		    		AI_EntityWeapon.Biped_Gun(gvcentity, itemstack,exflag);
					moveid = 0;
		    	}
	    	}
			else if (itemstack.getItem() instanceof ItemSword || itemstack.getItem() instanceof ItemAxe || itemstack.getItem() instanceof ItemSpade) 
	    	{
				max = 2;
				AI_EntityWeapon.Biped_Sword(gvcentity, itemstack);
				moveid = 1;
	    	}
			
			else if (itemstack.getItem() ==  Items.IRON_PICKAXE) 
	    	{
				moveid = 1;
				
	    	}
			else if (itemstack.getItem() ==  mod_GVCR2.gvcr2_item_aed) 
	    	{
				moveid = 3;
	    	}
		}
		if(gvcentity.getArmID_L() == 1) {
			AI_EntityMoveS_Squad.newmove(gvcentity, moveid, sp, 0, max, range, range2, 16);
		}else {
			if(gvcentity.getHealth() > 0)AI_Type2_EntityMoveS.newmove(gvcentity, moveid, sp, 0, max, range, range2);
		}
	}
}

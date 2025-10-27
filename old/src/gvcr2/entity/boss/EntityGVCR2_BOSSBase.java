package gvcr2.entity.boss;

import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.ISoldier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGVCR2_BOSSBase extends EntityGVCR2_BOSSBase_Base implements IMob
{
	
	
	
    public EntityGVCR2_BOSSBase(World worldIn)
    {
        super(worldIn);
    }
    
    public boolean CanAttack(Entity entity){
    	if(!(entity instanceof EntityGVCR2_BOSSBase) && entity instanceof EntityGolem && ((EntityLivingBase) entity).getHealth() > 0.0F){
    		return true;
    	}else if((entity instanceof ISoldier || entity instanceof EntityGolem || entity instanceof EntityVillager) && ((EntityLivingBase) entity).getHealth() > 0.0F){
    		return true;
    	}else if(entity instanceof EntityPlayer && ((EntityLivingBase) entity).getHealth() > 0.0F){
    		EntityPlayer entityplayer = (EntityPlayer) entity;
    		ItemStack itemstack = entityplayer.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
    		if(!itemstack.isEmpty() && itemstack.getItem() == Items.GOLDEN_HELMET){
    			return false;
    		}else{
    		return true;
    		}
    	}else{
    		return false;
    	}
    	/*if(entity instanceof EntityPlayer && ((EntityLivingBase) entity).getHealth() > 0.0F){
    		EntityPlayer entityplayer = (EntityPlayer) entity;
    		ItemStack itemstack = entityplayer.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
    		if(itemstack != null && itemstack.getItem() == Items.GOLDEN_HELMET){
    			return false;
    		}else{
    		return true;
    		}
    	}else{
    		return false;
    	}*/
    }
    
}
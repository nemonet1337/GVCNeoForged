package gvcr2.entity.pmc;

import java.util.List;

import gvclib.entity.living.AI_EntityMoveS;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_setState;
import gvclib.event.GVCSoundEvent;
import gvclib.item.ItemGunBase;
import gvclib.item.gunbase.IGun_Sword;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.ai.AI_Type2_EntityMoveS;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityGVCR2_PMC_S extends EntityGVCR2_PMCBase {

	public EntityGVCR2_PMC_S(World worldIn) {
		super(worldIn);
		this.setSize(0.5F, 1.8F);
	}

	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIRestrictSun(this));
		this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20D);
		// this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0D);
	}
	
	public boolean attackEntityFrom(DamageSource source, float par2)
    {
    	Entity entity;
    	entity = source.getTrueSource();
    	
		if(entity != null){
			if(entity instanceof EntityGVCR2_PMCBase){
				return false;
			}else {
				return super.attackEntityFrom(source, par2);
			}
		}else {
			return super.attackEntityFrom(source, par2);
		}
    }
	
	public boolean canExplosionDestroyBlock(Explosion explosionIn, World worldIn, BlockPos pos, IBlockState blockStateIn, float p_174816_5_)
    {
        return mod_GVCR2.cfg_exprotion_mob;
    }

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		this.setWeapon();
	}
	
	public void setWeapon() {
		int ra = this.world.rand.nextInt(6);
		{
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_ak102));
		}
	}
	
	
	/**
     * Drop the equipment for this entity.
     */
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier)
    {
    	
    }
    /*public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    	this.rotationYaw = this.rotationYawHead = this.rotation =  this.rotationYaw + 1;
		return true;
    }*/
    
    public void getbeacon() {
    }
    
    
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
		/*{
    		this.rotationYaw = this.rotationYaw + 5;
    		this.rotationYawHead = this.rotationYawHead + 5;
    		this.prevRotationYaw = this.prevRotationYaw + 5;
    		this.renderYawOffset = this.renderYawOffset + 5;
    	}
    	return true;*/
    	
		
    	ItemStack itemstack = player.getHeldItem(hand);
        boolean flag = !itemstack.isEmpty();
        if(flag) {
        	if(itemstack.getItem() == mod_GVCR2.gvcr2_item_squad_cn) {//L == 1で指揮下に//L == 0で追従はしない。
        		if(this.getArmID_L() == 0) {
        			this.setArmID_L(1);
        			this.setMoveT(0);
     				if(this.world.isRemote)
     				player.sendMessage(new TextComponentTranslation("gvcr2.order.follow.name", new Object[0]));
        		}else {
        			this.setArmID_L(0);
        			this.setMoveT(3);
      				if(this.world.isRemote)
      				player.sendMessage(new TextComponentTranslation("gvcr2.order.stay.name", new Object[0]));
        		}
        	}else if(itemstack.getItem() == mod_GVCR2.gvcr2_item_wrench  &&  player == this.getOwner()) {
        		if(player.isSneaking()) {
        			if (!this.world.isRemote) {
    					this.setDead();
    				}
        		}
			}else if(itemstack.getItem() == Items.DIAMOND) {
				this.setsquad(player.getDisplayNameString());
				this.setTamedBy(player);
				itemstack.shrink(1);
				if(this.world.isRemote)
					player.sendMessage(new TextComponentTranslation("gvcr2.order.follow.name", new Object[0]));
			}
        	else if(itemstack.getItem() instanceof ItemGunBase) {
        		if(player.isSneaking()) {
        			ItemGunBase gunbase = (ItemGunBase) itemstack.getItem();
    				ItemStack itemstackcopy = itemstack.copy();
    				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, itemstackcopy);
        		}
        	}
        	else if(itemstack.getItem() instanceof ItemArmor) {
        		if(player.isSneaking()) {
        			ItemArmor armor = (ItemArmor) itemstack.getItem();
    				ItemStack itemstackcopy = itemstack.copy();
    				if(armor.armorType == EntityEquipmentSlot.HEAD) {
    					this.setItemStackToSlot(EntityEquipmentSlot.HEAD, itemstackcopy);
    				}
    				if(armor.armorType == EntityEquipmentSlot.CHEST) {
    					this.setItemStackToSlot(EntityEquipmentSlot.CHEST, itemstackcopy);
    				}
    				if(armor.armorType == EntityEquipmentSlot.LEGS) {
    					this.setItemStackToSlot(EntityEquipmentSlot.LEGS, itemstackcopy);
    				}
    				if(armor.armorType == EntityEquipmentSlot.FEET) {
    					this.setItemStackToSlot(EntityEquipmentSlot.FEET, itemstackcopy);
    				}
        		}
        	}
        	else if(itemstack.getItem() == mod_GVCR2.gvcr2_item_bandage) {
        		this.setHealth(this.getHealth() + 4);
				itemstack.shrink(1);
				this.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
				if(this.getHealth() < this.getMaxHealth()) {
					
				}else {
					
				}
        	}else if(itemstack.getItem() == mod_GVCR2.gvcr2_item_aed) {
        		if(player.isSneaking()) {
        			ItemStack itemstackcopy = itemstack.copy();
    				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, itemstackcopy);
        		}else if(this.getHealth() <= 0.0F){
        			this.deathTime = 0;
    				this.setHealth(4);
    				itemstack.shrink(1);
    				this.playSound(SoundEvents.ITEM_SHIELD_BREAK, 1.0F, 1.0F);
        		}
			}
        	else {
        		if(this.getArmID_L() == 0) {
        			 if(this.getMoveT() == 0) {
          				this.setMoveT(3);
          				if(this.world.isRemote)
          				player.sendMessage(new TextComponentTranslation("gvcr2.order.stay.name", new Object[0]));
          			}
          			else if(this.getMoveT() == 3) {
          				this.setMoveT(0);
          				if(this.world.isRemote)
          				player.sendMessage(new TextComponentTranslation("gvcr2.order.free.name", new Object[0]));
          			}
        		}else {
        			 if(this.getMoveT() == 1) {
         				this.setMoveT(0);
         				if(this.world.isRemote)
         				player.sendMessage(new TextComponentTranslation("gvcr2.order.follow.name", new Object[0]));
         			}
         			else if(this.getMoveT() == 0) {
         				this.setMoveT(3);
         				if(this.world.isRemote)
         				player.sendMessage(new TextComponentTranslation("gvcr2.order.stay.name", new Object[0]));
         			}
         			else if(this.getMoveT() == 3) {
         				this.setMoveT(1);
         				if(this.world.isRemote)
         				player.sendMessage(new TextComponentTranslation("gvcr2.order.free.name", new Object[0]));
         			}
        		}
        	}
        }else {
        	if(this.getArmID_L() == 0) {
        		if(this.getMoveT() == 0) {
      				this.setMoveT(3);
      				if(this.world.isRemote)
      				player.sendMessage(new TextComponentTranslation("gvcr2.order.stay.name", new Object[0]));
      			}
      			else if(this.getMoveT() == 3) {
      				this.setMoveT(0);
      				if(this.world.isRemote)
      				player.sendMessage(new TextComponentTranslation("gvcr2.order.free.name", new Object[0]));
      			}
    		}else {
    			if(this.getMoveT() == 1) {
        			this.setMoveT(0);
        			if(this.world.isRemote)
        			player.sendMessage(new TextComponentTranslation("gvcr2.order.follow.name", new Object[0]));
        		}
        		else if(this.getMoveT() == 0) {
        			this.setMoveT(3);
        			if(this.world.isRemote)
        			player.sendMessage(new TextComponentTranslation("gvcr2.order.stay.name", new Object[0]));
        		}
        		else if(this.getMoveT() == 3) {
        			this.setMoveT(1);
        			if(this.world.isRemote)
        			player.sendMessage(new TextComponentTranslation("gvcr2.order.free.name", new Object[0]));
        		}
    		}
        }
        if(flag && itemstack.getItem() == Items.NAME_TAG) {
        	return false;
        }else {
        	return true;
        }
    }
    
    protected void onDeathUpdate() {
		 ++this.deathTicks;
		 this.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 10, 10));
		 if(this.deathTicks == 1) {
			 List llist = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox()
		        		.expand(this.motionX, this.motionY, this.motionZ).grow(60.0D));
				if (llist != null) {
					for (int lj = 0; lj < llist.size(); lj++) {
						Entity entity1 = (Entity) llist.get(lj);
						if (entity1.canBeCollidedWith() && entity1 != null) {
							if (entity1 instanceof EntityLivingBase && entity1 instanceof EntityPlayer)
	                        {
								if (this.isOwner((EntityLivingBase) entity1)) 
								{
									EntityPlayer player = (EntityPlayer) entity1;
									if(this.world.isRemote && this.isOwner(player) &&  player == this.getOwner()) {
									//	TextComponentTranslation aaa = new TextComponentTranslation("hmggirlfront.order.dead.name", new Object[0]);
									//	player.sendMessage(new TextComponentTranslation(this.getCustomNameTag() + "  is a dangerous situation!", new Object[0]));
									break;
									}
								}
	                        }
						}
					}
				}
		 }
		}
    
	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
    int self_ex = 0;
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.biped = true;
		if(this.getRemain_L() <= 0){
			++reload1;
			if(reload1 == reload_time1 - 10){
				this.playSound(GVCSoundEvent.reload_mag, 1.0F, 1.0F);
			}
			if(reload1 >= reload_time1){
				this.setRemain_L(this.magazine);
				reload1 = 0;
			}
		}
		float sp = 0.06F;
		Vec3d looked = this.getLookVec();
		
		//this.setAIType(0);
		this.updateArmSwingProgress();
		if (this.getRidingEntity() == null) {// 1
			if( this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isEmpty()) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_g17));
			}
		}
		
		ItemStack itemstack = this.getHeldItemMainhand();
		if(!itemstack.isEmpty()){
			if (itemstack.getItem() ==  mod_GVCR2.gvcr2_item_aed) 
	    	{
				this.medic = true;
	    	}else {
	    		this.medic = false;
	    	}
		}
		
		
		boolean exflag = false;
		
		AI_EntityWeapon.getTargetEntity(this, 50, 20, 20);
		AI_setState.set(this);
		
		AI_EntitySquad.load(this);
		
    	
	}
}
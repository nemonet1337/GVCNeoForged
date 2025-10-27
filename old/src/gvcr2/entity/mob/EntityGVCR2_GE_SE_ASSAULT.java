package gvcr2.entity.mob;

import java.util.List;

import gvclib.entity.living.AI_EntityMoveS;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.event.GVCSoundEvent;
import gvclib.item.ItemGunBase;
import gvclib.item.gunbase.IGun_Sword;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.ai.AI_Type2_EntityMoveS;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityGVCR2_GE_SE_ASSAULT extends EntityGVCR2_GEBase {

	public EntityGVCR2_GE_SE_ASSAULT(World worldIn) {
		super(worldIn);
		this.setSize(0.5F, 1.8F);
		this.experienceValue = 10;
	}

	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIRestrictSun(this));
		this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200D);
		// this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0D);
	}
	
	

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
	}
	
	public void setWeapon() {
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_m82a3));
		this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.CHAINMAIL_HELMET));
		this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.CHAINMAIL_CHESTPLATE));
		this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.CHAINMAIL_LEGGINGS));
		this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.CHAINMAIL_BOOTS));
	}
	
	
	/**
     * Drop the equipment for this entity.
     */
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier)
    {
    	
    	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_gun_m82a3), 0.0F);
    	
    	int rand = 0;
    	if(this.getMoveT() == 1) {
    		 rand = this.world.rand.nextInt(3);
    	}else {
    		 rand = 0;
    	}
    	if(rand == 0) {
    		/*{
    			int ra = this.world.rand.nextInt(2);
				if (ra == 0) {
					this.entityDropItem(new ItemStack(mod_GVCR.gun_magazine), 0.0F);
					if (!this.getHeldItemMainhand().isEmpty() && this.getHeldItemMainhand().getItem() == mod_GVCR.gun_rpg) {
						this.entityDropItem(new ItemStack(mod_GVCR.gun_magazinerpg), 0.0F);
					}
				}
    		}*/
			{
				int ra = this.world.rand.nextInt(10);
				//for(int x = 0; x < ra; ++x) {
				if (ra == 0) {
					this.entityDropItem(new ItemStack(Items.EMERALD), 0.0F);
				}
			}
			{
				int ra = this.world.rand.nextInt(6);
				if (ra == 0) {
					this.entityDropItem(new ItemStack(Items.GUNPOWDER), 0.0F);
				}
			}
			
			
    	}
    }
    /*public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    	this.rotationYaw = this.rotationYawHead = this.rotation =  this.rotationYaw + 1;
		return true;
    }*/
    
    public void getbeacon() {
    	
    }
    
    /**
     * Add the given player to the list of players tracking this entity. For instance, a player may track a boss in
     * order to view its associated boss bar.
     */
    public void addTrackingPlayer(EntityPlayerMP player)
    {
        super.addTrackingPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    /**
     * Removes the given player from the list of players tracking this entity. See {@link Entity#addTrackingPlayer} for
     * more information on tracking.
     */
    public void removeTrackingPlayer(EntityPlayerMP player)
    {
        super.removeTrackingPlayer(player);
        this.bossInfo.removePlayer(player);
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
		
		if(this.getHealth() > 0.0F) {
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}
		
		//this.setAIType(0);
		this.updateArmSwingProgress();
		if (this.getRidingEntity() == null) {// 1
			if( this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isEmpty()) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_m82a3));
			}
		}
		
		boolean exflag = false;
		
		AI_EntityWeapon.getTargetEntity(this, 50, 20, 20);
		
		if(this.onGround){
			if(this.world.rand.nextInt(400) == 0){
				this.motionY = 1.5;
				this.motionX = 1;
			}
			if(this.world.rand.nextInt(400) == 100){
				this.motionY = 1.5;
				this.motionZ = 1;
			}
			if(this.world.rand.nextInt(400) == 200){
				this.motionY = 1.5;
				this.motionX = -1;
			}
			if(this.world.rand.nextInt(400) == 300){
				this.motionY = 1.5;
				this.motionZ = -1;
			}
		}
		
		{
			int kazu = 0;
			double k = this.posX;
			double l = this.posY;
			double i = this.posZ;
			int han = 20;
			int bit = 0;
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double) (k - han), (double) (l - han),
					(double) (i - han), (double) (k + han), (double) (l + han), (double) (i + han)))
							.grow(1);
			List<Entity> llist = this.world.getEntitiesWithinAABBExcludingEntity(this, axisalignedbb);
			if (llist != null) {
				for (int lj = 0; lj < llist.size(); lj++) {
					Entity entity1 = (Entity) llist.get(lj);
					if (entity1.canBeCollidedWith()) {
						if (entity1 instanceof EntityGVCR2_GE_U_DRONE && entity1 != null) {
							++bit;
						}
					}
				}
			}
			if(bit < 2 +this.world.getDifficulty().getDifficultyId()) {
				if(this.cooltime2 >= 60) {
		        			float yaw = this.rotationYaw * (2 * (float) Math.PI / 360);
							double mox = 0;
							double moy = this.motionY;
							double moz = 0;
							
							mox -= MathHelper.sin(yaw - 1.57F) * 2;
							moz += MathHelper.cos(yaw - 1.57F) * 2;
							{
								EntityGVCR2_GE_U_DRONE entityskeleton = new EntityGVCR2_GE_U_DRONE(this.world);
					            entityskeleton.setLocationAndAngles(this.posX + mox, this.posY+2, this.posZ + moz, this.rotationYaw, 0.0F);
					            entityskeleton.targetentity = this.targetentity;
					            entityskeleton.setOwnerId(this.entityUniqueID);
					            if(!this.world.isRemote) {
					            	this.world.spawnEntity(entityskeleton);
					            }
							}
							this.cooltime2 = 0;
				}
			}else {
				//this.cooltime = 0;
			}
		}
		
		
		
		int max = 30;
		int range = 30;
		int range2 = 50;
		int moveid = 0;
		ItemStack itemstack = this.getHeldItemMainhand();
		if(!itemstack.isEmpty()){
			if (itemstack.getItem() instanceof ItemBow) 
	    	{
				if (itemstack.getItem() instanceof ItemGunBase) 
		    	{
					if (itemstack.getItem() instanceof IGun_Sword) 
			    	{
						max = 2;
						AI_EntityWeapon.Biped_Sword(this, itemstack);
			    	}else{
						ItemGunBase gun = (ItemGunBase) itemstack.getItem();
						max = gun.mobmax;
			    		range = (int) (gun.mobrange *0.75D);
			    		range2 = gun.mobrange;
			    		AI_EntityWeapon.Biped_Gun(this, itemstack,exflag);
			    	}
		    	}else {
		    		AI_EntityWeapon.Biped_Gun(this, itemstack,exflag);
					moveid = 0;
		    	}
	    	}
			
		}
		AI_Type2_EntityMoveS.newmove(this, moveid, sp, 0, max, range, range2);
		
		
		
    	
	}
}
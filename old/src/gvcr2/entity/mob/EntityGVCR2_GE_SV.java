package gvcr2.entity.mob;

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
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
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

public class EntityGVCR2_GE_SV extends EntityGVCR2_GEBase {

	public EntityGVCR2_GE_SV(World worldIn) {
		super(worldIn);
		this.setSize(0.5F, 1.8F);
		this.experienceValue = 20;
	}

	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIRestrictSun(this));
		this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40D);
		// this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
	}
	
	public boolean getCanSpawnHere() {
		return this.getLevel() >= 2 && super.getCanSpawnHere();
	}

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		this.setWeapon();
	}
	
	public void setWeapon() {
		int ra = this.world.rand.nextInt(7);
		this.setWeaponID(ra);
	}
	
	public void setWeaponID_Spawn(int id, boolean eggorblock) {
		
		boolean flagss = true;
		if(this.getLevel() < 4) {
			flagss = false;
		}
		if(eggorblock) {
			flagss = true;
		}
		
		
		if(id == 1) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_fm));
			this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(mod_GVCR2.gvcr2_armor_firemask));
			this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.LEATHER_CHESTPLATE));
			this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.LEATHER_LEGGINGS));
			this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.LEATHER_BOOTS));
		}
		else if(id == 2 && flagss) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_ptrd));
			//this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(mod_GVCR2.gvcr2_armor_gasmask));
			//this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.LEATHER_HELMET));
			//this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.LEATHER_CHESTPLATE));
			//this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.LEATHER_LEGGINGS));
			//this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.LEATHER_BOOTS));
		}
		else if(id == 3) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_club));
			this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(mod_GVCR2.gvcr2_armor_trenchmask));
			//this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
			//this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
			//this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
			this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_trench_body));
			this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(mod_GVCR2.gvcr2_armor_trench_leggings));
			this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(mod_GVCR2.gvcr2_armor_trench_boots));
		}
		else if(id == 4) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_m1891));
			this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(mod_GVCR2.gvcr2_armor_camouflage_head));
			this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_camouflage_body));
			this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(mod_GVCR2.gvcr2_armor_camouflage_leggings));
			this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(mod_GVCR2.gvcr2_armor_camouflage_boots));
		}
		else if(id == 5 && flagss) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_vz61));
			this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(mod_GVCR2.gvcr2_gun_riotshield));
			this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(mod_GVCR2.gvcr2_armor_sehelmet));
			this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_sechest));
		}
		else {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_pkm));
			this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(mod_GVCR2.gvcr2_armor_tachanka));
			this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
			this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
			this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
		}
		
		if(!this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isEmpty() && (this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem() instanceof ItemGunBase)) {
			ItemGunBase gun = (ItemGunBase) this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem();
			this.setRemain_L(gun.getMaxDamage());
		}
	}
	
	public void setWeaponID(int id) {
		setWeaponID_Spawn(id, false);
	}
	
	
	/**
     * Drop the equipment for this entity.
     */
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier)
    {
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
    		if(!this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isEmpty()) {
    			this.entityDropItem(this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND), 0.0F);
    		}
			{
				int ra = this.world.rand.nextInt(4) + 1;
				for(int x = 0; x < ra; ++x) 
				{
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
    	/*int i = 64;
    	if(this.cooltime6 > 200) {
    		for(int x = 0; x < i; ++x) {
    			for(int y = 0; y < i; ++y) {
    				for(int z = 0; z < i; ++z) {
    					if(this.world.getBlockState(new BlockPos(this.posX -32 + x, this.posY - 32 + y, this.posZ - 32 + z)).getBlock() == mod_GVCR.b_beacon_b) {
    						this.setMoveT(1);
    						this.setMoveX((int) (this.posX -32 + x));
    						this.setMoveY((int) (this.posY -32 + y));
    						this.setMoveZ((int) (this.posZ -32 + z));
    						break;
    					}
    				}
    			}
    		}
    		this.cooltime6 = 0;
    	}
    	int i2 = 2;
    	for(int x = 0; x < i2; ++x) {
			for(int y = 0; y < i2; ++y) {
				for(int z = 0; z < i2; ++z) {
					if(this.world.getBlockState(new BlockPos(this.posX -1 + x, this.posY - 1 + y, this.posZ - 1 + z)).getBlock() == mod_GVCR.b_beacon_b) {
						this.setMoveT(0);
						if(!this.world.isRemote) {
							this.world.setBlockState(new BlockPos(this.posX -1 + x, this.posY - 1 + y, this.posZ - 1 + z)
									, mod_GVCR.b_beacon.getDefaultState(), 2);
						}
						break;
					}
				}
			}
		}*/
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
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_pkm));
			}
		}
		/*if(this.onGround) {
			if(this.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty() 
					&& this.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == mod_GVCR.armor_parachestp) {
				this.setItemStackToSlot(EntityEquipmentSlot.CHEST, this.getItemStackFromSlot(EntityEquipmentSlot.CHEST).EMPTY);
			}
		}*/
		
		boolean exflag = false;
		
		AI_EntityWeapon.getTargetEntity(this, 50, 20, 20);
		AI_setState.set(this);
		
		
		if( !this.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty()
				&& this.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == mod_GVCR2.gvcr2_armor_sechest ){
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
			if(bit < 1 +this.world.getDifficulty().getDifficultyId()) {
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
						moveid = 1;
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
			else if (itemstack.getItem() instanceof ItemSword || itemstack.getItem() instanceof ItemAxe || itemstack.getItem() instanceof ItemSpade) 
	    	{
				max = 2;
				AI_EntityWeapon.Biped_Sword(this, itemstack);
				moveid = 1;
	    	}
			
			else if (itemstack.getItem() ==  Items.IRON_PICKAXE) 
	    	{
				moveid = 1;
				
	    	}
			else// if (itemstack == new ItemStack(Blocks.TNT)) 
	    	{
	    		AI_EntityMoveS.newmove(this, 2, 0.06F, 0, 0, 40, 40);
	    		if(AI_EntityWeapon.getRange(this, 2, 5, 5)){
	    			++self_ex;
	    			if (!this.world.isRemote && self_ex > 60) {
	    				GVCExplosionBase.ExplosionKai(this, this, this.posX, this.posY, this.posZ, 3.5F, true,  exflag);
	    				if (!this.world.isRemote) {
	    					this.setDead();
	    				}
	    			}
	    		}else {
	    			self_ex = 0;
	    		}
	    	}
		}
		
		if(!this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isEmpty() 
				&& this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem() == mod_GVCR2.gvcr2_gun_club) {
			sp = 0.10F;
		}
		
		AI_Type2_EntityMoveS.newmove(this, moveid, sp, 0, max, range, range2);
		
		
		ItemStack itemstackl = this.getHeldItemOffhand();
		if(!itemstackl.isEmpty()){
			if (itemstackl.getItem() instanceof ItemBow) 
	    	{
				AI_EntityWeapon.Biped_Gun(this, itemstackl,exflag);
				if (itemstackl.getItem() instanceof ItemGunBase) 
		    	{
					ItemGunBase gun = (ItemGunBase) itemstackl.getItem();
					max = gun.mobmax;
		    		range = gun.mobrange;
		    	}
				//AI_EntityMoveS.newmove(this, 0, sp, 0, max, range, range2);
	    	}
			
		}
    	
	}
}
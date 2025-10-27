package gvcr2.entity.mob;

import gvclib.entity.EntityT_Grenade;
import gvclib.entity.living.AI_EntityMoveS;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_setState;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityVehicleBase;
import gvclib.event.GVCSoundEvent;
import gvclib.item.ItemGunBase;
import gvclib.item.ItemGun_Shield;
import gvclib.item.gunbase.IGun_Sword;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.ai.AI_Type2_EntityMoveS;
import gvcr2.entity.ai.AI_Type3_EntityMoveS;
import gvcr2.entity.so.EntityGVCR2_SOBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityGVCR2_UNKS_C_S extends EntityGVCR2_UNKS_CBase {

	public EntityGVCR2_UNKS_C_S(World worldIn) {
		super(worldIn);
		this.setSize(0.5F, 1.8F);
		this.experienceValue = 10;
		this.fire_muteki = true;
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
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
	}
	
	
	public boolean getCanSpawnHere() {
		return this.getLevel() >= 0 && super.getCanSpawnHere();
	}

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		this.setWeapon(false);
	}
	
	public void setWeapon(boolean spawn) {
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_type95));
		this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_chest_rig));
	}
	
	public boolean attackEntityFrom(DamageSource source, float par2)
    {
    	Entity entity;
    	entity = source.getTrueSource();
    	
		if(entity != null){
			if(entity instanceof EntityGVCR2_UNKS_CBase){
				return false;
			}else {
				return super.attackEntityFrom(source, par2);
			}
		}else {
			return super.attackEntityFrom(source, par2);
		}
    }
	
	public void setWeapon_airborne() {
		int ra = this.world.rand.nextInt(6);
		/*if (ra == 0) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_m10));
		}
		else if (ra == 1) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_m79));
		} 
		else if (ra == 2) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_m870));
		} 
		else if (ra == 3) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_m63));
		} 
		else if (ra == 4) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_item_aed));
		} 
		else //if (ra == 1) 
		{
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_m4a1));
		}*/
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_type95));
		this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_chest_rig));
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
		if(this.getRemain_R() <= 0){
			++reload2;
			if(reload2 >= 60){
				this.setRemain_R(1);
				reload2 = 0;
			}
		}
		float sp = 0.06F;
		Vec3d looked = this.getLookVec();
		
		//this.setAIType(0);
		this.updateArmSwingProgress();
		if (this.getRidingEntity() == null) {// 1
			if( this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isEmpty()) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_pm));
			}
		}
		/*if(this.onGround) {
			if(this.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty() 
					&& this.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == mod_GVCR.armor_parachestp) {
				this.setItemStackToSlot(EntityEquipmentSlot.CHEST, this.getItemStackFromSlot(EntityEquipmentSlot.CHEST).EMPTY);
			}
		}*/
		
		boolean exflag = true;
		
		AI_EntityWeapon.getTargetEntity(this, 60, 20, 20);
		AI_setState.set(this);
		
		if (this.getRidingEntity() instanceof EntityVehicleBase && this.getRidingEntity() != null) {// 1
			this.posX = this.getRidingEntity().posX;
			this.posZ = this.getRidingEntity().posZ;
			this.posY = this.getRidingEntity().posY;
		}
		
		
		
		int max = 20;
		int range = 60;
		int attack_range = 30;
		int moveid = 0;
		ItemStack itemstack = this.getHeldItemMainhand();
		if(this.discover_count > 20 - (this.world.getDifficulty().getDifficultyId() * 5))
		{
			if(this.getAIType() == 1) {
				if(this.getattacktask()){
		    		if(this.getRemain_R() > 0)
					{
		    			{
			    			{
								String model = "gvclib:textures/entity/BulletNormal.obj";
					    		String tex = "gvclib:textures/entity/BulletNormal.png";
					    		SoundEvent sounds = GVCSoundEvent.fire_mg;
					    		
					    		EntityT_Grenade entitysnowball = new EntityT_Grenade(this.world, this);
					    		//entitysnowball.exsmoke = true;
					    		entitysnowball.timemax = 60;
					    		entitysnowball.exlevel = 3.0F;
					    		entitysnowball.gra = -0.03F;
					    		if(this.world.rand.nextInt(6) == 0) {
					    			entitysnowball.exflash = true;
					    			entitysnowball.setModel("gvclib:textures/entity/model/grenade_smoke.mqo");
					    			entitysnowball.setTex("gvclib:textures/entity/model/grenade_smoke.png");
					    		}else {
					    			entitysnowball.setModel("gvclib:textures/entity/model/grenade.mqo");
					    			entitysnowball.setTex("gvclib:textures/entity/model/grenade.png");
					    		}
					            entitysnowball.setHeadingFromThrower(this, this.rotationPitch, this.rotationYaw, 0.0F, 1.2F, 1.0F);
					            this.playSound(SoundEvents.ENTITY_SNOWMAN_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
					            if(!this.world.isRemote)this.world.spawnEntity(entitysnowball);
							}
							this.setRemain_R(this.getRemain_R() - 1);
							//this.cooltime2 = 0;
		    			}
					}
		    	}
			}
			else if(!itemstack.isEmpty()){
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
				    		attack_range = gun.mobrange;
				    		
				    		boolean flag = true;
				    		{
								Vec3d lock = Vec3d.fromPitchYaw(this.rotationPitch, this.rotationYawHead);//entity.getForward();
								for(int xxx = 0; xxx < 5; ++xxx) {
									BlockPos pos1 = new BlockPos(this.posX + lock.x * xxx, this.getEntityBoundingBox().minY + (double)this.height + lock.y * xxx,this.posZ + lock.z * xxx);
									if (this.world.getBlockState(pos1).getBlock() != Blocks.AIR) {
										flag = false;
									}
								}
				    		}
				    		if(flag)Biped_Gun_new(this, itemstack,exflag, 1, 1F);
				    	}
			    	}
		    	}
			}
		}
		
		AI_Type3_EntityMoveS.newmove(this, moveid, sp, 0, max, range, attack_range);
		
		
		ItemStack itemstackl = this.getHeldItemOffhand();
		if(!itemstackl.isEmpty()){
			if (itemstackl.getItem() instanceof ItemBow) 
	    	{
				Biped_Gun_new(this, itemstackl,exflag, 1, 1F);
				if (itemstackl.getItem() instanceof ItemGunBase) 
		    	{
					ItemGunBase gun = (ItemGunBase) itemstackl.getItem();
					max = gun.mobmax;
		    		range = gun.mobrange;
		    	}
	    	}
			
		}
		
	}
	
	public static void Biped_Gun_new(EntityGVCLivingBase entity, ItemStack itemstack, boolean ex, int powor_offset, float speed_offset){
		Vec3d looked = entity.getLookVec();
		if (itemstack.getItem() instanceof ItemGunBase && !(itemstack.getItem() instanceof ItemGun_Shield)) 
    	{
			ItemGunBase gun = (ItemGunBase) itemstack.getItem();
			entity.magazine = gun.getMaxDamage();
			entity.reload_time1 = gun.reloadtime;
    		String model = gun.bullet_model;
    		String tex = gun.bullet_tex;
    		String modelf = gun.bulletf_model;
    		String texf = gun.bulletf_tex;
        	{
        		if(entity.cooltime > 12 && entity.getRemain_L() > 0)
    			{
        			entity.counter1 = true;
        			entity.cooltime = 0;
    			}
        		if(entity.counter1 && entity.gun_count1 > gun.mobcycle && entity.getRemain_L() > 0){
        			SoundEvent sounds = SoundEvents.ENTITY_SKELETON_SHOOT;
        			if(gun.fires != null) {
        				sounds = gun.fires;
        			}else if(gun.sound != null){
        				sounds = SoundEvent.REGISTRY.getObject(new ResourceLocation(gun.modid, gun.sound));
        			}
        			float speed = gun.speed * speed_offset;
        			if(speed > 4F)speed = 4F;
        			AI_EntityWeapon.Attacktask(entity, entity, gun.mobbullettype, gun.mobrange, 
        					model, tex, modelf, texf,2, 
        					sounds, 
        					0, 0, 1.5, 1.0,entity.posX, entity.posY, entity.posZ,looked,entity.rotationYawHead, 20, 10,
    						gun.powor / powor_offset, speed, gun.bure, gun.exlevel, ex, gun.shotgun_pellet, gun.gra, gun.bullet_time_max, 0);
    				entity.gun_count1 = 0;
    				if(entity.firetrue){
    					entity.setRemain_L(entity.getRemain_L() - 1);
    				}
    				++entity.countlimit1;
    			}
    			if(entity.countlimit1 >= gun.mobbarst){
    				entity.gun_count1 = 0;
    				entity.counter1 = false;
    				entity.countlimit1 = 0;
    			}
        	}
    		//max = gun.mobmax;
    		//range = gun.mobrange;
    	}else if(!(itemstack.getItem() instanceof ItemGun_Shield)){
    		ItemBow bow = (ItemBow) itemstack.getItem();
    		{
        		if(entity.cooltime > 50)
    			{
	        			AI_EntityWeapon.Attacktask(entity, entity, 51, 20, 
	        					"gvclib:textures/entity/BulletAAA.obj","gvclib:textures/entity/BulletAAA.png",
	        					"gvclib:textures/entity/BulletAAA.obj","gvclib:textures/entity/BulletAAA.png",2, 
	        					SoundEvents.ENTITY_SKELETON_SHOOT, 
	        					0, 0, 1.5, 0.5,entity.posX, entity.posY, entity.posZ,looked,entity.rotationYawHead, 20, 10,
	    						6, 1.6F, 5, 0, false, 1, 0.025D, 80, 0);
	        			entity.cooltime = 0;
    			}
        	}
    	}
	}
}
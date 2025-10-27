package gvcr2.entity.mob;

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
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityGVCR2_BOSS_MER03K extends EntityGVCR2_GEBase {

	public EntityGVCR2_BOSS_MER03K(World worldIn) {
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
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
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
		
	}
	
	
	/**
     * Drop the equipment for this entity.
     */
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier)
    {
    	DamageSource source = this.getLastDamageSource();
    	int rand = 0;
    	if(this.getMoveT() == 1) {
    		 rand = this.world.rand.nextInt(3);
    	}else if(source == null || source.getTrueSource() == null) {
    		rand = 1;
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
			{
				int ra = this.world.rand.nextInt(5);
				if (ra == 0) {
					this.entityDropItem(new ItemStack(Items.BREAD), 0.0F);
				}
			}
			{
				int ra = this.world.rand.nextInt(4);
				if (ra == 0) {
					int kazu = this.world.rand.nextInt(10) + 1;
					for(int x = 0; x < kazu; ++x) {
						ItemStack stack = this.getHeldItemMainhand();
						if(!stack.isEmpty() && stack.getItem() instanceof ItemGunBase) {
							ItemGunBase gun = (ItemGunBase) stack.getItem();
							if(gun.magazine != null) {
								this.entityDropItem(new ItemStack(gun.magazine), 0.0F);
							}
						}
					}
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
    
    //　初回のみロード
    boolean spawn_reload = true;
    
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
		
		
		//if(this.getcanDespawn() == 1 && mod_GVCR2.cfg_return_block)this.doblock(this, 80, mod_GVCR2.gvcr2_block_ge_s);
		
		//this.setAIType(0);
		this.updateArmSwingProgress();
		if (this.getRidingEntity() == null) {// 1
			if( this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isEmpty()) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_stg44));
			}
		}
		
		
		
		boolean exflag = true;
		
		AI_EntityWeapon.getTargetEntity(this, 50, 20, 20);
		AI_setState.set(this);
		
		
		
		int max = 20;
		int range = 50;
		int attack_range = 30;
		int moveid = 0;
		ItemStack itemstack = this.getHeldItemMainhand();
		if(this.discover_count > 20)//20  40
		{
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
				    		if(flag)AI_EntityWeapon.Biped_Gun_new(this, itemstack,exflag, 2, 0.75F);
				    	}
			    	}else {
			    		AI_EntityWeapon.Biped_Gun(this, itemstack,exflag);
						moveid = 0;
			    	}
		    	}
			}
		}
		
		AI_Type2_EntityMoveS.newmove(this, moveid, sp, 0, max, range, attack_range);
		
		
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
		
		
		/*if(!spawn_reload) {
			if(this.getRemain_L() <= 0){
				{
					this.playSound(GVCSoundEvent.reload_mag, 1.0F, 1.0F);
					this.setRemain_L(this.magazine);
					reload1 = 0;
				}
			}
			spawn_reload = true;
		}*/
		
	}
}
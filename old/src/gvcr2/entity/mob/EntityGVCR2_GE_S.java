package gvcr2.entity.mob;

import java.util.Collection;

import gvclib.entity.living.AI_EntityMoveS;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_setState;
import gvclib.event.GVCPotion;
import gvclib.event.GVCSoundEvent;
import gvclib.item.ItemGunBase;
import gvclib.item.ItemMagazine;
import gvclib.item.gunbase.IGun_Sword;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.ai.AI_Type2_EntityMoveS;
import gvcr2.entity.bullet.EntityGVCR2_STARS;
import gvcr2.entity.pmc.EntityGVCR2_PMC_S;
import gvcr2.entity.so.EntityGVCR2_SO_S;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityGVCR2_GE_S extends EntityGVCR2_GEBase {

	public EntityGVCR2_GE_S(World worldIn) {
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
	
	public boolean attackEntityFrom(DamageSource source, float par2)
    {
		//MoveT == 1用　ダメージを受けた時にノックバックでブロックを置かないように
		{
			this.cooltime4 = 0;
		}
		return super.attackEntityFrom(source, par2);
    }
	
	public void setWeapon(boolean spawn) {
		if(mod_GVCR2.difficult_level == 0) {
			int ra = this.world.rand.nextInt(6);
			if (ra == 0) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_pm));
			} 
			else if (ra == 1) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_mp40));
			}
			else //if (ra == 1) 
			{
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_sks));
			}
		}
		else if(mod_GVCR2.difficult_level >= 6) {
			int ra = this.world.rand.nextInt(12);
			if (ra == 0) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_sks));
			} 
			else if (ra == 1) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_mp40));
			}
			else if (ra == 2) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_uzi));
			}
			else if (ra == 3) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_dp28));
			}
			else if (ra == 4) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_m1891));
			}
			else if (ra == 5 && mod_GVCR2.cfg_canspawn_mob_ge_rpg && !spawn) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_rpg7));
			}
			else if (ra == 6) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_m870));
			}
			else if (ra == 7) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_svd));
			}
			else if (ra == 8 && mod_GVCR2.cfg_canspawn_mob_ge_rpg && !spawn) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_panzerfaust));
			}
			else{
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_ak74));
			}
		}
		else if(mod_GVCR2.difficult_level >= 4) {
			int ra = this.world.rand.nextInt(10);
			if (ra == 0) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_sks));
			} 
			else if (ra == 1) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_mp40));
			}
			else if (ra == 2) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_uzi));
			}
			else if (ra == 3) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_dp28));
			}
			else if (ra == 5 && mod_GVCR2.cfg_canspawn_mob_ge_rpg && !spawn) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_rpg7));
			}
			else if (ra == 6) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_svd));
			}
			else if (ra == 7) {
				//this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_panzerfaust));
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_ak74));
			}
			else{
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_ak74));
			}
		}
		else if(mod_GVCR2.difficult_level >= 3) {
			int ra = this.world.rand.nextInt(8);
			if (ra == 0) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_sks));
			} 
			else if (ra == 1) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_mp40));
			}
			else if (ra == 2) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_uzi));
			}
			else if (ra == 4 && mod_GVCR2.cfg_canspawn_mob_ge_rpg && !spawn) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_rpg7));
			}
			else if (ra == 5) {
				//this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_panzerfaust));
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_ak47));
			}
			else{
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_ak47));
			}
		}
		else if(mod_GVCR2.difficult_level >= 1) {
			int ra = this.world.rand.nextInt(5);
			if (ra == 0) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_ak47));
			} 
			else if (ra == 1) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_mp40));
			}
			else if (ra == 2) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_uzi));
			}
			else{
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_sks));
			}
		}
		if(!this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isEmpty() && (this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem() instanceof ItemGunBase)) {
			ItemGunBase gun = (ItemGunBase) this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem();
			this.setRemain_L(gun.getMaxDamage());
		}
		
	}
	
	public void setWeapon_inv(boolean spawn) {
		{
			int ra = this.world.rand.nextInt(12);
			if (ra == 0 || ra == 1) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_PICKAXE));
			} 
			else if (ra == 2) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_uzi));
			}
			else if (ra == 3) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_dp28));
			}
			else if (ra == 4) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_m1891));
			}
			else if (ra == 5 && mod_GVCR2.cfg_canspawn_mob_ge_rpg && !spawn) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_rpg7));
			}
			else if (ra == 6) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_m870));
			}
			else if (ra == 7) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_svd));
			}
			else if (ra == 8) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_item_binoculars));
			}
			else{
				int ra2 = this.world.rand.nextInt(3);
				if (ra == 0) {
					this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_ak74));
				}else {
					this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_ak47));
				}
			}
		}
		if(!this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isEmpty() && (this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem() instanceof ItemGunBase)) {
			ItemGunBase gun = (ItemGunBase) this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem();
			this.setRemain_L(gun.getMaxDamage());
		}
	}
	
	public void setWeapon_inv_airborne(boolean spawn) {
		{
			int ra = this.world.rand.nextInt(6);
			if (ra == 0 || ra == 1) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_uzi));
			} 
			else if (ra == 2) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_m870));
			}
			else if (ra == 3) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_rpk47));
			}
			else if (ra == 4) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_pm));
				this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(mod_GVCR2.gvcr2_gun_pm));
			}
			else{
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_aks74u));
			}
		}
		if(!this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isEmpty() && (this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem() instanceof ItemGunBase)) {
			ItemGunBase gun = (ItemGunBase) this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem();
			this.setRemain_L(gun.getMaxDamage());
		}
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
			
			{
				int ran = this.world.rand.nextInt(30);
				if (ran == 0) {
					int ra = this.world.rand.nextInt(18);
					switch (ra) {
			        case 1:
			        	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_am_compm4), 0.0F);
			            break;
			        case 2:
			        	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_am_coyote), 0.0F);
			            break;
			        case 3:
			        	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_am_horo), 0.0F);
			            break;
			        case 4:
			        	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_am_kobra), 0.0F);
			            break;
			        case 5:
			        	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_am_micro), 0.0F);
			            break;
			        case 6:
			        	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_am_acog), 0.0F);
			            break;
			        case 7:
			        	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_am_m145), 0.0F);
			            break;
			        case 8:
			        	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_am_scope), 0.0F);
			            break;
			        case 9:
			        	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_am_lasersight), 0.0F);
			            break;
			        case 10:
			        	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_am_flashlight), 0.0F);
			            break;
			        case 11:
			        	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_am_suppressor), 0.0F);
			            break;
			        case 12:
			        	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_am_grip), 0.0F);
			            break;
			        case 13:
			        	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_am_anglegrip), 0.0F);
			            break;
			        case 14:
			        	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_am_bipod), 0.0F);
			            break;
			        case 15:
			        	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_am_gripod), 0.0F);
			            break;
			        default:
			        	this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_am_dotsight), 0.0F);
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
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    	if (this.isPotionActive(MobEffects.SLOWNESS))
        {
    		ItemStack itemstack = player.getHeldItem(hand);
            boolean flag = !itemstack.isEmpty();
            if(flag) {
            	if(itemstack.getItem() == mod_GVCR2.gvcr2_item_stars) {
            		if(!this.world.isRemote) {
            			EntityGVCR2_STARS ent = new EntityGVCR2_STARS(this.world);
            			ent.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            			ent.setcanDespawn(1);
            			this.world.spawnEntity(ent);
            			
            			this.startRiding(ent);
            		}
            	}
            }
            return true;
        }else {
        	return super.processInteract(player, hand);
        }
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
		
		
		if(this.getMoveT() == 1 && this.experienceValue > 0){
			this.experienceValue = 0;
		}
		if(this.getMoveT() == 1){
			this.setattacktask(true);
		}
		
		
		
		float sp = 0.06F;
		Vec3d looked = this.getLookVec();
		
		
		if(this.getcanDespawn() == 1 && mod_GVCR2.cfg_return_block && (this.getMoveT() != 1))this.doblock(this, 80, mod_GVCR2.gvcr2_block_ge_s);
		
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
		
		AI_EntityWeapon.getTargetEntity(this, 50, 20, 20);
		AI_setState.set(this);
		
		
		
		int max = 20;
		int range = 50;
		int attack_range = 30;
		int moveid = 0;
		ItemStack itemstack = this.getHeldItemMainhand();
		if(this.discover_count > mod_GVCR2.cfg_targeting_time - (this.world.getDifficulty().getDifficultyId() * 5))//20  40
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
				else if (itemstack.getItem() instanceof ItemSword || itemstack.getItem() instanceof ItemAxe || itemstack.getItem() instanceof ItemSpade) 
		    	{
					max = 2;
					AI_EntityWeapon.Biped_Sword(this, itemstack);
					moveid = 1;
		    	}
				
				else if (itemstack.getItem() ==  Items.IRON_PICKAXE) 
		    	{
					moveid = 1;
					sp = 0.12F;
					
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
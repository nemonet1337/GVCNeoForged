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
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityGVCR2_GE_S_MR_CPT extends EntityGVCR2_GEBase {

	public EntityGVCR2_GE_S_MR_CPT(World worldIn) {
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
	
	public void setWeapon(boolean spawn) {
		
	}
	
	protected void onDeathUpdate() {
		super.onDeathUpdate();
		/*if(!this.world.isRemote && this.deathTime == 19) {
			//GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 2, false,  false);
			{
				this.world.setBlockState(new BlockPos(this.getMoveX(), this.getMoveY(), this.getMoveZ()), Blocks.CHEST.getDefaultState(), 2);
				TileEntityChest Chest3;
				Chest3 = (TileEntityChest) this.world.getTileEntity(new BlockPos(this.getMoveX(), this.getMoveY(), this.getMoveZ()));
				Chest3.setInventorySlotContents(0, new ItemStack(mod_GVCR2.gvcr2_spawn_so_s, 12, 0));
				
				//Chest3.setInventorySlotContents(0, new ItemStack(mod_GVCR.i_aichip, 1, 0));
			}
		}*/
	}
	
	/**
     * Drop the equipment for this entity.
     */
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier)
    {
    	for(int x = 0; x < 10; ++x) {
    		this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_spawn_so_s), 0.0F);
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
		if(this.discover_count > 40 - (this.world.getDifficulty().getDifficultyId() * 5)){
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
		
	}
}
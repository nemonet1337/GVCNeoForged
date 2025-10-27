package gvcr2.entity.so;

import java.util.List;

import gvclib.entity.living.AI_EntityMoveS;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_setState;
import gvclib.entity.living.EntityVehicleBase;
import gvclib.event.GVCSoundEvent;
import gvclib.item.ItemGunBase;
import gvclib.item.gunbase.IGun_Sword;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.ai.AI_Type2_EntityMoveS;
import gvcr2.entity.mob.EntityGVCR2_GE_Jamming;
import gvcr2.entity.mob.EntityGVCR2_UNKS_C_S;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_A10;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_C130;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class EntityGVCR2_SO_S_MR_CPT extends EntityGVCR2_SOBase {

	public EntityGVCR2_SO_S_MR_CPT(World worldIn) {
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
	
	public boolean canExplosionDestroyBlock(Explosion explosionIn, World worldIn, BlockPos pos, IBlockState blockStateIn, float p_174816_5_)
    {
        return mod_GVCR2.cfg_exprotion_mob;
    }

	public boolean getCanSpawnHere() {
		return this.getLevel() >= 0 && super.getCanSpawnHere();
	}
	
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		this.setWeapon();
	}
	
	
	public void setWeapon() {
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_m93r));
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
    	if(this.getArmID_A() == 0){
    		this.startuptime = 0;
    		this.sendmessage("gvcr2.string.message.s_mr_cpt_.talk_1.name", player);
    		this.setArmID_A(1);
    	}else if(this.getArmID_A() == 1){
    		this.sendmessage("gvcr2.string.message.s_mr_cpt_.talk_2.name", player);
    		this.setArmID_A(2);
    	}else if(this.getArmID_A() == 2){
    		this.sendmessage("gvcr2.string.message.s_mr_cpt_.talk_3.name", player);
    		this.setArmID_A(3);
    	}else if(this.getArmID_A() == 3){
    		this.sendmessage("gvcr2.string.message.s_mr_cpt_.talk_4.name", player);
    		this.setArmID_A(4);
    	}else if(this.getArmID_A() == 4){
    		this.sendmessage("gvcr2.string.message.s_mr_cpt_.talk_5.name", player);
    		this.setArmID_A(5);
    	}else if(this.getArmID_A() == 5){
    		this.sendmessage("gvcr2.string.message.s_mr_cpt_.talk_6.name", player);
    		this.setArmID_A(6);
    	}else if(this.getArmID_A() == 6){
    		this.sendmessage("gvcr2.string.message.s_mr_cpt_.talk_7.name", player);
    		this.setArmID_A(7);
    	}else if(this.getArmID_A() == 7){
    		this.sendmessage("gvcr2.string.message.s_mr_cpt_.talk_8.name", player);
    		this.setArmID_A(8);
    	}
    	else if(this.getArmID_A() == 8){
    		this.sendmessage("gvcr2.string.message.s_mr_cpt_.talk_8.name", player);
    	}
    	
    	
    	 return true;
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
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_m1911));
			}
			if(this.onGround 
					&& !this.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty() 
					&& this.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == mod_GVCR2.gvcr2_armor_parachute) {
				this.setItemStackToSlot(EntityEquipmentSlot.CHEST, this.getItemStackFromSlot(EntityEquipmentSlot.CHEST).EMPTY);
			}
		}
		if(this.isRiding()
				&& !this.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty() 
				&& this.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == mod_GVCR2.gvcr2_armor_parachute) {
			this.setItemStackToSlot(EntityEquipmentSlot.CHEST, this.getItemStackFromSlot(EntityEquipmentSlot.CHEST).EMPTY);
		}
		
		boolean exflag = true;
		
		AI_EntityWeapon.getTargetEntity(this, 50, 20, 20);
		AI_setState.set(this);
		
		
		
		int max = 20;
		int range = 50;
		int attack_range = 30;
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
			    		attack_range = gun.mobrange;
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
			else if (itemstack.getItem() ==  mod_GVCR2.gvcr2_item_aed) 
	    	{
				moveid = 3;
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
		
		if(!itemstack.isEmpty()){
			if (itemstack.getItem() ==  mod_GVCR2.gvcr2_item_aed) 
	    	{
				this.medic = true;
	    	}else {
	    		this.medic = false;
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
		
		
		if(this.world.getWorldTime() %400 == 0 && this.getArmID_A() == 0){
			double k = this.posX;
			double l = this.posY;
			double i = this.posZ;
			int han = 80;
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double) (k - han), (double) (l - han),
					(double) (i - han), (double) (k + han), (double) (l + han), (double) (i + han)))
							.grow(1);
			List<Entity> llist = this.world.getEntitiesWithinAABBExcludingEntity(this, axisalignedbb);
			if (llist != null) {
				for (int lj = 0; lj < llist.size(); lj++) {
					Entity entity1 = (Entity) llist.get(lj);
					if (entity1.canBeCollidedWith()) {
						if (entity1 instanceof EntityPlayer && entity1 != null) {
							double d5 = entity1.posX - this.posX;
							double d7 = entity1.posZ - this.posZ;
							double d6 = this.posY - (entity1.posY);
							double ddx = Math.abs(d5);
							double ddz = Math.abs(d7);
							double ddy = Math.abs(d6);
							if(ddy < 8)
							{
								if ((ddx < 10 && ddz < 10) && ddy < 4) {
									this.sendmessage("gvcr2.string.message.s_mr_cpt_.help_4.name", null);
								}else if ((ddx < 25 && ddz < 25) && ddy < 8) {
									this.sendmessage("gvcr2.string.message.s_mr_cpt_.help_3.name", null);
								}else if ((ddx < 50 && ddz < 50) && ddy < 16) {
									this.sendmessage("gvcr2.string.message.s_mr_cpt_.help_2.name", null);
								}
								else if ((ddx < 100 && ddz < 100)) {
									this.sendmessage("gvcr2.string.message.s_mr_cpt_.help_1.name", null);
								}
							}
							
						}
					}
				}
			}
		}
		
		if(this.getArmID_A() == 1 && this.startuptime >= 1200){
			this.setArmID_A(8);
		}
		
		
		//　重いかも
		if(this.getArmID_A() == 8){
			boolean jam = false;
			double k = this.posX;
			double l = this.posY;
			double i = this.posZ;
			int han = 160;
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double) (k - han), (double) (l - han),
					(double) (i - han), (double) (k + han), (double) (l + han), (double) (i + han)))
							.grow(1);
			List<Entity> llist = this.world.getEntitiesWithinAABBExcludingEntity(this, axisalignedbb);
			if (llist != null) {
				for (int lj = 0; lj < llist.size(); lj++) {
					Entity entity1 = (Entity) llist.get(lj);
					if (entity1.canBeCollidedWith()) {
						if (entity1 instanceof EntityGVCR2_GE_Jamming && entity1 != null) {
							jam = true;
						}
					}
				}
			}
			if(!jam) {
				this.startuptime = 0;
				this.sendmessage("gvcr2.string.message.s_mr_cpt_.jam_1.name", null);
				this.setArmID_A(9);
			}
		}
		
		if(this.getArmID_A() == 9 && this.startuptime >= 60){
			this.sendmessage("gvcr2.string.message.s_mr_cpt_.jam_2.name", null);
			this.setArmID_A(10);
		}
		if(this.getArmID_A() == 10 && this.startuptime >= 300){
			this.sendmessage("gvcr2.string.message.s_mr_cpt_.jam_3.name", null);
			this.setArmID_A(11);
			
			//if(par3EntityPlayer != null)
			{
				double xx = this.posX - 20;
				double yy = this.posY + 30;
				double zz = this.posZ + 0;
				EntityVehicleBase var8;
				var8 = new EntityGVCR2_AIR_C130(this.world);
				var8.rotationYaw = var8.rotationYawHead = var8.renderYawOffset = -90F;
				
				var8.setLocationAndAngles(xx, yy, zz, var8.rotationYawHead, var8.rotationPitch);
				var8.setFTMode(33);
				var8.setcanDespawn(1);

				if (!this.world.isRemote) {
					this.world.spawnEntity(var8);
				}
				if (!this.world.isRemote){
					EntityGVCR2_SO_S entityskeleton = new EntityGVCR2_SO_S(this.world);
			        entityskeleton.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
			        entityskeleton.setcanDespawn(1);
			        this.world.spawnEntity(entityskeleton);
			        entityskeleton.startRiding(var8);
				}
			}
		}
		
		
		
		
	}
	
	
public void sendmessage(String message, EntityPlayer player) {
	
	
		if(this.world.isRemote)return;
		
		if(player != null) {
			player.sendMessage(new TextComponentTranslation(message, new Object[0]));
		}else {
			if(FMLCommonHandler.instance().getMinecraftServerInstance() != null) {
				for (EntityPlayerMP playermp : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers()) {
					playermp.sendMessage(new TextComponentTranslation(message, new Object[0]));
				}
			}
		}
		
		
		
    	/*boolean spawn = false;
    	Entity entity = null;
    	int mobkazu = 0;
    	int mobkazu2 = 0;
    	{
    		AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(x-han), (double)(y-han), (double)(z-han), 
    				(double)(x + han), (double)(y + han), (double)(z+ han)))
            		.grow(1);
            List llist2 = this.world.getEntitiesWithinAABBExcludingEntity(entity, axisalignedbb2);
            if(llist2!=null){
                for (int lj = 0; lj < llist2.size(); lj++) {
                	
                	Entity entity1 = (Entity)llist2.get(lj);
                	if (entity1.canBeCollidedWith())
                    {
                		if (entity1 != null && entity1 instanceof EntityPlayer) {
                			EntityPlayer player = (EntityPlayer) entity1;
                			if(this.world.isRemote) {
								player.sendMessage(new TextComponentTranslation(message, new Object[0]));
							}
                			
    					}
                    }
                }
            }
    	}*/
    }
}
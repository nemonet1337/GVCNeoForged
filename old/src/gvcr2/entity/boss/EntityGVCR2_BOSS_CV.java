package gvcr2.entity.boss;

import java.util.List;
import java.util.Random;

import gvclib.entity.living.AI_Damage;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_EntityWeapon_new;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityVehicleBase;
import gvclib.entity.living.ISoldier;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLClientMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.mob.EntityGVCR2_GE_U_DRONE;
import gvcr2.entity.mob.EntityGVCR2_UNKS_C_S;
import gvcr2.entity.so.EntityGVCR2_SO_S;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_C130;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_KA60;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_Z10;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGVCR2_BOSS_CV extends EntityGVCR2_BOSSBase_Base {
	
	public EntityGVCR2_BOSS_CV(World worldIn) {
		super(worldIn);
		this.setSize(1F, 1F);
		aitypemax = 80;
		aitypemaxset= 4;
		aitypemax2 = 50;
		aitypemaxset2 = 4;
		this.experienceValue = 300;
	}

	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIRestrictSun(this));
		this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
	}
	
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		
	}
	
	public SoundEvent  DamegeSound = SoundEvents.BLOCK_ANVIL_LAND;
	public boolean attackEntityFrom(DamageSource source, float par2)
    {
		return false;
    }
	
	public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
		if (!this.world.isRemote) {
			this.setDead();
		}
		 return true;
    }
	
	
	protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier)
    {
    }
	
    
	public void onUpdate()
    {
        super.onUpdate();
        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL && this.getcanDespawn() == 0)
        {
            this.setDead();
        }
    }
    
	protected void onDeathUpdate() {
		//super.onDeathUpdate();
		++deathTime;
		if(this.deathTime == 2){
			this.sendmessage(this.posX, this.posY, this.posZ, 80, "gvcr2.string.message.s_mr_cpt_.inv_clear_1.name", true);
		}
		if(this.deathTime == 60){
			this.sendmessage(this.posX, this.posY, this.posZ, 80, "gvcr2.string.message.s_mr_cpt_.inv_clear_2.name", true);
		}
		if(this.deathTime == 120){
			this.sendmessage(this.posX, this.posY, this.posZ, 80, "gvcr2.string.message.s_mr_cpt_.inv_clear_3.name", true);
		}
		if(this.deathTime == 200){
			this.sendmessage(this.posX, this.posY, this.posZ, 80, "gvcr2.string.message.s_mr_cpt_.inv_clear_4.name", true);
		}
		
		if(!this.world.isRemote && this.deathTime == 100) {
			{
				double xx = this.posX - 40;
				double yy = this.posY + 30;
				double zz = this.posZ + 0;
				EntityVehicleBase var8;
				var8 = new EntityGVCR2_AIR_C130(this.world);
				var8.rotationYaw = var8.rotationYawHead = var8.renderYawOffset = -90F;
				
				var8.setLocationAndAngles(xx, yy, zz, var8.rotationYawHead, var8.rotationPitch);
				var8.setFTMode(35);
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
		
		
		if(this.deathTime == 2){
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
						if (entity1 instanceof EntityGVCR2_UNKS_C_S && entity1 != null) {
							if(!this.world.isRemote) {
								entity1.setDead();
							}
						}
					}
				}
			}
		}
		if(!this.world.isRemote && this.deathTime == 200) {
			//GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 2, false,  false);
			{
				this.world.setBlockState(new BlockPos(this.getMoveX(), this.getMoveY(), this.getMoveZ()), Blocks.CHEST.getDefaultState(), 2);
				TileEntityChest Chest3;
				Chest3 = (TileEntityChest) this.world.getTileEntity(new BlockPos(this.getMoveX(), this.getMoveY(), this.getMoveZ()));
				//Chest3.setInventorySlotContents(13, new ItemStack(mod_GVCR2.gvcr2_spawn_sp_st1, 1, 0));
				
				Chest3.setInventorySlotContents(4, new ItemStack(Blocks.DIAMOND_BLOCK, 2, 0));
				Chest3.setInventorySlotContents(12, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
				Chest3.setInventorySlotContents(14, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
				Chest3.setInventorySlotContents(22, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
				
				//Chest3.setInventorySlotContents(0, new ItemStack(mod_GVCR.i_aichip, 1, 0));
			}
			this.setDead();
		}
	}
	
	
	@SideOnly(Side.CLIENT)
    public int getBrightnessForRender()
    {
        return 15728880;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness()
    {
        return 1.0F;
    }
	
	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
    int self_ex = 0;
    int timer = 0;
	public void onLivingUpdate() {
		super.onLivingUpdate();
		//if(this.timer < 100)return;
		
		++timer;
		
		float sp = 0.3F;
		Vec3d looked = this.getLookVec();
		
		boolean exflag = false;
		
		if(this.getMoveT() == 0) {
			this.setMoveT(1);
			this.setMoveX((int)this.posX);
			this.setMoveY((int)this.posY);
			this.setMoveZ((int)this.posZ);
		}
		
		if(this.getHealth() > 0.0F) {
			if(!this.world.isRemote)this.setPositionAndUpdate(this.getMoveX() - 0.5, this.getMoveY(), this.getMoveZ() + 0.5);
		}
		
		if(this.getArmID_A() != 0){
			
			
			int kazu = 0;
			double k = this.posX;
			double l = this.posY;
			double i = this.posZ;
			int han = 60;
			int bit = 0;
			EntityGVCR2_UNKS_C_S[] so = new EntityGVCR2_UNKS_C_S[256];
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double) (k - han), (double) (l - han),
					(double) (i - han), (double) (k + han), (double) (l + han), (double) (i + han)))
							.grow(1);
			List<Entity> llist = this.world.getEntitiesWithinAABBExcludingEntity(this, axisalignedbb);
			if (llist != null) {
				for (int lj = 0; lj < llist.size(); lj++) {
					Entity entity1 = (Entity) llist.get(lj);
					if (entity1.canBeCollidedWith()) {
						if (entity1 instanceof EntityGVCR2_UNKS_C_S && entity1 != null) {
							so[bit] = (EntityGVCR2_UNKS_C_S) entity1;
							++bit;
						}
					}
				}
			}
			if (so != null) {
				for (int lj = 0; lj < so.length; lj++) {
					if(so[lj] != null && so[lj].getHealth() <= 0 && so[lj].deathTime == 1) {
						this.setHealth(this.getHealth() - 30);
					}
				}
			}
		}
		
		if(this.getArmID_A() == 0){
			if(this.timer == 2) {
				this.sendmessage(this.posX, this.posY, this.posZ, 80, "gvcr2.string.message.s_mr_cpt_.inv_01.name", true);
			}
			if(this.timer == 60) {
				this.sendmessage(this.posX, this.posY, this.posZ, 80, "gvcr2.string.message.s_mr_cpt_.inv_02.name", true);
			}
			if(this.timer == 120) {
				this.sendmessage(this.posX, this.posY, this.posZ, 80, "gvcr2.string.message.s_mr_cpt_.inv_03.name", true);
			}
			if(this.timer == 180) {
				this.sendmessage(this.posX, this.posY, this.posZ, 80, "gvcr2.string.message.s_mr_cpt_.inv_04.name", true);
			}
			if(this.timer == 240) {
				this.sendmessage(this.posX, this.posY, this.posZ, 80, "gvcr2.string.message.s_mr_cpt_.inv_05.name", true);
			}
			if(this.timer == 300) {
				this.sendmessage(this.posX, this.posY, this.posZ, 80, "gvcr2.string.message.s_mr_cpt_.inv_06.name", true);
			}
		}
		
		
		if(this.getArmID_A() == 1){
			//if(this.getHealth() <=  this.getMaxHealth() * 0.75D) 
			if(this.getHealth() <=  800 || timer >= 3000) 
			{
				this.setHealth(800);
				this.timer = 0;
				this.setArmID_A(2);
				this.sendmessage(this.posX, this.posY, this.posZ, 80, "gvcr2.string.message.s_mr_cpt_.inv_2.name", true);//gvcr2.base.retrieve.name
				
				for (int c = 0; c < 5; ++c) {
					if (!this.world.isRemote) {
						EntityGVCR2_SO_S entityskeleton = new EntityGVCR2_SO_S(this.world);
						entityskeleton.setWeapon();
						entityskeleton.setLocationAndAngles(this.posX + this.world.rand.nextInt(10) - 5, this.posY,
								this.posZ + this.world.rand.nextInt(10) - 5, 0, 0.0F);
						this.world.spawnEntity(entityskeleton);
					}
				}
			}
		}
		
		if(this.getArmID_A() == 3){
			//if(this.getHealth() <=  this.getMaxHealth() * 0.75D) 
			if(this.getHealth() <=  600 || timer >= 3000) 
			{
				this.setHealth(600);
				this.timer = 0;
				this.setArmID_A(4);
				this.sendmessage(this.posX, this.posY, this.posZ, 80, "gvcr2.string.message.s_mr_cpt_.inv_4.name", true);//gvcr2.base.retrieve.name
				
				for (int c = 0; c < 5; ++c) {
					if (!this.world.isRemote) {
						EntityGVCR2_SO_S entityskeleton = new EntityGVCR2_SO_S(this.world);
						entityskeleton.setWeapon();
						entityskeleton.setLocationAndAngles(this.posX + this.world.rand.nextInt(10) - 5, this.posY,
								this.posZ + this.world.rand.nextInt(10) - 5, 0, 0.0F);
						this.world.spawnEntity(entityskeleton);
					}
				}
			}
		}
		
		if(this.getArmID_A() == 5){
			//if(this.getHealth() <=  this.getMaxHealth() * 0.75D) 
			if(this.getHealth() <=  400 || timer >= 3000) 
			{
				this.setHealth(400);
				this.timer = 0;
				this.setArmID_A(6);
				this.sendmessage(this.posX, this.posY, this.posZ, 80, "gvcr2.string.message.s_mr_cpt_.inv_6.name", true);//gvcr2.base.retrieve.name
				
				for (int c = 0; c < 5; ++c) {
					if (!this.world.isRemote) {
						EntityGVCR2_SO_S entityskeleton = new EntityGVCR2_SO_S(this.world);
						entityskeleton.setWeapon();
						entityskeleton.setLocationAndAngles(this.posX + this.world.rand.nextInt(10) - 5, this.posY,
								this.posZ + this.world.rand.nextInt(10) - 5, 0, 0.0F);
						this.world.spawnEntity(entityskeleton);
					}
				}
			}
		}
		
		
		//　強制終了
		if(this.getArmID_A() == 7){
			//if(this.getHealth() <=  this.getMaxHealth() * 0.75D) 
			if(timer >= 3600) 
			{
				this.setHealth(-100);
				this.timer = 0;
			}
		}
		
		
		//WAVE1
		if(this.timer >= 1500 && this.getArmID_A() == 0){
			this.setArmID_A(1);
			this.sendmessage(this.posX, this.posY, this.posZ, 80, "gvcr2.string.message.s_mr_cpt_.inv_1.name", true);
			this.timer = 0;
			/*for(int c = 0; c < 20;++c){
				EntityGVCR2_UNKS_C_S s = new EntityGVCR2_UNKS_C_S(this.world);
				s.setWeapon_airborne();
				s.setLocationAndAngles(this.posX + this.world.rand.nextInt(10) - 5, this.posY + 20,
						this.posZ + this.world.rand.nextInt(12) - 6, this.rotationYaw, 0F);
		            s.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
				if (!this.world.isRemote) {
					this.world.spawnEntity(s);
				}
			}*/
			
			for(int c = 0; c < 3;++c){
				int xx = 0;
				int zz = 0;
				if(c == 1) {
					xx = -10;
					zz = 10;
				}
				if(c == 2) {
					xx = -10;
					zz = -10;
				}
				EntityGVCR2_HELI_KA60 s = new EntityGVCR2_HELI_KA60(this.world);
				s.setLocationAndAngles(this.posX - 80 + xx, this.posY + 20, this.posZ + zz, this.rotationYaw, 0F);
				s.setMoveX((int)this.posX+ xx);
				s.setMoveY((int)this.posY);
				s.setMoveZ((int)this.posZ + zz);
				s.setArmID_S(10 + this.world.rand.nextInt(10));
				s.setFTMode(30);
				if (!this.world.isRemote) {
					this.world.spawnEntity(s);
				}
				if(s != null) {
					for(int mm = 0; mm < s.riddng_maximum; ++mm) {
						if (!this.world.isRemote) {
							EntityGVCR2_UNKS_C_S entityskeleton = new EntityGVCR2_UNKS_C_S(this.world);
							entityskeleton.setWeapon_airborne();
							entityskeleton.setMoveT(1);
							entityskeleton.setMoveX((int)this.posX + this.world.rand.nextInt(10) -5);
							entityskeleton.setMoveY((int)this.posY);
							entityskeleton.setMoveZ((int)this.posZ + this.world.rand.nextInt(10) -5);
							//if(mm != 0)entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
							entityskeleton.setLocationAndAngles(s.posX, s.posY, s.posZ, 0, 0.0F);
							this.world.spawnEntity(entityskeleton);
							entityskeleton.startRiding(s);
						}
					}
				}
			}
			
			
		}
		//WAVE1
		
		
		//WAVE2
		if(this.timer >= 600 && this.getArmID_A() == 2){
			this.setArmID_A(3);
			this.sendmessage(this.posX, this.posY, this.posZ, 80, "gvcr2.string.message.s_mr_cpt_.inv_3.name", true);
			this.setHealth(800);
			this.timer = 0;
			
			for(int c = 0; c < 3;++c){
				int xx = 0;
				int zz = 0;
				if(c == 1) {
					xx = -10;
					zz = 10;
				}
				if(c == 2) {
					xx = -10;
					zz = -10;
				}
				EntityGVCR2_HELI_KA60 s = new EntityGVCR2_HELI_KA60(this.world);
				s.setLocationAndAngles(this.posX - 80 + xx, this.posY + 15, this.posZ + zz, this.rotationYaw, 0F);
				s.setMoveX((int)this.posX+ xx);
				s.setMoveY((int)this.posY);
				s.setMoveZ((int)this.posZ + zz);
				if(c == 0) {
					//s.setFTMode(35);
				}else {
					s.setFTMode(30);
				}
				s.setArmID_S(10 + this.world.rand.nextInt(10));
				if (!this.world.isRemote) {
					this.world.spawnEntity(s);
				}
				if(s != null) {
					for(int mm = 0; mm < s.riddng_maximum; ++mm) {
						if (!this.world.isRemote) {
							EntityGVCR2_UNKS_C_S entityskeleton = new EntityGVCR2_UNKS_C_S(this.world);
							entityskeleton.setWeapon_airborne();
							entityskeleton.setMoveT(1);
							entityskeleton.setMoveX((int)this.posX + this.world.rand.nextInt(10) -5);
							entityskeleton.setMoveY((int)this.posY);
							entityskeleton.setMoveZ((int)this.posZ + this.world.rand.nextInt(10) -5);
							//if(mm != 0)entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_chest_rig));
							entityskeleton.setLocationAndAngles(s.posX, s.posY, s.posZ, 0, 0.0F);
							this.world.spawnEntity(entityskeleton);
							entityskeleton.startRiding(s);
						}
					}
				}
			}
			
			
			EntityGVCR2_HELI_Z10 s = new EntityGVCR2_HELI_Z10(this.world);
			s.setLocationAndAngles(this.posX - 80, this.posY + 20, this.posZ + 30, this.rotationYaw, 0F);
			s.setMoveX((int)this.posX);
			s.setMoveY((int)this.posY);
			s.setMoveZ((int)this.posZ);
			s.setFTMode(30);
			s.setcanDespawn(1);
			if (!this.world.isRemote) {
				this.world.spawnEntity(s);
			}
			if(s != null) {
				{
					if (!this.world.isRemote) {
						EntityGVCR2_UNKS_C_S entityskeleton = new EntityGVCR2_UNKS_C_S(this.world);
						entityskeleton.setLocationAndAngles(s.posX, s.posY, s.posZ, 0, 0.0F);
						entityskeleton.setMoveT(1);
						entityskeleton.setMoveX((int)this.posX);
						entityskeleton.setMoveY((int)this.posY);
						entityskeleton.setMoveZ((int)this.posZ);
						entityskeleton.setcanDespawn(1);
						this.world.spawnEntity(entityskeleton);
						entityskeleton.startRiding(s);
					}
				}
			}
			
		}
		//WAVE2
		
		
		
		//WAVE3
		if(this.timer >= 600 && this.getArmID_A() == 4){
			this.setArmID_A(5);
			this.sendmessage(this.posX, this.posY, this.posZ, 80, "gvcr2.string.message.s_mr_cpt_.inv_5.name", true);
			this.setHealth(600);
			this.timer = 0;
			
			for(int c = 0; c < 3;++c){
				int xx = 0;
				int zz = 0;
				if(c == 1) {
					xx = -10;
					zz = 10;
				}
				if(c == 2) {
					xx = -10;
					zz = -10;
				}
				EntityGVCR2_HELI_KA60 s = new EntityGVCR2_HELI_KA60(this.world);
				s.setLocationAndAngles(this.posX + 80 + xx, this.posY + 15, this.posZ + zz, this.rotationYaw, 0F);
				s.setMoveX((int)this.posX+ xx);
				s.setMoveY((int)this.posY);
				s.setMoveZ((int)this.posZ + zz);
				if(c == 0) {
					//s.setFTMode(35);
				}else {
					s.setFTMode(30);
				}
				s.setArmID_S(10 + this.world.rand.nextInt(10));
				if (!this.world.isRemote) {
					this.world.spawnEntity(s);
				}
				if(s != null) {
					for(int mm = 0; mm < s.riddng_maximum; ++mm) {
						if (!this.world.isRemote) {
							EntityGVCR2_UNKS_C_S entityskeleton = new EntityGVCR2_UNKS_C_S(this.world);
							entityskeleton.setWeapon_airborne();
							entityskeleton.setMoveT(1);
							entityskeleton.setMoveX((int)this.posX + this.world.rand.nextInt(10) -5);
							entityskeleton.setMoveY((int)this.posY);
							entityskeleton.setMoveZ((int)this.posZ + this.world.rand.nextInt(10) -5);
							//if(mm != 0)entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_chest_rig));
							entityskeleton.setLocationAndAngles(s.posX, s.posY, s.posZ, 0, 0.0F);
							this.world.spawnEntity(entityskeleton);
							entityskeleton.startRiding(s);
						}
					}
				}
			}
			
			
			EntityGVCR2_HELI_Z10 s = new EntityGVCR2_HELI_Z10(this.world);
			s.setLocationAndAngles(this.posX + 80, this.posY + 20, this.posZ + 30, this.rotationYaw, 0F);
			s.setMoveX((int)this.posX);
			s.setMoveY((int)this.posY);
			s.setMoveZ((int)this.posZ);
			s.setFTMode(30);
			s.setcanDespawn(1);
			if (!this.world.isRemote) {
				this.world.spawnEntity(s);
			}
			if(s != null) {
				{
					if (!this.world.isRemote) {
						EntityGVCR2_UNKS_C_S entityskeleton = new EntityGVCR2_UNKS_C_S(this.world);
						entityskeleton.setLocationAndAngles(s.posX, s.posY, s.posZ, 0, 0.0F);
						entityskeleton.setMoveT(1);
						entityskeleton.setMoveX((int)this.posX);
						entityskeleton.setMoveY((int)this.posY);
						entityskeleton.setMoveZ((int)this.posZ);
						entityskeleton.setcanDespawn(1);
						this.world.spawnEntity(entityskeleton);
						entityskeleton.startRiding(s);
					}
				}
			}
			
		}
		//WAVE3
		
		
		//WAVE4
		if(this.timer >= 600 && this.getArmID_A() == 6){
			this.setArmID_A(7);
			this.sendmessage(this.posX, this.posY, this.posZ, 80, "gvcr2.string.message.s_mr_cpt_.inv_7.name", true);
			this.setHealth(400);
			this.timer = 0;
			
			for(int c = 0; c < 3;++c){
				int xx = 0;
				int zz = 0;
				if(c == 1) {
					xx = -10;
					zz = 10;
				}
				if(c == 2) {
					xx = -10;
					zz = -10;
				}
				EntityGVCR2_HELI_KA60 s = new EntityGVCR2_HELI_KA60(this.world);
				s.setLocationAndAngles(this.posX - 80 + xx, this.posY + 15, this.posZ + zz, this.rotationYaw, 0F);
				s.setMoveX((int)this.posX+ xx);
				s.setMoveY((int)this.posY);
				s.setMoveZ((int)this.posZ + zz);
				if(c == 0) {
					//s.setFTMode(35);
				}else {
					s.setFTMode(30);
				}
				s.setArmID_S(10 + this.world.rand.nextInt(10));
				if (!this.world.isRemote) {
					this.world.spawnEntity(s);
				}
				if(s != null) {
					for(int mm = 0; mm < s.riddng_maximum; ++mm) {
						if (!this.world.isRemote) {
							EntityGVCR2_UNKS_C_S entityskeleton = new EntityGVCR2_UNKS_C_S(this.world);
							entityskeleton.setWeapon_airborne();
							entityskeleton.setMoveT(1);
							entityskeleton.setMoveX((int)this.posX + this.world.rand.nextInt(10) -5);
							entityskeleton.setMoveY((int)this.posY);
							entityskeleton.setMoveZ((int)this.posZ + this.world.rand.nextInt(10) -5);
							//if(mm != 0)entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_chest_rig));
							entityskeleton.setLocationAndAngles(s.posX, s.posY, s.posZ, 0, 0.0F);
							this.world.spawnEntity(entityskeleton);
							entityskeleton.startRiding(s);
						}
					}
				}
			}
			
			for(int c = 0; c < 3;++c){
				int xx = 0;
				int zz = 0;
				if(c == 1) {
					xx = -10;
					zz = 10;
				}
				if(c == 2) {
					xx = -10;
					zz = -10;
				}
				EntityGVCR2_HELI_KA60 s = new EntityGVCR2_HELI_KA60(this.world);
				s.setLocationAndAngles(this.posX + 80 + xx, this.posY + 15, this.posZ + zz, this.rotationYaw, 0F);
				s.setMoveX((int)this.posX+ xx);
				s.setMoveY((int)this.posY);
				s.setMoveZ((int)this.posZ + zz);
				if(c == 0) {
					//s.setFTMode(35);
				}else {
					s.setFTMode(30);
				}
				s.setArmID_S(10 + this.world.rand.nextInt(10));
				if (!this.world.isRemote) {
					this.world.spawnEntity(s);
				}
				if(s != null) {
					for(int mm = 0; mm < s.riddng_maximum; ++mm) {
						if (!this.world.isRemote) {
							EntityGVCR2_UNKS_C_S entityskeleton = new EntityGVCR2_UNKS_C_S(this.world);
							entityskeleton.setWeapon_airborne();
							entityskeleton.setMoveT(1);
							entityskeleton.setMoveX((int)this.posX + this.world.rand.nextInt(10) -5);
							entityskeleton.setMoveY((int)this.posY);
							entityskeleton.setMoveZ((int)this.posZ + this.world.rand.nextInt(10) -5);
							//if(mm != 0)entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_chest_rig));
							entityskeleton.setLocationAndAngles(s.posX, s.posY, s.posZ, 0, 0.0F);
							this.world.spawnEntity(entityskeleton);
							entityskeleton.startRiding(s);
						}
					}
				}
			}
			
			{
				EntityGVCR2_HELI_Z10 s = new EntityGVCR2_HELI_Z10(this.world);
				s.setLocationAndAngles(this.posX - 80, this.posY + 20, this.posZ + 30, this.rotationYaw, 0F);
				s.setMoveX((int)this.posX);
				s.setMoveY((int)this.posY);
				s.setMoveZ((int)this.posZ);
				s.setFTMode(30);
				s.setcanDespawn(1);
				if (!this.world.isRemote) {
					this.world.spawnEntity(s);
				}
				if(s != null) {
					{
						if (!this.world.isRemote) {
							EntityGVCR2_UNKS_C_S entityskeleton = new EntityGVCR2_UNKS_C_S(this.world);
							entityskeleton.setLocationAndAngles(s.posX, s.posY, s.posZ, 0, 0.0F);
							entityskeleton.setMoveT(1);
							entityskeleton.setMoveX((int)this.posX);
							entityskeleton.setMoveY((int)this.posY);
							entityskeleton.setMoveZ((int)this.posZ);
							entityskeleton.setcanDespawn(1);
							this.world.spawnEntity(entityskeleton);
							entityskeleton.startRiding(s);
						}
					}
				}
			}
			
			{
				EntityGVCR2_HELI_Z10 s = new EntityGVCR2_HELI_Z10(this.world);
				s.setLocationAndAngles(this.posX + 80, this.posY + 20, this.posZ + 30, this.rotationYaw, 0F);
				s.setMoveX((int)this.posX);
				s.setMoveY((int)this.posY);
				s.setMoveZ((int)this.posZ);
				s.setFTMode(30);
				s.setcanDespawn(1);
				if (!this.world.isRemote) {
					this.world.spawnEntity(s);
				}
				if(s != null) {
					{
						if (!this.world.isRemote) {
							EntityGVCR2_UNKS_C_S entityskeleton = new EntityGVCR2_UNKS_C_S(this.world);
							entityskeleton.setLocationAndAngles(s.posX, s.posY, s.posZ, 0, 0.0F);
							entityskeleton.setMoveT(1);
							entityskeleton.setMoveX((int)this.posX);
							entityskeleton.setMoveY((int)this.posY);
							entityskeleton.setMoveZ((int)this.posZ);
							entityskeleton.setcanDespawn(1);
							this.world.spawnEntity(entityskeleton);
							entityskeleton.startRiding(s);
						}
					}
				}
			}
			
			
		}
		//WAVE4
		
		
		
		
		
		
	}
	
	public void sendmessage(double x, double y, double z, int han, String message, boolean mission) {
		
		if(this.world.isRemote)return;
		
		if(FMLCommonHandler.instance().getMinecraftServerInstance() != null) {
			for (EntityPlayerMP playermp : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers()) {
				playermp.sendMessage(new TextComponentTranslation(message, new Object[0]));
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
package gvcr2.entity.boss;

import java.util.List;
import java.util.Random;

import gvclib.entity.EntityBBase;
import gvclib.entity.EntityB_Bullet;
import gvclib.entity.EntityT_Grenade;
import gvclib.entity.living.AI_Damage;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_EntityWeapon_new;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.ISoldier;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLClientMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.mob.EntityGVCR2_GE_U_DRONE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockLilyPad;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
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
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGVCR2_BOSS_RATTE extends EntityGVCR2_BOSSBase {
	
	public EntityGVCR2_BOSS_RATTE(World worldIn) {
		super(worldIn);
		this.setSize(14F, 12F);
		aitype_auto = false;
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
    	Entity entity;
    	entity = source.getImmediateSource();
    	
		if(entity != null){
			if(this.getControllingPassenger() != null && this.getControllingPassenger() == source.getImmediateSource()){
	    		return false;
	        }else
	        {
				par2 = par2 * AI_Damage.newAntiBullet(this, entity, par2, 0F, 0.05F, 0.5F, 0.75F);
				if(par2 <= 0.0) {
					this.playSound(DamegeSound, 2F, 1F);
				}
				return super.attackEntityFrom(source, par2);
			}
		}else{
			return super.attackEntityFrom(source, par2);
		}
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
		if(this.deathTime <= 140) {
			if (this.deathTime % 10 == 0 && !this.world.isRemote) {
				int x = new Random().nextInt(4) - 2;
				int y = new Random().nextInt(10) + 1;
				int z = new Random().nextInt(4) - 2;
				GVCExplosionBase.ExplosionKai(this, this, this.posX + x, this.posY + y, this.posZ + z, 2, false,  false);
			}
		}else if(this.deathTime <= 170){
			if (this.deathTime % 5 == 0 && !this.world.isRemote) {
				int x = new Random().nextInt(4) - 2;
				int y = new Random().nextInt(10) + 1;
				int z = new Random().nextInt(4) - 2;
				GVCExplosionBase.ExplosionKai(this, this, this.posX + x, this.posY + y, this.posZ + z, 2, false,  false);
			}
		}
		if(!this.world.isRemote && this.deathTime == 200) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 4, false,  false);
			/*{
				this.world.setBlockState(new BlockPos(this.getMoveX(), this.getMoveY(), this.getMoveZ()), Blocks.CHEST.getDefaultState(), 2);
				TileEntityChest Chest3;
				Chest3 = (TileEntityChest) this.world.getTileEntity(new BlockPos(this.getMoveX(), this.getMoveY(), this.getMoveZ()));
				Chest3.setInventorySlotContents(13, new ItemStack(mod_GVCR2.gvcr2_spawn_sp_st1, 1, 0));
				
				Chest3.setInventorySlotContents(4, new ItemStack(Blocks.DIAMOND_BLOCK, 2, 0));
				Chest3.setInventorySlotContents(12, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
				Chest3.setInventorySlotContents(14, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
				Chest3.setInventorySlotContents(22, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
				
				//Chest3.setInventorySlotContents(0, new ItemStack(mod_GVCR.i_aichip, 1, 0));
			}*/
			this.setDead();
		}
	}
	
	private int pos_reset = 0;
	public void getbeacon() {
		
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
	
    
    /*public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        if(player.isSneaking()) {
    		this.rotationYaw = this.rotationYaw + 10;
    		this.rotationYawHead = this.rotationYawHead + 10;
    		this.prevRotationYaw = this.prevRotationYaw + 10;
    		this.renderYawOffset = this.renderYawOffset + 10;
    	}else {
    		this.rotationYaw = this.rotationYaw - 10;
    		this.rotationYawHead = this.rotationYawHead - 10;
    		this.prevRotationYaw = this.prevRotationYaw - 10;
    		this.renderYawOffset = this.renderYawOffset - 10;
    	}
        this.rotation= this.rotationYaw;
    	return true;
    }/**/
    
	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
    int self_ex = 0;
	public void onLivingUpdate() {
		super.onLivingUpdate();
		//if(this.startuptime < 100)return;
		
		float sp = 0.01F;
		Vec3d looked = this.getLookVec();
		
		boolean exflag = false;
		
		if(this.getMoveT() == 0) {
			this.setMoveT(1);
			this.setMoveX((int)this.posX);
			this.setMoveY((int)this.posY);
			this.setMoveZ((int)this.posZ);
		}
		
		if(this.getHealth() > 0.0F) {
			AI_EntityWeapon.getTargetEntity(this, 80, 20, 20);
			this.newmove(this, 1, sp, 0, 2, 80);
			Gunner();
			Cannon();
		}
		
		hitboxgvc();
		
		
		if(!this.world.isRemote){
    		AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
    		double xx = width;
        		for(double x = 0; x < width*2; ++x) {
        			for(double y = 1; y < height*1.2; ++y) {
        				for(double z = 0; z < width*2; ++z) {
        					BlockPos pos = new BlockPos(this.posX -xx + x, this.posY + y, this.posZ - xx + z);
        					if(!(this.world.getBlockState(pos).getBlock() instanceof BlockStone)
        							&& !(this.world.getBlockState(pos).getBlock() instanceof BlockGrass)
        							&& !(this.world.getBlockState(pos).getBlock() instanceof BlockDirt)
        							&& !(this.world.getBlockState(pos).getBlock() instanceof BlockSand)
        							&& !(this.world.getBlockState(pos).getBlock() instanceof BlockAir)
        							&& !(this.world.getBlockState(pos).getBlock() instanceof BlockContainer)
        							) 
        					{
        						IBlockState iblockstate = this.world.getBlockState(pos);
        		                Block block = iblockstate.getBlock();
        		                if (iblockstate.getMaterial() != Material.AIR)
        		                {
        		                    block.dropBlockAsItemWithChance(this.world, pos, this.world.getBlockState(pos), 1.0F, 0);
        		                    world.setBlockToAir(pos);
        		                }
        					}
        				}
        			}
        		}
    	}
	}
	
	public void hitboxgvc() {
		Vec3d lock = Vec3d.fromPitchYaw(this.rotationPitch, this.rotationYaw);//entity.getForward();
		double xfront = this.posX + lock.x * 7;
		double yfront = this.posY + 6;
		double zfront = this.posZ + lock.z * 7;
		
		double xmiddle = this.posX;
		double ymiddle = this.posY + 10;
		double zmiddle = this.posZ;
		
		double xrear = this.posX + lock.x * -7;
		double yrear = this.posY + 6;
		double zrear = this.posZ + lock.z * -7;
		double han = 7;
		double hany = 6;
		{
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - han), (double) (yfront - hany),(double) (zfront - han),
					(double) (xfront + han), (double) (yfront + hany), (double) (zfront + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	ImpactEntity(llist2);
	        }
		}
		{
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xrear - han), (double) (yrear - hany),(double) (zrear - han),
					(double) (xrear + han), (double) (yrear + hany), (double) (zrear + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	ImpactEntity(llist2);
	        }
		}
	}
	
	public void ImpactEntity(List llist2) {
		 for (int lj = 0; lj < llist2.size(); lj++) {
         	Entity entity1 = (Entity)llist2.get(lj);
             {
         		if ((entity1 instanceof IProjectile) && entity1 != null && entity1 != this)
                 {
         			if(entity1 instanceof EntityBBase) {
         				EntityBBase bullet = (EntityBBase) entity1;
         				if(bullet.getThrower() != this) {
         					Vec3d vec3d1 = new Vec3d(entity1.posX, entity1.posY, entity1.posZ);
             	            Vec3d vec3d = new Vec3d(entity1.posX + entity1.motionX, entity1.posY + entity1.motionY, entity1.posZ + entity1.motionZ);
             	            RayTraceResult raytraceresult = this.world.rayTraceBlocks(vec3d1, vec3d, false, true, false);
             	            if (this != null)
             	            {
             	                raytraceresult = new RayTraceResult(this);
             	            }
             	            if (raytraceresult != null)
             	            {
             	            	bullet.ImpactGVC(raytraceresult);
             	            }
         				}
         			}else {
         				
         			}
                 }
             }
         }
	}
	
	public void Gunner() {
		Vec3d lock = Vec3d.fromPitchYaw(this.rotationPitch, this.rotationYaw);//entity.getForward();
		float yaw = this.rotationYaw * (2 * (float) Math.PI / 360);
		double xyaw = 0;
		double zyaw = 0;
		double xfront = this.posX + 0;
		double yfront = this.posY + 0;
		double zfront = this.posZ + 0;
		double han = 50;
		{//左右機銃
			xfront = this.posX + 0;
			yfront = this.posY + 8;
			zfront = this.posZ + 0;
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - han), (double) (yfront - 0),(double) (zfront - han),
					(double) (xfront + han), (double) (yfront + 80), (double) (zfront + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	GunnerTarget(llist2, -1.57F, -5F, 7.8F, -12F, 1);
	        	GunnerTarget(llist2, -1.57F, 5F, 7.8F, -12F, 2);
	        }
		}
		/*{//左機銃
			xfront = this.posX + 0;
			yfront = this.posY + 8;
			zfront = this.posZ + 0;
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - han), (double) (yfront - 0),(double) (zfront - han),
					(double) (xfront + han), (double) (yfront + 80), (double) (zfront + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	GunnerTarget(llist2, -1.57F, 5F, 7.8F, -12F, 2);
	        }
		}*/
		{//Flak88
			xfront = this.posX + 0;
			yfront = this.posY + 8;
			zfront = this.posZ + 0;
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - han), (double) (yfront - 0),(double) (zfront - han),
					(double) (xfront + han), (double) (yfront + 80), (double) (zfront + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	GunnerTarget(llist2, 0F, 0, 8.5F, -8, 4);
	        }
		}
		
		{//左右前機銃
			xyaw -= MathHelper.sin(yaw) * 50;
			zyaw += MathHelper.cos(yaw) * 50;
			xfront = this.posX + xyaw;
			yfront = this.posY + 0;
			zfront = this.posZ + zyaw;
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - 50), (double) (yfront - 10),(double) (zfront - 50),
					(double) (xfront + 50), (double) (yfront + 20), (double) (zfront + 50)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	GunnerTarget(llist2, -1.57F, 5F, 3.8F, 15F, 5);
	        	GunnerTarget(llist2, -1.57F, -5F, 3.8F, 15F, 6);
	        }
		}
		/*{//右前機銃
			xyaw -= MathHelper.sin(yaw) * 50;
			zyaw += MathHelper.cos(yaw) * 50;
			xfront = this.posX + xyaw;
			yfront = this.posY + 0;
			zfront = this.posZ + zyaw;
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - 50), (double) (yfront - 10),(double) (zfront - 50),
					(double) (xfront + 50), (double) (yfront + 20), (double) (zfront + 50)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	GunnerTarget(llist2, -1.57F, -5F, 3.8F, 15F, 6);
	        }
		}*/
		if(this.magazine2 == 0) {
			++this.reload2;
			if(this.reload2 > 60) {
				this.magazine2 = 20;
				this.reload2 = 0;
			}
		}
		if(this.magazine3 == 0) {
			++this.reload3;
			if(this.reload3 > 60) {
				this.magazine3 = 10;
				this.reload3 = 0;
			}
		}
	}
	
	public void GunnerTarget(List llist2, float ff, float ww, float hh, float zz, int id) {
		int cooltimer;
		int mag = magazine2;
		if(id == 1) {
			cooltimer = this.cooltime;
			mag = magazine2;
		}else if(id == 2) {
			cooltimer = this.cooltime2;
			mag = magazine2;
		}else if(id == 5) {
			cooltimer = this.cooltime5;
			mag = magazine3;
		}else if(id == 6) {
			cooltimer = this.cooltime6;
			mag = magazine3;
		}else {
			cooltimer = this.cooltime4;
		}
		 for (int lj = 0; lj < llist2.size(); lj++) {
        	Entity entity1 = (Entity)llist2.get(lj);
            {
            	if (entity1.canBeCollidedWith() && entity1 != null && entity1 != null && entity1 instanceof EntityLivingBase) {
					if (((EntityLivingBase) entity1).getHealth() > 0.0F && this.getHealth() > 0.0F && this.CanAttack(entity1)) 
					{
						EntityLivingBase targeted = (EntityLivingBase) entity1;
						double d5 = entity1.posX - this.posX;
						double d7 = entity1.posZ - this.posZ;
						double d6 = entity1.posY - this.posY;
						double d1 = this.posY - (entity1.posY);
						double d3 = (double) MathHelper.sqrt(d5 * d5 + d7 * d7);
						float f11 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
						
						 if(id == 4) {
							 this.rotation_4 = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
								this.rotationp_4 = -f11 + 0;
							 if(cooltimer > 60)
				    			{
				        			AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
									we.id = 2;
									we.model = "gvclib:textures/entity/model/bullet.mqo";
									we.tex = "gvclib:textures/entity/model/bullet.png";
									we.modelf = "gvclib:textures/entity/msmoke.mqo";
									we.texf = "gvclib:textures/entity/msmoke.png";
									we.ftime = 16;
									we.sound = GVCSoundEvent.fire_cannon;
									we.f = ff;
									we.w = ww;
									we.h = hh;
									we.z = zz;
									we.bx = ww;
									we.by = hh;
									we.bz = zz;
									we.follow_rote = true;
									we.xoffset = 0;
									we.yoffset = 0;
									we.px = this.posX;
									we.py = this.posY;
									we.pz = this.posZ;
									we.lock = this.getLookVec();
									we.rote = this.rotationYawHead;
									we.maxy = 0;
									we.miny = 0;
									
									we.power = 30;
									we.speed = 4F;
									we.bure = 1F;
									we.ex = 3;
									we.extrue = true;
									we.kazu = 1;
									we.gra = 0.029;
									we.maxtime = 80;
									we.dameid = 0;
									we.target = targeted;
									we.WeaponAttack();
									{
										{
											this.cooltime4 = 0;
										}
									}
									return;
				    			}
						 }else {
							 if(cooltimer > 3 && mag > 0)
				    		{
								 if(id == 5 || id == 6) {
									 AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
										we.id = 0;
										we.model = "gvclib:textures/entity/model/bullet.mqo";
										we.tex = "gvclib:textures/entity/model/bullet.png";
										we.modelf = "gvclib:textures/entity/mflash.mqo";
										we.texf = "gvclib:textures/entity/mflash.png";
										we.ftime = 2;
										we.sound = GVCSoundEvent.fire_rifle3;
										we.f = ff;
										we.w = ww;
										we.h = hh;
										we.z = zz;
										we.bx = ww;
										we.by = hh;
										we.bz = zz;
										we.follow_rote = true;
										we.xoffset = 0;
										we.yoffset = 0;
										we.px = this.posX;
										we.py = this.posY;
										we.pz = this.posZ;
										we.lock = this.getLookVec();
										we.rote = this.rotationYawHead;
										we.maxy = 0;
										we.miny = 0;
										
										we.power = 4;
										we.speed = 3F;
										we.bure = 4F;
										we.ex = 0;
										we.extrue = false;
										we.kazu = 1;
										we.gra = 0.029;
										we.maxtime = 80;
										we.dameid = 0;
										we.target = targeted;
										we.WeaponAttack();
										{
											if(id == 5) {
												this.cooltime5 = 0;
												this.rotation_5 = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
												this.rotationp_5 = -f11 + 0;
											}else if(id == 6) {
												this.cooltime6 = 0;
												this.rotation_6 = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
												this.rotationp_6 = -f11 + 0;
											}
										}
										--this.magazine3;
										return;
								 }else {
									 AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
										we.id = 7;
										we.model = "gvclib:textures/entity/model/bullet.mqo";
										we.tex = "gvclib:textures/entity/model/bullet.png";
										we.modelf = "gvclib:textures/entity/mflash.mqo";
										we.texf = "gvclib:textures/entity/mflash.png";
										we.ftime = 2;
										we.sound = GVCSoundEvent.fire_mg;
										we.f = ff;
										we.w = ww;
										we.h = hh;
										we.z = zz;
										we.bx = ww;
										we.by = hh;
										we.bz = zz;
										we.follow_rote = true;
										we.xoffset = 0;
										we.yoffset = 0;
										{
											we.px = this.posX;
											we.py = this.posY;
											we.pz = this.posZ;
										}
										we.lock = this.getLookVec();
										we.rote = this.rotationYawHead;
										we.maxy = 0;
										we.miny = 0;
										
										we.power = 4;
										we.speed = 4F;
										we.bure = 4F;
										we.ex = 0;
										we.extrue = false;
										we.kazu = 1;
										we.gra = 0.029;
										we.maxtime = 80;
										we.dameid = 0;
										we.target = targeted;
										we.WeaponAttack();
										{
											if(id == 1) {
												this.cooltime = 0;
												this.rotation_1 = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
												this.rotationp_1 = -f11 + 0;
											}else if(id == 2) {
												this.cooltime2 = 0;
												this.rotation_2 = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
												this.rotationp_2 = -f11 + 0;
											}
										}
										--this.magazine2;
										return;
								 }
				    		}
						 }
					}
            	}
            }
        }
	}
	
	public int AITIME = 0;
	public void Cannon() {
		++AITIME;
		if(this.getAIType() == 1) {
			if(AITIME == 60) {
				this.playSound(GVCSoundEvent.reload_cannon, 10.0F, 1.0F);
			}
			if(AITIME > 100) {
				{
        			AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
					we.id = 2;
					we.model = "gvclib:textures/entity/model/bullet.mqo";
					we.tex = "gvclib:textures/entity/model/bullet.png";
					we.modelf = "gvclib:textures/entity/msmoke_big.mqo";
					we.texf = "gvclib:textures/entity/msmoke_big.png";
					we.ftime = 16;
					we.sound = GVCSoundEvent.fire_havrycannon;
					we.f = -1.57F;
					we.w = 2.5F;
					we.h = 10F;
					we.z = 20F;
					we.bx = 0.0F;
					we.by = 10F;
					we.bz = 8F;
					we.follow_rote = true;
					we.xoffset = 0;
					we.yoffset = 0;
					we.px = this.posX;
					we.py = this.posY;
					we.pz = this.posZ;
					we.lock = this.getLookVec();
					we.rote = this.rotationYawHead;
					we.maxy = 0;
					we.miny = 0;
					
					we.power = 30;
					we.speed = 4F;
					we.bure = 1F;
					we.ex = 6;
					we.extrue = false;
					we.kazu = 1;
					we.gra = 0.00;
					we.maxtime = 80;
					we.dameid = 0;
					we.target = null;
					if(magazine == 0) {
						we.WeaponAttack();
						++magazine;
					}
					if(magazine == 1 && AITIME > 120) {
						we.w = -2.5F;
						we.WeaponAttack();
						++magazine;
					}
    			}
				if(magazine >= 2) {
					AITIME = 0;
					magazine = 0;
					this.setAIType(0);
				}
			}
		}else {
			if(AITIME > 500) {
				AITIME = 0;
				magazine = 0;
				this.setAIType(1);
			}
		}
	}
	
	public void newmove(EntityGVCLivingBase entity, int id, float sp, float turnspeed, double max, double range1) {
		entity.sneak = false;
		boolean ta = false;
		double range = range1;
		
		{
			double d5 = entity.getMoveX() - entity.posX;
			double d7 = entity.getMoveZ() - entity.posZ;
			double d6 = entity.getMoveY() - entity.posY;
			double d1 = entity.posY - (entity.getMoveY());
			double d3 = (double) MathHelper.sqrt(d5 * d5 + d7 * d7);
			float f11 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
			{
				entity.rotationYaw = entity.renderYawOffset = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
				
				entity.rotationYawHead = entity.rotation = entity.rote
						= -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
				entity.rotationp = entity.rotationPitch = -f11 + 15;
				
				double ddx = Math.abs(d5);
				double ddz = Math.abs(d7);
				if ((ddx > 30 || ddz > 30)) 
				{
					MoveS(entity, sp, 1, entity.getMoveX(), entity.getMoveY(), entity.getMoveZ(), id);
				}
			}
		}
		
		
	}
	
	public void MoveS(EntityGVCLivingBase entity, double speed, double han, double ex, double ey, double ez, int id){
		{// 1
			if(!entity.world.isRemote)
			{
				double d5 = ex - entity.posX;
				double d7 = ez - entity.posZ;
				
				double root = Math.sqrt(d5 * d5 + d7 * d7);
				
				float off = 0;
				//entity.rotationYaw = entity.renderYawOffset = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
				float yaw = entity.rotationYaw * (2 * (float) Math.PI / 360);
				double mox = 0;
				double moy = entity.motionY;
				double moz = 0;
				//if(entity.aitypetime %15 ==  0 && entity.getAIType2() != 0)
				{
					 if(entity.getAIType() == 0) 
					{
						mox -= MathHelper.sin(yaw) * speed * 1;
						moz += MathHelper.cos(yaw) * speed * 1;
					}
					
				}
				entity.stepHeight = entity.height * 0.8F;
				{
					{
						entity.motionX = mox;
						entity.motionZ = moz;
						entity.motionY = moy;
						entity.move(MoverType.SELF, entity.motionX, entity.motionY, entity.motionZ);
					}
				}

			}
		} // 1
	}
}
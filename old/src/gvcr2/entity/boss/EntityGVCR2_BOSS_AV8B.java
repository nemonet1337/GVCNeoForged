package gvcr2.entity.boss;

import java.util.List;
import java.util.Random;

import gvclib.entity.living.AI_Damage;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_EntityWeapon_new;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.PL_RoteModel;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLClientMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGVCR2_BOSS_AV8B extends EntityGVCR2_BOSSBase {
	public EntityGVCR2_BOSS_AV8B(World worldIn) {
		super(worldIn);
		this.setSize(5F, 4F);
		aitype_auto = false;
		
		aitype2_auto = false;
		
		this.experienceValue = 300;
	}

	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIRestrictSun(this));
		this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(600D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
	}
	
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		
	}
	
	public SoundEvent  DamegeSound = SoundEvents.BLOCK_ANVIL_LAND;
	public boolean attackEntityFrom(DamageSource source, float par2)
    {
    	{
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
				GVCExplosionBase.ExplosionKai(this, this, this.posX + x, this.posY + y, this.posZ + z, 0, false,  false);
			}
		}else if(this.deathTime <= 170){
			if (this.deathTime % 5 == 0 && !this.world.isRemote) {
				int x = new Random().nextInt(4) - 2;
				int y = new Random().nextInt(10) + 1;
				int z = new Random().nextInt(4) - 2;
				GVCExplosionBase.ExplosionKai(this, this, this.posX + x, this.posY + y, this.posZ + z, 0, false,  false);
			}
		}
		if(!this.world.isRemote && this.deathTime == 200) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 2, false,  false);
			{
				this.world.setBlockState(new BlockPos(this.getMoveX(), this.getMoveY(), this.getMoveZ()), Blocks.CHEST.getDefaultState(), 2);
				TileEntityChest Chest3;
				Chest3 = (TileEntityChest) this.world.getTileEntity(new BlockPos(this.getMoveX(), this.getMoveY(), this.getMoveZ()));
				Chest3.setInventorySlotContents(13, new ItemStack(mod_GVCR2.gvcr2_spawn_air_av8b, 16, 0));
				
				Chest3.setInventorySlotContents(4, new ItemStack(Blocks.DIAMOND_BLOCK, 2, 0));
				Chest3.setInventorySlotContents(12, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
				Chest3.setInventorySlotContents(14, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
				Chest3.setInventorySlotContents(22, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
				
				//Chest3.setInventorySlotContents(0, new ItemStack(mod_GVCR.i_aichip, 1, 0));
			}
			this.setDead();
		}
	}
	
	private int pos_reset = 0;
	private Object object;
	public void getbeacon() {
		++pos_reset;
    	int i = 64;
    	if(this.pos_reset > 100 && this.getMoveT() == 6) {
    		double x = Math.abs(this.posX - this.getMoveX());
    		double y = Math.abs(this.posY - this.getMoveY());
    		double z = Math.abs(this.posZ - this.getMoveZ());
    		if(x > 120 && z > 120) {
    			this.setPositionAndUpdate(this.getMoveX(), this.getMoveY(), this.getMoveZ());
    		}
    		if(this.targetentity == null) {
    			this.setPositionAndUpdate(this.getMoveX(), this.getMoveY(), this.getMoveZ());
    		}
    		this.pos_reset = 0;
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
	public void onLivingUpdate() {
		super.onLivingUpdate();
		//if(this.startuptime < 100)return;
		
		float sp = 0.3F;
		Vec3d looked = this.getLookVec();
		
		boolean exflag = false;
		
		if(this.getMoveT() == 0) {
			this.setMoveT(6);
			this.setMoveX((int)this.posX);
			this.setMoveY((int)this.posY);
			this.setMoveZ((int)this.posZ);
		}
		
		if(this.getHealth() > 0.0F) {
			//AI_EntityWeapon.getTargetEntity(this, 100, 20, 20);
			this.newmove(this, 1, sp, 0, 2, 80);
			if(!this.world.isRemote)this.getbeacon();
		}else {
			
		}
		
		{
			//if(this.deathTime < 0) 
			{
				this.motionY *= 0.5F;
			}
			BlockPos bp = this.world.getHeight(new BlockPos(this.posX, this.posY, this.posZ));
			int genY = bp.getY() + 20;
			if (this.getHealth() > 0.0F) {
				if(this.posY <= genY || this.posY <= this.getMoveY() + 20) {
					this.motionY = 0.2F;
				}
			}
		}
		
		
		this.AISetting();
		
		if(AI_EntityWeapon.getRange(this, 80, 30, 30)){
			{
				String model = "gvclib:textures/entity/BulletNormal.obj";
	    		String tex = "gvclib:textures/entity/BulletNormal.png";
	    		String modelf = "gvclib:textures/entity/mflash.mqo";
	    		String texf = "gvclib:textures/entity/mflash.png";
	    		if(this.getAIType2() == 0){
	        		SoundEvent sounds = GVCSoundEvent.fire_missile;
	        		if(this.cooltime > 60)
	    			{
	        			this.counter1 = true;
	        			this.cooltime = 0;
	    			}
	        		if(this.counter1 && this.gun_count1 > 0){
	        			this.gun_count1 = 0;
	        			{
	        				for(int ii = 0; ii < 2; ++ii) {
		        				float side = 1.57F;
		        				if(ii == 1)side = -1.57F;
		        				AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
								we.id = 4;
								we.missile_targeting_size = 1.0F;
								we.missile_targeting_time_start = 0;
								we.missile_targeting_time_end = 60;
								we.model = "gvclib:textures/entity/new/bullet_agm_small.mqo";
								we.tex = "gvclib:textures/entity/new/bullet_agm_small.png";
								we.modelf = model;
								we.texf = tex;
								we.ftime = 0;
								we.sound = sounds;
								we.f = side;
								we.w = 3.4;
								we.h = 2;
								we.z = 0;
								we.bx = 0;
								we.by = 2.5;
								we.bz = 0;
								we.follow_rote = true;
								we.xoffset = 0;
								we.yoffset = 0;
								we.px = this.posX;
								we.py = this.posY;
								we.pz = this.posZ;
								we.lock = looked;
								we.rote = this.rotationYawHead;
								we.maxy = 10;
								we.miny = 10;
								
								we.power = 20;
								we.speed = 1F;
								we.bure = 1F;
								we.ex = 2.0F;
								we.extrue = false;
								we.kazu = 1;
								we.gra = 0.029;
								we.maxtime = 80;
								we.dameid = 0;
								we.Attacktask(this, this, 100);
		        			}
	        			}
	        			++this.countlimit1;
	        		}
	        		if(this.countlimit1 >= 0){
	        			this.gun_count1 = 0;
	    				this.counter1 = false;
	    				this.countlimit1 = 0;
	    			}
	        	}
	    		if(this.getAIType2() == 1){
	        		SoundEvent sounds = GVCSoundEvent.fire_20mm;
	        		if(this.cooltime > 40)
	    			{
	        			this.counter1 = true;
	        			this.cooltime = 0;
	    			}
	        		if(this.counter1 && this.gun_count1 > 0){
	        			this.gun_count1 = 0;
	        			{
	        				AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
							we.id = 0;
							we.model = "gvclib:textures/entity/model/bullet.mqo";
							we.tex = "gvclib:textures/entity/model/bullet.png";
							we.modelf = model;
							we.texf = tex;
							we.ftime = 0;
							we.sound = sounds;
							we.f = 0;
							we.w = 0;
							we.h = 2.0;
							we.z = 0;
							we.bx = 0;
							we.by = 2.5;
							we.bz = 0;
							we.follow_rote = true;
							we.xoffset = 0;
							we.yoffset = 0;
							we.px = this.posX;
							we.py = this.posY;
							we.pz = this.posZ;
							we.lock = looked;
							we.rote = this.rotationYawHead;
							we.maxy = 10;
							we.miny = 10;
							
							we.power = 4;
							we.speed = 3F;
							we.bure = 4F;
							we.ex = 0;
							we.extrue = false;
							we.kazu = 1;
							we.gra = 0.029;
							we.maxtime = 80;
							we.dameid = 0;
							we.Attacktask(this, this, 80);
	        			}
	        			++this.countlimit1;
	        		}
	        		if(this.countlimit1 >= 20){
	        			this.gun_count1 = 0;
	    				this.counter1 = false;
	    				this.countlimit1 = 0;
	    			}
	        	}
	    		if(this.getAIType2() == 2){
	        		SoundEvent sounds = GVCSoundEvent.fire_roket;
	        		if(this.cooltime > 50)
	    			{
	        			this.counter1 = true;
	        			this.cooltime = 0;
	    			}
	        		if(this.counter1 && this.gun_count1 > 5){
	        			this.gun_count1 = 0;
	        			{
	        				for(int ii = 0; ii < 2; ++ii) {
		        				float side = 1.57F;
		        				if(ii == 1)side = -1.57F;
		        				AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
								we.id = 2;
								we.model = "gvclib:textures/entity/new/bullet_rocket_big.mqo";
								we.tex = "gvclib:textures/entity/new/bullet_rocket_big.png";
								we.modelf = model;
								we.texf = tex;
								we.ftime = 0;
								we.sound = sounds;
								we.f = side;
								we.w = 2.1;
								we.h = 1.2;
								we.z = 0;
								we.bx = 0;
								we.by = 2.5;
								we.bz = 0;
								we.follow_rote = true;
								we.xoffset = 0;
								we.yoffset = 0;
								we.px = this.posX;
								we.py = this.posY;
								we.pz = this.posZ;
								we.lock = looked;
								we.rote = this.rotationYawHead;
								we.maxy = 10;
								we.miny = 10;
								
								we.power = 10;
								we.speed = 2F;
								we.bure = 4F;
								we.ex = 2.0F;
								we.extrue = false;
								we.kazu = 1;
								we.gra = 0.029;
								we.maxtime = 80;
								we.dameid = 0;
								we.Attacktask(this, this, 80);
		        			}
	        			}
	        			++this.countlimit1;
	        		}
	        		if(this.countlimit1 >= 8){
	        			this.gun_count1 = 0;
	    				this.counter1 = false;
	    				this.countlimit1 = 0;
	    			}
	        	}
			}
		}
		
		{
			cloud_x[0] = cloud_x[1] = 1.45;
			cloud_x[2] = cloud_x[3] = -1.45;
			cloud_y[0] = cloud_y[1] = cloud_y[2] = cloud_y[3] = 2.15;
			cloud_z[0] = cloud_z[2] = -2.65;
			cloud_z[1] = cloud_z[3] = -4.0;
		}
		
		for(int t1 = 0; t1 < this.cloud; ++t1){
			if(this.getHealth() > 0.0F)
			{
				double x1 = 0;
				double z1 = 0;
				float ff = this.rotationYaw * 0.01745329252F;
				
				double b = 0;
				double b2 = 0;
				double a = 0;
				double ax = 0;
				double az = 0;
				//if(i != 0) 
				float rpitch = this.rotationPitch;
				if(this.onGround)rpitch = 0;
				
				{
					float rote = this.rotationYaw;
					b =  cloud_z[t1] * MathHelper.sin(rpitch  * (1 * (float) Math.PI / 180)) *  1.0D;
					a =  cloud_z[t1] * Math.abs(Math.cos(rpitch  * (1 * (float) Math.PI / 180))) *  1.0D;
					ax -= MathHelper.sin(rote * (2 * (float) Math.PI / 360)) * a;
					az += MathHelper.cos(rote * (2 * (float) Math.PI / 360)) * a;
					ax -= MathHelper.sin(rote * (2 * (float) Math.PI / 360) - 1.57F) * cloud_x[t1];
					az += MathHelper.cos(rote * (2 * (float) Math.PI / 360) - 1.57F) * cloud_x[t1];
				}
				
				x1 -= MathHelper.sin(ff -1.57F) * cloud_x[t1];
				z1 += MathHelper.cos(ff -1.57F) * cloud_x[t1];
				x1 -= MathHelper.sin(ff) * cloud_z[t1];
				z1 += MathHelper.cos(ff) * cloud_z[t1];
				this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX + 0 + ax, this.posY + cloud_y[t1] - b, this.posZ + 0 + az, 0.0D, 0.0D, 0.0D, new int[0]);
			}
		}
	}
	
	public int AITIME = 0;
	public int cloud = 4;
	public double[] cloud_x = new double[32];
	public double[] cloud_y = new double[32];
	public double[] cloud_z = new double[32];
	
	public void AISetting() {
		++AITIME;
		if(this.getAIType3() == 0) {//接近
			this.setAIType(4);
		}
		else if(this.getAIType3() == 10) {//接近後
			time_reset(1);
		}
		else if(this.getAIType3() == 1) {//近接：機銃orロケット
			if(!(this.getAIType() == 1 || this.getAIType() == 2)) {
				int ran = this.world.rand.nextInt(2);
				if(ran == 0) {
					this.setAIType(1);
				}else {
					this.setAIType(2);
				}
			}
			if(!(this.getAIType2() == 1 || this.getAIType2() == 2)) {
				int ran = this.world.rand.nextInt(2);
				if(ran == 0) {
					this.setAIType2(1);
				}else {
					this.setAIType2(2);
				}
			}
			if(AITIME > 100) {
				time_reset(4);
			}
		}else if(this.getAIType3() == 2) {//遠距離：ロケット
			this.setAIType(5);
			this.setAIType2(2);
			if(AITIME > 100) {
				int ran = this.world.rand.nextInt(4);
				time_reset(ran);
			}
		}
		else if(this.getAIType3() == 3) {//遠距離：ミサイル
			this.setAIType(5);
			this.setAIType2(0);
			if(AITIME > 100) {
				int ran = this.world.rand.nextInt(4);
				time_reset(ran);
			}
		}
		
		else {
			this.setAIType(4);
			if(AITIME > 100) {
				int ran = this.world.rand.nextInt(4);
				if(ran == 1) {
					time_reset(0);
				}else {
					time_reset(ran);
				}
			}
		}
	}
	
	public void time_reset(int ai3) {
		this.setAIType3(ai3);
		this.setAIType(10);
		this.setAIType2(10);
		this.AITIME = 0;
		this.cooltime = 0;
		this.gun_count1 = 0;
		this.counter1 = false;
		this.countlimit1 = 0;
	}
	
	public void newmove(EntityGVCLivingBase entity, int id, float sp, float turnspeed, double max, double range1) {
		entity.sneak = false;
		boolean ta = false;
		double range = range1;
		{
			List<Entity> llist = entity.world.getEntitiesWithinAABBExcludingEntity(entity, entity
					.getEntityBoundingBox().expand(entity.motionX, entity.motionY, entity.motionZ).grow(range));
			if (llist != null) {
				for (int lj = 0; lj < llist.size(); lj++) {
					Entity entity1 = (Entity) llist.get(lj);
					if (entity1.canBeCollidedWith()) {
						boolean flag = entity.getEntitySenses().canSee(entity1);
						if (entity.CanAttack(entity1) && entity1 != null) {//target
							if (((EntityLivingBase) entity1).getHealth() > 0.0F) {
								if(entity.targetentity != null && entity.targetentity == entity1) {
									double d5 = entity1.posX - entity.posX;
									double d7 = entity1.posZ - entity.posZ;
									double d6 = entity1.posY - entity.posY;
									double d1 = entity.posY - (entity1.posY);
									double d3 = (double) MathHelper.sqrt(d5 * d5 + d7 * d7);
									float f11 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
									{
										entity.rotationYawHead = entity.rotation = entity.rote = entity.renderYawOffset 
												= -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
										float pitchangle =  -f11 + 15;
										
										double ddx = Math.abs(d5);
										double ddz = Math.abs(d7);
										if ((ddx < 25 && ddz < 25) && entity.getAIType3() == 0) 
										{
											this.setAIType3(10);
										}
										
										{
											MoveS(entity, sp, 1, entity1.posX, entity1.posY, entity1.posZ, id, (EntityLivingBase)entity1, pitchangle);
										}
										entity.noflag = 0;
									}
									if (flag) {
										entity.targetentity = (EntityLivingBase) entity1;
									}
									break;
								}else {
									if (flag) {
										entity.targetentity = (EntityLivingBase) entity1;
										break;
									}
								}
							} 
						}//target
						
					}
				}
			}
		}
	}
	
	public void MoveS(EntityGVCLivingBase entity, double speed, double han, double ex, double ey, double ez, int id, EntityLivingBase en, float pitchangle){
		{// 1
			if(!entity.world.isRemote)
			{
				double d5 = ex - entity.posX;
				double d7 = ez - entity.posZ;
				
				double root = Math.sqrt(d5 * d5 + d7 * d7);
				
				float off = 0;
				if(entity.getAIType() == 4) {
					entity.rote = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
					if (entity.rote > 180F) {
						entity.rote = -179F;
					}
					if (entity.rote < -180F) {
						entity.rote = 179F;
					}
					if (entity.rotationYaw != entity.rote) {
						float turnspeed  = 0.5F;
						float f3 = (float) (entity.rotationYaw - entity.rote);
						if (f3 > turnspeed) {
							if (f3 > 180F) {
								PL_RoteModel.rotemodel(entity, +turnspeed);
								if (entity.throte < 50) {
									//entity.throte = entity.throte + 2;
								}
							} else {
								PL_RoteModel.rotemodel(entity, -turnspeed);
								if (entity.throte > -50) {
									//entity.throte = entity.throte - 2;
								}
							}
						} else if (f3 < -turnspeed) {
							if (f3 < -180F) {
								PL_RoteModel.rotemodel(entity, -turnspeed);
								if (entity.throte > -50) {
									//entity.throte = entity.throte - 2;
								}
							} else {
								PL_RoteModel.rotemodel(entity, +turnspeed);
								if (entity.throte < 50) {
									//entity.throte = entity.throte + 2;
								}
							}
						}
					}
				}else {
					entity.rotationYaw = entity.renderYawOffset = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
				}
				
				float yaw = entity.rotationYaw * (2 * (float) Math.PI / 360);
				double mox = 0;
				double moy = entity.motionY;
				double moz = 0;
				if(pitchangle > 30) {
					entity.rotationp = entity.rotationPitch = 30;
				}else if(pitchangle < -30) {
					entity.rotationp = entity.rotationPitch = -30;
				}else {
					entity.rotationp = entity.rotationPitch = pitchangle;
				}
				//if(entity.getAIType2() != 0)
				{
					if(entity.getAIType() == 1) {
						mox -= MathHelper.sin(yaw + 1.57F) * speed * 0.25;
						moz += MathHelper.cos(yaw + 1.57F) * speed * 0.25;
					}
					else if(entity.getAIType() == 2) {
						mox -= MathHelper.sin(yaw - 1.57F) * speed * 0.25;
						moz += MathHelper.cos(yaw - 1.57F) * speed * 0.25;
					}
					else if(entity.getAIType() == 3) {
						mox -= MathHelper.sin(yaw) * speed * -1;
						moz += MathHelper.cos(yaw) * speed * -1;
						entity.rotationp = entity.rotationPitch = -10;
					}
					else if(entity.getAIType() == 4) {
						mox -= MathHelper.sin(yaw) * speed * 1.5;
						moz += MathHelper.cos(yaw) * speed * 1.5;
						entity.rotationp = entity.rotationPitch = 0;
					}
					else if(entity.getAIType() == 5) 
					{
						//mox -= MathHelper.sin(yaw) * speed * 1;
						//moz += MathHelper.cos(yaw) * speed * 1;
					}
					else if(entity.getAIType() == 0) 
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

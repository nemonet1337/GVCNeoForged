package gvcr2.entity.vehicle.ge;

import javax.annotation.Nullable;

import gvclib.mod_GVCLib;
import gvclib.entity.living.AI_EntityMoveTank;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_TankSet;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.PL_TankMove;
import gvclib.entity.living.PL_Weapon;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityGVCR2_GE_Technical extends EntityMobVehicleBase {

	public EntityGVCR2_GE_Technical(World worldIn) {
		super(worldIn);
		this.setSize(3F, 1.3F);
		this.experienceValue = 30;
		
		this.sp = 0.020F;
        this.turnspeed = 1.5F;
		this.ridding_invisible = false;
		this.riddng_opentop = true;
        this.thmax = 5F;
		this.thmin = -2F;
		this.thmaxa = 0.2F;
		this.thmina = -0.15F;
		this.stepHeight = 1.5F;
		
		this.ridding_roteplayer = false;
		riddingx[0] = 0;
		riddingy[0] = 1.15;
		riddingz[0] = -1.4;
		
		riddingx_roteplayer[0] = 0;
		riddingy_roteplayer[0] = 0;
		riddingz_roteplayer[0] = -1.0;
		
		antibullet_0 = 0.2F;
		antibullet_1 = 0.75F;
		antibullet_2 = 1.0F;
		antibullet_3 = 1.0F;
		this.ridding_damege = 1.0F;
		
		mob_min_range = 15;
		mob_max_range = 50;
	}

	protected void initEntityAI() {
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0D);
	}
	
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		int ra = this.world.rand.nextInt(8);
		if (ra == 0) {
			this.setArmID_R(1);
		} else if (ra == 1) {
			this.setArmID_R(2);
		} else if (ra == 2) {
			this.setArmID_R(3);
		} else {
			this.setArmID_R(0);
		}
	}
	
	protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier)
    {
    	this.entityDropItem(new ItemStack(Blocks.IRON_BLOCK), 0.0F);
    	{
    		int ra = this.world.rand.nextInt(5) + 1;
        	for(int x = 0; x < ra; ++x) {
        		this.entityDropItem(new ItemStack(Items.EMERALD), 0.0F);
        	}
    	}
    	
    }
	
	/*public void updatePassenger(Entity passenger) {
		if (this.isPassenger(passenger)) {
			double ix = 0;
			double iz = 0;
			float f1 = this.rotation * (2 * (float) Math.PI / 360);
			float f2 = passenger.rotationPitch * (2 * (float) Math.PI / 360);
			ix -= MathHelper.sin(f1) * 0.8;
			iz += MathHelper.cos(f1) * 0.8;
			double ix2 = 0;
			double iz2 = 0;
			float f12 = this.rotationYawHead * (2 * (float) Math.PI / 360);
			float f22 = this.rotationPitch * (2 * (float) Math.PI / 360);
			ix2 -= MathHelper.sin(f12) * 1.3;
			iz2 += MathHelper.cos(f12) * 1.3;
			passenger.setPosition(this.posX - ix2 - ix, this.posY + this.getMountedYOffset() + passenger.getYOffset(),
					this.posZ - iz2 - iz);
		}
	}

	public double getMountedYOffset() {
		return 0.6D;
	}*/
	
	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	public boolean spawn = false;
	 public void onUpdate() {
			super.onUpdate();
			float f1 = this.rotationYawHead * (2 * (float) Math.PI / 360);
			
			this.weapon1true = true;
    		this.weapon1key = 0;
		if (this.getArmID_R() == 1) {
			this.ammo1 = 30;
			this.magazine = 24;
			reload_time1 = 100;
			this.w1name = "23mmMachineCannon";
			this.w1cycle = 4;
    		this.w1barst = 4;
    		this.weapon1 = 1;
    		{
    			this.bullet_type1[0] = 1;
        		this.bullet_model1[0] = "gvclib:textures/entity/BulletAAA.obj";
        		this.bullet_tex1[0] = "gvclib:textures/entity/BulletAAA.png";
        		this.fire_model1[0]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/mflash.png";
        		this.fire_time1[0] = 2;
        		this.sound_fire1[0] = "gvclib.fire_30mm";
        		this.fire_pointx1[0] = 0;
        		this.fire_pointy1[0] = 2F;
        		this.fire_pointz1[0] = -1.4F;
        		this.fire_yoffset1[0] = 0;
        		this.rotationfollowing1[0] = true;
        		this.rotationfirepoint1[0] = false;
        		this.bullet_damage1[0] = 5;
        		this.bullet_speed1[0] = 4F;
        		this.bullet_bure1[0] = 1.0F;
        		this.bullet_expower1[0] = 0F;
        		this.bullet_ex1[0] = false;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.029D;
        		this.bullet_livingtime1[0] = 80;
        		
    		}
    		this.mob_min_range = 100;
			this.mob_max_range = 120;
			this.mob_w1range = 120;
    		this.mob_w1range_max_y = 80;
    		this.mob_w1range_min_y = 1;
		}else
		if (this.getArmID_R() == 2) {
			this.ammo1 = 10;
			this.magazine = 1;
			reload_time1 = 200;
			this.w1name = "Morter";
			this.w1cycle = 1;
    		this.w1barst = 1;
    		this.weapon1 = 1;
    		{
    			this.bullet_type1[0] = 12;
        		this.bullet_model1[0] = "gvclib:textures/entity/BulletRocket.obj";
        		this.bullet_tex1[0] = "gvclib:textures/entity/BulletRocket.png";
        		this.fire_model1[0]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/mflash.png";
        		this.fire_time1[0] = 2;
        		this.sound_fire1[0] = "gvclib.fire_grenade";
        		this.fire_pointx1[0] = 0;
        		this.fire_pointy1[0] = 2F;
        		this.fire_pointz1[0] = -1.4F;
        		this.fire_yoffset1[0] = 1;
        		this.rotationfollowing1[0] = true;
        		this.rotationfirepoint1[0] = false;
        		this.bullet_damage1[0] = 20;
        		this.bullet_speed1[0] = 2.5F;
        		this.bullet_bure1[0] = 1.0F;
        		this.bullet_expower1[0] = 2.0F;
        		this.bullet_ex1[0] = false;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.020D;
        		this.bullet_livingtime1[0] = 80;
        		
    		}
    		this.mob_min_range = 100;
			this.mob_max_range = 120;
			this.mob_w1range = 120;
    		this.mob_w1range_max_y = 20;
    		this.mob_w1range_min_y = 1;
		}else
		if (this.getArmID_R() == 3) {
			this.ammo1 = 100;
			this.magazine = 1;
			reload_time1 = 300;
			this.w1name = "Missile";
			this.w1cycle = 1;
    		this.w1barst = 1;
    		this.weapon1 = 1;
    		{
    			this.bullet_type1[0] = 2;
        		this.bullet_model1[0] = "gvclib:textures/entity/BulletMissile.obj";
        		this.bullet_tex1[0] = "gvclib:textures/entity/BulletMissile.png";
        		this.fire_model1[0]= "gvclib:textures/entity/msmoke.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/msmoke.png";
        		this.fire_time1[0] = 16;
        		this.sound_fire1[0] = "gvclib.fire_missile";
        		this.fire_pointx1[0] = 0;
        		this.fire_pointy1[0] = 2F;
        		this.fire_pointz1[0] = -1.4F;
        		this.fire_yoffset1[0] = 0;
        		this.rotationfollowing1[0] = true;
        		this.rotationfirepoint1[0] = false;
        		this.bullet_damage1[0] = 30;
        		this.bullet_speed1[0] = 2.5F;
        		this.bullet_bure1[0] = 1.0F;
        		this.bullet_expower1[0] = 2.0F;
        		this.bullet_ex1[0] = false;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.029D;
        		this.bullet_livingtime1[0] = 80;
        		
    		}
    		this.mob_min_range = 100;
			this.mob_max_range = 120;
			this.mob_w1range = 120;
    		this.mob_w1range_max_y = 80;
    		this.mob_w1range_min_y = 1;
		}else {
			this.ammo1 = 20;
			this.magazine = 30;
			reload_time1 = 100;
			this.w1name = "MachineGun";
			this.w1cycle = 2;
    		this.w1barst = 3;
    		this.weapon1 = 1;
    		{
    			this.bullet_type1[0] = 0;
        		this.bullet_model1[0] = "gvclib:textures/entity/BulletNormal.obj";
        		this.bullet_tex1[0] = "gvclib:textures/entity/BulletNormal.png";
        		this.fire_model1[0]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/mflash.png";
        		this.fire_time1[0] = 2;
        		this.sound_fire1[0] = "gvclib.fire_rifle";
        		this.fire_pointx1[0] = 0;
        		this.fire_pointy1[0] = 2F;
        		this.fire_pointz1[0] = -1.4F;
        		this.fire_yoffset1[0] = 0;
        		this.rotationfollowing1[0] = true;
        		this.rotationfirepoint1[0] = false;
        		this.bullet_damage1[0] = 5;
        		this.bullet_speed1[0] = 2.5F;
        		this.bullet_bure1[0] = 1.0F;
        		this.bullet_expower1[0] = 0F;
        		this.bullet_ex1[0] = false;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.029D;
        		this.bullet_livingtime1[0] = 80;
        		
    		}
    		this.mob_min_range = 15;
    		this.mob_max_range = 50;
    		this.mob_w1range = 30;
    		this.mob_w1range_max_y = 15;
    		this.mob_w1range_min_y = 1;
		}
		this.ammo2 = 10;
		this.magazine2 = 1;
		reload_time2 = 400;
		this.w2name = "Spawn";
		
		if(this.getRemain_L() <= 0){
			++reload1;
			if(reload1 == reload_time1 - 40){
				this.playSound(GVCSoundEvent.reload_mg, 1.0F, 1.0F);
			}
			if(reload1 >= reload_time1){
				this.setRemain_L(this.magazine);
				reload1 = 0;
			}
		}
		
		if(this.getRemain_R() <= 0){
			++reload2;
			if(reload2 >= reload_time2){
				this.setRemain_R(this.magazine2);
				reload2 = 0;
			}
		}
		
		if (this.canBeSteered() && this.getControllingPassenger() != null)
		{
			if(this.getControllingPassenger() instanceof EntityPlayer)
			{
			EntityPlayer entitylivingbase = (EntityPlayer) this.getControllingPassenger();
			Vec3d looked = entitylivingbase.getLookVec();
			if (this.getArmID_R() == 2) {
				{
					if(this.getFTMode() == 1){
						spg_mode = true;
						{
							int range = 120;
								float yaw = entitylivingbase.rotationYawHead * (2 * (float) Math.PI / 360);
								float xx = 0;
								float zz = 0;
								if (entitylivingbase.moveForward > 0.0F && (spg_yaw < range && spg_picth < range)) {
									xx = xx + 1;
								}
								if (entitylivingbase.moveForward < 0.0F && (spg_yaw > -range && spg_picth > -range)) {
									xx = xx - 1;
								}
								if (entitylivingbase.moveStrafing > 0.0F && (spg_yaw < range && spg_picth < range)) {
									zz = zz + 1;
								}
								if (entitylivingbase.moveStrafing < 0.0F  && (spg_yaw > -range && spg_picth > -range)) {
									zz = zz - 1;
								}
								spg_yaw -= MathHelper.sin(yaw) * xx;
								spg_picth += MathHelper.cos(yaw) * xx;
								spg_yaw -= MathHelper.sin(yaw - 1.57F) * zz;
								spg_picth += MathHelper.cos(yaw - 1.57F) * zz;
								double d5 = this.spg_yaw;
								double d7 = this.spg_picth;
								float yawoffset = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
								this.rotation = yawoffset;
								this.rotationp = -40;
								BlockPos bp = world.getHeight(new BlockPos(spg_yaw, this.posY, spg_picth));
								spg_y = bp.getY();
								/*GVCLPacketHandler.INSTANCE
										.sendToServer(new GVCLMessageKeyPressed(31, this.getEntityId(), spg_yaw));
								GVCLPacketHandler.INSTANCE
										.sendToServer(new GVCLMessageKeyPressed(32, this.getEntityId(), spg_picth));*/
						}
					}else {
						spg_mode = false;
						spg_yaw = 0;
						spg_picth = 0;
						this.rotation = entitylivingbase.rotationYawHead;
						this.rotationp = entitylivingbase.rotationPitch;
						PL_TankMove.move2(entitylivingbase, this, sp, turnspeed);
					}
				}
				
			}else {
			this.rotation = entitylivingbase.rotationYawHead;
			this.rotationp = entitylivingbase.rotationPitch;
			PL_TankMove.move2(entitylivingbase, this, sp, turnspeed);
			}
			
			boolean left = mod_GVCLib.proxy.leftclick();
			boolean right = mod_GVCLib.proxy.rightclick();
			boolean jump = mod_GVCLib.proxy.jumped();
			boolean kx = mod_GVCLib.proxy.keyx();
			boolean kg = mod_GVCLib.proxy.keyg();
			boolean kc = mod_GVCLib.proxy.keyc();
			if (left) {
				GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(11, this.getEntityId()));
				this.server1 = true;
			}
			if (right) {
				GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(12, this.getEntityId()));
			}
			if (jump) {
				GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(13, this.getEntityId()));
			}
			if (kx) {
				GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(14, this.getEntityId()));
			}
			if (kg) {
				GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(15, this.getEntityId()));
			}
			if (kc) {
				GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(16, this.getEntityId()));
			}
			if(this.server1)
		    {
		    	{
    				if(cooltime >= ammo1){
    					this.counter1 = true;
    		            cooltime = 0;
    				}
    				if(this.weapon1true) {
    					if(this.getArmID_R() == 1 && this.weapon11true){
    						this.weapon11active(looked, entitylivingbase);
    					}else if(this.getArmID_R() == 2 && this.weapon12true){
    						this.weapon12active(looked, entitylivingbase);
    					}else {
    						this.weapon1active(looked, entitylivingbase);
    					}
        		    }
    			}
		    	this.server1 = false;
			}
			if(this.getArmID_R() == 3){
				PL_Weapon.EntityLock(this, entitylivingbase, false);
		}
			if (this.serverg) {
				if (cooltime6 > 1 && this.getWeaponChange() > 0) {
					if(this.getFTMode() >= 1){
						this.setFTMode(0);
					}else
					{
						this.setFTMode(1);
					}
					cooltime6 = 0;
					this.setWeaponChange(this.getWeaponChange() - 1);
				}
				{
					this.serverg = false;
				}
			}
			
			}//player
			else if(this.getControllingPassenger() instanceof EntityGVCLivingBase) {
				EntityGVCLivingBase entitylivingbase = (EntityGVCLivingBase) this.getControllingPassenger();
				Vec3d looked = entitylivingbase.getLookVec();
				int mobkazu = 0;
				int mobkazu2 = 0;
				/*if (this.getControllingPassenger() instanceof EntityG_S) {
					if (this.getRemain_R() > 0 && !this.world.isRemote)
					{// 1
						if (this.getArmID_R() == 0) 
						{
							Entity entity = null;
							int kazu = 0;
							double k = this.posX;
							double l = this.posY;
							double i = this.posZ;
							int han = 50;
							int han2 = 30;
							boolean player = false;
							AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double) (k - han), (double) (l - han),
									(double) (i - han), (double) (k + han), (double) (l + han), (double) (i + han)))
											.grow(1);
							List<Entity> llist = this.world.getEntitiesWithinAABBExcludingEntity(this, axisalignedbb);
							if (llist != null) {
								for (int lj = 0; lj < llist.size(); lj++) {
									Entity entity1 = (Entity) llist.get(lj);
									if (entity1.canBeCollidedWith()) {
										if (entity1 instanceof EntityPlayer && entity1 != null)
				                        {
				                			EntityPlayer ss = (EntityPlayer) entity1;
				                			ItemStack itemstack = ss.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
				                    		if(!itemstack.isEmpty() && itemstack.getItem() == Items.GOLDEN_HELMET){
				                    		}else {
				                    			player = true;
				                    		}
				                        }
									}
								}
							}
							if(player){
								AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double) (k - han2), (double) (l - han2),
										(double) (i - han2), (double) (k + han2), (double) (l + han2), (double) (i + han2)))
												.grow(1);
								List<Entity> llist22 = this.world.getEntitiesWithinAABBExcludingEntity(this,axisalignedbb2);
								if (llist22 != null) {
									for (int lj = 0; lj < llist22.size(); lj++) {
										Entity entity1 = (Entity) llist22.get(lj);
										if (entity1.canBeCollidedWith()) {
											if (entity1 instanceof EntityG_S && entity1 != null) {
												++mobkazu2;
											}
										}
									}
								}
								if(mobkazu2 < 2){
									for (int g = 0; g < 4; ++g){
										int ix = this.world.rand.nextInt(8);
										int iz = this.world.rand.nextInt(8);
										EntityG_S entityskeleton = new EntityG_S(this.world);
							            entityskeleton.setLocationAndAngles(this.posX - 4 +ix, this.posY+1, this.posZ - 4 +iz, this.rotationYaw, 0.0F);
							            if (this.world.rand.nextInt(5) == 0) {
							            	entityskeleton.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR.gun_svd));
							    		} else if (this.world.rand.nextInt(5) == 1) {
							    			entityskeleton.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR.gun_pkm));
							    		} else if (this.world.rand.nextInt(5) == 2) {
							    			entityskeleton.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR.gun_rpg));
							    		} else {
							    			entityskeleton.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR.gun_ak74));
							    		}
							            if(this.getMoveT() == 1){
							            	entityskeleton.setMoveT(1);
							                entityskeleton.setMoveX(this.getMoveX());
							                entityskeleton.setMoveY(this.getMoveY());
							                entityskeleton.setMoveZ(this.getMoveZ());
							            }
							            
							            this.world.spawnEntity(entityskeleton);
										}
								}
							}
						}
						this.cooltime2 = 0;
						this.setRemain_R(this.getRemain_R() - 1);
					} // 1
				}*/
				
				
				if (this.getArmID_R() == 1) {
					AI_EntityMoveTank.movespg(this, entitylivingbase, f1, sp,turnspeed, 60, 80);
				}else if (this.getArmID_R() == 2) {
					AI_EntityMoveTank.movespg(this, entitylivingbase, f1, sp,turnspeed, 60, 100);
				}else if (this.getArmID_R() == 3) {
					AI_EntityMoveTank.movespg(this, entitylivingbase, f1, sp,turnspeed, 60, 100);
				}else{
					AI_EntityMoveTank.move(this, entitylivingbase, f1, sp, turnspeed, this.mob_min_range, this.mob_max_range);
				}
				
				if(AI_EntityWeapon.getRange(entitylivingbase, this.mob_w1range, this.mob_w1range_max_y, this.mob_w1range_min_y)){
					if(cooltime >= ammo1 && this.getRemain_L() > 0){
						this.counter1 = true;
			            cooltime = 0;
					}
					if(this.weapon1true) {
	    		    	this.weapon1activeMob(looked, entitylivingbase, 0);
	    		    }
				}
			}
		}
		
		AI_TankSet.set2(this, GVCSoundEvent.sound_car, f1, sp, 0.1F);
		
		this.catchEntityBiped();
	}
	 @Nullable
	    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
	    {
	        livingdata = super.onInitialSpawn(difficulty, livingdata);
	     // if(!this.world.isRemote)
	        /*{
				EntityG_S entityskeleton = new EntityG_S(this.world);
		        entityskeleton.setLocationAndAngles(this.posX+0.5, this.posY, this.posZ+0.5, 0, 0.0F);
		        entityskeleton.onInitialSpawn(difficulty, (IEntityLivingData)null);
		        this.world.spawnEntity(entityskeleton);
		        entityskeleton.startRiding(this);
	        }*/
	        return livingdata;
	    }

	protected void onDeathUpdate() {
		++this.deathTicks;
		int x = this.world.rand.nextInt(4);
		int y = this.world.rand.nextInt(5);
		int z = this.world.rand.nextInt(4);
		if (this.deathTicks == 1 && !this.world.isRemote) {
			this.world.createExplosion(this, this.posX, this.posY + 2, this.posZ, 3.0F, false);
		}
		if (this.deathTicks == 10 && !this.world.isRemote) {
			this.setDead();
		}
	}
}
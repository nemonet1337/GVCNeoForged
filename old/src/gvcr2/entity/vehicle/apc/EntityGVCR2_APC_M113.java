package gvcr2.entity.vehicle.apc;

import java.util.List;

import javax.annotation.Nullable;

import gvclib.mod_GVCLib;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_TankSet;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.ISoldier;
import gvclib.entity.living.PL_TankMove;
import gvclib.entity.living.cnt.VehicleCNT_Tank;
import gvclib.entity.living.cnt.VehicleCNT_Tank_SPG;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.so.EntityGVCR2_SO_S;
import gvcr2.entity.vehicle.VehicleBase;
import gvcr2.event.level.GVCR2WorldDifficultyLevel;
import hmggirlfront.mod_GirlFront;
import hmggirlfront.entity.EntityDoll;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldProviderSurface;

public class EntityGVCR2_APC_M113 extends EntityMobVehicleBase
{

    public EntityGVCR2_APC_M113(World worldIn)
    {
        super(worldIn);
        this.setSize(4F, 3.0F);
        ridding_roteangle = mod_GVCR2.cfg_vehicle_angle;
        this.riddng_freehand = false;
        this.hud_icon = "gvcr2:textures/hud/apc.png";
        //this.render_hud_icon_hori = true;
        //this.hud_icon_hori = "hmggirlfront:textures/hud/heli_hori.png";
        this.render_hud_information_2 = "R-Click:Zoom";
        this.render_hud_information_3 = "W/S-KEY:Throttle-UP/DWON";
        this.render_hud_information_4 = "A/D-KEY:TURN-RIGHT/LEFT";
        vehicletype = 2;
        ridding_roteplayer = false;
        this.roodbreak = mod_GVCR2.cfg_movebreak;
        
        vehicle_ridding_nofire[0] = true;
        vehicle_ridding_nofire[1] = true;
        vehicle_ridding_nofire[2] = true;
        vehicle_ridding_nofire[3] = true;
        vehicle_ridding_nofire[4] = true;

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        
        this.sp = 0.05F;
        this.turnspeed = 3F;
		this.ridding_invisible = false;
		this.riddng_opentop = false;
		
		this.thmax = 5F;
		this.thmin = -2F;
		this.thmaxa = 0.2F;
		this.thmina = -0.15F;
		this.stepHeight = 1.5F;
		this.riddng_maximum = 5;
		this.ridding_roteplayer = false;
		this.riddng_maximum = 5;
		riddingx[0] = 0;
		riddingy[0] = 2.0;
		riddingz[0] = 0;
		{
			riddingx[1]=0.6D;
			riddingy[1]=0.6D;
			riddingz[1]=0.5D;
			
			riddingx[2]=-0.6D;
			riddingy[2]=0.6D;
			riddingz[2]=0.5D;
			
			riddingx[3]=0.6D;
			riddingy[3]=0.6D;
			riddingz[3]=-0.6D;
			
			riddingx[4]=-0.6D;
			riddingy[4]=0.6D;
			riddingz[4]=-0.6D;
		}
		riddingx_roteplayer[0] = 0;
		riddingy_roteplayer[0] = 0;
		riddingz_roteplayer[0] = 0;
		
		antibullet_0 = 0.0F;
		antibullet_1 = 0.5F;
		antibullet_2 = 1.0F;
		antibullet_3 = 1.0F;
		this.ridding_damege = 1.0F;
		
		this.roodbreak = mod_GVCR2.cfg_movebreak;
		
		this.weapon1true = true;
		this.weapon1key = 0;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(120D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }

    
    public void setWeapon(int id) {
    	if (id == 1) {
			//this.typeTank();
			this.spawn_item = mod_GVCR2.gvcr2_spawn_apc_m113_aa;
			VehicleCNT_Tank.load(this, GVCSoundEvent.sound_tank);
			this.w1can_cooldown = true;
			this.aarader = true;
			this.renderhud = true;
			this.riddng_opentop = false;
			this.w1name = "20mmMachineCannon";
			this.ammo1 = 1;
			this.magazine = 20;
			reload_time1 = 70;
			this.w1cycle = 1;
			this.w1barst = 1;
			this.weapon1 = 1;
			{
				this.bullet_type1[0] = 1;
				this.bullet_model1[0] = "gvclib:textures/entity/BulletAAA.obj";
				this.bullet_tex1[0] = "gvclib:textures/entity/BulletAAA.png";
				this.fire_model1[0] = "gvclib:textures/entity/mflash.mqo";
				this.fire_tex1[0] = "gvclib:textures/entity/mflash.png";
				this.fire_time1[0] = 2;
				this.sound_fire1[0] = "gvclib.fire_20mm";
				this.fire_pointx1[0] = 0;
				this.fire_pointy1[0] = 2.7F;
				this.fire_pointz1[0] = 2.8F;
				this.basis_pointx1[0] = 0;
        		this.basis_pointy1[0] = 2.7F;
        		this.basis_pointz1[0] = 1.0F;
				this.fire_yoffset1[0] = 0;
				this.rotationfollowing1[0] = true;
				this.rotationfirepoint1[0] = true;
				this.bullet_damage1[0] = 5;
				this.bullet_speed1[0] = 4F;
				this.bullet_bure1[0] = 1.0F;
				this.bullet_expower1[0] = 0F;
				this.bullet_ex1[0] = false;
				this.bullet_kazu1[0] = 1;
				this.bullet_gravity1[0] = 0.029D;
				this.bullet_livingtime1[0] = 80;

			}
			riddingx[0] = 0;
			riddingy[0] = 2.0;
			riddingz[0] = 0;
			riddingx_roteplayer[0] = 0;
			riddingy_roteplayer[0] = 0;
			riddingz_roteplayer[0] = 0.0;
			this.mob_min_range = 60;
			this.mob_max_range = 60;
			this.mob_w1range = 60;
			this.mob_w1range_max_y = 60;
			this.mob_w1range_min_y = 1;
		} else if (id == 2) {
			//this.typeTank();
			this.spawn_item = mod_GVCR2.gvcr2_spawn_apc_m113_ifv;
			VehicleCNT_Tank.load(this, GVCSoundEvent.sound_tank);
			this.w1can_cooldown = false;
			this.aarader = false;
			this.riddng_opentop = false;
			this.w1name = "25mmMachineCannon";
			this.ammo1 = 20;
			this.magazine = 30;
			reload_time1 = 80;
			this.w1cycle = 4;
			this.w1barst = 3;
			this.weapon1 = 1;
			{
				this.bullet_type1[0] = 1;
				this.bullet_model1[0] = "gvclib:textures/entity/BulletAAA.obj";
				this.bullet_tex1[0] = "gvclib:textures/entity/BulletAAA.png";
				this.fire_model1[0] = "gvclib:textures/entity/mflash.mqo";
				this.fire_tex1[0] = "gvclib:textures/entity/mflash.png";
				this.fire_time1[0] = 2;
				this.sound_fire1[0] = "gvclib.fire_30mm";
				this.fire_pointx1[0] = -0.7F;
				this.fire_pointy1[0] = 2.65F;
				this.fire_pointz1[0] = 1.8F;
				this.basis_pointx1[0] = -0.4F;
        		this.basis_pointy1[0] = 2.65F;
        		this.basis_pointz1[0] = 0.75F;
				this.fire_yoffset1[0] = 0;
				this.rotationfollowing1[0] = true;
				this.rotationfirepoint1[0] = true;
				this.bullet_damage1[0] = 5;
				this.bullet_speed1[0] = 3.5F;
				this.bullet_bure1[0] = 1.0F;
				this.bullet_expower1[0] = 0F;
				this.bullet_ex1[0] = false;
				this.bullet_kazu1[0] = 1;
				this.bullet_gravity1[0] = 0.025D;
				this.bullet_livingtime1[0] = 80;

			}
			riddingx[0] = -0.4;
			riddingy[0] = 2.3;
			riddingz[0] = 0.2;
			riddingx_roteplayer[0] = 0;
			riddingy_roteplayer[0] = 0;
			riddingz_roteplayer[0] = -0.1;
			this.mob_min_range = 20;
			this.mob_max_range = 50;
			this.mob_w1range = 50;
			this.mob_w1range_max_y = 15;
			this.mob_w1range_min_y = 5;
		} else if (id == 3) {
			//this.typeSPG();
			this.spawn_item = mod_GVCR2.gvcr2_spawn_apc_m113_spg;
			VehicleCNT_Tank_SPG.load(this, GVCSoundEvent.sound_tank);
			this.w1can_cooldown = false;
			this.aarader = false;
			this.riddng_opentop = false;
			this.weapon1true = true;
    		this.weapon1key = 0;
    		this.w1name = "60mmMortar";
    		this.ammo1 = 20;
    		this.magazine = 1;
    		this.reload_time1 = 120;
    		this.reloadsoundset1 = 20;
    		this.reloadsound1 = GVCSoundEvent.reload_shell;
    		this.w1cycle = 1;
    		this.w1barst = 1;
    		this.weapon1 = 1;
    		{
    			this.bullet_type1[0] = 13;
        		this.bullet_model1[0] = "gvclib:textures/entity/bulletrocket.mqo";
        		this.bullet_tex1[0] = "gvclib:textures/entity/bulletrocket.png";
        		this.fire_model1[0]= "gvclib:textures/entity/msmoke.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/msmoke.png";
        		this.fire_time1[0] = 16;
        		this.sound_fire1[0] = "gvclib.fire_grenade";
        		this.fire_pointx1[0] = 0;
        		this.fire_pointy1[0] = 1.2F;
        		this.fire_pointz1[0] = -1.1F;
        		this.basis_pointx1[0] = 0;
        		this.basis_pointy1[0] = 1.2F;
        		this.basis_pointz1[0] = -1.1F;
        		this.fire_yoffset1[0] = 0;
        		this.rotationfollowing1[0] = true;
        		this.rotationfirepoint1[0] = false;
        		this.rotation_player1[0] = true;
        		this.bullet_damage1[0] = 30;
        		this.bullet_speed1[0] = 4.0F;
        		this.bullet_bure1[0] = 1.0F;
        		this.bullet_expower1[0] = 3.0F;
        		this.bullet_ex1[0] = false;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.029D;
        		this.bullet_livingtime1[0] = 80;
    		}
    		riddingx[0] = 0.9;
    		riddingy[0] = 1.5;
    		riddingz[0] = 1.2;
    		riddingx_roteplayer[0] = 0;
			riddingy_roteplayer[0] = 0;
			riddingz_roteplayer[0] = 0.0;
			this.mob_min_range = 100;
			this.mob_max_range = 120;
			this.mob_w1range = 120;
			this.mob_w1range_max_y = 80;
			this.mob_w1range_min_y = 1;
		} else {
			//this.typeTank();
			this.spawn_item = mod_GVCR2.gvcr2_spawn_apc_m113;
			VehicleCNT_Tank.load(this, GVCSoundEvent.sound_tank);
			this.w1can_cooldown = true;
			this.aarader = false;
			this.riddng_opentop = true;
			this.w1name = "12.7mmHMG";
			this.ammo1 = 3;
			this.magazine = 10;
			reload_time1 = 55;
			this.reloadsoundset1 = 40;
    		this.reloadsound1 = GVCSoundEvent.reload_mg;
			this.w1cycle = 1;
			this.w1barst = 1;
			this.weapon1 = 1;
			{
				this.bullet_type1[0] = 0;
				this.bullet_model1[0] = "gvclib:textures/entity/BulletNormal.obj";
				this.bullet_tex1[0] = "gvclib:textures/entity/BulletNormal.png";
				this.fire_model1[0] = "gvclib:textures/entity/mflash.mqo";
				this.fire_tex1[0] = "gvclib:textures/entity/mflash.png";
				this.fire_time1[0] = 2;
				this.sound_fire1[0] = "gvclib.fire_hmg";
				this.fire_pointx1[0] = 0;
				this.fire_pointy1[0] = 2.7F;
				this.fire_pointz1[0] = 2.3F;
				this.basis_pointx1[0] = 0;
        		this.basis_pointy1[0] = 2.7F;
        		this.basis_pointz1[0] = 0.6F;
				this.fire_yoffset1[0] = -0.02F;
				this.rotationfollowing1[0] = true;
				this.rotationfirepoint1[0] = true;
				this.bullet_damage1[0] = 6;
				this.bullet_speed1[0] = 4.0F;
				this.bullet_bure1[0] = 0.5F;
				this.bullet_expower1[0] = 0F;
				this.bullet_ex1[0] = false;
				this.bullet_kazu1[0] = 1;
				this.bullet_gravity1[0] = 0.029D;
				this.bullet_livingtime1[0] = 80;

			}
			riddingx[0] = 0;
			riddingy[0] = 1.7;
			riddingz[0] = 0;
			riddingx_roteplayer[0] = 0;
			riddingy_roteplayer[0] = 0;
			riddingz_roteplayer[0] = 0.0;
			this.mob_min_range = 15;
			this.mob_max_range = 50;
			this.mob_w1range = 30;
			this.mob_w1range_max_y = 15;
			this.mob_w1range_min_y = 1;
		}
    }
    
    
    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		float f1 = this.rotationYawHead * (2 * (float) Math.PI / 360);
		this.roadattack();
		VehicleBase.roadattack_barbed(this);
		
		this.setWeapon(this.getArmID_L() );
		
		this.ContMobRidding();
    }

    protected void onDeathUpdate() {
		++this.deathTicks;
		int x = this.world.rand.nextInt(4);
		int y = this.world.rand.nextInt(5);
		int z = this.world.rand.nextInt(4);
		if(this.getControllingPassenger() instanceof EntityLivingBase) {
			EntityLivingBase entity = (EntityLivingBase) this.getControllingPassenger();
			this.getControllingPassenger().dismountRidingEntity();
		}
		if (this.deathTicks == 1 && !this.world.isRemote) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 2, false,  false);
		}
		if (this.deathTicks == 200 && !this.world.isRemote) {
			this.setDead();
		}
	}
    
    public boolean getCanSpawnHere() {
		return this.getLevel() >= 3 && this.getCanSpawnUnderGround() && this.getCanSpawnDimension() && super.getCanSpawnHere();
	}
   
   public boolean getCanSpawnDimension()
   {
	   boolean flag = false;
	   if (world.provider instanceof WorldProviderSurface) {
		   flag = true;
	   }
	   else if (world.provider instanceof WorldProviderHell) {
		   flag = mod_GVCR2.cfg_canspawn_hell;
	   }
	   else if (world.provider instanceof WorldProviderEnd) {
		   flag = mod_GVCR2.cfg_canspawn_sky;
	   }else {
		   flag = mod_GVCR2.cfg_canspawn_anotherworld;
	   }
	   return flag;
   }
   
   public boolean getCanSpawnUnderGround()
   {
	   boolean flag = false;
	   BlockPos bp = world.getHeight(new BlockPos(this.posX, this.posY, this.posZ));
	   int genY = bp.getY();
	   if(this.posY >= genY) {
		   flag = true;
	   }
	   if(mod_GVCR2.cfg_canspawn_underground) {
		   flag = true;
	   }
	   return flag;
   }
   
   public int getLevel() {
 	  /* if(mod_GVCR2.cfg_spawn_original) {
 		   return 10;
 	   }else */
 	   {
 		   return GVCR2WorldDifficultyLevel.getLevel(mod_GVCR2.INSTANCE, this.world);
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
   	}else if(this.getcanDespawn() >= 1) {
   		rand = 1;
   	}else {
   		 rand = 0;
   	}
   	if(rand == 0) {
   		int ran = this.world.rand.nextInt(3);
   		if(ran == 0){
				int ra = this.world.rand.nextInt(8) + 2;
				for(int x = 0; x < ra; ++x) {
					this.entityDropItem(new ItemStack(Items.IRON_INGOT), 0.0F);
				}
			}else {
				int ra = this.world.rand.nextInt(10) + 2;
				for(int x = 0; x < ra; ++x) {
					this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_item_scrap), 0.0F);
				}
			}
   	}
   }
   
   @Nullable
   public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
   {
       livingdata = super.onInitialSpawn(difficulty, livingdata);
      this.setWeapon(0);
       if(this.world.rand.nextInt(3) == 0){
       	EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(this.world);
	        entityskeleton.setLocationAndAngles(this.posX+0.5, this.posY, this.posZ+0.5, 0, 0.0F);
	        entityskeleton.onInitialSpawn(difficulty, (IEntityLivingData)null);
	        this.world.spawnEntity(entityskeleton);
	        entityskeleton.startRiding(this);
       }else {
    	   EntityGVCR2_SO_S entityskeleton = new EntityGVCR2_SO_S(this.world);
	        entityskeleton.setLocationAndAngles(this.posX+0.5, this.posY, this.posZ+0.5, 0, 0.0F);
	        entityskeleton.onInitialSpawn(difficulty, (IEntityLivingData)null);
	        this.world.spawnEntity(entityskeleton);
	        entityskeleton.startRiding(this);
       }
       return livingdata;
   }
   
}
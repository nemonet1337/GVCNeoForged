package gvcr2.entity.vehicle.car;

import java.util.List;

import javax.annotation.Nullable;

import gvclib.mod_GVCLib;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_TankSet;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.EntityVehicleBase;
import gvclib.entity.living.ISoldier;
import gvclib.entity.living.PL_TankMove;
import gvclib.entity.living.cnt.ai.AI_GetTarget_OnRidding;
import gvclib.event.GVCSoundEvent;
import gvclib.item.ItemGunBase;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.event.level.GVCR2WorldDifficultyLevel;
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldProviderSurface;

public class EntityGVCR2_CAR_Technical extends EntityMobVehicleBase
{

    public EntityGVCR2_CAR_Technical(World worldIn)
    {
        super(worldIn);
        this.setSize(4F, 3.0F);
        
        ridding_roteangle = mod_GVCR2.cfg_vehicle_angle;
        
        this.riddng_freehand = true;
        //this.hud_icon = "hmggirlfront:textures/hud/apc.png";
        //this.render_hud_icon_hori = true;
        //this.hud_icon_hori = "hmggirlfront:textures/hud/heli_hori.png";
        this.render_hud_information_2 = "R-Click:Zoom";
        this.render_hud_information_3 = "W/S-KEY:Throttle-UP/DWON";
        this.render_hud_information_4 = "A/D-KEY:TURN-RIGHT/LEFT";
        this.render_hud_information_5 = "V-KEY:ALLY-Boarding";
        this.render_hud_information_6 = "B-KEY:ALLY-Get off";
        vehicletype = 2;
        this.ridding_roteplayer = false;
        this.ridding_roteplayerPitch = false;
        this.roodbreak = mod_GVCR2.cfg_movebreak;
        
        vehicle_ridding_nofire[0] = true;
        vehicle_ridding_nofire[1] = true;
        vehicle_ridding_nofire[2] = true;
        vehicle_ridding_nofire[3] = true;
        vehicle_ridding_nofire[4] = true;

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_car_technical;
        
        this.sp = 0.05F;
        this.turnspeed = 3F;
		this.ridding_invisible = false;
		this.riddng_opentop = false;
		this.renderhud = true;
		this.render_rader = false;
		this.thmax = 5F;
		this.thmin = -2F;
		this.thmaxa = 0.2F;
		this.thmina = -0.15F;
		this.stepHeight = 1.5F;
		this.riddng_maximum = 3;
		riddingx[0]=0.6D;
		riddingy[0]=0.9D;
		riddingz[0]=0.15D;
		{
			riddingx[2]=-0.6D;
			riddingy[2]=0.9D;
			riddingz[2]=0.15D;
			
			//riddingx[2]=0.0D;
			//riddingy[2]=2.0D;
			//riddingz[2]=-1.0D;
			riddingx[1]=0.0D;
			riddingy[1]=1.8D;
			riddingz[1]=-1.5D;
			riddingx_roteplayer[1]=0.0D;
			riddingy_roteplayer[1]=0.0D;
			riddingz_roteplayer[1]=-1.0D;
		}
		
		
		ridding_view_x=0F;
		ridding_view_y=-2F;
		ridding_view_z=-5F;
		ridding_view_gunner_x=0F;
		ridding_view_gunner_y=2F;
		ridding_view_gunner_z=1F;
		
		antibullet_0 = 0.5F;
		antibullet_1 = 1.0F;
		antibullet_2 = 1.0F;
		antibullet_3 = 1.1F;
		this.ridding_damege = 0.5F;
		
		
		
		
			
			this.ridding_rotation_lock = false;
	        this.rotation_max = 180F;
			
			
			
	        
		
    }

    public void setWeapon(int id) {
    	if (id == 1) {
    		{
    			this.weapon3true = true;
        		this.weapon3key = 0;
        		this.w3name = "60mmMortar";
        		this.ammo3 = 20;
        		this.magazine3 = 1;
        		this.reload_time3 = 120;
        		this.reloadsoundset3 = 20;
        		this.reloadsound3 = GVCSoundEvent.reload_shell;
        		this.w3cycle = 1;
        		this.w3barst = 1;
        		this.weapon3 = 1;
        		{
        			this.bullet_type3[0] = 13;
            		this.bullet_model3[0] = "gvclib:textures/entity/bulletrocket.mqo";
            		this.bullet_tex3[0] = "gvclib:textures/entity/bulletrocket.png";
            		this.fire_model3[0]= "gvclib:textures/entity/msmoke.mqo";
            		this.fire_tex3[0] = "gvclib:textures/entity/msmoke.png";
            		this.fire_time3[0] = 16;
            		this.sound_fire3[0] = "gvclib.fire_grenade";
            		this.fire_pointx3[0] = 0.0F;
					this.fire_pointy3[0] = 2.8F;
					this.fire_pointz3[0] = -1.5F;
					this.basis_pointx3[0] = 0.0F;
	        		this.basis_pointy3[0] = 2.8F;
	        		this.basis_pointz3[0] = -1.5F;
	        		this.arm_x[0] = 0.0F;
	        		this.arm_z[0] = -1.5F;
					this.fire_yoffset3[0] = 0;
					this.rotationfollowing3[0] = false;
					this.rotationfirepoint3[0] = false;
					this.rotation_mob_head3[0] = false;
					this.rotation_firepointbxbz3[0] = true;
					this.rotation_player3[0] = true;
            		this.bullet_damage3[0] = 20;
            		this.bullet_speed3[0] = 4.0F;
            		this.bullet_bure3[0] = 1.0F;
            		this.bullet_expower3[0] = 3.0F;
            		this.bullet_ex3[0] = mod_GVCR2.cfg_exprotion_grenade;
            		this.bullet_kazu3[0] = 1;
            		this.bullet_gravity3[0] = 0.029D;
            		this.bullet_livingtime3[0] = 80;
            		
        		}
    		}
    		
    		this.mob_w3range = 100;
    		this.mob_w3range_max_y = 60;
    		this.mob_w3range_min_y = 60;
    		
    		mob_min_range = 80;
    		mob_max_range = 80;
    	}else if (id == 2) {
    		{
    			this.weapon3true = true;
    			this.w3can_cooldown = true;
        		this.weapon3key = 0;
        		this.w3name = "20mmMC";
        		this.ammo3 = 4;
        		this.magazine3 = 10;
        		this.reload_time3 = 60;
        		this.reloadsoundset3 = 40;
        		this.reloadsound3 = GVCSoundEvent.reload_mg;
        		this.w3cycle = 1;
        		this.w3barst = 1;
        		this.weapon3 = 1;
        		{
        			this.bullet_type3[0] = 7;
            		this.bullet_model3[0] = "gvclib:textures/entity/BulletNormal.mqo";
            		this.bullet_tex3[0] = "gvclib:textures/entity/BulletNormal.png";
            		this.fire_model3[0]= "gvclib:textures/entity/mflash.mqo";
            		this.fire_tex3[0] = "gvclib:textures/entity/mflash.png";
            		this.fire_time3[0] = 2;
            		this.sound_fire3[0] = "gvclib.fire_mg";
            		this.fire_pointx3[0] = 0.0F;
					this.fire_pointy3[0] = 2.8F;
					this.fire_pointz3[0] = -1.5F;
					this.basis_pointx3[0] = 0.0F;
	        		this.basis_pointy3[0] = 2.8F;
	        		this.basis_pointz3[0] = -1.5F;
	        		this.arm_x[0] = 0.0F;
	        		this.arm_z[0] = -1.5F;
					this.fire_yoffset3[0] = 0;
					this.rotationfollowing3[0] = false;
					this.rotationfirepoint3[0] = false;
					this.rotation_mob_head3[0] = false;
					this.rotation_firepointbxbz3[0] = true;
					this.rotation_player3[0] = true;
            		this.bullet_damage3[0] = 8;
            		this.bullet_speed3[0] = 8.0F;
            		this.bullet_bure3[0] = 1.0F;
            		this.bullet_expower3[0] = 1F;
            		this.bullet_ex3[0] = false;
            		this.bullet_kazu3[0] = 1;
            		this.bullet_gravity3[0] = 0.0299D;
            		this.bullet_livingtime3[0] = 80;
            		
        		}
    		}
    		
    		this.mob_w3range = 60;
    		this.mob_w3range_max_y = 50;
    		this.mob_w3range_min_y = 2;
    		
    		mob_min_range = 80;
    		mob_max_range = 80;
    	}else if (id == 3) {
    		{
    			this.weapon3true = true;
        		this.weapon3key = 0;
        		this.w3name = "Rocket";
        		this.ammo3 = 15;
        		this.magazine3 = 8;
        		this.reload_time3 = 120;
        		this.reloadsoundset3 = 20;
        		this.reloadsound3 = GVCSoundEvent.reload_shell;
        		this.w3cycle = 1;
        		this.w3barst = 1;
        		this.weapon3 = 1;
        		{
        			this.bullet_type3[0] = 13;
            		this.bullet_model3[0] = "gvclib:textures/entity/new/bullet_rocket_big.mqo";
            		this.bullet_tex3[0] = "gvclib:textures/entity/new/bullet_rocket_big.png";
            		this.fire_model3[0]= "gvclib:textures/entity/msmoke.mqo";
            		this.fire_tex3[0] = "gvclib:textures/entity/msmoke.png";
            		this.fire_time3[0] = 16;
            		this.sound_fire3[0] = "gvclib.fire_missile";
            		this.fire_pointx3[0] = 0.0F;
					this.fire_pointy3[0] = 2.8F;
					this.fire_pointz3[0] = -1.5F;
					this.basis_pointx3[0] = 0.0F;
	        		this.basis_pointy3[0] = 2.8F;
	        		this.basis_pointz3[0] = -1.5F;
	        		this.arm_x[0] = 0.0F;
	        		this.arm_z[0] = -1.5F;
					this.fire_yoffset3[0] = 0;
					this.rotationfollowing3[0] = false;
					this.rotationfirepoint3[0] = false;
					this.rotation_mob_head3[0] = false;
					this.rotation_firepointbxbz3[0] = true;
					this.rotation_player3[0] = true;
            		this.bullet_damage3[0] = 8;
            		this.bullet_speed3[0] = 4.0F;
            		this.bullet_bure3[0] = 5.0F;
            		this.bullet_expower3[0] = 2.0F;
            		this.bullet_ex3[0] = mod_GVCR2.cfg_exprotion_grenade;
            		this.bullet_kazu3[0] = 1;
            		this.bullet_gravity3[0] = 0.029D;
            		this.bullet_livingtime3[0] = 80;
            		
        		}
    		}
    		
    		this.mob_w3range = 100;
    		this.mob_w3range_max_y = 60;
    		this.mob_w3range_min_y = 60;
    		
    		mob_min_range = 80;
    		mob_max_range = 80;
    	}else if (id == 4) {
    		this.riddng_maximum = 1;
    	}
    	else {
    		{
				this.weapon3true = true;
				this.weapon3key = 0;
				this.weapon3key = 0;
				this.ammo3 = 3;
				this.magazine3 = 15;
				reload_time3 = 60;
				this.w3name = "MachineGun";
				this.w3cycle = 1;
				this.w3barst = 1;
				this.weapon3 = 1;
				{
					this.bullet_type3[0] = 0;
					this.bullet_model3[0] = "gvclib:textures/entity/BulletNormal.obj";
					this.bullet_tex3[0] = "gvclib:textures/entity/BulletNormal.png";
					this.fire_model3[0] = "gvclib:textures/entity/mflash.mqo";
					this.fire_tex3[0] = "gvclib:textures/entity/mflash.png";
					this.fire_time3[0] = 2;
					this.sound_fire3[0] = "gvclib.fire_rifle";
					this.fire_pointx3[0] = 0.0F;
					this.fire_pointy3[0] = 2.8F;
					this.fire_pointz3[0] = 0.0F;
					this.basis_pointx3[0] = 0.0F;
	        		this.basis_pointy3[0] = 2.8F;
	        		this.basis_pointz3[0] = -1.5F;
	        		this.arm_x[0] = 0.0F;
	        		this.arm_z[0] = -1.5F;
					this.fire_yoffset3[0] = 0;
					this.rotationfollowing3[0] = false;
					this.rotationfirepoint3[0] = false;
					this.rotation_mob_head3[0] = false;
					this.rotation_firepointbxbz3[0] = true;
					this.rotation_player3[0] = true;
					this.bullet_damage3[0] = 4;
					this.bullet_speed3[0] = 4F;
					this.bullet_bure3[0] = 5.0F;
					this.bullet_expower3[0] = 0F;
					this.bullet_ex3[0] = false;
					this.bullet_kazu3[0] = 1;
					this.bullet_gravity3[0] = 0.029D;
					this.bullet_livingtime3[0] = 80;

				}
				this.mob_w3range = 40;
				this.mob_w3range_max_y = 30;
				this.mob_w3range_min_y = 30;
				
				mob_min_range = 20;
				mob_max_range = 50;
			}
    	}
    }
    
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		float f1 = this.rotationYawHead * (2 * (float) Math.PI / 360);
		this.roadattack();
		this.typecar();
		this.CNT_MobRidding();
		
		this.ContMobRidding();
		
		this.setWeapon(this.getArmID_L() );
		
		
		if(this.getPassengers().size() > 1)
        {
        	 if(this.getPassengers().get(1) != null){
     			if (this.getPassengers().get(1) instanceof EntityPlayer) {
     			}else
     			if (this.getPassengers().get(1) instanceof EntityGVCLivingBase) {
     				EntityGVCLivingBase entitylivingbase = (EntityGVCLivingBase)this.getPassengers().get(1);
     				if(entitylivingbase.getattacktask()) {
     					this.CNT_MobRidding_getHead(entitylivingbase, this.mob_w3range_max_y);
     				}
     				this.rotation_3  = entitylivingbase.rotationYawHead;
     				this.rotationp_3 = entitylivingbase.rotationPitch;
     				Vec3d looked = entitylivingbase.getLookVec();
     				AI_GetTarget_OnRidding.load(entitylivingbase, this.mob_w3range, this.mob_w3range_max_y, this.mob_w3range_min_y, this.rotationYaw, 180, 180);
     				if(AI_GetTarget_OnRidding.getRange(entitylivingbase, this.mob_w3range, this.mob_w3range_max_y, this.mob_w3range_min_y, this.rotationYaw, 180, 180)){
     					if(cooltime3 >= ammo3 && this.getRemain_A() > 0){
     						this.counter3 = true;
     			            cooltime3 = 0;
     					}
     					if(this.weapon3true) {
     	    		    	this.weapon3activeMob(looked, entitylivingbase, 0);
     	    		    }
     				}
     			}
     			/*else if (this.getPassengers().get(2) instanceof EntityLivingBase) {
     				EntityLivingBase entitylivingbase = (EntityLivingBase)this.getPassengers().get(2);
     				Vec3d looked = entitylivingbase.getLookVec();
     				if(AI_GetTarget_OnRidding.load_LivingBase(entitylivingbase, this, 3, this.mob_w3range, this.mob_w3range_max_y, this.mob_w3range_min_y, this.rotationYaw, 180, 180))
     				{
     					if(cooltime3 >= ammo3 && this.getRemain_A() > 0){
     						this.counter3 = true;
     			            cooltime3 = 0;
     					}
     					if(this.weapon3true) {
     	    		    	this.weapon3activeMob(looked, this, 0);
     	    		    }
         				entitylivingbase.rotationYawHead = this.rotation_3;
         				entitylivingbase.rotationPitch = this.rotationp_3;
     				}
     			}*/
     		}else {
     			this.rotation_3  = this.rotationYawHead;
 				this.rotationp_3 = this.rotationPitch;
     		}
        }
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
			 if (this.getArmID_L() == 4) {
				 GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 6, true,  true);
			 }else {
				 GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 2, false,  false);
			 }
		}
		if (this.deathTicks == 200 && !this.world.isRemote) {
			this.setDead();
		}
	}
    
    public boolean getCanSpawnHere() {
		return this.getLevel() >= 1 && this.getCanSpawnUnderGround() && this.getCanSpawnDimension() && super.getCanSpawnHere();
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
				int ra = this.world.rand.nextInt(8) + 3;
				for(int x = 0; x < ra; ++x) {
					this.entityDropItem(new ItemStack(Items.IRON_INGOT), 0.0F);
				}
			}else {
				int ra = this.world.rand.nextInt(10) + 4;
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
       // if(!this.world.isRemote)
        {
        	EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(this.world);
	        entityskeleton.setLocationAndAngles(this.posX+0.5, this.posY, this.posZ+0.5, 0, 0.0F);
	        entityskeleton.onInitialSpawn(difficulty, (IEntityLivingData)null);
	        this.world.spawnEntity(entityskeleton);
	        entityskeleton.startRiding(this);
        }
        {
        	EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(this.world);
	        entityskeleton.setLocationAndAngles(this.posX+0.5, this.posY, this.posZ+0.5, 0, 0.0F);
	        entityskeleton.onInitialSpawn(difficulty, (IEntityLivingData)null);
	        this.world.spawnEntity(entityskeleton);
	        entityskeleton.startRiding(this);
        }
        {
        	EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(this.world);
	        entityskeleton.setLocationAndAngles(this.posX+0.5, this.posY, this.posZ+0.5, 0, 0.0F);
	        entityskeleton.onInitialSpawn(difficulty, (IEntityLivingData)null);
	        this.world.spawnEntity(entityskeleton);
	        entityskeleton.startRiding(this);
        }
        return livingdata;
    }
}
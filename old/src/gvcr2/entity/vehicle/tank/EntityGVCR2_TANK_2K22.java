package gvcr2.entity.vehicle.tank;

import javax.annotation.Nullable;

import gvclib.mod_GVCLib;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.vehicle.VehicleBase;
import gvcr2.event.level.GVCR2WorldDifficultyLevel;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldProviderSurface;

public class EntityGVCR2_TANK_2K22 extends EntityMobVehicleBase
{
    public EntityGVCR2_TANK_2K22(World worldIn)
    {
        super(worldIn);
        this.setSize(3.5F, 2.6F);
        ridding_roteangle = mod_GVCR2.cfg_vehicle_angle;
        this.render_hud_icon = false;
        this.hud_icon = "gvclib:textures/hud/tank.png";
        this.render_hud_scope = true;
        this.hud_icon_scope = "gvcr2:textures/misc/scope_tank.png";
        this.render_hud_scope_zoom = true;
        this.hud_icon_scope_zoom = "gvcr2:textures/misc/scope_tank_t34.png";
        
        //this.render_hud_information_6 = "X-KEY:WeaponChange";

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_tank_2k22;
        
        this.aarader = true;
        
        this.sp = 0.035F;
        this.turnspeed = 2.0F;
        this.rotationp_max = -90F;
        this.rotationp_min = 5F;
		this.ridding_invisible = false;
		this.riddng_opentop = false;
		this.renderhud = true;
        this.thmax = 5F;
		this.thmin = -2F;
		this.thmaxa = 0.2F;
		this.thmina = -0.15F;
		this.stepHeight = 1.5F;
		riddingx[0] = -0.2;
		riddingy[0] = 1.9;
		riddingz[0] = 0.4;
		
		this.ridding_view1_x = 0.2F;
		this.ridding_view1_y = 0.0F;
		this.ridding_view1_z = 0.0F;
		
		this.can_turret = true;
		this.turret_height = 1.8F;
	    this.damage_front = 20;
	    this.damage_side = 20;
	    this.damage_rear = 20;
	    this.damage_top = 10;
	    this.damage_bottom = 10;
	    
	    this.damage_turret_front = 20;
	    this.damage_turret_side = 20;
	    this.damage_turret_rear = 20;
		
		antibullet_0 = 0.0F;
		antibullet_1 = 0.2F;
		antibullet_2 = 0.8F;
		antibullet_3 = 1.0F;
		this.ridding_damege = 0.25F;
		
		this.roodbreak = mod_GVCR2.cfg_movebreak;
		
		{
			cloud = 2;
			cloud_x[0] = 0.60D;
			cloud_x[1] = 0.5D;
			cloud_y[0] = cloud_y[1] = 1.8D;
			cloud_z[0] = cloud_z[1] = -2.2D;
		}
		
		mob_min_range = 80;
		mob_max_range = 120;
		
		{
			this.weapon1true = true;
			this.w1can_cooldown = true;
    		this.weapon1key = 0;
    		this.w1name = "30mmMC";
    		this.ammo1 = 1;
    		this.magazine = 20;
    		this.reload_time1 = 60;
    		this.reloadsoundset1 = 40;
    		this.reloadsound1 = GVCSoundEvent.reload_mg;
    		this.w1cycle = 1;
    		this.w1barst = 1;
    		this.weapon1 = 2;
    		this.w1crossfire = true;
    		for(int x = 0; x < 2; ++x){
    			this.bullet_type1[x] = 7;
        		this.bullet_model1[x] = "gvclib:textures/entity/BulletNormal.mqo";
        		this.bullet_tex1[x] = "gvclib:textures/entity/BulletNormal.png";
        		this.fire_model1[x]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex1[x] = "gvclib:textures/entity/mflash.png";
        		this.fire_time1[x] = 2;
        		this.sound_fire1[x] = "gvclib.fire_mg";
        		this.fire_pointx1[0] = -0.85F;
        		this.fire_pointx1[1] = 0.85F;
        		this.fire_pointy1[x] = 2.35F;
        		this.fire_pointz1[x] = 2.0F;
        		this.basis_pointx1[x] = 0.0F;
        		this.basis_pointy1[x] = 2.35F;
        		this.basis_pointz1[x] = -0.35F;
        		this.fire_yoffset1[x] = 0;
        		this.rotationfollowing1[x] = true;
        		this.rotationfirepoint1[x] = false;
        		this.rotation_player1[x] = true;
        		this.bullet_damage1[x] = 12;
        		this.bullet_speed1[x] = 8.0F;
        		this.bullet_bure1[x] = 1.0F;
        		this.bullet_expower1[x] = 1F;
        		this.bullet_ex1[x] = false;
        		this.bullet_kazu1[x] = 1;
        		this.bullet_gravity1[x] = 0.0299D;
        		this.bullet_livingtime1[x] = 80;
        		
    		}
		}
		this.mob_w1range = 120;
		this.mob_w1range_max_y = 80;
		this.mob_w1range_min_y = 2;
		
		
		this.weapon2true = true;
		this.w2name = "SAM(IR)";
		this.ammo2 = 10;
		this.magazine2 = 8;
		this.reload_time2 = 70;
		this.w2cycle = 1;
		this.w2barst = 1;
		this.weapon2 = 1;
		this.w2crossfire = true;
		{
			this.bullet_type2[0] = 4;
			this.bullet_model2[0] = "gvclib:textures/entity/model/bullet_missile.mqo";
			this.bullet_tex2[0] = "gvclib:textures/entity/model/bullet_missile.png";
			this.fire_model2[0] = "gvclib:textures/entity/mflash.mqo";
			this.fire_tex2[0] = "gvclib:textures/entity/mflash.png";
			this.fire_time2[0] = 4;
			this.sound_fire2[0] = "gvclib.fire_missile";
			this.fire_pointx2[0] = 1.2F;
			this.fire_pointy2[0] = 2.25F;
			this.fire_pointz2[0] = 2.0F;
			this.basis_pointx2[0] = 0.0F;
    		this.basis_pointy2[0] = 2.35F;
    		this.basis_pointz2[0] = -0.35F;
			this.fire_yoffset2[0] = 0;
			this.rotationfollowing2[0] = true;
    		this.rotation_player2[0] = true;
    		this.rotationfirepoint2[0] = false;
			this.bullet_damage2[0] = 40;
			this.bullet_speed2[0] = 4F;
			this.bullet_bure2[0] = 1.0F;
			this.bullet_expower2[0] = 2F;
			this.bullet_ex2[0] = false;
			this.bullet_kazu2[0] = 1;
			this.bullet_gravity2[0] = 0.029D;
			this.bullet_livingtime2[0] = 800;
			this.missile_targeting_time_start2[0] = 5;
    		this.missile_targeting_time_end2[0] = 90;
		}
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    public void weapon_bay() {
    	
    }
    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		this.roadattack();
		this.typeTank();
		this.weapon_bay();
		
		VehicleBase.roadattack_barbed(this);
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
		return this.getLevel() >= 6 && this.getCanSpawnUnderGround() && this.getCanSpawnDimension() && super.getCanSpawnHere();
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
				int ra = this.world.rand.nextInt(18) + 4;
				for(int x = 0; x < ra; ++x) {
					this.entityDropItem(new ItemStack(Items.IRON_INGOT), 0.0F);
				}
			}else {
				int ra = this.world.rand.nextInt(40) + 8;
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
      return livingdata;
  }
}
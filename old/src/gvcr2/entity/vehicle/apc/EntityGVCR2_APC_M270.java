package gvcr2.entity.vehicle.apc;

import javax.annotation.Nullable;

import gvclib.mod_GVCLib;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.cnt.VehicleCNT_Tank_SPG;
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

public class EntityGVCR2_APC_M270 extends EntityMobVehicleBase
{
    public EntityGVCR2_APC_M270(World worldIn)
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
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_apc_m270;
        
        this.aarader = true;
        this.renderhud = true;
        
        this.sp = 0.045F;
        this.turnspeed = 3.0F;
        this.rotationp_max = -90F;
        this.rotationp_min = 20F;
		this.ridding_invisible = false;
		this.riddng_opentop = false;
		ridding_roteplayer = false;
        this.thmax = 5F;
		this.thmin = -2F;
		this.thmaxa = 0.2F;
		this.thmina = -0.15F;
		this.stepHeight = 1.5F;
		riddingx[0] = -0.7;
		riddingy[0] = 1.9;
		riddingz[0] = 1.85;
		
		this.ridding_view1_x = 0.0F;
		this.ridding_view1_y = 0.0F;
		this.ridding_view1_z = 0.4F;
		
		
		antibullet_0 = 0.0F;
		antibullet_1 = 0.5F;
		antibullet_2 = 1.0F;
		antibullet_3 = 1.1F;
		this.ridding_damege = 0.25F;
		
		this.roodbreak = mod_GVCR2.cfg_movebreak;
		
		mob_attackrange_hight = true;
		mob_min_range = 110;
		mob_max_range = 110;
		
		
		this.mob_w1range = 110;
		this.mob_w1range_max_y = 80;
		this.mob_w1range_min_y = 10;
		
		
		
		this.weapon1true = true;
		this.w1name = "227mmRocket";
		this.ammo1 = 10;
		this.magazine = 12;
		this.reload_time1 = 200;
		this.w1cycle = 1;
		this.w1barst = 1;
		this.weapon1 = 1;
		this.w1crossfire = true;
		{
			this.bullet_type1[0] = 11;
    		this.bullet_model1[0] = "gvclib:textures/entity/bulletrocket.mqo";
    		this.bullet_tex1[0] = "gvclib:textures/entity/bulletrocket.png";
    		this.fire_model1[0]= "gvclib:textures/entity/msmoke.mqo";
    		this.fire_tex1[0] = "gvclib:textures/entity/msmoke.png";
    		this.fire_time1[0] = 16;
    		this.sound_fire1[0] = "gvclib.fire_grenade";
    		this.fire_pointx1[0] = 0;
    		this.fire_pointy1[0] = 2.3F;
    		this.fire_pointz1[0] = -1.5F;
    		this.basis_pointx1[0] = 0;
    		this.basis_pointy1[0] = 2.3F;
    		this.basis_pointz1[0] = -1.5F;
    		this.fire_yoffset1[0] = 0;
    		this.rotationfollowing1[0] = true;
    		this.rotationfirepoint1[0] = false;
    		this.rotation_player1[0] = true;
    		this.bullet_damage1[0] = 30;
    		this.bullet_speed1[0] = 4.0F;
    		this.bullet_bure1[0] = 1.0F;
    		this.bullet_expower1[0] = 2.0F;
    		this.bullet_ex1[0] = false;
    		this.bullet_kazu1[0] = 1;
    		this.bullet_gravity1[0] = 0.00D;
    		this.bullet_livingtime1[0] = 80;
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
		VehicleBase.roadattack_barbed(this);
		VehicleCNT_Tank_SPG.load(this, GVCSoundEvent.sound_tank);
		this.weapon_bay();
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
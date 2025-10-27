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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldProviderSurface;

public class EntityGVCR2_TANK_T55 extends EntityMobVehicleBase
{
    public EntityGVCR2_TANK_T55(World worldIn)
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
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_tank_t55;
        
        this.sp = 0.035F;
        this.turnspeed = 2.0F;
        this.rotationp_max = -30F;
        this.rotationp_min = 5F;
		this.ridding_invisible = false;
		this.riddng_opentop = false;
        this.thmax = 5F;
		this.thmin = -2F;
		this.thmaxa = 0.4F;
		this.thmina = -0.4F;
		this.stepHeight = 1.5F;
		riddingx[0] = -0.4;
		riddingy[0] = 1.65;
		riddingz[0] = -0.3;
		
		this.ridding_view1_x = -0.4F;
		this.ridding_view1_y = 0.6F;
		this.ridding_view1_z = 0.8F;
		
		this.can_turret = true;
		this.turret_height = 1.5F;
	    this.damage_front = 50;
	    this.damage_side = 30;
	    this.damage_rear = 20;
	    this.damage_top = 10;
	    this.damage_bottom = 10;
	    
	    this.damage_turret_front = 50;
	    this.damage_turret_side = 30;
	    this.damage_turret_rear = 30;
		
		antibullet_0 = 0.0F;
		antibullet_1 = 0.2F;
		antibullet_2 = 0.8F;
		antibullet_3 = 1.0F;
		this.ridding_damege = 0.25F;
		
		this.roodbreak = mod_GVCR2.cfg_movebreak;
		
		{
			cloud = 2;
			cloud_x[0] = 0.5D;
			cloud_x[1] = -0.5D;
			cloud_y[0] = cloud_y[1] = 1D;
			cloud_z[0] = cloud_z[1] = -3.2D;
		}
		
		mob_min_range = 20;
		mob_max_range = 60;
		
		/*{
			this.weapon1true = true;
    		this.weapon1key = 0;
    		this.w1name = "100mm Cannon";
    		this.ammo1 = 10;
    		this.magazine = 1;
    		this.reload_time1 = 60;
    		this.reloadsoundset1 = 20;
    		this.reloadsound1 = GVCSoundEvent.reload_cannon;
    		this.w1cycle = 1;
    		this.w1barst = 1;
    		this.weapon1 = 1;
    		{
    			this.bullet_type1[0] = 3;
        		this.bullet_model1[0] = "gvclib:textures/entity/bulletcannon.mqo";
        		this.bullet_tex1[0] = "gvclib:textures/entity/bulletcannon.png";
        		this.fire_model1[0]= "gvclib:textures/entity/msmoke.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/msmoke.png";
        		this.fire_time1[0] = 16;
        		this.sound_fire1[0] = "gvclib.fire_cannon2";
        		this.fire_pointx1[0] = 0;
        		this.fire_pointy1[0] = 2.0F;
        		this.fire_pointz1[0] = 4.0F;
        		this.basis_pointx1[0] = 0;
        		this.basis_pointy1[0] = 2.0F;
        		this.basis_pointz1[0] = 1.2F;
        		this.fire_yoffset1[0] = -0.03;
        		this.rotationfollowing1[0] = true;
        		this.rotationfirepoint1[0] = true;
        		this.rotation_player1[0] = true;
        		this.bullet_damage1[0] = 50;
        		this.bullet_speed1[0] = 2.4F;
        		this.bullet_bure1[0] = 0.5F;
        		this.bullet_expower1[0] = 3.5F;
        		this.bullet_ex1[0] = mod_GVCR2.cfg_exprotion_player;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.025D;
        		this.bullet_livingtime1[0] = 80;
        		
    		}
		}*/
		this.mob_w1range = 50;
		this.mob_w1range_max_y = 15;
		this.mob_w1range_min_y = 2;
		
		
		{
			this.weapon2true = true;
			this.w2can_cooldown = true;
    		this.weapon2key = 2;
    		this.w2name = "MachineGun";
    		this.ammo2 = 2;
    		this.magazine2 = 20;
    		this.reload_time2 = 80;
    		this.reloadsoundset2 = 40;
    		this.reloadsound2 = GVCSoundEvent.reload_mg;
    		this.w2cycle = 1;
    		this.w2barst = 1;
    		this.weapon2 = 1;
    		{
    			this.bullet_type2[0] = 0;
        		this.bullet_model2[0] = "gvclib:textures/entity/BulletNormal.obj";
        		this.bullet_tex2[0] = "gvclib:textures/entity/BulletNormal.png";
        		this.fire_model2[0]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex2[0] = "gvclib:textures/entity/mflash.png";
        		this.fire_time2[0] = 5;
        		this.sound_fire2[0] = "gvclib.fire_mg";
        		this.fire_pointx2[0] = -0.4F;
        		this.fire_pointy2[0] = 2.0F;
        		this.fire_pointz2[0] = 1.2F;
        		this.fire_yoffset2[0] = -0.03;
        		this.rotationfollowing2[0] = true;
        		this.rotationfirepoint2[0] = true;
        		this.bullet_damage2[0] = 5;
        		this.bullet_speed2[0] = 4F;
        		this.bullet_bure2[0] = 1.0F;
        		this.bullet_expower2[0] = 0;
        		this.bullet_ex2[0] = false;
        		this.bullet_kazu2[0] = 1;
        		this.bullet_gravity2[0] = 0.029D;
        		this.bullet_livingtime2[0] = 80;
        		
    		}
		}
		this.mob_w2range = 15;
		this.mob_w2range_max_y = 15;
		this.mob_w2range_min_y = 2;
		
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    public void weapon_bay() {
    	this.weapon1true = true;
		this.weapon1key = 0;
		this.ammo1 = 10;
		this.magazine = 1;
		this.reload_time1 = 80;
		this.reloadsoundset1 = 20;
		this.reloadsound1 = GVCSoundEvent.reload_cannon;
		this.w1cycle = 1;
		this.w1barst = 1;
		this.weapon1 = 1;
		{
			this.bullet_type1[0] = 3;
			this.bullet_model1[0] = "gvclib:textures/entity/model/bullet_cannon_small.mqo";
    		this.bullet_tex1[0] = "gvclib:textures/entity/model/bullet_cannon_small.png";
    		this.fire_model1[0]= "gvclib:textures/entity/msmoke.mqo";
    		this.fire_tex1[0] = "gvclib:textures/entity/msmoke.png";
    		this.fire_time1[0] = 16;
    		this.sound_fire1[0] = "gvclib.fire_cannon2";
    		this.fire_pointy1[0] = 2.0F;
    		this.fire_pointz1[0] = 4.0F;
    		this.basis_pointx1[0] = 0;
    		this.basis_pointy1[0] = 2.0F;
    		this.basis_pointz1[0] = 1.2F;
    		this.fire_yoffset1[0] = -0.03;
    		this.rotationfollowing1[0] = true;
    		this.rotationfirepoint1[0] = true;
    		this.rotation_player1[0] = true;
		}
    	if(this.getArmID_R() == 0) {
    		this.bullet_type1[0] = 3;
    		this.w1name = "100mm AP";
			this.bullet_damage1[0] = 50;
			this.bullet_speed1[0] = 4F;
			this.bullet_bure1[0] = 0.5F;
			this.bullet_expower1[0] = 2.5F;
			this.bullet_ex1[0] = mod_GVCR2.cfg_exprotion_player;
			this.bullet_kazu1[0] = 1;
			this.bullet_gravity1[0] = 0.025D;
			this.bullet_livingtime1[0] = 80;
    	}
    	else if(this.getArmID_R() == 1) {
    		this.bullet_type1[0] = 2;
			this.w1name = "100mm HE";
			this.bullet_damage1[0] = 30;
			this.bullet_speed1[0] = 3.0F;
			this.bullet_bure1[0] = 0.5F;
			this.bullet_expower1[0] = 3.0F;
			this.bullet_ex1[0] = mod_GVCR2.cfg_exprotion_player;
			this.bullet_kazu1[0] = 1;
			this.bullet_gravity1[0] = 0.025D;
			this.bullet_livingtime1[0] = 80;
    	}
    	{
			boolean kx = mod_GVCLib.proxy.keyx();
			if (kx) {
				GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(14, this.getEntityId()));
			}
			if (this.serverx) {
				if (this.cooltime3 > 5) {
					if(this.getArmID_R() == 0){
						this.setArmID_R(1);
					}
					/*else if(this.getArmID_R() == 1){
						this.setArmID_R(2);
					}*/
					else
					{
						this.setArmID_R(0);
					}
					this.cooltime3 = 0;
					this.playSound(GVCSoundEvent.reload_shell, 1.0F, 1.0F);
				}
				{
					this.serverx = false;
				}
			}
		}
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
  		if(this.getMasterID() == 1) {
  			{
  				int ra = this.world.rand.nextInt(5) + 2;
				for(int x = 0; x < ra; ++x) {
					this.entityDropItem(new ItemStack(Blocks.IRON_BLOCK), 0.0F);
				}
  			}
  			{
  				int ra = this.world.rand.nextInt(2) + 1;
				for(int x = 0; x < ra; ++x) {
					this.entityDropItem(new ItemStack(Blocks.REDSTONE_BLOCK), 0.0F);
				}
  			}
  			{
  				int ra = this.world.rand.nextInt(3) + 2;
				for(int x = 0; x < ra; ++x) {
					this.entityDropItem(new ItemStack(Blocks.EMERALD_BLOCK), 0.0F);
				}
  			}
  			
			
  		}
  		else {
  			int ran = this.world.rand.nextInt(3);
  	  		if(ran == 0){
  					int ra = this.world.rand.nextInt(20) + 6;
  					for(int x = 0; x < ra; ++x) {
  						this.entityDropItem(new ItemStack(Items.IRON_INGOT), 0.0F);
  					}
  				}else {
  					int ra = this.world.rand.nextInt(20) + 6;
  					for(int x = 0; x < ra; ++x) {
  						this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_item_scrap), 0.0F);
  					}
  				}
  	  		{
  				int ra = this.world.rand.nextInt(20) + 4;
  				for(int x = 0; x < ra; ++x) {
  					this.entityDropItem(new ItemStack(Items.REDSTONE), 0.0F);
  				}
  			}
  		}
  	}
  }
  
  @Nullable
  public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
  {
      livingdata = super.onInitialSpawn(difficulty, livingdata);
      this.setMasterID(1);
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
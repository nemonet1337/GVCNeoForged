package gvcr2.entity.vehicle.heli;

import java.util.List;

import javax.annotation.Nullable;

import gvclib.mod_GVCLib;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.ISoldier;
import gvclib.entity.living.cnt.VehicleCNT_Heli;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.event.level.GVCR2WorldDifficultyLevel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
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

public class EntityGVCR2_HELI_MI24D extends EntityMobVehicleBase
{
    public EntityGVCR2_HELI_MI24D(World worldIn)
    {
        super(worldIn);
        this.setSize(7.0F, 5.0F);
        this.ridding_sneakdismount = false;
        this.riddng_freehand = true;
        this.hud_icon = "gvcr2:textures/hud/heli.png";
        this.render_hud_icon_hori = true;
        this.hud_icon_hori = "gvcr2:textures/hud/heli_hori.png";
        this.render_hud_information_1 = "Z-KEY:Get off";
        this.render_hud_information_2 = "W/S-KEY:Throttle-UP/DWON";
        this.render_hud_information_3 = "SPEAC/SHIFT-KEY:UP/DWON";
        this.render_hud_information_4 = "Mouse-UP/DOWN:PICTH-UP/DOWN";
        this.render_hud_information_5 = "G-KEY:Hovering_MODE";
        this.render_hud_information_6 = "X-KEY:WeaponChange";
        vehicletype = 2;
        ridding_roteplayer = false;

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_heli_mi24d;
        
        this.sp = 0.03F;
        this.turnspeed = 3F;
        this.rotationp_max = -30F;
        this.rotationp_min = 45F;
		this.ridding_invisible = false;
		this.riddng_opentop = true;
		this.renderhud = true;
        this.thmax = 20F;
		this.thmin = -2F;
		this.thmaxa = 0.2F;
		this.thmina = -0.15F;
		this.stepHeight = 1.5F;
		this.riddng_maximum = 3;
		riddingx[0]=0D;
		riddingy[0]=1.0D;
		riddingz[0]=2.2D;
		{
			riddingx[1]=0.4D;
			riddingy[1]=0.8D;
			riddingz[1]=0.41D;
			
			riddingx[2]=-0.4D;
			riddingy[2]=0.8D;
			riddingz[2]=0.41D;
		}
		ridding_view_x=0F;
		ridding_view_y=-3F;
		ridding_view_z=-10F;
		ridding_view_gunner_x=0F;
		ridding_view_gunner_y=2F;
		ridding_view_gunner_z=1F;
		
		antibullet_0 = 0.5F;
		antibullet_1 = 1.0F;
		antibullet_2 = 2.0F;
		antibullet_3 = 1.5F;
		this.ridding_damege = 0.25F;
		
		this.roodbreak = mod_GVCR2.cfg_movebreak;
		
		this.weapon1_auto_reload = true;
		this.weapon2_auto_reload = true;
		
		{
			pera = 2;
			pera_x[0] = 0F;
			pera_y[0] = 3F;
			pera_z[0] = 0F;
			perarote_x[0] = 0F;
			perarote_y[0] = 1F;
			perarote_z[0] = 0F;
			pera_x[1] = 0F;
			pera_y[1] = 2.263F;
			pera_z[1] = -4.95F;
			perarote_x[1] = 1F;
			perarote_y[1] = 0F;
			perarote_z[1] = 0F;
		}
		
		aitypemax = 120;
		mob_min_range = 80;
		mob_max_range = 100;
		
		mob_min_height = 15;
		
		this.weapon1type = 1;
		{
			this.weapon1true = true;
    		this.weapon1key = 0;
    		this.w1name = "76mmRocket";
    		this.ammo1 = 4;
    		this.magazine = 4;
    		this.reload_time1 = 60;
    		this.reloadsoundset1 = 40;
    		this.reloadsound1 = GVCSoundEvent.reload_cannon;
    		this.w1cycle = 1;
    		this.w1barst = 1;
    		this.weapon2 = 1;
    		this.w1crossfire = true;
    			this.bullet_type1[0] = 3;
    			this.bullet_model1[0] = "gvclib:textures/entity/new/bullet_rocket_big.mqo";
        		this.bullet_tex1[0] = "gvclib:textures/entity/new/bullet_rocket_big.png";
        		this.fire_model1[0]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/mflash.png";
        		this.fire_time1[0] = 5;
        		this.sound_fire1[0] = "gvclib.fire_roket";
        		this.fire_pointx1[0] = 2.3F;
        		this.fire_pointy1[0] = 1.0F;
        		this.fire_pointz1[0] = 0.5F;
        		this.basis_pointx1[0] = 2.3F;
        		this.basis_pointy1[0] = 0.6F;
        		this.basis_pointz1[0] = 0F;
        		this.fire_yoffset1[0] = 0;
        		this.rotationfollowing1[0] = false;
        		this.rotationfirepoint1[0] = false;
        		this.bullet_damage1[0] = 16;
        		this.bullet_speed1[0] = 2F;
        		this.bullet_bure1[0] = 1.0F;
        		this.bullet_expower1[0] = 2;
        		this.bullet_ex1[0] = mod_GVCR2.cfg_exprotion_player;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.029D;
        		this.bullet_livingtime1[0] = 80;
		}
		this.mob_w1range = 100;
		this.mob_w1range_max_y = 10;
		this.mob_w1range_min_y = 60;
		
		{
			this.weapon2true = true;
    		this.weapon2key = 0;
    		this.w2name = "12.7mmMG";
    		this.ammo2 = 2;
    		this.magazine2 = 60;
    		this.reload_time2 = 60;
    		this.reloadsoundset2 = 40;
    		this.reloadsound1 = GVCSoundEvent.reload_mg;
    		this.w2cycle = 1;
    		this.w2barst = 1;
    		this.weapon1 = 1;
    		{
    			this.bullet_type2[0] = 1;
        		this.bullet_model2[0] = "gvclib:textures/entity/BulletNormal.obj";
        		this.bullet_tex2[0] = "gvclib:textures/entity/BulletNormal.png";
        		this.fire_model2[0]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex2[0] = "gvclib:textures/entity/mflash.png";
        		this.fire_time2[0] = 5;
        		this.sound_fire2[0] = "gvclib.fire_mg";
        		this.fire_pointx2[0] = 0.0F;
    			this.basis_pointx2[0] = 0.0F;
        		this.fire_pointy2[0] = 0.4F;
        		this.fire_pointz2[0] = 3.0F;
        		this.basis_pointy2[0] = 1.0F;
        		this.basis_pointz2[0] = 0.0F;
        		this.fire_yoffset2[0] = 0;
        		this.rotationfollowing2[0] = true;
        		this.rotationfirepoint2[0] = true;
        		this.rotation_player2[0] = true;
        		this.rotation_firepointbxbz2[0] = true;
        		this.arm_x[0] = 0.0F;
        		this.arm_z[0] = 2.9F;
        		this.bullet_damage2[0] = 5;
        		this.bullet_speed2[0] = 4.0F;
        		this.bullet_bure2[0] = 1F;
        		this.bullet_expower2[0] = -1F;
        		this.bullet_ex2[0] = false;
        		this.bullet_kazu2[0] = 1;
        		this.bullet_gravity2[0] = 0.029D;
        		this.bullet_livingtime2[0] = 80;
    		}
		}
		
		this.mob_w2range = 100;
		this.mob_w2range_max_y = 10;
		this.mob_w2range_min_y = 60;
		
		this.weapon4type = 1;
		{
			this.weapon4true = true;
    		this.weapon4key = 0;
    		this.w4name = "Flare";
    		this.ammo4 = 30;
    		this.magazine4 = 1;
    		this.reload_time4 = 30;
    		this.reloadsoundset4 = 0;
    		this.reloadsound4 = GVCSoundEvent.reload_cannon;
    		this.w4cycle = 1;
    		this.w4barst = 1;
    		this.weapon4 = 1;
    		this.w4crossfire = false;
    			this.bullet_type4[0] = 21;
        		this.sound_fire4[0] = "gvclib.fire_roket";
        		this.fire_pointx4[0] = 6.4F;
        		this.fire_pointy4[0] = 2.5F;
        		this.fire_pointz4[0] = 0.5F;
        		this.basis_pointx4[0] = 3.5F;
        		this.basis_pointy4[0] = (float) (riddingy[0] + 1.25F);
        		this.basis_pointz4[0] = 0F;
        		this.fire_yoffset4[0] = 0;
        		this.bullet_speed4[0] = 1F;
        		this.bullet_kazu4[0] = 1;
        		
		}
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(140D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		//this.roadattackPC(1);
		VehicleCNT_Heli.load(this, GVCSoundEvent.sound_heli);
		//this.typePCHeli_NEW(GVCSoundEvent.sound_heli);
		
		this.ContMobRidding();
    }

    
    double deathY;
    protected void onDeathUpdate() {
		++this.deathTicks;
		if(deathTicks == 1) {
			deathY = this.posY;
		}
		int x = this.world.rand.nextInt(4);
		int y = this.world.rand.nextInt(5);
		int z = this.world.rand.nextInt(4);
		if(this.thpower > 1){
			this.thpower = this.thpower + this.thmina * 4;
		}
		if (this.deathTicks == 1 && !this.world.isRemote) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 3, false,  false);
		}
		/*if(this.getControllingPassenger() instanceof EntityLivingBase) {
			EntityLivingBase entity = (EntityLivingBase) this.getControllingPassenger();
			if(entity.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty()) {
				entity.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
			}
			this.getControllingPassenger().dismountRidingEntity();
		}*/
		double yy = this.posY;
		double ly = this.prevPosY;
		if(Math.abs(deathY - yy) > 0 && this.onGround) {
			if(!this.world.isRemote) {
				GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 3, false,  false);
				this.setDead();
			}
		}
		
		/*
		if (this.deathTicks >= 100 && !this.world.isRemote && this.onGround) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 3, false,  false);
			this.setDead();
		}*/
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
  				int ra = this.world.rand.nextInt(4) + 2;
				for(int x = 0; x < ra; ++x) {
					this.entityDropItem(new ItemStack(Blocks.IRON_BLOCK), 0.0F);
				}
  			}
  			{
  				int ra = this.world.rand.nextInt(4) + 1;
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
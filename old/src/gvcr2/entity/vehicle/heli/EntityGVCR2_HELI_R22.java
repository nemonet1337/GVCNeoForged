package gvcr2.entity.vehicle.heli;

import java.util.List;

import javax.annotation.Nullable;

import gvclib.mod_GVCLib;
import gvclib.entity.living.AI_AirCraftSet;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.ISoldier;
import gvclib.entity.living.PL_AirCraftMove;
import gvclib.entity.living.cnt.VehicleCNT_Heli;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.event.level.GVCR2WorldDifficultyLevel;
import hmggirlfront.mod_GirlFront;
import hmggirlfront.entity.EntityDoll;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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

public class EntityGVCR2_HELI_R22 extends EntityMobVehicleBase
{

    public EntityGVCR2_HELI_R22(World worldIn)
    {
        super(worldIn);
        this.setSize(5F, 4.0F);
        this.ridding_sneakdismount = false;
        this.riddng_freehand = true;
        this.hud_icon = "gvcr2:textures/hud/heli.png";
        this.render_hud_icon_hori = true;
        this.hud_icon_hori = "gvcr2:textures/hud/heli_hori.png";
        this.render_hud_information_1 = "Z-KEY:Get off";
        this.render_hud_information_2 = "W/S-KEY:Throttle-UP/DWON";
        this.render_hud_information_3 = "SPEAC/SHIFT-KEY:UP/DWON";
        this.render_hud_information_4 = "Mouse-UP/DOWN:PICTH-UP/DOWN";
        this.render_hud_information_5 = "V-KEY:ALLY-Boarding";
        this.render_hud_information_6 = "B-KEY:ALLY-Get off";
        vehicletype = 2;
        ridding_roteplayer = false;
        this.roodbreak = mod_GVCR2.cfg_movebreak;
        vehicle_ridding_nofire[0] = true;
        vehicle_ridding_nofire[1] = true;
        vehicle_ridding_nofire[2] = true;
        vehicle_ridding_nofire[3] = true;

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_heli_r22;
        
        this.sp = 0.025F;
        this.turnspeed = 6F;
        this.rotationp_max = -45F;
        this.rotationp_min = 60F;
		this.ridding_invisible = false;
		this.riddng_opentop = true;
		this.renderhud = true;
        this.thmax = 20F;
		this.thmin = -2F;
		this.thmaxa = 0.2F;
		this.thmina = -0.15F;
		this.stepHeight = 1.5F;
		this.riddng_maximum = 4;
		riddingx[0]=0.52D;
		riddingy[0]=1.0D;
		riddingz[0]=0.8D;
		{
			riddingx[1]=-0.52D;
			riddingy[1]=1.0D;
			riddingz[1]=0.8D;
			
			riddingx[2]=1.2D;
			riddingy[2]=0.7D;
			riddingz[2]=0.0D;
			
			riddingx[3]=-1.2D;
			riddingy[3]=0.7D;
			riddingz[3]=0.0D;
			
		}
		
		
		ridding_view_x=0F;
		ridding_view_y=-2F;
		ridding_view_z=-10F;
		ridding_view_gunner_x=0F;
		ridding_view_gunner_y=2F;
		ridding_view_gunner_z=1F;
		
		antibullet_0 = 1.0F;
		antibullet_1 = 1.0F;
		antibullet_2 = 2.0F;
		antibullet_3 = 2.0F;
		this.ridding_damege = 0.5F;
		
		{
			cloud = 1;
			cloud_x[0] = 0D;
			cloud_y[0] = 2.92D;
			cloud_z[0] = -2.0D;
		}
		{
			pera = 2;
			pera_x[0] = 0F;
			pera_y[0] = 4F;
			pera_z[0] = 0F;
			perarote_x[0] = 0F;
			perarote_y[0] = 1F;
			perarote_z[0] = 0F;
			pera_x[1] = 0F;
			pera_y[1] = 3.24F;
			pera_z[1] = -6.56F;
			perarote_x[1] = 1F;
			perarote_y[1] = 0F;
			perarote_z[1] = 0F;
		}
		
		aitypemax = 120;
		mob_min_range = 50;
		mob_max_range = 120;
		
		{
			this.weapon1type = 1;
			this.weapon1true = true;
			this.w1can_cooldown = true;
    		this.weapon1key = 0;
    		this.w1name = "7.62mmMG";
    		this.ammo1 = 2;
    		this.magazine = 20;
    		this.reload_time1 = 60;
    		this.reloadsoundset1 = 40;
    		this.reloadsound1 = GVCSoundEvent.reload_mg;
    		this.w1cycle = 1;
    		this.w1barst = 1;
    		this.weapon1 = 2;
    		this.w1crossfire = true;
    		for(int i = 0; i < 2; ++i){
    			this.bullet_type1[i] = 0;
        		this.bullet_model1[i] = "gvclib:textures/entity/BulletNormal.obj";
        		this.bullet_tex1[i] = "gvclib:textures/entity/BulletNormal.png";
        		this.fire_model1[i]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex1[i] = "gvclib:textures/entity/mflash.png";
        		this.fire_time1[i] = 5;
        		this.sound_fire1[i] = "gvclib.fire_mg";
        		this.fire_pointx1[0] = 1.6F;
        		this.fire_pointx1[1] = -1.6F;
    			this.basis_pointx1[i] = 0.0F;
        		this.fire_pointy1[i] = 0.6F;
        		this.fire_pointz1[i] = 1.0F;
        		this.basis_pointy1[i] = 1.0F;
        		this.basis_pointz1[i] = 0.0F;
        		this.fire_yoffset1[i] = 0;
        		this.rotationfollowing1[i] = false;
        		this.rotationfirepoint1[i] = false;
        		this.rotation_player1[i] = false;
        		this.bullet_damage1[i] = 4;
        		this.bullet_speed1[i] = 8.0F;
        		this.bullet_bure1[i] = 3F;
        		this.bullet_expower1[i] = 0F;
        		this.bullet_ex1[i] = false;
        		this.bullet_kazu1[i] = 1;
        		this.bullet_gravity1[i] = 0.029D;
        		this.bullet_livingtime1[i] = 80;
    		}
		}
		this.mob_w1range = 100;
		this.mob_w1range_max_y = 60;
		this.mob_w1range_min_y = 80;
		
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }

    
    public boolean spawn = false;
    public void onUpdate() {
    	/*if(this.world.isRemote) {
    		System.out.println("update_front");
    		System.out.println(String.format("%1$.2f", this.rotationPitch));
    	}*/
		super.onUpdate();
		/*if(this.world.isRemote) {
    		System.out.println("update_ato");
    		System.out.println(String.format("%1$.2f", this.rotationPitch));
    	}*/
		float f1 = this.rotationYawHead * (2 * (float) Math.PI / 360);
		this.roadattack();
		VehicleCNT_Heli.load(this, GVCSoundEvent.sound_heli);
		
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
		return this.getLevel() >= 5 && this.getCanSpawnUnderGround() && this.getCanSpawnDimension() && super.getCanSpawnHere();
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
   				int ra = this.world.rand.nextInt(3) + 2;
 				for(int x = 0; x < ra; ++x) {
 					this.entityDropItem(new ItemStack(Blocks.IRON_BLOCK), 0.0F);
 				}
   			}
   			{
   				int ra = this.world.rand.nextInt(3) + 1;
 				for(int x = 0; x < ra; ++x) {
 					this.entityDropItem(new ItemStack(Blocks.REDSTONE_BLOCK), 0.0F);
 				}
   			}
   			{
   				int ra = this.world.rand.nextInt(2) + 2;
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
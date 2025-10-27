package gvcr2.entity.vehicle.ship;

import java.util.List;

import gvclib.mod_GVCLib;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.ISoldier;
import gvclib.entity.living.PL_AirCraftMove;
import gvclib.entity.living.PL_Weapon;
import gvclib.entity.living.cnt.VehicleCNT_Boat;
import gvclib.entity.living.cnt.VehicleCNT_Tank;
import gvclib.entity.living.cnt.ai.AI_GetTarget_OnRidding;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityGVCR2_SHIP_RCB extends EntityMobVehicleBase
{
    public EntityGVCR2_SHIP_RCB(World worldIn)
    {
        super(worldIn);
        this.setSize(6.0F, 2.4F);
        this.hud_icon = "gvclib:textures/hud/tank64.png";

        this.render_hud_information_5 = "V-KEY:ALLY-Boarding";
        this.render_hud_information_6 = "B-KEY:ALLY-Get off";
        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_ship_rcb;
        
        this.sp = 0.035F;
        this.turnspeed = 1.5F;
        this.rotationp_max = -50F;
        this.rotationp_min = 10F;
		this.ridding_invisible = true;
		this.riddng_opentop = false;
		this.ridding_roteplayer = false;
		this.ridding_roteplayerPitch = false;
        this.thmax = 5F;
		this.thmin = -2F;
		this.thmaxa = 0.2F;
		this.thmina = -0.15F;
		this.stepHeight = 1.5F;
		this.riddng_maximum = 4;
		riddingx[0] = 0.0;
		riddingy[0] = 1.5;
		riddingz[0] = 0;
		this.ridding_view1_x = 0.75F;
		this.ridding_view1_y = 0.0F;
		this.ridding_view1_z = 0.0F;
		{
			riddingx[3]=0.0D;
			riddingy[3]=1.5D;
			riddingz[3]=-1.5D;
			
			riddingx[1]=0.8D;
			riddingy[1]=1.3D;
			riddingz[1]=-3.0D;
			riddingx[2]=-0.8D;
			riddingy[2]=1.3D;
			riddingz[2]=-3.0D;
		}
		 vehicle_ridding_nofire[0] = false;
	     vehicle_ridding_nofire[1] = false;
	     vehicle_ridding_nofire[2] = false;
	     vehicle_ridding_nofire[3] = false;
		
		antibullet_0 = 0.0F;
		antibullet_1 = 0.5F;
		antibullet_2 = 1.0F;
		antibullet_3 = 1.0F;
		this.ridding_damege = 0.75F;
		
		this.roodbreak = mod_GVCR2.cfg_movebreak;
		
		/*{
			cloud = 2;
			cloud_x[0] = 0.5D;
			cloud_x[1] = -0.5D;
			cloud_y[0] = cloud_y[1] = 1D;
			cloud_z[0] = cloud_z[1] = -3.2D;
		}*/
		
		mob_min_range = 20;
		mob_max_range = 60;
		
		{
			this.weapon1true = true;
    		this.weapon1key = 0;
    		this.w1name = "30mmMachineCannon";
    		this.ammo1 = 4;
    		this.magazine = 30;
    		this.reload_time1 = 80;
    		this.reloadsoundset1 = 40;
    		this.reloadsound1 = GVCSoundEvent.reload_mg;
    		this.w1cycle = 1;
    		this.w1barst = 1;
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
        		this.fire_pointy1[0] = 2.725F;
        		this.fire_pointz1[0] = 1.7F;
        		this.basis_pointx1[0] = 0;
        		this.basis_pointy1[0] = 2.725F;
        		this.basis_pointz1[0] = 0F;
        		this.fire_yoffset1[0] = 0;
        		this.rotationfollowing1[0] = true;
        		this.rotation_player1[0] = true;
        		this.rotationfirepoint1[0] = false;
        		this.bullet_damage1[0] = 11;
        		this.bullet_speed1[0] = 4F;
        		this.bullet_bure1[0] = 1.0F;
        		this.bullet_expower1[0] = 0F;
        		this.bullet_ex1[0] = false;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.025D;
        		this.bullet_livingtime1[0] = 80;
        		
    		}
    		this.mob_w1range = 50;
    		this.mob_w1range_max_y = 15;
    		this.mob_w1range_min_y = 5;
		}
		
		{
			this.weapon2true = true;
    		this.weapon2key = 2;
    		this.w2name = "ManualMissile";
    		this.ammo2 = 30;
    		this.magazine2 = 1;
    		this.reload_time2 = 80;
    		this.reloadsoundset2 = 40;
    		this.reloadsound2 = GVCSoundEvent.reload_mg;
    		this.w2cycle = 1;
    		this.w2barst = 1;
    		this.weapon2 = 1;
    		{
    			this.bullet_type2[0] = 8;
    			this.bullet_model2[0] = "gvclib:textures/entity/model/bullet_atm.mqo";
        		this.bullet_tex2[0] = "gvclib:textures/entity/model/bullet_atm.png";
        		this.fire_model2[0]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex2[0] = "gvclib:textures/entity/mflash.png";
        		this.fire_time2[0] = 2;
        		this.sound_fire2[0] = "gvclib.fire_roket";
        		this.fire_pointx2[0] = 0;
        		this.fire_pointy2[0] = 2.2F;
        		this.fire_pointz2[0] = -3.2F;
        		this.basis_pointx2[0] = 0;
        		this.basis_pointy2[0] = 2.2F;
        		this.basis_pointz2[0] = -3.2F;
        		this.fire_yoffset2[0] = 0;
        		this.rotationfollowing2[0] = true;
        		this.rotation_player2[0] = false;
        		this.rotationfirepoint2[0] = false;
        		this.bullet_damage2[0] = 40;
        		this.bullet_speed2[0] = 1.0F;
        		this.bullet_bure2[0] = 1.0F;
        		this.bullet_expower2[0] = 3F;
        		this.bullet_ex2[0] = false;
        		this.bullet_kazu2[0] = 1;
        		this.bullet_gravity2[0] = 0.025D;
        		this.bullet_livingtime2[0] = 800;
        		
    		}
    		this.mob_w2range = 50;
    		this.mob_w2range_max_y = 15;
    		this.mob_w2range_min_y = 5;
		}
		
		
		{
			this.weapon3true = true;
			this.weapon3key = 0;
			this.ammo3 = 1;
			this.magazine3 = 30;
			reload_time3 = 100;
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
				this.fire_pointx3[0] = 1.5F;
				this.fire_pointy3[0] = 1.4F;
				this.fire_pointz3[0] = -0.0F;
				this.basis_pointx3[0] = 1.5F;
        		this.basis_pointy3[0] = 1.4F;
        		this.basis_pointz3[0] = -0.0F;
				this.fire_yoffset3[0] = 0;
				this.rotationfollowing3[0] = true;
				this.rotationfirepoint3[0] = false;
				this.rotation_mob_head3[0] = true;
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
		}
		{
			this.weapon4true = true;
			this.weapon4key = 0;
			this.ammo4 = 1;
			this.magazine4 = 30;
			reload_time4 = 100;
			this.w4name = "MachineGun";
			this.w4cycle = 1;
			this.w4barst = 1;
			this.weapon4 = 1;
			{
				this.bullet_type4[0] = 0;
				this.bullet_model4[0] = "gvclib:textures/entity/BulletNormal.obj";
				this.bullet_tex4[0] = "gvclib:textures/entity/BulletNormal.png";
				this.fire_model4[0] = "gvclib:textures/entity/mflash.mqo";
				this.fire_tex4[0] = "gvclib:textures/entity/mflash.png";
				this.fire_time4[0] = 2;
				this.sound_fire4[0] = "gvclib.fire_rifle";
				this.fire_pointx4[0] = -1.5F;
				this.fire_pointy4[0] = 1.4F;
				this.fire_pointz4[0] = -0.0F;
				this.basis_pointx4[0] = -1.5F;
        		this.basis_pointy4[0] = 1.4F;
        		this.basis_pointz4[0] = -0.0F;
				this.fire_yoffset4[0] = 0;
				this.rotationfollowing4[0] = true;
				this.rotationfirepoint4[0] = false;
				this.rotation_mob_head4[0] = true;
				this.bullet_damage4[0] = 4;
				this.bullet_speed4[0] = 4F;
				this.bullet_bure4[0] = 5.0F;
				this.bullet_expower4[0] = 0F;
				this.bullet_ex4[0] = false;
				this.bullet_kazu4[0] = 1;
				this.bullet_gravity4[0] = 0.029D;
				this.bullet_livingtime4[0] = 80;

			}
			this.mob_w4range = 40;
			this.mob_w4range_max_y = 30;
			this.mob_w4range_min_y = 30;
		}
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		this.roadattack();
		//this.typeBoat();
		VehicleCNT_Boat.load(this, GVCSoundEvent.sound_car);
		this.ContMobRidding();
		
		
		if(this.getPassengers().size() > 1)
        {
        	 if(this.getPassengers().get(1) != null){
     			if (this.getPassengers().get(1) instanceof EntityPlayer) {
     				/*EntityPlayer entitylivingbase = (EntityPlayer)this.getPassengers().get(2);
     				this.setcanDespawn(1);
     				this.rotation_2  = entitylivingbase.rotationYawHead;
     				this.rotationp_2 = entitylivingbase.rotationPitch;
     				Vec3d looked = entitylivingbase.getLookVec();
     				boolean left = mod_GVCLib.proxy.leftclick();
     				if (left) {
     					GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(11, this.getEntityId()));
     					this.server1 = true;
     				}

     				if (this.server1) {
     					{
     	    				if(cooltime2 >= ammo2){
     	    					this.counter2 = true;
     	    		            cooltime2 = 0;
     	    				}
     	    				if(this.weapon2true) {
     	    					{
     	    						this.weapon2active(looked, entitylivingbase);
     	    					}
     	        		    }
     	    			}
     					this.server1 = false;
     				}*/
     			}else
     			if (this.getPassengers().get(1) instanceof EntityGVCLivingBase) {
     				EntityGVCLivingBase entitylivingbase = (EntityGVCLivingBase)this.getPassengers().get(1);
     				if(entitylivingbase.getattacktask()) {
     					
     				}else {
     					entitylivingbase.rotationYawHead = this.rotationYaw;
     				}
     				this.rotation_3  = entitylivingbase.rotationYawHead;
     				this.rotationp_3 = entitylivingbase.rotationPitch;
     				Vec3d looked = entitylivingbase.getLookVec();
     				//AI_EntityWeapon.getTargetEntity(entitylivingbase, this.mob_w2range, this.mob_w2range_max_y, this.mob_w2range_min_y);
     				AI_GetTarget_OnRidding.load(entitylivingbase, this.mob_w3range, this.mob_w3range_max_y, this.mob_w3range_min_y, this.rotationYaw, 180, 0);
     				if(AI_GetTarget_OnRidding.getRange(entitylivingbase, this.mob_w3range, this.mob_w3range_max_y, this.mob_w3range_min_y, this.rotationYaw, 180, 0)){
     					if(cooltime3 >= ammo3 && this.getRemain_A() > 0){
     						this.counter3 = true;
     			            cooltime3 = 0;
     					}
     					if(this.weapon3true) {
     	    		    	this.weapon3activeMob(looked, entitylivingbase, 0);
     	    		    }
     				}
     			}
     		}else {
     			this.rotation_3  = this.rotationYawHead;
 				this.rotationp_3 = this.rotationPitch;
     		}
        }
		if(this.getPassengers().size() > 2)
        {
        	 if(this.getPassengers().get(2) != null){
      			if (this.getPassengers().get(2) instanceof EntityPlayer) {
      				/*EntityPlayer entitylivingbase = (EntityPlayer)this.getPassengers().get(3);
      				this.setcanDespawn(1);
      				this.rotation_3  = entitylivingbase.rotationYawHead;
     				this.rotationp_3 = entitylivingbase.rotationPitch;
      				Vec3d looked = entitylivingbase.getLookVec();
      				boolean left = mod_GVCLib.proxy.leftclick();
      				if (left) {
      					GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(11, this.getEntityId()));
      					this.server1 = true;
      				}

      				if (this.server1) {
      					{
      	    				if(cooltime4 >= ammo4){
      	    					this.counter4 = true;
      	    		            cooltime4 = 0;
      	    				}
      	    				if(this.weapon4true) {
      	    					{
      	    						this.weapon4active(looked, entitylivingbase);
      	    					}
      	        		    }
      	    			}
      					this.server1 = false;
      				}*/
      			}else
      			if (this.getPassengers().get(2) instanceof EntityGVCLivingBase) {
      				EntityGVCLivingBase entitylivingbase = (EntityGVCLivingBase)this.getPassengers().get(2);
      				if(entitylivingbase.getattacktask()) {
      					
      				}else {
      					entitylivingbase.rotationYawHead = this.rotationYaw;
      				}
      				this.rotation_4  = entitylivingbase.rotationYawHead;
      				this.rotationp_4 = entitylivingbase.rotationPitch;
      				Vec3d looked = entitylivingbase.getLookVec();
      				//AI_EntityWeapon.getTargetEntity(entitylivingbase, this.mob_w4range, this.mob_w4range_max_y, this.mob_w4range_min_y);
      				AI_GetTarget_OnRidding.load(entitylivingbase, this.mob_w4range, this.mob_w4range_max_y, this.mob_w4range_min_y, this.rotationYaw, 0, 180);
      				if(AI_GetTarget_OnRidding.getRange(entitylivingbase, this.mob_w4range, this.mob_w4range_max_y, this.mob_w4range_min_y, this.rotationYaw, 0, 180)){
      					if(cooltime4 >= ammo4 && this.getRemain_S() > 0){
      						this.counter4 = true;
      			            cooltime4 = 0;
      					}
      					if(this.weapon4true) {
      	    		    	this.weapon4activeMob(looked, entitylivingbase, 0);
      	    		    }
      				}
      			}
      		}else {
     			this.rotation_4  = this.rotationYawHead;
 				this.rotationp_4 = this.rotationPitch;
     		}
        }
		/*this.w4name = "MachineGun";
		this.magazine4 = 20;
		this.ammo4 = 2;
		this.reload_time4 = 60;
		this.reloadsound4 = GVCSoundEvent.reload_mg;
		this.reloadsoundset4 = 0;
		
		if (this.canBeSteered() && this.getControllingPassenger() != null && this.getHealth() > 0.0F)
		{
			if(this.getControllingPassenger() instanceof EntityPlayer)
			{
				EntityPlayer entitylivingbase = (EntityPlayer) this.getControllingPassenger();
				if(cooltime4 > ammo4&& this.getRemain_S() > 0){
    		    	List<Entity> llist = this.world.getEntitiesWithinAABBExcludingEntity(this,
    						this.getEntityBoundingBox().expand(this.motionX, this.motionY, this.motionZ).grow(30));
    				if (llist != null) {
    					for (int lj = 0; lj < llist.size(); lj++) {
    						Entity entity1 = (Entity) llist.get(lj);
    						if (entity1.canBeCollidedWith()) {
    							{
    								if (entity1 instanceof IMob && entity1 != null && ((EntityLivingBase) entity1).getHealth() > 0.0F && this.getHealth() > 0.0F) 
    								{
    									double ddy = Math.abs(entity1.posY - this.posY);
    									double dyp = this.posY + 20;
    									double dym = this.posY - 2;
    									double d5 = entity1.posX - this.posX;
    									double d7 = entity1.posZ - this.posZ;
    									double d6 = entity1.posY - this.posY;
    									double d1 = this.posY - (entity1.posY);
    									double d3 = (double) MathHelper.sqrt(d5 * d5 + d7 * d7);
    									float f11 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
    									rotation_1 = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
    									rotationp_1 = -f11 + 0;
    									boolean flag = this.getEntitySenses().canSee(entity1);
    									Vec3d newlook = this.getVectorForRotation(this.rotationp_1, this.rotation_1);
    									if (entity1.posY < this.posY + 20 && entity1.posY > this.posY - 2 && flag) {
    										PL_Weapon.Weapon(this, 0, entitylivingbase, 
    				    							"gvclib:textures/entity/BulletNormal.obj","gvclib:textures/entity/BulletNormal.png",
    				    							"gvclib:textures/entity/mflash.mqo","gvclib:textures/entity/mflash.png",2,GVCSoundEvent.fire_rifle, 
    				    							-1.57F, 1.5, 1.8, -3, entitylivingbase.posX, this.posY, entitylivingbase.posZ,newlook,this.rotationYawHead,1,1,
    				    							5, 3.0F, 5F, 0, false, 1, 0.029D, 80, 0);//1.57/1.5/3
    										PL_Weapon.Weapon(this, 0, entitylivingbase, 
    				    							"gvclib:textures/entity/BulletNormal.obj","gvclib:textures/entity/BulletNormal.png",
    				    							"gvclib:textures/entity/mflash.mqo","gvclib:textures/entity/mflash.png",2,GVCSoundEvent.fire_rifle, 
    				    							1.57F, 1.5, 1.8, -3, entitylivingbase.posX, this.posY, entitylivingbase.posZ,newlook,this.rotationYawHead,1,1,
    				    							5, 3.0F, 5F, 0, false, 1, 0.029D, 80, 0);//1.57/1.5/3
    										{
    								            cooltime4 = 0;
    								            this.setRemain_S(this.getRemain_S() -1);
    									        }
    										break;
    									}
    									
    								}
    							}
    						}
    					}
    				}
			        
				}
			}
		}*/
    }
   

   protected void onDeathUpdate() {
		++this.deathTicks;
		int x = this.world.rand.nextInt(4);
		int y = this.world.rand.nextInt(5);
		int z = this.world.rand.nextInt(4);
		if (this.deathTicks == 1 && !this.world.isRemote) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 3, false,  false);
		}
		if (this.deathTicks == 200 && !this.world.isRemote) {
			this.setDead();
		}
	}
}
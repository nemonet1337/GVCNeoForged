package gvcr2.entity.vehicle.heli;

import java.util.List;

import gvclib.mod_GVCLib;
import gvclib.entity.living.AI_AirCraftSet;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.ISoldier;
import gvclib.entity.living.PL_AirCraftMove;
import gvclib.entity.living.cnt.VehicleCNT_Heli;
import gvclib.entity.living.cnt.ai.AI_GetTarget_OnRidding;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityGVCR2_HELI_UH60 extends EntityMobVehicleBase
{

    public EntityGVCR2_HELI_UH60(World worldIn)
    {
        super(worldIn);
        this.setSize(5F, 4.0F);
        this.ridding_sneakdismount = false;
        this.riddng_freehand = false;
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
        
        vehicle_ridding_nofire[2] = true;
        vehicle_ridding_nofire[3] = true;

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_heli_uh60;
        
        this.sp = 0.030F;
        this.turnspeed = 3F;
        this.rotationp_max = -20F;
        this.rotationp_min = 30F;
		this.ridding_invisible = false;
		this.riddng_opentop = true;
		this.renderhud = true;
        this.thmax = 20F;
		this.thmin = -2F;
		this.thmaxa = 0.2F;
		this.thmina = -0.15F;
		this.stepHeight = 1.5F;
		this.riddng_maximum = 6;
		riddingx[0]=0.52D;
		riddingy[0]=0.85D;
		riddingz[0]=2.0D;
		{
			riddingx[1]=-0.52D;
			riddingy[1]=1.05D;
			riddingz[1]=1.8D;
			
			riddingx[2]=0.72D;
			riddingy[2]=1.12D;
			riddingz[2]=-0.32D;
			
			riddingx[3]=-0.72D;
			riddingy[3]=1.12D;
			riddingz[3]=-0.32D;
			
			riddingx[4]=0.4D;
			riddingy[4]=1.12D;
			riddingz[4]=0.56D;
			riddingx[5]=-0.4D;
			riddingy[5]=1.12D;
			riddingz[5]=0.56D;
			
		}
		
		
		ridding_view_x=0F;
		ridding_view_y=-2F;
		ridding_view_z=-15F;
		ridding_view_gunner_x=0F;
		ridding_view_gunner_y=2F;
		ridding_view_gunner_z=1F;
		
		antibullet_0 = 0.5F;
		antibullet_1 = 1.0F;
		antibullet_2 = 2.0F;
		antibullet_3 = 1.2F;
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
		mob_min_range = 10;
		mob_max_range = 90;
		
		{
			this.weapon3true = true;
			this.weapon3key = 0;
			this.ammo3 = 2;
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
				this.fire_pointx3[0] = 1.6F;
				this.fire_pointy3[0] = 1.5F;
				this.fire_pointz3[0] =  -0.35F;
				this.basis_pointx3[0] = 1.6F;
        		this.basis_pointy3[0] = 1.5F;
        		this.basis_pointz3[0] =  -0.35F;
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
			this.mob_w3range_min_y = 50;
		}
		{
			this.weapon4true = true;
			this.weapon4key = 0;
			this.ammo4 = 2;
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
				this.fire_pointx4[0] = -1.6F;
				this.fire_pointy4[0] = 1.5F;
				this.fire_pointz4[0] = -0.35F;
				this.basis_pointx4[0] = -1.6F;
        		this.basis_pointy4[0] = 1.5F;
        		this.basis_pointz4[0] = -0.35F;
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
			this.mob_w4range_min_y = 50;
		}
		
		this.weapon2type = 1;
		{
			this.weapon2true = true;
    		this.weapon2key = 0;
    		this.w2name = "Flare";
    		this.ammo2 = 30;
    		this.magazine2 = 1;
    		this.reload_time2 = 30;
    		this.reloadsoundset2 = 0;
    		this.reloadsound2 = GVCSoundEvent.reload_cannon;
    		this.w2cycle = 1;
    		this.w2barst = 1;
    		this.weapon2 = 1;
    		this.w2crossfire = false;
    			this.bullet_type2[0] = 21;
        		this.sound_fire2[0] = "gvclib.fire_roket";
        		this.fire_pointx2[0] = 6.4F;
        		this.fire_pointy2[0] = 2.5F;
        		this.fire_pointz2[0] = 0.5F;
        		this.basis_pointx2[0] = 3.5F;
        		this.basis_pointy2[0] = (float) (riddingy[0] + 1.25F);
        		this.basis_pointz2[0] = 0F;
        		this.fire_yoffset2[0] = 0;
        		this.bullet_speed2[0] = 1F;
        		this.bullet_kazu2[0] = 1;
        		
		}
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(250D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }

    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		this.riddng_freehand = false;
		float f1 = this.rotationYawHead * (2 * (float) Math.PI / 360);
		this.roadattack();
		VehicleCNT_Heli.load(this, GVCSoundEvent.sound_heli);
		
		this.ContMobRidding();
		
		
		if(this.getPassengers().size() > 2)
        {
        	 if(this.getPassengers().get(2) != null){
     			if (this.getPassengers().get(2) instanceof EntityPlayer) {
     				
     			}else if (this.getPassengers().get(2) instanceof EntityGVCLivingBase) {
     				EntityGVCLivingBase entitylivingbase = (EntityGVCLivingBase)this.getPassengers().get(2);
     				if(entitylivingbase.getattacktask()) {
     					
     				}else {
     					entitylivingbase.rotationYawHead = this.rotationYaw;
     				}
     				this.rotation_3  = entitylivingbase.rotationYawHead;
     				this.rotationp_3 = entitylivingbase.rotationPitch;
     				Vec3d looked = entitylivingbase.getLookVec();
     				//AI_EntityWeapon.getTargetEntity(entitylivingbase, this.mob_w2range, this.mob_w2range_max_y, this.mob_w2range_min_y);
     				AI_GetTarget_OnRidding.load(entitylivingbase, this.mob_w3range, this.mob_w3range_max_y, this.mob_w3range_min_y, this.rotationYaw, 0, 180);
     				if(AI_GetTarget_OnRidding.getRange(entitylivingbase, this.mob_w3range, this.mob_w3range_max_y, this.mob_w3range_min_y, this.rotationYaw, 0, 180)){
     					if(cooltime3 >= ammo3 && this.getRemain_A() > 0){
     						this.counter3 = true;
     			            cooltime3 = 0;
     					}
     					if(this.weapon3true) {
     	    		    	this.weapon3activeMob(looked, entitylivingbase, 0);
     	    		    }
     				}
     			}else if (this.getPassengers().get(2) instanceof EntityLivingBase) {
     				EntityLivingBase entitylivingbase = (EntityLivingBase)this.getPassengers().get(2);
     				Vec3d looked = entitylivingbase.getLookVec();
     				if(AI_GetTarget_OnRidding.load_LivingBase(entitylivingbase, this, 3, this.mob_w3range, this.mob_w3range_max_y, this.mob_w3range_min_y, this.rotationYaw, 0, 180))
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
     			}
     			
     		}else {
     			this.rotation_3  = this.rotationYawHead;
 				this.rotationp_3 = this.rotationPitch;
     		}
        }
		if(this.getPassengers().size() > 3)
        {
        	 if(this.getPassengers().get(3) != null){
      			if (this.getPassengers().get(3) instanceof EntityPlayer) {
      				
      			}else
      			if (this.getPassengers().get(3) instanceof EntityGVCLivingBase) {
      				EntityGVCLivingBase entitylivingbase = (EntityGVCLivingBase)this.getPassengers().get(3);
      				if(entitylivingbase.getattacktask()) {
      					
      				}else {
      					entitylivingbase.rotationYawHead = this.rotationYaw;
      				}
      				this.rotation_4  = entitylivingbase.rotationYawHead;
      				this.rotationp_4 = entitylivingbase.rotationPitch;
      				Vec3d looked = entitylivingbase.getLookVec();
      				//AI_EntityWeapon.getTargetEntity(entitylivingbase, this.mob_w4range, this.mob_w4range_max_y, this.mob_w4range_min_y);
      				AI_GetTarget_OnRidding.load(entitylivingbase, this.mob_w4range, this.mob_w4range_max_y, this.mob_w4range_min_y, this.rotationYaw, 180, 0);
      				if(AI_GetTarget_OnRidding.getRange(entitylivingbase, this.mob_w4range, this.mob_w4range_max_y, this.mob_w4range_min_y, this.rotationYaw, 180, 0)){
      					if(cooltime4 >= ammo4 && this.getRemain_S() > 0){
      						this.counter4 = true;
      			            cooltime4 = 0;
      					}
      					if(this.weapon4true) {
      	    		    	this.weapon4activeMob(looked, entitylivingbase, 0);
      	    		    }
      				}
      			}
      		}else if (this.getPassengers().get(3) instanceof EntityLivingBase) {
 				EntityLivingBase entitylivingbase = (EntityLivingBase)this.getPassengers().get(3);
 				Vec3d looked = entitylivingbase.getLookVec();
 				if(AI_GetTarget_OnRidding.load_LivingBase(entitylivingbase, this, 4, this.mob_w4range, this.mob_w4range_max_y, this.mob_w4range_min_y, this.rotationYaw, 180, 0))
 				{
 					if(cooltime4 >= ammo4 && this.getRemain_S() > 0){
 						this.counter4 = true;
 			            cooltime4 = 0;
 					}
 					if(this.weapon4true) {
 	    		    	this.weapon4activeMob(looked, this, 0);
 	    		    }
     				entitylivingbase.rotationYawHead = this.rotation_4;
     				entitylivingbase.rotationPitch = this.rotationp_4;
 				}
 			}
        	 else {
     			this.rotation_4  = this.rotationYawHead;
 				this.rotationp_4 = this.rotationPitch;
     		}
        }
    }
    
    /*protected void onDeathUpdate() {
		++this.deathTicks;
		int x = this.world.rand.nextInt(4);
		int y = this.world.rand.nextInt(5);
		int z = this.world.rand.nextInt(4);
		if (this.deathTicks == 1 && !this.world.isRemote) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 3, false,  false);
		}
		if (this.deathTicks %2 == 0) {
			--throttle;
			--thpower;
		}
		if (this.deathTicks == 200 && !this.world.isRemote) {
			this.setDead();
		}
	}*/
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
}
package gvcr2.entity.vehicle.ship;

import java.util.List;

import gvclib.mod_GVCLib;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.ISoldier;
import gvclib.entity.living.PL_Weapon;
import gvclib.entity.living.PL_Weapon_new;
import gvclib.entity.living.cnt.VehicleCNT_Boat;
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class EntityGVCR2_SHIP_HAMINA extends EntityMobVehicleBase
{
    public EntityGVCR2_SHIP_HAMINA(World worldIn)
    {
        super(worldIn);
        this.setSize(8.0F, 6.0F);
        this.hud_icon = "gvclib:textures/hud/tank64.png";

        this.render_hud_information_5 = "V-KEY:ALLY-Boarding";
        this.render_hud_information_6 = "B-KEY:ALLY-Get off";
        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_ship_hamina;
        
        vehicletype = 5;
        
        this.sp = 0.035F;
        this.turnspeed = 1.5F;
        this.rotationp_max = -90F;
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
		this.riddng_maximum = 1;
		riddingx[0] = 0.0;
		riddingy[0] = 2.8;//3.8
		riddingz[0] = 5.5;//0.0
		
		this.aarader = true;
		
		this.ridding_rotation_lock = true;
        this.rotation_max = 120F;
        /*
		this.ridding_view1_turretmode = true;
		this.ridding_view1_x = 5.5F;
		this.ridding_view1_y = 0.0F;
		this.ridding_view1_z = 5.5F;*/
		
		ridding_view_x=0F;
		ridding_view_y=-5F;
		ridding_view_z=-15f;
		
		
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
    		this.w1name = "57mmCannon";
    		this.ammo1 = 10;
    		this.magazine = 1;
    		this.reload_time1 = 40;
    		this.reloadsoundset1 = 20;
    		this.reloadsound1 = GVCSoundEvent.reload_cannon;
    		this.w1cycle = 1;
    		this.w1barst = 1;
    		this.weapon1 = 1;
    		{
    			this.bullet_type1[0] = 3;
        		this.bullet_model1[0] = "gvclib:textures/entity/model/bullet_cannon_small.mqo";
        		this.bullet_tex1[0] = "gvclib:textures/entity/model/bullet_cannon_small.png";
        		this.fire_model1[0]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/mflash.png";
        		this.fire_time1[0] = 2;
        		this.sound_fire1[0] = "gvclib.fire_cannon";
        		this.fire_pointx1[0] = 0;
        		this.fire_pointy1[0] = 2.9F;
        		this.fire_pointz1[0] = 5.5F;
        		this.basis_pointx1[0] = 0;
        		this.basis_pointy1[0] = 2.9F;
        		this.basis_pointz1[0] = 5.5F;
        		this.fire_yoffset1[0] = -0.03;
        		this.rotationfollowing1[0] = true;
        		this.rotation_player1[0] = false;
        		this.rotationfirepoint1[0] = false;
        		this.bullet_damage1[0] = 40;
        		this.bullet_speed1[0] = 8F;
        		this.bullet_bure1[0] = 0.5F;
        		this.bullet_expower1[0] = 2F;
        		this.bullet_ex1[0] = mod_GVCR2.cfg_exprotion_player;;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.029D;
        		this.bullet_livingtime1[0] = 80;
        		
    		}
    		this.mob_w1range = 50;
    		this.mob_w1range_max_y = 15;
    		this.mob_w1range_min_y = 5;
		}
		
		{
			this.weapon2true = true;
    		this.weapon2key = 2;
    		this.w2name = "SAMissile";
    		this.ammo2 = 6;
    		this.magazine2 = 4;
    		this.reload_time2 = 80;
    		this.reloadsoundset2 = 20;
    		this.reloadsound2 = GVCSoundEvent.reload_cannon;
    		this.w2cycle = 1;
    		this.w2barst = 1;
    		this.weapon2 = 1;
    		this.w2crossfire = true;
    		this.w2missile_aam = true;
    		{
    			this.bullet_type2[0] = 4;
        		this.bullet_model2[0] = "gvclib:textures/entity/model/bullet_small_missile.mqo";
        		this.bullet_tex2[0] = "gvclib:textures/entity/model/bullet_small_missile.png";
        		this.fire_model2[0]= "gvclib:textures/entity/msmoke.mqo";
        		this.fire_tex2[0] = "gvclib:textures/entity/msmoke.png";
        		this.fire_time2[0] = 16;
        		this.sound_fire2[0] = "gvclib.fire_missile";
        		this.fire_pointx2[0] = -0.6F;
        		this.fire_pointy2[0] = 4.3F;
        		this.fire_pointz2[0] = -3.4F;
        		this.basis_pointx2[0] = -0.6F;
        		this.basis_pointy2[0] = 4.3F;
        		this.basis_pointz2[0] = -3.4F;
        		this.fire_yoffset2[0] = 3;
        		this.rotationfollowing2[0] = true;
        		this.rotationfirepoint2[0] = true;
        		this.bullet_damage2[0] = 40;
        		this.bullet_speed2[0] = 4.0F;
        		this.bullet_bure2[0] = 2F;
        		this.bullet_expower2[0] = 5F;
        		this.bullet_ex2[0] = mod_GVCR2.cfg_exprotion_player;
        		this.bullet_kazu2[0] = 1;
        		this.bullet_gravity2[0] = 0.029D;
        		this.bullet_livingtime2[0] = 8000;
        		
    		}
		}
		{
			this.weapon3true = true;
    		this.weapon3key = 2;
    		this.w3name = "SSMissile";
    		this.ammo3 = 6;
    		this.magazine3 = 4;
    		this.reload_time3 = 80;
    		this.reloadsoundset3 = 20;
    		this.reloadsound3 = GVCSoundEvent.reload_cannon;
    		this.w3cycle = 1;
    		this.w3barst = 1;
    		this.weapon3 = 1;
    		this.w3crossfire = true;
    		this.w3missile_aam = false;
    		{
    			this.bullet_type3[0] = 8;
        		this.bullet_model3[0] = "gvclib:textures/entity/model/bullet_small_missile.mqo";
        		this.bullet_tex3[0] = "gvclib:textures/entity/model/bullet_small_missile.png";
        		this.fire_model3[0]= "gvclib:textures/entity/msmoke.mqo";
        		this.fire_tex3[0] = "gvclib:textures/entity/msmoke.png";
        		this.fire_time3[0] = 16;
        		this.sound_fire3[0] = "gvclib.fire_missile";
        		this.fire_pointx3[0] = -0.6F;
        		this.fire_pointy3[0] = 4.3F;
        		this.fire_pointz3[0] = -3.4F;
        		this.basis_pointx3[0] = -0.6F;
        		this.basis_pointy3[0] = 4.3F;
        		this.basis_pointz3[0] = -3.4F;
        		this.fire_yoffset3[0] = 3;
        		this.rotationfollowing3[0] = true;
        		this.rotationfirepoint3[0] = true;
        		this.bullet_damage3[0] = 60;
        		this.bullet_speed3[0] = 2.0F;
        		this.bullet_bure3[0] = 2F;
        		this.bullet_expower3[0] = 5F;
        		this.bullet_ex3[0] = mod_GVCR2.cfg_exprotion_player;
        		this.bullet_kazu3[0] = 1;
        		this.bullet_gravity3[0] = 0.029D;
        		this.bullet_livingtime3[0] = 8000;
        		
    		}
		}
		{
			this.weapon4true = true;
    		this.weapon4key = 2;
    		this.w4name = "SGMissile";
    		this.ammo4 = 6;
    		this.magazine4 = 4;
    		this.reload_time4 = 80;
    		this.reloadsoundset4 = 20;
    		this.reloadsound4 = GVCSoundEvent.reload_cannon;
    		this.w4cycle = 1;
    		this.w4barst = 1;
    		this.weapon4 = 1;
    		this.w4crossfire = true;
    		{
    			this.bullet_type4[0] = 13;
        		this.bullet_model4[0] = "gvclib:textures/entity/model/bullet_small_missile.mqo";
        		this.bullet_tex4[0] = "gvclib:textures/entity/model/bullet_small_missile.png";
        		this.fire_model4[0]= "gvclib:textures/entity/msmoke.mqo";
        		this.fire_tex4[0] = "gvclib:textures/entity/msmoke.png";
        		this.fire_time4[0] = 16;
        		this.sound_fire4[0] = "gvclib.fire_missile";
        		this.fire_pointx4[0] = -0.6F;
        		this.fire_pointy4[0] = 4.3F;
        		this.fire_pointz4[0] = -3.4F;
        		this.basis_pointx4[0] = -0.6F;
        		this.basis_pointy4[0] = 4.3F;
        		this.basis_pointz4[0] = -3.4F;
        		this.fire_yoffset4[0] = 3;
        		this.rotationfollowing4[0] = true;
        		this.rotationfirepoint4[0] = true;
        		this.bullet_damage4[0] = 60;
        		this.bullet_speed4[0] = 2.0F;
        		this.bullet_bure4[0] = 2F;
        		this.bullet_expower4[0] = 5F;
        		this.bullet_ex4[0] = mod_GVCR2.cfg_exprotion_player;
        		this.bullet_kazu4[0] = 1;
        		this.bullet_gravity4[0] = 0.029D;
        		this.bullet_livingtime4[0] = 8000;
        		
    		}
		}
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		this.roadattack();
		VehicleCNT_Boat.load(this, GVCSoundEvent.sound_car);
		if (this.canBeSteered() && this.getControllingPassenger() != null && this.getHealth() > 0.0F)
		{
			if(this.getControllingPassenger() instanceof EntityPlayer)
			{
				EntityPlayer entitylivingbase = (EntityPlayer) this.getControllingPassenger();
				if(this.cooltime6 > 3) {
					this.cooltime6 = 0;
					for(int w1 = 0; w1 < 2; ++w1) {
						float rotefire = this.rotationYawHead;
						double x = this.posX;
						double z = this.posZ;
						Vec3d looked = this.getLookVec();
						/*if(this.rotation_firepointbxbz1[w1]) {
							double xx1 = 0;
							double zz1 = 0;
							xx1 -= MathHelper.sin(this.rotationYaw * 0.01745329252F) * this.arm_z[w1];
							zz1 += MathHelper.cos(this.rotationYaw * 0.01745329252F) * this.arm_z[w1];
							xx1 -= MathHelper.sin(this.rotationYaw * 0.01745329252F  -1.57F) * this.arm_x[w1];
							zz1 += MathHelper.cos(this.rotationYaw * 0.01745329252F -1.57F) * this.arm_x[w1];
							x = this.posX + xx1;
							z = this.posZ + zz1;
						}*/
						PL_Weapon_new we = new PL_Weapon_new(this, entitylivingbase);
						we.id = 0;
						we.model = "gvclib:textures/entity/BulletNormal.mqo";
						we.tex = "gvclib:textures/entity/BulletNormal.png";
						we.modelf = "gvclib:textures/entity/mflash.mqo";
						we.texf = "gvclib:textures/entity/mflash.png";
						we.ftime = 2;
						we.sound = SoundEvent.REGISTRY.getObject(new ResourceLocation(modid, "gvclib.fire_hmg"));
						we.sound_val = 0.1F;
						
						if(w1 == 1) {
							we.f = 0;
							we.w = 0;
							we.h = 3.45;
							we.z = -8.4;
							we.bx = 0;
							we.by = 3.45;
							we.bz = -8.4;
						}else {
							we.f = 0;
							we.w = 0;
							we.h = 4.25;
							we.z = 3.1;
							we.bx = 0;
							we.by = 4.25;
							we.bz = 3.1;
						}
						we.yoffset = -0.02F;
						we.px = x;
						we.py = this.posY;
						we.pz = z;
						//we.lock = looked;
						//we.lock_player = this.rotationfollowing1[w1];
						//we.lock_pitch_vehicle = this.rotation_lock_pitch_vehicle1[w1];
						we.rote = rotefire;
						we.maxy = 0;
						we.miny = 0;
						
						we.power = 7;
						we.speed = 4.0F;
						we.bure = 2F;
						we.ex = -1;
						we.extrue = false;
						we.kazu = 1;
						we.gra = 0.029D;
						we.maxtime = 80;
						we.dameid = 0;
						
						{
							we.AttacktaskAIGunner(this, 3, entitylivingbase, 50, 50, 20, we);
						}
				    }
				}
			}
			else if(this.getControllingPassenger() instanceof EntityGVCLivingBase && !this.getVehicleLock()) {
				EntityGVCLivingBase entitylivingbase = (EntityGVCLivingBase) this.getControllingPassenger();
			}
		}
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
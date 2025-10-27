package gvcr2.entity.vehicle.ship;

import java.util.List;

import gvclib.mod_GVCLib;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.ISoldier;
import gvclib.entity.living.PL_Weapon;
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityGVCR2_SHIP_PR1204 extends EntityMobVehicleBase
{
    public EntityGVCR2_SHIP_PR1204(World worldIn)
    {
        super(worldIn);
        this.setSize(6.0F, 5.0F);
        this.hud_icon = "gvclib:textures/hud/tank64.png";

        this.render_hud_information_5 = "V-KEY:ALLY-Boarding";
        this.render_hud_information_6 = "B-KEY:ALLY-Get off";
        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_ship_pr1204;
        
        this.sp = 0.020F;
        this.turnspeed = 1.5F;
        this.rotationp_max = -90F;
        this.rotationp_min = 10F;
		this.ridding_invisible = false;
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
		riddingy[0] = 2.2;
		riddingz[0] = 0.8;
		
		ridding_view_x=0F;
		ridding_view_y=-5F;
		ridding_view_z=-15f;
		
		antibullet_0 = 0.0F;
		antibullet_1 = 0.5F;
		antibullet_2 = 1.0F;
		antibullet_3 = 1.0F;
		this.ridding_damege = 0.75F;
		
		this.roodbreak = mod_GVCR2.cfg_movebreak;
		
		this.ridding_rotation_lock = false;
        this.rotation_max = 120F;
		
		/*{
			cloud = 2;
			cloud_x[0] = 0.5D;
			cloud_x[1] = -0.5D;
			cloud_y[0] = cloud_y[1] = 1D;
			cloud_z[0] = cloud_z[1] = -3.2D;
		}*/
		
        
        mob_attackrange_hight = true;
		mob_min_range = 60;
		mob_max_range = 100;
		
		{
			this.weapon1true = true;
    		this.weapon1key = 0;
    		this.w1name = "76mm Cannon";
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
        		this.fire_pointx1[0] = 0;
        		this.fire_pointy1[0] = 2.25F;
        		this.fire_pointz1[0] = 0.0F;
        		this.basis_pointx1[0] = 0;
        		this.basis_pointy1[0] = 2.25F;
        		this.basis_pointz1[0] = 0.0F;
        		this.fire_yoffset1[0] = 0;
        		this.rotationfollowing1[0] = true;
        		this.rotation_firepointbxbz1[0] = true;
        		this.arm_x[0] = 0.0F;
        		this.arm_z[0] = 4.0F;
        		this.rotation_player1[0] = true;
        		this.rotationfirepoint1[0] = false;
        		this.bullet_damage1[0] = 30;
        		this.bullet_speed1[0] = 2.0F;
        		this.bullet_bure1[0] = 0.5F;
        		this.bullet_expower1[0] = 2.0F;
        		this.bullet_ex1[0] = mod_GVCR2.cfg_exprotion_player;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.025D;
        		this.bullet_livingtime1[0] = 80;
        		
    		}
    		this.mob_w1range = 60;
    		this.mob_w1range_max_y = 20;
    		this.mob_w1range_min_y = -2;
		}
		
		
		{
			this.weapon2true = true;
			this.w2can_cooldown = true;
    		this.weapon2key = 2;
    		this.w2name = "23mmAAGun";
    		this.ammo2 = 3;
    		this.magazine2 = 10;
    		this.reload_time2 = 80;
    		this.reloadsoundset2 = 40;
    		this.reloadsound2 = GVCSoundEvent.reload_mg;
    		this.w2cycle = 1;
    		this.w2barst = 1;
    		this.weapon2 = 2;
    		for(int i = 0; i < 2; ++i){
    			this.bullet_type2[i] = 1;
        		this.bullet_model2[i] = "gvclib:textures/entity/BulletNormal.obj";
        		this.bullet_tex2[i] = "gvclib:textures/entity/BulletNormal.png";
        		this.fire_model2[i]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex2[i] = "gvclib:textures/entity/mflash.png";
        		this.fire_time2[i] = 5;
        		this.sound_fire2[i] = "gvclib.fire_mg";
        		this.fire_pointx2[0] = 0.4F;
        		this.fire_pointx2[1] = -0.4F;
        		this.fire_pointy2[i] = 2.4F;
        		this.fire_pointz2[i] = -7.2F;
        		this.basis_pointx2[0] = 0;
        		this.basis_pointy2[0] = 2.4F;
        		this.basis_pointz2[0] = -7.2F;
        		this.fire_yoffset2[i] = -0.03;
        		this.rotation_firepointbxbz2[0] = false;
        		this.rotationfollowing2[i] = true;
        		this.rotation_player2[0] = false;
        		this.rotationfirepoint2[i] = false;
        		this.bullet_damage2[i] = 10;
        		this.bullet_speed2[i] = 6F;
        		this.bullet_bure2[i] = 1.0F;
        		this.bullet_expower2[i] = 0;
        		this.bullet_ex2[i] = false;
        		this.bullet_kazu2[i] = 1;
        		this.bullet_gravity2[i] = 0.029D;
        		this.bullet_livingtime2[i] = 80;
        		
    		}
		}
		this.mob_w2range = 800;
		this.mob_w2range_max_y = 80;
		this.mob_w2range_min_y = 5;
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
		VehicleCNT_Boat.load(this, GVCSoundEvent.sound_car);
		
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
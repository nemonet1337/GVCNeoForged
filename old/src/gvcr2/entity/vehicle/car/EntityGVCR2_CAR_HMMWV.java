package gvcr2.entity.vehicle.car;

import java.util.List;

import gvclib.mod_GVCLib;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_TankSet;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.ISoldier;
import gvclib.entity.living.PL_TankMove;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvcr2.mod_GVCR2;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityGVCR2_CAR_HMMWV extends EntityMobVehicleBase
{

    public EntityGVCR2_CAR_HMMWV(World worldIn)
    {
        super(worldIn);
        this.setSize(3.8F, 3.0F);
        this.setcanDespawn(1);
        
        ridding_roteangle = mod_GVCR2.cfg_vehicle_angle;
        
        this.riddng_freehand = false;
        //this.hud_icon = "hmggirlfront:textures/hud/apc.png";
        //this.render_hud_icon_hori = true;
        //this.hud_icon_hori = "hmggirlfront:textures/hud/heli_hori.png";
        this.render_hud_information_2 = "R-Click:Zoom";
        this.render_hud_information_3 = "W/S-KEY:Throttle-UP/DWON";
        this.render_hud_information_4 = "A/D-KEY:TURN-RIGHT/LEFT";
        this.render_hud_information_5 = "V-KEY:ALLY-Boarding";
        this.render_hud_information_6 = "B-KEY:ALLY-Get off";
        vehicletype = 2;
        ridding_roteplayer = false;
        this.roodbreak = mod_GVCR2.cfg_movebreak;
        
        vehicle_ridding_nofire[0] = true;
        vehicle_ridding_nofire[1] = true;
        vehicle_ridding_nofire[2] = true;
        vehicle_ridding_nofire[3] = true;
        vehicle_ridding_nofire[4] = true;

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_car_hmmwv;
        
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
		this.riddng_maximum = 5;
		riddingx[0]=0.8D;
		riddingy[0]=0.9D;
		riddingz[0]=0.15D;
		{
			riddingx[1]=-0.8D;
			riddingy[1]=0.9D;
			riddingz[1]=0.15D;
			
			//riddingx[2]=0.0D;
			//riddingy[2]=2.0D;
			//riddingz[2]=-1.0D;
			riddingx[2]=0.0D;
			riddingy[2]=0.9D;
			riddingz[2]=-1.05D;
			
			riddingx[3]=0.8D;
			riddingy[3]=0.9D;
			riddingz[3]=-1.05D;
			riddingx[4]=-0.8D;
			riddingy[4]=0.9D;
			riddingz[4]=-1.05D;
			
		}
		
		
		ridding_view_x=0F;
		ridding_view_y=-2F;
		ridding_view_z=-5F;
		ridding_view_gunner_x=0F;
		ridding_view_gunner_y=2F;
		ridding_view_gunner_z=1F;
		
		antibullet_0 = 0.0F;
		antibullet_1 = 0.5F;
		antibullet_2 = 1.0F;
		antibullet_3 = 1.1F;
		this.ridding_damege = 0.5F;
		
		
		mob_min_range = 10;
		mob_max_range = 30;
		
			
			this.ridding_rotation_lock = false;
	        this.rotation_max = 180F;
			
			
			
		
		
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(120D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }

    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		this.setcanDespawn(1);
		this.riddng_freehand = false;
		float f1 = this.rotationYawHead * (2 * (float) Math.PI / 360);
		this.roadattack();
		this.setcanDespawn(1);
		this.typecar();
		
		this.ContMobRidding();
		
		/*if(this.getArmID_L() == 1) {
			riddingx[2]=0.0D;
			riddingy[2]=2.0D;
			riddingz[2]=-1.0D;
			
			this.weapon1true = true;
			this.weapon1key = 0;
			this.ammo1 = 3;
			this.magazine = 30;
			reload_time1 = 100;
			this.w1name = "MachineGun";
			this.w1cycle = 1;
			this.w1barst = 1;
			this.weapon1 = 1;
			{
				this.bullet_type1[0] = 0;
				this.bullet_model1[0] = "gvclib:textures/entity/BulletNormal.obj";
				this.bullet_tex1[0] = "gvclib:textures/entity/BulletNormal.png";
				this.fire_model1[0] = "gvclib:textures/entity/mflash.mqo";
				this.fire_tex1[0] = "gvclib:textures/entity/mflash.png";
				this.fire_time1[0] = 2;
				this.sound_fire1[0] = "gvclib.fire_rifle";
				this.fire_pointx1[0] = 0;
				this.fire_pointy1[0] = 3.1F;
				this.fire_pointz1[0] = 2.3F;
				this.basis_pointx1[0] = 0;
        		this.basis_pointy1[0] = 3.1F;
        		this.basis_pointz1[0] = 0.35F;
				this.fire_yoffset1[0] = 0;
				this.rotationfollowing1[0] = true;
        		this.rotation_player1[0] = true;
        		this.rotationfirepoint1[0] = false;
        		this.rotation_mob_head1[0] = true;
        		this.rotation_firepointbxbz1[0] = true;
        		this.arm_x[0] = 0.0F;
        		this.arm_z[0] = 0.0F;
				this.bullet_damage1[0] = 8;
				this.bullet_speed1[0] = 3.5F;
				this.bullet_bure1[0] = 1.0F;
				this.bullet_expower1[0] = 0F;
				this.bullet_ex1[0] = false;
				this.bullet_kazu1[0] = 1;
				this.bullet_gravity1[0] = 0.029D;
				this.bullet_livingtime1[0] = 80;

			}
			this.mob_min_range = 15;
			this.mob_max_range = 30;
			this.mob_w1range = 30;
			this.mob_w1range_max_y = 20;
			this.mob_w1range_min_y = 5;
		}else {
			
			riddingx[2]=0.0D;
			riddingy[2]=0.9D;
			riddingz[2]=-1.05D;
			
			this.weapon1true = false;
			this.weapon1key = 0;
			this.ammo1 = 0;
			this.magazine = 0;
			reload_time1 = 0;
			this.w1name = null;
		}*/
		
    }

   
}
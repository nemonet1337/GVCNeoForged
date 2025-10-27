package gvcr2.entity.vehicle.set;

import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.cnt.VehicleCNT_Turret;
import gvclib.event.GVCSoundEvent;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityGVCR2_SET_CANNON_Pak40 extends EntityMobVehicleBase
{
    public EntityGVCR2_SET_CANNON_Pak40(World worldIn)
    {
        super(worldIn);
        this.setSize(2.0F, 1.0F);
        this.render_hud_icon = false;
        this.hud_icon = "gvclib:textures/hud/vehicle.png";
        this.render_hud_scope = false;
        this.hud_icon_scope = "siegecraftww3:textures/misc/scope_tank.png";
        this.render_hud_scope_zoom = false;
        this.hud_icon_scope_zoom = "siegecraftww3:textures/misc/scope_tank_zoom.png";
        

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_set_mg_pak40;
        
        this.sp = 0.0F;
        this.turnspeed = 1.5F;
        this.rotationp_max = -40F;
        this.rotationp_min = 20F;
        this.ridding_rotation_lock = true;
        this.rotation_max = 12F;
        this.angle_offset = -10;
        
		this.ridding_invisible = false;
		this.riddng_opentop = true;
		riddingx[0] = 0.6;
		riddingy[0] = 0.0;
		riddingz[0] = -0.8;
		
		this.ridding_view1_x = 0.0F;
		this.ridding_view1_y = 0.0F;
		this.ridding_view1_z = 1.4F;
		
		antibullet_0 = 0.0F;
		antibullet_1 = 0.5F;
		antibullet_2 = 1.0F;
		antibullet_3 = 1.0F;
		this.ridding_damege = 1.0F;
		
		this.roodbreak = true;
		
		this.weapon1_auto_reload = true;
		
		{
			cloud = 0;
		}
		
		mob_min_range = 20;
		mob_max_range = 50;
		
		{
			this.weapon1true = true;
    		this.weapon1key = 0;
    		this.w1name = "76.2mmCANNON";
    		this.ammo1 = 20;
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
        		this.sound_fire1[0] = "gvclib.fire_cannon";
        		this.fire_pointx1[0] = 0;
        		this.fire_pointy1[0] = 0.9F;
        		this.fire_pointz1[0] = 2.0F;
        		this.basis_pointx1[0] = 0;
        		this.basis_pointy1[0] = 0.9F;
        		this.basis_pointz1[0] = 0.4F;
        		this.fire_yoffset1[0] = 0;
        		this.rotationfollowing1[0] = true;
        		this.rotationfirepoint1[0] = false;
        		this.rotation_player1[0] = false;
        		this.bullet_damage1[0] = 40;
        		this.bullet_speed1[0] = 4.0F;
        		this.bullet_bure1[0] = 1.0F;
        		this.bullet_expower1[0] = 3.0F;
        		this.bullet_ex1[0] = mod_GVCR2.cfg_exprotion_player;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.029D;
        		this.bullet_livingtime1[0] = 80;
        		
    		}
		}
		
		this.mob_w1range = 50;
		this.mob_w1range_max_y = 50;
		this.mob_w1range_min_y = 2;
		
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		//this.roadattackPC(1);
		this.typeTurret();
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
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 4, false,  false);
		}
		if (this.deathTicks == 200 && !this.world.isRemote) {
			this.setDead();
		}
		/*if (this.deathTicks == 1 && !this.world.isRemote) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 3, false,  false);
		}
		if (this.deathTicks == 200 && !this.world.isRemote) {
			this.setDead();
		}*/
	}
}
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

public class EntityGVCR2_SET_MG_DP28 extends EntityMobVehicleBase
{
    public EntityGVCR2_SET_MG_DP28(World worldIn)
    {
        super(worldIn);
        this.setSize(1.0F, 1.0F);
        this.render_hud_icon = false;
        this.hud_icon = "gvclib:textures/hud/vehicle.png";
        this.render_hud_scope = false;
        this.hud_icon_scope = "siegecraftww3:textures/misc/scope_tank.png";
        this.render_hud_scope_zoom = false;
        this.hud_icon_scope_zoom = "siegecraftww3:textures/misc/scope_tank_zoom.png";
        

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_set_mg_dp28;
        
        this.sp = 0.0F;
        this.turnspeed = 3.0F;
        this.angle_offset = -10;
        this.rotationp_max = -80F;
        this.rotationp_min = 60F;
		this.ridding_invisible = false;
		this.riddng_opentop = true;
		this.render_rader = false;
		riddingx[0] = 0.0;
		riddingy[0] = 0.2;
		riddingz[0] = -1.5;
		
		this.ridding_view1_x = 0.0F;
		this.ridding_view1_y = 0.0F;
		this.ridding_view1_z = 0.0F;
		
		antibullet_0 = 0.0F;
		antibullet_1 = 0.5F;
		antibullet_2 = 1.0F;
		antibullet_3 = 1.0F;
		this.ridding_damege = 1.0F;
		this.normal_anti_bullet = 4;
		
		this.roodbreak = true;
		
		this.weapon1_auto_reload = true;
		
		{
			cloud = 0;
		}
		
		mob_min_range = 0;
		mob_max_range = 40;
		
		{
			this.weapon1true = true;
			this.w1can_cooldown = true;
    		this.weapon1key = 0;
    		this.w1name = "7.62mmMG";
    		this.ammo1 = 2;
    		this.magazine = 10;
    		this.reload_time1 = 42;
    		this.reloadsoundset1 = 40;
    		this.reloadsound1 = GVCSoundEvent.reload_mg;
    		this.w1cycle = 1;
    		this.w1barst = 1;
    		this.weapon1 = 1;
    		{
    			this.bullet_type1[0] = 0;
        		this.bullet_model1[0] = "gvclib:textures/entity/BulletNormal.mqo";
        		this.bullet_tex1[0] = "gvclib:textures/entity/BulletNormal.png";
        		this.fire_model1[0]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/mflash.png";
        		this.fire_time1[0] = 2;
        		this.sound_fire1[0] = "gvclib.fire_mg";
        		this.fire_pointx1[0] = 0;
        		this.fire_pointy1[0] = 1.2F;
        		this.fire_pointz1[0] = 1.0F;
        		this.basis_pointx1[0] = 0;
        		this.basis_pointy1[0] = 0.9F;
        		this.basis_pointz1[0] = 0.0F;
        		this.fire_yoffset1[0] = -0.02F;
        		this.rotationfollowing1[0] = true;
        		this.rotationfirepoint1[0] = false;
        		this.rotation_player1[0] = true;
        		this.bullet_damage1[0] = 5;
        		this.bullet_speed1[0] = 4.0F;
        		this.bullet_bure1[0] = 1.0F;
        		this.bullet_expower1[0] = 0F;
        		this.bullet_ex1[0] = false;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.029D;
        		this.bullet_livingtime1[0] = 80;
        		
    		}
		}
		
		this.mob_w1range = 40;
		this.mob_w1range_max_y = 40;
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
			//GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 2, false,  false);
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
package gvcr2.entity.vehicle.air;

import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.cnt.VehicleCNT_AirCraft;
import gvclib.event.GVCSoundEvent;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityGVCR2_AIR_MIG17 extends EntityMobVehicleBase
{
    public EntityGVCR2_AIR_MIG17(World worldIn)
    {
        super(worldIn);
        this.setSize(8F, 4F);
        this.ridding_sneakdismount = false;
        this.riddng_freehand = true;
        this.hud_icon = "gvclib:textures/hud/target.png";
        this.render_hud_icon_hori = true;
        this.hud_icon_hori = "gvclib:textures/hud/air.png";
        this.render_hud_information_1 = "Z-KEY:Get off";
        this.render_hud_information_2 = "W/S-KEY:Throttle-UP/DWON";
        this.render_hud_information_3 = "SPEAC/SHIFT-KEY:UP/DWON";
        this.render_hud_information_4 = "Mouse-UP/DOWN:PICTH-UP/DOWN";
        vehicletype = 1;
        ridding_roteplayer = false;

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_air_mig17;
        
        this.sp = 0.025F;//0.025
        this.turnspeed = 4F;
        this.rotationp_max = -90F;
        this.rotationp_min = 90F;
		this.ridding_invisible = false;
		this.riddng_opentop = true;
		this.renderhud = true;
        this.thmax = 20F;
		this.thmin = -2F;
		this.thmaxa = 0.2F;
		this.thmina = -0.05F;
		this.stepHeight = 1.5F;
		riddingx[0]=0D;
		riddingy[0]=1.85D;
		riddingz[0]=2.0D;
		ridding_view_x=0F;
		ridding_view_y=-5F;
		ridding_view_z=-15f;
		ridding_view_gunner_x=0F;
		ridding_view_gunner_y=2F;
		ridding_view_gunner_z=1F;
		
		antibullet_0 = 0.5F;
		antibullet_1 = 1.0F;
		antibullet_2 = 2.0F;
		antibullet_3 = 2.0F;
		this.ridding_damege = 0.25F;
		
		this.roodbreak = mod_GVCR2.cfg_movebreak;
		
		mob_min_height = 20;
		
		/*this.slot_max = 27;
		
		this.can_fuel = true;
		this.fuel_max = 1200;
		this.fuel_item = Items.COAL;
		this.can_weapon1 = true;
		this.weapon1_item = Items.APPLE;
		this.can_weapon2 = true;
		this.weapon2_item = Items.APPLE;*/
		
		
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
		
		mob_min_range = 80;
		mob_max_range = 100;
		mob_min_height = 20;
		
		{
			this.weapon1type = 1;
			this.weapon1true = true;
			this.w1can_cooldown = true;
    		this.weapon1key = 0;
    		this.w1name = "23mmMC";
    		this.ammo1 = 2;
    		this.magazine = 20;
    		this.reload_time1 = 60;
    		this.reloadsoundset1 = 40;
    		this.reloadsound1 = GVCSoundEvent.reload_mg;
    		this.w1cycle = 1;
    		this.w1barst = 1;
    		this.weapon1 = 1;
    		this.w1crossfire = true;
    		{
    			this.bullet_type1[0] = 1;
        		this.bullet_model1[0] = "gvclib:textures/entity/model/bullet_aaa.mqo";
        		this.bullet_tex1[0] = "gvclib:textures/entity/model/bullet_aaa.png";
        		this.fire_model1[0]= "gvclib:textures/entity/msmoke.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/msmoke.png";
        		this.fire_time1[0] = 2;
        		this.sound_fire1[0] = "gvclib.fire_30mm";
        		this.fire_pointx1[0] = 0.5F;
        		this.fire_pointy1[0] = 0.5F;
        		this.fire_pointz1[0] = 4.5F;
        		this.basis_pointx1[0] = 0;
        		this.basis_pointy1[0] = (float) (riddingy[0] + 1.25F);
        		this.basis_pointz1[0] = 0.0F;
        		this.fire_yoffset1[0] = 0;
        		this.rotationfollowing1[0] = true;
        		this.rotationfirepoint1[0] = false;
        		this.rotation_player1[0] = true;
        		this.bullet_damage1[0] = 10;
        		this.bullet_speed1[0] = 5F;
        		this.bullet_bure1[0] = 1F;
        		this.bullet_expower1[0] = 1.0F;
        		this.bullet_ex1[0] = false;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.029D;
        		this.bullet_livingtime1[0] = 80;
        		
    		}
		}
		
		this.mob_w1range = 100;
		this.mob_w1range_max_y = 10;
		this.mob_w1range_min_y = 60;
		
		this.weapon2type = 1;
		{
			this.weapon2true = true;
    		this.weapon2key = 0;
    		this.w2name = "76mmRocket";
    		this.ammo2 = 4;
    		this.magazine2 = 4;
    		this.reload_time2 = 100;
    		this.reloadsoundset2 = 40;
    		this.reloadsound2 = GVCSoundEvent.reload_cannon;
    		this.w2cycle = 1;
    		this.w2barst = 1;
    		this.weapon2 = 1;
    		this.w2crossfire = true;
    			this.bullet_type2[0] = 3;
        		this.bullet_model2[0] = "gvclib:textures/entity/BulletRocket.obj";
        		this.bullet_tex2[0] = "gvclib:textures/entity/BulletRocket.png";
        		this.fire_model2[0]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex2[0] = "gvclib:textures/entity/mflash.png";
        		this.fire_time2[0] = 5;
        		this.sound_fire2[0] = "gvclib.fire_roket";
        		this.fire_pointx2[0] = 1.2F;
        		this.fire_pointy2[0] = 0.9F;
        		this.fire_pointz2[0] = 0.5F;
        		this.basis_pointx1[0] = 1.2F;
        		this.basis_pointy1[0] = (float) (riddingy[0] + 1.25F);
        		this.basis_pointz1[0] = 0F;
        		this.fire_yoffset2[0] = 0;
        		this.rotationfollowing2[0] = true;
        		this.rotationfirepoint2[0] = true;
        		this.bullet_damage2[0] = 40;
        		this.bullet_speed2[0] = 4F;
        		this.bullet_bure2[0] = 1.0F;
        		this.bullet_expower2[0] = 2;
        		this.bullet_ex2[0] = mod_GVCR2.cfg_exprotion_player;
        		this.bullet_kazu2[0] = 1;
        		this.bullet_gravity2[0] = 0.029D;
        		this.bullet_livingtime2[0] = 80;
		}
		this.mob_w2range = 100;
		this.mob_w2range_max_y = 10;
		this.mob_w2range_min_y = 60;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		//this.roadattackPC(1);
		VehicleCNT_AirCraft.load(this, GVCSoundEvent.sound_jet1, true);
		//this.typePCAirCraft_NEW(GVCSoundEvent.sound_heli);
    }

    
   protected void onDeathUpdate() {
		++this.deathTicks;
		int x = this.world.rand.nextInt(4);
		int y = this.world.rand.nextInt(5);
		int z = this.world.rand.nextInt(4);
		if(this.thpower > 1){
			this.thpower = this.thpower - this.thmina * 4;
		}
		if (this.deathTicks == 1 && !this.world.isRemote) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 3, false,  false);
		}
		if(this.getControllingPassenger() instanceof EntityLivingBase) {
			EntityLivingBase entity = (EntityLivingBase) this.getControllingPassenger();
			if(entity.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty()) {
				entity.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
			}
			this.getControllingPassenger().dismountRidingEntity();
		}
		if (this.deathTicks >= 100 && !this.world.isRemote && this.onGround) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 3, false,  false);
			this.setDead();
		}
		if (this.deathTicks == 200 && !this.world.isRemote) {
			this.setDead();
		}
	}
}
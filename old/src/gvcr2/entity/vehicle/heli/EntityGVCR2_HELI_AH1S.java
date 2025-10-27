package gvcr2.entity.vehicle.heli;

import gvclib.entity.living.AI_AirCraftSet;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.cnt.VehicleCNT_AirCraft;
import gvclib.entity.living.cnt.VehicleCNT_Heli;
import gvclib.event.GVCSoundEvent;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.so.EntityGVCR2_SO_S;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityGVCR2_HELI_AH1S extends EntityMobVehicleBase
{
    public EntityGVCR2_HELI_AH1S(World worldIn)
    {
        super(worldIn);
        this.setSize(4.2F, 2.8F);
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
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_heli_ah1s;
        
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
		riddingx[0]=0D;
		riddingy[0]=1.0D;
		riddingz[0]=1.8D;
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
        		this.fire_pointx1[0] = 1.75F;
        		this.fire_pointy1[0] = 0.9F;
        		this.fire_pointz1[0] = 0.5F;
        		this.basis_pointx1[0] = 1.75F;
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
    		this.w2name = "20mmMC";
    		this.ammo2 = 2;
    		this.magazine2 = 30;
    		this.reload_time2 = 70;
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
        		this.fire_pointy2[0] = 0.6F;
        		this.fire_pointz2[0] = 0.0F;
        		this.basis_pointy2[0] = 2.25F;
        		this.basis_pointz2[0] = 0.0F;
        		this.fire_yoffset2[0] = 0;
        		this.rotationfollowing2[0] = true;
        		this.rotationfirepoint2[0] = true;
        		this.rotation_player2[0] = true;
        		this.rotation_firepointbxbz2[0] = true;
        		this.arm_x[0] = 0.0F;
        		this.arm_z[0] = 2.9F;
        		this.bullet_damage2[0] = 10;
        		this.bullet_speed2[0] = 4.0F;
        		this.bullet_bure2[0] = 1F;
        		this.bullet_expower2[0] = 1.5F;
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		if(this.getFTMode() == 34) {
			this.setcanDespawn(1);
			this.thpower = thmax;
			this.throttle = thmax;
			//this.rotationp = this.rotationPitch = 0;
			Vec3d looked = this.getLookVec();
			if (startuptime <= 40 || startuptime >= mod_GVCR2.cfg_support_fighter_time - 100) {
				float f1 = this.rotationYawHead * (2 * (float) Math.PI / 360);
				AI_AirCraftSet.setheli_NEW(this, GVCSoundEvent.sound_heli, f1, sp, 0.1F);
			}else {
				VehicleCNT_Heli.load(this, GVCSoundEvent.sound_heli);
			}
			if (startuptime >= mod_GVCR2.cfg_support_fighter_time && !this.world.isRemote) {// 2
				if (this.canBeSteered() && this.getControllingPassenger() != null && this.getHealth() > 0.0F)
				{
					if(this.getControllingPassenger() instanceof EntityGVCR2_SO_S)
					{
						this.getControllingPassenger().setDead();
					}
				}
				this.setDead();
			}
		}else {
			VehicleCNT_Heli.load(this, GVCSoundEvent.sound_heli);
		}
		//this.roadattackPC(1);
		//VehicleCNT_Heli.load(this, GVCSoundEvent.sound_heli);
		//this.typePCHeli_NEW(GVCSoundEvent.sound_heli);
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
}
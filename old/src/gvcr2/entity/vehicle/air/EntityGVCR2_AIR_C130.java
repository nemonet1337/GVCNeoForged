package gvcr2.entity.vehicle.air;

import gvclib.entity.EntityB_Shell;
import gvclib.entity.Entity_Flare;
import gvclib.entity.living.AI_AirCraftSet;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.cnt.VehicleCNT_AirCraft;
import gvclib.entity.living.cnt.ai.AI_GetTarget_OnRidding;
import gvclib.event.GVCSoundEvent;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.so.EntityGVCR2_SO_S;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_FV101;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_M551;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityGVCR2_AIR_C130 extends EntityMobVehicleBase
{
    public EntityGVCR2_AIR_C130(World worldIn)
    {
        super(worldIn);
        this.setSize(20F, 6F);
        this.ridding_sneakdismount = false;
        this.riddng_freehand = true;
        this.hud_icon = "gvclib:textures/hud/target.png";
        this.render_hud_icon_hori = true;
        this.hud_icon_hori = "gvclib:textures/hud/air.png";
        this.render_hud_icon_bomber = true;
        this.render_hud_information_1 = "Z-KEY:Get off";
        this.render_hud_information_2 = "W/S-KEY:Throttle-UP/DWON";
        this.render_hud_information_3 = "SPEAC/SHIFT-KEY:UP/DWON";
        this.render_hud_information_4 = "Mouse-UP/DOWN:PICTH-UP/DOWN";
        vehicletype = 1;
        ridding_roteplayer = false;

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.sp = 0.020F;
        this.turnspeed = 1F;
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
		this.riddng_maximum = 2;
		riddingx[0]=0.65D;
		riddingy[0]=1.6D;
		riddingz[0]=7.5D;
		riddingx[1]=-0.65D;
		riddingy[1]=1.6D;
		riddingz[1]=7.5D;
		ridding_view_x=0F;
		ridding_view_y=-5F;
		ridding_view_z=-15f;
		ridding_view_gunner_x=0F;
		ridding_view_gunner_y=2F;
		ridding_view_gunner_z=1F;
		
		antibullet_0 = 1.0F;
		antibullet_1 = 2.0F;
		antibullet_2 = 3.0F;
		antibullet_3 = 3.0F;
		this.ridding_damege = 0.25F;
		
		this.roodbreak = true;
		/*this.slot_max = 27;
		
		this.can_fuel = true;
		this.fuel_max = 1200;
		this.fuel_item = Items.COAL;
		this.can_weapon1 = true;
		this.weapon1_item = Items.APPLE;
		this.can_weapon2 = true;
		this.weapon2_item = Items.APPLE;*/
		
		
		{
			cloud = 2;
			cloud_x[0] = 3.5D;
			cloud_x[1] = -3.5D;
			cloud_y[0] = cloud_y[1] = 1D;
			cloud_z[0] = cloud_z[1] = -1.5D;
		}
		
		pera = 4;
		pera_x[0]= 7.5F;
		pera_x[1]= 3.5F;
		pera_x[2]= -3.5F;
		pera_x[3]= -7.5F;
		pera_y[0] = pera_y[1]= pera_y[2]= pera_y[3]= 3.0F;
		pera_z[0] = pera_z[1]= pera_z[2]= pera_z[3]= 3.6F;
		perarote_x[0] = perarote_x[1]= perarote_x[2]= perarote_x[3]= 0F;
		perarote_y[0] = perarote_y[1]= perarote_y[2]= perarote_y[3]= 0F;
		perarote_z[0] = perarote_z[1]= perarote_z[2]= perarote_z[3]= 5.5F;
		
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    
    public boolean spawn = false;
    int mob_count = 0;
    public void onUpdate() {
		super.onUpdate();
		//this.roadattackPC(1);
		float bsp = (float)Math.tan((this.motionX * this.motionX) + (this.motionZ * this.motionZ)) * 12;
		this.bullet_speed2[0] = bsp;
		
		//this.typePCAirCraft_NEW(GVCSoundEvent.sound_heli);
		
		if(this.getFTMode() == 30
				|| this.getFTMode() == 31
				|| this.getFTMode() == 32
				|| this.getFTMode() == 33
				|| this.getFTMode() == 34
				|| this.getFTMode() == 35) {
			this.setcanDespawn(1);
			if(this.getHealth() <= 0.0F) {
				this.thpower = 0;
				this.throttle = 0;
				this.rotationp = this.rotationPitch = 0;
			}else {
				this.thpower = thmax;
				this.throttle = thmax;
				this.rotationp = this.rotationPitch = 0;
			}
			Vec3d looked = this.getLookVec();
		//	if(this.fri != null)  ///これいる？
			{
				if(this.getFTMode() == 33){
					if (cooltime >= 15 && startuptime > 55 && startuptime < 155) {// 2
						EntityGVCR2_SO_S s = new EntityGVCR2_SO_S(this.world);
						s.setWeapon_airborne();
						s.setLocationAndAngles(this.posX, this.posY - 1,
								this.posZ, this.rotationYaw, 0F);
						
				            s.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
						if (!this.world.isRemote) {
							this.world.spawnEntity(s);
						}
							cooltime = 0;
					} // 2
				}
				if(this.getFTMode() == 35){
					if (cooltime >= 15 && startuptime > 55 && startuptime < 155) {// 2
						EntityGVCR2_SO_S s = new EntityGVCR2_SO_S(this.world);
						if(mob_count == 1) {
							s.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_mgl140));
						}else if(mob_count == 2) {
							s.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_m249));
						}else if(mob_count == 3) {
							s.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(mod_GVCR2.gvcr2_gun_type95));
						}else {
							s.setWeapon_airborne();
						}
						s.setLocationAndAngles(this.posX, this.posY - 1,
								this.posZ, this.rotationYaw, 0F);
						
				            s.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
						if (!this.world.isRemote) {
							this.world.spawnEntity(s);
							++mob_count;
						}
							cooltime = 0;
					} // 2
				}
				if(this.getFTMode() == 34){
					if (cooltime >= 15 && startuptime > 55 && startuptime < 155) {// 2
						EntityGVCR2_SO_S s = new EntityGVCR2_SO_S(this.world);
						s.setWeapon_airborne();
						s.setLocationAndAngles(this.posX, this.posY - 1,
								this.posZ, this.rotationYaw, 0F);
						 
				            s.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
						if (!this.world.isRemote) {
							this.world.spawnEntity(s);
						}
							cooltime = 0;
					} // 2
					if (startuptime == 100) {// 2
						EntityGVCR2_TANK_FV101 lt = new EntityGVCR2_TANK_FV101(this.world);
						lt.setLocationAndAngles(this.posX, this.posY - 1,
								this.posZ, this.rotationYaw, 0F);
				            lt.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
						if (!this.world.isRemote) {
							this.world.spawnEntity(lt);
						}
						EntityGVCR2_SO_S s = new EntityGVCR2_SO_S(this.world);
						s.setWeapon_airborne();
						s.setLocationAndAngles(this.posX, this.posY - 1,
								this.posZ, this.rotationYaw, 0F);
						if (!this.world.isRemote) {
							this.world.spawnEntity(s);
							s.startRiding(lt);
						}
					} // 2
				}
			}
			if (cooltime2 >= 300 && !this.world.isRemote) {// 2
				if (this.canBeSteered() && this.getControllingPassenger() != null && this.getHealth() > 0.0F)
				{
					if(this.getControllingPassenger() instanceof EntityGVCR2_SO_S)
					{
						this.getControllingPassenger().setDead();
					}
				}
				if(this.getPassengers().size() > 2)
		        {
		        	 if(this.getPassengers().get(2) != null){
		        		 if (this.getPassengers().get(2) instanceof EntityGVCLivingBase) {
		        			 this.getPassengers().get(2).setDead();
			     		}
		     		}
		        }
				this.setDead();
			}
			float f1 = this.rotationYawHead * (2 * (float) Math.PI / 360);
			AI_AirCraftSet.setfighter(this, GVCSoundEvent.sound_pera, f1, sp, 0.1F);
		}else {
			VehicleCNT_AirCraft.load(this, GVCSoundEvent.sound_jet1, true);
		}
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
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 6, false,  false);
		}
		if(this.getControllingPassenger() instanceof EntityLivingBase) {
			EntityLivingBase entity = (EntityLivingBase) this.getControllingPassenger();
			if(entity.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty()) {
				entity.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
			}
			this.getControllingPassenger().dismountRidingEntity();
		}
		if (!this.world.isRemote && this.onGround) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 6, false,  false);
			this.setDead();
		}
		if (this.deathTicks == 200 && !this.world.isRemote) {
			this.setDead();
		}
	}
}
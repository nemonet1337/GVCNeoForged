package gvcr2.entity.vehicle.air;

import gvclib.entity.EntityB_Shell;
import gvclib.entity.Entity_Flare;
import gvclib.entity.living.AI_AirCraftSet;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.cnt.VehicleCNT_AirCraft;
import gvclib.event.GVCSoundEvent;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.so.EntityGVCR2_SO_S;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_M551;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityGVCR2_AIR_SU25 extends EntityMobVehicleBase
{
    public EntityGVCR2_AIR_SU25(World worldIn)
    {
        super(worldIn);
        this.setSize(6F, 2.8F);
        this.ridding_sneakdismount = false;
        this.riddng_freehand = true;
        this.hud_icon = "gvclib:textures/hud/target.png";
        this.render_hud_icon_hori = true;
        this.hud_icon_hori = "gvclib:textures/hud/air.png";
  //      this.render_hud_icon_bomber = true;
        this.render_hud_information_1 = "Z-KEY:Get off";
        this.render_hud_information_2 = "W/S-KEY:Throttle-UP/DWON";
        this.render_hud_information_3 = "SPEAC/SHIFT-KEY:UP/DWON";
        this.render_hud_information_4 = "Mouse-UP/DOWN:PICTH-UP/DOWN";
        vehicletype = 1;
        ridding_roteplayer = false;

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_air_su25;
        
        this.sp = 0.025F;
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
		riddingx[0]=0D;
		riddingy[0]=1.1D;
		riddingz[0]=0.0D;
		this.ridding_view1_x = 0.0F;
		this.ridding_view1_y = 0.0F;
		this.ridding_view1_z = 0.0F;
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
			cloud_x[0] = 1.7D;
			cloud_x[1] = -1.7D;
			cloud_y[0] = cloud_y[1] = 2.4D;
			cloud_z[0] = cloud_z[1] = -6.2D;
		}
		
		mob_min_range = 80;
		mob_max_range = 100;
		
		{
			this.weapon1true = true;
			this.w1can_cooldown = true;
    		this.weapon1key = 0;
    		this.w1name = "30mmMC";
    		this.ammo1 = 1;
    		this.magazine = 20;
    		this.reload_time1 = 40;
    		this.reloadsoundset1 = 40;
    		this.reloadsound1 = GVCSoundEvent.reload_mg;
    		this.w1cycle = 1;
    		this.w1barst = 1;
    		this.weapon1 = 1;
    		{
    			this.bullet_type1[0] = 1;
        		this.bullet_model1[0] = "gvclib:textures/entity/model/bullet_aaa.mqo";
        		this.bullet_tex1[0] = "gvclib:textures/entity/model/bullet_aaa.png";
        		this.fire_model1[0]= "gvclib:textures/entity/non.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/non.png";
        		this.fire_time1[0] = 2;
        		this.sound_fire1[0] = "gvclib.fire_20mm";
        		this.fire_pointx1[0] = 0.25F;
        		this.fire_pointy1[0] = 1.25F;
        		this.fire_pointz1[0] = 2.8F;
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
		
		this.weapon2type = 3;
		/*{
			this.weapon2true = true;
    		this.weapon2key = 0;
    		this.w2name = "Bomb";
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
        		this.bullet_model2[0] = "gvclib:textures/entity/model/bomb.mqo";
        		this.bullet_tex2[0] = "gvclib:textures/entity/model/bomb.png";
        		this.fire_model2[0]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex2[0] = "gvclib:textures/entity/mflash.png";
        		this.fire_time2[0] = 5;
        		this.sound_fire2[0] = "gvclib.reload_clip";
        		this.fire_pointx2[0] = 4.0F;
        		this.fire_pointy2[0] = 0.6F;
        		this.fire_pointz2[0] = -2.5F;
        		this.basis_pointx1[0] = 0.0F;
        		this.basis_pointy1[0] = (float) (riddingy[0] + 1.25F);
        		this.basis_pointz1[0] = 0F;
        		this.fire_yoffset2[0] = 0;
        		this.rotationfollowing2[0] = false;
        		this.rotationfirepoint2[0] = false;
        		this.rotation_player2[0] = true;
        		this.bullet_damage2[0] = 120;
        		this.bullet_speed2[0] = 1.6F;
        		this.bullet_bure2[0] = 1.0F;
        		this.bullet_expower2[0] = 5;
        		this.bullet_ex2[0] = mod_GVCR2.cfg_exprotion_player;
        		this.bullet_kazu2[0] = 1;
        		this.bullet_gravity2[0] = 0.00D;
        		this.bullet_livingtime2[0] = 200;
		}*/
		
		this.mob_w2range = 100;
		this.mob_w2range_max_y = 10;
		this.mob_w2range_min_y = 60;
		this.mob_w3range = 100;
		this.mob_w3range_max_y = 10;
		this.mob_w3range_min_y = 60;
		
		
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    public void weapon_bay() {
    	if(this.getArmID_R() == 0) {
    		{
    			this.weapon2true = true;
        		this.weapon2key = 0;
        		this.w2name = "AGMissile";
        		this.ammo2 = 4;
        		this.magazine2 = 2;
        		this.reload_time2 = 200;
        		this.reloadsoundset2 = 40;
        		this.reloadsound2 = GVCSoundEvent.reload_cannon;
        		this.w2cycle = 1;
        		this.w2barst = 1;
        		this.weapon2 = 1;
        		this.w2crossfire = true;
        		this.w2missile_aam = false;
        			this.bullet_type2[0] = 4;
        			this.bullet_model2[0] = "gvclib:textures/entity/new/bullet_agm_small.mqo";
            		this.bullet_tex2[0] = "gvclib:textures/entity/new/bullet_agm_small.png";
            		this.fire_model2[0]= "gvclib:textures/entity/mflash.mqo";
            		this.fire_tex2[0] = "gvclib:textures/entity/mflash.png";
            		this.fire_time2[0] = 5;
            		this.sound_fire2[0] = "gvclib.fire_missile";
            		this.fire_pointx2[0] = 4.5F;
            		this.fire_pointy2[0] = 1.6F;
            		this.fire_pointz2[0] = 0.0F;
            		this.basis_pointx1[0] = 4.5F;
            		this.basis_pointy1[0] = (float) (riddingy[0] + 1.25F);
            		this.basis_pointz1[0] = 0F;
            		this.fire_yoffset2[0] = 0;
            		this.rotationfollowing2[0] = true;
            		this.rotationfirepoint2[0] = true;
            		this.bullet_damage2[0] = 60;
            		this.bullet_speed2[0] = 4F;
            		this.bullet_bure2[0] = 1.0F;
            		this.bullet_expower2[0] = 3;
            		this.bullet_ex2[0] = mod_GVCR2.cfg_exprotion_player;
            		this.bullet_kazu2[0] = 1;
            		this.bullet_gravity2[0] = 0.029D;
            		this.bullet_livingtime2[0] = 80;
    		}
    		{
    			this.weapon3true = true;
        		this.weapon3key = 0;
        		this.w3name = "Bomb";
        		this.ammo3 = 4;
        		this.magazine3 = 4;
        		this.reload_time3 = 160;
        		this.reloadsoundset3 = 40;
        		this.reloadsound1 = GVCSoundEvent.reload_cannon;
        		this.w3cycle = 1;
        		this.w3barst = 1;
        		this.weapon3 = 1;
        		this.w3crossfire = true;
        		this.w3missile_aam = false;
        			this.bullet_type3[0] = 3;
            		this.bullet_model3[0] = "gvclib:textures/entity/new/bullet_bomb_small.mqo";
            		this.bullet_tex3[0] = "gvclib:textures/entity/new/bullet_bomb_small.png";
            		this.fire_model3[0]= "gvclib:textures/entity/mflash.mqo";
            		this.fire_tex3[0] = "gvclib:textures/entity/mflash.png";
            		this.fire_time3[0] = 5;
            		this.sound_fire3[0] = "gvclib.reload_clip";
            		this.fire_pointx3[0] = 3.7F;
            		this.fire_pointy3[0] = 1.6F;
            		this.fire_pointz3[0] = 0F;
            		this.basis_pointx3[0] = 0.0F;
            		this.basis_pointy3[0] = (float) (riddingy[0] + 1.25F);
            		this.basis_pointz3[0] = 0F;
            		this.fire_yoffset3[0] = 0;
            		this.rotationfollowing3[0] = false;
            		this.rotationfirepoint3[0] = false;
            		this.rotation_player3[0] = true;
            		this.rotation_lock_pitch_vehicle3[0] = true;
            		this.bullet_damage3[0] = 120;
            		this.bullet_speed3[0] = 1.6F;
            		this.bullet_bure3[0] = 1.0F;
            		this.bullet_expower3[0] = 5;
            		this.bullet_ex3[0] = mod_GVCR2.cfg_exprotion_player;
            		this.bullet_kazu3[0] = 1;
            		this.bullet_gravity3[0] = 0.00D;
            		this.bullet_livingtime3[0] = 200;
    		}
		}
    	
    	
    	if(this.getArmID_R() == 1) {
    		{
    			this.weapon2true = true;
        		this.weapon2key = 0;
        		this.w2name = "76mmRocket";
        		this.ammo2 = 4;
        		this.magazine2 = 16;
        		this.reload_time2 = 60;
        		this.reloadsoundset2 = 40;
        		this.reloadsound2 = GVCSoundEvent.reload_cannon;
        		this.w2cycle = 1;
        		this.w2barst = 1;
        		this.weapon2 = 1;
        		this.w2crossfire = true;
        			this.bullet_type2[0] = 3;
        			this.bullet_model2[0] = "gvclib:textures/entity/new/bullet_rocket_big.mqo";
            		this.bullet_tex2[0] = "gvclib:textures/entity/new/bullet_rocket_big.png";
            		this.fire_model2[0]= "gvclib:textures/entity/mflash.mqo";
            		this.fire_tex2[0] = "gvclib:textures/entity/mflash.png";
            		this.fire_time2[0] = 5;
            		this.sound_fire2[0] = "gvclib.fire_roket";
            		this.fire_pointx3[0] = 3.7F;
            		this.fire_pointy3[0] = 1.6F;
            		this.fire_pointz3[0] = 0F;
            		this.basis_pointx2[0] = 3.7F;
            		this.basis_pointy2[0] = 1.6F;
            		this.basis_pointz2[0] = 0F;
            		this.fire_yoffset2[0] = 0;
            		this.rotationfollowing2[0] = true;
            		this.rotationfirepoint2[0] = true;
            		this.bullet_damage2[0] = 16;
            		this.bullet_speed2[0] = 4F;
            		this.bullet_bure2[0] = 1.0F;
            		this.bullet_expower2[0] = 2;
            		this.bullet_ex2[0] = mod_GVCR2.cfg_exprotion_player;
            		this.bullet_kazu2[0] = 1;
            		this.bullet_gravity2[0] = 0.029D;
            		this.bullet_livingtime2[0] = 80;
    		}
    		{
    			this.weapon3true = true;
        		this.weapon3key = 0;
        		this.w3name = "Bomb";
        		this.ammo3 = 4;
        		this.magazine3 = 4;
        		this.reload_time3 = 160;
        		this.reloadsoundset3 = 40;
        		this.reloadsound1 = GVCSoundEvent.reload_cannon;
        		this.w3cycle = 1;
        		this.w3barst = 1;
        		this.weapon3 = 1;
        		this.w3crossfire = true;
        		this.w3missile_aam = false;
        			this.bullet_type3[0] = 3;
            		this.bullet_model3[0] = "gvclib:textures/entity/new/bullet_bomb_small.mqo";
            		this.bullet_tex3[0] = "gvclib:textures/entity/new/bullet_bomb_small.png";
            		this.fire_model3[0]= "gvclib:textures/entity/mflash.mqo";
            		this.fire_tex3[0] = "gvclib:textures/entity/mflash.png";
            		this.fire_time3[0] = 5;
            		this.sound_fire3[0] = "gvclib.reload_clip";
            		this.fire_pointx3[0] = 3.7F;
            		this.fire_pointy3[0] = 1.6F;
            		this.fire_pointz3[0] = 0F;
            		this.basis_pointx3[0] = 0.0F;
            		this.basis_pointy3[0] = (float) (riddingy[0] + 1.25F);
            		this.basis_pointz3[0] = 0F;
            		this.fire_yoffset3[0] = 0;
            		this.rotationfollowing3[0] = false;
            		this.rotationfirepoint3[0] = false;
            		this.rotation_player3[0] = true;
            		this.rotation_lock_pitch_vehicle3[0] = true;
            		this.bullet_damage3[0] = 120;
            		this.bullet_speed3[0] = 1.6F;
            		this.bullet_bure3[0] = 1.0F;
            		this.bullet_expower3[0] = 5;
            		this.bullet_ex3[0] = mod_GVCR2.cfg_exprotion_player;
            		this.bullet_kazu3[0] = 1;
            		this.bullet_gravity3[0] = 0.00D;
            		this.bullet_livingtime3[0] = 200;
    		}
		}
    }
    
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    	ItemStack itemstack = player.getHeldItem(hand);
        boolean flag = !itemstack.isEmpty();
        if(!itemstack.isEmpty()&& itemstack.getItem() == mod_GVCR2.gvcr2_item_weapon_change)
        {
        	if(this.getArmID_R() == 0) {
        		this.setArmID_R(1);
        	}else {
        		this.setArmID_R(0);
        	}
        	this.playSound(GVCSoundEvent.reload_shell, 1F, 1F);
        	return false;
        }
        else {
        	return super.processInteract(player, hand);
        }
    }
    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		//this.roadattackPC(1);
		
		if(this.getArmID_R() == 2) {
			float bsp = (float)Math.tan((this.motionX * this.motionX) + (this.motionZ * this.motionZ)) * 10;
			this.bullet_speed3[0] = bsp;
		}
		{
			this.weapon_bay();
		}
		
		//this.typePCAirCraft_NEW(GVCSoundEvent.sound_heli);
		
		if(this.getFTMode() == 30
				|| this.getFTMode() == 31
				|| this.getFTMode() == 32
				|| this.getFTMode() == 33
				|| this.getFTMode() == 34
				|| this.getFTMode() == 35) {
			this.setcanDespawn(1);
			this.thpower = thmax;
			this.throttle = thmax;
			this.rotationp = this.rotationPitch = 0;
			Vec3d looked = this.getLookVec();
			if(this.fri != null)
			{
				if(this.getFTMode() == 35){
					if (cooltime >= 1 && startuptime > 40 && startuptime < 90) {// 2
						EntityB_Shell entitysnowball = new EntityB_Shell(this.world, this.fri);
						entitysnowball.setModel("gvclib:textures/entity/model/bullet_aaa.mqo");
						entitysnowball.setTex("gvclib:textures/entity/model/bullet_aaa.png");
						entitysnowball.Bdamege = 18;
						entitysnowball.friend = this;
						entitysnowball.exlevel = 1.5F;
						entitysnowball.ex = mod_GVCR2.cfg_exprotion_player;
						entitysnowball.gra = 0.03;
						entitysnowball.setLocationAndAngles(this.posX, this.posY - 1,
								this.posZ, this.rotationYaw, 0F);
						entitysnowball.setThrowableHeading(looked.x, looked.y - 0.5F, looked.z, 3.0F, 3.0F);
						if (!this.world.isRemote) {
							this.world.spawnEntity(entitysnowball);
						}
						this.world.playSound((EntityPlayer)null, this.posX, this.posY, this.posZ, GVCSoundEvent.fire_20mm, SoundCategory.WEATHER, 2.0F, 1.0F);
							cooltime = 0;
					} // 2
				}
				/*if(this.getFTMode() == 30){
					if (cooltime >= 6 && startuptime > 50 && startuptime < 150) {// 2
						EntityB_Shell entitysnowball = new EntityB_Shell(this.world, this.fri);
						entitysnowball.setModel("gvclib:textures/entity/model/bomb.mqo");
						entitysnowball.setTex("gvclib:textures/entity/model/bomb.png");
						entitysnowball.Bdamege = 60;
						entitysnowball.friend = this;
						entitysnowball.exlevel = 3.0F;
						entitysnowball.ex = mod_GVCR2.cfg_exprotion_player;
						entitysnowball.gra = 0;
						entitysnowball.setLocationAndAngles(this.posX, this.posY - 1,
								this.posZ, this.rotationYaw, 0F);
						entitysnowball.setThrowableHeading(looked.x, looked.y - 0.5F, looked.z, 0.5F, 1.0F);
						if (!this.world.isRemote) {
							this.world.spawnEntity(entitysnowball);
						}
							cooltime = 0;
					} // 2
				}
				if(this.getFTMode() == 31){
					if (cooltime >= 6 && startuptime > 50 && startuptime < 150) {// 2
						Entity_Flare flare = new Entity_Flare(this.world);
						flare.id = 0;
						flare.gra = 0.7D;
						flare.setLocationAndAngles(this.posX, this.posY - 1,
								this.posZ, this.rotationYaw, 0F);
						if (!this.world.isRemote) {
							this.world.spawnEntity(flare);
						}
							cooltime = 0;
					} // 2
				}
				if(this.getFTMode() == 32){
					if (cooltime >= 6 && startuptime > 50 && startuptime < 150) {// 2
						Entity_Flare flare = new Entity_Flare(this.world);
						flare.id = 1;
						flare.gra = 1.0D;
						flare.setLocationAndAngles(this.posX, this.posY - 1,
								this.posZ, this.rotationYaw, 0F);
						if (!this.world.isRemote) {
							this.world.spawnEntity(flare);
						}
							cooltime = 0;
					} // 2
				}*/
			}
			if (cooltime2 >= 200 && !this.world.isRemote) {// 2
				if (this.canBeSteered() && this.getControllingPassenger() != null && this.getHealth() > 0.0F)
				{
					if(this.getControllingPassenger() instanceof EntityGVCR2_SO_S)
					{
						this.getControllingPassenger().setDead();
					}
				}
				this.setDead();
			}
			float f1 = this.rotationYawHead * (2 * (float) Math.PI / 360);
			AI_AirCraftSet.setfighter(this, GVCSoundEvent.sound_jet1, f1, sp, 0.1F);
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
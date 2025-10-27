package gvcr2.entity.vehicle.air;

import java.util.List;

import gvclib.entity.EntityB_Shell;
import gvclib.entity.Entity_Flare;
import gvclib.entity.living.AI_AirCraftSet;
import gvclib.entity.living.AI_EntityWeapon_new;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.EntityVehicleBase;
import gvclib.entity.living.cnt.VehicleCNT_AirCraft;
import gvclib.entity.living.cnt.ai.AI_GetTarget_OnRidding;
import gvclib.event.GVCSoundEvent;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.so.EntityGVCR2_SO_S;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_M551;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityGVCR2_AIR_AN2 extends EntityMobVehicleBase
{
    public EntityGVCR2_AIR_AN2(World worldIn)
    {
    	super(worldIn);
        this.setSize(8F, 4F);
        this.ridding_sneakdismount = false;
        this.riddng_freehand = false;
        this.hud_icon = "gvclib:textures/hud/target.png";
        this.render_hud_icon_hori = true;
        this.hud_icon_hori = "gvclib:textures/hud/air.png";
//        this.render_hud_icon_bomber = true;
        this.render_hud_information_1 = "Z-KEY:Get off";
        this.render_hud_information_2 = "W/S-KEY:Throttle-UP/DWON";
        this.render_hud_information_3 = "SPEAC/SHIFT-KEY:UP/DWON";
        this.render_hud_information_4 = "Mouse-UP/DOWN:PICTH-UP/DOWN";
        this.render_hud_information_5 = "G-KEY:Cruising_MODE";
        this.render_hud_information_6 = "X-KEY:WeaponChange";
        
        ridding_roteplayer = false;

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_air_an2;
        
        this.aitypetime = 100;
        this.aitypemaxset = 3;
        mob_min_height = 25;
        this.aitypemaxset2 = 3;
        vehicletype = 4;
        
        this.sp = 0.015F;
        this.turnspeed = 1F;
        this.rotationp_max = -90F;
        this.rotationp_min = 90F;
		this.ridding_invisible = false;
		this.riddng_opentop = true;
		this.renderhud = true;
        this.thmax = 20F;
		this.thmin = -2F;
		this.thmaxa = 0.4F;
		this.thmina = -0.1F;
		this.stepHeight = 1.5F;
		this.riddng_maximum = 12;
		riddingx[0]=0D;
		riddingy[0]=1.5D;
		riddingz[0]=0.0D;
		
		riddingx[1]=0D;
		riddingy[1]=2.5D;
		riddingz[1]=-2.5D;
		
		riddingx[2]=0.6D;
		riddingx[3]=-0.6D;
		riddingy[2]= riddingy[3] =1.6D;
		riddingz[2]= riddingz[3]=-0.65D;
		riddingx[4]=0.6D;
		riddingx[5]=-0.6D;
		riddingy[4]= riddingy[5] =1.6D;
		riddingz[4]= riddingz[5]=-1.25D;
		riddingx[6]=0.6D;
		riddingx[7]=-0.6D;
		riddingy[6]= riddingy[7] =1.6D;
		riddingz[6]= riddingz[7]=-1.85D;
		riddingx[8]=0.6D;
		riddingx[9]=-0.6D;
		riddingy[8]= riddingy[9] =1.6D;
		riddingz[8]= riddingz[9]=-2.45D;
		riddingx[10]=0.6D;
		riddingx[11]=-0.6D;
		riddingy[10]= riddingy[11] =1.6D;
		riddingz[10]= riddingz[1]=-3.05D;
		
		this.ridding_view1_x = 0.0F;
		this.ridding_view1_y = 0.0F;
		this.ridding_view1_z = 0.0F;
		/*vehicle_model_onground = true;
		vehicle_model_onground_x = 0.0D;
		vehicle_model_onground_y = 1.6D;
		vehicle_model_onground_z = 0.0D;*/
		ridding_view_x=0F;
		ridding_view_y=-5F;
		ridding_view_z=-25f;
		
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
		
		
		/*{
			cloud = 2;
			cloud_x[0] = 1.1D;
			cloud_x[1] = -1.1D;
			cloud_y[0] = cloud_y[1] = 1.7D;
			cloud_z[0] = cloud_z[1] = -4.0D;
		}*/
		model_angle_base_x = 0;
		model_angle_base_y = 0;
		model_angle_base_z = 0;
		model_angle_x = -10;
		model_angle_offset_y = 0.5F;
		
		pera = 1;
		pera_x[0]= 0.0F;
		pera_y[0]= 1.6F;
		pera_z[0]= 2.95F;
		perarote_x[0]= 0F;
		perarote_y[0]= 0F;
		perarote_z[0]= 5.5F;
		
		mob_min_range = 80;
		mob_max_range = 120;
		
		
		//爆撃コード
		this.weapon1true = true;
		this.weapon1key = 0;
		this.w1name = "Bomb";
		this.ammo1 = 2;
		this.magazine = 4;
		this.reload_time1 = 200;
		this.reloadsoundset1 = 40;
		this.reloadsound1 = GVCSoundEvent.reload_cannon;
		this.w1cycle = 1;
		this.w1barst = 1;
		this.weapon1 = 1;
		this.w1crossfire = true;
		{
			this.bullet_type1[0] = 3;
    		this.bullet_model1[0] = "gvclib:textures/entity/new/bullet_bomb_small.mqo";
    		this.bullet_tex1[0] = "gvclib:textures/entity/new/bullet_bomb_small.png";
    		this.fire_model1[0]= "gvclib:textures/entity/mflash.mqo";
    		this.fire_tex1[0] = "gvclib:textures/entity/mflash.png";
    		this.fire_time1[0] = 5;
    		this.sound_fire1[0] = "gvclib.reload_clip";
    		this.fire_pointx1[0] = 3.5F;
    		this.fire_pointy1[0] = 0.6F;
    		this.fire_pointz1[0] = 0F;
    		this.basis_pointx1[0] = 0.0F;
    		this.basis_pointy1[0] = (float) (riddingy[0] + 1.25F);
    		this.basis_pointz1[0] = 0F;
    		this.fire_yoffset1[0] = 0;
    		this.bullet_damage1[0] = 60;
    		this.bullet_speed1[0] = 1.0F;
    		this.bullet_bure1[0] = 1.0F;
    		this.bullet_expower1[0] = 4;
    		this.bullet_ex1[0] = mod_GVCR2.cfg_exprotion_player;
    		this.bullet_kazu1[0] = 1;
    		this.bullet_gravity1[0] = 0.00D;
    		this.bullet_livingtime1[0] = 200;
    		
    		this.mob_attackrange_hight = true;
    		
    		//爆撃が上手く行かないのでこっちで勝手に攻撃しないように
    		this.mob_w1range = 00;
			this.mob_w1range_max_y = 0;
			this.mob_w1range_min_y = -0;
		}
		
		this.weapon3type = 0;
		{
			{
				this.weapon3true = true;
				this.weapon3key = 0;
				this.weapon3key = 0;
				this.ammo3 = 3;
				this.magazine3 = 20;
				reload_time3 = 40;
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
					this.fire_pointx3[0] = 0.0F;
					this.fire_pointy3[0] = 2.8F;
					this.fire_pointz3[0] = 0.0F;
					this.basis_pointx3[0] = 0.0F;
	        		this.basis_pointy3[0] = 2.8F;
	        		this.basis_pointz3[0] = -2.5F;
	        		this.arm_x[0] = 0.0F;
	        		this.arm_z[0] = -1.5F;
					this.fire_yoffset3[0] = 0;
					this.rotationfollowing3[0] = false;
					this.rotationfirepoint3[0] = false;
					this.rotation_mob_head3[0] = false;
					this.rotation_firepointbxbz3[0] = true;
					this.rotation_player3[0] = true;
					this.bullet_damage3[0] = 4;
					this.bullet_speed3[0] = 4F;
					this.bullet_bure3[0] = 5.0F;
					this.bullet_expower3[0] = 0F;
					this.bullet_ex3[0] = false;
					this.bullet_kazu3[0] = 1;
					this.bullet_gravity3[0] = 0.029D;
					this.bullet_livingtime3[0] = 80;

				}
				this.mob_w3range = 60;
				this.mob_w3range_max_y = 60;
				this.mob_w3range_min_y = 0;
			}
		}
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    public void weapon_bay() {
    	if (this.canBeSteered() && this.getControllingPassenger() != null && this.getHealth() > 0.0F)
		{
    		

			if (this.getControllingPassenger() instanceof EntityPlayer) {
				// 爆撃コード
				this.rotationfollowing1[0] = false;
				this.rotationfirepoint1[0] = false;
				this.rotation_player1[0] = true;
				this.rotation_lock_pitch_vehicle1[0] = true;

				float bsp = (float) Math.tan((this.motionX * this.motionX) + (this.motionZ * this.motionZ)) * 10;
				this.bullet_speed1[0] = bsp;
			} else if (this.getControllingPassenger() instanceof EntityGVCLivingBase) {
				// 爆撃コード
				this.rotationfollowing1[0] = true;
				this.rotationfirepoint1[0] = false;
				this.rotation_player1[0] = true;
				this.rotation_lock_pitch_vehicle1[0] = false;
			}
		}
    		
    }
    
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    	ItemStack itemstack = player.getHeldItem(hand);
        boolean flag = !itemstack.isEmpty();
       /* if(!itemstack.isEmpty()&& itemstack.getItem() == mod_GVCR2.gvcr2_item_weapon_change)
        {
        	if(this.getArmID_R() == 0) {
        		this.setArmID_R(1);
        	}else {
        		this.setArmID_R(0);
        	}
        	this.playSound(GVCSoundEvent.reload_shell, 1F, 1F);
        	return false;
        }
        else */
        {
        	return super.processInteract(player, hand);
        }
    }
    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		{
			this.weapon_bay();
		}
		
		VehicleCNT_AirCraft.load(this, GVCSoundEvent.sound_jet1, true);
		airborne();
		
		// 爆撃コード
		 if(this.getControllingPassenger() instanceof EntityGVCLivingBase && !this.getVehicleLock()) {
				EntityGVCLivingBase entitylivingbase = (EntityGVCLivingBase) this.getControllingPassenger();
				//if(entitylivingbase.getattacktask()) 
				{
					target_bomber(entitylivingbase, 20);
				}
		} // 爆撃コード
		
		
		//gun_turret　機銃
		if(this.getPassengers().size() > 1)
        {
        	 if(this.getPassengers().get(1) != null){
     			if (this.getPassengers().get(1) instanceof EntityPlayer) {
     			}else
     			if (this.getPassengers().get(1) instanceof EntityGVCLivingBase) {
     				EntityGVCLivingBase entitylivingbase = (EntityGVCLivingBase)this.getPassengers().get(1);
     				if(entitylivingbase.getattacktask()) {
     					this.CNT_MobRidding_getHead(entitylivingbase, this.mob_w3range_max_y);
     				}
     				this.rotation_3  = entitylivingbase.rotationYawHead;
     				this.rotationp_3 = entitylivingbase.rotationPitch;
     				Vec3d looked = entitylivingbase.getLookVec();
     				if(target(entitylivingbase, this.mob_w3range)){
     					if(cooltime3 >= ammo3 && this.getRemain_A() > 0){
     						this.counter3 = true;
     			            cooltime3 = 0;
     					}
     					if(this.weapon3true) {
     	    		    	this.weapon3activeMob(looked, entitylivingbase, 0);
     	    		    }
     				}
     			}
     		}else {
     			this.rotation_3  = this.rotationYawHead;
 				this.rotationp_3 = this.rotationPitch;
     		}
        }//gun_turret　機銃
		
		this.ContMobRidding();
    }
    
    public static boolean target(EntityGVCLivingBase ridding, double range) {
    	boolean flags = false;
		Entity tagetentity = null;
		Entity[] targetlist = new Entity[1024];
		int targetplus = 0;
		List<Entity> llist = ridding.world.getEntitiesWithinAABBExcludingEntity(ridding, ridding
				.getEntityBoundingBox().expand(ridding.motionX, ridding.motionY, ridding.motionZ).grow(range));
		if (llist != null) {
			for (int lj = 0; lj < llist.size(); lj++) {
				Entity entity1 = (Entity) llist.get(lj);
				if (entity1.canBeCollidedWith()) {
					boolean flag = ridding.getEntitySenses().canSee(entity1);
					if (ridding.CanAttack(entity1) && entity1 != null) {
						if(((EntityLivingBase) entity1).getHealth() > 0.0F)
						{
							if(flag) 
							{
								targetlist[targetplus] = entity1;
								++targetplus;
							}
						}
					}
				}
			}
		}
		
		{
			for(int xs = 0; xs < targetlist.length; ++xs) {
				if(targetlist[xs] != null) {
					{
						if(ridding.targetentity != null) {
							double xx = targetlist[xs].posX - ridding.posX;
							double yy = targetlist[xs].posY - ridding.posY;
							double zz = targetlist[xs].posZ - ridding.posZ;
							double dxz = Math.sqrt(xx * xx + zz * zz);
							double dxyz = Math.sqrt(dxz * dxz + yy * yy);
							
							double xxt = ridding.targetentity.posX - ridding.posX;
							double yyt = ridding.targetentity.posY - ridding.posY;
							double zzt = ridding.targetentity.posZ - ridding.posZ;
							double dxzt = Math.sqrt(xxt * xxt + zzt * zzt);
							double dxyzt = Math.sqrt(dxzt * dxzt + yyt * yyt);
							if(targetlist[xs].posY >= ridding.posY || dxyz < dxyzt) {
								ridding.targetentity = (EntityLivingBase)  targetlist[xs];
								ridding.target = true;
							}
						}else {
							ridding.targetentity = (EntityLivingBase)  targetlist[xs];
							ridding.target = true;
						}
					}
				}
			}
		}
		if(ridding.targetentity != null) {
			if(ridding.targetentity.posY >= ridding.posY)flags = true;
		}
		return flags;
	}
    
    //なぜかRemain系が上手く行かないので追加
    public int mag = 0;
    public int mag_reload = 0;
    public int cooltime_bomb = 0;
    public void target_bomber(EntityGVCLivingBase ridding, double range) {
    	++cooltime_bomb;
    	//if(ridding.targetentity == null)
    	{
    		Entity tagetentity = null;
    		Entity[] targetlist = new Entity[1024];
    		int targetplus = 0;
    		List<Entity> llist = ridding.world.getEntitiesWithinAABBExcludingEntity(ridding, ridding
    				.getEntityBoundingBox().expand(ridding.motionX, ridding.motionY, ridding.motionZ).grow(80));
    		if (llist != null) {
    			for (int lj = 0; lj < llist.size(); lj++) {
    				Entity entity1 = (Entity) llist.get(lj);
    				if (entity1.canBeCollidedWith()) {
    					boolean flag = ridding.getEntitySenses().canSee(entity1);
    					if (ridding.CanAttack(entity1) && entity1 != null) {
    						if(((EntityLivingBase) entity1).getHealth() > 0.0F)
    						{
    							if(flag) 
    							{
    								/*targetlist[targetplus] = entity1;
    								++targetplus;*/
    								//ridding.targetentity = (EntityLivingBase) entity1;
    								EntityLivingBase targetentitys = (EntityLivingBase) entity1;
    								double xxt = targetentitys.posX - this.posX;
    								double yyt = targetentitys.posY - this.posY;
    								double zzt = targetentitys.posZ - this.posZ;
    								double ddx = Math.abs(xxt);
    								double ddz = Math.abs(zzt);
    								if ((ddx < range && ddz < range)) 
    								if(mag > 0){
    									if(this.cooltime_bomb >= 10)
    									{
    										{
    											EntityB_Shell var3 = new EntityB_Shell(ridding.world, ridding);
    											var3.Bdamege = this.bullet_damage1[0];
    											var3.gra = this.bullet_gravity1[0];// 0.025
    											//var3.friend = entity;
    											var3.friend = this;
    											var3.ex = mod_GVCR2.cfg_exprotion_mob;
    											var3.exlevel = this.bullet_expower1[0];
    											var3.setModel(this.bullet_model1[0]);
    											var3.setTex(this.bullet_tex1[0]);
    											var3.setLocationAndAngles(this.posX, this.posY-2, this.posZ, this.rotationYaw, this.rotationPitch);
    											var3.setHeadingFromThrower(this, (float)this.rotationPitch, this.rotationYaw, 0.0F,0.1F, 0F);
    											if (!this.world.isRemote) {
    												this.world.spawnEntity(var3);
    											}
    										}
    										mag = mag - 1;
    										this.cooltime_bomb = 0;
    					    			}
    								}else {
    									++mag_reload;
    									if(mag_reload >= this.reload_time1) {
    										mag = this.magazine;
    										mag_reload = 0;
    									}
    								}
    							}
    						}
    					}
    				}
    			}
    		}
    		/*for(int xs = 0; xs < targetlist.length; ++xs) {
				if(targetlist[xs] != null) {
					{
						if(ridding.targetentity != null) {
							double xx = targetlist[xs].posX - ridding.posX;
							double zz = targetlist[xs].posZ - ridding.posZ;
							double dxz = Math.sqrt(xx * xx + zz * zz);
							
							double xxt = ridding.targetentity.posX - ridding.posX;
							double zzt = ridding.targetentity.posZ - ridding.posZ;
							double dxzt = Math.sqrt(xxt * xxt + zzt * zzt);
							if(dxz < dxzt) {
								ridding.targetentity = (EntityLivingBase)  targetlist[xs];
								ridding.target = true;
							}
						}else {
							ridding.targetentity = (EntityLivingBase)  targetlist[xs];
							ridding.target = true;
						}
					}
				}
			}*/
    	}
    	
    	
    	
    	/*if(ridding.targetentity != null) {
			double xxt = ridding.targetentity.posX - ridding.posX;
			double yyt = ridding.targetentity.posY - ridding.posY;
			double zzt = ridding.targetentity.posZ - ridding.posZ;
			double ddx = Math.abs(xxt);
			double ddz = Math.abs(zzt);
			if ((ddx < range && ddz < range)) 
			if(mag > 0){
				if(this.cooltime_bomb >= 10)
				{
					{
						EntityB_Shell var3 = new EntityB_Shell(ridding.world, ridding);
						var3.Bdamege = this.bullet_damage1[0];
						var3.gra = this.bullet_gravity1[0];// 0.025
						//var3.friend = entity;
						var3.friend = this;
						var3.ex = mod_GVCR2.cfg_exprotion_mob;
						var3.exlevel = this.bullet_expower1[0];
						var3.setModel(this.bullet_model1[0]);
						var3.setTex(this.bullet_tex1[0]);
						var3.setLocationAndAngles(this.posX, this.posY-2, this.posZ, this.rotationYaw, this.rotationPitch);
						var3.setHeadingFromThrower(this, (float)this.rotationPitch, this.rotationYaw, 0.0F,0.1F, 0F);
						if (!this.world.isRemote) {
							this.world.spawnEntity(var3);
						}
					}
					mag = mag - 1;
					this.cooltime_bomb = 0;
    			}
			}else {
				++mag_reload;
				if(mag_reload >= this.reload_time1) {
					mag = this.magazine;
					mag_reload = 0;
				}
			}
    	}*/
		
	}

    public void airborne() {
    	double d5 = this.getMoveX() - this.posX;
		double d7 = this.getMoveZ() - this.posZ;
		//double ddx = Math.abs(d5);
		//double ddz = Math.abs(d7);
		double dxz = Math.sqrt(d5 * d5 + d7 * d7);
		this.setPositionAndUpdate(this.posX, this.posY, this.posZ);
		
		if(this.getFTMode() == 30) {
			if ((dxz < this.getArmID_S())) {
				this.setFTMode(31);
			}
			/*for(int ri = 2; ri < this.riddng_maximum; ++ri) {
				if(this.getPassengers().size() > ri) {
					if (this.getPassengers().get(ri) != null) {
						if (this.getPassengers().get(ri) instanceof EntityLivingBase) {
							EntityLivingBase entity = (EntityLivingBase)this.getPassengers().get(ri);
							//entity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
							entity.posX =this.posX;
							entity.prevPosX =this.prevPosX;
							//entity.serverPosX =this.serverPosX;
							entity.lastTickPosX =this.lastTickPosX;
							entity.posY =this.posY;
							entity.prevPosY =this.prevPosY;
							//entity.serverPosY =this.serverPosY;
							entity.lastTickPosY =this.lastTickPosY;
							entity.posZ =this.posZ;
							entity.prevPosZ =this.prevPosZ;
							//entity.serverPosZ =this.serverPosZ;
							entity.lastTickPosZ =this.lastTickPosZ;
							entity.setPositionAndUpdate(this.posX, this.posY, this.posZ);
						}
					}
				}
			}*/
		}
		
		if(this.getFTMode() == 31) {
					++tasktime;
					//if(tasktime > 40) 
					/*if(tasktime %10 == 0 &&  this.getPassengers().size() > 2) {
						if (this.getPassengers().get(2) != null) {
							if (this.getPassengers().get(2) instanceof EntityLivingBase) {
								EntityLivingBase entity = (EntityLivingBase)this.getPassengers().get(2);
								//entity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
								entity.setPositionAndUpdate(this.posX, this.posY, this.posZ);
								entity.dismountRidingEntity();
								//entity.posX = this.posX + this.world.rand.nextInt(4) - 2;
								//entity.posZ = this.posZ + this.world.rand.nextInt(4) - 2;
							}
						}
					}*/
					if(tasktime %10 == 0) {
						if (!this.world.isRemote) {
							EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(world);
							entityskeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mod_GVCR2.gvcr2_armor_parachute));
							entityskeleton.setWeapon_inv_airborne(false);
							entityskeleton.setcanDespawn(1);
							entityskeleton.setMoveT(1);
							entityskeleton.setMoveX(this.getMoveX());
							entityskeleton.setMoveY(this.getMoveY());
							entityskeleton.setMoveZ(this.getMoveZ());
							entityskeleton.setLocationAndAngles(this.posX, this.posY-2, this.posZ, this.rotationYaw, this.rotationPitch);
							world.spawnEntity(entityskeleton);
						}
					}
				
				if(tasktime > 100) {
					this.setFTMode(32);
					tasktime = 0;
				}
		}
		
		
		if(this.getFTMode() == 32) {
			if ((dxz > 80)) {
				if (!this.world.isRemote) {
					for(int m = 0; m < this.getPassengers().size(); ++m) {
						if (this.getPassengers().get(m) != null) {
							if (this.getPassengers().get(m) instanceof EntityLivingBase) {
								EntityLivingBase entity = (EntityLivingBase)this.getPassengers().get(m);
								entity.setDead();
							}
						}
					}
					
					this.setDead();
					
				}
			}
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
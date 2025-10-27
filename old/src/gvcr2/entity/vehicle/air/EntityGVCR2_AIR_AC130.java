package gvcr2.entity.vehicle.air;

import gvclib.mod_GVCLib;
import gvclib.entity.EntityB_Shell;
import gvclib.entity.Entity_Flare;
import gvclib.entity.living.AI_AirCraftSet;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.PL_AirCraftMove;
import gvclib.entity.living.PL_RoteModel;
import gvclib.entity.living.cnt.VehicleCNT_AirCraft;
import gvclib.entity.living.cnt.ai.AI_EntityMove_AirCraft;
import gvclib.entity.living.cnt.ai.AI_EntityMove_AirCraft_Squad;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLClientMessageKeyPressed;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityGVCR2_AIR_AC130 extends EntityMobVehicleBase
{
    public EntityGVCR2_AIR_AC130(World worldIn)
    {
        super(worldIn);
        this.setSize(10F, 6F);
        this.ridding_sneakdismount = false;
        this.riddng_freehand = true;
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
        vehicletype = 4;
        ridding_roteplayer = false;

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_air_ac130;
        
        this.sp = 0.015F;
        this.turnspeed = 0.5F;
        this.rotationp_max = -50F;
        this.rotationp_min = 50F;
		this.ridding_invisible = false;
		this.riddng_opentop = true;
		this.renderhud = true;
        this.thmax = 20F;
		this.thmin = -2F;
		this.thmaxa = 0.2F;
		this.thmina = -0.05F;
		this.stepHeight = 1.5F;
		this.riddng_maximum = 1;
		riddingx[0]=0.65D;
		riddingy[0]=1.1D;
		riddingz[0]=2.0D;
		
		this.ridding_view1_x = 0.0F;
		this.ridding_view1_y = -2.0F;
		this.ridding_view1_z = 0.0F;
		
		ridding_view_x=0F;
		ridding_view_y=-5F;
		ridding_view_z=-25f;
		ridding_view_gunner_x=0F;
		ridding_view_gunner_y=2F;
		ridding_view_gunner_z=1F;
		
		antibullet_0 = 1.0F;
		antibullet_1 = 2.0F;
		antibullet_2 = 3.0F;
		antibullet_3 = 3.0F;
		this.ridding_damege = 0.25F;
		
		this.roodbreak = mod_GVCR2.cfg_movebreak;
		
		mob_min_height = 30;
		
		/*this.slot_max = 27;
		
		this.can_fuel = true;
		this.fuel_max = 1200;
		this.fuel_item = Items.COAL;
		this.can_weapon1 = true;
		this.weapon1_item = Items.APPLE;
		this.can_weapon2 = true;
		this.weapon2_item = Items.APPLE;*/
		
		
		{
			cloud = 4;
			cloud_x[0] = 3.5D;
			cloud_x[1] = -3.5D;
			cloud_x[2] = 7.5D;
			cloud_x[3] = -7.5D;
			cloud_y[0] = cloud_y[1] = cloud_y[2] = cloud_y[3] = 2.8D;
			cloud_z[0] = cloud_z[1] = cloud_z[2] = cloud_z[3] = 1.0D;
			
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
		
		
		mob_min_range = 80;
		mob_max_range = 100;
		
		
		
		this.mob_w1range = 100;
		this.mob_w1range_max_y = 10;
		this.mob_w1range_min_y = 60;
		
		this.weapon1type = 3;
		{
			this.weapon1true = true;
    		this.weapon1key = 0;
    		this.w1name = "105mmCANNON";
    		this.ammo1 = 20;
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
        		this.fire_model1[0]= "gvclib:textures/entity/msmoke.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/msmoke.png";
        		this.fire_time1[0] = 16;
        		this.sound_fire1[0] = "gvclib.fire_cannon";
        		this.fire_pointx1[0] = 0;
        		this.fire_pointy1[0] = 1.4F;
        		this.fire_pointz1[0] = -2.7F;
        		this.basis_pointx1[0] = 0;
        		this.basis_pointy1[0] = 0.0F;
        		this.basis_pointz1[0] = 0.0F;
        		this.fire_yoffset1[0] = 0;
        		this.rotationfollowing1[0] = true;
        		this.rotationfirepoint1[0] = false;
        		this.rotation_player1[0] = false;
        		this.bullet_damage1[0] = 60;
        		this.bullet_speed1[0] = 4.0F;
        		this.bullet_bure1[0] = 1.0F;
        		this.bullet_expower1[0] = 4.0F;
        		this.bullet_ex1[0] = mod_GVCR2.cfg_exprotion_player;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.029D;
        		this.bullet_livingtime1[0] = 80;
        		
    		}
		}
		{
			this.weapon2true = true;
			this.w2can_cooldown = true;
    		this.weapon2key = 0;
    		this.w2name = "40mmCannon";
    		this.ammo2 = 4;
    		this.magazine2 = 20;
    		this.reload_time2 = 30;
    		this.reloadsoundset2 = 40;
    		this.reloadsound2 = GVCSoundEvent.reload_mg;
    		this.w2cycle = 1;
    		this.w2barst = 1;
    		this.weapon2 = 1;
    		{
    			this.bullet_type2[0] = 2;
        		this.bullet_model2[0] = "gvclib:textures/entity/model/bullet_aaa.mqo";
        		this.bullet_tex2[0] = "gvclib:textures/entity/model/bullet_aaa.png";
        		this.fire_model2[0]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex2[0] = "gvclib:textures/entity/mflash.png";
        		this.fire_time2[0] = 2;
        		this.sound_fire2[0] = "gvclib.fire_mg";
        		this.fire_pointx2[0] = 0;
        		this.fire_pointy2[0] = 0.95F;
        		this.fire_pointz2[0] = -1.15F;
        		this.basis_pointx2[0] = 0;
        		this.basis_pointy2[0] = 0.0F;
        		this.basis_pointz2[0] = -0.0F;
        		this.fire_yoffset2[0] = 0;
        		this.rotationfollowing2[0] = true;
        		this.rotationfirepoint2[0] = false;
        		this.rotation_player2[0] = true;
        		this.bullet_damage2[0] = 15;
        		this.bullet_speed2[0] = 6.0F;
        		this.bullet_bure2[0] = 2.0F;
        		this.bullet_expower2[0] = 2.5F;
        		this.bullet_ex2[0] = false;
        		this.bullet_kazu2[0] = 1;
        		this.bullet_gravity2[0] = 0.0299D;
        		this.bullet_livingtime2[0] = 80;
        		
    		}
		}
		
		{
			this.weapon3true = true;
			this.w3can_cooldown = true;
    		this.weapon3key = 0;
    		this.w3name = "20mmMC";
    		this.ammo3 = 1;
    		this.magazine3 = 80;
    		this.reload_time3 = 40;
    		this.reloadsoundset3 = 40;
    		this.reloadsound3 = GVCSoundEvent.reload_mg;
    		this.w3cycle = 1;
    		this.w3barst = 1;
    		this.weapon3 = 2;
    		for(int io = 0; io < 2; ++io){
    			this.bullet_type3[io] = 1;
        		this.bullet_model3[io] = "gvclib:textures/entity/model/bullet_aaa.mqo";
        		this.bullet_tex3[io] = "gvclib:textures/entity/model/bullet_aaa.png";
        		this.fire_model3[io]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex3[io] = "gvclib:textures/entity/mflash.png";
        		this.fire_time3[io] = 2;
        		this.sound_fire3[io] = "gvclib.fire_20mm";
        		this.fire_pointx3[io] = 0;
        		this.fire_pointy3[io] = 1.0F;
        		this.fire_pointz3[io] = 4.2F;
        		this.basis_pointx3[io] = 0;
        		this.basis_pointy3[io] = 0.0F;
        		this.basis_pointz3[io] = 0.0F;
        		this.fire_yoffset3[io] = 0;
        		this.rotationfollowing3[io] = true;
        		this.rotationfirepoint3[io] = false;
        		this.rotation_player3[io] = true;
        		this.bullet_damage3[io] = 8;
        		this.bullet_speed3[io] = 8.0F;
        		this.bullet_bure3[io] = 2.0F;
        		this.bullet_expower3[io] = 1.5F;
        		this.bullet_ex3[io] = false;
        		this.bullet_kazu3[io] = 1;
        		this.bullet_gravity3[io] = 0.0299D;
        		this.bullet_livingtime3[io] = 80;
        		
    		}
		}
		
		
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		
		/*if(this.world.isRemote){
			this.width = 30;
		}else{
			this.width = 10;
		}*/
		
		
		{
			EntityGVCR2_AIR_AC130 entity = this;
			
			//GVCLPacketHandler.INSTANCE2.sendToAll(new GVCLClientMessageKeyPressed(422, entity.getEntityId(), entity.onGround));
			//GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(422, entity.getEntityId(), entity.onGround));
			
			float f1 = entity.rotationYawHead * (2 * (float) Math.PI / 360);
	    	if(entity.getArmID_S() == 2) {
				entity.render_hud_scaleup_text1 = false;
				entity.render_hud_scaleup_text2 = false;
				entity.render_hud_scaleup_text3 = true;
			}else if(entity.getArmID_S() == 1) {
				entity.render_hud_scaleup_text1 = false;
				entity.render_hud_scaleup_text2 = true;
				entity.render_hud_scaleup_text3 = false;
			}
	    	else {
				entity.render_hud_scaleup_text1 = true;
				entity.render_hud_scaleup_text2 = false;
				entity.render_hud_scaleup_text3 = false;
			}
	    	if (entity.canBeSteered() && entity.getControllingPassenger() != null && entity.getHealth() > 0.0F)
			{
				if(entity.getControllingPassenger() instanceof EntityPlayer)
				{
				EntityPlayer entitylivingbase = (EntityPlayer) entity.getControllingPassenger();
				entity.setcanDespawn(1);
				Vec3d looked = entitylivingbase.getLookVec();
				if(entity.getFTMode() != 1 && entity.getFTMode() != 2){
					PL_AirCraftMove.movefighter(entitylivingbase, entity, entity.sp, entity.turnspeed);
				}
				else if(entity.getFTMode() == 1){
					entity.rotep = 0;
					if ((entity.rotationPitch > (entity.rotep + entity.turnspeed)) || (entity.rotationPitch < entity.rotep - entity.turnspeed)) {
						if (entity.rotationPitch < entity.rotep) {
							entity.rotationp = entity.rotationp + entity.turnspeed*1;
							entity.rotationPitch = entity.rotationPitch + entity.turnspeed*1;
							entity.prevRotationPitch = entity.prevRotationPitch + entity.turnspeed*1;
						} else if (entity.rotationPitch > entity.rotep) {
							entity.rotationp = entity.rotationp - entity.turnspeed*1;
							entity.rotationPitch = entity.rotationPitch - entity.turnspeed*1;
							entity.prevRotationPitch = entity.prevRotationPitch - entity.turnspeed*1;
						}
					}
					{
						{
							PL_RoteModel.rotemodel(entity, - turnspeed / 3);
							if(entity.throte > -30){
								entity.throte = entity.throte - 2;
							}
						}
						{
							entitylivingbase.setRenderYawOffset(this.rotationYaw - 90);
					        float f = MathHelper.wrapDegrees(entitylivingbase.rotationYaw - (this.rotationYaw - 90));
					        float f1x = MathHelper.clamp(f, -60.0F, 60.0F);
					        entitylivingbase.prevRotationYaw += f1x - f;
					        entitylivingbase.rotationYaw += f1x - f;
					        entitylivingbase.setRotationYawHead(entitylivingbase.rotationYaw);
						}
					}
					//if(entity.world.isRemote)GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(421, entity.getEntityId(), entity.rotationYaw, entity.rotationPitch));
				}
				/*else if(entity.getFTMode() == 2){
					if (entitylivingbase.moveForward > 0.0F) {
						entity.rotationPitch = entity.rotationPitch + 0.2F;
					}
					if (entitylivingbase.moveForward < 0.0F) {
						entity.rotationPitch = entity.rotationPitch - 0.2F;
					}
					if (entitylivingbase.moveStrafing < 0.0F) {
						entity.rotationYawHead = entity.rotationYawHead + entity.turnspeed* 1F;
						entity.rotationYaw = entity.rotationYaw + entity.turnspeed* 1F;
					}
					if (entitylivingbase.moveStrafing > 0.0F) {
						entity.rotationYawHead = entity.rotationYawHead - entity.turnspeed* 1F;
						entity.rotationYaw = entity.rotationYaw - entity.turnspeed* 1F;
					}
				}*/
				
				boolean left = mod_GVCLib.proxy.leftclick();
				boolean right = mod_GVCLib.proxy.rightclick();
				boolean jump = mod_GVCLib.proxy.jumped();
				boolean kx = mod_GVCLib.proxy.keyx();
				boolean kg = mod_GVCLib.proxy.keyg();
				boolean kc = mod_GVCLib.proxy.keyc();
				boolean kf = mod_GVCLib.proxy.keyf();
				if (left) {
					GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(11, entity.getEntityId()));
					entity.server1 = true;
				}
				if (right) {
					GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(12, entity.getEntityId()));
				}
				if (jump) {
					GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(13, entity.getEntityId()));
				}
				if (kx) {
					GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(14, entity.getEntityId()));
				}
				if (kg) {
					GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(15, entity.getEntityId()));
				}
				if (kc) {
					GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(16, entity.getEntityId()));
				}
				if (kf) {
					GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(19, entity.getEntityId()));
				}
				
				
				 if (entity.serverx) {
						if(entity.cooltime5 >= 5){
							if(entity.getArmID_S() == 1) {
								entity.setArmID_S(2);
							}else if(entity.getArmID_S() == 2) {
								entity.setArmID_S(0);
							}
							else {
								entity.setArmID_S(1);
							}
							entity.playSound(GVCSoundEvent.reload_shell, 1.0F, 1.0F);
							entity.cooltime5 = 0;
							
						}
						entity.serverx = false;
					}
				 if (entity.serverg) {
						if(entity.cooltime4 >= 5){
							if(entity.getFTMode() == 1) {
								entity.setFTMode(0);
							}
							/*if(entity.getFTMode() == 2) {
								entity.setFTMode(0);
							}*/
							else {
								entity.setFTMode(1);
							}
							entity.playSound(GVCSoundEvent.reload_shell, 1.0F, 1.0F);
							entity.cooltime4 = 0;
						}
						entity.serverg = false;
					}
				
				 if (entity.server1) {
					 if(entity.getFTMode() == 1) {
						 if(entity.getArmID_S() == 2){
			    				if(entity.cooltime3 >= entity.ammo3){
			    					entity.counter3 = true;
			    					entity.cooltime3 = 0;
			    				}
			    				if(entity.weapon3true) {
			    					entity.weapon3active(looked, entitylivingbase);
			        		    }
			    			}else if(entity.getArmID_S() == 1){
			    				if(entity.cooltime2 >= entity.ammo2){
			    					entity.counter2 = true;
			    					entity.cooltime2 = 0;
			    				}
			    				if(entity.weapon2true) {
			    					entity.weapon2active(looked, entitylivingbase);
			        		    }
			    			}
						 else{
			    				if(entity.cooltime >= entity.ammo1){
			    					entity.counter1 = true;
			    					entity.cooltime = 0;
			    				}
			    				if(entity.weapon1true) {
			    					entity.weapon1active(looked, entitylivingbase);
			        		    }
			    			}
					 }
					 
						entity.server1 = false;
					}
				
			    if (entity.serverf) {
					{
	    				if(entity.cooltime4 >= entity.ammo4){
	    					entity.counter4 = true;
	    					entity.cooltime4 = 0;
	    				}
	    				if(entity.weapon4true) {
	    					entity.weapon4active(looked, entitylivingbase);
	        		    }
	    			}
					entity.serverf = false;
				}
			    
//			    System.out.println(String.format("%1$.2f", entity.rotationPitch));
				}//player
				else if(entity.getControllingPassenger() instanceof EntityGVCLivingBase && !entity.getVehicleLock()) {
					EntityGVCLivingBase entitylivingbase = (EntityGVCLivingBase) entity.getControllingPassenger();
					//entity.rotation  = entitylivingbase.rotationYawHead;
					//entity.rotationp = entity.rotationPitch = entitylivingbase.rotationPitch;
					Vec3d looked = entitylivingbase.getLookVec();
					if(entitylivingbase.getOwner() != null) {
						AI_EntityMove_AirCraft_Squad.movefighter(entity, entitylivingbase, f1, entity.sp, entity.turnspeed * 0.5F, entity.mob_min_range, entity.mob_max_range, entity.mob_min_height);
					}else {
						if(entity.vehicletype == 4) {
							AI_EntityMove_AirCraft.movebomber(entity, entitylivingbase, f1, entity.sp, entity.turnspeed * 0.5F, entity.mob_min_range, entity.mob_max_range, entity.mob_min_height);
						}else {
							AI_EntityMove_AirCraft.movefighter(entity, entitylivingbase, f1, entity.sp, entity.turnspeed * 0.5F, entity.mob_min_range, entity.mob_max_range, entity.mob_min_height);
						}
					}
					if(AI_EntityWeapon.getRange(entitylivingbase, entity.mob_w1range, entity.mob_w1range_max_y, entity.mob_w1range_min_y)){
						if(entity.cooltime >= entity.ammo1 && entity.getRemain_L() > 0){
							entity.counter1 = true;
							entity.cooltime = 0;
							GVCLPacketHandler.INSTANCE2.sendToAll(new GVCLClientMessageKeyPressed(2001, entity.getEntityId(), 0));
						}
						if(entity.weapon1true) {
		    		    	entity.weapon1activeMob(looked, entitylivingbase, entity.weapon1type);
		    		    }
					}
				}
			}
			
	    	AI_AirCraftSet.setfighter(entity, GVCSoundEvent.sound_pera, f1, entity.sp, 0.1F);
//	    	System.out.println(String.format("%1$.2f", entity.rotationPitch));
			entity.catchEntityBiped();
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
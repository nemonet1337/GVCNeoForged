package gvcr2.entity.vehicle.tank;

import java.util.List;

import javax.annotation.Nullable;

import gvclib.mod_GVCLib;
import gvclib.entity.EntityBBase;
import gvclib.entity.living.AI_EntityWeapon_new;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.vehicle.VehicleBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityGVCR2_TANK_RATTE extends EntityMobVehicleBase
{
    public EntityGVCR2_TANK_RATTE(World worldIn)
    {
        super(worldIn);
        this.setSize(3.5F, 2.6F);
        ridding_roteangle = mod_GVCR2.cfg_vehicle_angle;
        this.render_hud_icon = false;
        this.hud_icon = "gvclib:textures/hud/tank.png";
        this.render_hud_scope = true;
        this.hud_icon_scope = "gvcr2:textures/misc/scope_tank.png";
        this.render_hud_scope_zoom = true;
        this.hud_icon_scope_zoom = "gvcr2:textures/misc/scope_tank_m1.png";
        
        //this.render_hud_information_6 = "X-KEY:WeaponChange";
        
        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_tank_ratte;
        
        ridding_roteplayer = false;
        ridding_roteplayerPitch = false;
        
        this.sp = 0.01F;
        this.turnspeed = 1F;
        this.rotationp_max = -30F;
        this.rotationp_min = 10F;
		this.ridding_invisible = false;
		this.riddng_opentop = false;
        this.thmax = 5F;
		this.thmin = -2F;
		this.thmaxa = 0.5F;
		this.thmina = -0.5F;
		this.stepHeight = 1.5F;
		riddingx[0] = 0.0;
		riddingy[0] = 9.5;
		riddingz[0] = 3.0;
		
		this.ridding_view1_x = 0.0F;
		this.ridding_view1_y = 0.0F;
		this.ridding_view1_z = 4.0F;
		
		ridding_view_x=0F;
		ridding_view_y=-10F;
		ridding_view_z=-30F;
		
		
		this.can_turret = true;
		this.turret_height = 1.8F;
	    this.damage_front = 60;
	    this.damage_side = 40;
	    this.damage_rear = 20;
	    this.damage_top = 10;
	    this.damage_bottom = 10;
	    
	    this.damage_turret_front = 60;
	    this.damage_turret_side = 60;
	    this.damage_turret_rear = 30;
		
		antibullet_0 = 0.0F;
		antibullet_1 = 0.2F;
		antibullet_2 = 0.8F;
		antibullet_3 = 1.0F;
		this.ridding_damege = 0.25F;
		
		this.roodbreak = mod_GVCR2.cfg_movebreak;
		
		{
			cloud = 2;
			cloud_x[0] = 0.5D;
			cloud_x[1] = -0.5D;
			cloud_y[0] = cloud_y[1] = 1D;
			cloud_z[0] = cloud_z[1] = -3.2D;
		}
		
		mob_min_range = 20;
		mob_max_range = 60;
		
		
		this.mob_w1range = 50;
		this.mob_w1range_max_y = 15;
		this.mob_w1range_min_y = 2;
		
		{
			this.weapon1true = true;
    		this.weapon1key = 0;
    		this.w1name = "280mmCannon";
    		this.ammo1 = 20;//20
    		this.magazine = 2;
    		this.reload_time1 = 160;
    		this.reloadsoundset1 = 40;
    		this.reloadsound1 = GVCSoundEvent.reload_cannon;
    		this.w1cycle = 1;
    		this.w1barst = 1;
    		this.weapon1 = 1;
    		this.w1crossfire = true;
    		{
    			this.bullet_type1[0] = 2;
        		this.bullet_model1[0] = "gvclib:textures/entity/model/bullet_cannon_small.mqo";
        		this.bullet_tex1[0] = "gvclib:textures/entity/model/bullet_cannon_small.png";
        		this.fire_model1[0]= "gvclib:textures/entity/msmoke_big.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/msmoke_big.png";
        		this.fire_time1[0] = 16;
        		this.sound_fire1[0] = "gvclib.fire_havrycannon";
        		this.fire_pointx1[0] = 2.5F;
        		this.fire_pointy1[0] = 10F;
        		this.fire_pointz1[0] = 20F;
        		this.basis_pointx1[0] = 0;
        		this.basis_pointy1[0] = 10F;
        		this.basis_pointz1[0] = 8F;
        		this.fire_yoffset1[0] = 0;
        		this.rotationfollowing1[0] = true;
        		this.rotation_player1[0] = true;
        		this.rotationfirepoint1[0] = false;
        		this.rotation_firepointbxbz1[0] = true;
        		this.arm_x[0] = 0.0F;
        		this.arm_z[0] = 3.0F;
        		this.bullet_damage1[0] = 160;
        		this.bullet_speed1[0] = 4F;
        		this.bullet_bure1[0] = 1.0F;
        		this.bullet_expower1[0] = 10F;
        		this.bullet_ex1[0] = mod_GVCR2.cfg_exprotion_player;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.029D;
        		this.bullet_livingtime1[0] = 80;
        		
    		}
    		this.mob_w1range = 50;
    		this.mob_w1range_max_y = 15;
    		this.mob_w1range_min_y = 5;
		}
		
    }

    
   
    
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		this.setVehicleLock(true);
		this.roadattack();
		this.typeTank();
		VehicleBase.roadattack_barbed(this);
		
		hitboxgvc();
		if (this.canBeSteered() && this.getControllingPassenger() != null && this.getHealth() > 0.0F)
		{
			if(this.getControllingPassenger() instanceof EntityPlayer)
			{
				Gunner();
			}
		}
    	
    }

    public void hitboxgvc() {
    	Vec3d lock = Vec3d.fromPitchYaw(this.rotationPitch, this.rotationYaw);//entity.getForward();
		double xfront = this.posX + lock.x * 7;
		double yfront = this.posY + 6;
		double zfront = this.posZ + lock.z * 7;
		
		double xmiddle = this.posX;
		double ymiddle = this.posY + 10;
		double zmiddle = this.posZ;
		
		double xrear = this.posX + lock.x * -7;
		double yrear = this.posY + 6;
		double zrear = this.posZ + lock.z * -7;
		double han = 7;
		double hany = 6;
		{
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - han), (double) (yfront - hany),(double) (zfront - han),
					(double) (xfront + han), (double) (yfront + hany), (double) (zfront + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	ImpactEntity(llist2);
	        }
		}
		{
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xrear - han), (double) (yrear - hany),(double) (zrear - han),
					(double) (xrear + han), (double) (yrear + hany), (double) (zrear + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	ImpactEntity(llist2);
	        }
		}
	}
	
	public void ImpactEntity(List llist2) {
		 for (int lj = 0; lj < llist2.size(); lj++) {
         	Entity entity1 = (Entity)llist2.get(lj);
             {
         		if ((entity1 instanceof IProjectile) && entity1 != null && entity1 != this)
                 {
         			if(entity1 instanceof EntityBBase) {
         				EntityBBase bullet = (EntityBBase) entity1;
         				if(bullet.getThrower() != this && bullet.getThrower() != getsittingPlayer()) {
         					Vec3d vec3d1 = new Vec3d(entity1.posX, entity1.posY, entity1.posZ);
             	            Vec3d vec3d = new Vec3d(entity1.posX + entity1.motionX, entity1.posY + entity1.motionY, entity1.posZ + entity1.motionZ);
             	            RayTraceResult raytraceresult = this.world.rayTraceBlocks(vec3d1, vec3d, false, true, false);
             	            if (this != null)
             	            {
             	                raytraceresult = new RayTraceResult(this);
             	            }
             	            if (raytraceresult != null)
             	            {
             	            	bullet.ImpactGVC(raytraceresult);
             	            }
             				/*if (!this.world.isRemote) {
             					entity1.setDead();
             				}*/
             				//System.out.println(String.format("000000000"));
         				}
         			}else {
         				
         			}
                 }
             }
         }
	}
	
	public EntityLivingBase getsittingPlayer() {
		EntityLivingBase entityy = null;
		if (this.canBeSteered() && this.getControllingPassenger() != null)
		{
			if(this.getControllingPassenger() instanceof EntityPlayer)
			{
				entityy = (EntityLivingBase) this.getControllingPassenger();
			}
		}
		return entityy;
	}
    
	public void Gunner() {
		Vec3d lock = Vec3d.fromPitchYaw(this.rotationPitch, this.rotationYaw);//entity.getForward();
		float yaw = this.rotationYaw * (2 * (float) Math.PI / 360);
		double xyaw = 0;
		double zyaw = 0;
		double xfront = this.posX + 0;
		double yfront = this.posY + 0;
		double zfront = this.posZ + 0;
		double han = 50;
		{//左右機銃
			xfront = this.posX + 0;
			yfront = this.posY + 8;
			zfront = this.posZ + 0;
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - han), (double) (yfront - 0),(double) (zfront - han),
					(double) (xfront + han), (double) (yfront + 80), (double) (zfront + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	GunnerTarget(llist2, -1.57F, 5F, 7.8F, -12F, 1);
	        	GunnerTarget(llist2, -1.57F, -5F, 7.8F, -12F, 2);
	        }
		}
		
		{//Flak88
			xfront = this.posX + 0;
			yfront = this.posY + 8;
			zfront = this.posZ + 0;
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - han), (double) (yfront - 0),(double) (zfront - han),
					(double) (xfront + han), (double) (yfront + 80), (double) (zfront + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	GunnerTarget(llist2, 0F, 0, 8.5F, -8, 0);
	        }
		}
		
		{//左右前機銃
			xyaw -= MathHelper.sin(yaw) * 50;
			zyaw += MathHelper.cos(yaw) * 50;
			xfront = this.posX + xyaw;
			yfront = this.posY + 0;
			zfront = this.posZ + zyaw;
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - 50), (double) (yfront - 10),(double) (zfront - 50),
					(double) (xfront + 50), (double) (yfront + 20), (double) (zfront + 50)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	GunnerTarget(llist2, -1.57F, 5F, 3.8F, 15F, 5);
	        	GunnerTarget(llist2, -1.57F, -5F, 3.8F, 15F, 6);
	        }
		}
	}
	
	public boolean CanAttack(Entity entity){
    	if(entity instanceof IMob && ((EntityLivingBase) entity).getHealth() > 0.0F){
    		return true;
    	}else/**/
    	{
    		return false;
    	}
    }
	
	public void GunnerTarget(List llist2, float ff, float ww, float hh, float zz, int id) {
		int cooltimer;
		//int mag;
		if(id == 1) {
			cooltimer = this.cooltime2;
		}else if(id == 2) {
			cooltimer = this.cooltime3;
		}else if(id == 5) {
			cooltimer = this.cooltime5;
		}else if(id == 6) {
			cooltimer = this.cooltime6;
		}else {
			cooltimer = this.cooltime4;
		}
		boolean return_rote = true;
		 for (int lj = 0; lj < llist2.size(); lj++) {
        	Entity entity1 = (Entity)llist2.get(lj);
            {
            	if (entity1.canBeCollidedWith() && entity1 != null && entity1 instanceof EntityLivingBase) {
					if (((EntityLivingBase) entity1).getHealth() > 0.0F && this.getHealth() > 0.0F && this.CanAttack(entity1)) 
					{
						
						EntityLivingBase targeted = (EntityLivingBase) entity1;
						double d5 = entity1.posX - this.posX;
						double d7 = entity1.posZ - this.posZ;
						double d6 = entity1.posY - this.posY;
						double d1 = this.posY - (entity1.posY);
						double d3 = (double) MathHelper.sqrt(d5 * d5 + d7 * d7);
						float f11 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
						
						boolean flag = this.getEntitySenses().canSee(entity1);
						if(flag) {
							if(id == 1 || id == 2){
								{
									
									if(id == 1) {
										this.rotation_1 = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
										this.rotationp_1 = -f11 + 0;
									}else if(id == 2) {
										this.rotation_2 = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
										this.rotationp_2 = -f11 + 0;
									}
								}
								 if(cooltimer > 3)
					    		{
					        			AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
										we.id = 7;
										we.model = "gvclib:textures/entity/model/bullet.mqo";
										we.tex = "gvclib:textures/entity/model/bullet.png";
										we.modelf = "gvclib:textures/entity/mflash.mqo";
										we.texf = "gvclib:textures/entity/mflash.png";
										we.ftime = 0;
										we.sound = GVCSoundEvent.fire_rifle3;
										we.f = ff;
										we.w = ww;
										we.h = hh;
										we.z = zz;
										we.bx = ww;
										we.by = hh;
										we.bz = zz;
										we.follow_rote = true;
										we.xoffset = 0;
										we.yoffset = 0;
										we.px = this.posX;
										we.py = this.posY;
										we.pz = this.posZ;
										we.lock = this.getLookVec();
										we.rote = this.rotationYawHead;
										we.maxy = 0;
										we.miny = 0;
										
										we.power = 4;
										we.speed = 4F;
										we.bure = 4F;
										we.ex = 0;
										we.extrue = false;
										we.kazu = 1;
										we.gra = 0.029;
										we.maxtime = 80;
										we.dameid = 0;
										we.target = targeted;
										we.WeaponAttack();
										if(id == 1) {
											this.cooltime2 = 0;
										}else {
											this.cooltime3 = 0;
										}
										return_rote = false;
										break;
					    			}
							 }
							if(id == 5 || id == 6){
								{
									
									if(id == 5) {
										this.rotation_5= -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
										this.rotationp_5 = -f11 + 0;
									}else if(id == 6) {
										this.rotation_6 = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
										this.rotationp_6 = -f11 + 0;
									}
								}
								 if(cooltimer > 3)
					    		{
									 AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
										we.id = 0;
										we.model = "gvclib:textures/entity/model/bullet.mqo";
										we.tex = "gvclib:textures/entity/model/bullet.png";
										we.modelf = "gvclib:textures/entity/mflash.mqo";
										we.texf = "gvclib:textures/entity/mflash.png";
										we.ftime = 0;
										we.sound = GVCSoundEvent.fire_rifle3;
										we.f = ff;
										we.w = ww;
										we.h = hh;
										we.z = zz;
										we.bx = ww;
										we.by = hh;
										we.bz = zz;
										we.follow_rote = true;
										we.xoffset = 0;
										we.yoffset = 0;
										we.px = this.posX;
										we.py = this.posY;
										we.pz = this.posZ;
										we.lock = this.getLookVec();
										we.rote = this.rotationYawHead;
										we.maxy = 0;
										we.miny = 0;
										
										we.power = 4;
										we.speed = 3F;
										we.bure = 4F;
										we.ex = 0;
										we.extrue = false;
										we.kazu = 1;
										we.gra = 0.029;
										we.maxtime = 80;
										we.dameid = 0;
										we.target = targeted;
										we.WeaponAttack();
									 
										if(id == 5) {
											this.cooltime5 = 0;
										}else {
											this.cooltime6 = 0;
										}
										return_rote = false;
										break;
					    			}
							 }
							if(id == 0){
								 this.rotation_4 = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
								this.rotationp_4 = -f11 + 0;
								 if(cooltimer > 60)
					    		{
									 AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
										we.id = 2;
										we.model = "gvclib:textures/entity/model/bullet.mqo";
										we.tex = "gvclib:textures/entity/model/bullet.png";
										we.modelf = "gvclib:textures/entity/msmoke.mqo";
										we.texf = "gvclib:textures/entity/msmoke.png";
										we.ftime = 16;
										we.sound = GVCSoundEvent.fire_cannon;
										we.f = ff;
										we.w = ww;
										we.h = hh;
										we.z = zz;
										we.bx = ww;
										we.by = hh;
										we.bz = zz;
										we.follow_rote = true;
										we.xoffset = 0;
										we.yoffset = 0;
										we.px = this.posX;
										we.py = this.posY;
										we.pz = this.posZ;
										we.lock = this.getLookVec();
										we.rote = this.rotationYawHead;
										we.maxy = 0;
										we.miny = 0;
										
										we.power = 30;
										we.speed = 4F;
										we.bure = 1F;
										we.ex = 3;
										we.extrue = true;
										we.kazu = 1;
										we.gra = 0.029;
										we.maxtime = 80;
										we.dameid = 0;
										we.target = targeted;
										we.WeaponAttack();
										this.cooltime4 = 0;
										return_rote = false;
										break;
					    			}
							 }
						}
						
					}
            	}
            }
        }
		 if(return_rote) {
			/* if(id == 1) {
				    this.rotation_1 = this.rotationYaw;
					this.rotationp_1 = this.rotationPitch;
				}else if(id == 2) {
					this.rotation_2 = this.rotationYaw;
					this.rotationp_2 = this.rotationPitch;
				}else if(id == 5) {
					this.rotation_5 = this.rotationYaw;
					this.rotationp_5 = this.rotationPitch;
				}else if(id == 6) {
					this.rotation_6 = this.rotationYaw;
					this.rotationp_6 = this.rotationPitch;
				}else {
					this.rotation_4 = this.rotationYaw;
					this.rotationp_4 = this.rotationPitch;
				}*/
		 }
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
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 2, false,  false);
		}
		if (this.deathTicks == 200 && !this.world.isRemote) {
			this.setDead();
		}
	}
}
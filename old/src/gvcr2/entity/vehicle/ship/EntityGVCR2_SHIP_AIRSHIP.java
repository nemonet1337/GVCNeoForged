package gvcr2.entity.vehicle.ship;

import java.util.List;

import gvclib.mod_GVCLib;
import gvclib.entity.EntityBBase;
import gvclib.entity.living.AI_AirCraftSet;
import gvclib.entity.living.AI_EntityWeapon_new;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.ISoldier;
import gvclib.entity.living.PL_AirCraftMove;
import gvclib.entity.living.PL_RoteModel;
import gvclib.entity.living.cnt.VehicleCNT_Heli;
import gvclib.entity.living.cnt.ai.AI_GetTarget_OnRidding;
import gvclib.entity.living.cnt.ai.VehicleAI_RotationYawOffset;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLClientMessageKeyPressed;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class EntityGVCR2_SHIP_AIRSHIP extends EntityMobVehicleBase
{

    public EntityGVCR2_SHIP_AIRSHIP(World worldIn)
    {
        super(worldIn);
        this.setSize(10F, 10F);
        this.ridding_sneakdismount = false;
        this.riddng_freehand = false;
        this.hud_icon = "gvcr2:textures/hud/heli.png";
        this.render_hud_icon_hori = true;
        this.hud_icon_hori = "gvcr2:textures/hud/heli_hori.png";
        this.render_hud_information_1 = "Z-KEY:Get off";
        this.render_hud_information_2 = "W/S-KEY:Throttle-UP/DWON";
        this.render_hud_information_3 = "SPEAC/SHIFT-KEY:UP/DWON";
        this.render_hud_information_4 = "Mouse-UP/DOWN:PICTH-UP/DOWN";
        this.render_hud_information_5 = "V-KEY:ALLY-Boarding";
        this.render_hud_information_6 = "B-KEY:ALLY-Get off";
        vehicletype = 2;
        ridding_roteplayer = false;
        ridding_roteplayerPitch = false;
        this.roodbreak = mod_GVCR2.cfg_movebreak;
        
        vehicle_ridding_nofire[2] = true;
        vehicle_ridding_nofire[3] = true;

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_ship_airship;
        
        this.sp = 0.01F;
        this.turnspeed = 1F;
        this.rotationp_max = -20F;
        this.rotationp_min = 30F;
		this.ridding_invisible = false;
		this.riddng_opentop = true;
		this.renderhud = true;
        this.thmax = 20F;
		this.thmin = -2F;
		this.thmaxa = 0.2F;
		this.thmina = -0.15F;
		this.stepHeight = 1.5F;
		this.riddng_maximum = 1;
		riddingx[0]=0.0D;
		riddingy[0]=1.35D;
		riddingz[0]=6.0D;
		riddingx_roteplayer[0] = 0D;
		riddingy_roteplayer[0] = 0D;
		riddingz_roteplayer[0] = 0D;
		
		
		ridding_view_x=0F;
		ridding_view_y=-10F;
		ridding_view_z=-30F;
		
		antibullet_0 = 0.5F;
		antibullet_1 = 1.0F;
		antibullet_2 = 2.0F;
		antibullet_3 = 1.2F;
		this.ridding_damege = 0.5F;
		
		{
			cloud = 1;
			cloud_x[0] = 0D;
			cloud_y[0] = 2.92D;
			cloud_z[0] = -2.0D;
		}
		{
			pera = 2;
			pera_x[0] = 0F;
			pera_y[0] = 4F;
			pera_z[0] = 0F;
			perarote_x[0] = 0F;
			perarote_y[0] = 1F;
			perarote_z[0] = 0F;
			pera_x[1] = 0F;
			pera_y[1] = 3.24F;
			pera_z[1] = -6.56F;
			perarote_x[1] = 1F;
			perarote_y[1] = 0F;
			perarote_z[1] = 0F;
		}
		
		aitypemax = 120;
		mob_min_range = 10;
		mob_max_range = 90;
		
		
		{
			this.weapon1true = true;
    		this.weapon1key = 0;
    		this.w1name = "152mmCannon";
    		this.ammo1 = 20;//20
    		this.magazine = 2;
    		this.reload_time1 = 80;
    		this.reloadsoundset1 = 40;
    		this.reloadsound1 = GVCSoundEvent.reload_cannon;
    		this.w1cycle = 1;
    		this.w1barst = 1;
    		this.weapon1 = 1;
    		{
    			this.bullet_type1[0] = 2;
        		this.bullet_model1[0] = "gvclib:textures/entity/model/bullet_cannon_small.mqo";
        		this.bullet_tex1[0] = "gvclib:textures/entity/model/bullet_cannon_small.png";
        		this.fire_model1[0]= "gvclib:textures/entity/msmoke.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/msmoke.png";
        		this.fire_time1[0] = 16;
        		this.sound_fire1[0] = "gvclib.fire_cannon";
        		this.fire_pointx1[0] = 0;
        		this.fire_pointy1[0] = -0.5F;
        		this.fire_pointz1[0] = -8F;
        		this.basis_pointx1[0] = 0;
        		this.basis_pointy1[0] = -0.5F;
        		this.basis_pointz1[0] = -8F;
        		this.fire_yoffset1[0] = 0;
        		this.rotationfollowing1[0] = true;
        		this.rotation_player1[0] = false;
        		this.rotationfirepoint1[0] = false;
        		this.bullet_damage1[0] = 80;
        		this.bullet_speed1[0] = 1.6F;
        		this.bullet_bure1[0] = 1.0F;
        		this.bullet_expower1[0] = 4F;
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
    
    
    
    
    public void onUpdate() {
		super.onUpdate();
		this.setVehicleLock(true);
		this.riddng_freehand = false;
		this.roadattack();
		
		float f1 = this.rotationYawHead * (2 * (float) Math.PI / 360);
//		ridding = false;
    	if (this.canBeSteered() && this.getControllingPassenger() != null && this.getHealth() > 0.0F)
		{
			if(this.getControllingPassenger() instanceof EntityPlayer)
			{
			EntityPlayer entitylivingbase = (EntityPlayer) this.getControllingPassenger();
			this.setcanDespawn(1);
			this.rotation  = entitylivingbase.rotationYawHead;
			this.rotationp = this.rotationPitch = entitylivingbase.rotationPitch;
			Vec3d looked = entitylivingbase.getLookVec();
			{
				VehicleAI_RotationYawOffset.offset(this, entitylivingbase);
				
				double x = 0;
				double y = 0;
				double z = 0;
				boolean true_move = false;
				{
					if (this.getMoveStrafing_PL() < 0.0F) {
						if (this.getMoveForward_PL() >= 0.0F) {
							this.rotationYawHead = this.rotationYawHead + turnspeed;
							this.rotationYaw = this.rotationYaw + turnspeed;
						}else {
							this.rotationYawHead = this.rotationYawHead - turnspeed;
							this.rotationYaw = this.rotationYaw - turnspeed;
						}
					}
					if (this.getMoveStrafing_PL() > 0.0F) {
						if (this.getMoveForward_PL() >= 0.0F) {
							this.rotationYawHead = this.rotationYawHead - turnspeed;
							this.rotationYaw = this.rotationYaw - turnspeed;
						}else {
							this.rotationYawHead = this.rotationYawHead + turnspeed;
							this.rotationYaw = this.rotationYaw + turnspeed;
						}
					}
				}
				if (entitylivingbase.moveForward > 0.0F) {
					x -= MathHelper.sin(f1) * sp * 5;
					z += MathHelper.cos(f1) * sp * 5;
					true_move = true;
				}
				if (entitylivingbase.moveForward < 0.0F) {
					x -= MathHelper.sin(f1) * sp * -5;
					z += MathHelper.cos(f1) * sp * -5;
					true_move = true;
				}
				{
					if(this.throttle_up == 1) {
						y += 0.01 * 10;
					}else if(this.throttle_up == -1) {
						y -=  0.01 * 10;
					}else {
						y = 0;
					}
				}
				{
					this.motionX = x;
					this.motionZ = z;
					this.motionY = y;
					this.move(MoverType.PLAYER, this.motionX, this.motionY, this.motionZ);
				}
			}
			
			boolean left = mod_GVCLib.proxy.leftclick();
			boolean right = mod_GVCLib.proxy.rightclick();
			boolean jump = mod_GVCLib.proxy.jumped();
			boolean kx = mod_GVCLib.proxy.keyx();
			boolean kg = mod_GVCLib.proxy.keyg();
			boolean kc = mod_GVCLib.proxy.keyc();
			if (left) {
				GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(11, this.getEntityId()));
				//this.server1 = true;
			}
			if (right) {
				GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(12, this.getEntityId()));
			}
			if (jump) {
				GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(13, this.getEntityId()));
				if(FMLCommonHandler.instance().getMinecraftServerInstance() != null) {
					for (EntityPlayerMP playermp : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers()) {
						GVCLPacketHandler.INSTANCE2.sendTo(new GVCLClientMessageKeyPressed(13, this.getEntityId()), playermp);
					}
				}
				//this.serverspace = true;
			}
			if (kx) {
				GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(14, this.getEntityId()));
			}
			if (kg) {
				GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(15, this.getEntityId()));
				//this.serverg = true;
			}
			if (kc) {
				GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(16, this.getEntityId()));
			}
			
			if(this.server1)
		    {
		    	{
    				if(cooltime >= ammo1){
    					this.counter1 = true;
    		            cooltime = 0;
    				}
    				if(this.weapon1true) {
    					{
    						this.weapon1active(looked, entitylivingbase);
    					}
        		    }
    			}
		    	this.server1 = false;
			}
		    
			if (this.serverspace) {
				this.throttle_up = 1;
				this.serverspace = false;
			}else if(entitylivingbase.isSneaking()) {
				this.throttle_up = -1;
			}else {
				this.throttle_up = 0;
			}
			
			
			}//player
			else if(this.getControllingPassenger() instanceof EntityGVCLivingBase) {
				
			}
		}else {
			
		}
    	 
	//	AI_TankSet.set2(this, GVCSoundEvent.sound_tank, f1, sp, 0.1F);
		
    	if ((this.canBeSteered() && this.getControllingPassenger() != null) || (this.getMobMode() == 0) && this.getHealth() > 0.0F)
		{
			if(this.ontick % 15 == 0 && (this.posX != this.prevPosX || this.posZ != this.prevPosZ)){
				//entity.playSound(sound, 4.0F, 1.0F);
		//		if(!this.world.isRemote)this.world.playSound((EntityPlayer)null, this.posX, this.posY, this.posZ, GVCSoundEvent.sound_robo_step, SoundCategory.WEATHER, 4.0F, 1.0F);
			}
		}
        
		
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
		double xfront = this.posX + lock.x * 10;
		double yfront = this.posY + 10;
		double zfront = this.posZ + lock.z * 10;
		
		double xmiddle = this.posX;
		double ymiddle = this.posY + 10;
		double zmiddle = this.posZ;
		
		double xrear = this.posX + lock.x * -10;
		double yrear = this.posY + 10;
		double zrear = this.posZ + lock.z * -10;
		double han = 10;
		{
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - han), (double) (yfront - han),(double) (zfront - han),
					(double) (xfront + han), (double) (yfront + han), (double) (zfront + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	ImpactEntity(llist2);
	        }
		}
		{
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xrear - han), (double) (yrear - han),(double) (zrear - han),
					(double) (xrear + han), (double) (yrear + han), (double) (zrear + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	ImpactEntity(llist2);
	        }
		}
		{
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xmiddle - han), (double) (ymiddle - han),(double) (zmiddle - han),
					(double) (xmiddle + han), (double) (ymiddle + han), (double) (zmiddle + han)))
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
		{//右機銃
			xyaw -= MathHelper.sin(yaw + 1.57F) * 50;
			zyaw += MathHelper.cos(yaw + 1.57F) * 1;
			xfront = this.posX + xyaw;
			yfront = this.posY + 0;
			zfront = this.posZ + zyaw;
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - han), (double) (yfront - 20),(double) (zfront - han),
					(double) (xfront + han), (double) (yfront + 20), (double) (zfront + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	GunnerTarget(llist2, -1.57F, -4F, 2.0F, -2.65F, 1);
	        }
		}
		{//左機銃
			xyaw -= MathHelper.sin(yaw + 1.57F) * -50;
			zyaw += MathHelper.cos(yaw + 1.57F) * 1;
			xfront = this.posX + xyaw;
			yfront = this.posY + 0;
			zfront = this.posZ + zyaw;
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - han), (double) (yfront - 20),(double) (zfront - han),
					(double) (xfront + han), (double) (yfront + 20), (double) (zfront + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	GunnerTarget(llist2, -1.57F, 4F, 2.0F, -2.65F, 2);
	        }
		}
		{//上部機銃
			xfront = this.posX + 0;
			yfront = this.posY + 20;
			zfront = this.posZ + 0;
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - han), (double) (yfront - 5),(double) (zfront - han),
					(double) (xfront + han), (double) (yfront + 50), (double) (zfront + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	GunnerTarget(llist2, 0F, 0F, -1F, 0F, 3);
	        }
		}
		/*{//下部砲塔
			xfront = this.posX + 0;
			yfront = this.posY + 0;
			zfront = this.posZ + 0;
			AxisAlignedBB aabb = (new AxisAlignedBB(
					(double) (xfront - han), (double) (yfront - 50),(double) (zfront - han),
					(double) (xfront + han), (double) (yfront + 0), (double) (zfront + han)))
							.grow(1);
	        List llist2 = this.world.getEntitiesWithinAABB(Entity.class, aabb);
	        if(llist2!=null){
	        	GunnerTarget(llist2, 0F, 0F, -0.5F, -8F, 4);
	        }
		}*/
		
		if(this.magazine4 == 0) {
			++this.reload4;
			if(this.reload4 > 60) {
				this.magazine4 = 20;
				this.reload4 = 0;
			}
		}
		if(this.magazine2 == 0) {
			++this.reload2;
			if(this.reload2 > 60) {
				this.magazine2 = 20;
				this.reload2 = 0;
			}
		}
		if(this.magazine3 == 0) {
			++this.reload3;
			if(this.reload3 > 60) {
				this.magazine3 = 20;
				this.reload3 = 0;
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
			cooltimer = this.cooltime4;
			//mag = this.magazine4;
		}else if(id == 2) {
			cooltimer = this.cooltime2;
			//mag = this.magazine2;
		}else if(id == 3) {
			cooltimer = this.cooltime3;
			//mag = this.magazine3;
		}else {
			cooltimer = this.cooltime4;
			//mag = this.magazine4;
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
							 
							 
							 if(cooltimer > 3)// if(cooltimer > 3 && mag > 0)
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
									if(id == 3) {
										we.px = this.posX;
										we.py = this.posY + 20;
										we.pz = this.posZ;
									}else {
										we.px = this.posX;
										we.py = this.posY;
										we.pz = this.posZ;
									}
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
									
									{
										if(id == 1) {
											this.cooltime4 = 0;
											//--this.magazine4;
											this.rotation_4 = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
											this.rotationp_4 = -f11 + 0;
										}else if(id == 2) {
											this.cooltime2 = 0;
											//--this.magazine2;
											this.rotation_2 = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
											this.rotationp_2 = -f11 + 0;
										}else if(id == 3) {
											this.cooltime3 = 0;
											//--this.magazine3;
											this.rotation_3 = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
											this.rotationp_3 = -f11 + 0;
										}
									}
									
									//return;
									return_rote = false;
									break;
				    			}
						 }
					}
            	}
            }
        }
		 if(return_rote) {
			 /*if(id == 1) {
				    this.rotation_4 = this.rotationYaw;
					this.rotationp_4 = this.rotationPitch;
				}else if(id == 2) {
					this.rotation_2 = this.rotationYaw;
					this.rotationp_2 = this.rotationPitch;
				}else if(id == 3) {
					this.rotation_3 = this.rotationYaw;
					this.rotationp_3 = this.rotationPitch;
				}*/
		 }
	}
}
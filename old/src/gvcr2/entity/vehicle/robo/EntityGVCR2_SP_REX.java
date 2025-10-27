package gvcr2.entity.vehicle.robo;

import java.util.List;

import javax.annotation.Nullable;

import gvclib.mod_GVCLib;
import gvclib.entity.living.AI_EntityMoveTank;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_TankSet;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.EntityVehicleBase;
import gvclib.entity.living.PL_RoteModel;
import gvclib.entity.living.PL_TankMove;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockLilyPad;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityGVCR2_SP_REX extends EntityMobVehicleBase
{
    public EntityGVCR2_SP_REX(World worldIn)
    {
        super(worldIn);
        this.setSize(8F, 8.0F);
        this.ridding_sneakdismount = false;
        this.render_hud_icon = false;
        this.hud_icon = "gvclib:textures/hud/tank.png";
        this.render_hud_scope = false;
        this.hud_icon_scope = "gvcr2:textures/misc/scope_tank_m41.png";
        
        //this.render_hud_information_6 = "X-KEY:WeaponChange";
        
        ridding_roteplayer = false;

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_sp_rex;
        
        this.sp = 0.035F;
        this.turnspeed = 2.0F;
        this.rotationp_max = -60F;
        this.rotationp_min = 60F;
        this.ridding_rotation_lock = true;
        this.rotation_max = 45F;
		this.ridding_invisible = false;
		this.riddng_opentop = false;
        this.thmax = 5F;
		this.thmin = -2F;
		this.thmaxa = 0.2F;
		this.thmina = -0.15F;
		this.stepHeight = 4.0F;
		riddingx[0] = 0.0;
		riddingy[0] = 5.0;
		riddingz[0] = 2.6;
		
		ridding_view_x=0F;
		ridding_view_y=-2F;
		ridding_view_z=-15f;
		
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
		
		{
			this.weapon1true = true;
    		this.weapon1key = 0;
    		this.w1name = "RailGun";
    		this.ammo1 = 10;
    		this.magazine = 1;
    		this.reload_time1 = 80;
    		this.reloadsoundset1 = 20;
    		this.reloadsound1 = GVCSoundEvent.reload_cannon;
    		this.w1cycle = 1;
    		this.w1barst = 1;
    		this.weapon1 = 1;
    		{
    			this.bullet_type1[0] = 3;
        		this.bullet_model1[0] = "gvclib:textures/entity/bulletcannon.mqo";
        		this.bullet_tex1[0] = "gvclib:textures/entity/bulletcannon.png";
        		this.fire_model1[0]= "gvclib:textures/entity/msmoke.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/msmoke.png";
        		this.fire_time1[0] = 16;
        		this.sound_fire1[0] = "gvclib.fire_rail";
        		this.fire_pointx1[0] = -3.2F;
        		this.fire_pointy1[0] = 7.2F;
        		this.fire_pointz1[0] = -1.0F;
        		this.basis_pointx1[0] = -3.2F;
        		this.basis_pointy1[0] = 7.0F;
        		this.basis_pointz1[0] = -2.1F;
        		this.fire_yoffset1[0] = -0.03;
        		this.rotationfollowing1[0] = true;
        		this.rotationfirepoint1[0] = true;
        		this.bullet_damage1[0] = 200;
        		this.bullet_speed1[0] = 32.0F;
        		this.bullet_bure1[0] = 0.5F;
        		this.bullet_expower1[0] = 5F;
        		this.bullet_ex1[0] = mod_GVCR2.cfg_exprotion_player;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.025D;
        		this.bullet_livingtime1[0] = 80;
        		
    		}
		}
		this.mob_w1range = 50;
		this.mob_w1range_max_y = 15;
		this.mob_w1range_min_y = 2;
		
		
		{
			this.weapon2true = true;
			this.w2can_cooldown = true;
    		this.weapon2key = 2;
    		this.w2name = "MachineCannon";
    		this.ammo2 = 2;
    		this.magazine2 = 20;
    		this.reload_time2 = 80;
    		this.reloadsoundset2 = 40;
    		this.reloadsound2 = GVCSoundEvent.reload_mg;
    		this.w2cycle = 1;
    		this.w2barst = 1;
    		this.weapon2 = 1;
    		{
    			this.bullet_type2[0] = 1;
        		this.bullet_model2[0] = "gvclib:textures/entity/BulletNormal.obj";
        		this.bullet_tex2[0] = "gvclib:textures/entity/BulletNormal.png";
        		this.fire_model2[0]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex2[0] = "gvclib:textures/entity/mflash.png";
        		this.fire_time2[0] = 5;
        		this.sound_fire2[0] = "gvclib.fire_mg";
        		this.fire_pointx2[0] = 0.0F;
        		this.fire_pointy2[0] = 3.55F;
        		this.fire_pointz2[0] = 1.7F;
        		this.fire_yoffset2[0] = 0.01;
        		this.rotationfollowing2[0] = true;
        		this.rotationfirepoint2[0] = true;
        		this.bullet_damage2[0] = 8;
        		this.bullet_speed2[0] = 3F;
        		this.bullet_bure2[0] = 1.0F;
        		this.bullet_expower2[0] = 1.5F;
        		this.bullet_ex2[0] = false;
        		this.bullet_kazu2[0] = 1;
        		this.bullet_gravity2[0] = 0.029D;
        		this.bullet_livingtime2[0] = 80;
        		
    		}
		}
		this.mob_w2range = 15;
		this.mob_w2range_max_y = 15;
		this.mob_w2range_min_y = 2;
		
		
		{
			this.weapon3true = true;
    		this.weapon3key = 0;
    		this.w3name = "Missile";
    		this.ammo3 = 6;
    		this.magazine3 = 4;
    		this.reload_time3 = 80;
    		this.reloadsoundset3 = 20;
    		this.reloadsound3 = GVCSoundEvent.reload_cannon;
    		this.w3cycle = 1;
    		this.w3barst = 1;
    		this.weapon3 = 1;
    		this.w3crossfire = true;
    		{
    			this.bullet_type3[0] = 8;
        		this.bullet_model3[0] = "gvclib:textures/entity/model/bullet_small_missile.mqo";
        		this.bullet_tex3[0] = "gvclib:textures/entity/model/bullet_small_missile.png";
        		this.fire_model3[0]= "gvclib:textures/entity/msmoke.mqo";
        		this.fire_tex3[0] = "gvclib:textures/entity/msmoke.png";
        		this.fire_time3[0] = 16;
        		this.sound_fire3[0] = "gvclib.fire_missile";
        		this.fire_pointx3[0] = -1.4F;
        		this.fire_pointy3[0] = 7.2F;
        		this.fire_pointz3[0] = -3.0F;
        		this.basis_pointx3[0] = -1.4F;
        		this.basis_pointy3[0] = 7.2F;
        		this.basis_pointz3[0] = -2.3F;
        		this.fire_yoffset3[0] = 3;
        		this.rotationfollowing3[0] = true;
        		this.rotationfirepoint3[0] = true;
        		this.bullet_damage3[0] = 40;
        		this.bullet_speed3[0] = 1.0F;
        		this.bullet_bure3[0] = 2F;
        		this.bullet_expower3[0] = 5F;
        		this.bullet_ex3[0] = mod_GVCR2.cfg_exprotion_player;
        		this.bullet_kazu3[0] = 1;
        		this.bullet_gravity3[0] = 0.029D;
        		this.bullet_livingtime3[0] = 8000;
        		
    		}
		}
		
		
		
		this.ammo4 = 20;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(2000D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    
    public boolean spawn = false;
    
    public int move_mode = 0;
    public boolean ridding = false;
    
    public void onUpdate() {
		super.onUpdate();
		this.roadattack();
		float f1 = this.rotationYawHead * (2 * (float) Math.PI / 360);
//		ridding = false;
    	if (this.canBeSteered() && this.getControllingPassenger() != null && this.getHealth() > 0.0F)
		{
			if(this.getControllingPassenger() instanceof EntityPlayer)
			{
			EntityPlayer entitylivingbase = (EntityPlayer) this.getControllingPassenger();
			ridding = true;
			this.setcanDespawn(1);
			this.rotation  = entitylivingbase.rotationYawHead;
			this.rotationp = this.rotationPitch = entitylivingbase.rotationPitch;
			Vec3d looked = entitylivingbase.getLookVec();
			{
				if(entitylivingbase.rotationYawHead > 360F || entitylivingbase.rotationYawHead < -360F){
					entitylivingbase.rotationYawHead = 0;
					entitylivingbase.rotationYaw = 0;
					entitylivingbase.prevRotationYaw = 0;
					entitylivingbase.prevRotationYawHead = 0;
					entitylivingbase.renderYawOffset = 0;
				}
				if(entitylivingbase.rotationYawHead > 180F){
					entitylivingbase.rotationYawHead = -179F;
					entitylivingbase.rotationYaw = -179F;
					entitylivingbase.prevRotationYaw = -179F;
					entitylivingbase.prevRotationYawHead = -179F;
					entitylivingbase.renderYawOffset = -179F;
				}
				if(entitylivingbase.rotationYawHead < -180F){
					entitylivingbase.rotationYawHead = 179F;
					entitylivingbase.rotationYaw = 179F;
					entitylivingbase.prevRotationYaw = 179F;
					entitylivingbase.prevRotationYawHead = 179F;
					entitylivingbase.renderYawOffset = 179F;
				}
				if(this.rotationYawHead > 360F || this.rotationYawHead < -360F){
		        	this.rotation = 0;
					this.rotationp = 0;
					this.rotationYawHead = 0;
					this.rotationYaw = 0;
					//this.prevRotationYaw = 0;
					//this.prevRotationYawHead = 0;
					this.renderYawOffset = 0;
				}
				if(this.rotationYawHead > 180F){
					this.rotation = -179F;
					this.rotationp = -179F;
					this.rotationYawHead = -179F;
					this.rotationYaw = -179F;
					//this.prevRotationYaw = -179F;
					//this.prevRotationYawHead = -179F;
					this.renderYawOffset = -179F;
				}
				if(this.rotationYawHead < -180F){
					this.rotation = 179F;
					this.rotationp = 179F;
					this.rotationYawHead = 179F;
					this.rotationYaw = 179F;
					//this.prevRotationYaw = 179F;
					//this.prevRotationYawHead = 179F;
					this.renderYawOffset = 179F;
				}
				
				if(!this.counter4)move_mode = 0;
				double x = 0;
				double y = 0;
				double z = 0;
				boolean true_move = false;
				{
					if (entitylivingbase.moveStrafing < 0.0F) {
						x += MathHelper.sin(this.rotationYawHead * 0.01745329252F - 1.57F) * sp * 5;
						z -= MathHelper.cos(this.rotationYawHead * 0.01745329252F - 1.57F) * sp * 5;
						true_move = true;
						move_mode = 3;
					}
					if (entitylivingbase.moveStrafing > 0.0F) {
						x += MathHelper.sin(this.rotationYawHead * 0.01745329252F + 1.57F) * sp * 5;
						z -= MathHelper.cos(this.rotationYawHead * 0.01745329252F + 1.57F) * sp * 5;
						true_move = true;
						move_mode = 4;
					}
				}
				if (entitylivingbase.moveForward > 0.0F) {
					x -= MathHelper.sin(f1) * sp * 5;
					z += MathHelper.cos(f1) * sp * 5;
					true_move = true;
					move_mode = 1;
				}
				if (entitylivingbase.moveForward < 0.0F) {
					x -= MathHelper.sin(f1) * sp * -5;
					z += MathHelper.cos(f1) * sp * -5;
					true_move = true;
					move_mode = 2;
				}
				
				{
					this.motionX = x;
					this.motionZ = z;
					//entity.motionY = y;
					this.move(MoverType.PLAYER, this.motionX, this.motionY, this.motionZ);
				}
				float f = Math.abs(this.rotationYawHead - entitylivingbase.rotationYawHead);
				float f2 = this.rotationYawHead - entitylivingbase.rotationYawHead;
				if(true_move) {
					if(f <= turnspeed*2 && f >= -turnspeed*2){
						this.rotationYawHead = entitylivingbase.rotationYaw;
						this.rotationYaw = entitylivingbase.rotationYawHead;
						this.prevRotationYaw = entitylivingbase.prevRotationYawHead;
						this.prevRotationYawHead = entitylivingbase.prevRotationYawHead;
						this.renderYawOffset = entitylivingbase.prevRotationYawHead;
					}else
					if(f2 > 0.1F){
						if(f2 > 180F){
							PL_RoteModel.rotemodel(this,+ turnspeed);
						}else{
							PL_RoteModel.rotemodel(this,- turnspeed);
						}
					}
					else if(f2 < -0.1F){
						if(f2 < -180F){
							PL_RoteModel.rotemodel(this,- turnspeed);
						}else{
							PL_RoteModel.rotemodel(this,+ turnspeed);
						}
					}
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
			
			/*if (serverx) {
				if (cooltime5 > 1 && this.getRemain_A() > 0) {
					if(this.getArmID_R() == 0 && this.weapon11true){
						this.setArmID_R(1);
					}else if(this.getArmID_R() == 1 && this.weapon12true){
						this.setArmID_R(2);
					}else
					{
						this.setArmID_R(0);
					}
					cooltime5 = 0;
					this.setRemain_A(this.getRemain_A() - 1);
					this.playSound(GVCSoundEvent.reload_shell, 1.0F, 1.0F);
				}
				{
					this.serverx = false;
				}
			}*/
			
			if(this.server1)
		    {
		    	{
    				if(cooltime >= ammo1){
    					this.counter1 = true;
    		            cooltime = 0;
    				}
    				if(this.weapon1true) {
    					if(this.getArmID_R() == 1 && this.weapon11true){
    						this.weapon11active(looked, entitylivingbase);
    					}else if(this.getArmID_R() == 2 && this.weapon12true){
    						this.weapon12active(looked, entitylivingbase);
    					}else {
    						this.weapon1active(looked, entitylivingbase);
    					}
        		    }
    			}
		    	this.server1 = false;
			}
		    
		    if(this.serverspace)
		    {
		    	{
    				if(cooltime2 >= ammo2){
    					this.counter2 = true;
    		            cooltime2 = 0;
    		            System.out.println("can_cool");
    				}
    				if(this.weapon2true) {
        		    	this.weapon2active(looked, entitylivingbase);
        		    }
    			}
		    	this.serverspace = false;
			}
		    if(this.serverg)
		    {
		    	{
    				if(cooltime3 >= ammo3){
    					this.counter3 = true;
    		            cooltime3 = 0;
    				}
    				if(this.weapon3true) {
    					this.weapon3active(looked, entitylivingbase);
        		    }
    			}
		    	this.serverg = false;
			}
		    
		    
		    if(entitylivingbase.isSneaking())
		    {
    				if(cooltime4 >= ammo4){
    					this.counter4 = true;
    		            cooltime4 = 0;
    				}
			}
		    if(this.counter4) {
		    	++countlimit4;
		    	double x = 0;
				double y = 0;
				double z = 0;
				x -= MathHelper.sin(f1) * sp * 10;
				z += MathHelper.cos(f1) * sp * 10;
				move_mode = 5;
				
				{
					this.motionX = x;
					this.motionZ = z;
					//entity.motionY = y;
					this.move(MoverType.PLAYER, this.motionX, this.motionY, this.motionZ);
				}
				this.roadattack2();
				if(countlimit4 == 1)this.world.playSound((EntityPlayer)null, this.posX, this.posY, this.posZ, GVCSoundEvent.sound_robo_boost, SoundCategory.WEATHER, 4.0F, 1.0F);
				if(countlimit4 > 10) {
					this.countlimit4 = 0;
					this.cooltime4 = 0;
					this.counter4 = false;
				}
				
			}
			
			
			}//player
			else if(this.getControllingPassenger() instanceof EntityGVCLivingBase) {
				
			}
		}else {
			ridding = false;
		}
    	 
	//	AI_TankSet.set2(this, GVCSoundEvent.sound_tank, f1, sp, 0.1F);
		
    	if ((this.canBeSteered() && this.getControllingPassenger() != null) || (this.getMobMode() == 0) && this.getHealth() > 0.0F)
		{
			if(this.ontick % 15 == 0 && (this.posX != this.prevPosX || this.posZ != this.prevPosZ)){
				//entity.playSound(sound, 4.0F, 1.0F);
				if(!this.world.isRemote)this.world.playSound((EntityPlayer)null, this.posX, this.posY, this.posZ, GVCSoundEvent.sound_robo_step, SoundCategory.WEATHER, 4.0F, 1.0F);
			}
		}
        
    }

    
    public void roadattack2() {
    	double dx = Math.abs(this.posX - this.prevPosX);
		double dz = Math.abs(this.posZ - this.prevPosZ);
		float dd = (float)Math.sqrt((dx * dx) + (dz * dz)) * 20;
    	if(dd != 0){
			this.swingArm(EnumHand.MAIN_HAND);
			AxisAlignedBB axisalignedbb2 = new AxisAlignedBB(
					this.posX - this.width, this.posY, this.posZ - this.width, 
					this.posX + this.width, this.posY + this.height, this.posZ + this.width)
	        		.expand(this.width, this.height, this.width);
			List<Entity> llist = this.world.getEntitiesWithinAABBExcludingEntity(this,axisalignedbb2);
			if (llist != null) {
				for (int lj = 0; lj < llist.size(); lj++) {
					Entity entity1 = (Entity) llist.get(lj);
					if (entity1.canBeCollidedWith() && entity1 instanceof EntityLivingBase && entity1 != null) {
						if(entity1 != this && entity1 != this.getControllingPassenger() && entity1 instanceof IMob && !entity1.isRiding()){
							if (this.canBeSteered() && this.getControllingPassenger() != null && this.getHealth() > 0.0F)
							{
								if(!(this.getControllingPassenger() instanceof IMob))
								{
									entity1.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase) this.getControllingPassenger()), 100);
								}
							}
						}
						if(entity1 != this && entity1 != this.getControllingPassenger() && entity1 instanceof EntityVehicleBase && !entity1.isRiding()){
							EntityVehicleBase vehi = (EntityVehicleBase) entity1;
							if (this.canBeSteered() && this.getControllingPassenger() != null && this.getHealth() > 0.0F)
							{
								if(!(this.getControllingPassenger() instanceof IMob) && (vehi.getControllingPassenger() != null && vehi.getControllingPassenger() instanceof IMob))
								{
									entity1.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase) this.getControllingPassenger()), 100);
								}
							}
						}
					}
				}
			}
		}
    }
    
    
   protected void onDeathUpdate() {
		++this.deathTicks;
		int x = this.world.rand.nextInt(4);
		int y = this.world.rand.nextInt(5);
		int z = this.world.rand.nextInt(4);
		if (this.deathTicks == 1 && !this.world.isRemote) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 3, false,  false);
		}
		if (this.deathTicks == 200 && !this.world.isRemote) {
			this.setDead();
		}
	}
}
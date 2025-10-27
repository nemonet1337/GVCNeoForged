package gvcr2.entity.vehicle.set;

import java.util.List;

import gvclib.entity.living.AI_EntityMoveS;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_EntityWeapon_new;
import gvclib.entity.living.AI_setState;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;

import gvclib.entity.living.cnt.VehicleCNT_Turret;
import gvclib.event.GVCSoundEvent;
import gvclib.item.ItemGunBase;
import gvclib.item.gunbase.IGun_Sword;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.ai.AI_Type2_EntityMoveS;
import gvcr2.entity.mob.EntityGVCR2_GE_SE_ASSAULT;
import gvcr2.entity.mob.EntityGVCR2_GE_SV;
import gvcr2.entity.mob.EntityGVCR2_GE_U_DRONE;
import gvcr2.entity.so.EntityGVCR2_SOBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;


public class EntityGVCR2_SET_AA_Mk15 extends EntityGVCR2_SOBase {

	public EntityGVCR2_SET_AA_Mk15(World worldIn) {
		super(worldIn);
		this.setSize(2.0F, 5.0F);
		 this.rotationp_max = -80F;
	        this.rotationp_min = 5F;
	}

	protected void initEntityAI() {
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200D);
		// this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0D);
	}
	
	public boolean canExplosionDestroyBlock(Explosion explosionIn, World worldIn, BlockPos pos, IBlockState blockStateIn, float p_174816_5_)
    {
        return mod_GVCR2.cfg_exprotion_mob;
    }

	public boolean getCanSpawnHere() {
		return this.getLevel() >= 0 && super.getCanSpawnHere();
	}
	
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		this.setWeapon();
	}
	
	
	public void setWeapon() {
	}
	
	
	
	/**
     * Drop the equipment for this entity.
     */
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier)
    {
    	
    }
    /*public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    	this.rotationYaw = this.rotationYawHead = this.rotation =  this.rotationYaw + 1;
		return true;
    }*/
    
    public void getbeacon() {
    	
    }
    
	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
    int self_ex = 0;
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.biped = false;
		this.reload_time1 = 60;
		this.magazine = 30;
		if(this.getRemain_L() <= 0){
			++reload1;
			if(reload1 == reload_time1 - 10){
				this.playSound(GVCSoundEvent.reload_mag, 1.0F, 1.0F);
			}
			if(reload1 >= reload_time1){
				this.setRemain_L(this.magazine);
				reload1 = 0;
			}
		}
		
		
		if(this.getMoveT() == 0) {
			this.setMoveT(1);
			this.setMoveX((int)this.posX);
			this.setMoveY((int)this.posY);
			this.setMoveZ((int)this.posZ);
		}
		
		if(this.getHealth() > 0.0F) {
			if(!this.world.isRemote)this.setPositionAndUpdate(this.getMoveX(), this.getMoveY(), this.getMoveZ());
		}
		
		float sp = 0.06F;
		Vec3d looked = this.getLookVec();
		
		
		boolean exflag = true;
		
		AI_EntityWeapon.getTargetEntity(this, 80, 80, 20);
		///AI_EntityMoveS.newmove(this, 1, sp, 0, 1, 40, 40);
		this.newmove(this, 1, sp, 0, 20, 80);
		
		
		
		if(AI_EntityWeapon.getRange(this, 80, 80, 20)){
			String model = "gvclib:textures/entity/BulletNormal.obj";
    		String tex = "gvclib:textures/entity/BulletNormal.png";
    		String modelf = "gvclib:textures/entity/mflash.mqo";
    		String texf = "gvclib:textures/entity/mflash.png";
        	{
        		if(this.cooltime > 1 && this.getRemain_L() > 0)
    			{
        			this.cooltime = 0;
        			
        			SoundEvent sounds = GVCSoundEvent.fire_20mm;
        			
        			AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
					we.id = 1;
					we.model = "gvclib:textures/entity/model/bullet.mqo";
					we.tex = "gvclib:textures/entity/model/bullet.png";
					we.modelf = model;
					we.texf = tex;
					we.ftime = 0;
					we.sound = sounds;
					we.f = 0;
					we.w = 0;
					we.h = 2.67;
					we.z = 2.3;
					we.bx = 0;
					we.by = 2.67;
					we.bz = 0.0;
					we.follow_rote = true;
					we.xoffset = 0;
					we.yoffset = 0;
					we.px = this.posX;
					we.py = this.posY;
					we.pz = this.posZ;
					we.lock = looked;
					we.rote = this.rotationYawHead;
					we.maxy = 10;
					we.miny = 10;
					
					we.power = 9;
					we.speed = 8F;
					we.bure = 2F;
					we.ex = 1;
					we.extrue = false;
					we.kazu = 1;
					we.gra = 0.029;
					we.maxtime = 80;
					we.damegetime = true;
					we.dameid = 0;
					we.Attacktask(this, this, 80);
    				this.gun_count1 = 0;
    				
    				if(this.firetrue){
    					this.setRemain_L(this.getRemain_L() - 1);
    				}
    			}
        	}
		}
		
		
	}

	public void newmove(EntityGVCLivingBase entity, int id, float sp, float turnspeed, double max, double range1) {
		entity.sneak = false;
		boolean ta = false;
		double range = range1;
		{
			List<Entity> llist = entity.world.getEntitiesWithinAABBExcludingEntity(entity, entity
					.getEntityBoundingBox().expand(entity.motionX, entity.motionY, entity.motionZ).grow(range));
			if (llist != null) {
				for (int lj = 0; lj < llist.size(); lj++) {
					Entity entity1 = (Entity) llist.get(lj);
					if (entity1.canBeCollidedWith()) {
						boolean flag = entity.getEntitySenses().canSee(entity1);
						if (entity.CanAttack(entity1) && entity1 != null) {//target
							
							if (entity.targetentity == entity1
									&& ((EntityLivingBase) entity1).getHealth() > 0.0F) {
								double d5 = entity1.posX - entity.posX;
								double d7 = entity1.posZ - entity.posZ;
								double d6 = entity1.posY - entity.posY;
								double d1 = entity.posY - (entity1.posY);
								double d3 = (double) MathHelper.sqrt(d5 * d5 + d7 * d7);
								float f11 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
								{
									entity.rotationYawHead = entity.rotation = entity.rote = entity.renderYawOffset = entity.rotationYaw
											= -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
									entity.rotationp = entity.rotationPitch = -f11 + 0;
									entity.noflag = 0;
									ta = true;
								}
								if (flag) {
									entity.targetentity = (EntityLivingBase) entity1;
									entity.setattacktask(true);
								}
								ta = true;
								break;
							} 
						}//target
						
					}
				}
			}
		}
		
	}
	
	public void MoveS(EntityGVCLivingBase entity, double speed, double han, double ex, double ey, double ez, int id, EntityLivingBase en){
		
	}
	
	
/*
public class EntityGVCR2_SET_AA_Mk15 extends EntityMobVehicleBase
{
    public EntityGVCR2_SET_AA_Mk15(World worldIn)
    {
        super(worldIn);
        this.setSize(2.0F, 2.0F);
        this.render_hud_icon = false;
        this.hud_icon = "gvclib:textures/hud/vehicle.png";
        this.render_hud_scope = false;
        this.hud_icon_scope = "siegecraftww3:textures/misc/scope_tank.png";
        this.render_hud_scope_zoom = false;
        this.hud_icon_scope_zoom = "siegecraftww3:textures/misc/scope_tank_zoom.png";
        

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_set_aa_vads;
        
        this.sp = 0.0F;
        this.turnspeed = 3.0F;
        this.rotationp_max = -80F;
        this.rotationp_min = 0F;
		this.ridding_invisible = true;
		this.riddng_opentop = false;
		riddingx[0] = 0.0;
		riddingy[0] = 2.8;
		riddingz[0] = 0.0;
		
		this.ridding_view1_x = 0.8F;
		this.ridding_view1_y = 0.0F;
		this.ridding_view1_z = 1.1F;
		
		antibullet_0 = 0.0F;
		antibullet_1 = 0.5F;
		antibullet_2 = 1.0F;
		antibullet_3 = 1.0F;
		this.ridding_damege = 1.0F;
		
		this.roodbreak = true;
		
		this.weapon1_auto_reload = true;
		
		{
			cloud = 0;
		}
		
		mob_min_range = 20;
		mob_max_range = 80;
		
		{
			this.weapon1true = true;
			this.w1can_cooldown = true;
    		this.weapon1key = 0;
    		this.w1name = "20mmMC";
    		this.ammo1 = 1;
    		this.magazine = 20;
    		this.reload_time1 = 50;
    		this.reloadsoundset1 = 40;
    		this.reloadsound1 = GVCSoundEvent.reload_mg;
    		this.w1cycle = 1;
    		this.w1barst = 1;
    		this.weapon1 = 1;
    		{
    			this.bullet_type1[0] = 1;
        		this.bullet_model1[0] = "gvclib:textures/entity/BulletNormal.mqo";
        		this.bullet_tex1[0] = "gvclib:textures/entity/BulletNormal.png";
        		this.fire_model1[0]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/mflash.png";
        		this.fire_time1[0] = 2;
        		this.sound_fire1[0] = "gvclib.fire_20mm";
        		this.fire_pointx1[0] = 0;
        		this.fire_pointy1[0] = 2.67F;
        		this.fire_pointz1[0] = 2.3F;
        		this.basis_pointx1[0] = 0;
        		this.basis_pointy1[0] = 2.67F;
        		this.basis_pointz1[0] = 0.0F;
        		this.fire_yoffset1[0] = 0;
        		this.rotationfollowing1[0] = true;
        		this.rotationfirepoint1[0] = false;
        		this.rotation_player1[0] = true;
        		this.bullet_damage1[0] = 8;
        		this.bullet_speed1[0] = 8.0F;
        		this.bullet_bure1[0] = 1.0F;
        		this.bullet_expower1[0] = 1F;
        		this.bullet_ex1[0] = false;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.0299D;
        		this.bullet_livingtime1[0] = 80;
        		
    		}
		}
		
		this.mob_w1range = 80;
		this.mob_w1range_max_y = 80;
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
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 2, false,  false);
		}
		if (this.deathTicks == 200 && !this.world.isRemote) {
			this.setDead();
		}
	}*/
}
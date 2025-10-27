package gvcr2.entity.vehicle.set;

import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.cnt.VehicleCNT_Turret;
import gvclib.event.GVCSoundEvent;
import gvclib.item.ItemWrench;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityGVCR2_SET_MORTAR_FH18 extends EntityMobVehicleBase
{
    public EntityGVCR2_SET_MORTAR_FH18(World worldIn)
    {
        super(worldIn);
        this.setSize(3.0F, 3.0F);
        this.render_hud_icon = false;
        this.hud_icon = "gvclib:textures/hud/vehicle.png";
        this.render_hud_scope = false;
        this.hud_icon_scope = "siegecraftww3:textures/misc/scope_tank.png";
        this.render_hud_scope_zoom = false;
        this.hud_icon_scope_zoom = "siegecraftww3:textures/misc/scope_tank_zoom.png";
        

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_set_mg_fh18;
        
        this.sp = 0.0F;
        this.turnspeed = 1.5F;
        this.spg_min_range = 60;
        this.ridding_roteplayer = false;
        this.rotationp_max = -40F;
        this.rotationp_min = 30F;
		this.ridding_invisible = false;
		this.riddng_opentop = true;
		riddingx[0] = 1.0;
		riddingy[0] = 0.5;
		riddingz[0] = -2.0;
		
		this.ridding_view1_x = 0.0F;
		this.ridding_view1_y = 0.0F;
		this.ridding_view1_z = 0.0F;
		
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
		
		mob_min_range = 60;
		mob_max_range = 120;
		
		{
			this.weapon1true = true;
    		this.weapon1key = 0;
    		this.w1name = "155mmCannon";
    		this.ammo1 = 20;
    		this.magazine = 1;
    		this.reload_time1 = 200;
    		this.reloadsoundset1 = 20;
    		this.reloadsound1 = GVCSoundEvent.reload_cannon;
    		this.w1cycle = 1;
    		this.w1barst = 1;
    		this.weapon1 = 1;
    		{
    			this.bullet_type1[0] = 13;
        		this.bullet_model1[0] = "gvclib:textures/entity/bulletcannon.mqo";
        		this.bullet_tex1[0] = "gvclib:textures/entity/bulletcannon.png";
        		this.fire_model1[0]= "gvclib:textures/entity/msmoke.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/msmoke.png";
        		this.fire_time1[0] = 16;
        		this.sound_fire1[0] = "gvclib.fire_havrycannon";
        		this.fire_pointx1[0] = 0;
        		this.fire_pointy1[0] = 5.0F;
        		this.fire_pointz1[0] = 3.0F;
        		this.basis_pointx1[0] = 0;
        		this.basis_pointy1[0] = 1.5F;
        		this.basis_pointz1[0] = 0.0F;
        		this.fire_yoffset1[0] = 0;
        		this.rotationfollowing1[0] = true;
        		this.rotationfirepoint1[0] = false;
        		this.rotation_player1[0] = true;
        		this.bullet_damage1[0] = 100;
        		this.bullet_speed1[0] = 4.0F;
        		this.bullet_bure1[0] = 1.0F;
        		this.bullet_expower1[0] = 6.0F;
        		this.bullet_ex1[0] = mod_GVCR2.cfg_exprotion_player;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.029D;
        		this.bullet_livingtime1[0] = 80;
        		
    		}
		}
		
		this.mob_w1range = 120;
		this.mob_w1range_max_y = 60;
		this.mob_w1range_min_y = 60;
		
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    	{
    		float yaw = this.rotationYaw * (2 * (float) Math.PI / 360);
			//spg_yaw = 0;
			//spg_picth = 0;
			spg_yaw -= MathHelper.sin(yaw) * this.spg_min_range;
			spg_picth += MathHelper.cos(yaw) * this.spg_min_range;
    	}
    	return super.processInteract(player, hand);
    }
    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		//this.roadattackPC(1);
		VehicleCNT_Turret.loadSPG(this, null, false);
    }
    /*
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    	ItemStack itemstack = player.getHeldItem(hand);
        boolean flag = !itemstack.isEmpty();
        boolean re = true;
        
        	if(flag && itemstack.getItem() instanceof ItemWrench && this.getHealth() <= 0.0F){
    			itemstack.damageItem(10, player);
    			this.playSound(SoundEvents.BLOCK_ANVIL_LAND, 2F, 1F);
				if (!this.world.isRemote)
                {
					EntityGVCR2_SET_MORTAR_M224 entity = new EntityGVCR2_SET_MORTAR_M224(this.world);
					entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0, 0.0F);
					entity.setcanDespawn(1);
					this.world.spawnEntity(entity);
					this.setDead();
					//System.out.println(String.format("ok"));
                }
        	}
        	else if(flag && itemstack.getItem() == Items.APPLE && this.getHealth() > 0.0F){
    			this.playSound(SoundEvents.BLOCK_ANVIL_LAND, 2F, 1F);
				if (!this.world.isRemote)
                {
					EntitySCW_T_CANNON1 entity = new EntitySCW_T_CANNON1(this.world);
					entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0, 0.0F);
					entity.setcanDespawn(1);
					this.world.spawnEntity(entity);
					this.setDead();
                }
        	}
        	else{
        		super.processInteract(player, hand);
        	}
        	return re;
    }
    */
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
		/*if (this.deathTicks == 1 && !this.world.isRemote) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 3, false,  false);
		}
		if (this.deathTicks == 200 && !this.world.isRemote) {
			this.setDead();
		}*/
	}
}
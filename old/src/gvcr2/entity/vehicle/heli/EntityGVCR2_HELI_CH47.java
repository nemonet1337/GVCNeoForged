package gvcr2.entity.vehicle.heli;

import java.util.List;

import gvclib.mod_GVCLib;
import gvclib.entity.living.AI_AirCraftSet;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.ISoldier;
import gvclib.entity.living.PL_AirCraftMove;
import gvclib.entity.living.cnt.VehicleCNT_Heli;
import gvclib.entity.living.cnt.ai.AI_GetTarget_OnRidding;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityGVCR2_HELI_CH47 extends EntityMobVehicleBase
{

    public EntityGVCR2_HELI_CH47(World worldIn)
    {
        super(worldIn);
        this.setSize(5F, 4.0F);
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
        this.roodbreak = mod_GVCR2.cfg_movebreak;
        
        vehicle_ridding_nofire[2] = true;
        vehicle_ridding_nofire[3] = true;

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_heli_ch47;
        
        this.sp = 0.020F;
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
		this.riddng_maximum = 16;
		riddingx[0]=0.50D;
		riddingy[0]=1.05D;
		riddingz[0]=1.6D;
		{
			riddingx[1]=-0.50D;
			riddingy[1]=1.05D;
			riddingz[1]=1.6D;
			
			riddingx[2]=0.68D;
			riddingy[2]=1.12D;
			riddingz[2]=-0.42D;
			riddingx[3]=-0.68D;
			riddingy[3]=1.12D;
			riddingz[3]=-0.42D;
			
			riddingx[4]=0.68D;
			riddingy[4]=1.12D;
			riddingz[4]=-1.22D;
			riddingx[5]=-0.68D;
			riddingy[5]=1.12D;
			riddingz[5]=-1.22D;
			
			riddingx[6]=0.68D;
			riddingy[6]=1.12D;
			riddingz[6]=-2.02D;
			riddingx[7]=-0.68D;
			riddingy[7]=1.12D;
			riddingz[7]=-2.02D;
			
			riddingx[8]=0.68D;
			riddingy[8]=1.12D;
			riddingz[8]=-2.82D;
			riddingx[9]=-0.68D;
			riddingy[9]=1.12D;
			riddingz[9]=-2.82D;
			
			riddingx[10]=0.68D;
			riddingy[10]=1.12D;
			riddingz[10]=-3.62D;
			riddingx[11]=-0.68D;
			riddingy[11]=1.12D;
			riddingz[11]=-3.62D;
			
			riddingx[12]=0.68D;
			riddingy[12]=1.12D;
			riddingz[12]=-4.42D;
			riddingx[13]=-0.68D;
			riddingy[13]=1.12D;
			riddingz[13]=-4.42D;
			
			riddingx[14]=0.68D;
			riddingy[14]=1.12D;
			riddingz[14]=-5.22D;
			riddingx[15]=-0.68D;
			riddingy[15]=1.12D;
			riddingz[15]=-5.22D;
			
		}
		
		
		ridding_view_x=0F;
		ridding_view_y=-4F;
		ridding_view_z=-20F;
		ridding_view_gunner_x=0F;
		ridding_view_gunner_y=2F;
		ridding_view_gunner_z=1F;
		
		antibullet_0 = 0.5F;
		antibullet_1 = 1.0F;
		antibullet_2 = 2.0F;
		antibullet_3 = 1.2F;
		this.ridding_damege = 0.5F;
		
		{
			cloud = 2;
			cloud_x[0] = 1.2D;
			cloud_y[0] = 3.5D;
			cloud_z[0] = -8.0D;
			
			cloud_x[1] = -1.2D;
			cloud_y[1] = 3.5D;
			cloud_z[1] = -8.0D;
		}
		{
			pera = 2;
			pera_x[0] = 0F;
			pera_y[0] = 4F;
			pera_z[0] = 1.4F;
			perarote_x[0] = 0F;
			perarote_y[0] = 1F;
			perarote_z[0] = 0F;
			pera_x[1] = 0F;
			pera_y[1] = 5.5F;
			pera_z[1] = -6.8F;
			perarote_x[1] = 0F;
			perarote_y[1] = -1F;
			perarote_z[1] = 0F;
		}
		
		aitypemax = 120;
		mob_min_range = 10;
		mob_max_range = 90;
		
		
		this.weapon2type = 1;
		{
			this.weapon2true = true;
    		this.weapon2key = 0;
    		this.w2name = "Flare";
    		this.ammo2 = 30;
    		this.magazine2 = 1;
    		this.reload_time2 = 30;
    		this.reloadsoundset2 = 0;
    		this.reloadsound2 = GVCSoundEvent.reload_cannon;
    		this.w2cycle = 1;
    		this.w2barst = 1;
    		this.weapon2 = 1;
    		this.w2crossfire = false;
    			this.bullet_type2[0] = 21;
        		this.sound_fire2[0] = "gvclib.fire_roket";
        		this.fire_pointx2[0] = 6.4F;
        		this.fire_pointy2[0] = 2.5F;
        		this.fire_pointz2[0] = 0.5F;
        		this.basis_pointx2[0] = 3.5F;
        		this.basis_pointy2[0] = (float) (riddingy[0] + 1.25F);
        		this.basis_pointz2[0] = 0F;
        		this.fire_yoffset2[0] = 0;
        		this.bullet_speed2[0] = 1F;
        		this.bullet_kazu2[0] = 1;
        		
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
		this.riddng_freehand = false;
		float f1 = this.rotationYawHead * (2 * (float) Math.PI / 360);
		this.roadattack();
		VehicleCNT_Heli.load(this, GVCSoundEvent.sound_heli);
		
		this.ContMobRidding();
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
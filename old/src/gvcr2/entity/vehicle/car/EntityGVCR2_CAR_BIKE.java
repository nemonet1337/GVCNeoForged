package gvcr2.entity.vehicle.car;

import java.util.List;

import gvclib.mod_GVCLib;
import gvclib.entity.living.AI_TankSet;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.PL_TankMove;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvcr2.mod_GVCR2;
import hmggirlfront.mod_GirlFront;
import hmggirlfront.entity.EntityDoll;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityGVCR2_CAR_BIKE extends EntityMobVehicleBase
{

    public EntityGVCR2_CAR_BIKE(World worldIn)
    {
        super(worldIn);
        this.setSize(1F, 1.4F);
        
        ridding_roteangle = mod_GVCR2.cfg_vehicle_angle;
        
        this.riddng_freehand = false;
        //this.hud_icon = "hmggirlfront:textures/hud/apc.png";
        this.render_hud_information_2 = "R-Click:Zoom";
        this.render_hud_information_3 = "W/S-KEY:Throttle-UP/DWON";
        this.render_hud_information_4 = "A/D-KEY:TURN-RIGHT/LEFT";
        vehicletype = 2;
        ridding_roteplayer = false;
        this.roodbreak = mod_GVCR2.cfg_movebreak;
        
        vehicle_ridding_nofire[0] = false;
        vehicle_ridding_nofire[1] = false;

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_car_bike;
        
        this.sp = 0.07F;
        this.turnspeed = 10F;
		this.ridding_invisible = false;
		this.riddng_opentop = true;
		this.renderhud = true;
		this.render_rader = false;
		this.thmax = 5F;
		this.thmin = -2F;
		this.thmaxa = 0.2F;
		this.thmina = -0.15F;
		this.stepHeight = 1.5F;
		this.riddng_maximum = 1;
		riddingx[0]=0.0D;
		riddingy[0]=0.8D;
		riddingz[0]=0.0D;
		/*{
			riddingx[1]=-1.0D;
			riddingy[1]=0.4D;
			riddingz[1]=-0.1D;
		}
		*/
		
		ridding_view_x=0F;
		ridding_view_y=-2F;
		ridding_view_z=-5F;
		
		antibullet_0 = 0.5F;
		antibullet_1 = 0.5F;
		antibullet_2 = 1.0F;
		antibullet_3 = 1.1F;
		this.ridding_damege = 0.5F;
		
		
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		this.setcanDespawn(1);
		this.riddng_freehand = false;
		float f1 = this.rotationYawHead * (2 * (float) Math.PI / 360);
		this.roadattack();
		this.setcanDespawn(1);
		//this.typeHeli(GVCSoundEvent.sound_heli);
		this.typecar();
    }

   
}
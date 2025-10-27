package gvcr2.entity.drone;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import gvclib.mod_GVCLib;
import gvclib.entity.living.AI_TankSet;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMAVBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.ISoldier;
import gvclib.entity.living.PL_TankMove;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLClientMessageKeyPressed;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class EntityDrone_MAV extends EntityMAVBase
{
	
    public EntityDrone_MAV(World worldIn)
    {
        super(worldIn);
        this.setSize(0.8F, 0.8F);
        this.setcanDespawn(1);
        this.setVehicleLock(true);
        
      //  this.spawn_item = mod_GirlFront.comand_drone;
        
        this.ridding_invisible = true;
        this.ridding_sneakdismount = true;
        this.render_hud_information_1 = "Z-KEY:Get off";
        
        this.riddng_freehand = false;
        this.hud_icon = "gvcr2:textures/hud/apc.png";
        vehicletype = 2;
        ridding_roteplayer = false;
        roodbreak = true;
        
        this.ridding_nottarget = false;
        this.return_basepoint = true;
        
        this.spawn_item = mod_GVCR2.gvcr2_drone_mav;
        
        this.sp = 0.07F;
        this.turnspeed = 10F;
		this.riddng_opentop = true;
		this.renderhud = true;
		this.render_rader = false;
		this.stepHeight = 1.5F;
		this.riddng_maximum = 1;
		riddingx[0]=0.0D;
		riddingy[0]=-0.5D;
		riddingz[0]=0.0D;
		this.ridding_view1_x = 0.0F;
		this.ridding_view1_y = 0.0F;
		this.ridding_view1_z = 0.2F;
		
		
		ridding_view_x=0F;
		ridding_view_y=0F;
		ridding_view_z=-5F;
		
		antibullet_0 = 1.0F;
		antibullet_1 = 1.0F;
		antibullet_2 = 1.0F;
		antibullet_3 = 1.0F;
		this.ridding_damege = 0.5F;
		
		
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    	ItemStack itemstack = player.getHeldItem(hand);
        boolean flag = !itemstack.isEmpty();
        if(player.isSneaking()) {
        	if (!this.world.isRemote)
            {
				this.entityDropItem(new ItemStack(spawn_item), 0.0F);
                this.setDead();
            }
        	return true;
        }
        else {
        	return super.processInteract(player, hand);
        }
    }

    
    
    public void onUpdate() {
		super.onUpdate();
		this.move_mav();
    }

   
}
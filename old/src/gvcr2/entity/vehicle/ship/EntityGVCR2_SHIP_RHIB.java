package gvcr2.entity.vehicle.ship;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import gvclib.mod_GVCLib;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_TankSet;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.entity.living.ISoldier;
import gvclib.entity.living.PL_TankMove;
import gvclib.entity.living.cnt.VehicleCNT_Boat;
import gvclib.entity.living.cnt.ai.AI_GetTarget_OnRidding;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvcr2.mod_GVCR2;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityGVCR2_SHIP_RHIB extends EntityMobVehicleBase
{

    public EntityGVCR2_SHIP_RHIB(World worldIn)
    {
        super(worldIn);
        this.setSize(4F, 3.0F);
       // this.setcanDespawn(1);
       // this.setVehicleLock(true);
        this.riddng_freehand = true;
        this.hud_icon = "gvclib:textures/hud/tank64.png";
        //this.render_hud_icon_hori = true;
        //this.hud_icon_hori = "hmggirlfront:textures/hud/heli_hori.png";
        this.render_hud_information_2 = "R-Click:Zoom";
        this.render_hud_information_3 = "W/S-KEY:Throttle-UP/DWON";
        this.render_hud_information_4 = "A/D-KEY:TURN-RIGHT/LEFT";
        this.render_hud_information_5 = "V-KEY:ALLY-Boarding";
        this.render_hud_information_6 = "B-KEY:ALLY-Get off";
        vehicletype = 5;
        ridding_roteplayer = false;
        this.roodbreak = mod_GVCR2.cfg_movebreak;
        
        vehicle_ridding_nofire[0] = true;
        vehicle_ridding_nofire[1] = true;
        vehicle_ridding_nofire[2] = true;
        vehicle_ridding_nofire[3] = true;
        vehicle_ridding_nofire[4] = true;

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_ship_rhib;
        
        this.sp = 0.05F;
        this.turnspeed = 3F;
		this.ridding_invisible = false;
		this.riddng_opentop = true;
		this.renderhud = true;
		this.thmax = 5F;
		this.thmin = -2F;
		this.thmaxa = 0.2F;
		this.thmina = -0.15F;
		this.stepHeight = 1.5F;
		this.riddng_maximum = 6;
		riddingx[0]=0.0D;
		riddingy[0]=0.7D;
		riddingz[0]=0.0D;
		{
			riddingx[1]=0.0D;
			riddingy[1]=0.75D;
			riddingz[1]=2.0D;
			
			riddingx[2]=0.75D;
			riddingy[2]=0.75D;
			riddingz[2]=1.0D;
			riddingx[3]=-0.75D;
			riddingy[3]=0.75D;
			riddingz[3]=1.0D;
			
			riddingx[4]=0.75D;
			riddingy[4]=0.75D;
			riddingz[4]=-1.0D;
			riddingx[5]=-0.75D;
			riddingy[5]=0.75D;
			riddingz[5]=-1.0D;
			
			
		}
		
		
		ridding_view_x=0F;
		ridding_view_y=-2F;
		ridding_view_z=-5F;
		ridding_view_gunner_x=0F;
		ridding_view_gunner_y=2F;
		ridding_view_gunner_z=1F;
		
		antibullet_0 = 0.5F;
		antibullet_1 = 1.0F;
		antibullet_2 = 1.0F;
		antibullet_3 = 1.1F;
		this.ridding_damege = 0.5F;
		
		
		mob_min_range = 20;
		mob_max_range = 60;
		
		{
			this.weapon3true = true;
			this.weapon3key = 0;
			this.ammo3 = 2;
			this.magazine3 = 10;
			reload_time3 = 60;
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
				this.fire_pointy3[0] = 1.4F;
				this.fire_pointz3[0] = 0.0F;
				this.basis_pointx3[0] = 0.0F;
        		this.basis_pointy3[0] = 1.4F;
        		this.basis_pointz3[0] = 0.0F;
        		this.arm_x[0] = 0.0F;
        		this.arm_z[0] = 2.2F;
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
			this.mob_w3range = 40;
			this.mob_w3range_max_y = 30;
			this.mob_w3range_min_y = 30;
		}
		
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }

    /*public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    	ItemStack itemstack = player.getHeldItem(hand);
        boolean flag = !itemstack.isEmpty();
        if(!itemstack.isEmpty()&& itemstack.getItem() == mod_GirlFront.idoll_parts)
        {
        	if(this.getHealth() < this.getMaxHealth()) {
				this.setHealth(this.getHealth() + 10);
    			itemstack.shrink(1);
    			this.playSound(SoundEvents.BLOCK_ANVIL_LAND, 5F, 2F);
			}
        	return true;
        }
        
        else{
        	super.processInteract(player, hand);
        	return true;
        }
    }*/
    
    private float momentum;
    private float boatGlide;
   // private EntityGVCR2_SHIP_RHIB.Status status;
   // private EntityGVCR2_SHIP_RHIB.Status previousStatus;
    private double lastYd;
    
    private double waterLevel;
    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		this.riddng_freehand = true;
		float f1 = this.rotationYawHead * (2 * (float) Math.PI / 360);
		this.roadattack();
		
		// this.status = this.getBoatStatus();
		 VehicleCNT_Boat.load(this, GVCSoundEvent.sound_car);
		 
		 this.ContMobRidding();
		 
		 if(this.getPassengers().size() > 1)
	        {
	        	 if(this.getPassengers().get(1) != null){
	        		 if (this.getPassengers().get(1) instanceof EntityGVCLivingBase) {
	      				EntityGVCLivingBase entitylivingbase = (EntityGVCLivingBase)this.getPassengers().get(1);
	      				if(entitylivingbase.getattacktask()) {
	      					this.CNT_MobRidding_getHead(entitylivingbase, this.mob_w3range_max_y);
	      				}
	      				this.rotation_3  = entitylivingbase.rotationYawHead;
	      				this.rotationp_3 = entitylivingbase.rotationPitch;
	      				Vec3d looked = entitylivingbase.getLookVec();
	      				AI_GetTarget_OnRidding.load(entitylivingbase, this.mob_w3range, this.mob_w3range_max_y, this.mob_w3range_min_y, this.rotationYaw, 180, 180);
	      				if(AI_GetTarget_OnRidding.getRange(entitylivingbase, this.mob_w3range, this.mob_w3range_max_y, this.mob_w3range_min_y, this.rotationYaw, 180, 180)){
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
	        }else {
	        	 this.rotation_3  = this.rotationYawHead;
	  				this.rotationp_3 = this.rotationPitch;
	        }
    }

   
    /**
     * Update the boat's speed, based on momentum.
     */
    /*private void updateMotion()
    {
        double d0 = -0.03999999910593033D;
        double d1 = this.hasNoGravity() ? 0.0D : -0.03999999910593033D;
        double d2 = 0.0D;
        this.momentum = 0.05F;

        
        if (this.previousStatus == EntityGVCR2_SHIP_RHIB.Status.IN_AIR && this.status != EntityGVCR2_SHIP_RHIB.Status.IN_AIR && this.status != EntityGVCR2_SHIP_RHIB.Status.ON_LAND)
        {
            this.waterLevel = this.getEntityBoundingBox().minY + (double)this.height;
            this.setPosition(this.posX, (double)(this.getWaterLevelAbove() - this.height) + 0.101D, this.posZ);
            this.motionY = 0.0D;
            this.lastYd = 0.0D;
            this.status = EntityGVCR2_SHIP_RHIB.Status.IN_WATER;
        }
        else
        {
            if (this.status == EntityGVCR2_SHIP_RHIB.Status.IN_WATER)
            {
                d2 = (this.waterLevel - this.getEntityBoundingBox().minY) / (double)this.height;
                this.momentum = 0.9F;
            }
            else if (this.status == EntityGVCR2_SHIP_RHIB.Status.UNDER_FLOWING_WATER)
            {
                d1 = -7.0E-4D;
                this.momentum = 0.9F;
            }
            else if (this.status == EntityGVCR2_SHIP_RHIB.Status.UNDER_WATER)
            {
                d2 = 0.009999999776482582D;
                this.momentum = 0.45F;
            }
            else if (this.status == EntityGVCR2_SHIP_RHIB.Status.IN_AIR)
            {
                this.momentum = 0.9F;
            }
            else if (this.status == EntityGVCR2_SHIP_RHIB.Status.ON_LAND)
            {
                this.momentum = this.boatGlide;

                if (this.getControllingPassenger() instanceof EntityPlayer)
                {
                    this.boatGlide /= 2.0F;
                }
            }
            
            this.motionX *= (double)this.momentum;
            this.motionZ *= (double)this.momentum;
           // this.deltaRotation *= this.momentum;
            this.motionY += d1;

            if (d2 > 0.0D)
            {
                double d3 = 0.65D;
                this.motionY += d2 * 0.06153846016296973D;
                double d4 = 0.75D;
                this.motionY *= 0.75D;
            }
        }
    }
    
    public float getWaterLevelAbove()
    {
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
        int i = MathHelper.floor(axisalignedbb.minX);
        int j = MathHelper.ceil(axisalignedbb.maxX);
        int k = MathHelper.floor(axisalignedbb.maxY);
        int l = MathHelper.ceil(axisalignedbb.maxY - this.lastYd);
        int i1 = MathHelper.floor(axisalignedbb.minZ);
        int j1 = MathHelper.ceil(axisalignedbb.maxZ);
        BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain();

        try
        {
            label108:

            for (int k1 = k; k1 < l; ++k1)
            {
                float f = 0.0F;
                int l1 = i;

                while (true)
                {
                    if (l1 >= j)
                    {
                        if (f < 1.0F)
                        {
                            float f2 = (float)blockpos$pooledmutableblockpos.getY() + f;
                            return f2;
                        }

                        break;
                    }

                    for (int i2 = i1; i2 < j1; ++i2)
                    {
                        blockpos$pooledmutableblockpos.setPos(l1, k1, i2);
                        IBlockState iblockstate = this.world.getBlockState(blockpos$pooledmutableblockpos);

                        if (iblockstate.getMaterial() == Material.WATER)
                        {
                            f = Math.max(f, BlockLiquid.getBlockLiquidHeight(iblockstate, this.world, blockpos$pooledmutableblockpos));
                        }

                        if (f >= 1.0F)
                        {
                            continue label108;
                        }
                    }

                    ++l1;
                }
            }

            float f1 = (float)(l + 1);
            return f1;
        }
        finally
        {
            blockpos$pooledmutableblockpos.release();
        }
    }

    /**
     * Decides how much the boat should be gliding on the land (based on any slippery blocks)
     */
   /* public float getBoatGlide()
    {
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
        AxisAlignedBB axisalignedbb1 = new AxisAlignedBB(axisalignedbb.minX, axisalignedbb.minY - 0.001D, axisalignedbb.minZ, axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        int i = MathHelper.floor(axisalignedbb1.minX) - 1;
        int j = MathHelper.ceil(axisalignedbb1.maxX) + 1;
        int k = MathHelper.floor(axisalignedbb1.minY) - 1;
        int l = MathHelper.ceil(axisalignedbb1.maxY) + 1;
        int i1 = MathHelper.floor(axisalignedbb1.minZ) - 1;
        int j1 = MathHelper.ceil(axisalignedbb1.maxZ) + 1;
        List<AxisAlignedBB> list = Lists.<AxisAlignedBB>newArrayList();
        float f = 0.0F;
        int k1 = 0;
        BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain();

        try
        {
            for (int l1 = i; l1 < j; ++l1)
            {
                for (int i2 = i1; i2 < j1; ++i2)
                {
                    int j2 = (l1 != i && l1 != j - 1 ? 0 : 1) + (i2 != i1 && i2 != j1 - 1 ? 0 : 1);

                    if (j2 != 2)
                    {
                        for (int k2 = k; k2 < l; ++k2)
                        {
                            if (j2 <= 0 || k2 != k && k2 != l - 1)
                            {
                                blockpos$pooledmutableblockpos.setPos(l1, k2, i2);
                                IBlockState iblockstate = this.world.getBlockState(blockpos$pooledmutableblockpos);
                                iblockstate.addCollisionBoxToList(this.world, blockpos$pooledmutableblockpos, axisalignedbb1, list, this, false);

                                if (!list.isEmpty())
                                {
                                    f += iblockstate.getBlock().getSlipperiness(iblockstate, this.world, blockpos$pooledmutableblockpos, this);
                                    ++k1;
                                }

                                list.clear();
                            }
                        }
                    }
                }
            }
        }
        finally
        {
            blockpos$pooledmutableblockpos.release();
        }

        return f / (float)k1;
    }
    
    /**
     * Determines whether the boat is in water, gliding on land, or in air
     */
   /* private EntityGVCR2_SHIP_RHIB.Status getBoatStatus()
    {
    	EntityGVCR2_SHIP_RHIB.Status entityboat$status = this.getUnderwaterStatus();

        if (entityboat$status != null)
        {
            this.waterLevel = this.getEntityBoundingBox().maxY;
            return entityboat$status;
        }
        else if (this.checkInWater())
        {
            return EntityGVCR2_SHIP_RHIB.Status.IN_WATER;
        }
        else
        {
            float f = this.getBoatGlide();

            if (f > 0.0F)
            {
                this.boatGlide = f;
                return EntityGVCR2_SHIP_RHIB.Status.ON_LAND;
            }
            else
            {
                return EntityGVCR2_SHIP_RHIB.Status.IN_AIR;
            }
        }
    }
    
    /**
     * Decides whether the boat is currently underwater.
     */
   /* @Nullable
    private EntityGVCR2_SHIP_RHIB.Status getUnderwaterStatus()
    {
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
        double d0 = axisalignedbb.maxY + 0.001D;
        int i = MathHelper.floor(axisalignedbb.minX);
        int j = MathHelper.ceil(axisalignedbb.maxX);
        int k = MathHelper.floor(axisalignedbb.maxY);
        int l = MathHelper.ceil(d0);
        int i1 = MathHelper.floor(axisalignedbb.minZ);
        int j1 = MathHelper.ceil(axisalignedbb.maxZ);
        boolean flag = false;
        BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain();

        try
        {
            for (int k1 = i; k1 < j; ++k1)
            {
                for (int l1 = k; l1 < l; ++l1)
                {
                    for (int i2 = i1; i2 < j1; ++i2)
                    {
                        blockpos$pooledmutableblockpos.setPos(k1, l1, i2);
                        IBlockState iblockstate = this.world.getBlockState(blockpos$pooledmutableblockpos);

                        if (iblockstate.getMaterial() == Material.WATER && d0 < (double)BlockLiquid.getLiquidHeight(iblockstate, this.world, blockpos$pooledmutableblockpos))
                        {
                            if (((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue() != 0)
                            {
                            	EntityGVCR2_SHIP_RHIB.Status entityboat$status = EntityGVCR2_SHIP_RHIB.Status.UNDER_FLOWING_WATER;
                                return entityboat$status;
                            }

                            flag = true;
                        }
                    }
                }
            }
        }
        finally
        {
            blockpos$pooledmutableblockpos.release();
        }

        return flag ? EntityGVCR2_SHIP_RHIB.Status.UNDER_WATER : null;
    }
    
    private boolean checkInWater()
    {
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
        int i = MathHelper.floor(axisalignedbb.minX);
        int j = MathHelper.ceil(axisalignedbb.maxX);
        int k = MathHelper.floor(axisalignedbb.minY);
        int l = MathHelper.ceil(axisalignedbb.minY + 0.001D);
        int i1 = MathHelper.floor(axisalignedbb.minZ);
        int j1 = MathHelper.ceil(axisalignedbb.maxZ);
        boolean flag = false;
        this.waterLevel = Double.MIN_VALUE;
        BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain();

        try
        {
            for (int k1 = i; k1 < j; ++k1)
            {
                for (int l1 = k; l1 < l; ++l1)
                {
                    for (int i2 = i1; i2 < j1; ++i2)
                    {
                        blockpos$pooledmutableblockpos.setPos(k1, l1, i2);
                        IBlockState iblockstate = this.world.getBlockState(blockpos$pooledmutableblockpos);

                        if (iblockstate.getMaterial() == Material.WATER)
                        {
                            float f = BlockLiquid.getLiquidHeight(iblockstate, this.world, blockpos$pooledmutableblockpos);
                            this.waterLevel = Math.max((double)f, this.waterLevel);
                            flag |= axisalignedbb.minY < (double)f;
                        }
                    }
                }
            }
        }
        finally
        {
            blockpos$pooledmutableblockpos.release();
        }

        return flag;
    }
    
    public static enum Status
    {
        IN_WATER,
        UNDER_WATER,
        UNDER_FLOWING_WATER,
        ON_LAND,
        IN_AIR;
    }*/
}
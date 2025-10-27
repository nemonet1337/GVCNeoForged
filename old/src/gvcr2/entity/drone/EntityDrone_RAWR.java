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

public class EntityDrone_RAWR extends EntityMAVBase
{
	
    public EntityDrone_RAWR(World worldIn)
    {
        super(worldIn);
        this.setSize(1F, 1F);
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
        
        this.spawn_item = mod_GVCR2.gvcr2_drone_rawr;
        
        this.sp = 0.08F;
        this.turnspeed = 3F;
		this.riddng_opentop = true;
		this.renderhud = true;
		this.render_rader = false;
		this.stepHeight = 1.5F;
		this.riddng_maximum = 1;
		riddingx[0]=0.0D;
		riddingy[0]=-0.5D;
		riddingz[0]=0.0D;
		this.ridding_view1_x = -0.3F;
		this.ridding_view1_y = 0.0F;
		this.ridding_view1_z = 0.2F;
		
		
		ridding_view_x=0F;
		ridding_view_y=-1F;
		ridding_view_z=-2F;
		
		antibullet_0 = 1.0F;
		antibullet_1 = 1.0F;
		antibullet_2 = 1.0F;
		antibullet_3 = 1.0F;
		this.ridding_damege = 0.5F;
		
		{
			this.weapon1true = true;
			this.w1can_cooldown = true;
    		this.weapon1key = 0;
    		this.w1name = "MachineGun";
    		this.ammo1 = 2;
    		this.magazine = 20;
    		this.reload_time1 = 80;
    		this.reloadsoundset1 = 40;
    		this.reloadsound1 = GVCSoundEvent.reload_mg;
    		this.w1cycle = 1;
    		this.w1barst = 1;
    		this.weapon1 = 1;
    		{
    			this.bullet_type1[0] = 0;
        		this.bullet_model1[0] = "gvclib:textures/entity/BulletNormal.obj";
        		this.bullet_tex1[0] = "gvclib:textures/entity/BulletNormal.png";
        		this.fire_model1[0]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex1[0] = "gvclib:textures/entity/mflash.png";
        		this.fire_time1[0] = 5;
        		this.sound_fire1[0] = "gvclib.fire_mg";
        		this.fire_pointx1[0] = 0.0F;
        		this.fire_pointy1[0] = 0.8F;
        		this.fire_pointz1[0] = 1.0F;
        		this.basis_pointx1[0] = 0;
        		this.basis_pointy1[0] = 0.75F;
        		this.basis_pointz1[0] = -0.1F;
        		this.fire_yoffset1[0] = -0.03;
        		this.rotationfollowing1[0] = true;
        		this.rotationfirepoint1[0] = true;
        		this.bullet_damage1[0] = 5;
        		this.bullet_speed1[0] = 6F;
        		this.bullet_bure1[0] = 1.0F;
        		this.bullet_expower1[0] = 0;
        		this.bullet_ex1[0] = false;
        		this.bullet_kazu1[0] = 1;
        		this.bullet_gravity1[0] = 0.029D;
        		this.bullet_livingtime1[0] = 80;
        		
    		}
		}
		this.mob_w1range = 50;
		this.mob_w1range_max_y = 15;
		this.mob_w1range_min_y = 2;
		
		
		{
			this.weapon2true = true;
    		this.weapon2key = 2;
    		this.w2name = "GrenadeLauncher";
    		this.ammo2 = 6;
    		this.magazine2 = 8;
    		this.reload_time2 = 80;
    		this.reloadsoundset2 = 40;
    		this.reloadsound2 = GVCSoundEvent.reload_shell;
    		this.w2cycle = 1;
    		this.w2barst = 1;
    		this.weapon2 = 1;
    		this.w2crossfire = true;
    		{
    			this.bullet_type2[0] = 0;
        		this.bullet_model2[0] = "gvclib:textures/entity/BulletNormal.obj";
        		this.bullet_tex2[0] = "gvclib:textures/entity/BulletNormal.png";
        		this.fire_model2[0]= "gvclib:textures/entity/mflash.mqo";
        		this.fire_tex2[0] = "gvclib:textures/entity/mflash.png";
        		this.fire_time2[0] = 5;
        		this.sound_fire2[0] = "gvclib.fire_grenade";
        		this.fire_pointx2[0] = 0.45F;
        		this.fire_pointy2[0] = 0.75F;
        		this.fire_pointz2[0] = 0.0F;
        		this.basis_pointx2[0] = 0;
        		this.basis_pointy2[0] = 0.75F;
        		this.basis_pointz2[0] = -0.1F;
        		this.fire_yoffset2[0] = 0.03;
        		this.rotationfollowing2[0] = true;
        		this.rotationfirepoint2[0] = true;
        		this.bullet_damage2[0] = 20;
        		this.bullet_speed2[0] = 2F;
        		this.bullet_bure2[0] = 1.0F;
        		this.bullet_expower2[0] = 3;
        		this.bullet_ex2[0] = false;
        		this.bullet_kazu2[0] = 1;
        		this.bullet_gravity2[0] = 0.00D;
        		this.bullet_livingtime2[0] = 800;
        		
    		}
		}
		this.mob_w2range = 15;
		this.mob_w2range_max_y = 15;
		this.mob_w2range_min_y = 2;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100D);
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
		this.move_eod();
    }

    public void move_eod() {
    	float f1 = this.rotationYaw * (2 * (float) Math.PI / 360);
    	if (this.canBeSteered() && this.getControllingPassenger() != null && this.getHealth() > 0.0F)
		{
			if(this.getControllingPassenger() instanceof EntityPlayer)
			{
				EntityPlayer entitylivingbase = (EntityPlayer) this.getControllingPassenger();
				
				//entitylivingbase.height = 0.8F;
				{
					double x = this.posX;
					double y = this.posY;
					double z = this.posZ;
			  //      if (this.isAddedToWorld() && !this.world.isRemote) this.world.updateEntityWithOptionalForce(this, false); // Forge - Process chunk registration after moving.
			        float f = this.width / 2.0F;
			        float f12 = this.height;
			        entitylivingbase.setEntityBoundingBox(new AxisAlignedBB(x - (double)f, y, z - (double)f, x + (double)f, y + (double)f12, z + (double)f));
				}
				
				this.setcanDespawn(1);
				//entitylivingbase.rotationYawHead = this.rotationYaw;
				this.rotation = entitylivingbase.rotationYawHead;
				this.rotationp = this.rotationPitch = entitylivingbase.rotationPitch;
				Vec3d looked = entitylivingbase.getLookVec();
				//PL_TankMove.movecar(entitylivingbase, this, sp, turnspeed);

				double xmove = 0;
				double zmove = 0;
				if (entitylivingbase.moveForward > 0.0F) {
					xmove -= MathHelper.sin(f1) * this.sp;
					zmove += MathHelper.cos(f1) * this.sp;
				}
				if (entitylivingbase.moveForward < 0.0F) {
					xmove -= MathHelper.sin(f1) * -this.sp;
					zmove += MathHelper.cos(f1) * -this.sp;
				}
				
				{
					if (entitylivingbase.moveStrafing < 0.0F) {
						if (entitylivingbase.moveForward >= 0.0F) {
							this.rotationYawHead = this.rotationYawHead + turnspeed;
							this.rotationYaw = this.rotationYaw + turnspeed;
							this.renderYawOffset = this.rotationYaw;
						}else {
							this.rotationYawHead = this.rotationYawHead - turnspeed;
							this.rotationYaw = this.rotationYaw - turnspeed;
							this.renderYawOffset = this.rotationYaw;
						}
					}
					if (entitylivingbase.moveStrafing > 0.0F) {
						if (entitylivingbase.moveForward >= 0.0F) {
							this.rotationYawHead = this.rotationYawHead - turnspeed;
							this.rotationYaw = this.rotationYaw - turnspeed;
							this.renderYawOffset = this.rotationYaw;
						}else {
							this.rotationYawHead = this.rotationYawHead + turnspeed;
							this.rotationYaw = this.rotationYaw + turnspeed;
							this.renderYawOffset = this.rotationYaw;
						}
					}
				}
				
				{
					this.motionX = xmove;
					this.motionZ = zmove;
					//entity.motionY = y;
					this.move(MoverType.PLAYER, this.motionX, this.motionY, this.motionZ);
				}
				boolean left = mod_GVCLib.proxy.leftclick();
				boolean right = mod_GVCLib.proxy.rightclick();
				boolean jump = mod_GVCLib.proxy.jumped();
				boolean kx = mod_GVCLib.proxy.keyx();
				boolean kg = mod_GVCLib.proxy.keyg();
				boolean kc = mod_GVCLib.proxy.keyc();
				boolean kz = mod_GVCLib.proxy.keyz();
				if (left) {
					GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(11, this.getEntityId()));
					this.server1 = true;
				}
				if (right) {
					GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(12, this.getEntityId()));
				}
				if (jump) {
					this.serverspace = true;
					GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(13, this.getEntityId()));
					//GVCLPacketHandler.INSTANCE2.sendToAll(new GVCLClientMessageKeyPressed(13, this.getEntityId()));
				}
				if (kx) {
					GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(14, this.getEntityId()));
				}
				if (kg) {
					GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(15, this.getEntityId()));
				}
				if (kc) {
					GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(16, this.getEntityId()));
				}
				if (kz) {
					this.serverz = true;
					GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(17, this.getEntityId()));
					GVCLPacketHandler.INSTANCE2.sendToAll(new GVCLClientMessageKeyPressed(17, this.getEntityId()));
				}
				
				
				if(this.server1)
			    {
			    	{
	    				if(this.cooltime >= this.ammo1){
	    					this.counter1 = true;
	    					this.cooltime = 0;
	    					//GVCLPacketHandler.INSTANCE2.sendToAll(new GVCLClientMessageKeyPressed(2001, this.getEntityId(), this.cooltime));
	    					//GVCLPacketHandler.INSTANCE.sendToServer(new GVCLMessageKeyPressed(2001, this.getEntityId(), this.cooltime));
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
	    				if(this.cooltime2 >= this.ammo2){
	    					this.counter2 = true;
	    					this.cooltime2 = 0;
	    				}
	    				if(this.weapon2true) {
	        		    	this.weapon2active(looked, entitylivingbase);
	        		    }
	    			}
			    	this.serverspace = false;
				}
				
				
			}//player
			else if(this.getControllingPassenger() instanceof EntityGVCLivingBase) {
				
			}
		}
    }

   
}
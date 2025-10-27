package gvcr2.entity.bullet;

import java.util.List;

import gvclib.entity.EntityBBase;
import gvclib.entity.EntityB_Shell;
import gvclib.entity.living.EntityVehicleBase;
import gvclib.network.GVCLClientMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.entity.so.EntityGVCR2_SO_S;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_A10;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_A6;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_C130;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class EntityGVCR2_Request_Smoke extends EntityBBase {
	
	public int req_id = 0;
	
	public EntityGVCR2_Request_Smoke(World worldIn) {
		super(worldIn);
	}

	public EntityGVCR2_Request_Smoke(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityGVCR2_Request_Smoke(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public static void func_189662_a(DataFixer p_189662_0_) {
		EntityBBase.func_189661_a(p_189662_0_, "Snowball");
	}

	protected void entityInit()
    {
		//super.entityInit();
    	this.dataManager.register(Model, new String("gvclib:textures/entity/dynamite.mqo"));
        this.dataManager.register(Tex, new String("gvclib:textures/entity/dynamite.png"));
        this.dataManager.register(ModelF, new String("gvclib:textures/entity/mflash.mqo"));
        this.dataManager.register(TexF, new String("gvclib:textures/entity/mflash.png"));
    }
	
	public void onUpdate()
    {
        super.onUpdate();
        if(inGround) {
        	//this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.5D, 0.0D, new int[0]);
        	 if (!this.world.isRemote && this.world instanceof WorldServer)
             {
        		 WorldServer server = (WorldServer) this.world;
        		 server.spawnParticle(EnumParticleTypes.CLOUD, true, this.posX, this.posY, this.posZ, 1, 0.0D, 2.0D, 0.0D, 0D, 0);
             }
        }
    }
	
	private void explode()
    {
        
    }
	
	public boolean spawn_impact = false;
	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	protected void onImpact(RayTraceResult result) {
		Entity entity = result.entityHit;
		
		if(!spawn_impact){
			if(this.getThrower() != null && this.getThrower() instanceof EntityPlayer) {
				EntityPlayer entityplayer = (EntityPlayer)this.getThrower();
				if(req_id == 1) {
					this.callbomber(this.world, entityplayer, this.posX, this.posY, this.posZ, 100, 30);
				}
				if(req_id == 2) {
					for(int ii = 0; ii < 3; ++ii) {
						double xx11 = 0;
						double zz11 = 0;
						float side = 0;
						if(ii == 1)side = -1.57F;
						if(ii == 2)side = 1.57F;
						xx11 -= MathHelper.sin((entityplayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
						zz11 += MathHelper.cos((entityplayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
						xx11 -= MathHelper.sin((entityplayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
						zz11 += MathHelper.cos((entityplayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
						double xx = this.posX - xx11;
						double yy = this.posY;
						double zz = this.posZ - zz11;
						this.callbomber(this.world, entityplayer, xx, yy, zz, 100, 30);
					}
				}
				if(req_id == 3) {
					for(int ii = 0; ii < 3; ++ii) {
						double xx11 = 0;
						double zz11 = 0;
						float side = 0;
						if(ii == 1)side = -1.57F;
						if(ii == 2)side = 1.57F;
						xx11 -= MathHelper.sin((entityplayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
						zz11 += MathHelper.cos((entityplayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
						xx11 -= MathHelper.sin((entityplayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
						zz11 += MathHelper.cos((entityplayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
						double xx = this.posX - xx11;
						double yy = this.posY;
						double zz = this.posZ - zz11;
						this.callbomber(this.world, entityplayer, xx, yy, zz, 100, 30);
					}
					for(int ii = 0; ii < 3; ++ii) {
						double xx11 = 0;
						double zz11 = 0;
						float side = 0;
						if(ii == 1)side = -1.57F;
						if(ii == 2)side = 1.57F;
						xx11 -= MathHelper.sin((entityplayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
						zz11 += MathHelper.cos((entityplayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
						xx11 -= MathHelper.sin((entityplayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
						zz11 += MathHelper.cos((entityplayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
						double xx = this.posX - xx11;
						double yy = this.posY;
						double zz = this.posZ - zz11;
						this.callbomber(this.world, entityplayer, xx, yy, zz, 115, 30);
					}
				}
				if(req_id == 4) {
					this.callbomber(this.world, entityplayer, this.posX, this.posY, this.posZ, 100, 31);
				}
				if(req_id == 5) {
					this.callbomber(this.world, entityplayer, this.posX, this.posY, this.posZ, 100, 32);
				}
				if(req_id == 6) {
					this.callbomber(this.world, entityplayer, this.posX, this.posY, this.posZ, 100, 33);
				}
				if(req_id == 7) {
					this.callbomber(this.world, entityplayer, this.posX, this.posY, this.posZ, 100, 34);
				}
				if(req_id == 8) {
					for(int ii = 0; ii < 3; ++ii) {
						double xx11 = 0;
						double zz11 = 0;
						float side = 0;
						if(ii == 1)side = -1.57F;
						if(ii == 2)side = 1.57F;
						xx11 -= MathHelper.sin((entityplayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
						zz11 += MathHelper.cos((entityplayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
						xx11 -= MathHelper.sin((entityplayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
						zz11 += MathHelper.cos((entityplayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
						double xx = this.posX - xx11;
						double yy = this.posY;
						double zz = this.posZ - zz11;
						this.callbomber(this.world, entityplayer, xx, yy, zz, 100, 34);
					}
				}
				if(req_id == 9) {
					for(int ii = 0; ii < 4; ++ii) {
						int rax = this.world.rand.nextInt(8);
						int raz = this.world.rand.nextInt(8);
						this.fire(this.world, entityplayer, this.posX - 4 + rax, this.posY + ii * 10, this.posZ - 4 + raz, 0);
					}
				}
				if(req_id == 10) {
					for(int ii = 0; ii < 8; ++ii) {
						int rax = this.world.rand.nextInt(8);
						int raz = this.world.rand.nextInt(8);
						this.fire(this.world, entityplayer, this.posX - 4 + rax, this.posY + ii * 10, this.posZ - 4 + raz, 1);
					}
				}
				if(req_id == 11) {
					for(int ii = 0; ii < 10; ++ii) {
						int rax = this.world.rand.nextInt(10);
						int raz = this.world.rand.nextInt(10);
						this.fire(this.world, entityplayer, this.posX - 5 + rax, this.posY + ii * 10, this.posZ - 5 + raz, 2);
					}
				}
				if(req_id == 12) {
					this.callbomber(this.world, entityplayer, this.posX, this.posY, this.posZ, 110, 35);
				}
				if(req_id == 13) {
					for(int ii = 0; ii < 3; ++ii) {
						double xx11 = 0;
						double zz11 = 0;
						float side = 0;
						if(ii == 1)side = -1.57F;
						if(ii == 2)side = 1.57F;
						xx11 -= MathHelper.sin((entityplayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
						zz11 += MathHelper.cos((entityplayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
						xx11 -= MathHelper.sin((entityplayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
						zz11 += MathHelper.cos((entityplayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
						double xx = this.posX - xx11;
						double yy = this.posY;
						double zz = this.posZ - zz11;
						this.callbomber(this.world, entityplayer, xx, yy, zz, 110, 35);
					}
				}
				
			}//end
		}
		inGround = true;
		spawn_impact = true;
	}

	public void callbomber(World par2World, EntityLivingBase par3EntityPlayer, double ix, double iy, double iz, double range, int id) {
    	if(par3EntityPlayer != null){
			double xx11 = 0;
			double zz11 = 0;
			xx11 -= MathHelper.sin(par3EntityPlayer.rotationYaw * 0.01745329252F - 1.57F) * range;
			zz11 += MathHelper.cos(par3EntityPlayer.rotationYaw * 0.01745329252F - 1.57F) * range;
			double xx = ix - xx11;
			double yy = iy + 40;
			double zz = iz - zz11;
			EntityVehicleBase var8;
			if(id == 33 || id == 34) {
				var8 = new EntityGVCR2_AIR_C130(par2World);
			}
			else if(id == 35) {
				var8 = new EntityGVCR2_AIR_A10(par2World);
				yy = iy + 20;
			}
			else {
				var8 = new EntityGVCR2_AIR_A6(par2World);
			}
			var8.fri = par3EntityPlayer;
			var8.rotationYaw = var8.rotationYawHead = var8.renderYawOffset = -((float) Math.atan2(ix - xx, iz - zz)) * 180.0F
					/ (float) Math.PI;
			var8.setLocationAndAngles(xx, yy, zz, var8.rotationYawHead, var8.rotationPitch);
			var8.setFTMode(id);
			var8.setcanDespawn(1);

			if (!par2World.isRemote) {
				par2World.spawnEntity(var8);
			}
			if (!par2World.isRemote){
				EntityGVCR2_SO_S entityskeleton = new EntityGVCR2_SO_S(par2World);
		        entityskeleton.setLocationAndAngles(xx, yy, zz, 0, 0.0F);
		        entityskeleton.setcanDespawn(1);
		        par2World.spawnEntity(entityskeleton);
		        entityskeleton.startRiding(var8);
			}
		}
	}
	
	
	public void fire(World par2World, EntityLivingBase par3EntityPlayer, double ix, double iy, double iz, int id) {
    	EntityB_Shell var8 = new EntityB_Shell(par2World, (EntityLivingBase) par3EntityPlayer);
    	if(id == 1) {
    		var8.Bdamege = 60;
    		var8.exlevel = 4.0F;
    		var8.setModel("gvclib:textures/entity/model/bullet_cannon_small.mqo");
			var8.setTex("gvclib:textures/entity/model/bullet_cannon_small.png");
    	}else if(id == 2) {
    		var8.Bdamege = 100;
    		var8.exlevel = 6.0F;
    		var8.setModel("gvclib:textures/entity/model/bullet_cannon.mqo");
			var8.setTex("gvclib:textures/entity/model/bullet_cannon.png");
    	}else {
    		var8.Bdamege = 60;
    		var8.exlevel = 4.0F;
    		var8.setModel("gvclib:textures/entity/model/bullet_cannon_small.mqo");
			var8.setTex("gvclib:textures/entity/model/bullet_cannon_small.png");
    	}
		
    	var8.spg_fly_sound = true;
		var8.gra = 0;
		var8.muteki = true;
		var8.friend = par3EntityPlayer;
		
		var8.bulletDameID = this.bulletDameID;
		var8.ex = this.ex;
		
		//var8.P_ID = this.p_id;
		var8.mitarget = this.mitarget;
		float bbure = 1;
		var8.timemax = 800;
		var8.setLocationAndAngles(ix, iy + 200, iz, 0,0);
		var8.setHeadingFromThrower(par3EntityPlayer, 90, par3EntityPlayer.rotationYaw, 0.0F,3F, bbure);
		
		if (!par2World.isRemote) {
			par2World.spawnEntity(var8);
		}
	}
	
	@Override
	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
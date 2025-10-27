package gvcr2.entity.bullet;

import java.util.List;

import gvclib.entity.EntityBBase;
import gvclib.entity.living.EntityVehicleBase;
import gvclib.event.GVCSoundEvent;
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
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class EntityGVCR2_Bullet_ROG extends EntityBBase {
	
	public int req_id = 0;
	
	public EntityGVCR2_Bullet_ROG(World worldIn) {
		super(worldIn);
	}

	public EntityGVCR2_Bullet_ROG(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityGVCR2_Bullet_ROG(World worldIn, double x, double y, double z) {
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
		this.motionX = 0F;
		this.motionY = 0F;
		this.motionZ = 0F;
		if(this.getThrower() != null){
			String model = "gvclib:textures/entity/model/bullet_aaa.mqo";
    		String tex = "gvclib:textures/entity/model/bullet_aaa.png";
    		String modelf = "gvclib:textures/entity/mflash.mqo";
    		String texf = "gvclib:textures/entity/mflash.png";
    		SoundEvent sounds = GVCSoundEvent.fire_mg;
    		//
    		EntityBBase var3;
    		var3 = new EntityGVCR2_Bullet_Beam(this.world, this.getThrower());
    		var3.Bdamege = 5;
			var3.gra = 0.029;// 0.025
			//var3.friend = entity;
			var3.friend = this.getThrower();
			var3.ex = false;
			var3.exfire = false;
			var3.exsmoke = false;
			var3.exflash = false;
			var3.exlevel = 10;
			var3.setModel(model);
			var3.setTex(tex);
			var3.timemax = 200;
			var3.bulletDameID = 0;
			var3.muteki = true;
			var3.fly_sound = false;
			
			var3.startposX = this.posX;
			var3.startposY = this.posY;
			var3.startposZ = this.posZ;
			
			float w = 0F;
			float bx = 0F;
			double z = 0.0;
			double bz = 0.0;
			double h = -2.5;
			double by = -2.5;
			
			boolean follow_rote = true;//向いている方向に
			float xoffset = 0;
			float yoffset = 0;
			double px = this.posX;
			double py = this.posY;
			double pz = this.posZ;
			float rote = this.rotationYaw;
			
			double xx11 = 0;
			double zz11 = 0;
			xx11 -= MathHelper.sin(rote * 0.01745329252F) * z;
			zz11 += MathHelper.cos(rote * 0.01745329252F) * z;
			xx11 -= MathHelper.sin(rote * 0.01745329252F + 1.57F) * w;
			zz11 += MathHelper.cos(rote * 0.01745329252F + 1.57F) * w;
			double offx = 0;
			double offz = 0;
			offx -= MathHelper.sin(rote * 0.01745329252F + 1.57F) * xoffset;
			offz += MathHelper.cos(rote * 0.01745329252F + 1.57F) * xoffset;
			double kaku = 0;
			//kaku += lock.y * 2;
			kaku = MathHelper.sqrt((z - bz)* (z - bz) + (w - bx)*(w - bx)) * Math.tan(Math.toRadians(-this.rotationPitch)) * 0.4D;
			var3.setLocationAndAngles(px + xx11, py + h + kaku, pz + zz11, this.rotationYaw,
					0.0F);
			float pitch = 0;
			float yaw = -90;
			pitch = this.world.rand.nextInt(90);
			
			
			var3.setHeadingFromThrower(this, time * 4 + 45, this.rotationYaw + (float)xoffset + yaw, 0.0F,
					2F, 1F);
			
			
			if (!this.world.isRemote) {
				this.world.spawnEntity(var3);
			}
		}
		
		
		++time;
        if(time > timemax){
        	if(!this.world.isRemote){
        		//System.out.println(String.format("dead"));
        	this.setDead();
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
		
	}
	
	@Override
	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
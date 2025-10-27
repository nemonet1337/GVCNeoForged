package gvcr2.entity.bullet;

import java.util.List;

import gvclib.entity.EntityBBase;
import gvclib.entity.EntityT_Grenade;
import gvclib.entity.GVCDamageSource;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityGVCR2_Bullet_Beam extends EntityBBase {
	public EntityGVCR2_Bullet_Beam(World worldIn) {
		super(worldIn);
	}

	public EntityGVCR2_Bullet_Beam(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityGVCR2_Bullet_Beam(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public static void func_189662_a(DataFixer p_189662_0_) {
		EntityBBase.func_189661_a(p_189662_0_, "Snowball");
	}
	
	protected void entityInit()
    {
		//super.entityInit();
    	this.dataManager.register(Model, new String("gvclib:textures/entity/BulletAAA.obj"));
        this.dataManager.register(Tex, new String("gvclib:textures/entity/BulletAAA.png"));
        this.dataManager.register(ModelF, new String("gvclib:textures/entity/mflash.mqo"));
        this.dataManager.register(TexF, new String("gvclib:textures/entity/mflash.png"));
    }

	public boolean exnear = false;
	
	public boolean impact = false;
	public int im_time = 0;
	
	public void onUpdate()
    {
        super.onUpdate();
        if(this.startposX == 0) {
        	this.startposX = this.posX;
        	this.startposY = this.posY;
        	this.startposZ = this.posZ;
        }
        /*if(impact) {
        	++im_time;
        	if (!this.world.isRemote && im_time > 5) {
        		GVCExplosionBase.ExplosionKai(this.getThrower(), this, this.posX + 0, this.posY + 0, this.posZ + 0, this.exlevel, this.exfire,  this.ex);
				this.setDead();
			}
        }*/
    }
	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			//GVCExplosionBase.ExplosionKai(this.getThrower(), this, this.posX + 0, this.posY + 0, this.posZ + 0, this.exlevel, this.exfire,  this.ex);
			if(this.getThrower() != null) {
				EntityT_Grenade gre = new EntityT_Grenade(this.world, this.getThrower());
				gre.timemax = 20;
				gre.exlevel = 5F;
				gre.ex = mod_GVCR2.cfg_exprotion_mob;
				gre.setModel("gvcr2:textures/entity/rog.mqo");
				gre.setTex("gvcr2:textures/entity/rog.png");
				gre.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
				gre.setHeadingFromThrower(this, 0.0F, 0.0F, 0.0F, 1F, 1F);
				this.world.spawnEntity(gre);
			}
			this.setDead();
		}
		/*{
			this.motionX = (double)((float)(result.hitVec.x - this.posX));
            this.motionY = (double)((float)(result.hitVec.y - this.posY));
            this.motionZ = (double)((float)(result.hitVec.z - this.posZ));
            float f2 = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
            this.posX -= this.motionX / (double)f2 * 0.05000000074505806D;
            this.posY -= this.motionY / (double)f2 * 0.05000000074505806D;
            this.posZ -= this.motionZ / (double)f2 * 0.05000000074505806D;
		}*/
		/*{
			boolean ap = false;
			if (result.entityHit != null) 
			{
				int i = Bdamege;
				if (this.muteki) {
					result.entityHit.hurtResistantTime = 0;
				}

				if(this.bulletDameID == 1){
					result.entityHit.attackEntityFrom(GVCDamageSource.causeBulletAP(this, this.getThrower()), (float) i);
					ap = true;
				}else{
					result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float) i);
				}
			}
			if (!this.world.isRemote && this.exlevel >= 0) {
			}
			this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY + 0D, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);

			if (!this.world.isRemote && !ap) {
				this.setDead();
			}
		}*/
	}

	@Override
	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
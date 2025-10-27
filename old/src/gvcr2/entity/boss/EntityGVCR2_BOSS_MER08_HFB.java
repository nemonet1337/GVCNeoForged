package gvcr2.entity.boss;

import java.util.List;
import java.util.Random;

import gvclib.entity.EntityB_BulletFire;
import gvclib.entity.living.AI_Damage;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.ISoldier;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLClientMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGVCR2_BOSS_MER08_HFB extends EntityGVCR2_BOSSBase {
	
	public EntityGVCR2_BOSS_MER08_HFB(World worldIn) {
		super(worldIn);
		this.setSize(1F, 2.5F);
		aitypemax = 60;
		aitypemax2 = 40;
		aitypemaxset = 4;
		aitypemaxset2 = 7;
		this.experienceValue = 300;
	}

	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIRestrictSun(this));
		this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
	}

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		
	}
	
	public boolean getdame = false;
	public boolean attackEntityFrom(DamageSource source, float par2)
    {
    	Entity entity;
    	entity = source.getTrueSource();
    	Entity entity2 = source.getImmediateSource();
    	
    	if(this.startuptime < 100) {
    		return false;
    	}else {
    		if(entity != null){
    			if(entity instanceof IMob){
    	    		return false;
    	        }else {
    	        	par2 = par2 * AI_Damage.newAntiBullet(this, entity2, par2, 0.5F, 1.0F, 1.0F, 1.0F);
    	        	if(entity2 instanceof EntityB_BulletFire)
    	    		{
    	        		par2 = 0;
    	            }
    	        	if(!(this.getHealth() > this.getMaxHealth()/2)) {
    	        		par2 = par2 * AI_Damage.newAntiBullet(this, entity2, par2, 0.0F, 0.0F, 1.0F, 1.0F);
    	        		getdame = true;
    	        	}
    				if(par2 <= 0.0) {
    					this.playSound(SoundEvents.BLOCK_ANVIL_LAND, 5F, 1F);
    				}
    				if(this.getHealth() > this.getMaxHealth()/2){
    					float x = this.getHealth() - par2;
    					if(x <= this.getMaxHealth()/2) {
    						this.startuptime = 0;
    					}
    				}
    				if(!(entity instanceof EntityPlayer)){
    					par2 = par2 * 0.1F;
    				}
    				return super.attackEntityFrom(source, par2);
    	        }
    		}else{
    			return super.attackEntityFrom(source, par2);
    		}
    	}
    }
    
	public void onUpdate()
    {
        super.onUpdate();
        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL && this.getcanDespawn() == 0)
        {
            this.setDead();
        }
    }
    
	protected void onDeathUpdate() {
		//super.onDeathUpdate();
		++deathTime;
		if (this.deathTime % 10 == 0 && !this.world.isRemote){
				int x = new Random().nextInt(3) - 1;
				int y = new Random().nextInt(3) + 0;
				int z = new Random().nextInt(3) - 1;
				GVCExplosionBase.ExplosionKai(this, this, this.posX + x, this.posY + y, this.posZ + z, 0, false,  false);
		}
		if(!this.world.isRemote && this.deathTime == 100) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 2, false,  false);
			{
				this.world.setBlockState(new BlockPos(this.getMoveX(), this.getMoveY(), this.getMoveZ()), Blocks.CHEST.getDefaultState(), 2);
				TileEntityChest Chest3;
				Chest3 = (TileEntityChest) this.world.getTileEntity(new BlockPos(this.getMoveX(), this.getMoveY(), this.getMoveZ()));
				Chest3.setInventorySlotContents(13, new ItemStack(mod_GVCR2.gvcr2_gun_m202, 1, 0));
				
				Chest3.setInventorySlotContents(4, new ItemStack(Blocks.DIAMOND_BLOCK, 2, 0));
				Chest3.setInventorySlotContents(12, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
				Chest3.setInventorySlotContents(14, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
				Chest3.setInventorySlotContents(22, new ItemStack(Blocks.EMERALD_BLOCK, 4, 0));
				
				//Chest3.setInventorySlotContents(0, new ItemStack(mod_GVCR.i_aichip, 1, 0));
			}
			this.setDead();
		}
	}
	
	private int pos_reset = 0;
	public void getbeacon() {
		++pos_reset;
    	int i = 64;
    	if(this.pos_reset > 100 && this.getMoveT() == 1) {
    		double x = Math.abs(this.posX - this.getMoveX());
    		double y = Math.abs(this.posY - this.getMoveY());
    		double z = Math.abs(this.posZ - this.getMoveZ());
    		if(x > 40 && z > 40) {
    			this.setPositionAndUpdate(this.getMoveX(), this.getMoveY(), this.getMoveZ());
    		}
    		if(y > 15) {
    			this.setPositionAndUpdate(this.getMoveX(), this.getMoveY(), this.getMoveZ());
    		}
    		if(this.targetentity == null) {
    			this.setPositionAndUpdate(this.getMoveX(), this.getMoveY(), this.getMoveZ());
    		}
    		this.pos_reset = 0;
    	}
    	
    }
	
	@SideOnly(Side.CLIENT)
    public int getBrightnessForRender()
    {
        return 15728880;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness()
    {
        return 1.0F;
    }
	
	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
    int self_ex = 0;
    public float lasehp;
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.biped = true;
		this.reload_time1 = 60;
		this.magazine = 24;
		
		float sp = 0.1F;
		Vec3d looked = this.getLookVec();
		
		boolean exflag = false;
		
		if(this.getHealth() > this.getMaxHealth()/2) {
			if(this.startuptime < 100)return;
		}else {
			if(this.startuptime < 100) {
				int rx = this.world.rand.nextInt(2);
				int rz = this.world.rand.nextInt(2);
				if(this.getHealth() <= this.getMaxHealth()/4)this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX-1+rx, this.posY + 1D, this.posZ-1+rz, 0.0D, 0.0D, 0.0D, new int[0]);
				this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX-1+rx, this.posY + 1D, this.posZ-1+rz, 0.0D, 0.0D, 0.0D, new int[0]);
				if (this.startuptime % 10 == 0 && !this.world.isRemote) {
					int x = new Random().nextInt(3) - 1;
					int y = new Random().nextInt(3) + 0;
					int z = new Random().nextInt(3) - 1;
					GVCExplosionBase.ExplosionKai(this, this, this.posX + x, this.posY + y, this.posZ + z, 0, false,  false);
				}
			}
			if(this.startuptime < 100)return;
			
		}
		
		
		if(this.getMoveT() == 0) {
			this.setMoveT(1);
			this.setMoveX((int)this.posX);
			this.setMoveY((int)this.posY);
			this.setMoveZ((int)this.posZ);
		}
		
		if(this.getHealth() > 0.0F) {
			AI_EntityWeapon.getTargetEntity(this, 80, 20, 20);
			this.newmove(this, 1, sp, 0, 2, 80);
			if(!this.world.isRemote)this.getbeacon();
		}
		if(getdame) {
			++ammo1;
			if(ammo1 > 20) {
				getdame = false;
			}
			this.aitypetime = 0;
			this.setAIType(5);
		}
		
		if(this.getHealth() > this.getMaxHealth()/2)
		{
			boolean task = AI_EntityWeapon.KnifeAttack(this, 0, 2, 0, 2, 2);
			if(task)
			{
				if(cooltime4 > 60){
					this.counter4 = true;
		            cooltime4 = 0;
		            //System.out.println("1");
		            GVCLPacketHandler.INSTANCE2.sendToAll(new GVCLClientMessageKeyPressed(2004, this.getEntityId(), 0));
				}
				if(this.counter4 && cooltime4 > 20){
					double x2 = 0;
					double z2 = 0;
					x2 -= MathHelper.sin(this.rotation * 0.01745329252F) * 1.0;
					z2 += MathHelper.cos(this.rotation * 0.01745329252F) * 1.0;
					AxisAlignedBB axisalignedbb2 = new AxisAlignedBB(
							this.posX + x2, this.posY, this.posZ + z2, 
							this.posX + x2, this.posY, this.posZ + z2)
			        		.expand(1, 1, 1);
					List<Entity> llist = this.world.getEntitiesWithinAABBExcludingEntity(this,axisalignedbb2);
					if (llist != null) {
						for (int lj = 0; lj < llist.size(); lj++) {
							Entity entity1 = (Entity) llist.get(lj);
							if (entity1.canBeCollidedWith() && entity1 instanceof EntityLivingBase && entity1 != null) {
								if(entity1 != this && entity1 != this.getControllingPassenger()){
									entity1.attackEntityFrom(DamageSource.causeMobDamage(this), 15);
									//System.out.println("2");
								}
							}
						}
					}
					this.counter4 = false;
					this.setAIType(3);
					this.aitypetime = 0;
					//System.out.println("3");
				}
			}
		}else {
			boolean task = AI_EntityWeapon.KnifeAttack(this, 0, 2, 0, 2, 2);
			if(task)
			{
			if(cooltime4 > 60){
				this.counter4 = true;
	            cooltime4 = 0;
	            //System.out.println("1");
	            GVCLPacketHandler.INSTANCE2.sendToAll(new GVCLClientMessageKeyPressed(2004, this.getEntityId(), 0));
			}
			if(this.counter4 && cooltime4 > 20){
				double x2 = 0;
				double z2 = 0;
				x2 -= MathHelper.sin(this.rotation * 0.01745329252F) * 1.0;
				z2 += MathHelper.cos(this.rotation * 0.01745329252F) * 1.0;
				AxisAlignedBB axisalignedbb2 = new AxisAlignedBB(
						this.posX + x2, this.posY, this.posZ + z2, 
						this.posX + x2, this.posY, this.posZ + z2)
		        		.expand(1, 1, 1);
				List<Entity> llist = this.world.getEntitiesWithinAABBExcludingEntity(this,axisalignedbb2);
				if (llist != null) {
					for (int lj = 0; lj < llist.size(); lj++) {
						Entity entity1 = (Entity) llist.get(lj);
						if (entity1.canBeCollidedWith() && entity1 instanceof EntityLivingBase && entity1 != null) {
							if(entity1 != this && entity1 != this.getControllingPassenger()){
								entity1.attackEntityFrom(DamageSource.causeMobDamage(this), 10);
								//System.out.println("2");
							}
						}
					}
				}
				this.counter4 = false;
				this.setAIType(3);
				this.aitypetime = 0;
				//System.out.println("3");
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
									entity.rotationYawHead = entity.rotation = entity.rote = entity.renderYawOffset 
											= -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
									entity.rotationp = entity.rotationPitch = -f11 + 0;
									double ddx = Math.abs(d5);
									double ddz = Math.abs(d7);
									if ((ddx > 40 || ddz > 40)) 
									{
										this.setAIType(0);
										this.aitypetime = 0;
										this.setAIType2(0);
										this.aitypetime2 = 0;
										MoveS(entity, sp, 1, entity1.posX, entity1.posY, entity1.posZ, id, (EntityLivingBase)entity1);
									}else {
										MoveS(entity, sp, 1, entity1.posX, entity1.posY, entity1.posZ, id, (EntityLivingBase)entity1);
									}
									entity.noflag = 0;
									ta = true;
								}
								if (flag) {
									entity.targetentity = (EntityLivingBase) entity1;
								}
								ta = true;
								break;
							} 
						}//target
						
					}
				}
			}
		}
		if(!ta){
			stay(entity, id);
		}else{
			entity.sneak = true;
		}
	}
	
	public void spawnp() {
		for (int i = 0; i < 2; ++i)
        {
            this.world.spawnParticle(EnumParticleTypes.PORTAL, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
        }
	}
	
	public void MoveS(EntityGVCLivingBase entity, double speed, double han, double ex, double ey, double ez, int id, EntityLivingBase en){
		{// 1
			if(!(entity.getHealth() > entity.getMaxHealth()/2)) {
				/*if(entity.getAIType2() == 0
						|| entity.getAIType2() == 1
						|| entity.getAIType2() == 2
						|| entity.getAIType2() == 3
						|| entity.getAIType2() == 4) {
					spawnp();
				}
				else {
				}*/
				spawnp();
			}
			if(!entity.world.isRemote)
			{
				double d5 = ex - entity.posX;
				double d7 = ez - entity.posZ;
				
				double root = Math.sqrt(d5 * d5 + d7 * d7);
				
				float off = 0;
				entity.rotationYaw = entity.renderYawOffset = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
				float yaw = entity.rotationYaw * (2 * (float) Math.PI / 360);
				double mox = 0;
				double moy = entity.motionY;
				double moz = 0;
				
				if(entity.getHealth() > entity.getMaxHealth()/2) {
					if(entity.getAIType() == 1) {
						if(aitypetime > 10) {
							mox -= MathHelper.sin(yaw + 1.57F) * speed * -20;
							moz += MathHelper.cos(yaw + 1.57F) * speed * -20;
							moy = 0.2;
							this.aitypetime = 0;
							this.setAIType(4);
						}
					}
					else if(entity.getAIType() == 2) {
						if(aitypetime > 10) {
							mox -= MathHelper.sin(yaw + 1.57F) * speed * -20;
							moz += MathHelper.cos(yaw + 1.57F) * speed * -20;
							moy = 0.2;
							this.aitypetime = 0;
							this.setAIType(4);
						}
					}
					else if(entity.getAIType() == 3) {
						if(aitypetime > 10) {
							mox -= MathHelper.sin(yaw) * speed * -20;
							moz += MathHelper.cos(yaw) * speed * -20;
							moy = 0.2;
							this.aitypetime = 0;
							this.setAIType(4);
						}
					}
					else if(entity.getAIType() == 0) {
						mox -= MathHelper.sin(yaw) * speed * 1;
						moz += MathHelper.cos(yaw) * speed * 1;
						double ddx = Math.abs(d5);
						double ddz = Math.abs(d7);
						if ((ddx < 2 && ddz < 2)) 
						{
							this.aitypetime = 0;
							this.setAIType(5);
						}
						/*if(entity.aitypetime == 30 && entity.targetentity != null) {
							double x1 = 0;
							double z1 = 0;
							float ff = entity.targetentity.rotationYawHead * 0.01745329252F;
							x1 -= MathHelper.sin(ff) * 1.5;
							z1 += MathHelper.cos(ff) * 1.5;
							entity.setPositionAndUpdate(entity.targetentity.posX + x1, entity.targetentity.posY, entity.targetentity.posZ + z1);
						}*/
						
					}
					else if(entity.getAIType() == 4) {
						if(aitypetime > 0) {
							this.aitypetime = aitypemax;
						}
					}
				}else {
					if(entity.getAIType() == 1) {
						mox -= MathHelper.sin(yaw + 1.57F) * speed * 0.5;
						moz += MathHelper.cos(yaw + 1.57F) * speed * 0.5;
					}
					else if(entity.getAIType() == 2) {
						mox -= MathHelper.sin(yaw - 1.57F) * speed * 0.5;
						moz += MathHelper.cos(yaw - 1.57F) * speed * 0.5;
					}
					else if(entity.getAIType() == 3) {
						mox -= MathHelper.sin(yaw) * speed * -0.5;
						moz += MathHelper.cos(yaw) * speed * -0.5;
					}
					else if(entity.getAIType() == 0) {
						mox -= MathHelper.sin(yaw) * speed * 0.5;
						moz += MathHelper.cos(yaw) * speed * 0.5;
					}
					else {
						
					}
				}
				/*else {
					if(entity.getAIType() == 1) {
						mox -= MathHelper.sin(yaw + 1.57F) * speed * 0.5;
						moz += MathHelper.cos(yaw + 1.57F) * speed * 0.5;
					}
					else if(entity.getAIType() == 2) {
						mox -= MathHelper.sin(yaw - 1.57F) * speed * 0.5;
						moz += MathHelper.cos(yaw - 1.57F) * speed * 0.5;
					}
					else if(entity.getAIType() == 3) {
						mox -= MathHelper.sin(yaw) * speed * -0.5;
						moz += MathHelper.cos(yaw) * speed * -0.5;
					}
					else if(entity.getAIType() == 0) {
						if(entity.aitypetime == 30 && entity.targetentity != null) {
							double x1 = 0;
							double z1 = 0;
							float ff = entity.targetentity.rotationYawHead * 0.01745329252F;
							x1 -= MathHelper.sin(ff) * 1.5;
							z1 += MathHelper.cos(ff) * 1.5;
							entity.setPositionAndUpdate(entity.targetentity.posX + x1, entity.targetentity.posY, entity.targetentity.posZ + z1);
						}
					}
					else {
						
					}
				}*/
				
				
				
				
				entity.stepHeight = entity.height * 0.8F;
				{
					{
						entity.motionX = mox;
						entity.motionZ = moz;
						entity.motionY = moy;
						entity.move(MoverType.SELF, entity.motionX, entity.motionY, entity.motionZ);
					}
				}

			}
		} // 1
	}
	
	public static void stay(EntityGVCLivingBase entity, int id) {
		double xPosition = 0;
	    double yPosition = 0;
	    double zPosition = 0;
		if (entity.getIdleTime() >= 100)
        {
        }
        else if (entity.getRNG().nextInt(120) != 0)
        {
        }
        else
        {
            Vec3d vec3 = RandomPositionGenerator.findRandomTarget(entity, 10, 7);

            if (vec3 == null)
            {
            }
            else
            {
                xPosition = vec3.x;
                yPosition = vec3.y;
                zPosition = vec3.z;
            }
            entity.rotation = entity.getRNG().nextInt(120) - 60;
        }
		if(id != 0) {
			entity.getNavigator().tryMoveToXYZ(xPosition, yPosition, zPosition, 1D);
		}
	}
	
}
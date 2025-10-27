package gvcr2.entity.boss;

import java.util.List;
import java.util.Random;

import gvclib.entity.living.AI_Damage;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_EntityWeapon_new;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.ISoldier;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLClientMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.monster.EntityGolem;
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
import net.minecraft.util.EnumHand;
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
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGVCR2_BOSS_IRVING extends EntityGVCR2_BOSSBase {
	
	public EntityGVCR2_BOSS_IRVING(World worldIn) {
		super(worldIn);
		this.setSize(3F, 5F);
		aitypemax = 40;
		aitypemaxset= 9;
		aitypemax2 = 50;
		aitypemaxset2 = 5;
		this.experienceValue = 300;
	}

	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIRestrictSun(this));
		this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(400D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
	}
	
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		
	}
	
	public SoundEvent  DamegeSound = SoundEvents.BLOCK_ANVIL_LAND;
	public boolean attackEntityFrom(DamageSource source, float par2)
    {
    	Entity entity;
    	entity = source.getImmediateSource();
    	
		if(entity != null){
			if(this.getControllingPassenger() != null && this.getControllingPassenger() == source.getImmediateSource()){
	    		return false;
	        }else
	        {
				/*par2 = par2 * AI_Damage.newAntiBullet(this, entity, par2, 0F, 0.05F, 0.5F, 0.75F);
				if(par2 <= 0.0) {
					this.playSound(DamegeSound, 5F, 1F);
				}*/
				return super.attackEntityFrom(source, par2);
			}
		}else{
			return super.attackEntityFrom(source, par2);
		}
    }
	
	protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier)
    {
    }
	
    
	public void onUpdate()
    {
        super.onUpdate();
        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL && this.getcanDespawn() == 0)
        {
            this.setDead();
        }
        
        if(FMLCommonHandler.instance().getMinecraftServerInstance() != null) {
			for (EntityPlayerMP playermp : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers()) {
				GVCLPacketHandler.INSTANCE2.sendTo(new GVCLClientMessageKeyPressed(2004, this.getEntityId(), cooltime4), playermp);
				GVCLPacketHandler.INSTANCE2.sendTo(new GVCLClientMessageKeyPressed(2017, this.getEntityId(), counter4), playermp);
			}
		}
    }
    
	protected void onDeathUpdate() {
		//super.onDeathUpdate();
		++deathTime;
		if(this.deathTime <= 140) {
			if (this.deathTime % 10 == 0 && !this.world.isRemote) {
				int x = new Random().nextInt(4) - 2;
				int y = new Random().nextInt(10) + 1;
				int z = new Random().nextInt(4) - 2;
				GVCExplosionBase.ExplosionKai(this, this, this.posX + x, this.posY + y, this.posZ + z, 0, false,  false);
			}
		}else if(this.deathTime <= 170){
			if (this.deathTime % 5 == 0 && !this.world.isRemote) {
				int x = new Random().nextInt(4) - 2;
				int y = new Random().nextInt(10) + 1;
				int z = new Random().nextInt(4) - 2;
				GVCExplosionBase.ExplosionKai(this, this, this.posX + x, this.posY + y, this.posZ + z, 0, false,  false);
			}
		}
		if(!this.world.isRemote && this.deathTime == 200) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 2, false,  false);
			{
				this.world.setBlockState(new BlockPos(this.getMoveX(), this.getMoveY(), this.getMoveZ()), Blocks.CHEST.getDefaultState(), 2);
				TileEntityChest Chest3;
				Chest3 = (TileEntityChest) this.world.getTileEntity(new BlockPos(this.getMoveX(), this.getMoveY(), this.getMoveZ()));
				//Chest3.setInventorySlotContents(13, new ItemStack(mod_GVCR.spawn_pmc_st1, 1, 0));
				
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
    		if(x > 80 && z > 80) {
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
    
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    	{
    		this.rotationYaw = this.rotationYaw + 5;
    		this.rotationYawHead = this.rotationYawHead + 5;
    		this.prevRotationYaw = this.prevRotationYaw + 5;
    		this.renderYawOffset = this.renderYawOffset + 5;
    	}
    	return true;
    }
    
	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
    int self_ex = 0;
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if(this.startuptime < 100)return;
		
		float sp = 0.1F;
		Vec3d looked = this.getLookVec();
		
		boolean exflag = false;
		
		if(this.getMoveT() == 0) {
			this.setMoveT(1);
			this.setMoveX((int)this.posX);
			this.setMoveY((int)this.posY);
			this.setMoveZ((int)this.posZ);
		}
		
		if(this.getHealth() > 0.0F) {
			AI_EntityWeapon.getTargetEntity(this, 60, 20, 20);
			this.newmove(this, 1, sp, 0, 2, 60);
			if(!this.world.isRemote)this.getbeacon();
		}
		
		
		boolean task = AI_EntityWeapon.KnifeAttack(this, 0, 3, 3, 3, 3);
		//this.counter4 = false;
		if(!this.counter4)cooltime4 = 0;
		if(this.getAIType() == 4 || this.getAIType() == 5 || this.getAIType() == 6){
			this.counter4 = false;
			cooltime4 = 0;
			this.cooltime = 0;
			this.counter1 = false;
		}else
		if(task){
			this.counter4 = true;
			this.aitypetime = 0;
			this.cooltime = 0;
			this.counter1 = false;
			if(this.counter4 && (cooltime4 >= 30 && cooltime4 <= 32)){
				double x2 = 0;
				double z2 = 0;
				x2 -= MathHelper.sin(this.rotation * 0.01745329252F) * 2.0;
				z2 += MathHelper.cos(this.rotation * 0.01745329252F) * 2.0;
				AxisAlignedBB axisalignedbb2 = new AxisAlignedBB(
						this.posX - x2, this.posY - 2, this.posZ - z2, 
						this.posX + x2, this.posY + 2, this.posZ + z2)
		        		.grow(1D);
				List<Entity> llist = this.world.getEntitiesWithinAABBExcludingEntity(this,axisalignedbb2);
				if (llist != null) {
					for (int lj = 0; lj < llist.size(); lj++) {
						Entity entity1 = (Entity) llist.get(lj);
						if (entity1.canBeCollidedWith() && entity1 instanceof EntityLivingBase && entity1 != null) {
							if(entity1 != this && entity1 != this.getControllingPassenger()){
								entity1.attackEntityFrom(DamageSource.causeMobDamage(this), 10);
								entity1.motionY = 0.4;
								entity1.motionX = x2;
								entity1.motionZ = z2;
								//System.out.println("task2");
								/*if (entity1 != null)
			                    {
			                        double d1 = entity1.posX - this.posX;
			                        double d0;

			                        for (d0 = entity1.posZ - this.posZ; d1 * d1 + d0 * d0 < 1.0E-4D; d0 = (Math.random() - Math.random()) * 0.01D)
			                        {
			                            d1 = (Math.random() - Math.random()) * 0.01D;
			                        }

			                        this.attackedAtYaw = (float)(MathHelper.atan2(d0, d1) * (180D / Math.PI) - (double)this.rotationYaw);
			                        ((EntityLivingBase) entity1).knockBack(this, 2F, d1, d0);
			                    }*/
							}
						}
					}
				}
			}
			if(cooltime4 > 39){
				this.counter4 = false;
				this.aitypetime = 0;
	            this.setAIType(6);
			}
		}else
		if(this.getAIType() == 1 || this.getAIType() == 3 || this.getAIType() == 7 || this.getAIType() == 8) {
			if(AI_EntityWeapon.getRange(this, 40, 20, 20)){
				{
					String model = "gvclib:textures/entity/BulletNormal.obj";
		    		String tex = "gvclib:textures/entity/BulletNormal.png";
		    		String modelf = "gvclib:textures/entity/mflash.mqo";
		    		String texf = "gvclib:textures/entity/mflash.png";
		        	{
		        		if(this.cooltime > 20)
		    			{
		        			this.counter1 = true;
		        			this.cooltime = 0;
		    			}
		        		if(this.counter1 && this.gun_count1 > 2){
		        			SoundEvent sounds = GVCSoundEvent.fire_rifle3;
		        			AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
							we.id = 0;
							we.model = "gvclib:textures/entity/model/bullet.mqo";
							we.tex = "gvclib:textures/entity/model/bullet.png";
							we.modelf = model;
							we.texf = tex;
							we.ftime = 0;
							we.sound = sounds;
							we.f = -1.57F;
							we.w = -0.7F;
							we.h = 4.05;
							we.z = 0.9;
							we.bx = -0.7F;
							we.by = 4.05;
							we.bz = -0.6;
							we.follow_rote = true;
							we.xoffset = 0;
							we.yoffset = 0;
							we.px = this.posX;
							we.py = this.posY;
							we.pz = this.posZ;
							we.lock = looked;
							we.rote = this.rotationYawHead;
							we.maxy = 20;
							we.miny = 20;
							
							we.power = 5;
							we.speed = 3F;
							we.bure = 4F;
							we.ex = 0;
							we.extrue = false;
							we.kazu = 1;
							we.gra = 0.029;
							we.maxtime = 80;
							we.dameid = 0;
							we.Attacktask(this, this, 40);
		    				this.gun_count1 = 0;
		    				++this.countlimit1;
		    			}
		    			if(this.countlimit1 >= 3){
		    				this.gun_count1 = 0;
		    				this.counter1 = false;
		    				this.countlimit1 = 0;
		    			}
		        	}
				}
			}
		}
		else if(this.getAIType() == 2) {
			if(AI_EntityWeapon.getRange(this, 40, 20, 20)){
				{
					String model = "gvclib:textures/entity/BulletRocket.obj";
		    		String tex = "gvclib:textures/entity/BulletRocket.png";
		    		String modelf = "gvclib:textures/entity/mflash.mqo";
		    		String texf = "gvclib:textures/entity/mflash.png";
		        	{
		        		if(this.cooltime > 25)
		    			{
		        			this.counter1 = true;
		        			this.cooltime = 0;
		    			}
		        		if(this.counter1 && this.gun_count1 > 10){
		        			SoundEvent sounds = GVCSoundEvent.fire_roket;
		        			AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
							we.id = 3;
							we.model = "gvclib:textures/entity/model/bullet.mqo";
							we.tex = "gvclib:textures/entity/model/bullet.png";
							we.modelf = model;
							we.texf = tex;
							we.ftime = 0;
							we.sound = sounds;
							we.f = -1.57F;
							we.w = 0.7F;
							we.h = 3.9;
							we.z = 0.9;
							we.bx = 0.7F;
							we.by = 3.9;
							we.bz = -0.6;
							we.follow_rote = true;
							we.xoffset = 0;
							we.yoffset = 0;
							we.px = this.posX;
							we.py = this.posY;
							we.pz = this.posZ;
							we.lock = looked;
							we.rote = this.rotationYawHead;
							we.maxy = 20;
							we.miny = 20;
							
							we.power = 10;
							we.speed = 2F;
							we.bure = 4F;
							we.ex = 2;
							we.extrue = false;
							we.kazu = 1;
							we.gra = 0.029;
							we.maxtime = 80;
							we.dameid = 0;
							we.Attacktask(this, this, 40);
							this.gun_count1 = 0;
		    				++this.countlimit1;
		    			}
		    			if(this.countlimit1 >= 2){
		    				this.gun_count1 = 0;
		    				this.counter1 = false;
		    				this.countlimit1 = 0;
		    			}
		        	}
				}
			}
		}else {
			this.counter4 = false;
			this.cooltime4 = 0;
			this.cooltime = 0;
			this.counter1 = false;
		}
		
		
		
		int ra = this.world.rand.nextInt(40);
		if (ra == 0) {
			//this.motionY = 1D;
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
									if ((ddx > 25 || ddz > 25)) 
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
	
	public void MoveS(EntityGVCLivingBase entity, double speed, double han, double ex, double ey, double ez, int id, EntityLivingBase en){
		{// 1
			{
				double d5 = ex - entity.posX;
				double d7 = ez - entity.posZ;
				
				double root = Math.sqrt(d5 * d5 + d7 * d7);
				
				float off = 0;
				entity.rotationYaw = entity.renderYawOffset = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
				float yaw = entity.rotationYaw * (2 * (float) Math.PI / 360);
				double mox = entity.motionX;
				double moy = entity.motionY;
				double moz = entity.motionZ;
				{
					if(entity.getAIType() == 4) {
						if(this.aitypetime >= 10 && this.aitypetime < 12) {
							mox -= MathHelper.sin(yaw + 1.57F) * speed * 3;
							moz += MathHelper.cos(yaw + 1.57F) * speed * 3;
						}
						if(this.aitypetime == 10) {
							moy = 0.5;
						}
						if(this.aitypetime > 12 && this.onGround) {
							this.aitypetime = 0;
							this.setAIType(0);
						}
					}
					else if(entity.getAIType() == 5) {
						if(this.aitypetime >= 10 && this.aitypetime < 12) {
							mox -= MathHelper.sin(yaw - 1.57F) * speed * 3;
							moz += MathHelper.cos(yaw - 1.57F) * speed * 3;
						}
						if(this.aitypetime == 10) {
							moy = 0.5;
						}
						if(this.aitypetime > 12 && this.onGround) {
							this.aitypetime = 0;
							this.setAIType(0);
						}
					}
					else if(entity.getAIType() == 6) {
						if(this.aitypetime >= 10 && this.aitypetime < 12) {
							mox -= MathHelper.sin(yaw) * speed * -3;
							moz += MathHelper.cos(yaw) * speed * -3;
						}
						if(this.aitypetime == 10) {
							moy = 0.5;
						}
						if(this.aitypetime > 12 && this.onGround) {
							this.aitypetime = 0;
							this.setAIType(0);
						}
					}
					else if(entity.getAIType() == 3) {
						mox -= MathHelper.sin(yaw) * speed * -1;
						moz += MathHelper.cos(yaw) * speed * -1;
					}
					else if(entity.getAIType() == 1) {
					}
					else if(entity.getAIType() == 2) {
					}
					else{
						mox -= MathHelper.sin(yaw) * speed * 1;
						moz += MathHelper.cos(yaw) * speed * 1;
					}
					
				}
				entity.stepHeight = entity.height * 0.8F;
				if(!counter4){
					if(!entity.world.isRemote){
						entity.motionX = mox;
						entity.motionZ = moz;
						entity.motionY = moy;
						entity.move(MoverType.SELF, entity.motionX, entity.motionY, entity.motionZ);
					}
				}

			}
		} // 1*/
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
package gvcr2.entity.boss;

import java.util.List;
import java.util.Random;

import gvclib.entity.EntityB_Bullet;
import gvclib.entity.EntityT_Grenade;
import gvclib.entity.living.AI_Damage;
import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.AI_EntityWeapon_new;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.ISoldier;
import gvclib.event.GVCSoundEvent;
import gvclib.network.GVCLClientMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.mob.EntityGVCR2_GE_U_DRONE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockLilyPad;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGVCR2_BOSS_CHAR2C extends EntityGVCR2_BOSSBase {
	
	public EntityGVCR2_BOSS_CHAR2C(World worldIn) {
		super(worldIn);
		this.setSize(3F, 5F);
		aitypemax = 80;
		aitypemaxset= 4;
		aitypemax2 = 50;
		aitypemaxset2 = 4;
		this.experienceValue = 300;
	}

	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIRestrictSun(this));
		this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000D);
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
				par2 = par2 * AI_Damage.newAntiBullet(this, entity, par2, 0F, 0.05F, 0.5F, 0.75F);
				if(par2 <= 0.0) {
					this.playSound(DamegeSound, 2F, 1F);
				}
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
				Chest3.setInventorySlotContents(13, new ItemStack(mod_GVCR2.gvcr2_spawn_sp_st1, 1, 0));
				
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
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if(this.startuptime < 100)return;
		
		float sp = 0.01F;
		Vec3d looked = this.getLookVec();
		
		boolean exflag = false;
		
		if(this.getMoveT() == 0) {
			this.setMoveT(1);
			this.setMoveX((int)this.posX);
			this.setMoveY((int)this.posY);
			this.setMoveZ((int)this.posZ);
		}
		
		if(this.getHealth() > 0.0F) {
			AI_EntityWeapon.getTargetEntity(this, 80, 20, 20);
			this.newmove(this, 1, sp, 0, 2, 80);
			//if(!this.world.isRemote)this.getbeacon();
		}
		
		if(this.cooltime3 > 4 && this.getHealth() > 0.0F){
			this.playSound(GVCSoundEvent.fire_mg, 1.0F, 1.0F);
			for(int side = 0 ; side < 2; ++side) {
				String model = "gvclib:textures/entity/BulletNormal.obj";
	    		String tex = "gvclib:textures/entity/BulletNormal.png";
	    		SoundEvent sounds = GVCSoundEvent.fire_mg;
	    		
	    		EntityB_Bullet entitysnowball = new EntityB_Bullet(this.world, this);
	    		//entitysnowball.exsmoke = true;
	    		entitysnowball.gra = 0.029F;
	    		entitysnowball.timemax = 80;
	    		entitysnowball.Bdamege = 5;
	    		entitysnowball.setModel("gvclib:textures/entity/model/bullet.mqo");
				entitysnowball.setTex("gvclib:textures/entity/model/bullet.png");
				
				double xx11 = 0;
				double zz11 = 0;
				xx11 -= MathHelper.sin(rote * 0.01745329252F) * 3.5;
				zz11 += MathHelper.cos(rote * 0.01745329252F) *3.5;
				float kaku = -1;
				if(side == 0)kaku = 1F;
				xx11 -= MathHelper.sin(rote * 0.01745329252F -1.57F) * 1.4 * kaku;
				zz11 += MathHelper.cos(rote * 0.01745329252F -1.57F) * 1.4 * kaku;
				entitysnowball.setLocationAndAngles(this.posX + xx11, this.posY + 2, this.posZ + zz11, this.rotationYaw,
						0);
				int offset = 20;
				if(side == 0)offset = -20;
	            entitysnowball.setHeadingFromThrower(this, 0, this.rotationYaw + offset, 0.0F, 2F, 10F);
	            
	            if(!this.world.isRemote)this.world.spawnEntity(entitysnowball);
	            this.cooltime3 = 0;
			}
		}
		
		
		
		if(AI_EntityWeapon.getRange(this, 80, 30, 30) && this.aitypetime2 > 20 && this.getHealth() > 0.0F){
			{
				String model = "gvclib:textures/entity/BulletNormal.obj";
	    		String tex = "gvclib:textures/entity/BulletNormal.png";
	    		String modelf = "gvclib:textures/entity/mflash.mqo";
	    		String texf = "gvclib:textures/entity/mflash.png";
	    		if(this.getAIType2() == 0){
	        		SoundEvent sounds = GVCSoundEvent.fire_havrycannon;
	        		if(this.cooltime > 40){
	        			AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
						we.id = 3;
						we.model = "gvclib:textures/entity/model/bullet_cannon.mqo";
						we.tex = "gvclib:textures/entity/model/bullet_cannon.png";
						we.modelf = "gvclib:textures/entity/msmoke.mqo";
						we.texf = "gvclib:textures/entity/msmoke.png";
						we.ftime = 16;
						we.sound = sounds;
						we.f = 1.57F;
						we.w = 0;
						we.h = 3.6;
						we.z = 3;
						we.bx = 0;
						we.by = 4.5;
						we.bz = 0.9;
						we.follow_rote = true;
						we.xoffset = 0;
						we.yoffset = -20;
						we.px = this.posX;
						we.py = this.posY;
						we.pz = this.posZ;
						we.lock = looked;
						we.rote = this.rotationYawHead;
						we.maxy = 10;
						we.miny = 10;
						
						we.power = 40;
						we.speed = 2F;
						we.bure = 1F;
						we.ex = 4;
						we.extrue = exflag;
						we.kazu = 1;
						we.gra = 0.020;
						we.maxtime = 80;
						we.dameid = 0;
						we.Attacktask(this, this, 40);
						this.cooltime = 0;
	    			}	
	        	}
	    		
	    		if(this.getAIType2() == 2){
	        		SoundEvent sounds = GVCSoundEvent.fire_30mm;
	        		if(this.cooltime > 6){
	        				AI_EntityWeapon_new we = new AI_EntityWeapon_new(this, this);
							we.id = 2;
							we.model = "gvclib:textures/entity/model/bullet_aaa.mqo";
							we.tex = "gvclib:textures/entity/model/bullet_aaa.png";
							we.modelf = model;
							we.texf = tex;
							we.ftime = 0;
							we.sound = sounds;
							we.f = 0;
							we.w = 0;
							we.h = 3.2;
							we.z = -5.9;
							we.bx = 0;
							we.by = 3.2;
							we.bz = -5.9;
							we.follow_rote = true;
							we.xoffset = 0;
							we.yoffset = 0;
							we.px = this.posX;
							we.py = this.posY;
							we.pz = this.posZ;
							we.lock = looked;
							we.rote = this.rotationYawHead;
							we.maxy = 10;
							we.miny = 10;
							
							we.power = 20;
							we.speed = 3F;
							we.bure = 4F;
							we.ex = 0;
							we.extrue = false;
							we.kazu = 1;
							we.gra = 0.02;
							we.maxtime = 80;
							we.dameid = 0;
							we.Attacktask(this, this, 40);
	        			this.cooltime = 0;
	    		}
	        	}
			}
		}
		
		{
			int kazu = 0;
			double k = this.posX;
			double l = this.posY;
			double i = this.posZ;
			int han = 10;
			int bit = 0;
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double) (k - han), (double) (l - han),
					(double) (i - han), (double) (k + han), (double) (l + han), (double) (i + han)))
							.grow(1);
			List<Entity> llist = this.world.getEntitiesWithinAABBExcludingEntity(this, axisalignedbb);
			if (llist != null) {
				for (int lj = 0; lj < llist.size(); lj++) {
					Entity entity1 = (Entity) llist.get(lj);
					if (entity1.canBeCollidedWith()) {
						if (entity1 instanceof EntityGVCR2_GE_S && entity1 != null) {
							++bit;
						}
					}
				}
			}
			if(bit < 2 +this.world.getDifficulty().getDifficultyId()) {
				if(this.cooltime2 >= 60) {
		        			float yaw = this.rotationYaw * (2 * (float) Math.PI / 360);
							double mox = 0;
							double moy = this.motionY;
							double moz = 0;
							
							int ran = this.world.rand.nextInt(5);
							float kaku = 0;
							int rang = 4;
							if(ran == 0) {
								kaku = 0;
								rang = -4;
							}
							if(ran == 1) {
								kaku = 1.57F;
								rang = -4;
							}
							if(ran == 2) {
								kaku = 1.57F;
								rang = 4;
							}
							
							mox -= MathHelper.sin(yaw - kaku) * rang;
							moz += MathHelper.cos(yaw - kaku) * rang;
							{
								EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(this.world);
					            entityskeleton.setLocationAndAngles(this.posX + mox, this.posY+2, this.posZ + moz, this.rotationYaw, 0.0F);
					            entityskeleton.targetentity = this.targetentity;
					            entityskeleton.setOwnerId(this.entityUniqueID);
					            entityskeleton.setWeapon(true);
					            entityskeleton.setMoveT(1);
					            entityskeleton.setMoveX((int)this.getMoveX());
					            entityskeleton.setMoveY((int)this.getMoveY());
					            entityskeleton.setMoveZ((int)this.getMoveZ());
					            if(!this.world.isRemote) {
					            	this.world.spawnEntity(entityskeleton);
					            }
							}
							this.cooltime2 = 0;
				}
			}else {
				//this.cooltime = 0;
			}
		}
    	
		
		if(!this.world.isRemote){
    		AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
    		double xx = width;
        		for(double x = 0; x < width*2; ++x) {
        			for(double y = 1; y < height*1.2; ++y) {
        				for(double z = 0; z < width*2; ++z) {
        					BlockPos pos = new BlockPos(this.posX -xx + x, this.posY + y, this.posZ - xx + z);
        					if(!(this.world.getBlockState(pos).getBlock() instanceof BlockStone)
        							&& !(this.world.getBlockState(pos).getBlock() instanceof BlockGrass)
        							&& !(this.world.getBlockState(pos).getBlock() instanceof BlockDirt)
        							&& !(this.world.getBlockState(pos).getBlock() instanceof BlockSand)
        							&& !(this.world.getBlockState(pos).getBlock() instanceof BlockAir)
        							&& !(this.world.getBlockState(pos).getBlock() instanceof BlockContainer)
        							/*this.world.getBlockState(pos).getBlock() instanceof BlockOldLog
        						|| this.world.getBlockState(pos).getBlock() instanceof BlockOldLeaf	
        						|| this.world.getBlockState(pos).getBlock() instanceof BlockPane	
        						|| this.world.getBlockState(pos).getBlock() instanceof BlockLog
        						|| this.world.getBlockState(pos).getBlock() instanceof BlockNewLeaf	
        						|| this.world.getBlockState(pos).getBlock() instanceof BlockPlanks	
        						|| this.world.getBlockState(pos).getBlock() instanceof BlockLilyPad	
        						|| this.world.getBlockState(pos).getBlock() instanceof BlockCactus	
        						|| this.world.getBlockState(pos).getBlock() instanceof BlockSandStone	
        						|| this.world.getBlockState(pos).getBlock() instanceof BlockCactus	*/
        						//|| this.world.getBlockState(pos).getBlock() instanceof BlockGrass	
        							) 
        					{
        						IBlockState iblockstate = this.world.getBlockState(pos);
        		                Block block = iblockstate.getBlock();
        		                if (iblockstate.getMaterial() != Material.AIR)
        		                {
        		                    block.dropBlockAsItemWithChance(this.world, pos, this.world.getBlockState(pos), 1.0F, 0);
        		                    world.setBlockToAir(pos);
        		                }
        					}
        				}
        			}
        		}
    	}
		
	}
	
	
	public void newmove(EntityGVCLivingBase entity, int id, float sp, float turnspeed, double max, double range1) {
		entity.sneak = false;
		boolean ta = false;
		double range = range1;
		
		{
			double d5 = entity.getMoveX() - entity.posX;
			double d7 = entity.getMoveZ() - entity.posZ;
			double d6 = entity.getMoveY() - entity.posY;
			double d1 = entity.posY - (entity.getMoveY());
			double d3 = (double) MathHelper.sqrt(d5 * d5 + d7 * d7);
			float f11 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
			{
				entity.rotationYaw = entity.renderYawOffset = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
				double ddx = Math.abs(d5);
				double ddz = Math.abs(d7);
				if ((ddx > 10 || ddz > 10)) 
				{
					MoveS(entity, sp, 1, entity.getMoveX(), entity.getMoveY(), entity.getMoveZ(), id);
				}
			}
		}
		
		
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
									entity.rotationYawHead = entity.rotation = entity.rote
											= -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
									entity.rotationp = entity.rotationPitch = -f11 + 15;
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
	}
	
	public void MoveS(EntityGVCLivingBase entity, double speed, double han, double ex, double ey, double ez, int id){
		{// 1
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
				//if(entity.aitypetime %15 ==  0 && entity.getAIType2() != 0)
				{
					 if(entity.getAIType() == 0) 
					{
						mox -= MathHelper.sin(yaw) * speed * 1;
						moz += MathHelper.cos(yaw) * speed * 1;
					}
					
				}
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
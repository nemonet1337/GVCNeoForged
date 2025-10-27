package gvcr2.entity.vehicle.car;

import javax.annotation.Nullable;

import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.EntityMobVehicleBase;
import gvclib.event.GVCSoundEvent;
import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.vehicle.VehicleBase;
import gvcr2.event.level.GVCR2WorldDifficultyLevel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldProviderSurface;

public class EntityGVCR2_CAR_BULLDOZER extends EntityMobVehicleBase
{
    public EntityGVCR2_CAR_BULLDOZER(World worldIn)
    {
        super(worldIn);
        this.setSize(3.5F, 2.6F);
        this.render_hud_icon = false;
        this.hud_icon = "gvclib:textures/hud/tank.png";
        this.render_hud_scope = false;
        this.hud_icon_scope = "gvcr2:textures/misc/scope_tank_t34.png";
        
        //this.render_hud_information_6 = "X-KEY:WeaponChange";

        
        this.difficulty_adjustment = mod_GVCR2.cfg_damage_relief_vehicle;
        
        this.spawn_item = mod_GVCR2.gvcr2_spawn_car_armor_bulldozer;
        
        this.sp = 0.04F;
        this.turnspeed = 1.5F;
        this.rotationp_max = -30F;
        this.rotationp_min = 10F;
		this.ridding_invisible = false;
		this.riddng_opentop = false;
		this.render_rader = false;
        this.thmax = 5F;
		this.thmin = -2F;
		this.thmaxa = 0.2F;
		this.thmina = -0.15F;
		this.stepHeight = 1.5F;
		riddingx[0] = 0;
		riddingy[0] = 1.25;
		riddingz[0] = -0.7;
		ridding_roteplayer = false;
		
		//this.ridding_view1_x = -0.6F;
		//this.ridding_view1_y = 0.6F;
		//this.ridding_view1_z = 1.5F;
		
		antibullet_0 = 0.0F;
		antibullet_1 = 0.5F;
		antibullet_2 = 1.0F;
		antibullet_3 = 1.0F;
		this.ridding_damege = 0.25F;
		
		this.roodbreak = mod_GVCR2.cfg_movebreak;
		
		{
			cloud = 2;
			cloud_x[0] = 0.5D;
			cloud_x[1] = -0.5D;
			cloud_y[0] = cloud_y[1] = 1D;
			cloud_z[0] = cloud_z[1] = -3.2D;
		}
		
		mob_min_range = 20;
		mob_max_range = 60;
		
		
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100D);//160
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20D);
    }
    
    public boolean attackEntityFrom(DamageSource source, float par2)
    {
		//MoveT == 1用　ダメージを受けた時にノックバックでブロックを置かないように
    	if(this.getMoveT() == 1 && this.w5barst < 100)
		{
			this.w5barst = 0;
		}
		return super.attackEntityFrom(source, par2);
    }
    
    public boolean spawn = false;
    public void onUpdate() {
		super.onUpdate();
		this.roadattack();
		VehicleBase.roadattack_barbed(this);
		this.typeTank();
		if (this.canBeSteered() && this.getControllingPassenger() != null && this.getHealth() > 0.0F)
		{
			 if(this.getControllingPassenger() instanceof EntityGVCLivingBase && !this.getVehicleLock()) {
				 EntityGVCLivingBase ridding = (EntityGVCLivingBase) this.getControllingPassenger();
				 if(ridding.getMoveT() == 1){
					 this.sp = 0.04F;
						if(this.w5barst < 100) {
							++this.w5barst;
						}
						if(this.w5barst < 60) {
							//this.throttle = 0;
						}
						Vec3d lock = Vec3d.fromPitchYaw(this.rotationPitch, this.rotationYaw);//entity.getForward();
						{
							boolean yflag = false;
							int y_range = 3;
							double z_range = 2.0D;
							for(int yhi = 1; yhi <= y_range; ++yhi) {
								BlockPos pos0 = new BlockPos(this.posX +  lock.x * z_range, this.posY - yhi,this.posZ + lock.z * z_range);
								if (getBlock(this.world.getBlockState(pos0).getBlock())){
									yflag = true;
									break;
								}
							}
							if(yflag){
								this.swingArm(EnumHand.MAIN_HAND);
								if(this.w5barst > 60){
									this.w5barst = 0;
									/*if(this.getMoveY() - 2 > this.posY ) {
										for(int xx =0; xx < 3; ++xx) {
											for(int zz =0; zz < 3; ++zz) {
												setBlock(this.world, new BlockPos(this.posX +  lock.x * z_range + xx - 1, this.posY + 0,this.posZ + lock.z * z_range + zz - 1), mod_GVCR2.gvcr2_block_scaffold);
											}
										}
									}else if(this.getMoveY() + 2 < this.posY ) {
										for(int xx =0; xx < 3; ++xx) {
											for(int zz =0; zz < 3; ++zz) {
												setBlock(this.world, new BlockPos(this.posX +  lock.x * z_range + xx - 1, this.posY - 2,this.posZ + lock.z * z_range + zz - 1), mod_GVCR2.gvcr2_block_scaffold);
											}
										}
									}else */
									{
										for(int xx =0; xx < 3; ++xx) {
											for(int zz =0; zz < 3; ++zz) {
												setBlock(this.world, new BlockPos(this.posX +  lock.x * z_range + xx - 1, this.posY - 1,this.posZ + lock.z * z_range + zz - 1), mod_GVCR2.gvcr2_block_scaffold);
											}
										}
									}
								}
							}
							
						}
					}
			 }
		}
		
    }

    public static void setBlock(World world, BlockPos pos, Block block) {
		/*if(world.getBlockState(pos).getBlock() != Blocks.BEDROCK
				&& world.getBlockState(pos).getBlock() != Blocks.OBSIDIAN) {
			world.setBlockState(pos, block.getDefaultState(), 2);
		}*/
		if(world.getBlockState(pos).getBlock() == Blocks.AIR) {
			world.setBlockState(pos, block.getDefaultState(), 2);
		}
	}
    
    public static boolean getBlock(Block block) {
		boolean flag = false;
		if(block == Blocks.WATER
				|| block == Blocks.FLOWING_WATER
				|| block == Blocks.LAVA
				|| block == Blocks.FLOWING_LAVA
				|| block == Blocks.AIR) {
			flag = true;
		}
		return flag;
		
	}
	public static boolean getBlockfalse(Block block) {
		boolean flag = false;
		if(block != Blocks.WATER
				&& block != Blocks.FLOWING_WATER
				&& block != Blocks.LAVA
				&& block != Blocks.FLOWING_LAVA
				&& block != Blocks.AIR) {
			flag = true;
		}
		return flag;
		
	}
    
    
    protected void onDeathUpdate() {
		++this.deathTicks;
		int x = this.world.rand.nextInt(4);
		int y = this.world.rand.nextInt(5);
		int z = this.world.rand.nextInt(4);
		if(this.getControllingPassenger() instanceof EntityLivingBase) {
			EntityLivingBase entity = (EntityLivingBase) this.getControllingPassenger();
			this.getControllingPassenger().dismountRidingEntity();
		}
		if (this.deathTicks == 1 && !this.world.isRemote) {
			GVCExplosionBase.ExplosionKai(this, this, this.posX + 0, this.posY + 0, this.posZ + 0, 2, false,  false);
		}
		if (this.deathTicks == 200 && !this.world.isRemote) {
			this.setDead();
		}
	}
   
   public boolean getCanSpawnHere() {
		return this.getLevel() >= 4 && this.getCanSpawnUnderGround() && this.getCanSpawnDimension() && super.getCanSpawnHere();
	}
   
   public boolean getCanSpawnDimension()
   {
	   boolean flag = false;
	   if (world.provider instanceof WorldProviderSurface) {
		   flag = true;
	   }
	   else if (world.provider instanceof WorldProviderHell) {
		   flag = mod_GVCR2.cfg_canspawn_hell;
	   }
	   else if (world.provider instanceof WorldProviderEnd) {
		   flag = mod_GVCR2.cfg_canspawn_sky;
	   }else {
		   flag = mod_GVCR2.cfg_canspawn_anotherworld;
	   }
	   return flag;
   }
   
   public boolean getCanSpawnUnderGround()
   {
	   boolean flag = false;
	   BlockPos bp = world.getHeight(new BlockPos(this.posX, this.posY, this.posZ));
	   int genY = bp.getY();
	   if(this.posY >= genY) {
		   flag = true;
	   }
	   if(mod_GVCR2.cfg_canspawn_underground) {
		   flag = true;
	   }
	   return flag;
   }
   
   public int getLevel() {
 	  /* if(mod_GVCR2.cfg_spawn_original) {
 		   return 10;
 	   }else */
 	   {
 		   return GVCR2WorldDifficultyLevel.getLevel(mod_GVCR2.INSTANCE, this.world);
 	   }
    }
  
   /**
    * Drop the equipment for this entity.
    */
   protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier)
   {
   	DamageSource source = this.getLastDamageSource();
   	int rand = 0;
   	if(this.getMoveT() == 1) {
   		 rand = this.world.rand.nextInt(3);
   	}else if(this.getcanDespawn() >= 1) {
   		rand = 1;
   	}else {
   		 rand = 0;
   	}
   	if(rand == 0) {
   		int ran = this.world.rand.nextInt(3);
   		if(ran == 0){
				int ra = this.world.rand.nextInt(12) + 3;
				for(int x = 0; x < ra; ++x) {
					this.entityDropItem(new ItemStack(Items.IRON_INGOT), 0.0F);
				}
			}else {
				int ra = this.world.rand.nextInt(20) + 3;
				for(int x = 0; x < ra; ++x) {
					this.entityDropItem(new ItemStack(mod_GVCR2.gvcr2_item_scrap), 0.0F);
				}
			}
   	}
   }
   
   @Nullable
   public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
   {
       livingdata = super.onInitialSpawn(difficulty, livingdata);
      // if(!this.world.isRemote)
       {
       	EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(this.world);
	        entityskeleton.setLocationAndAngles(this.posX+0.5, this.posY, this.posZ+0.5, 0, 0.0F);
	        entityskeleton.onInitialSpawn(difficulty, (IEntityLivingData)null);
	        this.world.spawnEntity(entityskeleton);
	        entityskeleton.startRiding(this);
       }
       return livingdata;
   }
}
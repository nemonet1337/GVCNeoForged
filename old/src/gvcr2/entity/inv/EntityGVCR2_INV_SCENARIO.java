package gvcr2.entity.inv;

import gvclib.entity.living.AI_EntityWeapon;
import gvclib.entity.living.EntityGVCLivingBase;
import gvclib.entity.living.ISoldier;
import gvcr2.mod_GVCR2;
import gvcr2.entity.boss.EntityGVCR2_BOSSBase_Base;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGVCR2_INV_SCENARIO extends EntityGVCR2_BOSSBase_Base// implements IMob
{
	
	//public int spawn_time = 2400;
	//public int timer = 0;
	
	
    public EntityGVCR2_INV_SCENARIO(World worldIn)
    {
        super(worldIn);
        this.setSize(1F, 1F);
		aitypemax = 80;
		aitypemaxset= 4;
		aitypemax2 = 50;
		aitypemaxset2 = 4;
		this.experienceValue = 300;
    }
    
    public boolean CanAttack(Entity entity){
    	{
    		return false;
    	}
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
		return false;
    }
	
	public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
		INV_SCENARIO scenario = new INV_SCENARIO();
		ItemStack itemstack = player.getHeldItem(hand);
		if(!itemstack.isEmpty() && itemstack.getItem() == mod_GVCR2.gvcr2_item_wrench)
        {
			if(player.isSneaking()) {
				if(this.getArmID_R() == 2400){
					this.setArmID_R(3000);
					scenario.sendmessage(world, this.posX, this.posY, this.posZ, 80, "Time : 2m30s", true);
				}else if(this.getArmID_R() == 3000){
					this.setArmID_R(3600);
					scenario.sendmessage(world, this.posX, this.posY, this.posZ, 80, "Time : 3m0s", true);
				}else if(this.getArmID_R() == 3600){
					this.setArmID_R(4200);
					scenario.sendmessage(world, this.posX, this.posY, this.posZ, 80, "Time : 3m30s", true);
				}else if(this.getArmID_R() == 4200){
					this.setArmID_R(4800);
					scenario.sendmessage(world, this.posX, this.posY, this.posZ, 80, "Time : 4m0s", true);
				}else if(this.getArmID_R() == 4800){
					this.setArmID_R(5400);
					scenario.sendmessage(world, this.posX, this.posY, this.posZ, 80, "Time : 4m30s", true);
				}else if(this.getArmID_R() == 5400){
					this.setArmID_R(6000);
					scenario.sendmessage(world, this.posX, this.posY, this.posZ, 80, "Time : 5m0s", true);
				}else if(this.getArmID_R() == 6000){
					this.setArmID_R(1200);
					scenario.sendmessage(world, this.posX, this.posY, this.posZ, 80, "Time : 1m0s", true);
				}else if(this.getArmID_R() == 1200){
					this.setArmID_R(1800);
					scenario.sendmessage(world, this.posX, this.posY, this.posZ, 80, "Time : 1m30s", true);
				}else {
					this.setArmID_R(2400);
					scenario.sendmessage(world, this.posX, this.posY, this.posZ, 80, "Time : 2m0s", true);
				}
			}else {
				if(this.getArmID_S() != 30 && this.getArmID_S() != 31 && this.getArmID_S() != 32 && this.getArmID_S() != 33){
					if(this.getArmID_L() == 0){
						this.setArmID_L(10);
						scenario.sendmessage(world, this.posX, this.posY, this.posZ, 80, "Range : 90", true);
					}else if(this.getArmID_L() == 10){
						this.setArmID_L(20);
						scenario.sendmessage(world, this.posX, this.posY, this.posZ, 80, "Range : 100", true);
					}else if(this.getArmID_L() == 20){
						this.setArmID_L(30);
						scenario.sendmessage(world, this.posX, this.posY, this.posZ, 80, "Range : 110", true);
					}else {
						this.setArmID_L(0);
						scenario.sendmessage(world, this.posX, this.posY, this.posZ, 80, "Range : 80", true);
					}
				}else {
					scenario.sendmessage(world, this.posX, this.posY, this.posZ, 80, "Range : 110Only", true);
				}
				
			}
        }else if(!itemstack.isEmpty() && itemstack.getItem() == mod_GVCR2.gvcr2_item_weapon_change)
        {
        	if (!this.world.isRemote) {
				this.setDead();
			}
        }
		else {
        	if(this.getHealth() > 200) {
				if (!this.world.isRemote)this.setHealth(this.getHealth() - 200);
			}else {
				if (!this.world.isRemote)this.setHealth(1);
			}
        }
		
		 return true;
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
        
        
        if(this.getHealth() > 0.0F &&this.getMoveT() == 1) {
			if(!this.world.isRemote)this.setPositionAndUpdate(this.getMoveX()+0.5D, this.getMoveY(), this.getMoveZ()+0.5D);
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
    
	public void onLivingUpdate() {
		super.onLivingUpdate();
		//if(this.timer < 100)return;
		if(this.getMoveT() == 0) {
			this.setMoveT(1);
			this.setMoveX((int)(this.posX));
			this.setMoveY((int)this.posY);
			this.setMoveZ((int)(this.posZ));
		}
		//++timer;
		
		INV_SCENARIO scenario = new INV_SCENARIO();
		scenario.scenario(this);
	}
    
}
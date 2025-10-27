package gvcr2.entity.npc;

import gvclib.entity.trader.EntityNPCBase;
import gvcr2.mod_GVCR2;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class EntityGVCR2_NPC_ARMSTRADER extends EntityNPCBase {

	public EntityGVCR2_NPC_ARMSTRADER(World worldIn) {
		super(worldIn);
		this.setSize(0.5F, 1.8F);
		this.biped = true;
		{
			this.sell_page = 3;
			{
				//sell = //売り物
				//sell_id = //売り物
				//sell_size = //売り物の量
				//sellm = //販売価格
				this.setCustomNameTag("ArmsTrader");
				this.sell[0] = mod_GVCR2.gvcr2_gun_m82a3;
				this.sell[1] = mod_GVCR2.gvcr2_gun_m134;
				this.sell[2] = mod_GVCR2.gvcr2_gun_mg42;
				this.sell_size[0] = 1;
				this.sell_size[1] = 1;
				this.sell_size[2] = 1;
				this.sellm[0] = 32;
				this.sellm[1] = 32;
				this.sellm[2] = 32;
				
				this.sell[3] = mod_GVCR2.gvcr2_gun_xm25;
				this.sell[4] = mod_GVCR2.gvcr2_gun_mgl140;
				this.sell_size[3] = 1;
				this.sell_size[4] = 1;
				this.sellm[3] = 32;
				this.sellm[4] = 32;
				
				
				
			}
			
			
		}
		
		this.buy_page = 1;
		{
			this.buy[0] = mod_GVCR2.gvcr2_gun_ak47;
			this.buy_size[0] = 2;
			this.buym[0] = 1;
			
			this.buy[1] = mod_GVCR2.gvcr2_gun_sks;
			this.buy_size[1] = 2;
			this.buym[1] = 1;
			
			this.buy[2] = mod_GVCR2.gvcr2_gun_ak74;
			this.buy_size[2] = 4;
			this.buym[2] = 1;
			
			this.buy[3] = mod_GVCR2.gvcr2_gun_uzi;
			this.buy_size[3] = 2;
			this.buym[3] = 1;
			
			this.buy[4] = mod_GVCR2.gvcr2_gun_rpg7;
			this.buy_size[4] = 4;
			this.buym[4] = 1;
			
			this.buy[5] = mod_GVCR2.gvcr2_gun_svd;
			this.buy_size[5] = 4;
			this.buym[5] = 1;
			
		}
		
	}

	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAILookIdle(this));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20D);
	}

	public double getYOffset()
    {
        return 0.1D;
    }
	
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
		/*if(player != null) {
			if(this.getArmID_A() == 1) {
				if(this.world.isRemote)player.sendMessage(new TextComponentTranslation("hmggirlfront.helianthus.serif_0.name", new Object[0]));
			}else if(this.getArmID_A() == 0){
				int ra = this.world.rand.nextInt(5);
				if(ra == 1) {
					if(this.world.isRemote)player.sendMessage(new TextComponentTranslation("hmggirlfront.kalina.serif_1.name", new Object[0]));
				}
				else if(ra == 2) {
					if(this.world.isRemote)player.sendMessage(new TextComponentTranslation("hmggirlfront.kalina.serif_2.name", new Object[0]));
				}
				else if(ra == 3) {
					if(this.world.isRemote)player.sendMessage(new TextComponentTranslation("hmggirlfront.kalina.serif_3.name", new Object[0]));
				}
				else if(ra == 4) {
					if(this.world.isRemote)player.sendMessage(new TextComponentTranslation("hmggirlfront.kalina.serif_4.name", new Object[0]));
				}else{
					if(this.world.isRemote)player.sendMessage(new TextComponentTranslation("hmggirlfront.kalina.serif_0.name", new Object[0]));
				}
			}
		}*/
		super.processInteract(player, hand);
		return true;
    }
	
	public void onLivingUpdate() {
		super.onLivingUpdate();
		
	}
	
	
}
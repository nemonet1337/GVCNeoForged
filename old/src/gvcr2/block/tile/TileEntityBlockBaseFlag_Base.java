package gvcr2.block.tile;
 
import java.util.List;

import gvclib.entity.living.ISoldier;
import gvcr2.entity.boss.EntityGVCR2_BOSSBase_Base;
import gvcr2.entity.mob.EntityGVCR2_GEBase;
import gvcr2.entity.so.EntityGVCR2_SO_S;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_AH1S;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_AH6;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_M60A1;
import gvcr2.network.GVCR2ClientMessageKeyPressed;
import gvcr2.network.GVCR2ClientMessageKeyPressedHandler;
import gvcr2.network.GVCR2PacketHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
 
public class TileEntityBlockBaseFlag_Base extends TileEntity implements ITickable
{
	public int count = 0;
	public int invcount = 0;
	public int lastinvcount = 0;
	
	public int invmaxcount = 200;
	
	public boolean enemyblock = false;
	
	public Block invclearblock = Blocks.AIR;
	
	public String inv_tex = "inv_m.png";
	public String inv_tex_em = "inv_m.png";
	
	public String inv_name = "";
	
	public int player_count = 0;
	public int mob_count = 0;
	
	public boolean base_boss = false;
	
	public boolean enemy = false;
	
	public boolean spawn_tank = false;
	public boolean spawn_heli = false;
	
	public boolean spawn_inv_timing = true;
	
	
	public int flag_range = 20;
	
	//21/5/16
	/**旗の下側のモブも判定するか*/
	public boolean can_under_mob = true;
    
	@SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared()
    {
        return 65536.0D;
    }
	
	@SideOnly(Side.CLIENT)
    public static int getClientInvCount(TileEntityBlockBaseFlag_Base inv)
    {
        return inv.invcount;
    }
	@SideOnly(Side.CLIENT)
    public static int getClientInvMaxCount(TileEntityBlockBaseFlag_Base inv)
    {
        return inv.invmaxcount;
    }
	@SideOnly(Side.CLIENT)
    public static int getClientPlayerCount(TileEntityBlockBaseFlag_Base inv)
    {
        return inv.player_count;
    }
	@SideOnly(Side.CLIENT)
    public static int getClientMobCount(TileEntityBlockBaseFlag_Base inv)
    {
        return inv.mob_count;
    }
	
    @Override
	public void update() {
    	if(FMLCommonHandler.instance().getMinecraftServerInstance() != null) {
			for (EntityPlayerMP player : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers())
            {
				GVCR2PacketHandler.INSTANCE2.sendTo(new GVCR2ClientMessageKeyPressed(100, invcount,
						this.getPos().getX(), this.getPos().getY(), this.getPos().getZ()), player);
		    	GVCR2PacketHandler.INSTANCE2.sendTo(new GVCR2ClientMessageKeyPressed(101, invmaxcount,
						this.getPos().getX(), this.getPos().getY(), this.getPos().getZ()), player);
		    	GVCR2PacketHandler.INSTANCE2.sendTo(new GVCR2ClientMessageKeyPressed(102, player_count,
						this.getPos().getX(), this.getPos().getY(), this.getPos().getZ()), player);
		    	GVCR2PacketHandler.INSTANCE2.sendTo(new GVCR2ClientMessageKeyPressed(103, mob_count,
						this.getPos().getX(), this.getPos().getY(), this.getPos().getZ()), player);
            }
    	}
    	
    	
    	Block block = this.world.getBlockState(this.pos).getBlock();
        Entity entity = null;
        int k = this.pos.getX();
        int l = this.pos.getY();
        int i1 = this.pos.getZ();
        int x = this.pos.getX();
        int y= this.pos.getY();
        int z = this.pos.getZ();
        
        lastinvcount = invcount;
        
        /*++count;
        if(count > 1000) {
			if (this.canspawn(x, y, z, 20, 20) && !this.world.isRemote) {
			}
			count = 0;
        }*/
        if(enemyblock) {
        	this.getInvCount(x, y, z, flag_range);
        }else {
        	this.getInvCountPlayer(x, y, z, flag_range);
        }
        
        if(invcount >= invmaxcount) {
        	if(this.enemyblock) {
        		//this.sendmessage(x, y, z, 20, "Retrieve base!", true);
        		this.sendmessage(x, y, z, 20, "gvcr2.base.retrieve.name", true);
        		this.Invation(pos);
        	}else {
        		//this.sendmessage(x, y, z, 20, "The base was taken!", false);
        		this.sendmessage(x, y, z, 20, "gvcr2.base.invation.name", false);
        		
        	}
        	if(!this.world.isRemote){
            	//this.world.setBlockToAir(pos);
        		if(enemyblock) {
        			if(spawn_inv_timing){
        				int i = this.world.rand.nextInt(5) + 1;
        		        for(int ii = 0; ii < i; ++ii){
        		        	int ix = this.world.rand.nextInt(10);
        					int iz = this.world.rand.nextInt(10);
        					BlockPos spawnpos = new BlockPos(x - 5 + ix, y + 1, z - 5 + iz);
        					BlockPos spawnpos2 = new BlockPos(x - 5 + ix, y + 2, z - 5 + iz);
        					if(this.world.getBlockState(spawnpos).getBlock() == Blocks.AIR
        							&& this.world.getBlockState(spawnpos2).getBlock() == Blocks.AIR) {
        						EntityGVCR2_SO_S entityskeleton = new EntityGVCR2_SO_S(this.world);
            		        	entityskeleton.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
            		        	entityskeleton.setWeapon_base();
            			        this.world.spawnEntity(entityskeleton);
        					}
        		        }
        		        if(spawn_heli) {
        		        	BlockPos spawnpos = new BlockPos(x, y + 2, z);
        					{
        						EntityGVCR2_HELI_AH1S entityskeleton = new EntityGVCR2_HELI_AH1S(this.world);
        						entityskeleton.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
            			        this.world.spawnEntity(entityskeleton);
            			        {
            			        	EntityGVCR2_SO_S entityskeleton2 = new EntityGVCR2_SO_S(this.world);
              				       entityskeleton2.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
              				       this.world.spawnEntity(entityskeleton2);
              				     entityskeleton2.startRiding(entityskeleton);
            			        }
        					}
        		        }
        		        if(spawn_tank) {
        		        	BlockPos spawnpos = new BlockPos(x, y + 2, z);
        					{
        						EntityGVCR2_TANK_M60A1 entityskeleton = new EntityGVCR2_TANK_M60A1(this.world);
        						entityskeleton.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
            			        this.world.spawnEntity(entityskeleton);
            			        {
            			        	EntityGVCR2_SO_S entityskeleton2 = new EntityGVCR2_SO_S(this.world);
              				       entityskeleton2.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
              				       this.world.spawnEntity(entityskeleton2);
              				     entityskeleton2.startRiding(entityskeleton);
            			        }
        					}
        		        }
        			}
        			this.world.playSound((EntityPlayer)null, x, y, z,
        					SoundEvents.BLOCK_ANVIL_FALL, SoundCategory.NEUTRAL, 5.0F, 1.0F);
        		}else {
        			this.world.playSound((EntityPlayer)null, x, y, z,
        					SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.NEUTRAL, 5.0F, 1.0F);
        		}
        		
        		this.world.setBlockState(pos, invclearblock.getDefaultState(), 2);
        		
            }
        }
        
	}
    
    
    protected void Invation(BlockPos pos) {
    	
    }
    
    public void getInvCount(double x, double y, double z, int han) {
    	Entity entity = null;
    	int playercount = 0;
    	int mobcount = 0;
    	{
    		int under = han;
    		if(!can_under_mob) {
    			under = 0;
    		}
    		AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(x-under), (double)(y-han), (double)(z-han), 
    				(double)(x + han), (double)(y + han), (double)(z+ han)))
            		.grow(1);
            List llist2 = this.world.getEntitiesWithinAABBExcludingEntity(entity, axisalignedbb2);
            if(llist2!=null){
                for (int lj = 0; lj < llist2.size(); lj++) {
                	
                	Entity entity1 = (Entity)llist2.get(lj);
                	boolean yy = true;
                	if(!can_under_mob) {
                		if(entity1.posY > y) {
                			yy = false;
                		}
                	}
                	if (entity1.canBeCollidedWith() && entity1 != null && yy)
                    {
                		if (entity1 instanceof EntityPlayer) {
                			EntityPlayer ss = (EntityPlayer) entity1;
                			ItemStack itemstack = ss.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
                    		if(!itemstack.isEmpty() && itemstack.getItem() == Items.GOLDEN_HELMET){
                    		}else {
                    			++playercount;
                    		}
    					}
                		if (entity1 instanceof ISoldier) {
    						++playercount;
    					}
                		/*if (entity1 instanceof EntityDoll) {
    						++playercount;
    					}*/
                		if (entity1 instanceof IMob && entity1 instanceof EntityGVCR2_GEBase) {
    						++mobcount;
    					}
                    }
                }
            }
    	}
    	if(playercount > mobcount) {
    		//invcount = invcount + 2;
    		++invcount;
    	}else if(playercount == mobcount){
    		
    	}else if(invcount > 0){
    		--invcount;
    	}
    	this.player_count = playercount;
    	this.mob_count = mobcount;
    }
    
    public void getInvCountPlayer(double x, double y, double z, int han) {
    	Entity entity = null;
    	int playercount = 0;
    	int mobcount = 0;
    	{
    		int under = han;
    		if(!can_under_mob) {
    			under = 0;
    		}
    		AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(x-under), (double)(y-han), (double)(z-han), 
    				(double)(x + han), (double)(y + han), (double)(z+ han)))
            		.grow(1);
            List llist2 = this.world.getEntitiesWithinAABBExcludingEntity(entity, axisalignedbb2);
            if(llist2!=null){
                for (int lj = 0; lj < llist2.size(); lj++) {
                	
                	Entity entity1 = (Entity)llist2.get(lj);
                	boolean yy = true;
                	if(!can_under_mob) {
                		if(entity1.posY > y) {
                			yy = false;
                		}
                	}
                	if (entity1.canBeCollidedWith() && entity1 != null && yy)
                    {
                		/*if (entity1 instanceof EntityPlayer || entity1 instanceof EntityDoll) {
    						++playercount;
    					}*/
                		if (entity1 instanceof EntityPlayer) {
    						++playercount;
    					}
                		if (entity1 instanceof ISoldier) {
    						++playercount;
    					}
                		if (entity1 instanceof IMob && entity1 instanceof EntityGVCR2_GEBase) {
    						++mobcount;
    					}
                    }
                }
            }
    	}
    	if(mobcount > playercount) {
    		//invcount = invcount + 2;
    		++invcount;
    	}else if(playercount == mobcount){
    		
    	}else if(invcount > 0){
    		--invcount;
    	}
    	this.player_count = playercount;
    	this.mob_count = mobcount;
    }
    
        public boolean canspawn(double x, double y, double z, int han) {
        	boolean spawn = false;
        	Entity entity = null;
        	int mobkazu = 0;
        	int mobkazu2 = 0;
        	{
        		AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(x-han), (double)(y-han), (double)(z-han), (double)(x + han), (double)(y + han), (double)(z+ han)))
                		.grow(1);
                List llist2 = this.world.getEntitiesWithinAABBExcludingEntity(entity, axisalignedbb2);
                if(llist2!=null){
                    for (int lj = 0; lj < llist2.size(); lj++) {
                    	
                    	Entity entity1 = (Entity)llist2.get(lj);
                    	if (entity1.canBeCollidedWith())
                        {
                    		if (entity1 instanceof EntityLivingBase && entity1 != null) {
        						++mobkazu;
        						if (entity1 instanceof IMob) {
        							++mobkazu2;
        						}
        					}
                        }
                    }
                }
        	}
        	if(mobkazu <= 10 && mobkazu2 <= 4) {
        		spawn = true;
        	}
        	return spawn;
        }
        public boolean canspawnAlly(double x, double y, double z, int han) {
        	boolean spawn = false;
        	Entity entity = null;
        	int mobkazu = 0;
        	int mobkazu2 = 0;
        	{
        		AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(x-han), (double)(y-han), (double)(z-han), (double)(x + han), (double)(y + han), (double)(z+ han)))
                		.grow(1);
                List llist2 = this.world.getEntitiesWithinAABBExcludingEntity(entity, axisalignedbb2);
                if(llist2!=null){
                    for (int lj = 0; lj < llist2.size(); lj++) {
                    	
                    	Entity entity1 = (Entity)llist2.get(lj);
                    	if (entity1.canBeCollidedWith())
                        {
                    		if (entity1 instanceof EntityLivingBase && entity1 != null) {
        						++mobkazu;
        						if (entity1 instanceof ISoldier) {
        							++mobkazu2;
        						}
        					}
                        }
                    }
                }
        	}
        	if(mobkazu <= 10 && mobkazu2 <= 4) {
        		spawn = true;
        	}
        	if(!spawn_inv_timing){
        		{
        			int han2 = 80;
            		AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(x-han2), (double)(y-han2), (double)(z-han2), (double)(x + han2), (double)(y + han2), (double)(z+ han2)))
                    		.grow(1);
                    List llist2 = this.world.getEntitiesWithinAABBExcludingEntity(entity, axisalignedbb2);
                    if(llist2!=null){
                        for (int lj = 0; lj < llist2.size(); lj++) {
                        	
                        	Entity entity1 = (Entity)llist2.get(lj);
                        	if (entity1.canBeCollidedWith())
                            {
                        		if (entity1 != null && entity1 instanceof EntityGVCR2_BOSSBase_Base) {
                        			spawn = false;
            						break;
            					}
                            }
                        }
                    }
            	}
        	}
        	return spawn;
        }
        
        public void sendmessage(double x, double y, double z, int han, String message, boolean mission) {
        	boolean spawn = false;
        	Entity entity = null;
        	int mobkazu = 0;
        	int mobkazu2 = 0;
        	{
        		AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(x-han), (double)(y-han), (double)(z-han), 
        				(double)(x + han), (double)(y + han), (double)(z+ han)))
                		.grow(1);
                List llist2 = this.world.getEntitiesWithinAABBExcludingEntity(entity, axisalignedbb2);
                if(llist2!=null){
                    for (int lj = 0; lj < llist2.size(); lj++) {
                    	
                    	Entity entity1 = (Entity)llist2.get(lj);
                    	if (entity1.canBeCollidedWith())
                        {
                    		if (entity1 != null && entity1 instanceof EntityPlayer) {
                    			EntityPlayer player = (EntityPlayer) entity1;
                    			if(this.world.isRemote) {
									player.sendMessage(new TextComponentTranslation(message, new Object[0]));
								}
                    			if(mission){
                    				InventoryPlayer playerInv = player.inventory;
                        			for(int is = 0; is < playerInv.mainInventory.size(); ++is){
                        				ItemStack itemi = playerInv.mainInventory.get(is);
                        			}
                    			}
                    			
        					}
                        }
                    }
                }
        	}
        }
        
}
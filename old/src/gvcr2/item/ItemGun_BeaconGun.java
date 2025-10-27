package gvcr2.item;

import gvclib.entity.EntityBBase;
import gvclib.entity.EntityB_BulletAA;
import gvclib.entity.EntityB_GrenadeB;
import gvclib.entity.EntityB_Missile;
import gvclib.entity.EntityB_Shell;
import gvclib.entity.living.EntityVehicleBase;
import gvclib.gui.GVCInventoryItem;
import gvclib.item.ItemAttachment;
import gvclib.item.ItemGunBase;
import gvclib.network.GVCLClientMessageKeyPressed;
import gvclib.network.GVCLPacketHandler;
import gvcr2.mod_GVCR2;
import gvcr2.entity.bullet.EntityGVCR2_Bullet_ROG;
import gvcr2.entity.bullet.EntityGVCR2_Request_Smoke;
import gvcr2.entity.so.EntityGVCR2_SO_S;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_A10;
import gvcr2.entity.vehicle.air.EntityGVCR2_AIR_C130;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;


	public class ItemGun_BeaconGun extends ItemGunBase {
		public int id;
		
		public ItemGun_BeaconGun() {
			super();
			//this.maxStackSize = 1;
		}
		
		/*public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
	    {
			super.onUpdate(itemstack, world, entity, i, flag);
			EntityPlayer entityplayer = (EntityPlayer)entity;
			boolean lflag = cycleBolt(itemstack);
			if (flag) {
				entityplayer.motionX = entityplayer.motionX * this.motion;
				entityplayer.motionZ = entityplayer.motionZ * this.motion;
			}
			this.gunbase_reload(itemstack, world, entity, i, flag);
			
	    }*/
		public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityLivingBase par3EntityPlayer, int par4){
			
		}
		@Override
		public byte getCycleCountrecoilre(ItemStack pItemstack) {
			return 3;
		}
		
		public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
	    {
			EntityPlayer entityplayer = (EntityPlayer)entity;
			int s;
			int li = getMaxDamage() - itemstack.getItemDamage();
			boolean lflag = cycleBolt(itemstack);
			boolean var5 = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, itemstack) > 0;
			Item item = itemstack.getItem();
			ItemStack item_m = entityplayer.getHeldItemMainhand();
			ItemStack item_o = entityplayer.getHeldItemOffhand();
			NBTTagCompound nbt = itemstack.getTagCompound();
			
			if(itemstack.hasTagCompound()) {
				//this.gunbase_recoil(itemstack, world, entity, i, flag, 1);
				//if(!entityplayer.isHandActive())this.gunbase_cocking(itemstack, world, entity, i, flag);
				//this.gunbase_reload(itemstack, world, entity, i, flag);
				//this.gunbase_lockon(itemstack, world, entity, i, flag);
			}
			
			
			if (flag) {
				entityplayer.motionX = entityplayer.motionX * this.motion;
				entityplayer.motionZ = entityplayer.motionZ * this.motion;
				InventoryPlayer playerInv = entityplayer.inventory;
				GVCInventoryItem inventory = new GVCInventoryItem(playerInv, itemstack);
				//GVCInventoryItem inventory = new GVCInventoryItem(entityplayer);
				inventory.openInventory(entityplayer);
				for (int i1 = 0; i1 < inventory.getSizeInventory(); ++i1) {
					ItemStack itemstacki = inventory.getStackInSlot(i1);

					if (i1 == 5) {
						if (!itemstacki.isEmpty() && itemstacki.getItem() instanceof ItemAttachment) {
							if(itemstacki.getItem() == mod_GVCR2.gvcr2_item_request_airstrike1) {
								id = 1;
							}
							if(itemstacki.getItem() == mod_GVCR2.gvcr2_item_request_airstrike2) {
								id = 11;
							}
							if(itemstacki.getItem() == mod_GVCR2.gvcr2_item_request_airstrike3) {
								id = 12;
							}
							if(itemstacki.getItem() == mod_GVCR2.gvcr2_item_request_flare) {
								id = 2;
							}
							if(itemstacki.getItem() == mod_GVCR2.gvcr2_item_request_light) {
								id = 21;
							}
							if(itemstacki.getItem() == mod_GVCR2.gvcr2_item_request_105mm) {
								id = 3;
							}
							if(itemstacki.getItem() == mod_GVCR2.gvcr2_item_request_40mm) {
								id = 31;
							}
							if(itemstacki.getItem() == mod_GVCR2.gvcr2_item_request_20mm) {
								id = 32;
							}
							if(itemstacki.getItem() == mod_GVCR2.gvcr2_item_request_pave) {
								id = 33;
							}
							if(itemstacki.getItem() == mod_GVCR2.gvcr2_item_request_airborne1) {
								id = 4;
							}
							if(itemstacki.getItem() == mod_GVCR2.gvcr2_item_request_airborne2) {
								id = 41;
							}
							if(itemstacki.getItem() == mod_GVCR2.gvcr2_item_request_airborne3) {
								id = 42;
							}
							if(itemstacki.getItem() == mod_GVCR2.gvcr2_item_request_missile1) {
								id = 5;
							}
							if(itemstacki.getItem() == mod_GVCR2.gvcr2_item_request_missile2) {
								id = 51;
							}
							if(itemstacki.getItem() == mod_GVCR2.gvcr2_item_request_missile3) {
								id = 52;
							}
							if(itemstacki.getItem() == mod_GVCR2.gvcr2_item_request_rog) {
								id = 99;
							}
						}
					}
				}
				if(entityplayer.isSneaking()) {
					Vec3d lock = Vec3d.fromPitchYaw(entityplayer.rotationPitch, entityplayer.rotationYaw);
					int ix = 0;
					int iy = 0;
					int iz = 0;
					for(int x = 0; x < 150; ++x) {
						if (entityplayer.world
								.getBlockState(new BlockPos(entityplayer.posX + lock.x * x,
										entityplayer.posY + 1.5 + lock.y * x,
										entityplayer.posZ + lock.z * x))
								.getBlock() != Blocks.AIR) {
							ix = (int) (entityplayer.posX + lock.x * x);
							iy = (int) (entityplayer.posY + 1.5 + lock.y * x);
							iz = (int) (entityplayer.posZ + lock.z * x);
							
							double d2 = entityplayer.world.rand.nextGaussian() * 0.02D;
			                double d0 = entityplayer.world.rand.nextGaussian() * 0.02D;
			                double d1 = entityplayer.world.rand.nextGaussian() * 0.02D;
			                entityplayer.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, 
			                		entityplayer.posX +lock.x * x,  entityplayer.posY + 1.5 +lock.y * x, entityplayer.posZ +lock.z * x, d2, d0, d1);
							break;
						}
					}
				}
			}
			
			boolean cocking = nbt.getBoolean("Cocking");;
			if (entity != null && !world.isRemote) 
			{
				if (entity != null  && entityplayer != null && !itemstack.isEmpty()) //if (entity != null && !world.isRemote && entityplayer != null && !itemstack.isEmpty()) 
				{
					if (flag)
					{
						if (entityplayer.getActiveItemStack() == itemstack){
								Fire(itemstack, world, entityplayer, 0);
							}
					}
				}
			}
			
			super.onUpdate(itemstack, world, entity, i, flag);
	    }
		
		
		
		public void Fire(ItemStack par1ItemStack, World par2World, EntityLivingBase par3EntityPlayer, int par4){
			if (par3EntityPlayer instanceof EntityPlayer)
	        {
				EntityPlayer entityplayer = (EntityPlayer)par3EntityPlayer;
				int s;
				int li = getMaxDamage() - par1ItemStack.getItemDamage();
				boolean lflag = cycleBolt(par1ItemStack);
				boolean var5 = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, par1ItemStack) > 0;
				Item item = par1ItemStack.getItem();
				
		//		par1ItemStack.damageItem(1, par3EntityPlayer);
				
			{
				{
							Vec3d lock = Vec3d.fromPitchYaw(par3EntityPlayer.rotationPitch, par3EntityPlayer.rotationYaw);
							int ix = 0;
							int iy = 0;
							int iz = 0;
							for(int x = 0; x < 150; ++x) {
								if (par3EntityPlayer.world
										.getBlockState(new BlockPos(par3EntityPlayer.posX + lock.x * x,
												par3EntityPlayer.posY + 1.5 + lock.y * x,
												par3EntityPlayer.posZ + lock.z * x))
										.getBlock() != Blocks.AIR) {
									ix = (int) (par3EntityPlayer.posX + lock.x * x);
									iy = (int) (par3EntityPlayer.posY + 1.5 + lock.y * x);
									iz = (int) (par3EntityPlayer.posZ + lock.z * x);
									break;
								}
							}
							if(ix != 0 && iz != 0 && iy != 0) {
								if(id == 1) {
									this.callbomber(par1ItemStack, par2World, par3EntityPlayer, ix, iy, iz, 95, 30);
									if (!par2World.isRemote)par3EntityPlayer.sendMessage(new TextComponentTranslation("Request the Air strike!", new Object[0]));
									entityplayer.getCooldownTracker().setCooldown(this, 100);
								}
								if(id == 11) {
									for(int ii = 0; ii < 3; ++ii) {
										double xx11 = 0;
										double zz11 = 0;
										float side = 0;
										if(ii == 1)side = -1.57F;
										if(ii == 2)side = 1.57F;
										xx11 -= MathHelper.sin((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
										zz11 += MathHelper.cos((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
										xx11 -= MathHelper.sin((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
										zz11 += MathHelper.cos((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
										double xx = ix - xx11;
										double yy = iy;
										double zz = iz - zz11;
										this.callbomber(par1ItemStack, par2World, par3EntityPlayer, xx, yy, zz, 95, 30);
									}
									if (!par2World.isRemote)par3EntityPlayer.sendMessage(new TextComponentTranslation("Request the Air strike!", new Object[0]));
									entityplayer.getCooldownTracker().setCooldown(this, 200);
								}
								if(id == 12) {
									for(int ii = 0; ii < 3; ++ii) {
										double xx11 = 0;
										double zz11 = 0;
										float side = 0;
										if(ii == 1)side = -1.57F;
										if(ii == 2)side = 1.57F;
										xx11 -= MathHelper.sin((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
										zz11 += MathHelper.cos((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
										xx11 -= MathHelper.sin((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
										zz11 += MathHelper.cos((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
										double xx = ix - xx11;
										double yy = iy;
										double zz = iz - zz11;
										this.callbomber(par1ItemStack, par2World, par3EntityPlayer, xx, yy, zz, 90, 30);
									}
									for(int ii = 0; ii < 3; ++ii) {
										double xx11 = 0;
										double zz11 = 0;
										float side = 0;
										if(ii == 1)side = -1.57F;
										if(ii == 2)side = 1.57F;
										xx11 -= MathHelper.sin((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
										zz11 += MathHelper.cos((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
										xx11 -= MathHelper.sin((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
										zz11 += MathHelper.cos((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
										double xx = ix - xx11;
										double yy = iy;
										double zz = iz - zz11;
										this.callbomber(par1ItemStack, par2World, par3EntityPlayer, xx, yy, zz, 110, 30);
									}
									if (!par2World.isRemote)par3EntityPlayer.sendMessage(new TextComponentTranslation("Request the Air strike!", new Object[0]));
									entityplayer.getCooldownTracker().setCooldown(this, 400);
								}
								if(id == 2) {
									/*for(int ii = 0; ii < 3; ++ii) {
										double xx11 = 0;
										double zz11 = 0;
										float side = 0;
										if(ii == 1)side = -1.57F;
										if(ii == 2)side = 1.57F;
										xx11 -= MathHelper.sin((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
										zz11 += MathHelper.cos((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
										xx11 -= MathHelper.sin((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
										zz11 += MathHelper.cos((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
										double xx = ix - xx11;
										double yy = iy;
										double zz = iz - zz11;
										this.callbomber(par1ItemStack, par2World, par3EntityPlayer, xx, yy, zz, 95, 31);
									}*/
									this.callbomber(par1ItemStack, par2World, par3EntityPlayer, ix, iy, iz, 95, 31);
									if (!par2World.isRemote)par3EntityPlayer.sendMessage(new TextComponentTranslation("Request the FlareSupport!", new Object[0]));
									entityplayer.getCooldownTracker().setCooldown(this, 100);
								}
								if(id == 21) {
									this.callbomber(par1ItemStack, par2World, par3EntityPlayer, ix, iy, iz, 95, 32);
									if (!par2World.isRemote)par3EntityPlayer.sendMessage(new TextComponentTranslation("Request the LightSupport!", new Object[0]));
									entityplayer.getCooldownTracker().setCooldown(this, 100);
								}
								if(id == 3) {
									this.fire(par1ItemStack, par2World, par3EntityPlayer, ix, iy, iz, 0, 0);
									if (!par2World.isRemote)par3EntityPlayer.sendMessage(new TextComponentTranslation("Request the FireSupport!", new Object[0]));
									entityplayer.getCooldownTracker().setCooldown(this, 100);
								}
								
								if(id == 31) {
									for(int ii = 0; ii < 8; ++ii) {
										int rax = par2World.rand.nextInt(10);
										int raz = par2World.rand.nextInt(10);
										this.fire(par1ItemStack, par2World, par3EntityPlayer, ix - 5 + rax, iy, iz - 5 + raz, 1, ii);
									}
									if (!par2World.isRemote)par3EntityPlayer.sendMessage(new TextComponentTranslation("Request the FireSupport!", new Object[0]));
									entityplayer.getCooldownTracker().setCooldown(this, 80);
								}
								if(id == 32) {
									for(int ii = 0; ii < 30; ++ii) {
										int rax = par2World.rand.nextInt(10);
										int raz = par2World.rand.nextInt(10);
										this.fire(par1ItemStack, par2World, par3EntityPlayer, ix - 5 + rax, iy, iz - 5 + raz, 2, ii);
									}
									if (!par2World.isRemote)par3EntityPlayer.sendMessage(new TextComponentTranslation("Request the FireSupport!", new Object[0]));
									entityplayer.getCooldownTracker().setCooldown(this, 60);
								}
								if(id == 33) {
									this.fire(par1ItemStack, par2World, par3EntityPlayer, ix, iy, iz, 3, 0);
									if (!par2World.isRemote)par3EntityPlayer.sendMessage(new TextComponentTranslation("Request the FireSupport!", new Object[0]));
									entityplayer.getCooldownTracker().setCooldown(this, 120);
								}
								
								if(id == 4) {
									this.callbomber(par1ItemStack, par2World, par3EntityPlayer, ix, iy, iz, 95, 33);
									if (!par2World.isRemote)par3EntityPlayer.sendMessage(new TextComponentTranslation("Request the Airborne!", new Object[0]));
									entityplayer.getCooldownTracker().setCooldown(this, 200);
								}
								if(id == 41) {
									this.callbomber(par1ItemStack, par2World, par3EntityPlayer, ix, iy, iz, 95, 34);
									if (!par2World.isRemote)par3EntityPlayer.sendMessage(new TextComponentTranslation("Request the Airborne!", new Object[0]));
									entityplayer.getCooldownTracker().setCooldown(this, 400);
								}
								if(id == 42) {
									for(int ii = 0; ii < 3; ++ii) {
										double xx11 = 0;
										double zz11 = 0;
										float side = 0;
										if(ii == 1)side = -1.57F;
										if(ii == 2)side = 1.57F;
										xx11 -= MathHelper.sin((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
										zz11 += MathHelper.cos((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F) * -ii * 12;
										xx11 -= MathHelper.sin((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
										zz11 += MathHelper.cos((par3EntityPlayer.rotationYaw + 90) * 0.01745329252F + side) * 12;
										double xx = ix - xx11;
										double yy = iy;
										double zz = iz - zz11;
										this.callbomber(par1ItemStack, par2World, par3EntityPlayer, xx, yy, zz, 95, 34);
									}
									if (!par2World.isRemote)par3EntityPlayer.sendMessage(new TextComponentTranslation("Request the Airborne!", new Object[0]));
									entityplayer.getCooldownTracker().setCooldown(this, 600);
								}
								if(id == 5) {
									this.fire_missile(par1ItemStack, par2World, par3EntityPlayer, ix, iy, iz, 0);
									if (!par2World.isRemote)par3EntityPlayer.sendMessage(new TextComponentTranslation("Request the Missile!", new Object[0]));
									entityplayer.getCooldownTracker().setCooldown(this, 100);
								}
								if(id == 51) {
									this.fire_missile(par1ItemStack, par2World, par3EntityPlayer, ix, iy, iz, 1);
									if (!par2World.isRemote)par3EntityPlayer.sendMessage(new TextComponentTranslation("Request the Missile!", new Object[0]));
									entityplayer.getCooldownTracker().setCooldown(this, 200);
								}
								if(id == 52) {
									this.fire_missile(par1ItemStack, par2World, par3EntityPlayer, ix, iy, iz, 2);
									if (!par2World.isRemote)par3EntityPlayer.sendMessage(new TextComponentTranslation("Request the Missile!", new Object[0]));
									entityplayer.getCooldownTracker().setCooldown(this, 400);
								}
								
								if(id == 99) {
									this.fire_rog(par1ItemStack, par2World, par3EntityPlayer, ix, iy, iz, 2);
									if (!par2World.isRemote)par3EntityPlayer.sendMessage(new TextComponentTranslation("R.I.P", new Object[0]));
									entityplayer.getCooldownTracker().setCooldown(this, 100);
								}
								
				//				par1ItemStack.damageItem(1, par3EntityPlayer);
								par3EntityPlayer.resetActiveHand();
								{
									int ra = par2World.rand.nextInt(10) + 1;
							    	float val = ra * 0.02F;
									if(this.fires != null) {
										par2World.playSound((EntityPlayer)null, par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ,
												this.fires, SoundCategory.NEUTRAL, 3.0F, 0.9F + val);
									}else if(sound != null){
										par2World.playSound((EntityPlayer)null, par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ,
												SoundEvent.REGISTRY.getObject(new ResourceLocation(modid, sound)), SoundCategory.NEUTRAL, 3.0F, 0.9F + val);
									}
								}
								entityplayer.addStat(StatList.getObjectUseStats(this));
							}
				}
			}
	        }
        	
			
        }
		
		public void callbomber(ItemStack par1ItemStack, World par2World, EntityLivingBase par3EntityPlayer, double ix, double iy, double iz, double range, int id) {
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
				}else {
					var8 = new EntityGVCR2_AIR_A10(par2World);
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
		
		public void fire(ItemStack par1ItemStack, World par2World, EntityLivingBase par3EntityPlayer, double ix, double iy, double iz, int id, int count) {
			EntityBBase var8;
			//EntityB_Shell var8 = new EntityB_Shell(par2World, (EntityLivingBase) par3EntityPlayer);
			int firepointxz = 40;
			int firepointy = 40;
			float speedoffset = 3.0F;
			float kakusan = 0.0F;
			double graa = 0.0D;
	    	if(id == 1) {
	    		var8 = new EntityB_GrenadeB(par2World, (EntityLivingBase) par3EntityPlayer);
	    		var8.Bdamege = 12;
	    		var8.exlevel = 2.0F;
	    		var8.setModel("gvclib:textures/entity/model/bullet_aaa.mqo");
				var8.setTex("gvclib:textures/entity/model/bullet_aaa.png");
				kakusan = 1.0F;
	    	}
	    	else if(id == 2) {
	    		var8 = new EntityB_BulletAA(par2World, (EntityLivingBase) par3EntityPlayer);
	    		var8.Bdamege = 8;
	    		var8.exlevel = 1.0F;
	    		var8.setModel("gvclib:textures/entity/model/bullet_aaa.mqo");
				var8.setTex("gvclib:textures/entity/model/bullet_aaa.png");
				kakusan = 1.0F;
	    	}
	    	else if(id == 3) {
	    		var8 = new EntityB_Shell(par2World, (EntityLivingBase) par3EntityPlayer);
	    		var8.Bdamege = 80;
	    		var8.exlevel = 3.0F;
	    		var8.setModel("gvclib:textures/entity/new/bullet_bomb_pave_small.mqo");
				var8.setTex("gvclib:textures/entity/new/bullet_bomb_pave_small.png");
				firepointxz = 20;
				firepointy = 60;
				speedoffset = 2.0F;
				graa = 0.03F;
	    	}
	    	else {
	    		var8 = new EntityB_Shell(par2World, (EntityLivingBase) par3EntityPlayer);
	    		var8.Bdamege = 60;
	    		var8.exlevel = 3.0F;
	    		var8.setModel("gvclib:textures/entity/model/bullet_cannon_small.mqo");
				var8.setTex("gvclib:textures/entity/model/bullet_cannon_small.png");
	    	}
			
	    	var8.spg_fly_sound = false;
	    	var8.gra = graa;
			var8.muteki = true;
			var8.friend = par3EntityPlayer;
			
			var8.bulletDameID = this.bulletDameID;
			var8.ex = this.ex;
			
			
			
			var8.P_ID = this.p_id;
			var8.mitarget = this.mitarget;
			float bbure = this.bure;
			var8.timemax = 800;
			//var8.setLocationAndAngles(ix, iy + 240, iz, 0,0);
			//var8.setHeadingFromThrower(par3EntityPlayer, 90, par3EntityPlayer.rotationYaw, 0.0F,this.speed, bbure);
			double xx11 = 0;
			double zz11 = 0;
			xx11 -= MathHelper.sin(par3EntityPlayer.rotationYaw * 0.01745329252F - 1.57F) * 1;
			zz11 += MathHelper.cos(par3EntityPlayer.rotationYaw * 0.01745329252F - 1.57F) * 1;
			//var8.setLocationAndAngles(ix, iy + 240, iz, 0,0);
			int rax = par3EntityPlayer.world.rand.nextInt(5);
			int raz = par3EntityPlayer.world.rand.nextInt(5);
			
			double firex = par3EntityPlayer.posX - (xx11 * (firepointxz + 0)) + rax;
			double firey = par3EntityPlayer.posY + firepointy + 0;
			double firez = par3EntityPlayer.posZ - (zz11 * (firepointxz + 0)) + raz;
			
			
			var8.setLocationAndAngles(firex, firey, firez, 0, 0);
			
			double varx = ix - firex;
			double vary = iy - firey;
			double varz = iz - firez;
			float var10 = MathHelper.sqrt(varx * varx + varz * varz) * 0.1F;
			var8.setThrowableHeading(varx, (vary + (double) var10) * 1, varz, speedoffset + count * 0.1F, kakusan);
			if (!par2World.isRemote) {
				par2World.spawnEntity(var8);
			}
		}
		
		
		public void fire_missile(ItemStack par1ItemStack, World par2World, EntityLivingBase par3EntityPlayer, double ix, double iy, double iz, int id) {
			EntityB_Missile var8 = new EntityB_Missile(par2World, (EntityLivingBase) par3EntityPlayer);
	    	if(id == 1) {
	    		var8.Bdamege = 120;
	    		var8.exlevel = 5.0F;
	    		var8.speedd = 0.5;
	    		var8.setModel("gvclib:textures/entity/model/bullet_agm.mqo");
				var8.setTex("gvclib:textures/entity/model/bullet_agm.png");
	    	}else if(id == 2) {
	    		var8.Bdamege = 300;
	    		var8.exlevel = 12.0F;
	    		var8.speedd = 0.3;
	    		if(par2World.rand.nextInt(20) == 0) {
	    			var8.setModel("gvcr2:textures/entity/creeper.mqo");
					var8.setTex("textures/entity/creeper/creeper.png");
	    		}else {
	    			var8.setModel("gvclib:textures/entity/model/bullet_cm.mqo");
					var8.setTex("gvclib:textures/entity/model/bullet_cm.png");
	    		}
	    	}else {
	    		var8.Bdamege = 60;
	    		var8.exlevel = 4.0F;
	    		var8.speedd = 0.6;
	    		var8.setModel("gvclib:textures/entity/model/bullet_atm.mqo");
				var8.setTex("gvclib:textures/entity/model/bullet_atm.png");
	    	}
			
	    	var8.autoaim = false;
	    	var8.aim_lock = true;
	    	var8.spg_fly_sound = true;
			var8.gra = 0.03;
			var8.muteki = true;
			var8.friend = par3EntityPlayer;
			
			var8.bulletDameID = this.bulletDameID;
			var8.ex = this.ex;
			
			var8.P_ID = this.p_id;
			var8.mitarget = this.mitarget;
			float bbure = this.bure;
			var8.timemax = 800;
			double xx11 = 0;
			double zz11 = 0;
			xx11 -= MathHelper.sin(par3EntityPlayer.rotationYaw * 0.01745329252F - 1.57F) * 1;
			zz11 += MathHelper.cos(par3EntityPlayer.rotationYaw * 0.01745329252F - 1.57F) * 1;
			//var8.setLocationAndAngles(ix, iy + 240, iz, 0,0);
			int rax = par3EntityPlayer.world.rand.nextInt(20);
			int raz = par3EntityPlayer.world.rand.nextInt(20);
			var8.setLocationAndAngles(par3EntityPlayer.posX - (xx11 * 40) + rax, par3EntityPlayer.posY + 40 + 1 * 2D, par3EntityPlayer.posZ - (zz11 * 40) + raz, 0, 0);
			var8.setHeadingFromThrower(par3EntityPlayer, par3EntityPlayer.rotationPitch, par3EntityPlayer.rotationYaw, 0.0F, 1F, bbure);
			if (!par2World.isRemote) {
				par2World.spawnEntity(var8);
			}
		}
		
		public void fire_rog(ItemStack par1ItemStack, World par2World, EntityLivingBase par3EntityPlayer, double ix, double iy, double iz, int id) {
			EntityGVCR2_Bullet_ROG entitysnowball = new EntityGVCR2_Bullet_ROG(par2World, par3EntityPlayer);
			entitysnowball.setLocationAndAngles(ix, iy + 40, iz, 0,0);
            entitysnowball.setHeadingFromThrower(par3EntityPlayer, par3EntityPlayer.rotationPitch, par3EntityPlayer.rotationYaw, 0.0F, 1.5F, 1.0F);
            {
            	entitysnowball.timemax = 20;
            }
            par2World.spawnEntity(entitysnowball);
			if (!par2World.isRemote) {
				par2World.spawnEntity(entitysnowball);
			}
		}
		
		
		public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	    {
			ItemStack itemstack = playerIn.getHeldItem(handIn);
	        {
	            playerIn.setActiveHand(handIn);
	            return new ActionResult(EnumActionResult.SUCCESS, itemstack);
	        }
	    }

}

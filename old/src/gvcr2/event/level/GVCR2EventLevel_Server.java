package gvcr2.event.level;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import gvcr2.mod_GVCR2;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.vehicle.car.EntityGVCR2_CAR_Technical;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T34;
import gvcr2.network.GVCR2ClientMessageKeyPressed;
import gvcr2.network.GVCR2PacketHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GVCR2EventLevel_Server {
	
	
	
	@SubscribeEvent
	public void onUpdateEvent(LivingUpdateEvent event) {
		
	}
	
	
	
	@SubscribeEvent
	public void onDeadEvent(LivingDeathEvent event) {
		EntityLivingBase target = event.getEntityLiving();
		DamageSource source = event.getSource();
		if (target instanceof EntityLivingBase && target != null) 
		{
			Entity entity = source.getTrueSource();
			if(entity != null && entity instanceof EntityPlayer){
	    		EntityPlayer player = (EntityPlayer) entity;
	    		if(player != null){
	    			if (target instanceof EntityGVCR2_GE_S) 
	    			{
	    				if(mod_GVCR2.difficult_level < 1)GVCR2WorldDifficultyLevel.setLevel(mod_GVCR2.INSTANCE, player.world, 1, "levelUp1");
	    			}
	    			if (target instanceof EntityGVCR2_CAR_Technical) 
	    			{
	    				if(mod_GVCR2.difficult_level < 2)GVCR2WorldDifficultyLevel.setLevel(mod_GVCR2.INSTANCE, player.world, 2, "levelUp2");
	    			}
	    			if (target instanceof EntityGVCR2_TANK_T34) 
	    			{
	    				if(mod_GVCR2.difficult_level < 5)GVCR2WorldDifficultyLevel.setLevel(mod_GVCR2.INSTANCE, player.world, 5, "levelUp5");
	    			}
	    		}
	    	}
		}
	}
	
	///ワールドにログイン時のイベント
		///レベルの設置
		
		@SubscribeEvent
		//public void OnEvent(WorldEvent.Load event) 
		public void OnEvent(EntityJoinWorldEvent event) 
		{
			mod_GVCR2 mod = mod_GVCR2.INSTANCE;
			if(!event.getWorld().isRemote && event.getEntity() instanceof EntityPlayer){
				String name = event.getWorld().getWorldInfo().getWorldName();
				File newfile = new File(".",
						"mods" + File.separatorChar + "gvcr2" + File.separatorChar + "level" + File.separatorChar
								+ name + ".txt");
				if (newfile.isFile()) {
					try {
						if (checkBeforeReadfile(newfile)) {
							BufferedReader br = new BufferedReader(new FileReader(newfile)); // ファイルを開く
							String str;
							while ((str = br.readLine()) != null) { // 1行ずつ読み込む
								String[] type = str.split(",");
								if (type.length != 0) {// 1
									//if (!mod.proxy.getClient())
									{
										//System.out.println(String.format("1"));
										if (type[0].equals("level")) {
											mod.difficult_level = Integer.parseInt(type[1]);
											String dd = String.format("%1$3d", (int)mod.difficult_level);
											if(FMLCommonHandler.instance().getMinecraftServerInstance() != null) {
												for (EntityPlayerMP player : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers())
									            {
													GVCR2PacketHandler.INSTANCE2.sendTo(new GVCR2ClientMessageKeyPressed(1, mod.difficult_level), player);
									            }
								            }
											System.out.println("LEVEL"+String.format(dd));
										}
									}
								}
							}
							br.close(); // ファイルを閉じる
						}
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				} else{
					File dire = new File(".",
							"mods" + File.separatorChar + "gvcr2" + File.separatorChar + "level");
					dire.mkdirs();
					try {
						newfile.createNewFile();
						BufferedWriter bw = new BufferedWriter(new FileWriter(newfile));
						bw.write("#");
						bw.newLine();
						bw.write("level," + "0");
						bw.close();
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					mod.difficult_level = 0;
					//mod.difficult_doll_kazu = 0;
					System.out.println(String.format("createLevel"));
					String dd = String.format("%1$3d", (int)mod.difficult_level);
					System.out.println(String.format(dd));
				}
			}
			
			
			//hmggirlfrontRecipeRegistrys_level.recipe(mod.difficult_level);
		}
		
		 private static boolean checkBeforeReadfile(File file){
			    if (file.exists()){
			      if (file.isFile() && file.canRead()){
			        return true;
			      }
			    }

			    return false;
			  }
		 
}

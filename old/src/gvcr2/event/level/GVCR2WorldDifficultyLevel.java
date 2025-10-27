package gvcr2.event.level;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import gvcr2.mod_GVCR2;
import gvcr2.network.GVCR2ClientMessageKeyPressed;
import gvcr2.network.GVCR2PacketHandler;
import gvcr2.registry.GVCR2RecipeRegistrys_level;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GVCR2WorldDifficultyLevel{
	
	@SideOnly(Side.CLIENT)
	public static int getLevelClient(){
		if(mod_GVCR2.cfg_worldlevel_debag) {
			mod_GVCR2.INSTANCE.difficult_level = 1000;
			return 1000;
		}else {
			 return mod_GVCR2.INSTANCE.difficult_level;
		}
	   
	}
	
	public static int getLevel(mod_GVCR2 mod, World world){
		/*int level = 0;
		level = mod.difficult_level;
	    return level;*/
		if(mod_GVCR2.cfg_worldlevel_debag) {
			mod_GVCR2.INSTANCE.difficult_level = 1000;
			return 1000;
		}else {
			 return mod_GVCR2.INSTANCE.difficult_level;
		}
	}
	public static void setLevel(mod_GVCR2 mod, World world,  int lev, String massage){
		int level = mod.difficult_level;
		System.out.println(String.format("updateLevel"));
		if(lev > level  && !world.isRemote) {
			String name = world.getWorldInfo().getWorldName();
			File newfile = new File(".",
					"mods" + File.separatorChar + "gvcr2" + File.separatorChar+ "level"+ File.separatorChar + name + ".txt");
			if(newfile.isFile()) {
				{
					File dire = new File(".",
							"mods" + File.separatorChar + "gvcr2" + File.separatorChar + "level");
					dire.mkdirs();
					try {
						newfile.createNewFile();
						BufferedWriter bw = new BufferedWriter(new FileWriter(newfile));
						bw.write("#");
						bw.newLine();
						bw.write("level," + String.valueOf(lev));
						bw.close();
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					mod.difficult_level = lev;
	    		}
			}else {//ファイルを作成
				
    		}
			{
				EntityPlayer player = mod.proxy.getEntityPlayerInstance();
				if(player != null) {
			//		if(player.world.isRemote)player.sendMessage(new TextComponentTranslation(massage, new Object[0]));
					player.playSound(SoundEvents.UI_TOAST_CHALLENGE_COMPLETE, 0.5F, 1.0F);
				}
			}
			mod.difficult_level = lev;
			if(FMLCommonHandler.instance().getMinecraftServerInstance() != null) {
				for (EntityPlayerMP player : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers())
	            {
					GVCR2PacketHandler.INSTANCE2.sendTo(new GVCR2ClientMessageKeyPressed(1, mod.difficult_level), player);
					//GFPacketHandler.INSTANCE2.sendTo(new GFClientMessageKeyPressed(2, mod.difficult_doll_kazu), player);
					if(player != null) {
						player.sendMessage(new TextComponentTranslation(massage, new Object[0]));
						//player.playSound(SoundEvents.UI_TOAST_CHALLENGE_COMPLETE, 0.5F, 1.0F);
					}
	            }
            }
		}else {
			
		}
	}
	
	/*
	public static void setLevel(mod_GVCR2 mod, World world,  int lev, String massage){
		int level = mod.difficult_level;
		System.out.println(String.format("updateLevel"));
		if(lev > level) {
			String name = world.getWorldInfo().getWorldName();
			File newfile = new File(".",
					"mods" + File.separatorChar + "gvcr2" + File.separatorChar+ "level"+ File.separatorChar + name + ".txt");
			if(newfile.isFile()) {
				try {
					if (checkBeforeReadfile(newfile)) {
						BufferedReader br = new BufferedReader(new FileReader(newfile)); // ファイルを開く
						String str;
						while ((str = br.readLine()) != null) { // 1行ずつ読み込む
							String[] type = str.split(",");
							if (type.length != 0) {// 1
								{
									//System.out.println(String.format("2"));
									if (type[0].equals("level")) {
										level = Integer.parseInt(type[1]);
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
				if(level <= (lev - 1)) {
					File dire = new File(".",
							"mods" + File.separatorChar + "gvcr2" + File.separatorChar + "level");
					dire.mkdirs();
					try {
						newfile.createNewFile();
						BufferedWriter bw = new BufferedWriter(new FileWriter(newfile));
						bw.write("#");
						bw.newLine();
						bw.write("level," + String.valueOf(lev));
						bw.close();
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					mod.difficult_level = lev;
	    		}
			}else {
				//mod.proxy.ProxyFile(),
				File dire = new File(".",
						"mods" + File.separatorChar + "gvcr2" + File.separatorChar + "level");
				dire.mkdirs();
				try {
					newfile.createNewFile();
					BufferedWriter bw = new BufferedWriter(new FileWriter(newfile));
					bw.write("#");
					bw.newLine();
					bw.write("level," + String.valueOf(lev));
					bw.close();
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				mod.difficult_level = lev;
    		}
			{
				EntityPlayer player = mod.proxy.getEntityPlayerInstance();
				if(player != null) {
					if(player.world.isRemote)player.sendMessage(new TextComponentTranslation(massage, new Object[0]));
				}
			}
			
			mod.difficult_level = lev;
			
			//GVCR2RecipeRegistrys_level.recipe(mod.difficult_level);
		}else {
			
		}
	}
	*/
	 private static boolean checkBeforeReadfile(File file){
		    if (file.exists()){
		      if (file.isFile() && file.canRead()){
		        return true;
		      }
		    }

		    return false;
		  }
}
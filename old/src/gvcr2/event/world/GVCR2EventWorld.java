package gvcr2.event.world;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import gvcr2.mod_GVCR2;
import gvcr2.registry.GVCR2RecipeRegistrys_level;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GVCR2EventWorld {
	
	
	@SubscribeEvent
	public void OnEvent(WorldEvent.Load event) {
		mod_GVCR2 mod = mod_GVCR2.INSTANCE;
		if(!event.getWorld().isRemote){
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
										System.out.println(String.format(dd));
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
				System.out.println(String.format("createLevel"));
				String dd = String.format("%1$3d", (int)mod.difficult_level);
				System.out.println(String.format(dd));
			}
		}
		
		
		//GVCR2RecipeRegistrys_level.recipe(mod.difficult_level);
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
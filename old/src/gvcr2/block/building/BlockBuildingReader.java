package gvcr2.block.building;
 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
//import net.minecraft.world.gen.structure.StructureStrongholdPieces;;
 
public class BlockBuildingReader extends Block
{
	public FMLPreInitializationEvent pEvent;
	public String txt;
	public int sizex = 16;
	public int sizez = 16;
	public int sizey = 16;
	public int offsety = 0;
	public boolean setair = false;
	public boolean setbed = false;
	
	public String[] text_read = new String[2097152];
	public int text_read_num = 0;
	
    public BlockBuildingReader(String t) {
        super(Material.ROCK);
        txt = t;
        setHardness(1.5F);
        setResistance(1.0F);
        setLightOpacity(1);
        setLightLevel(1.0F);
    }
    
    public void Building_Read(String t) {
		/*try {
			InputStreamReader packFile = new InputStreamReader(
					getClass().getClassLoader().getResourceAsStream("assets/gvcr2/building/" + t), "UTF-8");
			{
				BufferedReader br = new BufferedReader(packFile); // ファイルを開く
				String str;
				while ((str = br.readLine()) != null) { // 1行ずつ読み込む
					text_read[text_read_num] = str;
					++text_read_num;
				}
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}*/
    }
 
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
    	int par1 = pos.getX();
    	int par2 = pos.getY();
    	int par3 = pos.getZ();
    	//if (FMLCommonHandler.instance().getSide().isClient()) 
    	{
    		if(setbed){
        		int sety = pos.getY() - 60;
        		if(sety > 0) {
        			for (int i0 = 0; i0 < sizex; ++i0){
        	    		for (int i1 = 0; i1 < sety; ++i1){
        	    			for (int i2 = 0; i2 < sizez; ++i2){
        	    				worldIn.setBlockState(new BlockPos(par1+i0, par2-i1 -1, par3+i2), Blocks.STONE.getDefaultState(), 2);
        	    			}
        	    		}
        	    	}
        		}
        	}
			if(setair) {
        		for (int i0 = 0; i0 < sizex; ++i0){
            		for (int i1 = 0; i1 < sizey; ++i1){
            			for (int i2 = 0; i2 < sizez; ++i2){
            				if(worldIn.getBlockState(new BlockPos(par1+i0, par2+i1 + offsety, par3+i2)).getBlock() != Blocks.AIR){
            					worldIn.setBlockState(new BlockPos(par1+i0, par2+i1 + offsety, par3+i2), Blocks.AIR.getDefaultState(), 2);
            				}
            			}
            		}
            	}
        	}
			
			/*{
        		for (int i0 = 0; i0 < sizex; ++i0){
            		for (int i1 = 0; i1 < sizey; ++i1){
            			for (int i2 = 0; i2 < sizez; ++i2){
            				{
            					worldIn.setBlockState(new BlockPos(par1+i0, par2+i1 + offsety, par3+i2), Blocks.STONE.getDefaultState(), 2);
            				}
            			}
            		}
            	}
        	}*/
        	
    		try {
    			InputStreamReader packFile = new InputStreamReader(getClass().getClassLoader()
    		            .getResourceAsStream("assets/gvcr2/building/" + txt), "UTF-8");
                {
              	  BufferedReader br = new BufferedReader(packFile);  // ファイルを開く
                
                String str;
                while((str = br.readLine()) != null){  // 1行ずつ読み込む
                  //System.out.println(str);
              	  String[] type = str.split(",");
              	  if (type.length != 0)
                    {
              		  if(type[0].equals("Block")){
              			String blockd = type[1];
              			String blockid = type[2];//Integer.parseInt(type[1]);
              			int x = Integer.parseInt(type[3]);
              			int y = Integer.parseInt(type[4]);
              			int z = Integer.parseInt(type[5]);
              			int meta = Integer.parseInt(type[6]);
              			Block block;
              			boolean chest = false;
              			boolean dispenser = false;
              			if(blockid.equals("tilechest")) {
              				block = (Block)Block.REGISTRY.getObject(new ResourceLocation(blockd + ":" + "chest"));
              				chest = true;
              			}else if(blockid.equals("tiledispenser")) {
              				block = (Block)Block.REGISTRY.getObject(new ResourceLocation(blockd + ":" + "dispenser"));
              				dispenser = true;
              			}
              			else if(blockid.equals("gvcr2_block_setair")) {
              				block = null;
              				if (!worldIn.isRemote)
                	        {
              					worldIn.setBlockState(new BlockPos(par1+x, par2+y + offsety, par3+z), Blocks.AIR.getDefaultState(), 2);
                	        }
              			}
              			else
              			{
              				block = (Block)Block.REGISTRY.getObject(new ResourceLocation(blockd + ":" + blockid));
              			}
              			if (!worldIn.isRemote && block != null)
            	        {
              			//par1World.setBlock(par1+x, par2+y, par3+z, block,meta,2);
              				worldIn.setBlockState(new BlockPos(par1+x, par2+y + offsety, par3+z), block.getStateFromMeta(meta), 2);
              				if(chest) {
          						TileEntityChest Chest;
              					Chest = (TileEntityChest) worldIn.getTileEntity(new BlockPos(par1+x, par2+y + offsety, par3+z));
              					for(int c = 0; c < 78; c = c +3) {
              						//int it = Integer.parseInt(type[7 + c]);
              						String modid = type[7 + c];
                          			String item = type[7 + c + 1];//Integer.parseInt(type[1]);
                          			int itemmeta = Integer.parseInt(type[7 + c + 2]);//Integer.parseInt(type[1]);
              						//if(it != 0) 
              						{
              							ItemStack itemstack = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(modid + ":" + item)));
                	    				if(!itemstack.isEmpty()) {
                	    					itemstack.getItem().getMetadata(itemmeta);
                	    			//		if(Chest != null)
                	    						Chest.setInventorySlotContents(c/3, itemstack);
                	    					
                	    				}
              						}
            	    			}
          					}
              				if(dispenser) {
              					TileEntityDispenser Chest;
              					Chest = (TileEntityDispenser) worldIn.getTileEntity(new BlockPos(par1+x, par2+y + offsety, par3+z));
              					for(int c = 0; c < 27; c = c +3) {
              						String modid = type[7 + c];
                          			String item = type[7 + c + 1];//Integer.parseInt(type[1]);
                          			int itemmeta = Integer.parseInt(type[7 + c + 2]);//Integer.parseInt(type[1]);
              						{
              							ItemStack itemstack = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(modid + ":" + item)));
                	    				if(!itemstack.isEmpty()) {
                	    					itemstack.getItem().getMetadata(itemmeta);
                	    						Chest.setInventorySlotContents(c/3, itemstack);
                	    					
                	    				}
              						}
            	    			}
          					}
            	        }
              		  }
                    }
                }
                }
            	} catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
			
			/*String str;
            for(int num = 0; num < text_read_num; ++num) {// 1行ずつ読み込む
              //System.out.println(str);
          	  String[] type = text_read[num].split(",");
          	  if (type.length != 0)
                {
          		  if(type[0].equals("Block")){
          			String blockd = type[1];
          			String blockid = type[2];//Integer.parseInt(type[1]);
          			int x = Integer.parseInt(type[3]);
          			int y = Integer.parseInt(type[4]);
          			int z = Integer.parseInt(type[5]);
          			int meta = Integer.parseInt(type[6]);
          			Block block;
          			boolean chest = false;
          			if(blockid.equals("tilechest")) {
          				block = (Block)Block.REGISTRY.getObject(new ResourceLocation(blockd + ":" + "chest"));
          				chest = true;
          			}else
          			{
          				block = (Block)Block.REGISTRY.getObject(new ResourceLocation(blockd + ":" + blockid));
          			}
          			if (!worldIn.isRemote && block != null)
        	        {
          			//par1World.setBlock(par1+x, par2+y, par3+z, block,meta,2);
          				worldIn.setBlockState(new BlockPos(par1+x, par2+y + offsety, par3+z), block.getStateFromMeta(meta), 2);
          				if(chest) {
      						TileEntityChest Chest;
          					Chest = (TileEntityChest) worldIn.getTileEntity(new BlockPos(par1+x, par2+y + offsety, par3+z));
          					for(int c = 0; c < 78; c = c +3) {
          						//int it = Integer.parseInt(type[7 + c]);
          						String modid = type[7 + c];
                      			String item = type[7 + c + 1];//Integer.parseInt(type[1]);
                      			int itemmeta = Integer.parseInt(type[7 + c + 2]);//Integer.parseInt(type[1]);
          						//if(it != 0) 
          						{
          							ItemStack itemstack = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(modid + ":" + item)));
            	    				if(!itemstack.isEmpty()) {
            	    					itemstack.getItem().getMetadata(itemmeta);
            	    			//		if(Chest != null)
            	    						Chest.setInventorySlotContents(c/3, itemstack);
            	    					
            	    				}
          						}
        	    			}
      					}
        	        }
          		  }
                }
            }*/
    	}
    	worldIn.setBlockState(new BlockPos(par1+0 + 0, par2+0, par3+0), Blocks.AIR.getDefaultState(), 2);
    	//System.out.println(String.format("HMGGVC-" + txt));
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
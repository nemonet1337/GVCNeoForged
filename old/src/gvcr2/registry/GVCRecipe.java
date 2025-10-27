package gvcr2.registry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GVCRecipe {

	public static int addrecipe = 0;
	public static Item[] item1 = new Item[1024];
	public static Item[] item2 = new Item[1024];
	public static Item[] item3 = new Item[1024];
	public static Item[] item4 = new Item[1024];
	public static Item[] item5 = new Item[1024];
	public static Item[] item6 = new Item[1024];
	public static Item[] item7 = new Item[1024];
	public static Item[] item8 = new Item[1024];
	public static Item[] item9 = new Item[1024];
	
	public static Item[] item0 = new Item[1024];
	public static int[] item0_kazu = new int[1024];
	
	
	public GVCRecipe() {
		
	}
	
	public static void setRecipe(int id, String recipename, String group, Block item_0, int kazu, 
			Item item_1 , Item item_2, Item item_3
			, Item item_4, Item item_5, Item item_6
			, Item item_7, Item item_8, Item item_9) {
		setRecipe(id, recipename, group, Item.getItemFromBlock(item_0), kazu, 
				item_1, item_2, item_3, 
				item_4, item_5, item_6, 
				item_7, item_8, item_9);
	}
	
	public static void setRecipe(int id, String recipename, String group, Item item_0, int kazu, 
			Item item_1 , Item item_2, Item item_3
			, Item item_4, Item item_5, Item item_6
			, Item item_7, Item item_8, Item item_9) {
		
		if(item_3 == null &&  item_6 == null 
				&& item_7 == null && item_8 == null && item_9 == null) {
			if(item_1 == null)item_1 = Items.AIR;
			if(item_2 == null)item_2 = Items.AIR;
			if(item_4 == null)item_4 = Items.AIR;
			if(item_5 == null)item_5 = Items.AIR;
			GameRegistry.addShapedRecipe(new ResourceLocation(recipename),
	                new ResourceLocation(group),
	                new ItemStack(item_0, kazu), new Object[]{
					/*"cd",
					"dc",
					'd', Blocks.DIRT,
					'c', Items.COAL*/
	                		"ab",
	                		"de",
	                		'a', item_1,
	                		'b', item_2,
	                		'd', item_4,
	                		'e', item_5,
				 });
			//addrecipe = id;
			item0[id] = item_0;
			item0_kazu[id] = kazu;
			item1[id] = item_1;
			item2[id] = item_2;
			item4[id] = item_4;
			item5[id] = item_5;
		}else if(item_7 == null && item_8 == null && item_9 == null) {
			if(item_1 == null)item_1 = Items.AIR;
			if(item_2 == null)item_2 = Items.AIR;
			if(item_3 == null)item_3 = Items.AIR;
			if(item_4 == null)item_4 = Items.AIR;
			if(item_5 == null)item_5 = Items.AIR;
			if(item_6 == null)item_6 = Items.AIR;
			GameRegistry.addShapedRecipe(new ResourceLocation(recipename),
	                new ResourceLocation(group),
	                new ItemStack(item_0, kazu), new Object[]{
					/*"cd",
					"dc",
					'd', Blocks.DIRT,
					'c', Items.COAL*/
	                		"abc",
	                		"def",
	                		'a', item_1,
	                		'b', item_2,
	                		'c', item_3,
	                		'd', item_4,
	                		'e', item_5,
	                		'f', item_6,
				 });
			//addrecipe = id;
			item0[id] = item_0;
			item0_kazu[id] = kazu;
			item1[id] = item_1;
			item2[id] = item_2;
			item3[id] = item_3;
			item4[id] = item_4;
			item5[id] = item_5;
			item6[id] = item_6;
		}else {
			if(item_1 == null)item_1 = Items.AIR;
			if(item_2 == null)item_2 = Items.AIR;
			if(item_3 == null)item_3 = Items.AIR;
			if(item_4 == null)item_4 = Items.AIR;
			if(item_5 == null)item_5 = Items.AIR;
			if(item_6 == null)item_6 = Items.AIR;
			if(item_7 == null)item_7 = Items.AIR;
			if(item_8 == null)item_8 = Items.AIR;
			if(item_9 == null)item_9 = Items.AIR;
			GameRegistry.addShapedRecipe(new ResourceLocation(recipename),
	                new ResourceLocation(group),
	                new ItemStack(item_0, kazu), new Object[]{
					/*"cd",
					"dc",
					'd', Blocks.DIRT,
					'c', Items.COAL*/
	                		"abc",
	                		"def",
	                		"ghi",
	                		'a', item_1,
	                		'b', item_2,
	                		'c', item_3,
	                		'd', item_4,
	                		'e', item_5,
	                		'f', item_6,
	                		'g', item_7,
	                		'h', item_8,
	                		'i', item_9
				 });
			//addrecipe = id;
			item0[id] = item_0;
			item0_kazu[id] = kazu;
			item1[id] = item_1;
			item2[id] = item_2;
			item3[id] = item_3;
			item4[id] = item_4;
			item5[id] = item_5;
			item6[id] = item_6;
			item7[id] = item_7;
			item8[id] = item_8;
			item9[id] = item_9;
		}
		
		
		
		
	}
	
	public static Item[] item_input = new Item[1024];
	public static ItemStack[] item_output = new ItemStack[1024];
	
	public static void setSmelting(int id,  Block item_in, ItemStack item_out , float ex) {
		setSmelting(id, Item.getItemFromBlock(item_in), item_out, ex);
	}
	
	public static void setSmelting(int id,  Item item_in, ItemStack item_out , float ex) {
		GameRegistry.addSmelting(item_in, item_out, ex);
		item_input[id] = item_in;
		item_output[id] = item_out;
	}
}

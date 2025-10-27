package gvcr2.registry;

import gvcr2.mod_GVCR2;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GVCR2RecipeRegistrys_level {
	public static void recipe(int level){
		int D = Short.MAX_VALUE;
		
		mod_GVCR2 mod = mod_GVCR2.INSTANCE;
		
		if(level >= 5) {
			
		}
		if(level >= 3) {
			GameRegistry.addShapedRecipe(new ResourceLocation("gvcr2_block_guncrafter_2"),
	                new ResourceLocation(mod.MOD_ID),
	                new ItemStack(mod.gvcr2_block_guncrafter_2, 1), new Object[]{
					"iii",
					"isi",
					"iii",
					's', mod.gvcr2_block_guncrafter_1,
					'i', Items.IRON_INGOT
				 });
		}
		
		
	}
}
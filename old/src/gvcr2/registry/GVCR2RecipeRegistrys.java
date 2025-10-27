package gvcr2.registry;

import gvcr2.mod_GVCR2;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GVCR2RecipeRegistrys {
	public static void recipe(){
		int D = Short.MAX_VALUE;
		
		mod_GVCR2 mod = mod_GVCR2.INSTANCE;
		
		{
			/*GameRegistry.addShapedRecipe(new ResourceLocation("relief_gunpowder"),
	                new ResourceLocation(mod.MOD_ID),
	                new ItemStack(Items.GUNPOWDER, 1), new Object[]{
					"cd",
					"dc",
					'd', Blocks.DIRT,
					'c', Items.COAL
				 });
			//GVCRecipe.setRecipe();
			GVCRecipe recipe = new GVCRecipe();
			recipe.item1[0] = Items.COAL;
			recipe.item2[0] = new ItemBlock(Blocks.DIRT);
			recipe.item4[0] = new ItemBlock(Blocks.DIRT);
			recipe.item5[0] = Items.COAL;
			recipe.item0[0] = Items.GUNPOWDER;
			++recipe.addrecipe;*/
			GVCRecipe.setRecipe(0, "relief_gunpowder2", mod.MOD_ID, Items.GUNPOWDER, 1,
					Items.COAL, Item.getItemFromBlock(Blocks.DIRT), null,
					Item.getItemFromBlock(Blocks.DIRT), Items.COAL, null,
					null, null, null);
		}
		
		/*GameRegistry.addShapedRecipe(new ResourceLocation("gvcr2_item_pra"),
                new ResourceLocation(mod.MOD_ID),
                new ItemStack(mod.gvcr2_item_pra, 2), new Object[]{
				"gig",
				'g', Blocks.GLASS,
				'i', Items.IRON_INGOT
			 });
		GVCRecipe recipe = new GVCRecipe();
		recipe.item1[1] = new ItemBlock(Blocks.GLASS);
		recipe.item2[1] = Items.IRON_INGOT;
		recipe.item3[1] = new ItemBlock(Blocks.GLASS);
		recipe.item0[1] = mod.gvcr2_item_pra;*/
		GVCRecipe.setRecipe(1, "gvcr2_item_pra", mod.MOD_ID, mod.gvcr2_item_pra, 2,
				Item.getItemFromBlock(Blocks.GLASS), Items.IRON_INGOT, Item.getItemFromBlock(Blocks.GLASS),
				null, null, null,
				null, null, null);
		
		/*GameRegistry.addShapedRecipe(new ResourceLocation("gvcr2_item_pad"),
                new ResourceLocation(mod.MOD_ID),
                new ItemStack(mod.gvcr2_item_pad, 1), new Object[]{
				"pp",
				"gg",
				"pp",
				'g', Blocks.GLASS,
				'p', mod.gvcr2_item_pra
			 });*/
		GVCRecipe.setRecipe(2, "gvcr2_item_pad", mod.MOD_ID, mod.gvcr2_item_pad, 1,
				Item.getItemFromBlock(Blocks.GLASS), Item.getItemFromBlock(Blocks.GLASS), null,
				mod.gvcr2_item_pra, mod.gvcr2_item_pra, null,
				Item.getItemFromBlock(Blocks.GLASS), Item.getItemFromBlock(Blocks.GLASS), null);
		
		/*GameRegistry.addShapedRecipe(new ResourceLocation("gvcr2_item_wrench"),
                new ResourceLocation(mod.MOD_ID),
                new ItemStack(mod.gvcr2_item_wrench, 1), new Object[]{
				" p ",
				"pp ",
				"  p",
				'p', mod.gvcr2_item_pra
			 });*/
		GVCRecipe.setRecipe(3, "gvcr2_item_wrench", mod.MOD_ID, mod.gvcr2_item_wrench, 1,
				null, mod.gvcr2_item_pra, null,
				mod.gvcr2_item_pra, mod.gvcr2_item_pra, null,
				null, null, mod.gvcr2_item_pra);
		
		/*GameRegistry.addShapedRecipe(new ResourceLocation("gvcr2_item_binoculars"),
                new ResourceLocation(mod.MOD_ID),
                new ItemStack(mod.gvcr2_item_binoculars, 1), new Object[]{
				"pgp",
				'g', Blocks.GLASS,
				'p', mod.gvcr2_item_pra
			 });*/
		GVCRecipe.setRecipe(4, "gvcr2_item_binoculars", mod.MOD_ID, mod.gvcr2_item_binoculars, 1,
				Item.getItemFromBlock(Blocks.GLASS), mod.gvcr2_item_pra, Item.getItemFromBlock(Blocks.GLASS),
				null, null, null,
				null, null, null);
		
		/*GameRegistry.addShapedRecipe(new ResourceLocation("gvcr2_item_bandage"),
                new ResourceLocation(mod.MOD_ID),
                new ItemStack(mod.gvcr2_item_bandage, 1), new Object[]{
				"sbs",
				's', Items.STRING,
				'b', Items.STICK
			 });*/
		GVCRecipe.setRecipe(5, "gvcr2_item_bandage", mod.MOD_ID, mod.gvcr2_item_bandage, 1,
				Items.STRING, Items.STICK, Items.STRING,
				null, null, null,
				null, null, null);
		
		/*GameRegistry.addShapedRecipe(new ResourceLocation("gvcr2_item_bandage2"),
                new ResourceLocation(mod.MOD_ID),
                new ItemStack(mod.gvcr2_item_bandage, 4), new Object[]{
				"sbs",
				's', Blocks.WOOL,
				'b', Items.STICK
			 });*/
		GVCRecipe.setRecipe(6, "gvcr2_item_bandage2", mod.MOD_ID, mod.gvcr2_item_bandage, 4,
				Item.getItemFromBlock(Blocks.WOOL), Items.STICK, Item.getItemFromBlock(Blocks.WOOL),
				null, null, null,
				null, null, null);
		
		/*GameRegistry.addShapedRecipe(new ResourceLocation("gvcr2_item_cm"),
                new ResourceLocation(mod.MOD_ID),
                new ItemStack(mod.gvcr2_item_cm, 1), new Object[]{
				"ppp",
				"aaa",
				"ppp",
				'p', Items.PAPER,
				'a', Items.APPLE
			 });*/
		GVCRecipe.setRecipe(7, "gvcr2_item_cm", mod.MOD_ID, mod.gvcr2_item_cm, 2,
				Items.PAPER, Items.PAPER, Items.PAPER,
				Items.APPLE, Items.APPLE, Items.APPLE,
				Items.PAPER, Items.PAPER, Items.PAPER);
		
		/*GameRegistry.addShapedRecipe(new ResourceLocation("gvcr2_block_guncrafter_1"),
                new ResourceLocation(mod.MOD_ID),
                new ItemStack(mod.gvcr2_block_guncrafter_1, 1), new Object[]{
				"isi",
				"iii",
				's', mod.gvcr2_item_scrap,
				'i', Items.IRON_INGOT
			 });*/
		GVCRecipe.setRecipe(8, "gvcr2_item_aed", mod.MOD_ID, mod.gvcr2_item_aed, 1,
				mod.gvcr2_item_pra, null, mod.gvcr2_item_pra,
				Items.IRON_INGOT, null, Items.IRON_INGOT,
				null, null, null);
		
		GVCRecipe.setRecipe(9, "gvcr2_item_weapon_change", mod.MOD_ID, mod.gvcr2_item_weapon_change, 1,
				mod.gvcr2_item_scrap, mod.gvcr2_item_scrap, mod.gvcr2_item_scrap,
				mod.gvcr2_item_scrap, mod.gvcr2_item_wrench, mod.gvcr2_item_scrap,
				mod.gvcr2_item_scrap, mod.gvcr2_item_scrap, mod.gvcr2_item_scrap);
		
		GVCRecipe.setRecipe(10, "gvcr2_grenade_frag", mod.MOD_ID, mod.gvcr2_grenade_frag, 1,
				Items.STICK, Items.STICK, null,
				Items.GUNPOWDER, Items.GUNPOWDER, null,
				null, null, null);
		
		GVCRecipe.setRecipe(11, "gvcr2_grenade_flame", mod.MOD_ID, mod.gvcr2_grenade_flame, 1,
				mod.gvcr2_grenade_frag, Items.COAL, null,
				null, null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(12, "gvcr2_grenade_smoke", mod.MOD_ID, mod.gvcr2_grenade_smoke, 1,
				mod.gvcr2_grenade_frag, Items.FLINT, null,
				null, null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(13, "gvcr2_grenade_impact", mod.MOD_ID, mod.gvcr2_grenade_impact, 1,
				mod.gvcr2_grenade_frag, Items.GLOWSTONE_DUST, null,
				null, null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(14, "gvcr2_grenade_atgrenade", mod.MOD_ID, mod.gvcr2_grenade_atgrenade, 1,
				mod.gvcr2_grenade_frag, mod.gvcr2_grenade_frag, mod.gvcr2_grenade_frag,
				null, null, null,
				null, null, null);
		
		
		GVCRecipe.setRecipe(15, "gvcr2_bullet_50calrf", mod.MOD_ID, mod.gvcr2_bullet_50calrf, 1,
				mod.gvcr2_bullet_30calrf, mod.gvcr2_bullet_30calrf, mod.gvcr2_bullet_30calrf,
				mod.gvcr2_bullet_30calrf, mod.gvcr2_bullet_30calrf, mod.gvcr2_bullet_30calrf,
				mod.gvcr2_bullet_30calrf, mod.gvcr2_bullet_30calrf, mod.gvcr2_bullet_30calrf);
		
		GVCRecipe.setRecipe(16, "gvcr2_bullet_40mmgl", mod.MOD_ID, mod.gvcr2_bullet_40mmgl, 1,
				mod.gvcr2_bullet_84mmrl, null, null,
				null, null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(17, "gvcr2_bullet_76mmrl", mod.MOD_ID, mod.gvcr2_bullet_76mmrl, 1,
				mod.gvcr2_bullet_84mmrl, mod.gvcr2_bullet_84mmrl, null,
				null, null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(18, "gvcr2_bullet_76mmml", mod.MOD_ID, mod.gvcr2_bullet_76mmml, 4,
				null, mod.gvcr2_bullet_76mmrl, null,
				mod.gvcr2_bullet_76mmrl, Items.REDSTONE, mod.gvcr2_bullet_76mmrl,
				null, mod.gvcr2_bullet_76mmrl, null);
		
		
		
		GVCRecipe.setRecipe(20, "gvcr2_block_mine", mod.MOD_ID, mod.gvcr2_block_mine, 1,
				mod.gvcr2_grenade_frag, null, null,
				Item.getItemFromBlock(Blocks.COBBLESTONE), null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(21, "gvcr2_block_atmine", mod.MOD_ID, mod.gvcr2_block_atmine, 1,
				Item.getItemFromBlock(mod.gvcr2_block_mine), Item.getItemFromBlock(mod.gvcr2_block_mine), Item.getItemFromBlock(mod.gvcr2_block_mine),
				null, null, null,
				null, null, null);
		
		
		GVCRecipe.setRecipe(25, "gvcr2_block_gunrack_hsin", mod.MOD_ID, mod.gvcr2_block_gunrack_hsin, 1,
				Item.getItemFromBlock(Blocks.IRON_BARS), Item.getItemFromBlock(Blocks.IRON_BARS), Item.getItemFromBlock(Blocks.IRON_BARS),
				Item.getItemFromBlock(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE), Item.getItemFromBlock(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE), Item.getItemFromBlock(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE),
				null, null, null);
		
		GVCRecipe.setRecipe(26, "gvcr2_block_gunrack_rsin", mod.MOD_ID, mod.gvcr2_block_gunrack_rsin, 1,
				Item.getItemFromBlock(Blocks.IRON_BARS), Item.getItemFromBlock(Blocks.IRON_BARS), Item.getItemFromBlock(Blocks.IRON_BARS),
				Item.getItemFromBlock(Blocks.IRON_BARS), Item.getItemFromBlock(Blocks.IRON_BARS), Item.getItemFromBlock(Blocks.IRON_BARS),
				Item.getItemFromBlock(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE), Item.getItemFromBlock(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE), Item.getItemFromBlock(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE));
		
		GVCRecipe.setRecipe(27, "gvcr2_block_gunrack_rswn", mod.MOD_ID, mod.gvcr2_block_gunrack_rswn, 1,
				Item.getItemFromBlock(Blocks.FURNACE), Item.getItemFromBlock(Blocks.FURNACE), Item.getItemFromBlock(Blocks.FURNACE),
				Item.getItemFromBlock(Blocks.FURNACE), Item.getItemFromBlock(Blocks.FURNACE), Item.getItemFromBlock(Blocks.FURNACE),
				Item.getItemFromBlock(Blocks.WOODEN_PRESSURE_PLATE), Item.getItemFromBlock(Blocks.WOODEN_PRESSURE_PLATE), Item.getItemFromBlock(Blocks.WOODEN_PRESSURE_PLATE));
		
		GVCRecipe.setRecipe(28, "gvcr2_block_gunrack_hti", mod.MOD_ID, mod.gvcr2_block_gunrack_hti, 1,
				Item.getItemFromBlock(Blocks.IRON_BARS), Item.getItemFromBlock(Blocks.IRON_BARS), null,
				Item.getItemFromBlock(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE), Item.getItemFromBlock(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE), null,
				null, null, null);
		
		GVCRecipe.setRecipe(29, "gvcr2_block_gunrack_rti1", mod.MOD_ID, mod.gvcr2_block_gunrack_rti1, 1,
				Item.getItemFromBlock(Blocks.IRON_BARS), null, Item.getItemFromBlock(Blocks.IRON_BARS),
				Item.getItemFromBlock(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE), null, Item.getItemFromBlock(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE),
				null, null, null);
		
		GVCRecipe.setRecipe(201, "gvcr2_block_gunrack_rti2", mod.MOD_ID, mod.gvcr2_block_gunrack_rti2, 1,
				Item.getItemFromBlock(mod.gvcr2_block_gunrack_rti1), null, null,
				Item.getItemFromBlock(mod.gvcr2_block_gunrack_rti1), null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(202, "gvcr2_block_fslight", mod.MOD_ID, mod.gvcr2_block_fslight, 1,
				Item.getItemFromBlock(Blocks.IRON_BARS), Items.GLOWSTONE_DUST, Item.getItemFromBlock(Blocks.IRON_BARS),
				null, null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(203, "gvcr2_block_ghostlight_tile", mod.MOD_ID, mod.gvcr2_block_ghostlight_tile, 2,
				Item.getItemFromBlock(Blocks.SOUL_SAND), Item.getItemFromBlock(mod.gvcr2_block_fslight), Item.getItemFromBlock(Blocks.SOUL_SAND),
				null, null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(555, "gvcr2_block_flag_so_playerbase", mod.MOD_ID, mod.gvcr2_block_flag_so_playerbase, 1,
				mod.gvcr2_item_pra, mod.gvcr2_item_pra, mod.gvcr2_item_pra,
				mod.gvcr2_item_pra, mod.gvcr2_gun_m16a1, mod.gvcr2_item_pra,
				mod.gvcr2_item_pra, mod.gvcr2_item_pra, mod.gvcr2_item_pra);
		
		GVCRecipe.setRecipe(204, "gvcr2_block_scaffold", mod.MOD_ID, mod.gvcr2_block_scaffold, 16,
				Item.getItemFromBlock(Blocks.IRON_BARS), Item.getItemFromBlock(Blocks.IRON_BARS), Item.getItemFromBlock(Blocks.IRON_BARS),
				Items.IRON_INGOT, null, Items.IRON_INGOT,
				Item.getItemFromBlock(Blocks.IRON_BARS), Item.getItemFromBlock(Blocks.IRON_BARS), Item.getItemFromBlock(Blocks.IRON_BARS));
		
		
		
		
		GVCRecipe.setRecipe(35, "gvcr2_block_bulletcrafter_1", mod.MOD_ID, mod.gvcr2_block_bulletcrafter_1, 1,
				mod.gvcr2_item_scrap, mod.gvcr2_item_scrap, mod.gvcr2_item_scrap,
				Item.getItemFromBlock(Blocks.COBBLESTONE), Item.getItemFromBlock(Blocks.COBBLESTONE), Item.getItemFromBlock(Blocks.COBBLESTONE),
				null, null, null);
		
		GVCRecipe.setRecipe(30, "gvcr2_block_guncrafter_1", mod.MOD_ID, mod.gvcr2_block_guncrafter_1, 1,
				Item.getItemFromBlock(Blocks.COBBLESTONE), mod.gvcr2_item_scrap, Items.IRON_INGOT,
				Item.getItemFromBlock(Blocks.COBBLESTONE), Item.getItemFromBlock(Blocks.COBBLESTONE), Item.getItemFromBlock(Blocks.COBBLESTONE),
				null, null, null);
		
		GVCRecipe.setRecipe(31, "gvcr2_block_guncrafter_2", mod.MOD_ID, mod.gvcr2_block_guncrafter_2, 1,
				Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT,
				Items.IRON_INGOT, Item.getItemFromBlock(mod.gvcr2_block_guncrafter_1), Items.IRON_INGOT,
				Item.getItemFromBlock(Blocks.IRON_BLOCK), Item.getItemFromBlock(Blocks.IRON_BLOCK), Item.getItemFromBlock(Blocks.IRON_BLOCK));
		
		GVCRecipe.setRecipe(32, "gvcr2_block_guncrafter_3", mod.MOD_ID, mod.gvcr2_block_guncrafter_3, 1,
				mod.gvcr2_item_pra, mod.gvcr2_item_pra, Item.getItemFromBlock(Blocks.QUARTZ_BLOCK),
				mod.gvcr2_item_pra, Item.getItemFromBlock(mod.gvcr2_block_guncrafter_2), Item.getItemFromBlock(Blocks.QUARTZ_BLOCK),
				Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT);
		
		
		GVCRecipe.setRecipe(40, "gvcr2_block_vehiclecrafter_1", mod.MOD_ID, mod.gvcr2_block_vehiclecrafter_1, 1,
				Items.EMERALD, Items.EMERALD, Items.EMERALD,
				Items.EMERALD, Item.getItemFromBlock(mod.gvcr2_block_guncrafter_1), Items.EMERALD,
				Item.getItemFromBlock(Blocks.COBBLESTONE), Item.getItemFromBlock(Blocks.COBBLESTONE), Item.getItemFromBlock(Blocks.COBBLESTONE));
		
		GVCRecipe.setRecipe(41, "gvcr2_block_vehiclecrafter_2", mod.MOD_ID, mod.gvcr2_block_vehiclecrafter_2, 1,
				Items.EMERALD, Items.EMERALD, Items.EMERALD,
				Items.EMERALD, Item.getItemFromBlock(mod.gvcr2_block_vehiclecrafter_1), Items.EMERALD,
				Item.getItemFromBlock(Blocks.EMERALD_BLOCK), Item.getItemFromBlock(Blocks.EMERALD_BLOCK), Item.getItemFromBlock(Blocks.EMERALD_BLOCK));
		
		GVCRecipe.setRecipe(42, "gvcr2_block_vehiclecrafter_3", mod.MOD_ID, mod.gvcr2_block_vehiclecrafter_3, 1,
				Items.DIAMOND, Items.DIAMOND, Items.DIAMOND,
				Items.DIAMOND, Item.getItemFromBlock(mod.gvcr2_block_vehiclecrafter_2), Items.DIAMOND,
				Item.getItemFromBlock(Blocks.DIAMOND_BLOCK), Item.getItemFromBlock(Blocks.DIAMOND_BLOCK), Item.getItemFromBlock(Blocks.DIAMOND_BLOCK));
		
		
		
		GVCRecipe.setRecipe(50, "gvcr2_item_squad_cn", mod.MOD_ID, mod.gvcr2_item_squad_cn, 1,
				mod.gvcr2_item_pad, null, null,
				mod.gvcr2_spawn_pmc_s, null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(51, "gvcr2_spawn_pmc_s", mod.MOD_ID, mod.gvcr2_spawn_pmc_s, 1,
				null, mod.gvcr2_item_pra, null,
				null, Items.EGG, null,
				null, null, null);
		
		GVCRecipe.setRecipe(52, "gvcr2_item_stars", mod.MOD_ID, mod.gvcr2_item_stars, 1,
				Item.getItemFromBlock(Blocks.WOOL), Item.getItemFromBlock(Blocks.WOOL), Item.getItemFromBlock(Blocks.WOOL),
				Item.getItemFromBlock(Blocks.WOOL), mod.gvcr2_item_pra, Item.getItemFromBlock(Blocks.WOOL),
				null, mod.gvcr2_item_pra, null);
		
		
		GVCRecipe.setRecipe(80, "gvcr2_armor_prahelmet", mod.MOD_ID, mod.gvcr2_armor_prahelmet, 1,
				mod.gvcr2_item_pra, mod.gvcr2_item_pra, mod.gvcr2_item_pra,
				mod.gvcr2_item_pra, null, mod.gvcr2_item_pra,
				null, null, null);
		
		GVCRecipe.setRecipe(81, "gvcr2_armor_prachest", mod.MOD_ID, mod.gvcr2_armor_prachest, 1,
				mod.gvcr2_item_pra, null, mod.gvcr2_item_pra,
				mod.gvcr2_item_pra, mod.gvcr2_item_pra, mod.gvcr2_item_pra,
				mod.gvcr2_item_pra, mod.gvcr2_item_pra, mod.gvcr2_item_pra);
		
		GVCRecipe.setRecipe(82, "gvcr2_armor_praleggings", mod.MOD_ID, mod.gvcr2_armor_praleggings, 1,
				mod.gvcr2_item_pra, mod.gvcr2_item_pra, mod.gvcr2_item_pra,
				mod.gvcr2_item_pra, null, mod.gvcr2_item_pra,
				mod.gvcr2_item_pra, null, mod.gvcr2_item_pra);
		
		GVCRecipe.setRecipe(83, "gvcr2_armor_praboots", mod.MOD_ID, mod.gvcr2_armor_praboots, 1,
				mod.gvcr2_item_pra, null, mod.gvcr2_item_pra,
				mod.gvcr2_item_pra, null, mod.gvcr2_item_pra,
				null, null, null);
		
		GVCRecipe.setRecipe(84, "gvcr2_armor_camouflage_head", mod.MOD_ID, mod.gvcr2_armor_camouflage_head, 1,
				Item.getItemFromBlock(Blocks.LEAVES), Item.getItemFromBlock(Blocks.LEAVES), Item.getItemFromBlock(Blocks.LEAVES),
				Item.getItemFromBlock(Blocks.LEAVES), Items.LEATHER_HELMET, Item.getItemFromBlock(Blocks.LEAVES),
				Item.getItemFromBlock(Blocks.LEAVES), Item.getItemFromBlock(Blocks.LEAVES), Item.getItemFromBlock(Blocks.LEAVES));
		
		GVCRecipe.setRecipe(85, "gvcr2_armor_camouflage_body", mod.MOD_ID, mod.gvcr2_armor_camouflage_body, 1,
				Item.getItemFromBlock(Blocks.LEAVES), Item.getItemFromBlock(Blocks.LEAVES), Item.getItemFromBlock(Blocks.LEAVES),
				Item.getItemFromBlock(Blocks.LEAVES), Items.LEATHER_CHESTPLATE, Item.getItemFromBlock(Blocks.LEAVES),
				Item.getItemFromBlock(Blocks.LEAVES), Item.getItemFromBlock(Blocks.LEAVES), Item.getItemFromBlock(Blocks.LEAVES));
		
		GVCRecipe.setRecipe(86, "gvcr2_armor_camouflage_leggings", mod.MOD_ID, mod.gvcr2_armor_camouflage_leggings, 1,
				Item.getItemFromBlock(Blocks.LEAVES), Item.getItemFromBlock(Blocks.LEAVES), Item.getItemFromBlock(Blocks.LEAVES),
				Item.getItemFromBlock(Blocks.LEAVES), Items.LEATHER_LEGGINGS, Item.getItemFromBlock(Blocks.LEAVES),
				Item.getItemFromBlock(Blocks.LEAVES), Item.getItemFromBlock(Blocks.LEAVES), Item.getItemFromBlock(Blocks.LEAVES));
		
		GVCRecipe.setRecipe(87, "gvcr2_armor_camouflage_boots", mod.MOD_ID, mod.gvcr2_armor_camouflage_boots, 1,
				Item.getItemFromBlock(Blocks.LEAVES), Item.getItemFromBlock(Blocks.LEAVES), Item.getItemFromBlock(Blocks.LEAVES),
				Item.getItemFromBlock(Blocks.LEAVES), Items.LEATHER_BOOTS, Item.getItemFromBlock(Blocks.LEAVES),
				Item.getItemFromBlock(Blocks.LEAVES), Item.getItemFromBlock(Blocks.LEAVES), Item.getItemFromBlock(Blocks.LEAVES));
		
		
		
		
		
		GVCRecipe.setRecipe(100, "gvcr2_gun_m16a2", mod.MOD_ID, mod.gvcr2_gun_m16a2, 1,
				mod.gvcr2_gun_m16a1, mod.gvcr2_gun_m16a1, null,
				mod.gvcr2_gun_m16a1, mod.gvcr2_gun_m16a1, null,
				null, null, null);
		
		GVCRecipe.setRecipe(101, "gvcr2_gun_m16a4", mod.MOD_ID, mod.gvcr2_gun_m16a4, 1,
				mod.gvcr2_gun_m16a2, mod.gvcr2_gun_m16a2, null,
				mod.gvcr2_gun_m16a2, mod.gvcr2_gun_m16a2, null,
				null, null, null);
		
		GVCRecipe.setRecipe(102, "gvcr2_gun_m4", mod.MOD_ID, mod.gvcr2_gun_m4, 1,
				mod.gvcr2_gun_m16a2, null, null,
				null, null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(103, "gvcr2_gun_m4a1", mod.MOD_ID, mod.gvcr2_gun_m4a1, 1,
				mod.gvcr2_gun_m16a4, null, null,
				null, null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(110, "gvcr2_gun_ak74", mod.MOD_ID, mod.gvcr2_gun_ak74, 1,
				mod.gvcr2_gun_ak47, mod.gvcr2_gun_ak47, null,
				mod.gvcr2_gun_ak47, mod.gvcr2_gun_ak47, null,
				null, null, null);
		
		GVCRecipe.setRecipe(111, "gvcr2_gun_ak12", mod.MOD_ID, mod.gvcr2_gun_ak12, 1,
				mod.gvcr2_gun_ak74, mod.gvcr2_gun_ak74, null,
				mod.gvcr2_gun_ak74, mod.gvcr2_gun_ak74, null,
				null, null, null);
		
		GVCRecipe.setRecipe(112, "gvcr2_gun_aks74u", mod.MOD_ID, mod.gvcr2_gun_aks74u, 1,
				mod.gvcr2_gun_ak74, null, null,
				null, null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(113, "gvcr2_gun_g36c", mod.MOD_ID, mod.gvcr2_gun_g36c, 1,
				mod.gvcr2_gun_g36, null, null,
				null, null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(114, "gvcr2_gun_m93r", mod.MOD_ID, mod.gvcr2_gun_m93r, 1,
				mod.gvcr2_gun_m9, mod.gvcr2_gun_m9, null,
				mod.gvcr2_gun_m9, mod.gvcr2_gun_m9, null,
				null, null, null);
		
		GVCRecipe.setRecipe(115, "gvcr2_gun_rpk47", mod.MOD_ID, mod.gvcr2_gun_rpk47, 1,
				mod.gvcr2_gun_ak47, Items.IRON_INGOT, null,
				Items.IRON_INGOT, Items.IRON_INGOT, null,
				null, null, null);
		
		GVCRecipe.setRecipe(116, "gvcr2_gun_pkm", mod.MOD_ID, mod.gvcr2_gun_pkm, 1,
				mod.gvcr2_gun_ak47, Item.getItemFromBlock(Blocks.IRON_BLOCK), null,
				null, null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(117, "gvcr2_gun_pkp", mod.MOD_ID, mod.gvcr2_gun_pkp, 1,
				mod.gvcr2_gun_pkm, mod.gvcr2_gun_pkm, null,
				mod.gvcr2_gun_pkm, mod.gvcr2_gun_pkm, null,
				null, null, null);
		
		GVCRecipe.setRecipe(118, "gvcr2_gun_m63", mod.MOD_ID, mod.gvcr2_gun_m63, 1,
				mod.gvcr2_gun_m16a1, mod.gvcr2_gun_m60, null,
				null, null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(119, "gvcr2_gun_svd", mod.MOD_ID, mod.gvcr2_gun_svd, 1,
				mod.gvcr2_gun_ak47, mod.gvcr2_am_scope, null,
				null, null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(120, "gvcr2_gun_saiga12", mod.MOD_ID, mod.gvcr2_gun_saiga12, 1,
				mod.gvcr2_gun_ak47, mod.gvcr2_gun_m870, null,
				null, null, null,
				null, null, null);
		
		GVCRecipe.setRecipe(121, "gvcr2_gun_mp5", mod.MOD_ID, mod.gvcr2_gun_mp5, 1,
				mod.gvcr2_gun_g3a3, null, null,
				null, null, null,
				null, null, null);
		
		
		GVCRecipe.setRecipe(150, "gvcr2_item_request_airstrike2", mod.MOD_ID, mod.gvcr2_item_request_airstrike2, 1,
				mod.gvcr2_item_request_airstrike1, mod.gvcr2_item_request_airstrike1, null,
				mod.gvcr2_item_request_airstrike1, mod.gvcr2_item_request_airstrike1, null,
				null, null, null);
		
		GVCRecipe.setRecipe(151, "gvcr2_item_request_airstrike3", mod.MOD_ID, mod.gvcr2_item_request_airstrike3, 1,
				mod.gvcr2_item_request_airstrike2, mod.gvcr2_item_request_airstrike2, null,
				mod.gvcr2_item_request_airstrike2, mod.gvcr2_item_request_airstrike2, null,
				null, null, null);
		
		GVCRecipe.setRecipe(152, "gvcr2_item_request_fire2", mod.MOD_ID, mod.gvcr2_item_request_fire2, 1,
				mod.gvcr2_item_request_fire1, mod.gvcr2_item_request_fire1, null,
				mod.gvcr2_item_request_fire1, mod.gvcr2_item_request_fire1, null,
				null, null, null);
		
		GVCRecipe.setRecipe(153, "gvcr2_item_request_fire3", mod.MOD_ID, mod.gvcr2_item_request_fire3, 1,
				mod.gvcr2_item_request_fire2, mod.gvcr2_item_request_fire2, null,
				mod.gvcr2_item_request_fire2, mod.gvcr2_item_request_fire2, null,
				null, null, null);
		
		GVCRecipe.setRecipe(154, "gvcr2_item_request_airborne2", mod.MOD_ID, mod.gvcr2_item_request_airborne2, 1,
				mod.gvcr2_item_request_airborne1, mod.gvcr2_item_request_airborne1, null,
				mod.gvcr2_item_request_airborne1, mod.gvcr2_item_request_airborne1, null,
				null, null, null);
		
		GVCRecipe.setRecipe(155, "gvcr2_item_request_airborne3", mod.MOD_ID, mod.gvcr2_item_request_airborne3, 1,
				mod.gvcr2_item_request_airborne2, mod.gvcr2_item_request_airborne2, null,
				mod.gvcr2_item_request_airborne2, mod.gvcr2_item_request_airborne2, null,
				null, null, null);
		
		GVCRecipe.setRecipe(156, "gvcr2_item_request_missile2", mod.MOD_ID, mod.gvcr2_item_request_missile2, 1,
				mod.gvcr2_item_request_missile1, mod.gvcr2_item_request_missile1, null,
				mod.gvcr2_item_request_missile1, mod.gvcr2_item_request_missile1, null,
				null, null, null);
		
		GVCRecipe.setRecipe(157, "gvcr2_item_request_missile3", mod.MOD_ID, mod.gvcr2_item_request_missile3, 1,
				mod.gvcr2_item_request_missile2, mod.gvcr2_item_request_missile2, null,
				mod.gvcr2_item_request_missile2, mod.gvcr2_item_request_missile2, null,
				null, null, null);
		
		GVCRecipe.setRecipe(158, "gvcr2_item_request_support_fighter2", mod.MOD_ID, mod.gvcr2_item_request_support_fighter2, 1,
				mod.gvcr2_item_request_support_fighter1, mod.gvcr2_item_request_support_fighter1, null,
				mod.gvcr2_item_request_support_fighter1, mod.gvcr2_item_request_support_fighter1, null,
				null, null, null);
		
		GVCRecipe.setRecipe(159, "gvcr2_item_request_support_fighter3", mod.MOD_ID, mod.gvcr2_item_request_support_fighter3, 1,
				mod.gvcr2_item_request_support_fighter2, mod.gvcr2_item_request_support_fighter2, null,
				mod.gvcr2_item_request_support_fighter2, mod.gvcr2_item_request_support_fighter2, null,
				null, null, null);
		
		GVCRecipe.setRecipe(160, "gvcr2_item_request_support_heli2", mod.MOD_ID, mod.gvcr2_item_request_support_heli2, 1,
				mod.gvcr2_item_request_support_heli1, mod.gvcr2_item_request_support_heli1, null,
				mod.gvcr2_item_request_support_heli1, mod.gvcr2_item_request_support_heli1, null,
				null, null, null);
		
		GVCRecipe.setRecipe(161, "gvcr2_item_request_strafing2", mod.MOD_ID, mod.gvcr2_item_request_strafing2, 1,
				mod.gvcr2_item_request_strafing1, mod.gvcr2_item_request_strafing1, null,
				mod.gvcr2_item_request_strafing1, mod.gvcr2_item_request_strafing1, null,
				null, null, null);
		
		//GameRegistry.addSmelting(mod.gvcr2_item_scrap, new ItemStack(Items.IRON_NUGGET), 0.1F);
		GVCRecipe.setSmelting(200, mod.gvcr2_item_scrap, new ItemStack(Items.IRON_NUGGET), 0.1F);
		
		//GVCRecipe.setSmelting(201, Items.IRON_NUGGET, new ItemStack(Items.IRON_INGOT), 0.1F);
		
	}
}

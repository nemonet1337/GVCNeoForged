package gvcr2.world;

import java.util.Random;

import gvcr2.mod_GVCR2;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.BiomeHills;
import net.minecraft.world.biome.BiomeMesa;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeSavanna;
import net.minecraft.world.biome.BiomeSnow;
import net.minecraft.world.biome.BiomeSwamp;
import net.minecraft.world.biome.BiomeTaiga;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenerator_GVCR2_Bullding implements IWorldGenerator {

	public Block ore;
	public int maxh;
	public int minh;
	public int kazu;
	public int kazura;
	public boolean generatorhell;
	public boolean generatorsky;
	//public BiomeGenBase[] biomegenbase;
	public int stack;

	public WorldGenerator_GVCR2_Bullding() {
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		BiomeProvider worldchunkmanager = world.getBiomeProvider();
		if (worldchunkmanager != null) {

			if (world.provider instanceof WorldProviderSurface) {
				this.generateOre(world, random, chunkX << 4, chunkZ << 4);
			}

			if (this.generatorhell) {
				if (world.provider instanceof WorldProviderHell) {
					this.generateOreHell(world, random, chunkX << 4, chunkZ << 4);
				}
			}

			if (this.generatorsky) {
				if (world.provider instanceof WorldProviderEnd) {
					this.generateOreEnd(world, random, chunkX << 4, chunkZ << 4);
				}
			}
		}
	}

	
	/**0=Ocean以外/
	 * 1=Ocean/
	 * 2=暗い森/
	 * 3=砂漠/
	 * 4=寒いところ/
	 * 5=山系/
	 * 6=ジャングル/
	 * 7=沼地/
	 * 8=森/
	 * 9=平原系/
	 * */
	private static boolean getbiome_(World world, BlockPos bp, int id) {
		boolean re = false;
		if(id == 0) {//Ocean以外
			if(world.getBiome(bp) != Biome.getBiome(0) 
					&& world.getBiome(bp) != Biome.getBiome(10) 
					&& world.getBiome(bp) != Biome.getBiome(24))
			{
				re = true;
			}
		}
		if(id == 1) {//Ocean
			if(world.getBiome(bp) == Biome.getBiome(0) 
					|| world.getBiome(bp) == Biome.getBiome(10) 
					|| world.getBiome(bp) == Biome.getBiome(24))
			{
				re = true;
			}
		}
		if(id == 2) {//　暗い森
			if(world.getBiome(bp) == Biome.getBiome(29) 
					|| world.getBiome(bp) == Biome.getBiome(157)
					|| world.getBiome(bp) == Biome.getBiome(1)
					|| world.getBiome(bp) == Biome.getBiome(6)
					)
			{
				re = true;
			}
		}
		if(id == 3) {//　砂漠
			if(world.getBiome(bp) == Biome.getBiome(2) 
					|| world.getBiome(bp) == Biome.getBiome(17)
					|| world.getBiome(bp) == Biome.getBiome(130)
					|| world.getBiome(bp) == Biome.getBiome(6)
					)
			{
				re = true;
			}
		}
		if(id == 4) {//　寒いところ
			if(world.getBiome(bp) == Biome.getBiome(12) 
					|| world.getBiome(bp) == Biome.getBiome(140)
					|| world.getBiome(bp) == Biome.getBiome(30)
					|| world.getBiome(bp) == Biome.getBiome(158)
					|| world.getBiome(bp) == Biome.getBiome(11)
					|| world.getBiome(bp) == Biome.getBiome(26)
					|| world.getBiome(bp) == Biome.getBiome(13)
					|| world.getBiome(bp) == Biome.getBiome(31)
					)
			{
				re = true;
			}
		}
		if(id == 5) {//　山系
			if(world.getBiome(bp) == Biome.getBiome(3) 
					|| world.getBiome(bp) == Biome.getBiome(131)
					|| world.getBiome(bp) == Biome.getBiome(34)
					|| world.getBiome(bp) == Biome.getBiome(162)
					|| world.getBiome(bp) == Biome.getBiome(5)
					|| world.getBiome(bp) == Biome.getBiome(133)
					|| world.getBiome(bp) == Biome.getBiome(32)
					|| world.getBiome(bp) == Biome.getBiome(160)
					|| world.getBiome(bp) == Biome.getBiome(25)
					|| world.getBiome(bp) == Biome.getBiome(19)
					|| world.getBiome(bp) == Biome.getBiome(33)
					|| world.getBiome(bp) == Biome.getBiome(161)
					)
			{
				re = true;
			}
		}
		if(id == 6) {//　ジャングル
			if(world.getBiome(bp) == Biome.getBiome(21) 
					|| world.getBiome(bp) == Biome.getBiome(149)
					|| world.getBiome(bp) == Biome.getBiome(23)
					|| world.getBiome(bp) == Biome.getBiome(151)
					|| world.getBiome(bp) == Biome.getBiome(22)
					)
			{
				re = true;
			}
		}
		if(id == 7) {//　沼地
			if(world.getBiome(bp) == Biome.getBiome(6) 
					|| world.getBiome(bp) == Biome.getBiome(134)
					)
			{
				re = true;
			}
		}
		if(id == 8) {//　森
			if(world.getBiome(bp) == Biome.getBiome(4) 
					|| world.getBiome(bp) == Biome.getBiome(27)
					|| world.getBiome(bp) == Biome.getBiome(155)
					|| world.getBiome(bp) == Biome.getBiome(29)
					|| world.getBiome(bp) == Biome.getBiome(157)
					|| world.getBiome(bp) == Biome.getBiome(18)
					|| world.getBiome(bp) == Biome.getBiome(28)
					|| world.getBiome(bp) == Biome.getBiome(156)
					)
			{
				re = true;
			}
		}
		if(id == 9) {//　平原系
			if(world.getBiome(bp) == Biome.getBiome(1) 
					|| world.getBiome(bp) == Biome.getBiome(35)
					)
			{
				re = true;
			}
		}
		return re;
	}
	
	
	private void generateOre(World world, Random random, int x, int z) {
		/////　初期の物資
			if(mod_GVCR2.cfg_building_supplies){
				BlockPos spawn = world.getSpawnPoint();
				WorldBlockBuilding var1 = new WorldBlockBuilding(100);
					/*int genX =  x + random.nextInt(16); 
					int genZ =  z + random.nextInt(16); 
					BlockPos bp = world.getHeight(new BlockPos(genX, 64 + random.nextInt(100), genZ));
					int genY = bp.getY(); */
					//if(genY > 60)
				int genX =  x; 
				int genZ =  z; 
				BlockPos bp = world.getHeight(new BlockPos(genX, 50 + random.nextInt(100), genZ));
				//BlockPos bp = world.getHeight(new BlockPos(spawn.getX(), 64+ random.nextInt(120), spawn.getX()));
				Chunk chunk = world.getChunkFromBlockCoords(bp);
				Chunk chunk2 = world.getChunkFromBlockCoords(spawn);
				if(chunk == chunk2)
					{
						var1.generate(world, random, new BlockPos(spawn.getX(), bp.getY(), spawn.getZ())); 
					 } 
			}
		/////　初期の物資
		
			
			//　構造物
			if(mod_GVCR2.cfg_building_mine){
				int genX =  x + random.nextInt(16); 
				int genZ =  z + random.nextInt(16); 
				BlockPos bp = world.getHeight(new BlockPos(genX, 50 + random.nextInt(100), genZ));
				int genY = bp.getY(); //world.getChunksLowestHorizon(genX, genZ);
				if(random.nextInt(mod_GVCR2.cfg_building_rand_mine) == 0 && genY > 50)
				{
					//if(!(world.getBiome(bp) instanceof BiomeOcean))
					{
						WorldBlockStructure var1 = new WorldBlockStructure(0);
							var1.generate(world, random, new BlockPos(genX, genY, genZ));
					}
					
				}
				else if(random.nextInt(mod_GVCR2.cfg_building_rand_mine + 2) == 0 && genY > 50)
				{
					//if(world.getBiome(bp) instanceof BiomeOcean)
					{
						WorldBlockStructure var1 = new WorldBlockStructure(1);
							var1.generate(world, random, new BlockPos(genX, genY, genZ));
					}
				}
			}
			
			
			
			
			
			//　ダンジョン
		{
			
			// 試作一定間隔式/特大規模ダンジョン
			/*{
				/*BlockPos spawn = world.getSpawnPoint();
				boolean sp = false;
				Chunk ch = world.getChunkFromChunkCoords(x >> 4, z >> 4);
				// Chunk ch = world.getChunkFromChunkCoords(x, z);
				Chunk ch2 = world.getChunkFromBlockCoords(spawn);
				if (ch == ch2)sp = true;

				int genX = x + 0;
				int genZ = z + 0;
				BlockPos bp = world.getHeight(new BlockPos(genX, 64 + random.nextInt(100), genZ));
				int genY = bp.getY(); // world.getChunksLowestHorizon(genX, genZ);
				boolean canbuild = true;
				int ran1 = 80 * 10;// 896
				int ran2 = 128 * 5;// 896
				if (!sp && genY > 60) {
					if (Math.abs(genX) % ran1 == 0 && Math.abs(genZ) % ran1 == 0) {
						generateBuilding(world, random, genX, genY, genZ, spawn);
					} else if (Math.abs(genX) % ran2 == 0 && Math.abs(genZ) % ran2 == 0) {
						generateBuilding(world, random, genX, genY, genZ, spawn);
					}

				}

			}*/
			
			if(!mod_GVCR2.cfg_building_dungeon)return;
			
			
			if(mod_GVCR2.cfg_building_offsettype) {

				// 試作一定間隔式
				int genX =  x; 
				int genZ =  z; 
				BlockPos bp = world.getHeight(new BlockPos(genX, 60 + random.nextInt(100), genZ));
				int genY = bp.getY(); //world.getChunksLowestHorizon(genX, genZ);
				boolean canbuild = true;
				
				
				int ran1 = mod_GVCR2.cfg_building_offset_rand_boss_dungeon * 128;// 896
				int ran2 = 1280;// 896
				boolean flag1 = false;
				boolean flag2 = false;
				if (Math.abs(genX) % ran1 == 128 && Math.abs(genZ) % ran1 == 128) {
					flag1 = true;
				}
				if (Math.abs(genX) % ran2 == 128 && Math.abs(genZ) % ran2 == 128) {
					flag2 = true;
				}
				
				BlockPos spawn = world.getSpawnPoint();
				double xpos = Math.abs(genX - spawn.getX());
				double zpos = Math.abs(genZ - spawn.getZ());
				
				if(xpos > 64 || zpos > 64) 
				{
					//　　特大規模ダンジョン
					if (genY > 60) {
						if(flag1 || flag2 && mod_GVCR2.cfg_building_boss_dungeon) {
							generateBuilding(world, random, genX, genY, genZ, spawn);
						}
					}/**/
					
					
					/*if((Math.abs(genX) %64 == 0 && Math.abs(genZ) %64 == 0) && (!flag1 && !flag2)) 
					{
						WorldBlockBuilding var1 = new WorldBlockBuilding(0);
						var1.generate(world, random, new BlockPos(genX, genY, genZ));
					}
					if((Math.abs(genX) %64 == 32 && Math.abs(genZ) %64 == 32) && (!flag1 && !flag2)) 
					{
						WorldBlockBuilding var1 = new WorldBlockBuilding(1);
						var1.generate(world, random, new BlockPos(genX, genY, genZ));
					}*/
					
					//　小規模
					if((Math.abs(genX) %32 == 0 && Math.abs(genZ) %32 == 0) && (!flag1 && !flag2)) 
					{
						//if(random.nextInt(mod_GVCR2.cfg_building_rand_dungeon) == 0 && genY > 60 && mod_GVCR2.cfg_building_dungeon)
						if(random.nextInt(mod_GVCR2.cfg_building_offset_rand_dungeon) == 0 && genY > 60 && mod_GVCR2.cfg_building_dungeon)
						{
							if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeDesert)
							{
								WorldBlockBuilding var1 = new WorldBlockBuilding(1);
									var1.generate(world, random, new BlockPos(genX, genY, genZ));
							}
							else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeSnow)
							{
								WorldBlockBuilding var1 = new WorldBlockBuilding(2);
									var1.generate(world, random, new BlockPos(genX, genY, genZ));
							}
							else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeHills)
							{
								if(random.nextInt(3) == 0)
								{
									
								}else {
									WorldBlockBuilding var1 = new WorldBlockBuilding(15);
									var1.generate(world, random, new BlockPos(genX, genY, genZ));
								}
							}else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeOcean){
								WorldBlockBuilding var1 = new WorldBlockBuilding(16);
								var1.generate(world, random, new BlockPos(genX, genY, genZ));
							}
							else if(!(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeOcean)){
								{
									WorldBlockBuilding var1 = new WorldBlockBuilding(0);
									var1.generate(world, random, new BlockPos(genX, genY, genZ));
								}
							}
						}
					}/**/
					
					//　大規模ダンジョン
					if((Math.abs(genX) %64 == 0 && Math.abs(genZ) %64 == 0) && (!flag1 && !flag2)) 
					{
						
						//if(random.nextInt(mod_GVCR2.cfg_building_rand_huge_dungeon) == 0 && genY > 60 && mod_GVCR2.cfg_building_huge_dungeon)
						if(random.nextInt(mod_GVCR2.cfg_building_offset_rand_huge_dungeon) == 0 && genY > 59)
						{
							
							if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomePlains 
									|| world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeSnow
									|| world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeForest
									|| world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeSwamp)
							{
								if(random.nextInt(3) == 0 && mod_GVCR2.cfg_building_ally_dungeon)
								{
									if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeSnow) {
										WorldBlockBuilding var1 = new WorldBlockBuilding(13);
										var1.generate(world, random, new BlockPos(genX, genY, genZ));
									}else {
										WorldBlockBuilding var1 = new WorldBlockBuilding(11);
										var1.generate(world, random, new BlockPos(genX, genY, genZ));
									}
								}
								else if(mod_GVCR2.cfg_building_huge_dungeon){
									WorldBlockBuilding var1 = new WorldBlockBuilding(4);
									var1.generate(world, random, new BlockPos(genX, genY, genZ));
								}
							}
							else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeOcean)
							{
									//if(random.nextInt(3) == 0)
								if(world.getBiome(new BlockPos(genX,genY, genZ)) == Biome.getBiome(10)) {
									if(random.nextInt(3) == 0 && mod_GVCR2.cfg_building_ally_dungeon)
									{
										WorldBlockBuilding var1 = new WorldBlockBuilding(14);
										var1.generate(world, random, new BlockPos(genX, genY, genZ));
									}else {
										WorldBlockBuilding var1 = new WorldBlockBuilding(3);
										var1.generate(world, random, new BlockPos(genX, genY, genZ));
									}
								}else if(mod_GVCR2.cfg_building_huge_dungeon){
										WorldBlockBuilding var1 = new WorldBlockBuilding(3);
										var1.generate(world, random, new BlockPos(genX, genY, genZ));
								}
							}
							else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeDesert)
							{
									if(random.nextInt(3) == 0 && mod_GVCR2.cfg_building_ally_dungeon)
									{
										WorldBlockBuilding var1 = new WorldBlockBuilding(12);
										var1.generate(world, random, new BlockPos(genX, genY, genZ));
									}
							}
							else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeTaiga
									 || world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeSnow)
							{
								    if(random.nextInt(3) == 0 && mod_GVCR2.cfg_building_ally_dungeon)
									{
										WorldBlockBuilding var1 = new WorldBlockBuilding(13);
										var1.generate(world, random, new BlockPos(genX, genY, genZ));
									}
							}
						}
					}/**/
				}
			}
			
			//　旧式
			else {
				
				int genX =  x + random.nextInt(16); 
				int genZ =  z + random.nextInt(16); 
				BlockPos bp = world.getHeight(new BlockPos(genX, 60 + random.nextInt(100), genZ));
				int genY = bp.getY(); //world.getChunksLowestHorizon(genX, genZ);
				
				//　特大規模ダンジョン
				if(random.nextInt(mod_GVCR2.cfg_building_rand_boss_dungeon) == 0 && genY > 60 && mod_GVCR2.cfg_building_boss_dungeon)
				{
					if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeSnow)
					{
						WorldBlockBuilding var1 = new WorldBlockBuilding(7);
							var1.generate(world, random, new BlockPos(genX, genY, genZ));
					}else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomePlains)
					{
						WorldBlockBuilding var1 = new WorldBlockBuilding(5);
							var1.generate(world, random, new BlockPos(genX, genY, genZ));
					}
					else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeDesert)
					{
						WorldBlockBuilding var1 = new WorldBlockBuilding(8);
							var1.generate(world, random, new BlockPos(genX, genY, genZ));
					}
					else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeOcean)
					{
						WorldBlockBuilding var1 = new WorldBlockBuilding(6);
							var1.generate(world, random, new BlockPos(genX, genY, genZ));
					}
					else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeForest)
					{
						WorldBlockBuilding var1 = new WorldBlockBuilding(5);
							var1.generate(world, random, new BlockPos(genX, genY, genZ));
					}
				}
				
				//　大規模ダンジョン
				if(random.nextInt(mod_GVCR2.cfg_building_rand_huge_dungeon) == 0 && genY > 60 && mod_GVCR2.cfg_building_huge_dungeon)
				{
					if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomePlains 
							|| world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeSnow)
					{
						WorldBlockBuilding var1 = new WorldBlockBuilding(4);
							var1.generate(world, random, new BlockPos(genX, genY, genZ));
					}
				}
				
				//　味方基地
				if(random.nextInt(mod_GVCR2.cfg_building_rand_ally_dungeon) == 0 && genY > 60 && mod_GVCR2.cfg_building_ally_dungeon)
				{
					//if(getbiome_(world, bp, 9) || getbiome_(world, bp, 4))
					if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomePlains 
							|| world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeSnow)
					{
						WorldBlockBuilding var1 = new WorldBlockBuilding(11);
							var1.generate(world, random, new BlockPos(genX, genY, genZ));
					}
					//if(getbiome_(world, bp, 3))
					else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeDesert)
					{
						WorldBlockBuilding var1 = new WorldBlockBuilding(12);
							var1.generate(world, random, new BlockPos(genX, genY, genZ));
					}
					else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeTaiga
							 || world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeSnow)
					{
							{
								WorldBlockBuilding var1 = new WorldBlockBuilding(13);
								var1.generate(world, random, new BlockPos(genX, genY, genZ));
							}
					}
				}
			}
			
			
			
		}
		
		
		
			
			
		////////////////////////////////old
		/*
		//小型基地
		{
			WorldBlockBuilding var1 = new WorldBlockBuilding(0);
				int genX =  x + random.nextInt(16); 
				int genZ =  z + random.nextInt(16); 
				BlockPos bp = world.getHeight(new BlockPos(genX, 64 + random.nextInt(100), genZ));
				int genY = bp.getY(); 
					Biome[] biomeList = null;
					String biomeNameList[] = new String[] { "plains", "forest", "taiga", "swampland", "jungle", "taiga_cold", "savanna", "mesa"};
					biomeList = new Biome[biomeNameList.length];
				for (int i=0; i<biomeNameList.length; i++) biomeList[i] = Biome.REGISTRY.getObject(new ResourceLocation(biomeNameList[i]));
		 		{
						if(random.nextInt(120) == 0 && genY > 60)
						{
							{
								for(Biome biome : biomeList)
								{
									if(biome!=null)
									{
										if(world.getBiomeForCoordsBody(new BlockPos(genX,genY, genZ)) == biome)
										{
									var1.generate(world, random, new BlockPos(genX, genY, genZ)); 
										}
									}
								}
							}
						}
				 } 
		}
		{
			WorldBlockBuilding var1 = new WorldBlockBuilding(1);
				int genX =  x + random.nextInt(16); 
				int genZ =  z + random.nextInt(16); 
				BlockPos bp = world.getHeight(new BlockPos(genX, 64 + random.nextInt(100), genZ));
				int genY = bp.getY(); 
					Biome[] biomeList = null;
					String biomeNameList[] = new String[] { "desert", "desert_hills", "mutated_desert"};
					biomeList = new Biome[biomeNameList.length];
				for (int i=0; i<biomeNameList.length; i++) biomeList[i] = Biome.REGISTRY.getObject(new ResourceLocation(biomeNameList[i]));
		 		{
						if(random.nextInt(120) == 0 && genY > 60)
						{
							{
								for(Biome biome : biomeList)
								{
									if(biome!=null)
									{
										if(world.getBiomeForCoordsBody(new BlockPos(genX,genY, genZ)) == biome)
										{
									var1.generate(world, random, new BlockPos(genX, genY, genZ)); 
										}
									}
								}
							}
						}
				 } 
		}
		{
			WorldBlockBuilding var1 = new WorldBlockBuilding(2);
				int genX =  x + random.nextInt(16); 
				int genZ =  z + random.nextInt(16); 
				BlockPos bp = world.getHeight(new BlockPos(genX, 64 + random.nextInt(100), genZ));
				int genY = bp.getY(); 
					Biome[] biomeList = null;
					String biomeNameList[] = new String[] { "ice_flats", "ice_mountains", "cold_beach"};
					biomeList = new Biome[biomeNameList.length];
				for (int i=0; i<biomeNameList.length; i++) biomeList[i] = Biome.REGISTRY.getObject(new ResourceLocation(biomeNameList[i]));
		 		{
						if(random.nextInt(120) == 0 && genY > 60)
						{
							{
								for(Biome biome : biomeList)
								{
									if(biome!=null)
									{
										if(world.getBiomeForCoordsBody(new BlockPos(genX,genY, genZ)) == biome)
										{
									var1.generate(world, random, new BlockPos(genX, genY, genZ)); 
										}
									}
								}
							}
						}
				 } 
		}*/
		
		
		
		
		
	}

	
	private void generateBuilding(World world, Random random, int genX, int genY, int genZ, BlockPos spawn) {
		double xpos = Math.abs(genX - spawn.getX());
		double zpos = Math.abs(genZ - spawn.getZ());
		if(xpos > 200 || zpos > 200) 
		{
			if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeSnow)
			{
				if(random.nextInt(3) == 0 && mod_GVCR2.cfg_building_ally_dungeon)
				{WorldBlockBuilding var1 = new WorldBlockBuilding(10);
				var1.generate(world, random, new BlockPos(genX, genY, genZ));
					
				}
				else {
					WorldBlockBuilding var1 = new WorldBlockBuilding(7);
					var1.generate(world, random, new BlockPos(genX, genY, genZ));
				}
			}
			else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeSavanna 
					|| world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeHills)
			{
				{
					WorldBlockBuilding var1 = new WorldBlockBuilding(17);
					var1.generate(world, random, new BlockPos(genX, genY, genZ));
				}
			}
			else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomePlains
					|| world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeSwamp
					|| world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeTaiga)
			{
				if(random.nextInt(3) == 0 && mod_GVCR2.cfg_building_ally_dungeon)
				{
					WorldBlockBuilding var1 = new WorldBlockBuilding(10);
				    var1.generate(world, random, new BlockPos(genX, genY, genZ));
					
				}
				else {
					WorldBlockBuilding var1 = new WorldBlockBuilding(5);
					var1.generate(world, random, new BlockPos(genX, genY, genZ));
				}
			}
			else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeDesert)
			{
				{
					WorldBlockBuilding var1 = new WorldBlockBuilding(8);
					var1.generate(world, random, new BlockPos(genX, genY, genZ));
				}
			}
			else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeOcean)
			{
				WorldBlockBuilding var1 = new WorldBlockBuilding(6);
					var1.generate(world, random, new BlockPos(genX, genY, genZ));
			}
			else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeForest)
			{
				WorldBlockBuilding var1 = new WorldBlockBuilding(5);
					var1.generate(world, random, new BlockPos(genX, genY, genZ));
			}
			else if(world.getBiome(new BlockPos(genX,genY, genZ)) instanceof BiomeMesa)
			{
				world.setBlockState(new BlockPos(genX,genY, genZ),
						mod_GVCR2.gvcr2_block_building_abandoned_factory.getDefaultState(), 2);
			}
			/*else {
				WorldBlockBuilding var1 = new WorldBlockBuilding(10);
				if(mod_GVCR2.cfg_building_ally_dungeon)var1.generate(world, random, new BlockPos(genX, genY, genZ));
			}*/
		}
	}
	
	
	
	
	private void generateOreHell(World world, Random random, int x, int z) {
		/*{
			for (int i = 0; i < kazu; ++i) {
				int genX = x + random.nextInt(16);
				int genY = 0 + random.nextInt(60);
				int genZ = z + random.nextInt(16);

				// if(maxh > minh)
				{
					(new WorldGenMinable(this.ore.getDefaultState(), this.kazura, BlockHelper.forBlock(Blocks.stone)))
							.generate(world, random, new BlockPos(genX, genY, genZ));
				}
			}
		}*/
	}

	private void generateOreEnd(World world, Random random, int x, int z) 
 	{ 
 		/*{ 
	 		for (int i = 0; i < kazu; ++i) 
	 		{ 
	 			int genX =  x + random.nextInt(16); 
	 			int genY = 0 + random.nextInt(60); 
	 			int genZ =  z + random.nextInt(16); 

	 			//if(maxh > minh)
	 			{
	 			(new WorldGenMinable(this.ore.getDefaultState(),this.kazura,BlockHelper.forBlock(Blocks.stone))).generate(world, random, new BlockPos( genX, genY, genZ)); 
	 			}
	 			} 
 		}*/
 	}

	


}

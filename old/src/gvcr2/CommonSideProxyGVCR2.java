package gvcr2;

import java.io.File;

import gvcr2.block.tile.TileEntityBlockBaseFlag;
import gvcr2.block.tile.TileEntityBlockBossSpawn_Tile;
import gvcr2.block.tile.TileEntityBlockSpawn_Spawner;
import gvcr2.block.tile.TileEntityBlock_GunRack_Deco;
import gvcr2.block.tile.TileEntity_BulletCrafter;
import gvcr2.block.tile.TileEntity_GVC_DecoFacingBlock;
import gvcr2.block.tile.TileEntity_GunCrafter;
import gvcr2.block.tile.TileEntity_GunRack;
import gvcr2.block.tile.TileEntity_Mine;
import gvcr2.block.tile.TileEntity_Supplies;
import gvcr2.block.tile.TileEntity_VehicleCrafter;
import hmggirlfront.block.tile.TileEntity_Base_Materials;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonSideProxyGVCR2  {
 
	public boolean getClient() {
		return false;
	}
	
	public EntityPlayer getEntityPlayerInstance() {return null;}
	
	public File ProxyFile(){
		return new File(".");
	}
	public void registerClientInfo(){}
	
	public void IGuiHandler(){}
	
    public void reisterRenderers(){}
	
	public World getCilentWorld(){
		return null;}

	public void InitRendering() {
		
	}

	public void registerTileEntity() {		
		GameRegistry.registerTileEntity(TileEntity_Mine.class, "TileEntity_Mine");
		GameRegistry.registerTileEntity(TileEntity_Supplies.class, "TileEntity_Supplies");
		
		GameRegistry.registerTileEntity(TileEntity_BulletCrafter.class, "TileEntity_BulletCrafter");
		GameRegistry.registerTileEntity(TileEntity_GunCrafter.class, "TileEntity_GunCrafter");
		GameRegistry.registerTileEntity(TileEntity_VehicleCrafter.class, "TileEntity_VehicleCrafter");
		
		
		GameRegistry.registerTileEntity(TileEntityBlockSpawn_Spawner.class, "TileEntityBlockSpawn_Spawner");
		GameRegistry.registerTileEntity(TileEntityBlockBossSpawn_Tile.class, "TileEntityBlockBossSpawn_Tile");
		
		GameRegistry.registerTileEntity(TileEntityBlockBaseFlag.class, "TileEntityBlockBaseFlag");
		
		GameRegistry.registerTileEntity(TileEntity_GunRack.class, "TileEntity_GunRack");
		GameRegistry.registerTileEntity(TileEntityBlock_GunRack_Deco.class, "TileEntityBlock_GunRack_Deco");
		
		GameRegistry.registerTileEntity(TileEntity_GVC_DecoFacingBlock.class, "TileEntity_GVC_DecoFacingBlock");
	}
	
}
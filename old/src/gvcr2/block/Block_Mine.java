package gvcr2.block;

import java.util.Random;

import javax.annotation.Nullable;

import gvclib.world.GVCExplosionBase;
import gvcr2.mod_GVCR2;
import gvcr2.block.tile.TileEntity_Mine;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.PotionTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Block_Mine extends BlockContainer
{
	
	protected static final AxisAlignedBB ATMine_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.6D, 1.0D);
	protected static final AxisAlignedBB AHMine_AABB = new AxisAlignedBB(0.2D, 0.0D, 0.2D, 0.8D, 0.8D, 0.8D);
	protected static final AxisAlignedBB WaterMine_AABB = new AxisAlignedBB(0.1D, -0.9D, 0.1D, 0.9D, 0.9D, 0.9D);
	protected static final AxisAlignedBB Bomb_AABB = new AxisAlignedBB(0.1D, 0.0D, 0.1D, 0.9D, 0.9D, 0.9D);
	protected static final AxisAlignedBB IED_AABB = new AxisAlignedBB(0.35D, 0.0D, 0.1D, 0.65D, 0.2D, 0.9D);
	protected static final AxisAlignedBB PROPANE_AABB = new AxisAlignedBB(0.1D, 0.0D, 0.1D, 0.9D, 1.0D, 0.9D);
	
    public Block_Mine()
    {
    	super(Material.IRON);
        //setBlockUnbreakable();
        //setLightOpacity(1);
        //setLightLevel(1.0F);
    }
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state){
    	//worldIn.playSound((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), 
        //		SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, 1F, false);
    }
    @Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntity_Mine();
	}
    
    /**
     * Called when this Block is destroyed by an Explosion
     */
   // public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn)
    public void onBlockExploded(World worldIn, BlockPos pos, Explosion explosion)
    {
        /*if (!worldIn.isRemote)
        {
            EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(worldIn, (double)((float)pos.getX() + 0.5F), (double)pos.getY(), (double)((float)pos.getZ() + 0.5F), explosionIn.getExplosivePlacedBy());
            entitytntprimed.setFuse((short)(worldIn.rand.nextInt(entitytntprimed.getFuse() / 4) + entitytntprimed.getFuse() / 8));
            worldIn.spawnEntity(entitytntprimed);
        }*/
    	double x = pos.getX();
    	double y = pos.getY();
    	double z = pos.getZ();
    	 if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_atmine) {
 			if (!worldIn.isRemote) 
 		    	{
 					GVCExplosionBase.ExplosionKai(null, null, x, y + 0.5, z, 3.5F, false,  false);
 					//entityIn.attackEntityFrom(DamageSource.IN_FIRE, 100.0F);
 					worldIn.setBlockToAir(pos);
 				}
 		 }
    	 else  if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_bomb) {
  			if (!worldIn.isRemote) 
		    	{
					GVCExplosionBase.ExplosionKai(null, null, x, y + 0.5, z, 3.5F, false,  false);
					//entityIn.attackEntityFrom(DamageSource.IN_FIRE, 100.0F);
					worldIn.setBlockToAir(pos);
				}
		 }
    	 else  if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_water_mine) {
   			if (!worldIn.isRemote) 
 		    	{
 					GVCExplosionBase.ExplosionKai(null, null, x, y + 0.5, z, 4F, false,  true);
 					//entityIn.attackEntityFrom(DamageSource.IN_FIRE, 100.0F);
 					worldIn.setBlockToAir(pos);
 				}
 		 }
    	 else  if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_propane) {
    		// System.out.println("1");
   			if (!worldIn.isRemote) 
 		    	{
   				EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(worldIn, x, y + 0.5, z);
                entityareaeffectcloud.setOwner(null);
                entityareaeffectcloud.setRadius(6);
                entityareaeffectcloud.setDuration(2000);
                entityareaeffectcloud.setRadiusOnUse(-0.5F);
                entityareaeffectcloud.setWaitTime(10);
                entityareaeffectcloud.setRadiusPerTick(-entityareaeffectcloud.getRadius() / (float)entityareaeffectcloud.getDuration());
                //entityareaeffectcloud.setPotion(potiontype);
                entityareaeffectcloud.setPotion(PotionTypes.POISON);
                worldIn.spawnEntity(entityareaeffectcloud);
                worldIn.setBlockToAir(pos);
               // System.out.println("2");
 				}
 		 }
    	 else {
 			if (!worldIn.isRemote) 
 		    	{
 					GVCExplosionBase.ExplosionKai(null, null, x, y + 0.5, z, 2.0F, false,  false);
 					//entityIn.attackEntityFrom(DamageSource.IN_FIRE, 20.0F);
 					worldIn.setBlockToAir(pos);
 				}
 		 }
    }
    
    /**
     * Called When an Entity Collided with the Block
     */
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
    	double x = pos.getX();
    	double y = pos.getY();
    	double z = pos.getZ();
    	//if (!worldIn.isRemote) 
    	if(entityIn instanceof EntityLivingBase){
    		EntityLivingBase en = (EntityLivingBase) entityIn;
    		//en.addPotionEffect(new PotionEffect(MobEffects., 10, 10));
    		//en.setFire(15);
    		 if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_atmine) {
    			//if (!worldIn.isRemote) 
    		    	if(en.width > 2.0F){
    					GVCExplosionBase.ExplosionKai(entityIn, entityIn, x, y + 0.5, z, 3.5F, false,  true);
    					entityIn.attackEntityFrom(DamageSource.IN_FIRE, 100.0F);
    					worldIn.setBlockToAir(pos);
    				}
    		 }
    		 else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_bomb) {
     			//if (!worldIn.isRemote) 
     		    	if(en.width > 2.0F){
     					GVCExplosionBase.ExplosionKai(entityIn, entityIn, x, y + 0.5, z, 3.5F, false,  true);
     					entityIn.attackEntityFrom(DamageSource.IN_FIRE, 100.0F);
     					worldIn.setBlockToAir(pos);
     				}
     		 }
    		 else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_water_mine) {
      			//if (!worldIn.isRemote) 
      		    	{
      					GVCExplosionBase.ExplosionKai(entityIn, entityIn, x, y + 0.5, z, 4F, false,  true);
      					entityIn.attackEntityFrom(DamageSource.IN_FIRE, 100.0F);
      					worldIn.setBlockToAir(pos);
      				}
      		 }
    		 else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_propane) {
      			
      		 }
    		 else {
    			//if (!worldIn.isRemote) 
    		    	{
    					GVCExplosionBase.ExplosionKai(entityIn, entityIn, x, y + 0.5, z, 2.0F, false,  false);
    					entityIn.attackEntityFrom(DamageSource.IN_FIRE, 20.0F);
    					worldIn.setBlockToAir(pos);
    				}
    		 }
		}
    	else if(entityIn instanceof IProjectile){
    		if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_atmine) {
    			//if (!worldIn.isRemote) 
    		    	{
    					GVCExplosionBase.ExplosionKai(entityIn, entityIn, x, y + 0.5, z, 3.5F, false,  false);
    					entityIn.attackEntityFrom(DamageSource.IN_FIRE, 100.0F);
    					worldIn.setBlockToAir(pos);
    				}
    		 }
    		 else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_bomb) {
     			//if (!worldIn.isRemote) 
     		    	{
     					GVCExplosionBase.ExplosionKai(entityIn, entityIn, x, y + 0.5, z, 3.5F, false,  false);
     					entityIn.attackEntityFrom(DamageSource.IN_FIRE, 100.0F);
     					worldIn.setBlockToAir(pos);
     				}
     		 }
    		 else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_water_mine) {
      			//if (!worldIn.isRemote) 
      		    	{
      					GVCExplosionBase.ExplosionKai(entityIn, entityIn, x, y + 0.5, z, 4F, false,  true);
      					entityIn.attackEntityFrom(DamageSource.IN_FIRE, 100.0F);
      					worldIn.setBlockToAir(pos);
      				}
      		 }
    		 else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_propane) {
    			 EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(worldIn, x, y + 0.5, z);
                 entityareaeffectcloud.setOwner(null);
                 entityareaeffectcloud.setRadius(6);
                 entityareaeffectcloud.setDuration(2000);
                 entityareaeffectcloud.setRadiusOnUse(-0.5F);
                 entityareaeffectcloud.setWaitTime(10);
                 entityareaeffectcloud.setRadiusPerTick(-entityareaeffectcloud.getRadius() / (float)entityareaeffectcloud.getDuration());
                 //entityareaeffectcloud.setPotion(potiontype);
                 entityareaeffectcloud.setPotion(PotionTypes.POISON);
                 worldIn.spawnEntity(entityareaeffectcloud);
                 worldIn.setBlockToAir(pos);
      		 }
    		 else {
    			//if (!worldIn.isRemote) 
    		    	{
    					GVCExplosionBase.ExplosionKai(entityIn, entityIn, x, y + 0.5, z, 2.0F, false,  false);
    					entityIn.attackEntityFrom(DamageSource.IN_FIRE, 20.0F);
    					worldIn.setBlockToAir(pos);
    				}
    		 }
    	}
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
       /* if (rand.nextInt(24) == 0)
        {
            worldIn.playSound((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), 
            		SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
        }

        for (int i = 0; i < 3; ++i)
        {
            double d0 = (double)pos.getX() + rand.nextDouble();
            double d1 = (double)pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
            double d2 = (double)pos.getZ() + rand.nextDouble();
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }*/
    }
    
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        //return NULL_AABB;
    	if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_atmine) {
    		return ATMine_AABB;
    	}
    	else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_bomb) {
    		return Bomb_AABB;
 		 }
		 else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_water_mine) {
			 return WaterMine_AABB;
  		 }
		 else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_propane) {
			 return PROPANE_AABB;
  		 }
		 else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_ied) {
			 return IED_AABB;
  		 }
		 else {
			 return AHMine_AABB;
		 }
    }
    /**
     * Return an AABB (in world coords!) that should be highlighted when the player is targeting this Block
     */
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
    {
    	if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_atmine) {
    		return ATMine_AABB.offset(pos);
    	}
    	else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_bomb) {
    		return Bomb_AABB.offset(pos);
 		 }
		 else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_water_mine) {
			 return WaterMine_AABB.offset(pos);
  		 }
		 else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_propane) {
			 return PROPANE_AABB.offset(pos);
  		 }
		 else if(worldIn.getBlockState(pos).getBlock() == mod_GVCR2.gvcr2_block_ied) {
			 return IED_AABB.offset(pos);
  		 }
		 else {
			 return AHMine_AABB.offset(pos);
		 }
    }
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    protected boolean canSilkHarvest()
    {
        return true;
    }
    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    /**
     * The type of render function called. 3 for standard block models, 2 for TESR's, 1 for liquids, -1 is no render
     */
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
}
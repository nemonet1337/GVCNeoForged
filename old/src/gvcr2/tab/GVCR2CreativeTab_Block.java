package gvcr2.tab;
 
import gvcr2.mod_GVCR2;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
 
public class GVCR2CreativeTab_Block extends CreativeTabs
{
	public GVCR2CreativeTab_Block(String label)
	{
		super(label);
	}
 
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem()
	{
		//return new ItemStack(mod_GirlFront.dollgun_m4a1);
		return new ItemStack(mod_GVCR2.gvcr2_block_supplies_air);
	}
 
	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "GVCTab_Block";
	}
}
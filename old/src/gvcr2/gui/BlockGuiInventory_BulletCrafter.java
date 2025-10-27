package gvcr2.gui;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.opengl.GL11;

import gvcr2.mod_GVCR2;
import gvcr2.block.tile.TileEntity_BulletCrafter;
import gvcr2.gui.container.BlockContainerInventory_BulletCrafter;
import gvcr2.network.GVCR2MessageKeyPressed;
import gvcr2.network.GVCR2PacketHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class BlockGuiInventory_BulletCrafter extends GuiContainer
{
    private static final ResourceLocation FURNACE_GUI_TEXTURES = new ResourceLocation("gvcr2:textures/gui/bullet_crafter.png");
    /** The player inventory bound to this GUI. */
    private final InventoryPlayer playerInventory;
    private final IInventory tileFurnace;
    private final TileEntity_BulletCrafter tile;
    
    private GuiButton next;
    private GuiButton back;
    
    private GuiButton go;

    public BlockGuiInventory_BulletCrafter(InventoryPlayer playerInv, IInventory furnaceInv, TileEntity_BulletCrafter t)
    {
        super(new BlockContainerInventory_BulletCrafter(playerInv, furnaceInv, t));
        this.playerInventory = playerInv;
        this.tileFurnace = furnaceInv;
        this.tile = t;
    }
    
    @Override
    public void onGuiClosed()
    {
    	super.onGuiClosed();
    	this.tile.sell_id = 0;
    }
    
    public void initGui()
    {
    	super.initGui();
    	this.next = this.addButton(new GuiButton(0, this.width / 2 - 10, this.height / 2 - 69, 20, 20, I18n.format("next")));
    	this.back = this.addButton(new GuiButton(1, this.width / 2 - 60, this.height / 2 - 69, 20, 20, I18n.format("back")));
    	
    	this.go = this.addButton(new GuiButton(2, this.width / 2 + 25, this.height / 2 - 50, 20, 20, I18n.format("BUY")));
    }
    protected void actionPerformed(GuiButton button) throws IOException
    {
    	 if (button.id == 0)
         {
    		{
    			 if(tile.sell_id < (mod_GVCR2.bullet_id_1 - 1)) {
        			 ++tile.sell_id;
        		 }else {
        			 tile.sell_id = 0;
        		 }
        		 GVCR2PacketHandler.INSTANCE.sendToServer(new GVCR2MessageKeyPressed(100, tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ()));
    		 }
    		 
         }
    	 if (button.id == 1)
         {
    		 {
    			 if(tile.sell_id > 0) {
        			 --tile.sell_id;
        		 }else {
        			 tile.sell_id = (mod_GVCR2.bullet_id_1 - 1);
        		 }
        		 GVCR2PacketHandler.INSTANCE.sendToServer(new GVCR2MessageKeyPressed(200, tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ()));
    		 }
         }
    	 if (button.id == 2)
         {
    		 ItemStack eme = (ItemStack)tile.furnaceItemStacks.get(0);
             ItemStack iron = (ItemStack)tile.furnaceItemStacks.get(1);
             ItemStack output = (ItemStack)tile.furnaceItemStacks.get(3);
             if(mod_GVCR2.bullet_item_1[tile.sell_id] != null) {
             	if(!eme.isEmpty() && eme.getItem() == Items.GUNPOWDER
             			&& !iron.isEmpty() && iron.getItem() == Items.IRON_INGOT) {
             		if(eme.getCount() >= mod_GVCR2.bullet_eme_1[tile.sell_id]
             				&& iron.getCount() >= mod_GVCR2.bullet_iron_1[tile.sell_id]) {
             			tile.do_sell = true;
             			GVCR2PacketHandler.INSTANCE.sendToServer(new GVCR2MessageKeyPressed(300, tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ()));
             		}
             	}
             }
         }
    }
    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.drawGuiContainer_Item(partialTicks, mouseX, mouseY);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.tileFurnace.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
    	GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(FURNACE_GUI_TEXTURES);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
    
    /**
     * Draws the background layer of this container (behind the items).
     */
    protected void drawGuiContainer_Item(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        
        {
        	FontRenderer fontReader = mc.fontRenderer;
    		mc.fontRenderer.setUnicodeFlag(mc.isUnicode());
    		RenderItem renderitem = mc.getRenderItem();
        	GL11.glPushMatrix();
    		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
    				GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
    				GlStateManager.DestFactor.ZERO);
    		mc.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        	{
				ItemStack item= new ItemStack(mod_GVCR2.bullet_item_1[tile.sell_id]);
				if (!item.isEmpty()) {
					int posx =   k + 56;
					int posy =   l + 17;
					renderitem.renderItemIntoGUI(item, posx, posy);
					boolean onitem = mouseX >= posx && mouseY >= posy && mouseX < posx + 16 && mouseY < posy + 16;
					if(onitem)
					{
						this.renderToolTip(item, mouseX, mouseY);
					}
					String d2 = String.format("%1$3d", mod_GVCR2.bullet_kazu_1[tile.sell_id]);
					fontReader.drawString(d2,  posx + 5, posy + 8, Color.GREEN.getRGB());
				}
			}
        	{
				ItemStack item = new ItemStack(Items.GUNPOWDER);
				if (!item.isEmpty()) {
					int posx =   k + 38;
					int posy =   l + 35;
					renderitem.renderItemIntoGUI(item, posx, posy);
					boolean onitem = mouseX >= posx && mouseY >= posy && mouseX < posx + 16 && mouseY < posy + 16;
					if(onitem)
					{
						this.renderToolTip(item, mouseX, mouseY);
					}
					//renderitem.renderItemIntoGUI(item, k + 20, l + 35);
					int kazu = mod_GVCR2.bullet_eme_1[tile.sell_id];
					String d2 = String.format("%1$3d", kazu);
					fontReader.drawString(d2,  k + 28, l + 45, Color.GREEN.getRGB());
				}
			}
        	{
				ItemStack item = new ItemStack(Items.IRON_INGOT);
				if (!item.isEmpty()) {
					int posx =   k + 74;
					int posy =   l + 35;
					renderitem.renderItemIntoGUI(item, posx, posy);
					boolean onitem = mouseX >= posx && mouseY >= posy && mouseX < posx + 16 && mouseY < posy + 16;
					if(onitem)
					{
						this.renderToolTip(item, mouseX, mouseY);
					}
					//renderitem.renderItemIntoGUI(item, k + 56, l + 35);
					int kazu = mod_GVCR2.bullet_iron_1[tile.sell_id];
					String d2 = String.format("%1$3d", kazu);
					fontReader.drawString(d2,  k + 62, l + 45, Color.GREEN.getRGB());
				}
			}
        	
        	GL11.glPopMatrix();
        }
    }

    private int getCookProgressScaled(int pixels)
    {
        int i = this.tileFurnace.getField(2);
        int j = this.tileFurnace.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }

    private int getBurnLeftScaled(int pixels)
    {
        int i = this.tileFurnace.getField(1);

        if (i == 0)
        {
            i = 200;
        }

        return this.tileFurnace.getField(0) * pixels / i;
    }
}
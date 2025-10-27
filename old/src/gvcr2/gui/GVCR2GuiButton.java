package gvcr2.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GVCR2GuiButton extends GuiButton
{
    public ResourceLocation BUTTON_TEXTURES = new ResourceLocation("gvcr2:textures/gui/pad/gvcr2_widgets.png");
    
    private int tex_id = 0;
    
    public GVCR2GuiButton(int buttonId, int x, int y, String buttonText)
    {
        this(buttonId, x, y, 200, 20, buttonText, 0);
    }

    public GVCR2GuiButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, int texid)
    {
    	super(buttonId, x, y, buttonText);
        this.width = 200;
        this.height = 20;
        this.enabled = true;
        this.visible = true;
        this.id = buttonId;
        this.x = x;
        this.y = y;
        this.width = widthIn;
        this.height = heightIn;
        this.displayString = buttonText;
        this.tex_id = texid;
    }

    /**
     * Draws this button to the screen.
     */
   // public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks, int xpos, int ypos)
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
    {
        if (this.visible)
        {
            FontRenderer fontrenderer = mc.fontRenderer;
            mc.getTextureManager().bindTexture(BUTTON_TEXTURES);
            
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            int i = this.getHoverState(this.hovered);//暗くなるかどうとかの判定
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, 
            		GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            if(this.tex_id >= 10) {
            	this.drawTexturedModalRect(this.x, this.y, 
                		0 + (this.tex_id - 10) * 60, 60 + i * 20, 
                		this.width, this.height);
            }else {
            	this.drawTexturedModalRect(this.x, this.y, 
                		0 + this.tex_id * 20, 0 + i * 20, 
                		this.width, this.height);
            }
            
            //this.drawTexturedModalRect(this.x, this.y, 0, 46 + i * 20, this.width / 2, this.height);//左前半の表示
        //    this.drawTexturedModalRect(this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);//右後半の表示
            //this.drawTexturedModalRect(xpos,ypos, width, height, 20, 20);//没
            this.mouseDragged(mc, mouseX, mouseY);
            int j = 14737632;

            if (packedFGColour != 0)
            {
                j = packedFGColour;
            }
            else
            if (!this.enabled)
            {
                j = 10526880;
            }
            else if (this.hovered)
            {
                j = 16777120;
            }

            this.drawCenteredString(fontrenderer, this.displayString, this.x + this.width / 2, this.y + (this.height - 8) / 2, j);
        }
    }

}
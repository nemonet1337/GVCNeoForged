package gvcr2.gui;
 
import java.io.IOException;

import org.lwjgl.opengl.GL11;

import gvclib.mod_GVCLib;
import gvclib.event.gun.Layermat;
import gvclib.item.ItemGunBase;
import gvcr2.mod_GVCR2;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.gui.container.GVCR2Container_Pad;
import gvcr2.registry.GVCRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
 
public class GVCR2Gui_Pad extends GuiContainer
{
    //private static final ResourceLocation texture = new ResourceLocation("textures/gui/container/generic_54.png");
    private static final ResourceLocation texture = new ResourceLocation("gvcr2:textures/gui/pad/pad.png");
    private static final ResourceLocation texture2 = new ResourceLocation("gvcr2:textures/gui/pad/pad2.png");
    private static EntityPlayer player;
    /** The mouse x-position recorded during the last rendered frame. */
    private float mousePosx;
    /** The mouse y-position recorded during the last renderered frame. */
    private float mousePosY;
 
    private static final ResourceLocation m1 = new ResourceLocation("gvcr2:textures/gui/pad_mission/mission_1.png");
    private static final ResourceLocation m2 = new ResourceLocation("gvcr2:textures/gui/pad_mission/mission_2.png");
    private static final ResourceLocation m3 = new ResourceLocation("gvcr2:textures/gui/pad_mission/mission_3.png");
    private static final ResourceLocation m4 = new ResourceLocation("gvcr2:textures/gui/pad_mission/mission_4.png");
    private static final ResourceLocation m5 = new ResourceLocation("gvcr2:textures/gui/pad_mission/mission_5.png");
    private static final ResourceLocation m6 = new ResourceLocation("gvcr2:textures/gui/pad_mission/mission_6.png");
    
    private static final ResourceLocation gun_1 = new ResourceLocation("gvcr2:textures/gui/pad_gun/gun_1.png");
    private static final ResourceLocation gun_11 = new ResourceLocation("gvcr2:textures/gui/pad_gun/gun_11.png");
    private static final ResourceLocation gun_2 = new ResourceLocation("gvcr2:textures/gui/pad_gun/gun_2.png");
    private static final ResourceLocation gun_21 = new ResourceLocation("gvcr2:textures/gui/pad_gun/gun_21.png");
    private static final ResourceLocation gun_3 = new ResourceLocation("gvcr2:textures/gui/pad_gun/gun_3.png");
    private static final ResourceLocation gun_31 = new ResourceLocation("gvcr2:textures/gui/pad_gun/gun_31.png");
    
    private static final ResourceLocation vehicle_1 = new ResourceLocation("gvcr2:textures/gui/pad_vehicle/vehicle_1.png");
    private static final ResourceLocation vehicle_2 = new ResourceLocation("gvcr2:textures/gui/pad_vehicle/vehicle_2.png");
    private static final ResourceLocation vehicle_3 = new ResourceLocation("gvcr2:textures/gui/pad_vehicle/vehicle_3.png");
    private static final ResourceLocation vehicle_4 = new ResourceLocation("gvcr2:textures/gui/pad_vehicle/vehicle_4.png");
    
    
    
    private GVCR2GuiButton button_home;
    private GVCR2GuiButton button_back;
    
    private GVCR2GuiButton button_mission;
    private GVCR2GuiButton button_craft;
    
    
    private GVCR2GuiButton button_m_0;//ゲリラを倒せ0>>>1
    private GVCR2GuiButton button_m_1;//テクニカルを倒せ1>>>2
    private GVCR2GuiButton button_m_2;//ゲリラスポナーを壊せ2>>>3
    private GVCR2GuiButton button_m_3;//ゲリラ中規模拠点を攻略せよ3>>>4
    private GVCR2GuiButton button_m_4;//ゲリラ戦車を破壊せよ4>>>5
    private GVCR2GuiButton button_m_5;//ゲリラ大規模拠点を攻略せよ5>>>3
    //private GVCR2GuiButton button_m_6;//ゲリラ戦車を破壊せよ
    
    private GVCR2GuiButton button_c_next;//
    private GVCR2GuiButton button_c_back;//
    
    private GVCR2GuiButton button_c_0;//ユーティリティ
    private GVCR2GuiButton button_c_1;//弾薬
    private GVCR2GuiButton button_c_2;//銃
    private GVCR2GuiButton button_c_3;//乗り物
    private GVCR2GuiButton button_c_4;//PMC
    
    private GVCR2GuiButton button_gun_setumei;
    private GVCR2GuiButton button_g_0;//銃の入手
    private GVCR2GuiButton button_g_1;//弾薬管理
    private GVCR2GuiButton button_g_2;//アタッチメント
    
    private GVCR2GuiButton button_vehicle_setumei;
    private GVCR2GuiButton button_v_0;//乗り物の製造方法
    private GVCR2GuiButton button_v_1;//戦車・車の操作方法
    private GVCR2GuiButton button_v_2;//ヘリの操作方法
    private GVCR2GuiButton button_v_3;//航空機の操作方法
    private GVCR2GuiButton button_v_4;//船の操作方法
    private GVCR2GuiButton button_v_5;//固定兵器の操作方法
    
    
    public GVCR2Gui_Pad(InventoryPlayer inventoryPlayer, ItemStack itemstack)
    {
        super(new GVCR2Container_Pad(inventoryPlayer, itemstack));
        this.ySize = 222;
        player = inventoryPlayer.player;
    }
    
    
    public int page = 0;
    public int page_sub = 0;
    
    public void initGui()
    {
    	super.initGui();
    	int xpos = (this.width - this.xSize) / 2;
        int ypos = (this.height - this.ySize) / 2;
        
        this.button_home = this.addButton(new GVCR2GuiButton(0, xpos + 78 ,  ypos + 202, 20, 20, I18n.format(""), 0));
        this.button_back = this.addButton(new GVCR2GuiButton(1, xpos +45 ,  ypos + 202, 20, 20, I18n.format(""), 0));
        
        this.button_mission = this.addButton(new GVCR2GuiButton(2, xpos + 35 ,  ypos + 45, 20, 20, I18n.format(""), 1));
        this.button_craft = this.addButton(new GVCR2GuiButton(3, xpos + 75 ,  ypos + 45, 20, 20, I18n.format(""), 2));
        
        
        this.button_m_0 = this.addButton(new GVCR2GuiButton(4, xpos + 15 ,  ypos + 30  , 60, 20, I18n.format("MISSION::1"), 10));
        this.button_m_1 = this.addButton(new GVCR2GuiButton(5, xpos + 15 ,  ypos + 55  , 60, 20, I18n.format("MISSION::2"), 10));
        this.button_m_2 = this.addButton(new GVCR2GuiButton(6, xpos + 15 ,  ypos + 80  , 60, 20, I18n.format("MISSION::3"), 10));
        this.button_m_3 = this.addButton(new GVCR2GuiButton(7, xpos + 15 ,  ypos + 105, 60, 20, I18n.format("MISSION::4"), 10));
        this.button_m_4 = this.addButton(new GVCR2GuiButton(8, xpos + 15 ,  ypos + 130, 60, 20, I18n.format("MISSION::5"), 10));
        this.button_m_5 = this.addButton(new GVCR2GuiButton(9, xpos + 15 ,  ypos + 155, 60, 20, I18n.format("MISSION::6"), 10));
        
        this.button_c_next = this.addButton(new GVCR2GuiButton(10, xpos + 115,  ypos + 180, 20, 20, I18n.format(""), 4));
        this.button_c_back = this.addButton(new GVCR2GuiButton(11, xpos + 45  ,  ypos + 180, 20, 20, I18n.format(""), 3));
        
        this.button_c_0 = this.addButton(new GVCR2GuiButton(12, xpos + 15 ,  ypos + 30  , 20, 20, I18n.format(""), 5));
        this.button_c_1 = this.addButton(new GVCR2GuiButton(13, xpos + 15 ,  ypos + 55  , 20, 20, I18n.format(""), 5));
        this.button_c_2 = this.addButton(new GVCR2GuiButton(14, xpos + 15 ,  ypos + 80  , 20, 20, I18n.format(""), 5));
        this.button_c_3 = this.addButton(new GVCR2GuiButton(15, xpos + 15 ,  ypos + 105, 20, 20, I18n.format(""), 5));
        this.button_c_4 = this.addButton(new GVCR2GuiButton(16, xpos + 15 ,  ypos + 130, 20, 20, I18n.format(""), 5));
        
        this.button_gun_setumei = this.addButton(new GVCR2GuiButton(17, xpos + 115 ,  ypos + 45, 20, 20, I18n.format(""), 5));
        this.button_g_0 = this.addButton(new GVCR2GuiButton(18, xpos + 15 ,  ypos + 30  , 60, 20, I18n.format("gvcr2.string.pad.gun_ex0_1.name"), 10));
        this.button_g_1 = this.addButton(new GVCR2GuiButton(19, xpos + 15 ,  ypos + 55  , 60, 20, I18n.format("gvcr2.string.pad.gun_ex0_2.name"), 10));
        this.button_g_2 = this.addButton(new GVCR2GuiButton(20, xpos + 15 ,  ypos + 80  , 60, 20, I18n.format("gvcr2.string.pad.gun_ex0_3.name"), 10));
        
        this.button_vehicle_setumei = this.addButton(new GVCR2GuiButton(21, xpos + 35 ,  ypos + 75, 20, 20, I18n.format(""), 5));
        this.button_v_0 = this.addButton(new GVCR2GuiButton(22, xpos + 15 ,  ypos + 30  , 60, 20, I18n.format("gvcr2.string.pad.ve_ex0_1.name"), 10));
        this.button_v_1 = this.addButton(new GVCR2GuiButton(23, xpos + 15 ,  ypos + 55  , 60, 20, I18n.format("gvcr2.string.pad.ve_ex0_2.name"), 10));
        this.button_v_2 = this.addButton(new GVCR2GuiButton(24, xpos + 15 ,  ypos + 80  , 60, 20, I18n.format("gvcr2.string.pad.ve_ex0_3.name"), 10));
        this.button_v_3 = this.addButton(new GVCR2GuiButton(25, xpos + 15 ,  ypos + 105, 60, 20, I18n.format("gvcr2.string.pad.ve_ex0_4.name"), 10));
        this.button_v_4 = this.addButton(new GVCR2GuiButton(26, xpos + 15 ,  ypos + 130, 60, 20, I18n.format("gvcr2.string.pad.ve_ex0_5.name"), 10));
        this.button_v_5 = this.addButton(new GVCR2GuiButton(27, xpos + 15 ,  ypos + 155, 60, 20, I18n.format("gvcr2.string.pad.ve_ex0_6.name"), 10));
        
    	/*this.button_0 = this.addButton(new GVCR2GuiButton(1, xpos + 20 ,  ypos + 45, 20, 20, I18n.format("0"), 0));
    	this.button_1 = this.addButton(new GVCR2GuiButton(2, xpos + 60  , ypos + 45, 20, 20, I18n.format("1"), 0));
    	this.button_2 = this.addButton(new GVCR2GuiButton(3, xpos + 100, ypos + 45, 20, 20, I18n.format("2"), 0));*/
    	
    	//this.button_1.BUTTON_TEXTURES = new ResourceLocation("gvcr2:textures/gui/gvcr2_widgets2.png");
    }
    
   /* protected void actionPerformed(GuiButton button) throws IOException
    {
    	//home
    	if (button.id == 0)
        {
    		page = 0;
        }
    	
    	//back
    	else if (button.id == 1)
        {
    		if(page == 1) {
    			page = 0;
    		}
    		if(page == 2) {
    			page = 0;
    		}
    		if(page == 3 
    				|| page == 4 
    				|| page == 5
    				|| page == 6
    				|| page == 7
    				|| page == 8) {
    			page = 1;
    		}
    		if(page == 12 
    				|| page == 13 
    				|| page == 14
    				|| page == 15
    				|| page == 16) {
    			page = 2;
    		}
        }
    	
    	//mission
    	else if (button.id == 2)
        {
    		page = 1;
        }
    	//ccraft
    	else if (button.id == 3)
        {
    		page = 2;
        }
    	
    	
    	else if (button.id == 4 &&page == 1)
        {
    		page = 3;
        }
    	else if (button.id == 5 &&page == 1)
        {
    		page = 4;
        }
    	else if (button.id == 6 &&page == 1)
        {
    		page = 5;
        }
    	else if (button.id == 7 &&page == 1)
        {
    		page = 6;
        }
    	else if (button.id == 8 &&page == 1)
        {
    		page = 7;
        }
    	else if (button.id == 9 &&page == 1)
        {
    		page = 8;
        }
    	
    	else if (button.id == 9 &&page == 1)
        {
    		page = 8;
        }
    	
    	
    	else if (button.id == 10)//Button-Next
        {
    		if(page == 12) {
    			if(page_sub < 4)++page_sub;
    		}
    		if(page == 13) {
    			if(page_sub < 7)++page_sub;
    		}
    		if(page == 14) {
    			if(page_sub < 5)++page_sub;
    		}
    		if(page == 15) {
    			if(page_sub < 1)++page_sub;
    		}
    		if(page == 16) {
    			if(page_sub < 1)++page_sub;
    		}
        }
    	else if (button.id == 11)//Button-Back
        {
    		{
    			if(page_sub > 0)--page_sub;
    		}
        }
    	
    	
    	else if (button.id == 12 &&page == 2)
        {
    		page = 12;
    		page_sub = 0;
        }
    	else if (button.id == 13 &&page == 2)
        {
    		page = 13;
    		page_sub = 0;
        }
    	else if (button.id == 14 &&page == 2)
        {
    		page = 14;
    		page_sub = 0;
        }
    	else if (button.id == 15 &&page == 2)
        {
    		page = 15;
    		page_sub = 0;
        }
    	else if (button.id == 16 &&page == 2)
        {
    		page = 16;
    		page_sub = 0;
        }
    	
    	
    	else if (button.id == 17 &&page == 0)
        {
    		page = 20;
        }
    	else if (button.id == 18 &&page == 20)
        {
    		page = 21;
    		page_sub = 0;
        }
    	else if (button.id == 19 &&page == 20)
        {
    		page = 22;
    		page_sub = 0;
        }
    	else if (button.id == 20 &&page == 20)
        {
    		page = 23;
    		page_sub = 0;
        }
    	
    	
    	else if (button.id == 21 &&page == 0)
        {
    		page = 25;
        }
    	else if (button.id == 22 &&page == 25)
        {
    		page = 26;
    		page_sub = 0;
        }
    	else if (button.id == 23 &&page == 25)
        {
    		page = 27;
    		page_sub = 0;
        }
    	else if (button.id == 24 &&page == 25)
        {
    		page = 28;
    		page_sub = 0;
        }
    	else if (button.id == 25 &&page == 25)
        {
    		page = 29;
    		page_sub = 0;
        }
    	else if (button.id == 26 &&page == 25)
        {
    		page = 30;
    		page_sub = 0;
        }
    	else if (button.id == 27 &&page == 25)
        {
    		page = 31;
    		page_sub = 0;
        }
    	
    }
    */
    /**
     * Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton
     */
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        if (mouseButton == 0)
        {
        	
        	if(page == 1) {
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_home.id, 0, 0, 0) ;//home
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_back.id, 0, 0, 0) ;//back
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_m_0.id, 3, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_m_1.id, 4, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_m_2.id, 5, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_m_3.id, 6, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_m_4.id, 7, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_m_5.id, 8, 0, 0) ;
        	}
        	else if(page == 2) {
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_home.id, 0, 0, 0) ;//home
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_back.id, 0, 0, 0) ;//back
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_0.id, 12, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_1.id, 13, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_2.id, 14, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_3.id, 15, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_4.id, 16, 0, 0) ;
        	}
        	else if(page == 3
        			|| page == 4
        			|| page == 5
        			|| page == 6
        			|| page == 7
        			|| page == 8) {
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_home.id, 0, 0, 0) ;//home
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_back.id, 1, 0, 0) ;//back
        	}
        	else if(page == 12
        			|| page == 13
        			|| page == 14
        			|| page == 15
        			|| page == 16) {
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_home.id, 0, 0, 0) ;//home
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_back.id, 2, 0, 0) ;//back
        		if(page == 12)mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_next.id, -1, 1, 10) ;//sub_next
        		if(page == 13)mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_next.id, -1, 1, 11) ;//sub_next
        		if(page == 14)mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_next.id, -1, 1, 13) ;//sub_next
        		if(page == 15)mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_next.id, -1, 1, 1) ;//sub_next
        		if(page == 16)mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_next.id, -1, 1, 1) ;//sub_next
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_back.id, -1, 2, 0) ;//sub_back
        	}
        	else if(page == 20) {
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_home.id, 0, 0, 0) ;//home
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_back.id, 0, 0, 0) ;//back
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_g_0.id, 21, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_g_1.id, 22, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_g_2.id, 23, 0, 0) ;
        	}
        	else if(page == 21
        			|| page == 22
        			|| page == 23) {
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_home.id, 0, 0, 0) ;//home
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_back.id, 20, 0, 0) ;//back
        		if(page == 21)mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_next.id, -1, 1, 1) ;//sub_next
        		if(page == 22)mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_next.id, -1, 1, 1) ;//sub_next
        		if(page == 23)mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_next.id, -1, 1, 1) ;//sub_next
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_back.id, -1, 2, 0) ;//sub_back
        	}
        	else if(page == 25) {
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_home.id, 0, 0, 0) ;//home
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_back.id, 0, 0, 0) ;//back
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_v_0.id, 26, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_v_1.id, 27, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_v_2.id, 28, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_v_3.id, 29, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_v_4.id, 30, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_v_5.id, 31, 0, 0) ;
        	}
        	else if(page == 26
        			|| page == 27
        			|| page == 28
        			|| page == 29
        			|| page == 30
        			|| page == 31) {
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_home.id, 0, 0, 0) ;//home
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_back.id, 25, 0, 0) ;//back
        		if(page == 26)mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_next.id, -1, 1, 1) ;//sub_next
        		if(page == 27)mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_next.id, -1, 1, 0) ;//sub_next
        		if(page == 28)mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_next.id, -1, 1, 0) ;//sub_next
        		if(page == 29)mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_next.id, -1, 1, 0) ;//sub_next
        		if(page == 30)mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_next.id, -1, 1, 0) ;//sub_next
        		if(page == 31)mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_next.id, -1, 1, 0) ;//sub_next
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_c_back.id, -1, 2, 0) ;//sub_back
        	}
        	
        	
        	
        	else  
        	if(page == 0) {//最初の画面     何故かpage1のものが反応するため後ろに
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_home.id, 0, 0, 0) ;//home
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_back.id, 0, 0, 0) ;//back
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_mission.id, 1, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_craft.id, 2, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_gun_setumei.id, 20, 0, 0) ;
        		mouseClicked_do( mouseX,  mouseY,  mouseButton,  button_vehicle_setumei.id, 25, 0, 0) ;
        	}
        }
    }
    
    protected void mouseClicked_do(int mouseX, int mouseY, int mouseButton, int id, int move_page, int sub_pag, int sub_max) throws IOException
    {
    	//以下ボタンを押したときの処理
        GuiButton guibutton = this.buttonList.get(id);
        if (guibutton.mousePressed(this.mc, mouseX, mouseY))
        {
            net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent.Pre event = new net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent.Pre(this, guibutton, this.buttonList);
            //if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) break;
            guibutton = event.getButton();
            this.selectedButton = guibutton;
            guibutton.playPressSound(this.mc.getSoundHandler());
            //this.actionPerformed(guibutton);
            {
            	if(move_page >= 0)page = move_page;
            	if(sub_pag == 1 && page_sub < sub_max) {
            		++page_sub;
            	}
            	else if(sub_pag == 2 && page_sub > 0) {
            		--page_sub;
            	}
            	else {
            		page_sub = 0;
            	}
            }
            if (this.equals(this.mc.currentScreen))
                net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent.Post(this, event.getButton(), this.buttonList));
        }
    }
    
    
    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();//　仮面を暗くする
        this.mousePosx = (float)mouseX;
        this.mousePosY = (float)mouseY;
        {
        	if(page == 0) {
           	 this.mc.getTextureManager().bindTexture(texture);
           }
           else {
           	 this.mc.getTextureManager().bindTexture(texture2);
           }
          
           int k = (this.width - this.xSize) / 2;
           int l = (this.height - this.ySize) / 2;
           this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        }
  //      super.drawScreen(mouseX, mouseY, partialTicks);//ここからボタンを表示する
        
        ((GuiButton)button_home).drawButton(this.mc, mouseX, mouseY, partialTicks);
        ((GuiButton)button_back).drawButton(this.mc, mouseX, mouseY, partialTicks);
        if(page == 0) {
        	((GuiButton)button_mission).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_craft).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_gun_setumei).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_vehicle_setumei).drawButton(this.mc, mouseX, mouseY, partialTicks);
        }
        else  if(page == 1) {
        	((GuiButton)button_m_0).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_m_1).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_m_2).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_m_3).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_m_4).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_m_5).drawButton(this.mc, mouseX, mouseY, partialTicks);
        }
        else  if(page == 2) {
        	((GuiButton)button_c_0).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_c_1).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_c_2).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_c_3).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_c_4).drawButton(this.mc, mouseX, mouseY, partialTicks);
        }
        else  if(page == 12
        		     || page == 13
        		     || page == 14
        		     || page == 15
        		     || page == 16) {
        	((GuiButton)button_c_next).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_c_back).drawButton(this.mc, mouseX, mouseY, partialTicks);
        }
        else  if(page == 20) {
        	((GuiButton)button_g_0).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_g_1).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_g_2).drawButton(this.mc, mouseX, mouseY, partialTicks);
        }
		else if (page == 21 || page == 22 || page == 23) {
			((GuiButton) button_c_next).drawButton(this.mc, mouseX, mouseY, partialTicks);
			((GuiButton) button_c_back).drawButton(this.mc, mouseX, mouseY, partialTicks);
		}
        else  if(page == 25) {
        	((GuiButton)button_v_0).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_v_1).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_v_2).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_v_3).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_v_4).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	((GuiButton)button_v_5).drawButton(this.mc, mouseX, mouseY, partialTicks);
        }
        else if (page == 26 ) {
			((GuiButton) button_c_next).drawButton(this.mc, mouseX, mouseY, partialTicks);
			((GuiButton) button_c_back).drawButton(this.mc, mouseX, mouseY, partialTicks);
		}
        else {
        	//((GuiButton)this.buttonList.get(1)).drawButton(this.mc, mouseX, mouseY, partialTicks);
        	//button_1.drawButton(this.mc, mouseX, mouseY, partialTicks, button_1.x, button_1.y);
        }
        for (int j = 0; j < this.labelList.size(); ++j)
        {
            ((GuiLabel)this.labelList.get(j)).drawLabel(this.mc, mouseX, mouseY);
        }
        
        this.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
        this.renderHoveredToolTip(mouseX, mouseY);
    }
    
    
	/*
        ChestとかInventoryとか文字を描画する
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int p_146979_2_)
    {
    	
        //描画する文字, X, Y, 色
      //  this.fontRenderer.drawString("AR Attachment", 8, 6, 4210752);
      //  this.fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);
    }
 
    /*
        背景の描画
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
       /* if(page == 0) {
        	 this.mc.getTextureManager().bindTexture(texture);
        }
        else {
        	 this.mc.getTextureManager().bindTexture(texture2);
        }
       */
        
        float mozi_bai = 1.0F;//0.8
        float mozi_x = 0F;//31
        float mozi_y = 0F;
        
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        //this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        FontRenderer fontReader = mc.fontRenderer;
	//	mc.fontRenderer.setUnicodeFlag(mc.isUnicode());
        GL11.glPushMatrix();
        {
        	long worldtime = mod_GVCR2.proxy.getCilentWorld().getWorldTime();
            int time = (int) (worldtime * 1);
            int h = time / 1000 + 6;
            int m = (time % 1000) / 17;
            //int s = (time % 3600) % 60;
            if(h >= 24)h = h - 24;
            String string_h = String.format("%1$3d", (int)h);
            String string_m = String.format("%1$3d", (int)m);
            //String string_s = String.format("%1$3d", (int)s);
    		fontReader.drawString(string_h + ":" + string_m,  k + 140, l + 5, 0xFFFFFF);
        }
        
        
        if(page == 0) {
        	String d2 = String.format("%1$3d", (int)mod_GVCR2.difficult_level );
			fontReader.drawString("progress : "+ d2,  k + 5, l + 5, 0xFFFFFF);
			RenderItem renderitem = mc.getRenderItem();
        	{
        		ItemStack item = new ItemStack(mod_GVCR2.gvcr2_gun_m16a1);
    			if (!item.isEmpty())renderitem.renderItemIntoGUI(item, button_gun_setumei.x + 2, button_gun_setumei.y + 2);
        	}
        	{
        		ItemStack item = new ItemStack(mod_GVCR2.gvcr2_spawn_tank_m1);
    			if (!item.isEmpty())renderitem.renderItemIntoGUI(item, button_vehicle_setumei.x + 2, button_vehicle_setumei.y + 2);
        	}
        }
        if(page == 1) {
        	if(mod_GVCR2.difficult_level >= 1)fontReader.drawString("CLEAR!",  k + 80, l + 30, 0xffff00);
        	if(mod_GVCR2.difficult_level >= 2)fontReader.drawString("CLEAR!",  k + 80, l + 55, 0xffff00);
        	if(mod_GVCR2.difficult_level >= 3)fontReader.drawString("CLEAR!",  k + 80, l + 80, 0xffff00);
        	if(mod_GVCR2.difficult_level >= 4)fontReader.drawString("CLEAR!",  k + 80, l + 105, 0xffff00);
        	if(mod_GVCR2.difficult_level >= 5)fontReader.drawString("CLEAR!",  k + 80, l + 130, 0xffff00);
        	if(mod_GVCR2.difficult_level >= 6)fontReader.drawString("CLEAR!",  k + 80, l + 155, 0xffff00);
        }
        if(page == 3) {
        	GL11.glPushMatrix();
        	float bairitu = 2F;
        	this.mc.getTextureManager().bindTexture(m1);
        	GL11.glScalef(bairitu, bairitu, bairitu);
        	this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 0, 0, (int)(58/ 1), (int)(40/ 1));
        	/*EntityGVCR2_GE_S ge = new EntityGVCR2_GE_S(mod_GVCR2.proxy.getCilentWorld());
        	if(ge != null){
            	GL11.glPushMatrix();
            	GuiInventory.drawEntityOnScreen((k+ 60),( l + 160), 50, 40, 0, ge);
            	GL11.glPopMatrix();
            	
            }*/
        	GL11.glPopMatrix();
        	
        	GL11.glPushMatrix();
        	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
        	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission1_1.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission1_2.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission1_3.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission1_4.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission1_5.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission1_6.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
        	GL11.glScalef(1F, 1F, 1F);
        	GL11.glPopMatrix();
        }
        if(page == 4) {
        	GL11.glPushMatrix();
        	float bairitu = 2F;
        	this.mc.getTextureManager().bindTexture(m2);
        	GL11.glScalef(bairitu, bairitu, bairitu);
        	this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 0, 0, (int)(58/ 1), (int)(40/ 1));
        	GL11.glPopMatrix();
        	
        	GL11.glPushMatrix();
        	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
        	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission2_1.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission2_2.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission2_3.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission2_4.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission2_5.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission2_6.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
        	GL11.glScalef(1F, 1F, 1F);
        	GL11.glPopMatrix();
        }
        if(page == 5) {
        	GL11.glPushMatrix();
        	float bairitu = 2F;
        	this.mc.getTextureManager().bindTexture(m3);
        	GL11.glScalef(bairitu, bairitu, bairitu);
        	this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 0, 0, (int)(65/ 1), (int)(45/ 1));
        	GL11.glPopMatrix();
        	
        	GL11.glPushMatrix();
        	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
        	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission3_1.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission3_2.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission3_3.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission3_4.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission3_5.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission3_6.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
        	GL11.glScalef(1F, 1F, 1F);
        	GL11.glPopMatrix();
        }
        if(page == 6) {
        	GL11.glPushMatrix();
        	float bairitu = 1F;
        	this.mc.getTextureManager().bindTexture(m4);
        	GL11.glScalef(bairitu, bairitu, bairitu);
        	this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 0, 0, (int)(115/ 1), (int)(75/ 1));
        	GL11.glPopMatrix();

        	GL11.glPushMatrix();
        	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
        	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission4_1.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission4_2.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission4_3.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission4_4.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission4_5.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission4_6.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
        	GL11.glScalef(1F, 1F, 1F);
        	GL11.glPopMatrix();
        }
        if(page == 7) {
        	GL11.glPushMatrix();
        	float bairitu = 2F;
        	this.mc.getTextureManager().bindTexture(m5);
        	GL11.glScalef(bairitu, bairitu, bairitu);
        	this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 0, 0, (int)(70/ 1), (int)(40/ 1));
        	GL11.glPopMatrix();

        	GL11.glPushMatrix();
        	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
        	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission5_1.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission5_2.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission5_3.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission5_4.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission5_5.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission5_6.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
        	GL11.glScalef(1F, 1F, 1F);
        	GL11.glPopMatrix();
        }
        if(page == 8) {
        	GL11.glPushMatrix();
        	float bairitu = 0.75F;
        	this.mc.getTextureManager().bindTexture(m6);
        	GL11.glScalef(bairitu, bairitu, bairitu);
        	this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 0, 0, (int)(192/ 1), (int)(102/ 1));
        	GL11.glPopMatrix();
        	
        	GL11.glPushMatrix();
        	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
        	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission6_1.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission6_2.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission6_3.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission6_4.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission6_5.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
        	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.mission6_6.name", 
        			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
        	GL11.glScalef(1F, 1F, 1F);
        	GL11.glPopMatrix();
        	
        }
        
        if(page == 2) {
        	RenderItem renderitem = mc.getRenderItem();
        	{
        		ItemStack item = new ItemStack(mod_GVCR2.gvcr2_item_pad);
    			if (!item.isEmpty())renderitem.renderItemIntoGUI(item, button_c_0.x + 2, button_c_0.y + 2);
        	}
        	{
        		ItemStack item = new ItemStack(mod_GVCR2.gvcr2_bullet_22calar);
    			if (!item.isEmpty())renderitem.renderItemIntoGUI(item, button_c_1.x + 2, button_c_1.y + 2);
        	}
        	{
        		ItemStack item = new ItemStack(mod_GVCR2.gvcr2_gun_ak47);
    			if (!item.isEmpty())renderitem.renderItemIntoGUI(item, button_c_2.x + 2, button_c_2.y + 2);
        	}
        	{
        		ItemStack item = new ItemStack(mod_GVCR2.gvcr2_spawn_tank_m41);
    			if (!item.isEmpty())renderitem.renderItemIntoGUI(item, button_c_3.x + 2, button_c_3.y + 2);
        	}
        	{
        		ItemStack item = new ItemStack(mod_GVCR2.gvcr2_spawn_pmc_s);
    			if (!item.isEmpty())renderitem.renderItemIntoGUI(item, button_c_4.x + 2, button_c_4.y + 2);
        	}
        	
        }
        
        if(page == 12) {//　ユーティリティ
        	if(page_sub == 0)drow_page_recipe(0, 1, k, l, mouseX, mouseY);
        	if(page_sub == 1)drow_page_recipe(2, 3, k, l, mouseX, mouseY);
        	if(page_sub == 2)drow_page_recipe(4, 5, k, l, mouseX, mouseY);
        	if(page_sub == 3)drow_page_recipe(6, 7, k, l, mouseX, mouseY);
        	if(page_sub == 4)drow_page_recipe(8, 9, k, l, mouseX, mouseY);
        	if(page_sub == 5)drow_page_recipe(202, 203, k, l, mouseX, mouseY);
        	if(page_sub == 6)drow_page_recipe(204, 555, k, l, mouseX, mouseY);
        	if(page_sub == 7)drow_page_recipe(25, 26, k, l, mouseX, mouseY);
        	if(page_sub == 8)drow_page_recipe(27, 28, k, l, mouseX, mouseY);
        	if(page_sub == 9)drow_page_recipe(29, 201, k, l, mouseX, mouseY);
        	if(page_sub == 10)drow_page_smelting(200, 999, k, l, mouseX, mouseY);
        }
       if(page == 13) {//　弾薬
        	if(page_sub == 0)drow_page_recipe(35, 10, k, l, mouseX, mouseY);
        	if(page_sub == 1)drow_page_recipe(11, 12, k, l, mouseX, mouseY);
        	if(page_sub == 2)drow_page_recipe(13, 14, k, l, mouseX, mouseY);
        	if(page_sub == 3)drow_page_recipe(20, 21, k, l, mouseX, mouseY);
        	if(page_sub == 4)drow_page_recipe(15, 16, k, l, mouseX, mouseY);
        	if(page_sub == 5)drow_page_recipe(17, 18, k, l, mouseX, mouseY);
        	if(page_sub == 6)drow_page_recipe(150, 151, k, l, mouseX, mouseY);
        	if(page_sub == 7)drow_page_recipe(152, 153, k, l, mouseX, mouseY);
        	if(page_sub == 8)drow_page_recipe(154, 155, k, l, mouseX, mouseY);
        	if(page_sub == 9)drow_page_recipe(156, 157, k, l, mouseX, mouseY);
        	if(page_sub == 10)drow_page_recipe(158, 159, k, l, mouseX, mouseY);
        	if(page_sub == 11)drow_page_recipe(160, 161, k, l, mouseX, mouseY);
        }
        if(page == 14) {//　銃
        	if(page_sub == 0)drow_page_recipe(30, 31, k, l, mouseX, mouseY);
        	if(page_sub == 1)drow_page_recipe(32, 999, k, l, mouseX, mouseY);
        	if(page_sub == 2)drow_page_recipe(80, 81, k, l, mouseX, mouseY);
        	if(page_sub == 3)drow_page_recipe(82, 83, k, l, mouseX, mouseY);
        	if(page_sub == 4)drow_page_recipe(84, 85, k, l, mouseX, mouseY);
        	if(page_sub == 5)drow_page_recipe(86, 87, k, l, mouseX, mouseY);
        	
        	if(page_sub == 6)drow_page_recipe(100, 101, k, l, mouseX, mouseY);
        	if(page_sub == 7)drow_page_recipe(102, 103, k, l, mouseX, mouseY);
        	if(page_sub == 8)drow_page_recipe(110, 111, k, l, mouseX, mouseY);
        	if(page_sub == 9)drow_page_recipe(112, 113, k, l, mouseX, mouseY);
        	if(page_sub == 10)drow_page_recipe(114, 115, k, l, mouseX, mouseY);
        	if(page_sub == 11)drow_page_recipe(116, 117, k, l, mouseX, mouseY);
        	if(page_sub == 12)drow_page_recipe(118, 119, k, l, mouseX, mouseY);
        	if(page_sub == 13)drow_page_recipe(120, 121, k, l, mouseX, mouseY);
        }
        if(page == 15) {//　乗り物
        	if(page_sub == 0)drow_page_recipe(40, 41, k, l, mouseX, mouseY);
        	if(page_sub == 1)drow_page_recipe(42, 999, k, l, mouseX, mouseY);
        }
        if(page == 16) {//　PMC
        	if(page_sub == 0)drow_page_recipe(50, 52, k, l, mouseX, mouseY);
        	if(page_sub == 1)drow_page_recipe(51, 999, k, l, mouseX, mouseY);
        }
        
        
        if(page == 21) {
        	if(page_sub == 0) {
        		GL11.glPushMatrix();
            	float bairitu = 0.5F;
            	this.mc.getTextureManager().bindTexture(gun_1);
            	GL11.glScalef(bairitu, bairitu, bairitu);
            	this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 0, 0, (int)(256), (int)(136));//136
            	GL11.glPopMatrix();
            	
            	GL11.glPushMatrix();
            	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
            	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_1_1.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_1_2.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_1_3.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_1_4.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_1_5.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_1_6.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
            	GL11.glScalef(1F, 1F, 1F);
            	GL11.glPopMatrix();
        	}else {
        		GL11.glPushMatrix();
            	float bairitu = 0.5F;
            	this.mc.getTextureManager().bindTexture(gun_11);
            	GL11.glScalef(bairitu, bairitu, bairitu);
            	this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 0, 0, (int)(256), (int)(136));//136
            	GL11.glPopMatrix();
            	
            	GL11.glPushMatrix();
            	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
            	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_11_1.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_11_2.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_11_3.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_11_4.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_11_5.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_11_6.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
            	GL11.glScalef(1F, 1F, 1F);
            	GL11.glPopMatrix();
        	}
        }
        if(page == 22) {
        	if(page_sub == 0) {
        		GL11.glPushMatrix();
            	float bairitu = 0.5F;
            	this.mc.getTextureManager().bindTexture(gun_2);
            	GL11.glScalef(bairitu, bairitu, bairitu);
            	this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 0, 0, (int)(256), (int)(136));//136
            	GL11.glPopMatrix();
            	
            	GL11.glPushMatrix();
            	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
            	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_2_1.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_2_2.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_2_3.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_2_4.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_2_5.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_2_6.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
            	GL11.glScalef(1F, 1F, 1F);
            	GL11.glPopMatrix();
        	}else {
        		GL11.glPushMatrix();
            	float bairitu = 0.5F;
            	this.mc.getTextureManager().bindTexture(gun_21);
            	GL11.glScalef(bairitu, bairitu, bairitu);
            	this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 0, 0, (int)(256), (int)(136));//136
            	GL11.glPopMatrix();
            	
            	GL11.glPushMatrix();
            	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
            	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_21_1.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_21_2.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_21_3.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_21_4.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_21_5.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_21_6.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
            	GL11.glScalef(1F, 1F, 1F);
            	GL11.glPopMatrix();
        	}
        }
        if(page == 23) {
        	if(page_sub == 0) {
        		GL11.glPushMatrix();
            	float bairitu = 0.5F;
            	this.mc.getTextureManager().bindTexture(gun_3);
            	GL11.glScalef(bairitu, bairitu, bairitu);
            	this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 0, 0, (int)(256), (int)(136));//136
            	GL11.glPopMatrix();
            	
            	GL11.glPushMatrix();
            	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
            	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_3_1.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_3_2.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_3_3.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_3_4.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_3_5.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_3_6.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
            	GL11.glScalef(1F, 1F, 1F);
            	GL11.glPopMatrix();
        	}else {
        		GL11.glPushMatrix();
            	float bairitu = 0.5F;
            	this.mc.getTextureManager().bindTexture(gun_31);
            	GL11.glScalef(bairitu, bairitu, bairitu);
            	this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 0, 0, (int)(256), (int)(136));//136
            	GL11.glPopMatrix();
            	
            	GL11.glPushMatrix();
            	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
            	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_31_1.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_31_2.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_31_3.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_31_4.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_31_5.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.gun_ex_31_6.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
            	GL11.glScalef(1F, 1F, 1F);
            	GL11.glPopMatrix();
        	}
        }
        
        if(page == 26) {
        	if(page_sub == 0) {
            	
            	GL11.glPushMatrix();
            	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
            	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_0_1.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_0_2.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_0_3.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_0_4.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_0_5.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_0_6.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
            	GL11.glScalef(1F, 1F, 1F);
            	GL11.glPopMatrix();
        	}else {
            	
            	GL11.glPushMatrix();
            	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
            	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_01_1.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_01_2.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_01_3.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_01_4.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_01_5.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_01_6.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_01_7.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 90, 0x000000);
            	GL11.glScalef(1F, 1F, 1F);
            	GL11.glPopMatrix();
        	}
        }
        
        if(page == 27) {
        	{
        		GL11.glPushMatrix();
            	float bairitu = 0.5F;
            	this.mc.getTextureManager().bindTexture(vehicle_1);
            	GL11.glScalef(bairitu, bairitu, bairitu);
            	this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 0, 0, (int)(256), (int)(136));//136
            	GL11.glPopMatrix();
            	
            	GL11.glPushMatrix();
            	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
            	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_1_1.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_1_2.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_1_3.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_1_4.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_1_5.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_1_6.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
            	GL11.glScalef(1F, 1F, 1F);
            	GL11.glPopMatrix();
        	}
        }
        if(page == 28) {
        	{
        		GL11.glPushMatrix();
            	float bairitu = 0.5F;
            	this.mc.getTextureManager().bindTexture(vehicle_2);
            	GL11.glScalef(bairitu, bairitu, bairitu);
            	this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 0, 0, (int)(256), (int)(136));//136
            	GL11.glPopMatrix();
            	
            	GL11.glPushMatrix();
            	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
            	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_2_1.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_2_2.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_2_3.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_2_4.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_2_5.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_2_6.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
            	GL11.glScalef(1F, 1F, 1F);
            	GL11.glPopMatrix();
        	}
        }
        if(page == 29) {
        	{
        		GL11.glPushMatrix();
            	float bairitu = 0.5F;
            	this.mc.getTextureManager().bindTexture(vehicle_3);
            	GL11.glScalef(bairitu, bairitu, bairitu);
            	this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 0, 0, (int)(256), (int)(136));//136
            	GL11.glPopMatrix();
            	
            	GL11.glPushMatrix();
            	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
            	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_3_1.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_3_2.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_3_3.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_3_4.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_3_5.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_3_6.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
            	GL11.glScalef(1F, 1F, 1F);
            	GL11.glPopMatrix();
        	}
        }
        if(page == 30) {
        	{
        		GL11.glPushMatrix();
            	float bairitu = 0.5F;
            	this.mc.getTextureManager().bindTexture(vehicle_4);
            	GL11.glScalef(bairitu, bairitu, bairitu);
            	this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 0, 0, (int)(256), (int)(136));//136
            	GL11.glPopMatrix();
            	
            	GL11.glPushMatrix();
            	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
            	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_4_1.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_4_2.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_4_3.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_4_4.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_4_5.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_4_6.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
            	GL11.glScalef(1F, 1F, 1F);
            	GL11.glPopMatrix();
        	}
        }
        if(page == 31) {
        	{
            	
            	GL11.glPushMatrix();
            	GL11.glScalef(mozi_bai, mozi_bai, 1.0F);
            	GL11.glTranslatef(mozi_x, mozi_y, 0);//41/0
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_5_1.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 30, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_5_2.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 40, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_5_3.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 50, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_5_4.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 60, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_5_5.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 70, 0x000000);
            	fontReader.drawString(new TextComponentTranslation("gvcr2.string.pad.vehicle_ex_5_6.name", 
            			new Object[0]).getFormattedText(),  k + 20, l + 80, 0x000000);
            	GL11.glScalef(1F, 1F, 1F);
            	GL11.glPopMatrix();
        	}
        }
        
        
        
        
		GL11.glPopMatrix();
    }
    
    /**
     * 前が上にくるレシピID
     * 後ろが下にくるレシピ、ID999のとき反映されない
     * */
    private void drow_page_recipe(int id1, int id2, int k, int l, int mouseX, int mouseY) {
    	GL11.glPushMatrix();
    	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	float bairitu = 1F;
    	this.mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/crafting_table.png"));
    	GL11.glScalef(bairitu, bairitu, bairitu);
    	this.drawTexturedModalRect((k + 20) / bairitu, (l + 20) / bairitu, 26, 13, (int)(122), (int)(60));
    	this.drowRecipe(id1, (k + 20)  + 0, (l + 20)  + 0, mouseX, mouseY);
    	this.mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/crafting_table.png"));
    	if(id2 != 999) {
    		this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 26, 13, (int)(122), (int)(60));
    		this.drowRecipe(id2, (k + 20)  + 0, (l + 100)  + 0, mouseX, mouseY);
    	}
    	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	GL11.glPopMatrix();
    }
    
    /**
     * 前が上にくるレシピ
     * 後ろが下にくるレシピ、999のとき反映されない
     * */
    private void drow_page_smelting(int id1, int id2, int k, int l, int mouseX, int mouseY) {
    	GL11.glPushMatrix();
    	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	float bairitu = 1F;
    	this.mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/furnace.png"));
    	GL11.glScalef(bairitu, bairitu, bairitu);
    	this.drawTexturedModalRect((k + 20) / bairitu, (l + 20) / bairitu, 46, 13, (int)(100), (int)(60));
    	this.drowSmelting(id1, (k + 20)  + 0, (l + 20)  + 0, mouseX, mouseY);
    	this.mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/furnace.png"));
    	if(id2 != 999) {
    		this.drawTexturedModalRect((k + 20) / bairitu, (l + 100) / bairitu, 46, 13, (int)(100), (int)(60));
    		this.drowSmelting(id2, (k + 20)  + 0, (l + 100)  + 0, mouseX, mouseY);
    	}
    	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	GL11.glPopMatrix();
    }
    
    
    private void drowRecipe(int id, int x, int y, int mouseX, int mouseY) {
    	RenderItem renderitem = mc.getRenderItem();
    	FontRenderer fontReader = mc.fontRenderer;
    	GVCRecipe recipe = new GVCRecipe();
    	{
    		GL11.glPushMatrix();
    		ItemStack item = new ItemStack(recipe.item0[id]);
			if (!item.isEmpty()) 
			{
				int posx =   x + 98;
				int posy =   y + 22;
				renderitem.renderItemAndEffectIntoGUI(item, posx, posy);
				renderitem.renderItemOverlayIntoGUI(fontReader, item, posx, posy, null);
				boolean onitem = mouseX >= posx && mouseY >= posy && mouseX < posx + 16 && mouseY < posy + 16;
				if(onitem)
				{
					this.renderToolTip(item, mouseX, mouseY);
				}
				String d2 = String.format("%1$3d", recipe.item0_kazu[id]);
				fontReader.drawString(d2,  posx + 8, posy + 8, 0xFFFFFF);
			}
			GL11.glPopMatrix();
    	}
    	{
    		GL11.glPushMatrix();
    		ItemStack item = new ItemStack(recipe.item1[id]);
			if (!item.isEmpty()) {
				int posx =   x + 4;
				int posy =   y + 4;
				drawItemStack(item, posx, posy, null);
				boolean onitem = mouseX >= posx && mouseY >= posy && mouseX < posx + 16 && mouseY < posy + 16;
				if(onitem)
				{
					this.renderToolTip(item, mouseX, mouseY);
				}
			}
			GL11.glPopMatrix();
    	}
    	{
    		GL11.glPushMatrix();
    		ItemStack item = new ItemStack(recipe.item2[id]);
			if (!item.isEmpty()) {
				int posx =   x + 22;
				int posy =   y + 4;
				drawItemStack(item, posx, posy, null);
				boolean onitem = mouseX >= posx && mouseY >= posy && mouseX < posx + 16 && mouseY < posy + 16;
				if(onitem)
				{
					this.renderToolTip(item, mouseX, mouseY);
				}
			}
			GL11.glPopMatrix();
    	}
    	{
    		GL11.glPushMatrix();
    		ItemStack item = new ItemStack(recipe.item3[id]);
			if (!item.isEmpty()) {
				int posx =   x + 40;
				int posy =   y + 4;
				renderitem.renderItemIntoGUI(item, posx, posy);
				boolean onitem = mouseX >= posx && mouseY >= posy && mouseX < posx + 16 && mouseY < posy + 16;
				if(onitem)
				{
					this.renderToolTip(item, mouseX, mouseY);
				}
			}
			GL11.glPopMatrix();
    	}
    	{
    		GL11.glPushMatrix();
    		ItemStack item = new ItemStack(recipe.item4[id]);
			if (!item.isEmpty()) {
				int posx =   x + 4;
				int posy =   y + 22;
				renderitem.renderItemIntoGUI(item, posx, posy);
				boolean onitem = mouseX >= posx && mouseY >= posy && mouseX < posx + 16 && mouseY < posy + 16;
				if(onitem)
				{
					this.renderToolTip(item, mouseX, mouseY);
				}
			}
			GL11.glPopMatrix();
    	}
    	{
    		GL11.glPushMatrix();
    		ItemStack item = new ItemStack(recipe.item5[id]);
			if (!item.isEmpty()) {
				int posx =   x + 22;
				int posy =   y + 22;
				renderitem.renderItemIntoGUI(item, posx, posy);
				boolean onitem = mouseX >= posx && mouseY >= posy && mouseX < posx + 16 && mouseY < posy + 16;
				if(onitem)
				{
					this.renderToolTip(item, mouseX, mouseY);
				}
			}
			GL11.glPopMatrix();
    	}
    	{
    		GL11.glPushMatrix();
    		ItemStack item = new ItemStack(recipe.item6[id]);
			if (!item.isEmpty()) {
				int posx =   x + 40;
				int posy =   y + 22;
				renderitem.renderItemIntoGUI(item, posx, posy);
				boolean onitem = mouseX >= posx && mouseY >= posy && mouseX < posx + 16 && mouseY < posy + 16;
				if(onitem)
				{
					this.renderToolTip(item, mouseX, mouseY);
				}
			}
			GL11.glPopMatrix();
    	}
    	{
    		GL11.glPushMatrix();
    		ItemStack item = new ItemStack(recipe.item7[id]);
			if (!item.isEmpty()) {
				int posx =   x + 4;
				int posy =   y + 40;
				renderitem.renderItemIntoGUI(item, posx, posy);
				boolean onitem = mouseX >= posx && mouseY >= posy && mouseX < posx + 16 && mouseY < posy + 16;
				if(onitem)
				{
					this.renderToolTip(item, mouseX, mouseY);
				}
			}
			GL11.glPopMatrix();
    	}
    	{
    		GL11.glPushMatrix();
    		ItemStack item = new ItemStack(recipe.item8[id]);
			if (!item.isEmpty()) {
				int posx =   x + 22;
				int posy =   y + 40;
				renderitem.renderItemIntoGUI(item, posx, posy);
				boolean onitem = mouseX >= posx && mouseY >= posy && mouseX < posx + 16 && mouseY < posy + 16;
				if(onitem)
				{
					this.renderToolTip(item, mouseX, mouseY);
				}
			}
			GL11.glPopMatrix();
    	}
    	{
    		GL11.glPushMatrix();
    		ItemStack item = new ItemStack(recipe.item9[id]);
			if (!item.isEmpty()) {
				int posx =   x + 40;
				int posy =   y + 40;
				renderitem.renderItemIntoGUI(item, posx, posy);
				boolean onitem = mouseX >= posx && mouseY >= posy && mouseX < posx + 16 && mouseY < posy + 16;
				if(onitem)
				{
					this.renderToolTip(item, mouseX, mouseY);
				}
			}
			GL11.glPopMatrix();
    	}
    }
    
    private void drowSmelting(int id, int x, int y, int mouseX, int mouseY) {
    	RenderItem renderitem = mc.getRenderItem();
    	FontRenderer fontReader = mc.fontRenderer;
    	GVCRecipe recipe = new GVCRecipe();
    	{
    		GL11.glPushMatrix();
    		ItemStack item = recipe.item_output[id];//recipe.item_output[id];
			if (!item.isEmpty()) 
			{
				int posx =   x + 70;
				int posy =   y + 22;
				renderitem.renderItemAndEffectIntoGUI(item, posx, posy);
				renderitem.renderItemOverlayIntoGUI(fontReader, item, posx, posy, null);
				boolean onitem = mouseX >= posx && mouseY >= posy && mouseX < posx + 16 && mouseY < posy + 16;
				if(onitem)
				{
					this.renderToolTip(item, mouseX, mouseY);
				}
			}
			GL11.glPopMatrix();
    	}
    	{
    		GL11.glPushMatrix();
    		ItemStack item = new ItemStack(recipe.item_input[id]);
			if (!item.isEmpty()) {
				int posx =   x + 10;
				int posy =   y + 4;
				drawItemStack(item, posx, posy, null);
				boolean onitem = mouseX >= posx && mouseY >= posy && mouseX < posx + 16 && mouseY < posy + 16;
				if(onitem)
				{
					this.renderToolTip(item, mouseX, mouseY);
				}
			}
			GL11.glPopMatrix();
    	}
    }
    
    /**
     * Draws an ItemStack.
     *  
     * The z index is increased by 32 (and not decreased afterwards), and the item is then rendered at z=200.
     */
    private void drawItemStack(ItemStack stack, int x, int y, String altText)
    {
        GlStateManager.translate(0.0F, 0.0F, 32.0F);
        this.zLevel = 200.0F;
        this.itemRender.zLevel = 200.0F;
        net.minecraft.client.gui.FontRenderer font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = fontRenderer;
        this.itemRender.renderItemAndEffectIntoGUI(stack, x, y);
        this.itemRender.renderItemOverlayIntoGUI(font, stack, x, y, altText);
        this.zLevel = 0.0F;
        this.itemRender.zLevel = 0.0F;
    }
    
    /*GUIが開いている時にゲームの処理を止めるかどうか。*/
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
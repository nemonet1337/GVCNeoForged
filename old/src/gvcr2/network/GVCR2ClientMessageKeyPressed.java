package gvcr2.network;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 
public class GVCR2ClientMessageKeyPressed implements IMessage {
 
    public int key;
    public Entity keyentity;
    public double posx;
    public double posy;
    public double posz;
    public double posx1;
    public double posy1;
    public double posz1;
    public int da;
    public float gra;
    public float sp;
    public float kaku;
    public int fre;
    
    public int enid;
    public float strength;
    
    public int item_id;
 
    public GVCR2ClientMessageKeyPressed(){}
 
    public GVCR2ClientMessageKeyPressed(int i) {
        this.key = i;
    }
    
    public GVCR2ClientMessageKeyPressed(int i, int entity) {
        this.key = i;
        this.fre = entity;
    }
    
    public GVCR2ClientMessageKeyPressed(int i, int e, float s, double posx, double posy, double posz) {
    	this.key = i;
        this.enid = e;
        this.strength = s;
        this.posx = posx;
        this.posy = posy;
        this.posz = posz;
    }
    
    public GVCR2ClientMessageKeyPressed(int i, int e, double posx, double posy, double posz) {
    	this.key = i;
        this.enid = e;
        this.posx = posx;
        this.posy = posy;
        this.posz = posz;
    }
    
    public GVCR2ClientMessageKeyPressed(int i, double posx, double posy, double posz, int id, boolean flag) {
    	this.key = i;
        this.posx = posx;
        this.posy = posy;
        this.posz = posz;
        this.item_id = id;
    }
    
    
    @Override
    public void fromBytes(ByteBuf buf) {
        this.key = buf.readInt();
        this.posx = buf.readDouble();
        this.posy = buf.readDouble();
        this.posz = buf.readDouble();
        this.posx1 = buf.readDouble();
        this.posy1 = buf.readDouble();
        this.posz1 = buf.readDouble();
        this.da = buf.readInt();
        this.gra = buf.readFloat();
        this.sp = buf.readFloat();
        this.kaku = buf.readFloat();
        this.fre = buf.readInt();
        this.enid = buf.readInt();
        this.strength = buf.readFloat();
        this.item_id = buf.readInt();
    }
 
    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.key);
        buf.writeDouble(this.posx);
        buf.writeDouble(this.posy);
        buf.writeDouble(this.posz);
        buf.writeDouble(this.posx1);
        buf.writeDouble(this.posy1);
        buf.writeDouble(this.posz1);
        buf.writeInt(this.da);
        buf.writeFloat(this.gra);
        buf.writeFloat(this.sp);
        buf.writeFloat(this.kaku);
        buf.writeInt(this.fre);
        buf.writeInt(this.enid);
        buf.writeFloat(this.strength);
        buf.writeInt(this.item_id);
    }
}
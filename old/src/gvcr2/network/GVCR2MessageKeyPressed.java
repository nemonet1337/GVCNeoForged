package gvcr2.network;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 
public class GVCR2MessageKeyPressed implements IMessage {
 
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
    public int count;
 
    public GVCR2MessageKeyPressed(){}
 
    public GVCR2MessageKeyPressed(int i) {
        this.key = i;
    }
    
    public GVCR2MessageKeyPressed(int i, int j, boolean b) {
        this.key = i;
        this.count = j;
    }
    
    public GVCR2MessageKeyPressed(int i, int entity) {
        this.key = i;
        this.fre = entity;
    }
    
    public GVCR2MessageKeyPressed(Entity i) {
        this.keyentity = i;
    }
 
    public GVCR2MessageKeyPressed(int i, double posx, double posy, double posz, double posx1, double posy1, double posz1, 
    		int da, float gra, float sp, float kaku, int fre) {
    	this.key = i;
        this.posx = posx;
        this.posy = posy;
        this.posz = posz;
        this.posx1 = posx1;
        this.posy1 = posy1;
        this.posz1 = posz1;
        this.da = da;
        this.gra = gra;
        this.sp = sp;
        this.kaku = kaku;
        this.fre = fre;
    }
    
    public GVCR2MessageKeyPressed(int i, double posx, double posy, double posz) {
    	this.key = i;
        this.posx = posx;
        this.posy = posy;
        this.posz = posz;
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
    }
}
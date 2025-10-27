package gvcr2.network;

import gvcr2.mod_GVCR2;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class GVCR2PacketHandler {
 
    //このMOD用のSimpleNetworkWrapperを生成。チャンネルの文字列は固有であれば何でも良い。MODIDの利用を推奨。
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(mod_GVCR2.MOD_ID);
    public static final SimpleNetworkWrapper INSTANCE2 = NetworkRegistry.INSTANCE.newSimpleChannel(mod_GVCR2.MOD_ID + "client");
 
 
    public static void init() {
        INSTANCE.registerMessage(GVCR2MessageKeyPressedHandler.class, GVCR2MessageKeyPressed.class, 0, Side.SERVER);
        INSTANCE2.registerMessage(GVCR2ClientMessageKeyPressedHandler.class, GVCR2ClientMessageKeyPressed.class, 1, Side.CLIENT);
    }
}
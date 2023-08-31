package io.github.acubed.SkyblockHelper;

import io.github.acubed.SkyblockHelper.gui.ClickGUI;
import io.github.acubed.SkyblockHelper.handlers.LoginHandler;
import io.github.acubed.SkyblockHelper.modules.NetherWart;
import io.github.acubed.SkyblockHelper.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class SkyblockHelper
{

    public static KeyBinding[] keyBindings = new KeyBinding[1];

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS)
    public static ClientProxy proxy;

    @Instance("SkyblockHelper")
    public static SkyblockHelper instance;

    @EventHandler
    public void preInit(FMLInitializationEvent e)
    {
    }

    @EventHandler
    public void init(FMLInitializationEvent e)
    {
        MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new LoginHandler());
        MinecraftForge.EVENT_BUS.register(new NetherWart());

        keyBindings[0] = new KeyBinding("Open Config Menu", 157, "Skyblock Helper Mod");
        for (KeyBinding keyBinding : keyBindings) {
            ClientRegistry.registerKeyBinding(keyBinding);
        }
    }

    @EventHandler
    public void postInit(FMLInitializationEvent e)
    {
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent e)
    {
        if (keyBindings[0].isPressed()) {
            Minecraft.getMinecraft().displayGuiScreen(new ClickGUI());
        }
    }
}

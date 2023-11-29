package io.github.acubed.SkyblockHelper;

import io.github.acubed.SkyblockHelper.handlers.LoginHandler;
import io.github.acubed.SkyblockHelper.modules.macros.MacroHandler;
import io.github.acubed.SkyblockHelper.modules.macros.Sugarcane;
import io.github.acubed.SkyblockHelper.proxy.ClientProxy;
import io.github.acubed.SkyblockHelper.util.KeybindUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class SkyblockHelper
{
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
        KeybindUtils.setup();
        MinecraftForge.EVENT_BUS.register(new LoginHandler());
        MinecraftForge.EVENT_BUS.register(new KeybindUtils());
        MinecraftForge.EVENT_BUS.register(new Sugarcane());
        MinecraftForge.EVENT_BUS.register(new MacroHandler());

    }

    @EventHandler
    public void postInit(FMLInitializationEvent e)
    {
    }
}

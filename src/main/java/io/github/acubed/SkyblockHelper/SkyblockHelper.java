package io.github.acubed.SkyblockHelper;

import io.github.acubed.SkyblockHelper.events.loginHandler;
import io.github.acubed.SkyblockHelper.util.ChatUtils;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod(modid = "sbhelper", name = "Skyblock Helper", version = "1.0", acceptedMinecraftVersions = "1.8.9")
public class SkyblockHelper
{    
    @EventHandler
    public void init(FMLInitializationEvent e)
    {
		MinecraftForge.EVENT_BUS.register(new loginHandler());
    }
}

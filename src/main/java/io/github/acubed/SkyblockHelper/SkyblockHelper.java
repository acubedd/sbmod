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

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class SkyblockHelper
{    
    @EventHandler
    public void init(FMLInitializationEvent e)
    {
		MinecraftForge.EVENT_BUS.register(new loginHandler());
    }
}

package io.github.acubed.SkyblockHelper.events;

import io.github.acubed.SkyblockHelper.proxy.ClientProxy;
import io.github.acubed.SkyblockHelper.util.ChatUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class loginHandler {
    @SubscribeEvent
    public void onLogin(EntityJoinWorldEvent e) {
        if (e.entity != null && e.entity instanceof EntityPlayer) {
            ChatUtils.sendMessageToPlayer("commands and info for mod to be added");
        }
    }
}

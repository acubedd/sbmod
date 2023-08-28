package io.github.acubed.SkyblockHelper.events;

import io.github.acubed.SkyblockHelper.util.ChatUtils;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class loginHandler {
    @SubscribeEvent
    public void onLogin(PlayerEvent.PlayerLoggedInEvent e) {
        ChatUtils.sendMessageToPlayer((EntityPlayerMP) e.player, "commands and info for mod to be added");
    }
}

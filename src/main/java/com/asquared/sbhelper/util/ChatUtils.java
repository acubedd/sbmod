package com.asquared.sbhelper.util;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;

public class ChatUtils {
    public static void sendMessageToPlayer(EntityPlayerMP player, String message) {
        ChatComponentText msg = new ChatComponentText(message);
        player.addChatMessage(msg);
    }
}

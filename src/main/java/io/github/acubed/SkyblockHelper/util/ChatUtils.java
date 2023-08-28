package io.github.acubed.SkyblockHelper.util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class ChatUtils {
    public static void sendMessageToPlayer(String message) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(message));
    }
}

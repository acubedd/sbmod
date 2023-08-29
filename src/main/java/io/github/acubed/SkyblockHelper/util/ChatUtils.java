package io.github.acubed.SkyblockHelper.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class ChatUtils {
    public static void sendMessageToPlayer(String message) {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;

        if (player != null) {
            player.addChatMessage(new ChatComponentText(message));
        }
        else {
            
        }
    }
}

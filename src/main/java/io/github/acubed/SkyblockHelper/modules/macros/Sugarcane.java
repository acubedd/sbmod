package io.github.acubed.SkyblockHelper.modules.macros;

import io.github.acubed.SkyblockHelper.util.ChatUtils;
import io.github.acubed.SkyblockHelper.util.KeybindUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Sugarcane extends Macro {
    @Override
    public void onEnable() {
        ChatUtils.sendMessageToPlayer("Sugarcane Macro Enabled");
        KeybindUtils.updateKeys(true, false, false, false, false, false, false);
    }

    @Override
    public void onDisable() {
        ChatUtils.sendMessageToPlayer("Sugarcane Macro Disabled");
        KeybindUtils.stopMovement();
    }

















}

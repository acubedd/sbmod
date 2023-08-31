package io.github.acubed.SkyblockHelper.modules;

import io.github.acubed.SkyblockHelper.gui.Buttons;
import io.github.acubed.SkyblockHelper.util.ChatUtils;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class NetherWart {

    @SubscribeEvent
    public void onTick(ClientTickEvent e) {
        if(!Buttons.netherWart) {
            return;
        }
        //implement the module here


    }
}

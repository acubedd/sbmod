package io.github.acubed.SkyblockHelper.handlers;

import io.github.acubed.SkyblockHelper.util.ChatUtils;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;

public class LoginHandler {
    private boolean worldLoaded = false;
    private boolean clientConnected = false;

    @SubscribeEvent
    public void onLogin(ClientConnectedToServerEvent e) {
        this.clientConnected = true;

        System.out.println("*********Connected to server*********");
    }

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load e) {
        this.worldLoaded = true;

        System.out.println("*********World loaded*********");
    }

    @SubscribeEvent
    public void onTick(ClientTickEvent e) {
        if (this.worldLoaded && this.clientConnected) {
            this.worldLoaded = false;
            this.clientConnected = false;
            System.out.println("**************************************CONNECTED**************************************");

            ChatUtils.sendMessageToPlayer("commands and info for mod to be added");
        }
    }
}

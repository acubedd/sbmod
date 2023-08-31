package io.github.acubed.SkyblockHelper.handlers;

import io.github.acubed.SkyblockHelper.Reference;
import io.github.acubed.SkyblockHelper.gui.ClickGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class InputHandler {
    private KeyBinding[] keyBindings = new KeyBinding[1];

    public InputHandler() {
        keyBindings[0] = new KeyBinding("Open Config Menu", Reference.KEY, "Skyblock Helper Mod");
        for (KeyBinding keyBinding : keyBindings) {
            ClientRegistry.registerKeyBinding(keyBinding);
        }
        // Can we remove the for loop and instead register the keybinding directly?
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent e)
    {   
        if (keyBindings[0].isPressed()) {
            Minecraft.getMinecraft().displayGuiScreen(new ClickGUI());
        }
    }
}

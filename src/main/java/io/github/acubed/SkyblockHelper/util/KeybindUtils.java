package io.github.acubed.SkyblockHelper.util;

import io.github.acubed.SkyblockHelper.Reference;
import io.github.acubed.SkyblockHelper.gui.ClickGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeybindUtils {
    private static Minecraft mc = Minecraft.getMinecraft();

    public static KeyBinding[] keyBindings = new KeyBinding[2];

    public static void setup() {
        keyBindings[0] = new KeyBinding("Open Config Menu", Reference.OPEN_GUI_KEY, "Skyblock Helper Mod");
        keyBindings[1] = new KeyBinding("Toggle Macro Script", Reference.SCRIPT_KEY, "Skyblock Helper Mod");
        for (KeyBinding keyBinding : keyBindings) {
            ClientRegistry.registerKeyBinding(keyBinding);
        }
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent e)
    {
        if (keyBindings[0].isPressed()) {
            Minecraft.getMinecraft().displayGuiScreen(new ClickGUI());
        }
    }

    public static void updateKeys(boolean forward, boolean back, boolean right, boolean left, boolean attack) {
       updateKeys(forward, back, right, left, attack, false, false);
    }

    public static void updateKeys(boolean forward, boolean back, boolean right, boolean left, boolean attack, boolean crouch, boolean space) {
        if (mc.currentScreen != null) {
            stopMovement();
            return;
        }
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), forward);
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), back);
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), right);
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), left);
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), attack);
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), crouch);
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), space);
    }

    public static void stopMovement() {
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
    }
}

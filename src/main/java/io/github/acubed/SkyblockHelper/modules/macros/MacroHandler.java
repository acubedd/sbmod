package io.github.acubed.SkyblockHelper.modules.macros;

import io.github.acubed.SkyblockHelper.gui.ClickGUI;
import io.github.acubed.SkyblockHelper.util.ChatUtils;
import io.github.acubed.SkyblockHelper.util.KeybindUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import static io.github.acubed.SkyblockHelper.util.KeybindUtils.keyBindings;

public class MacroHandler {

    public static final Minecraft mc = Minecraft.getMinecraft();

    public static Macro currentMacro;

    public static boolean isMacroing;

    public static Sugarcane sugarcaneMacro = new Sugarcane();;

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent e)
    {
        if (keyBindings[1].isPressed()) {
            toggleMacro();
        }
    }

    public void toggleMacro() {
        if (isMacroing) {
            disableCurrentMacro();
        }
        else {
            enableMacro();
        }
    }

    public static void enableMacro() {
        /*
        TODO: add if statements code to set currentMacro to the current macro based on the crop type from a FarmConfig file
         */
        currentMacro = sugarcaneMacro;
        isMacroing = true;
        mc.thePlayer.closeScreen();

        enableCurrentMacro();
    }

    private static void enableCurrentMacro() {
        if(!currentMacro.enabled) {
            mc.inGameHasFocus = true;
            mc.displayGuiScreen(null);
            currentMacro.toggle();
        }
    }

    public static void disableCurrentMacro() {
        isMacroing = false;
        if(currentMacro.enabled) {
            currentMacro.toggle();
        }
    }

    //need a getFarmingCrop() method to update FarmConfig, it should detect what the player is looking at
}

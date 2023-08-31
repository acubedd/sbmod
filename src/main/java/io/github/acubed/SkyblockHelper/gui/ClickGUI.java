package io.github.acubed.SkyblockHelper.gui;

import io.github.acubed.SkyblockHelper.handlers.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.EnumChatFormatting;

public class ClickGUI extends GuiScreen {

    private GuiButton sugarCane;
    private GuiButton netherWart;
    private GuiButton autoSell;
    private GuiButton banChecker;
    private GuiButton close;

    public static boolean guiOpened = false;

    @Override
    public void initGui() {
        guiOpened = true;
        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        int height = sr.getScaledHeight();
        int width = sr.getScaledWidth();

        //GuiButton params: id, x, y, width, height, text
        this.sugarCane = new GuiButton(0, width / 2 - 100, height / 6 - 5, 200, 20, "");
        this.netherWart = new GuiButton(1, width / 2 - 100 - 110, height / 6 + 25, 200, 20, "");
        this.autoSell = new GuiButton(2, width / 2 - 100 + 110, height / 6 + 25, 200, 20, "");
        this.banChecker = new GuiButton(3, width / 2 - 100 - 110, height / 6 + 55, 200, 20, "");
        this.close = new GuiButton(4, width/2 - 100, height / 6 * 5, 200, 20, "Close");
        this.buttonList.add(this.sugarCane);
        this.buttonList.add(this.netherWart);
        this.buttonList.add(this.autoSell);
        this.buttonList.add(this.banChecker);
        this.buttonList.add(this.close);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        Minecraft mc = Minecraft.getMinecraft();

    }

    @Override
    public void actionPerformed(GuiButton button) {
        EntityPlayerSP playerSP = Minecraft.getMinecraft().thePlayer;
        switch (button.id) {
            case 0: //sugar cane
                Buttons.sugarCane = !Buttons.sugarCane;
                ConfigHandler.writeBooleanConfig("toggles", "caneToggled", Buttons.sugarCane);
                this.sugarCane.displayString = "Sugar Cane: " + getOnOff(Buttons.sugarCane);
                break;
            case 1: //nether wart
                Buttons.netherWart = !Buttons.netherWart;
                ConfigHandler.writeBooleanConfig("toggles", "wartToggled", Buttons.netherWart);
                this.netherWart.displayString = "Nether Wart: " + getOnOff(Buttons.netherWart);
                break;
            case 2: //auto sell
                Buttons.autoSell = !Buttons.autoSell;
                ConfigHandler.writeBooleanConfig("toggles", "autoSellToggled", Buttons.autoSell);
                this.autoSell.displayString = "Auto Sell: " + getOnOff(Buttons.autoSell);
                break;
            case 3: //ban checker
                Buttons.banChecker = !Buttons.banChecker;
                ConfigHandler.writeBooleanConfig("toggles", "banCheckerToggled", Buttons.banChecker);
                this.banChecker.displayString = "Ban Checker: " + getOnOff(Buttons.banChecker);
                break;
            case 4: //close
                playerSP.closeScreen();
                break;
        }
    }

    @Override
    public void onGuiClosed() {
        guiOpened = false;
    }

    public static String getOnOff(boolean enabled) {
        if (enabled) {
            return EnumChatFormatting.GREEN + "On";
        }
        return EnumChatFormatting.RED + "Off";
    }

}

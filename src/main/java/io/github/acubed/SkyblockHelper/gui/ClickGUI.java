package io.github.acubed.SkyblockHelper.gui;

import io.github.acubed.SkyblockHelper.handlers.ConfigHandler;
import io.github.acubed.SkyblockHelper.handlers.TextRenderer;
import io.github.acubed.SkyblockHelper.util.ChatUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.EnumChatFormatting;
import tv.twitch.chat.Chat;

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
        this.sugarCane = new GuiButton(0, width / 2 - 100 - 110, height / 6 + 55, 200, 20, "Sugar Cane: " + getOnOff(Buttons.sugarCane));
        this.netherWart = new GuiButton(1, width / 2 - 100 - 110, height / 6 + 25, 200, 20, "Nether Wart: " + getOnOff(Buttons.netherWart));
        this.autoSell = new GuiButton(2, width / 2 - 100 + 110, height / 6 + 25, 200, 20, "Auto Sell: " + getOnOff(Buttons.autoSell));
        this.banChecker = new GuiButton(3, width / 2 - 100 + 110, height / 6 + 55, 200, 20, "Ban Checker: " + getOnOff(Buttons.banChecker));
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
        String headerText = EnumChatFormatting.AQUA.toString() + EnumChatFormatting.BOLD + "Skyblock Helper";
        int width1 = mc.fontRendererObj.getStringWidth(headerText);
        TextRenderer.drawText(mc, headerText, this.width / 2 - width1 / 2, this.height / 6 - 25, 1.0D, false);

        super.drawScreen(mouseX, mouseY, partialTicks); //this makes the buttons actually show up instead of being invisible
    }

    @Override
    public void actionPerformed(GuiButton button) {
        EntityPlayerSP playerSP = Minecraft.getMinecraft().thePlayer;
        switch (button.id) {
            case 0: //sugar cane
                Buttons.sugarCane = !Buttons.sugarCane;
                ConfigHandler.writeBooleanConfig("toggles", "caneToggled", Buttons.sugarCane);
                this.sugarCane.displayString = "Sugar Cane: " + getOnOff(Buttons.sugarCane);
                ChatUtils.sendMessageToPlayer("Sugar Cane: " + getOnOff(Buttons.sugarCane));
                break;
            case 1: //nether wart
                Buttons.netherWart = !Buttons.netherWart;
                ConfigHandler.writeBooleanConfig("toggles", "wartToggled", Buttons.netherWart);
                this.netherWart.displayString = "Nether Wart: " + getOnOff(Buttons.netherWart);
                ChatUtils.sendMessageToPlayer("Nether Wart: " + getOnOff(Buttons.netherWart));
                break;
            case 2: //auto sell
                Buttons.autoSell = !Buttons.autoSell;
                ConfigHandler.writeBooleanConfig("toggles", "autoSellToggled", Buttons.autoSell);
                this.autoSell.displayString = "Auto Sell: " + getOnOff(Buttons.autoSell);
                ChatUtils.sendMessageToPlayer("Auto Sell: " + getOnOff(Buttons.autoSell));
                break;
            case 3: //ban checker
                Buttons.banChecker = !Buttons.banChecker;
                ConfigHandler.writeBooleanConfig("toggles", "banCheckerToggled", Buttons.banChecker);
                this.banChecker.displayString = "Ban Checker: " + getOnOff(Buttons.banChecker);
                ChatUtils.sendMessageToPlayer("Ban Checker: " + getOnOff(Buttons.banChecker));
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

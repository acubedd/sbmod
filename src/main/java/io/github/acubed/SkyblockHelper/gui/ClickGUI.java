package io.github.acubed.SkyblockHelper.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

public class ClickGUI extends GuiScreen {

    private GuiButton sugarCane;
    private GuiButton netherWart;
    private GuiButton autoSell;
    private GuiButton banChecker;

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


    }

}

package io.github.acubed.SkyblockHelper.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.StringUtils;

public class TextRenderer extends Gui {
    public static void drawText(Minecraft mc, String text, int x, int y, double scale, boolean outline) {
        GlStateManager.pushMatrix();
        GlStateManager.scale(scale, scale, scale);
        y = y - mc.fontRendererObj.FONT_HEIGHT;
        for(String line : text.split("\n")) { //split each word with new line
            y = (int) (y + mc.fontRendererObj.FONT_HEIGHT * scale);
            if(outline) {
                String noColorLine = StringUtils.stripControlCodes(line); //remove colors from the string
                //drawString params: text, x, y, color, dropShadow
                //purpose of 5 drawStrings is to create an outline effect
                mc.fontRendererObj.drawString(noColorLine, (int) (Math.round(x / scale) - 1), (int) Math.round(y / scale), 0, false);
                mc.fontRendererObj.drawString(noColorLine, (int) (Math.round(x / scale) + 1), (int) Math.round(y / scale), 0, false);
                mc.fontRendererObj.drawString(noColorLine, (int) Math.round(x / scale), ((int) Math.round(y / scale) - 1), 0, false);
                mc.fontRendererObj.drawString(noColorLine, (int) Math.round(x / scale), ((int) Math.round(y / scale) + 1), 0, false);
                mc.fontRendererObj.drawString(line, (int) Math.round(x / scale), (int) Math.round(y / scale), 16777215, false);
            } else {
                mc.fontRendererObj.drawString(line, (int) Math.round(x / scale), (int) Math.round(y / scale), 16777215, true);
            }
        }

        //popMatrix purpose is to restore the state of the matrix when you pushed it. If you don't do this GL will be broken.
        GlStateManager.popMatrix();
        //color params: red, green, blue, alpha
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }
}


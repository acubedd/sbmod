package io.github.acubed.SkyblockHelper.handlers;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {
    public static Configuration config;

    private static final String file = "config/SkyblockHelper.cfg";

    public boolean doesGuiPauseGame() {
        return false;
    }

    public static void init() {
        config = new Configuration(new File(file));
        try {
            config.load();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            config.save();
        }
    }

    public static void writeBooleanConfig(String category, String key, boolean value) {
        config = new Configuration(new File(file));
        try {
            config.load();
            boolean set = config.get(category, key, value).getBoolean();
            config.getCategory(category).get(key).set(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            config.save();
        }
    }
}

package io.github.acubed.SkyblockHelper.modules.macros;

public abstract class Macro {
    public boolean enabled = false;

    public void toggle() {
        this.enabled = !this.enabled;
        if (this.enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void onEnable() {}

    public void onDisable() {}

    public void onTick() {}

    public void onChatMessageReceived(String msg) {}
}

package io.github.acubed.SkyblockHelper.modules;

public class Module {
    private boolean toggled = false;

    public boolean isToggled() {
        return this.toggled;
    }

    public void toggle() {
        this.toggled = !this.toggled;

        if (this.toggled) {
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

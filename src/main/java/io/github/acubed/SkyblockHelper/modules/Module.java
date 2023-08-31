package io.github.acubed.SkyblockHelper.modules;

public class Module {
    private String name;
    private boolean toggled;

    public Module(String name) {
        this.name = name;
    }

    public boolean isToggled() {
        return this.toggled;
    }

    public String getName() {
        return this.name;
    }

    public void toggle() {
        this.toggled = !this.toggled;

        if (this.toggled) {
            this.onEnable();
        } else {
            this.onDisable();
        }
    }

    public void onEnable() {
    }

    public void onDisable() {
    }
}

package nl.vloedje.stayyoung;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(new PlayerInteractEntityListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

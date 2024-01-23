package hardbuckaroo.goplantyourself;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class GoPlantYourself extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(new SaplingWatcher(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

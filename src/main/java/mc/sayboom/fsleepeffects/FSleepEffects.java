package mc.sayboom.fsleepeffects;

import mc.sayboom.fsleepeffects.config.ConfigListener;
import mc.sayboom.fsleepeffects.utils.FCommands;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class FSleepEffects extends JavaPlugin {

    @Override
    public void onEnable() {
        File config = new File(getDataFolder(), "config.yml");
        if (!config.exists()) {
            saveDefaultConfig();
        }
        ConfigListener configListener = new ConfigListener(getConfig());
        getServer().getPluginManager().registerEvents(configListener, this);
        FCommands reloadCommand = new FCommands(this, configListener);
        getCommand("fslp").setExecutor(reloadCommand);
        getCommand("fslp").setTabCompleter(reloadCommand);
    }
}

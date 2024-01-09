package mc.sayboom.fsleepeffects.utils;

import mc.sayboom.fsleepeffects.config.ConfigListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class FCommands implements CommandExecutor, TabCompleter {
    private JavaPlugin plugin;
    private ConfigListener configListener;

    public FCommands(JavaPlugin plugin, ConfigListener configListener) {
        this.plugin = plugin;
        this.configListener = configListener;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("fslp")) {
            if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
                plugin.reloadConfig();
                configListener.reloadConfig(plugin.getConfig());
                sender.sendMessage("Плагин был перезагружен.");
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("fslp")) {
            if (args.length == 1) {
                List<String> list = new ArrayList<>();
                list.add("reload");
                return list;
            }
        }
        return new ArrayList<>();
    }
}



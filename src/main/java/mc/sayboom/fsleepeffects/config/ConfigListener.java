package mc.sayboom.fsleepeffects.config;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

import java.util.List;

public class ConfigListener implements Listener {
    private FileConfiguration config;

    public ConfigListener(FileConfiguration config) {
        this.config = config;
    }

    public void reloadConfig(FileConfiguration newConfig) {
        this.config = newConfig;
    }

    @EventHandler
    public void onPlayerWake(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        List<String> effects = config.getStringList("EFFECTS");

        for (String effect : effects) {
            String[] parts = effect.split(";");
            if (parts.length != 3) {
                continue;
            }

            PotionEffectType type = PotionEffectType.getByName(parts[0]);
            if (type == null) {
                continue;
            }

            int duration;
            int level;
            try {
                duration = Integer.parseInt(parts[1]);
                level = Integer.parseInt(parts[2]) - 1; // Subtract 1 from the level
            } catch (NumberFormatException e) {
                continue;
            }

            PotionEffect potionEffect = new PotionEffect(type, duration * 20, level);
            player.addPotionEffect(potionEffect);
        }
    }
}

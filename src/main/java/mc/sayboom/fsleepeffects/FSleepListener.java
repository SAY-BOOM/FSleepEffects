package mc.sayboom.fsleepeffects;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class FSleepListener implements Listener {

    @EventHandler
    public void onPlayerWake(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        PotionEffect blindness = new PotionEffect(PotionEffectType.BLINDNESS, 200, 1);
        player.addPotionEffect(blindness);
    }
}

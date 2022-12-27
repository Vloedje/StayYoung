package nl.vloedje.stayyoung;

import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Breedable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerInteractEntityListener implements Listener {

    Main plugin;

    public PlayerInteractEntityListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        FileConfiguration config = plugin.getConfig();
        if (!event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.valueOf(config.getString("trigger_item")))) return;

        if (!(event.getRightClicked() instanceof Breedable breedable)) return;

        if (config.getBoolean("debug")) {
            plugin.getLogger().info(String.format("Player tried to age lock entity %s, lock: %s, is baby: %s", breedable.getName(), breedable.getAgeLock(), !breedable.isAdult()));
        }

        if (breedable.isAdult()) return;

        if (breedable.getAgeLock()) {
            event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.valueOf(config.getString("failure_sound")), 1, 1);
            return;
        }

        breedable.setAgeLock(true);

        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.valueOf(config.getString("success_sound")), 1, 1);

        Location loc = event.getRightClicked().getLocation();
        event.getPlayer().spawnParticle(Particle.valueOf(config.getString("success_particle")), loc.getX(), loc.getY() + 0.75, loc.getZ(), 5, 0.5, 0.25, 0.5);

    }
}

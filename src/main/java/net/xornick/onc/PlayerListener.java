package net.xornick.onc;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by xorboone on 1/2/17.
 */
public class PlayerListener implements Listener {

    private OldNameChecker onc;

    public PlayerListener(OldNameChecker onc) {
        this.onc = onc;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String UUID = event.getPlayer().getUniqueId().toString();

        if (!event.getPlayer().hasPermission("oldnamechecker.bypass")) {
            onc.fetchNameHistory(UUID);
            // TODO: Something here. Likely will broadcast a message to all staff alerting that the user has previous name history.
        }
    }
}

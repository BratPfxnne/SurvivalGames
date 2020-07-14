package de.brati.sg.Listeners;
// This Class is created by BratPfxnne
// BratPfxnne is a cool Dude ;D
// ._.
// :V

import de.brati.sg.GameStates.EndingState;
import de.brati.sg.GameStates.LobbyState;
import de.brati.sg.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import javax.xml.stream.events.EndDocument;

public class PlayerDropListener implements Listener {

    private Main plugin;

    public PlayerDropListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if(plugin.getGameStateManager().getCurrentGameState() instanceof LobbyState) {
            if(!e.getPlayer().hasPermission("sg.build")) {
                e.setCancelled(true);
            }
        }
        if(plugin.getGameStateManager().getCurrentGameState() instanceof EndingState) {
            if(!e.getPlayer().hasPermission("sg.build")) {
                e.setCancelled(true);
            }
        }
    }


}


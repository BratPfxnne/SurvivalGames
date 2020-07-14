package de.brati.sg.Listeners;
// This Class is created by BratPfxnne
// BratPfxnne is a cool Dude ;D
// ._.
// :V

import de.brati.sg.GameStates.EndingState;
import de.brati.sg.GameStates.LobbyState;
import de.brati.sg.GameStates.ProtectState;
import de.brati.sg.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerHungerListener implements Listener {

    private Main plugin;

    public PlayerHungerListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent e) {
        Player p = (Player) e.getEntity();
        if(this.plugin.getGameStateManager().getCurrentGameState() instanceof LobbyState) {
            e.setCancelled(true);
            e.setFoodLevel(20);
        }
        if(this.plugin.getGameStateManager().getCurrentGameState() instanceof ProtectState) {
            e.setFoodLevel(20);
            e.setCancelled(true);
        }
        if(this.plugin.getGameStateManager().getCurrentGameState() instanceof EndingState) {
            e.setFoodLevel(20);
            e.setCancelled(true);
        }
    }


}


// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.Listeners;

import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.EventHandler;
import de.brati.sg.GameStates.EndingState;
import de.brati.sg.GameStates.ProtectState;
import de.brati.sg.GameStates.LobbyState;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import de.brati.sg.Main;
import org.bukkit.event.Listener;

public class PlayerDamageListener implements Listener
{
    private Main plugin;
    
    public PlayerDamageListener(final Main plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void ondamage(final EntityDamageByEntityEvent e) {
        final Player p = (Player)e.getEntity();
        if (e.getDamager() instanceof Player && this.plugin.getGameStateManager().getCurrentGameState() instanceof LobbyState) {
            e.setCancelled(true);
        }
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        final Player damager = (Player)e.getDamager();
        if (this.plugin.getGameStateManager().getCurrentGameState() instanceof LobbyState) {
            e.setCancelled(true);
        }
        if (this.plugin.getGameStateManager().getCurrentGameState() instanceof ProtectState) {
            e.setCancelled(true);
        }
        if (this.plugin.getGameStateManager().getCurrentGameState() instanceof EndingState) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageEvent(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            e.setCancelled(true);
            if (this.plugin.getGameStateManager().getCurrentGameState() instanceof EndingState) {
                e.setCancelled(true);
            }
            if (this.plugin.getGameStateManager().getCurrentGameState() instanceof LobbyState) {
                e.setCancelled(true);
            }
            if (this.plugin.getGameStateManager().getCurrentGameState() instanceof ProtectState) {
                e.setCancelled(true);
            }
        }
    }
}

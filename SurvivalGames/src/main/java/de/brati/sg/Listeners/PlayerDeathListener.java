// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.Listeners;

import org.bukkit.event.EventHandler;
import de.brati.sg.voting.Map;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import de.brati.sg.utils.CheckEnding;
import de.brati.sg.GameStates.ProtectState;
import org.bukkit.GameMode;
import de.brati.sg.utils.ConfigLocationUtil;
import org.bukkit.event.entity.PlayerDeathEvent;
import de.brati.sg.Main;
import org.bukkit.event.Listener;

public class PlayerDeathListener implements Listener
{
    private Main plugin;
    
    public PlayerDeathListener(final Main plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onDeath(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        final Player killer = p.getKiller();
        final Map maap = this.plugin.getVoting().getWinnerMap();
        maap.load();
        final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".Spectator");
        p.setGameMode(GameMode.SPECTATOR);
        if (ProtectState.getPlayers().contains(p)) {
            ProtectState.getPlayers().remove(p);
            CheckEnding.check();
            e.setDeathMessage(Main.getPREFIX() + "§aDer Spieler §6" + killer.getName() + "§a hat den Spieler §6" + p.getName() + "§a umgebracht!");
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.spigot().respawn();
                    p.teleport(spawn.loadLocation());
                }
            }, 5);
        }
        else {
            e.setDeathMessage((String)null);
        }
    }
}

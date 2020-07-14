// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import de.brati.sg.utils.CheckEnding;
import de.brati.sg.GameStates.DeathmatchState;
import de.brati.sg.GameStates.IngameState;
import de.brati.sg.GameStates.ProtectState;
import org.bukkit.event.player.PlayerQuitEvent;
import de.brati.sg.GameStates.LobbyState;
import de.brati.sg.Countdowns.LobbyCountdown;
import de.brati.sg.voting.Voting;
import de.brati.sg.Main;
import org.bukkit.event.Listener;

public class PlayerQuitListener implements Listener
{
    private Main plugin;
    private Voting voting;
    private LobbyCountdown lobbyCountdown;
    
    public PlayerQuitListener(final Main plugin) {
        this.lobbyCountdown = LobbyState.getCountdown();
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onQuit(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        if (this.plugin.getGameStateManager().getCurrentGameState() instanceof LobbyState) {
            if (this.plugin.getPlayers().contains(p)) {
                this.plugin.getPlayers().remove(p);
                e.setQuitMessage(Main.getPREFIX() + "§aDer Spieler §6" + p.getName() + "§a hat das Spiel verlassen §6[§a" + this.plugin.getPlayers().size() + "§6/§a" + LobbyState.MAX_PLAYERS + "§6]");
                if (this.plugin.getPlayers().size() < 2) {
                    this.lobbyCountdown.stop();
                    this.lobbyCountdown.startIdle();
                }
            }
            else {
                e.setQuitMessage((String)null);
            }
        }
        else if (this.plugin.getGameStateManager().getCurrentGameState() instanceof ProtectState || this.plugin.getGameStateManager().getCurrentGameState() instanceof IngameState || this.plugin.getGameStateManager().getCurrentGameState() instanceof DeathmatchState) {
            if (this.plugin.getPlayers().contains(p)) {
                this.plugin.getPlayers().remove(p);
                CheckEnding.check();
                e.setQuitMessage(Main.getPREFIX() + "§aDer Spieler §6" + p.getName() + "§a hat das Spiel verlassen §6[§a" + this.plugin.getPlayers().size() + "§6/§a" + LobbyState.MAX_PLAYERS + "§6]");
            }
            else {
                e.setQuitMessage((String)null);
            }
        }
        if (ProtectState.getPlayers().contains(p)) {
            ProtectState.getPlayers().remove(p);
            CheckEnding.check();
        }
    }
}

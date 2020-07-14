// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.Commands;

import org.bukkit.Bukkit;
import de.brati.sg.Countdowns.LobbyCountdown;
import de.brati.sg.GameStates.LobbyState;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import de.brati.sg.Main;
import org.bukkit.command.CommandExecutor;

public class Start_CMD implements CommandExecutor
{
    private Main plugin;
    
    public Start_CMD(final Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player p = (Player)sender;
        if (!p.hasPermission("ft13.start")) {
            p.sendMessage(Main.getPREFIX() + "§cDazu hast du keine Rechte!");
            return true;
        }
        if (this.plugin.getGameStateManager().getCurrentGameState() instanceof LobbyState) {
            if (LobbyCountdown.isRunning()) {
                if (this.plugin.getPlayers().contains(p)) {
                    if (this.plugin.getPlayers().size() >= LobbyState.MIN_PLAYERS) {
                        if (LobbyCountdown.getSeconds() >= 5) {
                            LobbyCountdown.setSeconds(5);
                            Bukkit.broadcastMessage(Main.getPREFIX() + "§aDer Spieler §6 " + p.getName() + "§a hat den Spielstart verk\u00fcrzt!");
                        }
                        else {
                            p.sendMessage(Main.getPREFIX() + "§cDu kannst nicht mehr das Spiel schneller starten!");
                        }
                    }
                    else {
                        p.sendMessage(Main.getPREFIX() + "§cEs m\u00fcssen 2 Spieler online seiN!");
                    }
                }
                else {
                    p.sendMessage(Main.getPREFIX() + "§cBitte einmal rejoinen!");
                }
            }
            else {
                p.sendMessage(Main.getPREFIX() + "§cDu kannst das nur in der Lobby machen!");
            }
            return false;
        }
        return false;
    }
}

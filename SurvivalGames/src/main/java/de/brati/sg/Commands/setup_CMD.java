// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.Commands;

import de.brati.sg.GameStates.LobbyState;
import de.brati.sg.voting.Map;
import de.brati.sg.utils.ConfigLocationUtil;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import de.brati.sg.Main;
import org.bukkit.command.CommandExecutor;

public class setup_CMD implements CommandExecutor
{
    private Main plugin;
    
    public setup_CMD(final Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player p = (Player)sender;
        if (!p.hasPermission("SG.setup")) {
            p.sendMessage(Main.getPREFIX() + "§cDazu hast du keine Rechte!");
            return true;
        }
        if (args.length == 0) {
            p.sendMessage(Main.getPREFIX() + "§cBitte benutze §6/setup <LOBBY>§c!");
        }
        else if (args[0].equalsIgnoreCase("lobby")) {
            if (args.length == 1) {
                new ConfigLocationUtil(this.plugin, p.getLocation(), "SG.Spawns.Lobby").saveLocation();
                p.sendMessage(Main.getPREFIX() + "§aDie Lobby wurde gesetzt!");
            }
            else {
                p.sendMessage(Main.getPREFIX() + "§cBitte benutze §6/setup lobby§c!");
            }
        }
        else if (args[0].equalsIgnoreCase("create")) {
            if (args.length == 3) {
                final Map map = new Map(this.plugin, args[1]);
                if (!map.exists()) {
                    map.create(args[2]);
                    p.sendMessage(Main.getPREFIX() + "§aDie Map wurde erstellt!");
                }
                else {
                    p.sendMessage(Main.getPREFIX() + "§cDiese Map existiert bereits!");
                }
            }
            else {
                p.sendMessage(Main.getPREFIX() + "§cBitte benutze §6/setup create <NAME> <ERBAUEER>§c!");
            }
        }
        else if (args[0].equalsIgnoreCase("set")) {
            if (args.length == 3) {
                final Map map = new Map(this.plugin, args[1]);
                if (map.exists()) {
                    try {
                        final int spawnNumber = Integer.parseInt(args[2]);
                        if (spawnNumber > 0 && spawnNumber <= LobbyState.MAX_PLAYERS) {
                            map.setSpawnLocation(spawnNumber, p.getLocation());
                            p.sendMessage(Main.getPREFIX() + "§aDu hast den Spawn §6" + spawnNumber + "§a f\u00fcr die Map §6" + map.getName() + "§a gesetzt!");
                        }
                        else {
                            p.sendMessage(Main.getPREFIX() + "§cBitte gebe eine Zahl zwischen 1 und " + LobbyState.MAX_PLAYERS + "§c an!");
                        }
                    }
                    catch (NumberFormatException e) {
                        if (args[2].equalsIgnoreCase("spectator")) {
                            map.setSpectatorLocation(p.getLocation());
                            p.sendMessage(Main.getPREFIX() + "§aDu hast den Spawn f\u00fcr die Spectator gesetzt!");
                        }
                        else {
                            p.sendMessage(Main.getPREFIX() + "§cEine Spawnnumber muss immer eine Zahl sein!");
                        }
                    }
                }
                else {
                    p.sendMessage(Main.getPREFIX() + "§cDiese Map existiert noch nicht!");
                }
            }
            else {
                p.sendMessage(Main.getPREFIX() + "§cBitte benutze §6/setup set <NAME> <1- " + LobbyState.MAX_PLAYERS + " // Spectator");
            }
        }
        return false;
    }
}

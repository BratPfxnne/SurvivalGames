// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.Commands;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import de.brati.sg.voting.Voting;
import de.brati.sg.Main;
import org.bukkit.command.CommandExecutor;

public class forcemap_CMD implements CommandExecutor
{
    private Main plugin;
    private Voting voting;
    
    public forcemap_CMD(final Main plugin) {
        this.plugin = plugin;
        this.voting = plugin.getVoting();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player p = (Player)sender;
        if (!p.hasPermission("sg.forcemap")) {
            p.sendMessage(Main.getPREFIX() + "§cDazu hast du keine Rechte!");
            return true;
        }
        if (this.voting.getVotingInventory().getItem(3).getItemMeta().getDisplayName().equalsIgnoreCase(args[0])) {
            for (int i = 1; i < 100; ++i) {
                final String s = String.valueOf(i);
                this.voting.getPlayervotes().put(s, 3);
            }
        }
        else {
            if (!this.voting.getVotingInventory().getItem(5).getItemMeta().getDisplayName().equalsIgnoreCase(args[0])) {
                p.sendMessage(Main.getPREFIX() + "§cDie Map wurde nicht gefunden.");
                return true;
            }
            for (int i = 1; i < 100; ++i) {
                final String s = String.valueOf(i);
                this.voting.getPlayervotes().put(s, 5);
            }
        }
        p.sendMessage(Main.getPREFIX() + "§aDie Map wurde wurde erfolgreich geforced");
        return false;
    }
}

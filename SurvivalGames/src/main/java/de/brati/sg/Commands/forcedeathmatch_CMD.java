// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.Commands;

import de.brati.sg.Countdowns.DeathmatchCount;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import de.brati.sg.Main;
import org.bukkit.command.CommandExecutor;

public class forcedeathmatch_CMD implements CommandExecutor
{
    private Main plugin;
    
    public forcedeathmatch_CMD(final Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player p = (Player)sender;
        if (!p.hasPermission("sg.forcedeathmatch")) {
            p.sendMessage(Main.getPREFIX() + "§cDazu hast du keine Rechte!");
            return true;
        }
        DeathmatchCount.setSeconds(10);
        p.sendMessage(Main.getPREFIX() + "§aDas Deathmatch wurde erfolgreich erstellt");
        return false;
    }
}

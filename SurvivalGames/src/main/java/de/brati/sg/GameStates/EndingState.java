// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.GameStates;

import de.brati.sg.Main;
import org.bukkit.plugin.Plugin;
import java.util.Iterator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import de.brati.sg.Countdowns.EndingCountdown;

public class EndingState extends GameState
{
    private EndingCountdown endingCountdown;
    private Main plugin;
    
    public EndingState(Main plugin
    ) {
        this.plugin = plugin;
        this.endingCountdown = new EndingCountdown(plugin);
    }
    
    @Override
    public void start() {
        this.endingCountdown.start();
        Bukkit.getScheduler().runTaskLater((Plugin)GameStateManager.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                for (final Player all : Bukkit.getOnlinePlayers()) {
                    all.setGameMode(GameMode.ADVENTURE);
                    all.teleport(GameStateManager.getPlugin().getLobby().loadLocation());
                    all.getInventory().clear();
                    all.getInventory().setArmorContents((ItemStack[])null);
                }
            }
        }, 100L);
    }
    
    @Override
    public void stop() {
    }
}

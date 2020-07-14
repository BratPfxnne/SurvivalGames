// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.GameStates;

import java.util.Iterator;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import de.brati.sg.Countdowns.DeathmatchCount;
import de.brati.sg.Main;

public class IngameState extends GameState
{
    private Main plugin;
    GameStateManager gameStateManager;
    private static DeathmatchCount deathmatchcountdown;
    
    public IngameState(final Main plugin, final GameStateManager gameStateManager) {
        this.plugin = plugin;
        this.gameStateManager = gameStateManager;
        IngameState.deathmatchcountdown = new DeathmatchCount(gameStateManager, plugin);
    }
    
    @Override
    public void start() {
        Bukkit.broadcastMessage(Main.getPREFIX() + "§aDie Schutzphase ist vorbei!");
        for (final Player all : ProtectState.getPlayers()) {
            all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0f, 1.0f);
        }
        IngameState.deathmatchcountdown.start();
    }
    
    @Override
    public void stop() {
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import de.brati.sg.GameStates.DeathmatchState;
import de.brati.sg.GameStates.ProtectState;
import de.brati.sg.GameStates.IngameState;
import de.brati.sg.GameStates.GameStateManager;
import de.brati.sg.Main;

public class CheckEnding
{
    private static Main plugin;
    private GameStateManager gameStateManager;
    
    public CheckEnding(final Main plugin) {
        CheckEnding.plugin = plugin;
        this.gameStateManager = new GameStateManager(plugin);
    }
    
    public static void check() {
        if ((GameStateManager.getPlugin().getGameStateManager().getCurrentGameState() instanceof IngameState || GameStateManager.getPlugin().getGameStateManager().getCurrentGameState() instanceof ProtectState || GameStateManager.getPlugin().getGameStateManager().getCurrentGameState() instanceof DeathmatchState) && ProtectState.getPlayers().size() <= 1) {
            final Player Winner = ProtectState.getPlayers().get(0);
            if (Winner == null) {
                return;
            }
            for(Player current : Bukkit.getOnlinePlayers()) {
                current.sendTitle(ChatColor.GOLD + "BratPfxnne", "§aHat das Spiel Gewonnen!");
                current.playSound(current.getLocation(), Sound.ENDERDRAGON_DEATH, 10L, 10L);
            }
            GameStateManager.getPlugin().getGameStateManager().setGameState(4);
        }
    }
}

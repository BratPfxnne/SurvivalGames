// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.Countdowns;

import org.bukkit.plugin.Plugin;
import java.util.Iterator;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import de.brati.sg.GameStates.ProtectState;
import de.brati.sg.Main;
import org.bukkit.Bukkit;
import de.brati.sg.GameStates.GameStateManager;

public class ProtectCountdown extends Countdown
{
    private static final int PROTECT_COUNTDOWN = 20;
    private int seconds;
    private GameStateManager gameStateManager;
    public boolean isRunning;
    private Main plugin;
    private int taskID;
    
    public ProtectCountdown(final GameStateManager gameStateManager, Main plugin) {
            this.plugin = plugin;
            this.gameStateManager = gameStateManager;
            this.isRunning = false;
            seconds = plugin.getProtect_Countdown();
    }
    
    @Override
    public void start() {
        System.out.println(seconds);
        this.isRunning = true;
        this.taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)GameStateManager.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                ProtectCountdown.this.seconds--;
                for(Player players : ProtectState.getPlayers()) {
                    players.setLevel(seconds);
                }
                switch (ProtectCountdown.this.seconds) {
                    case 2:
                    case 3:
                    case 5:
                    case 10:
                    case 15:
                    case 20:
                    case 30: {
                        Bukkit.broadcastMessage(Main.getPREFIX() + "§aDie Schutzphase endet in §6" + ProtectCountdown.this.seconds + "§a Sekunden!");
                        for (final Player current : ProtectState.getPlayers()) {
                            current.setLevel(ProtectCountdown.this.seconds);
                            current.playSound(current.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                        }
                        break;
                    }
                    case 1: {
                        Bukkit.broadcastMessage(Main.getPREFIX() + "§aDie Schutzphase endet in §6" + ProtectCountdown.this.seconds + "§a Sekunde!");
                        for (final Player current : ProtectState.getPlayers()) {
                            current.setLevel(ProtectCountdown.this.seconds);
                            current.playSound(current.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                        }
                        break;
                    }
                    case 0: {
                        GameStateManager.getPlugin().getGameStateManager().setGameState(2);
                        break;
                    }
                }
            }
        }, 0L, 20L);
    }
    
    @Override
    public void stop() {
        if (this.isRunning) {
            Bukkit.getScheduler().cancelTask(this.taskID);
            this.isRunning = false;
        }
    }

    public int getTaskID() {
        return taskID;
    }
}

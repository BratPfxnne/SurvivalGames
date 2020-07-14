// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.Countdowns;

import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.plugin.Plugin;
import java.util.Iterator;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import de.brati.sg.Main;
import de.brati.sg.GameStates.GameStateManager;

public class LobbyCountdown extends Countdown
{
    private GameStateManager gameStateManager;
    private Main plugin;
    private int idleID;
    private boolean isIdling;
    private static boolean isRunning;
    private static final int IDLE_TIME = 15;
    private static final int COUNTDOWN_TIME = 31;
    private static int seconds;
    
    public LobbyCountdown(final GameStateManager gameStateManager, Main plugin) {
        this.gameStateManager = gameStateManager;
        this.plugin = plugin;
        LobbyCountdown.seconds = plugin.getLobby_Countdown();
    }
    
    @Override
    public void start() {
        System.out.println(seconds);
        this.stopIdle();
        LobbyCountdown.isRunning = true;
        final BukkitScheduler scheduler = Bukkit.getScheduler();
        final GameStateManager gameStateManager = this.gameStateManager;
        this.taskID = scheduler.scheduleSyncRepeatingTask((Plugin)GameStateManager.getPlugin(), new Runnable() {
            @Override
            public void run() {
                LobbyCountdown.seconds--;
                for (final Player all : Bukkit.getOnlinePlayers()) {
                    all.setLevel(LobbyCountdown.seconds);
                }
                switch (LobbyCountdown.seconds) {
                    case 2:
                    case 3:
                    case 5:
                    case 10:
                    case 15:
                    case 20:
                    case 30: {
                        Bukkit.broadcastMessage(Main.getPREFIX() + "§aDas Spiel startet in §6" + LobbyCountdown.seconds + "§a Sekunden§a!");
                        for (final Player all : Bukkit.getOnlinePlayers()) {
                            all.playSound(all.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                        }
                        break;
                    }
                    case 1: {
                        Bukkit.broadcastMessage(Main.getPREFIX() + "§aDas Spiel startet in §61 §aSekunde§a!");
                        for (final Player all : Bukkit.getOnlinePlayers()) {
                            all.playSound(all.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                        }
                        break;
                    }
                    case 0: {
                        Bukkit.getScheduler().cancelTask(LobbyCountdown.this.taskID);
                        LobbyCountdown.this.gameStateManager.setGameState(1);
                        break;
                    }
                }
            }
        }, 0L, 20L);
        System.out.println(taskID);
    }
    
    @Override
    public void stop() {
        if (LobbyCountdown.isRunning) {
            Bukkit.getScheduler().cancelTask(this.taskID);
            LobbyCountdown.isRunning = false;
            LobbyCountdown.seconds = 31;
        }
    }
    
    public void startIdle() {
        final BukkitScheduler scheduler = Bukkit.getScheduler();
        final GameStateManager gameStateManager = this.gameStateManager;
        this.idleID = scheduler.scheduleSyncRepeatingTask((Plugin)GameStateManager.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                LobbyCountdown.this.isIdling = true;
                Bukkit.broadcastMessage(Main.getPREFIX() + "§aWarten auf Spieler... ");
            }
        }, 0L, 300L);
    }
    
    public void stopIdle() {
        if (this.isIdling) {
            this.isIdling = false;
            Bukkit.getScheduler().cancelTask(this.idleID);
        }
    }
    
    public boolean isIdling() {
        return this.isIdling;
    }
    
    public static boolean isRunning() {
        return LobbyCountdown.isRunning;
    }
    
    public static int getSeconds() {
        return LobbyCountdown.seconds;
    }
    
    public static void setSeconds(final int secondss) {
        LobbyCountdown.seconds = secondss;
    }
}

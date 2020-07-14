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

public class DeathmatchCount extends Countdown
{
    private GameStateManager gameStateManager;
    private Main plugin;
    private int idleID;
    private boolean isIdling;
    private static boolean isRunning;
    private static final int COUNTDOWN_TIME = 600;
    private static int seconds;
    int taskID;
    
    public DeathmatchCount(final GameStateManager gameStateManager, Main plugin) {
        this.gameStateManager = gameStateManager;
        this.plugin = plugin;
        seconds = plugin.getDeathmatch_Countdown();
    }
    
    @Override
    public void start() {

        DeathmatchCount.isRunning = true;
        final BukkitScheduler scheduler = Bukkit.getScheduler();
        final GameStateManager gameStateManager = this.gameStateManager;
        taskID = scheduler.scheduleSyncRepeatingTask((Plugin)GameStateManager.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                DeathmatchCount.seconds--;
                for (final Player all : Bukkit.getOnlinePlayers()) {
                    all.setLevel(DeathmatchCount.seconds);
                }
                switch (DeathmatchCount.seconds) {
                    case 2:
                    case 3:
                    case 5:
                    case 10:
                    case 15:
                    case 30:
                    case 60:
                    case 120:
                    case 180:
                    case 240:
                    case 300:
                    case 360:
                    case 420:
                    case 480:
                    case 540: {
                        Bukkit.broadcastMessage(Main.getPREFIX() + "§aDeathmatch in §6" + DeathmatchCount.seconds + "§a Sekunden§a!");
                        for (final Player all : Bukkit.getOnlinePlayers()) {
                            all.playSound(all.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                        }
                        break;
                    }
                    case 1: {
                        Bukkit.broadcastMessage(Main.getPREFIX() + "§aDeathmatch in §61 §aSekunde§a!");
                        for (final Player all : Bukkit.getOnlinePlayers()) {
                            all.playSound(all.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                        }
                        break;
                    }
                    case 0: {
                        Bukkit.getScheduler().cancelTask(DeathmatchCount.this.taskID);
                        DeathmatchCount.this.gameStateManager.setGameState(3);
                        break;
                    }
                }
            }
        }, 0L, 20L);
    }
    
    @Override
    public void stop() {
        if (DeathmatchCount.isRunning) {
            Bukkit.getScheduler().cancelTask(this.taskID);
            DeathmatchCount.isRunning = false;
            DeathmatchCount.seconds = 600;
        }
    }

    
    public static int getSeconds() {
        return DeathmatchCount.seconds;
    }
    
    public static void setSeconds(final int secondss) {
        DeathmatchCount.seconds = secondss;
    }

    public int getTaskID() {
        return taskID;
    }
}

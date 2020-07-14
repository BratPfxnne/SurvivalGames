// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.Countdowns;

import de.brati.sg.GameStates.DeathmatchState;
import org.bukkit.plugin.Plugin;
import java.util.Iterator;
import org.bukkit.Sound;
import de.brati.sg.Main;
import org.bukkit.entity.Player;
import de.brati.sg.GameStates.GameStateManager;
import org.bukkit.Bukkit;

public class EndingCountdown extends Countdown
{
    int seconds;
    private static final int restartTime = 31;
    private DeathmatchCount deathmatchCount;
    private Main plugin;
    
    public EndingCountdown(Main plugin) {
        this.plugin = plugin;
        seconds = plugin.getEnding_Countdown();
    }
    
    @Override
    public void start() {
        System.out.println(seconds);
        DeathmatchCount.setSeconds(100000);
        this.taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)GameStateManager.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {

                final EndingCountdown this$0 = EndingCountdown.this;
                --this$0.seconds;
                for (final Player all : Bukkit.getOnlinePlayers()) {
                    all.setLevel(EndingCountdown.this.seconds);
                }
                switch (EndingCountdown.this.seconds) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 10:
                    case 15:
                    case 20:
                    case 30: {
                        Bukkit.broadcastMessage(Main.getPREFIX() + "§a§lDer Server startet in §6" + EndingCountdown.this.seconds + " Sekunden §a§l neu!");
                        for (final Player all : Bukkit.getOnlinePlayers()) {
                            all.playSound(all.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                        }
                        break;
                    }
                    case 0: {
                        for (final Player all : Bukkit.getOnlinePlayers()) {
                            all.kickPlayer("§c§lDer Server restartet jetzt!");
                        }
                        Bukkit.getScheduler().cancelTask(EndingCountdown.this.taskID);
                        Bukkit.shutdown();
                        break;
                    }
                }
            }
        }, 0L, 20L);
    }
    
    @Override
    public void stop() {
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.Listeners;

import org.bukkit.event.EventHandler;
import de.brati.sg.voting.Map;
import org.bukkit.scoreboard.ScoreboardManager;
import de.brati.sg.Countdowns.LobbyCountdown;
import org.bukkit.plugin.Plugin;
import org.bukkit.GameMode;
import de.brati.sg.utils.ConfigLocationUtil;
import de.brati.sg.GameStates.LobbyState;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import de.brati.sg.voting.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.inventory.ItemStack;
import de.brati.sg.Main;
import org.bukkit.event.Listener;

public class PlayerJoinListener implements Listener
{
    private Main plugin;
    private ItemStack voteitem;
    private static ArrayList<Player> players;
    
    public PlayerJoinListener(final Main plugin) {
        this.plugin = plugin;
        this.voteitem = new ItemBuilder(Material.NETHER_STAR).setName("§6§lVoting").toItemStack();
    }
    
    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        final ScoreboardManager manager = Bukkit.getScoreboardManager();
        e.getPlayer().setScoreboard(manager.getNewScoreboard());
        final Player p = e.getPlayer();
        p.getInventory().setArmorContents((ItemStack[])null);
        p.getInventory().clear();
        p.getActivePotionEffects().clear();
        if (!(this.plugin.getGameStateManager().getCurrentGameState() instanceof LobbyState)) {
            e.setJoinMessage((String)null);
            if (!p.hasPermission("sg.admin")) {
                p.kickPlayer(Main.getPREFIX() + "§c§lDie Runde hat bereits begonnen!");
            }
            else {
                p.sendMessage(Main.getPREFIX() + "§c§lDie Runde hat bereits begonnen!");
                PlayerJoinListener.players = this.plugin.getPlayers();
                final Map maap = this.plugin.getVoting().getWinnerMap();
                maap.load();
                final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
                p.teleport(spawn.loadLocation());
                p.setGameMode(GameMode.SPECTATOR);
            }
        }
        else {
            this.plugin.getPlayers().add(p);
            p.setGameMode(GameMode.ADVENTURE);
            e.setJoinMessage(Main.getPREFIX() + "§aDer Spieler §6" + p.getName() + "§a hat das Spiel betreten §6[§a" + this.plugin.getPlayers().size() + "§6/§a" + LobbyState.MAX_PLAYERS + "§6]");
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.teleport(PlayerJoinListener.this.plugin.getLobby().loadLocation());
                }
            }, 20L);
            p.getInventory().setItem(4, this.voteitem);
            if (this.plugin.getPlayers().size() >= LobbyState.MIN_PLAYERS) {
                final LobbyCountdown countdown = LobbyState.getCountdown();
                if (!LobbyCountdown.isRunning()) {
                    countdown.start();
                    countdown.stopIdle();
                }
            }
        }
    }
}

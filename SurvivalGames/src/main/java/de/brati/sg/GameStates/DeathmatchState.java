// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.GameStates;

import org.bukkit.WorldBorder;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.Iterator;
import de.brati.sg.voting.Map;
import org.bukkit.Sound;
import de.brati.sg.utils.ConfigLocationUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import de.brati.sg.Main;

public class DeathmatchState extends GameState
{
    private Main plugin;
    private static ArrayList<Player> players;
    
    public DeathmatchState(final Main plugin) {
        this.plugin = plugin;
        DeathmatchState.players = plugin.getPlayers();
    }
    
    @Override
    public void start() {
        Bukkit.broadcastMessage(Main.getPREFIX() + "§aDEATHMATCH");
        final Map maap = this.plugin.getVoting().getWinnerMap();
        maap.load();
        final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
        final ConfigLocationUtil spawn2 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".2");
        final ConfigLocationUtil spawn3 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".3");
        final ConfigLocationUtil spawn4 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".4");
        final ConfigLocationUtil spawn5 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".5");
        final ConfigLocationUtil spawn6 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".6");
        final ConfigLocationUtil spawn7 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".7");
        final ConfigLocationUtil spawn8 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".8");
        final ConfigLocationUtil spawn9 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".9");
        final ConfigLocationUtil spawn10 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".10");
        final ConfigLocationUtil spawn11 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".11");
        final ConfigLocationUtil spawn12 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".12");
        final ConfigLocationUtil spawn13 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".13");
        final ConfigLocationUtil spawn14 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".14");
        final ConfigLocationUtil spawn15 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".15");
        final ConfigLocationUtil spawn16 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".16");
        for (final Player all : DeathmatchState.players) {
            all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0f, 1.0f);
            final FileConfiguration config = this.plugin.getConfig();
            final World world = Bukkit.getWorld(config.getString("Maps." + maap.getName() + ".1.World"));
            final WorldBorder b = Bukkit.getWorld(world.getName()).getWorldBorder();
            b.setCenter(Bukkit.getWorld(world.getName()).getSpawnLocation());
            b.setSize(50.0);
            b.setDamageAmount(5.0);
            if (DeathmatchState.players.size() == 1) {
                DeathmatchState.players.get(0).teleport(spawn.loadLocation());
            }
            else if (DeathmatchState.players.size() == 2) {
                DeathmatchState.players.get(0).teleport(spawn.loadLocation());
                DeathmatchState.players.get(1).teleport(spawn2.loadLocation());
            }
            else if (DeathmatchState.players.size() == 3) {
                DeathmatchState.players.get(0).teleport(spawn.loadLocation());
                DeathmatchState.players.get(1).teleport(spawn2.loadLocation());
                DeathmatchState.players.get(2).teleport(spawn3.loadLocation());
            }
            else if (DeathmatchState.players.size() == 4) {
                DeathmatchState.players.get(0).teleport(spawn.loadLocation());
                DeathmatchState.players.get(1).teleport(spawn2.loadLocation());
                DeathmatchState.players.get(2).teleport(spawn3.loadLocation());
                DeathmatchState.players.get(3).teleport(spawn4.loadLocation());
            }
            else if (DeathmatchState.players.size() == 5) {
                DeathmatchState.players.get(0).teleport(spawn.loadLocation());
                DeathmatchState.players.get(1).teleport(spawn2.loadLocation());
                DeathmatchState.players.get(2).teleport(spawn3.loadLocation());
                DeathmatchState.players.get(3).teleport(spawn4.loadLocation());
                DeathmatchState.players.get(4).teleport(spawn5.loadLocation());
            }
            else if (DeathmatchState.players.size() == 6) {
                DeathmatchState.players.get(0).teleport(spawn.loadLocation());
                DeathmatchState.players.get(1).teleport(spawn2.loadLocation());
                DeathmatchState.players.get(2).teleport(spawn3.loadLocation());
                DeathmatchState.players.get(3).teleport(spawn4.loadLocation());
                DeathmatchState.players.get(4).teleport(spawn5.loadLocation());
                DeathmatchState.players.get(5).teleport(spawn6.loadLocation());
            }
            else if (DeathmatchState.players.size() == 7) {
                DeathmatchState.players.get(0).teleport(spawn.loadLocation());
                DeathmatchState.players.get(1).teleport(spawn2.loadLocation());
                DeathmatchState.players.get(2).teleport(spawn3.loadLocation());
                DeathmatchState.players.get(3).teleport(spawn4.loadLocation());
                DeathmatchState.players.get(4).teleport(spawn5.loadLocation());
                DeathmatchState.players.get(5).teleport(spawn6.loadLocation());
                DeathmatchState.players.get(6).teleport(spawn7.loadLocation());
            }
            else if (DeathmatchState.players.size() == 8) {
                DeathmatchState.players.get(0).teleport(spawn.loadLocation());
                DeathmatchState.players.get(1).teleport(spawn2.loadLocation());
                DeathmatchState.players.get(2).teleport(spawn3.loadLocation());
                DeathmatchState.players.get(3).teleport(spawn4.loadLocation());
                DeathmatchState.players.get(4).teleport(spawn5.loadLocation());
                DeathmatchState.players.get(5).teleport(spawn6.loadLocation());
                DeathmatchState.players.get(6).teleport(spawn7.loadLocation());
                DeathmatchState.players.get(7).teleport(spawn8.loadLocation());
            }
            else if (DeathmatchState.players.size() == 9) {
                DeathmatchState.players.get(0).teleport(spawn.loadLocation());
                DeathmatchState.players.get(1).teleport(spawn2.loadLocation());
                DeathmatchState.players.get(2).teleport(spawn3.loadLocation());
                DeathmatchState.players.get(3).teleport(spawn4.loadLocation());
                DeathmatchState.players.get(4).teleport(spawn5.loadLocation());
                DeathmatchState.players.get(5).teleport(spawn6.loadLocation());
                DeathmatchState.players.get(6).teleport(spawn7.loadLocation());
                DeathmatchState.players.get(7).teleport(spawn8.loadLocation());
                DeathmatchState.players.get(8).teleport(spawn9.loadLocation());
            }
            else if (DeathmatchState.players.size() == 10) {
                DeathmatchState.players.get(0).teleport(spawn.loadLocation());
                DeathmatchState.players.get(1).teleport(spawn2.loadLocation());
                DeathmatchState.players.get(2).teleport(spawn3.loadLocation());
                DeathmatchState.players.get(3).teleport(spawn4.loadLocation());
                DeathmatchState.players.get(4).teleport(spawn5.loadLocation());
                DeathmatchState.players.get(5).teleport(spawn6.loadLocation());
                DeathmatchState.players.get(6).teleport(spawn7.loadLocation());
                DeathmatchState.players.get(7).teleport(spawn8.loadLocation());
                DeathmatchState.players.get(8).teleport(spawn9.loadLocation());
                DeathmatchState.players.get(9).teleport(spawn10.loadLocation());
            }
            else if (DeathmatchState.players.size() == 11) {
                DeathmatchState.players.get(0).teleport(spawn.loadLocation());
                DeathmatchState.players.get(1).teleport(spawn2.loadLocation());
                DeathmatchState.players.get(2).teleport(spawn3.loadLocation());
                DeathmatchState.players.get(3).teleport(spawn4.loadLocation());
                DeathmatchState.players.get(4).teleport(spawn5.loadLocation());
                DeathmatchState.players.get(5).teleport(spawn6.loadLocation());
                DeathmatchState.players.get(6).teleport(spawn7.loadLocation());
                DeathmatchState.players.get(7).teleport(spawn8.loadLocation());
                DeathmatchState.players.get(8).teleport(spawn9.loadLocation());
                DeathmatchState.players.get(9).teleport(spawn10.loadLocation());
                DeathmatchState.players.get(10).teleport(spawn11.loadLocation());
            }
            else if (DeathmatchState.players.size() == 12) {
                DeathmatchState.players.get(0).teleport(spawn.loadLocation());
                DeathmatchState.players.get(1).teleport(spawn2.loadLocation());
                DeathmatchState.players.get(2).teleport(spawn3.loadLocation());
                DeathmatchState.players.get(3).teleport(spawn4.loadLocation());
                DeathmatchState.players.get(4).teleport(spawn5.loadLocation());
                DeathmatchState.players.get(5).teleport(spawn6.loadLocation());
                DeathmatchState.players.get(6).teleport(spawn7.loadLocation());
                DeathmatchState.players.get(7).teleport(spawn8.loadLocation());
                DeathmatchState.players.get(8).teleport(spawn9.loadLocation());
                DeathmatchState.players.get(9).teleport(spawn10.loadLocation());
                DeathmatchState.players.get(10).teleport(spawn11.loadLocation());
                DeathmatchState.players.get(11).teleport(spawn12.loadLocation());
            }
            else if (DeathmatchState.players.size() == 13) {
                DeathmatchState.players.get(0).teleport(spawn.loadLocation());
                DeathmatchState.players.get(1).teleport(spawn2.loadLocation());
                DeathmatchState.players.get(2).teleport(spawn3.loadLocation());
                DeathmatchState.players.get(3).teleport(spawn4.loadLocation());
                DeathmatchState.players.get(4).teleport(spawn5.loadLocation());
                DeathmatchState.players.get(5).teleport(spawn6.loadLocation());
                DeathmatchState.players.get(6).teleport(spawn7.loadLocation());
                DeathmatchState.players.get(7).teleport(spawn8.loadLocation());
                DeathmatchState.players.get(8).teleport(spawn9.loadLocation());
                DeathmatchState.players.get(9).teleport(spawn10.loadLocation());
                DeathmatchState.players.get(10).teleport(spawn11.loadLocation());
                DeathmatchState.players.get(11).teleport(spawn12.loadLocation());
                DeathmatchState.players.get(12).teleport(spawn13.loadLocation());
            }
            else if (DeathmatchState.players.size() == 14) {
                DeathmatchState.players.get(0).teleport(spawn.loadLocation());
                DeathmatchState.players.get(1).teleport(spawn2.loadLocation());
                DeathmatchState.players.get(2).teleport(spawn3.loadLocation());
                DeathmatchState.players.get(3).teleport(spawn4.loadLocation());
                DeathmatchState.players.get(4).teleport(spawn5.loadLocation());
                DeathmatchState.players.get(5).teleport(spawn6.loadLocation());
                DeathmatchState.players.get(6).teleport(spawn7.loadLocation());
                DeathmatchState.players.get(7).teleport(spawn8.loadLocation());
                DeathmatchState.players.get(8).teleport(spawn9.loadLocation());
                DeathmatchState.players.get(9).teleport(spawn10.loadLocation());
                DeathmatchState.players.get(10).teleport(spawn11.loadLocation());
                DeathmatchState.players.get(11).teleport(spawn12.loadLocation());
                DeathmatchState.players.get(12).teleport(spawn13.loadLocation());
                DeathmatchState.players.get(13).teleport(spawn14.loadLocation());
            }
            else if (DeathmatchState.players.size() == 15) {
                DeathmatchState.players.get(0).teleport(spawn.loadLocation());
                DeathmatchState.players.get(1).teleport(spawn2.loadLocation());
                DeathmatchState.players.get(2).teleport(spawn3.loadLocation());
                DeathmatchState.players.get(3).teleport(spawn4.loadLocation());
                DeathmatchState.players.get(4).teleport(spawn5.loadLocation());
                DeathmatchState.players.get(5).teleport(spawn6.loadLocation());
                DeathmatchState.players.get(6).teleport(spawn7.loadLocation());
                DeathmatchState.players.get(7).teleport(spawn8.loadLocation());
                DeathmatchState.players.get(8).teleport(spawn9.loadLocation());
                DeathmatchState.players.get(9).teleport(spawn10.loadLocation());
                DeathmatchState.players.get(10).teleport(spawn11.loadLocation());
                DeathmatchState.players.get(11).teleport(spawn12.loadLocation());
                DeathmatchState.players.get(12).teleport(spawn13.loadLocation());
                DeathmatchState.players.get(13).teleport(spawn14.loadLocation());
                DeathmatchState.players.get(14).teleport(spawn15.loadLocation());
            }
            else {
                if (DeathmatchState.players.size() != 16) {
                    continue;
                }
                DeathmatchState.players.get(0).teleport(spawn.loadLocation());
                DeathmatchState.players.get(1).teleport(spawn2.loadLocation());
                DeathmatchState.players.get(2).teleport(spawn3.loadLocation());
                DeathmatchState.players.get(3).teleport(spawn4.loadLocation());
                DeathmatchState.players.get(4).teleport(spawn5.loadLocation());
                DeathmatchState.players.get(5).teleport(spawn6.loadLocation());
                DeathmatchState.players.get(6).teleport(spawn7.loadLocation());
                DeathmatchState.players.get(7).teleport(spawn8.loadLocation());
                DeathmatchState.players.get(8).teleport(spawn9.loadLocation());
                DeathmatchState.players.get(9).teleport(spawn10.loadLocation());
                DeathmatchState.players.get(10).teleport(spawn11.loadLocation());
                DeathmatchState.players.get(11).teleport(spawn12.loadLocation());
                DeathmatchState.players.get(12).teleport(spawn13.loadLocation());
                DeathmatchState.players.get(13).teleport(spawn14.loadLocation());
                DeathmatchState.players.get(14).teleport(spawn15.loadLocation());
                DeathmatchState.players.get(15).teleport(spawn16.loadLocation());
            }
        }
    }
    
    @Override
    public void stop() {
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.GameStates;

import java.util.Iterator;
import de.brati.sg.voting.Map;
import de.brati.sg.utils.ConfigLocationUtil;
import java.util.List;
import java.util.Collections;
import de.brati.sg.Countdowns.ProtectCountdown;
import de.brati.sg.voting.Voting;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import de.brati.sg.Main;

public class ProtectState extends GameState
{
    private Main plugin;
    private static ArrayList<Player> players;
    private Voting voting;
    private ProtectCountdown countdown;
    private GameStateManager gameStateManager;
    
    public ProtectState(final Main plugin) {
        this.plugin = plugin;
        Collections.shuffle(plugin.getPlayers());
        ProtectState.players = plugin.getPlayers();
        this.countdown = new ProtectCountdown(this.gameStateManager, plugin);
    }
    
    @Override
    public void start() {
        this.countdown.start();
        final Map maap = this.plugin.getVoting().getWinnerMap();
        maap.load();
        Collections.shuffle(ProtectState.players);
        for (final Player all : ProtectState.players) {
            if (ProtectState.players.size() == 1) {
                final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
                ProtectState.players.get(0).teleport(spawn.loadLocation());
            }
            else if (ProtectState.players.size() == 2) {
                final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".2");
                final ConfigLocationUtil spawn2 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
                ProtectState.players.get(0).teleport(spawn.loadLocation());
                ProtectState.players.get(1).teleport(spawn2.loadLocation());
            }
            else if (ProtectState.players.size() == 3) {
                final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
                final ConfigLocationUtil spawn2 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".2");
                final ConfigLocationUtil spawn3 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".3");
                ProtectState.players.get(0).teleport(spawn.loadLocation());
                ProtectState.players.get(1).teleport(spawn2.loadLocation());
                ProtectState.players.get(2).teleport(spawn3.loadLocation());
            }
            else if (ProtectState.players.size() == 4) {
                final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
                final ConfigLocationUtil spawn2 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".2");
                final ConfigLocationUtil spawn3 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".3");
                final ConfigLocationUtil spawn4 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".4");
                ProtectState.players.get(0).teleport(spawn.loadLocation());
                ProtectState.players.get(1).teleport(spawn2.loadLocation());
                ProtectState.players.get(2).teleport(spawn3.loadLocation());
                ProtectState.players.get(3).teleport(spawn4.loadLocation());
            }
            else if (ProtectState.players.size() == 5) {
                final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
                final ConfigLocationUtil spawn2 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".2");
                final ConfigLocationUtil spawn3 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".3");
                final ConfigLocationUtil spawn4 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".4");
                final ConfigLocationUtil spawn5 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".5");
                ProtectState.players.get(0).teleport(spawn.loadLocation());
                ProtectState.players.get(1).teleport(spawn2.loadLocation());
                ProtectState.players.get(2).teleport(spawn3.loadLocation());
                ProtectState.players.get(3).teleport(spawn4.loadLocation());
                ProtectState.players.get(4).teleport(spawn5.loadLocation());
            }
            else if (ProtectState.players.size() == 6) {
                final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
                final ConfigLocationUtil spawn2 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".2");
                final ConfigLocationUtil spawn3 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".3");
                final ConfigLocationUtil spawn4 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".4");
                final ConfigLocationUtil spawn5 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".5");
                final ConfigLocationUtil spawn6 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".6");
                ProtectState.players.get(0).teleport(spawn.loadLocation());
                ProtectState.players.get(1).teleport(spawn2.loadLocation());
                ProtectState.players.get(2).teleport(spawn3.loadLocation());
                ProtectState.players.get(3).teleport(spawn4.loadLocation());
                ProtectState.players.get(4).teleport(spawn5.loadLocation());
                ProtectState.players.get(5).teleport(spawn6.loadLocation());
            }
            else if (ProtectState.players.size() == 7) {
                final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
                final ConfigLocationUtil spawn2 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".2");
                final ConfigLocationUtil spawn3 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".3");
                final ConfigLocationUtil spawn4 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".12");
                final ConfigLocationUtil spawn5 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".16");
                final ConfigLocationUtil spawn6 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".3");
                final ConfigLocationUtil spawn7 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".7");
                ProtectState.players.get(0).teleport(spawn.loadLocation());
                ProtectState.players.get(1).teleport(spawn2.loadLocation());
                ProtectState.players.get(2).teleport(spawn3.loadLocation());
                ProtectState.players.get(3).teleport(spawn4.loadLocation());
                ProtectState.players.get(4).teleport(spawn5.loadLocation());
                ProtectState.players.get(5).teleport(spawn6.loadLocation());
                ProtectState.players.get(6).teleport(spawn7.loadLocation());
            }
            else if (ProtectState.players.size() == 8) {
                final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
                final ConfigLocationUtil spawn2 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".6");
                final ConfigLocationUtil spawn3 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".7");
                final ConfigLocationUtil spawn4 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".16");
                final ConfigLocationUtil spawn5 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".15");
                final ConfigLocationUtil spawn6 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".8");
                final ConfigLocationUtil spawn7 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".3");
                final ConfigLocationUtil spawn8 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".10");
                ProtectState.players.get(0).teleport(spawn.loadLocation());
                ProtectState.players.get(1).teleport(spawn2.loadLocation());
                ProtectState.players.get(2).teleport(spawn3.loadLocation());
                ProtectState.players.get(3).teleport(spawn4.loadLocation());
                ProtectState.players.get(4).teleport(spawn5.loadLocation());
                ProtectState.players.get(5).teleport(spawn6.loadLocation());
                ProtectState.players.get(6).teleport(spawn7.loadLocation());
                ProtectState.players.get(7).teleport(spawn8.loadLocation());
            }
            else if (ProtectState.players.size() == 9) {
                final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
                final ConfigLocationUtil spawn2 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".6");
                final ConfigLocationUtil spawn3 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".7");
                final ConfigLocationUtil spawn4 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".8");
                final ConfigLocationUtil spawn5 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".2");
                final ConfigLocationUtil spawn6 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".3");
                final ConfigLocationUtil spawn7 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".9");
                final ConfigLocationUtil spawn8 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".10");
                final ConfigLocationUtil spawn9 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".16");
                ProtectState.players.get(0).teleport(spawn.loadLocation());
                ProtectState.players.get(1).teleport(spawn2.loadLocation());
                ProtectState.players.get(2).teleport(spawn3.loadLocation());
                ProtectState.players.get(3).teleport(spawn4.loadLocation());
                ProtectState.players.get(4).teleport(spawn5.loadLocation());
                ProtectState.players.get(5).teleport(spawn6.loadLocation());
                ProtectState.players.get(6).teleport(spawn7.loadLocation());
                ProtectState.players.get(7).teleport(spawn8.loadLocation());
                ProtectState.players.get(8).teleport(spawn9.loadLocation());
            }
            else if (ProtectState.players.size() == 10) {
                final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
                final ConfigLocationUtil spawn10 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".2");
                final ConfigLocationUtil spawn11 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".3");
                final ConfigLocationUtil spawn12 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".4");
                final ConfigLocationUtil spawn13 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".5");
                final ConfigLocationUtil spawn14 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".6");
                final ConfigLocationUtil spawn15 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".10");
                final ConfigLocationUtil spawn16 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".11");
                final ConfigLocationUtil spawn17 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".12");
                final ConfigLocationUtil spawn18 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".13");
                final ConfigLocationUtil spawn19 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".14");
                ProtectState.players.get(0).teleport(spawn.loadLocation());
                ProtectState.players.get(1).teleport(spawn11.loadLocation());
                ProtectState.players.get(2).teleport(spawn12.loadLocation());
                ProtectState.players.get(3).teleport(spawn13.loadLocation());
                ProtectState.players.get(4).teleport(spawn14.loadLocation());
                ProtectState.players.get(5).teleport(spawn15.loadLocation());
                ProtectState.players.get(6).teleport(spawn16.loadLocation());
                ProtectState.players.get(7).teleport(spawn17.loadLocation());
                ProtectState.players.get(8).teleport(spawn18.loadLocation());
                ProtectState.players.get(9).teleport(spawn19.loadLocation());
            }
            else if (ProtectState.players.size() == 11) {
                final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
                final ConfigLocationUtil spawn10 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".4");
                final ConfigLocationUtil spawn11 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".5");
                final ConfigLocationUtil spawn12 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".6");
                final ConfigLocationUtil spawn13 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".7");
                final ConfigLocationUtil spawn14 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".11");
                final ConfigLocationUtil spawn15 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".12");
                final ConfigLocationUtil spawn16 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".13");
                final ConfigLocationUtil spawn17 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".14");
                final ConfigLocationUtil spawn18 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".15");
                final ConfigLocationUtil spawn19 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".16");
                final ConfigLocationUtil spawn20 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".2");
                ProtectState.players.get(0).teleport(spawn.loadLocation());
                ProtectState.players.get(1).teleport(spawn11.loadLocation());
                ProtectState.players.get(2).teleport(spawn12.loadLocation());
                ProtectState.players.get(3).teleport(spawn13.loadLocation());
                ProtectState.players.get(4).teleport(spawn14.loadLocation());
                ProtectState.players.get(5).teleport(spawn15.loadLocation());
                ProtectState.players.get(6).teleport(spawn16.loadLocation());
                ProtectState.players.get(7).teleport(spawn17.loadLocation());
                ProtectState.players.get(8).teleport(spawn18.loadLocation());
                ProtectState.players.get(9).teleport(spawn19.loadLocation());
                ProtectState.players.get(10).teleport(spawn20.loadLocation());
            }
            else if (ProtectState.players.size() == 12) {
                final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
                final ConfigLocationUtil spawn2 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".2");
                final ConfigLocationUtil spawn3 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".3");
                final ConfigLocationUtil spawn4 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".4");
                final ConfigLocationUtil spawn5 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".5");
                final ConfigLocationUtil spawn6 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".6");
                final ConfigLocationUtil spawn7 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".7");
                final ConfigLocationUtil spawn8 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".8");
                final ConfigLocationUtil spawn9 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".9");
                final ConfigLocationUtil spawn21 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".16");
                final ConfigLocationUtil spawn22 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".15");
                final ConfigLocationUtil spawn23 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".14");
                ProtectState.players.get(0).teleport(spawn.loadLocation());
                ProtectState.players.get(1).teleport(spawn2.loadLocation());
                ProtectState.players.get(2).teleport(spawn3.loadLocation());
                ProtectState.players.get(3).teleport(spawn4.loadLocation());
                ProtectState.players.get(4).teleport(spawn5.loadLocation());
                ProtectState.players.get(5).teleport(spawn6.loadLocation());
                ProtectState.players.get(6).teleport(spawn7.loadLocation());
                ProtectState.players.get(7).teleport(spawn8.loadLocation());
                ProtectState.players.get(8).teleport(spawn9.loadLocation());
                ProtectState.players.get(9).teleport(spawn21.loadLocation());
                ProtectState.players.get(10).teleport(spawn22.loadLocation());
                ProtectState.players.get(11).teleport(spawn23.loadLocation());
            }
            else if (ProtectState.players.size() == 13) {
                final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
                final ConfigLocationUtil spawn2 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".2");
                final ConfigLocationUtil spawn3 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".3");
                final ConfigLocationUtil spawn4 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".4");
                final ConfigLocationUtil spawn5 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".5");
                final ConfigLocationUtil spawn6 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".6");
                final ConfigLocationUtil spawn7 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".7");
                final ConfigLocationUtil spawn8 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".8");
                final ConfigLocationUtil spawn9 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".9");
                final ConfigLocationUtil spawn21 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".16");
                final ConfigLocationUtil spawn22 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".15");
                final ConfigLocationUtil spawn23 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".14");
                final ConfigLocationUtil spawn24 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".10");
                ProtectState.players.get(0).teleport(spawn.loadLocation());
                ProtectState.players.get(1).teleport(spawn2.loadLocation());
                ProtectState.players.get(2).teleport(spawn3.loadLocation());
                ProtectState.players.get(3).teleport(spawn4.loadLocation());
                ProtectState.players.get(4).teleport(spawn5.loadLocation());
                ProtectState.players.get(5).teleport(spawn6.loadLocation());
                ProtectState.players.get(6).teleport(spawn7.loadLocation());
                ProtectState.players.get(7).teleport(spawn8.loadLocation());
                ProtectState.players.get(8).teleport(spawn9.loadLocation());
                ProtectState.players.get(9).teleport(spawn21.loadLocation());
                ProtectState.players.get(10).teleport(spawn22.loadLocation());
                ProtectState.players.get(11).teleport(spawn23.loadLocation());
                ProtectState.players.get(12).teleport(spawn24.loadLocation());
            }
            else if (ProtectState.players.size() == 14) {
                final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
                final ConfigLocationUtil spawn2 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".2");
                final ConfigLocationUtil spawn3 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".3");
                final ConfigLocationUtil spawn4 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".4");
                final ConfigLocationUtil spawn5 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".5");
                final ConfigLocationUtil spawn6 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".6");
                final ConfigLocationUtil spawn7 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".7");
                final ConfigLocationUtil spawn8 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".8");
                final ConfigLocationUtil spawn9 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".9");
                final ConfigLocationUtil spawn21 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".16");
                final ConfigLocationUtil spawn22 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".15");
                final ConfigLocationUtil spawn23 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".14");
                final ConfigLocationUtil spawn24 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".10");
                final ConfigLocationUtil spawn25 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".11");
                ProtectState.players.get(0).teleport(spawn.loadLocation());
                ProtectState.players.get(1).teleport(spawn2.loadLocation());
                ProtectState.players.get(2).teleport(spawn3.loadLocation());
                ProtectState.players.get(3).teleport(spawn4.loadLocation());
                ProtectState.players.get(4).teleport(spawn5.loadLocation());
                ProtectState.players.get(5).teleport(spawn6.loadLocation());
                ProtectState.players.get(6).teleport(spawn7.loadLocation());
                ProtectState.players.get(7).teleport(spawn8.loadLocation());
                ProtectState.players.get(8).teleport(spawn9.loadLocation());
                ProtectState.players.get(9).teleport(spawn21.loadLocation());
                ProtectState.players.get(10).teleport(spawn22.loadLocation());
                ProtectState.players.get(11).teleport(spawn23.loadLocation());
                ProtectState.players.get(12).teleport(spawn24.loadLocation());
                ProtectState.players.get(13).teleport(spawn25.loadLocation());
            }
            else if (ProtectState.players.size() == 15) {
                final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
                final ConfigLocationUtil spawn2 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".2");
                final ConfigLocationUtil spawn3 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".3");
                final ConfigLocationUtil spawn4 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".4");
                final ConfigLocationUtil spawn5 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".5");
                final ConfigLocationUtil spawn6 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".6");
                final ConfigLocationUtil spawn7 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".7");
                final ConfigLocationUtil spawn8 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".8");
                final ConfigLocationUtil spawn9 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".9");
                final ConfigLocationUtil spawn21 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".16");
                final ConfigLocationUtil spawn22 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".15");
                final ConfigLocationUtil spawn23 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".14");
                final ConfigLocationUtil spawn24 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".10");
                final ConfigLocationUtil spawn25 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".11");
                final ConfigLocationUtil spawn26 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".12");
                ProtectState.players.get(0).teleport(spawn.loadLocation());
                ProtectState.players.get(1).teleport(spawn2.loadLocation());
                ProtectState.players.get(2).teleport(spawn3.loadLocation());
                ProtectState.players.get(3).teleport(spawn4.loadLocation());
                ProtectState.players.get(4).teleport(spawn5.loadLocation());
                ProtectState.players.get(5).teleport(spawn6.loadLocation());
                ProtectState.players.get(6).teleport(spawn7.loadLocation());
                ProtectState.players.get(7).teleport(spawn8.loadLocation());
                ProtectState.players.get(8).teleport(spawn9.loadLocation());
                ProtectState.players.get(9).teleport(spawn21.loadLocation());
                ProtectState.players.get(10).teleport(spawn22.loadLocation());
                ProtectState.players.get(11).teleport(spawn23.loadLocation());
                ProtectState.players.get(12).teleport(spawn24.loadLocation());
                ProtectState.players.get(13).teleport(spawn25.loadLocation());
                ProtectState.players.get(14).teleport(spawn26.loadLocation());
            }
            else {
                if (ProtectState.players.size() != 16) {
                    continue;
                }
                final ConfigLocationUtil spawn = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".1");
                final ConfigLocationUtil spawn2 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".2");
                final ConfigLocationUtil spawn3 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".3");
                final ConfigLocationUtil spawn4 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".4");
                final ConfigLocationUtil spawn5 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".5");
                final ConfigLocationUtil spawn6 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".6");
                final ConfigLocationUtil spawn7 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".7");
                final ConfigLocationUtil spawn8 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".8");
                final ConfigLocationUtil spawn9 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".9");
                final ConfigLocationUtil spawn21 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".16");
                final ConfigLocationUtil spawn22 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".15");
                final ConfigLocationUtil spawn23 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".14");
                final ConfigLocationUtil spawn24 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".10");
                final ConfigLocationUtil spawn25 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".11");
                final ConfigLocationUtil spawn26 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".12");
                final ConfigLocationUtil spawn27 = new ConfigLocationUtil(this.plugin, "Maps." + maap.getName() + ".13");
                ProtectState.players.get(0).teleport(spawn.loadLocation());
                ProtectState.players.get(1).teleport(spawn2.loadLocation());
                ProtectState.players.get(2).teleport(spawn3.loadLocation());
                ProtectState.players.get(3).teleport(spawn4.loadLocation());
                ProtectState.players.get(4).teleport(spawn5.loadLocation());
                ProtectState.players.get(5).teleport(spawn6.loadLocation());
                ProtectState.players.get(6).teleport(spawn7.loadLocation());
                ProtectState.players.get(7).teleport(spawn8.loadLocation());
                ProtectState.players.get(8).teleport(spawn9.loadLocation());
                ProtectState.players.get(9).teleport(spawn21.loadLocation());
                ProtectState.players.get(10).teleport(spawn22.loadLocation());
                ProtectState.players.get(11).teleport(spawn23.loadLocation());
                ProtectState.players.get(12).teleport(spawn24.loadLocation());
                ProtectState.players.get(13).teleport(spawn25.loadLocation());
                ProtectState.players.get(14).teleport(spawn26.loadLocation());
                ProtectState.players.get(15).teleport(spawn27.loadLocation());
            }
        }
        for (final Player current : ProtectState.players) {
            current.getInventory().clear();
        }
    }
    
    @Override
    public void stop() {
        this.countdown.stop();
    }
    
    public static ArrayList<Player> getPlayers() {
        return ProtectState.players;
    }
}

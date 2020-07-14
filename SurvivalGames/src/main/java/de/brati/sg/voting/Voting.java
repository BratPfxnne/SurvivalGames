

package de.brati.sg.voting;

import org.bukkit.entity.Player;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import de.brati.sg.Main;
import org.bukkit.inventory.Inventory;
import org.bukkit.event.Listener;

public class Voting implements Listener
{
    public static final int MAP_AMOUNT = 2;
    public static final String VOTING_NAME = "§6§lVoting";
    private Inventory votingInventory;
    private int[] votingInventoryOrder;
    private Main plugin;
    private ArrayList<Map> maps;
    private Map[] votingMaps;
    private HashMap<String, Integer> playervotes;
    
    public Voting(final Main plugin, final ArrayList<Map> maps) {
        this.votingInventoryOrder = new int[] { 3, 5 };
        this.plugin = plugin;
        this.maps = maps;
        this.votingMaps = new Map[2];
        this.playervotes = new HashMap<String, Integer>();
        this.chooseRandomMaps();
        this.initVotingInventory();
    }
    
    private void chooseRandomMaps() {
        for (int i = 0; i < this.votingMaps.length; ++i) {
            Collections.shuffle(this.maps);
            this.votingMaps[i] = this.maps.remove(0);
        }
    }
    
    public void initVotingInventory() {
        this.votingInventory = Bukkit.createInventory((InventoryHolder)null, 9, "§6§lVoting");
        for (int i = 0; i < this.votingMaps.length; ++i) {
            final Map currentMap = this.votingMaps[i];
            this.votingInventory.setItem(this.votingInventoryOrder[i], new ItemBuilder(Material.PAPER).setName("§6" + currentMap.getName() + "§c - §c§l " + currentMap.getVotes() + " Votes").setLore("§7Erbauer: §a" + currentMap.getBuilder()).toItemStack());
        }
    }
    
    public Map getWinnerMap() {
        Map winnerMap = this.votingMaps[0];
        for (int i = 1; i < this.votingMaps.length; ++i) {
            if (this.votingMaps[i].getVotes() >= winnerMap.getVotes()) {
                winnerMap = this.votingMaps[i];
            }
        }
        return winnerMap;
    }
    
    public void vote(final Player p, final int votingMap) {
        if (!this.playervotes.containsKey(p.getName())) {
            this.votingMaps[votingMap].addVote();
            p.closeInventory();
            p.sendMessage(Main.getPREFIX() + "§aDu hast f\u00fcr die Map §6" + this.votingMaps[votingMap].getName() + "§a abgestimmt!");
            this.playervotes.put(p.getName(), votingMap);
            this.initVotingInventory();
        }
        else {
            p.sendMessage(Main.getPREFIX() + "§cDu hast bereits gevotet!");
        }
    }
    
    public HashMap<String, Integer> getPlayervotes() {
        return this.playervotes;
    }
    
    public Inventory getVotingInventory() {
        return this.votingInventory;
    }
    
    public Map[] getVotingMaps() {
        return this.votingMaps;
    }
    
    public int[] getVotingInventoryOrder() {
        return this.votingInventoryOrder;
    }
}

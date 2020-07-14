// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.Listeners;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import de.brati.sg.voting.Voting;
import de.brati.sg.Main;
import org.bukkit.event.Listener;

public class VotingListener implements Listener
{
    private Main plugin;
    private Voting voting;
    
    public VotingListener(final Main plugin) {
        this.plugin = plugin;
        this.voting = plugin.getVoting();
    }
    
    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        final ItemStack item = p.getItemInHand();
        if (item.getItemMeta() == null) {
            return;
        }
        try {
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§6§lVoting")) {
                p.openInventory(this.voting.getVotingInventory());
            }
        }
        catch (NullPointerException ex) {}
    }
    
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getWhoClicked();
        if (!e.getView().getTitle().equalsIgnoreCase("§6§lVoting")) {
            return;
        }
        e.setCancelled(true);
        for (int i = 0; i < this.voting.getVotingInventoryOrder().length; ++i) {
            if (this.voting.getVotingInventoryOrder()[i] == e.getSlot()) {
                this.voting.vote(p, i);
                return;
            }
        }
    }
}

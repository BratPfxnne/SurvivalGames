// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.Listeners;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import de.brati.sg.Main;
import org.bukkit.event.Listener;

public class ProtectListener implements Listener
{
    private Main plugin;
    
    public ProtectListener(final Main plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onPlace(final BlockPlaceEvent e) {
        if (!e.getPlayer().hasPermission("sg.build")) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onBreak(final BlockBreakEvent e) {
        if (!e.getPlayer().hasPermission("sg.build")) {
            e.setCancelled(true);
        }
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.Listeners;

import org.bukkit.event.EventHandler;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import java.util.Random;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.Location;
import java.util.HashMap;
import de.brati.sg.Main;
import org.bukkit.event.Listener;

public class ChestListener implements Listener
{
    private Main plugin;
    private static HashMap<Location, Inventory> sgchest;
    
    public ChestListener(final Main plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (e.getClickedBlock().getType() != Material.CHEST) {
            return;
        }
        e.setCancelled(true);
        if (ChestListener.sgchest.containsKey(e.getClickedBlock().getLocation())) {
            p.openInventory((Inventory)ChestListener.sgchest.get(e.getClickedBlock().getLocation()));
        }
        else {
            final Random rnd = new Random();
            int tries = rnd.nextInt(20);
            final Inventory inv = Bukkit.createInventory((InventoryHolder)null, InventoryType.CHEST);
            final List<ItemStack> items = new ArrayList<ItemStack>();
            items.add(new ItemStack(Material.APPLE));
            items.add(new ItemStack(Material.BAKED_POTATO));
            items.add(new ItemStack(Material.POTATO));
            items.add(new ItemStack(Material.BREAD));
            items.add(new ItemStack(Material.COOKIE));
            items.add(new ItemStack(Material.COOKED_BEEF));
            items.add(new ItemStack(Material.COOKED_BEEF));
            items.add(new ItemStack(Material.CAKE));
            items.add(new ItemStack(Material.MELON));
            items.add(new ItemStack(Material.CARROT));
            items.add(new ItemStack(Material.PUMPKIN_PIE));
            items.add(new ItemStack(Material.COOKED_CHICKEN));
            items.add(new ItemStack(Material.APPLE));
            items.add(new ItemStack(Material.BAKED_POTATO));
            items.add(new ItemStack(Material.POTATO));
            items.add(new ItemStack(Material.BREAD));
            items.add(new ItemStack(Material.COOKIE));
            items.add(new ItemStack(Material.RAW_BEEF));
            items.add(new ItemStack(Material.COOKED_BEEF));
            items.add(new ItemStack(Material.CAKE));
            items.add(new ItemStack(Material.MELON));
            items.add(new ItemStack(Material.CARROT));
            items.add(new ItemStack(Material.PUMPKIN_PIE));
            items.add(new ItemStack(Material.COOKED_CHICKEN));
            items.add(new ItemStack(Material.STONE_SWORD));
            items.add(new ItemStack(Material.STONE_SWORD));
            items.add(new ItemStack(Material.WOOD_SWORD));
            items.add(new ItemStack(Material.WOOD_SWORD));
            items.add(new ItemStack(Material.WOOD_SWORD));
            items.add(new ItemStack(Material.IRON_SWORD));
            items.add(new ItemStack(Material.GOLD_SWORD));
            items.add(new ItemStack(Material.DIAMOND_SWORD));
            items.add(new ItemStack(Material.WOOD_AXE));
            items.add(new ItemStack(Material.STONE_AXE));
            items.add(new ItemStack(Material.IRON_AXE));
            items.add(new ItemStack(Material.BOW));
            items.add(new ItemStack(Material.ARROW, 2));
            items.add(new ItemStack(Material.IRON_HELMET));
            items.add(new ItemStack(Material.IRON_CHESTPLATE));
            items.add(new ItemStack(Material.IRON_LEGGINGS));
            items.add(new ItemStack(Material.IRON_BOOTS));
            items.add(new ItemStack(Material.CHAINMAIL_BOOTS));
            items.add(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
            items.add(new ItemStack(Material.CHAINMAIL_HELMET));
            items.add(new ItemStack(Material.CHAINMAIL_LEGGINGS));
            items.add(new ItemStack(Material.GOLD_HELMET));
            items.add(new ItemStack(Material.GOLD_CHESTPLATE));
            items.add(new ItemStack(Material.GOLD_LEGGINGS));
            items.add(new ItemStack(Material.GOLD_BOOTS));
            items.add(new ItemStack(Material.LEATHER_BOOTS));
            items.add(new ItemStack(Material.LEATHER_HELMET));
            items.add(new ItemStack(Material.LEATHER_CHESTPLATE));
            items.add(new ItemStack(Material.LEATHER_LEGGINGS));
            items.add(new ItemStack(Material.FISHING_ROD));
            while (tries != 0) {
                --tries;
                final int slot = rnd.nextInt(27);
                final int item = rnd.nextInt(items.size());
                inv.setItem(slot, (ItemStack)items.get(item));
                p.openInventory(inv);
            }
            ChestListener.sgchest.put(e.getClickedBlock().getLocation(), inv);
        }
    }
    
    public static HashMap<Location, Inventory> getSgchest() {
        return ChestListener.sgchest;
    }
    
    static {
        ChestListener.sgchest = new HashMap<Location, Inventory>();
    }
}

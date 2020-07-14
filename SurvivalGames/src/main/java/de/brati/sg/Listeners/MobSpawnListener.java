package de.brati.sg.Listeners;
// This Class is created by BratPfxnne
// BratPfxnne is a cool Dude ;D
// ._.
// :V

import de.brati.sg.Main;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.world.SpawnChangeEvent;

public class MobSpawnListener implements Listener {

    private Main plugin;

    public MobSpawnListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent e) {
        e.setCancelled(true);
    }


}


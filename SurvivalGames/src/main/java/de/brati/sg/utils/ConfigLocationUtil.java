// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.utils;

import org.bukkit.World;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.Location;
import de.brati.sg.Main;

public class ConfigLocationUtil
{
    private Main plugin;
    private Location location;
    private String root;
    
    public ConfigLocationUtil(final Main plugin, final Location location, final String root) {
        this.plugin = plugin;
        this.location = location;
        this.root = root;
    }
    
    public ConfigLocationUtil(final Main plugin, final String root) {
        this(plugin, null, root);
    }
    
    public void saveLocation() {
        final FileConfiguration config = this.plugin.getConfig();
        config.set(this.root + ".World", (Object)this.location.getWorld().getName());
        config.set(this.root + ".X", (Object)this.location.getX());
        config.set(this.root + ".Y", (Object)this.location.getY());
        config.set(this.root + ".Z", (Object)this.location.getZ());
        config.set(this.root + ".Yaw", (Object)this.location.getYaw());
        config.set(this.root + ".Pitch", (Object)this.location.getPitch());
        this.plugin.saveConfig();
    }
    
    public Location loadLocation() {
        final FileConfiguration config = this.plugin.getConfig();
        if (config.contains(this.root)) {
            final World world = Bukkit.getWorld(config.getString(this.root + ".World"));
            final double x = config.getDouble(this.root + ".X");
            final double y = config.getDouble(this.root + ".Y");
            final double z = config.getDouble(this.root + ".Z");
            final float yaw = (float)config.getDouble(this.root + ".Yaw");
            final float pitch = (float)config.getDouble(this.root + ".Pitch");
            return new Location(world, x, y, z, yaw, pitch);
        }
        return null;
    }
}

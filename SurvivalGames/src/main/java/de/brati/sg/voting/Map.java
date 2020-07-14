

package de.brati.sg.voting;

import org.bukkit.configuration.ConfigurationSection;
import de.brati.sg.utils.ConfigLocationUtil;
import de.brati.sg.GameStates.LobbyState;
import org.bukkit.Location;
import de.brati.sg.Main;

public class Map
{
    private Main plugin;
    private String name;
    private String Builder;
    public Location[] spawnLocations;
    private Location spectatorLocation;
    private int votes;
    
    public Map(final Main plugin, final String name) {
        this.spawnLocations = new Location[LobbyState.MAX_PLAYERS];
        this.plugin = plugin;
        this.name = name.toUpperCase();
        if (this.exists()) {
            this.Builder = plugin.getConfig().getString("Maps." + name + ".Builder");
        }
    }
    
    public void load() {
        for (int e = 0; e < this.spawnLocations.length; ++e) {
            this.spawnLocations[e] = new ConfigLocationUtil(this.plugin, "Maps." + this.name + "." + e).loadLocation();
        }
        this.spectatorLocation = new ConfigLocationUtil(this.plugin, "Maps." + this.name + ".Spectator").loadLocation();
    }
    
    public void create(final String Builder) {
        this.Builder = Builder;
        this.plugin.getConfig().set("Maps." + this.name + ".Builder", (Object)Builder);
        this.plugin.saveConfig();
    }
    
    public void setSpawnLocation(final int spawnNumber, final Location location) {
        this.spawnLocations[spawnNumber - 1] = location;
        new ConfigLocationUtil(this.plugin, location, "Maps." + this.name + "." + spawnNumber).saveLocation();
    }
    
    public void setSpectatorLocation(final Location location) {
        this.spectatorLocation = location;
        new ConfigLocationUtil(this.plugin, location, "Maps." + this.name + ".Spectator").saveLocation();
    }
    
    public void addVote() {
        ++this.votes;
    }
    
    public void removeVote() {
        --this.votes;
    }
    
    public boolean exists() {
        return this.plugin.getConfig().getString("Maps." + this.name + ".Builder") != null;
    }
    
    public boolean playable() {
        final ConfigurationSection configSection = this.plugin.getConfig().getConfigurationSection("Maps." + this.name);
        if (!configSection.contains("Spectator")) {
            return false;
        }
        if (!configSection.contains("Builder")) {
            return false;
        }
        for (int i = 1; i < LobbyState.MAX_PLAYERS + 1; ++i) {
            if (!configSection.contains(Integer.toString(i))) {
                return false;
            }
        }
        return true;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getBuilder() {
        return this.Builder;
    }
    
    public Location[] getSpawnLocations() {
        return this.spawnLocations;
    }
    
    public Location getSpectatorLocation() {
        return this.spectatorLocation;
    }
    
    public int getVotes() {
        return this.votes;
    }
}

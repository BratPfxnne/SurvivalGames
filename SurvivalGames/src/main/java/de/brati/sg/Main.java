

package de.brati.sg;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import de.brati.sg.Commands.forcemap_CMD;
import de.brati.sg.Commands.forcedeathmatch_CMD;
import de.brati.sg.Commands.Start_CMD;
import de.brati.sg.Listeners.*;
import org.bukkit.command.CommandExecutor;
import de.brati.sg.Commands.setup_CMD;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import de.brati.sg.GameStates.GameStateManager;
import de.brati.sg.voting.Voting;
import de.brati.sg.voting.Map;
import de.brati.sg.utils.ConfigLocationUtil;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    public static final String PREFIX = "§8[§a§lSG§8] §r";
    private ArrayList<Player> Players;
    ConfigLocationUtil lobby;
    private Main plugin;
    ArrayList<Map> maps;
    private Voting voting;
    GameStateManager gameStateManager;
    private File file = new File("plugins/SurvivalGames/Game_Settings.yml");
    private YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
    private int Protect_Countdown = yamlConfiguration.getInt("Game.Settings.PROTECT_COUNTDOWN");
    private int Deathmatch_Countdown = yamlConfiguration.getInt("Game.Settings.DEATHMATCH_COUNTDOWN");
    private int Ending_Countdown = yamlConfiguration.getInt("Game.Settings.ENDING_COUNTDOWN");
    private int Lobby_Countdown = yamlConfiguration.getInt("Game.Settings.LOBBY_COUNTDOWN");

    public Main() throws IOException {
        AddDefault();
        this.Players = new ArrayList<Player>();
        this.lobby = new ConfigLocationUtil(this, "SG.Spawns.Lobby");
        this.plugin = this;
        this.gameStateManager = new GameStateManager(this);
    }
    public void AddDefault() throws IOException {
        int MAX_PLAYERS = yamlConfiguration.getInt("Game.Settings.MAX_PLAYERS");
        if(MAX_PLAYERS == 0) {
            yamlConfiguration.set("Game.Settings.MAX_PLAYERS", 16);
        }
        int MIN_PLAYERS = yamlConfiguration.getInt("Game.Settings.MIN_PLAYERS");
        if(MIN_PLAYERS == 0) {
            yamlConfiguration.set("Game.Settings.MIN_PLAYERS", 2);
        }
        int LOBBY_COUNTDOWN = yamlConfiguration.getInt("Game.Settings.LOBBY_COUNTDOWN");
        if(LOBBY_COUNTDOWN == 0) {
            yamlConfiguration.set("Game.Settings.LOBBY_COUNTDOWN", 31);
        }
        int PROTECT_COUNTDOWN = yamlConfiguration.getInt("Game.Settings.PROTECT_COUNTDOWN");
        if(PROTECT_COUNTDOWN == 0) {
            yamlConfiguration.set("Game.Settings.PROTECT_COUNTDOWN", 31);
        }
        int DEATHMATCH_COUNTDOWN = yamlConfiguration.getInt("Game.Settings.DEATHMATCH_COUNTDOWN");
        if(DEATHMATCH_COUNTDOWN == 0) {
            yamlConfiguration.set("Game.Settings.DEATHMATCH_COUNTDOWN", 600);
        }
        int ENDING_COUNTDOWN = yamlConfiguration.getInt("Game.Settings.ENDING_COUNTDOWN");
        if(ENDING_COUNTDOWN == 0) {
            yamlConfiguration.set("Game.Settings.ENDING_COUNTDOWN", 31);
        }
        yamlConfiguration.save(file);
    }
    
    public void onEnable() {
        try {
            AddDefault();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.initVoting();
        this.initListeners();
        this.gameStateManager.setGameState(0);
        this.initCommands();
        Bukkit.getConsoleSender().sendMessage("§a§lDas Plugin wurde gestartet §6§l(SG BY BRATPFXNNE)");
    }
    
    private void initListeners() {
        final PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents((Listener)new PlayerJoinListener(this), (Plugin)this);
        pm.registerEvents((Listener)new VotingListener(this), (Plugin)this);
        pm.registerEvents((Listener)new PlayerQuitListener(this), (Plugin)this);
        pm.registerEvents((Listener)new PlayerDamageListener(this), (Plugin)this);
        pm.registerEvents((Listener)new ChestListener(this), (Plugin)this);
        pm.registerEvents((Listener)new PlayerDeathListener(this), (Plugin)this);
        pm.registerEvents((Listener)new ProtectListener(this), (Plugin)this);
        pm.registerEvents(new PlayerHungerListener(this), this);
        pm.registerEvents(new MobSpawnListener(this), this);
        pm.registerEvents(new PlayerDropListener(this), this);
        pm.registerEvents(new PlayerInventoryClickListener(this), this);
    }
    
    public void onDisable() {
        ChestListener.getSgchest().clear();
    }
    
    private void initCommands() {
        this.getCommand("setup").setExecutor((CommandExecutor)new setup_CMD(this));
        this.getCommand("start").setExecutor((CommandExecutor)new Start_CMD(this));
        this.getCommand("forcedeathmatch").setExecutor((CommandExecutor)new forcedeathmatch_CMD(this));
        this.getCommand("forcemap").setExecutor((CommandExecutor)new forcemap_CMD(this));
    }
    
    private void initVoting() {
        this.maps = new ArrayList<Map>();
        for (final String current : this.getConfig().getConfigurationSection("Maps").getKeys(false)) {
            final Map map = new Map(this, current);
            if (map.playable()) {
                this.maps.add(map);
            }
            else {
                Bukkit.getConsoleSender().sendMessage(getPREFIX() + "§cDie Map §6" + map.getName() + "§c ist noch nicht fertig eingerichtet!");
            }
        }
        if (this.maps.size() >= 2) {
            this.voting = new Voting(this, this.maps);
        }
        else {
            Bukkit.getConsoleSender().sendMessage(getPREFIX() + "§cEs m\u00fcssen 2 Maps eingerichtet sein!");
            this.voting = null;
        }
    }

    public int getDeathmatch_Countdown() {
        return Deathmatch_Countdown;
    }

    public int getEnding_Countdown() {
        return Ending_Countdown;
    }

    public int getLobby_Countdown() {
        return Lobby_Countdown;
    }

    public int getProtect_Countdown() {
        return Protect_Countdown;
    }

    public static String getPREFIX() {
        return "§8[§a§lSG§8] §r";
    }
    
    public ArrayList<Player> getPlayers() {
        return this.Players;
    }
    
    public Main getPlugin() {
        return this.plugin;
    }
    
    public GameStateManager getGameStateManager() {
        return this.gameStateManager;
    }
    
    public ConfigLocationUtil getLobby() {
        return this.lobby;
    }
    
    public Voting getVoting() {
        return this.voting;
    }
    
    public ArrayList<Map> getMaps() {
        return this.maps;
    }

    public YamlConfiguration getYamlConfiguration() {
        return yamlConfiguration;
    }

}

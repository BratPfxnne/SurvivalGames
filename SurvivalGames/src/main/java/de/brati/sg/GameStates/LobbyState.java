// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.GameStates;

import de.brati.sg.Countdowns.LobbyCountdown;
import de.brati.sg.Main;

public class LobbyState extends GameState
{
    private GameStateManager gameStateManager;
    private static LobbyCountdown lobbyCountdown;
    public static int MAX_PLAYERS;
    public static int MIN_PLAYERS;
    private Main plugin;
    
    public LobbyState(final GameStateManager gameStateManager, Main plugin) {
        LobbyState.lobbyCountdown = new LobbyCountdown(gameStateManager, plugin);
    }
    
    @Override
    public void start() {
        LobbyState.lobbyCountdown.startIdle();
    }
    
    @Override
    public void stop() {
    }
    
    public static LobbyCountdown getCountdown() {
        return LobbyState.lobbyCountdown;
    }
    
    static {
        int maxplayers =  GameStateManager.getPlugin().getYamlConfiguration().getInt("Game.Settings.MAX_PLAYERS");
        int minplayers =  GameStateManager.getPlugin().getYamlConfiguration().getInt("Game.Settings.MIN_PLAYERS");
        System.out.println(maxplayers);
        System.out.println(minplayers);
        LobbyState.MAX_PLAYERS = maxplayers;
        LobbyState.MIN_PLAYERS = minplayers;;
    }
}

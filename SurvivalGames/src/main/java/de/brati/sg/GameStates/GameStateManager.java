// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.GameStates;

import de.brati.sg.Main;

public class GameStateManager
{
    private static Main plugin;
    private GameState[] gameStates;
    private GameState currentGameState;
    
    public GameStateManager(final Main plugin) {
        GameStateManager.plugin = plugin;
        (this.gameStates = new GameState[5])[0] = new LobbyState(this, plugin);
        this.gameStates[2] = new IngameState(plugin, this);
        this.gameStates[4] = new EndingState(plugin);
        this.gameStates[1] = new ProtectState(plugin);
        this.gameStates[3] = new DeathmatchState(plugin);
    }
    
    public void setGameState(final int gameStateID) {
        if (this.currentGameState != null) {
            this.currentGameState.stop();
        }
        (this.currentGameState = this.gameStates[gameStateID]).start();
    }
    
    public void stopCurrentGameState() {
        if (this.currentGameState != null) {
            this.currentGameState.stop();
            this.currentGameState = null;
        }
    }
    
    public GameState getCurrentGameState() {
        return this.currentGameState;
    }
    
    public static Main getPlugin() {
        return GameStateManager.plugin;
    }
}

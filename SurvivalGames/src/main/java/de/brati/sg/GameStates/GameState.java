// 
// Decompiled by Procyon v0.5.36
// 

package de.brati.sg.GameStates;

public abstract class GameState
{
    public static final int LOBBY_STATE = 0;
    public static final int Protect_STATE = 1;
    public static final int INGAME_STATE = 2;
    public static final int DEATHMATCH_STATE = 3;
    public static final int ENDING_STATE = 4;
    
    public abstract void start();
    
    public abstract void stop();
}

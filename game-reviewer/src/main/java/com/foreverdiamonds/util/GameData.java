package com.foreverdiamonds.util;

public class GameData {
    public int gameID;
    public String gameName;

    public GameData(int gameID, String gameName) {
        this.gameID = gameID;
        this.gameName = gameName;
    }

    public GameData(GameData gameData) {
        gameID = gameData.gameID;
        gameName = gameData.gameName;
    }
}
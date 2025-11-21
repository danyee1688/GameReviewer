package com.foreverdiamonds.util;

import java.util.ArrayList;
import java.util.HashMap;

public class GameDatabase {
    public static ArrayList<GameData> gameList = new ArrayList<>();
    public static HashMap<String, GameData> gameDict = new HashMap<>();

    public static void initializeDatabase() {
        gameList.add(new GameData(0, "Rocket League"));
        gameList.add(new GameData(1, "Path of Exile"));
        gameList.add(new GameData(2, "Path of Exile 2"));

        for (GameData gameData : gameList) {
            gameDict.put(gameData.gameName, gameData);
        }
    }

    public static GameData getRandomGame() {
        int randomIndex = (int)(Math.random() * gameList.size());

        return gameList.get(randomIndex);
    }

    public static boolean gameInDatabase(String gameName) {
        return gameDict.containsKey(gameName);
    }

    public static void viewGameDatabase() {
        for (GameData gameData : gameList) {
            System.out.println(gameData.gameName);
        }
    }
}
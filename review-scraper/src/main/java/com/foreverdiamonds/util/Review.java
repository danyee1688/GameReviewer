package com.foreverdiamonds.util;

public class Review {
    private String reviewTitle = "No Title";
    private float reviewRating = -1;
    private String reviewDescription = "No Description";
    private GameData gameData = null;

    public String getTitle() {
        return reviewTitle;
    }

    public void setTitle(String reviewTitle) {
        if (!reviewTitle.isBlank()) {
            this.reviewTitle = reviewTitle;
        }
    }

    public float getRating() {
        return reviewRating;
    }

    public void setRating(float reviewRating) {
        if (reviewRating >= 0 && reviewRating <= 5)
        {
            this.reviewRating = reviewRating;
        }
    }

    public String getDescription() {
        return reviewDescription;
    }

    public void setDescription(String reviewDescription)
    {
        if (!reviewDescription.isBlank()) {
            this.reviewDescription = reviewDescription;
        }
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = new GameData(gameData);
    }
}
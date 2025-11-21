package com.foreverdiamonds.util;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReviewManager {
    private ArrayList<Review> reviewList = new ArrayList<>();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    public void addReview(Review review) {
        reviewList.add(review);

        updateJSON();
    }

    public void seeReviews() {
        for (Review review : reviewList) {
            System.out.println("Review for " + review.getGameData().gameName);
            System.out.println(review.getTitle());
            System.out.println(review.getRating() + "/5");
            System.out.println(review.getDescription());
        }
    }

    public void updateJSON() {
        try (FileWriter writer = new FileWriter("reviews.json")) {
            gson.toJson(reviewList, writer);
        }
        catch (IOException e) {
            System.err.println("Write file error");
        }
    }

    public void loadReviews() {
        try (FileReader reader = new FileReader("reviews.json"))
        {
            Review[] reviewArray = gson.fromJson(reader, Review[].class);

            reviewList = new ArrayList<>(Arrays.asList(reviewArray));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Error reading the file!");
        }
    }
}
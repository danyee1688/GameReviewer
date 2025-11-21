package com.foreverdiamonds.util;

import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ReviewManager reviewManager = new ReviewManager();

    public static void main(String[] args) {
        boolean userContinues = true;
        boolean success = false;
        
        Initialize();

        do { 
            do { 
                System.out.println("What would you like to do?");
                System.out.println("Type the number corresponding to an option below");
                System.out.println("1. Write a review");
                System.out.println("2. View reviews");
                System.out.println("3. View all games");
                System.out.println("4. Quit");
                int input = scanner.nextInt();
                scanner.nextLine();

                switch (input) {
                    case 1:
                        success = true;

                        tryWriteReview();
                        break;
                    case 2:
                        success = true;

                        reviewManager.seeReviews();
                        break;
                    case 3:
                        success = true;
                        GameDatabase.viewGameDatabase();
                        break;
                    case 4:
                        userContinues = false;
                        break;
                    default:
                        System.out.println("Your input was not accepted, please try again");
                        break;
                }
                
            } while (!success);
            
        } while (userContinues);
        
    }

    public static void Initialize() {
        GameDatabase.initializeDatabase();
        reviewManager.loadReviews();
    }

    public static void tryWriteReview() {
        boolean success = false;
        GameData gameData;
        Review review = new Review();

        do { 
            System.out.println("What would you like to do?");
            System.out.println("Type the number corresponding to an option below");
            System.out.println("1. Proceed with writing a review");
            System.out.println("2. Review a random game");
            System.out.println("3. Go back");
            int input = scanner.nextInt();
            scanner.nextLine();
            String stringInput;

            switch (input) {
                case 1:
                    success = true;
                    System.out.println("Enter game name:");
                    stringInput = scanner.nextLine();

                    if (GameDatabase.gameInDatabase(stringInput)) {
                        gameData = GameDatabase.gameDict.get(stringInput);
                        review.setGameData(gameData);
                    }
                    else {
                        System.out.println("ERROR -1: Game not found in database");
                        break;
                    }

                    System.out.println("Enter review title:");
                    review.setTitle(scanner.nextLine());
                    System.out.println("Enter review rating (out of 5):");
                    review.setRating(scanner.nextFloat()); 
                    scanner.nextLine();
                    System.out.println("Enter review description:");
                    review.setDescription(scanner.nextLine());

                    reviewManager.addReview(review);

                    break;
                case 2:
                    success = true;
                    
                    gameData = new GameData(GameDatabase.getRandomGame());
                    System.out.println("You are reviewing " + gameData.gameName);
                    review.setGameData(gameData);

                    System.out.println("Enter review title:");
                    review.setTitle(scanner.nextLine());
                    System.out.println("Enter review rating (out of 5):");
                    review.setRating(scanner.nextFloat()); 
                    scanner.nextLine();
                    System.out.println("Enter review description:");
                    review.setDescription(scanner.nextLine());

                    reviewManager.addReview(review);
                    break;
                case 3:
                    success = true;
                    break;
                default:
                    System.out.println("Your input was not accepted, please try again");
                    break;
            }
        } while (!success);
    }
}
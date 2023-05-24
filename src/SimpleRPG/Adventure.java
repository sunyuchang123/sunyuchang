/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleRPG;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author yucha
 */
public class Adventure {
    private Hero hero;// The player's character.
    private Scanner scanner; // Used for player input.
    
    // Constructor for the Adventure class.
    public Adventure(Hero hero) {
        this.hero = hero; 
        scanner = new Scanner(System.in); 
    }
    
    // Initialize game locations with enemies.
    private List<Location> initializeLocations() {
        List<Location> locations = new ArrayList<>();
        
        // Create locations with their specific enemies
        Location island = new Location("Waiheke Island");
        island.addEnemy(new Enemy("Kiwi Bird", (int) (Math.random() * 1) + 1, (int) (Math.random() * 5) + 10));
        island.addEnemy(new Enemy("Seagull", (int) (Math.random() * 1) + 1, (int) (Math.random() * 10) + 20));
        locations.add(island);
        
        // The enemies have randomized health and strength within certain ranges
        Location building = new Location("AUT WZ Building");
        building.addEnemy(new Enemy("Professor", (int) (Math.random() * 1) + 1, (int) (Math.random() * 20) + 40));
        building.addEnemy(new Enemy("TA", (int) (Math.random() * 1) + 1, (int) (Math.random() * 10) + 30));
        locations.add(building);
        
        // The locations and enemies are then added to the locations list
        Location library = new Location("Auckland Library");
        library.addEnemy(new Enemy("Library Revolving Door", (int) (Math.random() * 1) + 1, (int) (Math.random() * 20) + 50));
        library.addEnemy(new Enemy("Crazy Librarian", (int) (Math.random() * 1) + 1, (int) (Math.random() * 20) + 60));
        locations.add(library);

        return locations;
    }
    // This method is used to safely parse player input to an integer.
    private int safelyParseInt() {
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        return choice;
    }
        //To handle invalid inputs and show the prompt "Invalid input" 
        //when the user enters anything other than a number, 
        //to use the try-catch block with Integer.parseInt() with input validation
   
    // The start() method is the main game loop.
    public void start() {
        
        List<Location> locations = initializeLocations();
        
        // Main game loop, continues until the player's health is zero or they reach level 100
        boolean adventureToday = true;
        while (hero.health > 0 && hero.level < 100 && adventureToday) {
            System.out.println("\nAre you ready to go for an adventure? ('y' to continue)");
            System.out.println("(OR enter 'any other key' to quit)");
            String adventureChoice = scanner.next();

            if (adventureChoice.equalsIgnoreCase("q")) {
                System.out.println("*** Thank you for playing! Goodbye! ***");
                System.exit(0);
            }
            adventureToday = adventureChoice.equalsIgnoreCase("y");

            if (adventureToday) {
               
                while (hero.health > 0 && hero.level < 100) {
                    
                    // Check if the player's health is low and offer them the chance to rest
                    if (hero.health <= 20) {
                        System.out.println("\nYour health is low! Would you like to return home for a rest? ('y' for a nap at home OR 'any other key' to ignore)");
                        String restChoice = scanner.next();
                        
                        // If they choose to rest, increase their health by 30
                        if (restChoice.equalsIgnoreCase("y")) {
                            System.out.println("*** You just had a amazing nap and increase 30 health points. ***");
                            hero.health += 30;
                            continue;
                        }
                    }
                    
                    // Provide a list of locations for the player to choose from
                    System.out.println("\nNow choose a location for your adventure today!");
                    for (int i = 0; i < locations.size(); i++) {
                        System.out.println((i + 1) + ". " + locations.get(i).name);
                    }
                    System.out.println(locations.size() + 1 + ". Home Sweet Home");
                    System.out.println(locations.size() + 2 + ". Boring Old Bar");
                    System.out.println(locations.size() + 3 + ". My Inventory");
                    System.out.println(locations.size() + 4 + ". Quit Game");
                    int choice = safelyParseInt();
                    
                    // Depending on the player's choice, different actions occur
                    if (choice == locations.size() + 4) {
                        System.out.println("*** Thank you for playing! Goodbye! ***");
                        System.exit(0);
                    } else if (choice == locations.size() + 3) {
                        hero.inventory.showInventory();
                    } else if (choice > 0 && choice <= locations.size()) {
                        Location location = locations.get(choice - 1);
                                            System.out.println("Welcome to " + location.name + "!");
                        System.out.println("Choose an enemy you would like to fight today:");

                        for (int i = 0; i < location.enemies.size(); i++) {
                            System.out.println((i + 1) + ". " + location.enemies.get(i).type);
                        }

                        int enemyChoice = safelyParseInt();
                        scanner.nextLine();

                        if (enemyChoice > 0 && enemyChoice <= location.enemies.size()) {
                            Enemy chosenEnemy = location.enemies.get(enemyChoice - 1);
                            chosenEnemy.fightEnemy(hero);
                        } else {
                            System.out.println("--- Invalid enemy choice. ---");
                        }
                    } else if (choice == locations.size() + 1) {
                        System.out.println("You're at Home Sweet Home. What do you want to do?");
                        System.out.println("1. Pillow fight with yourself.");
                        System.out.println("2. Lying in bed, chilling and watching TikTok.");
                        int homeChoice = safelyParseInt();

                        switch (homeChoice) {
                            case 1:
                                System.out.println("*** You achieved nothing. ***");
                                break;
                            case 2:
                                System.out.println("*** You accidentally fell asleep and increase 30 health points during the nap. ***");
                                hero.health += 30;
                                break;
                            default:
                                System.out.println("--- Invalid choice. Try again. ---");
                        }
                    } else if (choice == locations.size() + 2) {
                        System.out.println("You're at Whatever Bar. What do you want to do?");
                        System.out.println("1. Talk to beautiful people.");
                        System.out.println("2. Drink the strongest liquor ever!");
                        int barChoice = safelyParseInt();

                        switch (barChoice) {
                            case 1:
                                System.out.println("*** Beautiful people don't like you, they walked away. ***");
                                break;
                            case 2:
                                System.out.println("*** You feel a strong fire inside your stomach. Strength up by 30 point!!! ***");
                                hero.strength += 30;
                                break;
                            default:
                                System.out.println("--- Invalid choice. Try again. ---");
                        }
                    } else {
                        System.out.println(" --- Invalid choice. Try again. ---");
                    }

                    Game.saveGame(hero);
                    Game.printHeroStats(hero);
                }
                
                // If the player's health is zero or they reach level 100, the game ends
                if (hero.health <= 0) {
                        System.out.println("*** Game over! Your hero has fallen. ***");
                        System.out.println(" _____                         ____                 ");
                        System.out.println("|  __ \\                       / __ \\                ");
                        System.out.println("| |  \\/ __ _ _ __ ___   ___  | |  | |_   _____ _ __ ");
                        System.out.println("| | __ / _` | '_ ` _  \\/ _ \\ | |  | \\ \\ / / _ \\ '__|");
                        System.out.println("| |_\\ \\ (_| | | | | | |  __/ | |__| |\\ V /  __/ |   ");
                        System.out.println(" \\____/\\__,_|_| |_| |_|\\___|  \\____/  \\_/ \\___|_|   ");



                } else if (hero.level >= 100) {
                        System.out.println("*** Congratulations! Your hero has reached level 100! ***");
                        System.out.println(" __        __   _    _   _ ");
                        System.out.println(" \\ \\      / /  (_)  | \\ | | ");
                        System.out.println("  \\ \\ /\\ / /   | |  |  \\| | ");
                        System.out.println("   \\ V  V /    | |  | |\\  | ");
                        System.out.println("    \\_/\\_/     |_|  |_| \\_| ");

                }

                // when the game ends, the high scores will be updated if the 
                // hero's score is higher than their previous score. 
                // The high scores will be saved to a file and printed to the console.
                if (hero.health <= 0 || hero.level >= 100) {
                    hero.HeroScore();

                    System.out.println("*** Final Score: " + hero.score + " ***");

                    Map<String, Integer> highScores = Game.loadHighScores();
                    Integer currentHighScore = highScores.get(hero.name);

                    if (currentHighScore == null || hero.score > currentHighScore) {
                        highScores.put(hero.name, hero.score);
                        Game.saveHighScores(highScores);
                        System.out.println("*** New high score for " + hero.name + ": " + hero.score + " ***");
                    }

                    Game.printHighScores(highScores);
                    
                    // Call the deleteSaveFile() method to delete the save file
                    Game.deleteSaveFile();
                }
            }
        }   
    }
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleRPG;

import SimpleRPG.Archer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yucha
 */
public class Game {
    
    // Constant for the name of the game file
    private static final String GAME_FILE = "game.txt";
   
    // Method to create a new hero based on the user's choice
    public static Hero createHero(String name, int choice) {
        
        Hero hero = null;

        switch (choice) {
            case 1:
                hero = new Swordsman(name);
                break;
            case 2:
                hero = new Wizard(name);
                break;
            case 3:
                hero = new Archer(name);
                break;
            default:
                throw new IllegalArgumentException("Invalid hero choice.");
        }

        return hero;
    }
    
    // Method to save the current game state to a file
    public static void saveGame(Hero hero) {
        try {
            FileWriter fileWriter = new FileWriter(GAME_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            // Writing hero's attributes to the file
            bufferedWriter.write(hero.name + "\n");
            bufferedWriter.write(hero.type + "\n");
            bufferedWriter.write(hero.health + "\n");
            bufferedWriter.write(hero.strength + "\n");
            bufferedWriter.write(hero.agility + "\n");
            bufferedWriter.write(hero.wisdom + "\n");
            bufferedWriter.write(hero.level + "\n");
            bufferedWriter.write(hero.attack + "\n");

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }
    
    // Method to load a saved game state from a file
    public static Hero loadGame() {
        Hero hero = null;
        try {
            FileReader fileReader = new FileReader(GAME_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            // Reading hero's attributes from the file
            String name = bufferedReader.readLine();
            String type = bufferedReader.readLine();
            int health = Integer.parseInt(bufferedReader.readLine());
            int strength = Integer.parseInt(bufferedReader.readLine());
            int agility = Integer.parseInt(bufferedReader.readLine());
            int wisdom = Integer.parseInt(bufferedReader.readLine());
            int level = Integer.parseInt(bufferedReader.readLine());
            int attack = Integer.parseInt(bufferedReader.readLine());
            
            // Creating a new hero with the read attributes
            switch (type) {
                case "Swordsman":
                    hero = new Swordsman(name);
                    break;
                case "Wizard":
                    hero = new Wizard(name);
                    break;
                case "Archer":
                    hero = new Archer(name);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid hero type.");
            }

            hero.health = health;
            hero.strength = strength;
            hero.agility = agility;
            hero.wisdom = wisdom;
            hero.level = level;
            hero.attack = attack;

            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No saved game found. Starting a new game.");
        } catch (IOException e) {
            System.out.println("Error loading game: " + e.getMessage());
        }
        return hero;
    }
    
    // Method to delete the game file
    public static void deleteSaveFile() {
        File oldSave = new File(GAME_FILE);
        oldSave.delete();
    }
    
    // Method to print the current stats of the hero
    public static void printHeroStats(Hero hero) {
        System.out.println("\n$$$ Your Hero stats: $$$");
        System.out.println("Hero Name: " + hero.name);
        System.out.println("Occupation: " + hero.type);
        System.out.println("Equipped Weapon: " + (hero.inventory.equippedWeapon != null ? hero.inventory.equippedWeapon.name : "None"));
        System.out.println("Equipped Shield: " + (hero.inventory.equippedShield != null ? hero.inventory.equippedShield.name : "None"));
        System.out.println("Current Level: " + hero.level);
        System.out.println("Current Health: " + hero.health);
        System.out.println("Strength: " + hero.strength);
        System.out.println("Wisdom: " + hero.wisdom);
        System.out.println("Agility: " + hero.agility);
    }
    
    // Method to save the high scores using a Map collection
    public static void saveHighScores(Map<String, Integer> highScores) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("highScores.ser"))) {
            oos.writeObject(highScores);
        } catch (IOException e) {
            System.out.println("Error saving high scores: " + e.getMessage());
        }
    }

    // will create a new empty HashMap if the highScores.ser file is not found, 
    // allowing the program to continue without errors. 
    // The first time run the program, the file will not exist, but it will be 
    // created when save the high scores using the saveHighScores() method.
    public static Map<String, Integer> loadHighScores() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("highScores.ser"))) {
            return (HashMap<String, Integer>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No high scores file found, creating a new one.");
            return new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading high scores: " + e.getMessage());
            return new HashMap<>();
        }
    }

    public static void printHighScores(Map<String, Integer> highScores) {
        System.out.println("\n\n---*** High Scores Leader Board ***---");

        // Convert Map to List of Map.Entry objects
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(highScores.entrySet());

        // Sort the List by value in descending order
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // Print the sorted List
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleRPG;

import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author yucha
 */
public class SimpleRPG extends Application{
    
    // This method validates the input ensuring that it is a valid integer.
    private static int safelyParseInt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            try {
                // Try to parse the input string to an integer.
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // If it fails, print an error message and loop again.
                System.out.println("--- Invalid input. Please enter a number. ---");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
        
        // Display the game manual.
       // GameManual.printGameManual();

        /*int startChoice = 0;
        // Loop until a valid main menu choice is entered.
        while (startChoice < 1 || startChoice > 3) {
            System.out.println("1. *** Start a new game ***");
            System.out.println("2.    ** Resume game **");
            System.out.println("3.         * Quit *");
            System.out.println("");
            System.out.println("Enter your choice: ");
            startChoice = safelyParseInt();

            if (startChoice < 1 || startChoice > 3) {
                System.out.println("--- Invalid input. Please choose a valid option. ---");
            }
        }
        // If the player chooses to quit, exit the game.
        if (startChoice == 3) {
            System.out.println("Thank you for playing! Goodbye!");
            System.exit(0);
        }
        // If a new game is chosen, delete the old save file.
        if (startChoice == 1) {
            Game.deleteSaveFile();
        }*/
        // Try to load the game.
        /*Hero hero = Game.loadGame();
        
        // If no game was loaded (i.e., it's a new game), create a new hero.
        if (hero == null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the name of your hero: ");
            String name = scanner.nextLine();

            int choice = 0;
            while (choice < 1 || choice > 3) {
                System.out.println("Choose your hero's occupation: ");
                System.out.println("1. Swordsman");
                System.out.println("2. Wizard");
                System.out.println("3. Archer");
                choice = safelyParseInt();

                if (choice < 1 || choice > 3) {
                    System.out.println("--- Invalid input. Please choose a valid option. ---");
                }
            }

            hero = Game.createHero(name, choice);
            Drawing.displayASCIIArt(choice);
            Game.printHeroStats(hero);
        } else {
            System.out.println("Welcome back, " + hero.name + " the " + hero.type + "!");
        }
        // Start the adventure with the hero.
        Adventure adventure = new Adventure(hero);
        adventure.start();
    }

    @Override
    public void start(Stage stage) throws Exception {
        SimpleRPGView simpleRpgView = new SimpleRPGView();
        Controller controller = new Controller(simpleRpgView, stage);
        stage.setTitle("Simple RPG");
        stage.setWidth(1000);
        stage.setHeight(1000);
        stage.setScene(simpleRpgView.getScene());
        stage.show();
        Display.printGameManual(controller);
        Display.printMenuChoices(controller);
        */
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleRPG;

/**
 *
 * @author yucha
 */
public class GameManual {
    
    // This method prints out the game manual.
    public static void printGameManual() {
        
        System.out.println("        ***** Welcome to the SimpleRPG game *****\n"
                + "In this game, you will create a hero and embark on a journey to\n"
                + "explore various locations and fight against a range of enemies.\n"
                + "\n"
                + "*** About Occupation ***\n" 
                + "Each occupation has its unique set of starting attributes,\n"
                + "such as health, strength, agility, wisdom, and attack.\n" 
                + "\n"
                + "*** About adventure ***\n"
                + "Each adventure has a different enemy type, and some locations\n"
                + "have special effects on your hero's attributes.\n" 
                + "When you choose a location, you will encounter an enemy and\n"
                + "engage in a fight and your hero will level up.\n"
                + "\n"
                +"*** About Inventory ***\n"
                + "There are three kinds of weapon and shield: paper/iron/diamond.\n"
                + "Your hero will acuquire only one of them for each flight randomly.\n"
                + "The item will give you a stat boost by 20-80 once equipped.\n" 
                + "\n"
                + "*** Winning & Losing conditions ***\n" 
                + "- Your hero's health drops to 0 or below, game over.\n" 
                + "- Your hero reaches level 100, and you win the game.\n");
        }
}

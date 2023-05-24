/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleRPG;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author yucha
 */
public class Enemy {
    String type;
    int health;
    int attack;
    
    // Constructor for the Enemy class. It initializes the type, health, and attack of the enemy.
    public Enemy(String type, int health, int attack) {
        this.type = type;
        this.health = health;
        this.attack = attack;
    }
    
    // The fightEnemy method is where the actual combat takes place.
    public void fightEnemy(Hero hero) {
        
        Scanner scanner = new Scanner(System.in);
            if (this != null) {
                System.out.println("*** Fighting a " + this.type + " with attack points: " + this.attack + " ***");
                System.out.println("*** Fighting...ends in 3 seconds ***");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted while waiting: " + e.getMessage());
                }

                hero.attack();  // Hero attacks the enemy
                this.health -= hero.attack;
                hero.health -= this.attack;
                
                // If the enemy's health is less than or equal to 0, the hero has won.
                if (this.health <= 0) {
                System.out.println("*** You have defeated the enemy! ***");
                }
                
                // Hero gains a random amount of levels after a fight.
                int previousLevel = hero.level;
                hero.level += (int) (Math.random() * 21) + 20; // Level up by 10 to 30
                
                // If the hero's health is less than or equal to 0, the game is over.
                if (hero.health <= 0) {
                    System.out.println("*** Game over! Your hero has fallen. ***");
                    return;
                }
                
                // If the hero's level is greater than or equal to 100, the player has won the game.
                if (hero.level >= 100) {
                    System.out.println("*** Congratulations! Your hero has reached level 100! ***");
                    return;
                }
            
            // If the hero has leveled up, the game announces this and the hero gets stat increases.
            if (previousLevel != hero.level) {
                System.out.println("*** Your hero has leveled up! ***");
                System.out.println("*** New level: " + hero.level + " ***");
                hero.strength += (int) (Math.random() * 11) + 1; // Randomly increase Strength by 1 to 10
                hero.wisdom += (int) (Math.random() * 11) + 1;
                hero.agility += (int) (Math.random() * 11) + 1;

                // The hero's attack is recalculated based on their occupation and new stats.
                if (hero.type.equals("Swordsman")) {
                    hero.attack = (int) (hero.strength * 1.5 + hero.wisdom * 0.5 + hero.agility * 0.5);
                } else if (hero.type.equals("Wizard")) {
                    hero.attack = (int) (hero.strength * 0.5 + hero.wisdom * 1.5 + hero.agility * 0.5);
                } else if (hero.type.equals("Archer")) {
                    hero.attack = (int) (hero.strength * 0.5 + hero.wisdom * 0.5 + hero.agility * 1.5);
                }

                // Check the hero's health and level again before equipping items
                if (hero.health <= 0 || hero.level >= 100) {
                    return;
                }
                
                // Generate a random item after the fight
                Random random = new Random();
                int itemType = random.nextInt(2); // 0 = weapon, 1 = shield
                int itemQuality = random.nextInt(3); // 0 = paper, 1 = iron, 2 = diamond

                if (itemType == 0) { // Generate weapon
                    String weaponName;
                    int attackBoost;
                    switch (itemQuality) {
                        case 0:
                            weaponName = "Paper Weapon";
                            attackBoost = 20;
                            break;
                        case 1:
                            weaponName = "Iron Weapon";
                            attackBoost = 40;
                            break;
                        case 2:
                            weaponName = "Diamond Weapon";
                            attackBoost = 80;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected itemQuality: " + itemQuality);
                    }
                    Weapon newWeapon = new Weapon(weaponName, attackBoost);
                    hero.inventory.addWeapon(newWeapon);
                    System.out.println("!!! You've acquired a " + weaponName + " !!!");

                    // Prompt the user to equip the new weapon
                    System.out.println("Do you want to equip the new weapon? ('y' to equip OR 'any other key' put into inventory)");
                    String userInput = scanner.nextLine().trim().toUpperCase();
                    if ("Y".equals(userInput)) {
                        hero.inventory.equipWeapon(newWeapon);
                        hero.attack += newWeapon.attackBoost;
                        System.out.println("*** You have equipped the " + newWeapon.name + " ***");
                        System.out.println("*** Your stats have boosted up! ***");
                    }
                } else { // Generate shield
                    String shieldName;
                    int healthBoost;
                    switch (itemQuality) {
                        case 0:
                            shieldName = "Paper Shield";
                            healthBoost = 20;
                            break;
                        case 1:
                            shieldName = "Iron Shield";
                            healthBoost = 40;
                            break;
                        case 2:
                            shieldName = "Diamond Shield";
                            healthBoost = 80;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected itemQuality: " + itemQuality);
                    }
                    Shield newShield = new Shield(shieldName, healthBoost);
                    hero.inventory.addShield(newShield);
                    System.out.println("!!! You've acquired a " + shieldName + " !!!");

                    // Prompt the user to equip the new shield
                    System.out.println("Do you want to equip the new shield? ('y' to equip OR 'any other key' put into inventory)");
                    String userInput = scanner.nextLine().trim().toUpperCase();
                    if ("Y".equals(userInput)) {
                        hero.inventory.equipShield(newShield);
                        hero.health += newShield.healthBoost;
                        System.out.println("*** You have equipped the " + newShield.name + " ***");
                        System.out.println("*** Your stats have boosted up! ***");
                    }
                }
            }
        }
    }
}


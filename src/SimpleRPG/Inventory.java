/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleRPG;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yucha
 */
public class Inventory {
    Weapon equippedWeapon; // The currently equipped weapon.
    Shield equippedShield; // The currently equipped shield.
    List<Weapon> weapons; // List of weapons in the inventory.
    List<Shield> shields; // List of shields in the inventory.

    // Constructor initializes the weapons and shields lists.
    public Inventory() {
        weapons = new ArrayList<>();
        shields = new ArrayList<>();
    }
    
    // Method to add a weapon to the inventory.
    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }
    
    // Method to add a shield to the inventory.
    public void addShield(Shield shield) {
        shields.add(shield);
    }
    
    // Method to equip a weapon.
    public void equipWeapon(Weapon weapon) {
        equippedWeapon = weapon;
    }

    // Method to equip a shield.
    public void equipShield(Shield shield) {
        equippedShield = shield;
    }
    
    // Method to print the contents of the inventory.
    public void showInventory() {
    System.out.println("***---*** My Inventory ***---***");
    System.out.println("Equipped Weapon: " + (equippedWeapon != null ? equippedWeapon.name : "None"));
    System.out.println("Equipped Shield: " + (equippedShield != null ? equippedShield.name : "None"));
    System.out.println("Available Weapons:");
    for (Weapon weapon : weapons) {
        System.out.println("- " + weapon.name);
    }
    System.out.println("Available Shields:");
    for (Shield shield : shields) {
        System.out.println("- " + shield.name);
    }
}

}


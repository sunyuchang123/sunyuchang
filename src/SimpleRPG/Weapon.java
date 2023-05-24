/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleRPG;

/**
 *
 * @author yucha
 */
public class Weapon {
    String name;
    int attackBoost; // The amount of attack power that the weapon adds when equipped.

    // Constructor initializes the weapon with a name and attack boost.
    public Weapon(String name, int attackBoost) {
        this.name = name;
        this.attackBoost = attackBoost;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleRPG;

/**
 *
 * @author yucha
 */
public class Shield {
    String name;
    int healthBoost; // The amount of health that the shield adds when equipped.

    // Constructor initializes the shield with a name and health boost.
    public Shield(String name, int healthBoost) {
        this.name = name;
        this.healthBoost = healthBoost;
    }
}

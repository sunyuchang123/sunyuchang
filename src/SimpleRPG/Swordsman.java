/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleRPG;

/**
 *
 * @author yucha
 */
public class Swordsman extends Hero {
    
    // Constructor for a Swordsman object.
    public Swordsman(String name) {
        super(name, "Swordsman", 100, 10, 5, 5, 1, 7);
    }

    // The Swordsman's specific attack method, which overrides the attack method in Hero.
    @Override
    public void attack() {
        System.out.println("*** " + this.name + " slashes with a sword with strength " + this.strength + " ***");
    }
}


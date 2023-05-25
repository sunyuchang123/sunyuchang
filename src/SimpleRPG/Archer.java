/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleRPG;

import SimpleRPG.Hero;

/**
 *
 * @author yucha
 */
public class Archer extends Hero {
        
    // Constructor for an Archer object.
    public Archer(String name) {
        super(name, "Archer", 100, 5, 10, 5, 1, 6);
    }

    // The Archer's specific attack method, which overrides the attack method in Hero.
    @Override
    public void attack() {
        System.out.println("*** " + this.name + " shoots an arrow with agility " + this.agility + " ***");
    }
}
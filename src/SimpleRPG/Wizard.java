/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleRPG;

/**
 *
 * @author yucha
 */
public class Wizard extends Hero {

    // Constructor for a Wizard object.
    public Wizard(String name) {
        super(name, "Wizard", 100, 5, 5, 10, 1, 5);
    }

    // The Wizard's specific attack method, which overrides the attack method in Hero.
    @Override
    public void attack() {
        System.out.println("*** " + this.name + " casts a spell with wisdom " + this.wisdom + " ***");
    }
}

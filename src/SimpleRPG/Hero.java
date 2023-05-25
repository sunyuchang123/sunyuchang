/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleRPG;



import SimpleRPG.Inventory;
import SimpleRPG.Location;
import javafx.scene.image.ImageView;

/**
 *
 * @author yucha
 */
public abstract class Hero {
    
    // These variables store the hero's characteristics.
    String name;
    String type;
    int health;
    int strength;
    int agility;
    int wisdom;
    int level;
    int attack;
    int score;
    Inventory inventory;
    private Location location;
    
    // Constructor for a Hero object.
    public Hero(String name, String type, int health, int strength, 
                int agility, int wisdom, int level, int attack) {
        
        // Assign the values of these variables.
        this.name = name;
        this.type = type;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.wisdom = wisdom;
        this.level = level;
        this.attack = attack;
        inventory = new Inventory(); // Initialize the hero's inventory.
    }
    
    // The attack() method is an abstract method that has been overridden in subclasses
    public void attack() {
        System.out.println(this.name + " attacks with strength " + this.strength);
    }
    
    // Method to calculate the hero's score.
    public void HeroScore() {
        score = level + health + attack;
    }
    
    
    public String getName(){
    return name;
    }
    
    public void setName(String name){
    this.name = name;
    }
    
    public String getType(){
    return type;
    }
    
    public void setType(String type){
    this.type = type;
    }
    
    public int getHealth(){
    return health;
    }
    
    public void setHealth(int health){
    this.health = health;
    }
    
    public int getStrength(){
    return strength;
    }
    
    public void setStrength(int strength){
    this.strength = strength;
    }
    
     public int getAgility(){
    return agility;
    }
    
    public void setAgility(int agility){
    this.agility = agility;
    }
    
     public int getWisdom(){
    return wisdom;
    }
    
    public void setWisdom(int wisdom){
    this.wisdom = wisdom;
    }
    
     public int getLevel(){
    return level;
    }
    
    public void setLevel(int level){
    this.level = level;
    }
    
     public int getAttack(){
    return attack;
    }
    
    public void setAttack(int attack){
    this.attack = attack;
    }
    
     public int getScore(){
    return score;
    }
    
    public void setScore(int score){
    this.score = score;
    }
    
    public void setInventory(Inventory inventory){
    this.inventory = inventory;
    }
    
    public Inventory getInventory() {
        return inventory;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
}



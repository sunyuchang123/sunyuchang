/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleRPG;

/**
 *
 * @author yucha
 */
class Weapon {
  String name;
  int attackBoost;
  
  public Weapon(String name , int attackBoost){
  this.name =name;
  this.attackBoost = attackBoost;
  }
  
  public String getNmae(){
  return name;
  }
  
  public int getAttackBoost(){
  return attackBoost;
  }
}

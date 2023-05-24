/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleRPG;

import javafx.scene.input.KeyCode;
import javafx.stage.Stage;


/**
 *
 * @author yucha
 */
public class Controller {
     private SimpleRPGView simpleRpgView;
     private Stage stage;

     private String choice;
     
     public Controller(SimpleRPGView simpleRpgView, Stage stage){
        this.simpleRpgView = simpleRpgView;
        this.stage = stage;
        initialize();
    }
     
     private void initialize(){
        addInputListener();
    }

     private void addInputListener(){
        simpleRpgView.getInputField().setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                this.choice = simpleRpgView.getInputField().getText();;
                simpleRpgView.getDisplayBoard().appendText(choice + "\n");
                simpleRpgView.getDisplayBoard().appendText("-----------------------------------\n");
                simpleRpgView.getInputField().clear();
                if(safelyParseInt(choice) < 1 || safelyParseInt(choice) > 3){
                    printMessage("--- Invalid input. Please choose a valid option. ---");
                    Display.printMenuChoices(this);
                }
                if (safelyParseInt(choice) == 3) {
                    System.out.println("Thank you for playing! Goodbye!");
                    stage.close();
                    System.exit(0);
                }
                if (safelyParseInt(choice) == 1) {
                    Game.deleteSaveFile();
                }

            }

        });
     }
     
     public void printMessage(String message){
        simpleRpgView.getDisplayBoard().appendText(message + "\n");
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }

    public int safelyParseInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            printMessage("--- Invalid input. Please enter a number. ---");
        }
        return -1;
    }
}

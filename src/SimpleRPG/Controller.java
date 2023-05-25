/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleRPG;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 *
 * @author yucha
 */
public class Controller {
     private SimpleRPGView simpleRpgView;
     private Stage stage;

     private Hero hero;
     
     public Controller(SimpleRPGView simpleRpgView, Stage stage){
        this.simpleRpgView = simpleRpgView;
        this.stage = stage;
        initialize();
    }
     
     private void initialize(){
        setHeroChooseHandler();
    }
    
     private void setHeroChooseHandler(){
     HBox hBox = simpleRpgView.getHeroChoosePanel().getHeroList();
     hBox.getChildren().forEach(node ->{
        node.setOnMouseClicked(e ->{
           if(showInputDialog(node.getId())){
             simpleRpgView.showChooseHeroPanel();
           }
        });
     });
     }
    
    private void handleHeroChoose(String heroId, String heroName){
        if(heroId.equals("swordsman")){
            this.hero = new Swordsman(heroName);
            //rootView.getGame().setHero(new Swordsman(heroName));
        } else if(heroId.equals("archer")){
            this.hero = new Archer(heroName);
            //rootView.getGame().setHero(new Archer(heroName));
        }else {
            this.hero = new Wizard(heroName);
            //rootView.getGame().setHero(new Wizard(heroName));
        }
    }
    
    private boolean showInputDialog(String heroId) {
        AtomicBoolean confirmed = new AtomicBoolean(false);
        //An AtomicBoolean is created, initialized with false. An AtomicBoolean is used in this context because it is mutable and can be updated in a lambda expression or anonymous class.
        TextInputDialog inputDialog = new TextInputDialog();
        //A new TextInputDialog object is created. 
        inputDialog.setTitle("Hero Name");
        //This sets the title of the dialog window to "Hero Name".
        inputDialog.setHeaderText(String.format("Enter your %s name:", heroId));
        //This sets the header text of the dialog window. 
        Optional<String> result = inputDialog.showAndWait();
        //The showAndWait method is called on the TextInputDialog object. 
        //This opens the dialog window and waits for the user to close it.
        //The user's input is returned as an Optional<String>. The Optional class is a container object that may or may not contain a non-null value.
        result.ifPresent(name -> {
            handleHeroChoose(heroId, name);
            confirmed.set(true);
        });
        //This method is called on the Optional<String> object. 
        //If the Optional contains a value (i.e., the user entered text), then the lambda expression inside ifPresent is executed. 
        //Inside this lambda expression, a method handleHeroChoose(heroId, name); is called (the method is not defined in the given code), and the AtomicBoolean confirmed is set to true.
        inputDialog.setOnCloseRequest(event -> {
           simpleRpgView.showChooseHeroPanel();
        });
        //This line sets an action to be performed when the dialog window is closed. In this case, a method showChooseHeroWindow(); is called on simpleRpgView. 
        return confirmed.get();
        // the method returns the value of the AtomicBoolean confirmed, which indicates whether the user entered a name.
    }
    
     
     

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleRPG;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
/**
 *
 * @author yucha
 */
public class SimpleRPGView {
    private Scene scene;
    private TextArea displayBoard;
    private TextField inputField;
    private VBox controlPanel;
    
     public SimpleRPGView(){
        BorderPane root =new BorderPane();
        //create a text area
        displayBoard = new TextArea();
        displayBoard.setEditable(false);
        displayBoard.setPrefSize(600,600);
        displayBoard.setPadding(new Insets(10,10,10,10));

        //create a text field
        inputField = new TextField();


        //create a vbox
        controlPanel = new VBox();
        controlPanel.getChildren().addAll(new Button("Attack"),new Button("Defend"),new Button("Run"));
        VBox.setMargin(controlPanel.getChildren().get(0), new Insets(10,0,10,0));
        VBox.setMargin(controlPanel.getChildren().get(1), new Insets(10,0,10,0));
        VBox.setMargin(controlPanel.getChildren().get(2), new Insets(10,0,10,0));

        root.setCenter(displayBoard);
        root.setBottom(inputField);
        root.setRight(controlPanel);

        this.scene = new Scene(root);

    }
     public Scene getScene() {
        return scene;
    }

    public TextField getInputField() {
        return inputField;
    }

    public TextArea getDisplayBoard() {
        return displayBoard;
    }
}

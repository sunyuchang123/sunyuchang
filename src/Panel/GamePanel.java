/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panel;

import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author yucha
 */
public class GamePanel extends BorderPane{
       private TextArea heroInfoBoard;
       private String heroInfo;
    
       public GamePanel(String heroInfo){
       this.heroInfo = heroInfo;
       initHeroInfo();
    }
    
    private void initHeroInfo(){
        this.heroInfoBoard = new TextArea();
        heroInfoBoard.setPadding(new Insets(10,10,10,10));
        heroInfoBoard.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        heroInfoBoard.setEditable(false);
        heroInfoBoard.appendText(heroInfo);

        this.setRight(heroInfoBoard);
    }
}

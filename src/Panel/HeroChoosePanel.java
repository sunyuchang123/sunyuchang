/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panel;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author yucha
 */
public class HeroChoosePanel extends BorderPane{
    private HBox heroList;
    
    public HeroChoosePanel(){
    initTitle();
    initHeroList();
    }
    
    private void initTitle(){
    Text title = new Text("Choose your hero!!");
    title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
    BorderPane.setAlignment(title, Pos.CENTER);
    this.setTop(title);
    }
    
    private void initHeroList(){
    this.heroList = new HBox();
    heroList.setAlignment(Pos.CENTER);
    heroList.setSpacing(50);
    
    ImageView swordsman = new ImageView(new Image(""));
    swordsman.setPreserveRatio(true);
    swordsman.setFitWidth(200);
    swordsman.setId("swordsman");
    
    ImageView archer = new ImageView(new Image(""));
    archer.setPreserveRatio(true);
    archer.setFitWidth(200);
    archer.setId("archer");
    
    ImageView wizard = new ImageView(new Image(""));
    wizard.setPreserveRatio(true);
    wizard.setFitWidth(200);
    wizard.setId("swordsman");
    
    heroList.getChildren().addAll(swordsman, archer, wizard);
    BorderPane.setAlignment(heroList, Pos.CENTER);
    this.setCenter(heroList);
    }
    
  
    public HBox getHeroList(){
    return heroList;
    }

    
}

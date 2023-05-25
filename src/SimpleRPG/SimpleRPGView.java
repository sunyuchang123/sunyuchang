/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleRPG;
import Panel.HeroChoosePanel;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
/**
 *
 * @author yucha
 */
public class SimpleRPGView {
    private Scene scene;
    
    private BorderPane view;
    private MenuBar menuBar;
    private BorderPane mainPanel;
    private HeroChoosePanel heroChoosePanel;
    private Game game;
    private TextArea heroInfoBoard;
    
    public SimpleRPGView(){
        this.view = new BorderPane();
        this.heroChoosePanel = new HeroChoosePanel();
        this.menuBar = new MenuBar();
        this.mainPanel = new BorderPane();
        this.scene = new Scene(view);
        initMainPane();

    }
     public Scene getScene() {
        return scene;
    }
    
     public void showChooseHeroPanel(){
     this.mainPanel.setCenter(heroChoosePanel);
     }
     
    public void showHeroInfoBoard(String heroInfo){
    heroInfoBoard.setPrefSize(200,500);
    heroInfoBoard.setPadding(new Insets(10,10,10,10));
    heroInfoBoard.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
    }
    
    public void updateHeroInfoBoard(String heroInfo){
        heroInfoBoard.setText(heroInfo);
    }
    
    public HeroChoosePanel getHeroChoosePanel() {
        return heroChoosePanel;
    }
    
    public void initMenuBar(){
    Menu game = new Menu("Game");
    Menu score = new Menu("Score");
    
    MenuItem newGame = new MenuItem("New Game");
    MenuItem loadGame = new MenuItem("Load Game");
    MenuItem quit = new MenuItem("Quit"); 
    MenuItem highScore = new MenuItem("Save Score");
    //add to menu
    game.getItems().addAll(newGame,loadGame,quit);
    score.getItems().addAll(highScore);
    //add to menubar
    menuBar.getMenus().addAll(game);
    menuBar.getMenus().addAll(score);
    //to create an EventHandler for the ActionEvent triggered when a user interacts with a MenuItem. The EventHandler determines what action will be taken when the event occurs.
    newGame.setOnAction(e ->{
       showChooseHeroPanel();
    });
    
    quit.setOnAction(e->{
            System.exit(0);
        });
    
    highScore.setOnAction(e->{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Score Saving");
            alert.showAndWait();
        });
    //Alert is a subclass of Dialog
    //an Alert is created with AlertType.ERROR. 
    //sets the title of the alert dialog to "Score Saving".
    // displays the alert dialog and waits for the user to close it.
    
   this.view.setTop(menuBar);
    }
    
    
    private void initMainPane(){
    TextArea displayBoard = new TextArea();
    displayBoard.setEditable(false);
    displayBoard.setPadding(new Insets(10,10,10,10));
    displayBoard.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
    displayBoard.setStyle("-fx-alignment: center;");
    displayBoard.appendText(Display.printGameManual());
    this.mainPanel.setCenter(displayBoard);
    this.view.setCenter(mainPanel);
    }

    
}

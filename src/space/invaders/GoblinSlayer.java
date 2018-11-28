package space.invaders;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GoblinSlayer extends Application {
    
    private static Stage window;
    private static Scene scene;
    
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        
        AssetManager.preloadAllAssets();
        MenuPane menu = new MenuPane();
        
        scene = new Scene(menu, 1280, 720);
        
        //the value of paused is not being printed.
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.P) {
                GamePane.paused = !GamePane.paused;
                System.out.println(GamePane.paused);
            }
        });
        
        window.setTitle("Goblin Slayer");
        window.setScene(scene);
        
        window.setOnCloseRequest(e ->{
            Platform.exit();
            System.exit(0);
        });
        window.show(); 
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static void changePane(Pane p){
        scene = new Scene(p, 1280, 720);
        window.setScene(scene);
    }
}

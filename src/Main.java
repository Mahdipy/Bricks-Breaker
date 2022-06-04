import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    Pane pane = new Pane();
    boolean n = true;
    int select =1 , select1= 6;
    public void start(Stage primaryStage) {
        Menu menu = new Menu();
        menu.n = n;
        primaryStage.getIcons().add(new Image("image/wall.png"));
        menu.start(primaryStage);

    }
    public static void main(String[] args) {
        launch(args);
    }
}
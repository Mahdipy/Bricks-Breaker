import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.ImageView;

public class Raket {
    Pane pane =  new Pane();
     Rectangle raket = new Rectangle(100,10);
     ImageView start = new ImageView(new Image("image/play.png"));
    ImageView restart = new ImageView(new Image("image/restart2.png"));

    public void Move(){
        start.setFitWidth(40);
        start.setFitHeight(40);
        start.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.D && raket.getLayoutX()<=390)
                    raket.setLayoutX(raket.getLayoutX() + 20);

                if (event.getCode() == KeyCode.A && raket.getLayoutX()>=10)
                    raket.setLayoutX(raket.getLayoutX() - 20);
            }
        });
        pane.getChildren().addAll(start,raket);
        start.setLayoutX(30);
        start.setLayoutY(460);
        restart.setLayoutX(80);
        restart.setLayoutY(457);
        restart.setFitWidth(47);
        restart.setFitHeight(47);
    }

}

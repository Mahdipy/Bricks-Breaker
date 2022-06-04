import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class End {
    Pane pane = new Pane();
    Label Score = new Label();
    Menu menu = new Menu();
    public Pane loose( Stage primaryStage , int minute , int second , int theme , int control ){
        pane.setStyle("-fx-background-image: url(image/gameover.jpg)");
        //Label label = new Label("Game Over");
        //label.setTextFill(Color.RED);
        Label time = new Label();
        if (second<10)
            time.setText("0"+minute +" : 0" + second);
        else
            time.setText("0"+minute +" : " + second);
        Button Restart = new Button("Restart");
        Button Exit = new Button("Exit");
        Score.setTextFill(Color.GREEN);
        //label.setLayoutX(60);
        //label.setLayoutY(70);
        Score.setLayoutY(300);
        Score.setLayoutX(140);
        time.setLayoutY(365);
        time.setLayoutX(175);
        Restart.setLayoutY(450);
        Restart.setLayoutX(130);
        Exit.setLayoutY(450);
        Exit.setLayoutX(275);
        time.setTextFill(Color.WHITE);
        Exit.setPrefSize(80,30);
        Restart.setPrefSize(80,30);
        Restart.setStyle("-fx-background-color: green;"+
                "-fx-background-radius:50,50,50,50");
        Exit.setStyle("-fx-background-color: green;"+
                "-fx-background-radius:50,50,50,50");
        Exit.setTextFill(Color.WHITE);
        Exit.setFont(Font.font(null,FontWeight.BOLD,15));
        Restart.setFont(Font.font(null,FontWeight.BOLD,15));
        Restart.setTextFill(Color.WHITE);
        time.setFont(Font.font(null, FontWeight.BOLD, 49));
        Score.setFont(Font.font(null, FontWeight.BOLD, 49));
        pane.getChildren().addAll(Score,Restart,Exit ,time);
        //label.setFont(Font.font(null, FontWeight.BOLD, 69));
        Exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(0);
            }
        });
        Restart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event)
            {
                menu.selected[0] = theme;
                menu.selected[1] = control;
                menu.start(primaryStage );
            }
        });
        Restart.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Restart.setPrefSize(100, 40);
                Restart.setLayoutX(120);
                Restart.setLayoutY(445);
            }
        });
        Restart.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Restart.setPrefSize(80, 30);
                Restart.setLayoutX(130);
                Restart.setLayoutY(450);
            }
        });
        Exit.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Exit.setPrefSize(100, 40);
                Exit.setLayoutX(265);
                Exit.setLayoutY(445);
            }
        });
        Exit.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Exit.setPrefSize(80, 30);
                Exit.setLayoutX(275);
                Exit.setLayoutY(450);
            }
        });
        return pane;
       }
    public Pane win(Stage primaryStage, int minute , int second , int theme , int paddleControl ) {
            //pane.setStyle("-fx-background-color: black");
            pane.setStyle("-fx-background-image: url(image/wb.jpg)");
            Label time = new Label();
            if (second < 10)
                time.setText("0" + minute + " : 0" + second);
            else
                time.setText("0" + minute + " : " + second);
            Button Restart = new Button("Restart");
            Button Exit = new Button("Exit");
            Score.setTextFill(Color.BLACK);
            Score.setLayoutY(100);
            Score.setLayoutX(210);
            time.setLayoutY(165);
            time.setLayoutX(190);
            Restart.setLayoutY(450);
            Restart.setLayoutX(130);
            Exit.setLayoutY(450);
            Exit.setLayoutX(290);
            time.setTextFill(Color.WHITE);
            Exit.setPrefSize(80, 30);
            Restart.setPrefSize(80, 30);
            Restart.setStyle("-fx-background-color: green;" +
                    "-fx-background-radius:50,50,50,50");
            Exit.setStyle("-fx-background-color: green;" +
                    "-fx-background-radius:50,50,50,50");
            Exit.setTextFill(Color.WHITE);
            Exit.setFont(Font.font(null, FontWeight.BOLD, 15));
            Restart.setFont(Font.font(null, FontWeight.BOLD, 15));
            Restart.setTextFill(Color.WHITE);
            time.setFont(Font.font(null, FontWeight.BOLD, 39));
            Score.setFont(Font.font(null, FontWeight.BOLD, 49));
            pane.getChildren().addAll(Score, Restart, Exit, time);
            //label.setFont(Font.font(null, FontWeight.BOLD, 69));
            Exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.exit(0);
                }
            });
            Restart.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    menu.selected[0] = theme;
                    menu.selected[1] = paddleControl;
                    menu.start(primaryStage);
                }
            });
            Restart.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Restart.setPrefSize(100, 40);
                    Restart.setLayoutX(120);
                    Restart.setLayoutY(445);
                }
            });
            Restart.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Restart.setPrefSize(80, 30);
                    Restart.setLayoutX(130);
                    Restart.setLayoutY(450);
                }
            });
            Exit.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Exit.setPrefSize(100, 40);
                    Exit.setLayoutX(280);
                    Exit.setLayoutY(445);
                }
            });
            Exit.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Exit.setPrefSize(80, 30);
                    Exit.setLayoutX(290);
                    Exit.setLayoutY(450);
                }
            });
            return pane;
        }
    }
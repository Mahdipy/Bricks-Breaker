import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Menu {
    Music music = new Music();
    Pane pane = new Pane();
    Scene scene = new Scene(pane, 488, 500);
    Pane pane1 = new Pane();
    Pane paneSetting = new Pane();
    Pane paneHelp = new Pane();
    int selected[]={1,4};
    boolean n = true;

    public void start(Stage primaryStage) {
        //primaryStage.getIcons().add(new Image("image/wall.png"));
        //bricks breaker text
        Text t = new Text();
        t.setX(7);
        t.setY(90);
        t.setText("Bricks Breaker");
        t.setFill(Color.DARKGRAY);
        t.setStrokeWidth(2);
        t.setStroke(Color.WHITE);
        t.setLayoutX(10);
        t.setLayoutY(100);
        t.setFont(Font.font(null, FontWeight.BOLD, 69));

        Button btn1 = new Button("Easy");
        Button btn2 = new Button("Medium");
        Button btn3 = new Button("Hard");
        Button btnStart = new Button("Start");
        Button btn4 = new Button("Exit");
        btnStart.setTextFill(Color.BLACK);
        btn4.setTextFill(Color.BLACK);
        btnStart.setPrefSize(100,40);
        btnStart.setLayoutY(310);
        btnStart.setLayoutX(200);
        btn1.setLayoutX(50);
        btn2.setLayoutX(50);
        btn3.setLayoutX(50);
        btn1.setLayoutY(170);
        btn2.setLayoutY(240);
        btn3.setLayoutY(310);
        btn4.setLayoutX(200);
        btn4.setLayoutY(380);
        btn1.setPrefSize(80, 30);
        btn2.setPrefSize(80, 30);
        btn3.setPrefSize(80, 30);
        btn4.setPrefSize(100, 40);
        btnStart.setFont(Font.font(null,FontWeight.BOLD,15));
        btn4.setFont(Font.font(null,FontWeight.BOLD,15));
        btnStart.setStyle("-fx-background-color: orange;"+
                          "-fx-background-radius:50,50,50,50");
        btn4.setStyle("-fx-background-color: orange;"+
                      "-fx-background-radius:50,50,50,50");

        color(); //animationTimer for rectangles

        ImageView setting = new ImageView(new Image("image/15.png"));
        ImageView help = new ImageView(new Image("image/16.png"));
        setting.setFitWidth(40);
        setting.setFitHeight(40);
        setting.setLayoutX(20);
        setting.setLayoutY(450);
        help.setLayoutX(440);
        help.setLayoutY(450);

        Label level = new Label("Choose\nYour\nLevel");
        level.setTextFill(Color.WHITE);
        level.setLayoutX(350);
        level.setLayoutY(160);
        level.setFont(Font.font(null,FontWeight.BOLD,40));
        //first page
        pane.getChildren().addAll(t,btnStart, btn4 , help , setting);
        pane.setStyle("-fx-background-color: rgb(20,0,40)");

        //level page
        pane1.getChildren().addAll(btn1,btn2,btn3,level);
        pane1.setStyle("-fx-background-image: url(image/2.jpg)");

        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        Ball ball = new Ball();
        music.start();
        setting();
        ///////////////////////////////////////////////////////////////////
        //buttons action
        btnStart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                scene.setRoot(pane1);
                primaryStage.setScene(scene);
            }
        });
        btn1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ball.speedX = 4;
                ball.speedY = -5;
                ball.speed = 3;
                ball.Move(selected[0] ,selected[1]);
                music.stop();
                primaryStage.close();
            }
        });
        btn2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ball.speedX = 7;
                music.stop();
                ball.speedY = -8;
                ball.speed = 4;
                ball.Move(selected[0],selected[1]);
                ball.raketSpeed=15;
                primaryStage.close();
            }
        });
        btn3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ball.speedX = 9;
                music.stop();
                ball.speedY = -10;
                ball.speed = 6;
                ball.raketSpeed=20;
                ball.t = 4;
                //music.hard();
                ball.Move(selected[0] , selected[1]);
                primaryStage.close();
            }
        });
        btn4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(0);
            }
        });
        btn1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn1.setPrefSize(90, 40);
                btn1.setLayoutX(45);
                btn1.setLayoutY(165);
            }
        });
        btn1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn1.setPrefSize(80, 30);
                btn1.setLayoutX(50);
                btn1.setLayoutY(170);
            }
        });
        btnStart.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnStart.setPrefSize(120, 50);
                btnStart.setLayoutX(190);
                btnStart.setLayoutY(305);
                btnStart.setFont(Font.font(null,FontWeight.BOLD,20));
            }
        });
        btnStart.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnStart.setPrefSize(100, 40);
                btnStart.setLayoutX(200);
                btnStart.setLayoutY(310);
                btnStart.setFont(Font.font(null,FontWeight.BOLD,15));
            }
        });
        btn2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn2.setPrefSize(90, 40);
                btn2.setLayoutX(45);
                btn2.setLayoutY(235);
            }
        });
        btn2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn2.setPrefSize(80, 30);
                btn2.setLayoutX(50);
                btn2.setLayoutY(240);
            }
        });
        btn3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn3.setPrefSize(90, 40);
                btn3.setLayoutX(45);
                btn3.setLayoutY(305);
            }
        });
        btn3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn3.setPrefSize(80, 30);
                btn3.setLayoutX(50);
                btn3.setLayoutY(310);
            }
        });
        btn4.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn4.setPrefSize(120, 50);
                btn4.setLayoutX(190);
                btn4.setLayoutY(375);
                btn4.setFont(Font.font(null,FontWeight.BOLD,20));
            }
        });
        btn4.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn4.setPrefSize(100, 40);
                btn4.setLayoutX(200);
                btn4.setLayoutY(380);
                btn4.setFont(Font.font(null,FontWeight.BOLD,15));
            }
        });
        setting.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setting.setLayoutX(15);
                setting.setLayoutY(445);
                setting.setFitHeight(50);
                setting.setFitWidth(50);

            }
        });
        setting.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setting.setLayoutY(450);
                setting.setLayoutX(20);
                setting.setFitWidth(40);
                setting.setFitHeight(40);
            }
        });
        help.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help.setLayoutX(435);
                help.setLayoutY(445);
                help.setFitHeight(50);
                help.setFitWidth(50);

            }
        });
        help.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help.setLayoutY(450);
                help.setLayoutX(440);
                help.setFitWidth(40);
                help.setFitHeight(40);
            }
        });
        setting.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                scene.setRoot(paneSetting);
            }
        });
        help.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help();
                scene.setRoot(paneHelp);
            }
        });
        //////////////////////////////////////////////////////////////////////////
    }
    void color(){
        int[] j = {0};
        long start[] = {1} , end[] ={0};
        Rectangle[] rectangles = new Rectangle[5];
        for( int i = 0 ; i<5 ; i++) rectangles[i] = new Rectangle(80,20);
        rectangles[0].setLayoutY(10);
        rectangles[0].setLayoutX(15);
        rectangles[1].setLayoutY(35);
        rectangles[1].setLayoutX(110);
        rectangles[2].setLayoutY(60);
        rectangles[2].setLayoutX(210);
        rectangles[3].setLayoutY(35);
        rectangles[3].setLayoutX(310);
        rectangles[4].setLayoutY(10);
        rectangles[4].setLayoutX(405);
        System.out.println(selected[0]);
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                start[0] = System.currentTimeMillis();
                if (start[0]>end[0]){
                  if (j[0]==0){
                     rectangles[0].setFill(Color.RED);
                     rectangles[1].setFill(Color.GREEN);
                     rectangles[2].setFill(Color.BLUE);
                     rectangles[3].setFill(Color.GREEN);
                     rectangles[4].setFill(Color.RED);
                     j[0]++;
                 }
                    else if (j[0]==2){
                        rectangles[0].setFill(Color.BLUE);
                        rectangles[1].setFill(Color.RED);
                        rectangles[2].setFill(Color.GREEN);
                        rectangles[3].setFill(Color.RED);
                        rectangles[4].setFill(Color.BLUE);
                        j[0]++;
                    }
                    else if (j[0]==1){
                        rectangles[0].setFill(Color.GREEN);
                        rectangles[1].setFill(Color.BLUE);
                        rectangles[2].setFill(Color.RED);
                        rectangles[3].setFill(Color.BLUE);
                        rectangles[4].setFill(Color.GREEN);
                        j[0]++;
                    }
                    if (j[0]>2) j[0]-=3;
                    end[0]= start[0]+1100;
                }
            }
        };
        animationTimer.start();
        pane.getChildren().addAll(rectangles);
        }
    public void setting() {

        ImageView imageView = new ImageView(new Image("image/theme1.png"));
        ImageView imageView1 = new ImageView(new Image("image/theme2.png"));
        ImageView imageView3 = new ImageView(new Image("image/theme3.png"));
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView1.setFitHeight(100);
        imageView1.setFitWidth(100);
        imageView3.setFitHeight(100);
        imageView3.setFitWidth(100);
        imageView.setLayoutX(72);
        imageView.setLayoutY(170);
        imageView1.setLayoutX(202);
        imageView1.setLayoutY(170);
        imageView3.setLayoutX(332);
        imageView3.setLayoutY(170);
        final ToggleGroup group = new ToggleGroup();
        final ToggleGroup group1 = new ToggleGroup();
        ///////////////////////////////////////////////////
        RadioButton rbMouse = new RadioButton("");
        rbMouse.setToggleGroup(group1);
        rbMouse.setUserData(5);
        RadioButton rbKeyboard = new RadioButton("");
        rbKeyboard.setToggleGroup(group1);
        rbKeyboard.setUserData(4);
        rbKeyboard.setSelected(true);
        rbMouse.setLayoutX(295);
        rbKeyboard.setLayoutX(175);
        rbKeyboard.setLayoutY(380);
        rbMouse.setLayoutY(380);
        ImageView IVKeyboard = new ImageView(new Image("image/keyboard (5).png"));
        ImageView IVMouse = new ImageView(new Image("image/mouse (4).png"));
        IVKeyboard.setFitHeight(90);
        IVKeyboard.setFitWidth(90);
        IVMouse.setFitHeight(60);
        IVMouse.setFitWidth(60);
        IVKeyboard.setLayoutX(140);
        IVKeyboard.setLayoutY(400);
        IVMouse.setLayoutX(280);
        IVMouse.setLayoutY(410);
        IVKeyboard.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rbKeyboard.setSelected(true);
            }
        });
        IVMouse.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rbMouse.setSelected(true);
            }
        });
        group1.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle old_toggle, Toggle new_toggle) {
                if (group1.getSelectedToggle() != null) {
                    selected[1] = (int) group1.getSelectedToggle().getUserData();
                }
            }
        });
        Label labelControl = new Label("CONTROL");
        labelControl.setFont(Font.font(null, FontWeight.BOLD,30));
        labelControl.setTextFill(Color.WHITE);
        labelControl.setLayoutX(180);
        labelControl.setLayoutY(310);
        Line lineControl = new Line();
        lineControl.setEndX(400);
        lineControl.setEndY(360);
        lineControl.setStartX(100);
        lineControl.setStartY(360);
        lineControl.setStrokeWidth(5);
        lineControl.setStroke(Color.WHITE);
        paneSetting.getChildren().addAll(lineControl,labelControl,rbKeyboard,rbMouse,IVKeyboard,IVMouse);
        ///////////////////////////////////////////////////
        RadioButton rb1 = new RadioButton("");
        rb1.setToggleGroup(group);
        rb1.setUserData(1);
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("");
        rb2.setToggleGroup(group);
        rb2.setUserData(2);
        RadioButton rb3 = new RadioButton("");
        rb3.setToggleGroup(group);
        rb3.setUserData(3);

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle old_toggle, Toggle new_toggle) {
                if (group.getSelectedToggle() != null) {
                    selected[0] = (int) group.getSelectedToggle().getUserData();
                }
            }
        });
        Label label = new Label("THEME");
        label.setFont(Font.font(null, FontWeight.BOLD,30));
        label.setTextFill(Color.WHITE);
        label.setLayoutX(200);
        label.setLayoutY(50);
        Line line = new Line();
        line.setEndX(400);
        line.setEndY(100);
        line.setStartX(100);
        line.setStartY(100);
        line.setStrokeWidth(5);
        line.setStroke(Color.WHITE);
        ImageView imageView2 = new ImageView(new Image("image/back.png"));
        imageView2.setLayoutY(10);
        imageView2.setLayoutX(10);
        imageView2.setFitHeight(40);
        imageView2.setFitWidth(50);
        rb1.setLayoutX(115);
        rb2.setLayoutX(245);
        rb3.setLayoutX(375);
        rb1.setLayoutY(120);
        rb2.setLayoutY(120);
        rb3.setLayoutY(120);
        paneSetting.setStyle("-fx-background-color: rgb(20,0,40)");
        paneSetting.getChildren().addAll(imageView3 , imageView , imageView1 , line , label,imageView2,rb1,rb2,rb3);
        imageView2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                scene.setRoot(pane);
            }
        });
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rb1.setSelected(true);
            }
        });
        imageView1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rb2.setSelected(true);
            }
        });
        imageView3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rb3.setSelected(true);
            }
        });
    }
    void help(){
        Rectangle[] rectangles = new Rectangle[4];
        Label[] labels = new Label[4];
        for (int i = 0 ; i<4 ; i++){
            labels[i] = new Label();
            labels[i].setTextFill(Color.WHITE);
            labels[i].setLayoutX(100);
            labels[i].setLayoutY(125+(50*i));
            labels[i].setFont(Font.font(null,FontWeight.BOLD,15));
            rectangles[i] = new Rectangle(60,30);
            rectangles[i].setLayoutX(350);
            rectangles[i].setLayoutY(120+(50*i));
        }
        labels[0].setText("Normal Bricks");
        labels[2].setText("Make The Paddle Length *2 (10 S)");
        labels[3].setText("Make The Ball Speed /2 (20 S)");
        labels[1].setText("Make The Score *2 (15 S)");
        rectangles[0].setFill(Color.BLUE);
        rectangles[1].setFill(Color.SILVER);
        rectangles[2].setFill(Color.GOLD);
        rectangles[3].setFill(Color.PURPLE);
        Label label1 = new Label("*** Use A & D Buttons Or Mouse To Control The Paddle\n\n*** You Can Change The Theme In Setting");
        label1.setFont(Font.font(null,FontWeight.BOLD,15));
        label1.setTextFill(Color.WHITE);
        label1.setLayoutY(400);
        label1.setLayoutX(20);
        Label label = new Label("RECTANGLES");
        label.setFont(Font.font(null, FontWeight.BOLD,25));
        label.setTextFill(Color.WHITE);
        label.setLayoutX(180);
        label.setLayoutY(50);
        Line line = new Line();
        line.setEndX(408);
        line.setEndY(90);
        line.setStartX(100);
        line.setStartY(90);
        line.setStrokeWidth(5);
        line.setStroke(Color.WHITE);
        ImageView imageView2 = new ImageView(new Image("image/back.png"));
        imageView2.setLayoutY(10);
        imageView2.setLayoutX(10);
        imageView2.setFitHeight(40);
        imageView2.setFitWidth(50);
        imageView2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                scene.setRoot(pane);
            }
        });
        paneHelp.setStyle("-fx-background-color: rgb(20,0,40)");
        paneHelp.getChildren().addAll(label1,label,line,imageView2);
        paneHelp.getChildren().addAll(rectangles);
        paneHelp.getChildren().addAll(labels);
    }
    }

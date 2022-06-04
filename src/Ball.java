import com.sun.org.apache.regexp.internal.RE;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

public class Ball {
    // Numbers
    boolean timer = false;
    int t=0 , raketSpeed = 10 , paddleControl;
    double speedY, speedX, speed ,x = 250, y = 330, sw , sw1 , sw2 , sw3 , sw4 , sw5 ;
    int swXYZ , scoreAdd = 1 , raketLength = 100 , sws , minute , second;
    long startTime = 1 , firstTime , endTime = 0 ;
    int[] score = new int[1];
    int[] maxX = new int[24];
    int[] cnt = new int[1];
    double[] degree = new double[1];
    //Stuff
    Circle ball = new Circle(10);
    Pane pane = new Pane();
    Label label = new Label("PRIZE!");
    Label time = new Label("");
    Label Score = new Label("Score: " + score[0]);
    // Objects
    Menu menu = new Menu();
    Raket raket = new Raket();
    Bricks bricks = new Bricks();
    End end = new End();
    int color=1;
    Button Restart = new Button("Restart");
    //Timer timer = new Timer();
    Music music = new Music();
    Stage primaryStage = new Stage();
    AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if(timer) startTime = System.currentTimeMillis();
            sws = 1;
            //Timer
            second = (int)((startTime - firstTime)/1000);
            if (second<10)
            time.setText("0"+minute +" : 0" + second);
            else
                time.setText("0"+minute +" : " + second);
            //if (color==) time.setTextFill(Color.WHITE);
            if ( second == 60){
                minute+=1;
                firstTime = System.currentTimeMillis();
            }
            //touch();
            if(speedY<0) {
                touchX();
            }
            touchY();
            prize();
            //All around the scene
            if (y <= 10) speedY *= -1;
            if (x >= 475 || x < 10) speedX *= -1;
            if (y >= 435) {
                if (x+10 >= raket.raket.getLayoutX() && x-10 <= raket.raket.getLayoutX() + raketLength && y >= 435) {
                    // Racket degree so complicated to explain :)
                    degree[0] = (((120 * (x - raket.raket.getLayoutX())) / raketLength) + 30);
                    speedY = -(Math.sin(Math.toRadians(degree[0]))) * speed;
                    speedX = -(Math.cos(Math.toRadians(degree[0]))) * speed;
                } else {
                    speedY=0;
                    speedX=0;
                    end.Score.setText("Score: " + score[0]);
                    //Game over

                    Scene scene = new Scene(end.loose( primaryStage , minute , second , color , paddleControl ), 488, 500);
                    animationTimer.stop();
                    //primaryStage.setTitle("Game");
                    primaryStage.setScene(scene);
                    /*primaryStage.setResizable(false);
                    primaryStage.show();*/

                }
            }
            //If all the bricks have been removed
            for (int j = 0 ; j<24 ; j++) if (maxX[j]==1) cnt[0]++;
            if (cnt[0]==24){
                end.Score.setText(""+score[0]);
                //Win
                Scene scene = new Scene(end.win(primaryStage , minute , second , color ,paddleControl),488,500);
                animationTimer.stop();
                primaryStage.setScene(scene);
            }else cnt[0]=0;
            ball.setLayoutX(ball.getLayoutX() + speedX);
            ball.setLayoutY(ball.getLayoutY() + speedY);
            x += speedX;
            y += speedY;
            swXYZ=0;
        }
    };
    public  void Move(int theme , int control) {
        primaryStage.getIcons().add(new Image("image/wall.png"));
        color=theme;
        paddleControl = control;
        Score.setTextFill(Color.BLACK);
        Line line = new Line(0,455,500,455);
        line.setStrokeWidth(3);
        pane.getChildren().addAll(line);
        label.setTextAlignment(TextAlignment.CENTER);
        raket.raket.setLayoutY(440);
        label.setFont(Font.font(null, FontWeight.BOLD, 33));
        label.setLayoutY(120);
        label.setLayoutX(180);
        label.setVisible(false);
        label.setTextFill(Color.GOLD);
        raket.raket.setLayoutX(200);
        ball.setLayoutX(x);
        ball.setLayoutY(y);
        Score.setLayoutY(458);
        Score.setLayoutX(340);
        time.setLayoutY(465);
        time.setLayoutX(210);
        // Add bricks & Labels
        bricks.Rectangle();
        bricks.label();
        ball.setFill(Color.rgb(0, 200, 200));
        if (theme ==2){
            time.setTextFill(Color.WHITE);
            line.setStroke(Color.GRAY);
            pane.setStyle("-fx-background-image: url(image/bg1.jpg)");
            raket.raket.setFill(Color.GRAY);
            for (int i = 0 ; i<24 ; i++){
                bricks.rectangle[i].setStroke(Color.BLACK);
                Score.setTextFill(Color.WHITE);
                ball.setFill(Color.WHITE);
            }
        }
        else if (theme ==3){
            line.setStroke(Color.WHITE);
            pane.setStyle("-fx-background-image: url(image/bg5.jpg)");
            Score.setTextFill(Color.WHITE);
            raket.raket.setFill(Color.WHITE);
            ball.setFill(Color.rgb(0,255,100));
        }
        //Add Racket and move it
        raket.Move();
        //Getting the first time for timer
        firstTime = System.currentTimeMillis();
        pane.getChildren().addAll(time,label, ball, raket.pane, bricks.pane, Score);
        Score.setFont(Font.font(null, FontWeight.BOLD, 30));
        time.setFont(Font.font(null, FontWeight.BOLD, 25));
       //
        //Animation

        //animationTimer.start();
        Restart.setLayoutX(100);
        Restart.setLayoutY(470);
        //Image image = new Image("3.jpg");
        //ImageView imageView = new ImageView(image);
        Restart.setAlignment(Pos.CENTER_LEFT);
        Restart.setPrefSize(60,20);
        //Restart Button
        int cntbt[]={0};
        if (control==5) {
            pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    raket.raket.setLayoutX(event.getX() - 50);
                }
            });
        }
        else if (control==4){
            Restart.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode() == KeyCode.D && raket.raket.getLayoutX() <= 488 - raketLength)
                        raket.raket.setLayoutX(raket.raket.getLayoutX() + raketSpeed);

                    if (event.getCode() == KeyCode.A && raket.raket.getLayoutX() >= 10)
                        raket.raket.setLayoutX(raket.raket.getLayoutX() - raketSpeed);
                }
            });
        }
        Restart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                animationTimer.stop();
                menu.selected[0]= theme;
                menu.selected[1] = paddleControl;
                menu.start(primaryStage);
            }

        });
        raket.start.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (cntbt[0]%2==0) {
                    timer=true;
                    animationTimer.start();

                    raket.start.setImage(new Image("image/pause.png"));
                }
                else {
                    timer=false;
                        animationTimer.stop();

                        raket.start.setImage(new Image("image/play.png"));
                }
                cntbt[0]++;
            }
        });
        //Restart.setVisible(false);
        //pane.getChildren().add(raket.restart);
        pane.getChildren().addAll(Restart);
        Scene scene = new Scene(pane, 478, 500);
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
//A method if ball hit the bottom of the bricks
    public void touchX() {
        for (int i = 0; i < 24; i++) {
            if (y <= ((i / 8) + 1) * 35 + 4 + t && y>=((i / 8) + 1) * 35 -3 - t ) {
                if (i < 8 && x >= ((i) * 60)-7 && x <= bricks.rectangle[i].getLayoutX() + ((i + 1) * 60)+7 && maxX[i] == 0) {
                    if (swXYZ == 0) {
                        swXYZ = 1;
                        bricks.label[i].setText("" + (--bricks.number[i]));
                        speedY *= -1;
                        music.hit();
                        score[0] += scoreAdd;
                        Score.setText("Score: " + score[0]);
                        if (bricks.number[i] == 0) {
                            bricks.rectangle[i].setVisible(false);
                            bricks.label[i].setText("");
                            maxX[i] = 1;
                        }
                        sws = 0;
                        break;
                    }
                }
                if (i > 7 && i < 16 && x >= ((i - 8) * 60) - 7 && x <= bricks.rectangle[i].getLayoutX() + ((i - 7) * 60)+7 && maxX[i] == 0) {
                    if (swXYZ == 0) {
                        swXYZ=1;
                        bricks.label[i].setText("" + (--bricks.number[i]));
                        speedY *= -1;
                        music.hit();
                        score[0] += scoreAdd;
                        Score.setText("Score: " + score[0]);
                        if (bricks.number[i] == 0) {
                            bricks.rectangle[i].setVisible(false);
                            bricks.label[i].setText("");
                            maxX[i] = 1;
                        }
                        sws = 0;
                        break;
                    }
                }
                if (i > 15 && x >= ((i - 16) * 60)-7 && x <= bricks.rectangle[i].getLayoutX() + ((i - 15) * 60)+7 && maxX[i] == 0) {
                    if (swXYZ == 0) {
                        swXYZ=1;
                        bricks.label[i].setText("" + (--bricks.number[i]));
                        speedY *= -1;
                        music.hit();
                        score[0] += scoreAdd;
                        Score.setText("Score: " + score[0]);
                        if (bricks.number[i] == 0) {
                            bricks.rectangle[i].setVisible(false);
                            bricks.label[i].setText("");
                            maxX[i] = 1;
                        }
                        sws = 0;
                        break;
                    }
                }
            }
        }
    }
    //A method if ball hit the left side or right side of the bricks
    public void touchY() {
        for (int i = 0; i < 24; i++) {
            if (maxX[i] == 0) {
                if (((x + 10 >= bricks.label[i].getLayoutX() - 33) && (x + 10 <= bricks.label[i].getLayoutX() - 27)) ||
                  (((x - 10 >= bricks.label[i].getLayoutX() +27) && (x - 10 <= bricks.label[i].getLayoutX() + 32)))) {
                    if (y+10 >= bricks.label[i].getLayoutY() - 13 && y-10 <= bricks.label[i].getLayoutY() + 23) {
                        if (swXYZ == 0) {
                            swXYZ=1;
                            bricks.label[i].setText("" + (--bricks.number[i]));
                            speedX *= -1;
                            music.hit();
                            score[0] += scoreAdd;
                            Score.setText("Score: " + score[0]);
                            if (bricks.number[i] == 0) {
                                bricks.rectangle[i].setVisible(false);
                                bricks.label[i].setText("");
                                maxX[i] = 1;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    //A method if ball hit the edge of the bricks
    public void touch() {
        for (int i = 0; i < 24; i++) {
            if (maxX[i] == 0) {
                if ((x+10 >= bricks.label[i].getLayoutX() + 28 && x+10 <= bricks.label[i].getLayoutX() + 32 && y-10 >= bricks.label[i].getLayoutY() + 17 && y-10 <= bricks.label[i].getLayoutY() + 23) ||
                        (x-10 >= bricks.label[i].getLayoutX() - 32 && x-10 <= bricks.label[i].getLayoutX() - 28 && y-10 >= bricks.label[i].getLayoutY() + 17 && y-10 <= bricks.label[i].getLayoutY() + 23)) {
                    if (swXYZ == 0) {
                        swXYZ=1;
                        bricks.label[i].setText("" + (--bricks.number[i]));
                       // speedX *= -1;
                        speedY *= -1;
                        music.hit();
                        score[0] += scoreAdd;
                        Score.setText("Score: " + score[0]);
                        if (bricks.number[i] == 0) {
                            bricks.rectangle[i].setVisible(false);
                            bricks.label[i].setText("");
                            maxX[i] = 1;
                        }
                        break;
                    }
                }
            }
        }
    }
    //Prize method
    public void prize(){
        if (((maxX[bricks.prize[1]]==1 ) && sw1==0) ||( maxX[bricks.prize[0]]==1 && sw==0 ) ) {
            time.setTextFill(Color.RED);
            label.setTextFill(Color.GOLD);
            endTime = startTime + (10 * 1000);
            raket.raket.setWidth(200);
            raketLength = 200;
           // label.setVisible(true);
            if (((maxX[bricks.prize[1]]==1 ) && sw1==0))
                sw1++;
            else sw++;
        }
        if (((maxX[bricks.prize[2]]==1 ) && sw2==0) ||( maxX[bricks.prize[3]]==1 && sw3==0 ) ) {
            time.setTextFill(Color.RED);
            label.setTextFill(Color.SILVER);
            endTime = startTime + (20 * 1000);
            scoreAdd =2;
            //label.setVisible(true);
            if (((maxX[bricks.prize[2]]==1 ) && sw2==0))
                sw2++;
            else sw3++;
        }
        if (((maxX[bricks.prize[4]]==1 ) && sw4==0) ) {
            time.setTextFill(Color.RED);
            label.setTextFill(Color.PURPLE);
            endTime = startTime + (15 * 1000);
            speedX/=2;
            speedY/=2;
            speed/=2;
            //label.setVisible(true);
            sw4++;
            sw5=0;
        }
        if (startTime > endTime) {
            raket.raket.setWidth(100);
            if (color==1)time.setTextFill(Color.BLACK);
            else time.setTextFill(Color.WHITE);
            label.setVisible(false);
            raketLength = 100;
            scoreAdd=1;
            if (sw5==0) speed*=2;
            sw5++;
        }
    }
}

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.Random;

public class Bricks {
    Pane pane = new Pane();
    Rectangle[] rectangle = new Rectangle[24];
    Label[] label = new Label[24];
    int[] number = new int[24];
    int[] prize = new int[5];
    //make the bricks
    public void Rectangle() {
        int j = 0;
        Random random = new Random();
        HBox root = new HBox();
        VBox root1 = new VBox();
        VBox root2 = new VBox();
        VBox root3 = new VBox();
        VBox root4 = new VBox();
        VBox root5 = new VBox();
        VBox root6 = new VBox();
        VBox root7 = new VBox();
        VBox root8 = new VBox();
        int[] max = new int[8];
        for (int n = 0; n < 8; n++) max[n] = 75;
        for (j = 0; j < 24; j++) {
            rectangle[j] = new Rectangle(60, 30);
            rectangle[j].setStroke(Color.WHITE);
            rectangle[j].setFill(Color.BLUE);
        }
        prize[0]=random.nextInt(8)+16;
        prize[1]=random.nextInt(24);
        prize[2]=random.nextInt(8);
        prize[3]=random.nextInt(24);
        prize[4]=random.nextInt(8)+8;
        rectangle[prize[0]].setFill(Color.GOLD);
        rectangle[prize[2]].setFill(Color.SILVER);
        rectangle[prize[1]].setFill(Color.GOLD);
        rectangle[prize[3]].setFill(Color.SILVER);
        rectangle[prize[4]].setFill(Color.PURPLE);
        root1.getChildren().addAll(rectangle[0], rectangle[8], rectangle[16]);
        root2.getChildren().addAll(rectangle[1], rectangle[9], rectangle[17]);
        root3.getChildren().addAll(rectangle[2], rectangle[10], rectangle[18]);
        root4.getChildren().addAll(rectangle[3], rectangle[11], rectangle[19]);
        root5.getChildren().addAll(rectangle[4], rectangle[12], rectangle[20]);
        root6.getChildren().addAll(rectangle[5], rectangle[13], rectangle[21]);
        root7.getChildren().addAll(rectangle[6], rectangle[14], rectangle[22]);
        root8.getChildren().addAll(rectangle[7], rectangle[15], rectangle[23]);
        root.getChildren().addAll(root1, root2, root3, root4, root5, root6, root7, root8);
        pane.getChildren().addAll(root);
    }
    // make the labels
    public void label() {
        Random random = new Random();
        for (int i = 0; i < 24; i++) {
            //random number between 1 to 9
            number[i] = (random.nextInt(9) + 1);
            label[i] = new Label("" + number[i]);
            label[i].setTextFill(Color.WHITE);
            label[i].setFont(Font.font(null, FontWeight.BOLD, 13));
            if (i < 8) label[i].setLayoutX((i * 60) + 30);
            if (i > 15) label[i].setLayoutX(((i - 16) * 60) + 30);
            if (i < 16 && i >= 8) label[i].setLayoutX(((i - 8) * 60) + 30);
            label[i].setLayoutY(((i / 8) * 30) + 10);
        }
        pane.getChildren().addAll(label);
    }
}


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.concurrent.CountDownLatch;

import static javafx.application.Application.launch;

public class Timer{
    void CountDown() {
        // get values from text field
        int seconds = 20;//Integer.parseInt(tfTimer.getText());
        // start count down
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis() + (20 * 1000);
        long temp = startTime + 1000;

        System.out.print(seconds + "\n");

        while (startTime < endTime) {
                if (startTime == temp) {
                    seconds--;
                    System.out.print(seconds + "\n");
                    temp += 1000;
                }
            startTime = System.currentTimeMillis();
        }
    }
}

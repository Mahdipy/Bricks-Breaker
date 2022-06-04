import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.net.URL;

public class Music {
     URL resource = getClass().getResource("music/a.mp3");
     Media media = new Media(resource.toString());
     MediaPlayer mediaPlayer = new MediaPlayer(media);
    public void start() {
        resource = getClass().getResource("music/a.mp3");
        media = new Media(resource.toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setStartTime(Duration.seconds(5.5));
        mediaPlayer.play();
    }

    public void hit() {
         resource = getClass().getResource("music/b.mp3");
         media = new Media(resource.toString());
         mediaPlayer = new MediaPlayer(media);
         mediaPlayer.play();
    }

    public void hard() {
        resource = getClass().getResource("music/c.mp3");
        media = new Media(resource.toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(2);
        mediaPlayer.play();
    }

    public void stop(){
        mediaPlayer.stop();
    }
}

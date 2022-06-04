public class Bouns {
    Ball ball = new Ball();
    public  void twice(){
        int seconds = 5;
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis() + (5 * 1000);
        long temp = startTime + 1000;
        while (startTime < endTime) {
            ball.raket.raket.setWidth(200);
            startTime = System.currentTimeMillis();
        } //ball.raket.raket.setWidth(100);
        ball.raket.raket.setWidth(200);
    }
}

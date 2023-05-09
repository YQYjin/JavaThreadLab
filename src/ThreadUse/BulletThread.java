import java.awt.*;

public class BulletThread implements Runnable,BallInfo{
    public long delay=550;
    Player player;
    Graphics gr;

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Bullet bullet = new Bullet(player.x+player.size/2-5, player.y-5);
            arr.add(bullet);
        }
    }
}

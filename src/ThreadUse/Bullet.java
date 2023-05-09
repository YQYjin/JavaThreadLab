import java.awt.*;

public class Bullet extends Move{
    //初始化子弹
    public Bullet(int x, int y){
        super(x, y,0,-8);
        color=Color.blue;
        size=10;
    }
    public void drawMove(Graphics gr){
        gr.setColor(Color.WHITE);
        gr.fillOval(x,y,size,size);
        x+=speedX;
        y+=speedY;
        gr.setColor(color);
        gr.fillOval(x,y,size,size);
        if(y< -10||y>810){
            arr.remove(this);
            return;
        }
    }
}

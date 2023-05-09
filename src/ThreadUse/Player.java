import java.awt.*;

public class Player extends Move{
    public Player(int x,int y){
        this.x =x;
        this.y =y;
        speedX=speedY=0;
        color=Color.RED;
        size=50;
    }
    public void drawMove(Graphics gr){
        gr.setColor(Color.WHITE);
        gr.fillOval(x,y,size,size);
        x+=speedX;
        y+=speedY;
        gr.setColor(color);
        gr.fillOval(x,y,size,size);
        if(y< -10){
            arr.remove(this);
            return;
        }
        //到达边界时停止移动
        if(x>850||x<0){
            speedX=0;
        }
        if(y>800||y<0){
            speedY=0;
        }
    }

}

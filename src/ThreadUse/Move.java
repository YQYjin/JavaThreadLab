import java.awt.*;
import java.awt.image.BufferedImage;

public class Move implements BallInfo{
    int speedX,speedY,x,y,size=5;
    Color color=Color.BLACK;
    public Move(){}
    public  void setSize(int size) {
        this.size=size;
    }
    public Move(int x,int y,int speedX,int speedY){
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }
    public Move(int speedX,int speedY){
        x=(int)(Math.random()*900);
        y=0;
        this.speedX = speedX;
        this.speedY = speedY;
        size=(int)(Math.random()*25+25);
    }
    public void drawMove(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x,y,size,size);
        x+=speedX;
        y+=speedY;
        g.setColor(color);
        g.fillOval(x,y,size,size);
        if(x>850||x<0){
            speedX=-speedX;
        }
        if(y>800||y<0){
            speedY=-speedY;
        }
    }

}

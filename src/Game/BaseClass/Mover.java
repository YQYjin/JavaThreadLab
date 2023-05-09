package Game;

public class Mover {
    private int x,y; //物体坐标
    private int xSpeed,ySpeed;   //物体速度

    public void setLocation(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void setSpeed(int xSpeed,int ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

}

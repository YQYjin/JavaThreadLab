import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameThread implements Runnable,BallInfo {
    JPanel gamePanel;
    boolean flag=false;
    //实现线程
    //重新run方法:启动线程后自动执行
    @Override
    public void run() {
        //创建缓存区
        BufferedImage image= new BufferedImage(gamePanel.getWidth(), gamePanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
        Graphics buffG=image.getGraphics();
        int x,y;
        x=(int)(Math.random()*900);
        y=0;
        while(true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(flag){
                continue;
            }
            //白色背景
            buffG.setColor(Color.WHITE);
            buffG.fillRect(x,y, image.getWidth(), image.getHeight());

            //遍历arr数组
            for(int i=0;i<arr.size();i++) {
                arr.get(i).drawMove(buffG);
            }
            gamePanel.getGraphics().drawImage(image,0,0,null);
        }
    }
    public void add(Move ball) {
        arr.add(ball);
    }
}


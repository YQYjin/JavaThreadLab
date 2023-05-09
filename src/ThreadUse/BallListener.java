import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class BallListener implements ActionListener, KeyListener,BallInfo {
    //引用传递画笔
    Graphics graphics;
    boolean flag=false;
    boolean isStarted=false,isCreatedPlayer=false;
    GameThread gameThread = new GameThread();
    JPanel gamePanel;
    Player player;
    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //持续获取焦点
        gamePanel.requestFocus();
        //创建线程对象
        JButton btn = (JButton)e.getSource();
        String action=btn.getActionCommand();
        if(action.equals("start")){
            isStarted=true;
//            gameImage=new BufferedImage(gamePanel.getWidth(), gamePanel.getHeight(),BufferedImage.TYPE_INT_RGB);
//            gameThread.graphics=gameImage.getGraphics();
//            gameThread.image=gameImage;
            gameThread.gamePanel=gamePanel;
            Thread thread=new Thread(gameThread);
            thread.start();
        }else if(action.equals("stop")){
            btn.setText("恢复");
            btn.setActionCommand("recover");
            gameThread.flag=true;

        }else if(action.equals("recover")){
            btn.setText("暂停");
            btn.setActionCommand("stop");
            gameThread.flag=false;
        }
        else if(action.equals("add")&&isStarted){
            int spdx=(int)(Math.random()*3+3);
            int spdy=(int)(Math.random()*3+3);
            Move ball=new Move(spdx,spdy);
            gameThread.add(ball);
        }
    }
    @Override
    //键入
    public void keyTyped(KeyEvent e) {
    }
    @Override
    //按下
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();
        switch(key) {
            case KeyEvent.VK_LEFT:
                if(isCreatedPlayer){
                    //System.out.println("按下左方向");
                    player.speedX=-10;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(isCreatedPlayer){
                    player.speedX=10;
                }
                break;
            case KeyEvent.VK_SPACE:
                if(!isCreatedPlayer){
                    player=new Player(400,750);
                    arr.add(player);
                    isCreatedPlayer=true;
                    BulletThread tt=new BulletThread();
                    tt.player=player;
                    tt.gr=graphics;
                    Thread bullets=new Thread(tt);
                    bullets.start();
                }
                break;

        }
    }
    @Override
    //松开
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            if (isCreatedPlayer) {
                player.speedX = 0;
            }
        }
    }
}

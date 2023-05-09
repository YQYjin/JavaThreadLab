package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    BufferedImage img;
    public void drawImg(){
        img=new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_INT_ARGB);


    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(img,0,0,null);

        repaint();
    }
}

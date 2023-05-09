package Game;

import javax.swing.*;
import java.awt.*;

public class MainUI extends JFrame {
    MainUI(){
        //创建主窗体
        JFrame frame=new JFrame();
        frame.setTitle("Game");
        frame.setLayout(new BorderLayout());
        frame.setSize(800,1100);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //按钮面板
        JPanel btnPanel=new JPanel();
        btnPanel.setBackground(Color.BLACK);
        btnPanel.setPreferredSize(new Dimension(frame.getWidth(),40));

        //创建按钮
        String[] btnNames={"开始","暂停","结束"};
        BtnListener btnListener=new BtnListener();
        for(String name:btnNames){
            JButton btn=new JButton(name);
            btn.setPreferredSize(new Dimension(80,25));
            //设置监听器
            btn.addActionListener(btnListener);
            btnPanel.add(btn);
        }

        //创建游戏画布界面
        GamePanel gamePanel=new GamePanel();
        gamePanel.setPreferredSize(new Dimension(frame.getWidth(),
                frame.getHeight()-btnPanel.getHeight()));
        gamePanel.setBackground(Color.GRAY);


        //向窗体中添加组件
        frame.add(btnPanel,BorderLayout.NORTH);
        frame.add(gamePanel,BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

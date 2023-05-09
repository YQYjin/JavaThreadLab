import javax.swing.*;
import java.awt.*;
public class UI extends JFrame {

    public void showUI(){
        //窗体
        JFrame frame = new JFrame();
        frame.setTitle("线程游戏");
        frame.setSize(900,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.WHITE);
        frame.setLayout(new FlowLayout());
        //居中显示
        frame.setLocationRelativeTo(null);
        //按钮
        JButton startButton = new JButton("开始游戏");
        startButton.setPreferredSize(new Dimension(100,30));
        startButton.setActionCommand("start");
        JButton stopButton = new JButton("暂停");
        stopButton.setPreferredSize(new Dimension(100,30));
        stopButton.setActionCommand("stop");
        JButton addButton = new JButton("添加");
        addButton.setPreferredSize(new Dimension(100,30));
        addButton.setActionCommand("add");

        //游戏界面
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(null);
        gamePanel.setPreferredSize(new Dimension(frame.getWidth(),frame.getHeight()-50));
        gamePanel.setBackground(Color.WHITE);
        //按钮监听器
        BallListener ballListener = new BallListener();
        ballListener.gamePanel = gamePanel;

        startButton.addActionListener(ballListener);
        stopButton.addActionListener(ballListener);
        addButton.addActionListener(ballListener);
        //给窗体添加键盘监听器
        gamePanel.addKeyListener(ballListener);
        gamePanel.requestFocus();//获取焦点

        frame.add(startButton);
        frame.add(stopButton);
        frame.add(addButton);
        frame.add(gamePanel);
        frame.setVisible(true);
        //画笔对象,在程序界面显示自定义类型
        //自定义内容显示在哪个界面就获取哪个界面的画笔对象
        //把画笔对象传递给监听器
        ballListener.setGraphics(gamePanel.getGraphics());
    }

    public static void main(String[] args){
        UI ui = new UI();
        ui.showUI();
    }
}

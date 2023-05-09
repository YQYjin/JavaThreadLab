package Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn=(JButton)e.getSource();
        String action=btn.getText();
        switch (action) {
            case "开始":

                break;
            case "暂停":

                break;
            case "结束":

                break;
        }
    }
}

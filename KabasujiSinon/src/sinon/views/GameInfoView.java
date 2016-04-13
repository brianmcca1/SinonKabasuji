package sinon.views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class GameInfoView extends InfoPanel {
    public GameInfoView() {
        this.setPreferredSize(new Dimension(180, 800));
        this.setMinimumSize(new Dimension(150, 800));
        this.setBorder(new LineBorder(new Color(0, 0, 0)));
        this.setLayout(null);

        JButton btnRestart = new JButton("Restart\r\n");
        btnRestart.setBounds(45, 20, 100, 50);
        this.add(btnRestart);

        JButton btnExit = new JButton("Exit\r\n");
        btnExit.setBounds(45, 100, 100, 50);
        this.add(btnExit);

        JButton button_2 = new JButton("Next Level\r\n");
        button_2.setBounds(45, 180, 100, 50);
        this.add(button_2);
    }
}

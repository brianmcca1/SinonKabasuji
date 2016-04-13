package sinon.views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

public class BankView extends InfoPanel {

    public BankView() {
        this.setPreferredSize(new Dimension(180, 800));
        this.setMinimumSize(new Dimension(150, 800));
        this.setBorder(new LineBorder(new Color(0, 0, 0)));

        this.setLayout(null);

        // This is specific to the builder /BankView
        JScrollBar scrollBar_1 = new JScrollBar();
        scrollBar_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        scrollBar_1.setBounds(0, 0, 17, 540);
        this.add(scrollBar_1);

        JLabel tempLabel = new JLabel("BANKVIEW GOES HERE");
        tempLabel.setBounds(23, 11, 150, 149);
        this.add(tempLabel);
    }

}

package sinon.views;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

public class BankView extends InfoPanel {
    private static final long serialVersionUID = 7842781710562282474L;

    public BankView() {
        super();

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

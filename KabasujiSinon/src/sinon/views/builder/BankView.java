package sinon.views.builder;

import javax.swing.JLabel;

import sinon.views.InfoPanel;

@SuppressWarnings("serial")
public class BankView extends InfoPanel {

    public BankView() {
        super();

        JLabel tempLabel = new JLabel("BANKVIEW GOES HERE");
        tempLabel.setBounds(0, 0, 100, 50);
        this.add(tempLabel);
    }

}

package sinon.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class NewLevelWizard extends JDialog {

    private final JPanel contentPanel = new JPanel();

    /**
     * Create the dialog.
     */
    public NewLevelWizard() {
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        {
            JRadioButton rdbtnNewRadioButton = new JRadioButton("Puzzle");
            rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
            contentPanel.add(rdbtnNewRadioButton, BorderLayout.WEST);
        }
        {
            JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Lightning");
            rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
            contentPanel.add(rdbtnNewRadioButton_1, BorderLayout.CENTER);
        }
        {
            JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Release");
            rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
            contentPanel.add(rdbtnNewRadioButton_2, BorderLayout.EAST);
        }
        {
            JLabel lblSelectLevelType = new JLabel("Select Level Type");
            lblSelectLevelType.setHorizontalAlignment(SwingConstants.CENTER);
            contentPanel.add(lblSelectLevelType, BorderLayout.NORTH);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

}

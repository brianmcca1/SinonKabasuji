package sinon.views;

import javax.swing.JButton;

public class LevelStartView extends JButton{
	String text = "Start";
	
	LevelStartView(){
		initialize();
	}
	
	void initialize(){
		JButton start = new JButton(text);
		start.setVisible(true);
		//start.addActionListener(new ActionListener(){
			//public void actionPerformed(ActionEvent e){
				
		//	}
		//});
	}
	
	

}

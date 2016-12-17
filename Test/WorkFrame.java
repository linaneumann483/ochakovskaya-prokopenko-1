import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class WorkFrame extends JFrame{
	private static final long serialVersionUID = -5190477996505555780L;
	 public static final int MY_WIDTH = 600;
	 public static final int MY_HEIGHT = 400;
	 
	public WorkFrame(){
	 setTitle("ButtonTest");
	 setSize(MY_WIDTH, MY_HEIGHT);
	 setResizable(false);
	 WorkPanel panel;
	try {
		panel = new WorkPanel();
		 add (panel);
		 panel.setLayout(null);
	} catch (ClassNotFoundException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}

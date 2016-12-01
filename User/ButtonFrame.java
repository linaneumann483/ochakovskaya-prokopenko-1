import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
class ButtonFrame extends JFrame implements Serializable{
	private static final long serialVersionUID = 107554717113806479L;
	 public ButtonFrame(){
		 setTitle("Authorization");
		 setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		 ButtonPanel panel = new ButtonPanel();
		 add(panel);
		 panel.setLayout(null);
	 }
	 public static final int DEFAULT_WIDTH = 500;
	 public static final int DEFAULT_HEIGHT = 400;
	 
	}

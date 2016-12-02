import javax.swing.JFrame;

public class WorkFrame extends JFrame{
	 public static final int MY_WIDTH = 600;
	 public static final int MY_HEIGHT = 600;
	 
	public WorkFrame(){
	 setTitle("ButtonTest");
	 setSize(MY_WIDTH, MY_HEIGHT);
	 WorkPanel panel = new WorkPanel();
	 add (panel);
	}
}

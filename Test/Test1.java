import java.util.Scanner;
import javax.swing.*;

public class Test1 {
public static Voc[] v;

  public static void main(String[] args){
		  v = new Voc[3];
		  v[0] = new Voc();
		  v[0].setWord("dog");
		  v[0].setTranslation("������");
		  v[1] = new Voc();
		  v[1].setWord("cat");
		  v[1].setTranslation("�����");
		  v[2] = new Voc();
		  v[2].setWord("fish");
		  v[2].setTranslation("�����");
	  
	  WorkFrame frame = new WorkFrame();
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setVisible(true);
	}
  }






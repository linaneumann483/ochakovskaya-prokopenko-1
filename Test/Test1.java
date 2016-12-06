import java.util.Scanner;
import javax.swing.*;

public class Test1 {
public static Voc[] v;

  public static void main(String[] args){
	  	  
		  v = new Voc[5];
		  v[0] = new Voc();
		  v[0].setWord("dog");
		  String[] a = new String[1];
		  a[0] = "собака";
		  v[0].setTrans(a);
		  
		  v[1] = new Voc();
		  v[1].setWord("cat");
		  String[] b = new String[1];
		  b[0] = "котик";
		  v[1].setTrans(b);
		  
		  v[2] = new Voc();
		  v[2].setWord("fish");
		  String[] c = new String[1];
		  c[0] = "рыбка";
		  v[2].setTrans(c);
		  
		  v[3] = new Voc();
		  v[3].setWord("parrot");
		  String[] d = new String[1];
		  d[0] = "попугай";
		  v[3].setTrans(d);
		  
		  v[4] = new Voc();
		  v[4].setWord("rabbit");
		  String[] e = new String[1];
		  e[0] = "кролик";
		  v[4].setTrans(e);
	  
	  WorkFrame frame = new WorkFrame();
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setVisible(true);
	}
  }






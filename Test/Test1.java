import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class Test1 {
public static Voc[] v;
public static InputVoc t;
public static int num;
public static int numWords;
public static File x = new File("VocabluaryUnKnown.bin");
public static File y = new File("VocabluaryLearning.bin");

  public static void main(String[] args) throws ClassNotFoundException, IOException{
	  t = new InputVoc();
	  t.Create();

	  v = t.readFromVoc(x);
	  if (v==null) System.out.println("File is empty:((");
	  else{
	  System.out.println("File 1:");
		for(int i = 0; i < v.length; i++){
			System.out.print(v[i].getWord()+" ");
			for(int j = 0; j<v[i].getTrans().length; j++){
				System.out.print(v[i].getTransl(j)+" ");
			}
			System.out.println("");
		}
	  num=3;
	  WorkFrame frame = new WorkFrame();
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setVisible(true);
	}}
  }






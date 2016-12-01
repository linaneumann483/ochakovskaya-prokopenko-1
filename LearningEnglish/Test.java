import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
public class Test implements Serializable{
	private static final long serialVersionUID = -5190477996505555780L;
	private static InputVocabluary t;
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		Scanner in = new Scanner(System.in);
		File x = new File("Vocabluary.bin");
		File y = new File("Vocabluary1.bin");
		t = new InputVocabluary();
		t.Create();
		String word = "rrrr";
		t.perekidka(word, x, y);
		Vocabluary[] a = t.readFromVoc(x);
		Vocabluary[] b = t.readFromVoc(y);
		System.out.println("File 1:");
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i].getWord()+" ");
			for(int j = 0; j<a[i].getTrans().length; j++){
				System.out.print(a[i].getTransl(j)+" ");
			}
			System.out.println("");
		}
		
		System.out.println("File 2:");
		for(int i = 0; i < b.length; i++){
			System.out.print(b[i].getWord()+" ");
			for(int j = 0; j<b[i].getTrans().length; j++){
				System.out.print(b[i].getTransl(j)+" ");
			}
			System.out.println("");
		}
		in.close();
	}
}

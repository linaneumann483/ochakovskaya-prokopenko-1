import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
class InputVocabluary implements Serializable{
	private static final long serialVersionUID = -5190477996505555780L;
    private static String[] trans;
    private static String x;
	public void Create() {
		Scanner sc = new Scanner(System.in);
		Vocabluary[] voc = new Vocabluary[2];
		for (int i = 0; i < voc.length; i++) {
			System.out.println("Enter word:");
			x = sc.next();
			voc[i] = new Vocabluary();
			voc[i].setWord(x);
			System.out.println("Enter num of translations");
			int num = sc.nextInt();
			trans = new String[num];
		    System.out.println("Enter "+num+" translations");
			for (int j=0;j<num;j++){
			trans[j] = sc.next();
			}
			voc[i].setTrans(trans);
		}
		File x = new File("Vocabluary.bin");
				addToVoc(voc, x);
		sc.close();
	}
	
	public void addToVoc(Vocabluary[] voc, File x){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(x));
			oos.writeObject(voc);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public Vocabluary[] readFromVoc(File x) throws IOException, ClassNotFoundException{
		Vocabluary[] c;
		    if(x.length()!=0){
		    InputStream t = new BufferedInputStream(new FileInputStream(x));
		 	ObjectInputStream input = new ObjectInputStream(t);
		    c = (Vocabluary[]) input.readObject();
		 	input.close();
	
		return c;
		    }else{
		    	return null;
		    }
	}
	public void perekidka(String sl, File x, File y) throws ClassNotFoundException, IOException{
	Vocabluary[] v = readFromVoc(x);
	for (int i = 0; i< v.length; i++){
	if(v[i].getWord().equals(sl)){
	    if(y.length()!=0){
	    	Vocabluary[] d = readFromVoc(y);
	    	Vocabluary[] e = new Vocabluary[d.length+1];
	    	System.arraycopy(d, 0, e, 0, d.length);
	    	e[e.length-1] = v[i];
	    	addToVoc(e, y);
	    } else{
	    	Vocabluary[] e = new Vocabluary[1];
	    	e[e.length-1] = v[i];
	    	addToVoc(e, y);
	    }
	     for(int k = i+1; k < v.length; k++){	 
	    v[k-1] = v[k];	 
	     }
	     Vocabluary[] t = new Vocabluary[v.length-1];
	     System.arraycopy(v, 0, t, 0, t.length);
	     addToVoc(t, x);
	}
	}
	
     }
}
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

class InputVoc implements Serializable{
	private static final long serialVersionUID = -5190477996505555780L;
    
	public void Create() {
		Voc[] v = new Voc[6];
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
		  
		  v[5] = new Voc();
		  v[5].setWord("humster");
		  String[] f = new String[1];
		  f[0] = "хом€чок";
		  v[5].setTrans(f);
		  addToVoc(v, Test1.x);
		  
	}
	
	public void addToVoc(Voc[] voc, File x){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(x));
			oos.writeObject(voc);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public Voc[] readFromVoc(File x) throws IOException, ClassNotFoundException{
		Voc[] c;
		    if(x.length()!=0){
		    InputStream t = new BufferedInputStream(new FileInputStream(x));
		 	ObjectInputStream input = new ObjectInputStream(t);
		    c = (Voc[]) input.readObject();
		 	input.close();
	
		return c;
		    }else{
		    	return null;
		    }
	}
	public void perekidka(String sl, File x, File y) throws ClassNotFoundException, IOException{
	Voc[] v = readFromVoc(x);
	for (int i = 0; i< v.length; i++){
	if(v[i].getWord().equals(sl)){
	    if(y.length()!=0){
	    	Voc[] d = readFromVoc(y);
	    	Voc[] e = new Voc[d.length+1];
	    	System.arraycopy(d, 0, e, 0, d.length);
	    	e[e.length-1] = v[i];
	    	addToVoc(e, y);
	    } else{
	    	Voc[] e = new Voc[1];
	    	e[e.length-1] = v[i];
	    	addToVoc(e, y);
	    }
	     for(int k = i+1; k < v.length; k++){	 
	    v[k-1] = v[k];	 
	     }
	     Voc[] t = new Voc[v.length-1];
	     System.arraycopy(v, 0, t, 0, t.length);
	     addToVoc(t, x);
	}
	}
	
     }
}
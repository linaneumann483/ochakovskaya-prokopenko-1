import java.util.*;
import java.io.*;

class InputVocabluary implements Serializable {
	private static final long serialVersionUID = 107554717113806479L;
	private static ArrayList<String> trans;
	private static String x;

	public ArrayList<Vocabluary> Create(File y) throws IOException, ClassNotFoundException{
	BufferedReader r = null;
	String a,b = "";
	int k = 0;
	
	ArrayList<Vocabluary> v = new ArrayList<Vocabluary>();
	ArrayList<String> tr = new ArrayList<String>();
		r = new BufferedReader(new FileReader(y));
		a = r.readLine();
		while(a!= null){
			tr = new ArrayList<String>();
		for(int i = 0; i < a.length(); i++){
			if (a.charAt(i) == ' '){
			  for(int j = 0; j < i; j++){
			   b = b+a.charAt(j);
			  }
			  
			Vocabluary vv = new Vocabluary();
			vv.setWord(b);
		    v.add(vv);

			  b = "";
				k = i;
			}
		
			if(a.charAt(i) == ','){
			 for(int j = k+1; j < i; j++){
				 b = b+a.charAt(j); 
			 }
			  tr.add(b); 	 
             b = "";
             k = i;
			}
			if(i == a.length()-1){
				for(int j = k+1; j < i+1; j++){
					 b = b+a.charAt(j); 
				 }
				  tr.add(b);
				  v.get(v.size()-1).setTrans(tr);
				tr = null;
				b = "";
				k = 0;
			}
		}
		a = r.readLine();
		}
		
		r.close();
		return v;	
	}

	public void addToVoc(List<Vocabluary> e2, File x)  {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(x));
			oos.writeObject(e2);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Vocabluary> readFromVoc(File x) throws IOException, ClassNotFoundException {
		ArrayList<Vocabluary> c;
		if (x.length() != 0) {
			InputStream t = new BufferedInputStream(new FileInputStream(x));
			ObjectInputStream input = new ObjectInputStream(t);
			c = (ArrayList<Vocabluary>) input.readObject();
			input.close();

			return c;
		} else {
			return null;
		}
	}

	public void perekidka(String sl, File x, File y) throws ClassNotFoundException, IOException {
		ArrayList<Vocabluary> v = readFromVoc(x);
		for (int i = 0; i < v.size(); i++) {
			if (v.get(i).getWord().equals(sl)) {
				ArrayList<Vocabluary> d = readFromVoc(y);
				ArrayList<Vocabluary> e = new ArrayList<Vocabluary>();
				System.arraycopy(d, 0, e, 0, d.size());
				addToVoc(e, y);
			}

		}
	}
	

}

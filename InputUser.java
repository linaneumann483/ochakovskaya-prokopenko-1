import java.io.*;
import java.util.*;
public class InputUser implements Serializable{
	
	private static final long serialVersionUID = 107554717113806479L;

	public void addToVoc(List<User> voc, File x){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(x));
			oos.writeObject(voc);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<User> readFromVoc(File x) throws IOException, ClassNotFoundException{
		ArrayList<User> c;
		    if(x.length()!=0){
		    InputStream t = new BufferedInputStream(new FileInputStream(x));
		 	ObjectInputStream input = new ObjectInputStream(t);
		    c= (ArrayList<User>) input.readObject();
		 	input.close();
	      
		return c;
		    }else{
		    	return null;
		    }
	}

}

import java.util.*;
import java.io.*;

class InputVocabluary implements Serializable {
	private static final long serialVersionUID = 107554717113806479L;
	private static String[] trans;
	private static String x;

	public void Create() throws StreamCorruptedException {
		Scanner sc = new Scanner(System.in);
		List<Vocabluary> voc = new ArrayList<Vocabluary>();
		for (int i = 0; i < voc.size(); i++) {
			System.out.println("Enter word:");
			x = sc.next();
			voc.get(voc.size()-1).setWord(x);
			System.out.println("Enter num of translations");
			int num = sc.nextInt();
			trans = new String[num];
			System.out.println("Enter " + num + " translations");
			for (int j = 0; j < num; j++) {
				trans[j] = sc.next();
			}
			voc.get(voc.size()-1).setTrans(trans);
		}
		File x = new File("Vocabluary.bin");
		addToVoc(voc, x);
		sc.close();
	}

	public void addToVoc(List<Vocabluary> e2, File x) throws StreamCorruptedException {
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
	public ArrayList<Vocabluary> readFromVoc(File x) throws IOException, ClassNotFoundException, StreamCorruptedException {
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
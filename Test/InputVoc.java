import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

//LEARNING ENGLISH

class InputVoc implements Serializable {
	private static final long serialVersionUID = -5190477996505555780L;

	public ArrayList<Voc> Create(File y) throws IOException, ClassNotFoundException {
		BufferedReader r = null;
		String a, b = "";
		int k = 0;
		ArrayList<Voc> v = new ArrayList<Voc>();
		ArrayList<String> tr = new ArrayList<String>();
		r = new BufferedReader(new FileReader(y));
		a = r.readLine();
		while (a != null) {
			tr = new ArrayList<String>();
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) == ' ') {
					for (int j = 0; j < i; j++) {
						b = b + a.charAt(j);
					}

					Voc vv = new Voc();
					vv.setWord(b);
					v.add(vv);

					b = "";
					k = i;
				}

				if (a.charAt(i) == ',') {
					for (int j = k + 1; j < i; j++) {
						b = b + a.charAt(j);
					}
					tr.add(b);
					b = "";
					k = i;
				}
				if (i == a.length() - 1) {
					for (int j = k + 1; j < i + 1; j++) {
						b = b + a.charAt(j);
					}
					tr.add(b);
					v.get(v.size() - 1).setTrans(tr);
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

	public void addToVoc(List<Voc> e2, File x) {
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
	public ArrayList<Voc> readFromVoc(File x) throws IOException, ClassNotFoundException {
		ArrayList<Voc> c;
		if (x.length() != 0) {
			InputStream t = new BufferedInputStream(new FileInputStream(x));
			ObjectInputStream input = new ObjectInputStream(t);
			c = (ArrayList<Voc>) input.readObject();
			input.close();

			return c;
		} else {
			return null;
		}
	}

	public void perekidka(String sl, File x, File y) throws ClassNotFoundException, IOException {
		ArrayList<Voc> v = readFromVoc(x);
		for (int i = 0; i < v.size(); i++) {
			if (v.get(i).getWord().equals(sl)) {
				ArrayList<Voc> d = readFromVoc(y);
				ArrayList<Voc> e = new ArrayList<Voc>();
				System.arraycopy(d, 0, e, 0, d.size());
				addToVoc(e, y);
			}

		}
	}
}
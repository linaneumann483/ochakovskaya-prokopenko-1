import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

//LEARNING ENGLISH

class Voc implements Serializable {
	private static final long serialVersionUID = -5190477996505555780L;
	private String word;
	private ArrayList<String> translations;
	private int correct;
	
	public Voc(){
		translations = new ArrayList<String>();
		correct = 0;
	}
	public String getWord(){
		return word;
	}
	
	public void setWord(String word){
		this.word = word;
	}
	
	/*public void AddToLearnt(){
		InputVoc in = new InputVoc();
		try {
			in.perekidka(word, WorkPanel.v, WorkPanel.v1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	public String getTransl(int i){
	return translations.get(i);
	}
	
	public ArrayList<String> getTrans(){
		return translations;
	}
	
	public String getRandTransl(){
		Rand r = new Rand(1,translations.size()-1);
		return getTransl(r.getNumbers()[0]);
	}
	
	public void setTrans(ArrayList<String> translations){
    	this.translations = translations;
}	
	
	public int getCorrect(){
		return correct;
	}
	
	public void setCorrect(int correct){
		this.correct = correct;
	}
	
	
}

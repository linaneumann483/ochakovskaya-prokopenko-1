import java.io.Serializable;
import java.util.ArrayList;

public class Vocabluary implements Serializable {
	private static final long serialVersionUID = 107554717113806479L;
	private String word;
	private ArrayList<String> translations;
	private int correct;
	public Vocabluary(){
		translations = new ArrayList<String>();
		correct = 0;
	}
	public String getWord(){
		return word;
	}
	
	public void setWord(String word){
		this.word = word;
	}
	
	public String getTransl(int i){
		return translations.get(i);
	}
	
	public ArrayList<String> getTrans(){
		return translations;
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

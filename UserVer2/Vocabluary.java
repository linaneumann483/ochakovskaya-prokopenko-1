import java.io.Serializable;

public class Vocabluary implements Serializable {
	private static final long serialVersionUID = 107554717113806479L;
	private String word;
	private String[] translations;
	private int correct;
	public Vocabluary(){
		translations = new String[0];
		correct = 0;
	}
	public String getWord(){
		return word;
	}
	
	public void setWord(String word){
		this.word = word;
	}
	
	public String getTransl(int i){
		return translations[i];
	}
	
	public String[] getTrans(){
		return translations;
	}
	
	public void setTrans(String [] translations){
	    	this.translations = translations;
	}
	
	public int getCorrect(){
		return correct;
	}
	
	public void setCorrect(int correct){
		this.correct = correct;
	}
	
}

import java.io.Serializable;

class Vocabluary implements Serializable {
	private static final long serialVersionUID = -5190477996505555780L;
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
	
}

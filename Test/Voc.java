import java.io.Serializable;

class Voc implements Serializable {
	private static final long serialVersionUID = -5190477996505555780L;
	private String word;
	private String[] translations;
	private int correct;
	
	public Voc(){
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
		return this.translations[i];
	}
	
	public String getRandTransl(){
		Rand r = new Rand(1,translations.length-1);
		return getTransl(r.getNumbers()[0]);
	}
	
	public String[] getTrans(){
		return translations;
	}
	
	public void setTrans(String [] translations){
	    	this.translations = translations;
	}	
	
	public int getcorrect(){
		return correct;
	}
	
	public void setCorrect(int i){
		this.correct = i;
	}
	
}

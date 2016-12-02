
class Voc {
	private String word, translation;
	private int correct;
	
	Voc(){
		correct = 0;
	}
	
	public String getWord(){
		return word;
	}
	
	public void setWord(String word){
		this.word = word;
	}
	
	public String getTranslation(){
		return translation;
	}
	
	public void setTranslation(String translation){
		this.translation = translation;
	}
	
	public int getcorrect(){
		return correct;
	}
	
	public void setCorrect(int correct){
		this.correct = correct;
	}

}

import java.lang.Math;

public class Rand {
	int[] mas;

	public Rand(int n, int d) {
		mas = new int[n];
		for (int i = 0; i < n; i++) {
			this.mas[i] = ((int)( Math.random() * d));
			boolean a = (CheckMas(mas[i],i));
			while (a){
				mas[i] =  ((int)( Math.random() * d)); 
				a = (CheckMas(mas[i],i));
			}
		}
	}
	
	public int[] getNumbers(){
		return mas;
	}
	
	public boolean CheckMas(int a,int n){
		boolean c = false;
		for (int i=0;i<n;i++){
			if (a==(mas[i])){
			c=true;	
			}
		}
		return c;
	}
}

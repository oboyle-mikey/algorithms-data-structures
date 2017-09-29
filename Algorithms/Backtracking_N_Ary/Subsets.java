package Backtracking_N_Ary;

public class Subsets {

	boolean[]s;
	int size;
	
	public Subsets(int size){
		this.size = size;
		this.s = new boolean[size];
		Gen_Subsets(0);
	}
	
	public void Gen_Subsets(int k){
		if(k==size){
			//print subset
		}else{
			s[k] = true;
			Gen_Subsets(k+1);
			s[k] = false;
			Gen_Subsets(k+1);
		}
	}
}

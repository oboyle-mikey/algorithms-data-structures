package Backtracking_N_Ary;

public class Permutations {

	int[]p;
	boolean[]used;
	
	public Permutations(int size){
		this.p = new int[size];
		this.used = new boolean[size];
		Gen_Permutations(0);
	}
	
	public void Gen_Permutations(int k){
		if(k==p.length){
			//print array
		}else{
			for(int j = 0; j<p.length; j++){
				if(!used[j]){
					p[k] = j;
					used[j] = true;
					Gen_Permutations(k+1);
					used[j] = false;
				}
			}
		}
	}
}

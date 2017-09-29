package Backtracking_N_Ary;

public class Combinations {

	int[]comb;
	int n, k;
	
	public Combinations(int n, int k){
		this.n = n;
		this.k = k;
		this.comb = new int[k];
		Gen_Combinations(0, 0);
	}
	
	public void Gen_Combinations(int i, int start){
		int j;
		if(i==k){
			//print combination
		}else{
			 j = start;
			 while(j<n){
				 comb[i] = j;
				 Gen_Combinations(i+1, j+1);
				 j++;
			 }
		}
	}
}

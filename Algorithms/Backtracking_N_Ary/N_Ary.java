package Backtracking_N_Ary;

public class N_Ary {

	int[]digits;
	int base;
	
	public N_Ary(int base, int size){
		this.base = base;
		this.digits = new int[size];
		generate(0);
	}
	
	public void generate(int k){
		if(k==digits.length){
			//print array
		}else{
			for(int j = 0; j<base; j++){
				digits[k] = j;
				generate(k+1);
			}
		}
	}
	
	
}

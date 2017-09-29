package Backtracking_Chess;

public class Gen_Queens {

	int[]q;
	boolean[]used_col;
	boolean[]up_diag;
	boolean[]down_diag;
	int counter = 0;
	
	public Gen_Queens(int n){
		q = new int[n];
		used_col = new boolean[n];
		up_diag = new boolean[2*n-1];
		down_diag = new boolean[2*n-1];
		Gen_Solutions(0);
	}
	
	public void Gen_Solutions(int i){
		if(i==q.length){
			//print solution
		}else{
			for(int j = 0; j<q.length; j++){
				if(Safe(i, j)){
					setQueens(i,j);
					Gen_Solutions(i+1);
					resetQueens(i,j);
				}
			}
		}
	}
	
	public boolean Safe(int i, int j){
		return(!(used_col[j] || up_diag[i+1] ||  down_diag[i-j+q.length-1]));
	}
	
	public void setQueens(int i, int j){
		q[i] = j;
		used_col[j] = true;
		up_diag[i+1] = true;
		down_diag[i-j+q.length-1] = true;
	}
	
	public void resetQueens(int i, int j){
		used_col[j] = false;
		up_diag[i+1] = false;
		down_diag[i-j+q.length-1] = false;
	}
}

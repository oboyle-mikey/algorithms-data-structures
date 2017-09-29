package Maths;

public class Saddle {

	public void all_saddle(Matrix M){
		double[] mins;
		double[] maxs;
		boolean found = false;
		Matrix mt;
		
		mins = M.minRow();
		mt = M.transpose();
		maxs = mt.maxRow();
		
		for(int i = 0; i<M.rows; i++){
			for(int j = 0; j<M.cols; j++){
				if(mins[i] == maxs[j]){
					found = true;
					System.out.print(M.item[i][j]);
				}
			}
		}
		
		
		
	}
}

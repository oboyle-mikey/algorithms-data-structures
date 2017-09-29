
public class QuickUnionUF {

	private int[]id;
	
	public QuickUnionUF(int N){
		id = new int[N];
		for(int i = 0; i<N; i++){
			id[i] = i;
		}
	}
	
	public int find(int i){
		while(i!=id[i]){
			id[i] = i;
		}
		return i;
	}
	
	public void union(int p, int q){
		int i = find(p);
		int j = find(q);
		id[i] = j;
	}
	
	public boolean connected(int p, int q){
		return(id[p]==id[q]);
	}
}

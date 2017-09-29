
public class WeightedCompressedUF {


	private int[]id;
	private int[]sz;

	public WeightedCompressedUF(int N){
		id = new int[N];
		for(int i = 0; i<N; i++){
			id[i] = i;
		}
	}

	public int find(int i){
		while(i!=id[i]){
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}

	public void union(int p, int q){
		int i = find(p);
		int j = find(q);
		if(i==j) return;
		if(sz[i]<sz[j]){
			id[i] = j;
		}else{
			id[j] = i;
		}
	}

	public boolean connected(int p, int q){
		return(id[p]==id[q]);
	}

}

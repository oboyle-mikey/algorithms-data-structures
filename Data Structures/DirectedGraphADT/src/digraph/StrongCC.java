package digraph;


public class StrongCC {
	private boolean marked[]; private int[] id;
	private int count;
	
	public StrongCC(DiGraph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOrder dfs = new DepthFirstOrder(G.reverse()); 
		for (int v : dfs.reversePostorder())
		{
			if (!marked[v]) {
				dfs(G, v);
				count++; }
		}
	
	}
	private void dfs(DiGraph G, int v) {
		marked[v] = true; id[v] = count;
		for (int w : G.adj(v)){
			if (!marked[w]) dfs(G, w);
		}
	}
}
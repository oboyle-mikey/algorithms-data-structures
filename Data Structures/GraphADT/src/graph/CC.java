package graph;

public class CC {

	private boolean[] marked;
	private int [] id;
	private int count;
	
	public CC(Graph g){
		marked = new boolean[g.V()];
		for(int v = 0; v<g.V(); v++){
			if(!marked[v]){
				dfs(g, v);
				count++;
			}
		}
	}
	
	public void dfs(Graph g, int v){
		marked[v] = true;
		id[v] = count;
		for(int w: g.adj(v)){
			if(!marked[w]){
				dfs(g, w);
			}
		}
	}
	
	public boolean connected(int v, int w){
		return(id[v] == id[w]);
	}
	
}

package graph;

import java.util.Stack;

public class DFS {

	private boolean[]marked;
	private int[]edgeTo;
	private int s;
	
	public DFS(Graph G, int S){
		dfs(G, S);
		this.s = S;
	}
	
	public void dfs(Graph g, int v){
		marked[v] = true;
		for(int w : g.adj(v)){
			if(!marked[w]){
				dfs(g, w);
				edgeTo[w] = v;
			}
		}
	}
	
	public boolean hasPath(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPath(v)){
			return null;
		}
		Stack<Integer>path = new Stack<Integer>();
		for(int x = v; x!=s; x = edgeTo[x]){
			path.push(x);
		}
		path.push(s);
		return path;
	}
}

package digraph;

import java.util.Stack;

public class TopologicalSort {

	private boolean[] marked;
	private Stack<Integer> reversePostorder;

	public TopologicalSort(DiGraph g){
		reversePostorder= new Stack<Integer>();
		marked = new boolean[g.V()];
		for(int v = 0; v<g.V(); v++){
			if(!marked[v]){
				dfs(g, v);
			}
		}
	}

	private void dfs(DiGraph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w]){
				dfs(G, w);
				reversePostorder.push(v);
			}
	}
	
	public Iterable<Integer> reversePostorder(){
		return reversePostorder;
	}
}

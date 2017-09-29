package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	private int s;
	private boolean[]marked;
	private int[]edgeTo;
	private int[]distTo;

	public BFS(Graph G, int S){
		this.s = S;
		bfs(G, S);
	}

	public void bfs(Graph g, int s){
		Queue<Integer> q = new LinkedList<Integer>();
		q.enqueue(s);
		marked[s] = true;
		distTo[s] = 0;
		
		while(!q.isEmpty()){
			int v;
			v= q.dequeue();
			for(int w:g.adj(v)){
				if(!marked[w]){
					
				}
			}
		}

	}
}

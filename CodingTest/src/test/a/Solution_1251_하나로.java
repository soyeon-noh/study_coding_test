package test.a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// MST
// 크루스칼 풀기 
public class Solution_1251_하나로 {

	static int V, E;
	static int[] parent;
	static int[] visited;
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge>{
		int x, y;
		long w;

		public Edge(int x, int y, long w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.w, o.w);
		}
	}
	
	static void make() {
		for(int i = 0; i < V; i++) parent[i] = i;
	}
	
	static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		
		parent[rootB] = rootA;
		
		return true;
	}
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			V = Integer.parseInt(br.readLine());
			E = Integer.parseInt(br.readLine());
			parent = new int[V];
			visited = new int[V];
			edgeList = new Edge[E]; // 초기화
			
			long[] x = new long[V];
			long[] y = new long[V];
			
			StringTokenizer stX = new StringTokenizer(br.readLine());
			StringTokenizer stY = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < V; i++) {
				Long.parseLong(stX.nextToken());
				Long.parseLong(stY.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());
			
			// 간선 리스트 만들어야해
			int inx = 0;
			edgeList = new Edge[V * (V - 1) / 2];
			for(int i = 0; i < V; i++) {
				for(int j = i+1; j < V; j++) {
					
					
				}
			}
		}
	}
}

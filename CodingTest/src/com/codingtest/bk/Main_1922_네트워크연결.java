package com.codingtest.bk;

import java.io.*;
import java.util.*;

// MST 크루스칼
public class Main_1922_네트워크연결 {
	
	static int V, E;
	static int[] parent;
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
		
	}
	
	static void make() {
		for(int i = 1; i < V + 1; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int a) {
		if(a == parent[a]) return a;
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
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		parent = new int[V+1];
		edgeList = new Edge[E];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edgeList);
		
		make();
		int ans = 0;
		int cnt = 0;
		
		for(Edge edge : edgeList) {
			if(!union(edge.from, edge.to)) continue;
			
			cnt++;
			ans += edge.weight;
			
			if(cnt == V -1) break;
		}
		
		System.out.println(ans);
		
	}

}

package com.codingtest.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1)summary
 * - N개의 섬들을 모두 연결하는 교통시스템 설계
 * - 가중치: 환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E * L^2)만큼 지불
 *           E * ( |x1-x2|^2 + |y1-y2|^2 ) - long
 * - 최소비용
 * 2)strategy
 * 2-1)Kruskal (O(ElogE))
 *   union-find
 * 2-2)prim (섬-정점중심) O(N^2) 
 *   - 입력처리
 *   - 모든 섬 간의 거리제곱(L^2) 구하기(가중치로 사용)
 *   - Prim 알고리즘이용 MST total(총 거리 제곱합)구하기
 *     인접행렬
 *   - total * E 소수 첫째자리 반올림해서 출력
 *  * 
 * 2-3)prim + java.util.PriorityQueue (정렬기준-Comparable(compareTo(o1)),Comparator(compare(o1,o2)
 *     (O(E logV)) 
 *   - 입력처리
 *   - 모든 섬 간의 거리제곱(L^2) 구하기(가중치로 사용)
 *   - Prim +PQ 알고리즘이용 MST total(총 거리제곱합)구하기
 *     - PriorityQueue -정렬기준
 *       Node implements Comparable - 가중치 오름차순
 *   - total * E 소수 첫째자리 반올림해서 출력
 * 
 * 3)note
 * -입력
 * 10			//testcase
 * 2			//섬 개수 N ( 1≤N≤1,000)
 * 0 0			//X좌표
 * 0 100		//Y좌표
 * 1.0			//환경 부담 세율 E(0≤E≤1)
 * 
 * -출력
 * #testcase 최단경로이동거리 (소수 첫째 자리에서 반올림하여 정수 형태로 출력)
 * 
 */
public class Solution_1251_Prim_PriorityQueue {
 
	static int N;			  //섬 개수
	static double E;		  //세율
	static int[] x, y;
	
	static class Node implements Comparable<Node>{
		int index; 	//도착 정점
		long cost;	//거리 제곱(간선 가중치)
		public Node(int index, long cost) {
			this.index = index;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			//가중치로 오름차순 정렬
			return Long.compare(this.cost, o.cost);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		int T = Integer.parseInt(in.readLine()); //테스트 케이스
		for(int testCase=1; testCase <=T; testCase++) {
			//1.입력
			N = Integer.parseInt(in.readLine()); //섬 수
			x = new int[N];
			y = new int[N];
			//x좌표 입력
			st = new StringTokenizer(in.readLine());
			for(int i=0; i < N; i++)
				x[i] = Integer.parseInt(st.nextToken());
			//y좌표 입력
			st = new StringTokenizer(in.readLine());
			for(int i=0; i < N; i++)
				y[i] = Integer.parseInt(st.nextToken());
			
			//환경부담 세율입력
			E = Double.parseDouble(in.readLine());
			
	
			//prim 실행
			long total = prim();
			
			//환경 부담 세율 곱하고 반올림;
			long answer = Math.round(total * E);
			
			//3.출력
			sb = new StringBuilder("#").append(testCase).append(" ").append(answer);
			System.out.println(sb.toString());

		}

	}

	/**
	 * prim PriorityQueue알고리즘 구현
	 * @return 최소비용 total: long
	 */
	private static long prim() {
		boolean [] visited = new boolean[N]; 	//방문여부
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0,0));				//시작 정점 0

		long total=0;
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			
			if(visited[current.index]) continue;
			visited[current.index] = true; //방문체크
			total += current.cost;		   //가중치 누적		

			
			//현재 정점에서 갈 수 있는 모든 정점과의 간선 계산
			for(int i=0; i < N ; i++) {
				if(!visited[i]) { //아직방문하지 않은 i에 대해
					long disX = Math.abs(x[current.index]-x[i]);
					long disY = Math.abs(y[current.index]-y[i]);
					pq.offer(new Node(i, disX*disX + disY*disY));
				}
			}
			
		}
		return total;
	}

}



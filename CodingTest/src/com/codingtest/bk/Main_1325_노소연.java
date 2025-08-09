package com.codingtest.bk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 영원히 런타임 에러가뜬다... 

// 효율적인 해킹
// 시간초과가 많이 나는 것 같다...
// 일단 나는 풀이법에만 집중해보자...
public class Main_1325_노소연 {

	static int N, M;
	static int[] cnt; //해킹 할 수 있는 컴퓨터의 수를 저장하는 배열 
	static List<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 1. 배열 초기화 
		cnt = new int[N+1];
		list = new ArrayList[N+1]; // 배열의 인덱스를 컴퓨터 번호와 일치시키기위한 N+1
		for(int i = 1; i <= N; i++) { // 그래서 N까지 돌
			list[i] = new ArrayList<>(); // 각 인덱스에 ArrayList 객체 할당
		}
		
		// 2. 그래프 간선 = 신뢰관계 로 보고 추가해준다
		for (int i = 0; i < M; i++) { // M개의 신뢰관계 input넣기 
			st = new StringTokenizer(br.readLine()); // 아니 이거 재정의만해주면 다시 쓸 수 있었던거임...
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()); // 각각 a,b를 받아옴
			list[b].add(a); // a가 b를 신뢰하므로. list[b]에 같이 해킹당하는 컴퓨터를 넣기...
			// B->A 역방향 간선을 추가했다고표현하는데 아직 잘 모르겠다
			
		}
		
		// 3. 모든 컴퓨터를 시작점으로 BFS 탐색
		// 컴퓨터를 해킹했을 때 해킹할 수 있는 컴퓨터 수를 구하기 위함.
		for(int i = 1; i < N+1; i++) {
			bfs(i);
		}
		
		
		// 4. 결과 출력
		// 해킹 최대값
		int maxCnt = 0;
		for(int i = 1; i <=N; i++) {
			if(cnt[i] > maxCnt) {
				maxCnt = cnt[i];
			}
		}
		//최대값을 가진 컴퓨터 번호 찾기
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <=N; i++) {
			if(cnt[i] == maxCnt) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb.toString());
		
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[N + 1];
		int count = 0; //BFS를 통해 해킹할 수 있는 컴퓨터 수 세기 
		
		// 첫 노드 방문 일지 추가 
		q.add(start);
		visited[start] = true;
		count++; // 시작점도해킹한 컴퓨터 수에 포
		
		//방문 리스트가 빌때까지 반복 
		while(!q.isEmpty()) {
			int current = q.poll();
			
			// 해킹할 수 있는 리스트 요소 꺼내 
			for(int next : list[current]) {
				if(!visited[next]) {
					visited[next] = true; // 해킹 방문 true 
					count++; // 방문할떄마다 해킹 가능한 컴퓨터 수 증
					q.add(next); // 여기도 방문하러 방문일지 추가 
				}
			}
			
		}
		cnt[start] = count;
	}
}

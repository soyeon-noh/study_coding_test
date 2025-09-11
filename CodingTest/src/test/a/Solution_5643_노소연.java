package test.a;

import java.util.*;
import java.io.*;

/**
 * 문제 이해
 * - 1~N번의 학생
 * - 모두 키가 다름
 * - 비교 결과가 입력으로 들어오는데
 * - 자신의 키가 몇 번째인지 알 수 있는 학생이 몇 명인지 출력
 * 
 * 전략
 * - 정방향, 역방향 dfs,bfs를 돌려서 탐색한 정점 수가 N-1이 되는 학생을 카운팅
 * - dfs로 풀어보자 
 * 
 * 입력
 * - 두 학생씩 키를 비교한 결과
 *
 */
public class Solution_5643_노소연 {
	
	static int N, M; // 학생들의 수 500, 비교횟수 500*299/2 = 74750
	// 정점이 500 / 간선이 74750
	static int[][] adj; 
	static int cnt;
	static int ans;
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			ans = 0;
			adj = new int[N+1][N+1];
			
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adj[from][to] = 1;
			}
			
//			for(int i = 0 ; i < N+1; i++) {
//				for(int j = 0 ; j < N+1; j++) {
//					System.out.print(adj[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			// 1번학생부터 N번학생까지 자기보다 크거나 작은 학생이 몇명인지 찾아보자 
			for(int i = 1; i <= N; i++) {
				boolean[] visited = new boolean[N+1]; // 정점을 방문했는지 체크 
				cnt = 0;
				lDfs(i, visited); // 이게 끝나면 나보다 큰 학생의 수가 cnt에 추가됨
				sDfs(i, visited); // 이게 끝나면 나보다 작은 학생의 수가 cnt에 추가됨
				
				if(cnt == N-1) ans++;
			}
			
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	private static void sDfs(int cur, boolean[] visited) {
		visited[cur] = true; 
		
		
		for(int i = 1; i <= N; i++) {
			if(adj[i][cur] == 1 && visited[i] == false) {
				cnt += 1;
				sDfs(i, visited);
			}
		}
	}
	
	private static void lDfs(int cur, boolean[] visited) {
		visited[cur] = true; 
		
		
		for(int i = 1; i <= N; i++) {
			if(adj[cur][i] == 1 && visited[i] == false) {
				cnt += 1;
				lDfs(i, visited);
			}
		}
		
	}
	


}


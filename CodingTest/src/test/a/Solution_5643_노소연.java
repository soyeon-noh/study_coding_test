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
 * 
 * 입력
 * - 두 학생씩 키를 비교한 결과
 *
 */
public class Solution_5643_노소연 {
	
	static int N, M; // 학생들의 수 500, 비교횟수 500*299/2 = 74750
	// 정점이 500 / 간선이 74750
//	static List<Integer> adjList; // 리스트로하면 2번해야함 차라리 행렬
	static int[][] adjArr; 
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
			adjArr = new int[N+1][N+1];

			
			
			// from -> to 큰사람 찾기
			// to -> from 작은 사람 찾기
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjArr[from][to] = 1;
			} // 입력끝
			
			for(int i = 1; i <= N; i++) {
				
				dfs(i, 0, true);
				dfs(i, 0, false);
			}
			
			
			sb.append("#").append(tc).append(" ").append(ans);
			System.out.println(sb.toString());
		}
	}
	
	// 학생번호, 카운트
	private static void dfs(int n, int cnt, boolean up) {
		if(cnt == N-1) {
			ans++;
			System.out.println("?");
			return;
		}
		System.out.println("?");
		if(up) {
			for(int to = 1; to <= N; to++) {
				if(adjArr[n][to] == 1) {
					adjArr[n][to] = 2;
					dfs(to, cnt+1, up);
					adjArr[n][to] = 1;
				}
			}
		}else {
			for(int to = 1; to <= N; to++) {
				if(adjArr[to][n] == 1) {
					adjArr[to][n] = 2;
					dfs(to, cnt+1, up);
					adjArr[to][n] = 1;
				}
			}
		}

	}

}

package test.a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 문제 이해
 * - 1~N 번호를 가진  학생들 (N명)
 * - 키는 모두 다름
 * - 두 학생끼리 키를 비교한 결과의 일부가 주어짐
 * 
 * - 작은쪽이 from / 큰쪽이 to
 * 
 * - 자신의 키가 몇 번재인지 알 수 있는 학생이 몇 명인지 출력.
 * 
 * 전략
 * - 큰일났다. 이거뭐지?
 * - 4번 정점은 나보다 작은 사람 + 나보다 큰 사람  = N-1명
 * - 내가 갈수 있는 수 + 나에게 올 수 있는 거 
 */
public class Solution_5643_키순서 {

	static int N, M;
	static int ans;
	static boolean[][] adj; // 인접행렬
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new boolean[N+1][N+1];
			
			//입력
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a][b] = true; // a->b 그래프, a가 키가 작다
			}
			
			for(int i = 1; i <= N; i++) {
				bfs(i, true);
				bfs(i, false); 
			}
			
			
			
			System.out.println("#" + tc + " " + ans);
		}
		
	}
	
	// dir = true : 나보다 큰사람 찾기 (정방향)
	// dir = false : 나보다 작은 사람 찾기
	private static int bfs(int cur, boolean dir) {
		int cnt = 0;
		
		
		Queue<Integer> q = new ArrayDeque<>();
		q.add(cur);
		
		
		while(!q.isEmpty()) {
			
		}
		
		
		return cnt;
	}
}

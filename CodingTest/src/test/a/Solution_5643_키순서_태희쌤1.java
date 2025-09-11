package test.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_키순서_태희쌤1 {

	static int N, adj[][];
	static int count; // 자신보다 키가 크거나 작은 학생수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			adj = new int[N+1][N+1]; // 학생번호 1번 부터
			
			for(int m = 0; m < M; m++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a][b] = 1; // a보다 b가 키가 크다.
			}
			
			int ans = 0;
			for(int i = 1; i <= N; i++) { // 모든 학생에 대해 자신보다 키가 큰 학생 탐색, 작은 학생 탐색
				count = 0; //초기화
				
				boolean[] visited = new boolean[N+1]; // 하나만 있으면됨 ㅇㅇ 크면서 작은 학생은 없으니.
				gtDFS(i, visited); // 수행하고나면 count에는 나보다 큰 학생수가 저장됨 
				ltDFS(i, visited); // 수행하고나면 count에는 나보다 작은 학생수까지 누적 저장됨
				
				if(count == N-1) ++ans;
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	private static void gtDFS(int cur, boolean[] visited) {
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if(adj[cur][i]==1 && !visited[i]) {
				++count; // 나보다 큰얘를 만날 때마다 count +1씩 누적
				gtDFS(i, visited);
			}
		}
	}
	
	private static void ltDFS(int cur, boolean[] visited) {
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if(adj[i][cur]==1 && !visited[i]) { // 여기 바꾸면됨
				++count;
				ltDFS(i, visited); // 재귀도 잘 부르기
			}
		}
	}
}

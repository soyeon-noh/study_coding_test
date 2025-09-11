package test.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_키순서_태희쌤3 {

	static int N, adj[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			adj = new int[N+1][N+1]; // 학생번호 1번 부터
			// 안쓰는 0인덱스 행렬을 이용
			
			for(int i = 1; i <= N; i++) adj[i][0] = -1; // 모든 행의 0열 초기화
			
			
			for(int m = 0; m < M; m++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a][b] = 1; // a보다 b가 키가 크다.
			}
			
			int ans = 0;
			// 모든 학생에 대해 자신보다 키가 큰 학생 탐색(이 과정에서 간점관계를 직접관계로 경로 압축)
			for(int i = 1; i <= N; i++) {
				if(adj[i][0] == -1) gtDFS(i); // 메모가 안 되어 있는 경우만 계산
			}
			
			// 여기까지 0열을 채움. 
			// 이제 0행을 채워서 작은 학생 세보자
			
			// 자신보다 작은 학생 카운트
			for(int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adj[0][i] += adj[j][i]; 
				}
			}
			
			// 자신보다 키가 큰 학생 + 작은 학생 카운팅
			for (int i = 1; i <= N; i++) {
				if(adj[i][0] + adj[0][i] == N-1) ++ans;
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void gtDFS(int cur) {
		for(int i = 1; i <= N; i++) {
			if(adj[cur][i] == 1) { // cur보다 큰 i 라면
				if(adj[i][0] == -1) gtDFS(i); // 탐색 안 했으면 탐색하러가
				
				// i가 탐색을 이미 했거나, i탐색을 마치고 내려왔거나
				if(adj[i][0] > 0) { // i보다 큰 학생이 있다면, cur<i<j ==> cur<j의 관계로 표현
					for (int j = 1; j <= N; j++) { // i보다 큰 학생 j 찾아서 cur<j 관계로 표현
						if(adj[i][j] == i) adj[cur][j] = 1;
						
					}
				}
			} 
		}
		// 자신보다 큰 학생들 수 카운팅 후 메모
		int cnt = 0;
		for (int i =1; i <= N; i++) {
			if(adj[cur][i] > 0) ++cnt;
		}
		adj[cur][0] = cnt;
	}
}

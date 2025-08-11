package com.codingtest.test.s0811;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N, M이 각각 백만을 넘는다.
// 완탐하면 큰일날 것 같음
// 누적합으로 풀어보자 근데 그래도  N^2아닌가. 암튼해보자
public class Test4_노소연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][M+1];
		int[][] sumArr = new int[N+1][M+1];
		
		for(int t = 0; t < T; t++) {
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
		}
		
		int maxCnt = 0;
		int[] maxPos = {-1, -1};
		for(int r = 1; r <= N; r++) {
			 for(int c = 1; c <= M; c++) {
				 sumArr[r][c] = arr[r][c] 
						 + sumArr[r-1][c] + sumArr[r][c-1]
						 - sumArr[r-1][c-1];
				 int nr = r-K-1;
				 int nc = c-K-1;
				 if(nr > 0 && nr <= N && nc > 0 && nc <= M) {
					 int cnt = sumArr[r][c] 
							- sumArr[nr][c] - sumArr[r][nc]
							+ sumArr[nr][nc];
						 
					 if(cnt >= maxCnt) {
//						 System.out.println("\n 봐보자 \n" + r + " " + c +  " cnt: " +cnt);
						 maxCnt = cnt;
						 maxPos[0] = r-K; // 여기  T로 잘못써서 30분날림 정 신 차려 
						 maxPos[1] = c;
					 }
				 }
				 
			 }
			 
		} // (7, 6) 최대 5가  결과로 나온다 
		
		StringBuilder sb = new StringBuilder();
		sb.append(maxPos[0]).append(" ").append(maxPos[1]).append("\n").append(maxCnt);
		System.out.println(sb.toString());
		
		
	}
}

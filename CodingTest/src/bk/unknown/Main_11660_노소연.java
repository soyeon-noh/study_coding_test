package bk.unknown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간 합 구하기 5

// 아이디어 : 누적 합
// 
public class Main_11660_노소연 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		// 순번은 1부터 시작이므로 배열 전체를 1부터 시작하게 N+1사이즈로 셋팅
		// 만약 누적합을 구할때 [r-1] 같은 인덱스를 처리하기에 이 방법이 좋다.
		int[][] arr = new int[N+1][N+1];
		int[][] prefixSum = new int[N+1][N+1];
				
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				prefixSum[i][j] = arr[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1]
						- prefixSum[i-1][j-1];
			}
		}
		
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			int sum = prefixSum[endX][endY] 
						- prefixSum[startX - 1][endY] - prefixSum[endX][startY - 1]
						+ prefixSum[startX - 1][startY - 1];
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
				
	}
}


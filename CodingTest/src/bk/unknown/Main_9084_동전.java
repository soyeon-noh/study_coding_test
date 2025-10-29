package bk.unknown;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9084_동전 {

	static int N, M;
	static int v[];
	static int dp[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			v = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				v[i] = Integer.parseInt(st.nextToken());
			}
			
			M = Integer.parseInt(br.readLine());// 입력완료
			dp = new int[M + 1];
			
			dp[0] = 0;
			
			for(int i = 1; i <= M; i++) {
				int min = Integer.MAX_VALUE;
				for(int j = 0; j < v.length; j++) {
					
					if(i >= v[j]) {
						min = Math.min(min, dp[i-v[j]] + 1);
					}
				}
				
				dp[i] = min;
			}
			
			System.out.println(dp[M]);
			
		}
	}
}

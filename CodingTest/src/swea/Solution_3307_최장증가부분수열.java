package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최장증가 부분수열 - DP
// 이진검색 사용 x 방법으로 풀어보았다.
public class Solution_3307_최장증가부분수열 {

	static int N;
	static int[] list;
	static int[] LIS; // 인덱스가 맨 마지막에 있을 때 길이값
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			list = new int[N];
			LIS = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				list[n] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for(int i = 0; i < N; i++) { // LIS[i]를 갱신하기 위해 반복을 돌려보자
				LIS[i] = 1; // 초기화 // 일단 최소 나자신. 1로 초기화
				for(int j = 0; j < i; j++) { // 0~ i-1 까지 돌면서 LIS[j]값을 이용해보자
					// 만약 i번 인덱스의 값이 j번보다 크면서
					// j for문을 돌면서 나온 LIS[i] 값보다 큰 것을 찾아내는 거임
					if(list[i] > list[j] && LIS[i] < LIS[j] + 1) {
						LIS[i] = LIS[j] + 1;
					}
				}
				// LIS[i] 값을 구했으니 비교해서 max값 찾기
				max = Math.max(LIS[i], max);
			}
			
			
			sb.append("#").append(tc).append(" ").append(max).append("\n");
			
		}
		
		System.out.println(sb.toString());
	}
}

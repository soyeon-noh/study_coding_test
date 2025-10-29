package swea;

import java.io.*;
import java.util.*;

public class Solution_2115_벌꿀채취 {

	// N*N map
	// 배열 데이터 : 꿀의 양
	// M : 꿀을 채취할 수 있는 벌통의 수
	// C : 두 일꾼이 채취할 수 있는 꿀의 최대 양
	// 1. 두명의 일꾼이 가로로 연속되도록 M개 벌통 채취
	// 하나의 벌통에서 채취한 꿀은 하나의 용기에
	// 2. 수익 : 각 용기 꿀양의 제곱

	static int N, M, C; // (3 ≤ N ≤ 10), (1 ≤ M ≤ 5), C는 30이하
	static int[][] map;
	static int maxProfit;

	// 구간 정보 클래스
	static class Section{
		int r,c; // 시작 좌표
		int profit; // 이 구간에서의 최대 수익
		public Section(int r, int c, int profit) {
			super();
			this.r = r;
			this.c = c;
			this.profit = profit;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 끝

			
			// 1. 모든 구간 후보 구하기
			List<Section> sections = new ArrayList<>();
			for(int r = 0; r < N; r++) {
				for(int c = 0; c <= N - M; c++) {
					int profit = getMaxProfit(r,c); // 2. 해당 구간 최대 수익
					sections.add(new Section(r, c, profit));
				}
			}
			
			// 3. 두 구간 선택 (겹치면 x)
			
			
			System.out.println("#" + tc + " " + maxProfit);

		}
	}

	// 구간 최대 수익 (부분집합 - 조합)
	private static int getMaxProfit(int r, int c) {
		int[] arr = new int[M];
		for(int i = 0; i < M; i++) {
			arr[i] = map[r][c + i];
		}
		
		
		return subset(arr, 0, 0, 0);
	}

	// 부분집합 탐색
	// 꿀합이 C를 넘으면 x
	// 각 부분집합의 제곱값의 최대를 구함
	/**
	 * 
	 * @param arr 	M개의 연속된 꿀 배열
	 * @param idx 	각 배열의 idx. idx == M이면  재귀 끝
	 * @param sum	C넘으면 안 된다는 조건 때문에 추가
	 * @param profit	구하고자 하는 값 (return 값)
	 * @return
	 */
	private static int subset(int[] arr, int idx, int sum, int profit) {
		if(sum > C) return 0; // 꿀합 C넘음 return
		if(idx == M) return profit; // arr 각 요소 다 돌았으면 return;
		
		// 각 arr[idx]를 
		// 선택 안 함
		int res1 = subset(arr, idx + 1, sum, profit);
		// 선택 함
		// 		sum에 더함, profit에 제곱 더함.
		int res2 = subset(arr, idx + 1, sum + arr[idx], profit + arr[idx] * arr[idx]);
		
		
		return Math.max(res1, res2);
	}
	
	// 두 구간이 겹치는지 확인 
	static boolean isOverlap(Section s1, Section s2) {
		if(s1.r != s2.r) return false;// 행이 다르면 무조건 안 겹침
		// 같은 행이면 열 구간이 겹치는지 확인
		//		s1
		if(s1.c + M - 1 < s2.c || s2.c + M - 1 <s1.c)return false;
		
		return true;
	}
	
}

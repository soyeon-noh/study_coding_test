package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2112_보호필름_다올쌤 {
	static int W; // 보호 필름 폭 W
	static int D; // 보호필름 두께 D
	static int K; // 합격기준 K
	static int Min; // 최소 투약 횟수
	static int[][] film; // 필름 정보
	static int[] chemicals;// 약품 투약 정보

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			film = new int[D][W];
			Min = Integer.MAX_VALUE;
			chemicals = new int[D];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// ------------INPUT END------------------------

			dfs(0, 0);

			System.out.println("#" + tc + " " + Min);

		}

	}

	static void dfs(int inputCnt, int row) {
		if (inputCnt > K) {
			return;
		}

		if (inputCnt >= Min) {
			return;
		}

		if (row == D) {
			if (check()) {
				Min = Math.min(Min, inputCnt);
			}
			return;
		}

		for (int i = -1; i < 2; i++) {
			chemicals[row] = i;
			if (i == -1) {
				dfs(inputCnt, row + 1);
			} else {
				dfs(inputCnt + 1, row + 1);
			}
		}
		// 부분집합의 형태 반복 되니까 for문으로 묶기
//		chemicals[row]=-1; //투입 안하는 경우
//		dfs(inputCnt, row+1);
//		chemicals[row]=0; //약품 0
//		dfs(inputCnt+1, row+1);
//		chemicals[row]=1; //약품 1
//		dfs(inputCnt+1, row+1);

	}

	static boolean check() {
		int cnt = 0;
		int cur, next;
		for (int col = 0; col < W; col++) { // 열
			cnt = 1;
			for (int row = 0; row < D - 1; row++) { // 행
				cur = chemicals[row] == -1 ? film[row][col] : chemicals[row];
				next = chemicals[row + 1] == -1 ? film[row + 1][col] : chemicals[row + 1];
				if (cur == next) {
					cnt++;
					if (cnt >= K) {
						break;
					}
				} else {
					cnt = 1;
				}
			}
			if (cnt < K) {
				return false;
			}
		}
		return true;
	}

}
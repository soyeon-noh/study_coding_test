package test.s0811;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 블록 회전
public class Test2_노소연 {

	// 상자의 크기 N (1<=N<=100)
	// N*N 배열 
	// 제한시간 2초
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		//  결국 row별로 블럭이 몇개인지 세면 됨.
		// row별 블럭 갯수를 카운트하자 
		int[] countByRow = new int[N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					countByRow[i] += 1;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < countByRow[i]; j++) {
				sb.append(1 + " ");
			}
			for(int j = 0; j < N - countByRow[i]; j++) {
				sb.append(0 + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
		
	}
}

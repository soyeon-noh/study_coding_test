package ssagorithm.bk.s;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11048_이동하기 {

	// N x M 미로
	
	static int N, M;
	static int[][] map;
	static int ans;
	static int[] dr = {1, 0, 1};
	static int[] dc = {0, 1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		
		for(int r = 1; r < N+1; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c < M+1; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs();
		
		System.out.println(ans);
	}
	
	private static void dfs() {
		
		if()
		
	}
}

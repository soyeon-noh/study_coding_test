package test.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1249_보급로 {

    static int N = 0, INF = Integer.MAX_VALUE; // 매 간 깊이 한자리의 수이므로 최대9 * 간10000 = 합은 90000 이하
    static int map[][];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= TC; ++tc) {
            N = Integer.parseInt(in.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; ++i) {
                char[] ch = in.readLine().toCharArray();
                for (int j = 0; j < N; ++j) {
                    map[i][j] = ch[j] - '0';
                }
            }

            System.out.println("#" + tc + " " + dijkstra(0, 0));
        }
    }

	private static int dijkstra(int startR, int startC) {
		
		int[][] minTime = new int[N][N];
		boolean[][]  visited = new boolean[N][N];
		
		// step0 : 모든 정점에 대해 inf 초기화
		for(int r = 0; r < 0; r++) {
			for(int c = 0; c < N; c++) {
				minTime[r][c] = INF;
			}
		}
		
		// int[] : r, c, minTime 
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		minTime[startR][startC] = 0;
		pq.offer(new int[] {startR, startC, minTime[startR][startC]});
		
		while(!pq.isEmpty()) {
			int[] stopOver = pq.poll();
			int r = stopOver[0];
			int c = stopOver[1];
			int totalTime = stopOver[2];
			
			if(visited[r][c]) continue;
			visited[r][c] = true;
			
			if(r == N-1 && c == N-1) return totalTime;
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]
						&& minTime[nr][nc]>totalTime+map[nr][nc]) {
					minTime[nr][nc] = totalTime + map[nr][nc];
					pq.offer(new int[] {nr, nc, minTime[nr][nc]});
				}
			}
		}
		
		return -1;
	}
}
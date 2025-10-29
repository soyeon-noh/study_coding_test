package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.DropMode;


public class Solution_2382_보충 {
	
	static int N, M, K; // 셀의 개수, 격리 시간, 미생물 군집 수
	static int[] dr = {0, -1, 1, 0, 0}; // x 상하좌우
	static int[] dc = {0, 0, 0, -1, 1}; // x 상하좌우
	static int[] opp = {0, 2, 1, 4, 3}; // 인덱스 하상우좌
	static Micro[] list;
	static Micro[][] map;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			list = new Micro[K];
			map = new Micro[N][N];
			
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				list[k] = new Micro(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			move();
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			ans = 0; // 초기화
		}
		
		System.out.println(sb);
	}
	
	private static void move() {
		int nr, nc;
		for(int t = 0; t < M; t++) {
			System.out.println(t + "번째 턴");
			for(Micro m : list) {
				System.out.println(m.toString());
				// 죽은건 취급 x
				if(m.cnt == 0) continue;
				// 이동
				nr = m.r += dr[m.dir];
				nc = m.c += dc[m.dir];
				
				// 약품처리
				if(nr == 0 || nc == 0 || nr == N-1 || nc == N-1) {
//					System.out.println("약품처리 전 : " + m.cnt);
					m.total = m.cnt /= 2; // 이거때문에 문제가 너무 많이 남
					
//					System.out.println("약품처리 결과 : " + m.cnt);
					m.changeDir();
				}
				
				// 군집 병합
				// 아무도없어
				
				if(map[nr][nc] == null) {
					map[nr][nc] = m;
				// 있는데 나보다 커 
				}else if(map[nr][nc].cnt > m.cnt) {
					map[nr][nc].total += m.cnt; // 터줏대감에게 가진거 다 주기
					m.cnt = 0; // 나를 죽여
				// 있는데 나보다 작아
				}else {
					m.total += map[nr][nc].total; // 여태 모아놓은거 내가 다 가지고 있기. 
					map[nr][nc] = m; // 내가 이자리를 차지해
				}
				
			}
			reset();
		}
		
		for(Micro m : list) {
			ans += m.cnt;
		}
	}

	// 여기가 너무 헷갈린다 
	private static void reset() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] == null) continue; // 없으면 패스
				
				map[r][c].cnt = map[r][c].total;
				
				map[r][c] = null; //초기화
					
			}
		}
		
	}

	static class Micro{
		int r;
		int c;
		int cnt;
		int dir;
		int total;
		public Micro(int r, int c, int cnt, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.total = this.cnt = cnt;
			this.dir = dir;
		}
		
		public void changeDir() {
			this.dir = opp[this.dir];
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder().append(c + " ").append(r + " ")
			.append(cnt + " ").append(dir + " ")
			.append(total);
			return sb.toString();
		}
	}
}

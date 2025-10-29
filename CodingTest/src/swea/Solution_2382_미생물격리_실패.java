package swea;
// 문제 발생
// 동시에 한씩 나눠서 더해야하는데 그러지 못했음
// hashmap을 사용하지 않고 해결하는 방법은 없나?
// 답이 전혀 안나온다. 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

// 미생물 격리
// 1. 각 군집들은 1시간마다 이동방향에 있는 다음 셀로 이동한다.
// 2. 미생물 군집이 이동 후 약품이 칠해진 셀에 도착하면 군집 내 미생물의 절반이 죽고, 이동방향이 반대로 바뀐다. 
//	 	살아남은 미생물 수 = 원래 미생물 수를 2로 나눈 후 소수점 이하를 버림 한 값
//		(따라서 군집에 미생물이 한 마리 있는 경우 살아남은 미생물 수가 0이 되기 때문에, 군집이 사라지게 된다,)
// 3. 이동 후 두 개 이상의 군집이 한 셀에 모이는 경우 군집들이 합쳐지게 된다. 
// 		합쳐 진 군집의 미생물 수는 군집들의 미생물 수의 합이며, 이동 방향은 군집들 중 미생물 수가 가장 많은 군집의 이동방향이 된다.
// 		(합쳐지는 군집의 미생물 수가 같은 경우는 주어지지 않으므로 고려하지 않아도 된다.)

// 상하좌우  1 2 3 4
public class Solution_2382_미생물격리_실패 {

	static int N, M, K; // 구역크기 N*N, 시간 M, 미생물 군집 수 K
	static int[][] map; // 해당 좌표에 바이러스가 존재하는지 체크하는 map 
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	static int[] opp = {0, 2, 1, 4, 3};
	static Virus[] virusList;
	
	
	static class Virus {
		int x;
		int y;
		int cnt;
		int dir;

		public Virus(int x, int y, int cnt, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}

		public void setDirOpp(int dir) {
			this.dir = opp[dir];
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
//			virusList = new ArrayList<>();
			virusList = new Virus[K+1]; // 인덱스 1이 군집 1... 군집 K까지 사용
			map = new int[N][N];
			
			for(int k = 0; k < K; k++) {
				
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
//				virusList.add(new Virus(x, y, cnt, dir));
				virusList[k] = new Virus(x, y, cnt, dir);
				map[x][y] = 1;  // 해당좌표에 바이러스가 존재한다

			}// 입력끝
			
			for(int m = 1; m <= M; m++) { // 1시간후~ M시간 후
				// 이동
				for(int i = 1; i <= K; i++) { // 군집 1, 2, ... N
					if(virusList[i] == null) continue; // 통합된 경우 패스
					
					// 현재 옮길 대상 군집
					Virus v = virusList[i];

					// 새좌표
					int nx = v.x + dx[v.dir];
					int ny = v.y + dy[v.dir];
					
					// 만약 새좌표에 이미 군집이 있다면
					if(map[nx][ny] > 0) {
						// 기존 군집 정보 가져옴
						Virus preV = virusList[map[nx][ny]];
						// 기존군집카운트와 비교하여 로직 
						if(preV.cnt > v.cnt) {
							preV.cnt += v.cnt;
							virusList[i] = null; // 통합된 경우 바이러스 리스트에서 삭제 // 오답노트 : v = null하면안된대
						} else {
							v.cnt += preV.cnt;
							virusList[map[nx][ny]] = null; // 오답노트 : preV = null 하면 안된대 
						}
						continue;
					}
					

					
					// 약품처리된 곳에 가면
					if(isOutOfMap(nx, ny)){
						v.cnt /= 2;
						// 오답노트 : 삭제됐을 때를 고려하지 못함
						if(v.cnt == 0) {
							virusList[i] = null; // 약품으로인해 0이됐다면 리스트에서 삭제 
						}
						// 방향전환
						v.setDirOpp(v.dir);
					}
					
					
					// 기존 위치를 맵에서 삭제
					map[v.x][v.y] = 0;
					// 새로운 위치를 맵에 추가
					map[nx][ny] = i;
					// 군집 위치 갱신
					v.x = nx;
					v.y = ny;
				} // 이동 완료
				
			}
			
			int sum = 0;
			for(Virus v : virusList) {
				if(v == null) continue;
				sum += v.cnt;
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean isOutOfMap(int nx, int ny) {
		return (nx == 0 || ny == 0 || nx == N-1 || ny == N-1);
	}
	
	
}

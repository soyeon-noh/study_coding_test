package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * - N*N 게임 공간 
 * 1. 정사각형 블록 : 부딛히면 방향을 반대로 전환 - 점수 카운팅
 *  4가지 형태의 삼각형 블록 : 경사면을 만날 경우 직각으로 꺾임(주의!!) - 점수 카운팅
 * 2. 웜홀 : 항상 쌍으로 주어짐. 웜홀에 핀볼이 도착하면 반대편 웜홀로 이동, 방향 유지
 * 	- 6~10번 -> 따로 기록해둘건지?
 * 3. 블랙홀, 출발 위치 : 게임이 끝난다. 
 *  - -1번 
 * 4. 핀볼  : 상, 하, 좌, 우 중 한방향
 * 5. 빈 공간 : 핀볼 놓을 수 있음. 핀볼이 현재 방향을 유지
 * 6. 벽 : 부딛히면 반대 방향으로 방향 전환, 점수 카운팅 필요
 * <<구현 로직 순서>>
 * 1. 입력 받기 
 *  - 2차원 배열 만들어서 값 받기 
 *  - 웜홀 정보 따로 저장 해두기 WarmH[웜홀 번호(6~10)][4]
 * 2. 2차원 배열 빈공간에 핀볼을 배치하고 게임 돌리기.
 * 		2-1. 블랙홀을 만났을 때 (출발지 포함) : 게임끝내고 점수 확인
 * 		2-2. 웜홀을 만났을 때 : 방향 유지, 핀볼 위치 변경
 * 		2-3. 블럭을 만났을 때 : 방향 전환+점수 올려주기 
 * 3. 게임이 끝나면, 최대 점수 갱신
 * 4. 출력 
 */
public class Solution_5650_핀볼게임_다올쌤 {
	//상, 우 , 하, 좌 순서
	private static int[] dr = {-1,0,1,0};
	private static int[] dc = {0,1,0,-1};
	private static int T, N;
	private static int Max; //최대 점수 저장용
	private static int[][] map, warmH; //핀볼게임판 저장용, 웜홀 저장용 
	
	static class Ball{
		int r, c; //핀볼 위치
		int dir;  //핀볼 진행 방향
		int count;  //핀볼의 점수
		
		public Ball(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1. 입력 받기 
		//		 *  - 2차원 배열 만들어서 값 받기 
		//		 *  - 웜홀 정보 따로 저장 해두기 WarmH[웜홀 번호(6~10)][4]
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		//숫자 1개 읽기때문에 바로 파싱+ 공백이 붙어있는 경우 에러날 수 있어서 trim()을 통해서 공백 없애주기
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <=T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			//자료구조 초기화
			//경계밖으로 나갔을 때, 방향을 되돌리기 위해서 경계 역할을 해줄 구역 만들기.
			map = new int[N+2][N+2]; //좌표 사용시 주의!!
			warmH = new int[11][4]; //실제 사용은 6~10번만 사용
			Max = Integer.MIN_VALUE; //정수 기준 최소값으로 초기화
			
			//map에 정보 받기
			for (int i = 1; i < N+1; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 1; j < N+1; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
					//웜홀에 해당하면 별도로 기록해주기
					if(map[i][j]>5) {
						int num = map[i][j];
						if(warmH[num][0]==0&&warmH[num][1]==0) {
							warmH[num][0] = i;
							warmH[num][1] = j;							
						}else {
							warmH[num][2] = i;
							warmH[num][3] = j;
						}
					}
				}
			}
			
			//경계 부분 모두 벽(5)을 셋팅
			for (int i = 0; i < N+1; i++) {
				map[i][0] = 5;
				map[0][i] = 5;
				map[N+1][i] = 5;
				map[i][N+1] = 5;
			}
			//-----------INPUT END0-------------------
			
			//2. 2차원 배열 빈공간에 핀볼을 배치하고 게임 돌리기.
			for (int r = 1; r < N+1; r++) {
				for (int c = 1; c < N+1; c++) {
					if(map[r][c]==0) {
						map[r][c] = -1;//블랙홀하고 시작위치는 같은 역할하므로 블랙홀로 표기
						move(r, c);
						map[r][c]=0; //다른위치로 가기위해 원상복귀
					}
				}
			}
			
			System.out.println("#" + t + " " + Max);
		}

	}
	
	/**
	 * 핀볼 움직이기 : 주어진 위치에서 4방향으로 핀볼 굴리기
	 * @param r
	 * @param c
	 */
	private static void move(int r, int c) {
			for (int d = 0; d < 4; d++) { //공을 4개 방향으로 다 굴려보기
				Ball b = new Ball(r, c, d);
				while (true) {
					// 무언가 만나지 않으면 계속 동일한 방향으로 진행
					while (true) {
						b.r += dr[b.dir];
						b.c += dc[b.dir];
						if (map[b.r][b.c] != 0)
							break;
					}
					// 0이 아닌 것들을 만났을때 처리할 내용들
					// 1.블랙홀을 만났을 때(출발지 포함)
					if (map[b.r][b.c] == -1) {
						// 점수 갱신 필수
						Max = Math.max(b.count, Max);
						break; // 게임 끝내기
					} 
					else if (map[b.r][b.c] > 5) {// 2. 웜홀을 만났을 때 (방향 바꾸지X, 위치만 이동)
						int num = map[b.r][b.c]; // 웜홀 번호 뽑기
						// 만난 웜홀의 위치 찾기
						if (warmH[num][0] == b.r && warmH[num][1] == b.c) {
							b.r = warmH[num][2];
							b.c = warmH[num][3];
						} else {
							b.r = warmH[num][0];
							b.c = warmH[num][1];
						}
					} else if (map[b.r][b.c] <= 5) {// 3. 블럭을 만났을 때 (블럭 번호에 따라서 방향 바꿈, 점수 올려주기)
						b.dir = changeDir(map[b.r][b.c], b.dir); // 방향 변경
						b.count++;// 점수 올려주기
					}
				}
			}
	}
	
	/**
	 * 공 방향 전환
	 * @param wall
	 * @param dir
	 * @return
	 */
	private static int changeDir(int wall, int dir) {
		if (wall == 1) { //1번 블럭인 경우 : 아래, 왼쪽인 경우 수직 전환
			if (dir == 0) {
				return 2;
			} else if (dir == 1) {
				return 3;
			} else if (dir == 2) {
				return 1;
			} else {
				return 0;
			}

		} else if (wall == 2) { //2번 블럭인 경우 : 위, 왼쪽인 경우 수직 전환
			if (dir == 0) {
				return 1;
			} else if (dir == 1) {
				return 3;
			} else if (dir == 2) {
				return 0;
			} else {
				return 2;
			}
		} else if (wall == 3) { //3번 블럭인 경우 : 위, 오른쪽인 경우 수직 전환
			if (dir == 0) {
				return 3;
			} else if (dir == 1) {
				return 2;
			} else if (dir == 2) {
				return 0;
			} else {
				return 1;
			}
		} else if (wall == 4) { //4번 블럭인 경우 : 아래, 오른쪽인 경우 수직 전환
			if (dir == 0) {
				return 2;
			} else if (dir == 1) {
				return 0;
			} else if (dir == 2) {
				return 3;
			} else {
				return 1;
			}
		} else {//벽인 경우 : 반대 방향으로 방향 전환
		    return (dir+2)%4;
		}
	}

}

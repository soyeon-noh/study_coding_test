package swea;

import java.io.*;
import java.util.*;

public class Solution_5648_원자소멸시뮬레이션 {

	static class Atom implements Comparable<Atom>{
		int x, y, dir, e; //좌표, 방향, 에너지

		public Atom(int x, int y, int dir, int e) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.e = e;
		}
		
		@Override
		public int compareTo(Atom o) {
			// x좌표보다 작은 순, 같다면 y좌표가 작은 순
				// 음수, 0 그대로 / 양수 뒤집어짐
				// 빼기 연산 안하는 이유는 좌표가 -가 있어서..?
			return this.x < o.x 
					? -1 : (this.x != o.x ? 
					Integer.compare(this.x, o.x): Integer.compare(this.y, o.y)); 
		}
	}
	
	static class Pair implements Comparable<Pair>{ // 충돌리스트에 담을 충돌하는 두 원자와 그 때의 시간 정보 
		int i, j, time; // 좌표를 2배로 만들어서 0.5시간을 제외시킬 예정. 때문에 시간을 int형으로 쓸 수 있음

		public Pair(int i, int j, int time) {
			super();
			this.i = i;
			this.j = j;
			this.time = time;
		}
		
		// 시간 비교 
		@Override
			public int compareTo(Pair o) {
				return Integer.compare(this.time, o.time);
			}
	}
	
	static int N;
	static ArrayList<Atom> list; // 원자리스트 // 배열로 해도 상관 x 길이 고정이니까
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken()) * 2;
				int y = Integer.parseInt(st.nextToken()) * 2;
				int d = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				list.add(new Atom(x, y, d, e));
			}
			System.out.println("#" + tc + " " + makeBoomPair());
		}
	}
	
	private static int makeBoomPair() {
		// 원자리스트를 좌표기준으로 정렬
		Collections.sort(list);
		ArrayList<Pair> boomList = new ArrayList<>();
		// 원자 2개씩 조합 생성
		// 2개 고정이니까 재귀를 안해도된다? -> 반복문 ㄱㄱ!!!!
		for(int i = 0; i < N; i++) { // 선택할 첫번째 원자
			for(int j = i+1; j < N; j++) {
				Atom a = list.get(i);
				Atom b = list.get(j);
				
				// 같은 x좌표를 갖는 원자들이 만날 때 (수직선)
				if(a.x == b.x) {
					if(a.dir == 0 && b.dir == 1) {
						boomList.add(new Pair(i, j, Math.abs(a.y-b.y)/2)); //그냥 b에서 a빼면 양수니까 그렇게해도됨
					}
				}
				// 같은 y좌표를 갖는 원자들이 만날 때 (수평선)
				if(a.y == b.y) {
					if(a.dir == 3 && b.dir == 2) {
						boomList.add(new Pair(i, j, Math.abs(a.x-b.x)/2));
					}
				}
				// / 대각선 라인에 있는 대상들이 만날 때 
				if(a.x - a.y == b.x - b.y) {
					if(a.dir == 3 && b.dir == 1 || a.dir == 0 && b.dir == 2) {
						boomList.add(new Pair(i, j, Math.abs(a.x - b.x)));
					}
				}
				// \ 대각선 라인에 있는 대상들이 만날 때
				if(a.x + a.y == b.x + b.y) {
					if(a.dir == 1 && b.dir == 2 || a.dir == 3 && b.dir == 0) {
						boomList.add(new Pair(i, j, Math.abs(a.x - b.x)));
					}
				}
			}
		}
		
		// 조합을 다 만들어내서 최종적으로 동시에 터지는 얘들을 계산해서 에너지 합을 리턴하는 함수에 넣기
		return getTotalenergy(boomList);
	}

	// 동시처리를 신경쓰자
	// 동시터진 건지 이미 터진 건지 관리해야함
	private static int getTotalenergy(ArrayList<Pair> boomList) {
		Collections.sort(boomList); // 터지는 시간 기준 오름차순 정렬
		
		int INF = Integer.MAX_VALUE;
		int boomTimes[] = new int[N];
		Arrays.fill(boomTimes, INF);
		int sum = 0;
		
		for(Pair p : boomList) {
			if(boomTimes[p.i] < p.time || boomTimes[p.j] < p.time) continue;
			
			if(boomTimes[p.i] == INF) { // i 안터졌으니 터쳐보자
				boomTimes[p.i] = p.time;
				sum += list.get(p.i).e;
			}
			
			if(boomTimes[p.j] == INF) { // j 안터졌으니 터쳐보자
				boomTimes[p.j] = p.time;
				sum += list.get(p.j).e;
			}
		}
		
		return sum;
	}
}

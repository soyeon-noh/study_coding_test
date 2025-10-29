package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2382_손홍민 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	// �� ũ��, �ݸ� �ð�, ���� ��
	static int n, time, gCnt;
	// �� ����, �� ��ġ �� �����ϴ� ���� ��ü ����
	static Group[][] map;
	// �� ������ ��ġ �̵��� ���� ť ����
	static Queue<Group> q = new ArrayDeque<>();
	// ��, ��, ��, ��
	static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
	
	static class Group {
		// ��ǥ, ��ü ��, �̵� ����, ���հ������� ���� �� ��ü ��
		int y, x, cnt, dir, totalCnt;

		public Group(int y, int x, int cnt, int dir) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.dir = dir;
			totalCnt = cnt;
		}
		
		// ��ü ���� ����. ��ü ���� �� ���� ���� ������ ������.
		public void fuse(Group g) {
			if(this.cnt < g.cnt) {
				this.dir = g.dir;
				this.cnt = g.cnt;
			}
			this.totalCnt += g.cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			init();
			for(int i=0; i<time; i++) {
				move();
			}
			
			int sum = 0;
			while(!q.isEmpty()) {
				Group g = q.poll();
				sum += g.cnt;
			}
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
	
	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		time = Integer.parseInt(st.nextToken());
		gCnt = Integer.parseInt(st.nextToken());
		map = new Group[n][n];
		
		for(int i=0; i<gCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken()) - 1;
			// ���� ����. ���� ��ȯ ���ϰԲ� �ð� ������ ��ġ�ϰ��� �Ͽ���
			if(dir != 0) dir = dir%3 + 1;
			Group g = new Group(y, x, cnt, dir);
			q.add(g);
		}
	}
	
	static void move() {
		while(!q.isEmpty()) {
			Group g = q.poll();
			g.totalCnt = g.cnt;
			int ny = g.y + dy[g.dir];
			int nx = g.x + dx[g.dir];
			if(map[ny][nx] == null) {
				if(isBlocked(ny, nx)) {
					g.dir = (g.dir+2)%4;
					g.cnt /= 2;
					if(g.cnt == 0) continue;
					g.totalCnt = g.cnt;
				}
				g.y = ny;
				g.x = nx;
				map[ny][nx] = g;
			} else {
				Group other = map[ny][nx];
				other.fuse(g);
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == null) continue;
				Group g = map[i][j];
				g.cnt = g.totalCnt;
				q.add(g);
				map[i][j] = null;
			}
		}
	}
	
	static boolean isBlocked(int y, int x) {
		return y == 0 || x == 0 || y == n-1 || x == n-1;
	}

}


package week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 이해
 * - 교실 크기 : NxN (1,1)~(N,N) 
 * - 학생 수 : NxN
 * - 학생 번호 : 1~NxN
 * 
 * - 학생이 좋아하는 4명 
 * - 상하좌우가 인접이라 정의
 * 
 * 규칙
 * 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리 정함
 * 2. 1을 만족하는 칸이 여러개면, 비어있는 인접 칸이 가장 많은 칸으로 자리 정함
 * 3. 2를 만족하는 칸이 여러개면, 행의 번호가 가장 작은칸, 그것도 여러개면 열의번호가 가장 작은 칸
 * 
 * 입력 데이터
 * - 학생 번호, 좋아하는 학생 1, 2, 3, 4
 *
 */
public class Main_21608_상어초등학교 {

	static class Student{
		int num;
		int[] likes;
		public Student(int num, int[] likes) {
			super();
			this.num = num;
			this.likes = likes;
		}

	}
	
	static int N;
	static int[][] map;
	static Student[] input;
	static Integer[][] likeMap; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1]; // 좌표 1~N 사용
		input = new Student[N*N+1]; // 학생번호 1~N*N
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N*N+1; i++) {
			input[i].num = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < 4; j++) {
				input[i].likes[j] = Integer.parseInt(st.nextToken());
			}
		}// 입력끝
		
		for(int i = 1; i < N*N+1; i++) {
			decide(i);	
		}
		
		
	}

	private static void decide(int order) {
		likeMap = new Integer[N+1][N+1];
		
	}
}

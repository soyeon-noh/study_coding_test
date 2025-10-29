package bk.stepByStep;

import java.util.Scanner;

// 조합
public class Main_15650_N과M2 {

	static int N, R;
	static int[] visited;
	static int[] result;
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		visited = new int[N+1];
		result = new int[R];
		
		
		combi(1, 0);
	}
	private static void combi(int start, int cnt) {
		if(cnt == R) {
			for(int n : result) {
				System.out.print(n + " ");	
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i <= N; i++) {
			
			result[cnt] = i;
			combi(i+1, cnt+1);
			
		}
	}
}

package bk.unknown;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10811_바구니뒤집기 {

	static int N, M; // 책 번호 1~N, 순서뒤집기 횟수
	static int s, e; // 뒤집기 시작 idx, 끝  idx
	static int[] book;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		book = new int[N+1]; // 번호가 1부터 시작 
		
		for(int i = 1; i < N+1; i++) {
			book[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			int cnt = e-s+1;
			
			for(int c = 0; c < cnt/2; c++) {
				int temp = book[s];
				book[s] = book[e];
				book[e] = temp;
				
				++s;
				--e;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			sb.append(book[i]);
			if(i!= N) sb.append(" ");
		}
		
		System.out.println(sb);
		
	}

}


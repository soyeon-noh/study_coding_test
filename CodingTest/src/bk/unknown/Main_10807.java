package bk.unknown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10807 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(br.readLine());
		
		int num;
		int count = 0;
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			if(num == v) {
				++count;
			}
		}
		
		System.out.println(count);
		
	}

}

package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퍼펙트 셔플
public class Solution_3499_퍼펙트셔플 {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			String[] list = new String[N];
			
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				list[i] = st.nextToken();
				
			}
			sb.append("#").append(tc).append(" ");
			shuffle(list);
			
		}
		
		System.out.println(sb.toString());
	}

	private static void shuffle(String[] list) {
		int half = (list.length+1)/2;
		for(int i = 0; i < half; i++) {
			sb.append(list[i]).append(" ");
			if(list.length % 2 == 1  && i == half-1) continue;
			
			sb.append(list[i+half]).append(" ");
		}
		
		sb.append("\n");
		
	}
}

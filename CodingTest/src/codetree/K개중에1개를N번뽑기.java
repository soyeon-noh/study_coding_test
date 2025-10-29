package codetree;

import java.util.Scanner;

//1이상 k이하 숫자 중 N개를 뽑는 순열
public class K개중에1개를N번뽑기 {
	
	 static int k, n;
	 static boolean[] visited;
	 static StringBuilder sb = new StringBuilder();
	 
	 public static void main(String[] args) {
	     Scanner sc = new Scanner(System.in);
	     k = sc.nextInt();
	     n = sc.nextInt();
	     // Please write your code here.
	     
	     visited = new boolean[k+1];
	    
	     permutation(0, new int[n]);
	     
	     System.out.println(sb.toString());
	 }
	
	private static void permutation(int depth, int[] result) {
		if(depth == n) {
			
			for(int n : result) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i = 1; i <= k; i++) {
			result[depth] = i;
			permutation(depth+1, result);
		}
		
		
	}
}
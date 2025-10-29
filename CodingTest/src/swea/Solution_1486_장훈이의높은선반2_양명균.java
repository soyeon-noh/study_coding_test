package swea;

import java.util.Scanner;

public class Solution_1486_장훈이의높은선반2_양명균 {
    static int N, B, ans; // 몇명인지, 높이제한은 몇인지, 정답은 뭔지...
    static int[] H; // 점원들의 키

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            B = sc.nextInt();
            H = new int[N];
            ans = 987654321;

            for (int i = 0; i < N; i++)
                H[i] = sc.nextInt();
            // 입력끝
            // 비트마스킹 방식으로 부분집합(모든 경우의 수를 구해보자)
            for (int i = 0; i < (1 << N); i++) {
                //i가 경우의 수라는 건 알았어.
                int sum = 0;
                for(int j = 0; j<N; j++) {
                    if((i & (1<<j)) > 0) {
                        sum += H[j];
                    }
                }//내부 검사 누구를 사용한거지 검사!
                if(sum >= B) {
                    ans = Math.min(ans, sum);
                }
            } // 전체 경우의 수

            System.out.println("#" + tc + " " + ans);
        } // tc
    }// main
}




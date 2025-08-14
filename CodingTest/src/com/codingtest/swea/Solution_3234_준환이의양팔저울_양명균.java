package com.codingtest.swea;

import java.util.Scanner;

public class Solution_3234_준환이의양팔저울_양명균 {
    static int[] W; // 무게저장
    static int N, ans; // 경우의 수 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            W = new int[N];
            for (int i = 0; i < N; i++)
                W[i] = sc.nextInt();
            //////////// 입력끝
            ans = 0;
            getChoo(0,0,0,0);
            System.out.println("#" + tc + " " + ans);
        } // tc
    }// main

    // 추를 올려두자
    // depth : 몇개의 추를 건드리고 있는지....
    // left, right : 각각저울에 올려놓은 추의 총합
    // 기록해놓고 결과를 재사용하는 코드-> 시간이 굉장히 단축 된다.
    static void getChoo(int depth, int check, int left, int right) {
        if (left < right)
            return;
        if (depth == N) {
            // 왼쪽 올린친구와 오른쪽 올린 친구를 나누어서 비교 분석 한뒤에 가능한 경우에만 올린다.
            ans++;
            return;
        }
        for (int i = 0; i < N; i++) {
            // 사용한 추를 또 사용이 가능한가? -> 불가능 추는 1개씩만 존재한다.
            // 추를 사용했나? 안했나..
            if ((check & (1 << i)) != 0)
                continue;
            getChoo(depth + 1, check | (1 << i), left + W[i], right);
            getChoo(depth + 1, check | (1 << i), left, right + W[i]);
        }
    }

}
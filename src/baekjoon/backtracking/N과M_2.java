package baekjoon.backtracking;

import java.util.Scanner;

/**
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * <p>
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 고른 수열은 오름차순이어야 한다.
 * 입력
 * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 * <p>
 * 출력
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 * <p>
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class N과M_2 {
    public static int[] arr;
    public static int N, M;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();
        arr = new int[M];

        dfs(1, 0);
    }

    public static void dfs(int at, int depth) {
        // depth 만큼만 조회
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        /**
         * at 변수를 통해 정렬, 반복 line 수 최소화
         *
         * 현재 검사하고 있는 포인트보다 큰 수만 분기처리할 수 있다.
         */
        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}

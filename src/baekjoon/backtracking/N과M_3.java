package baekjoon.backtracking;

import java.util.Scanner;

/**
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * <p>
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 입력
 * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
 * <p>
 * 출력
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 * <p>
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class N과M_3 {
    public static int[] arr;
    public static int N, M;
    public static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        arr = new int[M];
        dfs(N, M);
        System.out.println(stringBuffer);
    }

    private static void dfs(int n, int m) {
        if (m == 0) {
            for (int val : arr) {
                stringBuffer.append(val + " ");
            }
            stringBuffer.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[M-m] = i;
            dfs(n, m - 1);
        }
    }
}

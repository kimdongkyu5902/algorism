package baekjoon.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 자연수 과 정수 가 주어졌을 때 이항 계수를 10,007로 나눈 나머지를 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 과 가 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ K ≤ N)
 */
public class 이항계수2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // N크기의 파스칼 삼각형 만들기
        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) // 양쪽 끝
                    arr[i][j] = 1;
                else // 파스칼 삼각형 정의
                    arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j]) % 10007;
            }
        }

        System.out.println(arr[N][K]);
    }
}

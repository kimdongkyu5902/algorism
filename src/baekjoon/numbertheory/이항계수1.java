package baekjoon.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 자연수 과 정수 가 주어졌을 때 이항 계수를 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 과 가 주어진다. (1 ≤ N ≤ 10, 0 ≤ K ≤ N)
 */
public class 이항계수1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long result = 1;

        if (N / 2 < K)
            K = N - K;

        for (int i = 0; i < K; i++) {
            result *= (N - i);
        }

        for (int i = 0; i < K; i++) {
            result /= (i + 1);
        }

        System.out.println(result);
    }
}

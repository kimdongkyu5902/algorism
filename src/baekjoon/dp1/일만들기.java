package baekjoon.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 * <p>
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 * <p>
 * 입력
 * 첫째 줄에 1보다 크거나 같고, 1000000보다 작거나 같은 정수 N이 주어진다.
 * <p>
 * 출력
 * 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 */
public class 일만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] results = new int[1000001];
        results[1] = 0;
        results[2] = 1;
        results[3] = 1;
        /**
         * 주어진 결과를 활용하여,
         * 현재 수 i가 만들어질 수 있는 3가지 경우의 수 중
         * 가장 작은 값을 만들어 간다.
         */
        for (int i = 4; i < results.length; i++) {
            int min = results[i - 1];
            if (i % 3 == 0)
                min = Math.min(min, results[i / 3]);
            if (i % 2 == 0)
                min = Math.min(min, results[i / 2]);
            results[i] = min + 1;
        }

        System.out.println(results[N]);
    }
}

package baekjoon.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
 * <p>
 * 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
 * <p>
 * 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
 * N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
 * i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
 * 입력
 * 첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
 * <p>
 * 출력
 * 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
 */
public class RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] redWeight = new long[N];
        long[] greenWeight = new long[N];
        long[] buleWeight = new long[N];
        for (int i = 0; i < N; i++) {
            String[] weights = br.readLine().split(" ");
            redWeight[i] = Long.parseLong(weights[0]);
            greenWeight[i] = Long.parseLong(weights[1]);
            buleWeight[i] = Long.parseLong(weights[2]);
        }

        /**
         * 한 단계씩 진행하면서 최소가 될 수 있는 경우의 수만 +해서
         * K단계에서 최소가 나오는 수를 계속 구하도록 한다.
         */
        for (int i = 0; i < N-1; i++) {
            redWeight[i+1] += Math.min(greenWeight[i], buleWeight[i]);
            greenWeight[i+1] += Math.min(redWeight[i], buleWeight[i]);
            buleWeight[i+1] += Math.min(greenWeight[i], redWeight[i]);
        }

        long result = Math.min(Math.min(redWeight[N - 1], greenWeight[N - 1]), buleWeight[N - 1]);
        System.out.println(result);
    }
}

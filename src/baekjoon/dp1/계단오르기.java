package baekjoon.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 계단 오르는 데는 다음과 같은 규칙이 있다.
 * <p>
 * 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
 * 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
 * 마지막 도착 계단은 반드시 밟아야 한다.
 * <p>
 * 따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.
 * <p>
 * 각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 입력의 첫째 줄에 계단의 개수가 주어진다.
 * <p>
 * 둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다. 계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수이다.
 * <p>
 * 출력
 * 첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력한다.
 */
public class 계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] stair = new int[N + 1];
        int[] dp = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        // 시작점은 밟고 시작
        dp[1] = stair[1];

        // N 이 1이 입력될 수도 있기 때문에 예외처리를 해줄 필요가 있다.
        if (N >= 2) {
            dp[2] = stair[1] + stair[2];
        }

        /**
         * 현재 위치의 DP값은
         * i-2번째 dp값
         * i-1밟고 i-3의 dp값을 더한 것충 큰것과
         *
         * 현재 점수를 더한 값
         */
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2] , dp[i - 3] + stair[i - 1]) + stair[i];
        }
        System.out.println(dp[N]);
    }
}

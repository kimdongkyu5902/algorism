package baekjoon.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 45656이란 수를 보자.
 * <p>
 * 이 수는 인접한 모든 자리수의 차이가 1이 난다. 이런 수를 계단 수라고 한다.
 * <p>
 * 세준이는 수의 길이가 N인 계단 수가 몇 개 있는지 궁금해졌다.
 * <p>
 * N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)
 * <p>
 * 입력
 * 첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.
 * <p>
 * 출력
 * 첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
 */
public class 쉬운계단수 {
    final static long mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];

        // 1자리 수는 1 ~ 9 가능
        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 두 번째 자릿수부터 N까지 탐색
        for(int i = 2; i <= N; i++) {

            // 마지막 자리숫자를 통한 다음 숫자 계산
            for(int j = 0; j < 10; j++) {

                // j=0, 뒤에 1만 올 수 있음
                if(j == 0) {
                    dp[i][0] = dp[i - 1][1] % mod;
                }
                // j=9, 뒤에 8만 올 수 있음
                else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % mod;
                }
                // 그 외의 경우 이전 자릿수의 자릿값 +1, -1 의 합이 됨
                else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

        long result = 0;

        // 각 자릿값마다의 경우의 수를 모두 더해준다.
        for(int i = 0; i < 10; i++) {
            result += dp[N][i];
        }

        System.out.println(result % mod);
    }
}

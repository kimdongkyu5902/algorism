package baekjoon.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)
 * <p>
 * 출력
 * 첫째 줄에 구한 0의 개수를 출력한다.
 */
public class 팩토리얼0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int twoNum = 0;
        int fiveNum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                int tmp = i;
                while (tmp % 2 == 0) {
                    tmp = tmp / 2;
                    twoNum++;
                }
            }
            if (i % 5 == 0) {
                int tmp = i;
                while (tmp % 5 == 0) {
                    tmp = tmp / 5;
                    fiveNum++;
                }
            }
        }

        int result = Math.min(twoNum, fiveNum);
        System.out.println(result);
    }
}

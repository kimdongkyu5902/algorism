package baekjoon.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
 *
 * 출력
 * 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
 */
public class 최대공약수와최소공배수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int i = 1 ; i <= a ; i++) {
            if (a % i == 0) {
                listA.add(i);
            }
        }

        for (int i = 1 ; i <= b ; i++) {
            if (b % i == 0) {
                listB.add(i);
            }
        }

        int result1 = 1;
        for (int i = 0 ; i < listA.size() ; i++) {
            for (int j = 0 ; j < listB.size() ; j++) {
                int test1 = listA.get(i);
                int test2 = listB.get(j);
                if (test1 == test2) {
                    result1 = test1;
                }
            }
        }
        System.out.println(result1);

        int result2 = a * b / result1;
        System.out.println(result2);
    }
}

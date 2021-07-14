package baekjoon.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 해빈이는 패션에 매우 민감해서 한번 입었던 옷들의 조합을 절대 다시 입지 않는다.
 * 예를 들어 오늘 해빈이가 안경, 코트, 상의, 신발을 입었다면, 다음날은 바지를 추가로 입거나 안경대신 렌즈를 착용하거나 해야한다.
 * 해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 며칠동안 밖에 돌아다닐 수 있을까?
 * <p>
 * 입력
 * 첫째 줄에 테스트 케이스가 주어진다. 테스트 케이스는 최대 100이다.
 * <p>
 * 각 테스트 케이스의 첫째 줄에는 해빈이가 가진 의상의 수 n(0 ≤ n ≤ 30)이 주어진다.
 * 다음 n개에는 해빈이가 가진 의상의 이름과 의상의 종류가 공백으로 구분되어 주어진다. 같은 종류의 의상은 하나만 입을 수 있다.
 * 모든 문자열은 1이상 20이하의 알파벳 소문자로 이루어져있으며 같은 이름을 가진 의상은 존재하지 않는다.
 * <p>
 * 출력
 * 각 테스트 케이스에 대해 해빈이가 알몸이 아닌 상태로 의상을 입을 수 있는 경우를 출력하시오.
 */
public class 패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st;
            Map<String, Integer> map = new HashMap<>();
            // 타입별 옷의 수 구하기
            for (int j = 0 ; j < m ; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                String name = st.nextToken(); // 이름은 필요없음
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            // 타입별 옷의 수 + 1 을 곱하여 전체 경우의 수
            long result = 1;
            for (Integer value : map.values()) {
                result *= (value + 1);
            }
            // 아무것도 입지않는 경우의 수 제외
            result--;
            System.out.println(result);
        }
    }
}


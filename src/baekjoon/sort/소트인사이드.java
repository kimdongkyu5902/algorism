package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
 *
 * 입력
 * 첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
 *
 * 출력
 * 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
 */
public class 소트인사이드 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        List<Integer> list = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            list.add(Integer.parseInt(ch + ""));
        }

        list = list.stream().sorted().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = size - 1 ; i >= 0 ; i--) {
            sb.append(list.get(i));
        }
        System.out.println(sb);
    }
}

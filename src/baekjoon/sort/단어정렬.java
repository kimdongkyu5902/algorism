package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 *
 * 길이가 짧은 것부터
 * 길이가 같으면 사전 순으로
 * 입력
 * 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.
 *
 * 출력
 * 조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다
 */
public class 단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<CustomString> queue = new PriorityQueue<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String next = br.readLine();
            if (!set.contains(next)) {
                queue.add(new CustomString(next));
                set.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll().s).append("\n");
        }
        System.out.println(sb);
    }

    public static class CustomString implements Comparable<CustomString> {
        public String s;

        public CustomString(String s) {
            this.s = s;
        }

        @Override
        public int compareTo(CustomString o) {
            if (s.length() == o.s.length())
                return s.compareTo(o.s);
            else
                return s.length() - o.s.length();
        }
    }
}

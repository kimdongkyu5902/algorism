package estzoom;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0과 1로 이루어진 두 문자열 p와 s가 주어집니다.
 * s에서 일부 문자를 삭제하여 p가 반복되는 형태로 바꾸려 합니다.
 * 즉, s에서 일부 문자를 삭제한 문자열과 p를 반복해서 이어 붙인 문자열이 같아지도록 해야 합니다.
 * 단, 삭제하는 문자 수가 최소여야 합니다.
 */
public class sol1 {
    public static void main(String[] args) {
        System.out.println(solution("101", "10100010101101100"));
        System.out.println(solution("110", "110110110"));
        System.out.println(solution("000", "00000000"));
        System.out.println(solution("00", "1111111"));
    }

    public static int solution(String p, String s) {
        // 반복대상을 붙여넣어 더 길게 만들기
        int count = s.length() / p.length() + 1;
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0 ; i < count ; i++) {
            for (int j = 0 ; j < p.length() ; j++) {
                queue.add(p.charAt(j));
            }
        }

        // 만족하는 조건 만나면 poll하고 개수++
        int loop = 0;
        for (int i = 0 ; i< s.length() ; i++) {
            if (s.charAt(i) == queue.peek()) {
                queue.poll();
                loop++;
            }
        }

        // 만들다만 반복수 빼기
        int spare = loop % p.length();
        int makeNum = loop - spare;

        // 전체만든 반복수에서 비교대상 빼면
        // 반대로 반복만들기위해 뺀 값
        int answer = s.length() - makeNum;
        // 없다면 -1
        if (makeNum == 0)
            return -1;
        else
            return answer;
    }
}

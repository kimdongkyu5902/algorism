package programmers.greedy;

/**
 * 조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
 * ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
 * <p>
 * 조이스틱을 각 방향으로 움직이면 아래와 같습니다.
 * <p>
 * ▲ - 다음 알파벳
 * ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
 * ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
 * ▶ - 커서를 오른쪽으로 이동
 * 예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.
 * <p>
 * - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
 * - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
 * - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
 * 따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
 * 만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
 * <p>
 * 제한 사항
 * name은 알파벳 대문자로만 이루어져 있습니다.
 * name의 길이는 1 이상 20 이하입니다.
 * <p>
 * 입출력 예
 * name	return
 * "JEROEN"	56
 * "JAN"	23
 */
public class 조이스틱 {
    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
        System.out.println(solution("JAN"));
    }

    public static int solution(String name) {
        int answer = 0;
        int length = name.length();
        //최대로 가질 수 있는 min값은 끝까지 가는것
        int min_move = length - 1;

        for (int i = 0; i < length; i++) {
            // 알파벳 이동 수 합
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            //좌우: 연속된 A의 등장에 따라 최소 움직임이 달라진다
            int next = i + 1;
            //내 다음이 A라면 계속 NEXT++
            while (next < length && name.charAt(next) == 'A')
                next++;

            //현 위치에서 반대로 돌아 다음 (next)을 끝(len)까지의 이동과 최솟값 비교
            min_move = Math.min(min_move, i + i + length - next);
        }
        answer += min_move;

        return answer;
    }
}

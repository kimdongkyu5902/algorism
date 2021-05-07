package programmers.bruteforce;

import java.util.ArrayList;
import java.util.List;

/**
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 * <p>
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * <p>
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한 조건
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 * <p>
 * 입출력 예
 * answers	return
 * [1,2,3,4,5]	[1]
 * [1,3,2,4,2]	[1,2,3]
 * <p>
 * 입출력 예 설명
 * 입출력 예 #1
 * <p>
 * 수포자 1은 모든 문제를 맞혔습니다.
 * 수포자 2는 모든 문제를 틀렸습니다.
 * 수포자 3은 모든 문제를 틀렸습니다.
 * 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
 * <p>
 * 입출력 예 #2
 * <p>
 * 모든 사람이 2문제씩을 맞췄습니다.
 */
public class 모의고사 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution(new int[]{1, 3, 2, 4, 2}));
    }

    public static int[] solution(int[] answers) {
        int a = 0, b = 0, c = 0;

        // 각 사람 패턴에 맞는 조건 검사
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == (i % 5 + 1))
                a++;

            if (i % 2 == 0 && answers[i] == 2)
                b++;
            if (i % 8 == 1 && answers[i] == 1)
                b++;
            if (i % 8 == 3 && answers[i] == 3)
                b++;
            if (i % 8 == 5 && answers[i] == 4)
                b++;
            if (i % 8 == 7 && answers[i] == 5)
                b++;

            if ((i % 10 == 0 || i % 10 == 1) && answers[i] == 3)
                c++;
            if ((i % 10 == 2 || i % 10 == 3) && answers[i] == 1)
                c++;
            if ((i % 10 == 4 || i % 10 == 5) && answers[i] == 2)
                c++;
            if ((i % 10 == 6 || i % 10 == 7) && answers[i] == 4)
                c++;
            if ((i % 10 == 8 || i % 10 == 9) && answers[i] == 5)
                c++;
        }

        // 최대값일 경우에만 답에 추가
        // 같은경우엔 비우지 않기
        int[] scores = {a, b, c};
        int max = 0;
        List<Integer> maxList = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= max) {
                if(scores[i] > max)
                    maxList.clear();
                max = scores[i];
                maxList.add(i + 1);
            }
        }

        int[] answer = new int[maxList.size()];
        Object[] objects = maxList.toArray();

        for (int i = 0 ; i < objects.length ; i++) {
            answer[i] = (int) objects[i];
            System.out.println(answer[i]);
        }

        return answer;
    }
}

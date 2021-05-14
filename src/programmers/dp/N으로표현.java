package programmers.dp;

import java.util.*;

/**
 * 아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.
 * <p>
 * 12 = 5 + 5 + (5 / 5) + (5 / 5)
 * 12 = 55 / 5 + 5 / 5
 * 12 = (55 + 5) / 5
 * <p>
 * 5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
 * 이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.
 * <p>
 * 제한사항
 * N은 1 이상 9 이하입니다.
 * number는 1 이상 32,000 이하입니다.
 * 수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
 * 최솟값이 8보다 크면 -1을 return 합니다.
 * <p>
 * 입출력 예
 * N	number	return
 * 5	12	    4
 * 2	11	    3
 * 입출력 예 설명
 * 예제 #1
 * 문제에 나온 예와 같습니다.
 * <p>
 * 예제 #2
 * 11 = 22 / 2와 같이 2를 3번만 사용하여 표현할 수 있습니다.
 */
public class N으로표현 {
    public static void main(String[] args) {
        System.out.println(dpsolution(5, 12));
        System.out.println(dpsolution(2, 11));
        System.out.println(dpsolution(5, 31168));
    }

    // DP로 풀이
    public static int dpsolution(int n, int number) {
        List<Set<Integer>> answerSetList = new ArrayList<>();
        Set<Integer> newSet = new HashSet<>();
        newSet.add(n);
        answerSetList.add(newSet);
        for (int i = 1; i < 8; i++) { // 8번까지만 DP
            dp(n, i, answerSetList);
        }

        // 만들 수 있는지 검사, 없으면 -1
        for (int i = 0; i < answerSetList.size(); i++) {
            for (Integer answer : answerSetList.get(i)) {
                if (answer == number) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

    private static void dp(int n, int makeCount, List<Set<Integer>> answerSetList) {
        Set<Integer> newSet = new HashSet<>();
        // n번 사용시
        // i, n-i 사용으로 만들기
        for (int j = 0; j < makeCount; j++) {
            Set<Integer> preSet1 = answerSetList.get(j);
            Set<Integer> preSet2 = answerSetList.get(makeCount - j - 1);
            for (Integer integer1 : preSet1) {
                for (Integer integer2 : preSet2) {
                    newSet.add(integer1 + integer2);
                    newSet.add(integer1 - integer2);
                    newSet.add(integer1 * integer2);
                    if(integer2 != 0)
                        newSet.add(integer1 / integer2);
                }
            }
        }
        // n으로만 만들어진 숫자 별도 추가
        int newInt = n;
        for (int j = 0; j < makeCount; j++) {
            newInt = newInt * 10 + n;
        }
        newSet.add(newInt);
        answerSetList.add(newSet);
    }

}

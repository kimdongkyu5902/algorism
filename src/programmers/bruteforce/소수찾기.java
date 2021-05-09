package programmers.bruteforce;

import java.util.HashSet;
import java.util.Set;

/**
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 *
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 *
 * 입출력 예
 * numbers	return
 * "17"	    3
 * "011"	2
 *
 * 입출력 예 설명
 * 예제 #1
 * [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
 *
 * 예제 #2
 * [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
 *
 * 11과 011은 같은 숫자로 취급합니다.
 */
public class 소수찾기 {
    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }
    public static int solution(String numbers) {
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        String result = "";

        // 1 ~ 문자열의 길이만큼 선택하여 숫자 만들기
        for ( int i = 1 ; i <= numbers.length() ; i++) {
            // dfs로 숫자완전 탐색
            selectAndMake(i, set, numbers, visited, result);
        }

        int answer = 0;
        for (Integer integer : set) {
            if(integer < 2)
                continue;
            boolean isOK = true;
            for(int i = 2 ; i <= Math.sqrt(integer) ; i++) {
                if(integer % i == 0) { // 나눠지면 소수가 아님
                    isOK = false;
                    break;
                }
            }
            if(isOK)
                answer++;
        }

        return answer;
    }

    private static void selectAndMake(int count, Set<Integer> set, String numbers, boolean[] visited, String result) {
        if(count == 0) {
            set.add(Integer.parseInt(result));
            return;
        }

        // 미방문한 숫자를 뒤에 쓰기
        // 방문 후 3가지 조건 미방문으로 돌리기
        for( int j = 0 ; j < numbers.length() ; j++) {
            if(!visited[j]) {
                visited[j] = true;
                String tmpResult = result;
                result += numbers.charAt(j);
                count--;
                selectAndMake(count, set, numbers, visited, result);
                count++;
                result = tmpResult;
                visited[j] = false;
            }
        }
    }
}

package programmers.greedy;

import javafx.util.Pair;

import java.util.Stack;

/**
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 * <p>
 * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
 * <p>
 * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
 * <p>
 * 제한 조건
 * number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
 * k는 1 이상 number의 자릿수 미만인 자연수입니다.
 * <p>
 * 입출력 예
 * number	k	return
 * "1924"	2	"94"
 * "1231234"	3	"3234"
 * "4177252841"	4	"775841"
 */

public class 큰수만들기 {
    static String answer = "";

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
        System.out.println(solution("4577252841", 9));
    }

    public static String solution(String number, int k) {
        answer = "";
        findMax(number, k);
        return answer;
    }

    private static void findMax(String number, int count) {
        if (count == 0) {
            answer += number;
            return;
        } else if (count == number.length()) // 마지막 숫자남 남은 경우는 그 뒤의 숫자를 확인하지 않아도 되며 확인할 경우 Exception
            return;

        //버릴 수 있는 수 + 1 까지의 숫자중 가장 큰수를 확인
        String subNumber = number.substring(0, count + 1);
        char maxChar = number.charAt(0);
        int maxIdx = 0;
        for (int i = 1; i < subNumber.length(); i++) {
            if (subNumber.charAt(i) > maxChar) {
                maxChar = subNumber.charAt(i);
                maxIdx = i;
            }
        }
        //가장 큰 수를 답에 추가, 그 수 다음 숫자로 재귀
        answer += maxChar;
        number = number.substring(maxIdx + 1);
        count -= maxIdx;
        findMax(number, count);
    }

    public String solution_another(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            // 새로운 숫자가 더 클 경우
            // 버릴 수 있는 만큼, 이전 작은 숫자들이 버려짐
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}

package monthcodetest2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.
 *
 * (), [], {} 는 모두 올바른 괄호 문자열입니다.
 * 만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다. 예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
 * 만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다. 예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
 * 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다. 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * s의 길이는 1 이상 1,000 이하입니다.
 * 입출력 예
 * s	result
 * "[](){}"	3
 * "}]()[{"	2
 * "[)(]"	0
 * "}}}"	0
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 다음 표는 "[](){}" 를 회전시킨 모습을 나타낸 것입니다.
 * x	s를 왼쪽으로 x칸만큼 회전	올바른 괄호 문자열?
 * 0	"[](){}"	O
 * 1	"](){}["	X
 * 2	"(){}[]"	O
 * 3	"){}[]("	X
 * 4	"{}[]()"	O
 * 5	"}[](){"	X
 * 올바른 괄호 문자열이 되는 x가 3개이므로, 3을 return 해야 합니다.
 * 입출력 예 #2
 *
 * 다음 표는 "}]()[{" 를 회전시킨 모습을 나타낸 것입니다.
 * x	s를 왼쪽으로 x칸만큼 회전	올바른 괄호 문자열?
 * 0	"}]()[{"	X
 * 1	"]()[{}"	X
 * 2	"()[{}]"	O
 * 3	")[{}]("	X
 * 4	"[{}]()"	O
 * 5	"{}]()["	X
 * 올바른 괄호 문자열이 되는 x가 2개이므로, 2를 return 해야 합니다.
 * 입출력 예 #3
 *
 * s를 어떻게 회전하더라도 올바른 괄호 문자열을 만들 수 없으므로, 0을 return 해야 합니다.
 * 입출력 예 #4
 *
 * s를 어떻게 회전하더라도 올바른 괄호 문자열을 만들 수 없으므로, 0을 return 해야 합니다.
 */
public class 괄호회전하기 {
    /**
     * 해설
     *
     * 문자열을 검사하면서 여는 괄호가 나오면 push
     * 닫는 괄호가 나오면 pop
     * 매칭되지 않는다면 실패처리, 마지막에 스택이 비어있다면 성공
     *
     * 이것은 문자열을 큐로 회전하여 반복
     *
     * 복잡도 n2
     *
     */
    public static void main(String[] args) {
        String s = "}]()[{";
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0 ; i < s.length() ; i++) {
            queue.add(s.charAt(i));
        }

        int answer = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            answer += stringTest(queue);
            queue.add(queue.poll());
        }
        System.out.println(answer);
    }

    private static int stringTest(Queue<Character> queue) {
        Stack<Character> stack = new Stack<>();
        System.out.println(queue);
        for (Character character : queue) {
            System.out.println(stack);
            if(character.equals(')'))
                if(stack.isEmpty() || !stack.peek().equals('('))
                    return 0;
                else
                    stack.pop();
            if(character.equals('}'))
                if(stack.isEmpty() || !stack.peek().equals('{'))
                    return 0;
                else
                    stack.pop();
            if(character.equals(']'))
                if(stack.isEmpty() || !stack.peek().equals('['))
                    return 0;
                else
                    stack.pop();
            if(character.equals('(') || character.equals('{') || character.equals('['))
                stack.add(character);
        }
        if(stack.isEmpty())
            return 1;
        else
            return 0;
    }
}

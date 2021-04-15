package programmers.dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
 * 각 숫자는 1 이상 50 이하인 자연수입니다.
 * 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
 *
 * 입출력 예
 * numbers	        target	return
 * [1, 1, 1, 1, 1]	3	    5
 */
public class 타겟넘버 {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        List<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }
        int tmp = 0;
        int idx = -1;
        int result = findSolution(list, idx, tmp, target);
        System.out.println(result);
    }

    private static int findSolution(List<Integer> list, int idx, int tmp, int target) {
        idx++;
        if(idx == list.size()) { // 주어진 숫자를 모두 사용했다면 return
            if(tmp == target)
                return 1; // target과 일치하면 횟수 추가
            return 0;
        }
        // 다음 idx의 숫자를 + / - 할 수 있도록 2가지 실행
        return findSolution(list, idx,tmp + list.get(idx), target) + findSolution(list, idx, tmp - list.get(idx), target);
    }
}

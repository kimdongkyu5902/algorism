package programmers.dp;

import com.sun.org.apache.bcel.internal.generic.IXOR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 * <p>
 * 위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.
 * <p>
 * 삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.
 * <p>
 * 제한사항
 * 삼각형의 높이는 1 이상 500 이하입니다.
 * 삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.
 * <p>
 * 입출력 예
 * triangle	result
 * [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	30
 */
public class 정수삼각형 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    public static int solution(int[][] triangle) {
        List<int[]> layers = Arrays.asList(triangle);
        int[][] dpArray = new int[triangle.length][triangle.length];

        for (int i = 0; i < triangle.length - 1; i++) { // 초기값 설정, 삼각형 맨 아래
            dpArray[triangle.length - 1][i] = triangle[triangle.length - 1][i];
        }
        int layer = layers.size() - 1;
        dp(layers, dpArray, layer);

        return dpArray[0][0];
    }

    private static void dp(List<int[]> layers, int[][] dpArray, int layer) {
        if (layer == 0) {
            return;
        }
        // n층의 선택지 i, i+1 번째 수 중에서 더 큰수를
        // n-1층의 숫자에 더하기
        int[] blocks = layers.get(layer - 1);
        for (int i = 0; i < blocks.length; i++) {
            int max = Math.max(dpArray[layer][i], dpArray[layer][i + 1]);
            dpArray[layer - 1][i] = layers.get(layer - 1)[i] + max;
        }

        dp(layers, dpArray, --layer);
    }

    public static int solution2(int[][] triangle) {
        List<int[]> layers = Arrays.asList(triangle);
        int tmpLayer = 0;
        int idx = 0;
        List<Stack<Integer>> answerList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        dfs2(layers, tmpLayer, idx, answerList, stack);

        int sum = 0;
        int max = 0;
        for (Stack<Integer> integers : answerList) {
            sum = 0;
            for (Integer integer : integers) {
                sum += integer;
            }
            if (sum > max)
                max = sum;
        }
        return max;
    }

    private static void dfs2(List<int[]> layers, int tmpLayer, int idx, List<Stack<Integer>> answerList, Stack<Integer> stack) {
        if (tmpLayer == layers.size()) {
            // 마지막층까지 검사했으면 결과 리스트에 추가
            Stack<Integer> newStack = new Stack<>();
            newStack.addAll(stack);
            answerList.add(newStack);
            return;
        }

        // dfs로 왼쪽부터 스택에 넣기
        int[] blocks = layers.get(tmpLayer);
        stack.add(blocks[idx]);
        dfs2(layers, ++tmpLayer, idx, answerList, stack);
        tmpLayer--;
        stack.pop();
        // 오른쪽 검사할 수 있으면, 검사
        if (idx + 1 < blocks.length) {
            stack.add(blocks[idx + 1]);
            dfs2(layers, ++tmpLayer, ++idx, answerList, stack);
            tmpLayer--;
            stack.pop();
        }
    }
}

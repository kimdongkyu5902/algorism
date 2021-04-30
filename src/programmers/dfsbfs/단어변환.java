package programmers.dfsbfs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
 *
 * 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
 * 2. words에 있는 단어로만 변환할 수 있습니다.
 * 예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
 *
 * 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 각 단어는 알파벳 소문자로만 이루어져 있습니다.
 * 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
 * words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
 * begin과 target은 같지 않습니다.
 * 변환할 수 없는 경우에는 0를 return 합니다.
 *
 * 입출력 예
 * begin	target	words	                                    return
 * "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
 * "hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	        0
 *
 * 입출력 예 설명
 * 예제 #1
 * 문제에 나온 예와 같습니다.
 *
 * 예제 #2
 * target인 "cog"는 words 안에 없기 때문에 변환할 수 없습니다.L
 */
public class 단어변환 {
    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
    private static int solution(String begin, String target, String[] words) {
        List<String> wordList = new ArrayList<>();
        for (String word : words) {
            wordList.add(word);
        }

        //원하는 단어 없으면 탈출
        if(!wordList.contains(target))
            return 0;

        //dfs핵심
        boolean[] visited = new boolean[words.length];

        int result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        dfs(begin, target, wordList, visited, result, queue);

        //결과가 없다면 0
        if(queue.isEmpty())
            return 0;
        else
            return queue.peek();
    }

    private static void dfs(String begin, String target, List<String> wordList, boolean[] visited, int result, PriorityQueue<Integer> queue) {
        //변환된경우 탈출
        if(begin.equals(target)) {
            queue.offer(result);
            return;
        }

        //이미 더 짧은 경로가 있다면 탈출
        if(!queue.isEmpty() && queue.peek() < result)
            return;

        for(int i = 0 ; i < wordList.size() ; i++){
            //방문하지 않고, 변환가능한 경우에만 변환처리
            if(!visited[i] && changable(begin, wordList.get(i))) {
                visited[i] = true;
                dfs(wordList.get(i), target, wordList, visited, ++result, queue);
                visited[i] = false;
                result--;
            }
        }
    }

    private static boolean changable(String begin, String word) {
        int diff = 0;
        for(int i = 0 ; i < begin.length() ; i++){
            if(begin.charAt(i) != word.charAt(i))
                diff++;
        }
        if(diff == 1)
            return true;
        else
            return false;
    }
}

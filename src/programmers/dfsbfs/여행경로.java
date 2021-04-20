package programmers.dfsbfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
 *
 * 항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 모든 공항은 알파벳 대문자 3글자로 이루어집니다.
 * 주어진 공항 수는 3개 이상 10,000개 이하입니다.
 * tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
 * 주어진 항공권은 모두 사용해야 합니다.
 * 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
 * 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
 *
 * 입출력 예
 * tickets	                                                                        return
 * [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	                                ["ICN", "JFK", "HND", "IAD"]
 * [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
 *
 * 입출력 예 설명
 * 예제 #1
 *
 * ["ICN", "JFK", "HND", "IAD"] 순으로 방문할 수 있습니다.
 *
 * 예제 #2
 *
 * ["ICN", "SFO", "ATL", "ICN", "ATL", "SFO"] 순으로 방문할 수도 있지만 ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] 가 알파벳 순으로 앞섭니다.
 */
public class 여행경로 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}}));
        System.out.println(solution(new String[][]{{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}}));
    }

    private static String[] solution(String[][] tickets) {
        List<String[]> ticketList = Arrays.stream(tickets).collect(Collectors.toList());

        Queue<String> queue = new LinkedList<>();
        List<Queue<String>> resultList = new ArrayList<>();
        find(resultList, ticketList, queue, "ICN");

        for (Queue<String> stringQueue : resultList) {
            for (String s : stringQueue) {
                System.out.println(s);
            }

        }

        return new String[]{"test"};
    }

    private static void find(List<Queue<String>> resultList, List<String[]> ticketList, Queue<String> queue, String start) {
        int i = 0;
        for(i = 0 ; i < ticketList.size() ; i++) {
            if(ticketList.get(i)[0].equals(start)) {
                String[] strings = ticketList.get(i);
                queue.add(strings[0]);
                ticketList.remove(i);
                if(ticketList.size() == 0) {
                    queue.add(strings[1]);
                    resultList.add(queue);
                }
                find(resultList, ticketList, queue, strings[1]);
            }
        }
    }
}

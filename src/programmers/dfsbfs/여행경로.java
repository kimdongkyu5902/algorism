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
        String result = ""; // 1가지 결과를 sort하기 쉽게 문자열로 받기
        List<String> resultList = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];  // 방문 유무 검사
        int count = 0;
        find(count, tickets, result, visited, "ICN", resultList);
        return resultList.stream().sorted().collect(Collectors.toList()).get(0).split(",");
    }

    private static void find(int count, String[][] tickets, String result, boolean[] visited, String start, List<String> resultList) {
        for (int i = 0 ; i < tickets.length ; i++) {
            if(!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                String tmpResult = result;
                result += tickets[i][0] + ",";
                if(count == tickets.length - 1) {
                    result += tickets[i][1]; // 마지막 자리 추가
                    resultList.add(result); // 1가지 결과 저장
                    visited[i] = false; // 끝난 뒤 재사용위해 비우기
                    return;
                }
                find(count + 1, tickets, result, visited, tickets[i][1], resultList);
                visited[i] = false; // 다음 방문시 재사용위해 비우기
                result = tmpResult; // 다음 방문에서 이전 결과로 회귀
            }
        }
        return;
    }
}

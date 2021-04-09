package programmers.hash;

import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 문제 설명
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 *
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 * 입출력 예
 * participant	                                        completion	                                return
 * ["leo", "kiki", "eden"]	                            ["eden", "kiki"]	                        "leo"
 * ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
 * ["mislav", "stanko", "mislav", "ana"]	            ["stanko", "ana", "mislav"]	                "mislav"
 * 입출력 예 설명
 * 예제 #1
 * "leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
 *
 * 예제 #2
 * "vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
 *
 * 예제 #3
 * "mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.
 */
public class 완주하지못한선수 {
    public void solution2() {
        String[] participants = {"mislav", "stanko", "mislav", "ana"};
        String[] completions = {"stanko", "ana", "mislav"};
        Arrays.sort(participants);
        Arrays.sort(completions);
        int i;
        String result;
        for ( i = 0 ; i < completions.length; i++ ) {
            if(!participants[i].equals(completions[i]))
                result = participants[i];
        }
        result = participants[i];
        System.out.println(result);
    }

    public static void main(String[] args) {
        List<String> participants = Arrays.asList("mislav", "stanko", "mislav", "ana");
        List<String> completions = Arrays.asList("stanko", "ana", "mislav");

        Map<String, Integer> hashMap = new HashMap<>();

        for(String participant : participants){
            hashMap.put(participant, hashMap.getOrDefault(participant, 0) + 1);
        }

        for(String completion : completions) {
            hashMap.put(completion, hashMap.get(completion) -1 );
        }

        String result = "";
        for(String key : hashMap.keySet()) {
            if(hashMap.get(key) != 0)
                result = key;
        }
        System.out.println(result);
    }
}

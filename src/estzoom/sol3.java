package estzoom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sol3 {
    public static void main(String[] args) {
        String[] solution = solution(new String[]{"C", "SWIFT", "JAVA", "SWIFT", "JAVA", "JAVA", "R"}, new int[][]{{65, 80, 90}, {46, 100, 70}, {91, 96, 59}, {89, 90, 61}, {0, 94, 75}, {38, 95, 47}, {50, 60, 90}});
        for (String s : solution) {
            System.out.println(s);
        }

        String[] solution1 = solution(new String[]{"A", "AAA", "AA"}, new int[][]{{100, 50, 0, 30}, {100, 50, 0, 25}, {100, 50, 0, 30}});
        for (String s : solution1) {
            System.out.println(s);
        }
    }

    public static String[] solution(String[] languages, int[][] scores) {
        int langCount = scores[0].length;
        List<Map<String, Long>> langScoreMapList = new ArrayList<>();
        for (int i = 0; i < langCount; i++) {
            Map<String, Long> langScoreMap = new HashMap<>();
            for (int j = 0; j < languages.length; j++) {
                langScoreMap.put(languages[j], langScoreMap.getOrDefault(languages[j], 0L) + scores[j][i]);
            }
            langScoreMapList.add(langScoreMap);
        }

        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < languages.length; i++) {
            count.put(languages[i], count.getOrDefault(languages[i], 0) + 1);
        }

        for (Map<String, Long> map : langScoreMapList) {
            for (String key : count.keySet()) {
                map.put(key, map.get(key) / count.get(key));
            }
        }

        List<String> answerList = new ArrayList<>();
        for (Map<String, Long> map : langScoreMapList) {
            sortAnswer(map, count, answerList);
        }

        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    private static void sortAnswer(Map<String, Long> map, Map<String, Integer> count, List<String> answerList) {
        long max = -1;
        String maxName = "";
        for (String key : map.keySet()) {
            if (max < map.get(key)) {
                max = map.get(key);
                maxName = key;
            } else if (map.get(key) == 0 && max == -1) {
                max = map.get(key);
                maxName = key;
            } else if (max == map.get(key)) {
                if (count.get(key) > count.get(maxName)) {
                    max = map.get(key);
                    maxName = key;
                } else if (count.get(key) == count.get(maxName)) {
                    if (maxName.compareTo(key) < 0) {
                        max = map.get(key);
                        maxName = key;
                    }
                }
            }
        }
        answerList.add(maxName);
    }
}

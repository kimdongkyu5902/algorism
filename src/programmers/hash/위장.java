package programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 *
 */
public class 위장 {
    // stream 풀이... 대단
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int result = 1;
        Map<String, Integer> map = new HashMap<>();

        for(String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        // + 1 은 안입는 경우
        for(int count : map.values()) {
            result *= (count + 1);
        }

        // - 1 은 아무것도 안입는 경우
        System.out.printf(result - 1 + "");
    }

}

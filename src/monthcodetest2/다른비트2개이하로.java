package monthcodetest2;

/**
 * 양의 정수 x에 대한 함수 f(x)를 다음과 같이 정의합니다.
 *
 * x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
 * 예를 들어,
 *
 * f(2) = 3 입니다. 다음 표와 같이 2보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 3이기 때문입니다.
 * 수	비트	다른 비트의 개수
 * 2	000...0010
 * 3	000...0011	1
 * f(7) = 11 입니다. 다음 표와 같이 7보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 11이기 때문입니다.
 * 수	비트	다른 비트의 개수
 * 7	000...0111
 * 8	000...1000	4
 * 9	000...1001	3
 * 10	000...1010	3
 * 11	000...1011	2
 * 정수들이 담긴 배열 numbers가 매개변수로 주어집니다. numbers의 모든 수들에 대하여 각 수의 f 값을 배열에 차례대로 담아 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 1 ≤ numbers의 길이 ≤ 100,000
 * 0 ≤ numbers의 모든 수 ≤ 1015
 *
 * 입출력 예
 * numbers	result
 * [2,7]	[3,11]
 */
public class 다른비트2개이하로 {
    public static void main(String[] args) {
        long[] solution = solution(new long[]{2, 7});
        for (long l : solution) {
            System.out.println(l);
        }
    }

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0 ; i < numbers.length ; i++) {
            if(numbers[i] % 2 == 0) // 짝수는 + 1로 조건충족
                answer[i] = numbers[i] + 1;
            else
                answer[i] = find(numbers[i]);
        }
        return answer;
    }

    private static long find(Long number) {
        //홀수에서 오른쪽 첫번째 0 나올 떄 -> 해당 자리를 1, 그 전 자리를 0으로 바꾸면 댄다
        //0 없다면 -> 맨앞자리 자리 수 1 그 뒤자리 0
        long tmpNumber = number;
        long pointNumber = 1; // 자리수의 크기
        long amount = 0;
        while (true) {
            if (number == 0 || number % 2 ==0) { // 0 없거나 ,홀수에서 오른쪽 첫번째 0 나올 떄
                amount += pointNumber / 2;
                break;
            }
            number = number >> 1;
            pointNumber *= 2;
        }

        return tmpNumber + amount;
    }
}

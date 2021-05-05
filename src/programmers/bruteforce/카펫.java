package programmers.bruteforce;

/**
 * Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
 * <p>
 * Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
 * <p>
 * Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한사항
 * 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
 * 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
 * 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
 * <p>
 * 입출력 예
 * brown	yellow	return
 * 10	    2	    [4, 3]
 * 8	    1	    [3, 3]
 * 24	    24	    [8, 6]
 */
public class 카펫 {
    public static void main(String[] args) {
        solution(10, 2);
        solution(8, 1);
        solution(24, 24);
    }

    public static int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int a, b;
        int tot = brown + red;

        //세로의 길이가 더 작으므로, 세로의 길이는 3 ~ 루트tot
        for (int i = 3; i <= Math.sqrt(tot); i++) {
            //세로의 길이로 나눠질 경우만
            if (tot % i == 0) {
                int check_brown = 0;
                a = tot / i; // 가로
                b = i; // 세로
                //가장자리의 개수부터 더하면서 비교
                //a -> a-1 , b -> b - 1 대입 --> 안으로 들어 갈 수록 8씩 감소
                for (int round = 2 * (a + b) - 4; round > 0; round -= 8) {
                    check_brown += round;
                    if (check_brown == brown) {
                        answer[0] = a;
                        answer[1] = b;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}

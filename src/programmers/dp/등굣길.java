package programmers.dp;

/**
 * 계속되는 폭우로 일부 지역이 물에 잠겼습니다. 물에 잠기지 않은 지역을 통해 학교를 가려고 합니다. 집에서 학교까지 가는 길은 m x n 크기의 격자모양으로 나타낼 수 있습니다.
 *
 * 가장 왼쪽 위, 즉 집이 있는 곳의 좌표는 (1, 1)로 나타내고 가장 오른쪽 아래, 즉 학교가 있는 곳의 좌표는 (m, n)으로 나타냅니다.
 *
 * 격자의 크기 m, n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이 매개변수로 주어집니다. 오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 격자의 크기 m, n은 1 이상 100 이하인 자연수입니다.
 * m과 n이 모두 1인 경우는 입력으로 주어지지 않습니다.
 * 물에 잠긴 지역은 0개 이상 10개 이하입니다.
 * 집과 학교가 물에 잠긴 경우는 입력으로 주어지지 않습니다.
 *
 * 입출력 예
 * m   n   puddles   return
 * 4   3   [[2, 2]]   4
 */
public class 등굣길 {
    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2, 4}}));
        System.out.println(solution(4, 3, new int[][]{{2, 2}}));
        System.out.println(solution(10, 12, new int[][]{{2, 2},{4,6},{1,9},{10,1}}));
    }

    //문제에서의 m/n 반대로 된거 유의
    public static int solution(int m, int n, int[][] puddles) {
        int[][] path = new int[n][m];

        // 물덩이 -1로 표시
        for (int[] puddle : puddles) {
            path[puddle[0] - 1][puddle[1] - 1] = -1;
        }

        // 우측/아래측 경우의 수 1로 표시. 단, 물덩이 있다면 중료
        for (int i = 1 ; i < m ; i++){
            if(path[0][i] == -1)
                break;
            path[0][i] = 1;
        }
        for (int i = 1 ; i < n ; i++){
            if(path[i][0] == -1)
                break;
            path[i][0] = 1;
        }

        // 좌상단부터 순회하며
        // 현재 경로는, 좌측/위쪽 위 숫자를 더한 경우의 수. 단, 물덩이가 없다면
        for (int i = 1 ; i < n ; i++){
            for (int j = 1 ; j < m ; j++) {
                if(path[i][j] == -1)
                    continue;
                if (path[i-1][j] != -1)
                    path[i][j] += path[i-1][j];
                if (path[i][j-1] != -1)
                    path[i][j] += path[i][j-1];
            }
        }

        for (int[] ints : path) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        // 문제에서의 나머지값 확인
        return path[n-1][m-1] % 1000000007;
    }
}
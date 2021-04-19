package programmers.dfsbfs;

/**
 * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다. 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
 * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
 *
 * 제한사항
 * 컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
 * 각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
 * i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
 * computer[i][i]는 항상 1입니다.
 *
 * 입출력 예
 * n	computers	                        return
 * 3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
 * 3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
 *
 * 입출력 예 설명
 * 예제 #1
 * 1 - 2  3
 *
 * 예제 #2
 * 1 - 2 - 3
 */
public class 네트워크 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0},{1, 1, 0},{0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    private static int solution(int n, int[][] computers) {
        //방문 체크
        boolean[] check = new boolean[computers.length];
        int count = 0;
        for(int i = 0 ; i < computers.length ; i++) {
            //방문한 곳이 아닌곳 중 네트워크 전체 스캔
            if(!check[i]) {
                dfs(computers, i, check);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] computers, int i, boolean[] check) {
        //방문표시
        check[i] = true;

        // 다른 곳에서 체크하지 않앗다면 그곳에서 다시 전체 스캔
        for (int j = 0 ; j < computers.length ; j++) {
            if( i != j && computers[i][j] == 1 && check[j] == false)
                dfs(computers, j, check);
        }
    }

}

package devmach202103;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProTest2 {

    public static int change(int[][] matrix, int[] query){
        List<Integer> list = new ArrayList<>();
        // 위 우로
        int saveNum = matrix[query[0]-1][query[1] -1];
        list.add(saveNum);
        for(int i = query[1] ; i < query[3] ; i++) {
            int tmpNum = matrix[query[0]-1][i];
            matrix[query[0]-1][i] = saveNum;
            saveNum = tmpNum;
            list.add(saveNum);
        }

        // 오 아래로
        // 아래 좌로 22 54
        //              2           4
        for(int i = query[0] ; i < query[2] ; i++){
            int tmpNum = matrix[i][query[3]-1];
            matrix[i][query[3]-1] = saveNum;
            saveNum = tmpNum;
            list.add(saveNum);
        }

        // 아래 좌로 22 54
        //               2              0
        for(int i = query[3] - 2 ; i > query[1] - 2 ; i--) {
            int tmpNum = matrix[query[2]-1][i];
            matrix[query[2]-1][i] = saveNum;
            saveNum = tmpNum;
            list.add(saveNum);
        }
        //               4               2
        for(int i = query[2] -2 ; i > query[0] -2 ; i--){
            int tmpNum = matrix[i][query[1]-1];
            matrix[i][query[1]-1] = saveNum;
            saveNum = tmpNum;
            list.add(saveNum);
        }

        Optional<Integer> optresult = list.stream().sorted().findFirst();
        int result = optresult.get();
        System.out.println(result);

        return result;
    }

    //6 6  2 2 5 4
    //3	3	[[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]]	[1, 1, 5, 3]
    public static void main(String[] args) {
      int rows= 6;
      int columns= 6;
      int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        System.out.println(queries.length);
      int[][] matrix = new int[rows][columns];

      int num=1;
      for(int i = 0; i < rows ; i++) {
          for(int j = 0; j < columns ; j++){
              matrix[i][j] = num++;
          }
      }

        List<Integer> resultList = new ArrayList<>();
      for(int[] query : queries) {
          int rst = change(matrix, query);
          resultList.add(rst);
      }


      int [] radsf = new int[resultList.size()];
      for(int i = 0 ; i <resultList.size() ; i++) {
          System.out.println(resultList.get(i));
          radsf[i] = resultList.get(i);
      }
        System.out.println(radsf[0]);

      for(int i = 0; i < rows ; i++) {
          for(int j = 0; j < columns ; j++){
              System.out.print(matrix[i][j] + " ");
          }
          System.out.println();
      }
    }
}

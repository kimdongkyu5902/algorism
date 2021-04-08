package devmach202103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test6 {

    public static void task(int[][] boxs, int row, int col, int x, int y,Long sum,List<Long> list){
        sum = sum + boxs[y][x];

        if(y+1 < row)
            task(boxs, row, col, x, y+1, sum, list);
        if(x+1 < col)
            task(boxs, row, col, x+1, y, sum, list);

        if(x+1==col || y+1 ==row)
            list.add(sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArr = str.split(" ");
        int intRowCount = Integer.parseInt(strArr[1]);
        int intColCount = Integer.parseInt(strArr[0]);

        int[][] boxs = new int[intRowCount][intColCount];
        String line;

        for (int i = 0; i < intRowCount; i++) {
            line = br.readLine();
            line = line.replaceAll(" ","");
            for (int j = 0; j < intColCount; j++) {
                boxs[i][j] = Integer.parseInt(""+line.charAt(j));
            }
        }
        List<Long> list = new ArrayList<>();
        task(boxs, intRowCount, intColCount, 0, 0, 0L, list);

        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
    }

}

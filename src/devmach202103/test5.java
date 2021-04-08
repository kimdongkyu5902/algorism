package devmach202103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test5 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArr = str.split(" ");
        int intColCount = Integer.parseInt(strArr[0]);
        int intRowCount = Integer.parseInt(strArr[1]);


        String[][] boxs = new String[intRowCount][intColCount];
        String line;

        List<Integer> xposList = new ArrayList<>();
        List<Integer> yposList = new ArrayList<>();

        for (int i = 0; i < intRowCount; i++) {
            line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                boxs[i][j] = "" + line.charAt(j);
                if(("" + line.charAt(j)).equals("c")){
                    xposList.add(i);
                    yposList.add(j);
                }
            }
        }





    }
}

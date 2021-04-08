package devmach202103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class test3 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String count = br.readLine();
        int intCount = Integer.parseInt(count);

        int[][] boxs = new int[intCount][intCount];
        String line;

        for (int i = 0; i < intCount; i++) {
            line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                boxs[i][j] = Integer.parseInt("" + line.charAt(j));
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int objectSize = 1; objectSize <= intCount; objectSize++) {
            int solution = 0;
            for (int i = 0; i < intCount - objectSize ; i++) {
                for (int j = 0; j < intCount - objectSize ; j++) {
                    boolean isOk = true;
                    if(boxs[i][j] == 1) {
                        for (int x = 0; x < objectSize; x++) {
                            for (int y = 0; y < objectSize; y++) {
                                if (boxs[i + x][j + y] != 1) {
                                    isOk = false;
                                    break;
                                }
                            }
                            if(!isOk)
                                break;
                        }
                        if(isOk)
                            solution++;
                    }
                }
            }
            map.put(objectSize, solution);
        }

        int totSolution = 0;
        for(int i = 1 ; i <= intCount ; i++) {
            totSolution += map.get(i);
        }
        System.out.println("total: " + totSolution);

        for(int i = 1 ; i <= intCount ; i++) {
            if( map.get(i) != 0)
                System.out.println("size[" + i + "]: "+ map.get(i));
        }

    }
}

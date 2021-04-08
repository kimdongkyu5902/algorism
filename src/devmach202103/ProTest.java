package devmach202103;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProTest {


	//[45, 4, 35, 20, 3, 9], [20, 9, 3, 45, 4, 35]
    //기댓값 〉	[1, 1]
    public static void main(String[] args) {
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums = {20, 9, 3, 45, 4, 35};

        int low = 0;
        int high = 0;
        int match = 0;

        for(int lotto : lottos){
            if(lotto == 0)
                high++;
            for(int winNum : win_nums){
                if(lotto == winNum)
                    match++;
            }
        }

        low = 7-match;
        high += match;
        high = 7-high;

        if( low == 7)
            low =6;
        if( high == 7)
            high = 6;

        int[] answer = {high, low};

        System.out.println(low);
        System.out.println(high);

    }
}

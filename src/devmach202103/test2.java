package devmach202103;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class test2 {
    public static int fact(int n) {
        if (n == 0)
            return 1;
        else if (n < 1)
            return n;
        else
            return fact(n-1) * n;
    }
    public static int combination(int a, int b) {
        return fact(a)/fact(b)/fact(a-b);
    }
    public static int check(int size) {
        int maxDoubleCount = (size-1) / 2;

        int count = 1;
        for(int i = 1 ; i <= maxDoubleCount ; i++) {
            count += combination(size-1-i, i);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String count = br.readLine();
        int intCount = Integer.parseInt(count);
        String arrys = br.readLine();

        List<String> strList = Arrays.asList(arrys.split("0"));
        int sol = 1;
        for(String str :strList) {
            sol *= check(str.length());
        }
        System.out.println(sol);
    }
}
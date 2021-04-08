package devmach202103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String count = br.readLine();
        int intCount = Integer.parseInt(count);
        String time;
        List<LocalDateTime> startTimeList = new ArrayList<>();
        List<LocalDateTime> endTimeList = new ArrayList<>();

        for(int i = 0 ; i < intCount ; i++) {
            time = br.readLine();
            String[] times = time.split(" ~ ");

            startTimeList.add(LocalDateTime.parse("20210320"+times[0].replace(":","") , DateTimeFormatter.ofPattern("yyyyMMddHHmm")));
            endTimeList.add(LocalDateTime.parse("20210320"+times[1].replace(":","") , DateTimeFormatter.ofPattern("yyyyMMddHHmm")));
        }
        Collections.sort(startTimeList);
        Collections.sort(endTimeList);

        LocalDateTime startableTime = startTimeList.get(intCount - 1);
        LocalDateTime endableTime = endTimeList.get(0);

        System.out.println(startableTime.format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println(endableTime.format(DateTimeFormatter.ofPattern("HH:mm")));

        if(endableTime.isAfter(startableTime)) {
            System.out.println(startableTime.getHour() + ":" + startableTime.getMinute() + " ~ " + endableTime.getHour() + ":" + endableTime.getMinute());
        }
        else {
            System.out.println("-1");
        }


        System.out.println(startTimeList);
        System.out.println(endTimeList);
    }
}


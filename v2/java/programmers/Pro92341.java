package programmers;

import java.util.*;

public class Pro92341 {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> m = new HashMap<>();
        Map<String, Integer> ans = new TreeMap<>();

        for (String record : records) {
            String[] tmp = record.split("\\s");
            String time = tmp[0];
            String carNum = tmp[1];
            String inOrOut = tmp[2];

            if (inOrOut.equals("IN")) {
                m.put(carNum, time);
                continue;
            }

            String inTime = m.get(carNum);
            int remain = getRemainingMins(inTime, time);

            if (ans.containsKey(carNum)) ans.put(carNum, ans.get(carNum) + remain);
            else ans.put(carNum, remain);
            m.remove(carNum);
        }

        // 출차 기록이 없는 경우
        for (String carNum : m.keySet()) {
            String inTime = m.get(carNum);
            int remain = getRemainingMins(inTime, "23:59");

            if (ans.containsKey(carNum)) ans.put(carNum, ans.get(carNum) + remain);
            else ans.put(carNum, remain);
        }

        PriorityQueue<String[]> pq = new PriorityQueue<>((s1, s2) -> s1[0].compareTo(s2[0]));

        for (String carNum : ans.keySet()) {
            pq.add(new String[] { carNum, String.valueOf(ans.get(carNum)) });
        }

        int[] answer = new int[ans.size()];
        int idx = 0;

        while (!pq.isEmpty()) {
            int k = Integer.parseInt(pq.poll()[1]);
            if (k <= fees[0]) answer[idx] = fees[1];
            else {
                int total = fees[1];

                if ((k - fees[0]) % fees[2] != 0) {
                    int r = ((k - fees[0]) / fees[2]) + 1;
                    total += r * fees[3];
                } else {
                    int r = (k - fees[0]) / fees[2];
                    total += r * fees[3];
                }
                answer[idx] = total;
            }

            idx++;
        }

        return answer;
    }

    int getRemainingMins(String inTime, String outTime) {
        String[] s1 = inTime.split(":");
        String[] s2 = outTime.split(":");

        int hours = Integer.parseInt(s2[0]) - Integer.parseInt(s1[0]);
        int mins = Integer.parseInt(s2[1]) - Integer.parseInt(s1[1]);

        if (mins < 0) {
            mins += 60;
            hours--;
        }

        return hours * 60 + mins;
    }
}

package kakao;

import java.util.*;

public class p1 {
    // 이름에 따른 인덱스 번호 리턴
    static Map<String, Integer> map;

    // 사람에 따른 선물 지수를 저장
    static int[][] arr;

    public int solution(String[] friends, String[] gifts) {
        map = new HashMap<>();
        int size = friends.length;

        for (int i = 0; i < size; i++) {
            map.put(friends[i], i);
        }

        arr = new int[size][size];

        for (int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            int fromIdx = map.get(gift[0]);
            int toIdx = map.get(gift[1]);

            arr[fromIdx][toIdx]++;
        }

        int[] present = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int presentIdx = 0;

            for (int j = 0; j < arr[i].length; j++) {
                presentIdx += arr[i][j];
                presentIdx -= arr[j][i];
            }

            present[i] = presentIdx;
        }

        int[] ans = new int[size];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != arr[j][i]) {
                    if (arr[i][j] > arr[j][i]) ans[i]++;
                    else if (arr[i][j] < arr[j][i]) ans[j]++;
                }

                else {
                    if (present[i] > present[j]) ans[i]++;
                    else if (present[j] > present[i]) ans[j]++;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < ans.length; i++) {
            answer = Math.max(answer, ans[i]);
        }

        return answer / 2;
    }
}
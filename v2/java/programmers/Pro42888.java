package programmers;

import java.util.*;

class Pro42888 {
    public String[] solution(String[] record) {
        Map<String, String> m = new HashMap<>();

        for (String s : record) {
            String[] tmp = s.split("\\s");
            String cond = tmp[0];
            String uid = tmp[1];

            if (cond.equals("Enter") || cond.equals("Change")) {
                m.put(uid, tmp[2]);
            }
        }

        List<String> lst = new ArrayList<>();

        for (String rec : record) {
            String[] tmp = rec.split("\\s");
            String cond = tmp[0];
            String uid = tmp[1];

            if (cond.equals("Enter")) {
                lst.add(m.get(uid) + "님이 들어왔습니다.");
            } else if (cond.equals("Leave")) {
                lst.add(m.get(uid) + "님이 나갔습니다.");
            }
        }

        String[] ans = new String[lst.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = lst.get(i);
        }

        return ans;
    }
}
package part1.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj13223 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] teacher = br.readLine().split(":");
        String[] robot = br.readLine().split(":");
        String[] ans = new String[3];

        for (int i = 2; i >= 0; i--) {
            int t = Integer.parseInt(teacher[i]);
            int r = Integer.parseInt(robot[i]);

            if (t > r) {
                if (i == 0) r += 24;
                else {
                    r += 60;
                    robot[i - 1] = String.valueOf(Integer.parseInt(robot[i - 1]) - 1);
                }
            }

            int v = r - t;
            if (v / 10 == 0) ans[i] = "0" + v;
            else ans[i] = String.valueOf(v);
        }

        String time = String.join(":", ans);
        if (time.equals("00:00:00")) time = "24:00:00";

        System.out.println(time);
        br.close();
    }
}

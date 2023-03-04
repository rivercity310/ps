import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ25206 {
    static int n = 20;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        double sum = 0;
        double gpSum = 0;

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("\\s");

            double gp = Double.parseDouble(tmp[1]);
            String grade = tmp[2];

            if (grade.equals("P")) continue;

            double point;

            switch (grade) {
                case "A+": {
                    point = 4.5;
                    break;
                }
                case "A0": {
                    point = 4.0;
                    break;
                }
                case "B+": {
                    point = 3.5;
                    break;
                }
                case "B0": {
                    point = 3.0;
                    break;
                }
                case "C+": {
                    point = 2.5;
                    break;
                }
                case "C0": {
                    point = 2.0;
                    break;
                }
                case "D+": {
                    point = 1.5;
                    break;
                }
                case "D0": {
                    point = 1.0;
                    break;
                }
                default: point = 0;
            }

            gpSum += gp;
            sum += point * gp;
        }

        System.out.printf("%.6f", sum / gpSum);
    }
}

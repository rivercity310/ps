package BruteForce;

public class PRO42842 {
    public static int[] solution(int brown, int yellow) {
        // yellow 배치에 따라 결정된다

        // yellow 배치 (8)
        // (4, 2), (8, 1) --> 약수 중 큰게 x, 작은게 y

        // brown 배치
        // yellow 배치한 값에 +2 씩

        // yellow의 약수 찾기
        int x = 0;
        int y = 0;
        int s = yellow + brown;

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                x = Math.max(i, yellow / i);
                y = Math.min(i, yellow / i);
            }

            if ((x + 2) * (y + 2) == s) {
                break;
            }
        }

        return new int[] { x + 2, y + 2 };
    }

    public static void main(String[] args) {
        int[] browns = { 10, 8, 24 };
        int[] yellows = { 2, 1, 24 };

        for (int i = 0; i < browns.length; i++) {
            int[] ans = solution(browns[i], yellows[i]);
            System.out.println("ans = " + ans[0] + ", " + ans[1]);
        }
    }
}

public class PRO12985 {
    public static int solution(int n, int a, int b) {
        int ans = 1;
        int y = Math.max(a, b);
        int x = Math.min(a, b);

        while (y - x != 1) {
            x = x % 2 == 0 ? x / 2 : x / 2 + 1;
            y = y % 2 == 0 ? y / 2 : y / 2 + 1;
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(1024, 1021, 1023));
    }
}

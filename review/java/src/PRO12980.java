public class PRO12980 {
    public static int solution(int n) {
        return solve(n);
    }

    private static int solve(int n) {
        if (n == 1) return 1;
        if (n % 2 == 0) return solve(n / 2);
        return solve(n - 1) + 1;
    }

    public static void main(String[] args) {
        int[] t = { 5, 6, 5000, 1000000000 };
        for (int tt : t) System.out.println(solution(tt));
    }
}

package programmers;

class Pro68936 {
    int[] answer;

    public int[] solution(int[][] arr) {
        answer = new int[2];
        solve(arr, 0, 0, arr.length);
        return answer;
    }

    void solve(int[][] arr, int rs, int cs, int n) {
        if (chk(arr, rs, cs, n)) {
            answer[arr[rs][cs]]++;
            return;
        }
        
        n /= 2;

        solve(arr, rs, cs, n);
        solve(arr, rs, cs + n, n);
        solve(arr, rs + n, cs, n);
        solve(arr, rs + n, cs + n, n);
    }

    boolean chk(int[][] arr, int rs, int cs, int len) {
        int k = arr[rs][cs];

        for (int i = rs; i < rs + len; i++) {
            for (int j = cs; j < cs + len; j++) {
                if (arr[i][j] != k) {
                    return false;
                }
            }
        }

        return true;
    }
}

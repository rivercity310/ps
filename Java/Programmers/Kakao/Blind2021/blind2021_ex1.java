package Programmers.Kakao.Blind2021;



public class blind2021_ex1 {
    private static class Solution {
        public String solution(String new_id) {
            return new KakaoID(new_id)
                    .replaceToLowerCase()
                    .filter()
                    .toSingleDot()
                    .emptyCheck()
                    .rangeCheck()
                    .getResult();
        }

        private static class KakaoID {
            private String s;

            KakaoID(String s) { this.s = s; }

            private KakaoID replaceToLowerCase() {
                s = s.toLowerCase();
                return this;
            }

            private KakaoID filter() {
                s = s.replaceAll("[^a-z0-9._-]", "");
                return this;
            }

            private KakaoID toSingleDot() {
                s = s.replaceAll("[.]{2,}", ".")
                        .replaceAll("^[.]|[.]$", "");

                return this;
            }

            private KakaoID emptyCheck() {
                s = s.isEmpty() ? "a" : s;
                return this;
            }

            private KakaoID rangeCheck() {
                if (s.length() > 15) s = s.substring(0, 15);
                s = s.replaceAll("[.]$", "");

                StringBuilder sb = new StringBuilder(s);
                while (sb.length() <= 2)
                    sb.append(sb.charAt(s.length() - 1));

                s = sb.toString();
                return this;
            }

            private String getResult() { return this.s; }
        }
    }

    public static void main(String[] args) {
        String test[] = {
                "...!@BaT#*..y.abcdefghijklm",
                "z-+.^.",
                "=.=",
                "123_.def",
                "abcdefghijklmn.p"
        };

        for (String s : test)
            System.out.println(new Solution().solution(s));
    }
}
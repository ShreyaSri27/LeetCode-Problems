class Solution {
        public String shortestCommonSupersequence(String str1, String str2) {

                String lcs = getLcs(str1, str2);

                int i = 0, j = 0, k = 0;

                String ans = "";

                char ch1[] = str1.toCharArray();
                int len1 = ch1.length;
                char ch2[] = str2.toCharArray();
                int len2 = ch2.length;
                char ch3[] = lcs.toCharArray();
                int len3 = ch3.length;

                while (i < len1 && j < len2 && k < len3) {
                        char ch = ch3[k];

                        for (; i < len1 && ch1[i] != ch; ++i) {
                                ans += ch1[i];

                        }

                        for (; j < len2 && ch2[j] != ch; ++j) {

                                ans += ch2[j];
                        }

                        ans += ch;
                        ++k;
                        ++j;
                        ++i;

                }
                for (; i < len1; ++i)
                        ans += ch1[i];

                for (; j < len2; ++j)
                        ans += ch2[j];

                return ans;

        }

        public String getLcs(String str1, String str2) {

                int n = str1.length();
                int m = str2.length();
                char ch1[] = str1.toCharArray();
                char ch2[] = str2.toCharArray();

                int dp[][] = new int[n + 1][m + 1];

                int i, j;

                for (i = 1; i <= n; ++i) {
                        for (j = 1; j <= m; ++j) {
                                if (ch1[i - 1] == ch2[j - 1])
                                        dp[i][j] = 1 + dp[i - 1][j - 1];
                                else
                                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                        }
                }

                i = n;
                j = m;
                StringBuilder stb = new StringBuilder();

                while (i > 0 && j > 0) {
                        if (ch1[i - 1] == ch2[j - 1]) {
                                stb.append(ch1[i - 1]);
                                --i;
                                --j;
                        } else if (dp[i - 1][j] > dp[i][j - 1])
                                --i;
                        else --j;

                }

                return stb.reverse().toString();

        }
}

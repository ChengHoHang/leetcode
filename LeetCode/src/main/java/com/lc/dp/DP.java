package com.lc.dp;

/**
 * #longestPalindrome
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @author chh
 * @date 2022/2/28 21:29
 */
public class DP {
    
    
//    abcca
//    
//    dp      0       1       2       3       4
//        0   true    false   false
//        1           true
//        2                   true
//        3                           true
//        4                                   true
//    
//    dp[0][1] = (s[0] == s[1])
//    dp[0][2] = (s[0] == s[2])
//    dp[1][2] = (s[1] == s[2])
//    dp[0][3] = (s[0] == s[3]) && dp[1][2]
//    dp[1][3] = (s[1] == s[3])
//    dp[2][3] = (s[2] == s[3])
//    dp[0][4] = (s[0] == s[4]) && dp[1][3]
    
    public String longestPalindrome(String s) {
        // dp[i][j] 表示第i到第j位置的字符是回文字符串
        // dp[i][j] = (s[i] == s[j]) && dp[i+1][j-1]
        // j - 1 - (i + 1) >= 1   条件     j - i >= 3
        if (s.length() <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];

        char[] chars = s.toCharArray();
        int begin = 0, maxLength = 1;
        
        for (int j = 1; j < chars.length; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    // chars[i] == chars[j] 的情况，如果字串长度 == 1就是true
                    if ((j - 1) - (i + 1) < 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j]) {
                    int length = j - i + 1;
                    if (length > maxLength) {
                        begin = i;
                        maxLength = length;
                    }
                }
            }
        }

        return s.substring(begin, begin + maxLength);
    }

    public static void main(String[] args) {
        DP dp = new DP();
        System.out.println(dp.longestPalindrome("aacabdkacaa"));
        System.out.println(dp.longestPalindrome("cbbd"));
    }
}

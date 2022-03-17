package com.lc.dp;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 * @author chh
 * @date 2022/3/14 21:22
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();

        // 定义：dp[i][j] 表示 word1前i个字符转换为 word2前j个字符所需要的最少操作数
        // 则答案为dp[length1 + 1][length2 + 1]

        int[][] dp = new int[length1 + 1][length2 + 1];

        // 初始化边界条件。word2为空时，word1转换为word2所需要的步数; word1同理
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= length2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                dp[i][j] = word1Chars[i - 1] == word2Chars[j - 1] ? dp[i - 1][j - 1] :
                        1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
            }
        }

        return dp[length1][length2];
    }


    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance("horse", "ros"));
        System.out.println(editDistance.minDistance("intention", "execution"));
        System.out.println(editDistance.minDistance("", "a"));
        System.out.println(editDistance.minDistance("asdf", ""));
    }
}

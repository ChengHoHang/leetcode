package com.lc.string;

/**
 * #longestPalindrome
 * @author chh
 * @date 2022/2/28 22:07
 */
public class ExpandAroundCenter {

    public String longestPalindrome(String s) {
        if (s.length() <= 0) {
            return s;
        }

        int begin = 0, end = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int singleCharMaxLength = getPalindromeMaxLength(chars, i, i);
            int doubleCharMaxLength = getPalindromeMaxLength(chars, i, i + 1);
            int maxLength = Math.max(singleCharMaxLength, doubleCharMaxLength);
            if (maxLength > (end - begin + 1)) {
                begin = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }
        return s.substring(begin, end + 1);
    }

    private int getPalindromeMaxLength(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        ExpandAroundCenter expandAroundCenter = new ExpandAroundCenter();
        System.out.println(expandAroundCenter.longestPalindrome("babad"));
    }
}

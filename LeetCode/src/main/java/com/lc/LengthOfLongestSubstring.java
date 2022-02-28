package com.lc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 滑动窗口
 * @author chh
 * @date 2022/2/27 17:36
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring1(String str) {
        if (str.length() <= 1) {
            return str.length();
        }

        Map<Character, Integer> char2LastIndexMap = new HashMap<>();
        
        char[] chars = str.toCharArray();
        int left = 0, right = 0, maxLength = 1;
        for (; right < chars.length; right++) {
            char curChar = chars[right];
            if (char2LastIndexMap.containsKey(curChar)) {
                left = Math.max(char2LastIndexMap.get(curChar) + 1, left);
            }
            maxLength = Math.max(maxLength, right - left + 1);
            char2LastIndexMap.put(curChar, right);
        }

        return maxLength;
    }
    
    
    public int lengthOfLongestSubstring(String str) {
        if (str.length() <= 1) {
            return str.length();
        }

        char[] chars = str.toCharArray();
        
        // 修改左右指针
        int left = 0, right = 0, maxLength = 1;
        while (left <= right && right < chars.length) {
            char curChar = chars[right];
            // 判断窗口内是否包含curChar
            int lastCharIndex = getLastCharIndex(left, right, str, curChar);
            if (lastCharIndex != -1) {
                maxLength = Math.max(maxLength, right - left);
                left = lastCharIndex + 1;
            } else {
                right++;
            }
        }

        return Math.max(maxLength, right - left);
    }

    private int getLastCharIndex(int left, int right, String str, char curChar) {
        if (left == right) {
            return -1;
        }
        String window = str.substring(left, right);
        int index = window.indexOf(curChar);
        if (index != -1) {
            return left + index;
        }
        return -1;
    }


    /**
     * 当前节点（right）在 [left, right) 中有没有重复的
     * @param left
     * @param right
     * @param indexList 有序index
     *                 left 1 2 right 5 
     * @return
     */
    private Integer getLastCharIndex(int left, int right, List<Integer> indexList) {
        if (right == left) {
            return null;
        }

        for (Integer index : indexList) {
            if (index >= left && right > index) {
                return index;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring length = new LengthOfLongestSubstring();
        System.out.println(length.lengthOfLongestSubstring1("pwwkew"));
        System.out.println(length.lengthOfLongestSubstring1("abcabcbb"));
        System.out.println(length.lengthOfLongestSubstring1("bbbbb"));
    }
}



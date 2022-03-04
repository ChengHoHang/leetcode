package com.lc.dp;

import java.util.*;

/**
 * @author chh
 * @date 2022/3/2 20:38
 */
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        
        Map<String, String[]> digit2CharsMap = new HashMap<>();
        digit2CharsMap.put("2", new String[]{"a","b","c"});
        digit2CharsMap.put("3", new String[]{"d","e","f"});
        digit2CharsMap.put("4", new String[]{"g","h","i"});
        digit2CharsMap.put("5", new String[]{"j","k","l"});
        digit2CharsMap.put("6", new String[]{"m","n","o"});
        digit2CharsMap.put("7", new String[]{"p","q","r","s"});
        digit2CharsMap.put("8", new String[]{"t","u","v"});
        digit2CharsMap.put("9", new String[]{"w","x","y","z"});
        
        if (digits.length() <= 1) {
            return Arrays.asList(digit2CharsMap.get(digits));
        }
        
        // 定义dp[i]表示 s.subString(0, i + 1)能表示的字符集，result = dp[digits.length() - 1]
        // dp[i] = dp[i - 1] + digit2CharsMap.get(digits.charAt(i))


        List<String> result = new ArrayList<>(Arrays.asList(digit2CharsMap.get(String.valueOf(digits.charAt(0)))));
        
        for (int i = 1; i < digits.length(); i++) {
            String[] nextStrs = digit2CharsMap.get(String.valueOf(digits.charAt(i)));
            List<String> nextResult = new ArrayList<>();
            for (String tempStr : result) {
                for (String nextStr : nextStrs) {
                    nextResult.add(tempStr + nextStr);
                }
            }
            result = nextResult;
        }

        return result;
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations(""));
        System.out.println(letterCombinations.letterCombinations("23"));
        System.out.println(letterCombinations.letterCombinations("234"));
    }
}

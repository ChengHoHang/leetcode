package com.lc.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/valid-parentheses
 * @author chh
 * @date 2022/3/3 21:14
 */
public class ParenthesesValid {

    public boolean isValid(String s) {
        if (s.length() <= 1 || s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> matchCharMap = new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('{', '}');
                put('[', ']');
            }
        };

        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (matchCharMap.containsKey(c)) {
                stack.add(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                Character lastChar = stack.removeLast();
                if (!matchCharMap.get(lastChar).equals(c)) {
                    return false;
                }
            } 
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        ParenthesesValid parenthesesValid = new ParenthesesValid();
        System.out.println(parenthesesValid.isValid("()[]{}"));
        System.out.println(parenthesesValid.isValid("([)]"));
        System.out.println(parenthesesValid.isValid("{[]}"));
        System.out.println(parenthesesValid.isValid("(("));
    }
}

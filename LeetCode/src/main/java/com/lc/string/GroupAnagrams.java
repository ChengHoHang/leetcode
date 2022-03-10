package com.lc.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chh
 * @date 2022/3/9 21:45
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> resultMap = new HashMap<>();

        for (String str : strs) {
            int[] charCounts = new int[26];
            for (char c : str.toCharArray()) {
                charCounts[c - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < charCounts.length; i++) {
                if (charCounts[i] != 0) {
                    keyBuilder.append((char) ('a' + i)).append(charCounts[i]);
                }
            }

            List<String> result = resultMap.computeIfAbsent(keyBuilder.toString(), (key -> new ArrayList<>()));
            result.add(str);
        }

        return new ArrayList<>(resultMap.values());
    }


    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}

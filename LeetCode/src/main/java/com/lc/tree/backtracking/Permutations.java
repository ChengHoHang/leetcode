package com.lc.tree.backtracking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/permutations/
 * @author chanhaoheng
 * @date 2022/3/9
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> enableUseNums = Arrays.stream(nums).boxed().collect(Collectors.toList());

        dfs(nums, new LinkedList<>(), new LinkedList<>(enableUseNums), result);
        return result;
    }

    private void dfs(int[] nums, Deque<Integer> path, Deque<Integer> enableUseNums, List<List<Integer>> result) {
        // 遍历到末端，直接add
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < enableUseNums.size(); i++) {
            Integer nextNum = enableUseNums.removeFirst();
            path.addLast(nextNum);
            dfs(nums, path, enableUseNums, result);
            path.removeLast();
            enableUseNums.addLast(nextNum);
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{1, 2, 3}));
        System.out.println(permutations.permute(new int[]{1, 2, 3, 4}));
        System.out.println(permutations.permute(new int[]{1, 2, 3, 4}).size());
        System.out.println(permutations.permute(new int[]{1}));
        System.out.println(permutations.permute(new int[]{1, 2}));
    }
}

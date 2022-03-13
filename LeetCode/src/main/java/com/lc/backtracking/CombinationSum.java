package com.lc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chanhaoheng
 * @date 2022/3/9
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        dfs(candidates, new LinkedList<>(), 0, result, target);
        return result;
    }

    private void dfs(int[] candidates, LinkedList<Integer> pathNums, Integer pathSum, List<List<Integer>> result, int target) {
        if (pathSum == target) {
            result.add(new ArrayList<>(pathNums));
            return;
        }

        for (int candidate : candidates) {
            if (pathSum + candidate > target) {
                break;
            }
            Integer curNodeNum = pathNums.peekFirst();
            if (curNodeNum != null && candidate < curNodeNum) {
                continue;
            }

            pathNums.addFirst(candidate);
            dfs(candidates, pathNums, pathSum + candidate, result, target);
            pathNums.removeFirst();
        }
    }


    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum.combinationSum(new int[]{1, 2, 3, 6, 7}, 8));
        System.out.println(combinationSum.combinationSum(new int[]{7, 3, 9, 6}, 6));
    }
}

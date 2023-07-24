package com.lc.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chanhaoheng
 * @date 2022/12/20
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();

        dfs(result, path, 1, n, k);

        return result;
    }

    private void dfs(List<List<Integer>> result, Deque<Integer> path, int begin, int n, int k) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            dfs(result, path, i + 1, n, k);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(4, 2));
    }
}

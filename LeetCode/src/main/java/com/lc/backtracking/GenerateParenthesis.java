package com.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * @author chh
 * @date 2022/3/3 22:33
 */
public class GenerateParenthesis {

    /**
     * 生成n个括号组成的有效字符串
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        dfs(n, "", result, 0, 0);

        return result;
    }


    private void dfs(int n, String path, List<String> result, int open, int close) {
        // path树节点即所求
        if (path.length() == n * 2) {
            result.add(path);
            return;
        }

        // 左括号数大于等于n  剪枝
        if (open < n) {
            dfs(n, path + "(", result, open + 1, close);
        }
        
        // 右括号数大于等于左左括号数  剪枝
        if (close < open) {
            dfs(n, path + ")", result, open, close + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(1));
        System.out.println(new GenerateParenthesis().generateParenthesis(2));
    }
}

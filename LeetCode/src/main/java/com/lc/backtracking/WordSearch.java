package com.lc.backtracking;

/**
 * https://leetcode-cn.com/problems/word-search/
 * @author chanhaoheng
 * @date 2022/3/16
 */
public class WordSearch {


    // 上下左右
    private final int[][] DIRECTION = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    private char[][] board;

    private char[] wordCharArray;

    private boolean[][] visited;


    public boolean exist(char[][] board, String word) {
        // init
        this.board = board;
        this.wordCharArray = word.toCharArray();
        this.visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 从board[i][j] 上下左右4个方向搜索，从word[start]搜索到word[word.length - 1] 若存在则返回true
     */
    private boolean dfs(int i, int j, int start) {
        // start 遍历到word末端
        if (start == wordCharArray.length - 1) {
            return board[i][j] == wordCharArray[start];
        }


        if (board[i][j] == wordCharArray[start]) {
            visited[i][j] = true;
            for (int[] direction : DIRECTION) {
                int nextI = i + direction[0];
                int nextJ = j + direction[1];
                if (inArea(nextI, nextJ) && !visited[nextI][nextJ]) {
                    boolean result = dfs(nextI, nextJ, start + 1);
                    if (result) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }

        return false;
    }

    private boolean inArea(int nextI, int nextJ) {
        return nextI < board.length && nextI >= 0 && nextJ >= 0 && nextJ < board[0].length;
    }


    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ASAD"));
    }
}

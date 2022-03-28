package com.lc.backtracking;

/**
 * @author chh
 * @date 2022/3/28 20:50
 */
public class NumberOfIslands {

    private final int[][] DIRECTION = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
    public int numIslands(char[][] grid) {
        int width = grid.length;
        int height = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                count += numIslands(grid, i, j, width, height);
            }
        }

        return count;
    }

    private int numIslands(char[][] grid, int i, int j, int width, int height) {
        if (grid[i][j] != '1') {
            return 0;
        }

        // 将该位置标志为已遍历
        grid[i][j] = '2';
        
        for (int[] direction : DIRECTION) {
            if (inArea(i + direction[0], j + direction[1], width, height)) {
                numIslands(grid, i + direction[0], j + direction[1], width, height);
            }
        }
        return 1;
    }

    private boolean inArea(int i, int j, int width, int height) {
        return i >= 0 && i < width && j >= 0 && j < height;
    }


    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}
        }));
    }
}

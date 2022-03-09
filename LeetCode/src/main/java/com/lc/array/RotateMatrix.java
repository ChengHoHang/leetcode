package com.lc.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 * @author chh
 * @date 2022/3/9 21:16
 */
public class RotateMatrix {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 1) {
            return;
        }

        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        int[][] matrix = {new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
        rotateMatrix.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

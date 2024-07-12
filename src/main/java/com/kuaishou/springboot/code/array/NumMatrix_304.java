package com.kuaishou.springboot.code.array;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-25
 */
public class NumMatrix_304 {

    private final int[][] preSumArray;

    public NumMatrix_304(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (col == 0) {
            preSumArray = null;
            return;
        }
        preSumArray = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    preSumArray[i][j] = matrix[0][0];
                } else if (i == 0) {
                    preSumArray[i][j] = preSumArray[i][j - 1] + matrix[i][j];
                } else if (j == 0) {
                    preSumArray[i][j] = preSumArray[i - 1][j] + matrix[i][j];
                } else {
                    preSumArray[i][j] =
                            preSumArray[i][j - 1] + preSumArray[i - 1][j] - preSumArray[i - 1][j - 1] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int x1, int y1, int x2, int y2) {
        if (preSumArray == null) {
            throw new IllegalArgumentException("error input");
        }
        return preSumArray[x2][y2] - preSumArray[0][y1] - preSumArray[x1][0] + preSumArray[0][0];
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        NumMatrix_304 instance = new NumMatrix_304(matrix);

        System.out.println(instance.sumRegion(0, 1, 2, 2));
    }
}

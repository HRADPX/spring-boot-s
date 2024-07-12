package com.kuaishou.springboot.code.array;

import java.util.ArrayList;
import java.util.List;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-30
 */
public class SpiralOrder_54 {

    // 1 2 3 4
    // 4 5 6 10
    // 7 8 9 11
    // 0 2 4 5
    public List<Integer> spiralOrder(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> rs = new ArrayList<>(row * col);


        for (int i = 0; i <= ((Math.min(row, col) - 1) >>> 1); i++) {

            // up
            for (int j = i; j < col - i; j++)
                rs.add(matrix[i][j]);

            // right
            for (int j = i + 1; j < row - i; j++)
                rs.add(matrix[j][col - i - 1]);

            // bottom
            for (int j = col - i - 2; j >= i && row - i - 1 > i; j--)
                rs.add(matrix[row - i - 1][j]);

            // left
            for (int j = row - i - 2; j >= i + 1 && i < col - i - 1; j--)
                rs.add(matrix[j][i]);
        }
        return rs;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};

        System.out.println(ReflectUtils.getInstance(SpiralOrder_54.class).spiralOrder(matrix));
    }
}

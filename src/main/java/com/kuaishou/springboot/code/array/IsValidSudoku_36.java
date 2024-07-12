package com.kuaishou.springboot.code.array;

import com.kuaishou.springboot.code.mark.Mark;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-02-11
 */
public class IsValidSudoku_36 implements Mark {

    public boolean isValidSudoku(char[][] board) {

        if (board == null || board[0].length == 0)
            return false;
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] blocks = new int[9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '.')
                    continue;
                int mask = 1 << (board[i][j] - '0');
                if ((rows[i] & mask) != 0)
                    return false;
                if ((cols[j] & mask) != 0)
                    return false;
                int idx = (i / 3) * 3 + j / 3;
                if ((blocks[idx] & mask) != 0)
                    return false;
                rows[i] |= mask;
                cols[j] |= mask;
                blocks[idx] |= mask;
            }
        }
        return true;
    }
}

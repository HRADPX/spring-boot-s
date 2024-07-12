package com.kuaishou.springboot.code.array;

import java.util.Arrays;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-26
 */
public class CorpFlightBooking_1109 {

    public static int[] corpFlightBookings(int[][] bookings, int n) {

        if (n < 1) {
            return new int[0];
        }
        int[] rs = new int[n];

        for (int[] booking : bookings) {

            rs[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                rs[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < rs.length; i++) {
            rs[i] += rs[i - 1];
        }
        return rs;
    }

    public static void main(String[] args) {

        int[][] bookings = {{1,2,10}, {2,2,15}};
        System.out.println(Arrays.toString(corpFlightBookings(bookings, 2)));
    }

}

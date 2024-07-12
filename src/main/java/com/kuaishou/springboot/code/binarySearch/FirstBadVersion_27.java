package com.kuaishou.springboot.code.binarySearch;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-08-28
 */
public class FirstBadVersion_27 {

    public int firstBadVersion(int n) {

        int low = 1;
        int high = n;

        while (low <= high) {

            int mid = (low + high) >>> 1;
            if (isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isBadVersion(int n) {
        return false;
    }
}

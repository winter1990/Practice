package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @bitwise
 *
 * Input: 2, Output: [0,1,3,2] -> [00 01 11 10] or [0 2 3 1] -> 00 10 11 01
 * n represents total digits
 *
 * n = 3, 000 001 011 010 110 111 101 100
 * the mask is 1 << n
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if (n <= 0) {
            return res;
        }
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                int val = res.get(j);
                res.add(val | (1 << i));
            }
        }
        return res;
    }
}

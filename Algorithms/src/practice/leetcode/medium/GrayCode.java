package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * n represents total digits
 * creating a mask
 * n=3, 000 001 011 010 110 111 101 100
 * the mask is 1<<n
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

package practice.leetcode.ez;

import java.util.LinkedList;
import java.util.List;

public class AddtoArrayFormofInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new LinkedList<>();
        int carry = 0;
        int i = A.length - 1;
        while (K != 0 || i >= 0) {
            int val = i >= 0 ? K % 10 + A[i] + carry : K % 10 + carry;
            res.add(0, val % 10);
            K /= 10;
            carry = val / 10;
            i--;
        }
        if (carry != 0) {
            res.add(0, carry);
        }
        return res;
    }

    public List<Integer> addToArrayForm1(int[] A, int K) {
        List res = new LinkedList();
        for (int i = A.length - 1; i >= 0 || K > 0; --i) {
            res.add(0, (i >= 0 ? A[i] + K : K) % 10);
            K = (i >= 0 ? A[i] + K : K) / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        AddtoArrayFormofInteger aa = new AddtoArrayFormofInteger();
        System.out.println(aa.addToArrayForm(new int[]{9,9,9}, 1));
    }
}

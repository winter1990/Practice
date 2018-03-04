package practice.leetcode.ez;

/**
 * the most significant digit is at the head of the list
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int carry = 0;
        while (i >= 0) {
            if (i == digits.length - 1) {
                digits[i] += 1;
                carry = digits[i] / 10;
                digits[i] = digits[i] % 10;
            } else {
                digits[i] += carry;
                carry = digits[i] / 10;
                digits[i] %= 10;
            }
            i--;
        }
        /* to simplify
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + carry;
            digits[i] = val % 10;
            carry = val / 10;
        }
         */
        int[] res = new int[digits.length + 1];
        if (carry == 1) {
            res[0] = 1;
            return res;
        }
        return digits;
    }

    public int[] plusOne1(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {3, 4, 5, 9};
        int[] a3 = {9, 9, 9, 9};
        int[] a4 = {8, 9, 9, 9};

        PlusOne plusOne = new PlusOne();
        int[] res = plusOne.plusOne(a4);


        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

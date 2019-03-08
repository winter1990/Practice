package practice.leetcode.medium;

import java.util.Stack;

/**
 * @greedy
 * @string
 * @stack
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Input: num = "10200", k = 1
 * Output: "200"
 * Input: num = "10", k = 2
 * Output: "0"
 *
 * we want the result value smallest after removing k digits
 * a sequence of digits, the key is when we think about to remove it
 * some examples:
 * 112368 k = 3, remove the last k digits
 * 112134 k = 3, remove 2 and 34, 111
 * 5413210 k = 3, 1210
 * 1000123 k = 2, 12
 * 451789 k = 2
 * always compare with next digit and if num[i] > nums[i+1] remove the digit at i
 * 4563241 k = 4, 241, 456 when we see 3, compare with 6 remove, 5 remove, 4 remove -> backtracking previous digit 1 by 1
 * use a stack
 * when increasing order, push in stack, if see smaller value, pop from stack, update k
 * until stack is empty or current > stack.peek(), then continue, until k == 0
 * 100324 k = 2, 24, 0024
 * then at last, need to handle the leading 0s
 *
 * 1111 k = 2, remove k digits, any
 * 1000 k = 2, 000 k = 1
 */

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        char[] cs = num.toCharArray();
        for (char c : cs) {
            while (!stack.isEmpty() && c < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k-- > 0) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        if (i == sb.length()) {
            return "0";
        }
        return sb.substring(i);
    }

    public String removeKdigits1(String num, int k) {
        char[] res = new char[num.length()];
        int pre = 0;
        int count = num.length() - k;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (pre > 0 && res[pre - 1] > c && k > 0) {
                pre--;
                k--;
            }
            res[pre] = c;
            pre++;
        }
        int index = 0;
        while (index < count && res[index] == '0') {
            index++;
        }
        if (index == count) { // remove leading zeros
            return "0";
        }
        return new String(res, index, count - index);
    }

    public static void main(String[] args) {
        String s = "8001432219";
        RemoveKDigits rd= new RemoveKDigits();
        System.out.println(rd.removeKdigits(s, 3));
    }
}

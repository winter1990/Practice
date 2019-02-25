package practice.leetcode.medium;

import java.util.Stack;

/**
 * @greedy
 * @string
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
 * always compare with next digit and if num[i] > nums[i+1] remove i
 * then at last, need to handle the leading 0s
 */

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        char[] cs = num.toCharArray();
        int count = 0;
        for (char c : cs) {
            if (!stack.isEmpty() && stack.peek() > c) {
                while (!stack.isEmpty() && stack.peek() > c && count < k) {
                    stack.pop();
                    count++;
                }
            }
            stack.push(c);
        }
        while (count < k) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        return i == sb.length() ? "0" : sb.toString().substring(i);
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

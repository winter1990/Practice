package practice.leetcode.medium;

/*
Input: num = "1432219", k = 3
Output: "1219"
Input: num = "10200", k = 1
Output: "200"
Input: num = "10", k = 2
Output: "0"
 */

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
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
        String s = "1432219";
        RemoveKDigits rd= new RemoveKDigits();
        System.out.println(rd.removeKdigits(s, 3));
    }
}

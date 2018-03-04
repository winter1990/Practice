package practice.leetcode.medium;

import java.util.*;

/**
 * use a map to build up the dict <int,char[]>
 * recursively add each char to each string in result set
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character, char[]> map = new HashMap<>();
        map.put('0', new char[]{});
        map.put('1', new char[]{});
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        helper(digits, map, 0, new StringBuilder(), res);

        return res;
    }

    private void helper(String digits, Map<Character, char[]> map, int i, StringBuilder sb, List<String> res) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (char c : map.get(digits.charAt(i))) {
            sb.append(c);
            helper(digits, map, i + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * iterative solution:
     * 23. a+d a+e a+f,
     */
    public List<String> letterCombinations1(String digits) {
        if (digits == null || digits.length() == 0) {
            return new LinkedList<>();
        }
        String[] dict = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> q = new LinkedList<>();
        q.add("");
        for (int i = 0; i < digits.length(); i++) {
            int val = Character.getNumericValue(digits.charAt(i));
            while (q.peek().length() == i) {
                for (char c : dict[val].toCharArray()) {
                    String str = q.peek() + c;
                    q.add(str);
                }
                q.poll();
            }
        }
        return (List) q;
    }

}

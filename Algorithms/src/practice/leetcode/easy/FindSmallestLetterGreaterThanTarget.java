package practice.leetcode.easy;

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int val = target - 'a';
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < letters.length; i++) {
            int cur = letters[i] - 'a';
            if (val < cur) {
                min = Math.min(min, cur - val);
            }
            max = Math.max(max, val - cur);
        }
        return min == Integer.MAX_VALUE ? Character.toChars(target - max)[0] : Character.toChars('a' + val + min)[0];
    }

    public static void main(String[] args) {
        char[] cs = {'c', 'f', 'j'};
        char target = 'k';
        FindSmallestLetterGreaterThanTarget fl = new FindSmallestLetterGreaterThanTarget();
        System.out.println(fl.nextGreatestLetter(cs, target));
    }
}

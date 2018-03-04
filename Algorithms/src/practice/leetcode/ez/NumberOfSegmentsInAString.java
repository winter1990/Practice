package practice.leetcode.ez;

/**
 * "Hello, my name is John" -> 5
 *
 * count number of spaces (multiple spaces count for 1)
 */
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int count = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                while (s.charAt(i) == ' ') {
                    i++;
                }
                count++;
            } else {
                i++;
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        String s = "       ";
        s= s.trim();
        System.out.println("-" + s + "-");
    }
}

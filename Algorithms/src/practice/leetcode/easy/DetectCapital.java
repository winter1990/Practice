package practice.leetcode.easy;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        if (Character.isUpperCase(word.charAt(0))) {
            return word.substring(1).toUpperCase().equals(word.substring(1)) || word.substring(1).toLowerCase().equals(word.substring(1));
        }
        return word.substring(1).toLowerCase().equals(word.substring(1));
    }
}

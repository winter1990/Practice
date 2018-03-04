package practice.leetcode.ez;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] checker = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            checker[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            checker[ransomNote.charAt(i) - 'a']--;
            if (checker[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

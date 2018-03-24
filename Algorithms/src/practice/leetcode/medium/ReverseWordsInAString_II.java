package practice.leetcode.medium;

/*
Given an input string, reverse the string word by word
The input string does not contain leading or trailing spaces and the words are always separated by a single space
Given s = "the sky is blue",
return "blue is sky the"

in place:
eht yks si eulb
the sky is blue
reverse whole string
reverse each word
 */
public class ReverseWordsInAString_II {

    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        int s = 0;
        int e = 0;
        while (e < str.length) {
            while (e < str.length && str[e] != ' ') {
                e++;
            }
            reverse(str, s, e - 1);
            s = e + 1;
            e = s + 1;
        }
    }

    private void reverse(char[] str, int i, int j) {
        while (i < j) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] cs = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        ReverseWordsInAString_II rw = new ReverseWordsInAString_II();
        rw.reverseWords(cs);
        for (char c : cs) {
            System.out.print(c);
        }
    }
}

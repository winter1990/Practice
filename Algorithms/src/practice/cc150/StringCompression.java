package practice.cc150;

/**
 * @string
 */
public class StringCompression {
    public String compression(String s) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            counter++;
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i));
                sb.append(counter);
                counter = 0;
            }
        }
        return sb.toString();
    }

    public int compress(char[] chars) {
        int i = 0, j = 0, n = chars.length;
        while (j < n) {
            char c = chars[j];
            int count = 0;
            while (j < n && chars[j] == c) {
                count++;
                j++;
            }
            chars[i] = c;
            i++;
            if (count != 1) {
                for (char digit : ("" + count).toCharArray()) {
                    chars[i++] = digit;
                }
            }
        }
        return i;
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        String input = "a";
        System.out.println(sc.compression(input));
    }
}

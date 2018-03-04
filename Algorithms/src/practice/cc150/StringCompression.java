package practice.cc150;

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

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        String input = "a";
        System.out.println(sc.compression(input));
    }
}

package practice.interview.google;

public class RemoveSpacesBetweenString {
    public String trimTheString(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = s.length();
        while (i < n && sb.length() == 0 && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()) return "";
        while (i < n) {
            while (i < n && s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i++;
            }
            sb.append(" ");
            while (i < n && s.charAt(i) == ' ') i++;
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        RemoveSpacesBetweenString r = new RemoveSpacesBetweenString();
        String s = "   sadfgdf ddf    ds    ";
        System.out.println("-"+r.trimTheString(s)+"-");
    }
}

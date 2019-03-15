import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        // mod with negative number
        System.out.println(-1 % (2));
        System.out.println(-10 % 5);
        System.out.println(-5 % -7);

        // split and trim
        System.out.println("->" + "     ".trim() + "<-");
        String str = "  a b  c ";
        String[] strs = str.split(" ");
        for (String s : strs) {
            System.out.println("->" + s + "<-");
        }

        String s1 = "Hello world ";
        char[] cs1 = s1.toCharArray();
        for (char c : cs1) {
            System.out.print(c);
        }
    }
}



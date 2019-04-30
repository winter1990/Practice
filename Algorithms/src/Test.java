import javafx.util.Pair;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        int INF = 0x3F3F3F3F;
        System.out.println("INF - " + INF);

        char c = 'a';
        System.out.println(c);
        System.out.println(c + 1);

        System.out.println(5 & (-5));
        System.out.println(13 & (-13));
        System.out.println(0 & (-0));
        // bitwise
        System.out.println(true & false);
        System.out.println(-5 % 3);

        // bitwise signed and unsigned shift
        System.out.println((5 >> 1) + " " + (5 >>> 1)); // 5 -> 0101
        System.out.println((-5 >> 1) + " " + (-5 >>> 1)); // -5 -> 1111....1011

        // value update
        int i = 0;
        int j = i++;
        System.out.println(j);
        System.out.println(i);

        // pair in java
        Pair p = new Pair<>(1, 2);
        System.out.println(p.getKey().toString());

        // mod with negative number
        System.out.println(-1 % (2));
        System.out.println(-5 % 5);
        System.out.println(-5 % -7);
        System.out.println(50 % -13);

        // split and trim
        System.out.println("->" + "     ".trim() + "<-");
        String str = "  a b  c ";
        String[] strs = str.split(" ");
        for (String s : strs) {
            System.out.println("->" + s + "<-");
        }

        String s1 = "Hello world ";
        char[] cs1 = s1.toCharArray();
        for (char cc : cs1) {
            System.out.print(cc);
        }
    }
}



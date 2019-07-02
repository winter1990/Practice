import javafx.util.Pair;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        List<Integer> list = Arrays.asList(2,5,10,30,100);
        System.out.println(Collections.binarySearch(list, 3));

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1,1);
        System.out.println(map.floorKey(0));

        int INF = 0x3F3F3F3F;
        System.out.println("INF - " + INF);

        char c = 'a';
        System.out.println(c);
        System.out.println(c + 1);

        System.out.println(5 & (-5));
        System.out.println(13 & (-13));
        System.out.println(0 & (-0));
        // bitwise
        System.out.println(-5 % 3);

        // bitwise signed and unsigned shift
        System.out.println((5 >> 1) + " " + (5 >>> 1)); // 5 -> 0101
        System.out.println((-5 >> 1) + " " + (-5 >>> 1)); // -5 -> 1111....1011

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
    }
}



package practice.interview.other;

import java.util.LinkedHashSet;
import java.util.Set;

public class EnuDemo {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>();
        set.add("3");
        set.add("1");
        set.add("3");
        set.add("2");
        set.add("3");
        set.add("1");
        set.forEach(s-> System.out.println(s+"-"));

    }
}

package practice.algorithmAndOOD.threadingAndMemory;

import java.util.HashMap;
import java.util.Map;

public class HashCodeDemo {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        System.out.println("hascode - " + map.hashCode());
        map.put(1, 2);
        System.out.println("hascode - " + map.hashCode());
        map.put(2, 3);
        System.out.println("hascode - " + map.hashCode());
    }
}

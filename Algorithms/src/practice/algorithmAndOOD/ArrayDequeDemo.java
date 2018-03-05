package practice.algorithmAndOOD;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<Integer>(8);

        deque.add(20);
        deque.add(30);
        deque.add(10);
        deque.add(18);

        for (Integer number : deque) {
            System.out.println("Number = " + number);
        }

        boolean retval = deque.contains(10);

        if (retval == true) {
            System.out.println("element 10 is contained in the deque");
        } else {
            System.out.println("element 10 is not contained in the deque");
        }

        boolean retval2 = deque.contains(25);

        if (retval2 == true) {
            System.out.println("element 25 is contained in the deque");
        } else {
            System.out.println("element 25 is not contained in the deque");
        }
    }
}
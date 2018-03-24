package practice.algorithmAndOOD.AlgoAndDS;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
    public static void main(String[] args) {
        // similar to Queue data structure that can operate
        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.addFirst(2);
        q.addLast(3);
        System.out.println(q.peek() + " " + q.peekLast());
        //System.out.println(q.removeLast());
        System.out.println();
    }
}

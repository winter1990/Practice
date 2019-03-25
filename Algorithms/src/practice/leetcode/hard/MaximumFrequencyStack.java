package practice.leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @stack
 *
 * push(int x), which pushes an integer x onto the stack.
 * pop(), which removes and returns the most frequent element in the stack.
 * If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 *
 * [5 7 5 7 4 5]
 * pop() 5 [5 7 5 7 4]
 * pop() 7 [5 7 5 4]
 * pop() 5 [5 7 4]
 * pop() 4 [5 7]
 * frequency -> map
 * push to stack -> ordered
 *
 * heap (ordering) + map (track freq):
 * [5 0 1]
 * [7 1 1]
 * [5 2 2]
 * [7 3 2]
 * [4 4 1]
 * [5 5 3]
 * comparator: order by arr[2], if freq same order by index arr[1], return arr[0]
 */
public class MaximumFrequencyStack {
    public static void main(String[] args) {
        FreqStack fs = new FreqStack();
        fs.push(1);
        fs.push(1);
        fs.push(1);
        fs.push(2);
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        fs.push(2);
        fs.push(2);
        fs.push(1);
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
    }
}
class FreqStack {
    PriorityQueue<int[]> pq;
    Map<Integer, Integer> freq;
    int index;
    public FreqStack() {
        index = 0;
        freq = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> a[2] != b[2] ? b[2] - a[2] : b[1] - a[1]);
    }

    public void push(int x) {
        freq.put(x, freq.getOrDefault(x, 0) + 1);
        pq.offer(new int[]{x, index, freq.get(x)});
        index++;
    }

    public int pop() {
        int v = pq.poll()[0];
        freq.put(v, freq.get(v) - 1);
        return v;
    }
}
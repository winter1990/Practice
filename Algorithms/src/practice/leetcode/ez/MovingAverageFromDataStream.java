package practice.leetcode.ez;

import java.util.LinkedList;
import java.util.Queue;

/*
["MovingAverage","next","next","next","next","next","next","next","next","next","next"]
[[5],[12009],[1965],[-940],[-8516],[-16446],[7870],[25545],[-21028],[18430],[-23464]]
[null,12009.0, 6987.0, 4344.66667, 1129.5, -2385.6, -3213.4, (1502.6), -2515.0, 2874.2, 1470.6]
 */
public class MovingAverageFromDataStream {
    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(5);
        System.out.println(ma.next(12009));
        System.out.println(ma.next(1965));
        System.out.println(ma.next(-940));
        System.out.println(ma.next(-8516));
        System.out.println(ma.next(-16446));
        System.out.println(ma.next(7870));
        System.out.println(ma.next(25545));
        System.out.println(ma.next(-21028));
        System.out.println(ma.next(18430));
        System.out.println(ma.next(-23464));
    }
}

/**
 * use a queue to maintain the recent n elements
 * last sum
 */
class MovingAverage {
    double lastSum;
    Queue<Integer> q;
    int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        lastSum = 0;
        q = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if (q.size() == size) {
            lastSum -= q.poll();
        }
        q.offer(val);
        lastSum += val;
        return lastSum / q.size();
    }
}
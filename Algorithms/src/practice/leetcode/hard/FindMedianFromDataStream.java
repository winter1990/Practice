package practice.leetcode.hard;

import java.util.PriorityQueue;

/**
 * @design
 * @heap
 *
 * addNum(1), addNum(2), findMedian() -> 1.5, addNum(3), findMedian() -> 2
 *
 * problems to solve:
 * 1. data stream - continuous new values come in, may makes the median smaller, larger, same
 * 2. median can be single element (odd), or average of two elements (even)
 *
 * intuition
 * insert new element into an array list - find the insertion index - binary search O(logn)
 * when call find medium, get medium based on size odd/even - O(1)
 *
 * optimization
 * no matter what data structure used, need to store all the numbers because when new number comes in, median may change
 *
 * heap is used for getting largest/smallest in O(1) time
 * two heaps, one max heap and one min heap
 * all values in min heap are larger than max heap
 * medium is average of two peaks or the peak of larger size
 * size difference must be smaller/equal to 1
 *
 * add method
 * add to max/low heap
 * min.offer(max.poll) because the peek of lower heap might be larger than minimum of higher heap
 * if size of higher is larger than lower, lower.offer(higher.poll)
 *
 * getMedium method
 * check size difference, if not lower.peek, otherwise, calculate
 */
public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
    }
}

class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            return (min.peek() + max.peek()) / 2.0;
        }
        return (double) max.peek();
    }
}
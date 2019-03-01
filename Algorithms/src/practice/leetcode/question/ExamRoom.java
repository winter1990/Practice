package practice.leetcode.question;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @array
 *
 * In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.
 * When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.
 * If there are multiple such seats, they sit in the seat with the lowest number.
 * (Also, if no one is in the room, then the student sits at seat number 0.)
 *
 * Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * Output: [null,0,9,4,2,null,5]
 * Explanation:
 * ExamRoom(10) -> null
 * seat() -> 0, no one is in the room, then the student sits at seat number 0.
 * seat() -> 9, the student sits at the last seat number 9.
 * seat() -> 4, the student sits at the last seat number 4.
 * seat() -> 2, the student sits at the last seat number 2.
 * leave(4) -> null
 * seat() -> 5, the student sits at the last seat number 5.
 *
 * 0123456789
 * ..........
 * x.........
 * x........x
 * x...x....x
 * x.x.x....x
 * x.x......x
 * x.x..x...x
 *
 * maximize the distance to the closest person
 * when we initialize the slots, when some one comes in and takes the seat
 * it's divide the array into two intervals with some lengths
 * we need to get the largest interval when new person in
 * and divide again into two smaller ones, we put them in somewhere -> pq
 * seat is done
 * when leave, we need to merge the two intervals and put it back in pq
 *
 */
public class ExamRoom {

    PriorityQueue<Interval> pq;
    int N;
    public ExamRoom(int N) {
        this.pq = new PriorityQueue<>((a, b) -> a.dist != b.dist? b.dist - a.dist : a.x - b.x);
        this.N = N;
        pq.add(new Interval(-1, N));
    }

    public int seat() {
        int seat;
        Interval interval = pq.poll();
        if (interval.x == -1) {
            seat = 0;
        } else if (interval.y == N) {
            seat = N - 1;
        } else {
            seat = (interval.x + interval.y) / 2;
        }
        pq.offer(new Interval(interval.x, seat));
        pq.offer(new Interval(seat, interval.y));

        return seat;
    }

    public void leave(int p) {
        Interval head = null, tail = null;
        List<Interval> intervals = new ArrayList<>(pq);
        for (Interval interval : intervals) {
            if (interval.x == p) tail = interval;
            if (interval.y == p) head = interval;
            if (head != null && tail != null) break;
        }
        // Delete
        pq.remove(head);
        pq.remove(tail);
        // Merge
        pq.offer(new Interval(head.x, tail.y));
    }

    class Interval {
        int x, y, dist;
        public Interval(int x, int y) {
            this.x = x;
            this.y = y;
            if (x == -1) {
                this.dist = y;
            } else if (y == N) {
                this.dist = N - 1 - x;
            } else {
                this.dist = Math.abs(x - y) / 2;
            }
        }
    }
}

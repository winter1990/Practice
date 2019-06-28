package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @design
 *
 * In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.
 *
 * When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.
 * If there are multiple such seats, they sit in the seat with the lowest number
 *
 * problems to solve:
 * 1. maximizes the distance to the closest person
 * 2. if there are multiple such seats, they sit in the seat with the lowest index
 * 3. handle the first and last seat
 *
 * use list to track the seats occupied
 * to calculate the distance between two students:
 *   list.get(i+1) - list.get(i)
 * when trying to add a new student at into a slot:
 *   first one - add to 0
 *   get the distance to last
 *   calculate the distance in the middle
 *
 */
public class ExamRoom {
    class ExamRoom1 {
        List<Integer> seats;
        int n;

        public ExamRoom1(int N) {
            seats = new ArrayList<>();
            n = N;
        }

        public int seat() {
            if (seats.size() == 0) {
                seats.add(0);
                return 0;
            }
            int left = seats.get(0);
            int right = n - seats.get(seats.size() - 1) - 1;
            int d = Math.max(left, right);
            for (int i = 0; i < seats.size() - 1; i++) {
                d = Math.max(d, (seats.get(i + 1) - seats.get(i)) / 2);
            }
            if (d == seats.get(0)) {
                seats.add(0, 0);
                return 0;
            }
            for (int i = 0; i < seats.size() - 1; i++) {
                if ((seats.get(i + 1) - seats.get(i)) / 2 == d) {
                    seats.add(i + 1, seats.get(i) + d);
                    return seats.get(i) + d;
                }
            }
            seats.add(n - 1);
            return n - 1;
        }

        public void leave(int p) {
            seats.remove(Integer.valueOf(p));
        }
    }

    /**
     * if we look at the first solution
     * the not efficient part is seat()
     *   we get left and right
     *   linear search of the positions seated
     *
     * to optimize the problem as log(N) when searching
     * we use heap the get the largest distance between two people with log(N)
     * 0123456789
     * ..........
     * x.........
     * x........x
     * x...x....x
     * x.x.x....x
     * x.x......x
     * x.x..x...x
     *
     * seat()
     *   if seated in the middle, we divide the array into two intervals with some lengths
     *   we get the largest interval distance when new person comes in
     *   and divide again into two smaller ones
     *   head and tail
     *     initial state - [-1 n]
     *     define pq, sorted by distance, if tie sort by start time
     * when leave, we need to merge the two intervals and put it back in pq
     *   still use a list
     *
     */
    class ExamRoom2 {
        PriorityQueue<Interval> pq;
        int N;
        public ExamRoom2(int N) {
            this.pq = new PriorityQueue<>((a, b) -> a.dist != b.dist ? b.dist - a.dist : a.x - b.x);
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
            pq.remove(head);
            pq.remove(tail);
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
}


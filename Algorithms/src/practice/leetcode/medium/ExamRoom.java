package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

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
}

class ExamRoom1 {
    List<Integer> list;
    int n;
    public ExamRoom1(int N) {
        list = new ArrayList<>();
        n = N;
    }

    public int seat() {
        if (list.size() == 0) {
            list.add(0);
            return 0;
        }
        int d = Math.max(list.get(0), n - 1 - list.get(list.size() - 1));
        for (int i = 0; i < list.size() - 1; i++) {
            d = Math.max(d, (list.get(i + 1) - list.get(i)) / 2);
        }
        if (d == list.get(0)) {
            list.add(0, 0);
            return 0;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if ((list.get(i + 1) - list.get(i)) / 2 == d) {
                list.add(i + 1, (list.get(i) + list.get(i + 1)) / 2);
                return list.get(i + 1);
            }
        }
        list.add(n - 1);
        return n - 1;
    }

    public void leave(int p) {
        list.remove(Integer.valueOf(p));
    }
}

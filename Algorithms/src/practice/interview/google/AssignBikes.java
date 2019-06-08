package practice.interview.google;

import java.util.List;

public class AssignBikes {
    public int totalDistance(List<Pair> people, List<Pair> bikes) {
        return 0;
    }

    private int getDistance(Pair p1, Pair p2) {
        return Math.abs(p1.row - p2.row) + Math.abs(p1.col - p2.col);
    }

    class Pair {
        int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}

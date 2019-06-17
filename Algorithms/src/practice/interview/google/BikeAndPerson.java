package practice.interview.google;

import java.util.*;

public class BikeAndPerson {
    class Position {
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Pair {
        Position person;
        Position bike;
        int distance;
        public Pair(Position p, Position b) {
            this.person = p;
            this.bike = b;
            this.distance = getDistance(person, bike);
        }
    }

    public int getDistance(Position p1, Position p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public List<Pair> findPersonBikePairs(int[][] matrix) { // 1 person, 2 bike
        int m = matrix.length;
        int n = matrix[0].length;
        List<Position> people = new ArrayList<>();
        List<Position> bikes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    people.add(new Position(i, j));
                } else if (matrix[i][j] == 2) {
                    bikes.add(new Position(i, j));
                }
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.distance - b.distance));
        for (Position p : people) {
            for (Position b : bikes) {
                pq.offer(new Pair(p, b));
            }
        }
        List<Pair> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            String bp = cur.bike.x + " " + cur.bike.y;
            String pp = cur.person.x + " " + cur.person.y;
            if (visited.contains(bp) || visited.contains(pp)) continue;
            visited.add(bp);
            visited.add(pp);
            res.add(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] in = {
                {1,1,0,2,0},
                {0,0,0,0,2},
                {2,0,0,0,1},
                {1,0,0,2,2}};
        BikeAndPerson b = new BikeAndPerson();
        List<Pair> res = b.findPersonBikePairs(in);
        System.out.println(res);
    }
}

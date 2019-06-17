package practice.interview.google;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AssignBikes {
    public static void main(String[] args) {
        char[][] grid = {
                {'p', 'o', 'p', 'o', 'o'},
                {'o', 'o', 'o', 'o', 'o'},
                {'b', 'o', 'o', 'o', 'b'},
                {'b', 'o', 'o', 'o', 'p'}};
        List<Location[]> results = assignBikes(grid);
        for (Location[] cur : results) System.out.println(cur[0].x + " " + cur[0].y + " " + cur[1].x + " " + cur[1].y);
    }

    public static class Location {
        int x, y;
        public Location (int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
    }

    public static class PersonAndBike {
        public Location person;
        public Location bike;
        public int distance;


        public PersonAndBike (Location newPerson, Location newBike) {
            this.bike = newBike;
            this.person = newPerson;
            this.distance = Math.abs(person.x - bike.x) + Math.abs(person.y - bike.y);
        }
    }

    public static List<Location[]> assignBikes(char[][] grid) {
        List<Location[]> results = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) return results;
        List<Location> people = new ArrayList<>();
        List<Location> bikes = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'p') {
                    people.add(new Location(i, j));
                } else if (grid[i][j] == 'b') {
                    bikes.add(new Location(i, j));
                }
            }
        }
        PriorityQueue<PersonAndBike> pq = new PriorityQueue<>((a,b)->a.distance - b.distance);
        for (Location person : people) {
            for (Location bike : bikes) {
                PersonAndBike pair = new PersonAndBike(person, bike);
                pq.offer(pair);
            }
        }
        while (!pq.isEmpty()) {
            PersonAndBike curPair = pq.poll();
            if (grid[curPair.person.x][curPair.person.y] == 'p' && grid[curPair.bike.x][curPair.bike.y] == 'b') {
                Location[] result = new Location[2];
                result[0] = new Location(curPair.person.x, curPair.person.y);
                result[1] = new Location(curPair.bike.x, curPair.bike.y);
                results.add(result);
                System.out.println("find a pair!");
                grid[curPair.person.x][curPair.person.y] = '$';
                grid[curPair.bike.x][curPair.bike.y] = '$';
            }
        }
        return results;
    }


}

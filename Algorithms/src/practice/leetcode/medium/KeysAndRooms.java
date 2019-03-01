package practice.leetcode.medium;

import java.util.*;

/**
 * @graph
 * @dfs
 *
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1,
 * and each room may have some keys to access the next room.
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1]
 * where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 *
 * start from index 0, for each number in the list, we go to that room and open it
 * use an boolean array to mark if we have visited the room
 */
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int room : rooms.get(cur)) {
                if (!visited.contains(room)) {
                    q.offer(room);
                    visited.add(room);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}

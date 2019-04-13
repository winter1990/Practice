package practice.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @math
 *
 * for two points (y2-y1)/(x2-x1)
 * for another point, (y2-y2)/(x2-x1) = (y3-y1)/(x3-x1)
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points == null) return 0;
        if (points.length < 3) return points.length;
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        int n = points.length, res = 0;
        for (int i = 0; i < n; i++) {
            map.clear();
            int max = 0, countSame = 0;
            for (int j = i + 1; j < n; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    countSame++;
                    continue;
                }
                int gcd = gcd(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }
                if (!map.containsKey(y)) {
                    if (map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    } else {
                        map.get(x).put(y, 1);
                    }
                } else {
                    map.put(x, new HashMap<>());
                    map.get(x).put(y, 1);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            res = Math.max(res, max + countSame + 1);
        }
        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    class Point {
       int x;
       int y;
       Point(int a, int b) {
           x = a;
           y = b;
       }
    }
}

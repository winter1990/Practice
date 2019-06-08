package practice.interview.google;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * given a list of car traveling for point a to b with speed x, calculate how byst each segment is. For example,
 * car1: [0,14,90] car 1 travels from point 0 to 14 with speed 90
 * car2:[3,15,80] car 2 travels from point 3 to 15 with speed 80
 * expected answer
 * 0-> 3 speed 90
 * 3-> 14 speed is(90+80)/2, where we take the average of all cars here
 * 14-> 15 speed is 80
 */
public class SegmentTraffic {
    public List<String> getSegmentSpeed(int[][] cars) {
        TreeMap<Integer, Integer[]> map = new TreeMap<>();
        for (int[] car : cars) {
            if (!map.containsKey(car[0])) {
                map.put(car[0], new Integer[]{car[2], 1});
            } else {
                Integer[] value = map.get(car[0]);
                value[0] += car[2];
                value[1]++;
            }
            if (!map.containsKey(car[1])) {
                map.put(car[1], new Integer[]{-car[2], -1});
            } else {
                Integer[] value = map.get(car[1]);
                value[0] -= car[2];
                value[1]--;
            }
        }
        List<String> res = new ArrayList<>();
        Integer pre = null;
        double speed = 0.0;
        int count = 0;
        for (Integer key : map.keySet()) {
            if (pre == null) {
                pre = key;
                speed += map.get(key)[0];
                count += map.get(key)[1];
                continue;
            }
            res.add(pre + " " + key + " " + speed / count);
            pre = key;
            speed += map.get(key)[0];
            count += map.get(key)[1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] in = {{0,14,90},{3,15,80}};
        SegmentTraffic s = new SegmentTraffic();
        System.out.println(s.getSegmentSpeed(in));
    }
}

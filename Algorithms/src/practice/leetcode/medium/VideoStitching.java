package practice.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @array
 *
 * You are given a series of video clips from a sporting event that lasted T seconds.
 * Each video clip clips[i] is an interval: it starts at time clips[i][0] and ends at time clips[i][1]
 * Return the minimum number of clips needed so that we can cut the clips into segments that cover the entire event
 * If the task is impossible, return -1.
 *
 * problem to solve:
 * 1. there should not be any empty slots
 * 2. minimize the total clips to choose
 *
 * sort first based on start time
 * --------------- total
 * ---
 * -------
 *     --
 *      -----
 *      ---------
 *         -----
 *          ------
 * check head & tail first
 * use a dp array to store how many clips
 * start with 0
 */
public class VideoStitching {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (a, b) -> (a[0] - b[0]));
        if (clips[0][0] != 0) return -1;
        int count = 0, i = 0, last = 0;
        Queue<int[]> q = new LinkedList<>();
        while (clips[i][0] == 0) q.offer(clips[i++]);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                last = Math.max(last, cur[1]);
                if (last >= T) return ++count;
            }
            while (i < clips.length && clips[i][0] <= last) q.offer(clips[i++]);
            count++;
        }
        return last >= T ? count : -1;
    }

    public int videoStitching1(int[][] clips, int T) {
        Arrays.sort(clips, (a, b) -> (a[0] - b[0]));
        int count = 0, end = 0, i = 0;
        while (i < clips.length) {
            if (clips[i][0] > end) return -1;
            int newEnd = end;
            while (i < clips.length && clips[i][0] <= end) newEnd = Math.max(newEnd, clips[i++][1]);
            count++;
            end = newEnd;
            if (end >= T) return count;
        }
        return -1;
    }

    public static void main(String[] args) {
        VideoStitching v= new VideoStitching();
//        int[][] in = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
//        int[][] in = {{0,1},{1,2}};
//        int[][] in = {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
        int[][] in = {{0,4},{2,8}};
//        int[][] in = {{5,7},{1,8},{0,0},{2,3},{4,5},{0,6},{5,10},{7,10}};
        System.out.println(v.videoStitching(in, 5));
    }
}

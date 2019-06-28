package practice.interview.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @design
 *
 * Design and implement snapshotable array. Given a array that supports following methods
 *
 * void set(int index, int value) // sets the value at particular index
 * int takeSnapshop() // take snapshot of current state of the array and returns snapshot id
 * int getSnapshotValue(int snapshotId, int index) // returns value at specifiec index in particular snapshot
 *
 * Input : [1, 3, 4, 5]
 * Output:
 * 	set(0, 3) -> [3, 3, 4, 5]
 * 	takeSnaphot() -> it should store the changes and return snapshot id
 * 	getSnapshotValue(snapshotId, 0) -> 3
 * 	getSnapshotValue(snapshotId, 2) -> 4
 *
 * set()
 *   modify the array (and create a new version? no need)
 *
 * takeSnapshot()
 *   store the changed array and return snapshot id
 *
 * getSnapshotValue(snapshot id, index)
 *   check id is valid
 *   check index is valid
 *   return the value
 *
 *
 */
public class SnapshotArray {
    int[] arr;
    int snapshotId;
    Map<Integer, Integer[]> snapshots;
    public SnapshotArray(int[] arr) {
        this.arr = arr;
        this.snapshotId = 0;
        this.snapshots = new HashMap<>();
    }

    public void set(int index, int val) {
        if (index < 0 && index > arr.length) return;
        arr[index] = val;
    }

    public int takeSnapshot() {
        int n = arr.length;
        Integer[] snapshot = new Integer[n];
        for (int i = 0; i < n; i++) {
            snapshot[i] = arr[i];
        }
        snapshots.put(snapshotId, snapshot);
        snapshotId++;
        return snapshotId - 1;
    }

    public int getSnapshotValue(int snapshotId, int index) throws IllegalAccessException {
        if (!snapshots.keySet().contains(snapshotId)) throw new IllegalAccessException();
        if (index < 0 || index >= arr.length) throw new IllegalAccessException();
        return snapshots.get(snapshotId)[index];
    }

    // for above solution. space is not efficient because for each snapshot, we save the whole array
    class SnapshotOfArray {
        int[] arr;
        int snapshotId;
        Map<Integer, List<Edit>> snapshots;
        List<Edit> edits;
        public SnapshotOfArray(int[] arr) {
            this.arr = arr;
            snapshotId = -1;
            snapshots = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                edits.add(new Edit(arr[i], i, arr[i]));
            }
        }

        public void set(int index, int val) {
            if (index < 0 || index >= arr.length) throw new IllegalArgumentException();
            edits.add(new Edit(arr[index], index, val));
            arr[index] = val;
        }

        public int takeSnapshot() {
            snapshots.put(++snapshotId, edits);
            edits = new ArrayList<>();
            return snapshotId;
        }

        public int getSnapshotValue(int snapshotId, int index) throws IllegalAccessException {
            if (index < 0 || index >= arr.length) throw new IllegalArgumentException();
            if (!snapshots.containsKey(snapshotId)) throw new IllegalArgumentException();
            return snapshots.get(snapshotId).get(index).cur;
        }

        class Edit {
            int pre, index, cur;
            public Edit(int pre, int index, int cur) {
                this.pre = pre;
                this.index = index;
                this.cur = cur;
            }
        }
    }
}


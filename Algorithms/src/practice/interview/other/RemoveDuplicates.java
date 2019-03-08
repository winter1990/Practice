package practice.interview.other;

/**
 * 1 2 2 3 3 3 4 -> 1 4
 */
public class RemoveDuplicates {
    public int remove(int[] arr) {
        int i = 0, j = 1;
        while (j < arr.length) {
            int count = 1;
            if (j < arr.length - 1 && arr[j] == arr[j + 1]) {
                j++;
                count++;
            }
            if (count == 1) {
                arr[i] = arr[j];
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {

    }
}

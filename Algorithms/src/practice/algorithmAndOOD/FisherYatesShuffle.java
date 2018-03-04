package practice.algorithmAndOOD;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * nextInt(int n) method is used to get a pseudorandom,
 * uniformly distributed int value between 0 (inclusive) and the specified value (exclusive)
 */
public class FisherYatesShuffle {
    public static void main(String args[]) {
        int[] solutionArray = { 1, 2, 3, 4, 5, 6};

        shuffleArray(solutionArray);
        for (int i = 0; i < solutionArray.length; i++) {
            System.out.print(solutionArray[i] + " ");
        }
        System.out.println();
    }

    // Implementing Fisher–Yates shuffle
    static void shuffleArray(int[] ar) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}

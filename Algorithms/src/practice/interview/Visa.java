package practice.interview;

public class Visa {
    public boolean isPrimeNumber(int num) {
        // check negative input and 0, 1
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        // even number that larger than 2 can not be the prime number
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= num; i += 2) {
            if ((num % i) == 0) {
                return false;
            }
        }
        return true;
    }

}

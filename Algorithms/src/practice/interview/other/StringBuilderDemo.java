package practice.interview.other;

import java.util.Scanner;

public class StringBuilderDemo {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            if (sb.indexOf(arg) < 1) {
                sb.append(arg + " ");
            }
        }
        System.out.println(sb.toString());
        Scanner sc = new Scanner(sb.toString());
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                System.out.println(sc.nextInt() + " ");
            } else {
                sc.next();
            }
        }
    }
}

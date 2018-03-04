package practice.algorithmAndOOD;

public class AbstractDemo {

    public static void main(String [] args) {
        /* Following is not allowed and would raise error
        Staff e = new Staff("George W.", "Houston, TX", 43);
        System.out.println("\n Call mailCheck using Employee reference--");
        e.mailCheck();
        */
        Salary s = new Salary("personA", "Ambehta, UP", 333333333, 3600.00);
        Staff e = new Salary("personB", "Boston, MA", 222222222, 2400.00);
        System.out.println("Call mailCheck using Salary reference --");
        s.mailCheck();
        System.out.println("\nCall mailCheck using Employee reference--");
        e.mailCheck();
    }
}

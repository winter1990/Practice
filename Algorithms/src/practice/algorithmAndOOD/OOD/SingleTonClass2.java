package practice.algorithmAndOOD.OOD;

public class SingleTonClass2 {
    static SingleTonClass2 instance = null;
    public int x = 10;

    // private constructor can't be accessed outside the class
    private SingleTonClass2() {  }

    // Factory method to provide the users with instances
    public static SingleTonClass2 getInstance() {
        if (instance == null)
            instance = new SingleTonClass2();
        return instance;
    }
}

// Driver Class
class Main {
    public static void main(String args[]) {
        SingleTonClass2 a = SingleTonClass2.getInstance();
        SingleTonClass2 b = SingleTonClass2.getInstance();
        a.x = a.x + 10;
        // value are the same as both a and b refer to the same object
        System.out.println("Value of a.x = " + a.x);
        System.out.println("Value of b.x = " + b.x);
    }
}
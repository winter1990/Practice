package practice.algorithmAndOOD.threadingAndMemory;

public class TestThread extends Thread {
    //not overriding Thread.run() method

    //main method, can be in other class too
    public static void main(String args[]){
        Thread t = new TestThread();
        System.out.println("Before starting thread");
        t.start();
        System.out.println("After starting thread");
    }
}
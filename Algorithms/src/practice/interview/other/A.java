package practice.interview.other;

class A {
    static int total = 10;
    public void call() {
        int total = 5;
        System.out.println(this.total);
    }

    public static void main(String[] args) {
        A a1 = new A();
        a1.call();
    }
}

package practice.interview;

public class IknTest {
    /*
    static class Helper {
        private int data = 5;
        public void bump(int inc) {
            inc++;
            data = data + inc;
        }
    }

    public static void main(String[] args) {
        Helper h = new Helper();
        int data = 2;h.bump(data);
        System.out.println(h.data + " " + data);
    }
    */
    public IknTest() {
        this(10);
    }
    public IknTest(int data) {
        this.data = data;
    }
    public void display() {
        class Dec {
            public void decre() {
                data--;
            }
        }
        Dec d = new Dec();
        d.decre();
        System.out.println("data =  " + data);
    }
    private int data;

    public static void main(String[] args) {
        int data = 0;
        IknTest t = new IknTest();
        t.display();
//        System.out.println("data = " + data);

        short x = 2;
        switch (x) {
            case 0: System.out.println("0");
            case 2: System.out.println("2");
        }
    }
}

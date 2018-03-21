package practice.algorithmAndOOD.designPattern.DecoratorDemo;

public class Y extends D {
    public Y(I inner) {
        super(inner);
    }

    public void doIt()  {
        super.doIt();
        doY();
    }

    private void doY() {
        System.out.print('Y');
    }
}
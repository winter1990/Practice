package practice.algorithmAndOOD.designPattern;

// https://dzone.com/articles/singleton-design-pattern-%E2%80%93

public class SingletonExample {

    // Static member holds only one instance of the SingletonExample class
    private static SingletonExample singletonInstance;

    // SingletonExample prevents any other class from instantiating
    private SingletonExample() {
    }

    // Providing Global point of access
    public static SingletonExample getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new SingletonExample();
        }
        return singletonInstance;
    }
    public void printSingleton(){
        System.out.println("Inside print Singleton");
    }
}

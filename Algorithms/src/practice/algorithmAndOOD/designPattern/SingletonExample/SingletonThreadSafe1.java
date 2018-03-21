package practice.algorithmAndOOD.designPattern.SingletonExample;

// https://dzone.com/articles/singleton-design-pattern-%E2%80%93

public class SingletonThreadSafe1 {

    // Static member holds only one instance of the SingletonExample class
    private static SingletonThreadSafe1 singletonInstance = null;

    // SingletonExample prevents any other class from instantiating
    private SingletonThreadSafe1() {
    }

    // synchronized the method getSingletonInstance() can prevent other threads to access the singleton instance
    // Slow performance because of locking overhead
    // Unnecessary synchronization that is not required once the instance variable is initialized
    public static synchronized SingletonThreadSafe1 getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new SingletonThreadSafe1();
        }
        return singletonInstance;
    }
    public void printSingleton(){
        System.out.println("Inside print Singleton");
    }
}

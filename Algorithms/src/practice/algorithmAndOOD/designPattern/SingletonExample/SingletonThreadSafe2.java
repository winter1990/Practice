package practice.algorithmAndOOD.designPattern.SingletonExample;

public class SingletonThreadSafe2 {
    // object is created before it is needed.
    // The JVM takes care of the static variable initialization and ensures that the process is thread safe
    // and that the instance is created before the threads tries to access it
    // user can not pass arguments (DB connection)
    private static final SingletonThreadSafe2 singletonInstance = new SingletonThreadSafe2();

    // SingletonExample prevents any other class from instantiating
    private SingletonThreadSafe2() {
    }

    // Providing Global point of access
    public static SingletonThreadSafe2 getSingletonInstance() {
        return singletonInstance;
    }
}

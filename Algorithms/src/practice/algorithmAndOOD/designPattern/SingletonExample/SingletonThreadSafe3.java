package practice.algorithmAndOOD.designPattern.SingletonExample;

// https://dzone.com/articles/singleton-design-pattern-%E2%80%93

public class SingletonThreadSafe3 {
    // keyword with a variable, all the threads read value from memory and don't cache it
    // volatile keyword helps as concurrency control tool in a multithreaded environment
    // and provides the latest update in a most accurate manner
    private static volatile SingletonThreadSafe3 singletonInstance = null;

    private SingletonThreadSafe3() {
    }

    /**
     * use double checked locking so that the synchronization happens only during the first call
     * limit this expensive operation to happen only once
     *
     * All the remaining threads that were not lucky to enter the synchronized block along with the first thread
     * will be blocked at the first null check.
     * This mechanism is called double checked locking
     * and it provides significant performance benefit and also it is cost effective solution
     * Synchronization overhead is minimized and applicable only for first few threads when the variable is null
      */
    public static SingletonThreadSafe3 getSingletonInstance() {
        if (singletonInstance == null) {
            synchronized (SingletonThreadSafe3.class) {
                if (singletonInstance == null) {
                    singletonInstance = new SingletonThreadSafe3();
                }
            }
        }
        return singletonInstance;
    }
}

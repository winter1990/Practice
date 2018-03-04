package practice.algorithmAndOOD;

public class SingleTonClass1 {
    //Static Class Reference
    private static SingleTonClass1 obj = null;
    private SingleTonClass1(){
        /*Private Constructor will prevent
         * the instantiation of this class directly*/
    }
    public static SingleTonClass1 objectCreationMethod(){
        /*This logic will ensure that no more than
         * one object can be created at a time */
        if(obj == null){
            obj= new SingleTonClass1();
        }
        return obj;
    }
    public void display(){
        System.out.println("Singleton class Example");
    }

    public static void main(String args[]){
        //Object cannot be created directly due to private constructor
        //This way it is forced to create object via our method where
        //we have logic for only one object creation
        SingleTonClass1 myobject = SingleTonClass1.objectCreationMethod();
        myobject.display();

        // we can create another obj inside this current class ONLY
        // if we create another java file and initialize, it will not be allowed
        SingleTonClass1 myobject1 = SingleTonClass1.objectCreationMethod();
        myobject1.display();
    }
}

class main {
    public static void main(String args[]){
        //Object cannot be created directly due to private constructor
        //This way it is forced to create object via our method where
        //we have logic for only one object creation
        SingleTonClass1 myobject = SingleTonClass1.objectCreationMethod();
        myobject.display();

        // we can create another obj inside this current class ONLY
        // if we create another java file and initialize, it will not be allowed
        SingleTonClass1 myobject1 = SingleTonClass1.objectCreationMethod();
        myobject1.display();
    }
}
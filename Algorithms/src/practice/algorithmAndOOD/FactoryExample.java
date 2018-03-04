package practice.algorithmAndOOD;

public class FactoryExample {
    public static void main(String[] args) {
        // create a small dog
        Dog dog = FactoryDog.getDog("small");
        dog.speak();

        // create a big dog
        dog = FactoryDog.getDog("big");
        dog.speak();

        // create a working dog
        dog = FactoryDog.getDog("working");
        dog.speak();
    }
}

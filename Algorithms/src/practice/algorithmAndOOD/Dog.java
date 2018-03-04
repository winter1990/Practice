package practice.algorithmAndOOD;

public interface Dog {
    public void speak();
}

class Poodle implements Dog {
    public void speak() {
        System.out.println("The poodle says \"arf\"");
    }
}

class Rottweiler implements Dog {
    public void speak() {
        System.out.println("The Rottweiler says (in a very deep voice) \"WOOF!\"");
    }
}

class SiberianHusky implements Dog {
    public void speak() {
        System.out.println("The husky says \"Dude, what's up?\"");
    }
}
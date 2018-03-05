package practice.algorithmAndOOD.OOD;

public interface FactoryDog {
    // The factory just says it's returning something that implements the Dog interface
    // DogFactory class has a static getDog method that returns a Dog that depends on the criteria that has been supplied
    public static Dog getDog(String criteria) {
        if (criteria.equals("small")) {
            return new Poodle();
        } else if (criteria.equals("big")) {
            return new Rottweiler();
        } else if (criteria.equals("working")) {
            return new SiberianHusky();
        }
        return null;
    }
}
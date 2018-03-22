package practice.algorithmAndOOD.designPattern.ObserverExmaple;

//https://dzone.com/articles/gof-design-patterns-using-java-part-1

public interface Observer {
    public void update(String stockSymbol, Float stockValue, Integer stockUnits);
}

package practice.algorithmAndOOD.designPattern.ObserverExmaple;

public interface Subject {
    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
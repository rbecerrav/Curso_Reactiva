import java.util.ArrayList;

public class Subject {
    private ArrayList<Observer> observers;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void addEmployee(Employee employee){
        notifyObservers(employee);
    }

    public void notifyObservers(Employee employee) {
        observers.forEach(observer -> observer.update(employee.getName()));
    }
}

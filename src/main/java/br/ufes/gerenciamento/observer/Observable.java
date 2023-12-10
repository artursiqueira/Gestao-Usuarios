
package br.ufes.gerenciamento.observer;

import java.util.ArrayList;
import java.util.List;


public abstract class Observable {
    private List<Observer> observers = new ArrayList<>();
   
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for(Observer observer: observers) {
            observer.update();
        }
    }
}

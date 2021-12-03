package observer;

import java.util.ArrayList;

public abstract class Observed {
    private ArrayList<Observer> obs;
    public void notifyChanges(Object changes){
        for(Observer o:obs)
            o.notifyObChanges(changes);
    }
    public void addObserver(Observer observer){
        obs.add(observer);
    };
}

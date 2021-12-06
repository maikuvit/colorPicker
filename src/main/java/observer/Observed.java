package observer;

import java.util.ArrayList;

public abstract class Observed {
    private ArrayList<Observer> obs = new ArrayList<>();
    public void notifyChanges(Object changes){
        System.out.println("NOTIFICAAAAA");
        for(Observer o:obs)
            o.notifyObChanges(changes);
    }
    public void addObserver(Observer observer){
        obs.add(observer);
    };
}

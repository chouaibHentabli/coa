package core.util;

import java.util.*;
import java.util.Observer;

/**
 * Created by chouaib on 20/02/17.
 */
public class AbstractSubject implements Subject {


    protected List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public List<Observer> getObservers() {
        return observers;
    }


}

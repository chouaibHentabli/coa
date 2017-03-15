package core.difussionStrategy;

import core.captor.ICaptor;
import core.util.Observer;
import core.util.ValuesContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chouaib on 20/02/17.
 */
public class AbstractDiffusion implements IDiffusionStrategy {

    private DiffusionType type;
    protected List<Observer> observers = new ArrayList<>();
    //lien de proxy
    protected ICaptor captor;


    public AbstractDiffusion(DiffusionType type) {
        this.type = type;
    }

    @Override
    public void configure(ICaptor captor, List<Observer> observers) {
        this.captor = captor;
        this.observers = observers;
    }

    @Override
    public DiffusionType getDiffusionType() {
        return type;
    }

    @Override
    public void setDiffuseStrategy(DiffusionType type) {
        this.type = type;
    }


    @Override
    public ValuesContainer getValue() {
        return captor.getValue();
    }

    @Override
    public ValuesContainer setValue(ValuesContainer value) {
        return captor.setValue(value);
    }


    @Override
    public String toString() {
        return "DiffusionStrategy[" + type + "]";
    }

    @Override
    public void tick() {

    }

    @Override
    public void attach(Observer o) {

    }

    @Override
    public void detach(Observer o) {

    }

    @Override
    public IDiffusionStrategy getDiffuseStrategy() {
        return null;
    }

    @Override
    public void execute() {

    }

}

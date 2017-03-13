package core.difussionStrategy;

import core.captor.ICaptor;
import core.util.Observer;

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
    public void execute() {

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
    public Integer getValue() {
        return null;
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
}

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
    //proxy link
    protected ICaptor captor;

    public AbstractDiffusion(DiffusionType type) {
        this.type = type;
    }

    @Override
    public DiffusionType getDiffusionType() {
        return type;
    }

    @Override
    public String toString() {
        return "DiffusionStrategy[" + type + "]";
    }

    @Override
    public void configure(ICaptor captor, List<Observer> observers) {
        this.captor = captor;
        this.observers = observers;
    }

    @Override
    public void execute() {

    }


}

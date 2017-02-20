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


    public AbstractDiffusion(DiffusionType type) {
        this.type = type;
    }

    @Override
    public void configure(ICaptor captor, List<Observer> observers) {

    }

    @Override
    public void execute() {

    }

    @Override
    public DiffusionType getDiffusionType() {
        return null;
    }
}

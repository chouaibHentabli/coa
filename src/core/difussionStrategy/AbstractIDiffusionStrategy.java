package core.difussionStrategy;

import core.captor.ICaptor;
import core.util.Observer;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by chouaib on 15/03/17.
 */
public abstract class AbstractIDiffusionStrategy implements IDiffusionStrategy {

    private DiffusionType type;
    protected List<Observer> clients = new ArrayList<>();
    protected ICaptor captor;

    public AbstractIDiffusionStrategy(DiffusionType type) {
        this.type = type;
    }

    @Override
    public DiffusionType getDiffusionType() {
        return type;
    }

    @Override
    public String toString() {
        return "IDiffusionStrategy[" + type + "]";
    }

    @Override
    public void configure(ICaptor captor, List<Observer> clients) {
        this.captor = captor;
        this.clients = clients;
    }
}

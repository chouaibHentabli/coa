package core.difussionStrategy;

import core.captor.ICaptor;
import core.util.Observer;

import java.util.List;

/**
 * Created by chouaib on 23/01/17.
 */
public class EpocDiffusion extends AbstractDiffusion {

    public EpocDiffusion(DiffusionType type) {
        super(type);
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

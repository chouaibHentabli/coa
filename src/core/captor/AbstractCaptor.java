package core.captor;

import core.difussionStrategy.IDiffusionStrategy;
import core.util.AbstractSubject;

/**
 * Created by chouaib on 21/02/17.
 */
public abstract class AbstractCaptor extends AbstractSubject implements ICaptor {

    protected static int value = 0;
    protected IDiffusionStrategy diffuseStrategy;

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void tick() {

    }
}
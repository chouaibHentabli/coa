package core.captor;

import core.difussionStrategy.DiffusionType;
import core.difussionStrategy.IDiffusionStrategy;
import core.util.AbstractSubject;
import core.util.ValuesContainer;
import main.Controller;

/**
 * Created by chouaib on 21/02/17.
 */
public abstract class AbstractCaptor extends AbstractSubject implements ICaptor {

    protected ValuesContainer value;
    protected IDiffusionStrategy diffuseStrategy;


    public ValuesContainer getValues() {
        return this.value;
    }


}

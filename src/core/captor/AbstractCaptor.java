package core.captor;

import core.difussionStrategy.DiffusionType;
import core.difussionStrategy.IDiffusionStrategy;
import core.util.AbstractSubject;
import core.util.CaptorValuesContainer;
import core.util.ValuesContainer;
import main.Controller;

/**
 * Created by chouaib on 21/02/17.
 */
public abstract class AbstractCaptor extends AbstractSubject implements ICaptor {

    protected String name;
    protected ValuesContainer value = new CaptorValuesContainer(0, 0.0);
    protected IDiffusionStrategy diffuseStrategy;
    private static int identifier = 0;

    public AbstractCaptor() {
        name = "Capteur_" + ++identifier;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public ValuesContainer getValue() {
        return value;
    }

    @Override
    public ValuesContainer setValue(ValuesContainer value) {
        return value = value;
    }

    @Override
    public IDiffusionStrategy getDiffuseStrategy() {
        return diffuseStrategy;
    }


}

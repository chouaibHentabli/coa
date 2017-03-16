package core.captor;

import core.util.*;

/**
 * Created by chouaib on 20/02/17.
 */
public abstract class AbstractCaptor extends AbstractSubject implements ICaptor {

    protected String name;
    protected ValuesContainer values = new CaptorValuesContainer(0, 0.0);

    private static int identifier = 0;

    public AbstractCaptor() {
        name = "Capteur_" + ++identifier;
    }

    @Override
    public ValuesContainer getValues() {
        return values;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void setValues(ValuesContainer valuesContainer) {
        values = valuesContainer;
    }
}

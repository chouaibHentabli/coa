package core.captor;

import core.difussionStrategy.DiffusionType;
import core.difussionStrategy.IDiffusionStrategy;
import core.util.AbstractSubject;
import core.util.ValuesContainer;

/**
 * Created by chouaib on 21/02/17.
 */
public abstract class AbstractCaptor extends AbstractSubject implements ICaptor {

    protected ValuesContainer value;
    protected IDiffusionStrategy diffuseStrategy;


    public ValuesContainer getValues() {
        return this.value;
    }

    @Override
    public void tick() {
        diffuseStrategy.execute();
        /*if (controller != null) {
            controller.update(this);
        }
        System.out.println("Tick with " + getDiffusionStrategy() + "with value " + values);
       */
    }
}

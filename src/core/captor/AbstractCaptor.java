package core.captor;

import core.difussionStrategy.DiffusionType;
import core.difussionStrategy.IDiffusionStrategy;
import core.util.AbstractSubject;

/**
 * Created by chouaib on 21/02/17.
 */
public abstract class AbstractCaptor extends AbstractSubject implements ICaptor {

    protected int value = 0;
    protected IDiffusionStrategy diffuseStrategy;


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

package core.captor;

import core.difussionStrategy.DiffusionType;
import core.difussionStrategy.IDiffusionStrategy;
import core.util.Subject;
import core.util.ValuesContainer;

/**
 * Created by chouaib on 19/02/17.
 */
public interface ICaptor extends Subject {

    public ValuesContainer getValue();

    public ValuesContainer setValue();


    /**
     * Send a request for value updates to each observers
     */
    void tick();

    public void setDiffuseStrategy(DiffusionType type);

    public DiffusionType getDiffuseStrategy();
}

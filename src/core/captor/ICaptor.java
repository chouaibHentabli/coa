package core.captor;

import core.difussionStrategy.DiffusionType;
import core.difussionStrategy.IDiffusionStrategy;
import core.util.Subject;

/**
 * Created by chouaib on 19/02/17.
 */
public interface ICaptor extends Subject {

    public Integer getValue();

    public void setValue();


    /**
     * Send a request for value updates to each observers
     */
    void tick();

    public void setDiffuseStrategy(DiffusionType type);
    public DiffusionType getDiffuseStrategy();
}

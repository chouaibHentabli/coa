package core.captor;

import core.difussionStrategy.IDiffusionStrategy;
import core.util.Subject;

/**
 * Created by chouaib on 19/02/17.
 */
public interface ICaptor extends Subject {

    public Integer getValue();

    /**
     * Send a request for value updates to each observers
     */
    void tick();

    IDiffusionStrategy getDiffusionStrategy();
}

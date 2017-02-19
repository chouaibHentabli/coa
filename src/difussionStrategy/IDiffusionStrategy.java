package difussionStrategy;

import captor.ICaptor;
import util.Observer;

import java.util.List;

/**
 * Created by chouaib on 19/02/17.
 */
public interface IDiffusionStrategy {

    /**
     * Prepare all the necesserary for a complete working algo
     */
    void configure(ICaptor captor, List<Observer> clients);

    /**
     * Execute the algo with parameters specified inside the configure method
     */
    void execute();

    /**
     * Identifies this algo
     *
     * @return
     */
    DiffusionType getDiffusionType();
}

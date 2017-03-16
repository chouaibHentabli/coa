package core.difussionStrategy;

import core.captor.ICaptor;
import core.util.Observer;

import java.util.List;



/**
 * Created by chouaib on 15/03/17.
 */
public interface IDiffusionStrategy {

    /**
     * Prepare all the necesserary for a complete working algo
     *
     */
    void configure(ICaptor captor, List<Observer> clients);

    /**
     * Execute the algo with parameters specified inside the configure method
     *
     */
    void execute();

    /**
     * Identifies this algo
     *
     * @return
     */
    DiffusionType getDiffusionType();
}

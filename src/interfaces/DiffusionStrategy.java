package interfaces;

import difussionStrategy.DiffusionType;

import java.util.List;

/**
 * Created by chouaib on 19/02/17.
 */
public interface DiffusionStrategy {

    /**
     * Prepare all the necesserary for a complete working algo
     */
    void configure(Captor captor, List<Observer> clients);

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
